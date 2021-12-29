// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenHangingLamps extends TFGenerator
{
    private static final int MAX_HANG = 8;
    
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        if (!world.func_175623_d(pos) || !TFGenerator.surroundedByAir((IBlockAccess)world, pos)) {
            return false;
        }
        if (!this.isClearBelow(world, pos)) {
            return false;
        }
        final int dist = this.findLeavesAbove(world, pos);
        if (dist < 0) {
            return false;
        }
        world.func_180501_a(pos, TFBlocks.firefly_jar.func_176223_P(), 18);
        for (int cy = 1; cy < dist; ++cy) {
            world.func_180501_a(pos.func_177981_b(cy), Blocks.field_180407_aO.func_176223_P(), 18);
        }
        return true;
    }
    
    private int findLeavesAbove(final World world, final BlockPos pos) {
        for (int cy = 1; cy < 8; ++cy) {
            final Material above = world.func_180495_p(pos.func_177981_b(cy)).func_185904_a();
            if (above.func_76220_a() || above == Material.field_151584_j) {
                return cy;
            }
        }
        return -1;
    }
    
    private boolean isClearBelow(final World world, final BlockPos pos) {
        for (int cy = 1; cy < 4; ++cy) {
            if (world.func_180495_p(pos.func_177979_c(cy)).isSideSolid((IBlockAccess)world, pos, EnumFacing.UP)) {
                return false;
            }
        }
        return true;
    }
}
