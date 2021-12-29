// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import twilightforest.TwilightForestMod;
import twilightforest.worldgen.biomes.BiomeKeys;
import net.minecraft.util.registry.Registry;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import twilightforest.world.TFGenerationSettings;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IWeatherRenderHandler;

public class TFWeatherRenderer implements IWeatherRenderHandler
{
    private static final ResourceLocation RAIN_TEXTURES;
    private static final ResourceLocation SNOW_TEXTURES;
    private static final ResourceLocation SPARKLES_TEXTURE;
    private final float[] rainxs;
    private final float[] rainzs;
    private int rendererUpdateCount;
    private MutableBoundingBox protectedBox;
    private final Random random;
    
    public TFWeatherRenderer() {
        this.rainxs = new float[1024];
        this.rainzs = new float[1024];
        this.random = new Random();
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32; ++j) {
                final float f = (float)(j - 16);
                final float f2 = (float)(i - 16);
                final float f3 = MathHelper.func_76129_c(f * f + f2 * f2);
                this.rainxs[i << 5 | j] = -f2 / f3;
                this.rainzs[i << 5 | j] = f / f3;
            }
        }
    }
    
    public void tick() {
        ++this.rendererUpdateCount;
    }
    
    public void render(final int ticks, final float partialTicks, final ClientWorld world, final Minecraft mc, final LightTexture lightmap, final double xIn, final double yIn, final double zIn) {
        this.renderNormalWeather(lightmap, world, mc, partialTicks, xIn, yIn, zIn);
        if (TFGenerationSettings.isProgressionEnforced((World)world) && !mc.field_71439_g.func_184812_l_() && !mc.field_71439_g.func_175149_v()) {
            this.renderLockedBiome(partialTicks, world, mc, lightmap, xIn, yIn, zIn);
            this.renderLockedStructure(partialTicks, mc, lightmap, xIn, yIn, zIn);
        }
    }
    
    private void renderNormalWeather(final LightTexture lightmapIn, final ClientWorld world, final Minecraft mc, final float partialTicks, final double xIn, final double yIn, final double zIn) {
        final float f = world.func_72867_j(partialTicks);
        if (f > 0.0f) {
            lightmapIn.func_205109_c();
            final int i = MathHelper.func_76128_c(xIn);
            final int j = MathHelper.func_76128_c(yIn);
            final int k = MathHelper.func_76128_c(zIn);
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder bufferbuilder = tessellator.func_178180_c();
            RenderSystem.enableAlphaTest();
            RenderSystem.disableCull();
            RenderSystem.normal3f(0.0f, 1.0f, 0.0f);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.defaultAlphaFunc();
            RenderSystem.enableDepthTest();
            int l = 5;
            if (Minecraft.func_71375_t()) {
                l = 10;
            }
            RenderSystem.depthMask(Minecraft.func_238218_y_());
            int i2 = -1;
            final float f2 = this.rendererUpdateCount + partialTicks;
            RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
            for (int j2 = k - l; j2 <= k + l; ++j2) {
                for (int k2 = i - l; k2 <= i + l; ++k2) {
                    final int l2 = (j2 - k + 16) * 32 + k2 - i + 16;
                    final double d0 = this.rainxs[l2] * 0.5;
                    final double d2 = this.rainzs[l2] * 0.5;
                    blockpos$mutable.func_181079_c(k2, 0, j2);
                    final Biome biome = world.func_226691_t_((BlockPos)blockpos$mutable);
                    if (biome.func_201851_b() != Biome.RainType.NONE) {
                        final int i3 = world.func_205770_a(Heightmap.Type.MOTION_BLOCKING, (BlockPos)blockpos$mutable).func_177956_o();
                        int j3 = j - l;
                        int k3 = j + l;
                        if (j3 < i3) {
                            j3 = i3;
                        }
                        if (k3 < i3) {
                            k3 = i3;
                        }
                        final int l3 = Math.max(i3, j);
                        if (j3 != k3) {
                            final Random random = new Random(k2 * (long)k2 * 3121L + k2 * 45238971L ^ j2 * (long)j2 * 418711L + j2 * 13761L);
                            blockpos$mutable.func_181079_c(k2, j3, j2);
                            final float f3 = biome.func_225486_c((BlockPos)blockpos$mutable);
                            if (f3 >= 0.15f) {
                                if (i2 != 0) {
                                    if (i2 >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    i2 = 0;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.RAIN_TEXTURES);
                                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181704_d);
                                }
                                final int i4 = this.rendererUpdateCount + k2 * k2 * 3121 + k2 * 45238971 + j2 * j2 * 418711 + j2 * 13761 & 0x1F;
                                final float f4 = -(i4 + partialTicks) / 32.0f * (3.0f + random.nextFloat());
                                final double d3 = k2 + 0.5f - xIn;
                                final double d4 = j2 + 0.5f - zIn;
                                final float f5 = MathHelper.func_76133_a(d3 * d3 + d4 * d4) / l;
                                final float f6 = ((1.0f - f5 * f5) * 0.5f + 0.5f) * f;
                                blockpos$mutable.func_181079_c(k2, l3, j2);
                                final int j4 = WorldRenderer.func_228421_a_((IBlockDisplayReader)world, (BlockPos)blockpos$mutable);
                                bufferbuilder.func_225582_a_(k2 - xIn - d0 + 0.5, k3 - yIn, j2 - zIn - d2 + 0.5).func_225583_a_(0.0f, j3 * 0.25f + f4).func_227885_a_(1.0f, 1.0f, 1.0f, f6).func_227886_a_(j4).func_181675_d();
                                bufferbuilder.func_225582_a_(k2 - xIn + d0 + 0.5, k3 - yIn, j2 - zIn + d2 + 0.5).func_225583_a_(1.0f, j3 * 0.25f + f4).func_227885_a_(1.0f, 1.0f, 1.0f, f6).func_227886_a_(j4).func_181675_d();
                                bufferbuilder.func_225582_a_(k2 - xIn + d0 + 0.5, j3 - yIn, j2 - zIn + d2 + 0.5).func_225583_a_(1.0f, k3 * 0.25f + f4).func_227885_a_(1.0f, 1.0f, 1.0f, f6).func_227886_a_(j4).func_181675_d();
                                bufferbuilder.func_225582_a_(k2 - xIn - d0 + 0.5, j3 - yIn, j2 - zIn - d2 + 0.5).func_225583_a_(0.0f, k3 * 0.25f + f4).func_227885_a_(1.0f, 1.0f, 1.0f, f6).func_227886_a_(j4).func_181675_d();
                            }
                            else {
                                if (i2 != 1) {
                                    if (i2 >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    i2 = 1;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.SNOW_TEXTURES);
                                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181704_d);
                                }
                                final float f7 = -((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                final float f8 = (float)(random.nextDouble() + f2 * 0.01 * (float)random.nextGaussian());
                                final float f9 = (float)(random.nextDouble() + f2 * (float)random.nextGaussian() * 0.001);
                                final double d5 = k2 + 0.5f - xIn;
                                final double d6 = j2 + 0.5f - zIn;
                                final float f10 = MathHelper.func_76133_a(d5 * d5 + d6 * d6) / l;
                                final float f11 = ((1.0f - f10 * f10) * 0.3f + 0.5f) * f;
                                blockpos$mutable.func_181079_c(k2, l3, j2);
                                final int k4 = WorldRenderer.func_228421_a_((IBlockDisplayReader)world, (BlockPos)blockpos$mutable);
                                final int l4 = k4 >> 16 & 0xFFFF;
                                final int i5 = (k4 & 0xFFFF) * 3;
                                final int j5 = (l4 * 3 + 240) / 4;
                                final int k5 = (i5 * 3 + 240) / 4;
                                bufferbuilder.func_225582_a_(k2 - xIn - d0 + 0.5, k3 - yIn, j2 - zIn - d2 + 0.5).func_225583_a_(0.0f + f8, j3 * 0.25f + f7 + f9).func_227885_a_(1.0f, 1.0f, 1.0f, f11).func_225587_b_(k5, j5).func_181675_d();
                                bufferbuilder.func_225582_a_(k2 - xIn + d0 + 0.5, k3 - yIn, j2 - zIn + d2 + 0.5).func_225583_a_(1.0f + f8, j3 * 0.25f + f7 + f9).func_227885_a_(1.0f, 1.0f, 1.0f, f11).func_225587_b_(k5, j5).func_181675_d();
                                bufferbuilder.func_225582_a_(k2 - xIn + d0 + 0.5, j3 - yIn, j2 - zIn + d2 + 0.5).func_225583_a_(1.0f + f8, k3 * 0.25f + f7 + f9).func_227885_a_(1.0f, 1.0f, 1.0f, f11).func_225587_b_(k5, j5).func_181675_d();
                                bufferbuilder.func_225582_a_(k2 - xIn - d0 + 0.5, j3 - yIn, j2 - zIn - d2 + 0.5).func_225583_a_(0.0f + f8, k3 * 0.25f + f7 + f9).func_227885_a_(1.0f, 1.0f, 1.0f, f11).func_225587_b_(k5, j5).func_181675_d();
                            }
                        }
                    }
                }
            }
            if (i2 >= 0) {
                tessellator.func_78381_a();
            }
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            RenderSystem.defaultAlphaFunc();
            RenderSystem.disableAlphaTest();
            lightmapIn.func_205108_b();
        }
    }
    
    private void renderLockedBiome(final float partialTicks, final ClientWorld wc, final Minecraft mc, final LightTexture lightmap, final double xIn, final double yIn, final double zIn) {
        if (this.isNearLockedBiome((World)wc, mc.func_175606_aa())) {
            lightmap.func_205109_c();
            final Entity entity = mc.func_175606_aa();
            final World world = (World)mc.field_71441_e;
            final int x0 = MathHelper.func_76128_c(xIn);
            final int y0 = MathHelper.func_76128_c(yIn);
            final int z0 = MathHelper.func_76128_c(zIn);
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder bufferbuilder = tessellator.func_178180_c();
            RenderSystem.disableCull();
            RenderSystem.normal3f(0.0f, 1.0f, 0.0f);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.defaultAlphaFunc();
            RenderSystem.enableDepthTest();
            int range = 5;
            if (Minecraft.func_71375_t()) {
                range = 10;
            }
            RenderSystem.depthMask(Minecraft.func_238218_y_());
            RenderType currentType = null;
            final float combinedTicks = this.rendererUpdateCount + partialTicks;
            RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
            for (int z2 = z0 - range; z2 <= z0 + range; ++z2) {
                for (int x2 = x0 - range; x2 <= x0 + range; ++x2) {
                    final int idx = (z2 - z0 + 16) * 32 + x2 - x0 + 16;
                    final double rx = this.rainxs[idx] * 0.5;
                    final double ry = this.rainzs[idx] * 0.5;
                    blockpos$mutableblockpos.func_181079_c(x2, 0, z2);
                    final Biome biome = world.func_226691_t_((BlockPos)blockpos$mutableblockpos);
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
                                        tessellator.func_78381_a();
                                    }
                                    currentType = nextType;
                                    mc.func_110434_K().func_110577_a(nextType.getTextureLocation());
                                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181704_d);
                                }
                                switch (currentType) {
                                    case BLIZZARD:
                                    case BIG_RAIN: {
                                        final float d5 = -((this.rendererUpdateCount + x2 * x2 * 3121 + x2 * 45238971 + z2 * z2 * 418711 + z2 * 13761 & 0x1F) + partialTicks) / 32.0f * (3.0f + this.random.nextFloat());
                                        final double d6 = x2 + 0.5f - xIn;
                                        final double d7 = z2 + 0.5f - zIn;
                                        final float f3 = MathHelper.func_76133_a(d6 * d6 + d7 * d7) / range;
                                        final float f4 = (1.0f - f3 * f3) * 0.5f + 0.5f;
                                        blockpos$mutableblockpos.func_181079_c(x2, y2, z2);
                                        final int j3 = WorldRenderer.func_228421_a_((IBlockDisplayReader)world, (BlockPos)blockpos$mutableblockpos);
                                        final int k3 = j3 >> 16 & 0xFFFF;
                                        final int l3 = j3 & 0xFFFF;
                                        bufferbuilder.func_225582_a_(x2 - xIn - rx + 0.5, maxY - yIn, z2 - zIn - ry + 0.5).func_225583_a_(0.0f, minY * 0.25f + d5).func_227885_a_(1.0f, 1.0f, 1.0f, f4).func_225587_b_(k3, l3).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn + rx + 0.5, maxY - yIn, z2 - zIn + ry + 0.5).func_225583_a_(1.0f, minY * 0.25f + d5).func_227885_a_(1.0f, 1.0f, 1.0f, f4).func_225587_b_(k3, l3).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn + rx + 0.5, minY - yIn, z2 - zIn + ry + 0.5).func_225583_a_(1.0f, maxY * 0.25f + d5).func_227885_a_(1.0f, 1.0f, 1.0f, f4).func_225587_b_(k3, l3).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn - rx + 0.5, minY - yIn, z2 - zIn - ry + 0.5).func_225583_a_(0.0f, maxY * 0.25f + d5).func_227885_a_(1.0f, 1.0f, 1.0f, f4).func_225587_b_(k3, l3).func_181675_d();
                                        break;
                                    }
                                    case MOSQUITO: {
                                        final float d8 = 0.0f;
                                        final float d9 = this.random.nextFloat() + combinedTicks * 0.01f * (float)this.random.nextGaussian();
                                        final float d10 = this.random.nextFloat() + combinedTicks * (float)this.random.nextGaussian() * 0.001f;
                                        final double d11 = x2 + 0.5f - xIn;
                                        final double d12 = z2 + 0.5f - zIn;
                                        final float f5 = MathHelper.func_76133_a(d11 * d11 + d12 * d12) / range;
                                        final float r = this.random.nextFloat() * 0.3f;
                                        final float g = this.random.nextFloat() * 0.3f;
                                        final float b = this.random.nextFloat() * 0.3f;
                                        final float f6 = (1.0f - f5 * f5) * 0.3f + 0.5f;
                                        final int i4 = 15728880;
                                        final int j4 = i4 >> 16 & 0xFFFF;
                                        final int k4 = i4 & 0xFFFF;
                                        bufferbuilder.func_225582_a_(x2 - xIn - rx + 0.5, maxY - yIn, z2 - zIn - ry + 0.5).func_225583_a_(0.0f + d9, minY * 0.25f + d8 + d10).func_227885_a_(r, g, b, f6).func_225587_b_(j4, k4).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn + rx + 0.5, maxY - yIn, z2 - zIn + ry + 0.5).func_225583_a_(1.0f + d9, minY * 0.25f + d8 + d10).func_227885_a_(r, g, b, f6).func_225587_b_(j4, k4).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn + rx + 0.5, minY - yIn, z2 - zIn + ry + 0.5).func_225583_a_(1.0f + d9, maxY * 0.25f + d8 + d10).func_227885_a_(r, g, b, f6).func_225587_b_(j4, k4).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn - rx + 0.5, minY - yIn, z2 - zIn - ry + 0.5).func_225583_a_(0.0f + d9, maxY * 0.25f + d8 + d10).func_227885_a_(r, g, b, f6).func_225587_b_(j4, k4).func_181675_d();
                                        break;
                                    }
                                    case ASHES: {
                                        final float d8 = -((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                        final float d9 = this.random.nextFloat() + combinedTicks * 0.01f * (float)this.random.nextGaussian();
                                        final float d10 = this.random.nextFloat() + combinedTicks * (float)this.random.nextGaussian() * 0.001f;
                                        final double d11 = x2 + 0.5f - xIn;
                                        final double d12 = z2 + 0.5f - zIn;
                                        final float f5 = MathHelper.func_76133_a(d11 * d11 + d12 * d12) / range;
                                        final float f7 = (1.0f - f5 * f5) * 0.3f + 0.5f;
                                        final int i5 = 15728880;
                                        final int j5 = i5 >> 16 & 0xFFFF;
                                        final int k5 = i5 & 0xFFFF;
                                        final float color = this.random.nextFloat() * 0.2f + 0.8f;
                                        bufferbuilder.func_225582_a_(x2 - xIn - rx + 0.5, maxY - yIn, z2 - zIn - ry + 0.5).func_225583_a_(0.0f + d9, minY * 0.25f + d8 + d10).func_227885_a_(color, color, color, f7).func_225587_b_(j5, k5).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn + rx + 0.5, maxY - yIn, z2 - zIn + ry + 0.5).func_225583_a_(1.0f + d9, minY * 0.25f + d8 + d10).func_227885_a_(color, color, color, f7).func_225587_b_(j5, k5).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn + rx + 0.5, minY - yIn, z2 - zIn + ry + 0.5).func_225583_a_(1.0f + d9, maxY * 0.25f + d8 + d10).func_227885_a_(color, color, color, f7).func_225587_b_(j5, k5).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn - rx + 0.5, minY - yIn, z2 - zIn - ry + 0.5).func_225583_a_(0.0f + d9, maxY * 0.25f + d8 + d10).func_227885_a_(color, color, color, f7).func_225587_b_(j5, k5).func_181675_d();
                                        break;
                                    }
                                    case DARK_STREAM: {
                                        final float d8 = -((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                        final float d9 = 0.0f;
                                        final float d10 = this.random.nextFloat() + combinedTicks * (float)this.random.nextGaussian() * 0.001f;
                                        final double d11 = x2 + 0.5f - xIn;
                                        final double d12 = z2 + 0.5f - zIn;
                                        final float f5 = MathHelper.func_76133_a(d11 * d11 + d12 * d12) / range;
                                        final float f7 = ((1.0f - f5 * f5) * 0.3f + 0.5f) * this.random.nextFloat();
                                        final int i5 = 15728880;
                                        final int j5 = i5 >> 16 & 0xFFFF;
                                        final int k5 = i5 & 0xFFFF;
                                        bufferbuilder.func_225582_a_(x2 - xIn - rx + 0.5, maxY - yIn, z2 - zIn - ry + 0.5).func_225583_a_(0.0f + d9, minY * 0.25f + d8 + d10).func_227885_a_(1.0f, 1.0f, 1.0f, f7).func_225587_b_(j5, k5).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn + rx + 0.5, maxY - yIn, z2 - zIn + ry + 0.5).func_225583_a_(1.0f + d9, minY * 0.25f + d8 + d10).func_227885_a_(1.0f, 1.0f, 1.0f, f7).func_225587_b_(j5, k5).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn + rx + 0.5, minY - yIn, z2 - zIn + ry + 0.5).func_225583_a_(1.0f + d9, maxY * 0.25f + d8 + d10).func_227885_a_(1.0f, 1.0f, 1.0f, f7).func_225587_b_(j5, k5).func_181675_d();
                                        bufferbuilder.func_225582_a_(x2 - xIn - rx + 0.5, minY - yIn, z2 - zIn - ry + 0.5).func_225583_a_(0.0f + d9, maxY * 0.25f + d8 + d10).func_227885_a_(1.0f, 1.0f, 1.0f, f7).func_225587_b_(j5, k5).func_181675_d();
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
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            RenderSystem.defaultAlphaFunc();
            RenderSystem.disableAlphaTest();
            lightmap.func_205108_b();
        }
    }
    
    private void renderLockedStructure(final float partialTicks, final Minecraft mc, final LightTexture lightmap, final double xIn, final double yIn, final double zIn) {
        if (this.isNearLockedStructure(xIn, zIn)) {
            lightmap.func_205109_c();
            final int i = MathHelper.func_76128_c(xIn);
            final int j = MathHelper.func_76128_c(yIn);
            final int k = MathHelper.func_76128_c(zIn);
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder bufferbuilder = tessellator.func_178180_c();
            RenderSystem.disableCull();
            RenderSystem.normal3f(0.0f, 1.0f, 0.0f);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.defaultAlphaFunc();
            RenderSystem.enableDepthTest();
            int i2 = 5;
            if (Minecraft.func_71375_t()) {
                i2 = 10;
            }
            RenderSystem.depthMask(Minecraft.func_238218_y_());
            int j2 = -1;
            RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
            for (int k2 = k - i2; k2 <= k + i2; ++k2) {
                for (int l1 = i - i2; l1 <= i + i2; ++l1) {
                    final int i3 = (k2 - k + 16) * 32 + l1 - i + 16;
                    final double d3 = this.rainxs[i3] * 0.5;
                    final double d4 = this.rainzs[i3] * 0.5;
                    if (this.protectedBox != null && this.protectedBox.func_78885_a(l1, k2, l1, k2)) {
                        final int structureMin = this.protectedBox.field_78895_b - 4;
                        final int structureMax = this.protectedBox.field_78894_e + 4;
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
                            blockpos$mutableblockpos.func_181079_c(l1, k3, k2);
                            if (j2 != 0) {
                                if (j2 >= 0) {
                                    tessellator.func_78381_a();
                                }
                                j2 = 0;
                                mc.func_110434_K().func_110577_a(TFWeatherRenderer.SPARKLES_TEXTURE);
                                bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181704_d);
                            }
                            final float d5 = -((this.rendererUpdateCount + l1 * l1 * 3121 + l1 * 45238971 + k2 * k2 * 418711 + k2 * 13761 & 0x1F) + partialTicks) / 32.0f * (3.0f + random.nextFloat());
                            final double d6 = l1 + 0.5f - xIn;
                            final double d7 = k2 + 0.5f - zIn;
                            final float f3 = MathHelper.func_76133_a(d6 * d6 + d7 * d7) / i2;
                            final float f4 = random.nextFloat();
                            final float f5 = ((1.0f - f3 * f3) * 0.5f + 0.5f) * f4;
                            final int j3 = 15728880;
                            final int k4 = j3 >> 16 & 0xFFFF;
                            final int l3 = j3 & 0xFFFF;
                            bufferbuilder.func_225582_a_(l1 - xIn - d3 + 0.5, l2 - yIn, k2 - zIn - d4 + 0.5).func_225583_a_(0.0f, k3 * 0.25f + d5).func_227885_a_(1.0f, 1.0f, 1.0f, f5).func_225587_b_(k4, l3).func_181675_d();
                            bufferbuilder.func_225582_a_(l1 - xIn + d3 + 0.5, l2 - yIn, k2 - zIn + d4 + 0.5).func_225583_a_(1.0f, k3 * 0.25f + d5).func_227885_a_(1.0f, 1.0f, 1.0f, f5).func_225587_b_(k4, l3).func_181675_d();
                            bufferbuilder.func_225582_a_(l1 - xIn + d3 + 0.5, k3 - yIn, k2 - zIn + d4 + 0.5).func_225583_a_(1.0f, l2 * 0.25f + d5).func_227885_a_(1.0f, 1.0f, 1.0f, f5).func_225587_b_(k4, l3).func_181675_d();
                            bufferbuilder.func_225582_a_(l1 - xIn - d3 + 0.5, k3 - yIn, k2 - zIn - d4 + 0.5).func_225583_a_(0.0f, l2 * 0.25f + d5).func_227885_a_(1.0f, 1.0f, 1.0f, f5).func_225587_b_(k4, l3).func_181675_d();
                        }
                    }
                }
            }
            if (j2 >= 0) {
                tessellator.func_78381_a();
            }
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            RenderSystem.defaultAlphaFunc();
            RenderSystem.disableAlphaTest();
            lightmap.func_205108_b();
        }
    }
    
    private boolean isNearLockedBiome(final World world, final Entity viewEntity) {
        final BlockPos.Mutable pos = new BlockPos.Mutable();
        final int range = 15;
        final int px = MathHelper.func_76128_c(viewEntity.func_226277_ct_());
        for (int pz = MathHelper.func_76128_c(viewEntity.func_226281_cx_()), z = pz - 15; z <= pz + 15; ++z) {
            for (int x = px - 15; x <= px + 15; ++x) {
                final Biome biome = world.func_226691_t_((BlockPos)pos.func_181079_c(x, 0, z));
                if (!TFGenerationSettings.isBiomeSafeFor(biome, viewEntity)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isNearLockedStructure(final double xIn, final double zIn) {
        final int range = 15;
        final int px = MathHelper.func_76128_c(xIn);
        final int pz = MathHelper.func_76128_c(zIn);
        return this.protectedBox != null && this.protectedBox.func_78885_a(px - 15, pz - 15, px + 15, pz + 15);
    }
    
    public void setProtectedBox(final MutableBoundingBox protectedBox) {
        this.protectedBox = protectedBox;
    }
    
    private RenderType getRenderType(final Biome b) {
        if (Minecraft.func_71410_x().field_71441_e == null) {
            return null;
        }
        final ResourceLocation biome = Minecraft.func_71410_x().field_71441_e.func_241828_r().func_243612_b(Registry.field_239720_u_).func_177774_c((Object)b);
        if (BiomeKeys.SNOWY_FOREST.func_240901_a_().equals((Object)biome) || BiomeKeys.GLACIER.func_240901_a_().equals((Object)biome)) {
            return RenderType.BLIZZARD;
        }
        if (BiomeKeys.SWAMP.func_240901_a_().equals((Object)biome)) {
            return RenderType.MOSQUITO;
        }
        if (BiomeKeys.FIRE_SWAMP.func_240901_a_().equals((Object)biome)) {
            return RenderType.ASHES;
        }
        if (BiomeKeys.DARK_FOREST.func_240901_a_().equals((Object)biome) || BiomeKeys.DARK_FOREST_CENTER.func_240901_a_().equals((Object)biome)) {
            return (this.random.nextInt(2) == 0) ? RenderType.DARK_STREAM : null;
        }
        if (BiomeKeys.HIGHLANDS.func_240901_a_().equals((Object)biome) || BiomeKeys.THORNLANDS.func_240901_a_().equals((Object)biome) || BiomeKeys.FINAL_PLATEAU.func_240901_a_().equals((Object)biome)) {
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
