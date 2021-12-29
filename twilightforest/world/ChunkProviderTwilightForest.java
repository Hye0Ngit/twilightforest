// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.List;
import twilightforest.block.TFBlocks;
import twilightforest.TFFeature;
import twilightforest.biomes.TFBiomeBase;
import java.util.Random;

public class ChunkProviderTwilightForest implements abn
{
    private Random rand;
    private ahq noiseGen1;
    private ahq noiseGen2;
    private ahq noiseGen3;
    private ahq noiseGen4;
    public ahq noiseGen5;
    public ahq noiseGen6;
    public ahq mobSpawnerNoise;
    private zv worldObj;
    private final boolean mapFeaturesEnabled;
    private double[] landMap;
    private double[] stoneNoise;
    private TFGenCaves caveGenerator;
    private TFGenRavine ravineGenerator;
    private aap[] biomesForGeneration;
    double[] noise3;
    double[] noise1;
    double[] noise2;
    double[] noise5;
    double[] noise6;
    float[] squareTable;
    int[][] unusedIntArray32x32;
    private MapGenTFMajorFeature majorFeatureGenerator;
    
    public ChunkProviderTwilightForest(final zv world, final long l, final boolean flag) {
        this.stoneNoise = new double[256];
        this.caveGenerator = new TFGenCaves();
        this.majorFeatureGenerator = new MapGenTFMajorFeature();
        this.ravineGenerator = new TFGenRavine();
        this.unusedIntArray32x32 = new int[32][32];
        this.worldObj = world;
        this.mapFeaturesEnabled = flag;
        this.rand = new Random(l);
        this.noiseGen1 = new ahq(this.rand, 16);
        this.noiseGen2 = new ahq(this.rand, 16);
        this.noiseGen3 = new ahq(this.rand, 8);
        this.noiseGen4 = new ahq(this.rand, 4);
        this.noiseGen5 = new ahq(this.rand, 10);
        this.noiseGen6 = new ahq(this.rand, 16);
        this.mobSpawnerNoise = new ahq(this.rand, 8);
    }
    
    public void generateTerrain(final int par1, final int par2, final short[] par3ArrayofShort) {
        final byte byte0 = 4;
        final byte byte2 = 8;
        final byte byte3 = (byte)TFWorld.SEALEVEL;
        final int i = byte0 + 1;
        final byte byte4 = 9;
        final int j = byte0 + 1;
        this.biomesForGeneration = this.worldObj.t().a(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, i + 5, j + 5);
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
                                    par3ArrayofShort[l2 += c] = (short)aou.x.cz;
                                }
                                else if (i2 * 8 + j2 < byte3) {
                                    par3ArrayofShort[l2 += c] = (short)aou.F.cz;
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
    
    public void replaceBlocksForBiome(final int par1, final int par2, final short[] blockArray4096, final aap[] par4ArrayOfBiomeGenBase) {
        final byte sealevel = (byte)TFWorld.SEALEVEL;
        final double d = 0.03125;
        this.stoneNoise = this.noiseGen4.a(this.stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                aap biomegenbase = par4ArrayOfBiomeGenBase[j + i * 16];
                if (biomegenbase == null) {
                    biomegenbase = TFBiomeBase.twilightForest;
                }
                final float f = biomegenbase.j();
                final int k = (int)(this.stoneNoise[i + j * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int l = -1;
                short top = biomegenbase.A;
                short filler = biomegenbase.B;
                for (int i2 = 127; i2 >= 0; --i2) {
                    final int j2 = (j * 16 + i) * 128 + i2;
                    if (i2 <= 0 + this.rand.nextInt(5)) {
                        blockArray4096[j2] = (short)aou.D.cz;
                    }
                    else {
                        final short currentBlock = blockArray4096[j2];
                        if (currentBlock == aou.x.cz) {
                            if (l == -1) {
                                if (k <= 0) {
                                    top = 0;
                                    filler = (short)aou.x.cz;
                                }
                                else if (i2 >= sealevel - 4 && i2 <= sealevel + 1) {
                                    top = biomegenbase.A;
                                    filler = biomegenbase.B;
                                }
                                if (i2 < sealevel && top == 0) {
                                    if (f < 0.15f) {
                                        top = (short)aou.aX.cz;
                                    }
                                    else {
                                        top = (short)aou.F.cz;
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
                                if (l == 0 && filler == aou.I.cz) {
                                    l = this.rand.nextInt(4);
                                    filler = (short)aou.U.cz;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public abq c(final int i, final int j) {
        return this.d(i, j);
    }
    
    public abq d(final int cx, final int cz) {
        this.rand.setSeed(cx * 341873128712L + cz * 132897987541L);
        final short[] blockStorage = new short[32768];
        final byte[] metaStorage = new byte[32768];
        this.generateTerrain(cx, cz, blockStorage);
        this.addGlaciers(cx, cz, blockStorage, metaStorage, this.biomesForGeneration = this.worldObj.t().b(this.biomesForGeneration, cx * 16, cz * 16, 16, 16));
        this.raiseHills(cx, cz, blockStorage);
        this.addDarkForestCanopy(cx, cz, blockStorage, metaStorage, this.biomesForGeneration);
        this.replaceBlocksForBiome(cx, cz, blockStorage, this.biomesForGeneration);
        this.addFeatureMarker(cx, cz, blockStorage, metaStorage);
        this.caveGenerator.generate((abn)this, this.worldObj, cx, cz, blockStorage);
        this.ravineGenerator.generate((abn)this, this.worldObj, cx, cz, blockStorage);
        final byte[] fake = new byte[0];
        this.majorFeatureGenerator.a((abn)this, this.worldObj, cx, cz, fake);
        final abq chunk = this.makeAChunk(this.worldObj, blockStorage, metaStorage, cx, cz);
        final byte[] chunkBiomes = chunk.m();
        for (int i = 0; i < chunkBiomes.length; ++i) {
            chunkBiomes[i] = (byte)this.biomesForGeneration[i].N;
        }
        chunk.b();
        return chunk;
    }
    
    protected abq makeAChunk(final zv world, final short[] ids, final byte[] metadata, final int chunkX, final int chunkZ) {
        final abq chunk = new abq(world, chunkX, chunkZ);
        final abr[] storageArrays = chunk.i();
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
                            storageArrays[storageIndex] = new abr(storageIndex << 4, true);
                        }
                        storageArrays[storageIndex].a(x, y & 0xF, z, id);
                        storageArrays[storageIndex].b(x, y & 0xF, z, meta);
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
                        if (currentTerrain == 0 || currentTerrain == aou.aX.cz) {
                            if (newGround == -1) {
                                oldGround = y;
                                newGround = oldGround + hheight;
                            }
                            if (y <= newGround) {
                                storage[index] = (short)aou.x.cz;
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
                        if (hheight > 0 && y2 < TFWorld.SEALEVEL && storage[index2] != aou.x.cz) {
                            storage[index2] = (short)aou.x.cz;
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
                            if (currentTerrain2 != aou.x.cz) {
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
                        if (y3 < mazeheight && (storage[index3] == 0 || storage[index3] == aou.F.cz)) {
                            storage[index3] = (short)aou.x.cz;
                        }
                        if (y3 >= mazeheight && storage[index3] != aou.F.cz) {
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
                    final float f = 10.0f / kx.c(k1 * k1 + l2 * l2 + 0.2f);
                    this.squareTable[k1 + 2 + (l2 + 2) * 5] = f;
                }
            }
        }
        final double d = 684.412;
        final double d2 = 684.412;
        this.noise5 = this.noiseGen5.a(this.noise5, xx, zz, l, j1, 1.121, 1.121, 0.5);
        this.noise6 = this.noiseGen6.a(this.noise6, xx, zz, l, j1, 200.0, 200.0, 0.5);
        this.noise3 = this.noiseGen3.a(this.noise3, xx, zero, zz, l, i1, j1, d / 80.0, d2 / 160.0, d / 80.0);
        this.noise1 = this.noiseGen1.a(this.noise1, xx, zero, zz, l, i1, j1, d, d2, d);
        this.noise2 = this.noiseGen2.a(this.noise2, xx, zero, zz, l, i1, j1, d, d2, d);
        zz = (xx = 0);
        int i2 = 0;
        int j2 = 0;
        for (int k2 = 0; k2 < l; ++k2) {
            for (int l3 = 0; l3 < j1; ++l3) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                final byte byte0 = 2;
                final aap biomegenbase = this.biomesForGeneration[k2 + 2 + (l3 + 2) * (l + 5)];
                for (int i3 = -byte0; i3 <= byte0; ++i3) {
                    for (int j3 = -byte0; j3 <= byte0; ++j3) {
                        final aap biomegenbase2 = this.biomesForGeneration[k2 + i3 + 2 + (l3 + j3 + 2) * (l + 5)];
                        float f5 = this.squareTable[i3 + 2 + (j3 + 2) * 5] / (biomegenbase2.D + 2.0f);
                        if (biomegenbase2.D > biomegenbase.D) {
                            f5 /= 2.0f;
                        }
                        f2 += biomegenbase2.E * f5;
                        f3 += biomegenbase2.D * f5;
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
            blockStorage[0] = (short)aou.D.cz;
            blockStorage[1] = (short)aou.D.cz;
            blockStorage[2] = (short)aou.D.cz;
            metaStorage[0] = featureLowNibble;
            metaStorage[1] = featureHighNibble;
            metaStorage[2] = 1;
        }
    }
    
    public void addGlaciers(final int chunkX, final int chunkZ, final short[] blocks, final byte[] meta, final aap[] biomes) {
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final aap biome = biomes[z + x * 16];
                if (biome == TFBiomeBase.glacier) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final int index = (z * 16 + x) * 128 + y;
                        final short cb = blocks[index];
                        if (cb == aou.x.cz) {
                            topLevel = y;
                            blocks[index] = (short)aou.J.cz;
                            break;
                        }
                    }
                    final int gHeight = 32;
                    for (int gTop = topLevel + gHeight + 1, y2 = topLevel + 1; y2 <= gTop && y2 < 128; ++y2) {
                        final int index2 = (z * 16 + x) * 128 + y2;
                        blocks[index2] = (short)aou.aX.cz;
                    }
                }
            }
        }
    }
    
    public void addDarkForestCanopy(final int chunkX, final int chunkZ, final short[] blocks, final byte[] meta, final aap[] biomes) {
        final double d = 0.03125;
        this.stoneNoise = this.noiseGen4.a(this.stoneNoise, chunkX * 16, chunkZ * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final aap biome = biomes[z + x * 16];
                boolean generateForest = biome == TFBiomeBase.darkForest;
                if ((biome == TFBiomeBase.majorFeature || biome == TFBiomeBase.minorFeature) && z + 1 + x * 16 < biomes.length) {
                    generateForest = (biomes[z + 1 + x * 16] == TFBiomeBase.darkForest);
                }
                if (generateForest) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final int index = (z * 16 + x) * 128 + y;
                        final short currentBlock = blocks[index];
                        if (currentBlock == aou.F.cz) {
                            break;
                        }
                        if (currentBlock == aou.x.cz) {
                            topLevel = y;
                            break;
                        }
                    }
                    if (topLevel != -1) {
                        final int noise = (int)(this.stoneNoise[x + z * 16] / 2.0);
                        final int treeBottom = topLevel + 7 - noise;
                        for (int treeTop = treeBottom + 6 + noise, y2 = treeBottom; y2 <= treeTop; ++y2) {
                            final int index2 = (z * 16 + x) * 128 + y2;
                            blocks[index2] = (short)TFBlocks.hedge.cz;
                            meta[index2] = 1;
                        }
                    }
                }
            }
        }
    }
    
    public boolean a(final int i, final int j) {
        return true;
    }
    
    public void a(final abn ichunkprovider, final int chunkX, final int chunkZ) {
        amn.c = true;
        int mapX = chunkX * 16;
        int mapY = chunkZ * 16;
        aap biomegenbase = this.worldObj.a(mapX + 16, mapY + 16);
        if (biomegenbase == TFBiomeBase.majorFeature || biomegenbase == TFBiomeBase.minorFeature) {
            biomegenbase = this.worldObj.a(mapX + 17, mapY + 17);
        }
        this.rand.setSeed(this.worldObj.F());
        final long l1 = this.rand.nextLong() / 2L * 2L + 1L;
        final long l2 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(chunkX * l1 + chunkZ * l2 ^ this.worldObj.F());
        boolean disableFeatures = false;
        if (this.mapFeaturesEnabled) {
            disableFeatures |= this.majorFeatureGenerator.a(this.worldObj, this.rand, chunkX, chunkZ);
        }
        disableFeatures |= !TFFeature.getNearestFeature(chunkX, chunkZ, this.worldObj).chunkDecorationsEnabled;
        if (!disableFeatures && this.rand.nextInt(4) == 0) {
            final int i1 = mapX + this.rand.nextInt(16) + 8;
            final int i2 = this.rand.nextInt(TFWorld.WORLDHEIGHT);
            final int i3 = mapY + this.rand.nextInt(16) + 8;
            new adl(aou.F.cz).a(this.worldObj, this.rand, i1, i2, i3);
        }
        if (!disableFeatures && this.rand.nextInt(32) == 0) {
            final int j1 = mapX + this.rand.nextInt(16) + 8;
            final int j2 = this.rand.nextInt(this.rand.nextInt(TFWorld.WORLDHEIGHT - 8) + 8);
            final int j3 = mapY + this.rand.nextInt(16) + 8;
            if (j2 < TFWorld.SEALEVEL || this.rand.nextInt(10) == 0) {
                new adl(aou.H.cz).a(this.worldObj, this.rand, j1, j2, j3);
            }
        }
        for (int k1 = 0; k1 < 8; ++k1) {
            final int k2 = mapX + this.rand.nextInt(16) + 8;
            final int k3 = this.rand.nextInt(TFWorld.WORLDHEIGHT);
            final int l3 = mapY + this.rand.nextInt(16) + 8;
            if (!new ado().a(this.worldObj, this.rand, k2, k3, l3)) {}
        }
        biomegenbase.a(this.worldObj, this.rand, mapX, mapY);
        aah.a(this.worldObj, biomegenbase, mapX + 8, mapY + 8, 16, 16, this.rand);
        mapX += 8;
        mapY += 8;
        for (int i4 = 0; i4 < 16; ++i4) {
            for (int j4 = 0; j4 < 16; ++j4) {
                final int j5 = this.worldObj.h(mapX + i4, mapY + j4);
                if (this.worldObj.x(i4 + mapX, j5 - 1, j4 + mapY)) {
                    this.worldObj.f(i4 + mapX, j5 - 1, j4 + mapY, aou.aX.cz, 0, 2);
                }
                if (this.worldObj.z(i4 + mapX, j5, j4 + mapY)) {
                    this.worldObj.f(i4 + mapX, j5, j4 + mapY, aou.aW.cz, 0, 2);
                }
            }
        }
        amn.c = false;
    }
    
    public boolean a(final boolean flag, final lc iprogressupdate) {
        return true;
    }
    
    public boolean c() {
        return true;
    }
    
    public String d() {
        return "TwilightLevelSource";
    }
    
    public List a(final nh creatureType, final int mapX, final int mapY, final int mapZ) {
        final TFFeature nearestFeature = TFFeature.getNearestFeatureIncludeMore(mapX >> 4, mapZ >> 4, this.worldObj);
        if (nearestFeature != TFFeature.nothing) {
            final int spawnListIndex = this.majorFeatureGenerator.getSpawnListIndexAt(mapX, mapY, mapZ);
            if (spawnListIndex >= 0) {
                return nearestFeature.getSpawnableList(creatureType, spawnListIndex);
            }
        }
        if (mapY < TFWorld.SEALEVEL && creatureType == nh.a) {
            return TFFeature.underground.getSpawnableList(creatureType);
        }
        final aap biomegenbase = this.worldObj.a(mapX, mapZ);
        if (biomegenbase == null) {
            return null;
        }
        return biomegenbase.a(creatureType);
    }
    
    public aan a(final zv par1World, final String par2Str, final int par3, final int par4, final int par5) {
        return null;
    }
    
    public int e() {
        return 0;
    }
    
    public void e(final int var1, final int var2) {
        this.majorFeatureGenerator.a((abn)this, this.worldObj, var1, var2, (byte[])null);
    }
    
    public boolean b() {
        return false;
    }
}
