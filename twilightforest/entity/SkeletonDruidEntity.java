// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.world.LightType;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.projectile.NatureBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.Hand;
import net.minecraft.item.HoeItem;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SkeletonEntity;

public class SkeletonDruidEntity extends SkeletonEntity
{
    public SkeletonDruidEntity(final EntityType<? extends SkeletonDruidEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(4, (Goal)new RangedAttackGoal((IRangedAttackMob)this, 1.25, 60, 5.0f));
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.SKELETON_DRUID_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.SKELETON_DRUID_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.SKELETON_DRUID_DEATH;
    }
    
    protected SoundEvent func_190727_o() {
        return TFSounds.SKELETON_DRUID_STEP;
    }
    
    public void func_85036_m() {
        if (!(this.func_184586_b(Hand.MAIN_HAND).func_77973_b() instanceof HoeItem)) {
            super.func_85036_m();
        }
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)Items.field_151013_M));
    }
    
    public void func_82196_d(final LivingEntity attackTarget, final float extraDamage) {
        if (this.func_184586_b(Hand.MAIN_HAND).func_77973_b() instanceof HoeItem) {
            final NatureBoltEntity natureBolt = new NatureBoltEntity(this.field_70170_p, (LivingEntity)this);
            this.func_184185_a(TFSounds.SKELETON_DRUID_SHOOT, 1.0f, 1.0f / (this.field_70146_Z.nextFloat() * 0.4f + 0.8f));
            final double tx = attackTarget.func_226277_ct_() - this.func_226277_ct_();
            final double ty = attackTarget.func_226278_cu_() + attackTarget.func_70047_e() - 2.699999988079071 - this.func_226278_cu_();
            final double tz = attackTarget.func_226281_cx_() - this.func_226281_cx_();
            final float heightOffset = MathHelper.func_76133_a(tx * tx + tz * tz) * 0.2f;
            natureBolt.func_70186_c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
            this.field_70170_p.func_217376_c((Entity)natureBolt);
        }
        else {
            super.func_82196_d(attackTarget, extraDamage);
        }
    }
    
    public static boolean skeletonDruidSpawnHandler(final EntityType<? extends SkeletonDruidEntity> entity, final IWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        return world.func_175659_aa() != Difficulty.PEACEFUL && isValidLightLevel(world, pos, random) && func_223315_a((EntityType)entity, world, reason, pos, random);
    }
    
    public static boolean isValidLightLevel(final IWorld world, final BlockPos pos, final Random random) {
        if (world.func_226658_a_(LightType.SKY, pos) > random.nextInt(32)) {
            return false;
        }
        final int i = world.func_201696_r(pos);
        return i <= random.nextInt(12);
    }
}
