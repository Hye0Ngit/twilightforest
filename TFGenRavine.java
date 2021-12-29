import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenRavine extends he
{
    private float[] field_35627_a;
    
    public TFGenRavine() {
        this.field_35627_a = new float[1024];
    }
    
    protected void func_35626_a(final long l, final int i, final int j, final byte[] abyte0, double d, double d1, double d2, final float f, float f1, float f2, int k, int i1, final double d3) {
        final Random random = new Random(l);
        final double d4 = i * 16 + 8;
        final double d5 = j * 16 + 8;
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (i1 <= 0) {
            final int j2 = this.b * 16 - 16;
            i1 = j2 - random.nextInt(j2 / 4);
        }
        boolean flag = false;
        if (k == -1) {
            k = i1 / 2;
            flag = true;
        }
        float f5 = 1.0f;
        for (int k2 = 0; k2 < TFWorld.WORLDHEIGHT; ++k2) {
            if (k2 == 0 || random.nextInt(3) == 0) {
                f5 = 1.0f + random.nextFloat() * random.nextFloat() * 1.0f;
            }
            this.field_35627_a[k2] = f5 * f5;
        }
        while (k < i1) {
            double d6 = 1.5 + kb.a(k * 3.141593f / i1) * f * 1.0f;
            double d7 = d6 * d3;
            d6 *= random.nextFloat() * 0.25 + 0.75;
            d7 *= random.nextFloat() * 0.25 + 0.75;
            final float f6 = kb.b(f2);
            final float f7 = kb.a(f2);
            d += kb.b(f1) * f6;
            d1 += f7;
            d2 += kb.a(f1) * f6;
            f2 *= 0.7f;
            f2 += f4 * 0.05f;
            f1 += f3 * 0.05f;
            f4 *= 0.8f;
            f3 *= 0.5f;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (flag || random.nextInt(4) != 0) {
                final double d8a = d - d4;
                final double d9a = d2 - d5;
                final double d10a = i1 - k;
                final double d8 = f + 2.0f + 16.0f;
                if (d8a * d8a + d9a * d9a - d10a * d10a > d8 * d8) {
                    return;
                }
                if (d >= d4 - 16.0 - d6 * 2.0 && d2 >= d5 - 16.0 - d6 * 2.0 && d <= d4 + 16.0 + d6 * 2.0) {
                    if (d2 <= d5 + 16.0 + d6 * 2.0) {
                        int d9 = kb.b(d - d6) - i * 16 - 1;
                        int l2 = kb.b(d + d6) - i * 16 + 1;
                        int d10 = kb.b(d1 - d7) - 1;
                        int i2 = kb.b(d1 + d7) + 1;
                        int d11 = kb.b(d2 - d6) - j * 16 - 1;
                        int j3 = kb.b(d2 + d6) - j * 16 + 1;
                        if (d9 < 0) {
                            d9 = 0;
                        }
                        if (l2 > 16) {
                            l2 = 16;
                        }
                        if (d10 < 1) {
                            d10 = 1;
                        }
                        if (i2 > TFWorld.WORLDHEIGHT - 8) {
                            i2 = TFWorld.WORLDHEIGHT - 8;
                        }
                        if (d11 < 0) {
                            d11 = 0;
                        }
                        if (j3 > 16) {
                            j3 = 16;
                        }
                        boolean flag2 = false;
                        for (int k3 = d9; !flag2 && k3 < l2; ++k3) {
                            for (int i3 = d11; !flag2 && i3 < j3; ++i3) {
                                for (int j4 = i2 + 1; !flag2 && j4 >= d10 - 1; --j4) {
                                    final int k4 = (k3 * 16 + i3) * TFWorld.WORLDHEIGHT + j4;
                                    if (j4 >= 0) {
                                        if (j4 < TFWorld.WORLDHEIGHT) {
                                            if (abyte0[k4] == vz.A.bO || abyte0[k4] == vz.B.bO) {
                                                flag2 = true;
                                            }
                                            if (j4 != d10 - 1 && k3 != d9 && k3 != l2 - 1 && i3 != d11 && i3 != j3 - 1) {
                                                j4 = d10;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (!flag2) {
                            for (int l3 = d9; l3 < l2; ++l3) {
                                final double d12 = (l3 + i * 16 + 0.5 - d) / d6;
                                for (int l4 = d11; l4 < j3; ++l4) {
                                    final double d13 = (l4 + j * 16 + 0.5 - d2) / d6;
                                    int i4 = (l3 * 16 + l4) * TFWorld.WORLDHEIGHT + i2;
                                    boolean flag3 = false;
                                    if (d12 * d12 + d13 * d13 < 1.0) {
                                        for (int j5 = i2 - 1; j5 >= d10; --j5) {
                                            final double d14 = (j5 + 0.5 - d1) / d7;
                                            if ((d12 * d12 + d13 * d13) * this.field_35627_a[j5] + d14 * d14 / 6.0 < 1.0) {
                                                final byte byte0 = abyte0[i4];
                                                if (byte0 == vz.u.bO) {
                                                    flag3 = true;
                                                }
                                                if (byte0 == vz.t.bO || byte0 == vz.v.bO || byte0 == vz.u.bO) {
                                                    abyte0[i4] = 0;
                                                    if (flag3 && abyte0[i4 - 1] == vz.v.bO) {
                                                        abyte0[i4 - 1] = this.d.a().a(l3 + i * 16, l4 + j * 16).A;
                                                    }
                                                }
                                            }
                                            --i4;
                                        }
                                    }
                                }
                            }
                            if (flag) {
                                break;
                            }
                        }
                    }
                }
            }
            ++k;
        }
    }
    
    protected void a(final ge world, final int i, final int j, final int k, final int l, final byte[] abyte0) {
        if (this.c.nextInt(127) != 0) {
            return;
        }
        final double d = i * 16 + this.c.nextInt(16);
        final double d2 = this.c.nextInt(this.c.nextInt(40) + 8) + 20;
        final double d3 = j * 16 + this.c.nextInt(16);
        for (int i2 = 1, j2 = 0; j2 < i2; ++j2) {
            final float f = this.c.nextFloat() * 3.141593f * 2.0f;
            final float f2 = (this.c.nextFloat() - 0.5f) * 2.0f / 8.0f;
            final float f3 = (this.c.nextFloat() * 2.0f + this.c.nextFloat()) * 2.0f;
            this.func_35626_a(this.c.nextLong(), k, l, abyte0, d, d2, d3, f3, f, f2, 0, 0, 3.0);
        }
    }
}
