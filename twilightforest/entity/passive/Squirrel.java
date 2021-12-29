// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import javax.annotation.Nullable;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.entity.animal.Animal;

public class Squirrel extends Animal
{
    protected static final Ingredient SEEDS;
    
    public Squirrel(final EntityType<? extends Squirrel> type, final Level world) {
        super((EntityType)type, world);
        this.f_19793_ = 1.0f;
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PanicGoal((PathfinderMob)this, 1.3799999952316284));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 1.0, Squirrel.SEEDS, true));
        this.f_21345_.m_25352_(3, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Player.class, 2.0f, 0.800000011920929, 1.399999976158142));
        this.f_21345_.m_25352_(3, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Wolf.class, 8.0f, 0.800000011920929, 1.399999976158142));
        this.f_21345_.m_25352_(3, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Cat.class, 8.0f, 0.800000011920929, 1.399999976158142));
        this.f_21345_.m_25352_(3, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Ocelot.class, 8.0f, 0.800000011920929, 1.399999976158142));
        this.f_21345_.m_25352_(3, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Fox.class, 8.0f, 0.800000011920929, 1.399999976158142));
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.25));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 6.0f));
        this.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)this));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 1.0).m_22268_(Attributes.f_22279_, 0.3);
    }
    
    public boolean m_142535_(final float distance, final float multiplier, final DamageSource source) {
        return false;
    }
    
    public float m_20236_(final Pose pose) {
        return this.m_20206_() * 0.7f;
    }
    
    public float m_21692_(final BlockPos pos) {
        final Material underMaterial = this.f_19853_.m_8055_(pos.m_7495_()).m_60767_();
        if (underMaterial == Material.f_76274_) {
            return 12.0f;
        }
        if (underMaterial == Material.f_76320_) {
            return 15.0f;
        }
        if (underMaterial == Material.f_76315_) {
            return 10.0f;
        }
        return this.f_19853_.m_46803_(pos) - 0.5f;
    }
    
    @Nullable
    public AgeableMob m_142606_(final ServerLevel world, final AgeableMob ageableEntity) {
        return null;
    }
    
    static {
        SEEDS = Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42404_, (ItemLike)Items.f_42578_, (ItemLike)Items.f_42577_, (ItemLike)Items.f_42733_ });
    }
}
