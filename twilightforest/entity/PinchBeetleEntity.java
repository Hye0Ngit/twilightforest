// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Pose;
import net.minecraft.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.CreatureEntity;
import twilightforest.entity.ai.ChargeAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;

public class PinchBeetleEntity extends MonsterEntity implements IHostileMount
{
    public PinchBeetleEntity(final EntityType<? extends PinchBeetleEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(2, (Goal)new ChargeAttackGoal((CreatureEntity)this, 1.5f, false));
        this.field_70714_bg.func_75776_a(4, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 40.0).func_233815_a_(Attributes.field_233821_d_, 0.23).func_233815_a_(Attributes.field_233823_f_, 4.0).func_233815_a_(Attributes.field_233826_i_, 2.0);
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.PINCH_BEETLE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.PINCH_BEETLE_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.PINCH_BEETLE_STEP, 0.15f, 1.0f);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.func_184188_bt().isEmpty()) {
            this.func_70671_ap().func_75651_a((Entity)this.func_184188_bt().get(0), 100.0f, 100.0f);
            final Vector3d riderPos = this.getRiderPosition();
            this.func_213282_i(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
        }
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (this.func_184188_bt().isEmpty() && !entity.func_184218_aH()) {
            entity.func_184220_m((Entity)this);
        }
        entity.func_70097_a(TFDamageSources.CLAMPED((LivingEntity)this), (float)this.func_233637_b_(Attributes.field_233823_f_));
        return super.func_70652_k(entity);
    }
    
    public float func_213307_e(final Pose pose) {
        return 0.25f;
    }
    
    public void func_184232_k(final Entity passenger) {
        if (!this.func_184188_bt().isEmpty()) {
            final Vector3d riderPos = this.getRiderPosition();
            this.func_184188_bt().get(0).func_70107_b(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
        }
    }
    
    public double func_70042_X() {
        return 0.75;
    }
    
    private Vector3d getRiderPosition() {
        if (!this.func_184188_bt().isEmpty()) {
            final float distance = 0.9f;
            final double dx = Math.cos((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double dz = Math.sin((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return new Vector3d(this.func_226277_ct_() + dx, this.func_226278_cu_() + this.func_70042_X() + this.func_184188_bt().get(0).func_70033_W(), this.func_226281_cx_() + dz);
        }
        return new Vector3d(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
    }
    
    public boolean canRiderInteract() {
        return true;
    }
    
    public EntitySize func_213305_a(final Pose pose) {
        if (!this.func_184188_bt().isEmpty()) {
            return EntitySize.func_220314_b(1.9f, 2.0f);
        }
        return super.func_213305_a(pose);
    }
}
