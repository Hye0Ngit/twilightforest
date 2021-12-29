// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.List;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.structures.TFMaze;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFMinotaurMaze extends StructureTFComponent
{
    private static final int FLOOR_LEVEL = 1;
    TFMaze maze;
    int[] rcoords;
    private int level;
    
    public ComponentTFMinotaurMaze() {
    }
    
    public ComponentTFMinotaurMaze(final int index, final int x, final int y, final int z, final int entranceX, final int entranceZ, final int level) {
        super(index);
        this.setCoordBaseMode(0);
        this.level = level;
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -this.getRadius(), 0, -this.getRadius(), this.getRadius() * 2, 5, this.getRadius() * 2, 0);
        this.maze = new TFMaze(this.getMazeSize(), this.getMazeSize());
        this.setFixedMazeSeed();
        final int nrooms = 7;
        this.rcoords = new int[nrooms * 2];
        this.addRoomsToMaze(entranceX, entranceZ, nrooms);
        this.maze.generateRecursiveBacktracker(0, 0);
    }
    
    private void addRoomsToMaze(final int entranceX, final int entranceZ, final int nrooms) {
        this.rcoords[0] = entranceX;
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
    }
    
    private void setFixedMazeSeed() {
        this.maze.setSeed(this.field_74887_e.field_78897_a * 90342903 + this.field_74887_e.field_78895_b * 90342903 ^ this.field_74887_e.field_78896_c);
    }
    
    public ComponentTFMinotaurMaze(final int index, final int x, final int y, final int z, final int level) {
        this(index, x, y, z, 11, 11, level);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("mazeLevel", this.level);
        par1NBTTagCompound.func_74783_a("roomCoords", this.rcoords);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.level = par1NBTTagCompound.func_74762_e("mazeLevel");
        this.rcoords = par1NBTTagCompound.func_74759_k("roomCoords");
        this.maze = new TFMaze(this.getMazeSize(), this.getMazeSize());
        this.setFixedMazeSeed();
        for (int i = 2; i < this.rcoords.length; ++i) {
            this.rcoords[i] = 0;
        }
        this.addRoomsToMaze(this.rcoords[0], this.rcoords[1], (this.rcoords.length + 1) / 2);
        this.maze.generateRecursiveBacktracker(0, 0);
    }
    
    protected ComponentTFMazeRoom makeRoom(final Random random, final int i, final int dx, final int dz) {
        ComponentTFMazeRoom room = null;
        final int worldX = this.field_74887_e.field_78897_a + dx * 5 - 4;
        final int worldY = this.field_74887_e.field_78895_b;
        final int worldZ = this.field_74887_e.field_78896_c + dz * 5 - 4;
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
                    component.func_74861_a((StructureComponent)this, list, random);
                }
            }
        }
    }
    
    protected ComponentTFMazeDeadEnd makeDeadEnd(final Random random, final int dx, final int dz, final int rotation) {
        final int worldX = this.field_74887_e.field_78897_a + dx * 5 + 1;
        final int worldY = this.field_74887_e.field_78895_b;
        final int worldZ = this.field_74887_e.field_78896_c + dz * 5 + 1;
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
        final int worldX = this.field_74887_e.field_78897_a + dx * 5 + 1;
        final int worldY = this.field_74887_e.field_78895_b;
        final int worldZ = this.field_74887_e.field_78896_c + dz * 5 + 1;
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
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random random) {
        super.func_74861_a(structurecomponent, list, random);
        if (this.level == 1) {
            final int centerX = this.field_74887_e.field_78897_a + (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) / 2;
            final int centerZ = this.field_74887_e.field_78896_c + (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c) / 2;
            final ComponentTFMinotaurMaze maze = new ComponentTFMinotaurMaze(1, centerX, this.field_74887_e.field_78895_b - 10, centerZ, this.rcoords[2], this.rcoords[3], 2);
            list.add(maze);
            maze.func_74861_a(this, list, random);
        }
        for (int i = 0; i < this.rcoords.length / 2; ++i) {
            final int dx = this.rcoords[i * 2];
            final int dz = this.rcoords[i * 2 + 1];
            final ComponentTFMazeRoom room = this.makeRoom(random, i, dx, dz);
            list.add(room);
            room.func_74861_a(this, list, random);
        }
        this.decorateDeadEndsCorridors(random, list);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.level == 2) {
            this.func_74884_a(world, sbb, 0, -1, 0, this.getDiameter() + 2, 6, this.getDiameter() + 2, Block.field_71986_z.field_71990_ca, 0, false);
        }
        this.func_74878_a(world, sbb, 1, 1, 1, this.getDiameter(), 4, this.getDiameter());
        this.func_74872_a(world, sbb, 1, 5, 1, this.getDiameter(), 5, this.getDiameter(), TFBlocks.mazestone.field_71990_ca, 0, Block.field_71981_t.field_71990_ca, 0, this.level == 1);
        this.func_74872_a(world, sbb, 1, 0, 1, this.getDiameter(), 0, this.getDiameter(), TFBlocks.mazestone.field_71990_ca, 6, Block.field_71981_t.field_71990_ca, 0, false);
        this.maze.headBlockID = TFBlocks.mazestone.field_71990_ca;
        this.maze.headBlockMeta = 3;
        this.maze.wallBlockID = TFBlocks.mazestone.field_71990_ca;
        this.maze.wallBlockMeta = 1;
        this.maze.rootBlockID = TFBlocks.mazestone.field_71990_ca;
        this.maze.rootBlockMeta = 3;
        this.maze.pillarBlockID = TFBlocks.mazestone.field_71990_ca;
        this.maze.pillarBlockMeta = 2;
        this.maze.wallVar0ID = TFBlocks.mazestone.field_71990_ca;
        this.maze.wallVar0Meta = 4;
        this.maze.wallVarRarity = 0.2f;
        this.maze.torchRarity = 0.05f;
        this.maze.tall = 2;
        this.maze.head = 1;
        this.maze.roots = 1;
        this.maze.oddBias = 4;
        this.maze.copyToStructure(world, 1, 2, 1, this, sbb);
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
