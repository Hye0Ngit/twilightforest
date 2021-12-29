// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFGenNagaTemple extends TFGenerator
{
    static int RADIUS;
    
    @Override
    public boolean a(final xd world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        this.fill(x - TFGenNagaTemple.RADIUS, y - 1, z - TFGenNagaTemple.RADIUS, TFGenNagaTemple.RADIUS * 2 + 1, 1, TFGenNagaTemple.RADIUS * 2 + 1, pb.u.bO, 0);
        for (int fx = -TFGenNagaTemple.RADIUS; fx <= TFGenNagaTemple.RADIUS; ++fx) {
            for (int fz = -TFGenNagaTemple.RADIUS; fz <= TFGenNagaTemple.RADIUS; ++fz) {
                if (rand.nextInt(3) == 0) {
                    this.worldObj.d(x + fx, y, z + fz, 0);
                    this.worldObj.d(x + fx, y - 1, z + fz, pb.aj.bO);
                    if (rand.nextInt(20) == 0) {
                        this.worldObj.d(x + fx, y, z + fz, pb.ak.bO);
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
                this.worldObj.b(x + fx, y + 2, z + TFGenNagaTemple.RADIUS, pb.ak.bO, 5);
                this.putRandStoneBlock(x + fx, y + 2, z - TFGenNagaTemple.RADIUS);
            }
            else {
                this.worldObj.b(x + fx, y + 2, z - TFGenNagaTemple.RADIUS, pb.ak.bO, 5);
                this.putRandStoneBlock(x + fx, y + 2, z + TFGenNagaTemple.RADIUS);
            }
        }
        for (int fz2 = -TFGenNagaTemple.RADIUS; fz2 <= TFGenNagaTemple.RADIUS; ++fz2) {
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 0, z + fz2);
            this.putRandStoneBlock(x + TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 1, z + fz2);
            if (fz2 % 2 == 0) {
                this.worldObj.b(x + TFGenNagaTemple.RADIUS, y + 2, z + fz2, pb.ak.bO, 5);
                this.putRandStoneBlock(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2);
            }
            else {
                this.worldObj.b(x - TFGenNagaTemple.RADIUS, y + 2, z + fz2, pb.ak.bO, 5);
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
        this.worldObj.g(dx, dy, dz, pb.au.bO);
        final hb tec = (hb)this.worldObj.b(dx, dy, dz);
        if (tec != null) {
            tec.a(0, new aan(yr.at, 64));
            tec.a(1, new aan(yr.B));
            tec.a(2, new aan(yr.z));
            tec.a(3, new aan(yr.C));
            tec.a(4, new aan(yr.q));
            tec.a(5, new aan(pb.bm, 64));
            tec.a(6, new aan(pb.bm, 64));
            tec.a(7, new aan(yr.k));
            tec.a(8, new aan(yr.l, 64));
            tec.a(9, new aan(yr.l, 64));
            tec.a(10, new aan(yr.bj, 64));
            tec.a(11, new aan(yr.ad));
            tec.a(12, new aan(yr.ae));
            tec.a(13, new aan(yr.af));
            tec.a(14, new aan(yr.ag));
            tec.a(15, new aan(yr.ah));
            tec.a(16, new aan(yr.ai));
            tec.a(17, new aan(yr.aj));
            tec.a(18, new aan(yr.ak));
        }
    }
    
    public boolean makePillar(final int x, final int y, final int z) {
        final int height = 8;
        this.putBlock(x - 1, y + 0, z + 1, pb.ak.bO, true);
        this.putBlock(x + 0, y + 0, z + 1, pb.ak.bO, true);
        this.putBlock(x + 1, y + 0, z + 1, pb.ak.bO, true);
        this.putBlock(x + 1, y + 0, z + 0, pb.ak.bO, true);
        this.putBlock(x - 1, y + 0, z + 0, pb.ak.bO, true);
        this.putBlock(x - 1, y + 0, z - 1, pb.ak.bO, true);
        this.putBlock(x + 0, y + 0, z - 1, pb.ak.bO, true);
        this.putBlock(x + 1, y + 0, z - 1, pb.ak.bO, true);
        for (int i = 0; i < height; ++i) {
            this.putRandStoneBlock(x, y + i, z);
            if (i > 0 && this.worldObj.r.nextInt(2) == 0) {
                switch (this.worldObj.r.nextInt(4)) {
                    case 0: {
                        this.putBlockAndMetadata(x - 1, y + i, z + 0, pb.bu.bO, 8, true);
                        break;
                    }
                    case 1: {
                        this.putBlockAndMetadata(x + 1, y + i, z + 0, pb.bu.bO, 2, true);
                        break;
                    }
                    case 2: {
                        this.putBlockAndMetadata(x + 0, y + i, z + 1, pb.bu.bO, 4, true);
                        break;
                    }
                    case 3: {
                        this.putBlockAndMetadata(x + 0, y + i, z - 1, pb.bu.bO, 1, true);
                        break;
                    }
                }
            }
            else if (i > 0 && this.worldObj.r.nextInt(4) == 0) {
                switch (this.worldObj.r.nextInt(4)) {
                    case 0: {
                        this.putBlock(x - 1, y + i, z + 0, TFBlocks.critter.bO, true);
                        break;
                    }
                    case 1: {
                        this.putBlock(x + 1, y + i, z + 0, TFBlocks.critter.bO, true);
                        break;
                    }
                    case 2: {
                        this.putBlock(x + 0, y + i, z + 1, TFBlocks.critter.bO, true);
                        break;
                    }
                    case 3: {
                        this.putBlock(x + 0, y + i, z - 1, TFBlocks.critter.bO, true);
                        break;
                    }
                }
            }
        }
        if (height == 8) {
            this.putBlock(x - 1, y + 8, z + 1, pb.ak.bO, true);
            this.putBlock(x + 0, y + 8, z + 1, pb.ak.bO, true);
            this.putBlock(x + 1, y + 8, z + 1, pb.ak.bO, true);
            this.putBlock(x + 1, y + 8, z + 0, pb.ak.bO, true);
            this.putBlock(x - 1, y + 8, z + 0, pb.ak.bO, true);
            this.putBlock(x - 1, y + 8, z - 1, pb.ak.bO, true);
            this.putBlock(x + 0, y + 8, z - 1, pb.ak.bO, true);
            this.putBlock(x + 1, y + 8, z - 1, pb.ak.bO, true);
            this.putBlockAndMetadata(x + 0, y + 8, z + 0, pb.ak.bO, 5, true);
        }
        return true;
    }
    
    public void putRandStoneBlock(final int dx, final int dy, final int dz) {
        this.putBlockAndMetadata(dx, dy, dz, pb.bm.bO, this.worldObj.r.nextInt(3), true);
    }
    
    static {
        TFGenNagaTemple.RADIUS = 46;
    }
}
