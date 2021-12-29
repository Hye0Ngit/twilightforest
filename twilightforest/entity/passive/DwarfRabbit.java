// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Pose;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
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
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.animal.Animal;

public class DwarfRabbit extends Animal
{
    private static final EntityDataAccessor<Byte> DATA_TYPE;
    
    public DwarfRabbit(final EntityType<? extends DwarfRabbit> type, final Level world) {
        super((EntityType)type, world);
        this.f_19793_ = 1.0f;
        this.setBunnyType(this.f_19796_.nextInt(4));
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PanicGoal((PathfinderMob)this, 2.0));
        this.f_21345_.m_25352_(2, (Goal)new BreedGoal((Animal)this, 0.8));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 1.0, Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42619_, (ItemLike)Items.f_42677_, (ItemLike)Blocks.f_50111_ }), false));
        this.f_21345_.m_25352_(3, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Player.class, 2.0f, 0.800000011920929, 1.3300000429153442));
        this.f_21345_.m_25352_(4, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Ocelot.class, 8.0f, 0.800000011920929, 1.100000023841858));
        this.f_21345_.m_25352_(4, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Cat.class, 8.0f, 0.800000011920929, 1.100000023841858));
        this.f_21345_.m_25352_(4, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Wolf.class, 8.0f, 0.800000011920929, 1.100000023841858));
        this.f_21345_.m_25352_(4, (Goal)new AvoidEntityGoal((PathfinderMob)this, (Class)Fox.class, 8.0f, 0.800000011920929, 1.100000023841858));
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 0.800000011920929));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(7, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 6.0f));
        this.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)this));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 3.0).m_22268_(Attributes.f_22279_, 0.3);
    }
    
    @Nullable
    public AgeableMob m_142606_(final ServerLevel world, final AgeableMob ageableEntity) {
        final DwarfRabbit rabbit = (DwarfRabbit)TFEntities.DWARF_RABBIT.m_20615_((Level)world);
        int i = world.f_46441_.nextInt(4);
        if (this.f_19796_.nextInt(20) != 0) {
            if (ageableEntity instanceof DwarfRabbit && this.f_19796_.nextBoolean()) {
                i = ((DwarfRabbit)ageableEntity).getBunnyType();
            }
            else {
                i = this.getBunnyType();
            }
        }
        rabbit.setBunnyType(i);
        return (AgeableMob)rabbit;
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)DwarfRabbit.DATA_TYPE, (Object)0);
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128405_("BunnyType", this.getBunnyType());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setBunnyType(compound.m_128451_("BunnyType"));
    }
    
    public int getBunnyType() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)DwarfRabbit.DATA_TYPE);
    }
    
    public void setBunnyType(final int type) {
        this.f_19804_.m_135381_((EntityDataAccessor)DwarfRabbit.DATA_TYPE, (Object)(byte)type);
    }
    
    public float m_20236_(final Pose pose) {
        return this.m_20206_() * 0.5f;
    }
    
    public boolean m_6785_(final double p_213397_1_) {
        return false;
    }
    
    public float m_21692_(final BlockPos pos) {
        final Material underMaterial = this.f_19853_.m_8055_(pos.m_7495_()).m_60767_();
        if (underMaterial == Material.f_76274_) {
            return -1.0f;
        }
        if (underMaterial == Material.f_76320_) {
            return -1.0f;
        }
        if (underMaterial == Material.f_76315_) {
            return 10.0f;
        }
        return this.f_19853_.m_46803_(pos) - 0.5f;
    }
    
    private static boolean isTemptingItem(final ItemStack stack) {
        return stack.m_150930_(Items.f_42619_) || stack.m_150930_(Items.f_42677_) || stack.m_150930_(Blocks.f_50111_.m_5456_());
    }
    
    public boolean m_6898_(final ItemStack stack) {
        return isTemptingItem(stack);
    }
    
    @Nullable
    protected SoundEvent m_5592_() {
        return TFSounds.DWARF_DEATH;
    }
    
    @Nullable
    protected SoundEvent m_7975_(final DamageSource pDamageSource) {
        return TFSounds.DWARF_HURT;
    }
    
    @Nullable
    protected SoundEvent m_7515_() {
        return TFSounds.DWARF_AMBIENT;
    }
    
    static {
        DATA_TYPE = SynchedEntityData.m_135353_((Class)DwarfRabbit.class, EntityDataSerializers.f_135027_);
    }
}
