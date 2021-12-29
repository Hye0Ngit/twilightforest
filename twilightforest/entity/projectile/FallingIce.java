// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelReader;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.entity.boss.AlphaYeti;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;

public class FallingIce extends FallingBlockEntity
{
    private static final int HANG_TIME = 100;
    
    public FallingIce(final EntityType<? extends FallingIce> type, final Level world) {
        super((EntityType)type, world);
    }
    
    public FallingIce(final Level world, final int x, final int y, final int z) {
        super(world, (double)x, (double)y, (double)z, Blocks.f_50354_.m_49966_());
        this.f_149641_ = 10.0f;
        this.f_31940_ = 30;
        this.f_31939_ = true;
    }
    
    public void m_8119_() {
        if (this.f_31942_ > 100) {
            this.m_20242_(true);
        }
        super.m_8119_();
        if (!this.f_19853_.f_46443_) {
            final List<FallingIce> nearby = this.f_19853_.m_45976_((Class)FallingIce.class, this.m_142469_());
            for (final FallingIce entity : nearby) {
                if (entity != this && entity.f_31942_ < this.f_31942_) {
                    entity.m_146870_();
                }
            }
            this.destroyIceInAABB(this.m_142469_().m_82377_(0.5, 0.0, 0.5));
        }
        else {
            this.makeTrail();
        }
    }
    
    private void makeTrail() {
        for (int i = 0; i < 2; ++i) {
            final double dx = this.m_20185_() + 2.0f * (this.f_19796_.nextFloat() - this.f_19796_.nextFloat());
            final double dy = this.m_20186_() - 3.0 + 3.0f * (this.f_19796_.nextFloat() - this.f_19796_.nextFloat());
            final double dz = this.m_20189_() + 2.0f * (this.f_19796_.nextFloat() - this.f_19796_.nextFloat());
            this.f_19853_.m_7106_((ParticleOptions)TFParticleType.SNOW_WARNING.get(), dx, dy, dz, 0.0, -1.0, 0.0);
        }
    }
    
    public boolean m_142535_(final float distance, final float multiplier, final DamageSource source) {
        if (this.f_31939_) {
            final int i = Mth.m_14167_(distance - 1.0f);
            if (i > 0) {
                final List<Entity> list = this.f_19853_.m_45933_((Entity)this, this.m_142469_());
                final DamageSource damagesource = DamageSource.f_19322_;
                for (final Entity entity : list) {
                    if (!(entity instanceof AlphaYeti)) {
                        entity.m_6469_(damagesource, (float)Math.min(Mth.m_14143_(i * this.f_149641_), this.f_31940_));
                    }
                }
            }
        }
        final BlockState stateId = Blocks.f_50354_.m_49966_();
        for (int j = 0; j < 200; ++j) {
            final double dx = this.m_20185_() + 3.0f * (this.f_19796_.nextFloat() - this.f_19796_.nextFloat());
            final double dy = this.m_20186_() + 2.0 + 3.0f * (this.f_19796_.nextFloat() - this.f_19796_.nextFloat());
            final double dz = this.m_20189_() + 3.0f * (this.f_19796_.nextFloat() - this.f_19796_.nextFloat());
            this.f_19853_.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, stateId), dx, dy, dz, 0.0, 0.0, 0.0);
        }
        this.m_5496_(Blocks.f_50354_.getSoundType(Blocks.f_50354_.m_49966_(), (LevelReader)this.f_19853_, this.m_142538_(), (Entity)null).m_56775_(), 3.0f, 0.5f);
        return false;
    }
    
    private void destroyIceInAABB(final AABB aabb) {
        final int minX = Mth.m_14107_(aabb.f_82288_);
        final int minY = Mth.m_14107_(aabb.f_82289_);
        final int minZ = Mth.m_14107_(aabb.f_82290_);
        final int maxX = Mth.m_14107_(aabb.f_82291_);
        final int maxY = Mth.m_14107_(aabb.f_82292_);
        final int maxZ = Mth.m_14107_(aabb.f_82293_);
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final BlockPos pos = new BlockPos(dx, dy, dz);
                    final Block block = this.f_19853_.m_8055_(pos).m_60734_();
                    if (block == Blocks.f_50126_ || block == Blocks.f_50354_ || block == Blocks.f_50069_) {
                        this.f_19853_.m_46961_(pos, false);
                    }
                }
            }
        }
    }
}
