// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockTFDarkLeaves extends Block
{
    protected BlockTFDarkLeaves() {
        super(Material.field_151584_j);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
        this.func_149672_a(Block.field_149779_h);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.field_149768_d = "TwilightForest:darkwood_leaves2";
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
                final int i2 = world.func_72807_a(x + dx, z + dz).func_150571_c(x + dx, y, z + dz);
                red += (i2 & 0xFF0000) >> 16;
                grn += (i2 & 0xFF00) >> 8;
                blu += (i2 & 0xFF);
            }
        }
        return (red / 9 & 0xFF) << 16 | (grn / 9 & 0xFF) << 8 | (blu / 9 & 0xFF);
    }
    
    public int func_149692_a(final int meta) {
        return 3;
    }
    
    public int getFlammability(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection face) {
        return 1;
    }
    
    public int getFireSpreadSpeed(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection face) {
        return 0;
    }
    
    public int func_149745_a(final Random par1Random) {
        return (par1Random.nextInt(40) == 0) ? 1 : 0;
    }
    
    public Item func_149650_a(final int meta, final Random par2Random, final int par3) {
        return Item.func_150898_a(TFBlocks.sapling);
    }
    
    public void func_149690_a(final World par1World, final int par2, final int par3, final int par4, final int meta, final float par6, final int fortune) {
        if (!par1World.field_72995_K && par1World.field_73012_v.nextInt(40) == 0) {
            final Item var9 = this.func_149650_a(meta, par1World.field_73012_v, fortune);
            this.func_149642_a(par1World, par2, par3, par4, new ItemStack(var9, 1, this.func_149692_a(meta)));
        }
    }
}
