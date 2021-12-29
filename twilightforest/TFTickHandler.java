// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.world.biome.BiomeGenBase;
import twilightforest.biomes.TFBiomeBase;
import java.util.Iterator;
import java.util.List;
import net.minecraft.stats.StatBase;
import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFPortal;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import twilightforest.world.ChunkProviderTwilightForest;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.world.WorldProviderTwilightForest;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.item.Item;

public class TFTickHandler
{
    public Item portalItem;
    
    public TFTickHandler() {
        this.portalItem = null;
    }
    
    @SubscribeEvent
    public void playerTick(final TickEvent.PlayerTickEvent event) {
        final EntityPlayer player = event.player;
        final World world = player.field_70170_p;
        if (!TwilightForestMod.disablePortalCreation && event.phase == TickEvent.Phase.END && !world.field_72995_K && world.func_72820_D() % 20L == 0L) {
            if (TwilightForestMod.adminOnlyPortals) {
                try {
                    if (MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(player.func_146103_bH())) {
                        this.checkForPortalCreation(player, world, 4.0f);
                    }
                }
                catch (NoSuchMethodError ex) {
                    FMLLog.warning("[TwilightForest] Could not determine op status for adminOnlyPortals option, ignoring option.", new Object[0]);
                    TwilightForestMod.adminOnlyPortals = false;
                }
            }
            else {
                this.checkForPortalCreation(player, world, 32.0f);
            }
        }
        if (!world.field_72995_K && event.phase == TickEvent.Phase.END && world.func_72820_D() % 20L == 0L && world.func_82736_K().func_82766_b("tfEnforcedProgression") && world.field_73011_w instanceof WorldProviderTwilightForest && !player.field_71075_bZ.field_75098_d) {
            this.checkBiomeForProgression(player, world);
        }
        if (!world.field_72995_K && event.phase == TickEvent.Phase.END && world.func_72820_D() % 100L == 0L && world.func_82736_K().func_82766_b("tfEnforcedProgression") && world.field_73011_w instanceof WorldProviderTwilightForest) {
            if (!player.field_71075_bZ.field_75098_d) {
                this.checkForLockedStructuresSendPacket(player, world);
            }
            else {
                this.sendAllClearPacket(world, player);
            }
        }
    }
    
    private void sendStructureProtectionPacket(final World world, final EntityPlayer player, final StructureBoundingBox sbb) {
        final FMLProxyPacket message = TFGenericPacketHandler.makeStructureProtectionPacket(sbb);
        if (player instanceof EntityPlayerMP) {
            TwilightForestMod.genericChannel.sendTo(message, (EntityPlayerMP)player);
        }
    }
    
    private void sendAllClearPacket(final World world, final EntityPlayer player) {
        final FMLProxyPacket message = TFGenericPacketHandler.makeStructureProtectionClearPacket();
        if (player instanceof EntityPlayerMP) {
            TwilightForestMod.genericChannel.sendTo(message, (EntityPlayerMP)player);
        }
    }
    
    private boolean checkForLockedStructuresSendPacket(final EntityPlayer player, final World world) {
        final ChunkProviderTwilightForest chunkProvider = ((WorldProviderTwilightForest)world.field_73011_w).getChunkProvider();
        final int px = MathHelper.func_76128_c(player.field_70165_t);
        final int py = MathHelper.func_76128_c(player.field_70163_u);
        final int pz = MathHelper.func_76128_c(player.field_70161_v);
        if (chunkProvider == null || !chunkProvider.isBlockNearFullStructure(px, pz, 100)) {
            return false;
        }
        final StructureBoundingBox fullSBB = chunkProvider.getFullSBBNear(px, pz, 100);
        final TFFeature nearFeature = TFFeature.getFeatureForRegion(fullSBB.func_78881_e() >> 4, fullSBB.func_78891_g() >> 4, world);
        if (!nearFeature.hasProtectionAura || nearFeature.doesPlayerHaveRequiredAchievement(player)) {
            this.sendAllClearPacket(world, player);
            return false;
        }
        this.sendStructureProtectionPacket(world, player, fullSBB);
        return true;
    }
    
    @SubscribeEvent
    public void tickStart(final ItemTossEvent event) {
        System.out.println("ItemTossEvent Tick");
    }
    
    private void checkForPortalCreation(final EntityPlayer player, final World world, final float rangeToCheck) {
        if (world != null && player != null && (world.field_73011_w.field_76574_g == 0 || world.field_73011_w.field_76574_g == TwilightForestMod.dimensionID || TwilightForestMod.allowPortalsInOtherDimensions)) {
            final List<EntityItem> itemList = world.func_72872_a((Class)EntityItem.class, player.field_70121_D.func_72314_b((double)rangeToCheck, (double)rangeToCheck, (double)rangeToCheck));
            if (this.portalItem == null) {}
            for (final EntityItem entityItem : itemList) {
                if (entityItem.func_92059_d().func_77973_b() == this.portalItem && world.func_72875_a(entityItem.field_70121_D, Material.field_151586_h)) {
                    final Random rand = new Random();
                    for (int k = 0; k < 2; ++k) {
                        final double d = rand.nextGaussian() * 0.02;
                        final double d2 = rand.nextGaussian() * 0.02;
                        final double d3 = rand.nextGaussian() * 0.02;
                        world.func_72869_a("spell", entityItem.field_70165_t, entityItem.field_70163_u + 0.2, entityItem.field_70161_v, d, d2, d3);
                    }
                    final int dx = MathHelper.func_76128_c(entityItem.field_70165_t);
                    final int dy = MathHelper.func_76128_c(entityItem.field_70163_u);
                    final int dz = MathHelper.func_76128_c(entityItem.field_70161_v);
                    if (!((BlockTFPortal)TFBlocks.portal).tryToCreatePortal(world, dx, dy, dz)) {
                        continue;
                    }
                    player.func_71029_a((StatBase)TFAchievementPage.twilightPortal);
                }
            }
        }
    }
    
    private void checkBiomeForProgression(final EntityPlayer player, final World world) {
        final BiomeGenBase currentBiome = world.func_72807_a(MathHelper.func_76128_c(player.field_70165_t), MathHelper.func_76128_c(player.field_70161_v));
        if (currentBiome instanceof TFBiomeBase) {
            final TFBiomeBase tfBiome = (TFBiomeBase)currentBiome;
            final boolean dangerousBiome = !tfBiome.doesPlayerHaveRequiredAchievement(player);
            if (dangerousBiome) {
                tfBiome.enforceProgession(player, world);
            }
        }
    }
}
