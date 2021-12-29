// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.TFConfig;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import java.util.Random;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFMaze;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class MinotaurMazeComponent extends TFStructureComponentOld
{
    TFMaze maze;
    int[] rcoords;
    private int level;
    
    public MinotaurMazeComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMaze, nbt);
        this.level = nbt.m_128451_("mazeLevel");
        this.rcoords = nbt.m_128465_("roomCoords");
        this.maze = new TFMaze(this.getMazeSize(), this.getMazeSize());
        this.setFixedMazeSeed();
        for (int i = 2; i < this.rcoords.length; ++i) {
            this.rcoords[i] = 0;
        }
        this.addRoomsToMaze(this.rcoords[0], this.rcoords[1], (this.rcoords.length + 1) / 2);
        this.maze.generateRecursiveBacktracker(0, 0);
    }
    
    public MinotaurMazeComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int entranceX, final int entranceZ, final int level) {
        super(MinotaurMazePieces.TFMMaze, feature, index, x, y, z);
        this.m_73519_(Direction.SOUTH);
        this.level = level;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -this.getRadius(), 0, -this.getRadius(), this.getRadius() * 2, 5, this.getRadius() * 2, Direction.SOUTH);
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
        this.maze.setSeed(this.f_73383_.m_162395_() * 90342903L + this.f_73383_.m_162396_() * 90342903L ^ (long)this.f_73383_.m_162398_());
    }
    
    public MinotaurMazeComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int level) {
        this(feature, index, x, y, z, 11, 11, level);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("mazeLevel", this.level);
        tagCompound.m_128385_("roomCoords", this.rcoords);
    }
    
    protected MazeRoomComponent makeRoom(final Random random, final int i, final int dx, final int dz) {
        final int worldX = this.f_73383_.m_162395_() + dx * 5 - 4;
        final int worldY = this.f_73383_.m_162396_();
        final int worldZ = this.f_73383_.m_162398_() + dz * 5 - 4;
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
    
    protected void decorateDeadEndsCorridors(final Random random, final StructurePieceAccessor list) {
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
                    list.m_142679_((StructurePiece)component);
                    component.m_142537_((StructurePiece)this, list, random);
                }
            }
        }
    }
    
    protected MazeDeadEndComponent makeDeadEnd(final Random random, final int dx, final int dz, final Direction rotation) {
        final int worldX = this.f_73383_.m_162395_() + dx * 5 + 1;
        final int worldY = this.f_73383_.m_162396_();
        final int worldZ = this.f_73383_.m_162398_() + dz * 5 + 1;
        final int decorationType = random.nextInt(8);
        return switch (decorationType) {
            case 1 -> new MazeDeadEndChestComponent(MinotaurMazePieces.TFMMDEC, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            case 2 -> random.nextBoolean() ? new MazeDeadEndTripwireChestComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation) : new MazeDeadEndTrappedChestComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            case 3 -> new MazeDeadEndTorchesComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            case 4 -> new MazeDeadEndFountainComponent(MinotaurMazePieces.TFMMDEF, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            case 5 -> new MazeDeadEndFountainLavaComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            case 6 -> new MazeDeadEndPaintingComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            case 7 -> (this.level == 1) ? new MazeDeadEndRootsComponent(MinotaurMazePieces.TFMMDER, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation) : new MazeDeadEndShroomsComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            default -> new MazeDeadEndComponent(MinotaurMazePieces.TFMMDE, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
        };
    }
    
    protected MazeCorridorComponent makeCorridor(final Random random, final int dx, final int dz, final Direction rotation) {
        final int worldX = this.f_73383_.m_162395_() + dx * 5 + 1;
        final int worldY = this.f_73383_.m_162396_();
        final int worldZ = this.f_73383_.m_162398_() + dz * 5 + 1;
        final int decorationType = random.nextInt(5);
        return switch (decorationType) {
            case 1 -> new MazeCorridorComponent(MinotaurMazePieces.TFMMC, this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            case 2 -> new MazeCorridorIronFenceComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            case 3 -> null;
            case 4 -> (this.level == 1) ? new MazeCorridorRootsComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation) : new MazeCorridorShroomsComponent(this.getFeatureType(), 4, worldX, worldY, worldZ, rotation);
            default -> null;
        };
    }
    
    public void m_142537_(final StructurePiece structurecomponent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(structurecomponent, list, random);
        if (this.level == 1) {
            final int centerX = this.f_73383_.m_162395_() + (this.f_73383_.m_162399_() - this.f_73383_.m_162395_()) / 2;
            final int centerZ = this.f_73383_.m_162398_() + (this.f_73383_.m_162401_() - this.f_73383_.m_162398_()) / 2;
            final MinotaurMazeComponent maze = new MinotaurMazeComponent(this.getFeatureType(), 1, centerX, this.f_73383_.m_162396_() - 10, centerZ, this.rcoords[2], this.rcoords[3], 2);
            list.m_142679_((StructurePiece)maze);
            maze.m_142537_(this, list, random);
        }
        for (int i = 0; i < this.rcoords.length / 2; ++i) {
            final int dx = this.rcoords[i * 2];
            final int dz = this.rcoords[i * 2 + 1];
            final MazeRoomComponent room = this.makeRoom(random, i, dx, dz);
            list.m_142679_((StructurePiece)room);
            room.m_142537_(this, list, random);
        }
        this.decorateDeadEndsCorridors(random, list);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState bedrock = Blocks.f_50752_.m_49966_();
        final BlockState stone = Blocks.f_50069_.m_49966_();
        if (this.level == 2) {
            this.m_73441_(world, sbb, 0, -1, 0, this.getDiameter() + 2, 6, this.getDiameter() + 2, bedrock, MinotaurMazeComponent.AIR, false);
        }
        this.m_73535_(world, sbb, 1, 1, 1, this.getDiameter(), 4, this.getDiameter());
        final boolean onlyReplaceCeiling = this.level == 1 && !(boolean)TFConfig.COMMON_CONFIG.DIMENSION.skylightForest.get();
        this.m_73441_(world, sbb, 1, 5, 1, this.getDiameter(), 5, this.getDiameter(), ((Block)TFBlocks.MAZESTONE.get()).m_49966_(), stone, onlyReplaceCeiling);
        this.m_73441_(world, sbb, 1, 0, 1, this.getDiameter(), 0, this.getDiameter(), ((Block)TFBlocks.MAZESTONE_MOSAIC.get()).m_49966_(), stone, false);
        this.maze.headBlockState = ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_();
        this.maze.wallBlockState = ((Block)TFBlocks.MAZESTONE_BRICK.get()).m_49966_();
        this.maze.rootBlockState = ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_();
        this.maze.pillarBlockState = ((Block)TFBlocks.CUT_MAZESTONE.get()).m_49966_();
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
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BURY;
    }
}
