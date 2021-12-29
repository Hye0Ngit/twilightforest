// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;

public class BlockTFLeaves extends BlockLeaves
{
    int oakColor;
    int canopyColor;
    int mangroveColor;
    
    protected BlockTFLeaves(final int i) {
        super(i);
        this.oakColor = 4764952;
        this.canopyColor = 6330464;
        this.mangroveColor = 8431445;
        this.func_71848_c(0.2f);
        this.func_71868_h(2);
        this.func_71884_a(Block.field_71965_g);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_71933_m() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return ColorizerFoliage.func_77470_a(var1, var2);
    }
    
    public int func_71889_f_(final int par1) {
        return ((par1 & 0x3) == 0x1) ? this.canopyColor : (((par1 & 0x3) == 0x2) ? this.mangroveColor : this.oakColor);
    }
    
    public int func_71920_b(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z);
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int var9 = -1; var9 <= 1; ++var9) {
            for (int var10 = -1; var10 <= 1; ++var10) {
                final int var11 = par1IBlockAccess.func_72807_a(x + var10, z + var9).func_76726_l();
                red += (var11 & 0xFF0000) >> 16;
                green += (var11 & 0xFF00) >> 8;
                blue += (var11 & 0xFF);
            }
        }
        final int normalColor = (red / 9 & 0xFF) << 16 | (green / 9 & 0xFF) << 8 | (blue / 9 & 0xFF);
        if ((meta & 0x3) == 0x1) {
            return ((normalColor & 0xFEFEFE) + 4627046) / 2;
        }
        if ((meta & 0x3) == 0x2) {
            return ((normalColor & 0xFEFEFE) + 12641940) / 2;
        }
        if ((meta & 0x3) == 0x3) {
            red = x * 32 + y * 16;
            if ((red & 0x100) != 0x0) {
                red = 255 - (red & 0xFF);
            }
            red &= 0xFF;
            blue = y * 32 + z * 16;
            if ((blue & 0x100) != 0x0) {
                blue = 255 - (blue & 0xFF);
            }
            blue ^= 0xFF;
            green = x * 16 + z * 32;
            if ((green & 0x100) != 0x0) {
                green = 255 - (green & 0xFF);
            }
            green &= 0xFF;
            return red << 16 | blue << 8 | green;
        }
        return normalColor;
    }
    
    public boolean func_71926_d() {
        return Block.field_71952_K.func_71926_d();
    }
    
    public Icon func_71858_a(final int i, final int j) {
        return Block.field_71952_K.func_71858_a(i, ((j & 0x3) == 0x3) ? 0 : j);
    }
    
    public boolean func_71877_c(final IBlockAccess iblockaccess, final int i, final int j, final int k, final int l) {
        return Block.field_71952_K.func_71877_c(iblockaccess, i, j, k, l);
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack((Block)this, 1, 2));
        par3List.add(new ItemStack((Block)this, 1, 3));
    }
    
    public int func_71925_a(final Random par1Random) {
        return (par1Random.nextInt(40) == 0) ? 1 : 0;
    }
    
    public int func_71885_a(final int par1, final Random par2Random, final int par3) {
        return TFBlocks.sapling.field_71990_ca;
    }
    
    public int func_71899_b(final int par1) {
        final int leafType = par1 & 0x3;
        return (leafType == 3) ? 9 : leafType;
    }
    
    public void func_71914_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final int par7) {
        if (!par1World.field_72995_K) {
            byte chance = 40;
            if ((par5 & 0x3) == 0x2) {
                chance = 20;
            }
            if (par1World.field_73012_v.nextInt(chance) == 0) {
                final int var9 = this.func_71885_a(par5, par1World.field_73012_v, par7);
                this.func_71929_a(par1World, par2, par3, par4, new ItemStack(var9, 1, this.func_71899_b(par5)));
            }
        }
    }
}
