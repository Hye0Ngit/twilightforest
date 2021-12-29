// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class CarminiteGhastling extends CarminiteGhastguard
{
    private boolean isMinion;
    
    public CarminiteGhastling(final EntityType<? extends CarminiteGhastling> type, final Level world) {
        super(type, world);
        this.isMinion = false;
        this.wanderFactor = 4.0f;
    }
    
    @Override
    public int m_5792_() {
        return 16;
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return CarminiteGhastguard.registerAttributes().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22277_, 16.0);
    }
    
    protected float m_6431_(final Pose poseIn, final EntityDimensions sizeIn) {
        return 0.5f;
    }
    
    @Override
    protected SoundEvent m_7515_() {
        return TFSounds.GHASTLING_AMBIENT;
    }
    
    @Override
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.GHASTLING_HURT;
    }
    
    @Override
    protected SoundEvent m_5592_() {
        return TFSounds.GHASTLING_DEATH;
    }
    
    @Override
    public SoundEvent getFireSound() {
        return TFSounds.GHASTLING_SHOOT;
    }
    
    @Override
    public SoundEvent getWarnSound() {
        return TFSounds.GHASTLING_WARN;
    }
    
    @Override
    protected boolean shouldAttack(final LivingEntity living) {
        final ItemStack helmet = living.m_6844_(EquipmentSlot.HEAD);
        if (!helmet.m_41619_() && helmet.m_41720_() == Item.m_41439_(Blocks.f_50133_)) {
            return false;
        }
        if (living.m_20270_((Entity)this) <= 3.5f) {
            return living.m_142582_((Entity)this);
        }
        final Vec3 vec3d = living.m_20252_(1.0f).m_82541_();
        Vec3 vec3d2 = new Vec3(this.m_20185_() - living.m_20185_(), this.m_142469_().f_82289_ + this.m_20192_() - (living.m_20186_() + living.m_20192_()), this.m_20189_() - living.m_20189_());
        final double d0 = vec3d2.m_82553_();
        vec3d2 = vec3d2.m_82541_();
        final double d2 = vec3d.m_82526_(vec3d2);
        return d2 > 1.0 - 0.025 / d0 && living.m_142582_((Entity)this);
    }
    
    public static boolean canSpawnHere(final EntityType<CarminiteGhastling> entity, final ServerLevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        return world.m_46791_() != Difficulty.PEACEFUL && (reason == MobSpawnType.MOB_SUMMONED || Monster.m_33008_(world, pos, random)) && m_21400_((EntityType)entity, (LevelAccessor)world, reason, pos, random);
    }
    
    public void makeBossMinion() {
        this.wanderFactor = 0.005f;
        this.isMinion = true;
        this.m_21051_(Attributes.f_22276_).m_22100_(6.0);
        this.m_21153_(6.0f);
    }
    
    public boolean isMinion() {
        return this.isMinion;
    }
    
    public void m_7380_(final CompoundTag compound) {
        compound.m_128379_("isMinion", this.isMinion);
        super.m_7380_(compound);
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128471_("isMinion")) {
            this.makeBossMinion();
        }
    }
}
