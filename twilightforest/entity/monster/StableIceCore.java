// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import twilightforest.entity.projectile.IceSnowball;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.RangedAttackMob;

public class StableIceCore extends BaseIceMob implements RangedAttackMob
{
    public StableIceCore(final EntityType<? extends StableIceCore> type, final Level world) {
        super(type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new RangedAttackGoal((RangedAttackMob)this, 1.25, 20, 10.0f));
        this.f_21345_.m_25352_(2, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(3, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(3, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22279_, 0.23000000417232513).m_22268_(Attributes.f_22281_, 3.0);
    }
    
    public float m_20236_(final Pose pose) {
        return this.m_20206_() * 0.6f;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.ICE_CORE_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.ICE_CORE_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.ICE_CORE_DEATH;
    }
    
    public int m_5792_() {
        return 8;
    }
    
    public void m_6504_(final LivingEntity target, final float distanceFactor) {
        final IceSnowball snowball = new IceSnowball(this.f_19853_, (LivingEntity)this);
        snowball.m_6034_(this.m_20185_(), this.m_20186_() + this.m_20192_(), this.m_20189_());
        final double d0 = target.m_20186_() + target.m_20192_() - 1.4;
        final double d2 = target.m_20185_() - this.m_20185_();
        final double d3 = d0 - snowball.m_20186_();
        final double d4 = target.m_20189_() - this.m_20189_();
        final float f = Mth.m_14116_((float)(d2 * d2 + d4 * d4)) * 0.2f;
        snowball.m_6686_(d2, d3 + f, d4, 1.6f, 6.0f);
        this.m_5496_(TFSounds.ICE_CORE_SHOOT, 1.0f, 1.0f / (this.m_21187_().nextFloat() * 0.4f + 0.8f));
        this.f_19853_.m_7967_((Entity)snowball);
    }
}
