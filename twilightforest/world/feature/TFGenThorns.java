// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockRotatedPillar;
import twilightforest.block.TFBlocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenThorns extends TFGenerator
{
    private static final int MAX_SPREAD = 7;
    private static final int CHANCE_OF_BRANCH = 3;
    private static final int CHANCE_OF_LEAF = 3;
    private static final int CHANCE_LEAF_IS_ROSE = 50;
    
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        final int nextLength = 2 + rand.nextInt(4);
        final int maxLength = 2 + rand.nextInt(4) + rand.nextInt(4) + rand.nextInt(4);
        this.placeThorns(world, rand, pos, nextLength, EnumFacing.UP, maxLength, pos);
        return true;
    }
    
    private void placeThorns(final World world, final Random rand, final BlockPos pos, final int length, final EnumFacing dir, final int maxLength, final BlockPos oPos) {
        boolean complete = false;
        for (int i = 0; i < length; ++i) {
            final BlockPos dPos = pos.func_177967_a(dir, i);
            if (Math.abs(dPos.func_177958_n() - oPos.func_177958_n()) >= 7 || Math.abs(dPos.func_177952_p() - oPos.func_177952_p()) >= 7 || !this.canPlaceThorns(world, dPos)) {
                break;
            }
            this.func_175903_a(world, dPos, TFBlocks.thorns.func_176223_P().func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)dir.func_176740_k()));
            if (i == length - 1) {
                complete = true;
                if (rand.nextInt(3) == 0 && world.func_175623_d(dPos.func_177972_a(dir))) {
                    if (rand.nextInt(50) > 0) {
                        this.func_175903_a(world, dPos.func_177972_a(dir), TFBlocks.twilight_leaves_3.func_176223_P().func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false));
                    }
                    else {
                        this.func_175903_a(world, dPos.func_177972_a(dir), TFBlocks.thorn_rose.func_176223_P());
                    }
                }
            }
        }
        if (complete && maxLength > 1) {
            final EnumFacing nextDir = EnumFacing.func_176741_a(rand);
            final BlockPos nextPos = pos.func_177967_a(dir, length - 1).func_177972_a(nextDir);
            final int nextLength = 1 + rand.nextInt(maxLength);
            this.placeThorns(world, rand, nextPos, nextLength, nextDir, maxLength - 1, oPos);
        }
        if (complete && length > 3 && rand.nextInt(3) == 0) {
            final int middle = rand.nextInt(length);
            final EnumFacing nextDir2 = EnumFacing.func_176741_a(rand);
            final BlockPos nextPos2 = pos.func_177967_a(dir, middle).func_177972_a(nextDir2);
            final int nextLength2 = 1 + rand.nextInt(maxLength);
            this.placeThorns(world, rand, nextPos2, nextLength2, nextDir2, maxLength - 1, oPos);
        }
        if (complete && length > 3 && rand.nextInt(3) == 0) {
            final int middle = rand.nextInt(length);
            final EnumFacing nextDir2 = EnumFacing.func_176741_a(rand);
            final BlockPos nextPos2 = pos.func_177967_a(dir, middle).func_177972_a(nextDir2);
            if (world.func_175623_d(nextPos2)) {
                this.func_175903_a(world, nextPos2, TFBlocks.twilight_leaves_3.func_176223_P().func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false));
            }
        }
    }
    
    private boolean canPlaceThorns(final World world, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos);
        return state.func_177230_c().isAir(state, (IBlockAccess)world, pos) || state.func_177230_c().isLeaves(state, (IBlockAccess)world, pos);
    }
}
