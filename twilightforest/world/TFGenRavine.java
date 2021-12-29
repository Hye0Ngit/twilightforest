// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFFeature;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import java.util.Random;
import net.minecraft.block.Block;

public class TFGenRavine extends MapGenBase4096
{
    private float[] field_35627_a;
    
    public TFGenRavine() {
        this.field_35627_a = new float[1024];
    }
    
    protected void generateRavine(final long l, final int i, final int j, final Block[] blockStorage, double d, double d1, double d2, final float f, float f1, float f2, int k, int i1, final double d3) {
        final Random random = new Random(l);
        final double d4 = i * 16 + 8;
        final double d5 = j * 16 + 8;
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (i1 <= 0) {
            final int j2 = this.field_75040_a * 16 - 16;
            i1 = j2 - random.nextInt(j2 / 4);
        }
        boolean flag = false;
        if (k == -1) {
            k = i1 / 2;
            flag = true;
        }
        float f5 = 1.0f;
        for (int k2 = 0; k2 < TFWorld.CHUNKHEIGHT; ++k2) {
            if (k2 == 0 || random.nextInt(3) == 0) {
                f5 = 1.0f + random.nextFloat() * random.nextFloat() * 1.0f;
            }
            this.field_35627_a[k2] = f5 * f5;
        }
        while (k < i1) {
            double d6 = 1.5 + MathHelper.func_76126_a(k * 3.141593f / i1) * f * 1.0f;
            double d7 = d6 * d3;
            d6 *= random.nextFloat() * 0.25 + 0.75;
            d7 *= random.nextFloat() * 0.25 + 0.75;
            final float f6 = MathHelper.func_76134_b(f2);
            final float f7 = MathHelper.func_76126_a(f2);
            d += MathHelper.func_76134_b(f1) * f6;
            d1 += f7;
            d2 += MathHelper.func_76126_a(f1) * f6;
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
                        int d9 = MathHelper.func_76128_c(d - d6) - i * 16 - 1;
                        int l2 = MathHelper.func_76128_c(d + d6) - i * 16 + 1;
                        int d10 = MathHelper.func_76128_c(d1 - d7) - 1;
                        int i2 = MathHelper.func_76128_c(d1 + d7) + 1;
                        int d11 = MathHelper.func_76128_c(d2 - d6) - j * 16 - 1;
                        int j3 = MathHelper.func_76128_c(d2 + d6) - j * 16 + 1;
                        if (d9 < 0) {
                            d9 = 0;
                        }
                        if (l2 > 16) {
                            l2 = 16;
                        }
                        if (d10 < 1) {
                            d10 = 1;
                        }
                        if (i2 > TFWorld.CHUNKHEIGHT - 8) {
                            i2 = TFWorld.CHUNKHEIGHT - 8;
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
                                    final int k4 = (k3 * 16 + i3) * TFWorld.CHUNKHEIGHT + j4;
                                    if (j4 >= 0) {
                                        if (j4 < TFWorld.CHUNKHEIGHT) {
                                            if (blockStorage[k4] == Blocks.field_150355_j || blockStorage[k4] == Blocks.field_150355_j) {
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
                                    int i4 = (l3 * 16 + l4) * TFWorld.CHUNKHEIGHT + i2;
                                    boolean flag3 = false;
                                    if (d12 * d12 + d13 * d13 < 1.0) {
                                        for (int j5 = i2 - 1; j5 >= d10; --j5) {
                                            final double d14 = (j5 + 0.5 - d1) / d7;
                                            if ((d12 * d12 + d13 * d13) * this.field_35627_a[j5] + d14 * d14 / 6.0 < 1.0) {
                                                final Block curentBlock = blockStorage[i4];
                                                if (curentBlock == Blocks.field_150349_c) {
                                                    flag3 = true;
                                                }
                                                if (curentBlock == Blocks.field_150348_b || curentBlock == Blocks.field_150346_d || curentBlock == Blocks.field_150349_c) {
                                                    blockStorage[i4] = Blocks.field_150350_a;
                                                    if (flag3 && blockStorage[i4 - 1] == Blocks.field_150346_d) {
                                                        blockStorage[i4 - 1] = this.field_75039_c.func_72807_a(l3 + i * 16, l4 + j * 16).field_76752_A;
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
    
    @Override
    protected void recursiveGenerate(final World world, final int centerChunkX, final int centerChunkZ, final int currentChunkX, final int currentChunkZ, final Block[] shortStorage) {
        if (this.field_75038_b.nextInt(127) != 0) {
            return;
        }
        if (!TFFeature.getNearestFeature(currentChunkX, currentChunkZ, world).areChunkDecorationsEnabled) {
            return;
        }
        final double d = centerChunkX * 16 + this.field_75038_b.nextInt(16);
        final double d2 = this.field_75038_b.nextInt(this.field_75038_b.nextInt(40) + 8) + 20;
        final double d3 = centerChunkZ * 16 + this.field_75038_b.nextInt(16);
        for (int i1 = 1, j1 = 0; j1 < i1; ++j1) {
            final float f = this.field_75038_b.nextFloat() * 3.141593f * 2.0f;
            final float f2 = (this.field_75038_b.nextFloat() - 0.5f) * 2.0f / 8.0f;
            final float f3 = (this.field_75038_b.nextFloat() * 2.0f + this.field_75038_b.nextFloat()) * 2.0f;
            this.generateRavine(this.field_75038_b.nextLong(), currentChunkX, currentChunkZ, shortStorage, d, d2, d3, f3, f, f2, 0, 0, 3.0);
        }
    }
}
