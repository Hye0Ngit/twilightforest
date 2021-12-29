// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;
import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFPortal;
import java.util.Random;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import cpw.mods.fml.common.IScheduledTickHandler;

public class TFTickHandler implements IScheduledTickHandler
{
    private EnumSet ticks;
    
    public TFTickHandler() {
        this.ticks = EnumSet.of(TickType.PLAYER);
    }
    
    public void tickStart(final EnumSet type, final Object... tickData) {
        final qx player = (qx)tickData[0];
        final yc world = player.p;
        if (world != null && player != null && (world.u.h == 0 || world.u.h == TwilightForestMod.dimensionID || TwilightForestMod.allowPortalsInOtherDimensions)) {
            final List itemList = world.a((Class)px.class, player.D.b(32.0, 32.0, 32.0));
            for (final px entityItem : itemList) {
                if (entityItem.d().c == up.n.cj && world.a(entityItem.D, agi.h)) {
                    final Random rand = new Random();
                    for (int k = 0; k < 2; ++k) {
                        final double d = rand.nextGaussian() * 0.02;
                        final double d2 = rand.nextGaussian() * 0.02;
                        final double d3 = rand.nextGaussian() * 0.02;
                        world.a("spell", entityItem.t, entityItem.u + 0.2, entityItem.v, d, d2, d3);
                    }
                    final int dx = ke.c(entityItem.t);
                    final int dy = ke.c(entityItem.u);
                    final int dz = ke.c(entityItem.v);
                    if (!((BlockTFPortal)TFBlocks.portal).tryToCreatePortal(world, dx, dy, dz)) {
                        continue;
                    }
                    player.a((jl)TFAchievementPage.twilightPortal);
                }
            }
        }
    }
    
    public void tickEnd(final EnumSet type, final Object... tickData) {
    }
    
    public EnumSet ticks() {
        return this.ticks;
    }
    
    public String getLabel() {
        return "Twilight Forest tick";
    }
    
    public int nextTickSpacing() {
        return 10;
    }
}
