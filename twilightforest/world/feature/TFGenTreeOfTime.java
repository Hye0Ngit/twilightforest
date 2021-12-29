// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLog;
import twilightforest.block.TFBlocks;

public class TFGenTreeOfTime extends TFGenHollowTree
{
    public TFGenTreeOfTime(final boolean notify) {
        super(notify);
        this.treeState = TFBlocks.magic_log.func_176223_P();
        this.branchState = this.treeState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = TFBlocks.magic_leaves.func_176223_P().func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
    }
    
    @Override
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        final int height = 8;
        final int diameter = 1;
        if (pos.func_177956_o() < 1 || pos.func_177956_o() + height + diameter > 256) {
            return false;
        }
        final IBlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockAccess)world, pos.func_177977_b(), EnumFacing.UP, this.source)) {
            return false;
        }
        this.buildTrunk(world, random, pos, diameter, height);
        this.buildTinyCrown(world, random, pos, diameter, height);
        this.buildBranchRing(world, random, pos, diameter, 1, 0, 12, 0, 0.75, 0.0, 3, 5, 3, false);
        this.buildBranchRing(world, random, pos, diameter, 1, 2, 18, 0, 0.9, 0.0, 3, 5, 3, false);
        this.func_175903_a(world, pos.func_177982_a(-1, 2, 0), TFBlocks.magic_log_core.func_176223_P());
        return true;
    }
    
    protected void buildTinyCrown(final World world, final Random random, final BlockPos pos, final int diameter, final int height) {
        final int crownRadius = 4;
        final int bvar = 1;
        this.buildBranchRing(world, random, pos, diameter, height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, pos, diameter, height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, pos, diameter, height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 0, true);
        this.buildBranchRing(world, random, pos, diameter, height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 0, true);
    }
}
