// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import twilightforest.TFFeature;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.MapGenBase;

public class TFGenRavine extends MapGenBase
{
    protected static final IBlockState AIR;
    private final float[] rs;
    private Biome[] biomes;
    
    public TFGenRavine() {
        this.rs = new float[1024];
    }
    
    protected void addTunnel(final long p_180707_1_, final int p_180707_3_, final int p_180707_4_, final ChunkPrimer p_180707_5_, double p_180707_6_, double p_180707_8_, double p_180707_10_, final float p_180707_12_, float p_180707_13_, float p_180707_14_, int p_180707_15_, int p_180707_16_, final double p_180707_17_) {
        final Random random = new Random(p_180707_1_);
        final double d0 = p_180707_3_ * 16 + 8;
        final double d2 = p_180707_4_ * 16 + 8;
        float f = 0.0f;
        float f2 = 0.0f;
        if (p_180707_16_ <= 0) {
            final int i = this.field_75040_a * 16 - 16;
            p_180707_16_ = i - random.nextInt(i / 4);
        }
        boolean flag1 = false;
        if (p_180707_15_ == -1) {
            p_180707_15_ = p_180707_16_ / 2;
            flag1 = true;
        }
        float f3 = 1.0f;
        for (int j = 0; j < 256; ++j) {
            if (j == 0 || random.nextInt(3) == 0) {
                f3 = 1.0f + random.nextFloat() * random.nextFloat();
            }
            this.rs[j] = f3 * f3;
        }
        while (p_180707_15_ < p_180707_16_) {
            double d3 = 1.5 + MathHelper.func_76126_a(p_180707_15_ * 3.1415927f / p_180707_16_) * p_180707_12_;
            double d4 = d3 * p_180707_17_;
            d3 *= random.nextFloat() * 0.25 + 0.75;
            d4 *= random.nextFloat() * 0.25 + 0.75;
            final float f4 = MathHelper.func_76134_b(p_180707_14_);
            final float f5 = MathHelper.func_76126_a(p_180707_14_);
            p_180707_6_ += MathHelper.func_76134_b(p_180707_13_) * f4;
            p_180707_8_ += f5;
            p_180707_10_ += MathHelper.func_76126_a(p_180707_13_) * f4;
            p_180707_14_ *= 0.7f;
            p_180707_14_ += f2 * 0.05f;
            p_180707_13_ += f * 0.05f;
            f2 *= 0.8f;
            f *= 0.5f;
            f2 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (flag1 || random.nextInt(4) != 0) {
                final double d5 = p_180707_6_ - d0;
                final double d6 = p_180707_10_ - d2;
                final double d7 = p_180707_16_ - p_180707_15_;
                final double d8 = p_180707_12_ + 2.0f + 16.0f;
                if (d5 * d5 + d6 * d6 - d7 * d7 > d8 * d8) {
                    return;
                }
                if (p_180707_6_ >= d0 - 16.0 - d3 * 2.0 && p_180707_10_ >= d2 - 16.0 - d3 * 2.0 && p_180707_6_ <= d0 + 16.0 + d3 * 2.0 && p_180707_10_ <= d2 + 16.0 + d3 * 2.0) {
                    int k2 = MathHelper.func_76128_c(p_180707_6_ - d3) - p_180707_3_ * 16 - 1;
                    int l = MathHelper.func_76128_c(p_180707_6_ + d3) - p_180707_3_ * 16 + 1;
                    int l2 = MathHelper.func_76128_c(p_180707_8_ - d4) - 1;
                    int m = MathHelper.func_76128_c(p_180707_8_ + d4) + 1;
                    int i2 = MathHelper.func_76128_c(p_180707_10_ - d3) - p_180707_4_ * 16 - 1;
                    int i3 = MathHelper.func_76128_c(p_180707_10_ + d3) - p_180707_4_ * 16 + 1;
                    if (k2 < 0) {
                        k2 = 0;
                    }
                    if (l > 16) {
                        l = 16;
                    }
                    if (l2 < 1) {
                        l2 = 1;
                    }
                    if (m > 248) {
                        m = 248;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    if (i3 > 16) {
                        i3 = 16;
                    }
                    boolean flag2 = false;
                    for (int j2 = k2; !flag2 && j2 < l; ++j2) {
                        for (int k3 = i2; !flag2 && k3 < i3; ++k3) {
                            for (int l3 = m + 1; !flag2 && l3 >= l2 - 1; --l3) {
                                if (l3 >= 0 && l3 < 256) {
                                    if (this.isOceanBlock(p_180707_5_, j2, l3, k3, p_180707_3_, p_180707_4_)) {
                                        flag2 = true;
                                    }
                                    if (l3 != l2 - 1 && j2 != k2 && j2 != l - 1 && k3 != i2 && k3 != i3 - 1) {
                                        l3 = l2;
                                    }
                                }
                            }
                        }
                    }
                    if (!flag2) {
                        for (int j3 = k2; j3 < l; ++j3) {
                            final double d9 = (j3 + p_180707_3_ * 16 + 0.5 - p_180707_6_) / d3;
                            for (int i4 = i2; i4 < i3; ++i4) {
                                final double d10 = (i4 + p_180707_4_ * 16 + 0.5 - p_180707_10_) / d3;
                                boolean flag3 = false;
                                if (d9 * d9 + d10 * d10 < 1.0) {
                                    for (int j4 = m; j4 > l2; --j4) {
                                        final double d11 = (j4 - 1 + 0.5 - p_180707_8_) / d4;
                                        if ((d9 * d9 + d10 * d10) * this.rs[j4 - 1] + d11 * d11 / 6.0 < 1.0) {
                                            if (this.isTopBlock(p_180707_5_, j3, j4, i4, p_180707_3_, p_180707_4_)) {
                                                flag3 = true;
                                            }
                                            this.digBlock(p_180707_5_, j3, j4, i4, p_180707_3_, p_180707_4_, flag3);
                                        }
                                    }
                                }
                            }
                        }
                        if (flag1) {
                            break;
                        }
                    }
                }
            }
            ++p_180707_15_;
        }
    }
    
    protected void func_180701_a(final World world, final int chunkX, final int chunkZ, final int p_180701_4_, final int p_180701_5_, final ChunkPrimer primer) {
        if (this.field_75038_b.nextInt(127) == 0) {
            if (!TFFeature.getNearestFeature(p_180701_4_, p_180701_5_, world).areChunkDecorationsEnabled) {
                return;
            }
            this.biomes = world.func_72959_q().func_76933_b(this.biomes, chunkX << 4, chunkZ << 4, 16, 16);
            final double d0 = chunkX * 16 + this.field_75038_b.nextInt(16);
            final double d2 = this.field_75038_b.nextInt(this.field_75038_b.nextInt(40) + 8) + 20;
            final double d3 = chunkZ * 16 + this.field_75038_b.nextInt(16);
            final int i = 1;
            for (int j = 0; j < 1; ++j) {
                final float f = this.field_75038_b.nextFloat() * 6.2831855f;
                final float f2 = (this.field_75038_b.nextFloat() - 0.5f) * 2.0f / 8.0f;
                final float f3 = (this.field_75038_b.nextFloat() * 2.0f + this.field_75038_b.nextFloat()) * 2.0f;
                this.addTunnel(this.field_75038_b.nextLong(), p_180701_4_, p_180701_5_, primer, d0, d2, d3, f3, f, f2, 0, 0, 3.0);
            }
        }
    }
    
    protected boolean isOceanBlock(final ChunkPrimer data, final int x, final int y, final int z, final int chunkX, final int chunkZ) {
        final Block block = data.func_177856_a(x, y, z).func_177230_c();
        return block == Blocks.field_150358_i || block == Blocks.field_150355_j;
    }
    
    private boolean isTopBlock(final ChunkPrimer data, final int x, final int y, final int z, final int chunkX, final int chunkZ) {
        final IBlockState state = data.func_177856_a(x, y, z);
        return state.func_177230_c() == Blocks.field_150349_c;
    }
    
    protected void digBlock(final ChunkPrimer data, final int x, final int y, final int z, final int chunkX, final int chunkZ, final boolean foundTop) {
        final IBlockState state = data.func_177856_a(x, y, z);
        final Block block = state.func_177230_c();
        if (block == Blocks.field_150348_b || block == TFBlocks.trollsteinn || block == Blocks.field_150346_d || block == Blocks.field_150349_c) {
            data.func_177855_a(x, y, z, TFGenRavine.AIR);
            if (foundTop && data.func_177856_a(x, y - 1, z).func_177230_c() == Blocks.field_150346_d) {
                data.func_177855_a(x, y - 1, z, this.getBiome(x, z).field_76752_A);
            }
        }
    }
    
    private Biome getBiome(final int x, final int z) {
        return this.biomes[(x & 0xF) | (z & 0xF) << 4];
    }
    
    static {
        AIR = Blocks.field_150350_a.func_176223_P();
    }
}
