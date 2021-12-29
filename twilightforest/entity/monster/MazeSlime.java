// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.util.Mth;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.monster.Slime;

public class MazeSlime extends Slime
{
    private static final AttributeModifier DOUBLE_HEALTH;
    
    public MazeSlime(final EntityType<? extends MazeSlime> type, final Level world) {
        super((EntityType)type, world);
    }
    
    public void m_7839_(final int size, final boolean resetHealth) {
        super.m_7839_(size, resetHealth);
        this.f_21364_ += 3;
    }
    
    public static boolean getCanSpawnHere(final EntityType<MazeSlime> entity, final ServerLevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        return world.m_46791_() != Difficulty.PEACEFUL && m_21400_((EntityType)entity, (LevelAccessor)world, reason, pos, random) && Monster.m_33008_(world, pos, random);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22266_(Attributes.f_22276_);
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficultyIn, final MobSpawnType reason, @Nullable final SpawnGroupData spawnDataIn, @Nullable final CompoundTag dataTag) {
        final AttributeInstance health = this.m_21051_(Attributes.f_22276_);
        health.m_22125_(MazeSlime.DOUBLE_HEALTH);
        return super.m_6518_(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return this.m_33633_() ? TFSounds.MAZE_SLIME_HURT_SMALL : TFSounds.MAZE_SLIME_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return this.m_33633_() ? TFSounds.MAZE_SLIME_DEATH_SMALL : TFSounds.MAZE_SLIME_DEATH;
    }
    
    protected SoundEvent m_7905_() {
        return this.m_33633_() ? TFSounds.MAZE_SLIME_SQUISH_SMALL : TFSounds.MAZE_SLIME_SQUISH;
    }
    
    protected SoundEvent m_7903_() {
        return this.m_33633_() ? TFSounds.MAZE_SLIME_SQUISH_SMALL : TFSounds.MAZE_SLIME_SQUISH;
    }
    
    protected boolean m_7483_() {
        return true;
    }
    
    protected boolean spawnCustomParticles() {
        for (int i = this.m_33632_(), j = 0; j < i * 8; ++j) {
            final float f = this.f_19796_.nextFloat() * 6.2831855f;
            final float f2 = this.f_19796_.nextFloat() * 0.5f + 0.5f;
            final float f3 = Mth.m_14031_(f) * i * 0.5f * f2;
            final float f4 = Mth.m_14089_(f) * i * 0.5f * f2;
            final Level world = this.f_19853_;
            final double d0 = this.m_20185_() + f3;
            final double d2 = this.m_20189_() + f4;
            final BlockState state = ((Block)TFBlocks.MAZESTONE_BRICK.get()).m_49966_();
            world.m_7106_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, state), d0, this.m_142469_().f_82289_, d2, 0.0, 0.0, 0.0);
        }
        return true;
    }
    
    protected float m_6121_() {
        return 0.1f * this.m_33632_();
    }
    
    static {
        DOUBLE_HEALTH = new AttributeModifier("Maze slime double health", 1.0, AttributeModifier.Operation.MULTIPLY_BASE);
    }
}
