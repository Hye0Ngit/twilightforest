// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Iterator;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayerMP;

public class PlayerHelper
{
    @Deprecated
    public static void grantAdvancement(final EntityPlayerMP player, final ResourceLocation id) {
        final PlayerAdvancements advancements = player.func_192039_O();
        final Advancement advancement = player.func_71121_q().func_191952_z().func_192778_a(id);
        if (advancement != null) {
            for (final String criterion : advancements.func_192747_a(advancement).func_192107_d()) {
                advancements.func_192750_a(advancement, criterion);
            }
        }
    }
    
    @Deprecated
    public static void grantCriterion(final EntityPlayerMP player, final ResourceLocation id, final String criterion) {
        final PlayerAdvancements advancements = player.func_192039_O();
        final Advancement advancement = player.func_71121_q().func_191952_z().func_192778_a(id);
        if (advancement != null) {
            advancements.func_192750_a(advancement, criterion);
        }
    }
    
    public static boolean doesPlayerHaveRequiredAdvancements(final EntityPlayer player, final ResourceLocation... requiredAdvancements) {
        for (final ResourceLocation advancementLocation : requiredAdvancements) {
            if (!TwilightForestMod.proxy.doesPlayerHaveAdvancement(player, advancementLocation)) {
                return false;
            }
        }
        return true;
    }
}
