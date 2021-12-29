// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.phys.Vec3;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import twilightforest.entity.ai.HeavySpearAttackGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.monster.Monster;

public class UpperGoblinKnight extends Monster
{
    private static final int SHIELD_DAMAGE_THRESHOLD = 10;
    private static final EntityDataAccessor<Byte> DATA_EQUIP;
    private static final AttributeModifier ARMOR_MODIFIER;
    private static final AttributeModifier DAMAGE_MODIFIER;
    public static final int HEAVY_SPEAR_TIMER_START = 60;
    private int shieldHits;
    public int heavySpearTimer;
    
    public UpperGoblinKnight(final EntityType<? extends UpperGoblinKnight> type, final Level world) {
        super((EntityType)type, world);
        this.shieldHits = 0;
        this.setHasArmor(true);
        this.setHasShield(true);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new HeavySpearAttackGoal(this));
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, false));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22279_, 0.28).m_22268_(Attributes.f_22281_, 8.0);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)UpperGoblinKnight.DATA_EQUIP, (Object)0);
    }
    
    public boolean hasArmor() {
        return ((byte)this.f_19804_.m_135370_((EntityDataAccessor)UpperGoblinKnight.DATA_EQUIP) & 0x1) > 0;
    }
    
    private void setHasArmor(final boolean flag) {
        final byte otherFlags = (byte)this.f_19804_.m_135370_((EntityDataAccessor)UpperGoblinKnight.DATA_EQUIP);
        this.f_19804_.m_135381_((EntityDataAccessor)UpperGoblinKnight.DATA_EQUIP, (Object)(flag ? ((byte)(otherFlags | 0x1)) : ((byte)(otherFlags & 0xFFFFFFFE))));
        if (!this.f_19853_.f_46443_) {
            if (flag) {
                if (!this.m_21051_(Attributes.f_22284_).m_22109_(UpperGoblinKnight.ARMOR_MODIFIER)) {
                    this.m_21051_(Attributes.f_22284_).m_22118_(UpperGoblinKnight.ARMOR_MODIFIER);
                }
            }
            else {
                this.m_21051_(Attributes.f_22284_).m_22130_(UpperGoblinKnight.ARMOR_MODIFIER);
            }
        }
    }
    
    public boolean hasShield() {
        return ((byte)this.f_19804_.m_135370_((EntityDataAccessor)UpperGoblinKnight.DATA_EQUIP) & 0x2) > 0;
    }
    
    public void setHasShield(final boolean flag) {
        final byte otherFlags = (byte)this.f_19804_.m_135370_((EntityDataAccessor)UpperGoblinKnight.DATA_EQUIP);
        this.f_19804_.m_135381_((EntityDataAccessor)UpperGoblinKnight.DATA_EQUIP, (Object)(flag ? ((byte)(otherFlags | 0x2)) : ((byte)(otherFlags & 0xFFFFFFFD))));
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128379_("hasArmor", this.hasArmor());
        compound.m_128379_("hasShield", this.hasShield());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setHasArmor(compound.m_128471_("hasArmor"));
        this.setHasShield(compound.m_128471_("hasShield"));
    }
    
    public void m_8107_() {
        super.m_8107_();
        if ((this.f_19853_.f_46443_ || !this.m_21525_()) && this.heavySpearTimer > 0) {
            --this.heavySpearTimer;
        }
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.GOBLIN_KNIGHT_AMBIENT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.GOBLIN_KNIGHT_DEATH;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.GOBLIN_KNIGHT_HURT;
    }
    
    public void m_8024_() {
        super.m_8024_();
        if (this.m_6084_()) {
            if (this.m_20202_() instanceof LivingEntity && this.m_5448_() == null) {
                this.m_6710_(((Mob)this.m_20202_()).m_5448_());
            }
            if (this.m_5448_() instanceof Player && ((Player)this.m_5448_()).m_150110_().f_35934_) {
                this.m_6710_((LivingEntity)null);
            }
            if (!this.m_20159_() && this.hasShield()) {
                this.breakShield();
            }
            if (this.heavySpearTimer > 0) {
                if (!this.m_21051_(Attributes.f_22281_).m_22109_(UpperGoblinKnight.DAMAGE_MODIFIER)) {
                    this.m_21051_(Attributes.f_22281_).m_22118_(UpperGoblinKnight.DAMAGE_MODIFIER);
                }
            }
            else {
                this.m_21051_(Attributes.f_22281_).m_22120_(UpperGoblinKnight.DAMAGE_MODIFIER.m_22209_());
            }
        }
    }
    
    public void landHeavySpearAttack() {
        final Vec3 vector = this.m_20154_();
        final double dist = 1.25;
        final double px = this.m_20185_() + vector.f_82479_ * dist;
        final double py = this.m_142469_().f_82289_ - 0.75;
        final double pz = this.m_20189_() + vector.f_82481_ * dist;
        for (int i = 0; i < 50; ++i) {
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123755_, px, py, pz, (double)((this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.25f), 0.0, (double)((this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.25f));
        }
        final double radius = 1.5;
        final AABB spearBB = new AABB(px - radius, py - radius, pz - radius, px + radius, py + radius, pz + radius);
        final List<Entity> inBox = this.f_19853_.m_6249_((Entity)this, spearBB, e -> e != this.m_20202_());
        for (final Entity entity : inBox) {
            super.m_7327_(entity);
        }
        if (!inBox.isEmpty()) {
            this.m_5496_(SoundEvents.f_12313_, this.m_6121_(), this.m_6100_());
        }
    }
    
    public void m_6083_() {
        super.m_6083_();
        if (this.m_20202_() instanceof final LivingEntity livingEntity) {
            this.f_20883_ = livingEntity.f_20883_;
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 4) {
            this.heavySpearTimer = 60;
        }
        else if (id == 5) {
            final ItemStack broken = new ItemStack((ItemLike)Items.f_42469_);
            this.m_21278_(broken);
            this.m_21278_(broken);
            this.m_21278_(broken);
        }
        else {
            super.m_7822_(id);
        }
    }
    
    public boolean m_7327_(final Entity entity) {
        if (this.heavySpearTimer > 0) {
            return false;
        }
        if (this.f_19796_.nextInt(2) == 0) {
            this.heavySpearTimer = 60;
            this.f_19853_.m_7605_((Entity)this, (byte)4);
            return false;
        }
        this.m_6674_(InteractionHand.MAIN_HAND);
        return super.m_7327_(entity);
    }
    
    public boolean m_6469_(final DamageSource damageSource, final float amount) {
        if (damageSource == DamageSource.f_19310_ && this.m_20202_() != null) {
            return false;
        }
        final Entity attacker = damageSource.m_7639_();
        if (attacker != null && !damageSource.m_19390_()) {
            final double dx = this.m_20185_() - attacker.m_20185_();
            final double dz = this.m_20189_() - attacker.m_20189_();
            final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
            final float difference = Mth.m_14154_((this.f_20883_ - angle) % 360.0f);
            if (this.hasShield() && difference > 150.0f && difference < 230.0f) {
                if (this.takeHitOnShield(damageSource, amount)) {
                    return false;
                }
            }
            else if (this.hasShield() && this.f_19796_.nextBoolean()) {
                this.damageShield();
            }
            if (this.hasArmor() && (difference > 300.0f || difference < 60.0f)) {
                this.breakArmor();
            }
        }
        return super.m_6469_(damageSource, amount);
    }
    
    private void breakArmor() {
        this.f_19853_.m_7605_((Entity)this, (byte)5);
        this.setHasArmor(false);
    }
    
    private void breakShield() {
        this.f_19853_.m_7605_((Entity)this, (byte)5);
        this.setHasShield(false);
    }
    
    public boolean takeHitOnShield(final DamageSource source, final float amount) {
        if (amount > 10.0f && !this.f_19853_.f_46443_) {
            this.damageShield();
        }
        else {
            this.m_5496_(SoundEvents.f_12018_, 1.0f, ((this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        }
        final LivingEntity toKnockback = (LivingEntity)((this.m_20202_() instanceof LivingEntity) ? ((LivingEntity)this.m_20202_()) : this);
        if (source.m_7639_() != null) {
            double d0;
            double d2;
            for (d0 = source.m_7639_().m_20185_() - this.m_20185_(), d2 = source.m_7639_().m_20189_() - this.m_20189_(); d0 * d0 + d2 * d2 < 1.0E-4; d0 = (Math.random() - Math.random()) * 0.01, d2 = (Math.random() - Math.random()) * 0.01) {}
            toKnockback.m_147240_(0.0, d0 / 4.0, d2 / 4.0);
            if (source.m_7639_() instanceof final LivingEntity livingEntity) {
                this.m_6703_(livingEntity);
            }
        }
        return true;
    }
    
    private void damageShield() {
        this.m_5496_(SoundEvents.f_12600_, 0.25f, 0.25f);
        ++this.shieldHits;
        if (!this.f_19853_.f_46443_ && this.shieldHits >= 3) {
            this.breakShield();
        }
    }
    
    static {
        DATA_EQUIP = SynchedEntityData.m_135353_((Class)UpperGoblinKnight.class, EntityDataSerializers.f_135027_);
        ARMOR_MODIFIER = new AttributeModifier("Armor boost", 20.0, AttributeModifier.Operation.ADDITION);
        DAMAGE_MODIFIER = new AttributeModifier("Heavy spear attack boost", 12.0, AttributeModifier.Operation.ADDITION);
    }
}
