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
    private EnumSet ticks;
    
    public TFTickHandler() {
        this.ticks = EnumSet.of(TickType.PLAYER);
    }
    
    public void tickStart(final EnumSet type, final Object... tickData) {
        final sk player = (sk)tickData[0];
        final zv world = player.q;
        double rangeToCheck = 32.0;
        if (TwilightForestMod.disablePortalCreation) {
            return;
        }
        if (TwilightForestMod.adminOnlyPortals) {
            if (!MinecraftServer.D().ad().i().contains(player.bS.toLowerCase())) {
                return;
            }
            rangeToCheck = 4.0;
        }
        if (world != null && player != null && (world.t.h == 0 || world.t.h == TwilightForestMod.dimensionID || TwilightForestMod.allowPortalsInOtherDimensions)) {
            final List itemList = world.a((Class)rb.class, player.E.b(rangeToCheck, rangeToCheck, rangeToCheck));
            for (final rb entityItem : itemList) {
                if (entityItem.d().c == we.o.cp && world.a(entityItem.E, ahz.h)) {
                    final Random rand = new Random();
                    for (int k = 0; k < 2; ++k) {
                        final double d = rand.nextGaussian() * 0.02;
                        final double d2 = rand.nextGaussian() * 0.02;
                        final double d3 = rand.nextGaussian() * 0.02;
                        world.a("spell", entityItem.u, entityItem.v + 0.2, entityItem.w, d, d2, d3);
                    }
                    final int dx = kx.c(entityItem.u);
                    final int dy = kx.c(entityItem.v);
                    final int dz = kx.c(entityItem.w);
                    if (!((BlockTFPortal)TFBlocks.portal).tryToCreatePortal(world, dx, dy, dz)) {
                        continue;
                    }
                    player.a((ka)TFAchievementPage.twilightPortal);
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
        return 20;
    }
}
