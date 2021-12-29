// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import twilightforest.biomes.TFBiomeBase;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EnumCreatureType;
import twilightforest.biomes.TFBiomeDecorator;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.util.IntPair;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.Chunk;
import java.util.Iterator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.util.math.MathHelper;
import java.util.EnumMap;
import twilightforest.TFFeature;
import java.util.Map;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.WorldType;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import java.util.Random;
import net.minecraft.world.gen.IChunkGenerator;

public abstract class ChunkGeneratorTFBase implements IChunkGenerator
{
    protected final Random rand;
    private final NoiseGeneratorOctaves minLimitPerlinNoise;
    private final NoiseGeneratorOctaves maxLimitPerlinNoise;
    private final NoiseGeneratorOctaves mainPerlinNoise;
    private final NoiseGeneratorPerlin surfaceNoise;
    private final NoiseGeneratorOctaves depthNoise;
    protected final World world;
    protected final WorldType terrainType;
    private double[] mainNoiseRegion;
    private double[] minLimitRegion;
    private double[] maxLimitRegion;
    private double[] depthRegion;
    protected double[] depthBuffer;
    protected Biome[] biomesForGeneration;
    private final double[] heightMap;
    private final float[] biomeWeights;
    protected final MapGenTFHollowTree hollowTreeGenerator;
    protected final Map<TFFeature, MapGenTFMajorFeature> featureGenerators;
    protected final MapGenTFMajorFeature nothingGenerator;
    private final boolean shouldGenerateBedrock;
    
    protected static long getSeed(final int x, final int z) {
        return x * 341873128712L + z * 132897987541L;
    }
    
    protected static int getIndex(final int x, final int y, final int z) {
        return x << 12 | z << 8 | y;
    }
    
    public ChunkGeneratorTFBase(final World world, final long seed, final boolean enableFeatures, final boolean shouldGenerateBedrock) {
        this.depthBuffer = new double[256];
        this.hollowTreeGenerator = new MapGenTFHollowTree();
        this.featureGenerators = new EnumMap<TFFeature, MapGenTFMajorFeature>(TFFeature.class);
        this.nothingGenerator = new MapGenTFMajorFeature();
        this.world = world;
        this.terrainType = world.func_72912_H().func_76067_t();
        this.rand = new Random(seed);
        this.shouldGenerateBedrock = shouldGenerateBedrock;
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.surfaceNoise = new NoiseGeneratorPerlin(this.rand, 4);
        this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.heightMap = new double[825];
        this.biomeWeights = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                final float f = 10.0f / MathHelper.func_76129_c(j * j + k * k + 0.2f);
                this.biomeWeights[j + 2 + (k + 2) * 5] = f;
            }
        }
        for (final TFFeature feature : TFFeature.values()) {
            final MapGenTFMajorFeature generator = feature.createFeatureGenerator();
            if (generator != null) {
                this.featureGenerators.put(feature, generator);
            }
        }
    }
    
    protected final void generateFeatures(final int x, final int z, final ChunkPrimer primer) {
        for (final MapGenTFMajorFeature generator : this.featureGenerators.values()) {
            generator.func_186125_a(this.world, x, z, primer);
        }
    }
    
    protected final Chunk makeChunk(final int x, final int z, final ChunkPrimer primer) {
        final Chunk chunk = new Chunk(this.world, x, z);
        this.fillChunk(chunk, primer);
        final byte[] chunkBiomes = chunk.func_76605_m();
        for (int i = 0; i < chunkBiomes.length; ++i) {
            chunkBiomes[i] = (byte)Biome.func_185362_a(this.biomesForGeneration[i]);
        }
        chunk.func_76603_b();
        return chunk;
    }
    
    private void fillChunk(final Chunk chunk, final ChunkPrimer primer) {
        final int i = 256;
        final boolean flag = this.world.field_73011_w.func_191066_m();
        final ExtendedBlockStorage[] storageArrays = chunk.func_76587_i();
        for (int j = 0; j < 16; ++j) {
            for (int k = 0; k < 16; ++k) {
                for (int l = 0; l < 256; ++l) {
                    final IBlockState iblockstate = primer.func_177856_a(j, l, k);
                    if (iblockstate.func_177230_c() != Blocks.field_150350_a) {
                        final int i2 = l >> 4;
                        if (storageArrays[i2] == Chunk.field_186036_a) {
                            storageArrays[i2] = new ExtendedBlockStorage(i2 << 4, flag);
                        }
                        storageArrays[i2].func_177484_a(j, l & 0xF, k, iblockstate);
                    }
                }
            }
        }
    }
    
    protected final void setBlocksInChunk(final int x, final int z, final ChunkBitArray data) {
        final byte seaLevel = 63;
        this.biomesForGeneration = this.world.func_72959_q().func_76937_a(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
        this.generateHeightmap(x * 4, 0, z * 4);
        for (int k = 0; k < 4; ++k) {
            final int l = k * 5;
            final int i1 = (k + 1) * 5;
            for (int j1 = 0; j1 < 4; ++j1) {
                final int k2 = (l + j1) * 33;
                final int l2 = (l + j1 + 1) * 33;
                final int i2 = (i1 + j1) * 33;
                final int j2 = (i1 + j1 + 1) * 33;
                for (int k3 = 0; k3 < 32; ++k3) {
                    final double d0 = 0.125;
                    double d2 = this.heightMap[k2 + k3];
                    double d3 = this.heightMap[l2 + k3];
                    double d4 = this.heightMap[i2 + k3];
                    double d5 = this.heightMap[j2 + k3];
                    final double d6 = (this.heightMap[k2 + k3 + 1] - d2) * d0;
                    final double d7 = (this.heightMap[l2 + k3 + 1] - d3) * d0;
                    final double d8 = (this.heightMap[i2 + k3 + 1] - d4) * d0;
                    final double d9 = (this.heightMap[j2 + k3 + 1] - d5) * d0;
                    for (int l3 = 0; l3 < 8; ++l3) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            final double d15 = 0.25;
                            final double d16 = (d12 - d11) * d15;
                            double d17 = d11 - d16;
                            for (int k4 = 0; k4 < 4; ++k4) {
                                if ((d17 += d16) > 0.0) {
                                    data.set(getIndex(k * 4 + i3, k3 * 8 + l3, j1 * 4 + k4));
                                }
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }
    
    private void generateHeightmap(final int x, final int zero, final int z) {
        this.depthRegion = this.depthNoise.func_76305_a(this.depthRegion, x, z, 5, 5, 200.0, 200.0, 0.5);
        this.mainNoiseRegion = this.mainPerlinNoise.func_76304_a(this.mainNoiseRegion, x, zero, z, 5, 33, 5, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.minLimitRegion = this.minLimitPerlinNoise.func_76304_a(this.minLimitRegion, x, zero, z, 5, 33, 5, 684.412, 684.412, 684.412);
        this.maxLimitRegion = this.maxLimitPerlinNoise.func_76304_a(this.maxLimitRegion, x, zero, z, 5, 33, 5, 684.412, 684.412, 684.412);
        int terrainIndex = 0;
        int noiseIndex = 0;
        for (int ax = 0; ax < 5; ++ax) {
            for (int az = 0; az < 5; ++az) {
                float totalVariation = 0.0f;
                float totalHeight = 0.0f;
                float totalFactor = 0.0f;
                final byte two = 2;
                final Biome biome = this.biomesForGeneration[ax + 2 + (az + 2) * 10];
                for (int ox = -two; ox <= two; ++ox) {
                    for (int oz = -two; oz <= two; ++oz) {
                        final Biome biome2 = this.biomesForGeneration[ax + ox + 2 + (az + oz + 2) * 10];
                        float rootHeight = biome2.func_185355_j();
                        float heightVariation = biome2.func_185360_m();
                        if (this.terrainType == WorldType.field_151360_e && rootHeight > 0.0f) {
                            rootHeight = 1.0f + rootHeight * 2.0f;
                            heightVariation = 1.0f + heightVariation * 4.0f;
                        }
                        float heightFactor = this.biomeWeights[ox + 2 + (oz + 2) * 5] / (rootHeight + 2.0f);
                        if (biome2.func_185355_j() > biome.func_185355_j()) {
                            heightFactor /= 2.0f;
                        }
                        totalVariation += heightVariation * heightFactor;
                        totalHeight += rootHeight * heightFactor;
                        totalFactor += heightFactor;
                    }
                }
                totalVariation /= totalFactor;
                totalHeight /= totalFactor;
                totalVariation = totalVariation * 0.9f + 0.1f;
                totalHeight = (totalHeight * 4.0f - 1.0f) / 8.0f;
                double terrainNoise = this.depthRegion[noiseIndex] / 8000.0;
                if (terrainNoise < 0.0) {
                    terrainNoise = -terrainNoise * 0.3;
                }
                terrainNoise = terrainNoise * 3.0 - 2.0;
                if (terrainNoise < 0.0) {
                    terrainNoise /= 2.0;
                    if (terrainNoise < -1.0) {
                        terrainNoise = -1.0;
                    }
                    terrainNoise /= 1.4;
                    terrainNoise /= 2.0;
                }
                else {
                    if (terrainNoise > 1.0) {
                        terrainNoise = 1.0;
                    }
                    terrainNoise /= 8.0;
                }
                ++noiseIndex;
                double heightCalc = totalHeight;
                final double variationCalc = totalVariation;
                heightCalc += terrainNoise * 0.2;
                heightCalc = heightCalc * 8.5 / 8.0;
                final double d5 = 8.5 + heightCalc * 4.0;
                for (int ay = 0; ay < 33; ++ay) {
                    double d6 = (ay - d5) * 12.0 * 128.0 / 256.0 / variationCalc;
                    if (d6 < 0.0) {
                        d6 *= 4.0;
                    }
                    final double d7 = this.minLimitRegion[terrainIndex] / 512.0;
                    final double d8 = this.maxLimitRegion[terrainIndex] / 512.0;
                    final double d9 = (this.mainNoiseRegion[terrainIndex] / 10.0 + 1.0) / 2.0;
                    double terrainCalc = MathHelper.func_151238_b(d7, d8, d9) - d6;
                    if (ay > 29) {
                        final double d10 = (ay - 29) / 3.0f;
                        terrainCalc = terrainCalc * (1.0 - d10) + -10.0 * d10;
                    }
                    this.heightMap[terrainIndex] = terrainCalc;
                    ++terrainIndex;
                }
            }
        }
    }
    
    protected final void squishTerrain(final ChunkBitArray data) {
        final int squishHeight = 128;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < squishHeight; ++y) {
                    data.set(getIndex(x, y, z), data.get(getIndex(x, y * 2 + 1, z)));
                }
                for (int y = squishHeight; y < 256; ++y) {
                    data.clear(getIndex(x, y, z));
                }
            }
        }
    }
    
    protected abstract void initPrimer(final ChunkPrimer p0, final ChunkBitArray p1);
    
    public void replaceBiomeBlocks(final int x, final int z, final ChunkPrimer primer, final Biome[] biomesIn) {
        if (!ForgeEventFactory.onReplaceBiomeBlocks((IChunkGenerator)this, x, z, primer, this.world)) {
            return;
        }
        final double d0 = 0.03125;
        this.depthBuffer = this.surfaceNoise.func_151599_a(this.depthBuffer, (double)(x * 16), (double)(z * 16), 16, 16, 0.0625, 0.0625, 1.0);
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                final Biome biome = biomesIn[j + i * 16];
                biome.func_180622_a(this.world, this.rand, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16]);
            }
        }
    }
    
    protected final void deformTerrainForFeature(final int cx, final int cz, final ChunkPrimer primer) {
        final IntPair nearCenter = new IntPair();
        final TFFeature nearFeature = TFFeature.getNearestFeature(cx, cz, this.world, nearCenter);
        if (!nearFeature.isTerrainAltered) {
            return;
        }
        final int hx = nearCenter.x;
        final int hz = nearCenter.z;
        if (nearFeature == TFFeature.TROLL_CAVE) {
            this.deformTerrainForTrollCloud2(primer, nearFeature, cx, cz, hx, hz);
        }
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final int dx = x - hx;
                final int dz = z - hz;
                if (nearFeature == TFFeature.SMALL_HILL || nearFeature == TFFeature.MEDIUM_HILL || nearFeature == TFFeature.LARGE_HILL || nearFeature == TFFeature.HYDRA_LAIR) {
                    final int hdiam = (nearFeature.size * 2 + 1) * 16;
                    final int dist = (int)Math.sqrt(dx * dx + dz * dz);
                    final int hheight = (int)(Math.cos(dist / (float)hdiam * 3.141592653589793) * (hdiam / 3.0f));
                    this.raiseHills(primer, nearFeature, hdiam, x, z, dx, dz, hheight);
                }
                else if (nearFeature == TFFeature.HEDGE_MAZE || nearFeature == TFFeature.NAGA_COURTYARD || nearFeature == TFFeature.QUEST_GROVE) {
                    this.flattenTerrainForFeature(primer, nearFeature, x, z, dx, dz);
                }
                else if (nearFeature == TFFeature.YETI_CAVE) {
                    this.deformTerrainForYetiLair(primer, nearFeature, x, z, dx, dz);
                }
                else if (nearFeature == TFFeature.TROLL_CAVE) {
                    this.deformTerrainForTrollCaves(primer, nearFeature, x, z, dx, dz);
                }
            }
        }
    }
    
    private void raiseHills(final ChunkPrimer primer, final TFFeature nearFeature, final int hdiam, final int x, final int z, final int dx, final int dz, final int hillHeight) {
        int oldGround = -1;
        int newGround = -1;
        boolean foundGroundLevel = false;
        for (int y = 31; y < 256; ++y) {
            final Block currentTerrain = primer.func_177856_a(x, y, z).func_177230_c();
            if (currentTerrain != Blocks.field_150348_b) {
                oldGround = y;
                newGround = y + hillHeight;
                foundGroundLevel = true;
                break;
            }
        }
        if (foundGroundLevel) {
            for (int y = oldGround; y <= newGround; ++y) {
                primer.func_177855_a(x, y, z, Blocks.field_150348_b.func_176223_P());
            }
        }
        int hollow = hillHeight - 4 - nearFeature.size;
        if (nearFeature == TFFeature.HYDRA_LAIR) {
            final int mx = dx + 16;
            final int mz = dz + 16;
            final int mdist = (int)Math.sqrt(mx * mx + mz * mz);
            final int mheight = (int)(Math.cos(mdist / (hdiam / 1.5) * 3.141592653589793) * (hdiam / 1.5));
            hollow = Math.max(mheight - 4, hollow);
        }
        if (hollow < 0) {
            hollow = 0;
        }
        int hollowFloor = 28 - hollow / 8;
        if (nearFeature == TFFeature.HYDRA_LAIR) {
            hollowFloor = 31;
        }
        if (hillHeight > 0) {
            for (int y2 = 0; y2 < 31; ++y2) {
                if (primer.func_177856_a(x, y2, z).func_177230_c() != Blocks.field_150348_b) {
                    primer.func_177855_a(x, y2, z, Blocks.field_150348_b.func_176223_P());
                }
            }
        }
        for (int y2 = hollowFloor + 1; y2 < hollowFloor + hollow; ++y2) {
            primer.func_177855_a(x, y2, z, Blocks.field_150350_a.func_176223_P());
        }
    }
    
    private void flattenTerrainForFeature(final ChunkPrimer primer, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
        float squishFactor = 0.0f;
        int mazeHeight = 32;
        final int FEATURE_BOUNDARY = (nearFeature.size * 2 + 1) * 8 - 8;
        if (dx <= -FEATURE_BOUNDARY) {
            squishFactor = (-dx - FEATURE_BOUNDARY) / 8.0f;
        }
        else if (dx >= FEATURE_BOUNDARY) {
            squishFactor = (dx - FEATURE_BOUNDARY) / 8.0f;
        }
        if (dz <= -FEATURE_BOUNDARY) {
            squishFactor = Math.max(squishFactor, (-dz - FEATURE_BOUNDARY) / 8.0f);
        }
        else if (dz >= FEATURE_BOUNDARY) {
            squishFactor = Math.max(squishFactor, (dz - FEATURE_BOUNDARY) / 8.0f);
        }
        if (squishFactor > 0.0f) {
            for (int y = 0; y <= 127; ++y) {
                final Block currentTerrain = primer.func_177856_a(x, y, z).func_177230_c();
                if (currentTerrain != Blocks.field_150348_b) {
                    mazeHeight += (int)((y - mazeHeight) * squishFactor);
                    break;
                }
            }
        }
        for (int y = 0; y < mazeHeight; ++y) {
            final Block b = primer.func_177856_a(x, y, z).func_177230_c();
            if (b == Blocks.field_150350_a || b == Blocks.field_150355_j) {
                primer.func_177855_a(x, y, z, Blocks.field_150348_b.func_176223_P());
            }
        }
        for (int y = mazeHeight; y <= 127; ++y) {
            final Block b = primer.func_177856_a(x, y, z).func_177230_c();
            if (b != Blocks.field_150350_a && b != Blocks.field_150355_j) {
                primer.func_177855_a(x, y, z, Blocks.field_150350_a.func_176223_P());
            }
        }
    }
    
    private void deformTerrainForYetiLair(final ChunkPrimer primer, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
        float squishFactor = 0.0f;
        int topHeight = 55;
        final int outerBoundary = (nearFeature.size * 2 + 1) * 8 - 8;
        if (dx <= -outerBoundary) {
            squishFactor = (-dx - outerBoundary) / 8.0f;
        }
        else if (dx >= outerBoundary) {
            squishFactor = (dx - outerBoundary) / 8.0f;
        }
        if (dz <= -outerBoundary) {
            squishFactor = Math.max(squishFactor, (-dz - outerBoundary) / 8.0f);
        }
        else if (dz >= outerBoundary) {
            squishFactor = Math.max(squishFactor, (dz - outerBoundary) / 8.0f);
        }
        final int caveBoundary = nearFeature.size * 2 * 8 - 8;
        int hollowCeiling = 47;
        final int offset = Math.min(Math.abs(dx), Math.abs(dz));
        hollowCeiling = 71 - offset * 4;
        if (dx >= -caveBoundary && dz >= -caveBoundary && dx <= caveBoundary && dz <= caveBoundary) {
            hollowCeiling = 47;
        }
        hollowCeiling -= offset / 6;
        hollowCeiling = Math.min(hollowCeiling, 47);
        int hollowFloor = 30 + offset / 6;
        if (squishFactor > 0.0f) {
            for (int y = 0; y <= 127; ++y) {
                final Block currentTerrain = primer.func_177856_a(x, y, z).func_177230_c();
                if (currentTerrain != Blocks.field_150348_b) {
                    topHeight += (int)((y - topHeight) * squishFactor);
                    hollowFloor += (int)((y - hollowFloor) * squishFactor);
                    break;
                }
            }
        }
        for (int y = 0; y < topHeight; ++y) {
            final Block b = primer.func_177856_a(x, y, z).func_177230_c();
            if (b == Blocks.field_150350_a || b == Blocks.field_150355_j) {
                primer.func_177855_a(x, y, z, Blocks.field_150348_b.func_176223_P());
            }
        }
        for (int y = hollowFloor + 1; y < hollowCeiling; ++y) {
            primer.func_177855_a(x, y, z, Blocks.field_150350_a.func_176223_P());
        }
        if (hollowFloor < hollowCeiling && hollowFloor < 34) {
            primer.func_177855_a(x, hollowFloor, z, Blocks.field_150403_cj.func_176223_P());
        }
    }
    
    protected void deformTerrainForTrollCaves(final ChunkPrimer primer, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
    }
    
    private void deformTerrainForTrollCloud2(final ChunkPrimer primer, final TFFeature nearFeature, final int cx, final int cz, final int hx, final int hz) {
        for (int bx = 0; bx < 4; ++bx) {
            for (int bz = 0; bz < 4; ++bz) {
                final int dx = bx * 4 - hx - 2;
                final int dz = bz * 4 - hz - 2;
                final int regionX = cx + 8 >> 4;
                final int regionZ = cz + 8 >> 4;
                long seed = (long)(regionX * 3129871) ^ regionZ * 116129781L;
                seed = seed * seed * 42317861L + seed * 7L;
                final int num0 = (int)(seed >> 12 & 0x3L);
                final int num2 = (int)(seed >> 15 & 0x3L);
                final int num3 = (int)(seed >> 18 & 0x3L);
                final int num4 = (int)(seed >> 21 & 0x3L);
                final int num5 = (int)(seed >> 9 & 0x3L);
                final int num6 = (int)(seed >> 6 & 0x3L);
                final int num7 = (int)(seed >> 3 & 0x3L);
                final int num8 = (int)(seed >> 0 & 0x3L);
                final int dx2 = dx + num0 * 5 - num2 * 4;
                final int dz2 = dz + num3 * 4 - num4 * 5;
                final int dx3 = dx + num5 * 5 - num6 * 4;
                final int dz3 = dz + num7 * 4 - num8 * 5;
                final double dist0 = Math.sqrt(dx * dx + dz * dz) / 4.0;
                final double dist2 = Math.sqrt(dx2 * dx2 + dz2 * dz2) / 3.5;
                final double dist3 = Math.sqrt(dx3 * dx3 + dz3 * dz3) / 4.5;
                final double dist4 = Math.min(dist0, Math.min(dist2, dist3));
                final float pr = this.world.field_73012_v.nextFloat();
                final double cv = dist4 - 7.0 - pr * 3.0f;
                int y = 166;
                int depth = 4;
                if (pr < 0.1f) {
                    ++y;
                }
                if (pr > 0.6f) {
                    ++depth;
                }
                if (pr > 0.9f) {
                    ++depth;
                }
                for (int sx = 0; sx < 4; ++sx) {
                    for (int sz = 0; sz < 4; ++sz) {
                        final int lx = bx * 4 + sx;
                        final int lz = bz * 4 + sz;
                        if (dist4 < 7.0 || cv < 0.05000000074505806) {
                            primer.func_177855_a(lx, y, lz, TFBlocks.wispy_cloud.func_176223_P());
                            for (int d = 1; d < depth; ++d) {
                                primer.func_177855_a(lx, y - d, lz, TFBlocks.fluffy_cloud.func_176223_P());
                            }
                            primer.func_177855_a(lx, y - depth, lz, TFBlocks.wispy_cloud.func_176223_P());
                        }
                        else if (dist4 < 8.0 || cv < 1.0) {
                            for (int d = 1; d < depth; ++d) {
                                primer.func_177855_a(lx, y - d, lz, TFBlocks.fluffy_cloud.func_176223_P());
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected final boolean allowSurfaceLakes(final Biome biome) {
        return !(biome.field_76760_I instanceof TFBiomeDecorator) || !((TFBiomeDecorator)biome.field_76760_I).hasCanopy;
    }
    
    public final boolean shouldGenerateBedrock() {
        return this.shouldGenerateBedrock;
    }
    
    public boolean func_185933_a(final Chunk chunk, final int x, final int z) {
        return false;
    }
    
    public List<Biome.SpawnListEntry> func_177458_a(final EnumCreatureType creatureType, final BlockPos pos) {
        final TFFeature nearestFeature = TFFeature.getFeatureForRegionPos(pos.func_177958_n(), pos.func_177952_p(), this.world);
        final List<Biome.SpawnListEntry> featureList = this.getFeatureGenerator(nearestFeature).getPossibleCreatures(creatureType, pos);
        if (featureList != null) {
            return featureList;
        }
        final Biome biome = this.world.func_180494_b(pos);
        if (pos.func_177956_o() < 31 && biome instanceof TFBiomeBase) {
            return ((TFBiomeBase)biome).getUndergroundSpawnableList(creatureType);
        }
        return biome.func_76747_a(creatureType);
    }
    
    @Nullable
    public BlockPos func_180513_a(final World world, final String structureName, final BlockPos position, final boolean findUnexplored) {
        if (structureName.equalsIgnoreCase(this.hollowTreeGenerator.func_143025_a())) {
            return this.hollowTreeGenerator.func_180706_b(world, position, findUnexplored);
        }
        final TFFeature feature = TFFeature.getFeatureByName(new ResourceLocation(structureName));
        if (feature != TFFeature.NOTHING) {
            return TFFeature.findNearestFeaturePosBySpacing(world, feature, position, 20, 11, 10387313, true, 100, findUnexplored);
        }
        return null;
    }
    
    protected final MapGenTFMajorFeature getFeatureGenerator(final TFFeature feature) {
        return this.featureGenerators.getOrDefault(feature, this.nothingGenerator);
    }
    
    public void setStructureConquered(final BlockPos pos, final boolean flag) {
        this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(pos.func_177958_n(), pos.func_177952_p(), this.world)).setStructureConquered(pos, flag);
    }
    
    public boolean isStructureLocked(final BlockPos pos, final int lockIndex) {
        return this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(pos.func_177958_n(), pos.func_177952_p(), this.world)).isStructureLocked(pos, lockIndex);
    }
    
    public boolean isBlockInStructureBB(final BlockPos pos) {
        return this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(pos.func_177958_n(), pos.func_177952_p(), this.world)).func_175795_b(pos);
    }
    
    @Nullable
    public StructureBoundingBox getSBBAt(final BlockPos pos) {
        return this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(pos.func_177958_n(), pos.func_177952_p(), this.world)).getSBBAt(pos);
    }
    
    public boolean isBlockProtected(final BlockPos pos) {
        return this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(pos.func_177958_n(), pos.func_177952_p(), this.world)).isBlockProtectedAt(pos);
    }
    
    public boolean isStructureConquered(final BlockPos pos) {
        return this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(pos.func_177958_n(), pos.func_177952_p(), this.world)).isStructureConquered(pos);
    }
    
    public boolean isBlockInFullStructure(final int x, final int z) {
        return this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(x, z, this.world)).isBlockInFullStructure(x, z);
    }
    
    public boolean isBlockNearFullStructure(final int x, final int z, final int range) {
        return this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(x, z, this.world)).isBlockNearFullStructure(x, z, range);
    }
    
    @Nullable
    public StructureBoundingBox getFullSBBNear(final int mapX, final int mapZ, final int range) {
        return this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(mapX, mapZ, this.world)).getFullSBBNear(mapX, mapZ, range);
    }
    
    public TFFeature getFeatureAt(final BlockPos pos) {
        return this.getFeatureGenerator(TFFeature.getFeatureForRegionPos(pos.func_177958_n(), pos.func_177952_p(), this.world)).getFeatureAt(pos);
    }
    
    public void func_180514_a(final Chunk chunk, final int x, final int z) {
        for (final MapGenTFMajorFeature generator : this.featureGenerators.values()) {
            generator.func_186125_a(this.world, x, z, (ChunkPrimer)null);
        }
    }
    
    public boolean func_193414_a(final World world, final String structureName, final BlockPos pos) {
        if (structureName.equalsIgnoreCase(this.hollowTreeGenerator.func_143025_a())) {
            return this.hollowTreeGenerator.func_175795_b(pos);
        }
        final TFFeature feature = TFFeature.getFeatureByName(new ResourceLocation(structureName));
        return feature != TFFeature.NOTHING && this.getFeatureGenerator(feature).func_175795_b(pos);
    }
}
