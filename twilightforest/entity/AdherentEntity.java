// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.SoundEvents;
import twilightforest.entity.projectile.NatureBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.MonsterEntity;

public class AdherentEntity extends MonsterEntity implements IRangedAttackMob, ITFCharger
{
    private static final DataParameter<Boolean> CHARGE_FLAG;
    
    public AdherentEntity(final EntityType<? extends AdherentEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(2, (Goal)new RestrictSunGoal((CreatureEntity)this));
        this.field_70714_bg.func_75776_a(3, (Goal)new FleeSunGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(4, (Goal)new RangedAttackGoal((IRangedAttackMob)this, 1.0, 60, 10.0f));
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)AdherentEntity.CHARGE_FLAG, (Object)false);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 20.0).func_233815_a_(Attributes.field_233821_d_, 0.25);
    }
    
    public void func_82196_d(final LivingEntity attackTarget, final float extraDamage) {
        final NatureBoltEntity natureBolt = new NatureBoltEntity(this.field_70170_p, (LivingEntity)this);
        this.func_184185_a(SoundEvents.field_187557_bK, 1.0f, 1.0f / (this.field_70146_Z.nextFloat() * 0.4f + 0.8f));
        final double d0 = attackTarget.func_226278_cu_() + attackTarget.func_70047_e() - 1.100000023841858;
        final double d2 = attackTarget.func_226277_ct_() - this.func_226277_ct_();
        final double d3 = d0 - natureBolt.func_226278_cu_();
        final double d4 = attackTarget.func_226281_cx_() - this.func_226281_cx_();
        final float f = MathHelper.func_76133_a(d2 * d2 + d4 * d4) * 0.2f;
        natureBolt.func_70186_c(d2, d3 + f, d4, 0.6f, (float)(10 - this.field_70170_p.func_175659_aa().func_151525_a() * 4));
        this.field_70170_p.func_217376_c((Entity)natureBolt);
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean isCharging() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)AdherentEntity.CHARGE_FLAG);
    }
    
    public void setCharging(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)AdherentEntity.CHARGE_FLAG, (Object)flag);
    }
    
    static {
        CHARGE_FLAG = EntityDataManager.func_187226_a((Class)AdherentEntity.class, DataSerializers.field_187198_h);
    }
}
