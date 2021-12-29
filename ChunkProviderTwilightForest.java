import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ChunkProviderTwilightForest implements bx
{
    private Random rand;
    private ol noiseGen1;
    private ol noiseGen2;
    private ol noiseGen3;
    private ol noiseGen4;
    public ol noiseGen5;
    public ol noiseGen6;
    public ol mobSpawnerNoise;
    private wz worldObj;
    private final boolean mapFeaturesEnabled;
    private double[] landMap;
    private double[] stoneNoise;
    private xq caveGenerator;
    public xm strongholdGenerator;
    public am villageGenerator;
    public ali mineshaftGenerator;
    private xq ravineGenerator;
    private abi[] biomesForGeneration;
    double[] noise3;
    double[] noise1;
    double[] noise2;
    double[] noise5;
    double[] noise6;
    float[] squareTable;
    int[][] unusedIntArray32x32;
    private MapGenTFTower towerGenerator;
    private MapGenTFCourtyard courtyardGenerator;
    private MapGenTFHedgeMaze hedgeMazeGenerator;
    private MapGenTFHollowHill hollowHillGenerator;
    
    public ChunkProviderTwilightForest(final wz world, final long l, final boolean flag) {
        this.stoneNoise = new double[256];
        this.caveGenerator = (xq)new ahd();
        this.strongholdGenerator = new xm();
        this.towerGenerator = new MapGenTFTower();
        this.courtyardGenerator = new MapGenTFCourtyard();
        this.hedgeMazeGenerator = new MapGenTFHedgeMaze();
        this.hollowHillGenerator = new MapGenTFHollowHill();
        this.villageGenerator = new am(0);
        this.mineshaftGenerator = new ali();
        this.ravineGenerator = new TFGenRavine();
        this.unusedIntArray32x32 = new int[32][32];
        this.worldObj = world;
        this.mapFeaturesEnabled = flag;
        this.rand = new Random(l);
        this.noiseGen1 = new ol(this.rand, 16);
        this.noiseGen2 = new ol(this.rand, 16);
        this.noiseGen3 = new ol(this.rand, 8);
        this.noiseGen4 = new ol(this.rand, 4);
        this.noiseGen5 = new ol(this.rand, 10);
        this.noiseGen6 = new ol(this.rand, 16);
        this.mobSpawnerNoise = new ol(this.rand, 8);
    }
    
    public void generateTerrain(final int par1, final int par2, final byte[] par3ArrayOfByte) {
        final byte byte0 = 4;
        final byte byte2 = 8;
        final byte byte3 = (byte)TFWorld.SEALEVEL;
        final int i = byte0 + 1;
        final byte byte4 = 9;
        final int j = byte0 + 1;
        this.biomesForGeneration = this.worldObj.i().a(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, i + 5, j + 5);
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
                                    par3ArrayOfByte[l2 += c] = (byte)ox.t.bO;
                                }
                                else if (i2 * 8 + j2 < byte3) {
                                    par3ArrayOfByte[l2 += c] = (byte)ox.B.bO;
                                }
                                else {
                                    par3ArrayOfByte[l2 += c] = 0;
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
    
    public void replaceBlocksForBiome(final int par1, final int par2, final byte[] par3ArrayOfByte, final abi[] par4ArrayOfBiomeGenBase) {
        final byte byte0 = (byte)TFWorld.SEALEVEL;
        final double d = 0.03125;
        this.stoneNoise = this.noiseGen4.a(this.stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                final abi biomegenbase = par4ArrayOfBiomeGenBase[j + i * 16];
                final float f = biomegenbase.i();
                final int k = (int)(this.stoneNoise[i + j * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int l = -1;
                byte byte2 = biomegenbase.A;
                byte byte3 = biomegenbase.B;
                for (int i2 = 127; i2 >= 0; --i2) {
                    final int j2 = (j * 16 + i) * 128 + i2;
                    if (i2 <= 0 + this.rand.nextInt(5)) {
                        par3ArrayOfByte[j2] = (byte)ox.z.bO;
                    }
                    else {
                        final byte byte4 = par3ArrayOfByte[j2];
                        if (byte4 == ox.t.bO) {
                            if (l == -1) {
                                if (k <= 0) {
                                    byte2 = 0;
                                    byte3 = (byte)ox.t.bO;
                                }
                                else if (i2 >= byte0 - 4 && i2 <= byte0 + 1) {
                                    byte2 = biomegenbase.A;
                                    byte3 = biomegenbase.B;
                                }
                                if (i2 < byte0 && byte2 == 0) {
                                    if (f < 0.15f) {
                                        byte2 = (byte)ox.aT.bO;
                                    }
                                    else {
                                        byte2 = (byte)ox.B.bO;
                                    }
                                }
                                l = k;
                                if (i2 >= byte0 - 1) {
                                    par3ArrayOfByte[j2] = byte2;
                                }
                                else {
                                    par3ArrayOfByte[j2] = byte3;
                                }
                            }
                            else if (l > 0) {
                                --l;
                                par3ArrayOfByte[j2] = byte3;
                                if (l == 0 && byte3 == ox.E.bO) {
                                    l = this.rand.nextInt(4);
                                    byte3 = (byte)ox.Q.bO;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public acf c(final int i, final int j) {
        return this.b(i, j);
    }
    
    public acf b(final int i, final int j) {
        this.rand.setSeed(i * 341873128712L + j * 132897987541L);
        final byte[] abyte0 = new byte[32768];
        this.generateTerrain(i, j, abyte0);
        this.biomesForGeneration = this.worldObj.i().b(this.biomesForGeneration, i * 16, j * 16, 16, 16);
        float[] temperature = null;
        temperature = this.worldObj.i().a(temperature, i * 16, j * 16, 16, 16);
        this.addGlaciers(i, j, abyte0, this.biomesForGeneration, temperature);
        this.raiseHills(i, j, abyte0);
        this.replaceBlocksForBiome(i, j, abyte0, this.biomesForGeneration);
        this.ravineGenerator.a((bx)this, this.worldObj, i, j, abyte0);
        if (this.mapFeaturesEnabled) {
            this.villageGenerator.a((bx)this, this.worldObj, i, j, abyte0);
            this.strongholdGenerator.a((bx)this, this.worldObj, i, j, abyte0);
            this.towerGenerator.a((bx)this, this.worldObj, i, j, abyte0);
        }
        this.hedgeMazeGenerator.a((bx)this, this.worldObj, i, j, abyte0);
        this.courtyardGenerator.a((bx)this, this.worldObj, i, j, abyte0);
        this.hollowHillGenerator.a((bx)this, this.worldObj, i, j, abyte0);
        final acf chunk = new acf(this.worldObj, abyte0, i, j);
        chunk.b();
        return chunk;
    }
    
    public void raiseHills(final int cx, final int cz, final byte[] storage) {
        if (!nearChunkFeature(cx, cz, this.worldObj)) {
            return;
        }
        final int[] chill = nearestFeatureCenter(cx, cz, this.worldObj);
        final int hsize = nearestFeatureSize(cx, cz, this.worldObj);
        final int htype = nearestFeatureType(cx, cz, this.worldObj);
        final double hdiam = (hsize * 2 + 1) * 16.0;
        final int hx = chill[0];
        final int hz = chill[1];
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                int oldGround = -1;
                int newGround = -1;
                final int dx = x - hx;
                final int dz = z - hz;
                final int dist = (int)Math.sqrt(dx * dx + dz * dz);
                final int hheight = (int)(Math.cos(dist / hdiam * 3.141592653589793) * (hdiam / 3.0));
                if (htype < 4 || htype == 8) {
                    for (int y = 0; y <= 127; ++y) {
                        final int index = (x * 16 + z) * TFWorld.WORLDHEIGHT + y;
                        final int currentTerrain = storage[index];
                        if (currentTerrain == 0 || currentTerrain == ox.aT.bO) {
                            if (newGround == -1) {
                                oldGround = y;
                                newGround = oldGround + hheight;
                            }
                            if (y <= newGround) {
                                storage[index] = (byte)ox.t.bO;
                            }
                        }
                    }
                    int hollow = hheight - 4 - hsize;
                    if (hollow < 0) {
                        hollow = 0;
                    }
                    for (int y2 = 0; y2 <= 127; ++y2) {
                        final int index2 = (x * 16 + z) * TFWorld.WORLDHEIGHT + y2;
                        if (hheight > 0 && y2 < TFWorld.SEALEVEL && storage[index2] != ox.t.bO) {
                            storage[index2] = (byte)ox.t.bO;
                        }
                        final int hollowFloor = TFWorld.SEALEVEL - 3;
                        if (y2 > hollowFloor && y2 < hollowFloor + hollow) {
                            storage[index2] = 0;
                        }
                    }
                }
                if (htype == 4 || htype == 5 || htype == 9) {
                    float squishfactor = 0.0f;
                    int mazeheight = TFWorld.SEALEVEL + 1;
                    final int FEATUREBOUNDRY = (hsize * 2 + 1) * 8 - 8;
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
                            if (currentTerrain2 != ox.t.bO) {
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
                        if (y3 < mazeheight && (storage[index3] == 0 || storage[index3] == ox.B.bO)) {
                            storage[index3] = (byte)ox.t.bO;
                        }
                        if (y3 >= mazeheight && storage[index3] != ox.B.bO) {
                            storage[index3] = 0;
                        }
                    }
                }
            }
        }
    }
    
    public static boolean nearChunkFeature(final int cx, final int cz, final wz world) {
        for (int rad = 1; rad <= 3; ++rad) {
            for (int x = -rad; x <= rad; ++x) {
                for (int z = -rad; z <= rad; ++z) {
                    if (featureSize(x + cx, z + cz, world) == rad) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static int[] nearestFeatureCenter(final int cx, final int cz, final wz world) {
        for (int rad = 1; rad <= 3; ++rad) {
            for (int x = -rad; x <= rad; ++x) {
                for (int z = -rad; z <= rad; ++z) {
                    if (featureSize(x + cx, z + cz, world) == rad) {
                        final int[] center = { x * 16 + 8, z * 16 + 8 };
                        return center;
                    }
                }
            }
        }
        final int[] no = { 0, 0 };
        return no;
    }
    
    public static boolean isHollowHill(final int cx, final int cz, final wz world) {
        final int htype = featureType(cx, cz, world);
        return htype > 0 && htype < 4;
    }
    
    public static int nearestFeatureSize(final int cx, final int cz, final wz world) {
        for (int rad = 1; rad <= 3; ++rad) {
            for (int x = -rad; x <= rad; ++x) {
                for (int z = -rad; z <= rad; ++z) {
                    if (featureSize(x + cx, z + cz, world) == rad) {
                        return rad;
                    }
                }
            }
        }
        return -1;
    }
    
    public static int nearestFeatureType(final int cx, final int cz, final wz world) {
        for (int rad = 1; rad <= 3; ++rad) {
            for (int x = -rad; x <= rad; ++x) {
                for (int z = -rad; z <= rad; ++z) {
                    if (featureSize(x + cx, z + cz, world) == rad) {
                        return featureType(x + cx, z + cz, world);
                    }
                }
            }
        }
        return -1;
    }
    
    public static int featureSize(final int cx, final int cz, final wz world) {
        final int htype = featureType(cx, cz, world);
        if (htype == 4) {
            return 2;
        }
        if (htype == 5) {
            return 3;
        }
        if (htype == 6) {
            return 1;
        }
        if (htype == 7) {
            return 1;
        }
        if (htype == 8) {
            return 2;
        }
        if (htype == 9) {
            return 3;
        }
        if (htype == 1 || htype == 2 || htype == 3) {
            return htype;
        }
        return -1;
    }
    
    public static int featureType(final int cx, final int cz, final wz world) {
        if (!((TFWorldChunkManager)world.i()).isInFeatureChunk(cx * 16, cz * 16)) {
            return -1;
        }
        final abi biomeAt = world.i().a(cx * 16 + 8, cz * 16 + 8);
        final Random hillRNG = new Random(world.v() + cx * 25117 + cz * 151121);
        final int randnum = hillRNG.nextInt(16);
        if (biomeAt == TFBiomeBase.glacier && randnum % 2 == 0) {
            return 7;
        }
        switch (randnum) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
                return 1;
            }
            case 7:
            case 8:
            case 9: {
                return 2;
            }
            case 10: {
                return 3;
            }
            case 11:
            case 12: {
                return (biomeAt != TFBiomeBase.glacier) ? 4 : -1;
            }
            case 13: {
                return (biomeAt != TFBiomeBase.glacier && biomeAt != TFBiomeBase.tfLake) ? 5 : -1;
            }
            case 14:
            case 15: {
                return 6;
            }
            default: {
                return -1;
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
                    final float f = 10.0f / gh.c(k1 * k1 + l2 * l2 + 0.2f);
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
                final abi biomegenbase = this.biomesForGeneration[k2 + 2 + (l3 + 2) * (l + 5)];
                for (int i3 = -byte0; i3 <= byte0; ++i3) {
                    for (int j3 = -byte0; j3 <= byte0; ++j3) {
                        final abi biomegenbase2 = this.biomesForGeneration[k2 + i3 + 2 + (l3 + j3 + 2) * (l + 5)];
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
    
    public void addGlaciers(final int chunkX, final int chunkZ, final byte[] storage, final abi[] biomes, final float[] temps) {
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final abi biome = biomes[z + x * 16];
                if (biome == TFBiomeBase.glacier) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final int index = (z * 16 + x) * 128 + y;
                        final byte cb = storage[index];
                        if (cb == ox.t.bO) {
                            topLevel = y;
                            storage[index] = (byte)ox.F.bO;
                            break;
                        }
                    }
                    final double t = Math.min(temps[z + x * 16], 0.1);
                    final int gHeight = 16 + (int)((0.1 - t) * 16.0);
                    for (int gTop = topLevel + gHeight + 1, y2 = topLevel + 1; y2 <= gTop && y2 < 128; ++y2) {
                        final int index2 = (z * 16 + x) * 128 + y2;
                        storage[index2] = (byte)ox.aT.bO;
                    }
                }
            }
        }
    }
    
    public boolean a(final int i, final int j) {
        return true;
    }
    
    public void a(final bx ichunkprovider, final int i, final int j) {
        yk.a = true;
        int k = i * 16;
        int l = j * 16;
        final abi biomegenbase = this.worldObj.i().a(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.v());
        final long l2 = this.rand.nextLong() / 2L * 2L + 1L;
        final long l3 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(i * l2 + j * l3 ^ this.worldObj.v());
        boolean flag = false;
        if (this.mapFeaturesEnabled) {
            this.strongholdGenerator.a(this.worldObj, this.rand, i, j);
            this.mineshaftGenerator.a(this.worldObj, this.rand, i, j);
            flag = this.villageGenerator.a(this.worldObj, this.rand, i, j);
            flag |= this.towerGenerator.a(this.worldObj, this.rand, i, j);
            flag |= this.courtyardGenerator.a(this.worldObj, this.rand, i, j);
            flag |= this.hedgeMazeGenerator.a(this.worldObj, this.rand, i, j);
            this.hollowHillGenerator.a(this.worldObj, this.rand, i, j);
        }
        flag |= (nearestFeatureType(i, j, this.worldObj) > 3);
        if (!flag && this.rand.nextInt(4) == 0) {
            final int i2 = k + this.rand.nextInt(16) + 8;
            final int i3 = this.rand.nextInt(TFWorld.WORLDHEIGHT);
            final int i4 = l + this.rand.nextInt(16) + 8;
            new cq(ox.B.bO).a(this.worldObj, this.rand, i2, i3, i4);
        }
        if (!flag && this.rand.nextInt(32) == 0) {
            final int j2 = k + this.rand.nextInt(16) + 8;
            final int j3 = this.rand.nextInt(this.rand.nextInt(TFWorld.WORLDHEIGHT - 8) + 8);
            final int j4 = l + this.rand.nextInt(16) + 8;
            if (j3 < TFWorld.SEALEVEL || this.rand.nextInt(10) == 0) {
                new cq(ox.D.bO).a(this.worldObj, this.rand, j2, j3, j4);
            }
        }
        for (int k2 = 0; k2 < 8; ++k2) {
            final int k3 = k + this.rand.nextInt(16) + 8;
            final int k4 = this.rand.nextInt(TFWorld.WORLDHEIGHT);
            final int l4 = l + this.rand.nextInt(16) + 8;
            if (!new do().a(this.worldObj, this.rand, k3, k4, l4)) {}
        }
        biomegenbase.a(this.worldObj, this.rand, k, l);
        vb.a(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        k += 8;
        l += 8;
        for (int i5 = 0; i5 < 16; ++i5) {
            for (int j5 = 0; j5 < 16; ++j5) {
                final int j6 = this.worldObj.f(k + i5, l + j5);
                if (this.worldObj.r(i5 + k, j6 - 1, j5 + l)) {
                    this.worldObj.g(i5 + k, j6 - 1, j5 + l, ox.aT.bO);
                }
                if (this.worldObj.t(i5 + k, j6, j5 + l)) {
                    this.worldObj.g(i5 + k, j6, j5 + l, ox.aS.bO);
                }
            }
        }
        yk.a = false;
    }
    
    public boolean a(final boolean flag, final rs iprogressupdate) {
        return true;
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return true;
    }
    
    public String c() {
        if (mod_TwilightForest.shouldOtherModsGenerateInTwlightForest) {
            return "RandomLevelSource";
        }
        return "TwilightLevelSource";
    }
    
    public List a(final aca par1EnumCreatureType, final int par2, final int par3, final int par4) {
        final abi biomegenbase = this.worldObj.a(par2, par4);
        if (biomegenbase == null) {
            return null;
        }
        return biomegenbase.a(par1EnumCreatureType);
    }
    
    public qk a(final wz par1World, final String par2Str, final int par3, final int par4, final int par5) {
        if ("Stronghold".equals(par2Str) && this.strongholdGenerator != null) {
            return this.strongholdGenerator.a(par1World, par3, par4, par5);
        }
        return null;
    }
}
