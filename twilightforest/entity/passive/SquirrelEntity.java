// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import javax.annotation.Nullable;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.entity.passive.AnimalEntity;

public class SquirrelEntity extends AnimalEntity
{
    protected static final Ingredient SEEDS;
    
    public SquirrelEntity(final EntityType<? extends SquirrelEntity> type, final World world) {
        super((EntityType)type, world);
        this.field_70138_W = 1.0f;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new PanicGoal((CreatureEntity)this, 1.3799999952316284));
        this.field_70714_bg.func_75776_a(2, (Goal)new TemptGoal((CreatureEntity)this, 1.0, true, SquirrelEntity.SEEDS));
        this.field_70714_bg.func_75776_a(3, (Goal)new AvoidEntityGoal((CreatureEntity)this, (Class)PlayerEntity.class, 2.0f, 0.800000011920929, 1.399999976158142));
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.25));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 6.0f));
        this.field_70714_bg.func_75776_a(8, (Goal)new LookRandomlyGoal((MobEntity)this));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 1.0).func_233815_a_(Attributes.field_233821_d_, 0.3);
    }
    
    public boolean func_225503_b_(final float distance, final float multiplier) {
        return false;
    }
    
    public float func_213307_e(final Pose pose) {
        return this.func_213302_cg() * 0.7f;
    }
    
    public float func_180484_a(final BlockPos pos) {
        final Material underMaterial = this.field_70170_p.func_180495_p(pos.func_177977_b()).func_185904_a();
        if (underMaterial == Material.field_151584_j) {
            return 12.0f;
        }
        if (underMaterial == Material.field_151575_d) {
            return 15.0f;
        }
        if (underMaterial == Material.field_151577_b) {
            return 10.0f;
        }
        return this.field_70170_p.func_201696_r(pos) - 0.5f;
    }
    
    @Nullable
    public AgeableEntity func_241840_a(final ServerWorld world, final AgeableEntity ageableEntity) {
        return null;
    }
    
    static {
        SEEDS = Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151014_N, (IItemProvider)Items.field_151081_bc, (IItemProvider)Items.field_151080_bb, (IItemProvider)Items.field_185163_cU });
    }
}
