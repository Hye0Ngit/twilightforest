// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.util.Mth;
import twilightforest.entity.projectile.TomeBolt;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.LivingEntity;
import javax.annotation.Nullable;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.LootContext;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;

public class DeathTome extends Monster implements RangedAttackMob
{
    public DeathTome(final EntityType<? extends DeathTome> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(4, (Goal)new RangedAttackGoal((RangedAttackMob)this, 1.0, 100, 5.0f));
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22279_, 0.25).m_22268_(Attributes.f_22281_, 4.0);
    }
    
    public void m_8107_() {
        super.m_8107_();
        final Vec3 vel = this.m_20184_();
        if (!this.f_19861_ && vel.f_82480_ < 0.0) {
            this.m_20256_(vel.m_82542_(1.0, 0.6, 1.0));
        }
        for (int i = 0; i < 1; ++i) {
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123809_, this.m_20185_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_(), this.m_20186_() + this.f_19796_.nextDouble() * (this.m_20206_() - 0.75) + 0.5, this.m_20189_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_(), 0.0, 0.5, 0.0);
        }
    }
    
    public boolean m_142535_(final float p_147187_, final float p_147188_, final DamageSource p_147189_) {
        return false;
    }
    
    public boolean m_6469_(final DamageSource src, float damage) {
        if (src.m_19384_()) {
            damage *= 2.0f;
        }
        if (super.m_6469_(src, damage)) {
            if (damage > 0.0f && !this.f_19853_.f_46443_) {
                final LootContext ctx = this.m_7771_(true, src).m_78975_(LootContextParamSets.f_81415_);
                this.f_19853_.m_142572_().m_129898_().m_79217_(TFTreasure.DEATH_TOME_HURT).m_79148_(ctx, s -> this.m_5552_(s, 1.0f));
            }
            return true;
        }
        return false;
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    @Nullable
    protected SoundEvent m_7515_() {
        return TFSounds.TOME_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.TOME_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.TOME_DEATH;
    }
    
    public void m_6504_(final LivingEntity target, final float distanceFactor) {
        final ThrowableProjectile projectile = new TomeBolt(TFEntities.TOME_BOLT, this.f_19853_, (LivingEntity)this);
        final double tx = target.m_20185_() - this.m_20185_();
        final double ty = target.m_20186_() + target.m_20192_() - 1.100000023841858 - projectile.m_20186_();
        final double tz = target.m_20189_() - this.m_20189_();
        final float heightOffset = Mth.m_14116_((float)(tx * tx + tz * tz)) * 0.2f;
        projectile.m_6686_(tx, ty + heightOffset, tz, 0.6f, 6.0f);
        this.f_19853_.m_7967_((Entity)projectile);
    }
}
