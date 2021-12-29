// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import java.util.Random;

public class BlockTFLeaves extends uf
{
    int oakColor;
    int canopyColor;
    int mangroveColor;
    private int[] b;
    
    protected BlockTFLeaves(final int i, final int j) {
        super(i, j);
        this.oakColor = 4764952;
        this.canopyColor = 6330464;
        this.mangroveColor = 8431445;
        this.c(0.2f);
        this.f(2);
        this.a(pb.g);
        this.k();
    }
    
    public int i() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return gu.a(var1, var2);
    }
    
    public int d(final int par1) {
        return ((par1 & 0x3) == 0x1) ? this.canopyColor : (((par1 & 0x3) == 0x2) ? this.mangroveColor : this.oakColor);
    }
    
    public int c(final ali par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int var5 = par1IBlockAccess.e(par2, par3, par4);
        if ((var5 & 0x3) == 0x2) {
            return this.mangroveColor;
        }
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int var6 = -1; var6 <= 1; ++var6) {
            for (int var7 = -1; var7 <= 1; ++var7) {
                final int var8 = par1IBlockAccess.a(par2 + var7, par4 + var6).l();
                red += (var8 & 0xFF0000) >> 16;
                green += (var8 & 0xFF00) >> 8;
                blue += (var8 & 0xFF);
            }
        }
        final int normalColor = (red / 9 & 0xFF) << 16 | (green / 9 & 0xFF) << 8 | (blue / 9 & 0xFF);
        if ((var5 & 0x3) == 0x1) {
            return ((normalColor & 0xFEFEFE) + 4627046) / 2;
        }
        return normalColor;
    }
    
    public void a(final xd world, final int i, final int j, final int k, final Random random) {
        if (world.F) {
            return;
        }
        final int l = world.e(i, j, k);
        if ((l & 0x8) != 0x0 && (l & 0x4) == 0x0) {
            final byte byte0 = 4;
            final int i2 = byte0 + 1;
            final byte byte2 = 32;
            final int j2 = byte2 * byte2;
            final int k2 = byte2 / 2;
            if (this.b == null) {
                this.b = new int[byte2 * byte2 * byte2];
            }
            if (world.b(i - i2, j - i2, k - i2, i + i2, j + i2, k + i2)) {
                for (int l2 = -byte0; l2 <= byte0; ++l2) {
                    for (int k3 = -byte0; k3 <= byte0; ++k3) {
                        for (int i3 = -byte0; i3 <= byte0; ++i3) {
                            final int k4 = world.a(i + l2, j + k3, k + i3);
                            if (k4 == pb.J.bO || k4 == TFBlocks.wood.bO) {
                                this.b[(l2 + k2) * j2 + (k3 + k2) * byte2 + (i3 + k2)] = 0;
                            }
                            else if (k4 == pb.K.bO || k4 == TFBlocks.leaves.bO) {
                                this.b[(l2 + k2) * j2 + (k3 + k2) * byte2 + (i3 + k2)] = -2;
                            }
                            else {
                                this.b[(l2 + k2) * j2 + (k3 + k2) * byte2 + (i3 + k2)] = -1;
                            }
                        }
                    }
                }
                for (int i4 = 1; i4 <= 4; ++i4) {
                    for (int l3 = -byte0; l3 <= byte0; ++l3) {
                        for (int j3 = -byte0; j3 <= byte0; ++j3) {
                            for (int l4 = -byte0; l4 <= byte0; ++l4) {
                                if (this.b[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2)] == i4 - 1) {
                                    if (this.b[(l3 + k2 - 1) * j2 + (j3 + k2) * byte2 + (l4 + k2)] == -2) {
                                        this.b[(l3 + k2 - 1) * j2 + (j3 + k2) * byte2 + (l4 + k2)] = i4;
                                    }
                                    if (this.b[(l3 + k2 + 1) * j2 + (j3 + k2) * byte2 + (l4 + k2)] == -2) {
                                        this.b[(l3 + k2 + 1) * j2 + (j3 + k2) * byte2 + (l4 + k2)] = i4;
                                    }
                                    if (this.b[(l3 + k2) * j2 + (j3 + k2 - 1) * byte2 + (l4 + k2)] == -2) {
                                        this.b[(l3 + k2) * j2 + (j3 + k2 - 1) * byte2 + (l4 + k2)] = i4;
                                    }
                                    if (this.b[(l3 + k2) * j2 + (j3 + k2 + 1) * byte2 + (l4 + k2)] == -2) {
                                        this.b[(l3 + k2) * j2 + (j3 + k2 + 1) * byte2 + (l4 + k2)] = i4;
                                    }
                                    if (this.b[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2 - 1)] == -2) {
                                        this.b[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2 - 1)] = i4;
                                    }
                                    if (this.b[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2 + 1)] == -2) {
                                        this.b[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2 + 1)] = i4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final int j4 = this.b[k2 * j2 + k2 * byte2 + k2];
            if (j4 >= 0) {
                world.c(i, j, k, l & 0xFFFFFFF7);
            }
            else {
                this.removeLeaves(world, i, j, k);
            }
        }
    }
    
    void removeLeaves(final xd world, final int i, final int j, final int k) {
        this.a(world, i, j, k, world.e(i, j, k), 0);
        world.g(i, j, k, 0);
    }
    
    public boolean a() {
        return pb.K.a();
    }
    
    public int a(final int i, final int j) {
        return pb.K.a(i, j);
    }
    
    public boolean a(final ali iblockaccess, final int i, final int j, final int k, final int l) {
        return pb.K.a(iblockaccess, i, j, k, l);
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new aan((pb)this, 1, 0));
        itemList.add(new aan((pb)this, 1, 1));
        itemList.add(new aan((pb)this, 1, 2));
    }
}
