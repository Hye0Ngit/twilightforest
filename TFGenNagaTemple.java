import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenNagaTemple extends TFGenerator
{
    static int RADIUS;
    
    @Override
    public boolean a(final ge world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        this.fill(x - TFGenNagaTemple.RADIUS, y - 1, z - TFGenNagaTemple.RADIUS, TFGenNagaTemple.RADIUS * 2 + 1, 1, TFGenNagaTemple.RADIUS * 2 + 1, vz.u.bO, 0);
        for (int fx = -TFGenNagaTemple.RADIUS; fx <= TFGenNagaTemple.RADIUS; ++fx) {
            for (int fz = -TFGenNagaTemple.RADIUS; fz <= TFGenNagaTemple.RADIUS; ++fz) {
                if (rand.nextInt(3) == 0) {
                    this.worldObj.b(x + fx, y, z + fz, 0);
                    this.worldObj.b(x + fx, y - 1, z + fz, vz.aj.bO);
                    if (rand.nextInt(20) == 0) {
                        this.worldObj.b(x + fx, y, z + fz, vz.ak.bO);
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
                this.worldObj.a(x + fx, y + 2, z + TFGenNagaTemple.RADIUS, vz.ak.bO, 5);
                this.putRandStoneBlock(x + fx, y + 2, z - TFGenNagaTemple.RADIUS);
            }
            else {
                this.worldObj.a(x + fx, y + 2, z - TFGenNagaTemple.RADIUS, vz.ak.bO, 5);
                this.putRandStoneBlock(x + fx, y + 2, z + TFGenNagaTemple.RADIUS);
            }
        }
        for (int fz2 = -TFGenNagaTemple.RADIUS; fz2 <= TFGenNagaTemple.RADIUS; ++fz2) {
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            if (fz2 % 2 == 0) {
                this.worldObj.a(x + TFGenNagaTemple.RADIUS, y + 2, z + fz2, vz.ak.bO, 5);
                this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2);
            }
            else {
                this.worldObj.a(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2, vz.ak.bO, 5);
                this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 2, z + fz2);
            }
        }
        this.worldObj.e(x, y + 2, z, TFBlocks.bossSpawner.bO);
        for (int i = 0; i < 20; ++i) {
            final int rx = x - TFGenNagaTemple.RADIUS + 2 + rand.nextInt(2 * TFGenNagaTemple.RADIUS - 4);
            final int rz = z - TFGenNagaTemple.RADIUS + 2 + rand.nextInt(2 * TFGenNagaTemple.RADIUS - 4);
            this.makePillar(rx, y, rz);
        }
        return true;
    }
    
    protected void makeSupplyBox(final int dx, final int dy, final int dz) {
        this.worldObj.e(dx, dy, dz, vz.au.bO);
        final lh tec = (lh)this.worldObj.b(dx, dy, dz);
        if (tec != null) {
            tec.a(0, new kp(id.as, 64));
            tec.a(1, new kp(id.A));
            tec.a(2, new kp(id.y));
            tec.a(3, new kp(id.B));
            tec.a(4, new kp(id.p));
            tec.a(5, new kp(vz.bm, 64));
            tec.a(6, new kp(vz.bm, 64));
            tec.a(7, new kp(id.j));
            tec.a(8, new kp(id.k, 64));
            tec.a(9, new kp(id.k, 64));
            tec.a(10, new kp(id.bi, 64));
            tec.a(11, new kp(id.ac));
            tec.a(12, new kp(id.ad));
            tec.a(13, new kp(id.ae));
            tec.a(14, new kp(id.af));
            tec.a(15, new kp(id.ag));
            tec.a(16, new kp(id.ah));
            tec.a(17, new kp(id.ai));
            tec.a(18, new kp(id.aj));
        }
    }
    
    public boolean makePillar(final int x, final int y, final int z) {
        final int height = 8;
        this.putBlock(x - 1, y + 0, z + 1, vz.ak.bO, true);
        this.putBlock(x + 0, y + 0, z + 1, vz.ak.bO, true);
        this.putBlock(x + 1, y + 0, z + 1, vz.ak.bO, true);
        this.putBlock(x + 1, y + 0, z + 0, vz.ak.bO, true);
        this.putBlock(x - 1, y + 0, z + 0, vz.ak.bO, true);
        this.putBlock(x - 1, y + 0, z - 1, vz.ak.bO, true);
        this.putBlock(x + 0, y + 0, z - 1, vz.ak.bO, true);
        this.putBlock(x + 1, y + 0, z - 1, vz.ak.bO, true);
        for (int i = 0; i < height; ++i) {
            this.putRandStoneBlock(x, y + i, z);
            if (i > 0 && this.worldObj.r.nextInt(2) == 0) {
                switch (this.worldObj.r.nextInt(4)) {
                    case 0: {
                        this.putBlockAndMetadata(x - 1, y + i, z + 0, vz.bu.bO, 8, true);
                        break;
                    }
                    case 1: {
                        this.putBlockAndMetadata(x + 1, y + i, z + 0, vz.bu.bO, 2, true);
                        break;
                    }
                    case 2: {
                        this.putBlockAndMetadata(x + 0, y + i, z + 1, vz.bu.bO, 4, true);
                        break;
                    }
                    case 3: {
                        this.putBlockAndMetadata(x + 0, y + i, z - 1, vz.bu.bO, 1, true);
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
            this.putBlock(x - 1, y + 8, z + 1, vz.ak.bO, true);
            this.putBlock(x + 0, y + 8, z + 1, vz.ak.bO, true);
            this.putBlock(x + 1, y + 8, z + 1, vz.ak.bO, true);
            this.putBlock(x + 1, y + 8, z + 0, vz.ak.bO, true);
            this.putBlock(x - 1, y + 8, z + 0, vz.ak.bO, true);
            this.putBlock(x - 1, y + 8, z - 1, vz.ak.bO, true);
            this.putBlock(x + 0, y + 8, z - 1, vz.ak.bO, true);
            this.putBlock(x + 1, y + 8, z - 1, vz.ak.bO, true);
            this.putBlockAndMetadata(x + 0, y + 8, z + 0, vz.ak.bO, 5, true);
        }
        return true;
    }
    
    public void putRandStoneBlock(final int dx, final int dy, final int dz) {
        this.putBlockAndMetadata(dx, dy, dz, vz.bm.bO, this.worldObj.r.nextInt(3), true);
    }
    
    static {
        TFGenNagaTemple.RADIUS = 46;
    }
}
