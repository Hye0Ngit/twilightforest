// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.projectile.TomeBoltEntity;
import net.minecraft.entity.LivingEntity;
import javax.annotation.Nullable;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.Entity;
import net.minecraft.loot.LootContext;
import twilightforest.loot.TFTreasure;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.ai.attributes.Attributes;
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
import net.minecraft.entity.monster.MonsterEntity;

public class DeathTomeEntity extends MonsterEntity implements IRangedAttackMob
{
    public DeathTomeEntity(final EntityType<? extends DeathTomeEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(4, (Goal)new RangedAttackGoal((IRangedAttackMob)this, 1.0, 100, 5.0f));
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 30.0).func_233815_a_(Attributes.field_233821_d_, 0.25).func_233815_a_(Attributes.field_233823_f_, 4.0);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        for (int i = 0; i < 1; ++i) {
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197623_p, this.func_226277_ct_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextDouble() * (this.func_213302_cg() - 0.75) + 0.5, this.func_226281_cx_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf(), 0.0, 0.5, 0.0);
        }
    }
    
    public boolean func_70097_a(final DamageSource src, float damage) {
        if (src.func_76347_k()) {
            damage *= 2.0f;
        }
        if (super.func_70097_a(src, damage)) {
            if (!this.field_70170_p.field_72995_K) {
                final LootContext ctx = this.func_213363_a(true, src).func_216022_a(LootParameterSets.field_216263_d);
                this.field_70170_p.func_73046_m().func_200249_aQ().func_186521_a(TFTreasure.DEATH_TOME_HURT).func_216120_b(ctx, s -> this.func_70099_a(s, 1.0f));
            }
            return true;
        }
        return false;
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    @Nullable
    protected SoundEvent func_184639_G() {
        return TFSounds.TOME_IDLE;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.TOME_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.TOME_DEATH;
    }
    
    public void func_82196_d(final LivingEntity target, final float distanceFactor) {
        final ThrowableEntity projectile = new TomeBoltEntity(TFEntities.tome_bolt, this.field_70170_p, (LivingEntity)this);
        final double tx = target.func_226277_ct_() - this.func_226277_ct_();
        final double ty = target.func_226278_cu_() + target.func_70047_e() - 1.100000023841858 - projectile.func_226278_cu_();
        final double tz = target.func_226281_cx_() - this.func_226281_cx_();
        final float heightOffset = MathHelper.func_76133_a(tx * tx + tz * tz) * 0.2f;
        projectile.func_70186_c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
        this.field_70170_p.func_217376_c((Entity)projectile);
    }
}
