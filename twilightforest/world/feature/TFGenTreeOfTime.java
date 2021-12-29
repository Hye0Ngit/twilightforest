// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.state.Property;
import net.minecraft.block.RotatedPillarBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.IWorld;
import twilightforest.world.feature.config.TFTreeFeatureConfig;
import com.mojang.serialization.Codec;

public class TFGenTreeOfTime extends TFGenHollowTree
{
    public TFGenTreeOfTime(final Codec<TFTreeFeatureConfig> config) {
        super(config);
    }
    
    @Override
    public boolean generate(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> trunk, final Set<BlockPos> leaves, final Set<BlockPos> branch, final Set<BlockPos> root, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final int height = 8;
        final int diameter = 1;
        if (pos.func_177956_o() < 1 || pos.func_177956_o() + height + diameter > 256) {
            return false;
        }
        final BlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockReader)world, pos.func_177977_b(), Direction.UP, config.getSapling(random, pos))) {
            return false;
        }
        this.buildTrunk(world, random, pos, trunk, branch, root, diameter, height, mbb, config);
        this.buildTinyCrown(world, random, pos, leaves, branch, diameter, height, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, 1, 0, 12, 0.75, 3, 5, 3, false, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, 1, 2, 18, 0.9, 3, 5, 3, false, mbb, config);
        world.func_180501_a(pos.func_177982_a(-1, 2, 0), (BlockState)((Block)TFBlocks.time_log_core.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Y), 3);
        return true;
    }
    
    protected void buildTinyCrown(final IWorld world, final Random random, final BlockPos pos, final Set<BlockPos> leaves, final Set<BlockPos> branch, final int diameter, final int height, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        final int crownRadius = 4;
        final int bvar = 1;
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height - crownRadius, 0, crownRadius, 0.35, bvar, bvar + 2, 1, true, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height - crownRadius / 2, 0, crownRadius, 0.28, bvar, bvar + 2, 1, true, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height, 0, crownRadius, 0.15, 2, 4, 0, true, mbb, config);
        this.buildBranchRing(world, random, pos, leaves, branch, diameter, height, 0, crownRadius / 2, 0.05, bvar, bvar + 2, 0, true, mbb, config);
    }
}
