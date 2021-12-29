// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;
import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFPortal;
import java.util.Random;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import cpw.mods.fml.common.IScheduledTickHandler;

public class TFTickHandler implements IScheduledTickHandler
{
    private EnumSet<TickType> ticks;
    
    public TFTickHandler() {
        this.ticks = EnumSet.of(TickType.PLAYER);
    }
    
    public void tickStart(final EnumSet<TickType> type, final Object... tickData) {
        final ue player = (ue)tickData[0];
        final abv world = player.q;
        double rangeToCheck = 32.0;
        if (TwilightForestMod.disablePortalCreation) {
            return;
        }
        if (TwilightForestMod.adminOnlyPortals) {
            if (!MinecraftServer.F().af().i().contains(player.bu.toLowerCase())) {
                return;
            }
            rangeToCheck = 4.0;
        }
        if (world != null && player != null && (world.t.i == 0 || world.t.i == TwilightForestMod.dimensionID || TwilightForestMod.allowPortalsInOtherDimensions)) {
            final List<sr> itemList = world.a((Class)sr.class, player.E.b(rangeToCheck, rangeToCheck, rangeToCheck));
            for (final sr entityItem : itemList) {
                if (entityItem.d().d == yb.p.cv && world.a(entityItem.E, ajz.h)) {
                    final Random rand = new Random();
                    for (int k = 0; k < 2; ++k) {
                        final double d = rand.nextGaussian() * 0.02;
                        final double d2 = rand.nextGaussian() * 0.02;
                        final double d3 = rand.nextGaussian() * 0.02;
                        world.a("spell", entityItem.u, entityItem.v + 0.2, entityItem.w, d, d2, d3);
                    }
                    final int dx = lr.c(entityItem.u);
                    final int dy = lr.c(entityItem.v);
                    final int dz = lr.c(entityItem.w);
                    if (!((BlockTFPortal)TFBlocks.portal).tryToCreatePortal(world, dx, dy, dz)) {
                        continue;
                    }
                    player.a((kt)TFAchievementPage.twilightPortal);
                }
            }
        }
    }
    
    public void tickEnd(final EnumSet<TickType> type, final Object... tickData) {
    }
    
    public EnumSet<TickType> ticks() {
        return this.ticks;
    }
    
    public String getLabel() {
        return "Twilight Forest tick";
    }
    
    public int nextTickSpacing() {
        return 20;
    }
}
