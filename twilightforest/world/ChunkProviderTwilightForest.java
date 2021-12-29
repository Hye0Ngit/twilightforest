// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.block.BlockFalling;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.block.TFBlocks;
import twilightforest.TFFeature;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import java.util.Random;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderTwilightForest implements IChunkProvider
{
    private Random rand;
    private NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private double[] stoneNoise;
    private TFGenCaves caveGenerator;
    private TFGenRavine ravineGenerator;
    private BiomeGenBase[] biomesForGeneration;
    double[] noise3;
    double[] noise1;
    double[] noise2;
    double[] noise5;
    double[] noise6;
    float[] squareTable;
    int[][] unusedIntArray32x32;
    private WorldType field_147435_p;
    private NoiseGeneratorOctaves field_147431_j;
    private NoiseGeneratorOctaves field_147432_k;
    private NoiseGeneratorOctaves field_147429_l;
    private NoiseGeneratorPerlin field_147430_m;
    private final double[] terrainCalcs;
    private final float[] parabolicField;
    double[] field_147427_d;
    double[] field_147428_e;
    double[] field_147425_f;
    double[] field_147426_g;
    int[][] field_73219_j;
    private MapGenTFMajorFeature majorFeatureGenerator;
    
    public ChunkProviderTwilightForest(final World world, final long l, final boolean flag) {
        this.field_73219_j = new int[32][32];
        this.stoneNoise = new double[256];
        this.caveGenerator = new TFGenCaves();
        this.majorFeatureGenerator = new MapGenTFMajorFeature();
        this.ravineGenerator = new TFGenRavine();
        this.unusedIntArray32x32 = new int[32][32];
        this.worldObj = world;
        this.rand = new Random(l);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147435_p = world.func_72912_H().func_76067_t();
        this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
        this.terrainCalcs = new double[825];
        this.parabolicField = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                final float f = 10.0f / MathHelper.func_76129_c(j * j + k * k + 0.2f);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;
            }
        }
    }
    
    public Chunk func_73154_d(final int cx, final int cz) {
        this.rand.setSeed(cx * 341873128712L + cz * 132897987541L);
        final Block[] blockStorage = new Block[256 * TFWorld.CHUNKHEIGHT];
        final byte[] metaStorage = new byte[256 * TFWorld.CHUNKHEIGHT];
        this.generateTerrain2(cx, cz, blockStorage);
        this.squishTerrain(blockStorage);
        this.addDarkForestCanopy2(cx, cz, blockStorage, metaStorage);
        this.addGlaciers(cx, cz, blockStorage, metaStorage, this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, cx * 16, cz * 16, 16, 16));
        this.deformTerrainForFeature(cx, cz, blockStorage, metaStorage);
        this.replaceBlocksForBiome(cx, cz, blockStorage, metaStorage, this.biomesForGeneration);
        this.caveGenerator.func_151539_a((IChunkProvider)this, this.worldObj, cx, cz, blockStorage);
        this.ravineGenerator.func_151539_a((IChunkProvider)this, this.worldObj, cx, cz, blockStorage);
        final Block[] fake = new Block[0];
        this.majorFeatureGenerator.func_151539_a((IChunkProvider)this, this.worldObj, cx, cz, fake);
        final Chunk chunk = new Chunk(this.worldObj, blockStorage, metaStorage, cx, cz);
        final byte[] chunkBiomes = chunk.func_76605_m();
        for (int i = 0; i < chunkBiomes.length; ++i) {
            chunkBiomes[i] = (byte)this.biomesForGeneration[i].field_76756_M;
        }
        chunk.func_76603_b();
        return chunk;
    }
    
    public void generateTerrain2(final int chunkX, final int chunkZ, final Block[] blockStorage) {
        final byte seaLevel = 63;
        this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
        this.makeLandPerBiome2(chunkX * 4, 0, chunkZ * 4);
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
                    double d2 = this.terrainCalcs[k2 + k3];
                    double d3 = this.terrainCalcs[l2 + k3];
                    double d4 = this.terrainCalcs[i2 + k3];
                    double d5 = this.terrainCalcs[j2 + k3];
                    final double d6 = (this.terrainCalcs[k2 + k3 + 1] - d2) * d0;
                    final double d7 = (this.terrainCalcs[l2 + k3 + 1] - d3) * d0;
                    final double d8 = (this.terrainCalcs[i2 + k3 + 1] - d4) * d0;
                    final double d9 = (this.terrainCalcs[j2 + k3 + 1] - d5) * d0;
                    for (int l3 = 0; l3 < 8; ++l3) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k3 * 8 + l3;
                            final short short1 = 256;
                            j3 -= short1;
                            final double d15 = 0.25;
                            final double d16 = (d12 - d11) * d15;
                            double d17 = d11 - d16;
                            for (int k4 = 0; k4 < 4; ++k4) {
                                if ((d17 += d16) > 0.0) {
                                    blockStorage[j3 += short1] = Blocks.field_150348_b;
                                }
                                else if (k3 * 8 + l3 < seaLevel) {
                                    blockStorage[j3 += short1] = Blocks.field_150355_j;
                                }
                                else {
                                    blockStorage[j3 += short1] = null;
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
    
    private void makeLandPerBiome2(final int x, final int zero, final int z) {
        this.field_147426_g = this.noiseGen6.func_76305_a(this.field_147426_g, x, z, 5, 5, 200.0, 200.0, 0.5);
        this.field_147427_d = this.field_147429_l.func_76304_a(this.field_147427_d, x, zero, z, 5, 33, 5, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.field_147428_e = this.field_147431_j.func_76304_a(this.field_147428_e, x, zero, z, 5, 33, 5, 684.412, 684.412, 684.412);
        this.field_147425_f = this.field_147432_k.func_76304_a(this.field_147425_f, x, zero, z, 5, 33, 5, 684.412, 684.412, 684.412);
        int terrainIndex = 0;
        int noiseIndex = 0;
        for (int ax = 0; ax < 5; ++ax) {
            for (int az = 0; az < 5; ++az) {
                float totalVariation = 0.0f;
                float totalHeight = 0.0f;
                float totalFactor = 0.0f;
                final byte two = 2;
                final BiomeGenBase biomegenbase = this.biomesForGeneration[ax + 2 + (az + 2) * 10];
                for (int ox = -two; ox <= two; ++ox) {
                    for (int oz = -two; oz <= two; ++oz) {
                        final BiomeGenBase biomegenbase2 = this.biomesForGeneration[ax + ox + 2 + (az + oz + 2) * 10];
                        float rootHeight = biomegenbase2.field_76748_D;
                        float heightVariation = biomegenbase2.field_76749_E;
                        if (this.field_147435_p == WorldType.field_151360_e && rootHeight > 0.0f) {
                            rootHeight = 1.0f + rootHeight * 2.0f;
                            heightVariation = 1.0f + heightVariation * 4.0f;
                        }
                        float heightFactor = this.parabolicField[ox + 2 + (oz + 2) * 5] / (rootHeight + 2.0f);
                        if (biomegenbase2.field_76748_D > biomegenbase.field_76748_D) {
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
                double terrainNoise = this.field_147426_g[noiseIndex] / 8000.0;
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
                    final double d7 = this.field_147428_e[terrainIndex] / 512.0;
                    final double d8 = this.field_147425_f[terrainIndex] / 512.0;
                    final double d9 = (this.field_147427_d[terrainIndex] / 10.0 + 1.0) / 2.0;
                    double terrainCalc = MathHelper.func_151238_b(d7, d8, d9) - d6;
                    if (ay > 29) {
                        final double d10 = (ay - 29) / 3.0f;
                        terrainCalc = terrainCalc * (1.0 - d10) + -10.0 * d10;
                    }
                    this.terrainCalcs[terrainIndex] = terrainCalc;
                    ++terrainIndex;
                }
            }
        }
    }
    
    private void squishTerrain(final Block[] blockStorage) {
        final int squishHeight = TFWorld.MAXHEIGHT / 2;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < TFWorld.CHUNKHEIGHT; ++y) {
                    final int index = x * TFWorld.CHUNKHEIGHT * 16 | z * TFWorld.CHUNKHEIGHT | y;
                    if (y < squishHeight) {
                        final int twiceIndex = x * TFWorld.CHUNKHEIGHT * 16 | z * TFWorld.CHUNKHEIGHT | y * 2 + 1;
                        blockStorage[index] = blockStorage[twiceIndex];
                    }
                    else {
                        blockStorage[index] = Blocks.field_150350_a;
                    }
                }
            }
        }
    }
    
    public void replaceBlocksForBiome(final int chunkX, final int chunkZ, final Block[] blockStorage, final byte[] metaStorage, final BiomeGenBase[] biomes) {
        final ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks((IChunkProvider)this, chunkX, chunkZ, blockStorage, biomes);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }
        final double d0 = 0.03125;
        this.stoneNoise = this.field_147430_m.func_151599_a(this.stoneNoise, (double)(chunkX * 16), (double)(chunkZ * 16), 16, 16, d0 * 2.0, d0 * 2.0, 1.0);
        for (int z = 0; z < 16; ++z) {
            for (int x = 0; x < 16; ++x) {
                final BiomeGenBase biomegenbase = biomes[x + z * 16];
                biomegenbase.func_150573_a(this.worldObj, this.rand, blockStorage, metaStorage, chunkX * 16 + z, chunkZ * 16 + x, this.stoneNoise[x + z * 16]);
            }
        }
    }
    
    public Chunk func_73158_c(final int i, final int j) {
        return this.func_73154_d(i, j);
    }
    
    public void deformTerrainForFeature(final int cx, final int cz, final Block[] blockStorage, final byte[] metaStorage) {
        final TFFeature nearFeature = TFFeature.getNearestFeature(cx, cz, this.worldObj);
        if (!nearFeature.isTerrainAltered) {
            return;
        }
        final int[] nearCenter = TFFeature.getNearestCenter(cx, cz, this.worldObj);
        final int hx = nearCenter[0];
        final int hz = nearCenter[1];
        if (nearFeature == TFFeature.trollCave) {
            this.deformTerrainForTrollCloud2(blockStorage, metaStorage, nearFeature, cx, cz, hx, hz);
        }
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final int dx = x - hx;
                final int dz = z - hz;
                if (nearFeature == TFFeature.hill1 || nearFeature == TFFeature.hill2 || nearFeature == TFFeature.hill3 || nearFeature == TFFeature.hydraLair) {
                    final int hdiam = (nearFeature.size * 2 + 1) * 16;
                    final int dist = (int)Math.sqrt(dx * dx + dz * dz);
                    final int hheight = (int)(Math.cos(dist / (float)hdiam * 3.141592653589793) * (hdiam / 3.0f));
                    this.raiseHills(blockStorage, nearFeature, hdiam, x, z, dx, dz, hheight);
                }
                else if (nearFeature == TFFeature.hedgeMaze || nearFeature == TFFeature.nagaCourtyard || nearFeature == TFFeature.questGrove) {
                    this.flattenTerrainForFeature(blockStorage, nearFeature, x, z, dx, dz);
                }
                else if (nearFeature == TFFeature.yetiCave) {
                    this.deformTerrainForYetiLair(blockStorage, nearFeature, x, z, dx, dz);
                }
                else if (nearFeature == TFFeature.trollCave) {}
            }
        }
    }
    
    private void raiseHills(final Block[] storage, final TFFeature nearFeature, final int hdiam, final int x, final int z, final int dx, final int dz, final int hillHeight) {
        int newGround = -1;
        boolean foundGroundLevel = false;
        for (int y = 0; y < TFWorld.CHUNKHEIGHT; ++y) {
            final int index = x * TFWorld.CHUNKHEIGHT * 16 | z * TFWorld.CHUNKHEIGHT | y;
            final Block currentTerrain = storage[index];
            if (currentTerrain != Blocks.field_150348_b && !foundGroundLevel) {
                newGround = y + hillHeight;
                foundGroundLevel = true;
            }
            if (foundGroundLevel && y <= newGround) {
                storage[index] = Blocks.field_150348_b;
            }
        }
        int hollow = hillHeight - 4 - nearFeature.size;
        if (nearFeature == TFFeature.hydraLair) {
            final int mx = dx + 16;
            final int mz = dz + 16;
            final int mdist = (int)Math.sqrt(mx * mx + mz * mz);
            final int mheight = (int)(Math.cos(mdist / (hdiam / 1.5) * 3.141592653589793) * (hdiam / 1.5));
            hollow = Math.max(mheight - 4, hollow);
        }
        if (hollow < 0) {
            hollow = 0;
        }
        for (int y2 = 0; y2 < TFWorld.CHUNKHEIGHT; ++y2) {
            final int index2 = x * TFWorld.CHUNKHEIGHT * 16 | z * TFWorld.CHUNKHEIGHT | y2;
            if (hillHeight > 0 && y2 < TFWorld.SEALEVEL && storage[index2] != Blocks.field_150348_b) {
                storage[index2] = Blocks.field_150348_b;
            }
            int hollowFloor = TFWorld.SEALEVEL - 3 - hollow / 8;
            if (nearFeature == TFFeature.hydraLair) {
                hollowFloor = TFWorld.SEALEVEL;
            }
            if (y2 > hollowFloor && y2 < hollowFloor + hollow) {
                storage[index2] = Blocks.field_150350_a;
            }
        }
    }
    
    private void flattenTerrainForFeature(final Block[] storage, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
        float squishfactor = 0.0f;
        int mazeheight = TFWorld.SEALEVEL + 1;
        final int FEATUREBOUNDRY = (nearFeature.size * 2 + 1) * 8 - 8;
        if (dx <= -FEATUREBOUNDRY) {
            squishfactor = (-dx - FEATUREBOUNDRY) / 8.0f;
        }
        if (dx >= FEATUREBOUNDRY) {
            squishfactor = (dx - FEATUREBOUNDRY) / 8.0f;
        }
        if (dz <= -FEATUREBOUNDRY) {
            squishfactor = Math.max(squishfactor, (-dz - FEATUREBOUNDRY) / 8.0f);
        }
        if (dz >= FEATUREBOUNDRY) {
            squishfactor = Math.max(squishfactor, (dz - FEATUREBOUNDRY) / 8.0f);
        }
        if (squishfactor > 0.0f) {
            int newGround = -1;
            for (int y = 0; y <= 127; ++y) {
                final int index = (x * 16 + z) * TFWorld.CHUNKHEIGHT + y;
                final Block currentTerrain = storage[index];
                if (currentTerrain != Blocks.field_150348_b) {
                    if (newGround == -1) {
                        final int oldGround = y;
                        mazeheight += (int)((oldGround - mazeheight) * squishfactor);
                        newGround = oldGround;
                    }
                }
            }
        }
        for (int y = 0; y <= 127; ++y) {
            final int index = (x * 16 + z) * TFWorld.CHUNKHEIGHT + y;
            if (y < mazeheight && (storage[index] == Blocks.field_150350_a || storage[index] == Blocks.field_150355_j)) {
                storage[index] = Blocks.field_150348_b;
            }
            if (y >= mazeheight && storage[index] != Blocks.field_150355_j) {
                storage[index] = Blocks.field_150350_a;
            }
        }
    }
    
    private void deformTerrainForYetiLair(final Block[] storage, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
        float squishfactor = 0.0f;
        int topHeight = TFWorld.SEALEVEL + 24;
        final int outerBoundry = (nearFeature.size * 2 + 1) * 8 - 8;
        if (dx <= -outerBoundry) {
            squishfactor = (-dx - outerBoundry) / 8.0f;
        }
        if (dx >= outerBoundry) {
            squishfactor = (dx - outerBoundry) / 8.0f;
        }
        if (dz <= -outerBoundry) {
            squishfactor = Math.max(squishfactor, (-dz - outerBoundry) / 8.0f);
        }
        if (dz >= outerBoundry) {
            squishfactor = Math.max(squishfactor, (dz - outerBoundry) / 8.0f);
        }
        final int caveBoundry = nearFeature.size * 2 * 8 - 8;
        int hollowCeiling = TFWorld.SEALEVEL + 16;
        final int offset = Math.min(Math.abs(dx), Math.abs(dz));
        hollowCeiling = TFWorld.SEALEVEL + 40 - offset * 4;
        if (dx >= -caveBoundry && dz >= -caveBoundry && dx <= caveBoundry && dz <= caveBoundry) {
            hollowCeiling = TFWorld.SEALEVEL + 16;
        }
        hollowCeiling -= offset / 6;
        hollowCeiling = Math.min(hollowCeiling, TFWorld.SEALEVEL + 16);
        int hollowFloor = TFWorld.SEALEVEL - 1 + offset / 6;
        if (squishfactor > 0.0f) {
            int newGround = -1;
            for (int y = 0; y <= 127; ++y) {
                final int index = (x * 16 + z) * TFWorld.CHUNKHEIGHT + y;
                final Block currentTerrain = storage[index];
                if (currentTerrain != Blocks.field_150348_b) {
                    if (newGround == -1) {
                        final int oldGround = y;
                        topHeight += (int)((oldGround - topHeight) * squishfactor);
                        hollowFloor += (int)((oldGround - hollowFloor) * squishfactor);
                        newGround = oldGround;
                    }
                }
            }
        }
        for (int y = 0; y <= 127; ++y) {
            final int index = (x * 16 + z) * TFWorld.CHUNKHEIGHT + y;
            if (y < topHeight && (storage[index] == null || storage[index] == Blocks.field_150350_a || storage[index] == Blocks.field_150355_j)) {
                storage[index] = Blocks.field_150348_b;
            }
            if (y > hollowFloor && y < hollowCeiling) {
                storage[index] = Blocks.field_150350_a;
            }
            if (y == hollowFloor && y < hollowCeiling && y < TFWorld.SEALEVEL + 3) {
                storage[index] = Blocks.field_150403_cj;
            }
        }
    }
    
    private void deformTerrainForTrollCloud(final Block[] storage, final byte[] metaStorage, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
        final int y = 164;
        final int index = (x * 16 + z) * TFWorld.CHUNKHEIGHT + y;
        final int bx = dx >> 2;
        final int bz = dz >> 2;
        final double dist = Math.sqrt(bx * bx + bz * bz);
        final float pr = this.pseudoRand(x >> 2, z >> 2);
        System.out.println("pr = " + pr + ", dist = " + dist + "dx = " + dx + " dz = " + dz);
        final double cv = dist - 9.0 - pr * 4.0f;
        if (dist < 9.0 || cv < 0.05000000074505806) {
            storage[index] = (Block)Blocks.field_150399_cn;
            storage[index - 1] = Blocks.field_150371_ca;
            storage[index - 2] = Blocks.field_150371_ca;
            storage[index - 3] = Blocks.field_150371_ca;
            storage[index - 4] = (Block)Blocks.field_150399_cn;
        }
        else if (dist < 10.0 || cv < 1.0) {
            storage[index - 1] = (Block)Blocks.field_150399_cn;
            storage[index - 2] = (Block)Blocks.field_150399_cn;
            storage[index - 3] = (Block)Blocks.field_150399_cn;
        }
    }
    
    private void deformTerrainForTrollCloud2(final Block[] storage, final byte[] metaStorage, final TFFeature nearFeature, final int cx, final int cz, final int hx, final int hz) {
        for (int bx = 0; bx < 4; ++bx) {
            for (int bz = 0; bz < 4; ++bz) {
                final int dx = bx * 4 - hx - 2;
                final int dz = bz * 4 - hz - 2;
                final int regionX = cx + 8 >> 4;
                final int regionZ = cx + 8 >> 4;
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
                final float pr = this.worldObj.field_73012_v.nextFloat();
                final double cv = dist4 - 7.0 - pr * 3.0f;
                int y = 164;
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
                        final int index = ((bx * 4 + sx) * 16 + (bz * 4 + sz)) * TFWorld.CHUNKHEIGHT + y;
                        if (dist4 < 7.0 || cv < 0.05000000074505806) {
                            storage[index] = TFBlocks.wispyCloud;
                            for (int d = 1; d < depth; ++d) {
                                storage[index - d] = TFBlocks.fluffyCloud;
                            }
                            storage[index - depth] = TFBlocks.wispyCloud;
                        }
                        else if (dist4 < 8.0 || cv < 1.0) {
                            for (int d = 1; d < depth; ++d) {
                                storage[index - d] = TFBlocks.wispyCloud;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private float pseudoRand(final int bx, final int bz) {
        final Random rand = new Random(this.worldObj.func_72905_C() + bx * 321534781 ^ (long)(bz * 756839));
        rand.setSeed(rand.nextLong());
        return rand.nextFloat();
    }
    
    public void addGlaciers(final int chunkX, final int chunkZ, final Block[] blocks, final byte[] meta, final BiomeGenBase[] biomes) {
        for (int z = 0; z < 16; ++z) {
            for (int x = 0; x < 16; ++x) {
                final BiomeGenBase biome = biomes[(x & 0xF) | (z & 0xF) << 4];
                if (biome == TFBiomeBase.glacier) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final int index = x * TFWorld.CHUNKHEIGHT * 16 | z * TFWorld.CHUNKHEIGHT | y;
                        final Block currentBlock = blocks[index];
                        if (currentBlock == Blocks.field_150348_b) {
                            topLevel = y;
                            blocks[index] = Blocks.field_150351_n;
                            break;
                        }
                    }
                    final int gHeight = 32;
                    for (int gTop = topLevel + gHeight + 1, y2 = topLevel + 1; y2 <= gTop && y2 < 128; ++y2) {
                        final int index2 = x * TFWorld.CHUNKHEIGHT * 16 | z * TFWorld.CHUNKHEIGHT | y2;
                        blocks[index2] = Blocks.field_150432_aD;
                    }
                }
            }
        }
    }
    
    public void addDarkForestCanopy2(final int chunkX, final int chunkZ, final Block[] blocks, final byte[] meta) {
        final int[] thicks = new int[25];
        for (int z = 0; z < 5; ++z) {
            for (int x = 0; x < 5; ++x) {
                for (int bx = -1; bx <= 1; ++bx) {
                    for (int bz = -1; bz <= 1; ++bz) {
                        final BiomeGenBase biome = this.biomesForGeneration[x + bx + 2 + (z + bz + 2) * 10];
                        if (biome == TFBiomeBase.darkForest || biome == TFBiomeBase.darkForestCenter) {
                            final int[] array = thicks;
                            final int n = x + z * 5;
                            ++array[n];
                        }
                    }
                }
            }
        }
        for (int z = 0; z < 16; ++z) {
            for (int x = 0; x < 16; ++x) {
                final int qx = x / 4;
                final int qz = z / 4;
                final float xweight = x % 4 * 0.25f + 0.125f;
                final float zweight = z % 4 * 0.25f + 0.125f;
                float thickness = 0.0f;
                thickness += thicks[qx + qz * 5] * (1.0f - xweight) * (1.0f - zweight);
                thickness += thicks[qx + 1 + qz * 5] * xweight * (1.0f - zweight);
                thickness += thicks[qx + (qz + 1) * 5] * (1.0f - xweight) * zweight;
                thickness += thicks[qx + 1 + (qz + 1) * 5] * xweight * zweight;
                thickness -= 4.0f;
                final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, this.worldObj);
                if (nearFeature == TFFeature.darkTower) {
                    final int[] nearCenter = TFFeature.getNearestCenter(chunkX, chunkZ, this.worldObj);
                    final int hx = nearCenter[0];
                    final int hz = nearCenter[1];
                    final int dx = x - hx;
                    final int dz = z - hz;
                    final int dist = (int)Math.sqrt(dx * dx + dz * dz);
                    if (dist < 24) {
                        thickness -= 24 - dist;
                    }
                }
                final boolean generateForest = thickness > 1.0f;
                if (generateForest) {
                    final double d = 0.03125;
                    this.stoneNoise = this.noiseGen4.func_76304_a(this.stoneNoise, chunkX * 16, chunkZ * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final int index = x * TFWorld.CHUNKHEIGHT * 16 | z * TFWorld.CHUNKHEIGHT | y;
                        final Block currentBlock = blocks[index];
                        if (currentBlock == Blocks.field_150355_j) {
                            break;
                        }
                        if (currentBlock == Blocks.field_150348_b) {
                            topLevel = y;
                            break;
                        }
                    }
                    if (topLevel != -1) {
                        final int noise = Math.min(3, (int)(this.stoneNoise[(z & 0xF) | (x & 0xF) << 4] / 1.25));
                        int treeBottom = topLevel + 12 - (int)(thickness * 0.5f);
                        int treeTop;
                        int y2;
                        for (treeTop = treeBottom + (int)(thickness * 1.5f), treeBottom = (y2 = treeBottom - noise); y2 < treeTop; ++y2) {
                            final int index2 = x * TFWorld.CHUNKHEIGHT * 16 | z * TFWorld.CHUNKHEIGHT | y2;
                            blocks[index2] = TFBlocks.darkleaves;
                            meta[index2] = 0;
                        }
                    }
                }
            }
        }
    }
    
    public boolean func_73149_a(final int i, final int j) {
        return true;
    }
    
    public void func_73153_a(final IChunkProvider ichunkprovider, final int chunkX, final int chunkZ) {
        BlockFalling.field_149832_M = true;
        int mapX = chunkX * 16;
        int mapY = chunkZ * 16;
        final BiomeGenBase biomegenbase = this.worldObj.func_72807_a(mapX + 16, mapY + 16);
        this.rand.setSeed(this.worldObj.func_72905_C());
        final long l1 = this.rand.nextLong() / 2L * 2L + 1L;
        final long l2 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(chunkX * l1 + chunkZ * l2 ^ this.worldObj.func_72905_C());
        boolean disableFeatures = false;
        disableFeatures |= this.majorFeatureGenerator.func_75051_a(this.worldObj, this.rand, chunkX, chunkZ);
        disableFeatures |= !TFFeature.getNearestFeature(chunkX, chunkZ, this.worldObj).areChunkDecorationsEnabled;
        if (!disableFeatures && this.rand.nextInt(4) == 0) {
            final int i1 = mapX + this.rand.nextInt(16) + 8;
            final int i2 = this.rand.nextInt(TFWorld.CHUNKHEIGHT);
            final int i3 = mapY + this.rand.nextInt(16) + 8;
            new WorldGenLakes(Blocks.field_150355_j).func_76484_a(this.worldObj, this.rand, i1, i2, i3);
        }
        if (!disableFeatures && this.rand.nextInt(32) == 0) {
            final int j1 = mapX + this.rand.nextInt(16) + 8;
            final int j2 = this.rand.nextInt(this.rand.nextInt(TFWorld.CHUNKHEIGHT - 8) + 8);
            final int j3 = mapY + this.rand.nextInt(16) + 8;
            if (j2 < TFWorld.SEALEVEL || this.rand.nextInt(10) == 0) {
                new WorldGenLakes(Blocks.field_150353_l).func_76484_a(this.worldObj, this.rand, j1, j2, j3);
            }
        }
        for (int k1 = 0; k1 < 8; ++k1) {
            final int k2 = mapX + this.rand.nextInt(16) + 8;
            final int k3 = this.rand.nextInt(TFWorld.CHUNKHEIGHT);
            final int l3 = mapY + this.rand.nextInt(16) + 8;
            new WorldGenDungeons().func_76484_a(this.worldObj, this.rand, k2, k3, l3);
        }
        biomegenbase.func_76728_a(this.worldObj, this.rand, mapX, mapY);
        SpawnerAnimals.func_77191_a(this.worldObj, biomegenbase, mapX + 8, mapY + 8, 16, 16, this.rand);
        mapX += 8;
        mapY += 8;
        for (int i4 = 0; i4 < 16; ++i4) {
            for (int j4 = 0; j4 < 16; ++j4) {
                final int j5 = this.worldObj.func_72874_g(mapX + i4, mapY + j4);
                if (this.worldObj.func_72884_u(i4 + mapX, j5 - 1, j4 + mapY)) {
                    this.worldObj.func_147465_d(i4 + mapX, j5 - 1, j4 + mapY, Blocks.field_150432_aD, 0, 2);
                }
                if (this.worldObj.func_147478_e(i4 + mapX, j5, j4 + mapY, true)) {
                    this.worldObj.func_147465_d(i4 + mapX, j5, j4 + mapY, Blocks.field_150431_aC, 0, 2);
                }
            }
        }
        BlockFalling.field_149832_M = false;
    }
    
    public boolean func_73151_a(final boolean flag, final IProgressUpdate iprogressupdate) {
        return true;
    }
    
    public boolean func_73157_c() {
        return true;
    }
    
    public String func_73148_d() {
        return "TwilightLevelSource";
    }
    
    public List<BiomeGenBase.SpawnListEntry> func_73155_a(final EnumCreatureType creatureType, final int mapX, final int mapY, final int mapZ) {
        final TFFeature nearestFeature = TFFeature.getFeatureForRegion(mapX >> 4, mapZ >> 4, this.worldObj);
        if (nearestFeature != TFFeature.nothing) {
            if (this.isStructureConquered(mapX, mapY, mapZ)) {
                return null;
            }
            final int spawnListIndex = this.majorFeatureGenerator.getSpawnListIndexAt(mapX, mapY, mapZ);
            if (spawnListIndex >= 0) {
                return nearestFeature.getSpawnableList(creatureType, spawnListIndex);
            }
        }
        final BiomeGenBase biome = this.worldObj.func_72807_a(mapX, mapZ);
        if (biome == null) {
            return null;
        }
        if (mapY < TFWorld.SEALEVEL && creatureType == EnumCreatureType.monster && biome instanceof TFBiomeBase) {
            return ((TFBiomeBase)biome).getUndergroundSpawnableList();
        }
        return biome.func_76747_a(creatureType);
    }
    
    public boolean isBlockInStructureBB(final int mapX, final int mapY, final int mapZ) {
        return this.majorFeatureGenerator.func_75048_a(mapX, mapY, mapZ);
    }
    
    public void setStructureConquered(final int mapX, final int mapY, final int mapZ, final boolean flag) {
        this.majorFeatureGenerator.setStructureConquered(mapX, mapY, mapZ, flag);
    }
    
    public StructureBoundingBox getSBBAt(final int mapX, final int mapY, final int mapZ) {
        return this.majorFeatureGenerator.getSBBAt(mapX, mapY, mapZ);
    }
    
    public boolean isBlockProtected(final int x, final int y, final int z) {
        return this.majorFeatureGenerator.isBlockProtectedAt(x, y, z);
    }
    
    public boolean isStructureConquered(final int mapX, final int mapY, final int mapZ) {
        return this.majorFeatureGenerator.isStructureConquered(mapX, mapY, mapZ);
    }
    
    public int func_73152_e() {
        return 0;
    }
    
    public void func_82695_e(final int var1, final int var2) {
        this.majorFeatureGenerator.func_151539_a((IChunkProvider)this, this.worldObj, var1, var2, (Block[])null);
    }
    
    public boolean func_73156_b() {
        return false;
    }
    
    public void func_104112_b() {
    }
    
    public ChunkPosition func_147416_a(final World var1, final String var2, final int var3, final int var4, final int var5) {
        return null;
    }
}
