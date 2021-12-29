// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockTFTrollSteinn extends Block
{
    protected BlockTFTrollSteinn() {
        super(Material.field_151576_e);
        this.func_149711_c(2.0f);
        this.func_149752_b(15.0f);
        this.func_149672_a(Block.field_149769_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World world, final int x, final int y, final int z, final Random rand) {
        if (rand.nextInt(2) == 0) {
            this.sparkle(world, x, y, z, rand);
        }
    }
    
    private void sparkle(final World world, final int x, final int y, final int z, final Random rand) {
        final Random random = rand;
        final double pixel = 0.0625;
        final int threshhold = 8;
        for (int side = 0; side < 6; ++side) {
            double rx = x + random.nextFloat();
            double ry = y + random.nextFloat();
            double rz = z + random.nextFloat();
            if (side == 0 && !world.func_147439_a(x, y + 1, z).func_149662_c() && world.func_72957_l(x, y + 1, z) <= threshhold) {
                ry = y + 1 + pixel;
            }
            if (side == 1 && !world.func_147439_a(x, y - 1, z).func_149662_c() && world.func_72957_l(x, y - 1, z) <= threshhold) {
                ry = y + 0 - pixel;
            }
            if (side == 2 && !world.func_147439_a(x, y, z + 1).func_149662_c() && world.func_72957_l(x, y, z + 1) <= threshhold) {
                rz = z + 1 + pixel;
            }
            if (side == 3 && !world.func_147439_a(x, y, z - 1).func_149662_c() && world.func_72957_l(x, y, z - 1) <= threshhold) {
                rz = z + 0 - pixel;
            }
            if (side == 4 && !world.func_147439_a(x + 1, y, z).func_149662_c() && world.func_72957_l(x + 1, y, z) <= threshhold) {
                rx = x + 1 + pixel;
            }
            if (side == 5 && !world.func_147439_a(x - 1, y, z).func_149662_c() && world.func_72957_l(x - 1, y, z) <= threshhold) {
                rx = x + 0 - pixel;
            }
            if (rx < x || rx > x + 1 || ry < 0.0 || ry > y + 1 || rz < z || rz > z + 1) {
                world.func_72869_a("reddust", rx, ry, rz, -1.0, 0.2, -1.0);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.field_149761_L = Blocks.field_150341_Y.func_149691_a(0, 0);
    }
}
