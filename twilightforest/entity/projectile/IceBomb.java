// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import java.util.Iterator;
import java.util.List;
import net.minecraft.world.effect.MobEffectInstance;
import twilightforest.potions.TFMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import twilightforest.util.TFDamageSources;
import net.minecraft.tags.EntityTypeTags;
import twilightforest.entity.monster.Yeti;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.SnowLayerBlock;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import twilightforest.entity.TFEntities;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class IceBomb extends TFThrowable
{
    private int zoneTimer;
    private boolean hasHit;
    
    public IceBomb(final EntityType<? extends IceBomb> type, final Level world) {
        super(type, world);
        this.zoneTimer = 80;
    }
    
    public IceBomb(final EntityType<? extends IceBomb> type, final Level world, final LivingEntity thrower) {
        super(type, world, thrower);
        this.zoneTimer = 80;
    }
    
    public IceBomb(final Level world, final Position pos) {
        super(TFEntities.THROWN_ICE, world, pos.m_7096_(), pos.m_7098_(), pos.m_7094_());
        this.zoneTimer = 80;
    }
    
    protected void m_6532_(final HitResult ray) {
        this.m_20334_(0.0, 0.0, 0.0);
        this.hasHit = true;
        this.doTerrainEffects();
    }
    
    private void doTerrainEffects() {
        final int range = 3;
        final int ix = Mth.m_14107_(this.f_19790_);
        final int iy = Mth.m_14107_(this.f_19791_);
        final int iz = Mth.m_14107_(this.f_19792_);
        for (int x = -3; x <= 3; ++x) {
            for (int y = -3; y <= 3; ++y) {
                for (int z = -3; z <= 3; ++z) {
                    final BlockPos pos = new BlockPos(ix + x, iy + y, iz + z);
                    this.doTerrainEffect(pos);
                }
            }
        }
    }
    
    private void doTerrainEffect(final BlockPos pos) {
        final BlockState state = this.f_19853_.m_8055_(pos);
        if (!this.f_19853_.f_46443_) {
            if (state.m_60767_() == Material.f_76305_) {
                this.f_19853_.m_46597_(pos, Blocks.f_50126_.m_49966_());
            }
            if (state == Blocks.f_49991_.m_49966_()) {
                this.f_19853_.m_46597_(pos, Blocks.f_50080_.m_49966_());
            }
            if (this.f_19853_.m_46859_(pos) && Blocks.f_50125_.m_49966_().m_60710_((LevelReader)this.f_19853_, pos)) {
                this.f_19853_.m_46597_(pos, Blocks.f_50125_.m_49966_());
            }
            if (BlockTagGenerator.ICE_BOMB_REPLACEABLES.m_8110_((Object)state.m_60734_())) {
                this.f_19853_.m_7731_(pos, Blocks.f_50125_.m_49966_().m_60710_((LevelReader)this.f_19853_, pos) ? Blocks.f_50125_.m_49966_() : Blocks.f_50016_.m_49966_(), 3);
            }
            if (state.m_60713_(Blocks.f_50125_) && (int)state.m_61143_((Property)SnowLayerBlock.f_56581_) < 8) {
                this.f_19853_.m_46597_(pos, (BlockState)state.m_61124_((Property)SnowLayerBlock.f_56581_, (Comparable)((int)state.m_61143_((Property)SnowLayerBlock.f_56581_) + 1)));
            }
        }
    }
    
    public void m_8119_() {
        super.m_8119_();
        if (this.hasHit) {
            this.m_20184_().m_82542_(0.1, 0.1, 0.1);
            --this.zoneTimer;
            this.makeIceZone();
            if (!this.f_19853_.f_46443_ && this.zoneTimer <= 0) {
                this.f_19853_.m_46796_(2001, new BlockPos((Vec3i)this.m_142538_()), Block.m_49956_(Blocks.f_50126_.m_49966_()));
                this.m_146870_();
            }
        }
        else {
            this.makeTrail();
        }
    }
    
    public void makeTrail() {
        final BlockState stateId = Blocks.f_50125_.m_49966_();
        for (int i = 0; i < 5; ++i) {
            final double dx = this.m_20185_() + 1.5f * (this.f_19796_.nextFloat() - 0.5f);
            final double dy = this.m_20186_() + 1.5f * (this.f_19796_.nextFloat() - 0.5f);
            final double dz = this.m_20189_() + 1.5f * (this.f_19796_.nextFloat() - 0.5f);
            this.f_19853_.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123814_, stateId), dx, dy, dz, -this.m_20184_().m_7096_(), -this.m_20184_().m_7098_(), -this.m_20184_().m_7094_());
        }
    }
    
    private void makeIceZone() {
        if (this.f_19853_.f_46443_) {
            final BlockState stateId = Blocks.f_50125_.m_49966_();
            for (int i = 0; i < 15; ++i) {
                final double dx = this.m_20185_() + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 3.0f;
                final double dy = this.m_20186_() + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 3.0f;
                final double dz = this.m_20189_() + (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 3.0f;
                this.f_19853_.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123814_, stateId), dx, dy, dz, 0.0, 0.0, 0.0);
            }
        }
        else if (this.zoneTimer % 20 == 0) {
            this.hitNearbyEntities();
        }
    }
    
    private void hitNearbyEntities() {
        final List<LivingEntity> nearby = this.f_19853_.m_45976_((Class)LivingEntity.class, this.m_142469_().m_82377_(3.0, 2.0, 3.0));
        for (final LivingEntity entity : nearby) {
            if (entity != this.m_37282_()) {
                if (entity instanceof Yeti) {
                    final BlockPos pos = new BlockPos(entity.f_19790_, entity.f_19791_, entity.f_19792_);
                    this.f_19853_.m_46597_(pos, Blocks.f_50126_.m_49966_());
                    this.f_19853_.m_46597_(pos.m_7494_(), Blocks.f_50126_.m_49966_());
                    entity.m_146870_();
                }
                else {
                    if (!EntityTypeTags.f_144294_.m_8110_((Object)entity.m_6095_())) {
                        continue;
                    }
                    entity.m_6469_(TFDamageSources.frozen((Entity)this, (LivingEntity)this.m_37282_()), EntityTypeTags.f_144295_.m_8110_((Object)entity.m_6095_()) ? 5.0f : 1.0f);
                    entity.m_7292_(new MobEffectInstance((MobEffect)TFMobEffects.FROSTY.get(), 100));
                }
            }
        }
    }
    
    public BlockState getBlockState() {
        return Blocks.f_50354_.m_49966_();
    }
    
    protected float m_7139_() {
        return this.hasHit ? 0.0f : 0.025f;
    }
}
