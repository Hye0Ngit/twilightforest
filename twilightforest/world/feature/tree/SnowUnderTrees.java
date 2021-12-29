// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature.tree;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;
import net.minecraft.block.SnowyDirtBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.LeavesBlock;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class SnowUnderTrees extends Feature<NoFeatureConfig>
{
    public SnowUnderTrees(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        final BlockPos.Mutable mPos = new BlockPos.Mutable();
        final BlockPos.Mutable mPosDown = new BlockPos.Mutable();
        for (int xi = 0; xi < 16; ++xi) {
            for (int zi = 0; zi < 16; ++zi) {
                final int x = pos.func_177958_n() + xi;
                final int z = pos.func_177952_p() + zi;
                mPos.func_181079_c(x, world.func_201676_a(Heightmap.Type.MOTION_BLOCKING, x, z) - 1, z);
                if (world.func_180495_p((BlockPos)mPos).func_177230_c() instanceof LeavesBlock) {
                    mPos.func_181079_c(x, world.func_201676_a(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z), z);
                    final BlockState state = world.func_180495_p((BlockPos)mPos);
                    if (state.isAir((IBlockReader)world, (BlockPos)mPos)) {
                        mPosDown.func_189533_g((Vector3i)mPos).func_189536_c(Direction.DOWN);
                        final BlockState stateBelow = world.func_180495_p((BlockPos)mPosDown);
                        if (stateBelow.func_224755_d((IBlockReader)world, (BlockPos)mPosDown, Direction.UP)) {
                            world.func_180501_a((BlockPos)mPos, Blocks.field_150433_aE.func_176223_P(), 2);
                            if (stateBelow.func_235901_b_((Property)SnowyDirtBlock.field_196382_a)) {
                                world.func_180501_a((BlockPos)mPosDown, (BlockState)stateBelow.func_206870_a((Property)SnowyDirtBlock.field_196382_a, (Comparable)true), 2);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
