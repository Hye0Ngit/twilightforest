import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ChunkProviderTwilightForest implements ej
{
    public static final int ARENAHEIGHT = 31;
    private MapGenTFTower towerGenerator;
    private MapGenTFHollowTree hollowTreeGenerator;
    private Random rand;
    private eb field_912_k;
    private eb field_911_l;
    private eb field_910_m;
    private eb field_908_o;
    public eb field_922_a;
    public eb field_921_b;
    public eb mobSpawnerNoise;
    private ry worldObj;
    private final boolean mapFeaturesEnabled;
    private double[] landMap;
    private double[] stoneNoise;
    private bz caveGenerator;
    public MapGenTFStronghold strongholdGenerator;
    public xn villageGenerator;
    public kd mineshaftGenerator;
    private bz ravineGenerator;
    private sr[] biomesForGeneration;
    double[] field_4185_d;
    double[] field_4184_e;
    double[] field_4183_f;
    double[] field_4182_g;
    double[] field_4181_h;
    float[] squareTable;
    int[][] unusedIntArray32x32;
    
    public ChunkProviderTwilightForest(final ry world, final long l, final boolean flag) {
        this.stoneNoise = new double[256];
        this.caveGenerator = (bz)new ln();
        this.strongholdGenerator = new MapGenTFStronghold();
        this.towerGenerator = new MapGenTFTower();
        this.hollowTreeGenerator = new MapGenTFHollowTree();
        this.villageGenerator = new xn();
        this.mineshaftGenerator = new kd();
        this.ravineGenerator = (bz)new rf();
        this.unusedIntArray32x32 = new int[32][32];
        this.worldObj = world;
        this.mapFeaturesEnabled = flag;
        this.rand = new Random(l);
        this.field_912_k = new eb(this.rand, 16);
        this.field_911_l = new eb(this.rand, 16);
        this.field_910_m = new eb(this.rand, 8);
        this.field_908_o = new eb(this.rand, 4);
        this.field_922_a = new eb(this.rand, 10);
        this.field_921_b = new eb(this.rand, 16);
        this.mobSpawnerNoise = new eb(this.rand, 8);
    }
    
    public void generateTerrain(final int chunkX, final int chunkZ, final byte[] abyte0) {
        final byte four = 4;
        this.worldObj.getClass();
        final int k = 7;
        this.worldObj.getClass();
        final byte seaLevel = 30;
        final int five = four + 1;
        this.worldObj.getClass();
        final int seventeen = 8;
        final int fivee = four + 1;
        this.biomesForGeneration = this.worldObj.a().b(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, five + 5, fivee + 5);
        this.landMap = this.makeLandPerBiome(this.landMap, chunkX * four, 0, chunkZ * four, five, seventeen, fivee);
        for (int k2 = 0; k2 < four; ++k2) {
            for (int l1 = 0; l1 < four; ++l1) {
                for (int i2 = 0; i2 < k; ++i2) {
                    final double d = 0.125;
                    double d2 = this.landMap[((k2 + 0) * fivee + (l1 + 0)) * seventeen + (i2 + 0)];
                    double d3 = this.landMap[((k2 + 0) * fivee + (l1 + 1)) * seventeen + (i2 + 0)];
                    double d4 = this.landMap[((k2 + 1) * fivee + (l1 + 0)) * seventeen + (i2 + 0)];
                    double d5 = this.landMap[((k2 + 1) * fivee + (l1 + 1)) * seventeen + (i2 + 0)];
                    final double d6 = (this.landMap[((k2 + 0) * fivee + (l1 + 0)) * seventeen + (i2 + 1)] - d2) * d;
                    final double d7 = (this.landMap[((k2 + 0) * fivee + (l1 + 1)) * seventeen + (i2 + 1)] - d3) * d;
                    final double d8 = (this.landMap[((k2 + 1) * fivee + (l1 + 0)) * seventeen + (i2 + 1)] - d4) * d;
                    final double d9 = (this.landMap[((k2 + 1) * fivee + (l1 + 1)) * seventeen + (i2 + 1)] - d5) * d;
                    for (int j2 = 0; j2 < 8; ++j2) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int k3 = 0; k3 < 4; ++k3) {
                            this.worldObj.getClass();
                            this.worldObj.getClass();
                            int l2 = k3 + k2 * 4 << 11 | 0 + l1 * 4 << 7 | i2 * 8 + j2;
                            this.worldObj.getClass();
                            final int i3 = 128;
                            final double d15 = 0.25;
                            double d16 = d11;
                            final double d17 = (d12 - d11) * d15;
                            for (int j3 = 0; j3 < 4; ++j3) {
                                int k4 = 0;
                                if (i2 * 8 + j2 < seaLevel) {
                                    k4 = yy.B.bM;
                                }
                                if (d16 > 0.0) {
                                    k4 = yy.t.bM;
                                }
                                abyte0[l2] = (byte)k4;
                                l2 += i3;
                                d16 += d17;
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
    
    public void replaceBlocksForBiome(final int i, final int j, final byte[] abyte0, final sr[] abiomegenbase) {
        this.worldObj.getClass();
        final byte seaLevel = 30;
        final double d = 0.03125;
        this.stoneNoise = this.field_908_o.a(this.stoneNoise, i * 16, j * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                final sr biomegenbase = abiomegenbase[l + k * 16];
                final int makeStone = (int)(this.stoneNoise[k + l * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int dirtLevel = -1;
                byte byte1 = biomegenbase.t;
                byte byte2 = biomegenbase.u;
                this.worldObj.getClass();
                for (int cHeight = 127; cHeight >= 0; --cHeight) {
                    this.worldObj.getClass();
                    final int l2 = (l * 16 + k) * 128 + cHeight;
                    if (cHeight <= 0 + this.rand.nextInt(5)) {
                        abyte0[l2] = (byte)yy.z.bM;
                    }
                    else {
                        final byte currentBlockID = abyte0[l2];
                        if (currentBlockID == 0) {
                            dirtLevel = -1;
                        }
                        else if (currentBlockID == yy.t.bM) {
                            if (dirtLevel == -1) {
                                if (makeStone <= 0) {
                                    byte1 = 0;
                                    byte2 = (byte)yy.t.bM;
                                }
                                else if (cHeight >= seaLevel - 4 && cHeight <= seaLevel + 1) {
                                    byte1 = biomegenbase.t;
                                    byte2 = biomegenbase.u;
                                }
                                if (cHeight < seaLevel && byte1 == 0) {
                                    byte1 = (byte)yy.B.bM;
                                }
                                dirtLevel = makeStone;
                                if (cHeight >= seaLevel - 1) {
                                    abyte0[l2] = byte1;
                                }
                                else {
                                    abyte0[l2] = byte2;
                                }
                            }
                            else if (dirtLevel > 0) {
                                --dirtLevel;
                                abyte0[l2] = byte2;
                                if (dirtLevel == 0 && byte2 == yy.E.bM) {
                                    dirtLevel = this.rand.nextInt(4);
                                    byte2 = (byte)yy.Q.bM;
                                }
                                if (dirtLevel == 0) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public zx a(final int i, final int j) {
        return this.b(i, j);
    }
    
    public zx b(final int i, final int j) {
        this.rand.setSeed(i * 341873128712L + j * 132897987541L);
        this.worldObj.getClass();
        final byte[] abyte0 = new byte[32768];
        final zx chunk = new zx(this.worldObj, abyte0, i, j);
        this.generateTerrain(i, j, abyte0);
        this.biomesForGeneration = this.worldObj.a().a(this.biomesForGeneration, i * 16, j * 16, 16, 16);
        float[] temperature = null;
        temperature = this.worldObj.a().a(temperature, i * 16, j * 16, 16, 16);
        this.addGlaciers(i, j, abyte0, this.biomesForGeneration, temperature);
        this.raiseHills(i, j, abyte0);
        this.replaceBlocksForBiome(i, j, abyte0, this.biomesForGeneration);
        if (this.mapFeaturesEnabled) {
            this.strongholdGenerator.a((ej)this, this.worldObj, i, j, abyte0);
            this.villageGenerator.a((ej)this, this.worldObj, i, j, abyte0);
            this.towerGenerator.a((ej)this, this.worldObj, i, j, abyte0);
        }
        this.ravineGenerator.a((ej)this, this.worldObj, i, j, abyte0);
        chunk.c();
        return chunk;
    }
    
    public void terraform(final int cx, final int cz, final byte[] storage) {
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final double squishMultiplier = 0.5;
                int oldGround = -1;
                int newGround = -1;
                for (int y = 127; y >= 0; --y) {
                    final int index = (x * 16 + z) * 128 + y;
                    final byte currentTerrain = storage[index];
                    if (currentTerrain != 0) {
                        if (newGround == -1) {
                            oldGround = y;
                            newGround = (int)(oldGround * squishMultiplier);
                        }
                        if (y >= newGround) {
                            storage[index] = 0;
                        }
                    }
                }
            }
        }
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
                        final int index = (x * 16 + z) * 128 + y;
                        final int currentTerrain = storage[index];
                        if (currentTerrain == 0 || currentTerrain == yy.aT.bM) {
                            if (newGround == -1) {
                                oldGround = y;
                                newGround = oldGround + hheight;
                            }
                            if (y <= newGround) {
                                storage[index] = (byte)yy.t.bM;
                            }
                        }
                    }
                    int hollow = hheight - 4 - hsize;
                    if (hollow < 0) {
                        hollow = 0;
                    }
                    if (htype == 4) {
                        hollow = 100;
                    }
                    for (int y2 = 0; y2 <= 127; ++y2) {
                        final int index2 = (x * 16 + z) * 128 + y2;
                        if (hheight > 0 && y2 < 30 && storage[index2] != yy.t.bM) {
                            storage[index2] = (byte)yy.t.bM;
                        }
                        if (y2 > 28 && y2 < 28 + hollow) {
                            storage[index2] = 0;
                        }
                    }
                }
                if (htype == 4 || htype == 5 || htype == 9) {
                    float squishfactor = 0.0f;
                    int mazeheight = 31;
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
                            final int index3 = (x * 16 + z) * 128 + y3;
                            final int currentTerrain2 = storage[index3];
                            if (currentTerrain2 != yy.t.bM) {
                                if (newGround == -1) {
                                    oldGround = y3;
                                    mazeheight += (int)((oldGround - mazeheight) * squishfactor);
                                    newGround = oldGround;
                                }
                            }
                        }
                    }
                    for (int y3 = 0; y3 <= 127; ++y3) {
                        final int index3 = (x * 16 + z) * 128 + y3;
                        if (y3 < mazeheight && (storage[index3] == 0 || storage[index3] == yy.B.bM)) {
                            storage[index3] = (byte)yy.t.bM;
                        }
                        if (y3 >= mazeheight && storage[index3] != yy.B.bM) {
                            storage[index3] = 0;
                        }
                    }
                }
            }
        }
    }
    
    public static boolean nearChunkFeature(final int cx, final int cz, final ry world) {
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
    
    public static int[] nearestFeatureCenter(final int cx, final int cz, final ry world) {
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
    
    public static boolean isHollowHill(final int cx, final int cz, final ry world) {
        final int htype = featureType(cx, cz, world);
        return htype > 0 && htype < 4;
    }
    
    public static int nearestFeatureSize(final int cx, final int cz, final ry world) {
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
    
    public static int nearestFeatureType(final int cx, final int cz, final ry world) {
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
    
    public static int featureSize(final int cx, final int cz, final ry world) {
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
    
    public static int featureType(final int cx, final int cz, final ry world) {
        final sr biomeAt = world.a().a(cx * 16 + 8, cz * 16 + 8);
        if (biomeAt == sr.b || biomeAt == TFBiomeBase.tfOcean) {
            return -1;
        }
        if ((cx % 7 != 4 && cx % 7 != -4) || (cz % 7 != 4 && cz % 7 != -4)) {
            return -1;
        }
        final Random hillRNG = new Random(world.t() + cx * 25117 + cz * 151121);
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
                    final float f = 10.0f / me.c(k1 * k1 + l2 * l2 + 0.2f);
                    this.squareTable[k1 + 2 + (l2 + 2) * 5] = f;
                }
            }
        }
        final double d = 684.412;
        final double d2 = 684.412;
        this.field_4182_g = this.field_922_a.a(this.field_4182_g, xx, zz, l, j1, 1.121, 1.121, 0.5);
        this.field_4181_h = this.field_921_b.a(this.field_4181_h, xx, zz, l, j1, 200.0, 200.0, 0.5);
        this.field_4185_d = this.field_910_m.a(this.field_4185_d, xx, zero, zz, l, i1, j1, d / 80.0, d2 / 160.0, d / 80.0);
        this.field_4184_e = this.field_912_k.a(this.field_4184_e, xx, zero, zz, l, i1, j1, d, d2, d);
        this.field_4183_f = this.field_911_l.a(this.field_4183_f, xx, zero, zz, l, i1, j1, d, d2, d);
        zz = (xx = 0);
        int i2 = 0;
        int j2 = 0;
        for (int k2 = 0; k2 < l; ++k2) {
            for (int l3 = 0; l3 < j1; ++l3) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                final byte byte0 = 2;
                final sr biomegenbase = this.biomesForGeneration[k2 + 2 + (l3 + 2) * (l + 5)];
                for (int i3 = -byte0; i3 <= byte0; ++i3) {
                    for (int j3 = -byte0; j3 <= byte0; ++j3) {
                        final sr biomegenbase2 = this.biomesForGeneration[k2 + i3 + 2 + (l3 + j3 + 2) * (l + 5)];
                        float f5 = this.squareTable[i3 + 2 + (j3 + 2) * 5] / (biomegenbase2.w + 2.0f);
                        if (biomegenbase2.w > biomegenbase.w) {
                            f5 /= 2.0f;
                        }
                        f2 += biomegenbase2.x * f5;
                        f3 += biomegenbase2.w * f5;
                        f4 += f5;
                    }
                }
                f2 /= f4;
                f3 /= f4;
                f2 = f2 * 0.9f + 0.1f;
                f3 = (f3 * 4.0f - 1.0f) / 8.0f;
                double d3 = this.field_4181_h[j2] / 8000.0;
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
                    this.worldObj.getClass();
                    double d8 = (k3 - d6) * 12.0 * 128.0 / 128.0 / d5;
                    if (d8 < 0.0) {
                        d8 *= 4.0;
                    }
                    final double d9 = this.field_4184_e[i2] / 512.0;
                    final double d10 = this.field_4183_f[i2] / 512.0;
                    final double d11 = (this.field_4185_d[i2] / 10.0 + 1.0) / 2.0;
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
    
    public void addGlaciers(final int chunkX, final int chunkY, final byte[] storage, final sr[] biomes, final float[] temps) {
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final sr biome = biomes[z + x * 16];
                if (biome == TFBiomeBase.glacier) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final int index = (z * 16 + x) * 128 + y;
                        final byte cb = storage[index];
                        if (cb == yy.t.bM) {
                            topLevel = y;
                            storage[index] = (byte)yy.F.bM;
                            break;
                        }
                    }
                    final double t = Math.min(temps[z + x * 16], 0.1);
                    final int gHeight = 16 + (int)((0.1 - t) * 16.0);
                    for (int gTop = topLevel + gHeight + 1, y2 = topLevel + 1; y2 <= gTop && y2 < 128; ++y2) {
                        final int index2 = (z * 16 + x) * 128 + y2;
                        storage[index2] = (byte)yy.aT.bM;
                    }
                }
            }
        }
    }
    
    public boolean c(final int i, final int j) {
        return true;
    }
    
    public void a(final ej ichunkprovider, final int i, final int j) {
        cj.a = true;
        int k = i * 16;
        int l = j * 16;
        final sr biomegenbase = this.worldObj.a().a(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.t());
        final long l2 = this.rand.nextLong() / 2L * 2L + 1L;
        final long l3 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(i * l2 + j * l3 ^ this.worldObj.t());
        boolean flag = false;
        if (this.mapFeaturesEnabled) {
            this.strongholdGenerator.a(this.worldObj, this.rand, i, j);
            this.mineshaftGenerator.a(this.worldObj, this.rand, i, j);
            flag = this.villageGenerator.a(this.worldObj, this.rand, i, j);
            flag |= this.towerGenerator.a(this.worldObj, this.rand, i, j);
        }
        flag |= (nearestFeatureType(i, j, this.worldObj) > 3);
        if (!flag && this.rand.nextInt(4) == 0) {
            final int i2 = k + this.rand.nextInt(16) + 8;
            this.worldObj.getClass();
            final int i3 = this.rand.nextInt(128);
            final int i4 = l + this.rand.nextInt(16) + 8;
            new qv(yy.B.bM).a(this.worldObj, this.rand, i2, i3, i4);
        }
        if (!flag && this.rand.nextInt(32) == 0) {
            final int j2 = k + this.rand.nextInt(16) + 8;
            this.worldObj.getClass();
            final int j3 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            final int j4 = l + this.rand.nextInt(16) + 8;
            this.worldObj.getClass();
            if (j3 < 63 || this.rand.nextInt(10) == 0) {
                new qv(yy.D.bM).a(this.worldObj, this.rand, j2, j3, j4);
            }
        }
        for (int k2 = 0; k2 < 8; ++k2) {
            final int k3 = k + this.rand.nextInt(16) + 8;
            this.worldObj.getClass();
            final int k4 = this.rand.nextInt(128);
            final int l4 = l + this.rand.nextInt(16) + 8;
            if (!new acj().a(this.worldObj, this.rand, k3, k4, l4)) {}
        }
        biomegenbase.a(this.worldObj, this.rand, k, l);
        we.a(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        we.a(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        k += 8;
        l += 8;
        for (int i5 = 0; i5 < 16; ++i5) {
            for (int j5 = 0; j5 < 16; ++j5) {
                final int j6 = this.worldObj.e(k + i5, l + j5);
                if (this.worldObj.p(i5 + k, j6 - 1, j5 + l)) {
                    this.worldObj.g(i5 + k, j6 - 1, j5 + l, yy.aT.bM);
                }
                if (this.worldObj.r(i5 + k, j6, j5 + l)) {
                    this.worldObj.g(i5 + k, j6, j5 + l, yy.aS.bM);
                }
            }
        }
        cj.a = false;
    }
    
    public boolean a(final boolean flag, final rz iprogressupdate) {
        return true;
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return true;
    }
    
    public String c() {
        return "RandomLevelSource";
    }
    
    public List a(final jf enumcreaturetype, final int i, final int j, final int k) {
        final vh worldchunkmanager = this.worldObj.a();
        if (worldchunkmanager == null) {
            return null;
        }
        final sr biomegenbase = worldchunkmanager.a(new acm(i >> 4, k >> 4));
        if (biomegenbase == null) {
            return null;
        }
        return biomegenbase.a(enumcreaturetype);
    }
    
    public am a(final ry world, final String s, final int i, final int j, final int k) {
        if ("Stronghold".equals(s) && this.strongholdGenerator != null) {
            return this.strongholdGenerator.a(world, i, j, k);
        }
        return null;
    }
}
