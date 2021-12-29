// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.entity.EntitySize;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;

public class DeerEntity extends AnimalEntity
{
    public DeerEntity(final EntityType<? extends DeerEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new PanicGoal((CreatureEntity)this, 2.0));
        this.field_70714_bg.func_75776_a(2, (Goal)new BreedGoal((AnimalEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (Goal)new TemptGoal((CreatureEntity)this, 1.25, Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151015_O }), false));
        this.field_70714_bg.func_75776_a(4, (Goal)new FollowParentGoal((AnimalEntity)this, 1.25));
        this.field_70714_bg.func_75776_a(4, (Goal)new AvoidEntityGoal((CreatureEntity)this, (Class)PlayerEntity.class, 16.0f, 1.5, 1.8));
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 10.0).func_233815_a_(Attributes.field_233821_d_, 0.2);
    }
    
    public float func_213307_e(final Pose pose) {
        return this.func_213302_cg() * 0.7f;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.DEER_IDLE;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.DEER_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.DEER_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState blockIn) {
    }
    
    public DeerEntity createChild(final ServerWorld p_241840_1_, final AgeableEntity mate) {
        return (DeerEntity)TFEntities.deer.func_200721_a(this.field_70170_p);
    }
    
    protected float func_213348_b(final Pose pos, final EntitySize size) {
        return this.func_70631_g_() ? (size.field_220316_b * 0.95f) : 1.65f;
    }
}
