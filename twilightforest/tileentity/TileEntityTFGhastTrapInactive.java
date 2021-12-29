// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import java.util.Iterator;
import java.util.List;
import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFTowerDevice;
import twilightforest.entity.EntityTFMiniGhast;
import java.util.ArrayList;
import java.util.Random;

public class TileEntityTFGhastTrapInactive extends aqj
{
    int counter;
    Random rand;
    ArrayList dyingGhasts;
    
    public TileEntityTFGhastTrapInactive() {
        this.rand = new Random();
        this.dyingGhasts = new ArrayList();
    }
    
    public boolean canUpdate() {
        return true;
    }
    
    public void h() {
        final aqr aabb = aqr.a().a((double)this.l, (double)this.m, (double)this.n, (double)(this.l + 1), (double)(this.m + 1), (double)(this.n + 1)).b(16.0, 16.0, 16.0);
        final List nearbyGhasts = this.k.a((Class)EntityTFMiniGhast.class, aabb);
        for (final EntityTFMiniGhast ghast : nearbyGhasts) {
            if (ghast.aZ > 0 && !this.dyingGhasts.contains(ghast)) {
                this.dyingGhasts.add(ghast);
            }
        }
        final int chargeLevel = Math.min(3, this.dyingGhasts.size());
        ++this.counter;
        if (chargeLevel >= 1 & this.counter % 10 == 0) {
            ((BlockTFTowerDevice)TFBlocks.towerDevice).sparkle(this.k, this.l, this.m, this.n, this.k.s);
            this.k.a(this.l + 0.5, this.m + 1.5, this.n + 0.5, "note.harp", 0.5f, 1.0f, false);
        }
        if (chargeLevel >= 2) {
            this.k.a("smoke", this.l + 0.1 + this.rand.nextFloat() * 0.8, this.m + 1.05, this.n + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.0, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05);
        }
        if (chargeLevel >= 3) {
            this.k.a("largesmoke", this.l + 0.1 + this.rand.nextFloat() * 0.8, this.m + 1.05, this.n + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.05, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05);
            ((BlockTFTowerDevice)TFBlocks.towerDevice).sparkle(this.k, this.l, this.m, this.n, this.k.s);
        }
    }
    
    public boolean isCharged() {
        return this.dyingGhasts.size() >= 3;
    }
}
