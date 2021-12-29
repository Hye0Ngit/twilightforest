// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFTreasure;
import twilightforest.TFBlocks;
import java.util.Random;

public class ComponentTFHillMaze extends StructureTFComponent
{
    private static final int FLOOR_LEVEL = 1;
    private int hillSize;
    
    public ComponentTFHillMaze(final int i, final int x, final int y, final int z, final int hsize) {
        super(i);
        this.hillSize = hsize;
        this.setCoordBaseMode(0);
        this.e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -this.getRadius(), 0, -this.getRadius(), this.getRadius() * 2, 5, this.getRadius() * 2, 0);
    }
    
    public boolean a(final xv world, final Random rand, final acg sbb) {
        this.a(world, sbb, 0, 1, 0, this.getDiameter(), 3, this.getDiameter(), 0, 0, false);
        this.a(world, sbb, 0, 0, 0, this.getDiameter(), 0, this.getDiameter(), TFBlocks.mazestone.cm, 0, false);
        this.a(world, sbb, 0, 4, 0, this.getDiameter(), 4, this.getDiameter(), TFBlocks.mazestone.cm, 0, true);
        final TFMaze maze = new TFMaze(this.getMazeSize(), this.getMazeSize());
        maze.wallBlockID = TFBlocks.mazestone.cm;
        maze.wallBlockMeta = 3;
        maze.torchRarity = 0.05f;
        maze.setSeed(world.E() + this.e.a * this.e.c);
        final int nrooms = this.getMazeSize() / 3;
        final int[] rcoords = new int[nrooms * 2];
        for (int i = 0; i < nrooms; ++i) {
            int rx;
            int rz;
            do {
                rx = maze.rand.nextInt(this.getMazeSize() - 2) + 1;
                rz = maze.rand.nextInt(this.getMazeSize() - 2) + 1;
            } while (this.isNearRoom(rx, rz, rcoords));
            maze.carveRoom1(rx, rz);
            rcoords[i * 2] = rx;
            rcoords[i * 2 + 1] = rz;
        }
        maze.generateRecursiveBacktracker(0, 0);
        maze.add4Exits();
        maze.copyToStructure(world, rand, 0, 1, 0, this, sbb);
        this.decorate3x3Rooms(world, rcoords, sbb);
        return true;
    }
    
    public int getMazeSize() {
        return (this.hillSize == 1) ? 11 : ((this.hillSize == 2) ? 19 : 27);
    }
    
    public int getRadius() {
        return this.getMazeSize() * 2;
    }
    
    public int getDiameter() {
        return this.getMazeSize() * 4;
    }
    
    protected boolean isNearRoom(final int dx, final int dz, final int[] rcoords) {
        if (dx == 1 && dz == 1) {
            return true;
        }
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
    
    void decorate3x3Rooms(final xv world, final int[] rcoords, final acg sbb) {
        for (int i = 0; i < rcoords.length / 2; ++i) {
            int dx = rcoords[i * 2];
            int dz = rcoords[i * 2 + 1];
            dx = dx * 4 + 2;
            dz = dz * 4 + 2;
            this.decorate3x3Room(world, dx, dz, sbb);
        }
    }
    
    void decorate3x3Room(final xv world, final int x, final int z, final acg sbb) {
        final Random roomRNG = new Random(world.E() ^ (long)(x + z));
        this.roomSpawner(world, roomRNG, x, z, 8, sbb);
        this.roomTreasure(world, roomRNG, x, z, 8, sbb);
        if (roomRNG.nextInt(4) == 0) {
            this.roomTreasure(world, roomRNG, x, z, 8, sbb);
        }
    }
    
    private void roomSpawner(final xv world, final Random rand, final int x, final int z, final int diameter, final acg sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        String mobID = null;
        switch (rand.nextInt(3)) {
            case 1: {
                mobID = "Skeleton";
                break;
            }
            case 2: {
                mobID = "Zombie";
                break;
            }
            default: {
                mobID = "Spider";
                break;
            }
        }
        this.placeSpawnerAtCurrentPosition(world, rand, rx, 1, rz, mobID, sbb);
    }
    
    private void roomTreasure(final xv world, final Random rand, final int x, final int z, final int diameter, final acg sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        this.placeTreasureAtCurrentPosition(world, rand, rx, 1, rz, TFTreasure.labyrinth_room, sbb);
    }
}
