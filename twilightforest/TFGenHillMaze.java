// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFGenHillMaze extends TFGenerator
{
    int hsize;
    TFMaze maze;
    Random rand;
    
    public TFGenHillMaze(final int size) {
        this.hsize = size;
    }
    
    @Override
    public boolean a(final xd world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        this.rand = rand;
        final int sx = x - 7 - this.hsize * 16;
        final int sz = z - 7 - this.hsize * 16;
        int msize = 11;
        if (this.hsize == 2) {
            msize = 19;
        }
        else if (this.hsize == 3) {
            msize = 27;
        }
        this.fill(sx, y - 1, sz, msize * 4, 1, msize * 4, TFBlocks.mazestone.bO, 0);
        this.fill(sx, y, sz, msize * 4, 3, msize * 4, 0, 0);
        this.fill(sx, y + 3, sz, msize * 4, 1, msize * 4, TFBlocks.mazestone.bO, 0);
        this.maze = new TFMaze(msize, msize);
        final int nrooms = msize / 3;
        final int[] rcoords = new int[nrooms * 2];
        for (int i = 0; i < nrooms; ++i) {
            int rx;
            int rz;
            do {
                rx = rand.nextInt(msize - 2) + 1;
                rz = rand.nextInt(msize - 2) + 1;
            } while (this.isNearRoom(rx, rz, rcoords));
            this.maze.carveRoom1(rx, rz);
            rcoords[i * 2] = rx;
            rcoords[i * 2 + 1] = rz;
        }
        this.maze.generateRecursiveBacktracker(0, 0);
        this.maze.copyToWorld(this.worldObj, sx, y, sz);
        this.decorateDeadEnds();
        this.decorate3x3Rooms(rcoords);
        return true;
    }
    
    protected boolean isNearRoom(final int dx, final int dz, final int[] rcoords) {
        for (int i = 0; i < rcoords.length / 2; ++i) {
            final int rx = rcoords[i * 2];
            final int rz = rcoords[i * 2 + 1];
            if (rx != 0 || rz != 0) {
                if (Math.abs(dx - rx) < 3 && Math.abs(dz - rz) < 3) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void decorateDeadEnds() {
        for (int x = 0; x < this.maze.width; ++x) {
            for (int z = 0; z < this.maze.depth; ++z) {
                if (!this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(x, z, 3);
                }
                if (this.maze.isWall(x, z, x - 1, z) && !this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(x, z, 1);
                }
                if (this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && !this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(x, z, 0);
                }
                if (this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && !this.maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(x, z, 2);
                }
            }
        }
    }
    
    public void decorateDeadEnd(final int x, final int z, final int f) {
        final int dec = this.rand.nextInt(17);
        switch (dec) {
            case 0: {
                this.deadEndSpiderSpawner(x, z, f);
                break;
            }
            case 1: {
                this.deadEndWebs(x, z, f);
                break;
            }
            case 2: {
                this.deadEndTreasure(x, z, f);
                break;
            }
            case 3: {
                this.deadEndSpawner(x, z, f);
                break;
            }
            case 4: {
                this.deadEndPainting(x, z, f);
                break;
            }
            case 5: {
                this.deadEndTrap(x, z, f);
                break;
            }
            case 6: {
                this.deadEndTrappedChest(x, z, f);
                break;
            }
            case 7: {
                this.deadEndTorch(x, z, f);
                break;
            }
            case 8: {
                this.deadEndTorchRedstone(x, z, f);
                break;
            }
            case 9: {
                this.deadEndFountain(x, z, f);
                break;
            }
            case 10: {
                this.deadEndLavaFountain(x, z, f);
                break;
            }
            case 11: {
                this.deadEndDoorway(x, z, f);
                break;
            }
            case 12: {
                this.deadEndDoor(x, z, f);
                break;
            }
            case 13: {
                this.deadEndDoorSteel(x, z, f);
                break;
            }
            case 14: {
                this.deadEndDoorTreasure(x, z, f);
                break;
            }
        }
    }
    
    void deadEndSpiderSpawner(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        this.deadEndWebs(x, z, f);
        if (f == 0) {
            this.placeMobSpawner(dx + 1, dy + 0, dz + 2, "Spider");
        }
        else if (f == 1) {
            this.placeMobSpawner(dx + 0, dy + 0, dz + 1, "Spider");
        }
        else if (f == 2) {
            this.placeMobSpawner(dx + 1, dy + 0, dz + 0, "Spider");
        }
        else if (f == 3) {
            this.placeMobSpawner(dx + 2, dy + 0, dz + 1, "Spider");
        }
    }
    
    void deadEndWebs(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        if (f == 0) {
            this.worldObj.g(dx + 1, dy + 0, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 0, dy + 1, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 2, dy + 1, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 2, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 0, dy + 0, dz + 2, pb.W.bO);
            this.worldObj.g(dx + 2, dy + 0, dz + 2, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 1, dz + 2, pb.W.bO);
        }
        else if (f == 1) {
            this.worldObj.g(dx + 1, dy + 0, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 1, dz + 0, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 1, dz + 2, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 2, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 0, dy + 0, dz + 0, pb.W.bO);
            this.worldObj.g(dx + 0, dy + 0, dz + 2, pb.W.bO);
            this.worldObj.g(dx + 0, dy + 1, dz + 1, pb.W.bO);
        }
        else if (f == 2) {
            this.worldObj.g(dx + 1, dy + 0, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 0, dy + 1, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 2, dy + 1, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 2, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 0, dy + 0, dz + 0, pb.W.bO);
            this.worldObj.g(dx + 2, dy + 0, dz + 0, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 1, dz + 0, pb.W.bO);
        }
        else if (f == 3) {
            this.worldObj.g(dx + 1, dy + 0, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 1, dz + 0, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 1, dz + 2, pb.W.bO);
            this.worldObj.g(dx + 1, dy + 2, dz + 1, pb.W.bO);
            this.worldObj.g(dx + 2, dy + 0, dz + 0, pb.W.bO);
            this.worldObj.g(dx + 2, dy + 0, dz + 2, pb.W.bO);
            this.worldObj.g(dx + 2, dy + 1, dz + 1, pb.W.bO);
        }
    }
    
    void deadEndTreasure(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        if (f == 0) {
            TFTreasure.underhill_deadend.generate(this.worldObj, this.rand, dx + 1, dy + 0, dz + 2);
        }
        else if (f == 1) {
            TFTreasure.underhill_deadend.generate(this.worldObj, this.rand, dx + 0, dy + 0, dz + 1);
        }
        else if (f == 2) {
            TFTreasure.underhill_deadend.generate(this.worldObj, this.rand, dx + 1, dy + 0, dz + 0);
        }
        else if (f == 3) {
            TFTreasure.underhill_deadend.generate(this.worldObj, this.rand, dx + 2, dy + 0, dz + 1);
        }
    }
    
    void deadEndSpawner(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        final String mobID = (this.rand.nextInt(3) == 0) ? "Skeleton" : "Zombie";
        if (f == 0) {
            this.placeMobSpawner(dx + 1, dy + 0, dz + 2, mobID);
        }
        else if (f == 1) {
            this.placeMobSpawner(dx + 0, dy + 0, dz + 1, mobID);
        }
        else if (f == 2) {
            this.placeMobSpawner(dx + 1, dy + 0, dz + 0, mobID);
        }
        else if (f == 3) {
            this.placeMobSpawner(dx + 2, dy + 0, dz + 1, mobID);
        }
    }
    
    void deadEndPainting(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        final int anum = this.rand.nextInt(7);
        final go[] aenumart = go.values();
        final String artID = aenumart[anum].A;
        mk painting = null;
        if (f == 0) {
            this.worldObj.g(dx + 0, dy + 1, dz + 2, pb.aq.bO);
            painting = new mk(this.worldObj, dx + 1, dy + 1, dz + 3, 0, artID);
            this.worldObj.g(dx + 2, dy + 1, dz + 2, pb.aq.bO);
        }
        else if (f == 1) {
            this.worldObj.g(dx + 0, dy + 1, dz + 0, pb.aq.bO);
            painting = new mk(this.worldObj, dx - 1, dy + 1, dz + 1, 3, artID);
            this.worldObj.g(dx + 0, dy + 1, dz + 2, pb.aq.bO);
        }
        else if (f == 2) {
            this.worldObj.g(dx + 0, dy + 1, dz + 0, pb.aq.bO);
            painting = new mk(this.worldObj, dx + 1, dy + 1, dz - 1, 2, artID);
            this.worldObj.g(dx + 2, dy + 1, dz + 0, pb.aq.bO);
        }
        else if (f == 3) {
            this.worldObj.g(dx + 2, dy + 1, dz + 0, pb.aq.bO);
            painting = new mk(this.worldObj, dx + 3, dy + 1, dz + 1, 1, artID);
            this.worldObj.g(dx + 2, dy + 1, dz + 2, pb.aq.bO);
        }
        if (painting != null && painting.n()) {
            if (!this.worldObj.F) {
                this.worldObj.a((nn)painting);
            }
        }
        else {
            System.out.println("Painting fail!! " + painting.e.A + " at " + painting.b + " , " + painting.c + ", " + painting.d + " : " + painting.a);
        }
    }
    
    void deadEndTrap(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        this.worldObj.g(dx + 1, dy + 0, dz + 1, pb.aK.bO);
        if (f == 0) {
            this.worldObj.g(dx + 1, dy - 1, dz + 2, pb.am.bO);
        }
        else if (f == 1) {
            this.worldObj.g(dx + 0, dy - 1, dz + 1, pb.am.bO);
        }
        else if (f == 2) {
            this.worldObj.g(dx + 1, dy - 1, dz + 0, pb.am.bO);
        }
        else if (f == 3) {
            this.worldObj.g(dx + 2, dy - 1, dz + 1, pb.am.bO);
        }
    }
    
    void deadEndTrappedChest(final int x, final int z, final int f) {
        this.deadEndTrap(x, z, f);
        this.deadEndTreasure(x, z, f);
    }
    
    void deadEndTorch(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        if (f == 0) {
            this.worldObj.g(dx + 1, dy + 1, dz + 2, pb.aq.bO);
        }
        else if (f == 1) {
            this.worldObj.g(dx + 0, dy + 1, dz + 1, pb.aq.bO);
        }
        else if (f == 2) {
            this.worldObj.g(dx + 1, dy + 1, dz + 0, pb.aq.bO);
        }
        else if (f == 3) {
            this.worldObj.g(dx + 2, dy + 1, dz + 1, pb.aq.bO);
        }
    }
    
    void deadEndTorchRedstone(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        if (f == 0) {
            this.worldObj.g(dx + 1, dy + 1, dz + 2, pb.aQ.bO);
        }
        else if (f == 1) {
            this.worldObj.g(dx + 0, dy + 1, dz + 1, pb.aQ.bO);
        }
        else if (f == 2) {
            this.worldObj.g(dx + 1, dy + 1, dz + 0, pb.aQ.bO);
        }
        else if (f == 3) {
            this.worldObj.g(dx + 2, dy + 1, dz + 1, pb.aQ.bO);
        }
    }
    
    void deadEndNook(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        if (f == 0) {
            this.worldObj.g(dx + 0, dy + 0, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 1, dy + 0, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 0, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 1, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 1, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 2, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 1, dy + 2, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 2, dz + 2, pb.t.bO);
        }
        else if (f == 1) {
            this.worldObj.g(dx + 0, dy + 0, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 0, dz + 1, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 0, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 1, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 1, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 2, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 2, dz + 1, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 2, dz + 2, pb.t.bO);
        }
        else if (f == 2) {
            this.worldObj.g(dx + 0, dy + 0, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 1, dy + 0, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 0, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 1, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 1, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 0, dy + 2, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 1, dy + 2, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 2, dz + 0, pb.t.bO);
        }
        else if (f == 3) {
            this.worldObj.g(dx + 2, dy + 0, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 0, dz + 1, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 0, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 1, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 1, dz + 2, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 2, dz + 0, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 2, dz + 1, pb.t.bO);
            this.worldObj.g(dx + 2, dy + 2, dz + 2, pb.t.bO);
        }
    }
    
    void deadEndFountain(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        this.deadEndNook(x, z, f);
        this.worldObj.g(dx + 1, dy - 1, dz + 1, 0);
        if (f == 0) {
            this.worldObj.g(dx + 1, dy + 1, dz + 2, pb.A.bO);
        }
        else if (f == 1) {
            this.worldObj.g(dx + 0, dy + 1, dz + 1, pb.A.bO);
        }
        else if (f == 2) {
            this.worldObj.g(dx + 1, dy + 1, dz + 0, pb.A.bO);
        }
        else if (f == 3) {
            this.worldObj.g(dx + 2, dy + 1, dz + 1, pb.A.bO);
        }
    }
    
    void deadEndLavaFountain(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        this.deadEndNook(x, z, f);
        this.worldObj.g(dx + 1, dy - 1, dz + 1, 0);
        if (f == 0) {
            this.worldObj.g(dx + 1, dy + 1, dz + 2, pb.C.bO);
        }
        else if (f == 1) {
            this.worldObj.g(dx + 0, dy + 1, dz + 1, pb.C.bO);
        }
        else if (f == 2) {
            this.worldObj.g(dx + 1, dy + 1, dz + 0, pb.C.bO);
        }
        else if (f == 3) {
            this.worldObj.g(dx + 2, dy + 1, dz + 1, pb.C.bO);
        }
    }
    
    void deadEndDoorway(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        if (f == 0) {
            this.worldObj.d(dx + 0, dy + 0, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 0, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 1, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 1, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 2, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 1, dy + 2, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 2, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
        }
        else if (f == 1) {
            this.worldObj.d(dx + 2, dy + 0, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 0, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 1, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 1, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 2, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 2, dz + 1, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 2, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
        }
        else if (f == 2) {
            this.worldObj.d(dx + 0, dy + 0, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 0, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 1, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 1, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 2, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 1, dy + 2, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 2, dy + 2, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
        }
        else if (f == 3) {
            this.worldObj.d(dx + 0, dy + 0, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 0, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 1, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 1, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 2, dz + 0, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 2, dz + 1, this.maze.wallBlockID, this.maze.wallBlockMeta);
            this.worldObj.d(dx + 0, dy + 2, dz + 2, this.maze.wallBlockID, this.maze.wallBlockMeta);
        }
    }
    
    void deadEndDoor(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        this.deadEndDoorway(x, z, f);
        if (f == 0) {
            this.worldObj.d(dx + 1, dy + 0, dz + 0, pb.aE.bO, 1);
            this.worldObj.d(dx + 1, dy + 1, dz + 0, pb.aE.bO, 9);
        }
        else if (f == 1) {
            this.worldObj.d(dx + 2, dy + 0, dz + 1, pb.aE.bO, 2);
            this.worldObj.d(dx + 2, dy + 1, dz + 1, pb.aE.bO, 10);
        }
        else if (f == 2) {
            this.worldObj.d(dx + 1, dy + 0, dz + 2, pb.aE.bO, 3);
            this.worldObj.d(dx + 1, dy + 1, dz + 2, pb.aE.bO, 11);
        }
        else if (f == 3) {
            this.worldObj.d(dx + 0, dy + 0, dz + 1, pb.aE.bO, 0);
            this.worldObj.d(dx + 0, dy + 1, dz + 1, pb.aE.bO, 8);
        }
    }
    
    void deadEndDoorSteel(final int x, final int z, final int f) {
        final int dx = this.maze.getWorldX(x);
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z);
        this.deadEndDoorway(x, z, f);
        if (f == 0) {
            this.worldObj.d(dx + 1, dy + 0, dz + 0, pb.aL.bO, 1);
            this.worldObj.d(dx + 1, dy + 1, dz + 0, pb.aL.bO, 9);
        }
        else if (f == 1) {
            this.worldObj.d(dx + 2, dy + 0, dz + 1, pb.aL.bO, 2);
            this.worldObj.d(dx + 2, dy + 1, dz + 1, pb.aL.bO, 10);
        }
        else if (f == 2) {
            this.worldObj.d(dx + 1, dy + 0, dz + 2, pb.aL.bO, 3);
            this.worldObj.d(dx + 1, dy + 1, dz + 2, pb.aL.bO, 11);
        }
        else if (f == 3) {
            this.worldObj.d(dx + 0, dy + 0, dz + 1, pb.aL.bO, 0);
            this.worldObj.d(dx + 0, dy + 1, dz + 1, pb.aL.bO, 8);
        }
    }
    
    void deadEndDoorTreasure(final int x, final int z, final int f) {
        this.deadEndDoor(x, z, f);
        this.deadEndTreasure(x, z, f);
    }
    
    protected boolean placeMobSpawner(final int dx, final int dy, final int dz, final String mobID) {
        this.worldObj.g(dx, dy, dz, pb.as.bO);
        final cj ms = (cj)this.worldObj.b(dx, dy, dz);
        if (ms != null) {
            ms.a(mobID);
            return true;
        }
        return false;
    }
    
    void decorate3x3Rooms(final int[] rcoords) {
        for (int i = 0; i < rcoords.length / 2; ++i) {
            final int dx = rcoords[i * 2];
            final int dz = rcoords[i * 2 + 1];
            this.decorate3x3Room(dx, dz);
        }
    }
    
    void decorate3x3Room(final int x, final int z) {
        final int dx = this.maze.getWorldX(x) + 1;
        final int dy = this.maze.worldY;
        final int dz = this.maze.getWorldZ(z) + 1;
        this.roomSpawner(dx, dy, dz, 11);
        if (!this.roomTreasure(dx, dy, dz, 11) || this.rand.nextInt(2) == 0) {
            this.roomTreasure(dx, dy, dz, 11);
        }
        this.roomSpiderwebs(dx, dy, dz, 11);
    }
    
    private boolean roomSpawner(final int dx, final int dy, final int dz, final int diameter) {
        final int rx = this.rand.nextInt(diameter) + dx - diameter / 2;
        final int rz = this.rand.nextInt(diameter) + dz - diameter / 2;
        return this.placeMobSpawner(rx, dy, rz, "Skeleton");
    }
    
    private boolean roomTreasure(final int dx, final int dy, final int dz, final int diameter) {
        final int rx = this.rand.nextInt(diameter) + dx - diameter / 2;
        final int rz = this.rand.nextInt(diameter) + dz - diameter / 2;
        return this.worldObj.a(rx, dy, rz) == 0 && TFTreasure.underhill_room.generate(this.worldObj, this.rand, rx, dy, rz);
    }
    
    private boolean roomSpiderwebs(final int dx, final int dy, final int dz, final int diameter) {
        int rx = dx;
        int rz = dz;
        final int corner = this.rand.nextInt(4);
        if (corner == 0) {
            rx -= 5;
            rz -= 5;
        }
        else if (corner == 1) {
            rx += 5;
            rz -= 5;
        }
        else if (corner == 2) {
            rx -= 5;
            rz += 5;
        }
        else if (corner == 3) {
            rx += 5;
            rz += 5;
        }
        boolean flag = false;
        flag |= this.roomSpiderweb(rx, dy, rz, 3);
        flag |= this.roomSpiderweb(rx, dy, rz, 3);
        flag |= this.roomSpiderweb(rx, dy, rz, 3);
        return flag;
    }
    
    private boolean roomSpiderweb(final int dx, final int dy, final int dz, final int diameter) {
        final int rx = this.rand.nextInt(diameter) + dx - diameter / 2;
        final int rz = this.rand.nextInt(diameter) + dz - diameter / 2;
        if (this.worldObj.a(rx, dy + 2, rz) != 0) {
            return false;
        }
        this.worldObj.g(rx, dy + 2, rz, pb.W.bO);
        return true;
    }
}
