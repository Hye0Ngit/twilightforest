// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvents;
import twilightforest.entity.projectile.NatureBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.FleeSunGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RestrictSunGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.ITFCharger;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;

public class Adherent extends Monster implements RangedAttackMob, ITFCharger
{
    private static final EntityDataAccessor<Boolean> CHARGE_FLAG;
    
    public Adherent(final EntityType<? extends Adherent> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(2, (Goal)new RestrictSunGoal((PathfinderMob)this));
        this.f_21345_.m_25352_(3, (Goal)new FleeSunGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(4, (Goal)new RangedAttackGoal((RangedAttackMob)this, 1.0, 60, 10.0f));
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)Adherent.CHARGE_FLAG, (Object)false);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 20.0).m_22268_(Attributes.f_22279_, 0.25);
    }
    
    public void m_6504_(final LivingEntity attackTarget, final float extraDamage) {
        final NatureBolt natureBolt = new NatureBolt(this.f_19853_, (LivingEntity)this);
        this.m_5496_(SoundEvents.f_11923_, 1.0f, 1.0f / (this.f_19796_.nextFloat() * 0.4f + 0.8f));
        final double d0 = attackTarget.m_20186_() + attackTarget.m_20192_() - 1.100000023841858;
        final double d2 = attackTarget.m_20185_() - this.m_20185_();
        final double d3 = d0 - natureBolt.m_20186_();
        final double d4 = attackTarget.m_20189_() - this.m_20189_();
        final float f = Mth.m_14116_((float)(d2 * d2 + d4 * d4)) * 0.2f;
        natureBolt.m_6686_(d2, d3 + f, d4, 0.6f, (float)(10 - this.f_19853_.m_46791_().m_19028_() * 4));
        this.f_19853_.m_7967_((Entity)natureBolt);
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean isCharging() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)Adherent.CHARGE_FLAG);
    }
    
    public void setCharging(final boolean flag) {
        this.f_19804_.m_135381_((EntityDataAccessor)Adherent.CHARGE_FLAG, (Object)flag);
    }
    
    static {
        CHARGE_FLAG = SynchedEntityData.m_135353_((Class)Adherent.class, EntityDataSerializers.f_135035_);
    }
}
