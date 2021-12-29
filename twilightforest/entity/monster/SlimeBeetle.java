// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import twilightforest.entity.projectile.SlimeProjectile;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;

public class SlimeBeetle extends Monster implements RangedAttackMob
{
    public SlimeBeetle(final EntityType<? extends SlimeBeetle> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Player.class, 3.0f, 1.25, 2.0));
        this.f_21345_.m_25352_(3, (Goal)new RangedAttackGoal((RangedAttackMob)this, 1.0, 30, 10.0f));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 25.0).m_22268_(Attributes.f_22279_, 0.23).m_22268_(Attributes.f_22281_, 4.0);
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.SLIME_BEETLE_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.SLIME_BEETLE_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.SLIME_BEETLE_STEP, 0.15f, 1.0f);
    }
    
    public float m_20236_(final Pose pose) {
        return 0.25f;
    }
    
    public MobType m_6336_() {
        return MobType.f_21642_;
    }
    
    public void m_6504_(final LivingEntity target, final float distanceFactor) {
        final ThrowableProjectile projectile = new SlimeProjectile(TFEntities.SLIME_BLOB, this.f_19853_, (LivingEntity)this);
        this.m_5496_(TFSounds.SLIME_BEETLE_SQUISH_SMALL, 1.0f, 1.0f / (this.m_21187_().nextFloat() * 0.4f + 0.8f));
        final double tx = target.m_20185_() - this.m_20185_();
        final double ty = target.m_20186_() + target.m_20192_() - 1.100000023841858 - projectile.m_20186_();
        final double tz = target.m_20189_() - this.m_20189_();
        final float heightOffset = Mth.m_14116_((float)(tx * tx + tz * tz)) * 0.2f;
        projectile.m_6686_(tx, ty + heightOffset, tz, 0.6f, 6.0f);
        this.f_19853_.m_7967_((Entity)projectile);
    }
}
