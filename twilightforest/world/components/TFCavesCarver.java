// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components;

import java.util.Set;
import net.minecraft.util.Mth;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.core.Vec3i;
import net.minecraft.core.Direction;
import org.apache.commons.lang3.mutable.MutableBoolean;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.core.SectionPos;
import java.util.BitSet;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.BlockPos;
import java.util.function.Function;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import java.util.Random;
import net.minecraft.world.level.block.Blocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.material.Fluids;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class TFCavesCarver extends WorldCarver<CaveCarverConfiguration>
{
    private final boolean isHighlands;
    
    public TFCavesCarver(final Codec<CaveCarverConfiguration> codec, final boolean isHighlands) {
        super((Codec)codec);
        this.f_64984_ = (Set)ImmutableSet.of((Object)Fluids.f_76193_, (Object)Fluids.f_76195_);
        this.f_64983_ = (Set)ImmutableSet.of((Object)Blocks.f_49992_, (Object)Blocks.f_49994_);
        this.isHighlands = isHighlands;
    }
    
    public boolean isStartChunk(final CaveCarverConfiguration config, final Random rand) {
        return rand.nextFloat() <= config.f_67859_;
    }
    
    public boolean carve(final CarvingContext ctx, final CaveCarverConfiguration config, final ChunkAccess access, final Function<BlockPos, Biome> biomePos, final Random rand, final Aquifer aquifer, final ChunkPos accessPos, final BitSet bitSet) {
        final int i = SectionPos.m_123223_(this.m_65073_() * 2 - 1);
        for (int j = rand.nextInt(rand.nextInt(rand.nextInt(this.getCaveBound()) + 1) + 1), k = 0; k < j; ++k) {
            final double x = accessPos.m_151382_(rand.nextInt(16));
            final double y = config.f_159088_.m_142233_(rand, (WorldGenerationContext)ctx);
            final double z = accessPos.m_151391_(rand.nextInt(16));
            final double horiz = config.f_159155_.m_142269_(rand);
            final double vert = config.f_159156_.m_142269_(rand);
            final double floor = config.f_159157_.m_142269_(rand);
            final WorldCarver.CarveSkipChecker checker = (p_159202_, p_159203_, p_159204_, p_159205_, p_159206_) -> shouldSkip(p_159203_, p_159204_, p_159205_, floor);
            int l = 1;
            if (rand.nextInt(4) == 0 && this.isHighlands) {
                final double d6 = config.f_159089_.m_142269_(rand);
                final float f1 = 1.0f + rand.nextFloat() * 6.0f;
                this.createRoom(ctx, config, access, biomePos, rand.nextLong(), aquifer, x, y, z, f1, d6, bitSet, checker);
                l += rand.nextInt(4);
            }
            for (int k2 = 0; k2 < l; ++k2) {
                final float f2 = rand.nextFloat() * 6.2831855f;
                final float f3 = (rand.nextFloat() - 0.5f) / 4.0f;
                final float f4 = this.getThickness(rand);
                final int i2 = i - rand.nextInt(i / 4);
                this.createTunnel(ctx, config, access, biomePos, rand.nextLong(), aquifer, x, y, z, horiz, vert, f4, f2, f3, 0, i2, this.getYScale(), bitSet, checker);
            }
        }
        return true;
    }
    
    protected boolean carveBlock(final CarvingContext ctx, final CaveCarverConfiguration config, final ChunkAccess access, final Function<BlockPos, Biome> biomePos, final BitSet bitset, final Random rand, final BlockPos.MutableBlockPos pos, final BlockPos.MutableBlockPos posUp, final Aquifer aquifer, final MutableBoolean isSurface) {
        final BlockState blockstate = access.m_8055_((BlockPos)pos);
        final BlockState blockstate2 = access.m_8055_((BlockPos)posUp.m_122159_((Vec3i)pos, Direction.UP));
        if (blockstate.m_60713_(Blocks.f_50440_) || blockstate.m_60713_(Blocks.f_50195_) || blockstate.m_60713_(Blocks.f_50599_) || blockstate.m_60713_(Blocks.f_152481_)) {
            isSurface.setTrue();
        }
        if (pos.m_123342_() < access.m_141937_() + 6) {
            return false;
        }
        if (!this.m_65012_(blockstate, blockstate2) && !m_159423_((CarverConfiguration)config)) {
            return false;
        }
        final BlockState blockstate3 = this.m_159418_(ctx, (CarverConfiguration)config, (BlockPos)pos, aquifer);
        if (blockstate3 == null) {
            return false;
        }
        for (final Direction facing : Direction.values()) {
            final FluidState aboveSurface = access.m_6425_(posUp.m_141952_((Vec3i)pos.m_142082_(0, 1, 0)));
            final FluidState areaAround = access.m_6425_(posUp.m_142300_(facing));
            final FluidState areaAboveAround = access.m_6425_(posUp.m_141952_((Vec3i)pos.m_142082_(0, 1, 0).m_142300_(facing)));
            if (areaAround.m_76153_((Tag)FluidTags.f_13131_) || areaAboveAround.m_76153_((Tag)FluidTags.f_13131_) || aboveSurface.m_76153_((Tag)FluidTags.f_13131_)) {
                return false;
            }
            if (rand.nextInt(10) == 0 && access.m_8055_((BlockPos)pos).m_60795_() && access.m_8055_(pos.m_142300_(facing)).m_60620_((Tag)BlockTags.f_13061_) && this.isHighlands) {
                access.m_6978_(pos.m_142300_(facing), ((Block)TFBlocks.TROLLSTEINN.get()).m_49966_(), false);
            }
            access.m_6978_((BlockPos)pos, TFCavesCarver.f_64980_, false);
            if ((access.m_8055_(pos.m_7494_()).m_60620_((Tag)BlockTags.f_13061_) || access.m_6425_(pos.m_7494_()).m_76153_((Tag)FluidTags.f_13131_)) && access.m_8055_((BlockPos)pos).m_60795_() && !this.isHighlands) {
                switch (rand.nextInt(5)) {
                    case 0:
                    case 1:
                    case 2: {
                        access.m_6978_(pos.m_7494_(), Blocks.f_50493_.m_49966_(), false);
                        break;
                    }
                    case 3: {
                        access.m_6978_(pos.m_7494_(), Blocks.f_152549_.m_49966_(), false);
                        break;
                    }
                    case 4: {
                        access.m_6978_(pos.m_7494_(), Blocks.f_50546_.m_49966_(), false);
                        break;
                    }
                }
            }
            if (isSurface.isTrue()) {
                final BlockPos posDown = pos.m_122159_((Vec3i)pos, Direction.DOWN).m_7495_();
                if (access.m_8055_(posDown).m_60713_(Blocks.f_50493_)) {
                    access.m_6978_(posDown, biomePos.apply((BlockPos)pos).m_47536_().m_47824_().m_6743_(), false);
                }
            }
        }
        return true;
    }
    
    protected int getCaveBound() {
        return 15;
    }
    
    protected float getThickness(final Random rand) {
        float f = rand.nextFloat() * 2.0f + rand.nextFloat();
        if (rand.nextInt(10) == 0) {
            f *= rand.nextFloat() * rand.nextFloat() * 3.0f + 1.0f;
        }
        return f;
    }
    
    protected double getYScale() {
        return 1.0;
    }
    
    protected void createRoom(final CarvingContext ctx, final CaveCarverConfiguration config, final ChunkAccess access, final Function<BlockPos, Biome> biomePos, final long seed, final Aquifer aquifer, final double posX, final double posY, final double posZ, final float radius, final double horizToVertRatio, final BitSet bitSet, final WorldCarver.CarveSkipChecker checker) {
        final double d0 = 1.5 + Mth.m_14031_(1.5707964f) * radius;
        final double d2 = d0 * horizToVertRatio;
        this.m_159386_(ctx, (CarverConfiguration)config, access, (Function)biomePos, seed, aquifer, posX + 1.0, posY, posZ, d0, d2, bitSet, checker);
    }
    
    protected void createTunnel(final CarvingContext ctx, final CaveCarverConfiguration config, final ChunkAccess access, final Function<BlockPos, Biome> biomePos, final long seed, final Aquifer aquifer, double posX, double posY, double posZ, final double horizMult, final double vertMult, final float thickness, float yaw, float pitch, final int branchIndex, final int branchCount, final double horizToVertRatio, final BitSet bitSet, final WorldCarver.CarveSkipChecker checker) {
        final Random random = new Random(seed);
        final int i = random.nextInt(branchCount / 2) + branchCount / 4;
        final boolean flag = random.nextInt(6) == 0;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int j = branchIndex; j < branchCount; ++j) {
            final double d0 = 1.5 + Mth.m_14031_(3.1415927f * j / branchCount) * thickness;
            final double d2 = d0 * horizToVertRatio;
            final float f3 = Mth.m_14089_(pitch);
            posX += Mth.m_14089_(yaw) * f3;
            posY += Mth.m_14031_(pitch);
            posZ += Mth.m_14031_(yaw) * f3;
            pitch *= (flag ? 0.92f : 0.7f);
            pitch += f2 * 0.1f;
            yaw += f * 0.1f;
            f2 *= 0.9f;
            f *= 0.75f;
            f2 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (j == i && thickness > 1.0f) {
                this.createTunnel(ctx, config, access, biomePos, random.nextLong(), aquifer, posX, posY, posZ, horizMult, vertMult, random.nextFloat() * 0.5f + 0.5f, yaw - 1.5707964f, pitch / 3.0f, j, branchCount, 1.0, bitSet, checker);
                this.createTunnel(ctx, config, access, biomePos, random.nextLong(), aquifer, posX, posY, posZ, horizMult, vertMult, random.nextFloat() * 0.5f + 0.5f, yaw + 1.5707964f, pitch / 3.0f, j, branchCount, 1.0, bitSet, checker);
                return;
            }
            if (random.nextInt(4) != 0) {
                if (!m_159367_(access.m_7697_(), posX, posZ, j, branchCount, thickness)) {
                    return;
                }
                this.m_159386_(ctx, (CarverConfiguration)config, access, (Function)biomePos, seed, aquifer, posX, posY, posZ, d0 * horizMult, d2 * vertMult, bitSet, checker);
            }
        }
    }
    
    protected boolean m_65012_(final BlockState state, final BlockState aboveState) {
        return (this.f_64983_.contains(state.m_60734_()) || state.m_60620_((Tag)BlockTags.f_13061_) || state.m_60620_((Tag)BlockTags.f_144274_) || state.m_60713_((Block)TFBlocks.TROLLSTEINN.get())) && !aboveState.m_60819_().m_76153_((Tag)FluidTags.f_13131_);
    }
    
    private static boolean shouldSkip(final double posX, final double posY, final double posZ, final double minY) {
        return posY <= minY || posX * posX + posY * posY + posZ * posZ >= 1.0;
    }
}
