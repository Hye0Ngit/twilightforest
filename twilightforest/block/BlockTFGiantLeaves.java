// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class BlockTFGiantLeaves extends BlockTFGiantBlock
{
    public BlockTFGiantLeaves() {
        super((Block)Blocks.field_150362_t);
        this.func_149711_c(12.8f);
        this.func_149713_g(1);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149635_D() {
        final double d0 = 0.5;
        final double d2 = 1.0;
        return ColorizerFoliage.func_77470_a(d0, d2);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149741_i(final int p_149741_1_) {
        return ColorizerFoliage.func_77468_c();
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149720_d(final IBlockAccess world, final int x, final int y, final int z) {
        int red = 0;
        int grn = 0;
        int blu = 0;
        for (int dz = -1; dz <= 1; ++dz) {
            for (int dx = -1; dx <= 1; ++dx) {
                final int nearbyColor = world.func_72807_a(x + dx, z + dz).func_150571_c(x + dx, y, z + dz);
                red += (nearbyColor & 0xFF0000) >> 16;
                grn += (nearbyColor & 0xFF00) >> 8;
                blu += (nearbyColor & 0xFF);
            }
        }
        return (red / 9 & 0xFF) << 16 | (grn / 9 & 0xFF) << 8 | (blu / 9 & 0xFF);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_149646_a(final IBlockAccess world, final int x, final int y, final int z, final int side) {
        switch (side) {
            case 0: {
                return (y & 0x3) == 0x3;
            }
            case 1: {
                return (y & 0x3) == 0x0;
            }
            case 2: {
                return (z & 0x3) == 0x3;
            }
            case 3: {
                return (z & 0x3) == 0x0;
            }
            case 4: {
                return (x & 0x3) == 0x3;
            }
            case 5: {
                return (x & 0x3) == 0x0;
            }
            default: {
                return super.func_149646_a(world, x, y, z, side);
            }
        }
    }
}
