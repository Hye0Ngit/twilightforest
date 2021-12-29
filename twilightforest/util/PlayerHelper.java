// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.advancements.AdvancementProgress;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.multiplayer.ClientAdvancements;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import java.util.Iterator;
import net.minecraft.advancements.Advancement;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class PlayerHelper
{
    @Deprecated
    public static void grantAdvancement(final ServerPlayer player, final ResourceLocation id) {
        final PlayerAdvancements advancements = player.m_8960_();
        final Advancement advancement = player.m_20194_().m_129889_().m_136041_(id);
        if (advancement != null) {
            for (final String criterion : advancements.m_135996_(advancement).m_8219_()) {
                advancements.m_135988_(advancement, criterion);
            }
        }
    }
    
    @Deprecated
    public static void grantCriterion(final ServerPlayer player, final ResourceLocation id, final String criterion) {
        final PlayerAdvancements advancements = player.m_8960_();
        final Advancement advancement = player.m_20194_().m_129889_().m_136041_(id);
        if (advancement != null) {
            advancements.m_135988_(advancement, criterion);
        }
    }
    
    @Nullable
    public static Advancement getAdvancement(final Player player, final ResourceLocation advancementLocation) {
        if (player.f_19853_.m_5776_() && player instanceof LocalPlayer) {
            final LocalPlayer localPlayer = (LocalPlayer)player;
            final ClientAdvancements manager = localPlayer.f_108617_.m_105145_();
            return manager.m_104396_().m_139337_(advancementLocation);
        }
        if (player instanceof final ServerPlayer serverPlayer) {
            final ServerLevel world = serverPlayer.m_9236_();
            return world.m_142572_().m_129889_().m_136041_(advancementLocation);
        }
        return null;
    }
    
    public static boolean doesPlayerHaveRequiredAdvancement(final Player player, final Advancement advancement) {
        if (!player.f_19853_.m_5776_()) {
            return player instanceof ServerPlayer && advancement != null && ((ServerPlayer)player).m_8960_().m_135996_(advancement).m_8193_();
        }
        if (!(player instanceof LocalPlayer)) {
            return false;
        }
        final ClientAdvancements manager = ((LocalPlayer)player).f_108617_.m_105145_();
        if (advancement == null) {
            return false;
        }
        final AdvancementProgress progress = manager.f_104390_.get(advancement);
        return progress != null && progress.m_8193_();
    }
    
    public static boolean doesPlayerHaveRequiredAdvancement(final Player player, final ResourceLocation advancementLocation) {
        if (player.f_19853_.m_5776_()) {
            if (!(player instanceof LocalPlayer)) {
                return false;
            }
            final ClientAdvancements manager = ((LocalPlayer)player).f_108617_.m_105145_();
            final Advancement adv = manager.m_104396_().m_139337_(advancementLocation);
            if (adv == null) {
                return false;
            }
            final AdvancementProgress progress = manager.f_104390_.get(adv);
            return progress != null && progress.m_8193_();
        }
        else {
            if (player instanceof final ServerPlayer serverPlayer) {
                final ServerLevel world = serverPlayer.m_9236_();
                final Advancement adv = world.m_142572_().m_129889_().m_136041_(advancementLocation);
                return adv != null && ((ServerPlayer)player).m_8960_().m_135996_(adv).m_8193_();
            }
            return false;
        }
    }
    
    public static boolean doesPlayerHaveRequiredAdvancements(final Player player, final ResourceLocation... requiredAdvancements) {
        final int length = requiredAdvancements.length;
        final int n = 0;
        if (n >= length) {
            return true;
        }
        final ResourceLocation advancementLocation = requiredAdvancements[n];
        if (player.f_19853_.m_5776_()) {
            if (!(player instanceof LocalPlayer)) {
                return false;
            }
            final ClientAdvancements manager = ((LocalPlayer)player).f_108617_.m_105145_();
            final Advancement adv = manager.m_104396_().m_139337_(advancementLocation);
            if (adv == null) {
                return false;
            }
            final AdvancementProgress progress = manager.f_104390_.get(adv);
            return progress != null && progress.m_8193_();
        }
        else {
            if (player instanceof final ServerPlayer serverPlayer) {
                final ServerLevel world = serverPlayer.m_9236_();
                final Advancement adv = world.m_142572_().m_129889_().m_136041_(advancementLocation);
                return adv != null && ((ServerPlayer)player).m_8960_().m_135996_(adv).m_8193_();
            }
            return false;
        }
    }
}
