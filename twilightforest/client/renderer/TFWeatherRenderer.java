// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import twilightforest.biomes.TFBiomeFinalPlateau;
import twilightforest.biomes.TFBiomeThornlands;
import twilightforest.biomes.TFBiomeHighlands;
import twilightforest.biomes.TFBiomeDarkForest;
import twilightforest.biomes.TFBiomeFireSwamp;
import twilightforest.biomes.TFBiomeSwamp;
import twilightforest.biomes.TFBiomeGlacier;
import twilightforest.biomes.TFBiomeSnow;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;

public class TFWeatherRenderer extends IRenderHandler
{
    private static final ResourceLocation locationRainPng;
    private static final ResourceLocation locationSnowPng;
    private static final ResourceLocation locationBlizzardPng;
    private static final ResourceLocation locationMosquitoPng;
    private static final ResourceLocation locationAshesPng;
    private static final ResourceLocation locationDarkstreamPng;
    private static final ResourceLocation locationBigrainPng;
    private static final ResourceLocation locationSparklesPng;
    float[] rainXCoords;
    float[] rainYCoords;
    private int rendererUpdateCount;
    private Random random;
    private StructureBoundingBox protectedBox;
    
    public TFWeatherRenderer() {
        this.random = new Random();
    }
    
    public void render(final float partialTicks, final WorldClient world, final Minecraft mc) {
        ++this.rendererUpdateCount;
        this.renderNormalWeather(partialTicks, mc);
        if (world.func_82736_K().func_82766_b("tfEnforcedProgression") && !mc.field_71439_g.field_71075_bZ.field_75098_d) {
            this.renderLockedBiome(partialTicks, world, mc);
            this.renderLockedStructure(partialTicks, world, mc);
        }
    }
    
    private void renderNormalWeather(final float partialTicks, final Minecraft mc) {
        final float rainStrength = mc.field_71441_e.func_72867_j(partialTicks);
        if (rainStrength > 0.0f) {
            mc.field_71460_t.func_78463_b((double)partialTicks);
            this.initializeRainCoords();
            final EntityLivingBase entitylivingbase = mc.field_71451_h;
            final WorldClient worldclient = mc.field_71441_e;
            final int k2 = MathHelper.func_76128_c(entitylivingbase.field_70165_t);
            final int l2 = MathHelper.func_76128_c(entitylivingbase.field_70163_u);
            final int i3 = MathHelper.func_76128_c(entitylivingbase.field_70161_v);
            final Tessellator tessellator = Tessellator.field_78398_a;
            GL11.glDisable(2884);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glEnable(3042);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
            GL11.glAlphaFunc(516, 0.1f);
            final double d0 = entitylivingbase.field_70142_S + (entitylivingbase.field_70165_t - entitylivingbase.field_70142_S) * partialTicks;
            final double d2 = entitylivingbase.field_70137_T + (entitylivingbase.field_70163_u - entitylivingbase.field_70137_T) * partialTicks;
            final double d3 = entitylivingbase.field_70136_U + (entitylivingbase.field_70161_v - entitylivingbase.field_70136_U) * partialTicks;
            final int j = MathHelper.func_76128_c(d2);
            byte range = 5;
            if (mc.field_71474_y.field_74347_j) {
                range = 10;
            }
            byte b1 = -1;
            final float f5 = this.rendererUpdateCount + partialTicks;
            if (mc.field_71474_y.field_74347_j) {
                range = 10;
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            for (int m = i3 - range; m <= i3 + range; ++m) {
                for (int i4 = k2 - range; i4 <= k2 + range; ++i4) {
                    final int j2 = (m - i3 + 16) * 32 + i4 - k2 + 16;
                    final float f6 = this.rainXCoords[j2] * 0.5f;
                    final float f7 = this.rainYCoords[j2] * 0.5f;
                    final BiomeGenBase biomegenbase = worldclient.func_72807_a(i4, m);
                    if (biomegenbase.func_76738_d() || biomegenbase.func_76746_c()) {
                        final int k3 = worldclient.func_72874_g(i4, m);
                        int l3 = l2 - range;
                        int i5 = l2 + range;
                        if (l3 < k3) {
                            l3 = k3;
                        }
                        if (i5 < k3) {
                            i5 = k3;
                        }
                        final float f8 = 1.0f;
                        int j3;
                        if ((j3 = k3) < j) {
                            j3 = j;
                        }
                        if (l3 != i5) {
                            this.random.setSeed(i4 * i4 * 3121 + i4 * 45238971 ^ m * m * 418711 + m * 13761);
                            final float f9 = biomegenbase.func_150564_a(i4, l3, m);
                            if (worldclient.func_72959_q().func_76939_a(f9, k3) >= 0.15f) {
                                if (b1 != 0) {
                                    if (b1 >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    b1 = 0;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.locationRainPng);
                                    tessellator.func_78382_b();
                                }
                                final float downwardsMotion = ((this.rendererUpdateCount + i4 * i4 * 3121 + i4 * 45238971 + m * m * 418711 + m * 13761 & 0x1F) + partialTicks) / 32.0f * (3.0f + this.random.nextFloat());
                                final double d4 = i4 + 0.5f - entitylivingbase.field_70165_t;
                                final double xDist = m + 0.5f - entitylivingbase.field_70161_v;
                                final float f10 = MathHelper.func_76133_a(d4 * d4 + xDist * xDist) / range;
                                final float f11 = 1.0f;
                                tessellator.func_78380_c(worldclient.func_72802_i(i4, j3, m, 0));
                                tessellator.func_78369_a(f11, f11, f11, ((1.0f - f10 * f10) * 0.5f + 0.5f) * rainStrength);
                                tessellator.func_78373_b(-d0 * 1.0, -d2 * 1.0, -d3 * 1.0);
                                tessellator.func_78374_a(i4 - f6 + 0.5, (double)l3, m - f7 + 0.5, (double)(0.0f * f8), (double)(l3 * f8 / 4.0f + downwardsMotion * f8));
                                tessellator.func_78374_a(i4 + f6 + 0.5, (double)l3, m + f7 + 0.5, (double)(1.0f * f8), (double)(l3 * f8 / 4.0f + downwardsMotion * f8));
                                tessellator.func_78374_a(i4 + f6 + 0.5, (double)i5, m + f7 + 0.5, (double)(1.0f * f8), (double)(i5 * f8 / 4.0f + downwardsMotion * f8));
                                tessellator.func_78374_a(i4 - f6 + 0.5, (double)i5, m - f7 + 0.5, (double)(0.0f * f8), (double)(i5 * f8 / 4.0f + downwardsMotion * f8));
                                tessellator.func_78373_b(0.0, 0.0, 0.0);
                            }
                            else {
                                if (b1 != 1) {
                                    if (b1 >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    b1 = 1;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.locationSnowPng);
                                    tessellator.func_78382_b();
                                }
                                final float downwardsMotion = ((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                final float f12 = this.random.nextFloat() + f5 * 0.01f * (float)this.random.nextGaussian();
                                final float f13 = this.random.nextFloat() + f5 * (float)this.random.nextGaussian() * 0.001f;
                                final double xDist = i4 + 0.5f - entitylivingbase.field_70165_t;
                                final double zDist = m + 0.5f - entitylivingbase.field_70161_v;
                                final float f14 = MathHelper.func_76133_a(xDist * xDist + zDist * zDist) / range;
                                final float f15 = 1.0f;
                                tessellator.func_78380_c((worldclient.func_72802_i(i4, j3, m, 0) * 3 + 15728880) / 4);
                                tessellator.func_78369_a(f15, f15, f15, ((1.0f - f14 * f14) * 0.3f + 0.5f) * rainStrength);
                                tessellator.func_78373_b(-d0 * 1.0, -d2 * 1.0, -d3 * 1.0);
                                tessellator.func_78374_a(i4 - f6 + 0.5, (double)l3, m - f7 + 0.5, (double)(0.0f * f8 + f12), (double)(l3 * f8 / 4.0f + downwardsMotion * f8 + f13));
                                tessellator.func_78374_a(i4 + f6 + 0.5, (double)l3, m + f7 + 0.5, (double)(1.0f * f8 + f12), (double)(l3 * f8 / 4.0f + downwardsMotion * f8 + f13));
                                tessellator.func_78374_a(i4 + f6 + 0.5, (double)i5, m + f7 + 0.5, (double)(1.0f * f8 + f12), (double)(i5 * f8 / 4.0f + downwardsMotion * f8 + f13));
                                tessellator.func_78374_a(i4 - f6 + 0.5, (double)i5, m - f7 + 0.5, (double)(0.0f * f8 + f12), (double)(i5 * f8 / 4.0f + downwardsMotion * f8 + f13));
                                tessellator.func_78373_b(0.0, 0.0, 0.0);
                            }
                        }
                    }
                }
            }
            if (b1 >= 0) {
                tessellator.func_78381_a();
            }
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1f);
            mc.field_71460_t.func_78483_a((double)partialTicks);
        }
    }
    
    private void renderLockedBiome(final float partialTicks, final WorldClient world, final Minecraft mc) {
        if (this.isNearLockedBiome((World)world, mc.field_71451_h)) {
            this.initializeRainCoords();
            final EntityLivingBase entitylivingbase = mc.field_71451_h;
            final WorldClient worldclient = mc.field_71441_e;
            final int px = MathHelper.func_76128_c(entitylivingbase.field_70165_t);
            final int py = MathHelper.func_76128_c(entitylivingbase.field_70163_u);
            final int pz = MathHelper.func_76128_c(entitylivingbase.field_70161_v);
            final Tessellator tessellator = Tessellator.field_78398_a;
            GL11.glDisable(2884);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glEnable(3042);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
            GL11.glAlphaFunc(516, 0.1f);
            final double offX = entitylivingbase.field_70142_S + (entitylivingbase.field_70165_t - entitylivingbase.field_70142_S) * partialTicks;
            final double offY = entitylivingbase.field_70137_T + (entitylivingbase.field_70163_u - entitylivingbase.field_70137_T) * partialTicks;
            final double offZ = entitylivingbase.field_70136_U + (entitylivingbase.field_70161_v - entitylivingbase.field_70136_U) * partialTicks;
            final int floorY = MathHelper.func_76128_c(offY);
            byte range = 5;
            if (mc.field_71474_y.field_74347_j) {
                range = 10;
            }
            byte drawFlag = -1;
            final float preciseCount = this.rendererUpdateCount + partialTicks;
            if (mc.field_71474_y.field_74347_j) {
                range = 15;
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            for (int dz = pz - range; dz <= pz + range; ++dz) {
                for (int dx = px - range; dx <= px + range; ++dx) {
                    final int rainIndex = (dz - pz + 16) * 32 + dx - px + 16;
                    final float rainX = this.rainXCoords[rainIndex] * 0.5f;
                    final float rainZ = this.rainYCoords[rainIndex] * 0.5f;
                    final BiomeGenBase biomegenbase = worldclient.func_72807_a(dx, dz);
                    if (biomegenbase instanceof TFBiomeBase && entitylivingbase instanceof EntityPlayer && !((TFBiomeBase)biomegenbase).doesPlayerHaveRequiredAchievement((EntityPlayer)entitylivingbase)) {
                        final int rainHeight = 0;
                        int rainMin = py - range;
                        int rainMax = py + range * 2;
                        if (rainMin < rainHeight) {
                            rainMin = rainHeight;
                        }
                        if (rainMax < rainHeight) {
                            rainMax = rainHeight;
                        }
                        final float one = 1.0f;
                        int rainFloor;
                        if ((rainFloor = rainHeight) < floorY) {
                            rainFloor = floorY;
                        }
                        if (rainMin != rainMax) {
                            this.random.setSeed(dx * dx * 3121 + dx * 45238971 ^ dz * dz * 418711 + dz * 13761);
                            if (biomegenbase instanceof TFBiomeSnow || biomegenbase instanceof TFBiomeGlacier) {
                                if (drawFlag != 0) {
                                    if (drawFlag >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    drawFlag = 0;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.locationBlizzardPng);
                                    tessellator.func_78382_b();
                                }
                                final float countFactor = ((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                final float uFactor = this.random.nextFloat() + preciseCount * 0.03f * (float)this.random.nextGaussian();
                                final float vFactor = this.random.nextFloat() + preciseCount * 0.001f * (float)this.random.nextGaussian();
                                final double xRange = dx + 0.5f - entitylivingbase.field_70165_t;
                                final double zRange = dz + 0.5f - entitylivingbase.field_70161_v;
                                final float f14 = MathHelper.func_76133_a(xRange * xRange + zRange * zRange) / range;
                                final float onee = 1.0f;
                                tessellator.func_78380_c((worldclient.func_72802_i(dx, rainFloor, dz, 0) * 3 + 15728880) / 4);
                                tessellator.func_78369_a(onee, onee, onee, ((1.0f - f14 * f14) * 0.3f + 0.5f) * 1.0f);
                                tessellator.func_78373_b(-offX * 1.0, -offY * 1.0, -offZ * 1.0);
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMin, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMin, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMax, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMax, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78373_b(0.0, 0.0, 0.0);
                            }
                            else if (biomegenbase instanceof TFBiomeSwamp) {
                                if (drawFlag != 1) {
                                    if (drawFlag >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    drawFlag = 1;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.locationMosquitoPng);
                                    tessellator.func_78382_b();
                                }
                                final float countFactor = 0.0f;
                                final float uFactor = this.random.nextFloat() + preciseCount * 0.03f * (float)this.random.nextGaussian();
                                final float vFactor = this.random.nextFloat() + preciseCount * 0.003f * (float)this.random.nextGaussian();
                                tessellator.func_78380_c(983055);
                                final float r = this.random.nextFloat() * 0.3f;
                                final float g = this.random.nextFloat() * 0.3f;
                                final float b = this.random.nextFloat() * 0.3f;
                                tessellator.func_78369_a(r, g, b, 1.0f);
                                tessellator.func_78373_b(-offX * 1.0, -offY * 1.0, -offZ * 1.0);
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMin, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMin, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMax, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMax, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78373_b(0.0, 0.0, 0.0);
                            }
                            else if (biomegenbase instanceof TFBiomeFireSwamp) {
                                if (drawFlag != 2) {
                                    if (drawFlag >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    drawFlag = 2;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.locationAshesPng);
                                    tessellator.func_78382_b();
                                }
                                final float countFactor = -((this.rendererUpdateCount & 0x3FF) + partialTicks) / 1024.0f;
                                final float uFactor = this.random.nextFloat() + preciseCount * 0.001f * (float)this.random.nextGaussian();
                                final float vFactor = this.random.nextFloat() + preciseCount * 0.001f * (float)this.random.nextGaussian();
                                final double xRange = dx + 0.5f - entitylivingbase.field_70165_t;
                                final double zRange = dz + 0.5f - entitylivingbase.field_70161_v;
                                final float distanceFromPlayer = MathHelper.func_76133_a(xRange * xRange + zRange * zRange) / range;
                                tessellator.func_78380_c(983055);
                                final float bright = this.random.nextFloat() * 0.2f + 0.8f;
                                tessellator.func_78369_a(bright, bright, bright, ((1.0f - distanceFromPlayer * distanceFromPlayer) * 0.3f + 0.5f) * 1.0f);
                                tessellator.func_78373_b(-offX * 1.0, -offY * 1.0, -offZ * 1.0);
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMin, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMin, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMax, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMax, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78373_b(0.0, 0.0, 0.0);
                            }
                            else if (biomegenbase instanceof TFBiomeDarkForest && this.random.nextInt(2) == 0) {
                                if (drawFlag != 3) {
                                    if (drawFlag >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    drawFlag = 3;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.locationDarkstreamPng);
                                    tessellator.func_78382_b();
                                }
                                final int darkRainMax = Math.min(rainMax, worldclient.func_72874_g(dx, dz));
                                final int darkRainMin = Math.min(rainMin, darkRainMax);
                                final float countFactor2 = -((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                                final float uFactor2 = 0.0f;
                                final float vFactor2 = this.random.nextFloat() + preciseCount * 0.01f * (float)this.random.nextGaussian();
                                final double xRange2 = dx + 0.5f - entitylivingbase.field_70165_t;
                                final double zRange2 = dz + 0.5f - entitylivingbase.field_70161_v;
                                final float distanceFromPlayer2 = MathHelper.func_76133_a(xRange2 * xRange2 + zRange2 * zRange2) / range;
                                tessellator.func_78380_c(983055);
                                final float bright2 = 1.0f;
                                final float alpha = this.random.nextFloat();
                                tessellator.func_78369_a(bright2, bright2, bright2, ((1.0f - distanceFromPlayer2 * distanceFromPlayer2) * 0.3f + 0.5f) * alpha);
                                tessellator.func_78373_b(-offX * 1.0, -offY * 1.0, -offZ * 1.0);
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)darkRainMin, dz - rainZ + 0.5, (double)(0.0f * one + uFactor2), (double)(darkRainMin * one / 4.0f + countFactor2 * one + vFactor2));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)darkRainMin, dz + rainZ + 0.5, (double)(1.0f * one + uFactor2), (double)(darkRainMin * one / 4.0f + countFactor2 * one + vFactor2));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)darkRainMax, dz + rainZ + 0.5, (double)(1.0f * one + uFactor2), (double)(darkRainMax * one / 4.0f + countFactor2 * one + vFactor2));
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)darkRainMax, dz - rainZ + 0.5, (double)(0.0f * one + uFactor2), (double)(darkRainMax * one / 4.0f + countFactor2 * one + vFactor2));
                                tessellator.func_78373_b(0.0, 0.0, 0.0);
                            }
                            else if (biomegenbase instanceof TFBiomeHighlands || biomegenbase instanceof TFBiomeThornlands || biomegenbase instanceof TFBiomeFinalPlateau) {
                                if (drawFlag != 4) {
                                    if (drawFlag >= 0) {
                                        tessellator.func_78381_a();
                                    }
                                    drawFlag = 4;
                                    mc.func_110434_K().func_110577_a(TFWeatherRenderer.locationBigrainPng);
                                    tessellator.func_78382_b();
                                }
                                final float countFactor = ((this.rendererUpdateCount + dx * dx * 3121 + dx * 45238971 + dz * dz * 418711 + dz * 13761 & 0x1F) + partialTicks) / 32.0f * (3.0f + this.random.nextFloat());
                                final float uFactor = this.random.nextFloat();
                                final float vFactor = this.random.nextFloat();
                                final double xRange = dx + 0.5f - entitylivingbase.field_70165_t;
                                final double zRange = dz + 0.5f - entitylivingbase.field_70161_v;
                                final float distanceFromPlayer = MathHelper.func_76133_a(xRange * xRange + zRange * zRange) / range;
                                tessellator.func_78380_c(worldclient.func_72802_i(dx, rainFloor, dz, 0));
                                final float bright = 1.0f;
                                final float alpha2 = 1.0f;
                                tessellator.func_78369_a(bright, bright, bright, ((1.0f - distanceFromPlayer * distanceFromPlayer) * 0.3f + 0.5f) * alpha2);
                                tessellator.func_78373_b(-offX * 1.0, -offY * 1.0, -offZ * 1.0);
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMin, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMin, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMax, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMax, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                                tessellator.func_78373_b(0.0, 0.0, 0.0);
                            }
                        }
                    }
                }
            }
            if (drawFlag >= 0) {
                tessellator.func_78381_a();
            }
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1f);
            mc.field_71460_t.func_78483_a((double)partialTicks);
        }
    }
    
    private void renderLockedStructure(final float partialTicks, final WorldClient world, final Minecraft mc) {
        if (this.isNearLockedStructure((World)world, mc.field_71451_h)) {
            this.initializeRainCoords();
            final EntityLivingBase entitylivingbase = mc.field_71451_h;
            final int px = MathHelper.func_76128_c(entitylivingbase.field_70165_t);
            final int py = MathHelper.func_76128_c(entitylivingbase.field_70163_u);
            final int pz = MathHelper.func_76128_c(entitylivingbase.field_70161_v);
            final Tessellator tessellator = Tessellator.field_78398_a;
            GL11.glDisable(2884);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glEnable(3042);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
            GL11.glAlphaFunc(516, 0.1f);
            final double offX = entitylivingbase.field_70142_S + (entitylivingbase.field_70165_t - entitylivingbase.field_70142_S) * partialTicks;
            final double offY = entitylivingbase.field_70137_T + (entitylivingbase.field_70163_u - entitylivingbase.field_70137_T) * partialTicks;
            final double offZ = entitylivingbase.field_70136_U + (entitylivingbase.field_70161_v - entitylivingbase.field_70136_U) * partialTicks;
            byte range = 5;
            if (mc.field_71474_y.field_74347_j) {
                range = 10;
            }
            byte drawFlag = -1;
            final float preciseCount = this.rendererUpdateCount + partialTicks;
            if (mc.field_71474_y.field_74347_j) {
                range = 15;
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            for (int dz = pz - range; dz <= pz + range; ++dz) {
                for (int dx = px - range; dx <= px + range; ++dx) {
                    final int rainIndex = (dz - pz + 16) * 32 + dx - px + 16;
                    final float rainX = this.rainXCoords[rainIndex] * 0.5f;
                    final float rainZ = this.rainYCoords[rainIndex] * 0.5f;
                    if (this.protectedBox != null && this.protectedBox.func_78885_a(dx, dz, dx, dz)) {
                        final int structureMin = this.protectedBox.field_78895_b - 4;
                        final int structureMax = this.protectedBox.field_78894_e + 4;
                        int rainMin = py - range;
                        int rainMax = py + range * 2;
                        if (rainMin < structureMin) {
                            rainMin = structureMin;
                        }
                        if (rainMax < structureMin) {
                            rainMax = structureMin;
                        }
                        if (rainMin > structureMax) {
                            rainMin = structureMax;
                        }
                        if (rainMax > structureMax) {
                            rainMax = structureMax;
                        }
                        final float one = 1.0f;
                        if (rainMin != rainMax) {
                            this.random.setSeed(dx * dx * 3121 + dx * 45238971 ^ dz * dz * 418711 + dz * 13761);
                            if (drawFlag != 0) {
                                if (drawFlag >= 0) {
                                    tessellator.func_78381_a();
                                }
                                drawFlag = 0;
                                mc.func_110434_K().func_110577_a(TFWeatherRenderer.locationSparklesPng);
                                tessellator.func_78382_b();
                            }
                            final float countFactor = ((this.rendererUpdateCount & 0x1FF) + partialTicks) / 512.0f;
                            final float uFactor = this.random.nextFloat() + preciseCount * 0.01f * (float)this.random.nextGaussian();
                            final float vFactor = this.random.nextFloat() + preciseCount * 0.01f * (float)this.random.nextGaussian();
                            final double xRange = dx + 0.5f - entitylivingbase.field_70165_t;
                            final double zRange = dz + 0.5f - entitylivingbase.field_70161_v;
                            final float distanceFromPlayer = MathHelper.func_76133_a(xRange * xRange + zRange * zRange) / range;
                            tessellator.func_78380_c(983055);
                            final float bright = 1.0f;
                            final float alpha = this.random.nextFloat();
                            tessellator.func_78369_a(bright, bright, bright, ((1.0f - distanceFromPlayer * distanceFromPlayer) * 0.3f + 0.5f) * alpha);
                            tessellator.func_78373_b(-offX * 1.0, -offY * 1.0, -offZ * 1.0);
                            tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMin, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                            tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMin, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMin * one / 4.0f + countFactor * one + vFactor));
                            tessellator.func_78374_a(dx + rainX + 0.5, (double)rainMax, dz + rainZ + 0.5, (double)(1.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                            tessellator.func_78374_a(dx - rainX + 0.5, (double)rainMax, dz - rainZ + 0.5, (double)(0.0f * one + uFactor), (double)(rainMax * one / 4.0f + countFactor * one + vFactor));
                            tessellator.func_78373_b(0.0, 0.0, 0.0);
                        }
                    }
                }
            }
            if (drawFlag >= 0) {
                tessellator.func_78381_a();
            }
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1f);
            mc.field_71460_t.func_78483_a((double)partialTicks);
        }
    }
    
    private void initializeRainCoords() {
        if (this.rainXCoords == null) {
            this.rainXCoords = new float[1024];
            this.rainYCoords = new float[1024];
            for (int i = 0; i < 32; ++i) {
                for (int j = 0; j < 32; ++j) {
                    final float f2 = (float)(j - 16);
                    final float f3 = (float)(i - 16);
                    final float f4 = MathHelper.func_76129_c(f2 * f2 + f3 * f3);
                    this.rainXCoords[i << 5 | j] = -f3 / f4;
                    this.rainYCoords[i << 5 | j] = f2 / f4;
                }
            }
        }
    }
    
    private boolean isNearLockedBiome(final World world, final EntityLivingBase viewEntity) {
        final int range = 15;
        final int px = MathHelper.func_76128_c(viewEntity.field_70165_t);
        for (int pz = MathHelper.func_76128_c(viewEntity.field_70161_v), z = pz - range; z <= pz + range; ++z) {
            for (int x = px - range; x <= px + range; ++x) {
                final BiomeGenBase biomegenbase = world.func_72807_a(x, z);
                if (biomegenbase instanceof TFBiomeBase && viewEntity instanceof EntityPlayer) {
                    final TFBiomeBase tfBiome = (TFBiomeBase)biomegenbase;
                    final EntityPlayer player = (EntityPlayer)viewEntity;
                    if (!tfBiome.doesPlayerHaveRequiredAchievement(player)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isNearLockedStructure(final World world, final EntityLivingBase viewEntity) {
        final int range = 15;
        final int px = MathHelper.func_76128_c(viewEntity.field_70165_t);
        final int pz = MathHelper.func_76128_c(viewEntity.field_70161_v);
        return this.protectedBox != null && this.protectedBox.func_78885_a(px - range, pz - range, px + range, pz + range);
    }
    
    public StructureBoundingBox getProtectedBox() {
        return this.protectedBox;
    }
    
    public void setProtectedBox(final StructureBoundingBox protectedBox) {
        this.protectedBox = protectedBox;
    }
    
    static {
        locationRainPng = new ResourceLocation("textures/environment/rain.png");
        locationSnowPng = new ResourceLocation("textures/environment/snow.png");
        locationBlizzardPng = new ResourceLocation("twilightforest:textures/environment/blizzard.png");
        locationMosquitoPng = new ResourceLocation("twilightforest:textures/environment/mosquitoes.png");
        locationAshesPng = new ResourceLocation("twilightforest:textures/environment/ashes.png");
        locationDarkstreamPng = new ResourceLocation("twilightforest:textures/environment/darkstream.png");
        locationBigrainPng = new ResourceLocation("twilightforest:textures/environment/bigrain.png");
        locationSparklesPng = new ResourceLocation("twilightforest:textures/environment/sparkles.png");
    }
}
