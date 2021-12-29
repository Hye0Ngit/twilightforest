// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import twilightforest.enums.HollowLogVariants;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.block.HollowLogHorizontal;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.mojang.serialization.Codec;
import twilightforest.world.components.feature.config.HollowLogConfig;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenFallenSmallLog extends Feature<HollowLogConfig>
{
    public TFGenFallenSmallLog(final Codec<HollowLogConfig> configIn) {
        super((Codec)configIn);
    }
    
    public boolean m_142674_(final FeaturePlaceContext<HollowLogConfig> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final HollowLogConfig config = (HollowLogConfig)ctx.m_159778_();
        final boolean shouldMakeAllHollow = rand.nextBoolean();
        final boolean goingX = rand.nextBoolean();
        final int length = rand.nextInt(4) + 3;
        if (goingX) {
            if (!FeatureUtil.isAreaSuitable(world, pos, length, 2, 2, true)) {
                return false;
            }
        }
        else if (!FeatureUtil.isAreaSuitable(world, pos, 2, 2, length, true)) {
            return false;
        }
        BlockState logState = config.normal();
        BlockState hollowLogState = config.hollow();
        if (config.hollow().m_60795_()) {
            hollowLogState = null;
        }
        if (rand.nextInt(5) == 0 && world.m_8055_(pos).m_60767_() == Material.f_76305_) {
            final BlockPos.MutableBlockPos floatingPos = pos.m_122032_();
            for (int i = 0; i < 10; ++i) {
                if (world.m_8055_(floatingPos.m_7494_()).m_60795_()) {
                    pos = floatingPos.m_7949_();
                    break;
                }
                floatingPos.m_122184_(0, 1, 0);
            }
        }
        BlockState branchState;
        if (goingX) {
            logState = (BlockState)logState.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.X);
            if (hollowLogState != null) {
                hollowLogState = (BlockState)((BlockState)hollowLogState.m_61124_((Property)HollowLogHorizontal.HORIZONTAL_AXIS, (Comparable)Direction.Axis.X)).m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)this.determineHollowProperties(world, pos, rand));
            }
            branchState = (BlockState)logState.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Z);
            for (int lx = 0; lx < length; ++lx) {
                world.m_7731_(pos.m_142082_(lx, 0, 1), this.hollowOrNormal(world, shouldMakeAllHollow, hollowLogState, logState), 3);
                if (rand.nextInt(3) > 0) {
                    world.m_7731_(pos.m_142082_(lx, 1, 1), this.mossOrSeagrass(world, pos.m_142082_(lx, 1, 1)), 3);
                    this.m_159739_(world, pos.m_142082_(lx, 0, 1));
                }
            }
        }
        else {
            logState = (BlockState)logState.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Z);
            if (hollowLogState != null) {
                hollowLogState = (BlockState)((BlockState)hollowLogState.m_61124_((Property)HollowLogHorizontal.HORIZONTAL_AXIS, (Comparable)Direction.Axis.Z)).m_61124_((Property)HollowLogHorizontal.VARIANT, (Comparable)this.determineHollowProperties(world, pos, rand));
            }
            branchState = (BlockState)logState.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.X);
            for (int lz = 0; lz < length; ++lz) {
                world.m_7731_(pos.m_142082_(1, 0, lz), this.hollowOrNormal(world, shouldMakeAllHollow, hollowLogState, logState), 3);
                if (rand.nextInt(3) > 0) {
                    world.m_7731_(pos.m_142082_(1, 1, lz), this.mossOrSeagrass(world, pos.m_142082_(1, 1, lz)), 3);
                    this.m_159739_(world, pos.m_142082_(1, 0, lz));
                }
            }
        }
        if (rand.nextInt(3) > 0) {
            int bx;
            int bz;
            if (goingX) {
                bx = rand.nextInt(length);
                bz = (rand.nextBoolean() ? 2 : 0);
            }
            else {
                bx = (rand.nextBoolean() ? 2 : 0);
                bz = rand.nextInt(length);
            }
            world.m_7731_(pos.m_142082_(bx, 0, bz), branchState, 3);
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(bx, 1, bz), this.mossOrSeagrass(world, pos.m_142082_(bx, 1, bz)), 3);
                this.m_159739_(world, pos.m_142082_(bx, 0, bz));
            }
        }
        return true;
    }
    
    private BlockState mossOrSeagrass(final WorldGenLevel level, final BlockPos pos) {
        if (level.m_8055_(pos.m_6625_(2)).m_60767_() == Material.f_76280_) {
            return Blocks.f_50016_.m_49966_();
        }
        return (level.m_8055_(pos).m_60767_() == Material.f_76305_) ? Blocks.f_50037_.m_49966_() : ((Block)TFBlocks.MOSS_PATCH.get()).m_49966_();
    }
    
    private BlockState hollowOrNormal(final WorldGenLevel level, final boolean shouldBeHollow, final BlockState hollow, final BlockState normal) {
        return ((shouldBeHollow || level.m_5822_().nextInt(3) == 0) && hollow != null) ? hollow : normal;
    }
    
    private HollowLogVariants.Horizontal determineHollowProperties(final WorldGenLevel world, final BlockPos pos, final Random rand) {
        return (world.m_8055_(pos).m_60767_() == Material.f_76305_) ? HollowLogVariants.Horizontal.WATERLOGGED : (world.m_8055_(pos).m_60620_((Tag)BlockTags.f_144279_) ? HollowLogVariants.Horizontal.SNOW : ((rand.nextInt(5) == 0) ? HollowLogVariants.Horizontal.MOSS_AND_GRASS : ((rand.nextInt(3) == 0) ? HollowLogVariants.Horizontal.MOSS : HollowLogVariants.Horizontal.EMPTY)));
    }
}
