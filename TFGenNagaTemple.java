import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenNagaTemple extends TFGenerator
{
    static int RADIUS;
    
    @Override
    public boolean a(final ry world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        this.fill(x - TFGenNagaTemple.RADIUS, y - 1, z - TFGenNagaTemple.RADIUS, TFGenNagaTemple.RADIUS * 2 + 1, 1, TFGenNagaTemple.RADIUS * 2 + 1, yy.u.bM, 0);
        for (int fx = -TFGenNagaTemple.RADIUS; fx <= TFGenNagaTemple.RADIUS; ++fx) {
            for (int fz = -TFGenNagaTemple.RADIUS; fz <= TFGenNagaTemple.RADIUS; ++fz) {
                if (rand.nextInt(3) == 0) {
                    this.worldObj.d(x + fx, y, z + fz, 0);
                    this.worldObj.d(x + fx, y - 1, z + fz, yy.aj.bM);
                    if (rand.nextInt(20) == 0) {
                        this.worldObj.d(x + fx, y, z + fz, yy.ak.bM);
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
                this.worldObj.b(x + fx, y + 2, z + TFGenNagaTemple.RADIUS, yy.ak.bM, 5);
                this.putRandStoneBlock(x + fx, y + 2, z - TFGenNagaTemple.RADIUS);
            }
            else {
                this.worldObj.b(x + fx, y + 2, z - TFGenNagaTemple.RADIUS, yy.ak.bM, 5);
                this.putRandStoneBlock(x + fx, y + 2, z + TFGenNagaTemple.RADIUS);
            }
        }
        for (int fz2 = -TFGenNagaTemple.RADIUS; fz2 <= TFGenNagaTemple.RADIUS; ++fz2) {
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            if (fz2 % 2 == 0) {
                this.worldObj.b(x + TFGenNagaTemple.RADIUS, y + 2, z + fz2, yy.ak.bM, 5);
                this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2);
            }
            else {
                this.worldObj.b(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2, yy.ak.bM, 5);
                this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 2, z + fz2);
            }
        }
        this.worldObj.g(x, y + 2, z, TFBlocks.bossSpawner.bM);
        for (int i = 0; i < 20; ++i) {
            final int rx = x - TFGenNagaTemple.RADIUS + 2 + rand.nextInt(2 * TFGenNagaTemple.RADIUS - 4);
            final int rz = z - TFGenNagaTemple.RADIUS + 2 + rand.nextInt(2 * TFGenNagaTemple.RADIUS - 4);
            this.makePillar(rx, y, rz);
        }
        return true;
    }
    
    protected void makeSupplyBox(final int dx, final int dy, final int dz) {
        this.worldObj.g(dx, dy, dz, yy.au.bM);
        final tu tec = (tu)this.worldObj.b(dx, dy, dz);
        if (tec != null) {
            tec.a(0, new dk(acy.as, 64));
            tec.a(1, new dk(acy.A));
            tec.a(2, new dk(acy.y));
            tec.a(3, new dk(acy.B));
            tec.a(4, new dk(acy.p));
            tec.a(5, new dk(yy.bm, 64));
            tec.a(6, new dk(yy.bm, 64));
            tec.a(7, new dk(acy.j));
            tec.a(8, new dk(acy.k, 64));
            tec.a(9, new dk(acy.k, 64));
            tec.a(10, new dk(acy.bi, 64));
            tec.a(11, new dk(acy.ac));
            tec.a(12, new dk(acy.ad));
            tec.a(13, new dk(acy.ae));
            tec.a(14, new dk(acy.af));
            tec.a(15, new dk(acy.ag));
            tec.a(16, new dk(acy.ah));
            tec.a(17, new dk(acy.ai));
            tec.a(18, new dk(acy.aj));
        }
    }
    
    public boolean makePillar(final int x, final int y, final int z) {
        final int height = 8;
        this.putBlock(x - 1, y + 0, z + 1, yy.ak.bM, true);
        this.putBlock(x + 0, y + 0, z + 1, yy.ak.bM, true);
        this.putBlock(x + 1, y + 0, z + 1, yy.ak.bM, true);
        this.putBlock(x + 1, y + 0, z + 0, yy.ak.bM, true);
        this.putBlock(x - 1, y + 0, z + 0, yy.ak.bM, true);
        this.putBlock(x - 1, y + 0, z - 1, yy.ak.bM, true);
        this.putBlock(x + 0, y + 0, z - 1, yy.ak.bM, true);
        this.putBlock(x + 1, y + 0, z - 1, yy.ak.bM, true);
        for (int i = 0; i < height; ++i) {
            this.putRandStoneBlock(x, y + i, z);
            if (i > 0 && this.worldObj.w.nextInt(2) == 0) {
                switch (this.worldObj.w.nextInt(4)) {
                    case 0: {
                        this.putBlockAndMetadata(x - 1, y + i, z + 0, yy.bu.bM, 8, true);
                        break;
                    }
                    case 1: {
                        this.putBlockAndMetadata(x + 1, y + i, z + 0, yy.bu.bM, 2, true);
                        break;
                    }
                    case 2: {
                        this.putBlockAndMetadata(x + 0, y + i, z + 1, yy.bu.bM, 4, true);
                        break;
                    }
                    case 3: {
                        this.putBlockAndMetadata(x + 0, y + i, z - 1, yy.bu.bM, 1, true);
                        break;
                    }
                }
            }
            else if (i > 0 && this.worldObj.w.nextInt(4) == 0) {
                switch (this.worldObj.w.nextInt(4)) {
                    case 0: {
                        this.putBlock(x - 1, y + i, z + 0, TFBlocks.firefly.bM, true);
                        break;
                    }
                    case 1: {
                        this.putBlock(x + 1, y + i, z + 0, TFBlocks.firefly.bM, true);
                        break;
                    }
                    case 2: {
                        this.putBlock(x + 0, y + i, z + 1, TFBlocks.firefly.bM, true);
                        break;
                    }
                    case 3: {
                        this.putBlock(x + 0, y + i, z - 1, TFBlocks.firefly.bM, true);
                        break;
                    }
                }
            }
        }
        if (height == 8) {
            this.putBlock(x - 1, y + 8, z + 1, yy.ak.bM, true);
            this.putBlock(x + 0, y + 8, z + 1, yy.ak.bM, true);
            this.putBlock(x + 1, y + 8, z + 1, yy.ak.bM, true);
            this.putBlock(x + 1, y + 8, z + 0, yy.ak.bM, true);
            this.putBlock(x - 1, y + 8, z + 0, yy.ak.bM, true);
            this.putBlock(x - 1, y + 8, z - 1, yy.ak.bM, true);
            this.putBlock(x + 0, y + 8, z - 1, yy.ak.bM, true);
            this.putBlock(x + 1, y + 8, z - 1, yy.ak.bM, true);
            this.putBlockAndMetadata(x + 0, y + 8, z + 0, yy.ak.bM, 5, true);
        }
        return true;
    }
    
    public void putRandStoneBlock(final int dx, final int dy, final int dz) {
        this.putBlockAndMetadata(dx, dy, dz, yy.bm.bM, this.worldObj.w.nextInt(3), true);
    }
    
    static {
        TFGenNagaTemple.RADIUS = 46;
    }
}
