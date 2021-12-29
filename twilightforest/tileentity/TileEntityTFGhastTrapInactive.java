// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.TwilightForestMod;
import java.util.Iterator;
import java.util.List;
import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFTowerDevice;
import twilightforest.entity.EntityTFMiniGhast;
import java.util.ArrayList;
import java.util.Random;

public class TileEntityTFGhastTrapInactive extends asm
{
    int counter;
    Random rand;
    ArrayList<EntityTFMiniGhast> dyingGhasts;
    
    public TileEntityTFGhastTrapInactive() {
        this.rand = new Random();
        this.dyingGhasts = new ArrayList<EntityTFMiniGhast>();
    }
    
    public boolean canUpdate() {
        return true;
    }
    
    public void h() {
        final asu aabb = asu.a().a((double)this.l, (double)this.m, (double)this.n, (double)(this.l + 1), (double)(this.m + 1), (double)(this.n + 1)).b(10.0, 16.0, 10.0);
        final List<EntityTFMiniGhast> nearbyGhasts = this.k.a((Class)EntityTFMiniGhast.class, aabb);
        for (final EntityTFMiniGhast ghast : nearbyGhasts) {
            if (ghast.aB > 0) {
                this.makeParticlesTo((nm)ghast);
                if (this.dyingGhasts.contains(ghast)) {
                    continue;
                }
                this.dyingGhasts.add(ghast);
            }
        }
        final int chargeLevel = Math.min(3, this.dyingGhasts.size());
        ++this.counter;
        if (this.k.I) {
            if (this.counter % 20 == 0 && nearbyGhasts.size() > 0) {
                final EntityTFMiniGhast highlight = nearbyGhasts.get(this.rand.nextInt(nearbyGhasts.size()));
                this.makeParticlesTo((nm)highlight);
            }
            if (chargeLevel >= 1 && this.counter % 10 == 0) {
                ((BlockTFTowerDevice)TFBlocks.towerDevice).sparkle(this.k, this.l, this.m, this.n, this.k.s);
                this.k.a(this.l + 0.5, this.m + 1.5, this.n + 0.5, "note.harp", 1.0f, 1.0f, false);
            }
            if (chargeLevel >= 2) {
                this.k.a("smoke", this.l + 0.1 + this.rand.nextFloat() * 0.8, this.m + 1.05, this.n + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.0, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05);
                if (this.counter % 10 == 0) {
                    this.k.a(this.l + 0.5, this.m + 1.5, this.n + 0.5, "note.harp", 1.2f, 0.8f, false);
                }
            }
            if (chargeLevel >= 3) {
                this.k.a("largesmoke", this.l + 0.1 + this.rand.nextFloat() * 0.8, this.m + 1.05, this.n + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.05, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05);
                ((BlockTFTowerDevice)TFBlocks.towerDevice).sparkle(this.k, this.l, this.m, this.n, this.k.s);
                if (this.counter % 5 == 0) {
                    this.k.a(this.l + 0.5, this.m + 1.5, this.n + 0.5, "note.harp", 1.5f, 2.0f, false);
                }
            }
        }
    }
    
    private void makeParticlesTo(final nm highlight) {
        final double sx = this.l + 0.5;
        final double sy = this.m + 1.0;
        final double sz = this.n + 0.5;
        final double dx = sx - highlight.u;
        final double dy = sy - highlight.v - highlight.f();
        final double dz = sz - highlight.w;
        for (int i = 0; i < 5; ++i) {
            TwilightForestMod.proxy.spawnParticle("ghasttrap", sx, sy, sz, -dx, -dy, -dz);
        }
    }
    
    public boolean isCharged() {
        return this.dyingGhasts.size() >= 3;
    }
}
