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
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MagicWoodVariant;
import twilightforest.block.BlockTFMagicLog;
import twilightforest.block.TFBlocks;

public class TFGenMinersTree extends TFTreeGenerator
{
    public TFGenMinersTree() {
        this(false);
    }
    
    public TFGenMinersTree(final boolean notify) {
        super(notify);
        this.treeState = TFBlocks.magic_log.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.MINE);
        this.branchState = this.treeState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = TFBlocks.magic_leaves.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.MINE).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
        this.rootState = TFBlocks.root.func_176223_P();
    }
    
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        if (pos.func_177956_o() >= 244) {
            return false;
        }
        final IBlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockAccess)world, pos.func_177977_b(), EnumFacing.UP, this.source)) {
            return false;
        }
        for (int dy = 0; dy < 10; ++dy) {
            this.func_175903_a(world, pos.func_177981_b(dy), this.branchState);
        }
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 9, 1), true);
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 9, 2), false);
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 8, 3), false);
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 7, 4), false);
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 6, 5), false);
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 9, -1), true);
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 9, -2), false);
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 8, -3), false);
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 7, -4), false);
        this.putBranchWithLeaves(world, pos.func_177982_a(0, 6, -5), false);
        this.func_175903_a(world, pos.func_177984_a(), TFBlocks.magic_log_core.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.MINE));
        world.func_175684_a(pos.func_177984_a(), TFBlocks.magic_log_core, TFBlocks.magic_log_core.func_149738_a(world));
        if (TFGenerator.hasAirAround(world, pos.func_177977_b())) {
            this.func_175903_a(world, pos.func_177977_b(), this.treeState);
        }
        else {
            this.func_175903_a(world, pos.func_177977_b(), this.rootState);
        }
        final int numRoots = 3 + rand.nextInt(2);
        final double offset = rand.nextDouble();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, pos, offset, b);
        }
        return true;
    }
    
    protected void putBranchWithLeaves(final World world, final BlockPos pos, final boolean bushy) {
        this.func_175903_a(world, pos, this.branchState);
        for (int lx = -1; lx <= 1; ++lx) {
            for (int ly = -1; ly <= 1; ++ly) {
                for (int lz = -1; lz <= 1; ++lz) {
                    if (bushy || Math.abs(ly) <= 0 || Math.abs(lx) <= 0) {
                        TFGenerator.putLeafBlock(this, world, pos.func_177982_a(lx, ly, lz), this.leafState);
                    }
                }
            }
        }
    }
}
