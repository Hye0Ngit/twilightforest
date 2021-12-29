// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import java.util.Iterator;
import java.util.List;
import twilightforest.block.TFBlocks;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFUrGhast;
import twilightforest.TwilightForestMod;
import java.util.Random;

public class TileEntityTFGhastTrapActive extends asm
{
    public int counter;
    public Random rand;
    
    public TileEntityTFGhastTrapActive() {
        this.counter = 0;
        this.rand = new Random();
    }
    
    public boolean canUpdate() {
        return true;
    }
    
    public void h() {
        ++this.counter;
        if (this.k.I) {
            if (this.counter > 100 && this.counter % 4 == 0) {
                TwilightForestMod.proxy.spawnParticle("hugesmoke", this.l + 0.5, this.m + 0.95, this.n + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
            }
            else if (this.counter < 100) {
                final double dx = Math.cos(this.counter / 10.0) * 2.5;
                final double dy = 20.0;
                final double dz = Math.sin(this.counter / 10.0) * 2.5;
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.l + 0.5, this.m + 1.0, this.n + 0.5, dx, dy, dz);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.l + 0.5, this.m + 1.0, this.n + 0.5, -dx, dy, -dz);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.l + 0.5, this.m + 1.0, this.n + 0.5, -dx, dy / 2.0, dz);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.l + 0.5, this.m + 1.0, this.n + 0.5, dx, dy / 2.0, -dz);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.l + 0.5, this.m + 1.0, this.n + 0.5, dx / 2.0, dy / 4.0, dz / 2.0);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.l + 0.5, this.m + 1.0, this.n + 0.5, -dx / 2.0, dy / 4.0, -dz / 2.0);
            }
            if (this.counter < 30) {
                this.k.a(this.l + 0.5, this.m + 1.5, this.n + 0.5, "TwilightForest:mob.urghast.trapwarmup", 1.0f, 4.0f, false);
            }
            else if (this.counter < 80) {
                this.k.a(this.l + 0.5, this.m + 1.5, this.n + 0.5, "TwilightForest:mob.urghast.trapon", 1.0f, 4.0f, false);
            }
            else {
                this.k.a(this.l + 0.5, this.m + 1.5, this.n + 0.5, "TwilightForest:mob.urghast.trapspindown", 1.0f, 4.0f, false);
            }
        }
        if (!this.k.I) {
            final asu aabb = asu.a().a((double)this.l, this.m + 16.0, (double)this.n, (double)(this.l + 1), (double)(this.m + 16 + 1), (double)(this.n + 1)).b(6.0, 16.0, 6.0);
            final List<ti> nearbyGhasts = this.k.a((Class)ti.class, aabb);
            for (final ti ghast : nearbyGhasts) {
                if (ghast instanceof EntityTFUrGhast) {
                    ((EntityTFUrGhast)ghast).stopTantrum();
                    ghast.x = (ghast.u - this.l - 0.5) * -0.1;
                    ghast.y = (ghast.v - this.m - 2.5) * -0.1;
                    ghast.z = (ghast.w - this.n - 0.5) * -0.1;
                    if (this.rand.nextInt(10) == 0) {
                        ghast.a(na.j, 3.0f);
                    }
                }
                else {
                    ghast.x = (ghast.u - this.l - 0.5) * -0.1;
                    ghast.y = (ghast.v - this.m - 1.5) * -0.1;
                    ghast.z = (ghast.w - this.n - 0.5) * -0.1;
                    if (this.rand.nextInt(10) == 0) {
                        ghast.a(na.j, 10.0f);
                    }
                }
                if (ghast instanceof EntityTFTowerGhast) {
                    ((EntityTFTowerGhast)ghast).setInTrap();
                }
            }
            if (this.counter >= 120) {
                this.k.f(this.l, this.m, this.n, TFBlocks.towerDevice.cF, 10, 3);
            }
        }
    }
}
