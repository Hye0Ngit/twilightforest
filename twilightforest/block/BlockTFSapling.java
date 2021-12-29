// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.gen.feature.WorldGenerator;
import twilightforest.world.TFGenSmallTwilightOak;
import twilightforest.world.TFGenSmallRainboak;
import twilightforest.world.TFGenLargeRainboak;
import twilightforest.world.TFGenSortingTree;
import twilightforest.world.TFGenMinersTree;
import twilightforest.world.TFGenTreeOfTransformation;
import twilightforest.world.TFGenTreeOfTime;
import twilightforest.world.TFGenHollowTree;
import twilightforest.world.TFGenDarkCanopyTree;
import twilightforest.world.TFGenMangroveTree;
import twilightforest.world.TFGenCanopyTree;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.util.Icon;
import net.minecraft.block.BlockSapling;

public class BlockTFSapling extends BlockSapling
{
    private Icon[] icons;
    private String[] iconNames;
    
    protected BlockTFSapling(final int par1) {
        super(par1);
        this.iconNames = new String[] { "sapling_oak", "sapling_canopy", "sapling_mangrove", "sapling_darkwood", "sapling_hollow_oak", "sapling_time", "sapling_transformation", "sapling_mining", "sapling_sorting", "sapling_rainboak" };
        final float var3 = 0.4f;
        this.func_71905_a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, var3 * 2.0f, 0.5f + var3);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public void func_71847_b(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.field_72995_K) {
            this.func_72262_c(par1World, x, y, z);
            if (par1World.func_72957_l(x, y + 1, z) >= 9 && par5Random.nextInt(7) == 0) {
                final int var6 = par1World.func_72805_g(x, y, z);
                this.func_72269_c(par1World, x, y, z, par5Random);
            }
        }
    }
    
    public void func_72269_c(final World world, final int x, final int y, final int z, final Random rand) {
        final int meta = world.func_72805_g(x, y, z);
        WorldGenerator treeGenerator = null;
        final int var8 = 0;
        final int var9 = 0;
        final boolean largeTree = false;
        if (meta == 1) {
            treeGenerator = new TFGenCanopyTree(true);
        }
        else if (meta == 2) {
            treeGenerator = new TFGenMangroveTree(true);
        }
        else if (meta == 3) {
            treeGenerator = new TFGenDarkCanopyTree(true);
        }
        else if (meta == 4) {
            treeGenerator = new TFGenHollowTree(true);
        }
        else if (meta == 5) {
            treeGenerator = new TFGenTreeOfTime(true);
        }
        else if (meta == 6) {
            treeGenerator = new TFGenTreeOfTransformation(true);
        }
        else if (meta == 7) {
            treeGenerator = new TFGenMinersTree(true);
        }
        else if (meta == 8) {
            treeGenerator = new TFGenSortingTree(true);
        }
        else if (meta == 9) {
            treeGenerator = ((rand.nextInt(7) == 0) ? new TFGenLargeRainboak(true) : new TFGenSmallRainboak(true));
        }
        else {
            treeGenerator = new TFGenSmallTwilightOak(true);
        }
        if (largeTree) {
            world.func_72832_d(x + var8, y, z + var9, 0, 0, 4);
            world.func_72832_d(x + var8 + 1, y, z + var9, 0, 0, 4);
            world.func_72832_d(x + var8, y, z + var9 + 1, 0, 0, 4);
            world.func_72832_d(x + var8 + 1, y, z + var9 + 1, 0, 0, 4);
        }
        else {
            world.func_72832_d(x, y, z, 0, 0, 4);
        }
        if (!treeGenerator.func_76484_a(world, rand, x + var8, y, z + var9)) {
            if (largeTree) {
                world.func_72832_d(x + var8, y, z + var9, this.field_71990_ca, meta, 4);
                world.func_72832_d(x + var8 + 1, y, z + var9, this.field_71990_ca, meta, 4);
                world.func_72832_d(x + var8, y, z + var9 + 1, this.field_71990_ca, meta, 4);
                world.func_72832_d(x + var8 + 1, y, z + var9 + 1, this.field_71990_ca, meta, 4);
            }
            else {
                world.func_72832_d(x, y, z, this.field_71990_ca, meta, 4);
            }
        }
    }
    
    public Icon func_71858_a(final int side, final int metadata) {
        if (metadata < this.icons.length) {
            return this.icons[metadata];
        }
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        this.icons = new Icon[this.iconNames.length];
        for (int i = 0; i < this.icons.length; ++i) {
            this.icons[i] = par1IconRegister.func_94245_a("twilightforest:" + this.iconNames[i]);
        }
    }
    
    public int func_71899_b(final int par1) {
        return par1;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
        par3List.add(new ItemStack(par1, 1, 8));
        par3List.add(new ItemStack(par1, 1, 9));
    }
}
