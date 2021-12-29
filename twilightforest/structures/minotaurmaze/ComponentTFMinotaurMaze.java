// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MazestoneVariant;
import twilightforest.block.BlockTFMazestone;
import twilightforest.TFConfig;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.List;
import java.util.Random;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.TFMaze;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFMinotaurMaze extends StructureTFComponentOld
{
    TFMaze maze;
    int[] rcoords;
    private int level;
    
    public ComponentTFMinotaurMaze() {
    }
    
    public ComponentTFMinotaurMaze(final TFFeature feature, final int index, final int x, final int y, final int z, final int entranceX, final int entranceZ, final int level) {
        super(feature, index);
        this.func_186164_a(EnumFacing.SOUTH);
        this.level = level;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -this.getRadius(), 0, -this.getRadius(), this.getRadius() * 2, 5, this.getRadius() * 2, EnumFacing.SOUTH);
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
    
    public ComponentTFMinotaurMaze(final TFFeature feature, final int index, final int x, final int y, final int z, final int level) {
        this(feature, index, x, y, z, 11, 11, level);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("mazeLevel", this.level);
        tagCompound.func_74783_a("roomCoords", this.rcoords);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.level = tagCompound.func_74762_e("mazeLevel");
        this.rcoords = tagCompound.func_74759_k("roomCoords");
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
            room = new ComponentTFMazeRoom(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
        }
        else if (i == 1) {
            if (this.level == 1) {
                room = new ComponentTFMazeRoomExit(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
            else {
                room = new ComponentTFMazeRoomBoss(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
        }
        else if (i == 2 || i == 3) {
            if (this.level == 1) {
                room = new ComponentTFMazeRoomCollapse(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
            else {
                room = new ComponentTFMazeMushRoom(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
        }
        else if (i == 4) {
            if (this.level == 1) {
                room = new ComponentTFMazeRoomFountain(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
            else {
                room = new ComponentTFMazeRoomVault(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
        }
        else {
            room = new ComponentTFMazeRoomSpawnerChests(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
        }
        return room;
    }
    
    protected void decorateDeadEndsCorridors(final Random random, final List<StructureComponent> list) {
        for (int x = 0; x < this.maze.width; ++x) {
            for (int z = 0; z < this.maze.depth; ++z) {
                StructureTFComponentOld component = null;
                if (!this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, EnumFacing.EAST);
                }
                if (this.maze.isWall(x, z, x - 1, z) && !this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, EnumFacing.WEST);
                }
                if (this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && !this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, EnumFacing.SOUTH);
                }
                if (this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && !this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, EnumFacing.NORTH);
                }
                if (!this.maze.isWall(x, z, x - 1, z) && !this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1) && this.maze.isWall(x - 1, z, x - 1, z - 1) && this.maze.isWall(x - 1, z, x - 1, z + 1) && this.maze.isWall(x + 1, z, x + 1, z - 1) && this.maze.isWall(x + 1, z, x + 1, z + 1)) {
                    component = this.makeCorridor(random, x, z, EnumFacing.WEST);
                }
                if (!this.maze.isWall(x, z, x, z - 1) && !this.maze.isWall(x, z, x, z + 1) && this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z - 1, x - 1, z - 1) && this.maze.isWall(x, z - 1, x + 1, z - 1) && this.maze.isWall(x, z + 1, x - 1, z + 1) && this.maze.isWall(x, z + 1, x + 1, z + 1)) {
                    component = this.makeCorridor(random, x, z, EnumFacing.SOUTH);
                }
                if (component != null) {
                    list.add(component);
                    component.func_74861_a((StructureComponent)this, (List)list, random);
                }
            }
        }
    }
    
    protected ComponentTFMazeDeadEnd makeDeadEnd(final Random random, final int dx, final int dz, final EnumFacing rotation) {
        final int worldX = this.field_74887_e.field_78897_a + dx * 5 + 1;
        final int worldY = this.field_74887_e.field_78895_b;
        final int worldZ = this.field_74887_e.field_78896_c + dz * 5 + 1;
        final int decorationType = random.nextInt(8);
        switch (decorationType) {
            default: {
                return new ComponentTFMazeDeadEnd(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 1: {
                return new ComponentTFMazeDeadEndChest(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 2: {
                return random.nextBoolean() ? new ComponentTFMazeDeadEndTripwireChest(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation) : new ComponentTFMazeDeadEndTrappedChest(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 3: {
                return new ComponentTFMazeDeadEndTorches(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 4: {
                return new ComponentTFMazeDeadEndFountain(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 5: {
                return new ComponentTFMazeDeadEndFountainLava(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 6: {
                return new ComponentTFMazeDeadEndPainting(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 7: {
                return (this.level == 1) ? new ComponentTFMazeDeadEndRoots(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation) : new ComponentTFMazeDeadEndShrooms(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
        }
    }
    
    protected ComponentTFMazeCorridor makeCorridor(final Random random, final int dx, final int dz, final EnumFacing rotation) {
        final int worldX = this.field_74887_e.field_78897_a + dx * 5 + 1;
        final int worldY = this.field_74887_e.field_78895_b;
        final int worldZ = this.field_74887_e.field_78896_c + dz * 5 + 1;
        final int decorationType = random.nextInt(5);
        switch (decorationType) {
            default: {
                return null;
            }
            case 1: {
                return new ComponentTFMazeCorridor(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 2: {
                return new ComponentTFMazeCorridorIronFence(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 3: {
                return null;
            }
            case 4: {
                return (this.level == 1) ? new ComponentTFMazeCorridorRoots(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation) : new ComponentTFMazeCorridorShrooms(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
        }
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(structurecomponent, (List)list, random);
        if (this.level == 1) {
            final int centerX = this.field_74887_e.field_78897_a + (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) / 2;
            final int centerZ = this.field_74887_e.field_78896_c + (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c) / 2;
            final ComponentTFMinotaurMaze maze = new ComponentTFMinotaurMaze(this.getFeatureType(), 1, centerX, this.field_74887_e.field_78895_b - 10, centerZ, this.rcoords[2], this.rcoords[3], 2);
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
        final IBlockState bedrock = Blocks.field_150357_h.func_176223_P();
        final IBlockState stone = Blocks.field_150348_b.func_176223_P();
        final IBlockState mazestone = TFBlocks.maze_stone.func_176223_P();
        if (this.level == 2) {
            this.func_175804_a(world, sbb, 0, -1, 0, this.getDiameter() + 2, 6, this.getDiameter() + 2, bedrock, ComponentTFMinotaurMaze.AIR, false);
        }
        this.func_74878_a(world, sbb, 1, 1, 1, this.getDiameter(), 4, this.getDiameter());
        final boolean onlyReplaceCeiling = this.level == 1 && !TFConfig.dimension.skylightForest;
        this.func_175804_a(world, sbb, 1, 5, 1, this.getDiameter(), 5, this.getDiameter(), mazestone.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.PLAIN), stone, onlyReplaceCeiling);
        this.func_175804_a(world, sbb, 1, 0, 1, this.getDiameter(), 0, this.getDiameter(), mazestone.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.MOSAIC), stone, false);
        this.maze.headBlockState = mazestone.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE);
        this.maze.wallBlockState = mazestone.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.BRICK);
        this.maze.rootBlockState = mazestone.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.DECORATIVE);
        this.maze.pillarBlockState = mazestone.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.CHISELED);
        this.maze.wallBlocks = new StructureTFMazeStones();
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
