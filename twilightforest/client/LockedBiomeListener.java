// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.gui.components.toasts.Toast;
import twilightforest.item.TFItems;
import twilightforest.block.TrophyBlock;
import net.minecraft.world.item.ItemStack;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.ItemLike;
import net.minecraft.resources.ResourceKey;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import twilightforest.TFConfig;
import net.minecraft.world.level.Level;
import twilightforest.world.registration.TFGenerationSettings;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = { Dist.CLIENT }, bus = Mod.EventBusSubscriber.Bus.FORGE, modid = "twilightforest")
public class LockedBiomeListener
{
    private static boolean shownToast;
    private static int timeUntilToast;
    
    @SubscribeEvent
    public static void clientTick(final TickEvent.ClientTickEvent event) {
        final Player player = (Player)Minecraft.m_91087_().f_91074_;
        if (player != null) {
            final Level f_19853_ = player.f_19853_;
            if (f_19853_ instanceof final ClientLevel world) {
                if (world.f_46443_ && event.phase == TickEvent.Phase.END && player.f_19797_ % 5 == 0 && TFGenerationSettings.isProgressionEnforced((Level)world) && !player.m_7500_() && !player.m_5833_() && !(boolean)TFConfig.CLIENT_CONFIG.disableLockedBiomeToasts.get()) {
                    if (!TFGenerationSettings.isBiomeSafeFor(world.m_46857_(player.m_142538_()), (Entity)player)) {
                        --LockedBiomeListener.timeUntilToast;
                        ItemStack item;
                        if (world.m_46857_(player.m_142538_()).equals(world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.DARK_FOREST))) {
                            item = new ItemStack((ItemLike)TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE.get());
                        }
                        else if (world.m_46857_(player.m_142538_()).equals(world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.DARK_FOREST_CENTER))) {
                            item = new ItemStack((ItemLike)((TrophyBlock)TFBlocks.KNIGHT_PHANTOM_TROPHY.get()).m_5456_());
                        }
                        else if (world.m_46857_(player.m_142538_()).equals(world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.SNOWY_FOREST))) {
                            item = new ItemStack((ItemLike)TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE.get());
                        }
                        else if (world.m_46857_(player.m_142538_()).equals(world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.GLACIER))) {
                            item = new ItemStack((ItemLike)TFItems.ALPHA_YETI_FUR.get());
                        }
                        else if (world.m_46857_(player.m_142538_()).equals(world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.SWAMP))) {
                            item = new ItemStack((ItemLike)TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE.get());
                        }
                        else if (world.m_46857_(player.m_142538_()).equals(world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.FIRE_SWAMP))) {
                            item = new ItemStack((ItemLike)TFItems.MEEF_STROGANOFF.get());
                        }
                        else if (world.m_46857_(player.m_142538_()).equals(world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.HIGHLANDS))) {
                            item = new ItemStack((ItemLike)TFBlocks.UBEROUS_SOIL.get());
                        }
                        else if (world.m_46857_(player.m_142538_()).equals(world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.THORNLANDS))) {
                            item = new ItemStack((ItemLike)TFItems.LAMP_OF_CINDERS.get());
                        }
                        else if (world.m_46857_(player.m_142538_()).equals(world.m_5962_().m_175515_(Registry.f_122885_).m_6246_((ResourceKey)BiomeKeys.FINAL_PLATEAU))) {
                            item = new ItemStack((ItemLike)TFItems.LAMP_OF_CINDERS.get());
                        }
                        else {
                            item = new ItemStack((ItemLike)TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE.get());
                        }
                        if (!LockedBiomeListener.shownToast && LockedBiomeListener.timeUntilToast <= 0) {
                            Minecraft.m_91087_().m_91300_().m_94922_((Toast)new LockedBiomeToast(item));
                            LockedBiomeListener.shownToast = true;
                        }
                    }
                    else if (LockedBiomeListener.shownToast) {
                        LockedBiomeListener.timeUntilToast = 60;
                        LockedBiomeListener.shownToast = false;
                    }
                }
            }
        }
    }
    
    static {
        LockedBiomeListener.shownToast = false;
        LockedBiomeListener.timeUntilToast = 60;
    }
}
