// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.IWorld;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class CarminiteGhastlingEntity extends CarminiteGhastguardEntity
{
    private boolean isMinion;
    
    public CarminiteGhastlingEntity(final EntityType<? extends CarminiteGhastlingEntity> type, final World world) {
        super(type, world);
        this.isMinion = false;
        this.wanderFactor = 4.0f;
    }
    
    @Override
    public int func_70641_bl() {
        return 16;
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return CarminiteGhastguardEntity.registerAttributes().func_233815_a_(Attributes.field_233818_a_, 10.0).func_233815_a_(Attributes.field_233819_b_, 16.0);
    }
    
    protected float func_213348_b(final Pose poseIn, final EntitySize sizeIn) {
        return 0.5f;
    }
    
    @Override
    protected SoundEvent func_184639_G() {
        return TFSounds.GHASTLING_AMBIENT;
    }
    
    @Override
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.GHASTLING_HURT;
    }
    
    @Override
    protected SoundEvent func_184615_bR() {
        return TFSounds.GHASTLING_DEATH;
    }
    
    @Override
    protected boolean shouldAttack(final LivingEntity living) {
        final ItemStack helmet = living.func_184582_a(EquipmentSlotType.HEAD);
        if (!helmet.func_190926_b() && helmet.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK)) {
            return false;
        }
        if (living.func_70032_d((Entity)this) <= 3.5f) {
            return living.func_70685_l((Entity)this);
        }
        final Vector3d vec3d = living.func_70676_i(1.0f).func_72432_b();
        Vector3d vec3d2 = new Vector3d(this.func_226277_ct_() - living.func_226277_ct_(), this.func_174813_aQ().field_72338_b + this.func_70047_e() - (living.func_226278_cu_() + living.func_70047_e()), this.func_226281_cx_() - living.func_226281_cx_());
        final double d0 = vec3d2.func_72433_c();
        vec3d2 = vec3d2.func_72432_b();
        final double d2 = vec3d.func_72430_b(vec3d2);
        return d2 > 1.0 - 0.025 / d0 && living.func_70685_l((Entity)this);
    }
    
    public static boolean canSpawnHere(final EntityType<CarminiteGhastlingEntity> entity, final IServerWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        return world.func_175659_aa() != Difficulty.PEACEFUL && (reason == SpawnReason.MOB_SUMMONED || MonsterEntity.func_223323_a(world, pos, random)) && func_223315_a((EntityType)entity, (IWorld)world, reason, pos, random);
    }
    
    public void makeBossMinion() {
        this.wanderFactor = 0.005f;
        this.isMinion = true;
        this.func_110148_a(Attributes.field_233818_a_).func_111128_a(6.0);
        this.func_70606_j(6.0f);
    }
    
    public boolean isMinion() {
        return this.isMinion;
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        compound.func_74757_a("isMinion", this.isMinion);
        super.func_213281_b(compound);
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        if (compound.func_74767_n("isMinion")) {
            this.makeBossMinion();
        }
    }
}
