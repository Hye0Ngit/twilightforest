// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.world.biome.Biome;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import java.util.Iterator;
import java.util.List;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.util.EnumParticleTypes;
import java.util.Random;
import twilightforest.block.TFBlocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.Vec3i;
import twilightforest.world.ChunkGeneratorTFBase;
import twilightforest.util.StructureBoundingBoxUtils;
import net.minecraft.util.math.MathHelper;
import twilightforest.network.PacketStructureProtectionClear;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import twilightforest.network.PacketStructureProtection;
import twilightforest.network.TFPacketHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.world.TFWorld;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFTickHandler
{
    @SubscribeEvent
    public static void playerTick(final TickEvent.PlayerTickEvent event) {
        final EntityPlayer player = event.player;
        final World world = player.field_70170_p;
        if (!world.field_72995_K && !TFConfig.disablePortalCreation && event.phase == TickEvent.Phase.END && player.field_70173_aa % (TFConfig.checkPortalDestination ? 100 : 20) == 0) {
            if (TFConfig.adminOnlyPortals) {
                if (FMLCommonHandler.instance().getMinecraftServerInstance().func_184103_al().func_152603_m().func_187452_a(player.func_146103_bH()) != 0) {
                    checkForPortalCreation(player, world, 4.0f);
                }
            }
            else {
                checkForPortalCreation(player, world, 32.0f);
            }
        }
        if (!world.field_72995_K && event.phase == TickEvent.Phase.END && player.field_70173_aa % 20 == 0 && TFWorld.isProgressionEnforced(world) && TFWorld.isTwilightForest(world) && !player.func_184812_l_() && !player.func_175149_v()) {
            checkBiomeForProgression(player, world);
        }
        if (!world.field_72995_K && event.phase == TickEvent.Phase.END && player.field_70173_aa % 100 == 0 && TFWorld.isProgressionEnforced(world) && TFWorld.isTwilightForest(world)) {
            if (player.func_184812_l_() || player.func_175149_v()) {
                sendAllClearPacket(world, player);
            }
            else {
                checkForLockedStructuresSendPacket(player, world);
            }
        }
    }
    
    private static void sendStructureProtectionPacket(final World world, final EntityPlayer player, final StructureBoundingBox sbb) {
        if (player instanceof EntityPlayerMP) {
            TFPacketHandler.CHANNEL.sendTo((IMessage)new PacketStructureProtection(sbb), (EntityPlayerMP)player);
        }
    }
    
    private static void sendAllClearPacket(final World world, final EntityPlayer player) {
        if (player instanceof EntityPlayerMP) {
            TFPacketHandler.CHANNEL.sendTo((IMessage)new PacketStructureProtectionClear(), (EntityPlayerMP)player);
        }
    }
    
    private static boolean checkForLockedStructuresSendPacket(final EntityPlayer player, final World world) {
        final ChunkGeneratorTFBase chunkGenerator = TFWorld.getChunkGenerator(world);
        if (chunkGenerator == null) {
            return false;
        }
        final int px = MathHelper.func_76128_c(player.field_70165_t);
        final int pz = MathHelper.func_76128_c(player.field_70161_v);
        final StructureBoundingBox fullSBB = chunkGenerator.getFullSBBNear(px, pz, 100);
        if (fullSBB == null) {
            return false;
        }
        final Vec3i center = StructureBoundingBoxUtils.getCenter(fullSBB);
        final TFFeature nearFeature = TFFeature.getFeatureForRegionPos(center.func_177958_n(), center.func_177952_p(), world);
        if (!nearFeature.hasProtectionAura || nearFeature.doesPlayerHaveRequiredAdvancements(player)) {
            sendAllClearPacket(world, player);
            return false;
        }
        sendStructureProtectionPacket(world, player, fullSBB);
        return true;
    }
    
    private static void checkForPortalCreation(final EntityPlayer player, final World world, final float rangeToCheck) {
        if (world.field_73011_w.getDimension() == TFConfig.originDimension || world.field_73011_w.getDimension() == TFConfig.dimension.dimensionID || TFConfig.allowPortalsInOtherDimensions) {
            final List<EntityItem> itemList = world.func_72872_a((Class)EntityItem.class, player.func_174813_aQ().func_186662_g((double)rangeToCheck));
            for (final EntityItem entityItem : itemList) {
                if (TFConfig.portalIngredient.apply(entityItem.func_92059_d())) {
                    final BlockPos pos = entityItem.func_180425_c();
                    final IBlockState state = world.func_180495_p(pos);
                    if (!TFBlocks.twilight_portal.canFormPortal(state)) {
                        continue;
                    }
                    final Random rand = new Random();
                    for (int i = 0; i < 2; ++i) {
                        final double vx = rand.nextGaussian() * 0.02;
                        final double vy = rand.nextGaussian() * 0.02;
                        final double vz = rand.nextGaussian() * 0.02;
                        world.func_175688_a(EnumParticleTypes.SPELL, entityItem.field_70165_t, entityItem.field_70163_u + 0.2, entityItem.field_70161_v, vx, vy, vz, new int[0]);
                    }
                    if (TFBlocks.twilight_portal.tryToCreatePortal(world, pos, entityItem, player)) {
                        TFAdvancements.MADE_TF_PORTAL.trigger((EntityPlayerMP)player);
                        return;
                    }
                    continue;
                }
            }
        }
    }
    
    private static void checkBiomeForProgression(final EntityPlayer player, final World world) {
        final Biome currentBiome = world.func_180494_b(new BlockPos((Entity)player));
        if (currentBiome instanceof TFBiomeBase) {
            final TFBiomeBase tfBiome = (TFBiomeBase)currentBiome;
            if (!tfBiome.doesPlayerHaveRequiredAdvancements(player)) {
                tfBiome.enforceProgression(player, world);
            }
        }
    }
}
