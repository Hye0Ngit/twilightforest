// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.block.BlockState;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.MathHelper;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.IWorld;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.SlimeEntity;

public class MazeSlimeEntity extends SlimeEntity
{
    private static final AttributeModifier DOUBLE_HEALTH;
    
    public MazeSlimeEntity(final EntityType<? extends MazeSlimeEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    public void func_70799_a(final int size, final boolean resetHealth) {
        super.func_70799_a(size, resetHealth);
        this.field_70728_aV += 3;
    }
    
    public static boolean getCanSpawnHere(final EntityType<MazeSlimeEntity> entity, final IServerWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        return world.func_175659_aa() != Difficulty.PEACEFUL && func_223315_a((EntityType)entity, (IWorld)world, reason, pos, random) && MonsterEntity.func_223323_a(world, pos, random);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233814_a_(Attributes.field_233818_a_);
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficultyIn, final SpawnReason reason, @Nullable final ILivingEntityData spawnDataIn, @Nullable final CompoundNBT dataTag) {
        final ModifiableAttributeInstance health = this.func_110148_a(Attributes.field_233818_a_);
        health.func_233769_c_(MazeSlimeEntity.DOUBLE_HEALTH);
        return super.func_213386_a(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return this.func_189101_db() ? TFSounds.MAZE_SLIME_HURT_SMALL : TFSounds.MAZE_SLIME_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return this.func_189101_db() ? TFSounds.MAZE_SLIME_DEATH_SMALL : TFSounds.MAZE_SLIME_DEATH;
    }
    
    protected SoundEvent func_184709_cY() {
        return this.func_189101_db() ? TFSounds.MAZE_SLIME_SQUISH_SMALL : TFSounds.MAZE_SLIME_SQUISH;
    }
    
    protected SoundEvent func_184710_cZ() {
        return this.func_189101_db() ? TFSounds.MAZE_SLIME_SQUISH_SMALL : TFSounds.MAZE_SLIME_SQUISH;
    }
    
    protected boolean func_70800_m() {
        return true;
    }
    
    protected boolean spawnCustomParticles() {
        for (int i = this.func_70809_q(), j = 0; j < i * 8; ++j) {
            final float f = this.field_70146_Z.nextFloat() * 6.2831855f;
            final float f2 = this.field_70146_Z.nextFloat() * 0.5f + 0.5f;
            final float f3 = MathHelper.func_76126_a(f) * i * 0.5f * f2;
            final float f4 = MathHelper.func_76134_b(f) * i * 0.5f * f2;
            final World world = this.field_70170_p;
            final double d0 = this.func_226277_ct_() + f3;
            final double d2 = this.func_226281_cx_() + f4;
            final BlockState state = ((Block)TFBlocks.maze_stone_brick.get()).func_176223_P();
            world.func_195594_a((IParticleData)new BlockParticleData(ParticleTypes.field_197611_d, state), d0, this.func_174813_aQ().field_72338_b, d2, 0.0, 0.0, 0.0);
        }
        return true;
    }
    
    protected float func_70599_aP() {
        return 0.1f * this.func_70809_q();
    }
    
    static {
        DOUBLE_HEALTH = new AttributeModifier("Maze slime double health", 1.0, AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
