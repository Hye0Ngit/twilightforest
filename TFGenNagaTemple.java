import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenNagaTemple extends TFGenerator
{
    static int RADIUS;
    
    @Override
    public boolean a(final fq world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        this.fill(x - TFGenNagaTemple.RADIUS, y - 1, z - TFGenNagaTemple.RADIUS, TFGenNagaTemple.RADIUS * 2 + 1, 1, TFGenNagaTemple.RADIUS * 2 + 1, ud.w.bO, 0);
        for (int fx = -TFGenNagaTemple.RADIUS; fx <= TFGenNagaTemple.RADIUS; ++fx) {
            for (int fz = -TFGenNagaTemple.RADIUS; fz <= TFGenNagaTemple.RADIUS; ++fz) {
                if (rand.nextInt(3) == 0) {
                    this.worldObj.b(x + fx, y, z + fz, 0);
                    this.worldObj.b(x + fx, y - 1, z + fz, ud.al.bO);
                    if (rand.nextInt(20) == 0) {
                        this.worldObj.b(x + fx, y, z + fz, ud.am.bO);
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
                this.worldObj.a(x + fx, y + 2, z + TFGenNagaTemple.RADIUS, ud.am.bO, 5);
                this.putRandStoneBlock(x + fx, y + 2, z - TFGenNagaTemple.RADIUS);
            }
            else {
                this.worldObj.a(x + fx, y + 2, z - TFGenNagaTemple.RADIUS, ud.am.bO, 5);
                this.putRandStoneBlock(x + fx, y + 2, z + TFGenNagaTemple.RADIUS);
            }
        }
        for (int fz2 = -TFGenNagaTemple.RADIUS; fz2 <= TFGenNagaTemple.RADIUS; ++fz2) {
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            if (fz2 % 2 == 0) {
                this.worldObj.a(x + TFGenNagaTemple.RADIUS, y + 2, z + fz2, ud.am.bO, 5);
                this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2);
            }
            else {
                this.worldObj.a(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2, ud.am.bO, 5);
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
        this.worldObj.e(dx, dy, dz, ud.aw.bO);
        final kd tec = (kd)this.worldObj.b(dx, dy, dz);
        if (tec != null) {
            tec.a(0, new jm(hg.as, 64));
            tec.a(1, new jm(hg.A));
            tec.a(2, new jm(hg.y));
            tec.a(3, new jm(hg.B));
            tec.a(4, new jm(hg.p));
            tec.a(5, new jm(ud.bo, 64));
            tec.a(6, new jm(ud.bo, 64));
            tec.a(7, new jm(hg.j));
            tec.a(8, new jm(hg.k, 64));
            tec.a(9, new jm(hg.k, 64));
            tec.a(10, new jm(hg.bi, 64));
            tec.a(11, new jm(hg.ac));
            tec.a(12, new jm(hg.ad));
            tec.a(13, new jm(hg.ae));
            tec.a(14, new jm(hg.af));
            tec.a(15, new jm(hg.ag));
            tec.a(16, new jm(hg.ah));
            tec.a(17, new jm(hg.ai));
            tec.a(18, new jm(hg.aj));
        }
    }
    
    public boolean makePillar(final int x, final int y, final int z) {
        final int height = 8;
        this.putBlock(x - 1, y + 0, z + 1, ud.am.bO, true);
        this.putBlock(x + 0, y + 0, z + 1, ud.am.bO, true);
        this.putBlock(x + 1, y + 0, z + 1, ud.am.bO, true);
        this.putBlock(x + 1, y + 0, z + 0, ud.am.bO, true);
        this.putBlock(x - 1, y + 0, z + 0, ud.am.bO, true);
        this.putBlock(x - 1, y + 0, z - 1, ud.am.bO, true);
        this.putBlock(x + 0, y + 0, z - 1, ud.am.bO, true);
        this.putBlock(x + 1, y + 0, z - 1, ud.am.bO, true);
        for (int i = 0; i < height; ++i) {
            this.putRandStoneBlock(x, y + i, z);
            if (i > 0 && this.worldObj.w.nextInt(2) == 0) {
                switch (this.worldObj.w.nextInt(4)) {
                    case 0: {
                        this.putBlockAndMetadata(x - 1, y + i, z + 0, ud.bw.bO, 8, true);
                        break;
                    }
                    case 1: {
                        this.putBlockAndMetadata(x + 1, y + i, z + 0, ud.bw.bO, 2, true);
                        break;
                    }
                    case 2: {
                        this.putBlockAndMetadata(x + 0, y + i, z + 1, ud.bw.bO, 4, true);
                        break;
                    }
                    case 3: {
                        this.putBlockAndMetadata(x + 0, y + i, z - 1, ud.bw.bO, 1, true);
                        break;
                    }
                }
            }
            else if (i > 0 && this.worldObj.w.nextInt(4) == 0) {
                switch (this.worldObj.w.nextInt(4)) {
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
            this.putBlock(x - 1, y + 8, z + 1, ud.am.bO, true);
            this.putBlock(x + 0, y + 8, z + 1, ud.am.bO, true);
            this.putBlock(x + 1, y + 8, z + 1, ud.am.bO, true);
            this.putBlock(x + 1, y + 8, z + 0, ud.am.bO, true);
            this.putBlock(x - 1, y + 8, z + 0, ud.am.bO, true);
            this.putBlock(x - 1, y + 8, z - 1, ud.am.bO, true);
            this.putBlock(x + 0, y + 8, z - 1, ud.am.bO, true);
            this.putBlock(x + 1, y + 8, z - 1, ud.am.bO, true);
            this.putBlockAndMetadata(x + 0, y + 8, z + 0, ud.am.bO, 5, true);
        }
        return true;
    }
    
    public void putRandStoneBlock(final int dx, final int dy, final int dz) {
        this.putBlockAndMetadata(dx, dy, dz, ud.bo.bO, this.worldObj.w.nextInt(3), true);
    }
    
    static {
        TFGenNagaTemple.RADIUS = 46;
    }
}
