// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Pose;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.passive.AnimalEntity;

public class BunnyEntity extends AnimalEntity
{
    private static final DataParameter<Byte> DATA_TYPE;
    
    public BunnyEntity(final EntityType<? extends BunnyEntity> type, final World world) {
        super((EntityType)type, world);
        this.field_70138_W = 1.0f;
        this.setBunnyType(this.field_70146_Z.nextInt(4));
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new PanicGoal((CreatureEntity)this, 2.0));
        this.field_70714_bg.func_75776_a(2, (Goal)new TemptGoal((CreatureEntity)this, 1.0, Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151172_bF, (IItemProvider)Items.field_151150_bK, (IItemProvider)Blocks.field_196605_bc }), true));
        this.field_70714_bg.func_75776_a(3, (Goal)new AvoidEntityGoal((CreatureEntity)this, (Class)PlayerEntity.class, 2.0f, 0.800000011920929, 1.3300000429153442));
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 0.800000011920929));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 6.0f));
        this.field_70714_bg.func_75776_a(8, (Goal)new LookRandomlyGoal((MobEntity)this));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 3.0).func_233815_a_(Attributes.field_233821_d_, 0.3);
    }
    
    @Nullable
    public AgeableEntity func_241840_a(final ServerWorld world, final AgeableEntity ageableEntity) {
        return null;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)BunnyEntity.DATA_TYPE, (Object)0);
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74768_a("BunnyType", this.getBunnyType());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setBunnyType(compound.func_74762_e("BunnyType"));
    }
    
    public int getBunnyType() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)BunnyEntity.DATA_TYPE);
    }
    
    public void setBunnyType(final int type) {
        this.field_70180_af.func_187227_b((DataParameter)BunnyEntity.DATA_TYPE, (Object)(byte)type);
    }
    
    public float func_213307_e(final Pose pose) {
        return this.func_213302_cg() * 0.5f;
    }
    
    public boolean func_213397_c(final double p_213397_1_) {
        return false;
    }
    
    public float func_180484_a(final BlockPos pos) {
        final Material underMaterial = this.field_70170_p.func_180495_p(pos.func_177977_b()).func_185904_a();
        if (underMaterial == Material.field_151584_j) {
            return -1.0f;
        }
        if (underMaterial == Material.field_151575_d) {
            return -1.0f;
        }
        if (underMaterial == Material.field_151577_b) {
            return 10.0f;
        }
        return this.field_70170_p.func_201696_r(pos) - 0.5f;
    }
    
    static {
        DATA_TYPE = EntityDataManager.func_187226_a((Class)BunnyEntity.class, DataSerializers.field_187191_a);
    }
}
