// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.BreathAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.IBreathAttacker;
import net.minecraft.world.entity.monster.Monster;

public class FireBeetle extends Monster implements IBreathAttacker
{
    private static final EntityDataAccessor<Boolean> BREATHING;
    private static final int BREATH_DURATION = 10;
    private static final int BREATH_DAMAGE = 2;
    
    public FireBeetle(final EntityType<? extends FireBeetle> type, final Level world) {
        super((EntityType)type, world);
        this.m_5825_();
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(2, (Goal)new BreathAttackGoal<Object>(this, 5.0f, 30, 0.1f));
        this.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)FireBeetle.BREATHING, (Object)false);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 25.0).m_22268_(Attributes.f_22279_, 0.23).m_22268_(Attributes.f_22281_, 4.0);
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.FIRE_BEETLE_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.FIRE_BEETLE_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.FIRE_BEETLE_STEP, 0.15f, 1.0f);
    }
    
    public boolean isBreathing() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)FireBeetle.BREATHING);
    }
    
    public void setBreathing(final boolean flag) {
        this.f_19804_.m_135381_((EntityDataAccessor)FireBeetle.BREATHING, (Object)flag);
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (this.isBreathing()) {
            final Vec3 look = this.m_20154_();
            final double dist = 0.9;
            final double px = this.m_20185_() + look.f_82479_ * dist;
            final double py = this.m_20186_() + 0.25 + look.f_82480_ * dist;
            final double pz = this.m_20189_() + look.f_82481_ * dist;
            for (int i = 0; i < 2; ++i) {
                double dx = look.f_82479_;
                double dy = look.f_82480_;
                double dz = look.f_82481_;
                final double spread = 5.0 + this.m_21187_().nextDouble() * 2.5;
                final double velocity = 0.15 + this.m_21187_().nextDouble() * 0.15;
                dx += this.m_21187_().nextGaussian() * 0.007499999832361937 * spread;
                dy += this.m_21187_().nextGaussian() * 0.007499999832361937 * spread;
                dz += this.m_21187_().nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123744_, px, py, pz, dx, dy, dz);
            }
            this.m_5496_(TFSounds.FIRE_BEETLE_SHOOT, this.f_19796_.nextFloat() * 0.5f, this.f_19796_.nextFloat() * 0.5f);
        }
    }
    
    public float m_6073_() {
        if (this.isBreathing()) {
            return 1.572888E7f;
        }
        return super.m_6073_();
    }
    
    public int m_8132_() {
        return 500;
    }
    
    public float m_20236_(final Pose pose) {
        return this.m_20206_() * 0.6f;
    }
    
    public MobType m_6336_() {
        return MobType.f_21642_;
    }
    
    public void doBreathAttack(final Entity target) {
        if (!target.m_5825_() && target.m_6469_(TFDamageSources.scorched((LivingEntity)this), 2.0f)) {
            target.m_20254_(10);
        }
    }
    
    public boolean m_7327_(final Entity entityIn) {
        if (this.isBreathing()) {
            entityIn.m_6469_(TFDamageSources.scorched((LivingEntity)this), 2.0f);
        }
        return super.m_7327_(entityIn);
    }
    
    static {
        BREATHING = SynchedEntityData.m_135353_((Class)FireBeetle.class, EntityDataSerializers.f_135035_);
    }
}
