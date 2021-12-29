// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.projectile.IceSnowballEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;

public class StableIceCoreEntity extends IceMobEntity implements IRangedAttackMob
{
    public StableIceCoreEntity(final EntityType<? extends StableIceCoreEntity> type, final World world) {
        super(type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new RangedAttackGoal((IRangedAttackMob)this, 1.25, 20, 10.0f));
        this.field_70714_bg.func_75776_a(2, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233821_d_, 0.23000000417232513).func_233815_a_(Attributes.field_233823_f_, 3.0);
    }
    
    public float func_213307_e(final Pose pose) {
        return this.func_213302_cg() * 0.6f;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.ICE_CORE_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.ICE_CORE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ICE_CORE_DEATH;
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    public void func_82196_d(final LivingEntity target, final float distanceFactor) {
        final IceSnowballEntity snowball = new IceSnowballEntity(this.field_70170_p, (LivingEntity)this);
        snowball.func_70107_b(this.func_226277_ct_(), this.func_226278_cu_() + this.func_70047_e(), this.func_226281_cx_());
        final double d0 = target.func_226278_cu_() + target.func_70047_e() - 1.4;
        final double d2 = target.func_226277_ct_() - this.func_226277_ct_();
        final double d3 = d0 - snowball.func_226278_cu_();
        final double d4 = target.func_226281_cx_() - this.func_226281_cx_();
        final float f = MathHelper.func_76133_a(d2 * d2 + d4 * d4) * 0.2f;
        snowball.func_70186_c(d2, d3 + f, d4, 1.6f, 6.0f);
        this.func_184185_a(TFSounds.ICE_CORE_SHOOT, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        this.field_70170_p.func_217376_c((Entity)snowball);
    }
}
