// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.block.BlockState;
import twilightforest.entity.CarminiteGhastguardEntity;
import net.minecraft.util.DamageSource;
import twilightforest.entity.boss.UrGhastEntity;
import net.minecraft.entity.monster.GhastEntity;
import twilightforest.TFSounds;
import net.minecraft.state.Property;
import twilightforest.client.particle.TFParticleType;
import java.util.Iterator;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import twilightforest.block.TFBlocks;
import twilightforest.block.GhastTrapBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.ArrayList;
import net.minecraft.tileentity.TileEntityType;
import java.util.Random;
import twilightforest.entity.CarminiteGhastlingEntity;
import java.util.List;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ActiveGhastTrapTileEntity extends TileEntity implements ITickableTileEntity
{
    private int counter;
    private final List<CarminiteGhastlingEntity> dyingGhasts;
    private final Random rand;
    
    public ActiveGhastTrapTileEntity() {
        super((TileEntityType)TFTileEntities.GHAST_TRAP.get());
        this.counter = 0;
        this.dyingGhasts = new ArrayList<CarminiteGhastlingEntity>();
        this.rand = new Random();
    }
    
    private void tickInactive() {
        final AxisAlignedBB aabb = new AxisAlignedBB(this.field_174879_c).func_72314_b(10.0, 16.0, 10.0);
        final List<CarminiteGhastlingEntity> nearbyGhasts = this.field_145850_b.func_217357_a((Class)CarminiteGhastlingEntity.class, aabb);
        for (final CarminiteGhastlingEntity ghast : nearbyGhasts) {
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
                final CarminiteGhastlingEntity highlight = nearbyGhasts.get(this.rand.nextInt(nearbyGhasts.size()));
                this.makeParticlesTo((Entity)highlight);
            }
            if (chargeLevel >= 1 && this.counter % 10 == 0) {
                ((GhastTrapBlock)TFBlocks.ghast_trap.get()).sparkle(this.field_145850_b, this.field_174879_c);
                this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, SoundEvents.field_187682_dG, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            }
            if (chargeLevel >= 2) {
                this.field_145850_b.func_195594_a((IParticleData)ParticleTypes.field_197601_L, this.field_174879_c.func_177958_n() + 0.1 + this.rand.nextFloat() * 0.8, this.field_174879_c.func_177956_o() + 1.05, this.field_174879_c.func_177952_p() + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.0, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05);
                if (this.counter % 10 == 0) {
                    this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, SoundEvents.field_187682_dG, SoundCategory.BLOCKS, 1.2f, 0.8f, false);
                }
            }
            if (chargeLevel >= 3) {
                this.field_145850_b.func_195594_a((IParticleData)ParticleTypes.field_197594_E, this.field_174879_c.func_177958_n() + 0.1 + this.rand.nextFloat() * 0.8, this.field_174879_c.func_177956_o() + 1.05, this.field_174879_c.func_177952_p() + 0.1 + this.rand.nextFloat() * 0.8, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05, 0.05, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05);
                ((GhastTrapBlock)TFBlocks.ghast_trap.get()).sparkle(this.field_145850_b, this.field_174879_c);
                if (this.counter % 5 == 0) {
                    this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 1.5, this.field_174879_c.func_177952_p() + 0.5, SoundEvents.field_187682_dG, SoundCategory.BLOCKS, 1.5f, 2.0f, false);
                }
            }
        }
    }
    
    private void makeParticlesTo(final Entity highlight) {
        final double sx = this.field_174879_c.func_177958_n() + 0.5;
        final double sy = this.field_174879_c.func_177956_o() + 1.0;
        final double sz = this.field_174879_c.func_177952_p() + 0.5;
        final double dx = sx - highlight.func_226277_ct_();
        final double dy = sy - highlight.func_226278_cu_() - highlight.func_70047_e();
        final double dz = sz - highlight.func_226281_cx_();
        for (int i = 0; i < 5; ++i) {
            this.field_145850_b.func_195594_a((IParticleData)TFParticleType.GHAST_TRAP.get(), sx, sy, sz, -dx, -dy, -dz);
        }
    }
    
    public boolean isCharged() {
        return this.dyingGhasts.size() >= 3;
    }
    
    public void func_73660_a() {
        if (this.func_195044_w().func_177229_b((Property)GhastTrapBlock.ACTIVE)) {
            this.tickActive();
        }
        else {
            this.tickInactive();
        }
    }
    
    public boolean func_145842_c(final int event, final int payload) {
        if (event == 0) {
            this.counter = 0;
            this.dyingGhasts.clear();
            return true;
        }
        if (event == 1) {
            this.counter = 0;
            return true;
        }
        return false;
    }
    
    private void tickActive() {
        ++this.counter;
        if (this.field_145850_b.field_72995_K) {
            if (this.counter > 100 && this.counter % 4 == 0) {
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.HUGE_SMOKE.get(), this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.95, this.field_174879_c.func_177952_p() + 0.5, Math.cos(this.counter / 10.0) * 0.05, 0.25, Math.sin(this.counter / 10.0) * 0.05);
            }
            else if (this.counter < 100) {
                final double x = this.field_174879_c.func_177958_n() + 0.5;
                final double y = this.field_174879_c.func_177956_o() + 1.0;
                final double z = this.field_174879_c.func_177952_p() + 0.5;
                final double dx = Math.cos(this.counter / 10.0) * 2.5;
                final double dy = 20.0;
                final double dz = Math.sin(this.counter / 10.0) * 2.5;
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.GHAST_TRAP.get(), x, y, z, dx, dy, dz);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.GHAST_TRAP.get(), x, y, z, -dx, dy, -dz);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.GHAST_TRAP.get(), x, y, z, -dx, dy / 2.0, dz);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.GHAST_TRAP.get(), x, y, z, dx, dy / 2.0, -dz);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.GHAST_TRAP.get(), x, y, z, dx / 2.0, dy / 4.0, dz / 2.0);
                this.field_145850_b.func_195594_a((IParticleData)TFParticleType.GHAST_TRAP.get(), x, y, z, -dx / 2.0, dy / 4.0, -dz / 2.0);
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
        else {
            final AxisAlignedBB aabb = new AxisAlignedBB(this.field_174879_c.func_177981_b(16), this.field_174879_c.func_177981_b(16).func_177982_a(1, 1, 1)).func_72314_b(6.0, 16.0, 6.0);
            final List<GhastEntity> nearbyGhasts = this.field_145850_b.func_217357_a((Class)GhastEntity.class, aabb);
            for (final GhastEntity ghast : nearbyGhasts) {
                if (ghast instanceof UrGhastEntity) {
                    ((UrGhastEntity)ghast).setInTantrum(false);
                    ((UrGhastEntity)ghast).field_70145_X = true;
                    final double mx = (ghast.func_226277_ct_() - this.field_174879_c.func_177958_n() - 0.5) * -0.1;
                    final double my = (ghast.func_226278_cu_() - this.field_174879_c.func_177956_o() - 2.5) * -0.1;
                    final double mz = (ghast.func_226281_cx_() - this.field_174879_c.func_177952_p() - 0.5) * -0.1;
                    ghast.func_213293_j(mx, my, mz);
                    if (this.rand.nextInt(10) == 0) {
                        ghast.func_70097_a(DamageSource.field_76377_j, 7.0f);
                        ((UrGhastEntity)ghast).resetDamageUntilNextPhase();
                    }
                }
                else {
                    final double mx = (ghast.func_226277_ct_() - this.field_174879_c.func_177958_n() - 0.5) * -0.1;
                    final double my = (ghast.func_226278_cu_() - this.field_174879_c.func_177956_o() - 1.5) * -0.1;
                    final double mz = (ghast.func_226281_cx_() - this.field_174879_c.func_177952_p() - 0.5) * -0.1;
                    ghast.func_213293_j(mx, my, mz);
                    if (this.rand.nextInt(10) == 0) {
                        ghast.func_70097_a(DamageSource.field_76377_j, 10.0f);
                    }
                }
                if (ghast instanceof CarminiteGhastguardEntity) {
                    ((CarminiteGhastguardEntity)ghast).setInTrap();
                }
            }
            if (this.counter >= 120) {
                this.field_145850_b.func_175656_a(this.func_174877_v(), (BlockState)this.func_195044_w().func_206870_a((Property)GhastTrapBlock.ACTIVE, (Comparable)false));
                this.field_145850_b.func_175641_c(this.func_174877_v(), this.func_195044_w().func_177230_c(), 1, 0);
            }
        }
    }
}
