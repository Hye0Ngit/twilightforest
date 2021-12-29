// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import twilightforest.entity.ai.FlockToSameKindGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.CreatureEntity;
import twilightforest.entity.ai.PanicOnFlockDeathGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.MonsterEntity;

public class KoboldEntity extends MonsterEntity
{
    private static final DataParameter<Boolean> PANICKED;
    
    public KoboldEntity(final EntityType<? extends KoboldEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new PanicOnFlockDeathGoal((CreatureEntity)this, 2.0f));
        this.field_70714_bg.func_75776_a(2, (Goal)new LeapAtTargetGoal((MobEntity)this, 0.3f));
        this.field_70714_bg.func_75776_a(3, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(4, (Goal)new FlockToSameKindGoal((MobEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)KoboldEntity.PANICKED, (Object)false);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 13.0).func_233815_a_(Attributes.field_233821_d_, 0.28).func_233815_a_(Attributes.field_233823_f_, 4.0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.KOBOLD_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.KOBOLD_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.KOBOLD_DEATH;
    }
    
    public boolean isPanicked() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)KoboldEntity.PANICKED);
    }
    
    public void setPanicked(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)KoboldEntity.PANICKED, (Object)flag);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K && this.isPanicked()) {
            for (int i = 0; i < 2; ++i) {
                this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_218422_X, this.func_226277_ct_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 0.5, this.func_226278_cu_() + this.func_70047_e(), this.func_226281_cx_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 0.5, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public int func_70641_bl() {
        return 4;
    }
    
    static {
        PANICKED = EntityDataManager.func_187226_a((Class)KoboldEntity.class, DataSerializers.field_187198_h);
    }
}
