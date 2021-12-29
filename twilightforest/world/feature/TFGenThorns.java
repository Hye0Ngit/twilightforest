// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.tags.ITag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.block.RotatedPillarBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenThorns extends Feature<NoFeatureConfig>
{
    private static final int MAX_SPREAD = 7;
    private static final int CHANCE_OF_BRANCH = 3;
    private static final int CHANCE_OF_LEAF = 3;
    private static final int CHANCE_LEAF_IS_ROSE = 50;
    
    public TFGenThorns(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        final int nextLength = 2 + rand.nextInt(4);
        final int maxLength = 2 + rand.nextInt(4) + rand.nextInt(4) + rand.nextInt(4);
        this.placeThorns(world, rand, pos, nextLength, Direction.UP, maxLength, pos);
        return true;
    }
    
    private void placeThorns(final ISeedReader world, final Random rand, final BlockPos pos, final int length, final Direction dir, final int maxLength, final BlockPos oPos) {
        boolean complete = false;
        for (int i = 0; i < length; ++i) {
            final BlockPos dPos = pos.func_177967_a(dir, i);
            if (!world.func_175710_j(pos) || Math.abs(dPos.func_177958_n() - oPos.func_177958_n()) >= 7 || Math.abs(dPos.func_177952_p() - oPos.func_177952_p()) >= 7 || !this.canPlaceThorns((IWorld)world, dPos)) {
                break;
            }
            world.func_180501_a(dPos, (BlockState)((Block)TFBlocks.brown_thorns.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)dir.func_176740_k()), 3);
            if (i == length - 1) {
                complete = true;
                if (rand.nextInt(3) == 0 && world.func_175623_d(dPos.func_177972_a(dir))) {
                    if (rand.nextInt(50) > 0) {
                        world.func_180501_a(dPos.func_177972_a(dir), ((Block)TFBlocks.thorn_leaves.get()).func_176223_P(), 3);
                    }
                    else {
                        world.func_180501_a(dPos.func_177972_a(dir), ((Block)TFBlocks.thorn_rose.get()).func_176223_P(), 3);
                    }
                }
            }
        }
        if (complete && maxLength > 1) {
            final Direction nextDir = Direction.func_239631_a_(rand);
            final BlockPos nextPos = pos.func_177967_a(dir, length - 1).func_177972_a(nextDir);
            final int nextLength = 1 + rand.nextInt(maxLength);
            this.placeThorns(world, rand, nextPos, nextLength, nextDir, maxLength - 1, oPos);
        }
        if (complete && length > 3 && rand.nextInt(3) == 0) {
            final int middle = rand.nextInt(length);
            final Direction nextDir2 = Direction.func_239631_a_(rand);
            final BlockPos nextPos2 = pos.func_177967_a(dir, middle).func_177972_a(nextDir2);
            final int nextLength2 = 1 + rand.nextInt(maxLength);
            this.placeThorns(world, rand, nextPos2, nextLength2, nextDir2, maxLength - 1, oPos);
        }
        if (complete && length > 3 && rand.nextInt(3) == 0) {
            final int middle = rand.nextInt(length);
            final Direction nextDir2 = Direction.func_239631_a_(rand);
            final BlockPos nextPos2 = pos.func_177967_a(dir, middle).func_177972_a(nextDir2);
            if (world.func_175623_d(nextPos2)) {
                world.func_180501_a(nextPos2, ((Block)TFBlocks.thorn_leaves.get()).func_176223_P(), 3);
            }
        }
    }
    
    private boolean canPlaceThorns(final IWorld world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        return state.func_177230_c().isAir(state, (IBlockReader)world, pos) || state.func_177230_c().func_203417_a((ITag)BlockTags.field_206952_E);
    }
}
