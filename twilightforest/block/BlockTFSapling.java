// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import twilightforest.item.TFItems;

public class BlockTFSapling extends aqf
{
    private mr[] icons;
    private String[] iconNames;
    
    protected BlockTFSapling(final int par1) {
        super(par1);
        this.iconNames = new String[] { "sapling_oak", "sapling_canopy", "sapling_mangrove", "sapling_darkwood", "sapling_hollow_oak", "sapling_time", "sapling_transformation", "sapling_mining", "sapling_sorting", "sapling_rainboak" };
        final float var3 = 0.4f;
        this.a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, var3 * 2.0f, 0.5f + var3);
        this.a((wv)TFItems.creativeTab);
    }
    
    public void a(final abv par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.I) {
            this.e(par1World, x, y, z);
            if (par1World.n(x, y + 1, z) >= 9 && par5Random.nextInt(7) == 0) {
                final int var6 = par1World.h(x, y, z);
                this.d(par1World, x, y, z, par5Random);
            }
        }
    }
    
    public void d(final abv world, final int x, final int y, final int z, final Random rand) {
        final int meta = world.h(x, y, z);
        afd treeGenerator = null;
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
            world.f(x + var8, y, z + var9, 0, 0, 4);
            world.f(x + var8 + 1, y, z + var9, 0, 0, 4);
            world.f(x + var8, y, z + var9 + 1, 0, 0, 4);
            world.f(x + var8 + 1, y, z + var9 + 1, 0, 0, 4);
        }
        else {
            world.f(x, y, z, 0, 0, 4);
        }
        if (!treeGenerator.a(world, rand, x + var8, y, z + var9)) {
            if (largeTree) {
                world.f(x + var8, y, z + var9, this.cF, meta, 4);
                world.f(x + var8 + 1, y, z + var9, this.cF, meta, 4);
                world.f(x + var8, y, z + var9 + 1, this.cF, meta, 4);
                world.f(x + var8 + 1, y, z + var9 + 1, this.cF, meta, 4);
            }
            else {
                world.f(x, y, z, this.cF, meta, 4);
            }
        }
    }
    
    public mr a(final int side, final int metadata) {
        if (metadata < this.icons.length) {
            return this.icons[metadata];
        }
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.icons = new mr[this.iconNames.length];
        for (int i = 0; i < this.icons.length; ++i) {
            this.icons[i] = par1IconRegister.a("TwilightForest:" + this.iconNames[i]);
        }
    }
    
    public int a(final int par1) {
        return par1;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
        par3List.add(new yd(par1, 1, 1));
        par3List.add(new yd(par1, 1, 2));
        par3List.add(new yd(par1, 1, 3));
        par3List.add(new yd(par1, 1, 4));
        par3List.add(new yd(par1, 1, 5));
        par3List.add(new yd(par1, 1, 6));
        par3List.add(new yd(par1, 1, 7));
        par3List.add(new yd(par1, 1, 8));
        par3List.add(new yd(par1, 1, 9));
    }
}
