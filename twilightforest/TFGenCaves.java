// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFGenCaves extends xu
{
    protected void generateLargeCaveNode(final long par1, final int par3, final int par4, final byte[] par5ArrayOfByte, final double par6, final double par8, final double par10) {
        this.generateCaveNode(par1, par3, par4, par5ArrayOfByte, par6, par8, par10, 1.0f + this.c.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }
    
    protected void generateCaveNode(final long caveSeed, final int par3, final int par4, final byte[] byteStorage, double par6, double par8, double par10, final float par12, float par13, float par14, int par15, int par16, final double par17) {
        final double var19 = par3 * 16 + 8;
        final double var20 = par4 * 16 + 8;
        float var21 = 0.0f;
        float var22 = 0.0f;
        final Random caveRNG = new Random(caveSeed);
        if (par16 <= 0) {
            final int var23 = this.b * 16 - 16;
            par16 = var23 - caveRNG.nextInt(var23 / 4);
        }
        boolean var24 = false;
        if (par15 == -1) {
            par15 = par16 / 2;
            var24 = true;
        }
        final int var25 = caveRNG.nextInt(par16 / 2) + par16 / 4;
        final boolean var26 = caveRNG.nextInt(6) == 0;
        while (par15 < par16) {
            final double var27 = 1.5 + gk.a(par15 * 3.1415927f / par16) * par12 * 1.0f;
            final double var28 = var27 * par17;
            final float var29 = gk.b(par14);
            final float var30 = gk.a(par14);
            par6 += gk.b(par13) * var29;
            par8 += var30;
            par10 += gk.a(par13) * var29;
            if (var26) {
                par14 *= 0.92f;
            }
            else {
                par14 *= 0.7f;
            }
            par14 += var22 * 0.1f;
            par13 += var21 * 0.1f;
            var22 *= 0.9f;
            var21 *= 0.75f;
            var22 += (caveRNG.nextFloat() - caveRNG.nextFloat()) * caveRNG.nextFloat() * 2.0f;
            var21 += (caveRNG.nextFloat() - caveRNG.nextFloat()) * caveRNG.nextFloat() * 4.0f;
            if (!var24 && par15 == var25 && par12 > 1.0f && par16 > 0) {
                this.generateCaveNode(caveRNG.nextLong(), par3, par4, byteStorage, par6, par8, par10, caveRNG.nextFloat() * 0.5f + 0.5f, par13 - 1.5707964f, par14 / 3.0f, par15, par16, 1.0);
                this.generateCaveNode(caveRNG.nextLong(), par3, par4, byteStorage, par6, par8, par10, caveRNG.nextFloat() * 0.5f + 0.5f, par13 + 1.5707964f, par14 / 3.0f, par15, par16, 1.0);
                return;
            }
            if (var24 || caveRNG.nextInt(4) != 0) {
                final double var31 = par6 - var19;
                final double var32 = par10 - var20;
                final double var33 = par16 - par15;
                final double var34 = par12 + 2.0f + 16.0f;
                if (var31 * var31 + var32 * var32 - var33 * var33 > var34 * var34) {
                    return;
                }
                if (par6 >= var19 - 16.0 - var27 * 2.0 && par10 >= var20 - 16.0 - var27 * 2.0 && par6 <= var19 + 16.0 + var27 * 2.0 && par10 <= var20 + 16.0 + var27 * 2.0) {
                    int var35 = gk.c(par6 - var27) - par3 * 16 - 1;
                    int var36 = gk.c(par6 + var27) - par3 * 16 + 1;
                    int var37 = gk.c(par8 - var28) - 1;
                    int var38 = gk.c(par8 + var28) + 1;
                    int var39 = gk.c(par10 - var27) - par4 * 16 - 1;
                    int var40 = gk.c(par10 + var27) - par4 * 16 + 1;
                    if (var35 < 0) {
                        var35 = 0;
                    }
                    if (var36 > 16) {
                        var36 = 16;
                    }
                    if (var37 < 1) {
                        var37 = 1;
                    }
                    if (var38 > 120) {
                        var38 = 120;
                    }
                    if (var39 < 0) {
                        var39 = 0;
                    }
                    if (var40 > 16) {
                        var40 = 16;
                    }
                    boolean var41 = false;
                    for (int var42 = var35; !var41 && var42 < var36; ++var42) {
                        for (int var43 = var39; !var41 && var43 < var40; ++var43) {
                            for (int var44 = var38 + 1; !var41 && var44 >= var37 - 1; --var44) {
                                final int var45 = (var42 * 16 + var43) * 128 + var44;
                                if (var44 >= 0 && var44 < 128) {
                                    if (byteStorage[var45] == pb.A.bO || byteStorage[var45] == pb.B.bO) {
                                        var41 = true;
                                    }
                                    if (var44 != var37 - 1 && var42 != var35 && var42 != var36 - 1 && var43 != var39 && var43 != var40 - 1) {
                                        var44 = var37;
                                    }
                                }
                            }
                        }
                    }
                    if (!var41) {
                        for (int var42 = var35; var42 < var36; ++var42) {
                            final double var46 = (var42 + par3 * 16 + 0.5 - par6) / var27;
                            for (int var45 = var39; var45 < var40; ++var45) {
                                final double var47 = (var45 + par4 * 16 + 0.5 - par10) / var27;
                                int caveIndex = (var42 * 16 + var45) * 128 + var38;
                                boolean hitGrass = false;
                                if (var46 * var46 + var47 * var47 < 1.0) {
                                    for (int caveY = var38 - 1; caveY >= var37; --caveY) {
                                        final double var48 = (caveY + 0.5 - par8) / var28;
                                        if (var48 > -0.7 && var46 * var46 + var48 * var48 + var47 * var47 < 20.0) {
                                            final byte blockID = byteStorage[caveIndex];
                                            if (blockID == pb.u.bO) {
                                                hitGrass = true;
                                            }
                                            if (blockID == pb.t.bO || blockID == pb.v.bO || blockID == pb.u.bO) {
                                                if (var46 * var46 + var48 * var48 + var47 * var47 < 0.85) {
                                                    byteStorage[caveIndex] = (byte)((caveY < 10) ? ((byte)pb.A.bO) : 0);
                                                }
                                                else {
                                                    byteStorage[caveIndex] = (hitGrass ? ((byte)pb.u.bO) : ((byte)pb.v.bO));
                                                    hitGrass = false;
                                                }
                                                if (hitGrass && byteStorage[caveIndex - 1] == pb.v.bO) {
                                                    byteStorage[caveIndex - 1] = this.d.a(var42 + par3 * 16, var45 + par4 * 16).A;
                                                }
                                            }
                                        }
                                        --caveIndex;
                                    }
                                }
                            }
                        }
                        if (var24) {
                            break;
                        }
                    }
                }
            }
            ++par15;
        }
    }
    
    protected void a(final xd par1World, final int par2, final int par3, final int par4, final int par5, final byte[] par6ArrayOfByte) {
        int var7 = this.c.nextInt(this.c.nextInt(this.c.nextInt(40) + 1) + 1);
        if (this.c.nextInt(15) != 0) {
            var7 = 0;
        }
        for (int var8 = 0; var8 < var7; ++var8) {
            final double var9 = par2 * 16 + this.c.nextInt(16);
            final double var10 = this.c.nextInt(this.c.nextInt(120) + 8);
            final double var11 = par3 * 16 + this.c.nextInt(16);
            int var12 = 1;
            if (this.c.nextInt(4) == 0) {
                this.generateLargeCaveNode(this.c.nextLong(), par4, par5, par6ArrayOfByte, var9, var10, var11);
                var12 += this.c.nextInt(4);
            }
            for (int var13 = 0; var13 < var12; ++var13) {
                final float var14 = this.c.nextFloat() * 3.1415927f * 2.0f;
                final float var15 = (this.c.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float var16 = this.c.nextFloat() * 2.0f + this.c.nextFloat();
                if (this.c.nextInt(10) == 0) {
                    var16 *= this.c.nextFloat() * this.c.nextFloat() * 3.0f + 1.0f;
                }
                this.generateCaveNode(this.c.nextLong(), par4, par5, par6ArrayOfByte, var9, var10, var11, var16, var14, var15, 0, 0, 1.0);
            }
        }
    }
}
