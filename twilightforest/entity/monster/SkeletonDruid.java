// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import twilightforest.entity.projectile.NatureBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import java.util.UUID;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;

public class SkeletonDruid extends AbstractSkeleton
{
    private RangedAttackGoal rangedAttackGoal;
    private static final UUID SPEED_MODIFIER_BABY_UUID;
    private static final AttributeModifier SPEED_MODIFIER_BABY;
    private static final EntityDataAccessor<Boolean> DATA_BABY_ID;
    
    public SkeletonDruid(final EntityType<? extends SkeletonDruid> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        super.m_8099_();
        this.rangedAttackGoal = new RangedAttackGoal((RangedAttackMob)this, 1.25, 60, 5.0f);
        this.f_21345_.m_25352_(4, (Goal)this.rangedAttackGoal);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.m_20088_().m_135372_((EntityDataAccessor)SkeletonDruid.DATA_BABY_ID, (Object)false);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.SKELETON_DRUID_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.SKELETON_DRUID_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.SKELETON_DRUID_DEATH;
    }
    
    protected SoundEvent m_7878_() {
        return TFSounds.SKELETON_DRUID_STEP;
    }
    
    public void m_32164_() {
        if (this.f_19853_ != null && !this.f_19853_.f_46443_) {
            this.f_21345_.m_25363_((Goal)this.rangedAttackGoal);
            if (this.m_21120_(InteractionHand.MAIN_HAND).m_41720_() instanceof HoeItem) {
                this.f_21345_.m_25352_(4, (Goal)this.rangedAttackGoal);
            }
            else {
                super.m_32164_();
            }
        }
        else {
            super.m_32164_();
        }
    }
    
    protected void m_6851_(final DifficultyInstance difficulty) {
        if (this.m_6162_()) {
            this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42398_));
        }
        else {
            this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42434_));
        }
    }
    
    public void m_6504_(final LivingEntity attackTarget, final float extraDamage) {
        if (this.m_21120_(InteractionHand.MAIN_HAND).m_41720_() instanceof HoeItem) {
            final NatureBolt natureBolt = new NatureBolt(this.f_19853_, (LivingEntity)this);
            this.m_5496_(TFSounds.SKELETON_DRUID_SHOOT, 1.0f, 1.0f / (this.f_19796_.nextFloat() * 0.4f + 0.8f));
            final double tx = attackTarget.m_20185_() - this.m_20185_();
            final double ty = attackTarget.m_20186_() + attackTarget.m_20192_() - 2.699999988079071 - this.m_20186_();
            final double tz = attackTarget.m_20189_() - this.m_20189_();
            final float heightOffset = Mth.m_14116_((float)(tx * tx + tz * tz)) * 0.2f;
            natureBolt.m_6686_(tx, ty + heightOffset, tz, 0.6f, 6.0f);
            this.f_19853_.m_7967_((Entity)natureBolt);
        }
        else if (!Items.f_42398_.equals(this.m_21120_(InteractionHand.MAIN_HAND).m_41720_())) {
            super.m_6504_(attackTarget, extraDamage);
        }
    }
    
    public static boolean skeletonDruidSpawnHandler(final EntityType<? extends SkeletonDruid> entity, final LevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        return world.m_46791_() != Difficulty.PEACEFUL && isValidLightLevel(world, pos, random) && m_21400_((EntityType)entity, world, reason, pos, random);
    }
    
    public static boolean isValidLightLevel(final LevelAccessor world, final BlockPos pos, final Random random) {
        if (world.m_45517_(LightLayer.SKY, pos) > random.nextInt(32)) {
            return false;
        }
        final int i = world.m_46803_(pos);
        return i <= random.nextInt(12);
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128379_("IsBaby", this.m_6162_());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.m_6863_(compound.m_128471_("IsBaby"));
    }
    
    public boolean m_6162_() {
        return (boolean)this.m_20088_().m_135370_((EntityDataAccessor)SkeletonDruid.DATA_BABY_ID);
    }
    
    protected int m_6552_(final Player player) {
        if (this.m_6162_()) {
            this.f_21364_ *= (int)2.5f;
        }
        return super.m_6552_(player);
    }
    
    public void m_6863_(final boolean shouldBaby) {
        this.m_20088_().m_135381_((EntityDataAccessor)SkeletonDruid.DATA_BABY_ID, (Object)shouldBaby);
        if (this.f_19853_ != null && !this.f_19853_.f_46443_) {
            final AttributeInstance attributeinstance = this.m_21051_(Attributes.f_22279_);
            attributeinstance.m_22130_(SkeletonDruid.SPEED_MODIFIER_BABY);
            if (shouldBaby) {
                attributeinstance.m_22118_(SkeletonDruid.SPEED_MODIFIER_BABY);
            }
        }
    }
    
    public void m_7350_(final EntityDataAccessor<?> dataAccessor) {
        if (SkeletonDruid.DATA_BABY_ID.equals((Object)dataAccessor)) {
            this.m_6210_();
        }
        super.m_7350_((EntityDataAccessor)dataAccessor);
    }
    
    public double m_6049_() {
        return this.m_6162_() ? -0.35 : -0.6;
    }
    
    protected float m_6431_(final Pose pose, final EntityDimensions size) {
        return this.m_6162_() ? 0.93f : super.m_6431_(pose, size);
    }
    
    static {
        SPEED_MODIFIER_BABY_UUID = UUID.fromString("3F508BEA-92F5-47B3-BCA2-B0FA84860574");
        SPEED_MODIFIER_BABY = new AttributeModifier(SkeletonDruid.SPEED_MODIFIER_BABY_UUID, "Baby speed boost", 0.5, AttributeModifier.Operation.MULTIPLY_BASE);
        DATA_BABY_ID = SynchedEntityData.m_135353_((Class)SkeletonDruid.class, EntityDataSerializers.f_135035_);
    }
}
