// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import net.minecraft.world.IWorld;
import twilightforest.util.TFDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;

public class GiantMinerEntity extends MonsterEntity
{
    public GiantMinerEntity(final EntityType<? extends GiantMinerEntity> type, final World world) {
        super((EntityType)type, world);
        for (final EquipmentSlotType slot : EquipmentSlotType.values()) {
            this.func_184642_a(slot, 0.0f);
        }
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(4, (Goal)new MeleeAttackGoal(this, 1.0, false) {
            protected double func_179512_a(final LivingEntity attackTarget) {
                return this.field_75441_b.func_213311_cf() * this.field_75441_b.func_213302_cg();
            }
        });
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 80.0).func_233815_a_(Attributes.field_233821_d_, 0.23).func_233815_a_(Attributes.field_233823_f_, 2.0).func_233815_a_(Attributes.field_233819_b_, 40.0);
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficulty, final SpawnReason reason, @Nullable final ILivingEntityData spawnDataIn, @Nullable final CompoundNBT dataTag) {
        final ILivingEntityData data = super.func_213386_a(worldIn, difficulty, reason, spawnDataIn, dataTag);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);
        return data;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)Items.field_151050_s));
    }
    
    public boolean func_70652_k(final Entity entityIn) {
        entityIn.func_70097_a(TFDamageSources.ANT((LivingEntity)this), (float)this.func_233637_b_(Attributes.field_233823_f_));
        return super.func_70652_k(entityIn);
    }
    
    public int func_70641_bl() {
        return 1;
    }
    
    public boolean func_213380_a(final IWorld worldIn, final SpawnReason spawnReasonIn) {
        final List<GiantMinerEntity> giantsNearby = worldIn.func_217357_a((Class)GiantMinerEntity.class, this.func_174813_aQ().func_186662_g(50.0));
        return giantsNearby.size() < 7;
    }
    
    public static boolean canSpawn(final EntityType<? extends GiantMinerEntity> type, final IWorld world, final SpawnReason reason, final BlockPos pos, final Random rand) {
        return pos.func_177956_o() > 60 && (MobEntity.func_223315_a((EntityType)type, world, reason, pos, rand) || world.func_180495_p(pos).func_177230_c() == TFBlocks.wispy_cloud.get() || world.func_180495_p(pos).func_177230_c() == TFBlocks.fluffy_cloud.get());
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
}
