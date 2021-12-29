// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.TwilightForestMod;
import java.util.Iterator;
import java.util.List;
import twilightforest.block.TFBlocks;
import twilightforest.block.BlockTFTowerDevice;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import twilightforest.entity.EntityTFMiniGhast;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFGhastTrapInactive extends TileEntity
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
    
    public void func_145845_h() {
        final AxisAlignedBB aabb = AxisAlignedBB.func_72330_a((double)this.field_145851_c, (double)this.field_145848_d, (double)this.field_145849_e, (double)(this.field_145851_c + 1), (double)(this.field_145848_d + 1), (double)(this.field_145849_e + 1)).func_72314_b(10.0, 16.0, 10.0);
        final List<EntityTFMiniGhast> nearbyGhasts = this.field_145850_b.func_72872_a((Class)EntityTFMiniGhast.class, aabb);
        for (final EntityTFMiniGhast ghast : nearbyGhasts) {
            if (ghast.field_70725_aQ > 0) {
                this.makeParticlesTo((Entity)ghast);
                if (this.dyingGhasts.contains(ghast)) {
                    continue;
                }
                this.dyingGhasts.add(ghast);
            }
        }
        final int chargeLevel = Math.min(3, this.dyingGhasts.size());
        ++this.counter;
        if (this.field_145850_b.field_72995_K) {
            if (this.counter % 20 == 0 && nearbyGhasts.size() > 0) {
                final EntityTFMiniGhast highlight = nearbyGhasts.get(this.rand.nextInt(nearbyGhasts.size()));
                this.makeParticlesTo((Entity)highlight);
            }
            if (chargeLevel >= 1 && this.counter % 10 == 0) {
                ((BlockTFTowerDevice)TFBlocks.towerDevice).sparkle(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145850_b.field_73012_v);
                this.field_145850_b.func_72980_b(this.field_145851_c + 0.5, this.field_145848_d + 1.5, this.field_145849_e + 0.5, "note.harp", 1.0f, 1.0f, false);
            }
            if (chargeLevel >= 2) {
                this.field_145850_b.func_72869_a("smoke", this.field_145851_c + 0.1 + this.rand.nextFloat() * 0.8, this.field_145848_d + 1.05, this.field_145849_e + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.0, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05);
                if (this.counter % 10 == 0) {
                    this.field_145850_b.func_72980_b(this.field_145851_c + 0.5, this.field_145848_d + 1.5, this.field_145849_e + 0.5, "note.harp", 1.2f, 0.8f, false);
                }
            }
            if (chargeLevel >= 3) {
                this.field_145850_b.func_72869_a("largesmoke", this.field_145851_c + 0.1 + this.rand.nextFloat() * 0.8, this.field_145848_d + 1.05, this.field_145849_e + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.05, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05);
                ((BlockTFTowerDevice)TFBlocks.towerDevice).sparkle(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145850_b.field_73012_v);
                if (this.counter % 5 == 0) {
                    this.field_145850_b.func_72980_b(this.field_145851_c + 0.5, this.field_145848_d + 1.5, this.field_145849_e + 0.5, "note.harp", 1.5f, 2.0f, false);
                }
            }
        }
    }
    
    private void makeParticlesTo(final Entity highlight) {
        final double sx = this.field_145851_c + 0.5;
        final double sy = this.field_145848_d + 1.0;
        final double sz = this.field_145849_e + 0.5;
        final double dx = sx - highlight.field_70165_t;
        final double dy = sy - highlight.field_70163_u - highlight.func_70047_e();
        final double dz = sz - highlight.field_70161_v;
        for (int i = 0; i < 5; ++i) {
            TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "ghasttrap", sx, sy, sz, -dx, -dy, -dz);
        }
    }
    
    public boolean isCharged() {
        return this.dyingGhasts.size() >= 3;
    }
}
