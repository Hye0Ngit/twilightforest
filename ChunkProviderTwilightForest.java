import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ChunkProviderTwilightForest implements cr
{
    private Random rand;
    private to noiseGen1;
    private to noiseGen2;
    private to noiseGen3;
    private to noiseGen4;
    public to noiseGen5;
    public to noiseGen6;
    public to mobSpawnerNoise;
    private fq worldObj;
    private final boolean mapFeaturesEnabled;
    private double[] landMap;
    private double[] stoneNoise;
    private gm caveGenerator;
    public gi strongholdGenerator;
    public aq villageGenerator;
    public ye mineshaftGenerator;
    private gm ravineGenerator;
    private km[] biomesForGeneration;
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
    
    public ChunkProviderTwilightForest(final fq world, final long l, final boolean flag) {
        this.stoneNoise = new double[256];
        this.caveGenerator = (gm)new sh();
        this.strongholdGenerator = new gi();
        this.towerGenerator = new MapGenTFTower();
        this.courtyardGenerator = new MapGenTFCourtyard();
        this.hedgeMazeGenerator = new MapGenTFHedgeMaze();
        this.hollowHillGenerator = new MapGenTFHollowHill();
        this.villageGenerator = new aq(0);
        this.mineshaftGenerator = new ye();
        this.ravineGenerator = (gm)new xl();
        this.unusedIntArray32x32 = new int[32][32];
        this.worldObj = world;
        this.mapFeaturesEnabled = flag;
        this.rand = new Random(l);
        this.noiseGen1 = new to(this.rand, 16);
        this.noiseGen2 = new to(this.rand, 16);
        this.noiseGen3 = new to(this.rand, 8);
        this.noiseGen4 = new to(this.rand, 4);
        this.noiseGen5 = new to(this.rand, 10);
        this.noiseGen6 = new to(this.rand, 16);
        this.mobSpawnerNoise = new to(this.rand, 8);
    }
    
    public void generateTerrain(final int i, final int j, final byte[] abyte0) {
        final byte four = 4;
        final int k = this.worldObj.c / 16;
        final int seaLevel = this.worldObj.e;
        final int i2 = four + 1;
        final int j2 = this.worldObj.c / 16 + 1;
        final int k2 = four + 1;
        this.biomesForGeneration = this.worldObj.a().a(this.biomesForGeneration, i * 4 - 2, j * 4 - 2, i2 + 5, k2 + 5);
        this.landMap = this.makeLandPerBiome(this.landMap, i * four, 0, j * four, i2, j2, k2);
        for (int l1 = 0; l1 < four; ++l1) {
            for (int i3 = 0; i3 < four; ++i3) {
                for (int j3 = 0; j3 < k; ++j3) {
                    final double d = 0.125;
                    double d2 = this.landMap[((l1 + 0) * k2 + (i3 + 0)) * j2 + (j3 + 0)];
                    double d3 = this.landMap[((l1 + 0) * k2 + (i3 + 1)) * j2 + (j3 + 0)];
                    double d4 = this.landMap[((l1 + 1) * k2 + (i3 + 0)) * j2 + (j3 + 0)];
                    double d5 = this.landMap[((l1 + 1) * k2 + (i3 + 1)) * j2 + (j3 + 0)];
                    final double d6 = (this.landMap[((l1 + 0) * k2 + (i3 + 0)) * j2 + (j3 + 1)] - d2) * d;
                    final double d7 = (this.landMap[((l1 + 0) * k2 + (i3 + 1)) * j2 + (j3 + 1)] - d3) * d;
                    final double d8 = (this.landMap[((l1 + 1) * k2 + (i3 + 0)) * j2 + (j3 + 1)] - d4) * d;
                    final double d9 = (this.landMap[((l1 + 1) * k2 + (i3 + 1)) * j2 + (j3 + 1)] - d5) * d;
                    for (int k3 = 0; k3 < 8; ++k3) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int l2 = 0; l2 < 4; ++l2) {
                            int i4 = l2 + l1 * 4 << this.worldObj.b | 0 + i3 * 4 << this.worldObj.a | j3 * 8 + k3;
                            final int j4 = 1 << this.worldObj.a;
                            i4 -= j4;
                            final double d15 = 0.25;
                            double d16 = d11;
                            final double d17 = (d12 - d11) * d15;
                            d16 -= d17;
                            for (int k4 = 0; k4 < 4; ++k4) {
                                if ((d16 += d17) > 0.0) {
                                    abyte0[i4 += j4] = (byte)ud.v.bO;
                                }
                                else if (j3 * 8 + k3 < seaLevel) {
                                    abyte0[i4 += j4] = (byte)ud.D.bO;
                                }
                                else {
                                    abyte0[i4 += j4] = 0;
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
    
    public void replaceBlocksForBiome(final int i, final int j, final byte[] storage, final km[] abiomegenbase) {
        final int seaLevel = this.worldObj.e;
        final double d = 0.03125;
        this.stoneNoise = this.noiseGen4.a(this.stoneNoise, i * 16, j * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        final float[] af = this.worldObj.a().a(i * 16, j * 16, 16, 16);
        for (int l = 0; l < 16; ++l) {
            for (int i2 = 0; i2 < 16; ++i2) {
                final float f = af[i2 + l * 16];
                final km biomegenbase = abiomegenbase[i2 + l * 16];
                final int j2 = (int)(this.stoneNoise[l + i2 * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int k1 = -1;
                byte byte0 = biomegenbase.y;
                byte byte2 = biomegenbase.z;
                for (int l2 = this.worldObj.d; l2 >= 0; --l2) {
                    final int i3 = (i2 * 16 + l) * this.worldObj.c + l2;
                    if (l2 <= 0 + this.rand.nextInt(5)) {
                        storage[i3] = (byte)ud.B.bO;
                    }
                    else {
                        final byte byte3 = storage[i3];
                        if (byte3 == 0) {
                            k1 = -1;
                        }
                        else if (byte3 == ud.v.bO) {
                            if (k1 == -1) {
                                if (j2 <= 0) {
                                    byte0 = 0;
                                    byte2 = (byte)ud.v.bO;
                                }
                                else if (l2 >= seaLevel - 4 && l2 <= seaLevel + 1) {
                                    byte0 = biomegenbase.y;
                                    byte2 = biomegenbase.z;
                                }
                                if (l2 < seaLevel && byte0 == 0) {
                                    if (f < 0.15f) {
                                        byte0 = (byte)ud.aV.bO;
                                    }
                                    else {
                                        byte0 = (byte)ud.D.bO;
                                    }
                                }
                                k1 = j2;
                                if (l2 >= seaLevel - 1) {
                                    storage[i3] = byte0;
                                }
                                else {
                                    storage[i3] = byte2;
                                }
                            }
                            else if (k1 > 0) {
                                --k1;
                                storage[i3] = byte2;
                                if (k1 == 0 && byte2 == ud.G.bO) {
                                    k1 = this.rand.nextInt(4);
                                    byte2 = (byte)ud.S.bO;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public lq c(final int i, final int j) {
        return this.b(i, j);
    }
    
    public lq b(final int i, final int j) {
        this.rand.setSeed(i * 341873128712L + j * 132897987541L);
        final byte[] abyte0 = new byte[16 * this.worldObj.c * 16];
        final lq chunk = new lq(this.worldObj, abyte0, i, j);
        this.generateTerrain(i, j, abyte0);
        this.biomesForGeneration = this.worldObj.a().b(this.biomesForGeneration, i * 16, j * 16, 16, 16);
        float[] temperature = null;
        temperature = this.worldObj.a().a(temperature, i * 16, j * 16, 16, 16);
        this.addGlaciers(i, j, abyte0, this.biomesForGeneration, temperature);
        this.raiseHills(i, j, abyte0);
        this.replaceBlocksForBiome(i, j, abyte0, this.biomesForGeneration);
        this.ravineGenerator.a((cr)this, this.worldObj, i, j, abyte0);
        if (this.mapFeaturesEnabled) {
            this.villageGenerator.a((cr)this, this.worldObj, i, j, abyte0);
            this.strongholdGenerator.a((cr)this, this.worldObj, i, j, abyte0);
            this.towerGenerator.a((cr)this, this.worldObj, i, j, abyte0);
        }
        this.hedgeMazeGenerator.a((cr)this, this.worldObj, i, j, abyte0);
        this.courtyardGenerator.a((cr)this, this.worldObj, i, j, abyte0);
        this.hollowHillGenerator.a((cr)this, this.worldObj, i, j, abyte0);
        chunk.b();
        return chunk;
    }
    
    public lq provideChunkOld(final int i, final int j) {
        this.rand.setSeed(i * 341873128712L + j * 132897987541L);
        this.worldObj.getClass();
        final byte[] abyte0 = new byte[32768];
        final lq chunk = new lq(this.worldObj, abyte0, i, j);
        this.generateTerrain(i, j, abyte0);
        this.biomesForGeneration = this.worldObj.a().b(this.biomesForGeneration, i * 16, j * 16, 16, 16);
        float[] temperature = null;
        temperature = this.worldObj.a().a(temperature, i * 16, j * 16, 16, 16);
        this.addGlaciers(i, j, abyte0, this.biomesForGeneration, temperature);
        this.raiseHills(i, j, abyte0);
        this.replaceBlocksForBiome(i, j, abyte0, this.biomesForGeneration);
        if (this.mapFeaturesEnabled) {
            this.strongholdGenerator.a((cr)this, this.worldObj, i, j, abyte0);
            this.villageGenerator.a((cr)this, this.worldObj, i, j, abyte0);
            this.towerGenerator.a((cr)this, this.worldObj, i, j, abyte0);
        }
        this.ravineGenerator.a((cr)this, this.worldObj, i, j, abyte0);
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
                    for (int y = 0; y <= this.worldObj.d; ++y) {
                        final int index = (x * 16 + z) * this.worldObj.c + y;
                        final int currentTerrain = storage[index];
                        if (currentTerrain == 0 || currentTerrain == ud.aV.bO) {
                            if (newGround == -1) {
                                oldGround = y;
                                newGround = oldGround + hheight;
                            }
                            if (y <= newGround) {
                                storage[index] = (byte)ud.v.bO;
                            }
                        }
                    }
                    int hollow = hheight - 4 - hsize;
                    if (hollow < 0) {
                        hollow = 0;
                    }
                    for (int y2 = 0; y2 <= this.worldObj.d; ++y2) {
                        final int index2 = (x * 16 + z) * this.worldObj.c + y2;
                        if (hheight > 0 && y2 < this.worldObj.e && storage[index2] != ud.v.bO) {
                            storage[index2] = (byte)ud.v.bO;
                        }
                        final int hollowFloor = this.worldObj.e - 3;
                        if (y2 > hollowFloor && y2 < hollowFloor + hollow) {
                            storage[index2] = 0;
                        }
                    }
                }
                if (htype == 4 || htype == 5 || htype == 9) {
                    float squishfactor = 0.0f;
                    int mazeheight = this.worldObj.e + 1;
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
                        for (int y3 = 0; y3 <= this.worldObj.d; ++y3) {
                            final int index3 = (x * 16 + z) * this.worldObj.c + y3;
                            final int currentTerrain2 = storage[index3];
                            if (currentTerrain2 != ud.v.bO) {
                                if (newGround == -1) {
                                    oldGround = y3;
                                    mazeheight += (int)((oldGround - mazeheight) * squishfactor);
                                    newGround = oldGround;
                                }
                            }
                        }
                    }
                    for (int y3 = 0; y3 <= this.worldObj.d; ++y3) {
                        final int index3 = (x * 16 + z) * this.worldObj.c + y3;
                        if (y3 < mazeheight && (storage[index3] == 0 || storage[index3] == ud.D.bO)) {
                            storage[index3] = (byte)ud.v.bO;
                        }
                        if (y3 >= mazeheight && storage[index3] != ud.D.bO) {
                            storage[index3] = 0;
                        }
                    }
                }
            }
        }
    }
    
    public static boolean nearChunkFeature(final int cx, final int cz, final fq world) {
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
    
    public static int[] nearestFeatureCenter(final int cx, final int cz, final fq world) {
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
    
    public static boolean isHollowHill(final int cx, final int cz, final fq world) {
        final int htype = featureType(cx, cz, world);
        return htype > 0 && htype < 4;
    }
    
    public static int nearestFeatureSize(final int cx, final int cz, final fq world) {
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
    
    public static int nearestFeatureType(final int cx, final int cz, final fq world) {
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
    
    public static int featureSize(final int cx, final int cz, final fq world) {
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
    
    public static int featureType(final int cx, final int cz, final fq world) {
        final km biomeAt = world.a().a(cx * 16 + 8, cz * 16 + 8);
        if (biomeAt == km.b || biomeAt == TFBiomeBase.tfOcean) {
            return -1;
        }
        if ((cx % 7 != 4 && cx % 7 != -4) || (cz % 7 != 4 && cz % 7 != -4)) {
            return -1;
        }
        final Random hillRNG = new Random(world.m() + cx * 25117 + cz * 151121);
        final int randnum = hillRNG.nextInt(41);
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
                return 5;
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
                    final float f = 10.0f / iy.c(k1 * k1 + l2 * l2 + 0.2f);
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
                final km biomegenbase = this.biomesForGeneration[k2 + 2 + (l3 + 2) * (l + 5)];
                for (int i3 = -byte0; i3 <= byte0; ++i3) {
                    for (int j3 = -byte0; j3 <= byte0; ++j3) {
                        final km biomegenbase2 = this.biomesForGeneration[k2 + i3 + 2 + (l3 + j3 + 2) * (l + 5)];
                        float f5 = this.squareTable[i3 + 2 + (j3 + 2) * 5] / (biomegenbase2.B + 2.0f);
                        if (biomegenbase2.B > biomegenbase.B) {
                            f5 /= 2.0f;
                        }
                        f2 += biomegenbase2.C * f5;
                        f3 += biomegenbase2.B * f5;
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
                    double d8 = (k3 - d6) * 12.0 * 128.0 / this.worldObj.c / d5;
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
    
    public void addGlaciers(final int chunkX, final int chunkY, final byte[] storage, final km[] biomes, final float[] temps) {
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final km biome = biomes[z + x * 16];
                if (biome == TFBiomeBase.glacier) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final int index = (z * 16 + x) * 128 + y;
                        final byte cb = storage[index];
                        if (cb == ud.v.bO) {
                            topLevel = y;
                            storage[index] = (byte)ud.H.bO;
                            break;
                        }
                    }
                    final double t = Math.min(temps[z + x * 16], 0.1);
                    final int gHeight = 16 + (int)((0.1 - t) * 16.0);
                    for (int gTop = topLevel + gHeight + 1, y2 = topLevel + 1; y2 <= gTop && y2 < 128; ++y2) {
                        final int index2 = (z * 16 + x) * 128 + y2;
                        storage[index2] = (byte)ud.aV.bO;
                    }
                }
            }
        }
    }
    
    public boolean a(final int i, final int j) {
        return true;
    }
    
    public void a(final cr ichunkprovider, final int i, final int j) {
        hf.a = true;
        int k = i * 16;
        int l = j * 16;
        final km biomegenbase = this.worldObj.a().a(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.m());
        final long l2 = this.rand.nextLong() / 2L * 2L + 1L;
        final long l3 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(i * l2 + j * l3 ^ this.worldObj.m());
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
            final int i3 = this.rand.nextInt(this.worldObj.c);
            final int i4 = l + this.rand.nextInt(16) + 8;
            new dr(ud.D.bO).a(this.worldObj, this.rand, i2, i3, i4);
        }
        if (!flag && this.rand.nextInt(32) == 0) {
            final int j2 = k + this.rand.nextInt(16) + 8;
            final int j3 = this.rand.nextInt(this.rand.nextInt(this.worldObj.c - 8) + 8);
            final int j4 = l + this.rand.nextInt(16) + 8;
            if (j3 < this.worldObj.e || this.rand.nextInt(10) == 0) {
                new dr(ud.F.bO).a(this.worldObj, this.rand, j2, j3, j4);
            }
        }
        for (int k2 = 0; k2 < 8; ++k2) {
            final int k3 = k + this.rand.nextInt(16) + 8;
            final int k4 = this.rand.nextInt(this.worldObj.c);
            final int l4 = l + this.rand.nextInt(16) + 8;
            if (!new fc().a(this.worldObj, this.rand, k3, k4, l4)) {}
        }
        biomegenbase.a(this.worldObj, this.rand, k, l);
        cx.a(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        k += 8;
        l += 8;
        for (int i5 = 0; i5 < 16; ++i5) {
            for (int j5 = 0; j5 < 16; ++j5) {
                final int j6 = this.worldObj.e(k + i5, l + j5);
                if (this.worldObj.p(i5 + k, j6 - 1, j5 + l)) {
                    this.worldObj.e(i5 + k, j6 - 1, j5 + l, ud.aV.bO);
                }
                if (this.worldObj.r(i5 + k, j6, j5 + l)) {
                    this.worldObj.e(i5 + k, j6, j5 + l, ud.aU.bO);
                }
            }
        }
        hf.a = false;
    }
    
    public boolean a(final boolean flag, final yi iprogressupdate) {
        return true;
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return true;
    }
    
    public String makeString() {
        if (mod_TwilightForest.shouldOtherModsGenerateInTwlightForest) {
            return "RandomLevelSource";
        }
        return "TwilightLevelSource";
    }
    
    public List a(final ln enumcreaturetype, final int i, final int j, final int k) {
        final yc worldchunkmanager = this.worldObj.a();
        if (worldchunkmanager == null) {
            return null;
        }
        final km biomegenbase = worldchunkmanager.a(new zg(i >> 4, k >> 4));
        if (biomegenbase == null) {
            return null;
        }
        return biomegenbase.a(enumcreaturetype);
    }
    
    public wk a(final fq world, final String s, final int i, final int j, final int k) {
        if ("Stronghold".equals(s) && this.strongholdGenerator != null) {
            return this.strongholdGenerator.a(world, i, j, k);
        }
        return null;
    }
}
