// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.tags.Tag;
import twilightforest.data.EntityTagGenerator;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.PathfinderMob;
import twilightforest.entity.ai.ChargeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.IHostileMount;
import net.minecraft.world.entity.monster.Monster;

public class PinchBeetle extends Monster implements IHostileMount
{
    public PinchBeetle(final EntityType<? extends PinchBeetle> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(2, (Goal)new ChargeAttackGoal((PathfinderMob)this, 1.5f, false));
        this.f_21345_.m_25352_(4, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 40.0).m_22268_(Attributes.f_22279_, 0.23).m_22268_(Attributes.f_22281_, 4.0).m_22268_(Attributes.f_22284_, 2.0);
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.PINCH_BEETLE_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.PINCH_BEETLE_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.PINCH_BEETLE_STEP, 0.15f, 1.0f);
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (!this.m_20197_().isEmpty()) {
            this.m_21563_().m_24960_((Entity)this.m_20197_().get(0), 100.0f, 100.0f);
        }
    }
    
    public boolean m_7327_(final Entity entity) {
        if (this.m_20197_().isEmpty()) {
            final Entity v = entity.m_20202_();
            if (v == null || !v.m_6095_().m_20609_((Tag)EntityTagGenerator.RIDES_OBSTRUCT_SNATCHING)) {
                entity.m_8127_();
                entity.m_7998_((Entity)this, true);
            }
        }
        entity.m_6469_(TFDamageSources.clamped((LivingEntity)this), (float)this.m_21133_(Attributes.f_22281_));
        return super.m_7327_(entity);
    }
    
    public float m_20236_(final Pose pose) {
        return 0.25f;
    }
    
    public void m_7332_(final Entity passenger) {
        if (!this.m_20197_().isEmpty()) {
            final Vec3 riderPos = this.getRiderPosition();
            this.m_20197_().get(0).m_6034_(riderPos.f_82479_, riderPos.f_82480_, riderPos.f_82481_);
        }
    }
    
    public double m_6048_() {
        return 0.75;
    }
    
    private Vec3 getRiderPosition() {
        if (!this.m_20197_().isEmpty()) {
            final float distance = 0.9f;
            final double dx = Math.cos((this.m_146908_() + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double dz = Math.sin((this.m_146908_() + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return new Vec3(this.m_20185_() + dx, this.m_20186_() + this.m_6048_() + this.m_20197_().get(0).m_6049_(), this.m_20189_() + dz);
        }
        return new Vec3(this.m_20185_(), this.m_20186_(), this.m_20189_());
    }
    
    public boolean canRiderInteract() {
        return true;
    }
    
    public EntityDimensions m_6972_(final Pose pose) {
        if (!this.m_20197_().isEmpty()) {
            return EntityDimensions.m_20395_(1.9f, 2.0f);
        }
        return super.m_6972_(pose);
    }
}
