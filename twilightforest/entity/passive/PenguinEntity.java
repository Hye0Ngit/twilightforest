// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.block.Blocks;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.item.ItemStack;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class PenguinEntity extends BirdEntity
{
    public PenguinEntity(final EntityType<? extends PenguinEntity> type, final World world) {
        super(type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new PanicGoal((CreatureEntity)this, 1.75));
        this.field_70714_bg.func_75776_a(2, (Goal)new BreedGoal((AnimalEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (Goal)new TemptGoal((CreatureEntity)this, 0.75, Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_196086_aW }), false));
        this.field_70714_bg.func_75776_a(4, (Goal)new FollowParentGoal((AnimalEntity)this, 1.149999976158142));
        this.field_70714_bg.func_75776_a(5, (Goal)new RandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PenguinEntity.class, 5.0f, 0.02f));
        this.field_70714_bg.func_75776_a(8, (Goal)new LookRandomlyGoal((MobEntity)this));
    }
    
    @Override
    public AnimalEntity createChild(final ServerWorld world, final AgeableEntity entityanimal) {
        return (AnimalEntity)TFEntities.penguin.func_200721_a((World)world);
    }
    
    public boolean func_70877_b(final ItemStack stack) {
        return stack.func_77973_b() == Items.field_196086_aW;
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 10.0).func_233815_a_(Attributes.field_233821_d_, 0.2);
    }
    
    public static boolean canSpawn(final EntityType<? extends PenguinEntity> type, final IWorld world, final SpawnReason reason, final BlockPos pos, final Random rand) {
        final BlockPos blockpos = pos.func_177977_b();
        return MobEntity.func_223315_a((EntityType)type, world, reason, pos, rand) || world.func_180495_p(blockpos).func_177230_c() == Blocks.field_150432_aD || world.func_180495_p(blockpos).func_177230_c() == Blocks.field_150403_cj;
    }
}
