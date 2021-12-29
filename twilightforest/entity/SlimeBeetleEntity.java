// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.projectile.SlimeProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Pose;
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
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.MonsterEntity;

public class SlimeBeetleEntity extends MonsterEntity implements IRangedAttackMob
{
    public SlimeBeetleEntity(final EntityType<? extends SlimeBeetleEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(2, (Goal)new AvoidEntityGoal((CreatureEntity)this, (Class)PlayerEntity.class, 3.0f, 1.25, 2.0));
        this.field_70714_bg.func_75776_a(3, (Goal)new RangedAttackGoal((IRangedAttackMob)this, 1.0, 30, 10.0f));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 25.0).func_233815_a_(Attributes.field_233821_d_, 0.23).func_233815_a_(Attributes.field_233823_f_, 4.0);
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.SLIME_BEETLE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.SLIME_BEETLE_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.SLIME_BEETLE_STEP, 0.15f, 1.0f);
    }
    
    public float func_213307_e(final Pose pose) {
        return 0.25f;
    }
    
    public CreatureAttribute func_70668_bt() {
        return CreatureAttribute.field_223224_c_;
    }
    
    public void func_82196_d(final LivingEntity target, final float distanceFactor) {
        final ThrowableEntity projectile = new SlimeProjectileEntity(TFEntities.slime_blob, this.field_70170_p, (LivingEntity)this);
        this.func_184185_a(TFSounds.SLIME_BEETLE_SQUISH_SMALL, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        final double tx = target.func_226277_ct_() - this.func_226277_ct_();
        final double ty = target.func_226278_cu_() + target.func_70047_e() - 1.100000023841858 - projectile.func_226278_cu_();
        final double tz = target.func_226281_cx_() - this.func_226281_cx_();
        final float heightOffset = MathHelper.func_76133_a(tx * tx + tz * tz) * 0.2f;
        projectile.func_70186_c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
        this.field_70170_p.func_217376_c((Entity)projectile);
    }
}
