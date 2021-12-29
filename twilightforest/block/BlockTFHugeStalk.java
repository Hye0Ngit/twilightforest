// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFHugeStalk extends Block
{
    private IIcon topIcon;
    
    protected BlockTFHugeStalk() {
        super(Material.field_151575_d);
        this.func_149711_c(1.25f);
        this.func_149752_b(7.0f);
        this.func_149658_d("TwilightForest:huge_stalk");
        this.func_149672_a(BlockTFHugeStalk.field_149779_h);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        super.func_149651_a(par1IconRegister);
        this.topIcon = par1IconRegister.func_94245_a(this.func_149641_N() + "_top");
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int side, final int meta) {
        if (side == 0 || side == 1) {
            return this.topIcon;
        }
        return this.field_149761_L;
    }
    
    public boolean canSustainLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public void func_149749_a(final World world, final int x, final int y, final int z, final Block myBlock, final int meta) {
        final byte radius = 4;
        final int rad1 = radius + 1;
        if (world.func_72904_c(x - rad1, y - rad1, z - rad1, x + rad1, y + rad1, z + rad1)) {
            for (int dx = -radius; dx <= radius; ++dx) {
                for (int dy = -radius; dy <= radius; ++dy) {
                    for (int dz = -radius; dz <= radius; ++dz) {
                        final Block block = world.func_147439_a(x + dx, y + dy, z + dz);
                        if (block.isLeaves((IBlockAccess)world, x + dx, y + dy, z + dz)) {
                            block.beginLeavesDecay(world, x + dx, y + dy, z + dz);
                        }
                    }
                }
            }
        }
    }
}
