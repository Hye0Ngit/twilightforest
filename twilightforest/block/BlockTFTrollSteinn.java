// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFTrollSteinn extends Block
{
    private static final int LIGHT_THRESHHOLD = 7;
    private IIcon blockIconLight;
    
    protected BlockTFTrollSteinn() {
        super(Material.field_151576_e);
        this.func_149711_c(2.0f);
        this.func_149752_b(15.0f);
        this.func_149672_a(Block.field_149769_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149658_d("TwilightForest:trollsteinn");
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
        final int threshhold = 7;
        for (int side = 0; side < 6; ++side) {
            double rx = x + random.nextFloat();
            double ry = y + random.nextFloat();
            double rz = z + random.nextFloat();
            if (side == 0 && !world.func_147439_a(x, y - 1, z).func_149662_c() && world.func_72957_l(x, y - 1, z) <= threshhold) {
                ry = y + 0 - pixel;
            }
            if (side == 1 && !world.func_147439_a(x, y + 1, z).func_149662_c() && world.func_72957_l(x, y + 1, z) <= threshhold) {
                ry = y + 1 + pixel;
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
                world.func_72869_a("reddust", rx, ry, rz, 0.25, -1.0, 0.5);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149673_e(final IBlockAccess world, final int x, final int y, final int z, final int side) {
        if (side == 0 && this.isBlockLit(world, x, y - 1, z)) {
            return this.blockIconLight;
        }
        if (side == 1 && this.isBlockLit(world, x, y + 1, z)) {
            return this.blockIconLight;
        }
        if (side == 2 && this.isBlockLit(world, x, y, z - 1)) {
            return this.blockIconLight;
        }
        if (side == 3 && this.isBlockLit(world, x, y, z + 1)) {
            return this.blockIconLight;
        }
        if (side == 4 && this.isBlockLit(world, x - 1, y, z)) {
            return this.blockIconLight;
        }
        if (side == 5 && this.isBlockLit(world, x + 1, y, z)) {
            return this.blockIconLight;
        }
        return this.func_149691_a(side, world.func_72805_g(x, y, z));
    }
    
    private boolean isBlockLit(final IBlockAccess world, final int x, final int y, final int z) {
        final int threshhold = 112;
        if (world.func_147439_a(x, y, z).func_149662_c()) {
            return false;
        }
        final int light = world.func_72802_i(x, y, z, 0);
        final int sky = light % 65536;
        final int block = light / 65536;
        return sky > threshhold || block > threshhold;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.field_149761_L = par1IconRegister.func_94245_a(this.func_149641_N());
        this.blockIconLight = par1IconRegister.func_94245_a(this.func_149641_N() + "_light");
    }
}
