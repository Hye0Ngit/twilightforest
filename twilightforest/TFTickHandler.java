// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.Advancement;
import java.util.Iterator;
import java.util.List;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import java.util.Random;
import twilightforest.network.MissingAdvancementToastPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.network.chat.Component;
import twilightforest.util.PlayerHelper;
import java.util.Objects;
import twilightforest.block.TFBlocks;
import twilightforest.block.TFPortalBlock;
import net.minecraft.tags.Tag;
import twilightforest.data.ItemTagGenerator;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Vec3i;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import twilightforest.world.registration.TFFeature;
import twilightforest.util.BoundingBoxUtils;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.WorldUtil;
import twilightforest.network.StructureProtectionClearPacket;
import twilightforest.network.StructureProtectionPacket;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.player.Player;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.item.BrittleFlaskItem;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFTickHandler
{
    private static final TranslatableComponent PORTAL_UNWORTHY;
    
    @SubscribeEvent
    public static void playerTick(final TickEvent.PlayerTickEvent event) {
        final Player player2;
        final Player eventPlayer = player2 = event.player;
        if (!(player2 instanceof ServerPlayer)) {
            return;
        }
        final ServerPlayer player = (ServerPlayer)player2;
        final Level f_19853_ = player.f_19853_;
        if (f_19853_ instanceof final ServerLevel world) {
            if (!(boolean)TFConfig.COMMON_CONFIG.disablePortalCreation.get() && event.phase == TickEvent.Phase.END && player.f_19797_ % (TFConfig.COMMON_CONFIG.checkPortalDestination.get() ? 100 : 20) == 0) {
                if (TFConfig.COMMON_CONFIG.adminOnlyPortals.get()) {
                    if (world.m_142572_().m_129944_(player.m_36316_()) != 0) {
                        checkForPortalCreation(player, (Level)world, 4.0f);
                    }
                }
                else {
                    checkForPortalCreation(player, (Level)world, 32.0f);
                }
            }
            if (event.phase == TickEvent.Phase.END && player.f_19797_ % 20 == 0) {
                BrittleFlaskItem.ticker();
            }
            if (event.phase == TickEvent.Phase.END && player.f_19797_ % 20 == 0 && TFGenerationSettings.isProgressionEnforced((Level)world) && TFGenerationSettings.usesTwilightChunkGenerator(world) && !player.m_7500_() && !player.m_5833_()) {
                TFGenerationSettings.enforceBiomeProgression((Player)player, (Level)world);
            }
            if (event.phase == TickEvent.Phase.END && player.f_19797_ % 100 == 0 && TFGenerationSettings.isProgressionEnforced((Level)world) && TFGenerationSettings.usesTwilightChunkGenerator(world)) {
                if (player.m_7500_() || player.m_5833_()) {
                    sendAllClearPacket((Level)world, (Player)player);
                }
                else {
                    checkForLockedStructuresSendPacket((Player)player, (Level)world);
                }
            }
        }
    }
    
    private static void sendStructureProtectionPacket(final Level world, final Player player, final BoundingBox sbb) {
        if (player instanceof final ServerPlayer serverPlayer) {
            TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), (Object)new StructureProtectionPacket(sbb));
        }
    }
    
    private static void sendAllClearPacket(final Level world, final Player player) {
        if (player instanceof final ServerPlayer serverPlayer) {
            TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), (Object)new StructureProtectionClearPacket());
        }
    }
    
    private static boolean checkForLockedStructuresSendPacket(final Player player, final Level world) {
        final ChunkGeneratorTwilight chunkGenerator = WorldUtil.getChunkGenerator((LevelAccessor)world);
        return chunkGenerator != null && TFGenerationSettings.locateTFStructureInRange((WorldGenLevel)world, player.m_142538_(), 100).map(structure -> {
            final BoundingBox fullSBB = structure.m_73601_();
            final Vec3i center = BoundingBoxUtils.getCenter(fullSBB);
            final TFFeature nearFeature = TFFeature.getFeatureForRegionPos(center.m_123341_(), center.m_123343_(), (WorldGenLevel)world);
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
    
    private static void checkForPortalCreation(final ServerPlayer player, final Level world, final float rangeToCheck) {
        if (world.m_46472_().m_135782_().equals((Object)new ResourceLocation((String)TFConfig.COMMON_CONFIG.originDimension.get())) || TFGenerationSettings.isTwilightPortalDestination(world) || (boolean)TFConfig.COMMON_CONFIG.allowPortalsInOtherDimensions.get()) {
            final List<ItemEntity> itemList = world.m_45976_((Class)ItemEntity.class, player.m_142469_().m_82400_((double)rangeToCheck));
            ItemEntity qualified = null;
            for (final ItemEntity entityItem : itemList) {
                if (entityItem.m_32055_().m_150922_((Tag)ItemTagGenerator.PORTAL_ACTIVATOR) && ((TFPortalBlock)TFBlocks.TWILIGHT_PORTAL.get()).canFormPortal(world.m_8055_(entityItem.m_142538_())) && Objects.equals(entityItem.m_32057_(), player.m_142081_())) {
                    qualified = entityItem;
                    break;
                }
            }
            if (qualified == null) {
                return;
            }
            if (!player.m_7500_() && !player.m_5833_()) {
                final Advancement requirement = PlayerHelper.getAdvancement((Player)player, TFConfig.getPortalLockingAdvancement());
                if (requirement != null && !PlayerHelper.doesPlayerHaveRequiredAdvancement((Player)player, requirement)) {
                    player.m_5661_((Component)TFTickHandler.PORTAL_UNWORTHY, true);
                    if (!TFPortalBlock.isPlayerNotifiedOfRequirement(player)) {
                        final DisplayInfo info = requirement.m_138320_();
                        TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)((info == null) ? new MissingAdvancementToastPacket((Component)new TranslatableComponent(".ui.advancement.no_title"), new ItemStack((ItemLike)TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE.get())) : new MissingAdvancementToastPacket(info.m_14977_(), info.m_14990_())));
                        TFPortalBlock.playerNotifiedOfRequirement(player);
                    }
                    return;
                }
            }
            final Random rand = new Random();
            for (int i = 0; i < 2; ++i) {
                final double vx = rand.nextGaussian() * 0.02;
                final double vy = rand.nextGaussian() * 0.02;
                final double vz = rand.nextGaussian() * 0.02;
                world.m_7106_((ParticleOptions)ParticleTypes.f_123806_, qualified.m_20185_(), qualified.m_20186_() + 0.2, qualified.m_20189_(), vx, vy, vz);
            }
            if (((TFPortalBlock)TFBlocks.TWILIGHT_PORTAL.get()).tryToCreatePortal(world, qualified.m_142538_(), qualified, (Player)player)) {
                TFAdvancements.MADE_TF_PORTAL.trigger(player);
            }
        }
    }
    
    static {
        PORTAL_UNWORTHY = new TranslatableComponent("twilightforest.ui.portal.unworthy");
    }
}
