// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;
import java.util.List;

public class BlockTFLeaves extends akm
{
    int oakColor;
    int canopyColor;
    int mangroveColor;
    
    protected BlockTFLeaves(final int i, final int j) {
        super(i, j);
        this.oakColor = 4764952;
        this.canopyColor = 6330464;
        this.mangroveColor = 8431445;
        this.c(0.2f);
        this.h(2);
        this.a(amj.g);
        this.r();
    }
    
    public int o() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return xr.a(var1, var2);
    }
    
    public int g_(final int par1) {
        return ((par1 & 0x3) == 0x1) ? this.canopyColor : (((par1 & 0x3) == 0x2) ? this.mangroveColor : this.oakColor);
    }
    
    public int b(final yf par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.h(x, y, z);
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int var9 = -1; var9 <= 1; ++var9) {
            for (int var10 = -1; var10 <= 1; ++var10) {
                final int var11 = par1IBlockAccess.a(x + var10, z + var9).l();
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
    
    public boolean c() {
        return amj.N.c();
    }
    
    public int a(final int i, final int j) {
        return amj.N.a(i, ((j & 0x3) == 0x3) ? 0 : j);
    }
    
    public boolean a(final yf iblockaccess, final int i, final int j, final int k, final int l) {
        return amj.N.a(iblockaccess, i, j, k, l);
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        par3List.add(new um(par1, 1, 0));
        par3List.add(new um(par1, 1, 1));
        par3List.add(new um((amj)this, 1, 2));
        par3List.add(new um((amj)this, 1, 3));
    }
    
    public int a(final Random par1Random) {
        return (par1Random.nextInt(40) == 0) ? 1 : 0;
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return TFBlocks.sapling.cm;
    }
    
    public int b(final int par1) {
        final int leafType = par1 & 0x3;
        return (leafType == 3) ? 9 : leafType;
    }
    
    public void a(final xv par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final int par7) {
        if (!par1World.J) {
            byte chance = 40;
            if ((par5 & 0x3) == 0x2) {
                chance = 20;
            }
            if (par1World.u.nextInt(chance) == 0) {
                final int var9 = this.a(par5, par1World.u, par7);
                this.b(par1World, par2, par3, par4, new um(var9, 1, this.b(par5)));
            }
        }
    }
}
