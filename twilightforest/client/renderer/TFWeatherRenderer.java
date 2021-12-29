// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import twilightforest.TwilightForestMod;
import twilightforest.biomes.TFBiomeFinalPlateau;
import twilightforest.biomes.TFBiomeThornlands;
import twilightforest.biomes.TFBiomeHighlands;
import twilightforest.biomes.TFBiomeDarkForest;
import twilightforest.biomes.TFBiomeFireSwamp;
import twilightforest.biomes.TFBiomeSwamp;
import twilightforest.biomes.TFBiomeGlacier;
import twilightforest.biomes.TFBiomeSnow;
import net.minecraft.world.biome.Biome;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import twilightforest.world.TFWorld;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;

public class TFWeatherRenderer extends IRenderHandler
{
    private static final ResourceLocation RAIN_TEXTURES;
    private static final ResourceLocation SNOW_TEXTURES;
    private static final ResourceLocation SPARKLES_TEXTURE;
    private final float[] rainxs;
    private final float[] rainys;
    private final Random random;
    private int rendererUpdateCount;
    private StructureBoundingBox protectedBox;
    
    public TFWeatherRenderer() {
        this.rainxs = new float[1024];
        this.rainys = new float[1024];
        this.random = new Random();
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32; ++j) {
                final float f = (float)(j - 16);
                final float f2 = (float)(i - 16);
                final float f3 = MathHelper.func_76129_c(f * f + f2 * f2);
                this.rainxs[i << 5 | j] = -f2 / f3;
                this.rainys[i << 5 | j] = f / f3;
            }
        }
    }
    
    public void tick() {
        ++this.rendererUpdateCount;
    }
    
    public void render(final float partialTicks, final WorldClient world, final Minecraft mc) {
        this.renderNormalWeather(partialTicks, mc);
        if (TFWorld.isProgressionEnforced((World)world) && !mc.field_71439_g.func_184812_l_() && !mc.field_71439_g.func_175149_v()) {
            this.renderLockedBiome(partialTicks, world, mc);
            this.renderLockedStructure(partialTicks, world, mc);
        }
    }
    
    private void renderNormalWeather(final float partialTicks, final Minecraft mc) {
        final float f = mc.field_71441_e.func_72867_j(partialTicks);
        if (f > 0.0f) {
            mc.field_71460_t.func_180436_i();
            final Entity entity = mc.func_175606_aa();
            final World world = (World)mc.field_71441_e;
            final int i = MathHelper.func_76128_c(entity.field_70165_t);
            final int j = MathHelper.func_76128_c(entity.field_70163_u);
            final int k = MathHelper.func_76128_c(entity.field_70161_v);
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder bufferbuilder = tessellator.func_178180_c();
            GlStateManager.func_179129_p();
            GlStateManager.func_187432_a(0.0f, 1.0f, 0.0f);
            GlStateManager.func_179147_l();
            GlStateManager.func_187428_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.func_179092_a(516, 0.1f);
            final double d0 = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * partialTicks;
            final double d2 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * partialTicks;
            final double d3 = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * partialTicks;
            final int l = MathHelper.func_76128_c(d2);
            int i2 = 5;
            if (mc.field_71474_y.field_74347_j) {
                i2 = 10;
            }
            int j2 = -1;
            final float f2 = this.rendererUpdateCount + partialTicks;
            bufferbuilder.func_178969_c(-d0, -d2, -d3);
            GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            for (int k2 = k - i2; k2 <= k + i2; ++k2) {
                for (int l2 = i - i2; l2 <= i + i2; ++l2) {
                    final int i3 = (k2 - k + 16) * 32 + l2 - i + 16;
                    final double d4 = this.rainxs[i3] * 0.5;
                    final double d5 = this.rainys[i3] * 0.5;
                    blockpos$mutableblockpos.func_181079_c(l2, 0, k2);
                    final Biome biome = world.func_180494_b((BlockPos)blockpos$mutableblockpos);
                    if (biome.func_76738_d() || biome.func_76746_c()) {
                        final int j3 = world.func_175725_q((BlockPos)blockpos$mutableblockpos).func_177956_o();
                        int k3 = j - i2;
                        int l3 = j + i2;
                        if (k3 < j3) {
                            k3 = j3;
                        }
                        if (l3 < j3) {
                            l3 = j3;
                        }
                        int i4;
                        if ((i4 = j3) < l) {
                            i4 = l;
                        }
                        if (k3 != l3) {
                            this.random.setSeed(l2 * l2 * 3121 + l2 * 45238971 ^ k2 * k2 * 418711 + k2 * 13761);
                            blockpos$mutableblockpos.func_181079_c(l2, k3, k2);
                            final float f3 = biome.func_180626_a((BlockPos)blockpos$mutableblockpos);
                            if (world.func_72959_q().func_76939_a(f3, j3) >= 0.15f) {
                                if (j2 != 0) {
                                    if (j2 >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    j2 = 0;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.RAIN_TEXTURES);
                                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181704_d);
                                }
                                final double d6 = -((this.rendererUpdateCount + l2 * l2 * 3121 + l2 * 45238971 + k2 * k2 * 418711 + k2 * 13761 & 0x1F) + (double)partialTicks) / 32.0 * (3.0 + this.random.nextDouble());
                                final double d7 = l2 + 0.5f - entity.field_70165_t;
                                final double d8 = k2 + 0.5f - entity.field_70161_v;
                                final float f4 = MathHelper.func_76133_a(d7 * d7 + d8 * d8) / i2;
                                final float f5 = ((1.0f - f4 * f4) * 0.5f + 0.5f) * f;
                                blockpos$mutableblockpos.func_181079_c(l2, i4, k2);
                                final int j4 = world.func_175626_b((BlockPos)blockpos$mutableblockpos, 0);
                                final int k4 = j4 >> 16 & 0xFFFF;
                                final int l4 = j4 & 0xFFFF;
                                bufferbuilder.func_181662_b(l2 - d4 + 0.5, (double)l3, k2 - d5 + 0.5).func_187315_a(0.0, k3 * 0.25 + d6).func_181666_a(1.0f, 1.0f, 1.0f, f5).func_187314_a(k4, l4).func_181675_d();
                                bufferbuilder.func_181662_b(l2 + d4 + 0.5, (double)l3, k2 + d5 + 0.5).func_187315_a(1.0, k3 * 0.25 + d6).func_181666_a(1.0f, 1.0f, 1.0f, f5).func_187314_a(k4, l4).func_181675_d();
                                bufferbuilder.func_181662_b(l2 + d4 + 0.5, (double)k3, k2 + d5 + 0.5).func_187315_a(1.0, l3 * 0.25 + d6).func_181666_a(1.0f, 1.0f, 1.0f, f5).func_187314_a(k4, l4).func_181675_d();
                                bufferbuilder.func_181662_b(l2 - d4 + 0.5, (double)k3, k2 - d5 + 0.5).func_187315_a(0.0, l3 * 0.25 + d6).func_181666_a(1.0f, 1.0f, 1.0f, f5).func_187314_a(k4, l4).func_181675_d();
                            }
                            else {
                                if (j2 != 1) {
                                    if (j2 >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    j2 = 1;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.SNOW_TEXTURES);
                                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181704_d);
                                }
                                final double d9 = -((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                final double d10 = this.random.nextDouble() + f2 * 0.01 * (float)this.random.nextGaussian();
                                final double d11 = this.random.nextDouble() + f2 * (float)this.random.nextGaussian() * 0.001;
                                final double d12 = l2 + 0.5f - entity.field_70165_t;
                                final double d13 = k2 + 0.5f - entity.field_70161_v;
                                final float f6 = MathHelper.func_76133_a(d12 * d12 + d13 * d13) / i2;
                                final float f7 = ((1.0f - f6 * f6) * 0.3f + 0.5f) * f;
                                blockpos$mutableblockpos.func_181079_c(l2, i4, k2);
                                final int i5 = (world.func_175626_b((BlockPos)blockpos$mutableblockpos, 0) * 3 + 15728880) / 4;
                                final int j5 = i5 >> 16 & 0xFFFF;
                                final int k5 = i5 & 0xFFFF;
                                bufferbuilder.func_181662_b(l2 - d4 + 0.5, (double)l3, k2 - d5 + 0.5).func_187315_a(0.0 + d10, k3 * 0.25 + d9 + d11).func_181666_a(1.0f, 1.0f, 1.0f, f7).func_187314_a(j5, k5).func_181675_d();
                                bufferbuilder.func_181662_b(l2 + d4 + 0.5, (double)l3, k2 + d5 + 0.5).func_187315_a(1.0 + d10, k3 * 0.25 + d9 + d11).func_181666_a(1.0f, 1.0f, 1.0f, f7).func_187314_a(j5, k5).func_181675_d();
                                bufferbuilder.func_181662_b(l2 + d4 + 0.5, (double)k3, k2 + d5 + 0.5).func_187315_a(1.0 + d10, l3 * 0.25 + d9 + d11).func_181666_a(1.0f, 1.0f, 1.0f, f7).func_187314_a(j5, k5).func_181675_d();
                                bufferbuilder.func_181662_b(l2 - d4 + 0.5, (double)k3, k2 - d5 + 0.5).func_187315_a(0.0 + d10, l3 * 0.25 + d9 + d11).func_181666_a(1.0f, 1.0f, 1.0f, f7).func_187314_a(j5, k5).func_181675_d();
                            }
                        }
                    }
                }
            }
            if (j2 >= 0) {
                tessellator.func_78381_a();
            }
            bufferbuilder.func_178969_c(0.0, 0.0, 0.0);
            GlStateManager.func_179089_o();
            GlStateManager.func_179084_k();
            GlStateManager.func_179092_a(516, 0.1f);
            mc.field_71460_t.func_175072_h();
        }
    }
    
    private void renderLockedBiome(final float partialTicks, final WorldClient wc, final Minecraft mc) {
        if (this.isNearLockedBiome((World)wc, mc.func_175606_aa())) {
            mc.field_71460_t.func_180436_i();
            final Entity entity = mc.func_175606_aa();
            final World world = (World)mc.field_71441_e;
            final int x0 = MathHelper.func_76128_c(entity.field_70165_t);
            final int y0 = MathHelper.func_76128_c(entity.field_70163_u);
            final int z0 = MathHelper.func_76128_c(entity.field_70161_v);
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder bufferbuilder = tessellator.func_178180_c();
            GlStateManager.func_179129_p();
            GlStateManager.func_187432_a(0.0f, 1.0f, 0.0f);
            GlStateManager.func_179147_l();
            GlStateManager.func_187428_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.func_179092_a(516, 0.1f);
            final double dx = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * partialTicks;
            final double dy = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * partialTicks;
            final double dz = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * partialTicks;
            final int y2 = MathHelper.func_76128_c(dy);
            int range = 5;
            if (mc.field_71474_y.field_74347_j) {
                range = 10;
            }
            RenderType currentType = null;
            final float combinedTicks = this.rendererUpdateCount + partialTicks;
            bufferbuilder.func_178969_c(-dx, -dy, -dz);
            GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            for (int z2 = z0 - range; z2 <= z0 + range; ++z2) {
                for (int x2 = x0 - range; x2 <= x0 + range; ++x2) {
                    final int idx = (z2 - z0 + 16) * 32 + x2 - x0 + 16;
                    final double rx = this.rainxs[idx] * 0.5;
                    final double ry = this.rainys[idx] * 0.5;
                    blockpos$mutableblockpos.func_181079_c(x2, 0, z2);
                    final Biome biome = world.func_180494_b((BlockPos)blockpos$mutableblockpos);
                    if (!TFWorld.isBiomeSafeFor(biome, entity)) {
                        final int groundY = 0;
                        int minY = y0 - range;
                        int maxY = y0 + range;
                        if (minY < groundY) {
                            minY = groundY;
                        }
                        if (maxY < groundY) {
                            maxY = groundY;
                        }
                        int y3;
                        if ((y3 = groundY) < y2) {
                            y3 = y2;
                        }
                        if (minY != maxY) {
                            this.random.setSeed(x2 * x2 * 3121 + x2 * 45238971 ^ z2 * z2 * 418711 + z2 * 13761);
                            final RenderType nextType = this.getRenderType(biome);
                            if (nextType != null) {
                                if (currentType != nextType) {
                                    if (currentType != null) {
                                        tessellator.func_78381_a();
                                    }
                                    currentType = nextType;
                                    mc.func_110434_K().func_110577_a(nextType.getTextureLocation());
                                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181704_d);
                                }
                                switch (currentType) {
                                    case BLIZZARD: {
                                        final double d5 = -((this.rendererUpdateCount + x2 * x2 * 3121 + x2 * 45238971 + z2 * z2 * 418711 + z2 * 13761 & 0x1F) + (double)partialTicks) / 32.0 * (3.0 + this.random.nextDouble());
                                        final double d6 = x2 + 0.5f - entity.field_70165_t;
                                        final double d7 = z2 + 0.5f - entity.field_70161_v;
                                        final float f3 = MathHelper.func_76133_a(d6 * d6 + d7 * d7) / range;
                                        final float f4 = ((1.0f - f3 * f3) * 0.5f + 0.5f) * 1.0f;
                                        blockpos$mutableblockpos.func_181079_c(x2, y3, z2);
                                        final int j3 = world.func_175626_b((BlockPos)blockpos$mutableblockpos, 0);
                                        final int k3 = j3 >> 16 & 0xFFFF;
                                        final int l3 = j3 & 0xFFFF;
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)maxY, z2 - ry + 0.5).func_187315_a(0.0, minY * 0.25 + d5).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k3, l3).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)maxY, z2 + ry + 0.5).func_187315_a(1.0, minY * 0.25 + d5).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k3, l3).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)minY, z2 + ry + 0.5).func_187315_a(1.0, maxY * 0.25 + d5).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k3, l3).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)minY, z2 - ry + 0.5).func_187315_a(0.0, maxY * 0.25 + d5).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k3, l3).func_181675_d();
                                        break;
                                    }
                                    case MOSQUITO: {
                                        final double d8 = 0.0;
                                        final double d9 = this.random.nextDouble() + combinedTicks * 0.01 * (float)this.random.nextGaussian();
                                        final double d10 = this.random.nextDouble() + combinedTicks * (float)this.random.nextGaussian() * 0.001;
                                        final double d11 = x2 + 0.5f - entity.field_70165_t;
                                        final double d12 = z2 + 0.5f - entity.field_70161_v;
                                        final float f5 = MathHelper.func_76133_a(d11 * d11 + d12 * d12) / range;
                                        final float r = this.random.nextFloat() * 0.3f;
                                        final float g = this.random.nextFloat() * 0.3f;
                                        final float b = this.random.nextFloat() * 0.3f;
                                        final float f6 = ((1.0f - f5 * f5) * 0.3f + 0.5f) * 1.0f;
                                        final int i4 = 15728880;
                                        final int j4 = i4 >> 16 & 0xFFFF;
                                        final int k4 = i4 & 0xFFFF;
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)maxY, z2 - ry + 0.5).func_187315_a(0.0 + d9, minY * 0.25 + d8 + d10).func_181666_a(r, g, b, f6).func_187314_a(j4, k4).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)maxY, z2 + ry + 0.5).func_187315_a(1.0 + d9, minY * 0.25 + d8 + d10).func_181666_a(r, g, b, f6).func_187314_a(j4, k4).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)minY, z2 + ry + 0.5).func_187315_a(1.0 + d9, maxY * 0.25 + d8 + d10).func_181666_a(r, g, b, f6).func_187314_a(j4, k4).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)minY, z2 - ry + 0.5).func_187315_a(0.0 + d9, maxY * 0.25 + d8 + d10).func_181666_a(r, g, b, f6).func_187314_a(j4, k4).func_181675_d();
                                        break;
                                    }
                                    case ASHES: {
                                        final double d8 = -((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                        final double d9 = this.random.nextDouble() + combinedTicks * 0.01 * (float)this.random.nextGaussian();
                                        final double d10 = this.random.nextDouble() + combinedTicks * (float)this.random.nextGaussian() * 0.001;
                                        final double d11 = x2 + 0.5f - entity.field_70165_t;
                                        final double d12 = z2 + 0.5f - entity.field_70161_v;
                                        final float f5 = MathHelper.func_76133_a(d11 * d11 + d12 * d12) / range;
                                        final float f7 = ((1.0f - f5 * f5) * 0.3f + 0.5f) * 1.0f;
                                        final int i5 = 15728880;
                                        final int j5 = i5 >> 16 & 0xFFFF;
                                        final int k5 = i5 & 0xFFFF;
                                        final float color = this.random.nextFloat() * 0.2f + 0.8f;
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)maxY, z2 - ry + 0.5).func_187315_a(0.0 + d9, minY * 0.25 + d8 + d10).func_181666_a(color, color, color, f7).func_187314_a(j5, k5).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)maxY, z2 + ry + 0.5).func_187315_a(1.0 + d9, minY * 0.25 + d8 + d10).func_181666_a(color, color, color, f7).func_187314_a(j5, k5).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)minY, z2 + ry + 0.5).func_187315_a(1.0 + d9, maxY * 0.25 + d8 + d10).func_181666_a(color, color, color, f7).func_187314_a(j5, k5).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)minY, z2 - ry + 0.5).func_187315_a(0.0 + d9, maxY * 0.25 + d8 + d10).func_181666_a(color, color, color, f7).func_187314_a(j5, k5).func_181675_d();
                                        break;
                                    }
                                    case DARK_STREAM: {
                                        final double d8 = -((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                        final double d9 = 0.0;
                                        final double d10 = this.random.nextDouble() + combinedTicks * (float)this.random.nextGaussian() * 0.001;
                                        final double d11 = x2 + 0.5f - entity.field_70165_t;
                                        final double d12 = z2 + 0.5f - entity.field_70161_v;
                                        final float f5 = MathHelper.func_76133_a(d11 * d11 + d12 * d12) / range;
                                        final float f7 = ((1.0f - f5 * f5) * 0.3f + 0.5f) * this.random.nextFloat();
                                        final int i5 = 15728880;
                                        final int j5 = i5 >> 16 & 0xFFFF;
                                        final int k5 = i5 & 0xFFFF;
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)maxY, z2 - ry + 0.5).func_187315_a(0.0 + d9, minY * 0.25 + d8 + d10).func_181666_a(1.0f, 1.0f, 1.0f, f7).func_187314_a(j5, k5).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)maxY, z2 + ry + 0.5).func_187315_a(1.0 + d9, minY * 0.25 + d8 + d10).func_181666_a(1.0f, 1.0f, 1.0f, f7).func_187314_a(j5, k5).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)minY, z2 + ry + 0.5).func_187315_a(1.0 + d9, maxY * 0.25 + d8 + d10).func_181666_a(1.0f, 1.0f, 1.0f, f7).func_187314_a(j5, k5).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)minY, z2 - ry + 0.5).func_187315_a(0.0 + d9, maxY * 0.25 + d8 + d10).func_181666_a(1.0f, 1.0f, 1.0f, f7).func_187314_a(j5, k5).func_181675_d();
                                        break;
                                    }
                                    case BIG_RAIN: {
                                        final double d5 = -((this.rendererUpdateCount + x2 * x2 * 3121 + x2 * 45238971 + z2 * z2 * 418711 + z2 * 13761 & 0x1F) + (double)partialTicks) / 32.0 * (3.0 + this.random.nextDouble());
                                        final double d6 = x2 + 0.5f - entity.field_70165_t;
                                        final double d7 = z2 + 0.5f - entity.field_70161_v;
                                        final float f3 = MathHelper.func_76133_a(d6 * d6 + d7 * d7) / range;
                                        final float f4 = ((1.0f - f3 * f3) * 0.5f + 0.5f) * 1.0f;
                                        blockpos$mutableblockpos.func_181079_c(x2, y3, z2);
                                        final int j3 = world.func_175626_b((BlockPos)blockpos$mutableblockpos, 0);
                                        final int k3 = j3 >> 16 & 0xFFFF;
                                        final int l3 = j3 & 0xFFFF;
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)maxY, z2 - ry + 0.5).func_187315_a(0.0, minY * 0.25 + d5).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k3, l3).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)maxY, z2 + ry + 0.5).func_187315_a(1.0, minY * 0.25 + d5).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k3, l3).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 + rx + 0.5, (double)minY, z2 + ry + 0.5).func_187315_a(1.0, maxY * 0.25 + d5).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k3, l3).func_181675_d();
                                        bufferbuilder.func_181662_b(x2 - rx + 0.5, (double)minY, z2 - ry + 0.5).func_187315_a(0.0, maxY * 0.25 + d5).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k3, l3).func_181675_d();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (currentType != null) {
                tessellator.func_78381_a();
            }
            bufferbuilder.func_178969_c(0.0, 0.0, 0.0);
            GlStateManager.func_179089_o();
            GlStateManager.func_179084_k();
            GlStateManager.func_179092_a(516, 0.1f);
            mc.field_71460_t.func_175072_h();
        }
    }
    
    private void renderLockedStructure(final float partialTicks, final WorldClient wc, final Minecraft mc) {
        if (this.isNearLockedStructure((World)wc, mc.func_175606_aa())) {
            mc.field_71460_t.func_180436_i();
            final Entity entity = mc.func_175606_aa();
            final World world = (World)mc.field_71441_e;
            final int i = MathHelper.func_76128_c(entity.field_70165_t);
            final int j = MathHelper.func_76128_c(entity.field_70163_u);
            final int k = MathHelper.func_76128_c(entity.field_70161_v);
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder bufferbuilder = tessellator.func_178180_c();
            GlStateManager.func_179129_p();
            GlStateManager.func_187432_a(0.0f, 1.0f, 0.0f);
            GlStateManager.func_179147_l();
            GlStateManager.func_187428_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.func_179092_a(516, 0.1f);
            final double d0 = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * partialTicks;
            final double d2 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * partialTicks;
            final double d3 = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * partialTicks;
            final int l = MathHelper.func_76128_c(d2);
            int i2 = 5;
            if (mc.field_71474_y.field_74347_j) {
                i2 = 10;
            }
            int j2 = -1;
            final float f1 = this.rendererUpdateCount + partialTicks;
            bufferbuilder.func_178969_c(-d0, -d2, -d3);
            GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            for (int k2 = k - i2; k2 <= k + i2; ++k2) {
                for (int l2 = i - i2; l2 <= i + i2; ++l2) {
                    final int i3 = (k2 - k + 16) * 32 + l2 - i + 16;
                    final double d4 = this.rainxs[i3] * 0.5;
                    final double d5 = this.rainys[i3] * 0.5;
                    if (this.protectedBox != null && this.protectedBox.func_78885_a(l2, k2, l2, k2)) {
                        final int structureMin = this.protectedBox.field_78895_b - 4;
                        final int structureMax = this.protectedBox.field_78894_e + 4;
                        int k3 = j - i2;
                        int l3 = j + i2 * 2;
                        if (k3 < structureMin) {
                            k3 = structureMin;
                        }
                        if (l3 < structureMin) {
                            l3 = structureMin;
                        }
                        if (k3 > structureMax) {
                            k3 = structureMax;
                        }
                        if (l3 > structureMax) {
                            l3 = structureMax;
                        }
                        if (k3 != l3) {
                            this.random.setSeed(l2 * l2 * 3121 + l2 * 45238971 ^ k2 * k2 * 418711 + k2 * 13761);
                            blockpos$mutableblockpos.func_181079_c(l2, k3, k2);
                            if (j2 != 0) {
                                if (j2 >= 0) {
                                    tessellator.func_78381_a();
                                }
                                j2 = 0;
                                mc.func_110434_K().func_110577_a(TFWeatherRenderer.SPARKLES_TEXTURE);
                                bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181704_d);
                            }
                            final double d6 = -((this.rendererUpdateCount + l2 * l2 * 3121 + l2 * 45238971 + k2 * k2 * 418711 + k2 * 13761 & 0x1F) + (double)partialTicks) / 32.0 * (3.0 + this.random.nextDouble());
                            final double d7 = l2 + 0.5f - entity.field_70165_t;
                            final double d8 = k2 + 0.5f - entity.field_70161_v;
                            final float f2 = MathHelper.func_76133_a(d7 * d7 + d8 * d8) / i2;
                            final float f3 = this.random.nextFloat();
                            final float f4 = ((1.0f - f2 * f2) * 0.5f + 0.5f) * f3;
                            final int j3 = 15728880;
                            final int k4 = j3 >> 16 & 0xFFFF;
                            final int l4 = j3 & 0xFFFF;
                            bufferbuilder.func_181662_b(l2 - d4 + 0.5, (double)l3, k2 - d5 + 0.5).func_187315_a(0.0, k3 * 0.25 + d6).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k4, l4).func_181675_d();
                            bufferbuilder.func_181662_b(l2 + d4 + 0.5, (double)l3, k2 + d5 + 0.5).func_187315_a(1.0, k3 * 0.25 + d6).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k4, l4).func_181675_d();
                            bufferbuilder.func_181662_b(l2 + d4 + 0.5, (double)k3, k2 + d5 + 0.5).func_187315_a(1.0, l3 * 0.25 + d6).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k4, l4).func_181675_d();
                            bufferbuilder.func_181662_b(l2 - d4 + 0.5, (double)k3, k2 - d5 + 0.5).func_187315_a(0.0, l3 * 0.25 + d6).func_181666_a(1.0f, 1.0f, 1.0f, f4).func_187314_a(k4, l4).func_181675_d();
                        }
                    }
                }
            }
            if (j2 >= 0) {
                tessellator.func_78381_a();
            }
            bufferbuilder.func_178969_c(0.0, 0.0, 0.0);
            GlStateManager.func_179089_o();
            GlStateManager.func_179084_k();
            GlStateManager.func_179092_a(516, 0.1f);
            mc.field_71460_t.func_175072_h();
        }
    }
    
    private boolean isNearLockedBiome(final World world, final Entity viewEntity) {
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        final int range = 15;
        final int px = MathHelper.func_76128_c(viewEntity.field_70165_t);
        for (int pz = MathHelper.func_76128_c(viewEntity.field_70161_v), z = pz - 15; z <= pz + 15; ++z) {
            for (int x = px - 15; x <= px + 15; ++x) {
                final Biome biome = world.func_180494_b((BlockPos)pos.func_181079_c(x, 0, z));
                if (!TFWorld.isBiomeSafeFor(biome, viewEntity)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isNearLockedStructure(final World world, final Entity viewEntity) {
        final int range = 15;
        final int px = MathHelper.func_76128_c(viewEntity.field_70165_t);
        final int pz = MathHelper.func_76128_c(viewEntity.field_70161_v);
        return this.protectedBox != null && this.protectedBox.func_78885_a(px - 15, pz - 15, px + 15, pz + 15);
    }
    
    public void setProtectedBox(final StructureBoundingBox protectedBox) {
        this.protectedBox = protectedBox;
    }
    
    private RenderType getRenderType(final Biome biome) {
        if (biome instanceof TFBiomeSnow || biome instanceof TFBiomeGlacier) {
            return RenderType.BLIZZARD;
        }
        if (biome instanceof TFBiomeSwamp) {
            return RenderType.MOSQUITO;
        }
        if (biome instanceof TFBiomeFireSwamp) {
            return RenderType.ASHES;
        }
        if (biome instanceof TFBiomeDarkForest) {
            return (this.random.nextInt(2) == 0) ? RenderType.DARK_STREAM : null;
        }
        if (biome instanceof TFBiomeHighlands || biome instanceof TFBiomeThornlands || biome instanceof TFBiomeFinalPlateau) {
            return RenderType.BIG_RAIN;
        }
        return null;
    }
    
    static {
        RAIN_TEXTURES = new ResourceLocation("textures/environment/rain.png");
        SNOW_TEXTURES = new ResourceLocation("textures/environment/snow.png");
        SPARKLES_TEXTURE = TwilightForestMod.getEnvTexture("sparkles.png");
    }
    
    private enum RenderType
    {
        BLIZZARD("blizzard.png"), 
        MOSQUITO("mosquitoes.png"), 
        ASHES("ashes.png"), 
        DARK_STREAM("darkstream.png"), 
        BIG_RAIN("bigrain.png");
        
        private final ResourceLocation textureLocation;
        
        private RenderType(final String textureName) {
            this.textureLocation = TwilightForestMod.getEnvTexture(textureName);
        }
        
        public ResourceLocation getTextureLocation() {
            return this.textureLocation;
        }
    }
}
