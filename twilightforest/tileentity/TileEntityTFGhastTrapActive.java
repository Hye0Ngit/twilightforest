// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerDeviceVariant;
import twilightforest.block.BlockTFTowerDevice;
import twilightforest.block.TFBlocks;
import twilightforest.entity.EntityTFTowerGhast;
import net.minecraft.util.DamageSource;
import twilightforest.entity.boss.EntityTFUrGhast;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import java.util.Random;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFGhastTrapActive extends TileEntity implements ITickable
{
    private int counter;
    private final Random rand;
    
    public TileEntityTFGhastTrapActive() {
        this.counter = 0;
        this.rand = new Random();
    }
    
    public void func_73660_a() {
        ++this.counter;
        if (this.field_145850_b.field_72995_K) {
            if (this.counter > 100 && this.counter % 4 == 0) {
                TwilightForestMod.proxy.spawnParticle(TFParticleType.HUGE_SMOKE, this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.95, this.field_174879_c.func_177952_p() + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
            }
            else if (this.counter < 100) {
                final double x = this.field_174879_c.func_177958_n() + 0.5;
                final double y = this.field_174879_c.func_177956_o() + 1.0;
                final double z = this.field_174879_c.func_177952_p() + 0.5;
                final double dx = Math.cos(this.counter / 10.0) * 2.5;
                final double dy = 20.0;
                final double dz = Math.sin(this.counter / 10.0) * 2.5;
                TwilightForestMod.proxy.spawnParticle(TFParticleType.GHAST_TRAP, x, y, z, dx, dy, dz);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.GHAST_TRAP, x, y, z, -dx, dy, -dz);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.GHAST_TRAP, x, y, z, -dx, dy / 2.0, dz);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.GHAST_TRAP, x, y, z, dx, dy / 2.0, -dz);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.GHAST_TRAP, x, y, z, dx / 2.0, dy / 4.0, dz / 2.0);
                TwilightForestMod.proxy.spawnParticle(TFParticleType.GHAST_TRAP, x, y, z, -dx / 2.0, dy / 4.0, -dz / 2.0);
            }
            if (this.counter < 30) {
                this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, TFSounds.URGHAST_TRAP_WARMUP, SoundCategory.BLOCKS, 1.0f, 4.0f, false);
            }
            else if (this.counter < 80) {
                this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, TFSounds.URGHAST_TRAP_ON, SoundCategory.BLOCKS, 1.0f, 4.0f, false);
            }
            else {
                this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, TFSounds.URGHAST_TRAP_SPINDOWN, SoundCategory.BLOCKS, 1.0f, 4.0f, false);
            }
        }
        if (!this.field_145850_b.field_72995_K) {
            final AxisAlignedBB aabb = new AxisAlignedBB(this.field_174879_c.func_177981_b(16), this.field_174879_c.func_177981_b(16).func_177982_a(1, 1, 1)).func_72314_b(6.0, 16.0, 6.0);
            final List<EntityGhast> nearbyGhasts = this.field_145850_b.func_72872_a((Class)EntityGhast.class, aabb);
            for (final EntityGhast ghast : nearbyGhasts) {
                if (ghast instanceof EntityTFUrGhast) {
                    ((EntityTFUrGhast)ghast).setInTantrum(false);
                    ((EntityTFUrGhast)ghast).field_70145_X = true;
                    ghast.field_70159_w = (ghast.field_70165_t - this.field_174879_c.func_177958_n() - 0.5) * -0.1;
                    ghast.field_70181_x = (ghast.field_70163_u - this.field_174879_c.func_177956_o() - 2.5) * -0.1;
                    ghast.field_70179_y = (ghast.field_70161_v - this.field_174879_c.func_177952_p() - 0.5) * -0.1;
                    if (this.rand.nextInt(10) == 0) {
                        ghast.func_70097_a(DamageSource.field_76377_j, 7.0f);
                        ((EntityTFUrGhast)ghast).resetDamageUntilNextPhase();
                    }
                }
                else {
                    ghast.field_70159_w = (ghast.field_70165_t - this.field_174879_c.func_177958_n() - 0.5) * -0.1;
                    ghast.field_70181_x = (ghast.field_70163_u - this.field_174879_c.func_177956_o() - 1.5) * -0.1;
                    ghast.field_70179_y = (ghast.field_70161_v - this.field_174879_c.func_177952_p() - 0.5) * -0.1;
                    if (this.rand.nextInt(10) == 0) {
                        ghast.func_70097_a(DamageSource.field_76377_j, 10.0f);
                    }
                }
                if (ghast instanceof EntityTFTowerGhast) {
                    ((EntityTFTowerGhast)ghast).setInTrap();
                }
            }
            if (this.counter >= 120) {
                this.field_145850_b.func_180501_a(this.field_174879_c, TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.GHASTTRAP_INACTIVE), 3);
            }
        }
    }
}
