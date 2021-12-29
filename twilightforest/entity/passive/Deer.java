// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.world.entity.EntityDimensions;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;

public class Deer extends Animal
{
    public Deer(final EntityType<? extends Deer> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PanicGoal((PathfinderMob)this, 2.0));
        this.f_21345_.m_25352_(2, (Goal)new BreedGoal((Animal)this, 1.0));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 1.25, Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42405_ }), false));
        this.f_21345_.m_25352_(4, (Goal)new FollowParentGoal((Animal)this, 1.25));
        this.f_21345_.m_25352_(4, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Player.class, 16.0f, 1.5, 1.8));
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 6.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22279_, 0.2);
    }
    
    public float m_20236_(final Pose pose) {
        return this.m_20206_() * 0.7f;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.DEER_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.DEER_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.DEER_DEATH;
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState blockIn) {
    }
    
    public Deer getBreedOffspring(final ServerLevel p_241840_1_, final AgeableMob mate) {
        return (Deer)TFEntities.DEER.m_20615_(this.f_19853_);
    }
    
    protected float m_6431_(final Pose pos, final EntityDimensions size) {
        return this.m_6162_() ? (size.f_20378_ * 0.95f) : 1.65f;
    }
}
