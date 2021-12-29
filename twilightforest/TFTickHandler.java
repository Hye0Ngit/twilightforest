// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.block.BlockState;
import java.util.Iterator;
import java.util.List;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import java.util.Random;
import twilightforest.block.TFBlocks;
import twilightforest.block.TFPortalBlock;
import net.minecraft.util.math.BlockPos;
import twilightforest.data.ItemTagGenerator;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3i;
import twilightforest.world.ChunkGeneratorTwilightBase;
import twilightforest.util.StructureBoundingBoxUtils;
import net.minecraft.world.ISeedReader;
import twilightforest.network.StructureProtectionClearPacket;
import twilightforest.network.StructureProtectionPacket;
import net.minecraftforge.fml.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.entity.player.PlayerEntity;
import twilightforest.world.TFGenerationSettings;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFTickHandler
{
    @SubscribeEvent
    public static void playerTick(final TickEvent.PlayerTickEvent event) {
        final PlayerEntity player = event.player;
        if (!(player.field_70170_p instanceof ServerWorld)) {
            return;
        }
        final ServerWorld world = (ServerWorld)player.field_70170_p;
        if (!world.field_72995_K && !(boolean)TFConfig.COMMON_CONFIG.disablePortalCreation.get() && event.phase == TickEvent.Phase.END && player.field_70173_aa % (TFConfig.COMMON_CONFIG.checkPortalDestination.get() ? 100 : 20) == 0) {
            if (TFConfig.COMMON_CONFIG.adminOnlyPortals.get()) {
                if (world.func_73046_m().func_211833_a(player.func_146103_bH()) != 0) {
                    checkForPortalCreation(player, (World)world, 4.0f);
                }
            }
            else {
                checkForPortalCreation(player, (World)world, 32.0f);
            }
        }
        if (!world.field_72995_K && event.phase == TickEvent.Phase.END && player.field_70173_aa % 20 == 0 && TFGenerationSettings.isProgressionEnforced((World)world) && TFGenerationSettings.isTwilightChunk(world) && !player.func_184812_l_() && !player.func_175149_v()) {
            TFGenerationSettings.enforceBiomeProgression(player, (World)world);
        }
        if (!world.field_72995_K && event.phase == TickEvent.Phase.END && player.field_70173_aa % 100 == 0 && TFGenerationSettings.isProgressionEnforced((World)world) && TFGenerationSettings.isTwilightChunk(world)) {
            if (player.func_184812_l_() || player.func_175149_v()) {
                sendAllClearPacket((World)world, player);
            }
            else {
                checkForLockedStructuresSendPacket(player, (World)world);
            }
        }
    }
    
    private static void sendStructureProtectionPacket(final World world, final PlayerEntity player, final MutableBoundingBox sbb) {
        if (player instanceof ServerPlayerEntity) {
            TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)player), (Object)new StructureProtectionPacket(sbb));
        }
    }
    
    private static void sendAllClearPacket(final World world, final PlayerEntity player) {
        if (player instanceof ServerPlayerEntity) {
            TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)player), (Object)new StructureProtectionClearPacket());
        }
    }
    
    private static boolean checkForLockedStructuresSendPacket(final PlayerEntity player, final World world) {
        final ChunkGeneratorTwilightBase chunkGenerator = TFGenerationSettings.getChunkGenerator(world);
        return chunkGenerator != null && TFGenerationSettings.locateTFStructureInRange((ISeedReader)world, player.func_233580_cy_(), 100).map(structure -> {
            final MutableBoundingBox fullSBB = structure.func_75071_a();
            final Vector3i center = StructureBoundingBoxUtils.getCenter(fullSBB);
            final TFFeature nearFeature = TFFeature.getFeatureForRegionPos(center.func_177958_n(), center.func_177952_p(), (ISeedReader)world);
            if (!nearFeature.hasProtectionAura || nearFeature.doesPlayerHaveRequiredAdvancements(player)) {
                sendAllClearPacket(world, player);
                return false;
            }
            else {
                sendStructureProtectionPacket(world, player, fullSBB);
                return true;
            }
        }).orElse(false);
    }
    
    private static void checkForPortalCreation(final PlayerEntity player, final World world, final float rangeToCheck) {
        if (world.func_234923_W_().func_240901_a_().equals((Object)new ResourceLocation((String)TFConfig.COMMON_CONFIG.originDimension.get())) || world.func_234923_W_().func_240901_a_().toString().equals(TFConfig.COMMON_CONFIG.DIMENSION.twilightForestID.get()) || (boolean)TFConfig.COMMON_CONFIG.allowPortalsInOtherDimensions.get()) {
            final List<ItemEntity> itemList = world.func_217357_a((Class)ItemEntity.class, player.func_174813_aQ().func_186662_g((double)rangeToCheck));
            for (final ItemEntity entityItem : itemList) {
                if (ItemTagGenerator.PORTAL_ACTIVATOR.func_230235_a_((Object)entityItem.func_92059_d().func_77973_b())) {
                    final BlockPos pos = new BlockPos(entityItem.func_213303_ch().func_178786_a(0.0, -0.1, 0.0));
                    final BlockState state = world.func_180495_p(pos);
                    if (!((TFPortalBlock)TFBlocks.twilight_portal.get()).canFormPortal(state)) {
                        continue;
                    }
                    final Random rand = new Random();
                    for (int i = 0; i < 2; ++i) {
                        final double vx = rand.nextGaussian() * 0.02;
                        final double vy = rand.nextGaussian() * 0.02;
                        final double vz = rand.nextGaussian() * 0.02;
                        world.func_195594_a((IParticleData)ParticleTypes.field_197620_m, entityItem.func_226277_ct_(), entityItem.func_226278_cu_() + 0.2, entityItem.func_226281_cx_(), vx, vy, vz);
                    }
                    if (((TFPortalBlock)TFBlocks.twilight_portal.get()).tryToCreatePortal(world, pos, entityItem, player)) {
                        TFAdvancements.MADE_TF_PORTAL.trigger((ServerPlayerEntity)player);
                        return;
                    }
                    continue;
                }
            }
        }
    }
}
