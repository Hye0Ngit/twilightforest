// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.TFConfig;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.List;
import java.util.Random;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFMaze;
import twilightforest.structures.TFStructureComponentOld;

public class MinotaurMazeComponent extends TFStructureComponentOld
{
    TFMaze maze;
    int[] rcoords;
    private int level;
    
    public MinotaurMazeComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMaze, nbt);
        this.level = nbt.func_74762_e("mazeLevel");
        this.rcoords = nbt.func_74759_k("roomCoords");
        this.maze = new TFMaze(this.getMazeSize(), this.getMazeSize());
        this.setFixedMazeSeed();
        for (int i = 2; i < this.rcoords.length; ++i) {
            this.rcoords[i] = 0;
        }
        this.addRoomsToMaze(this.rcoords[0], this.rcoords[1], (this.rcoords.length + 1) / 2);
        this.maze.generateRecursiveBacktracker(0, 0);
    }
    
    public MinotaurMazeComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int entranceX, final int entranceZ, final int level) {
        super(MinotaurMazePieces.TFMMaze, feature, index);
        this.func_186164_a(Direction.SOUTH);
        this.level = level;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -this.getRadius(), 0, -this.getRadius(), this.getRadius() * 2, 5, this.getRadius() * 2, Direction.SOUTH);
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
    
    public MinotaurMazeComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int level) {
        this(feature, index, x, y, z, 11, 11, level);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("mazeLevel", this.level);
        tagCompound.func_74783_a("roomCoords", this.rcoords);
    }
    
    protected MazeRoomComponent makeRoom(final Random random, final int i, final int dx, final int dz) {
        final int worldX = this.field_74887_e.field_78897_a + dx * 5 - 4;
        final int worldY = this.field_74887_e.field_78895_b;
        final int worldZ = this.field_74887_e.field_78896_c + dz * 5 - 4;
        MazeRoomComponent room;
        if (i == 0) {
            room = new MazeRoomComponent(MinotaurMazePieces.TFMMR, this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
        }
        else if (i == 1) {
            if (this.level == 1) {
                room = new MazeRoomExitComponent(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
            else {
                room = new MazeRoomBossComponent(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
        }
        else if (i == 2 || i == 3) {
            if (this.level == 1) {
                room = new MazeRoomCollapseComponent(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
            else {
                room = new MazeMushRoomComponent(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
        }
        else if (i == 4) {
            if (this.level == 1) {
                room = new MazeRoomFountainComponent(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
            else {
                room = new MazeRoomVaultComponent(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
            }
        }
        else {
            room = new MazeRoomSpawnerChestsComponent(this.getFeatureType(), 3 + i, random, worldX, worldY, worldZ);
        }
        return room;
    }
    
    protected void decorateDeadEndsCorridors(final Random random, final List<StructurePiece> list) {
        for (int x = 0; x < this.maze.width; ++x) {
            for (int z = 0; z < this.maze.depth; ++z) {
                TFStructureComponentOld component = null;
                if (!this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, Direction.EAST);
                }
                if (this.maze.isWall(x, z, x - 1, z) && !this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, Direction.WEST);
                }
                if (this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && !this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, Direction.SOUTH);
                }
                if (this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && !this.maze.isWall(x, z, x, z + 1)) {
                    component = this.makeDeadEnd(random, x, z, Direction.NORTH);
                }
                if (!this.maze.isWall(x, z, x - 1, z) && !this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z, x, z - 1) && this.maze.isWall(x, z, x, z + 1) && this.maze.isWall(x - 1, z, x - 1, z - 1) && this.maze.isWall(x - 1, z, x - 1, z + 1) && this.maze.isWall(x + 1, z, x + 1, z - 1) && this.maze.isWall(x + 1, z, x + 1, z + 1)) {
                    component = this.makeCorridor(random, x, z, Direction.WEST);
                }
                if (!this.maze.isWall(x, z, x, z - 1) && !this.maze.isWall(x, z, x, z + 1) && this.maze.isWall(x, z, x - 1, z) && this.maze.isWall(x, z, x + 1, z) && this.maze.isWall(x, z - 1, x - 1, z - 1) && this.maze.isWall(x, z - 1, x + 1, z - 1) && this.maze.isWall(x, z + 1, x - 1, z + 1) && this.maze.isWall(x, z + 1, x + 1, z + 1)) {
                    component = this.makeCorridor(random, x, z, Direction.SOUTH);
                }
                if (component != null) {
                    list.add(component);
                    component.func_74861_a((StructurePiece)this, (List)list, random);
                }
            }
        }
    }
    
    protected MazeDeadEndComponent makeDeadEnd(final Random random, final int dx, final int dz, final Direction rotation) {
        final int worldX = this.field_74887_e.field_78897_a + dx * 5 + 1;
        final int worldY = this.field_74887_e.field_78895_b;
        final int worldZ = this.field_74887_e.field_78896_c + dz * 5 + 1;
        final int decorationType = random.nextInt(8);
        switch (decorationType) {
            default: {
                return new MazeDeadEndComponent(MinotaurMazePieces.TFMMDE, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 1: {
                return new MazeDeadEndChestComponent(MinotaurMazePieces.TFMMDEC, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 2: {
                return random.nextBoolean() ? new MazeDeadEndTripwireChestComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation) : new MazeDeadEndTrappedChestComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 3: {
                return new MazeDeadEndTorchesComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 4: {
                return new MazeDeadEndFountainComponent(MinotaurMazePieces.TFMMDEF, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 5: {
                return new MazeDeadEndFountainLavaComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 6: {
                return new MazeDeadEndPaintingComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 7: {
                return (this.level == 1) ? new MazeDeadEndRootsComponent(MinotaurMazePieces.TFMMDER, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation) : new MazeDeadEndShroomsComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
        }
    }
    
    protected MazeCorridorComponent makeCorridor(final Random random, final int dx, final int dz, final Direction rotation) {
        final int worldX = this.field_74887_e.field_78897_a + dx * 5 + 1;
        final int worldY = this.field_74887_e.field_78895_b;
        final int worldZ = this.field_74887_e.field_78896_c + dz * 5 + 1;
        final int decorationType = random.nextInt(5);
        switch (decorationType) {
            default: {
                return null;
            }
            case 1: {
                return new MazeCorridorComponent(MinotaurMazePieces.TFMMC, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 2: {
                return new MazeCorridorIronFenceComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
            case 3: {
                return null;
            }
            case 4: {
                return (this.level == 1) ? new MazeCorridorRootsComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation) : new MazeCorridorShroomsComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            }
        }
    }
    
    public void func_74861_a(final StructurePiece structurecomponent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(structurecomponent, (List)list, random);
        if (this.level == 1) {
            final int centerX = this.field_74887_e.field_78897_a + (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) / 2;
            final int centerZ = this.field_74887_e.field_78896_c + (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c) / 2;
            final MinotaurMazeComponent maze = new MinotaurMazeComponent(this.getFeatureType(), 1, centerX, this.field_74887_e.field_78895_b - 10, centerZ, this.rcoords[2], this.rcoords[3], 2);
            list.add(maze);
            maze.func_74861_a(this, list, random);
        }
        for (int i = 0; i < this.rcoords.length / 2; ++i) {
            final int dx = this.rcoords[i * 2];
            final int dz = this.rcoords[i * 2 + 1];
            final MazeRoomComponent room = this.makeRoom(random, i, dx, dz);
            list.add(room);
            room.func_74861_a(this, list, random);
        }
        this.decorateDeadEndsCorridors(random, list);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState bedrock = Blocks.field_150357_h.func_176223_P();
        final BlockState stone = Blocks.field_150348_b.func_176223_P();
        if (this.level == 2) {
            this.func_175804_a(world, sbb, 0, -1, 0, this.getDiameter() + 2, 6, this.getDiameter() + 2, bedrock, MinotaurMazeComponent.AIR, false);
        }
        this.func_74878_a(world, sbb, 1, 1, 1, this.getDiameter(), 4, this.getDiameter());
        final boolean onlyReplaceCeiling = this.level == 1 && !(boolean)TFConfig.COMMON_CONFIG.DIMENSION.skylightForest.get();
        this.func_175804_a(world, sbb, 1, 5, 1, this.getDiameter(), 5, this.getDiameter(), ((Block)TFBlocks.maze_stone.get()).func_176223_P(), stone, onlyReplaceCeiling);
        this.func_175804_a(world, sbb, 1, 0, 1, this.getDiameter(), 0, this.getDiameter(), ((Block)TFBlocks.maze_stone_mosaic.get()).func_176223_P(), stone, false);
        this.maze.headBlockState = ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P();
        this.maze.wallBlockState = ((Block)TFBlocks.maze_stone_brick.get()).func_176223_P();
        this.maze.rootBlockState = ((Block)TFBlocks.maze_stone_decorative.get()).func_176223_P();
        this.maze.pillarBlockState = ((Block)TFBlocks.maze_stone_chiseled.get()).func_176223_P();
        this.maze.wallBlocks = new MazestoneProcessor();
        this.maze.torchRarity = 0.05f;
        this.maze.tall = 2;
        this.maze.head = 1;
        this.maze.roots = 1;
        this.maze.oddBias = 4;
        this.maze.copyToStructure(world, manager, generator, 1, 2, 1, this, sbb);
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
