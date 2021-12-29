// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import twilightforest.TFSounds;
import javax.annotation.Nullable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.ISeedReader;
import twilightforest.TFFeature;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.ai.goal.ResetAngerGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.ai.goal.NonTamedTargetGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.WolfEntity;

public class HostileWolfEntity extends WolfEntity implements IMob
{
    public HostileWolfEntity(final EntityType<? extends HostileWolfEntity> type, final World world) {
        super((EntityType)type, world);
        this.func_70903_f(false);
        this.func_233687_w_(false);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return WolfEntity.func_234233_eS_().func_233815_a_(Attributes.field_233818_a_, 10.0);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(4, (Goal)new LeapAtTargetGoal((MobEntity)this, 0.4f));
        this.field_70714_bg.func_75776_a(5, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, true));
        this.field_70714_bg.func_75776_a(8, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(10, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(10, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(4, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
        this.field_70715_bh.func_75776_a(5, (Goal)new NonTamedTargetGoal((TameableEntity)this, (Class)AnimalEntity.class, false, HostileWolfEntity.field_213441_bD));
        this.field_70715_bh.func_75776_a(6, (Goal)new NonTamedTargetGoal((TameableEntity)this, (Class)TurtleEntity.class, false, TurtleEntity.field_203029_bx));
        this.field_70715_bh.func_75776_a(7, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)AbstractSkeletonEntity.class, false));
        this.field_70715_bh.func_75776_a(8, (Goal)new ResetAngerGoal((MobEntity)this, true));
    }
    
    public static boolean getCanSpawnHere(final EntityType<? extends HostileWolfEntity> type, final IServerWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        final int chunkX = MathHelper.func_76141_d((float)pos.func_177958_n()) >> 4;
        final int chunkZ = MathHelper.func_76141_d((float)pos.func_177952_p()) >> 4;
        return TFFeature.getNearestFeature(chunkX, chunkZ, (ISeedReader)world.func_201672_e()) == TFFeature.HEDGE_MAZE || MonsterEntity.func_223323_a(world, pos, random);
    }
    
    public void func_70624_b(@Nullable final LivingEntity entity) {
        if (entity != null && entity != this.func_70638_az()) {
            this.func_184185_a(TFSounds.HOSTILE_WOLF_TARGET, 4.0f, this.func_70647_i());
        }
        super.func_70624_b(entity);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.HOSTILE_WOLF_IDLE;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.HOSTILE_WOLF_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.HOSTILE_WOLF_DEATH;
    }
    
    public ActionResultType func_184199_a(final PlayerEntity player, final Vector3d vec, final Hand hand) {
        return ActionResultType.PASS;
    }
    
    public ActionResultType func_230254_b_(final PlayerEntity playerIn, final Hand hand) {
        return ActionResultType.PASS;
    }
    
    public boolean func_70877_b(final ItemStack stack) {
        return false;
    }
    
    public boolean func_70922_bv() {
        return false;
    }
    
    public boolean func_70878_b(final AnimalEntity otherAnimal) {
        return false;
    }
    
    public WolfEntity func_241840_a(final ServerWorld world, final AgeableEntity mate) {
        return null;
    }
    
    protected boolean func_225511_J_() {
        return true;
    }
}
