// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.ChunkPosition;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.block.BlockSand;
import twilightforest.block.TFBlocks;
import net.minecraft.util.MathHelper;
import twilightforest.TFFeature;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.chunk.Chunk;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import java.util.Random;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderTwilightForest implements IChunkProvider
{
    private Random rand;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private final boolean mapFeaturesEnabled;
    private double[] landMap;
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
    private MapGenTFMajorFeature majorFeatureGenerator;
    
    public ChunkProviderTwilightForest(final World world, final long l, final boolean flag) {
        this.stoneNoise = new double[256];
        this.caveGenerator = new TFGenCaves();
        this.majorFeatureGenerator = new MapGenTFMajorFeature();
        this.ravineGenerator = new TFGenRavine();
        this.unusedIntArray32x32 = new int[32][32];
        this.worldObj = world;
        this.mapFeaturesEnabled = flag;
        this.rand = new Random(l);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
    }
    
    public void generateTerrain(final int par1, final int par2, final short[] par3ArrayofShort) {
        final byte byte0 = 4;
        final byte byte2 = 8;
        final byte byte3 = (byte)TFWorld.SEALEVEL;
        final int i = byte0 + 1;
        final byte byte4 = 9;
        final int j = byte0 + 1;
        this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, i + 5, j + 5);
        this.landMap = this.makeLandPerBiome(this.landMap, par1 * byte0, 0, par2 * byte0, i, byte4, j);
        for (int k = 0; k < byte0; ++k) {
            for (int l = 0; l < byte0; ++l) {
                for (int i2 = 0; i2 < byte2; ++i2) {
                    final double d = 0.125;
                    double d2 = this.landMap[((k + 0) * j + (l + 0)) * byte4 + (i2 + 0)];
                    double d3 = this.landMap[((k + 0) * j + (l + 1)) * byte4 + (i2 + 0)];
                    double d4 = this.landMap[((k + 1) * j + (l + 0)) * byte4 + (i2 + 0)];
                    double d5 = this.landMap[((k + 1) * j + (l + 1)) * byte4 + (i2 + 0)];
                    final double d6 = (this.landMap[((k + 0) * j + (l + 0)) * byte4 + (i2 + 1)] - d2) * d;
                    final double d7 = (this.landMap[((k + 0) * j + (l + 1)) * byte4 + (i2 + 1)] - d3) * d;
                    final double d8 = (this.landMap[((k + 1) * j + (l + 0)) * byte4 + (i2 + 1)] - d4) * d;
                    final double d9 = (this.landMap[((k + 1) * j + (l + 1)) * byte4 + (i2 + 1)] - d5) * d;
                    for (int j2 = 0; j2 < 8; ++j2) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int k2 = 0; k2 < 4; ++k2) {
                            int l2 = k2 + k * 4 << 11 | 0 + l * 4 << 7 | i2 * 8 + j2;
                            final char c = '\u0080';
                            l2 -= c;
                            final double d15 = 0.25;
                            double d16 = d11;
                            final double d17 = (d12 - d11) * d15;
                            d16 -= d17;
                            for (int i3 = 0; i3 < 4; ++i3) {
                                if ((d16 += d17) > 0.0) {
                                    par3ArrayofShort[l2 += c] = (short)Block.field_71981_t.field_71990_ca;
                                }
                                else if (i2 * 8 + j2 < byte3) {
                                    par3ArrayofShort[l2 += c] = (short)Block.field_71943_B.field_71990_ca;
                                }
                                else {
                                    par3ArrayofShort[l2 += c] = 0;
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
    
    public void replaceBlocksForBiome(final int par1, final int par2, final short[] blockArray4096, final BiomeGenBase[] par4ArrayOfBiomeGenBase) {
        final byte sealevel = (byte)TFWorld.SEALEVEL;
        final double d = 0.03125;
        this.stoneNoise = this.noiseGen4.func_76304_a(this.stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                BiomeGenBase biomegenbase = par4ArrayOfBiomeGenBase[j + i * 16];
                if (biomegenbase == null) {
                    biomegenbase = TFBiomeBase.twilightForest;
                }
                final float f = biomegenbase.func_76743_j();
                final int k = (int)(this.stoneNoise[i + j * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int l = -1;
                short top = biomegenbase.field_76752_A;
                short filler = biomegenbase.field_76753_B;
                for (int i2 = 127; i2 >= 0; --i2) {
                    final int j2 = (j * 16 + i) * 128 + i2;
                    if (i2 <= 0 + this.rand.nextInt(5)) {
                        blockArray4096[j2] = (short)Block.field_71986_z.field_71990_ca;
                    }
                    else {
                        final short currentBlock = blockArray4096[j2];
                        if (currentBlock == Block.field_71981_t.field_71990_ca) {
                            if (l == -1) {
                                if (k <= 0) {
                                    top = 0;
                                    filler = (short)Block.field_71981_t.field_71990_ca;
                                }
                                else if (i2 >= sealevel - 4 && i2 <= sealevel + 1) {
                                    top = biomegenbase.field_76752_A;
                                    filler = biomegenbase.field_76753_B;
                                }
                                if (i2 < sealevel && top == 0) {
                                    if (f < 0.15f) {
                                        top = (short)Block.field_72036_aT.field_71990_ca;
                                    }
                                    else {
                                        top = (short)Block.field_71943_B.field_71990_ca;
                                    }
                                }
                                l = k;
                                if (i2 >= sealevel - 1) {
                                    blockArray4096[j2] = top;
                                }
                                else {
                                    blockArray4096[j2] = filler;
                                }
                            }
                            else if (l > 0) {
                                --l;
                                blockArray4096[j2] = filler;
                                if (l == 0 && filler == Block.field_71939_E.field_71990_ca) {
                                    l = this.rand.nextInt(4);
                                    filler = (short)Block.field_71957_Q.field_71990_ca;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public Chunk func_73158_c(final int i, final int j) {
        return this.func_73154_d(i, j);
    }
    
    public Chunk func_73154_d(final int cx, final int cz) {
        this.rand.setSeed(cx * 341873128712L + cz * 132897987541L);
        final short[] blockStorage = new short[32768];
        final byte[] metaStorage = new byte[32768];
        this.generateTerrain(cx, cz, blockStorage);
        this.addGlaciers(cx, cz, blockStorage, metaStorage, this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, cx * 16, cz * 16, 16, 16));
        this.raiseHills(cx, cz, blockStorage);
        this.addDarkForestCanopy(cx, cz, blockStorage, metaStorage, this.biomesForGeneration);
        this.replaceBlocksForBiome(cx, cz, blockStorage, this.biomesForGeneration);
        this.addFeatureMarker(cx, cz, blockStorage, metaStorage);
        this.caveGenerator.generate((IChunkProvider)this, this.worldObj, cx, cz, blockStorage);
        this.ravineGenerator.generate((IChunkProvider)this, this.worldObj, cx, cz, blockStorage);
        final byte[] fake = new byte[0];
        this.majorFeatureGenerator.func_75036_a((IChunkProvider)this, this.worldObj, cx, cz, fake);
        final Chunk chunk = this.makeAChunk(this.worldObj, blockStorage, metaStorage, cx, cz);
        final byte[] chunkBiomes = chunk.func_76605_m();
        for (int i = 0; i < chunkBiomes.length; ++i) {
            chunkBiomes[i] = (byte)this.biomesForGeneration[i].field_76756_M;
        }
        chunk.func_76603_b();
        return chunk;
    }
    
    protected Chunk makeAChunk(final World world, final short[] ids, final byte[] metadata, final int chunkX, final int chunkZ) {
        final Chunk chunk = new Chunk(world, chunkX, chunkZ);
        final ExtendedBlockStorage[] storageArrays = chunk.func_76587_i();
        final int height = ids.length / 256;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < height; ++y) {
                    final int index = x << 11 | z << 7 | y;
                    final int id = ids[index] & 0xFFF;
                    final int meta = metadata[index];
                    if (id != 0) {
                        final int storageIndex = y >> 4;
                        if (storageArrays[storageIndex] == null) {
                            storageArrays[storageIndex] = new ExtendedBlockStorage(storageIndex << 4, true);
                        }
                        storageArrays[storageIndex].func_76655_a(x, y & 0xF, z, id);
                        storageArrays[storageIndex].func_76654_b(x, y & 0xF, z, meta);
                    }
                }
            }
        }
        return chunk;
    }
    
    public void raiseHills(final int cx, final int cz, final short[] storage) {
        final TFFeature nearFeature = TFFeature.getNearestFeature(cx, cz, this.worldObj);
        if (nearFeature == TFFeature.nothing) {
            return;
        }
        final int[] nearCenter = TFFeature.getNearestCenter(cx, cz, this.worldObj);
        final double hdiam = (nearFeature.size * 2 + 1) * 16.0;
        final int hx = nearCenter[0];
        final int hz = nearCenter[1];
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                int oldGround = -1;
                int newGround = -1;
                final int dx = x - hx;
                final int dz = z - hz;
                final int dist = (int)Math.sqrt(dx * dx + dz * dz);
                final int hheight = (int)(Math.cos(dist / hdiam * 3.141592653589793) * (hdiam / 3.0));
                if (nearFeature == TFFeature.hill1 || nearFeature == TFFeature.hill2 || nearFeature == TFFeature.hill3 || nearFeature == TFFeature.hydraLair) {
                    for (int y = 0; y <= 127; ++y) {
                        final int index = (x * 16 + z) * TFWorld.WORLDHEIGHT + y;
                        final int currentTerrain = storage[index];
                        if (currentTerrain == 0 || currentTerrain == Block.field_72036_aT.field_71990_ca) {
                            if (newGround == -1) {
                                oldGround = y;
                                newGround = oldGround + hheight;
                            }
                            if (y <= newGround) {
                                storage[index] = (short)Block.field_71981_t.field_71990_ca;
                            }
                        }
                    }
                    int hollow = hheight - 4 - nearFeature.size;
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
                    for (int y2 = 0; y2 <= 127; ++y2) {
                        final int index2 = (x * 16 + z) * TFWorld.WORLDHEIGHT + y2;
                        if (hheight > 0 && y2 < TFWorld.SEALEVEL && storage[index2] != Block.field_71981_t.field_71990_ca) {
                            storage[index2] = (short)Block.field_71981_t.field_71990_ca;
                        }
                        int hollowFloor = TFWorld.SEALEVEL - 3 - hollow / 8;
                        if (nearFeature == TFFeature.hydraLair) {
                            hollowFloor = TFWorld.SEALEVEL;
                        }
                        if (y2 > hollowFloor && y2 < hollowFloor + hollow) {
                            storage[index2] = 0;
                        }
                    }
                }
                if (nearFeature == TFFeature.hedgeMaze || nearFeature == TFFeature.nagaLair || nearFeature == TFFeature.questGrove) {
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
                        newGround = -1;
                        for (int y3 = 0; y3 <= 127; ++y3) {
                            final int index3 = (x * 16 + z) * TFWorld.WORLDHEIGHT + y3;
                            final int currentTerrain2 = storage[index3];
                            if (currentTerrain2 != Block.field_71981_t.field_71990_ca) {
                                if (newGround == -1) {
                                    oldGround = y3;
                                    mazeheight += (int)((oldGround - mazeheight) * squishfactor);
                                    newGround = oldGround;
                                }
                            }
                        }
                    }
                    for (int y3 = 0; y3 <= 127; ++y3) {
                        final int index3 = (x * 16 + z) * TFWorld.WORLDHEIGHT + y3;
                        if (y3 < mazeheight && (storage[index3] == 0 || storage[index3] == Block.field_71943_B.field_71990_ca)) {
                            storage[index3] = (short)Block.field_71981_t.field_71990_ca;
                        }
                        if (y3 >= mazeheight && storage[index3] != Block.field_71943_B.field_71990_ca) {
                            storage[index3] = 0;
                        }
                    }
                }
            }
        }
    }
    
    private double[] makeLandPerBiome(double[] ad, int xx, final int zero, int zz, final int l, final int i1, final int j1) {
        if (ad == null) {
            ad = new double[l * i1 * j1];
        }
        if (this.squareTable == null) {
            this.squareTable = new float[25];
            for (int k1 = -2; k1 <= 2; ++k1) {
                for (int l2 = -2; l2 <= 2; ++l2) {
                    final float f = 10.0f / MathHelper.func_76129_c(k1 * k1 + l2 * l2 + 0.2f);
                    this.squareTable[k1 + 2 + (l2 + 2) * 5] = f;
                }
            }
        }
        final double d = 684.412;
        final double d2 = 684.412;
        this.noise5 = this.noiseGen5.func_76305_a(this.noise5, xx, zz, l, j1, 1.121, 1.121, 0.5);
        this.noise6 = this.noiseGen6.func_76305_a(this.noise6, xx, zz, l, j1, 200.0, 200.0, 0.5);
        this.noise3 = this.noiseGen3.func_76304_a(this.noise3, xx, zero, zz, l, i1, j1, d / 80.0, d2 / 160.0, d / 80.0);
        this.noise1 = this.noiseGen1.func_76304_a(this.noise1, xx, zero, zz, l, i1, j1, d, d2, d);
        this.noise2 = this.noiseGen2.func_76304_a(this.noise2, xx, zero, zz, l, i1, j1, d, d2, d);
        zz = (xx = 0);
        int i2 = 0;
        int j2 = 0;
        for (int k2 = 0; k2 < l; ++k2) {
            for (int l3 = 0; l3 < j1; ++l3) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                final byte byte0 = 2;
                final BiomeGenBase biomegenbase = this.biomesForGeneration[k2 + 2 + (l3 + 2) * (l + 5)];
                for (int i3 = -byte0; i3 <= byte0; ++i3) {
                    for (int j3 = -byte0; j3 <= byte0; ++j3) {
                        final BiomeGenBase biomegenbase2 = this.biomesForGeneration[k2 + i3 + 2 + (l3 + j3 + 2) * (l + 5)];
                        float f5 = this.squareTable[i3 + 2 + (j3 + 2) * 5] / (biomegenbase2.field_76748_D + 2.0f);
                        if (biomegenbase2.field_76748_D > biomegenbase.field_76748_D) {
                            f5 /= 2.0f;
                        }
                        f2 += biomegenbase2.field_76749_E * f5;
                        f3 += biomegenbase2.field_76748_D * f5;
                        f4 += f5;
                    }
                }
                f2 /= f4;
                f3 /= f4;
                f2 = f2 * 0.9f + 0.1f;
                f3 = (f3 * 4.0f - 1.0f) / 8.0f;
                double d3 = this.noise6[j2] / 8000.0;
                if (d3 < 0.0) {
                    d3 = -d3 * 0.3;
                }
                d3 = d3 * 3.0 - 2.0;
                if (d3 < 0.0) {
                    d3 /= 2.0;
                    if (d3 < -1.0) {
                        d3 = -1.0;
                    }
                    d3 /= 1.4;
                    d3 /= 2.0;
                }
                else {
                    if (d3 > 1.0) {
                        d3 = 1.0;
                    }
                    d3 /= 8.0;
                }
                ++j2;
                for (int k3 = 0; k3 < i1; ++k3) {
                    double d4 = f3;
                    final double d5 = f2;
                    d4 += d3 * 0.2;
                    d4 = d4 * i1 / 16.0;
                    final double d6 = i1 / 2.0 + d4 * 4.0;
                    double d7 = 0.0;
                    double d8 = (k3 - d6) * 12.0 * 128.0 / TFWorld.WORLDHEIGHT / d5;
                    if (d8 < 0.0) {
                        d8 *= 4.0;
                    }
                    final double d9 = this.noise1[i2] / 512.0;
                    final double d10 = this.noise2[i2] / 512.0;
                    final double d11 = (this.noise3[i2] / 10.0 + 1.0) / 2.0;
                    if (d11 < 0.0) {
                        d7 = d9;
                    }
                    else if (d11 > 1.0) {
                        d7 = d10;
                    }
                    else {
                        d7 = d9 + (d10 - d9) * d11;
                    }
                    d7 -= d8;
                    if (k3 > i1 - 4) {
                        final double d12 = (k3 - (i1 - 4)) / 3.0f;
                        d7 = d7 * (1.0 - d12) + -10.0 * d12;
                    }
                    ad[i2] = d7;
                    ++i2;
                }
            }
        }
        return ad;
    }
    
    private void addFeatureMarker(final int cx, final int cz, final short[] blockStorage, final byte[] metaStorage) {
        final TFFeature feature = TFFeature.getFeatureDirectlyAt(cx, cz, this.worldObj);
        if (feature != TFFeature.nothing) {
            final byte featureLowNibble = (byte)(feature.featureID & 0xF);
            final byte featureHighNibble = (byte)((feature.featureID & 0xF0) >> 4);
            blockStorage[0] = (short)Block.field_71986_z.field_71990_ca;
            blockStorage[1] = (short)Block.field_71986_z.field_71990_ca;
            blockStorage[2] = (short)Block.field_71986_z.field_71990_ca;
            metaStorage[0] = featureLowNibble;
            metaStorage[1] = featureHighNibble;
            metaStorage[2] = 1;
        }
    }
    
    public void addGlaciers(final int chunkX, final int chunkZ, final short[] blocks, final byte[] meta, final BiomeGenBase[] biomes) {
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final BiomeGenBase biome = biomes[z + x * 16];
                if (biome == TFBiomeBase.glacier) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final int index = (z * 16 + x) * 128 + y;
                        final short cb = blocks[index];
                        if (cb == Block.field_71981_t.field_71990_ca) {
                            topLevel = y;
                            blocks[index] = (short)Block.field_71940_F.field_71990_ca;
                            break;
                        }
                    }
                    final int gHeight = 32;
                    for (int gTop = topLevel + gHeight + 1, y2 = topLevel + 1; y2 <= gTop && y2 < 128; ++y2) {
                        final int index2 = (z * 16 + x) * 128 + y2;
                        blocks[index2] = (short)Block.field_72036_aT.field_71990_ca;
                    }
                }
            }
        }
    }
    
    public void addDarkForestCanopy(final int chunkX, final int chunkZ, final short[] blocks, final byte[] meta, final BiomeGenBase[] biomes) {
        final double d = 0.03125;
        this.stoneNoise = this.noiseGen4.func_76304_a(this.stoneNoise, chunkX * 16, chunkZ * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final BiomeGenBase biome = biomes[z + x * 16];
                boolean generateForest = biome == TFBiomeBase.darkForest;
                if ((biome == TFBiomeBase.majorFeature || biome == TFBiomeBase.minorFeature) && z + 1 + x * 16 < biomes.length) {
                    generateForest = (biomes[z + 1 + x * 16] == TFBiomeBase.darkForest);
                }
                if (generateForest) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final int index = (z * 16 + x) * 128 + y;
                        final short currentBlock = blocks[index];
                        if (currentBlock == Block.field_71943_B.field_71990_ca) {
                            break;
                        }
                        if (currentBlock == Block.field_71981_t.field_71990_ca) {
                            topLevel = y;
                            break;
                        }
                    }
                    if (topLevel != -1) {
                        final int noise = (int)(this.stoneNoise[x + z * 16] / 2.0);
                        final int treeBottom = topLevel + 7 - noise;
                        for (int treeTop = treeBottom + 6 + noise, y2 = treeBottom; y2 <= treeTop; ++y2) {
                            final int index2 = (z * 16 + x) * 128 + y2;
                            blocks[index2] = (short)TFBlocks.hedge.field_71990_ca;
                            meta[index2] = 1;
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
        BlockSand.field_72192_a = true;
        int mapX = chunkX * 16;
        int mapY = chunkZ * 16;
        BiomeGenBase biomegenbase = this.worldObj.func_72807_a(mapX + 16, mapY + 16);
        if (biomegenbase == TFBiomeBase.majorFeature || biomegenbase == TFBiomeBase.minorFeature) {
            biomegenbase = this.worldObj.func_72807_a(mapX + 17, mapY + 17);
        }
        this.rand.setSeed(this.worldObj.func_72905_C());
        final long l1 = this.rand.nextLong() / 2L * 2L + 1L;
        final long l2 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(chunkX * l1 + chunkZ * l2 ^ this.worldObj.func_72905_C());
        boolean disableFeatures = false;
        disableFeatures |= this.majorFeatureGenerator.func_75051_a(this.worldObj, this.rand, chunkX, chunkZ);
        disableFeatures |= !TFFeature.getNearestFeature(chunkX, chunkZ, this.worldObj).chunkDecorationsEnabled;
        if (!disableFeatures && this.rand.nextInt(4) == 0) {
            final int i1 = mapX + this.rand.nextInt(16) + 8;
            final int i2 = this.rand.nextInt(TFWorld.WORLDHEIGHT);
            final int i3 = mapY + this.rand.nextInt(16) + 8;
            new WorldGenLakes(Block.field_71943_B.field_71990_ca).func_76484_a(this.worldObj, this.rand, i1, i2, i3);
        }
        if (!disableFeatures && this.rand.nextInt(32) == 0) {
            final int j1 = mapX + this.rand.nextInt(16) + 8;
            final int j2 = this.rand.nextInt(this.rand.nextInt(TFWorld.WORLDHEIGHT - 8) + 8);
            final int j3 = mapY + this.rand.nextInt(16) + 8;
            if (j2 < TFWorld.SEALEVEL || this.rand.nextInt(10) == 0) {
                new WorldGenLakes(Block.field_71938_D.field_71990_ca).func_76484_a(this.worldObj, this.rand, j1, j2, j3);
            }
        }
        for (int k1 = 0; k1 < 8; ++k1) {
            final int k2 = mapX + this.rand.nextInt(16) + 8;
            final int k3 = this.rand.nextInt(TFWorld.WORLDHEIGHT);
            final int l3 = mapY + this.rand.nextInt(16) + 8;
            if (!new WorldGenDungeons().func_76484_a(this.worldObj, this.rand, k2, k3, l3)) {}
        }
        biomegenbase.func_76728_a(this.worldObj, this.rand, mapX, mapY);
        SpawnerAnimals.func_77191_a(this.worldObj, biomegenbase, mapX + 8, mapY + 8, 16, 16, this.rand);
        mapX += 8;
        mapY += 8;
        for (int i4 = 0; i4 < 16; ++i4) {
            for (int j4 = 0; j4 < 16; ++j4) {
                final int j5 = this.worldObj.func_72874_g(mapX + i4, mapY + j4);
                if (this.worldObj.func_72884_u(i4 + mapX, j5 - 1, j4 + mapY)) {
                    this.worldObj.func_72832_d(i4 + mapX, j5 - 1, j4 + mapY, Block.field_72036_aT.field_71990_ca, 0, 2);
                }
                if (this.worldObj.func_72858_w(i4 + mapX, j5, j4 + mapY)) {
                    this.worldObj.func_72832_d(i4 + mapX, j5, j4 + mapY, Block.field_72037_aS.field_71990_ca, 0, 2);
                }
            }
        }
        BlockSand.field_72192_a = false;
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
    
    public List func_73155_a(final EnumCreatureType creatureType, final int mapX, final int mapY, final int mapZ) {
        final TFFeature nearestFeature = TFFeature.getNearestFeatureIncludeMore(mapX >> 4, mapZ >> 4, this.worldObj);
        if (nearestFeature != TFFeature.nothing) {
            final int spawnListIndex = this.majorFeatureGenerator.getSpawnListIndexAt(mapX, mapY, mapZ);
            if (spawnListIndex >= 0) {
                return nearestFeature.getSpawnableList(creatureType, spawnListIndex);
            }
        }
        if (mapY < TFWorld.SEALEVEL && creatureType == EnumCreatureType.monster) {
            return TFFeature.underground.getSpawnableList(creatureType);
        }
        final BiomeGenBase biomegenbase = this.worldObj.func_72807_a(mapX, mapZ);
        if (biomegenbase == null) {
            return null;
        }
        return biomegenbase.func_76747_a(creatureType);
    }
    
    public ChunkPosition func_73150_a(final World par1World, final String par2Str, final int par3, final int par4, final int par5) {
        return null;
    }
    
    public int func_73152_e() {
        return 0;
    }
    
    public void func_82695_e(final int var1, final int var2) {
        this.majorFeatureGenerator.func_75036_a((IChunkProvider)this, this.worldObj, var1, var2, (byte[])null);
    }
    
    public boolean func_73156_b() {
        return false;
    }
    
    public void func_104112_b() {
    }
}
