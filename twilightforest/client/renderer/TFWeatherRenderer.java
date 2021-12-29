// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import twilightforest.TwilightForestMod;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import com.mojang.blaze3d.vertex.BufferBuilder;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.client.renderer.LevelRenderer;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.BlockPos;
import java.util.function.Supplier;
import net.minecraft.client.renderer.GameRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.Tesselator;
import net.minecraft.world.level.Level;
import twilightforest.world.registration.TFGenerationSettings;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.IWeatherRenderHandler;

public class TFWeatherRenderer implements IWeatherRenderHandler
{
    private static final ResourceLocation RAIN_TEXTURES;
    private static final ResourceLocation SNOW_TEXTURES;
    private static final ResourceLocation SPARKLES_TEXTURE;
    private final float[] rainxs;
    private final float[] rainzs;
    private int rendererUpdateCount;
    private BoundingBox protectedBox;
    private final Random random;
    
    public TFWeatherRenderer() {
        this.rainxs = new float[1024];
        this.rainzs = new float[1024];
        this.random = new Random();
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32; ++j) {
                final float f = (float)(j - 16);
                final float f2 = (float)(i - 16);
                final float f3 = Mth.m_14116_(f * f + f2 * f2);
                this.rainxs[i << 5 | j] = -f2 / f3;
                this.rainzs[i << 5 | j] = f / f3;
            }
        }
    }
    
    public void tick() {
        ++this.rendererUpdateCount;
    }
    
    public void render(final int ticks, final float partialTicks, final ClientLevel world, final Minecraft mc, final LightTexture lightmap, final double xIn, final double yIn, final double zIn) {
        this.renderNormalWeather(lightmap, world, mc, partialTicks, xIn, yIn, zIn);
        if (TFGenerationSettings.isProgressionEnforced((Level)world) && !mc.f_91074_.m_7500_() && !mc.f_91074_.m_5833_()) {
            this.renderLockedBiome(partialTicks, world, mc, lightmap, xIn, yIn, zIn);
            this.renderLockedStructure(partialTicks, mc, lightmap, xIn, yIn, zIn);
        }
    }
    
    private void renderNormalWeather(final LightTexture lightmap, final ClientLevel world, final Minecraft mc, final float ticks, final double x, final double y, final double z) {
        final float f = Minecraft.m_91087_().f_91073_.m_46722_(ticks);
        if (f > 0.0f) {
            lightmap.m_109896_();
            final Level level = (Level)Minecraft.m_91087_().f_91073_;
            final int i = Mth.m_14107_(x);
            final int j = Mth.m_14107_(y);
            final int k = Mth.m_14107_(z);
            final Tesselator tesselator = Tesselator.m_85913_();
            final BufferBuilder bufferbuilder = tesselator.m_85915_();
            RenderSystem.m_69464_();
            RenderSystem.m_69478_();
            RenderSystem.m_69453_();
            RenderSystem.m_69482_();
            int l = 5;
            if (Minecraft.m_91405_()) {
                l = 10;
            }
            RenderSystem.m_69458_(Minecraft.m_91085_());
            int i2 = -1;
            final float f2 = this.rendererUpdateCount + ticks;
            RenderSystem.m_157427_((Supplier)GameRenderer::m_172829_);
            RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            for (int j2 = k - l; j2 <= k + l; ++j2) {
                for (int k2 = i - l; k2 <= i + l; ++k2) {
                    final int l2 = (j2 - k + 16) * 32 + k2 - i + 16;
                    final double d0 = this.rainxs[l2] * 0.5;
                    final double d2 = this.rainzs[l2] * 0.5;
                    blockpos$mutableblockpos.m_122178_(k2, 0, j2);
                    final Biome biome = level.m_46857_((BlockPos)blockpos$mutableblockpos);
                    if (biome.m_47530_() != Biome.Precipitation.NONE) {
                        final int i3 = level.m_5452_(Heightmap.Types.MOTION_BLOCKING, (BlockPos)blockpos$mutableblockpos).m_123342_();
                        int j3 = j - l;
                        int k3 = j + l;
                        if (j3 < i3) {
                            j3 = i3;
                        }
                        if (k3 < i3) {
                            k3 = i3;
                        }
                        int l3;
                        if ((l3 = i3) < j) {
                            l3 = j;
                        }
                        if (j3 != k3) {
                            final Random random = new Random(k2 * (long)k2 * 3121L + k2 * 45238971L ^ j2 * (long)j2 * 418711L + j2 * 13761L);
                            blockpos$mutableblockpos.m_122178_(k2, j3, j2);
                            final float f3 = biome.m_47505_((BlockPos)blockpos$mutableblockpos);
                            if (f3 >= 0.15f) {
                                if (i2 != 0) {
                                    if (i2 >= 0) {
                                        tesselator.m_85914_();
                                    }
                                    i2 = 0;
                                    RenderSystem.m_157456_(0, TFWeatherRenderer.RAIN_TEXTURES);
                                    bufferbuilder.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85813_);
                                }
                                final int i4 = this.rendererUpdateCount + k2 * k2 * 3121 + k2 * 45238971 + j2 * j2 * 418711 + j2 * 13761 & 0x1F;
                                final float f4 = -(i4 + ticks) / 32.0f * (3.0f + random.nextFloat());
                                final double d3 = k2 + 0.5 - x;
                                final double d4 = j2 + 0.5 - z;
                                final float f5 = (float)Math.sqrt(d3 * d3 + d4 * d4) / l;
                                final float f6 = ((1.0f - f5 * f5) * 0.5f + 0.5f) * f;
                                blockpos$mutableblockpos.m_122178_(k2, l3, j2);
                                final int j4 = LevelRenderer.m_109541_((BlockAndTintGetter)level, (BlockPos)blockpos$mutableblockpos);
                                bufferbuilder.m_5483_(k2 - x - d0 + 0.5, k3 - y, j2 - z - d2 + 0.5).m_7421_(0.0f, j3 * 0.25f + f4).m_85950_(1.0f, 1.0f, 1.0f, f6).m_85969_(j4).m_5752_();
                                bufferbuilder.m_5483_(k2 - x + d0 + 0.5, k3 - y, j2 - z + d2 + 0.5).m_7421_(1.0f, j3 * 0.25f + f4).m_85950_(1.0f, 1.0f, 1.0f, f6).m_85969_(j4).m_5752_();
                                bufferbuilder.m_5483_(k2 - x + d0 + 0.5, j3 - y, j2 - z + d2 + 0.5).m_7421_(1.0f, k3 * 0.25f + f4).m_85950_(1.0f, 1.0f, 1.0f, f6).m_85969_(j4).m_5752_();
                                bufferbuilder.m_5483_(k2 - x - d0 + 0.5, j3 - y, j2 - z - d2 + 0.5).m_7421_(0.0f, k3 * 0.25f + f4).m_85950_(1.0f, 1.0f, 1.0f, f6).m_85969_(j4).m_5752_();
                            }
                            else {
                                if (i2 != 1) {
                                    if (i2 >= 0) {
                                        tesselator.m_85914_();
                                    }
                                    i2 = 1;
                                    RenderSystem.m_157456_(0, TFWeatherRenderer.SNOW_TEXTURES);
                                    bufferbuilder.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85813_);
                                }
                                final float f7 = -((this.rendererUpdateCount & 0x1FF) + ticks) / 512.0f;
                                final float f8 = (float)(random.nextDouble() + f2 * 0.01 * (float)random.nextGaussian());
                                final float f9 = (float)(random.nextDouble() + f2 * (float)random.nextGaussian() * 0.001);
                                final double d5 = k2 + 0.5 - x;
                                final double d6 = j2 + 0.5 - z;
                                final float f10 = (float)Math.sqrt(d5 * d5 + d6 * d6) / l;
                                final float f11 = ((1.0f - f10 * f10) * 0.3f + 0.5f) * f;
                                blockpos$mutableblockpos.m_122178_(k2, l3, j2);
                                final int k4 = LevelRenderer.m_109541_((BlockAndTintGetter)level, (BlockPos)blockpos$mutableblockpos);
                                final int l4 = k4 >> 16 & 0xFFFF;
                                final int i5 = k4 & 0xFFFF;
                                final int j5 = (l4 * 3 + 240) / 4;
                                final int k5 = (i5 * 3 + 240) / 4;
                                bufferbuilder.m_5483_(k2 - x - d0 + 0.5, k3 - y, j2 - z - d2 + 0.5).m_7421_(0.0f + f8, j3 * 0.25f + f7 + f9).m_85950_(1.0f, 1.0f, 1.0f, f11).m_7120_(k5, j5).m_5752_();
                                bufferbuilder.m_5483_(k2 - x + d0 + 0.5, k3 - y, j2 - z + d2 + 0.5).m_7421_(1.0f + f8, j3 * 0.25f + f7 + f9).m_85950_(1.0f, 1.0f, 1.0f, f11).m_7120_(k5, j5).m_5752_();
                                bufferbuilder.m_5483_(k2 - x + d0 + 0.5, j3 - y, j2 - z + d2 + 0.5).m_7421_(1.0f + f8, k3 * 0.25f + f7 + f9).m_85950_(1.0f, 1.0f, 1.0f, f11).m_7120_(k5, j5).m_5752_();
                                bufferbuilder.m_5483_(k2 - x - d0 + 0.5, j3 - y, j2 - z - d2 + 0.5).m_7421_(0.0f + f8, k3 * 0.25f + f7 + f9).m_85950_(1.0f, 1.0f, 1.0f, f11).m_7120_(k5, j5).m_5752_();
                            }
                        }
                    }
                }
            }
            if (i2 >= 0) {
                tesselator.m_85914_();
            }
            RenderSystem.m_69481_();
            RenderSystem.m_69461_();
            lightmap.m_109891_();
        }
    }
    
    private void renderLockedBiome(final float partialTicks, final ClientLevel wc, final Minecraft mc, final LightTexture lightmap, final double xIn, final double yIn, final double zIn) {
        if (this.isNearLockedBiome((Level)wc, mc.m_91288_())) {
            lightmap.m_109896_();
            final Entity entity = mc.m_91288_();
            final Level world = (Level)mc.f_91073_;
            final int x0 = Mth.m_14107_(xIn);
            final int y0 = Mth.m_14107_(yIn);
            final int z0 = Mth.m_14107_(zIn);
            final Tesselator tessellator = Tesselator.m_85913_();
            final BufferBuilder bufferbuilder = tessellator.m_85915_();
            RenderSystem.m_69464_();
            RenderSystem.m_69478_();
            RenderSystem.m_69453_();
            RenderSystem.m_69482_();
            int range = 5;
            if (Minecraft.m_91405_()) {
                range = 10;
            }
            RenderSystem.m_69458_(Minecraft.m_91085_());
            RenderType currentType = null;
            final float combinedTicks = this.rendererUpdateCount + partialTicks;
            RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            for (int z2 = z0 - range; z2 <= z0 + range; ++z2) {
                for (int x2 = x0 - range; x2 <= x0 + range; ++x2) {
                    final int idx = (z2 - z0 + 16) * 32 + x2 - x0 + 16;
                    final double rx = this.rainxs[idx] * 0.5;
                    final double ry = this.rainzs[idx] * 0.5;
                    blockpos$mutableblockpos.m_122178_(x2, 0, z2);
                    final Biome biome = world.m_46857_((BlockPos)blockpos$mutableblockpos);
                    if (!TFGenerationSettings.isBiomeSafeFor(biome, entity)) {
                        final int groundY = 0;
                        int minY = y0 - range;
                        int maxY = y0 + range;
                        if (minY < groundY) {
                            minY = groundY;
                        }
                        if (maxY < groundY) {
                            maxY = groundY;
                        }
                        final int y2 = Math.max(groundY, y0);
                        if (minY != maxY) {
                            this.random.setSeed(x2 * (long)x2 * 3121L + x2 * 45238971L ^ z2 * (long)z2 * 418711L + z2 * 13761L);
                            final RenderType nextType = this.getRenderType(biome);
                            if (nextType != null) {
                                if (currentType != nextType) {
                                    if (currentType != null) {
                                        tessellator.m_85914_();
                                    }
                                    currentType = nextType;
                                    RenderSystem.m_157179_(0, nextType.getTextureLocation());
                                    bufferbuilder.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85813_);
                                }
                                switch (currentType) {
                                    case BLIZZARD:
                                    case BIG_RAIN: {
                                        final float d5 = -((this.rendererUpdateCount + x2 * x2 * 3121 + x2 * 45238971 + z2 * z2 * 418711 + z2 * 13761 & 0x1F) + partialTicks) / 32.0f * (3.0f + this.random.nextFloat());
                                        final double d6 = x2 + 0.5f - xIn;
                                        final double d7 = z2 + 0.5f - zIn;
                                        final float f3 = Mth.m_14116_((float)(d6 * d6 + d7 * d7)) / range;
                                        final float f4 = (1.0f - f3 * f3) * 0.5f + 0.5f;
                                        blockpos$mutableblockpos.m_122178_(x2, y2, z2);
                                        final int j3 = LevelRenderer.m_109541_((BlockAndTintGetter)world, (BlockPos)blockpos$mutableblockpos);
                                        final int k3 = j3 >> 16 & 0xFFFF;
                                        final int l3 = j3 & 0xFFFF;
                                        bufferbuilder.m_5483_(x2 - xIn - rx + 0.5, maxY - yIn, z2 - zIn - ry + 0.5).m_7421_(0.0f, minY * 0.25f + d5).m_85950_(1.0f, 1.0f, 1.0f, f4).m_7120_(k3, l3).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn + rx + 0.5, maxY - yIn, z2 - zIn + ry + 0.5).m_7421_(1.0f, minY * 0.25f + d5).m_85950_(1.0f, 1.0f, 1.0f, f4).m_7120_(k3, l3).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn + rx + 0.5, minY - yIn, z2 - zIn + ry + 0.5).m_7421_(1.0f, maxY * 0.25f + d5).m_85950_(1.0f, 1.0f, 1.0f, f4).m_7120_(k3, l3).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn - rx + 0.5, minY - yIn, z2 - zIn - ry + 0.5).m_7421_(0.0f, maxY * 0.25f + d5).m_85950_(1.0f, 1.0f, 1.0f, f4).m_7120_(k3, l3).m_5752_();
                                        break;
                                    }
                                    case MOSQUITO: {
                                        final float d8 = 0.0f;
                                        final float d9 = this.random.nextFloat() + combinedTicks * 0.01f * (float)this.random.nextGaussian();
                                        final float d10 = this.random.nextFloat() + combinedTicks * (float)this.random.nextGaussian() * 0.001f;
                                        final double d11 = x2 + 0.5f - xIn;
                                        final double d12 = z2 + 0.5f - zIn;
                                        final float f5 = Mth.m_14116_((float)(d11 * d11 + d12 * d12)) / range;
                                        final float r = this.random.nextFloat() * 0.3f;
                                        final float g = this.random.nextFloat() * 0.3f;
                                        final float b = this.random.nextFloat() * 0.3f;
                                        final float f6 = (1.0f - f5 * f5) * 0.3f + 0.5f;
                                        final int i4 = 15728880;
                                        final int j4 = i4 >> 16 & 0xFFFF;
                                        final int k4 = i4 & 0xFFFF;
                                        bufferbuilder.m_5483_(x2 - xIn - rx + 0.5, maxY - yIn, z2 - zIn - ry + 0.5).m_7421_(0.0f + d9, minY * 0.25f + d8 + d10).m_85950_(r, g, b, f6).m_7120_(j4, k4).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn + rx + 0.5, maxY - yIn, z2 - zIn + ry + 0.5).m_7421_(1.0f + d9, minY * 0.25f + d8 + d10).m_85950_(r, g, b, f6).m_7120_(j4, k4).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn + rx + 0.5, minY - yIn, z2 - zIn + ry + 0.5).m_7421_(1.0f + d9, maxY * 0.25f + d8 + d10).m_85950_(r, g, b, f6).m_7120_(j4, k4).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn - rx + 0.5, minY - yIn, z2 - zIn - ry + 0.5).m_7421_(0.0f + d9, maxY * 0.25f + d8 + d10).m_85950_(r, g, b, f6).m_7120_(j4, k4).m_5752_();
                                        break;
                                    }
                                    case ASHES: {
                                        final float d8 = -((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                        final float d9 = this.random.nextFloat() + combinedTicks * 0.01f * (float)this.random.nextGaussian();
                                        final float d10 = this.random.nextFloat() + combinedTicks * (float)this.random.nextGaussian() * 0.001f;
                                        final double d11 = x2 + 0.5f - xIn;
                                        final double d12 = z2 + 0.5f - zIn;
                                        final float f5 = Mth.m_14116_((float)(d11 * d11 + d12 * d12)) / range;
                                        final float f7 = (1.0f - f5 * f5) * 0.3f + 0.5f;
                                        final int i5 = 15728880;
                                        final int j5 = i5 >> 16 & 0xFFFF;
                                        final int k5 = i5 & 0xFFFF;
                                        final float color = this.random.nextFloat() * 0.2f + 0.8f;
                                        bufferbuilder.m_5483_(x2 - xIn - rx + 0.5, maxY - yIn, z2 - zIn - ry + 0.5).m_7421_(0.0f + d9, minY * 0.25f + d8 + d10).m_85950_(color, color, color, f7).m_7120_(j5, k5).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn + rx + 0.5, maxY - yIn, z2 - zIn + ry + 0.5).m_7421_(1.0f + d9, minY * 0.25f + d8 + d10).m_85950_(color, color, color, f7).m_7120_(j5, k5).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn + rx + 0.5, minY - yIn, z2 - zIn + ry + 0.5).m_7421_(1.0f + d9, maxY * 0.25f + d8 + d10).m_85950_(color, color, color, f7).m_7120_(j5, k5).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn - rx + 0.5, minY - yIn, z2 - zIn - ry + 0.5).m_7421_(0.0f + d9, maxY * 0.25f + d8 + d10).m_85950_(color, color, color, f7).m_7120_(j5, k5).m_5752_();
                                        break;
                                    }
                                    case DARK_STREAM: {
                                        final float d8 = -((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                        final float d9 = 0.0f;
                                        final float d10 = this.random.nextFloat() + combinedTicks * (float)this.random.nextGaussian() * 0.001f;
                                        final double d11 = x2 + 0.5f - xIn;
                                        final double d12 = z2 + 0.5f - zIn;
                                        final float f5 = Mth.m_14116_((float)(d11 * d11 + d12 * d12)) / range;
                                        final float f7 = ((1.0f - f5 * f5) * 0.3f + 0.5f) * this.random.nextFloat();
                                        final int i5 = 15728880;
                                        final int j5 = i5 >> 16 & 0xFFFF;
                                        final int k5 = i5 & 0xFFFF;
                                        bufferbuilder.m_5483_(x2 - xIn - rx + 0.5, maxY - yIn, z2 - zIn - ry + 0.5).m_7421_(0.0f + d9, minY * 0.25f + d8 + d10).m_85950_(1.0f, 1.0f, 1.0f, f7).m_7120_(j5, k5).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn + rx + 0.5, maxY - yIn, z2 - zIn + ry + 0.5).m_7421_(1.0f + d9, minY * 0.25f + d8 + d10).m_85950_(1.0f, 1.0f, 1.0f, f7).m_7120_(j5, k5).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn + rx + 0.5, minY - yIn, z2 - zIn + ry + 0.5).m_7421_(1.0f + d9, maxY * 0.25f + d8 + d10).m_85950_(1.0f, 1.0f, 1.0f, f7).m_7120_(j5, k5).m_5752_();
                                        bufferbuilder.m_5483_(x2 - xIn - rx + 0.5, minY - yIn, z2 - zIn - ry + 0.5).m_7421_(0.0f + d9, maxY * 0.25f + d8 + d10).m_85950_(1.0f, 1.0f, 1.0f, f7).m_7120_(j5, k5).m_5752_();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (currentType != null) {
                tessellator.m_85914_();
            }
            RenderSystem.m_69481_();
            RenderSystem.m_69461_();
            lightmap.m_109891_();
        }
    }
    
    private void renderLockedStructure(final float partialTicks, final Minecraft mc, final LightTexture lightmap, final double xIn, final double yIn, final double zIn) {
        if (this.isNearLockedStructure(xIn, zIn)) {
            lightmap.m_109896_();
            final int i = Mth.m_14107_(xIn);
            final int j = Mth.m_14107_(yIn);
            final int k = Mth.m_14107_(zIn);
            final Tesselator tessellator = Tesselator.m_85913_();
            final BufferBuilder bufferbuilder = tessellator.m_85915_();
            RenderSystem.m_69464_();
            RenderSystem.m_69478_();
            RenderSystem.m_69453_();
            RenderSystem.m_69482_();
            int i2 = 5;
            if (Minecraft.m_91405_()) {
                i2 = 10;
            }
            RenderSystem.m_69458_(Minecraft.m_91085_());
            int j2 = -1;
            RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            for (int k2 = k - i2; k2 <= k + i2; ++k2) {
                for (int l1 = i - i2; l1 <= i + i2; ++l1) {
                    final int i3 = (k2 - k + 16) * 32 + l1 - i + 16;
                    final double d3 = this.rainxs[i3] * 0.5;
                    final double d4 = this.rainzs[i3] * 0.5;
                    if (this.protectedBox != null && this.protectedBox.m_71019_(l1, k2, l1, k2)) {
                        final int structureMin = this.protectedBox.m_162396_() - 4;
                        final int structureMax = this.protectedBox.m_162400_() + 4;
                        int k3 = j - i2;
                        int l2 = j + i2 * 2;
                        if (k3 < structureMin) {
                            k3 = structureMin;
                        }
                        if (l2 < structureMin) {
                            l2 = structureMin;
                        }
                        if (k3 > structureMax) {
                            k3 = structureMax;
                        }
                        if (l2 > structureMax) {
                            l2 = structureMax;
                        }
                        if (k3 != l2) {
                            final Random random = new Random(l1 * (long)l1 * 3121L + l1 * 45238971L ^ k2 * (long)k2 * 418711L + k2 * 13761L);
                            blockpos$mutableblockpos.m_122178_(l1, k3, k2);
                            if (j2 != 0) {
                                if (j2 >= 0) {
                                    tessellator.m_85914_();
                                }
                                j2 = 0;
                                RenderSystem.m_157179_(0, TFWeatherRenderer.SPARKLES_TEXTURE);
                                bufferbuilder.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85813_);
                            }
                            final float d5 = -((this.rendererUpdateCount + l1 * l1 * 3121 + l1 * 45238971 + k2 * k2 * 418711 + k2 * 13761 & 0x1F) + partialTicks) / 32.0f * (3.0f + random.nextFloat());
                            final double d6 = l1 + 0.5f - xIn;
                            final double d7 = k2 + 0.5f - zIn;
                            final float f3 = Mth.m_14116_((float)(d6 * d6 + d7 * d7)) / i2;
                            final float f4 = random.nextFloat();
                            final float f5 = ((1.0f - f3 * f3) * 0.5f + 0.5f) * f4;
                            final int j3 = 15728880;
                            final int k4 = j3 >> 16 & 0xFFFF;
                            final int l3 = j3 & 0xFFFF;
                            bufferbuilder.m_5483_(l1 - xIn - d3 + 0.5, l2 - yIn, k2 - zIn - d4 + 0.5).m_7421_(0.0f, k3 * 0.25f + d5).m_85950_(1.0f, 1.0f, 1.0f, f5).m_7120_(k4, l3).m_5752_();
                            bufferbuilder.m_5483_(l1 - xIn + d3 + 0.5, l2 - yIn, k2 - zIn + d4 + 0.5).m_7421_(1.0f, k3 * 0.25f + d5).m_85950_(1.0f, 1.0f, 1.0f, f5).m_7120_(k4, l3).m_5752_();
                            bufferbuilder.m_5483_(l1 - xIn + d3 + 0.5, k3 - yIn, k2 - zIn + d4 + 0.5).m_7421_(1.0f, l2 * 0.25f + d5).m_85950_(1.0f, 1.0f, 1.0f, f5).m_7120_(k4, l3).m_5752_();
                            bufferbuilder.m_5483_(l1 - xIn - d3 + 0.5, k3 - yIn, k2 - zIn - d4 + 0.5).m_7421_(0.0f, l2 * 0.25f + d5).m_85950_(1.0f, 1.0f, 1.0f, f5).m_7120_(k4, l3).m_5752_();
                        }
                    }
                }
            }
            if (j2 >= 0) {
                tessellator.m_85914_();
            }
            RenderSystem.m_69481_();
            RenderSystem.m_69461_();
            lightmap.m_109891_();
        }
    }
    
    private boolean isNearLockedBiome(final Level world, final Entity viewEntity) {
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        final int range = 15;
        final int px = Mth.m_14107_(viewEntity.m_20185_());
        for (int pz = Mth.m_14107_(viewEntity.m_20189_()), z = pz - 15; z <= pz + 15; ++z) {
            for (int x = px - 15; x <= px + 15; ++x) {
                final Biome biome = world.m_46857_((BlockPos)pos.m_122178_(x, 0, z));
                if (!TFGenerationSettings.isBiomeSafeFor(biome, viewEntity)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isNearLockedStructure(final double xIn, final double zIn) {
        final int range = 15;
        final int px = Mth.m_14107_(xIn);
        final int pz = Mth.m_14107_(zIn);
        return this.protectedBox != null && this.protectedBox.m_71019_(px - 15, pz - 15, px + 15, pz + 15);
    }
    
    public void setProtectedBox(final BoundingBox protectedBox) {
        this.protectedBox = protectedBox;
    }
    
    private RenderType getRenderType(final Biome b) {
        if (Minecraft.m_91087_().f_91073_ == null) {
            return null;
        }
        final ResourceLocation biome = Minecraft.m_91087_().f_91073_.m_5962_().m_175515_(Registry.f_122885_).m_7981_((Object)b);
        if (BiomeKeys.SNOWY_FOREST.m_135782_().equals((Object)biome) || BiomeKeys.GLACIER.m_135782_().equals((Object)biome)) {
            return RenderType.BLIZZARD;
        }
        if (BiomeKeys.SWAMP.m_135782_().equals((Object)biome)) {
            return RenderType.MOSQUITO;
        }
        if (BiomeKeys.FIRE_SWAMP.m_135782_().equals((Object)biome)) {
            return RenderType.ASHES;
        }
        if (BiomeKeys.DARK_FOREST.m_135782_().equals((Object)biome) || BiomeKeys.DARK_FOREST_CENTER.m_135782_().equals((Object)biome)) {
            return (this.random.nextInt(2) == 0) ? RenderType.DARK_STREAM : null;
        }
        if (BiomeKeys.HIGHLANDS.m_135782_().equals((Object)biome) || BiomeKeys.THORNLANDS.m_135782_().equals((Object)biome) || BiomeKeys.FINAL_PLATEAU.m_135782_().equals((Object)biome)) {
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
