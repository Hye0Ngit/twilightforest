// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import java.util.Iterator;
import java.util.List;
import twilightforest.block.TFBlocks;
import twilightforest.entity.EntityTFTowerGhast;
import net.minecraft.util.DamageSource;
import twilightforest.entity.EntityTFUrGhast;
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
    
    public void func_70316_g() {
        ++this.counter;
        if (this.field_70331_k.field_72995_K) {
            if (this.counter > 100 && this.counter % 4 == 0) {
                TwilightForestMod.proxy.spawnParticle("hugesmoke", this.field_70329_l + 0.5, this.field_70330_m + 0.95, this.field_70327_n + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
            }
            else if (this.counter < 100) {
                final double dx = Math.cos(this.counter / 10.0) * 2.5;
                final double dy = 20.0;
                final double dz = Math.sin(this.counter / 10.0) * 2.5;
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, dx, dy, dz);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, -dx, dy, -dz);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, -dx, dy / 2.0, dz);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, dx, dy / 2.0, -dz);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, dx / 2.0, dy / 4.0, dz / 2.0);
                TwilightForestMod.proxy.spawnParticle("ghasttrap", this.field_70329_l + 0.5, this.field_70330_m + 1.0, this.field_70327_n + 0.5, -dx / 2.0, dy / 4.0, -dz / 2.0);
            }
            if (this.counter < 30) {
                this.field_70331_k.func_72980_b(this.field_70329_l + 0.5, this.field_70330_m + 1.5, this.field_70327_n + 0.5, "mob.tf.urghast.trapwarmup", 1.0f, 4.0f, false);
            }
            else if (this.counter < 80) {
                this.field_70331_k.func_72980_b(this.field_70329_l + 0.5, this.field_70330_m + 1.5, this.field_70327_n + 0.5, "mob.tf.urghast.trapon", 1.0f, 4.0f, false);
            }
            else {
                this.field_70331_k.func_72980_b(this.field_70329_l + 0.5, this.field_70330_m + 1.5, this.field_70327_n + 0.5, "mob.tf.urghast.trapspindown", 1.0f, 4.0f, false);
            }
        }
        if (!this.field_70331_k.field_72995_K) {
            final AxisAlignedBB aabb = AxisAlignedBB.func_72332_a().func_72299_a((double)this.field_70329_l, this.field_70330_m + 16.0, (double)this.field_70327_n, (double)(this.field_70329_l + 1), (double)(this.field_70330_m + 16 + 1), (double)(this.field_70327_n + 1)).func_72314_b(6.0, 16.0, 6.0);
            final List nearbyGhasts = this.field_70331_k.func_72872_a((Class)EntityGhast.class, aabb);
            for (final EntityGhast ghast : nearbyGhasts) {
                if (ghast instanceof EntityTFUrGhast) {
                    ((EntityTFUrGhast)ghast).stopTantrum();
                    ghast.field_70159_w = (ghast.field_70165_t - this.field_70329_l - 0.5) * -0.1;
                    ghast.field_70181_x = (ghast.field_70163_u - this.field_70330_m - 2.5) * -0.1;
                    ghast.field_70179_y = (ghast.field_70161_v - this.field_70327_n - 0.5) * -0.1;
                    if (this.rand.nextInt(10) == 0) {
                        ghast.func_70097_a(DamageSource.field_76377_j, 3);
                    }
                }
                else {
                    ghast.field_70159_w = (ghast.field_70165_t - this.field_70329_l - 0.5) * -0.1;
                    ghast.field_70181_x = (ghast.field_70163_u - this.field_70330_m - 1.5) * -0.1;
                    ghast.field_70179_y = (ghast.field_70161_v - this.field_70327_n - 0.5) * -0.1;
                    if (this.rand.nextInt(10) == 0) {
                        ghast.func_70097_a(DamageSource.field_76377_j, 10);
                    }
                }
                if (ghast instanceof EntityTFTowerGhast) {
                    ((EntityTFTowerGhast)ghast).setInTrap();
                }
            }
            if (this.counter >= 120) {
                this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, TFBlocks.towerDevice.field_71990_ca, 10, 3);
            }
        }
    }
}
