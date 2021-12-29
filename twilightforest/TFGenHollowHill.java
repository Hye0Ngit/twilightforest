// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFGenHollowHill extends TFGenerator
{
    int hsize;
    int radius;
    int sn;
    int mg;
    int tc;
    int hx;
    int hy;
    int hz;
    Random hillRNG;
    
    public TFGenHollowHill(final int size) {
        this.hsize = size;
        this.radius = (this.hsize * 2 + 1) * 8 - 6;
        final int area = (int)(3.141592653589793 * this.radius * this.radius);
        this.sn = area / 16;
        final int[] mga = { 0, 3, 9, 18 };
        this.mg = mga[this.hsize];
        final int[] tca = { 0, 2, 6, 12 };
        this.tc = tca[this.hsize];
    }
    
    @Override
    public boolean a(final xd world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        this.hx = x;
        this.hy = y;
        this.hz = z;
        this.hillRNG = rand;
        for (int i = 0; i < this.mg; ++i) {
            final int[] dest = this.getCoordsInHill2D();
            this.placeMobSpawner(dest[0], this.hy + rand.nextInt(4), dest[1]);
        }
        for (int i = 0; i < this.tc; ++i) {
            final int[] dest = this.getCoordsInHill2D();
            this.placeTreasureChest(dest[0], this.hy, dest[1]);
        }
        for (int i = 0; i < this.sn; ++i) {
            final int[] dest = this.getCoordsInHill2D();
            final TFGenCaveStalactite stalag = TFGenCaveStalactite.makeRandomOreStalactite(rand, this.hsize);
            stalag.a(this.worldObj, rand, dest[0], this.hy + 1, dest[1]);
        }
        for (int i = 0; i < this.sn; ++i) {
            final int[] dest = this.getCoordsInHill2D();
            new TFGenCaveStalactite(pb.t.bO, rand.nextDouble(), true).a(this.worldObj, rand, dest[0], this.hy + 1, dest[1]);
        }
        for (int i = 0; i < this.sn; ++i) {
            final int[] dest = this.getCoordsInHill2D();
            new TFGenCaveStalactite(pb.t.bO, rand.nextDouble() * 0.7, false).a(this.worldObj, rand, dest[0], this.hy + 1, dest[1]);
        }
        if (this.hsize == 3) {
            int[] dest2 = this.getEmptyCoordsInHill(this.hy + 10, 20);
            this.placeWraithSpawner(dest2[0], this.hy + 10, dest2[1]);
            dest2 = this.getEmptyCoordsInHill(this.hy + 10, 20);
            this.placeWraithSpawner(dest2[0], this.hy + 10, dest2[1]);
        }
        return true;
    }
    
    boolean isInHill(final int cx, final int cz) {
        final int dx = this.hx - cx;
        final int dz = this.hz - cz;
        final int dist = (int)Math.sqrt(dx * dx + dz * dz);
        return dist < this.radius;
    }
    
    int[] getCoordsInHill2D() {
        return this.getCoordsInHill2D(this.radius);
    }
    
    int[] getCoordsInHill2D(final int rad) {
        int rx;
        int rz;
        do {
            rx = this.hx + this.hillRNG.nextInt(2 * rad) - rad;
            rz = this.hz + this.hillRNG.nextInt(2 * rad) - rad;
        } while (!this.isInHill(rx, rz));
        final int[] coords = { rx, rz };
        return coords;
    }
    
    int[] getEmptyCoordsInHill(final int ry, final int rad) {
        int rx;
        int rz;
        int whatsThere;
        do {
            rx = this.hx + this.hillRNG.nextInt(2 * rad) - rad;
            rz = this.hz + this.hillRNG.nextInt(2 * rad) - rad;
            whatsThere = this.worldObj.a(rx, ry, rz);
        } while (!this.isInHill(rx, rz) || whatsThere != 0);
        final int[] coords = { rx, rz };
        return coords;
    }
    
    protected boolean placeMobSpawner(final int dx, final int dy, final int dz) {
        this.worldObj.g(dx, dy, dz, pb.as.bO);
        final cj ms = (cj)this.worldObj.b(dx, dy, dz);
        if (ms != null) {
            ms.a(this.getMobID(this.hsize));
        }
        return true;
    }
    
    protected boolean placeWraithSpawner(final int dx, final int dy, final int dz) {
        this.worldObj.g(dx, dy, dz, pb.as.bO);
        final cj ms = (cj)this.worldObj.b(dx, dy, dz);
        if (ms != null) {
            ms.a("Twilight Wraith");
        }
        return true;
    }
    
    protected String getMobID(final int level) {
        if (level == 1) {
            return this.getLevel1Mob();
        }
        if (level == 2) {
            return this.getLevel2Mob();
        }
        if (level == 3) {
            return this.getLevel3Mob();
        }
        return "Spider";
    }
    
    public String getLevel1Mob() {
        switch (this.hillRNG.nextInt(10)) {
            case 0:
            case 1:
            case 2: {
                return "Swarm Spider";
            }
            case 3:
            case 4:
            case 5: {
                return "Spider";
            }
            case 6:
            case 7: {
                return "Zombie";
            }
            case 8: {
                return "Silverfish";
            }
            case 9: {
                return "Redcap";
            }
            default: {
                return "Swarm Spider";
            }
        }
    }
    
    public String getLevel2Mob() {
        switch (this.hillRNG.nextInt(10)) {
            case 0:
            case 1:
            case 2: {
                return "Redcap";
            }
            case 3:
            case 4:
            case 5: {
                return "Zombie";
            }
            case 6:
            case 7: {
                return "Skeleton";
            }
            case 8: {
                return "Swarm Spider";
            }
            case 9: {
                return "CaveSpider";
            }
            default: {
                return "Redcap";
            }
        }
    }
    
    public String getLevel3Mob() {
        switch (this.hillRNG.nextInt(11)) {
            case 0:
            case 1:
            case 2: {
                return "Enderman";
            }
            case 3:
            case 4:
            case 5: {
                return "Skeleton";
            }
            case 6:
            case 7:
            case 8: {
                return "CaveSpider";
            }
            case 9: {
                return "Creeper";
            }
            case 10: {
                return "Twilight Wraith";
            }
            default: {
                return "Enderman";
            }
        }
    }
    
    protected boolean placeTreasureChest(final int dx, final int dy, final int dz) {
        return TFTreasure.hill1.generate(this.worldObj, this.hillRNG, dx, dy, dz);
    }
    
    protected boolean placeTreasureChestOld(final int dx, final int dy, final int dz) {
        this.worldObj.g(dx, dy, dz, pb.au.bO);
        final hb tec = (hb)this.worldObj.b(dx, dy, dz);
        if (tec != null && tec.a() > 0) {
            for (int ni = this.hillRNG.nextInt(4) + this.hillRNG.nextInt(4) + 2, i = 0; i < ni; ++i) {
                tec.a(i, this.getTreasure(this.hsize));
            }
        }
        return true;
    }
    
    protected aan getTreasure(final int level) {
        if (level == 1) {
            switch (this.hillRNG.nextInt(6)) {
                case 0: {
                    return new aan(yr.o, this.hillRNG.nextInt(4) + 1);
                }
                case 1: {
                    return new aan(yr.aw);
                }
                case 2: {
                    return new aan(yr.U);
                }
                case 4: {
                    return new aan(yr.T, this.hillRNG.nextInt(3) + 1);
                }
                default: {
                    return new aan(pb.aq, this.hillRNG.nextInt(16) + 1);
                }
            }
        }
        else if (level == 2) {
            switch (this.hillRNG.nextInt(8)) {
                case 0:
                case 1:
                case 2: {
                    return this.getTreasure(1);
                }
                case 4: {
                    return new aan(yr.p, this.hillRNG.nextInt(6) + 1);
                }
                case 5: {
                    return new aan(yr.aA);
                }
                case 6: {
                    return new aan(yr.aW, this.hillRNG.nextInt(10) + 1, this.hillRNG.nextInt(16));
                }
                default: {
                    return new aan(yr.F);
                }
            }
        }
        else {
            if (level != 3) {
                return new aan(yr.m, this.hillRNG.nextInt(16) + 1);
            }
            switch (this.hillRNG.nextInt(8)) {
                case 0:
                case 1:
                case 2: {
                    return this.getTreasure(2);
                }
                case 4: {
                    return new aan(yr.at);
                }
                case 5: {
                    return new aan(yr.bF);
                }
                case 6: {
                    return new aan(yr.aA);
                }
                default: {
                    return new aan(yr.n);
                }
            }
        }
    }
}
