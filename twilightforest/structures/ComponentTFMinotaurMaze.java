// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.List;
import java.util.Random;

public class ComponentTFMinotaurMaze extends StructureTFComponent
{
    private static final int FLOOR_LEVEL = 1;
    TFMaze maze;
    int[] rcoords;
    private int level;
    
    public ComponentTFMinotaurMaze(final int index, final int x, final int y, final int z, final int entranceX, final int entranceZ, final int level) {
        super(index);
        this.setCoordBaseMode(0);
        this.level = level;
        this.e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -this.getRadius(), 0, -this.getRadius(), this.getRadius() * 2, 5, this.getRadius() * 2, 0);
        (this.maze = new TFMaze(this.getMazeSize(), this.getMazeSize())).setSeed(this.e.a * 90342903 + this.e.b * 90342903 ^ this.e.c);
        final int nrooms = 7;
        (this.rcoords = new int[nrooms * 2])[0] = entranceX;
        this.rcoords[1] = entranceZ;
        this.maze.carveRoom1(entranceX, entranceZ);
        for (int i = 1; i < nrooms; ++i) {
            int rx;
            int rz;
            do {
                rx = this.maze.rand.nextInt(this.getMazeSize() - 2) + 1;
                rz = this.maze.rand.nextInt(this.getMazeSize() - 2) + 1;
            } while (this.isNearRoom(rx, rz, this.rcoords, (i == 1) ? 7 : 4));
            this.maze.carveRoom1(rx, rz);
            this.rcoords[i * 2] = rx;
            this.rcoords[i * 2 + 1] = rz;
        }
        this.maze.generateRecursiveBacktracker(0, 0);
    }
    
    public ComponentTFMinotaurMaze(final int index, final int x, final int y, final int z, final int level) {
        this(index, x, y, z, 11, 11, level);
    }
    
    protected ComponentTFMazeRoom makeRoom(final Random random, final int i, final int dx, final int dz) {
        ComponentTFMazeRoom room = null;
        final int worldX = this.e.a + dx * 5 - 4;
        final int worldY = this.e.b;
        final int worldZ = this.e.c + dz * 5 - 4;
        if (i == 0) {
            room = new ComponentTFMazeRoom(3 + i, random, worldX, worldY, worldZ);
        }
        else if (i == 1) {
            if (this.level == 1) {
                room = new ComponentTFMazeRoomExit(3 + i, random, worldX, worldY, worldZ);
            }
            else {
                room = new ComponentTFMazeRoomBoss(3 + i, random, worldX, worldY, worldZ);
            }
        }
        else if (i == 2 || i == 3) {
            if (this.level == 1) {
                room = new ComponentTFMazeRoomCollapse(3 + i, random, worldX, worldY, worldZ);
            }
            else {
                room = new ComponentTFMazeMushRoom(3 + i, random, worldX, worldY, worldZ);
            }
        }
        else if (i == 4) {
            if (this.level == 1) {
                room = new ComponentTFMazeRoomFountain(3 + i, random, worldX, worldY, worldZ);
            }
            else {
                room = new ComponentTFMazeRoomVault(3 + i, random, worldX, worldY, worldZ);
            }
        }
        else {
            room = new ComponentTFMazeRoomSpawnerChests(3 + i, random, worldX, worldY, worldZ);
        }
        return room;
    }
    
    protected void decorateDeadEndsCorridors(final Random random, final List list) {
        for (int x = 0; x < this.maze.width; ++x) {
            for (int z = 0; z < this.maze.depth; ++z) {
                StructureTFComponent component = null;
                if (!this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, 3);
                }
                if (this.maze.isWall(x, z, x - 1, z) && !this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, 1);
                }
                if (this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && !this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, 0);
                }
                if (this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && !this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, 2);
                }
                if (!this.maze.isWall(x, z, x - 1, z) && !this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1) && this.maze.isWall(x - 1, z, x - 1, z - 1) && this.maze.isWall(x - 1, z, x - 1, z + 1) && this.maze.isWall(x + 1, z, x + 1, z - 1) && this.maze.isWall(x + 1, z, x + 1, z + 1)) {
                    component = this.makeCorridor(random, x, z, 1);
                }
                if (!this.maze.isWall(x, z, x, z - 1) && !this.maze.isWall(x, z, x, z + 1) && this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z - 1, x - 1, z - 1) && this.maze.isWall(x, z - 1, x + 1, z - 1) && this.maze.isWall(x, z + 1, x - 1, z + 1) && this.maze.isWall(x, z + 1, x + 1, z + 1)) {
                    component = this.makeCorridor(random, x, z, 0);
                }
                if (component != null) {
                    list.add(component);
                    component.a((aez)this, list, random);
                }
            }
        }
    }
    
    protected ComponentTFMazeDeadEnd makeDeadEnd(final Random random, final int dx, final int dz, final int rotation) {
        final int worldX = this.e.a + dx * 5 + 1;
        final int worldY = this.e.b;
        final int worldZ = this.e.c + dz * 5 + 1;
        final int decorationType = random.nextInt(8);
        switch (decorationType) {
            default: {
                return new ComponentTFMazeDeadEnd(4, worldX, worldY, worldZ, rotation);
            }
            case 1: {
                return new ComponentTFMazeDeadEndChest(4, worldX, worldY, worldZ, rotation);
            }
            case 2: {
                return new ComponentTFMazeDeadEndTrappedChest(4, worldX, worldY, worldZ, rotation);
            }
            case 3: {
                return new ComponentTFMazeDeadEndTorches(4, worldX, worldY, worldZ, rotation);
            }
            case 4: {
                return new ComponentTFMazeDeadEndFountain(4, worldX, worldY, worldZ, rotation);
            }
            case 5: {
                return new ComponentTFMazeDeadEndFountainLava(4, worldX, worldY, worldZ, rotation);
            }
            case 6: {
                return new ComponentTFMazeDeadEndPainting(4, worldX, worldY, worldZ, rotation);
            }
            case 7: {
                return (this.level == 1) ? new ComponentTFMazeDeadEndRoots(4, worldX, worldY, worldZ, rotation) : new ComponentTFMazeDeadEndShrooms(4, worldX, worldY, worldZ, rotation);
            }
        }
    }
    
    protected ComponentTFMazeCorridor makeCorridor(final Random random, final int dx, final int dz, final int rotation) {
        final int worldX = this.e.a + dx * 5 + 1;
        final int worldY = this.e.b;
        final int worldZ = this.e.c + dz * 5 + 1;
        final int decorationType = random.nextInt(5);
        switch (decorationType) {
            default: {
                return null;
            }
            case 1: {
                return new ComponentTFMazeCorridor(4, worldX, worldY, worldZ, rotation);
            }
            case 2: {
                return new ComponentTFMazeCorridorIronFence(4, worldX, worldY, worldZ, rotation);
            }
            case 3: {
                return null;
            }
            case 4: {
                return (this.level == 1) ? new ComponentTFMazeCorridorRoots(4, worldX, worldY, worldZ, rotation) : new ComponentTFMazeCorridorShrooms(4, worldX, worldY, worldZ, rotation);
            }
        }
    }
    
    public void a(final aez structurecomponent, final List list, final Random random) {
        super.a(structurecomponent, list, random);
        if (this.level == 1) {
            final int centerX = this.e.a + (this.e.d - this.e.a) / 2;
            final int centerZ = this.e.c + (this.e.f - this.e.c) / 2;
            final ComponentTFMinotaurMaze maze = new ComponentTFMinotaurMaze(1, centerX, this.e.b - 10, centerZ, this.rcoords[2], this.rcoords[3], 2);
            list.add(maze);
            maze.a(this, list, random);
        }
        for (int i = 0; i < this.rcoords.length / 2; ++i) {
            final int dx = this.rcoords[i * 2];
            final int dz = this.rcoords[i * 2 + 1];
            final ComponentTFMazeRoom room = this.makeRoom(random, i, dx, dz);
            list.add(room);
            room.a(this, list, random);
        }
        this.decorateDeadEndsCorridors(random, list);
    }
    
    public boolean a(final yc world, final Random rand, final acn sbb) {
        if (this.level == 2) {
            this.a(world, sbb, 0, -1, 0, this.getDiameter() + 2, 6, this.getDiameter() + 2, amq.C.cm, 0, false);
        }
        this.a(world, sbb, 1, 1, 1, this.getDiameter(), 4, this.getDiameter());
        this.a(world, sbb, 1, 5, 1, this.getDiameter(), 5, this.getDiameter(), TFBlocks.mazestone.cm, 0, amq.w.cm, 0, this.level == 1);
        this.a(world, sbb, 1, 0, 1, this.getDiameter(), 0, this.getDiameter(), TFBlocks.mazestone.cm, 6, amq.w.cm, 0, false);
        this.maze.headBlockID = TFBlocks.mazestone.cm;
        this.maze.headBlockMeta = 3;
        this.maze.wallBlockID = TFBlocks.mazestone.cm;
        this.maze.wallBlockMeta = 1;
        this.maze.rootBlockID = TFBlocks.mazestone.cm;
        this.maze.rootBlockMeta = 3;
        this.maze.pillarBlockID = TFBlocks.mazestone.cm;
        this.maze.pillarBlockMeta = 2;
        this.maze.wallVar0ID = TFBlocks.mazestone.cm;
        this.maze.wallVar0Meta = 4;
        this.maze.wallVarRarity = 0.2f;
        this.maze.torchRarity = 0.05f;
        this.maze.tall = 2;
        this.maze.head = 1;
        this.maze.roots = 1;
        this.maze.oddBias = 4;
        this.maze.copyToStructure(world, rand, 1, 2, 1, this, sbb);
        return true;
    }
    
    public int getMazeSize() {
        return 22;
    }
    
    public int getRadius() {
        return (int)(this.getMazeSize() * 2.5);
    }
    
    public int getDiameter() {
        return this.getMazeSize() * 5;
    }
    
    protected boolean isNearRoom(final int dx, final int dz, final int[] rcoords, final int range) {
        if (dx == 1 && dz == 1) {
            return true;
        }
        for (int i = 0; i < rcoords.length / 2; ++i) {
            final int rx = rcoords[i * 2];
            final int rz = rcoords[i * 2 + 1];
            if (rx != 0 || rz != 0) {
                if (Math.abs(dx - rx) < range && Math.abs(dz - rz) < range) {
                    return true;
                }
            }
        }
        return false;
    }
}
