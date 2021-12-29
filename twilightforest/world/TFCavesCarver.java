// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Set;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.tags.FluidTags;
import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.Direction;
import org.apache.commons.lang3.mutable.MutableBoolean;
import net.minecraft.util.math.MathHelper;
import java.util.BitSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import java.util.function.Function;
import net.minecraft.world.chunk.IChunk;
import java.util.Random;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.carver.WorldCarver;

public class TFCavesCarver extends WorldCarver<ProbabilityConfig>
{
    private final boolean isHighlands;
    
    public TFCavesCarver(final Codec<ProbabilityConfig> codec, final int maxheight, final boolean isHighlands) {
        super((Codec)codec, maxheight);
        this.field_222719_k = (Set)ImmutableSet.of();
        this.isHighlands = isHighlands;
    }
    
    public boolean shouldCarve(final Random rand, final int chunkX, final int chunkZ, final ProbabilityConfig config) {
        return rand.nextFloat() <= config.field_203622_a;
    }
    
    public boolean carveRegion(final IChunk chunk, final Function<BlockPos, Biome> biomePos, final Random rand, final int seaLevel, final int chunkXOffset, final int chunkZOffset, final int chunkX, final int chunkZ, final BitSet carvingMask, final ProbabilityConfig config) {
        final int size = (this.func_222704_c() * 2 - 1) * 16;
        for (int maxcaves = rand.nextInt(rand.nextInt(rand.nextInt(45) + 1) + 1), k = 0; k < maxcaves; ++k) {
            final double randx = chunkXOffset * 16 + rand.nextInt(16);
            final double randy = this.func_230361_b_(rand);
            final double randz = chunkZOffset * 16 + rand.nextInt(16);
            int l = 1;
            if (rand.nextInt(4) == 0) {
                final float cavesize = 1.0f + rand.nextFloat() * 6.0f;
                this.genLargeNode(chunk, biomePos, rand.nextLong(), seaLevel, chunkX, chunkZ, randx, randy, randz, cavesize, 0.5, carvingMask);
                l += rand.nextInt(4);
            }
            for (int k2 = 0; k2 < l; ++k2) {
                final float f = rand.nextFloat() * 6.2831855f;
                final float f2 = (rand.nextFloat() - 0.5f) / 4.0f;
                final float f3 = this.func_230359_a_(rand);
                final int i1 = size - rand.nextInt(size / 4);
                this.genNode(chunk, biomePos, rand.nextLong(), seaLevel, chunkX, chunkZ, randx, randy, randz, f3, f, f2, 0, i1, this.func_230360_b_(), carvingMask, this.isHighlands);
            }
        }
        return true;
    }
    
    protected float func_230359_a_(final Random rand) {
        float f = rand.nextFloat() * 2.0f + rand.nextFloat();
        if (rand.nextInt(10) == 0) {
            f *= rand.nextFloat() * rand.nextFloat() * 3.0f + 1.0f;
        }
        return f;
    }
    
    protected double func_230360_b_() {
        return 1.0;
    }
    
    protected int func_230361_b_(final Random rand) {
        return rand.nextInt(rand.nextInt(120) + 8);
    }
    
    protected void genLargeNode(final IChunk chunk, final Function<BlockPos, Biome> biomePos, final long seed, final int seaLevel, final int chunkX, final int chunkZ, final double randOffsetXCoord, final double startY, final double randOffsetZCoord, final float p_227205_14_, final double p_227205_15_, final BitSet carvingMask) {
        final double d0 = 1.5 + MathHelper.func_76126_a(1.5707964f) * p_227205_14_;
        final double d2 = d0 * p_227205_15_;
        this.func_227208_a_(chunk, (Function)biomePos, seed, seaLevel, chunkX, chunkZ, randOffsetXCoord + 1.0, startY, randOffsetZCoord, d0, d2, carvingMask);
    }
    
    protected void genNode(final IChunk chunk, final Function<BlockPos, Biome> biomePos, final long seed, final int seaLevel, final int chunkX, final int chunkZ, double randOffsetXCoord, double startY, double randOffsetZCoord, float caveRadius, float pitch, float p_227206_16_, final int p_227206_17_, final int p_227206_18_, final double p_227206_19_, final BitSet p_227206_21_, final boolean isHighlands) {
        final Random random = new Random(seed);
        final int i = random.nextInt(p_227206_18_ / 2) + p_227206_18_ / 4;
        final boolean flag = random.nextInt(6) == 0;
        float f = 0.0f;
        float f2 = 0.0f;
        if (isHighlands && caveRadius < 6.0f) {
            caveRadius *= 2.0f;
        }
        for (int j = p_227206_17_; j < p_227206_18_; ++j) {
            final double d0 = 1.5 + MathHelper.func_76126_a(3.1415927f * j / p_227206_18_) * caveRadius;
            final double d2 = d0 * p_227206_19_;
            final float f3 = MathHelper.func_76134_b(p_227206_16_);
            randOffsetXCoord += MathHelper.func_76134_b(pitch) * f3;
            startY += MathHelper.func_76126_a(p_227206_16_);
            randOffsetZCoord += MathHelper.func_76126_a(pitch) * f3;
            p_227206_16_ *= (flag ? 0.92f : 0.7f);
            p_227206_16_ += f2 * 0.1f;
            pitch += f * 0.1f;
            f2 *= 0.9f;
            f *= 0.75f;
            f2 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (j == i && caveRadius > 1.0f) {
                this.genNode(chunk, biomePos, random.nextLong(), seaLevel, chunkX, chunkZ, randOffsetXCoord, startY, randOffsetZCoord, random.nextFloat() * 0.5f + 0.5f, pitch - 1.5707964f, p_227206_16_ / 3.0f, j, p_227206_18_, 1.0, p_227206_21_, this.isHighlands);
                this.genNode(chunk, biomePos, random.nextLong(), seaLevel, chunkX, chunkZ, randOffsetXCoord, startY, randOffsetZCoord, random.nextFloat() * 0.5f + 0.5f, pitch + 1.5707964f, p_227206_16_ / 3.0f, j, p_227206_18_, 1.0, p_227206_21_, this.isHighlands);
                return;
            }
            if (random.nextInt(4) != 0) {
                if (!this.func_222702_a(chunkX, chunkZ, randOffsetXCoord, randOffsetZCoord, j, p_227206_18_, caveRadius)) {
                    return;
                }
                this.func_227208_a_(chunk, (Function)biomePos, seed, seaLevel, chunkX, chunkZ, randOffsetXCoord, startY, randOffsetZCoord, d0, d2, p_227206_21_);
            }
        }
    }
    
    protected boolean func_222708_a(final double p_222708_1_, final double p_222708_3_, final double p_222708_5_, final int p_222708_7_) {
        return p_222708_3_ <= -0.7 || p_222708_1_ * p_222708_1_ + p_222708_3_ * p_222708_3_ + p_222708_5_ * p_222708_5_ >= 1.0;
    }
    
    protected boolean func_230358_a_(final IChunk chunk, final Function<BlockPos, Biome> biomePos, final BitSet carvingMask, final Random rand, final BlockPos.Mutable pos, final BlockPos.Mutable posUp, final BlockPos.Mutable posDown, final int p_230358_8_, final int p_230358_9_, final int p_230358_10_, final int posX, final int posZ, final int p_230358_13_, final int posY, final int p_230358_15_, final MutableBoolean isSurface) {
        final int i = p_230358_13_ | p_230358_15_ << 4 | posY << 8;
        if (carvingMask.get(i)) {
            return false;
        }
        carvingMask.set(i);
        pos.func_181079_c(posX, posY, posZ);
        final BlockState blockstate = chunk.func_180495_p((BlockPos)pos);
        final BlockState blockstate2 = chunk.func_180495_p((BlockPos)posUp.func_239622_a_((Vector3i)pos, Direction.UP));
        if (blockstate.func_203425_a(Blocks.field_196658_i) || blockstate.func_203425_a(Blocks.field_150391_bh)) {
            isSurface.setTrue();
        }
        if (!this.func_222707_a(blockstate, blockstate2)) {
            return false;
        }
        if (posY < 6) {
            return false;
        }
        final BlockState aboveSurface = chunk.func_180495_p((BlockPos)posUp.func_189533_g((Vector3i)pos.func_177982_a(0, 1, 0)));
        for (final Direction facing : Direction.values()) {
            final BlockState areaAround = chunk.func_180495_p(posUp.func_177972_a(facing));
            final BlockState areaAboveAround = chunk.func_180495_p((BlockPos)posUp.func_189533_g((Vector3i)pos.func_177982_a(0, 1, 0).func_177972_a(facing)));
            if (rand.nextInt(10) == 0 && chunk.func_180495_p((BlockPos)pos).func_203425_a(Blocks.field_201941_jj) && chunk.func_180495_p(pos.func_177972_a(facing)).func_235714_a_((ITag)BlockTags.field_242172_aH) && this.isHighlands) {
                chunk.func_177436_a(pos.func_177972_a(facing), ((Block)TFBlocks.trollsteinn.get()).func_176223_P(), false);
            }
            if (!aboveSurface.func_203425_a(Blocks.field_150355_j) && !areaAround.func_203425_a(Blocks.field_150355_j) && !areaAboveAround.func_203425_a(Blocks.field_150355_j)) {
                chunk.func_177436_a((BlockPos)pos, TFCavesCarver.field_222715_g, false);
                if (chunk.func_180495_p(pos.func_177984_a()).func_235714_a_((ITag)BlockTags.field_242172_aH) && chunk.func_180495_p((BlockPos)pos).func_203425_a(Blocks.field_201941_jj) && !this.isHighlands) {
                    chunk.func_177436_a(pos.func_177984_a(), Blocks.field_150346_d.func_176223_P(), false);
                }
                if (isSurface.isTrue()) {
                    posDown.func_239622_a_((Vector3i)pos, Direction.DOWN);
                    if (chunk.func_180495_p((BlockPos)posDown).func_203425_a(Blocks.field_150346_d)) {
                        chunk.func_177436_a((BlockPos)posDown, biomePos.apply((BlockPos)pos).func_242440_e().func_242502_e().func_204108_a(), false);
                    }
                }
            }
        }
        return true;
    }
    
    protected boolean func_222707_a(final BlockState state, final BlockState aboveState) {
        return this.func_222706_a(state) || ((state.func_203425_a(Blocks.field_150354_m) || state.func_203425_a((Block)TFBlocks.trollsteinn.get()) || state.func_203425_a(Blocks.field_150351_n)) && !aboveState.func_204520_s().func_206884_a((ITag)FluidTags.field_206959_a));
    }
}
