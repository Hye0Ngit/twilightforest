// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MagicWoodVariant;
import twilightforest.block.BlockTFMagicLog;
import twilightforest.block.TFBlocks;
import net.minecraft.block.state.IBlockState;

public class TFGenSortingTree extends TFGenerator
{
    protected IBlockState treeState;
    protected IBlockState branchState;
    protected IBlockState leafState;
    protected IBlockState rootState;
    
    public TFGenSortingTree() {
        this(false);
    }
    
    public TFGenSortingTree(final boolean notify) {
        super(notify);
        this.treeState = TFBlocks.magic_log.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.SORT);
        this.branchState = this.treeState.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = TFBlocks.magic_leaves.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.SORT).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
        this.rootState = TFBlocks.root.func_176223_P();
    }
    
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        final Material materialUnder = world.func_180495_p(pos.func_177977_b()).func_185904_a();
        if ((materialUnder != Material.field_151577_b && materialUnder != Material.field_151578_c) || pos.func_177956_o() >= 244) {
            return false;
        }
        for (int dy = 0; dy < 4; ++dy) {
            this.func_175903_a(world, pos.func_177981_b(dy), this.treeState);
        }
        this.putLeaves(world, pos.func_177981_b(2), false);
        this.putLeaves(world, pos.func_177981_b(3), false);
        this.func_175903_a(world, pos.func_177984_a(), TFBlocks.magic_log_core.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.SORT));
        return true;
    }
    
    private void putLeaves(final World world, final BlockPos pos, final boolean bushy) {
        for (int lx = -1; lx <= 1; ++lx) {
            for (int ly = -1; ly <= 1; ++ly) {
                for (int lz = -1; lz <= 1; ++lz) {
                    if (bushy || Math.abs(ly) <= 0 || Math.abs(lx) + Math.abs(lz) <= 1) {
                        TFGenerator.putLeafBlock(this, world, pos.func_177982_a(lx, ly, lz), this.leafState);
                    }
                }
            }
        }
    }
}
