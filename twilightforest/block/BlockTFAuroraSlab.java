// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.Facing;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockSlab;

public class BlockTFAuroraSlab extends BlockSlab
{
    private IIcon sideIcon;
    
    public BlockTFAuroraSlab(final boolean isDouble) {
        super(isDouble, Material.field_151598_x);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
        this.func_149713_g(isDouble ? 255 : 0);
    }
    
    public int func_149720_d(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        return TFBlocks.auroraPillar.func_149720_d(par1IBlockAccess, -x, y, -z);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149635_D() {
        return this.func_149720_d(null, 0, 0, 16);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149741_i(final int meta) {
        return this.func_149635_D();
    }
    
    public String func_150002_b(final int var1) {
        return super.func_149739_a();
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int side, final int meta) {
        if (side == 0 || side == 1) {
            return this.field_149761_L;
        }
        return this.sideIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = TFBlocks.auroraPillar.func_149691_a(0, 0);
        this.sideIcon = iconRegister.func_94245_a("TwilightForest:aurora_slab_side");
    }
    
    public Item func_149650_a(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.func_150898_a((Block)TFBlocks.auroraSlab);
    }
    
    protected ItemStack func_149644_j(final int meta) {
        return new ItemStack(Item.func_150898_a((Block)TFBlocks.auroraSlab), 2, 0);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_149646_a(final IBlockAccess world, final int x, final int y, final int z, final int side) {
        if (this.field_150004_a) {
            return super.func_149646_a(world, x, y, z, side);
        }
        if (side != 1 && side != 0 && !super.func_149646_a(world, x, y, z, side)) {
            return false;
        }
        final int i1 = x + Facing.field_71586_b[Facing.field_71588_a[side]];
        final int j1 = y + Facing.field_71587_c[Facing.field_71588_a[side]];
        final int k1 = z + Facing.field_71585_d[Facing.field_71588_a[side]];
        final boolean flag = (world.func_72805_g(i1, j1, k1) & 0x8) != 0x0;
        return flag ? (side == 0 || (side == 1 && super.func_149646_a(world, x, y, z, side)) || (!isSingleSlab(world.func_147439_a(x, y, z)) || (world.func_72805_g(x, y, z) & 0x8) == 0x0)) : (side == 1 || (side == 0 && super.func_149646_a(world, x, y, z, side)) || (!isSingleSlab(world.func_147439_a(x, y, z)) || (world.func_72805_g(x, y, z) & 0x8) != 0x0));
    }
    
    @SideOnly(Side.CLIENT)
    private static boolean isSingleSlab(final Block p_150003_0_) {
        return p_150003_0_ == TFBlocks.auroraSlab;
    }
}
