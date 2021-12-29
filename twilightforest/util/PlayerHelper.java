// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.client.multiplayer.ClientAdvancementManager;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import java.util.Iterator;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.ServerPlayerEntity;

public class PlayerHelper
{
    @Deprecated
    public static void grantAdvancement(final ServerPlayerEntity player, final ResourceLocation id) {
        final PlayerAdvancements advancements = player.func_192039_O();
        final Advancement advancement = player.func_184102_h().func_191949_aK().func_192778_a(id);
        if (advancement != null) {
            for (final String criterion : advancements.func_192747_a(advancement).func_192107_d()) {
                advancements.func_192750_a(advancement, criterion);
            }
        }
    }
    
    @Deprecated
    public static void grantCriterion(final ServerPlayerEntity player, final ResourceLocation id, final String criterion) {
        final PlayerAdvancements advancements = player.func_192039_O();
        final Advancement advancement = player.func_184102_h().func_191949_aK().func_192778_a(id);
        if (advancement != null) {
            advancements.func_192750_a(advancement, criterion);
        }
    }
    
    public static boolean doesPlayerHaveRequiredAdvancements(final PlayerEntity player, final ResourceLocation... requiredAdvancements) {
        final int length = requiredAdvancements.length;
        final int n = 0;
        if (n >= length) {
            return true;
        }
        final ResourceLocation advancementLocation = requiredAdvancements[n];
        if (player.field_70170_p.func_201670_d()) {
            if (!(player instanceof ClientPlayerEntity)) {
                return false;
            }
            final ClientAdvancementManager manager = ((ClientPlayerEntity)player).field_71174_a.func_191982_f();
            final Advancement adv = manager.func_194229_a().func_192084_a(advancementLocation);
            if (adv == null) {
                return false;
            }
            final AdvancementProgress progress = manager.field_192803_d.get(adv);
            return progress != null && progress.func_192105_a();
        }
        else {
            if (player instanceof ServerPlayerEntity) {
                final ServerWorld world = ((ServerPlayerEntity)player).func_71121_q();
                final Advancement adv = world.func_73046_m().func_191949_aK().func_192778_a(advancementLocation);
                return adv != null && ((ServerPlayerEntity)player).func_192039_O().func_192747_a(adv).func_192105_a();
            }
            return false;
        }
    }
}
