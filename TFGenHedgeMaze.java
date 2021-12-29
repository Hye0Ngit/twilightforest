import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenHedgeMaze extends TFGenerator
{
    int size;
    TFMaze maze;
    Random rand;
    
    public TFGenHedgeMaze(final int size) {
        this.size = size;
    }
    
    @Override
    public boolean a(final fq world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        this.rand = rand;
        final int sx = x - 7 - this.size * 16;
        final int sz = z - 7 - this.size * 16;
        final int msize = 16;
        this.maze = new TFMaze(msize, msize);
        this.maze.oddBias = 2;
        this.maze.torchBlockID = TFBlocks.firefly.bO;
        this.maze.wallBlockID = TFBlocks.hedge.bO;
        this.maze.type = 4;
        this.maze.tall = 3;
        this.maze.roots = 3;
        this.fill(sx, y - 1, sz, msize * 3, 1, msize * 3, ud.w.bO, 0);
        this.putBlockAndMetadata(sx - 1, y, sz + 23, ud.bh.bO, 1, true);
        this.putBlockAndMetadata(sx - 1, y, sz + 28, ud.bh.bO, 1, true);
        this.putBlockAndMetadata(sx + 49, y, sz + 23, ud.bh.bO, 3, true);
        this.putBlockAndMetadata(sx + 49, y, sz + 28, ud.bh.bO, 3, true);
        this.putBlockAndMetadata(sx + 23, y, sz - 1, ud.bh.bO, 2, true);
        this.putBlockAndMetadata(sx + 28, y, sz - 1, ud.bh.bO, 2, true);
        this.putBlockAndMetadata(sx + 23, y, sz + 49, ud.bh.bO, 0, true);
        this.putBlockAndMetadata(sx + 28, y, sz + 49, ud.bh.bO, 0, true);
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
        this.maze.add4Exits();
        this.maze.copyToWorld(this.worldObj, sx, y, sz);
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
        this.roomSpawner(dx, dy, dz, 8);
        if (!this.roomTreasure(dx, dy, dz, 8)) {
            this.roomTreasure(dx, dy, dz, 8);
        }
        if (!this.roomJackO(dx, dy, dz, 8) || this.rand.nextInt(4) == 0) {
            this.roomJackO(dx, dy, dz, 8);
        }
    }
    
    private boolean roomSpawner(final int dx, final int dy, final int dz, final int diameter) {
        final int rx = this.rand.nextInt(diameter) + dx - diameter / 2;
        final int rz = this.rand.nextInt(diameter) + dz - diameter / 2;
        String mobID = null;
        switch (this.rand.nextInt(3)) {
            case 1: {
                mobID = "Swarm Spider";
                break;
            }
            case 2: {
                mobID = "Hostile Wolf";
                break;
            }
            default: {
                mobID = "Hedge Spider";
                break;
            }
        }
        return this.placeMobSpawner(rx, dy, rz, mobID);
    }
    
    private boolean roomTreasure(final int dx, final int dy, final int dz, final int diameter) {
        final int rx = this.rand.nextInt(diameter) + dx - diameter / 2;
        final int rz = this.rand.nextInt(diameter) + dz - diameter / 2;
        return this.worldObj.a(rx, dy, rz) == 0 && TFTreasure.hedgemaze.generate(this.worldObj, this.rand, rx, dy, rz);
    }
    
    protected boolean placeMobSpawner(final int dx, final int dy, final int dz, final String mobID) {
        this.worldObj.e(dx, dy, dz, ud.au.bO);
        final dj ms = (dj)this.worldObj.b(dx, dy, dz);
        if (ms != null) {
            ms.a(mobID);
            return true;
        }
        return false;
    }
    
    private boolean roomJackO(final int dx, final int dy, final int dz, final int diameter) {
        final int rx = this.rand.nextInt(diameter) + dx - diameter / 2;
        final int rz = this.rand.nextInt(diameter) + dz - diameter / 2;
        if (this.worldObj.a(rx, dy, rz) != 0) {
            return false;
        }
        this.worldObj.b(rx, dy, rz, ud.bh.bO, this.rand.nextInt(4));
        return true;
    }
}
