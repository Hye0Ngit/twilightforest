// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import java.util.Iterator;
import java.util.List;
import twilightforest.block.TFBlocks;
import twilightforest.entity.EntityTFTowerGhast;
import net.minecraft.util.DamageSource;
import twilightforest.entity.boss.EntityTFUrGhast;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.AxisAlignedBB;
import twilightforest.TwilightForestMod;
import java.util.Random;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFGhastTrapActive extends TileEntity
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
    
    public void func_145845_h() {
        ++this.counter;
        if (this.field_145850_b.field_72995_K) {
            if (this.counter > 100 && this.counter % 4 == 0) {
                TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "hugesmoke", this.field_145851_c + 0.5, this.field_145848_d + 0.95, this.field_145849_e + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
            }
            else if (this.counter < 100) {
                final double dx = Math.cos(this.counter / 10.0) * 2.5;
                final double dy = 20.0;
                final double dz = Math.sin(this.counter / 10.0) * 2.5;
                TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "ghasttrap", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, dx, dy, dz);
                TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "ghasttrap", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, -dx, dy, -dz);
                TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "ghasttrap", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, -dx, dy / 2.0, dz);
                TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "ghasttrap", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, dx, dy / 2.0, -dz);
                TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "ghasttrap", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, dx / 2.0, dy / 4.0, dz / 2.0);
                TwilightForestMod.proxy.spawnParticle(this.field_145850_b, "ghasttrap", this.field_145851_c + 0.5, this.field_145848_d + 1.0, this.field_145849_e + 0.5, -dx / 2.0, dy / 4.0, -dz / 2.0);
            }
            if (this.counter < 30) {
                this.field_145850_b.func_72980_b(this.field_145851_c + 0.5, this.field_145848_d + 1.5, this.field_145849_e + 0.5, "TwilightForest:mob.urghast.trapwarmup", 1.0f, 4.0f, false);
            }
            else if (this.counter < 80) {
                this.field_145850_b.func_72980_b(this.field_145851_c + 0.5, this.field_145848_d + 1.5, this.field_145849_e + 0.5, "TwilightForest:mob.urghast.trapon", 1.0f, 4.0f, false);
            }
            else {
                this.field_145850_b.func_72980_b(this.field_145851_c + 0.5, this.field_145848_d + 1.5, this.field_145849_e + 0.5, "TwilightForest:mob.urghast.trapspindown", 1.0f, 4.0f, false);
            }
        }
        if (!this.field_145850_b.field_72995_K) {
            final AxisAlignedBB aabb = AxisAlignedBB.func_72330_a((double)this.field_145851_c, this.field_145848_d + 16.0, (double)this.field_145849_e, (double)(this.field_145851_c + 1), (double)(this.field_145848_d + 16 + 1), (double)(this.field_145849_e + 1)).func_72314_b(6.0, 16.0, 6.0);
            final List<EntityGhast> nearbyGhasts = this.field_145850_b.func_72872_a((Class)EntityGhast.class, aabb);
            for (final EntityGhast ghast : nearbyGhasts) {
                if (ghast instanceof EntityTFUrGhast) {
                    ((EntityTFUrGhast)ghast).stopTantrum();
                    ghast.field_70159_w = (ghast.field_70165_t - this.field_145851_c - 0.5) * -0.1;
                    ghast.field_70181_x = (ghast.field_70163_u - this.field_145848_d - 2.5) * -0.1;
                    ghast.field_70179_y = (ghast.field_70161_v - this.field_145849_e - 0.5) * -0.1;
                    if (this.rand.nextInt(10) == 0) {
                        ghast.func_70097_a(DamageSource.field_76377_j, 3.0f);
                    }
                }
                else {
                    ghast.field_70159_w = (ghast.field_70165_t - this.field_145851_c - 0.5) * -0.1;
                    ghast.field_70181_x = (ghast.field_70163_u - this.field_145848_d - 1.5) * -0.1;
                    ghast.field_70179_y = (ghast.field_70161_v - this.field_145849_e - 0.5) * -0.1;
                    if (this.rand.nextInt(10) == 0) {
                        ghast.func_70097_a(DamageSource.field_76377_j, 10.0f);
                    }
                }
                if (ghast instanceof EntityTFTowerGhast) {
                    ((EntityTFTowerGhast)ghast).setInTrap();
                }
            }
            if (this.counter >= 120) {
                this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d, this.field_145849_e, TFBlocks.towerDevice, 10, 3);
            }
        }
    }
}
