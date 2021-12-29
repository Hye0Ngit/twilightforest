// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.ai.goal.WrappedGoal;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.registration.TFFeature;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;

public class SwarmSpider extends Spider
{
    protected boolean shouldSpawn;
    
    public SwarmSpider(final EntityType<? extends SwarmSpider> type, final Level world) {
        this(type, world, true);
    }
    
    public SwarmSpider(final EntityType<? extends SwarmSpider> type, final Level world, final boolean spawnMore) {
        super((EntityType)type, world);
        this.shouldSpawn = false;
        this.setSpawnMore(spawnMore);
        this.f_21364_ = 2;
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Spider.m_33815_().m_22268_(Attributes.f_22276_, 3.0).m_22268_(Attributes.f_22281_, 1.0);
    }
    
    protected void m_8099_() {
        super.m_8099_();
        this.f_21345_.f_25345_.removeIf(t -> t.m_26015_() instanceof MeleeAttackGoal);
        this.f_21345_.m_25352_(4, (Goal)new MeleeAttackGoal(this, 1.0, true) {
            protected double m_6639_(final LivingEntity attackTarget) {
                return 4.0f + attackTarget.m_20205_();
            }
        });
        this.f_21346_.f_25345_.removeIf(t -> t.m_26012_() == 2 && t.m_26015_() instanceof NearestAttackableTargetGoal);
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.SWARM_SPIDER_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.SWARM_SPIDER_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.SWARM_SPIDER_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState blockIn) {
        this.m_5496_(TFSounds.SWARM_SPIDER_STEP, 0.15f, 1.0f);
    }
    
    protected float m_6431_(final Pose poseIn, final EntityDimensions sizeIn) {
        return 0.3f;
    }
    
    public void m_8119_() {
        if (!this.f_19853_.f_46443_ && this.shouldSpawnMore()) {
            for (int more = 1 + this.f_19796_.nextInt(2), i = 0; i < more; ++i) {
                if (!this.spawnAnother()) {
                    this.spawnAnother();
                }
            }
            this.setSpawnMore(false);
        }
        super.m_8119_();
    }
    
    public boolean m_7327_(final Entity entity) {
        return this.f_19796_.nextInt(4) == 0 && super.m_7327_(entity);
    }
    
    protected boolean spawnAnother() {
        final SwarmSpider another = new SwarmSpider(TFEntities.SWARM_SPIDER, this.f_19853_, false);
        final double sx = this.m_20185_() + (this.f_19796_.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.m_20186_();
        final double sz = this.m_20189_() + (this.f_19796_.nextBoolean() ? 0.9 : -0.9);
        another.m_7678_(sx, sy, sz, this.f_19796_.nextFloat() * 360.0f, 0.0f);
        if (!another.m_5545_((LevelAccessor)this.f_19853_, MobSpawnType.MOB_SUMMONED)) {
            another.m_146870_();
            return false;
        }
        this.f_19853_.m_7967_((Entity)another);
        another.m_21373_();
        return true;
    }
    
    public static boolean getCanSpawnHere(final EntityType<? extends SwarmSpider> entity, final ServerLevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        return world.m_46791_() != Difficulty.PEACEFUL && isValidLightLevel(world, pos, random) && m_21400_((EntityType)entity, (LevelAccessor)world, reason, pos, random);
    }
    
    public static boolean isValidLightLevel(final ServerLevelAccessor world, final BlockPos pos, final Random random) {
        final int chunkX = Mth.m_14143_((float)pos.m_123341_()) >> 4;
        final int chunkZ = Mth.m_14143_((float)pos.m_123343_()) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, (WorldGenLevel)world) == TFFeature.HEDGE_MAZE || Monster.m_33008_(world, pos, random);
    }
    
    public boolean shouldSpawnMore() {
        return this.shouldSpawn;
    }
    
    public void setSpawnMore(final boolean flag) {
        this.shouldSpawn = flag;
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128379_("SpawnMore", this.shouldSpawnMore());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setSpawnMore(compound.m_128471_("SpawnMore"));
    }
    
    public float m_6100_() {
        return (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.2f + 1.5f;
    }
    
    public int m_5792_() {
        return 16;
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable SpawnGroupData livingData, @Nullable final CompoundTag dataTag) {
        livingData = super.m_6518_(worldIn, difficulty, reason, livingData, dataTag);
        if (this.m_146895_() != null || worldIn.m_5822_().nextInt(20) <= difficulty.m_19048_().m_19028_()) {
            final SkeletonDruid druid = (SkeletonDruid)TFEntities.SKELETON_DRUID.m_20615_(this.f_19853_);
            druid.m_7678_(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_146908_(), 0.0f);
            druid.m_6863_(true);
            druid.m_6518_(worldIn, difficulty, MobSpawnType.JOCKEY, (SpawnGroupData)null, (CompoundTag)null);
            if (this.m_146862_(e -> true)) {
                this.m_20153_();
            }
            druid.m_20329_((Entity)this);
        }
        return livingData;
    }
}
