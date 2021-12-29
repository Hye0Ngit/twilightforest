// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.ItemStack;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class Penguin extends Bird
{
    public Penguin(final EntityType<? extends Penguin> type, final Level world) {
        super(type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PanicGoal((PathfinderMob)this, 1.75));
        this.f_21345_.m_25352_(2, (Goal)new BreedGoal((Animal)this, 1.0));
        this.f_21345_.m_25352_(3, (Goal)new TemptGoal((PathfinderMob)this, 0.75, Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42526_ }), false));
        this.f_21345_.m_25352_(4, (Goal)new FollowParentGoal((Animal)this, 1.149999976158142));
        this.f_21345_.m_25352_(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 6.0f));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Penguin.class, 5.0f, 0.02f));
        this.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)this));
    }
    
    @Override
    public Animal getBreedOffspring(final ServerLevel world, final AgeableMob entityanimal) {
        return (Animal)TFEntities.PENGUIN.m_20615_((Level)world);
    }
    
    public boolean m_6898_(final ItemStack stack) {
        return stack.m_41720_() == Items.f_42526_;
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22279_, 0.2);
    }
    
    public static boolean canSpawn(final EntityType<? extends Penguin> type, final LevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random rand) {
        final BlockPos blockpos = pos.m_7495_();
        return Mob.m_21400_((EntityType)type, world, reason, pos, rand) || world.m_8055_(blockpos).m_60620_((Tag)BlockTags.f_13047_);
    }
}
