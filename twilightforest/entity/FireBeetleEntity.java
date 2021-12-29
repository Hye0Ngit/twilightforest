// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Pose;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.BreathAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.MonsterEntity;

public class FireBeetleEntity extends MonsterEntity implements IBreathAttacker
{
    private static final DataParameter<Boolean> BREATHING;
    private static final int BREATH_DURATION = 10;
    private static final int BREATH_DAMAGE = 2;
    
    public FireBeetleEntity(final EntityType<? extends FireBeetleEntity> type, final World world) {
        super((EntityType)type, world);
        this.func_230279_az_();
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(2, (Goal)new BreathAttackGoal<Object>(this, 5.0f, 30, 0.1f));
        this.field_70714_bg.func_75776_a(3, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)FireBeetleEntity.BREATHING, (Object)false);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 25.0).func_233815_a_(Attributes.field_233821_d_, 0.23).func_233815_a_(Attributes.field_233823_f_, 4.0);
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.FIRE_BEETLE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.FIRE_BEETLE_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.FIRE_BEETLE_STEP, 0.15f, 1.0f);
    }
    
    public boolean isBreathing() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)FireBeetleEntity.BREATHING);
    }
    
    public void setBreathing(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)FireBeetleEntity.BREATHING, (Object)flag);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isBreathing()) {
            final Vector3d look = this.func_70040_Z();
            final double dist = 0.9;
            final double px = this.func_226277_ct_() + look.field_72450_a * dist;
            final double py = this.func_226278_cu_() + 0.25 + look.field_72448_b * dist;
            final double pz = this.func_226281_cx_() + look.field_72449_c * dist;
            for (int i = 0; i < 2; ++i) {
                double dx = look.field_72450_a;
                double dy = look.field_72448_b;
                double dz = look.field_72449_c;
                final double spread = 5.0 + this.func_70681_au().nextDouble() * 2.5;
                final double velocity = 0.15 + this.func_70681_au().nextDouble() * 0.15;
                dx += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dy += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dz += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197631_x, px, py, pz, dx, dy, dz);
            }
            this.func_184185_a(TFSounds.FIRE_BEETLE_SHOOT, this.field_70146_Z.nextFloat() * 0.5f, this.field_70146_Z.nextFloat() * 0.5f);
        }
    }
    
    public float func_70013_c() {
        if (this.isBreathing()) {
            return 1.572888E7f;
        }
        return super.func_70013_c();
    }
    
    public int func_70646_bf() {
        return 500;
    }
    
    public float func_213307_e(final Pose pose) {
        return this.func_213302_cg() * 0.6f;
    }
    
    public CreatureAttribute func_70668_bt() {
        return CreatureAttribute.field_223224_c_;
    }
    
    public void doBreathAttack(final Entity target) {
        if (!target.func_230279_az_() && target.func_70097_a(TFDamageSources.SCORCHED((LivingEntity)this), 2.0f)) {
            target.func_70015_d(10);
        }
    }
    
    public boolean func_70652_k(final Entity entityIn) {
        if (this.isBreathing()) {
            entityIn.func_70097_a(TFDamageSources.SCORCHED((LivingEntity)this), 2.0f);
        }
        return super.func_70652_k(entityIn);
    }
    
    static {
        BREATHING = EntityDataManager.func_187226_a((Class)FireBeetleEntity.class, DataSerializers.field_187198_h);
    }
}
