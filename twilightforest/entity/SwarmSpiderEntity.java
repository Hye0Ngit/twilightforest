// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.ISeedReader;
import twilightforest.TFFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Pose;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SpiderEntity;

public class SwarmSpiderEntity extends SpiderEntity
{
    protected boolean shouldSpawn;
    
    public SwarmSpiderEntity(final EntityType<? extends SwarmSpiderEntity> type, final World world) {
        this(type, world, true);
    }
    
    public SwarmSpiderEntity(final EntityType<? extends SwarmSpiderEntity> type, final World world, final boolean spawnMore) {
        super((EntityType)type, world);
        this.shouldSpawn = false;
        this.setSpawnMore(spawnMore);
        this.field_70728_aV = 2;
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return SpiderEntity.func_234305_eI_().func_233815_a_(Attributes.field_233818_a_, 3.0).func_233815_a_(Attributes.field_233823_f_, 1.0);
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.field_220892_d.removeIf(t -> t.func_220772_j() instanceof MeleeAttackGoal);
        this.field_70714_bg.func_75776_a(4, (Goal)new MeleeAttackGoal(this, 1.0, true) {
            protected double func_179512_a(final LivingEntity attackTarget) {
                return 4.0f + attackTarget.func_213311_cf();
            }
        });
        this.field_70715_bh.field_220892_d.removeIf(t -> t.func_220770_h() == 2 && t.func_220772_j() instanceof NearestAttackableTargetGoal);
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.SWARM_SPIDER_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.SWARM_SPIDER_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.SWARM_SPIDER_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState blockIn) {
        this.func_184185_a(TFSounds.SWARM_SPIDER_STEP, 0.15f, 1.0f);
    }
    
    protected float func_213348_b(final Pose poseIn, final EntitySize sizeIn) {
        return 0.3f;
    }
    
    public void func_70071_h_() {
        if (!this.field_70170_p.field_72995_K && this.shouldSpawnMore()) {
            for (int more = 1 + this.field_70146_Z.nextInt(2), i = 0; i < more; ++i) {
                if (!this.spawnAnother()) {
                    this.spawnAnother();
                }
            }
            this.setSpawnMore(false);
        }
        super.func_70071_h_();
    }
    
    public boolean func_70652_k(final Entity entity) {
        return this.field_70146_Z.nextInt(4) == 0 && super.func_70652_k(entity);
    }
    
    protected boolean spawnAnother() {
        final SwarmSpiderEntity another = new SwarmSpiderEntity(TFEntities.swarm_spider, this.field_70170_p, false);
        final double sx = this.func_226277_ct_() + (this.field_70146_Z.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.func_226278_cu_();
        final double sz = this.func_226281_cx_() + (this.field_70146_Z.nextBoolean() ? 0.9 : -0.9);
        another.func_70012_b(sx, sy, sz, this.field_70146_Z.nextFloat() * 360.0f, 0.0f);
        if (!another.func_213380_a((IWorld)this.field_70170_p, SpawnReason.MOB_SUMMONED)) {
            another.func_70106_y();
            return false;
        }
        this.field_70170_p.func_217376_c((Entity)another);
        another.func_70656_aK();
        return true;
    }
    
    public static boolean getCanSpawnHere(final EntityType<? extends SwarmSpiderEntity> entity, final IServerWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        return world.func_175659_aa() != Difficulty.PEACEFUL && isValidLightLevel(world, pos, random) && func_223315_a((EntityType)entity, (IWorld)world, reason, pos, random);
    }
    
    public static boolean isValidLightLevel(final IServerWorld world, final BlockPos pos, final Random random) {
        final int chunkX = MathHelper.func_76141_d((float)pos.func_177958_n()) >> 4;
        final int chunkZ = MathHelper.func_76141_d((float)pos.func_177952_p()) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, (ISeedReader)world) == TFFeature.HEDGE_MAZE || MonsterEntity.func_223323_a(world, pos, random);
    }
    
    public boolean shouldSpawnMore() {
        return this.shouldSpawn;
    }
    
    public void setSpawnMore(final boolean flag) {
        this.shouldSpawn = flag;
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74757_a("SpawnMore", this.shouldSpawnMore());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setSpawnMore(compound.func_74767_n("SpawnMore"));
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.5f;
    }
    
    public int func_70641_bl() {
        return 16;
    }
}
