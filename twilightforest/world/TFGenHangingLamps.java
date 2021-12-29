// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenHangingLamps extends TFGenerator
{
    private static final int MAX_HANG = 8;
    
    public boolean func_76484_a(final World par1World, final Random par2Random, final int x, final int y, final int z) {
        final int copyX = x;
        final int copyZ = z;
        if (par1World.func_72799_c(x, y, z) && TFGenerator.surroundedByAir((IBlockAccess)par1World, x, y, z) && this.areLeavesAbove(par1World, x, y, z) && this.isClearBelow(par1World, x, y, z)) {
            par1World.func_94575_c(x, y, z, Block.field_72014_bd.field_71990_ca);
            for (int cy = 1; cy < 8; ++cy) {
                final Material above = par1World.func_72803_f(x, y + cy, z);
                if (above == Material.field_76245_d) {
                    break;
                }
                if (above == Material.field_76257_i) {
                    break;
                }
                par1World.func_94575_c(x, y + cy, z, Block.field_72031_aZ.field_71990_ca);
            }
        }
        return false;
    }
    
    private boolean areLeavesAbove(final World par1World, final int x, final int y, final int z) {
        boolean areLeavesAbove = false;
        for (int cy = 1; cy < 8; ++cy) {
            final Material above = par1World.func_72803_f(x, y + cy, z);
            if (above == Material.field_76245_d || above == Material.field_76257_i) {
                areLeavesAbove = true;
            }
        }
        return areLeavesAbove;
    }
    
    private boolean isClearBelow(final World par1World, final int x, final int y, final int z) {
        boolean isClearBelow = true;
        for (int cy = 1; cy < 4; ++cy) {
            if (par1World.func_72797_t(x, y - cy, z)) {
                isClearBelow = false;
            }
        }
        return isClearBelow;
    }
}
