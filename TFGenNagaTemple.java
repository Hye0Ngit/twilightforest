import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenNagaTemple extends TFGenerator
{
    static int RADIUS;
    
    @Override
    public boolean a(final wz world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        this.fill(x - TFGenNagaTemple.RADIUS, y - 1, z - TFGenNagaTemple.RADIUS, TFGenNagaTemple.RADIUS * 2 + 1, 1, TFGenNagaTemple.RADIUS * 2 + 1, ox.u.bO, 0);
        for (int fx = -TFGenNagaTemple.RADIUS; fx <= TFGenNagaTemple.RADIUS; ++fx) {
            for (int fz = -TFGenNagaTemple.RADIUS; fz <= TFGenNagaTemple.RADIUS; ++fz) {
                if (rand.nextInt(3) == 0) {
                    this.worldObj.d(x + fx, y, z + fz, 0);
                    this.worldObj.d(x + fx, y - 1, z + fz, ox.aj.bO);
                    if (rand.nextInt(20) == 0) {
                        this.worldObj.d(x + fx, y, z + fz, ox.ak.bO);
                    }
                }
            }
        }
        for (int fx = -TFGenNagaTemple.RADIUS; fx <= TFGenNagaTemple.RADIUS; ++fx) {
            this.putRandStoneBlock(x + fx, y + 0, z + TFGenNagaTemple.RADIUS);
            this.putRandStoneBlock(x + fx, y + 0, z - TFGenNagaTemple.RADIUS);
            this.putRandStoneBlock(x + fx, y + 1, z + TFGenNagaTemple.RADIUS);
            this.putRandStoneBlock(x + fx, y + 1, z - TFGenNagaTemple.RADIUS);
            if (fx % 2 == 0) {
                this.worldObj.b(x + fx, y + 2, z + TFGenNagaTemple.RADIUS, ox.ak.bO, 5);
                this.putRandStoneBlock(x + fx, y + 2, z - TFGenNagaTemple.RADIUS);
            }
            else {
                this.worldObj.b(x + fx, y + 2, z - TFGenNagaTemple.RADIUS, ox.ak.bO, 5);
                this.putRandStoneBlock(x + fx, y + 2, z + TFGenNagaTemple.RADIUS);
            }
        }
        for (int fz2 = -TFGenNagaTemple.RADIUS; fz2 <= TFGenNagaTemple.RADIUS; ++fz2) {
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            if (fz2 % 2 == 0) {
                this.worldObj.b(x + TFGenNagaTemple.RADIUS, y + 2, z + fz2, ox.ak.bO, 5);
                this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2);
            }
            else {
                this.worldObj.b(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2, ox.ak.bO, 5);
                this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 2, z + fz2);
            }
        }
        this.worldObj.g(x, y + 2, z, TFBlocks.bossSpawner.bO);
        for (int i = 0; i < 20; ++i) {
            final int rx = x - TFGenNagaTemple.RADIUS + 2 + rand.nextInt(2 * TFGenNagaTemple.RADIUS - 4);
            final int rz = z - TFGenNagaTemple.RADIUS + 2 + rand.nextInt(2 * TFGenNagaTemple.RADIUS - 4);
            this.makePillar(rx, y, rz);
        }
        return true;
    }
    
    protected void makeSupplyBox(final int dx, final int dy, final int dz) {
        this.worldObj.g(dx, dy, dz, ox.au.bO);
        final gy tec = (gy)this.worldObj.b(dx, dy, dz);
        if (tec != null) {
            tec.a(0, new aai(ym.at, 64));
            tec.a(1, new aai(ym.B));
            tec.a(2, new aai(ym.z));
            tec.a(3, new aai(ym.C));
            tec.a(4, new aai(ym.q));
            tec.a(5, new aai(ox.bm, 64));
            tec.a(6, new aai(ox.bm, 64));
            tec.a(7, new aai(ym.k));
            tec.a(8, new aai(ym.l, 64));
            tec.a(9, new aai(ym.l, 64));
            tec.a(10, new aai(ym.bj, 64));
            tec.a(11, new aai(ym.ad));
            tec.a(12, new aai(ym.ae));
            tec.a(13, new aai(ym.af));
            tec.a(14, new aai(ym.ag));
            tec.a(15, new aai(ym.ah));
            tec.a(16, new aai(ym.ai));
            tec.a(17, new aai(ym.aj));
            tec.a(18, new aai(ym.ak));
        }
    }
    
    public boolean makePillar(final int x, final int y, final int z) {
        final int height = 8;
        this.putBlock(x - 1, y + 0, z + 1, ox.ak.bO, true);
        this.putBlock(x + 0, y + 0, z + 1, ox.ak.bO, true);
        this.putBlock(x + 1, y + 0, z + 1, ox.ak.bO, true);
        this.putBlock(x + 1, y + 0, z + 0, ox.ak.bO, true);
        this.putBlock(x - 1, y + 0, z + 0, ox.ak.bO, true);
        this.putBlock(x - 1, y + 0, z - 1, ox.ak.bO, true);
        this.putBlock(x + 0, y + 0, z - 1, ox.ak.bO, true);
        this.putBlock(x + 1, y + 0, z - 1, ox.ak.bO, true);
        for (int i = 0; i < height; ++i) {
            this.putRandStoneBlock(x, y + i, z);
            if (i > 0 && this.worldObj.r.nextInt(2) == 0) {
                switch (this.worldObj.r.nextInt(4)) {
                    case 0: {
                        this.putBlockAndMetadata(x - 1, y + i, z + 0, ox.bu.bO, 8, true);
                        break;
                    }
                    case 1: {
                        this.putBlockAndMetadata(x + 1, y + i, z + 0, ox.bu.bO, 2, true);
                        break;
                    }
                    case 2: {
                        this.putBlockAndMetadata(x + 0, y + i, z + 1, ox.bu.bO, 4, true);
                        break;
                    }
                    case 3: {
                        this.putBlockAndMetadata(x + 0, y + i, z - 1, ox.bu.bO, 1, true);
                        break;
                    }
                }
            }
            else if (i > 0 && this.worldObj.r.nextInt(4) == 0) {
                switch (this.worldObj.r.nextInt(4)) {
                    case 0: {
                        this.putBlock(x - 1, y + i, z + 0, TFBlocks.firefly.bO, true);
                        break;
                    }
                    case 1: {
                        this.putBlock(x + 1, y + i, z + 0, TFBlocks.firefly.bO, true);
                        break;
                    }
                    case 2: {
                        this.putBlock(x + 0, y + i, z + 1, TFBlocks.firefly.bO, true);
                        break;
                    }
                    case 3: {
                        this.putBlock(x + 0, y + i, z - 1, TFBlocks.firefly.bO, true);
                        break;
                    }
                }
            }
        }
        if (height == 8) {
            this.putBlock(x - 1, y + 8, z + 1, ox.ak.bO, true);
            this.putBlock(x + 0, y + 8, z + 1, ox.ak.bO, true);
            this.putBlock(x + 1, y + 8, z + 1, ox.ak.bO, true);
            this.putBlock(x + 1, y + 8, z + 0, ox.ak.bO, true);
            this.putBlock(x - 1, y + 8, z + 0, ox.ak.bO, true);
            this.putBlock(x - 1, y + 8, z - 1, ox.ak.bO, true);
            this.putBlock(x + 0, y + 8, z - 1, ox.ak.bO, true);
            this.putBlock(x + 1, y + 8, z - 1, ox.ak.bO, true);
            this.putBlockAndMetadata(x + 0, y + 8, z + 0, ox.ak.bO, 5, true);
        }
        return true;
    }
    
    public void putRandStoneBlock(final int dx, final int dy, final int dz) {
        this.putBlockAndMetadata(dx, dy, dz, ox.bm.bO, this.worldObj.r.nextInt(3), true);
    }
    
    static {
        TFGenNagaTemple.RADIUS = 46;
    }
}
