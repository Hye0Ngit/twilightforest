// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.RedcapLightTNTGoal;
import twilightforest.entity.ai.RedcapShyGoal;
import net.minecraft.world.entity.PathfinderMob;
import twilightforest.entity.ai.AvoidAnyEntityGoal;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Monster;

public class Redcap extends Monster
{
    public ItemStack heldPick;
    public ItemStack heldTNT;
    public ItemStack heldFlint;
    
    public Redcap(final EntityType<? extends Redcap> type, final Level world) {
        super((EntityType)type, world);
        this.heldPick = new ItemStack((ItemLike)Items.f_42385_);
        this.heldTNT = new ItemStack((ItemLike)Blocks.f_50077_);
        this.heldFlint = new ItemStack((ItemLike)Items.f_42409_);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new AvoidAnyEntityGoal<Object>((PathfinderMob)this, PrimedTnt.class, 2.0f, 1.0, 2.0));
        this.f_21345_.m_25352_(2, (Goal)new RedcapShyGoal(this, 1.0f));
        this.f_21345_.m_25352_(3, (Goal)new RedcapLightTNTGoal(this, 1.0f));
        this.f_21345_.m_25352_(5, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 20.0).m_22268_(Attributes.f_22279_, 0.28);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.REDCAP_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.REDCAP_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.REDCAP_DEATH;
    }
    
    public boolean isShy() {
        return this.f_20889_ <= 0;
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable final SpawnGroupData spawnDataIn, @Nullable final CompoundTag dataTag) {
        final SpawnGroupData data = super.m_6518_(worldIn, difficulty, reason, spawnDataIn, dataTag);
        this.m_6851_(difficulty);
        this.m_6850_(difficulty);
        this.m_21409_(EquipmentSlot.MAINHAND, 0.2f);
        this.m_21409_(EquipmentSlot.FEET, 0.2f);
        return data;
    }
    
    protected void m_6851_(final DifficultyInstance difficulty) {
        this.m_8061_(EquipmentSlot.MAINHAND, this.heldPick);
        this.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)Items.f_42471_));
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128405_("TNTLeft", this.heldTNT.m_41613_());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.heldTNT.m_41764_(compound.m_128451_("TNTLeft"));
    }
}
