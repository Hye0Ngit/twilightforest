// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.TFEntities;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
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
import twilightforest.entity.ai.RiderSpearAttackGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.monster.Monster;

public class LowerGoblinKnight extends Monster
{
    private static final EntityDataAccessor<Boolean> ARMOR;
    private static final AttributeModifier ARMOR_MODIFIER;
    
    public LowerGoblinKnight(final EntityType<? extends LowerGoblinKnight> type, final Level world) {
        super((EntityType)type, world);
        this.setHasArmor(true);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new RiderSpearAttackGoal(this));
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, false));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 20.0).m_22268_(Attributes.f_22279_, 0.28).m_22268_(Attributes.f_22281_, 4.0);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)LowerGoblinKnight.ARMOR, (Object)false);
    }
    
    public boolean hasArmor() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)LowerGoblinKnight.ARMOR);
    }
    
    private void setHasArmor(final boolean flag) {
        this.f_19804_.m_135381_((EntityDataAccessor)LowerGoblinKnight.ARMOR, (Object)flag);
        if (!this.f_19853_.f_46443_) {
            if (flag) {
                if (!this.m_21051_(Attributes.f_22284_).m_22109_(LowerGoblinKnight.ARMOR_MODIFIER)) {
                    this.m_21051_(Attributes.f_22284_).m_22118_(LowerGoblinKnight.ARMOR_MODIFIER);
                }
            }
            else {
                this.m_21051_(Attributes.f_22284_).m_22130_(LowerGoblinKnight.ARMOR_MODIFIER);
            }
        }
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128379_("hasArmor", this.hasArmor());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setHasArmor(compound.m_128471_("hasArmor"));
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable SpawnGroupData livingData, @Nullable final CompoundTag dataTag) {
        livingData = super.m_6518_(worldIn, difficulty, reason, livingData, dataTag);
        final UpperGoblinKnight upper = new UpperGoblinKnight(TFEntities.UPPER_GOBLIN_KNIGHT, this.f_19853_);
        upper.m_7678_(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_146908_(), 0.0f);
        upper.m_6518_(worldIn, difficulty, MobSpawnType.NATURAL, livingData, dataTag);
        upper.m_20329_((Entity)this);
        return livingData;
    }
    
    public double m_6048_() {
        return 1.0;
    }
    
    public void m_8024_() {
        if (this.m_20160_() && this.m_20197_().get(0) instanceof LivingEntity && this.m_5448_() == null) {
            this.m_6710_(this.m_20197_().get(0).m_5448_());
        }
        if (this.m_5448_() instanceof Player && ((Player)this.m_5448_()).m_150110_().f_35934_) {
            this.m_6710_((LivingEntity)null);
        }
        super.m_8024_();
    }
    
    public boolean m_7327_(final Entity entity) {
        if (this.m_20160_() && this.m_20197_().get(0) instanceof LivingEntity) {
            return this.m_20197_().get(0).m_7327_(entity);
        }
        return super.m_7327_(entity);
    }
    
    @Nullable
    protected SoundEvent m_7515_() {
        return this.m_20160_() ? TFSounds.GOBLIN_KNIGHT_MUFFLED_AMBIENT : TFSounds.GOBLIN_KNIGHT_AMBIENT;
    }
    
    protected SoundEvent m_5592_() {
        return this.m_20160_() ? TFSounds.GOBLIN_KNIGHT_MUFFLED_DEATH : TFSounds.GOBLIN_KNIGHT_DEATH;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return this.m_20160_() ? TFSounds.GOBLIN_KNIGHT_MUFFLED_HURT : TFSounds.GOBLIN_KNIGHT_HURT;
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        Entity attacker = null;
        if (source.m_7639_() != null) {
            attacker = source.m_7639_();
        }
        if (source.m_7639_() != null) {
            attacker = source.m_7639_();
        }
        if (attacker != null && !source.m_19390_()) {
            final double dx = this.m_20185_() - attacker.m_20185_();
            final double dz = this.m_20189_() - attacker.m_20189_();
            final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
            final float difference = Mth.m_14154_((this.f_20883_ - angle) % 360.0f);
            UpperGoblinKnight upper = null;
            if (this.m_20160_() && this.m_20197_().get(0) instanceof UpperGoblinKnight) {
                upper = this.m_20197_().get(0);
            }
            if (upper != null && upper.hasShield() && difference > 150.0f && difference < 230.0f && upper.takeHitOnShield(source, amount)) {
                return false;
            }
            if (this.hasArmor() && (difference > 300.0f || difference < 60.0f)) {
                this.breakArmor();
            }
        }
        return super.m_6469_(source, amount);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 5) {
            final ItemStack broken = new ItemStack((ItemLike)Items.f_42469_);
            this.m_21278_(broken);
            this.m_21278_(broken);
            this.m_21278_(broken);
        }
        else {
            super.m_7822_(id);
        }
    }
    
    private void breakArmor() {
        this.f_19853_.m_7605_((Entity)this, (byte)5);
        this.setHasArmor(false);
    }
    
    static {
        ARMOR = SynchedEntityData.m_135353_((Class)LowerGoblinKnight.class, EntityDataSerializers.f_135035_);
        ARMOR_MODIFIER = new AttributeModifier("Armor boost", 17.0, AttributeModifier.Operation.ADDITION);
    }
}
