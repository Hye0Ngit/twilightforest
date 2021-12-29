// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.world.IWorld;
import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenFallenSmallLog extends Feature<NoFeatureConfig>
{
    public TFGenFallenSmallLog(final Codec<NoFeatureConfig> configIn) {
        super((Codec)configIn);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        final boolean goingX = rand.nextBoolean();
        final int length = rand.nextInt(4) + 3;
        if (goingX) {
            if (!FeatureUtil.isAreaSuitable((IWorld)world, pos, length, 3, 2)) {
                return false;
            }
        }
        else if (!FeatureUtil.isAreaSuitable((IWorld)world, pos, 3, length, 2)) {
            return false;
        }
        BlockState logState = null;
        switch (rand.nextInt(7)) {
            default: {
                logState = ((RotatedPillarBlock)TFBlocks.oak_log.get()).func_176223_P();
                break;
            }
            case 1: {
                logState = ((RotatedPillarBlock)TFBlocks.canopy_log.get()).func_176223_P();
                break;
            }
            case 2: {
                logState = ((RotatedPillarBlock)TFBlocks.mangrove_log.get()).func_176223_P();
                break;
            }
            case 3: {
                logState = Blocks.field_196617_K.func_176223_P();
                break;
            }
            case 4: {
                logState = Blocks.field_196618_L.func_176223_P();
                break;
            }
            case 5: {
                logState = Blocks.field_196619_M.func_176223_P();
                break;
            }
            case 6: {
                logState = Blocks.field_196620_N.func_176223_P();
                break;
            }
        }
        BlockState branchState;
        if (goingX) {
            logState = (BlockState)logState.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.X);
            branchState = (BlockState)logState.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Z);
            for (int lx = 0; lx < length; ++lx) {
                world.func_180501_a(pos.func_177982_a(lx, 0, 1), logState, 3);
                if (rand.nextInt(3) > 0) {
                    world.func_180501_a(pos.func_177982_a(lx, 1, 1), ((Block)TFBlocks.moss_patch.get()).func_176223_P(), 3);
                }
            }
        }
        else {
            logState = (BlockState)logState.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Z);
            branchState = (BlockState)logState.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.X);
            for (int lz = 0; lz < length; ++lz) {
                world.func_180501_a(pos.func_177982_a(1, 0, lz), logState, 3);
                if (rand.nextInt(3) > 0) {
                    world.func_180501_a(pos.func_177982_a(1, 1, lz), ((Block)TFBlocks.moss_patch.get()).func_176223_P(), 3);
                }
            }
        }
        if (rand.nextInt(3) > 0) {
            if (goingX) {
                final int bx = rand.nextInt(length);
                final int bz = rand.nextBoolean() ? 2 : 0;
                world.func_180501_a(pos.func_177982_a(bx, 0, bz), branchState, 3);
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(bx, 1, bz), ((Block)TFBlocks.moss_patch.get()).func_176223_P(), 3);
                }
            }
            else {
                final int bx = rand.nextBoolean() ? 2 : 0;
                final int bz = rand.nextInt(length);
                world.func_180501_a(pos.func_177982_a(bx, 0, bz), branchState, 3);
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(bx, 1, bz), ((Block)TFBlocks.moss_patch.get()).func_176223_P(), 3);
                }
            }
        }
        return true;
    }
}
