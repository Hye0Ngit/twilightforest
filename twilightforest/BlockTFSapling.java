// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.List;
import twilightforest.world.TFGenSmallTwilightOak;
import twilightforest.world.TFGenSmallRainboak;
import twilightforest.world.TFGenLargeRainboak;
import twilightforest.world.TFGenTreeOfTime;
import twilightforest.world.TFGenHollowTree;
import twilightforest.world.TFGenDarkCanopyTree;
import twilightforest.world.TFGenMangroveTree;
import twilightforest.world.TFGenCanopyTree;
import java.util.Random;

public class BlockTFSapling extends alt
{
    protected BlockTFSapling(final int par1) {
        super(par1, 16);
        this.cl = 16;
        final float var3 = 0.4f;
        this.a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, var3 * 2.0f, 0.5f + var3);
        this.a(th.c);
    }
    
    public void b(final xv par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.J) {
            super.b(par1World, x, y, z, par5Random);
            if (par1World.m(x, y + 1, z) >= 9 && par5Random.nextInt(7) == 0) {
                final int var6 = par1World.h(x, y, z);
                if ((var6 & 0x8) == 0x0) {
                    par1World.c(x, y, z, var6 | 0x8);
                }
                else {
                    this.c(par1World, x, y, z, par5Random);
                }
            }
        }
    }
    
    public void c(final xv world, final int x, final int y, final int z, final Random rand) {
        final int meta = world.h(x, y, z);
        abf treeGenerator = null;
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
        else if (meta == 9) {
            treeGenerator = ((rand.nextInt(7) == 0) ? new TFGenLargeRainboak(true) : new TFGenSmallRainboak(true));
        }
        else {
            treeGenerator = new TFGenSmallTwilightOak(true);
        }
        if (largeTree) {
            world.b(x + var8, y, z + var9, 0);
            world.b(x + var8 + 1, y, z + var9, 0);
            world.b(x + var8, y, z + var9 + 1, 0);
            world.b(x + var8 + 1, y, z + var9 + 1, 0);
        }
        else {
            world.b(x, y, z, 0);
        }
        if (!treeGenerator.a(world, rand, x + var8, y, z + var9)) {
            if (largeTree) {
                world.c(x + var8, y, z + var9, this.cm, meta);
                world.c(x + var8 + 1, y, z + var9, this.cm, meta);
                world.c(x + var8, y, z + var9 + 1, this.cm, meta);
                world.c(x + var8 + 1, y, z + var9 + 1, this.cm, meta);
            }
            else {
                world.c(x, y, z, this.cm, meta);
            }
        }
    }
    
    public int a(final int side, final int metadata) {
        return 96 + metadata;
    }
    
    public int b(final int par1) {
        return par1;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        par3List.add(new um(par1, 1, 0));
        par3List.add(new um(par1, 1, 1));
        par3List.add(new um(par1, 1, 2));
        par3List.add(new um(par1, 1, 3));
        par3List.add(new um(par1, 1, 4));
        par3List.add(new um(par1, 1, 5));
        par3List.add(new um(par1, 1, 9));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
