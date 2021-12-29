// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.BaseSpawner;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.block.LadderBlock;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import twilightforest.world.registration.ConfiguredFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.DispenserBlock;
import twilightforest.world.components.structures.TFStructureDecorator;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.loot.TFTreasure;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.world.components.structures.TFMaze;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Iterator;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import java.util.ArrayList;
import twilightforest.util.RotationUtil;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import twilightforest.TwilightForestMod;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class DarkTowerMainComponent extends DarkTowerWingComponent
{
    private boolean placedKeys;
    
    public DarkTowerMainComponent(final ServerLevel level, final CompoundTag nbt) {
        super(DarkTowerPieces.TFDTMai, nbt);
        this.placedKeys = false;
    }
    
    public DarkTowerMainComponent(final TFFeature feature, final Random rand, final int index, final int x, final int y, final int z) {
        this(feature, rand, index, x + 10, y, z + 10, Direction.NORTH);
    }
    
    public DarkTowerMainComponent(final TFFeature feature, final Random rand, final int index, final int x, final int y, final int z, final Direction rotation) {
        super(DarkTowerPieces.TFDTMai, feature, index, x, y, z, 19, 56 + rand.nextInt(32) / 5 * 5, rotation);
        this.placedKeys = false;
        if (this.f_73383_.m_162400_() > 245) {
            final int amtToLower = (this.f_73383_.m_162400_() - 245) / 5 * 5 + 5;
            TwilightForestMod.LOGGER.info("Lowering Dark Tower max height by {} to be within world bounds", (Object)amtToLower);
            this.height -= amtToLower;
        }
        if (this.deco == null) {
            this.deco = new StructureDecoratorDarkTower();
        }
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        if (this.m_73548_() > 0) {
            this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        }
        Rotation mainDir = null;
        if (this.m_73548_() < 2) {
            mainDir = RotationUtil.ROTATIONS[rand.nextInt(RotationUtil.ROTATIONS.length)];
            for (final Rotation rotation : RotationUtil.ROTATIONS) {
                if (rotation != mainDir) {
                    final int[] dest = this.getValidOpening(rand, rotation);
                    final int childHeight = this.validateChildHeight(21 + rand.nextInt(10));
                    this.makeTowerWing(list, rand, this.m_73548_(), dest[0], dest[1], dest[2], 11, childHeight, rotation);
                }
            }
        }
        else {
            for (final Rotation i : RotationUtil.ROTATIONS) {
                final int[] dest = this.getValidOpening(rand, i);
                this.makeBossTrapWing(list, rand, this.m_73548_(), dest[0], dest[1], dest[2], i);
            }
        }
        if (this.m_73548_() > 0) {
            for (final Rotation i : RotationUtil.ROTATIONS) {
                if (i != Rotation.CLOCKWISE_180) {
                    final int[] dest = this.getValidOpening(rand, i);
                    dest[1] = 1;
                    final int childHeight = this.validateChildHeight(21 + rand.nextInt(10));
                    this.makeTowerWing(list, rand, this.m_73548_(), dest[0], dest[1], dest[2], 11, childHeight, i);
                }
            }
            this.makeABeard(parent, list, rand);
        }
        else {
            for (final Rotation rotation : new Rotation[] { Rotation.NONE, Rotation.CLOCKWISE_180 }) {
                final int[] dest = this.getValidOpening(rand, rotation);
                dest[1] = 1;
                final int childHeight = this.validateChildHeight(10 + rand.nextInt(5));
                this.makeEntranceTower(list, rand, 5, dest[0], dest[1], dest[2], 9, childHeight, rotation);
            }
        }
        if (mainDir != null) {
            final int[] dest2 = this.getValidOpening(rand, mainDir);
            this.makeNewLargeTower(list, rand, this.m_73548_() + 1, dest2[0], dest2[1], dest2[2], mainDir);
        }
        this.makeARoof(parent, list, rand);
        if (!this.placedKeys && this.m_73548_() < 2) {
            final ArrayList<DarkTowerWingComponent> possibleKeyTowers = new ArrayList<DarkTowerWingComponent>();
            if (list instanceof StructureStart) {
                final StructureStart<?> start = (StructureStart<?>)list;
                for (final StructurePiece structurePiece : start.m_73602_()) {
                    final StructurePiece piece = structurePiece;
                    if (structurePiece instanceof final DarkTowerWingComponent wing) {
                        if (wing.size != 9 || wing.m_73548_() != this.m_73548_()) {
                            continue;
                        }
                        possibleKeyTowers.add(wing);
                    }
                }
            }
            for (int j = 0; j < 4; ++j) {
                if (possibleKeyTowers.size() < 1) {
                    TwilightForestMod.LOGGER.warn("Dark forest tower could not find four small towers to place keys in.");
                    break;
                }
                final int towerNum = rand.nextInt(possibleKeyTowers.size());
                possibleKeyTowers.get(towerNum).setKeyTower(true);
                possibleKeyTowers.remove(towerNum);
            }
            this.placedKeys = true;
        }
    }
    
    private boolean makeEntranceTower(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int childSize, final int childHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final DarkTowerBridgeComponent bridge = new DarkTowerEntranceBridgeComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], childSize, childHeight, direction);
        list.m_142679_((StructurePiece)bridge);
        bridge.m_142537_(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
    
    private boolean makeNewLargeTower(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        final int wingSize = 15;
        final int wingHeight = 56;
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final DarkTowerMainBridgeComponent bridge = new DarkTowerMainBridgeComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.m_142679_((StructurePiece)bridge);
        bridge.m_142537_(this, list, rand);
        this.addOpening(x, y, z, rotation, EnumDarkTowerDoor.LOCKED);
        return true;
    }
    
    private boolean makeBossTrapWing(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        final int wingSize = 11;
        final int wingHeight = 9;
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final DarkTowerBossBridgeComponent bridge = new DarkTowerBossBridgeComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.m_142679_((StructurePiece)bridge);
        bridge.m_142537_(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (this.m_73548_() < 2) {
            super.makeARoof(parent, list, rand);
        }
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.m_73535_(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        if (this.m_73548_() == 0) {
            for (int x = 0; x < this.size; ++x) {
                for (int z = 0; z < this.size; ++z) {
                    this.m_73434_(world, this.deco.accentState, x, -1, z, sbb);
                }
            }
        }
        final int totalFloors = this.height / 5;
        final boolean beamMaze = decoRNG.nextBoolean();
        final int centerFloors = beamMaze ? 4 : (totalFloors / 2);
        final int bottomFloors = (totalFloors - centerFloors) / 2;
        final int topFloorsStartY = this.height - (bottomFloors * 5 + 1);
        this.addThreeQuarterFloors(world, manager, generator, decoRNG, sbb, 0, bottomFloors * 5);
        if (this.m_73548_() < 2) {
            this.addThreeQuarterFloors(world, manager, generator, decoRNG, sbb, topFloorsStartY, this.height - 1);
        }
        else {
            this.addThreeQuarterFloorsDecorateBoss(world, decoRNG, sbb, topFloorsStartY, this.height - 1);
            this.destroyTower(world, decoRNG, 12, this.height + 4, 3, 4, sbb);
            this.destroyTower(world, decoRNG, 3, this.height + 4, 12, 4, sbb);
            this.destroyTower(world, decoRNG, 3, this.height + 4, 3, 4, sbb);
            this.destroyTower(world, decoRNG, 12, this.height + 4, 12, 4, sbb);
            this.destroyTower(world, decoRNG, 8, this.height + 4, 8, 5, sbb);
            this.decorateBossSpawner(world, sbb, Rotation.NONE, this.height - 6);
        }
        if (beamMaze) {
            this.addTimberMaze(world, decoRNG, sbb, bottomFloors * 5, topFloorsStartY);
        }
        else {
            this.addBuilderPlatforms(world, decoRNG, sbb, bottomFloors * 5, topFloorsStartY);
        }
        this.makeOpenings(world, sbb);
        return true;
    }
    
    protected void addThreeQuarterFloors(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random decoRNG, final BoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        Rotation rotation = RotationUtil.ROTATIONS[Math.abs((this.f_73383_.m_162396_() + bottom) % 4)];
        if (bottom == 0) {
            this.makeLargeStairsUp(world, sbb, rotation, 0);
            rotation = rotation.m_55952_(Rotation.COUNTERCLOCKWISE_90);
            this.makeBottomEntrance(world, sbb, rotation, bottom);
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            final boolean isBottomFloor = y == bottom && bottom != spacing;
            final boolean isTopFloor = y >= top - spacing;
            final boolean isTowerTopFloor = y >= this.height - spacing - 2;
            this.makeThreeQuarterFloor(world, sbb, rotation, y, isBottomFloor, isTowerTopFloor);
            if (!isTopFloor) {
                this.makeLargeStairsUp(world, sbb, rotation, y);
            }
            if (!isTopFloor || isTowerTopFloor) {
                this.decorateFloor(world, manager, generator, decoRNG, sbb, rotation, y, isBottomFloor, isTopFloor);
            }
            rotation = rotation.m_55952_(Rotation.COUNTERCLOCKWISE_90);
        }
    }
    
    protected void addThreeQuarterFloorsDecorateBoss(final WorldGenLevel world, final Random decoRNG, final BoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        Rotation rotation = RotationUtil.ROTATIONS[(this.f_73383_.m_162396_() + bottom) % 4];
        if (bottom == 0) {
            this.makeLargeStairsUp(world, sbb, rotation, 0);
            rotation = rotation.m_55952_(Rotation.COUNTERCLOCKWISE_90);
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            final boolean isBottomFloor = y == bottom && bottom != spacing;
            final boolean isTopFloor = y >= top - spacing;
            final boolean isTowerTopFloor = y >= this.height - spacing - 2;
            this.makeThreeQuarterFloor(world, sbb, rotation, y, isBottomFloor, isTowerTopFloor);
            if (!isTopFloor) {
                this.makeLargeStairsUp(world, sbb, rotation, y);
                this.decorateExperiment(world, sbb, rotation, y);
            }
            rotation = rotation.m_55952_(Rotation.COUNTERCLOCKWISE_90);
        }
    }
    
    private void decorateFloor(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random decoRNG, final BoundingBox sbb, final Rotation rotation, final int y, final boolean isBottom, final boolean isTop) {
        if (isTop) {
            switch (decoRNG.nextInt(3)) {
                case 1: {
                    this.decorateBotanical(world, generator, decoRNG, sbb, rotation, y);
                    break;
                }
                case 2: {
                    this.decorateNetherwart(world, decoRNG, sbb, rotation, y, isTop);
                    break;
                }
                default: {
                    this.decorateAquarium(world, sbb, rotation, y);
                    break;
                }
            }
        }
        else if (isBottom) {
            switch (decoRNG.nextInt(4)) {
                default: {
                    this.decorateAquarium(world, sbb, rotation, y);
                    break;
                }
                case 1: {
                    this.decorateBotanical(world, generator, decoRNG, sbb, rotation, y);
                    break;
                }
                case 2: {
                    if (y + this.f_73383_.m_162396_() > 64) {
                        this.decorateNetherwart(world, decoRNG, sbb, rotation, y, isTop);
                        break;
                    }
                }
                case 3: {
                    this.decorateForge(world, decoRNG, sbb, rotation, y);
                    break;
                }
            }
        }
        else {
            switch (decoRNG.nextInt(8)) {
                default: {
                    this.decorateReappearingMaze(world, manager, generator, decoRNG, sbb, rotation, y);
                    break;
                }
                case 2: {
                    this.decorateUnbuilderMaze(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 3: {
                    this.decorateAquarium(world, sbb, rotation, y);
                    break;
                }
                case 4: {
                    this.decorateBotanical(world, generator, decoRNG, sbb, rotation, y);
                    break;
                }
                case 5: {
                    if (y + this.f_73383_.m_162396_() > 64) {
                        this.decorateNetherwart(world, decoRNG, sbb, rotation, y, isTop);
                        break;
                    }
                }
                case 6: {
                    this.decorateLounge(world, generator, decoRNG, sbb, rotation, y);
                    break;
                }
                case 7: {
                    this.decorateForge(world, decoRNG, sbb, rotation, y);
                    break;
                }
            }
        }
    }
    
    protected void makeThreeQuarterFloor(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y, final boolean isBottom, final boolean isTowerTopFloor) {
        final int half = this.size / 2;
        this.fillBlocksRotated(world, sbb, half + 1, y, 1, this.size - 2, y, half + 1, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 1, y, half + 1, this.size - 2, y, this.size - 2, this.deco.blockState, rotation);
        final int startZ = isBottom ? 1 : 3;
        this.fillBlocksRotated(world, sbb, 1, y, half, half, y, half, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, half, y, startZ, half, y, half, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, 1, y + 1, half, half, y + 1, half, this.deco.fenceState, rotation);
        this.fillBlocksRotated(world, sbb, half, y + 1, startZ, half, y + 1, half, this.deco.fenceState, rotation);
        if (isTowerTopFloor) {
            this.fillBlocksRotated(world, sbb, 1, y, half - 2, 3, y, half, this.deco.accentState, rotation);
            this.fillBlocksRotated(world, sbb, 1, y + 1, half - 2, 3, y + 1, half, this.deco.fenceState, rotation);
            this.fillBlocksRotated(world, sbb, 1, y, half - 1, 2, y, half, this.deco.fenceState, rotation);
            this.fillBlocksRotated(world, sbb, 1, y + 1, half - 1, 2, y + 1, half, DarkTowerMainComponent.AIR, rotation);
        }
    }
    
    protected void makeLargeStairsUp(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        for (int i = 0; i < 5; ++i) {
            final int z = this.size / 2 - i + 4;
            final int sy = y + i + 1;
            this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), 1, sy, z, rotation, sbb);
            this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), 2, sy, z, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 1, sy, z - 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 2, sy, z - 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 3, sy, z - 1, rotation, sbb);
            if (i > 0 && i < 4) {
                this.setBlockStateRotated(world, this.deco.accentState, 3, sy, z, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.fenceState, 3, sy + 1, z, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.fenceState, 3, sy + 2, z, rotation, sbb);
            }
            else if (i == 0) {
                this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, false), 3, sy, z, rotation, sbb);
            }
        }
    }
    
    private void decorateReappearingMaze(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random decoRNG, final BoundingBox sbb, final Rotation rotation, final int y) {
        final int mazeSize = 6;
        final TFMaze maze = new TFMaze(mazeSize, mazeSize);
        maze.setSeed(world.m_7328_() + this.f_73383_.m_162395_() * 90342903L + y * 90342903L ^ (long)this.f_73383_.m_162398_());
        for (int i = 0; i < 13; ++i) {
            maze.putRaw(i, 0, 5);
            maze.putRaw(i, 12, 5);
            maze.putRaw(0, i, 5);
            maze.putRaw(12, i, 5);
        }
        maze.doorRarity = 0.3f;
        switch (rotation) {
            case NONE: {
                for (int x = 1; x < 6; ++x) {
                    for (int z = 1; z < 6; ++z) {
                        maze.putRaw(x, z, 5);
                    }
                }
                maze.putRaw(1, 6, 5);
                maze.putRaw(1, 7, 5);
                maze.putRaw(1, 8, 5);
                maze.putRaw(1, 9, 5);
                maze.putRaw(1, 10, 6);
                maze.putRaw(6, 1, 5);
                maze.putRaw(7, 1, 5);
                maze.putRaw(8, 1, 6);
                maze.generateRecursiveBacktracker(0, 5);
                break;
            }
            case CLOCKWISE_90: {
                for (int x = 7; x < 12; ++x) {
                    for (int z = 1; z < 6; ++z) {
                        maze.putRaw(x, z, 5);
                    }
                }
                maze.putRaw(6, 1, 5);
                maze.putRaw(5, 1, 5);
                maze.putRaw(4, 1, 5);
                maze.putRaw(3, 1, 5);
                maze.putRaw(2, 1, 6);
                maze.putRaw(11, 6, 5);
                maze.putRaw(11, 7, 5);
                maze.putRaw(11, 8, 6);
                maze.generateRecursiveBacktracker(0, 0);
                break;
            }
            case CLOCKWISE_180: {
                for (int x = 7; x < 12; ++x) {
                    for (int z = 7; z < 12; ++z) {
                        maze.putRaw(x, z, 5);
                    }
                }
                maze.putRaw(11, 6, 5);
                maze.putRaw(11, 5, 5);
                maze.putRaw(11, 4, 5);
                maze.putRaw(11, 3, 5);
                maze.putRaw(11, 2, 6);
                maze.putRaw(6, 11, 5);
                maze.putRaw(5, 11, 5);
                maze.putRaw(4, 11, 6);
                maze.generateRecursiveBacktracker(5, 0);
                break;
            }
            case COUNTERCLOCKWISE_90: {
                for (int x = 1; x < 6; ++x) {
                    for (int z = 7; z < 12; ++z) {
                        maze.putRaw(x, z, 5);
                    }
                }
                maze.putRaw(6, 11, 5);
                maze.putRaw(7, 11, 5);
                maze.putRaw(8, 11, 5);
                maze.putRaw(9, 11, 5);
                maze.putRaw(10, 11, 6);
                maze.putRaw(1, 6, 5);
                maze.putRaw(1, 5, 5);
                maze.putRaw(1, 4, 6);
                maze.generateRecursiveBacktracker(5, 5);
                break;
            }
        }
        maze.wallBlockState = this.deco.blockState;
        maze.headBlockState = this.deco.accentState;
        maze.pillarBlockState = this.deco.accentState;
        maze.doorBlockState = ((Block)TFBlocks.REAPPEARING_BLOCK.get()).m_49966_();
        maze.torchRarity = 0.0f;
        maze.tall = 3;
        maze.head = 1;
        maze.oddBias = 2;
        maze.copyToStructure(world, manager, generator, 0, y + 1, 0, this, sbb);
        this.decorateMazeDeadEnds(world, decoRNG, maze, y, rotation, sbb);
    }
    
    protected void decorateMazeDeadEnds(final WorldGenLevel world, final Random decoRNG, final TFMaze maze, final int y, final Rotation rotation, final BoundingBox sbb) {
        for (int x = 0; x < maze.width; ++x) {
            for (int z = 0; z < maze.depth; ++z) {
                if (!maze.isWall(x, z, x - 1, z) && maze.isWall(x, z, x + 1, z) && maze.isWall(x, z, x, z - 1) && maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(world, x, y, z, 3, sbb);
                }
                if (maze.isWall(x, z, x - 1, z) && !maze.isWall(x, z, x + 1, z) && maze.isWall(x, z, x, z - 1) && maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(world, x, y, z, 1, sbb);
                }
                if (maze.isWall(x, z, x - 1, z) && maze.isWall(x, z, x + 1, z) && !maze.isWall(x, z, x, z - 1) && maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(world, x, y, z, 0, sbb);
                }
                if (maze.isWall(x, z, x - 1, z) && maze.isWall(x, z, x + 1, z) && maze.isWall(x, z, x, z - 1) && !maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(world, x, y, z, 2, sbb);
                }
            }
        }
    }
    
    private void decorateDeadEnd(final WorldGenLevel world, final int mx, final int y, final int mz, final int facing, final BoundingBox sbb) {
        final int x = mx * 3 + 1;
        final int z = mz * 3 + 1;
        switch (facing) {
            case 0: {
                this.m_73434_(world, this.deco.accentState, x, y + 1, z + 1, sbb);
                this.m_73434_(world, this.deco.accentState, x + 1, y + 1, z + 1, sbb);
                this.setDoubleLootChest(world, x, y + 2, z + 1, x + 1, y + 2, z + 1, Direction.SOUTH, TFTreasure.DARKTOWER_CACHE, sbb, false);
                break;
            }
            case 1: {
                this.m_73434_(world, this.deco.accentState, x, y + 1, z, sbb);
                this.m_73434_(world, this.deco.accentState, x, y + 1, z + 1, sbb);
                this.setDoubleLootChest(world, x, y + 2, z, x, y + 2, z + 1, Direction.WEST, TFTreasure.DARKTOWER_CACHE, sbb, false);
                break;
            }
            case 2: {
                this.m_73434_(world, this.deco.accentState, x, y + 1, z, sbb);
                this.m_73434_(world, this.deco.accentState, x + 1, y + 1, z, sbb);
                this.setDoubleLootChest(world, x + 1, y + 2, z, x, y + 2, z, Direction.NORTH, TFTreasure.DARKTOWER_CACHE, sbb, false);
                break;
            }
            case 3: {
                this.m_73434_(world, this.deco.accentState, x + 1, y + 1, z, sbb);
                this.m_73434_(world, this.deco.accentState, x + 1, y + 1, z + 1, sbb);
                this.setDoubleLootChest(world, x + 1, y + 2, z + 1, x + 1, y + 2, z, Direction.EAST, TFTreasure.DARKTOWER_CACHE, sbb, false);
                break;
            }
        }
    }
    
    private void decorateUnbuilderMaze(final WorldGenLevel world, final Random decoRNG, final BoundingBox sbb, final Rotation rotation, final int y) {
        for (int x = this.size / 2; x < this.size - 1; ++x) {
            for (int z = 3; z < this.size - 1; ++z) {
                if (x % 2 == 1 && z % 2 == 1) {
                    for (int py = 1; py < 5; ++py) {
                        this.setBlockStateRotated(world, this.deco.pillarState, x, y + py, z, rotation, sbb);
                    }
                }
                else if (x % 2 == 1 || z % 2 == 1) {
                    for (int py = 1; py < 5; ++py) {
                        this.setBlockStateRotated(world, this.deco.fenceState, x, y + py, z, rotation, sbb);
                    }
                    if (x != this.size / 2 && x != this.size - 2 && z != this.size - 2) {
                        int ay = decoRNG.nextInt(4) + 1;
                        this.setBlockStateRotated(world, DarkTowerMainComponent.AIR, x, y + ay, z, rotation, sbb);
                        if (x > this.size - 7) {
                            ay = decoRNG.nextInt(3) + 1;
                            this.setBlockStateRotated(world, DarkTowerMainComponent.AIR, x, y + ay, z, rotation, sbb);
                        }
                    }
                }
            }
        }
        final BlockState antiBuilderBlockState = ((Block)TFBlocks.ANTIBUILDER.get()).m_49966_();
        this.setBlockStateRotated(world, antiBuilderBlockState, 15, y + 2, 7, rotation, sbb);
        this.setBlockStateRotated(world, antiBuilderBlockState, 11, y + 3, 7, rotation, sbb);
        this.setBlockStateRotated(world, antiBuilderBlockState, 15, y + 2, 13, rotation, sbb);
        this.setBlockStateRotated(world, antiBuilderBlockState, 11, y + 3, 13, rotation, sbb);
        this.setBlockStateRotated(world, antiBuilderBlockState, 5, y + 3, 13, rotation, sbb);
    }
    
    private void decorateLounge(final WorldGenLevel world, final ChunkGenerator generator, final Random decoRNG, final BoundingBox sbb, final Rotation rotation, final int y) {
        this.fillBlocksRotated(world, sbb, 17, y + 1, 1, 17, y + 4, 6, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 1, 17, y + 4, 1, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 2, 16, y + 1, 5, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 2, 12, y + 1, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 6, 16, y + 1, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), rotation);
        this.makeDispenserPillar(world, this.deco, 13, y, 1, Direction.SOUTH, rotation, sbb);
        this.makeDispenserPillar(world, this.deco, 15, y, 1, Direction.SOUTH, rotation, sbb);
        this.makeDispenserPillar(world, this.deco, 17, y, 3, Direction.WEST, rotation, sbb);
        this.makeDispenserPillar(world, this.deco, 17, y, 5, Direction.WEST, rotation, sbb);
        this.makeStonePillar(world, this.deco, 12, y, 1, rotation, sbb);
        this.makeStonePillar(world, this.deco, 17, y, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50255_.m_49966_(), 13, y + 2, 5, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_152476_.m_49966_().m_61124_((Property)LayeredCauldronBlock.f_153514_, (Comparable)3), 15, y + 2, 3, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 10, y + 1, 17, 17, y + 4, 17, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 10, 17, y + 4, 17, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 11, y + 1, 17, 12, y + 4, 17, Blocks.f_50078_.m_49966_(), rotation);
        this.fillBlocksRotated(world, sbb, 14, y + 1, 17, 15, y + 4, 17, Blocks.f_50078_.m_49966_(), rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 11, 17, y + 4, 12, Blocks.f_50078_.m_49966_(), rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 14, 17, y + 4, 15, Blocks.f_50078_.m_49966_(), rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, true), 13, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, true), 14, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, true), 14, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, true), 13, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, false), 11, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), 13, y + 1, 11, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50261_.m_49966_(), 8, y + 3, 8, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.CEILING, decoRNG.nextBoolean() ? Direction.EAST : Direction.NORTH, false), 8, y + 2, 8, rotation, sbb);
        this.placeTreePlanter(world, generator, decoRNG.nextInt(5), 6, y + 1, 12, rotation, sbb);
    }
    
    private void makeDispenserPillar(final WorldGenLevel world, final TFStructureDecorator forgeDeco, final int x, final int y, final int z, final Direction stairMeta, final Rotation rotation, final BoundingBox sbb) {
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(forgeDeco.stairState, stairMeta, true), x, y + 2, z, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50061_.m_49966_().m_61124_((Property)DispenserBlock.f_52659_, (Comparable)stairMeta.m_122424_()), x, y + 3, z, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(forgeDeco.stairState, stairMeta, false), x, y + 4, z, rotation, sbb);
    }
    
    private void decorateBossSpawner(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        this.setBlockStateRotated(world, ((Block)TFBlocks.UR_GHAST_BOSS_SPAWNER.get()).m_49966_(), 9, y + 4, 9, rotation, sbb);
    }
    
    private void decorateExperiment(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        final BlockState obsidian = Blocks.f_50080_.m_49966_();
        final BlockState netherrack = Blocks.f_50134_.m_49966_();
        final BlockState redstone = Blocks.f_50330_.m_49966_();
        final BlockState inactiveReactor = ((Block)TFBlocks.CARMINITE_REACTOR.get()).m_49966_();
        this.fillBlocksRotated(world, sbb, 17, y + 1, 1, 17, y + 4, 6, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 1, 17, y + 4, 1, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 2, 16, y + 1, 5, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 2, 12, y + 1, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 6, 16, y + 1, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), rotation);
        this.makeWoodPillar(world, 13, y, 1, rotation, sbb);
        this.makeWoodPillar(world, 15, y, 1, rotation, sbb);
        this.makeWoodPillar(world, 17, y, 3, rotation, sbb);
        this.makeWoodPillar(world, 17, y, 5, rotation, sbb);
        this.makeStonePillar(world, this.deco, 12, y, 1, rotation, sbb);
        this.makeStonePillar(world, this.deco, 17, y, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50091_.m_49966_(), 14, y + 2, 4, rotation, sbb);
        this.placeItemFrameRotated(world, 13, y + 2, 1, rotation, Direction.SOUTH, new ItemStack((ItemLike)TFItems.BORER_ESSENCE.get()), sbb);
        this.placeItemFrameRotated(world, 14, y + 2, 1, rotation, Direction.SOUTH, new ItemStack((ItemLike)Items.f_42451_), sbb);
        this.placeItemFrameRotated(world, 15, y + 2, 1, rotation, Direction.SOUTH, new ItemStack((ItemLike)TFItems.BORER_ESSENCE.get()), sbb);
        this.placeItemFrameRotated(world, 13, y + 3, 1, rotation, Direction.SOUTH, new ItemStack((ItemLike)Items.f_42451_), sbb);
        this.placeItemFrameRotated(world, 14, y + 3, 1, rotation, Direction.SOUTH, new ItemStack((ItemLike)Items.f_42586_), sbb);
        this.placeItemFrameRotated(world, 15, y + 3, 1, rotation, Direction.SOUTH, new ItemStack((ItemLike)Items.f_42451_), sbb);
        this.placeItemFrameRotated(world, 13, y + 4, 1, rotation, Direction.SOUTH, new ItemStack((ItemLike)TFItems.BORER_ESSENCE.get()), sbb);
        this.placeItemFrameRotated(world, 14, y + 4, 1, rotation, Direction.SOUTH, new ItemStack((ItemLike)Items.f_42451_), sbb);
        this.placeItemFrameRotated(world, 15, y + 4, 1, rotation, Direction.SOUTH, new ItemStack((ItemLike)TFItems.BORER_ESSENCE.get()), sbb);
        this.placeItemFrameRotated(world, 17, y + 2, 3, rotation, Direction.WEST, new ItemStack((ItemLike)TFBlocks.ENCASED_TOWERWOOD.get()), sbb);
        this.placeItemFrameRotated(world, 17, y + 2, 4, rotation, Direction.WEST, new ItemStack((ItemLike)TFBlocks.TOWERWOOD.get()), sbb);
        this.placeItemFrameRotated(world, 17, y + 2, 5, rotation, Direction.WEST, new ItemStack((ItemLike)TFBlocks.ENCASED_TOWERWOOD.get()), sbb);
        this.placeItemFrameRotated(world, 17, y + 3, 3, rotation, Direction.WEST, new ItemStack((ItemLike)TFBlocks.TOWERWOOD.get()), sbb);
        this.placeItemFrameRotated(world, 17, y + 3, 4, rotation, Direction.WEST, new ItemStack((ItemLike)TFItems.CARMINITE.get()), sbb);
        this.placeItemFrameRotated(world, 17, y + 3, 5, rotation, Direction.WEST, new ItemStack((ItemLike)TFBlocks.TOWERWOOD.get()), sbb);
        this.placeItemFrameRotated(world, 17, y + 4, 3, rotation, Direction.WEST, new ItemStack((ItemLike)TFBlocks.ENCASED_TOWERWOOD.get()), sbb);
        this.placeItemFrameRotated(world, 17, y + 4, 4, rotation, Direction.WEST, new ItemStack((ItemLike)TFBlocks.TOWERWOOD.get()), sbb);
        this.placeItemFrameRotated(world, 17, y + 4, 5, rotation, Direction.WEST, new ItemStack((ItemLike)TFBlocks.ENCASED_TOWERWOOD.get()), sbb);
        if (y < this.height - 13) {
            this.setBlockStateRotated(world, obsidian, 13, y + 1, 13, rotation, sbb);
            this.setBlockStateRotated(world, obsidian, 15, y + 1, 13, rotation, sbb);
            this.setBlockStateRotated(world, obsidian, 13, y + 1, 15, rotation, sbb);
            this.setBlockStateRotated(world, obsidian, 15, y + 1, 15, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 13, y + 1, 14, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 14, y + 1, 13, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 15, y + 1, 14, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 14, y + 1, 15, rotation, sbb);
            this.setBlockStateRotated(world, redstone, 14, y + 1, 14, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 13, y + 2, 13, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 15, y + 2, 13, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 13, y + 2, 15, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 15, y + 2, 15, rotation, sbb);
            this.setBlockStateRotated(world, inactiveReactor, 14, y + 2, 14, rotation, sbb);
            this.setBlockStateRotated(world, obsidian, 13, y + 3, 13, rotation, sbb);
            this.setBlockStateRotated(world, obsidian, 15, y + 3, 13, rotation, sbb);
            this.setBlockStateRotated(world, obsidian, 13, y + 3, 15, rotation, sbb);
            this.setBlockStateRotated(world, obsidian, 15, y + 3, 15, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 13, y + 3, 14, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 14, y + 3, 13, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 15, y + 3, 14, rotation, sbb);
            this.setBlockStateRotated(world, netherrack, 14, y + 3, 15, rotation, sbb);
            this.setBlockStateRotated(world, redstone, 14, y + 3, 14, rotation, sbb);
        }
        this.setBlockStateRotated(world, this.deco.accentState, 14, y + 1, 17, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.WALL, Direction.EAST, false), 13, y + 1, 17, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50039_.m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.SOUTH), 14, y + 2, 17, rotation, sbb);
        this.setBlockStateRotated(world, redstone, 14, y + 2, 16, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 17, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.WALL, Direction.SOUTH, false), 17, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50039_.m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.EAST), 17, y + 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, redstone, 16, y + 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, redstone, 14, y + 2, 11, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 14, y + 1, 11, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.WALL, Direction.EAST, true), 13, y + 1, 11, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50039_.m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.NORTH), 14, y + 2, 10, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 14, y + 1, 9, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.WALL, Direction.EAST, false), 13, y + 1, 9, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50032_.m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.NORTH), 14, y + 2, 9, rotation, sbb);
        this.setBlockStateRotated(world, redstone, 11, y + 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 11, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.WALL, Direction.SOUTH, true), 11, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50039_.m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.WEST), 10, y + 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 9, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.WALL, Direction.SOUTH, false), 9, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50032_.m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.WEST), 9, y + 2, 14, rotation, sbb);
    }
    
    private void makeWoodPillar(final WorldGenLevel world, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb) {
        final BlockState log = ((RotatedPillarBlock)TFBlocks.DARK_LOG.get()).m_49966_();
        this.setBlockStateRotated(world, log, x, y + 2, z, rotation, sbb);
        this.setBlockStateRotated(world, log, x, y + 3, z, rotation, sbb);
        this.setBlockStateRotated(world, log, x, y + 4, z, rotation, sbb);
    }
    
    private void placeItemFrameRotated(final WorldGenLevel world, final int x, final int y, final int z, final Rotation rotation, final Direction direction, final ItemStack itemStack, final BoundingBox sbb) {
        final int dx = this.getXWithOffsetRotated(x, z, rotation);
        final int dy = this.m_73544_(y);
        final int dz = this.getZWithOffsetRotated(x, z, rotation);
        final Direction facing = this.f_73379_.m_55952_(rotation).m_55954_(direction).m_122424_();
        final BlockPos pos = new BlockPos(dx, dy, dz).m_142300_(facing);
        if (sbb.m_71051_((Vec3i)pos)) {
            final ItemFrame frame = new ItemFrame((Level)world.m_6018_(), pos, facing);
            if (!itemStack.m_41619_()) {
                frame.m_31789_(itemStack, false);
            }
            world.m_7967_((Entity)frame);
        }
    }
    
    private void decorateAquarium(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        this.makePillarFrame(world, sbb, this.deco, rotation, 12, y, 3, 4, 4, 13, false);
        this.fillBlocksRotated(world, sbb, 13, y + 4, 4, 14, y + 4, 14, Blocks.f_49990_.m_49966_(), rotation);
        this.makePillarFrame(world, sbb, this.deco, rotation, 6, y, 12, 4, 4, 4, false);
        this.fillBlocksRotated(world, sbb, 6, y + 5, 12, 9, y + 5, 15, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, 7, y + 4, 13, 8, y + 5, 14, Blocks.f_49990_.m_49966_(), rotation);
    }
    
    private void decorateForge(final WorldGenLevel world, final Random decoRNG, final BoundingBox sbb, final Rotation rotation, final int y) {
        final TFStructureDecorator forgeDeco = this.deco;
        this.fillBlocksRotated(world, sbb, 17, y + 1, 1, 17, y + 4, 6, forgeDeco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 1, 17, y + 4, 1, forgeDeco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 17, 17, y + 4, 17, forgeDeco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 12, 17, y + 4, 17, forgeDeco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 2, 16, y + 1, 5, forgeDeco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 2, 12, y + 1, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 6, 16, y + 1, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 13, 16, y + 1, 16, forgeDeco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 12, 12, y + 1, 16, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 12, 16, y + 1, 12, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), rotation);
        this.makeFurnacePillar(world, decoRNG, 13, y, 1, Direction.SOUTH, rotation, sbb);
        this.makeFurnacePillar(world, decoRNG, 15, y, 1, Direction.SOUTH, rotation, sbb);
        this.makeFurnacePillar(world, decoRNG, 17, y, 3, Direction.WEST, rotation, sbb);
        this.makeFurnacePillar(world, decoRNG, 17, y, 5, Direction.WEST, rotation, sbb);
        this.makeFurnacePillar(world, decoRNG, 13, y, 17, Direction.NORTH, rotation, sbb);
        this.makeFurnacePillar(world, decoRNG, 15, y, 17, Direction.NORTH, rotation, sbb);
        this.makeFurnacePillar(world, decoRNG, 17, y, 13, Direction.WEST, rotation, sbb);
        this.makeFurnacePillar(world, decoRNG, 17, y, 15, Direction.WEST, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 17, y, 6, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 12, y, 17, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 17, y, 12, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 17, y, 9, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 9, y, 17, rotation, sbb);
        BlockState anvil = (BlockState)((Block)BlockTags.f_13033_.m_13288_(decoRNG)).m_49966_().m_61124_((Property)AnvilBlock.f_48764_, (Comparable)Direction.Plane.HORIZONTAL.m_122560_(decoRNG));
        this.setBlockStateRotated(world, anvil, 13, y + 2, 5, rotation, sbb);
        anvil = (BlockState)((Block)BlockTags.f_13033_.m_13288_(decoRNG)).m_49966_().m_61124_((Property)AnvilBlock.f_48764_, (Comparable)Direction.Plane.HORIZONTAL.m_122560_(decoRNG));
        this.setBlockStateRotated(world, anvil, 13, y + 2, 13, rotation, sbb);
        this.makeFirePit(world, forgeDeco, 6, y + 1, 12, rotation, sbb);
    }
    
    private void makeFurnacePillar(final WorldGenLevel world, final Random rand, final int x, final int y, final int z, final Direction direction, final Rotation rotation, final BoundingBox sbb) {
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, direction, true), x, y + 2, z, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50094_.m_49966_().m_61124_((Property)AbstractFurnaceBlock.f_48683_, (Comparable)direction.m_122424_()), x, y + 3, z, rotation, sbb);
        final int amount = rand.nextBoolean() ? (rand.nextInt(5) + 4) : 0;
        if (amount > 0) {
            final int dx = this.getXWithOffsetRotated(x, z, rotation);
            final int dy = this.m_73544_(y + 3);
            final int dz = this.getZWithOffsetRotated(x, z, rotation);
            final BlockPos pos = new BlockPos(dx, dy, dz);
            if (sbb.m_71051_((Vec3i)pos) && world.m_8055_(pos).m_60734_() == Blocks.f_50094_) {
                final Container inv = (Container)world.m_7702_(pos);
                inv.m_6836_(1, new ItemStack((ItemLike)Items.f_42414_, amount));
            }
        }
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, direction, false), x, y + 4, z, rotation, sbb);
    }
    
    private void makeStonePillar(final WorldGenLevel world, final TFStructureDecorator forgeDeco, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb) {
        for (int py = 1; py <= 4; ++py) {
            this.setBlockStateRotated(world, forgeDeco.pillarState, x, y + py, z, rotation, sbb);
        }
    }
    
    private void makeFirePit(final WorldGenLevel world, final TFStructureDecorator myDeco, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb) {
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), x - 1, y, z, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, false), x + 1, y, z, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), x, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), x, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, myDeco.pillarState, x + 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, myDeco.pillarState, x + 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, myDeco.pillarState, x - 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, myDeco.pillarState, x - 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50134_.m_49966_(), x, y, z, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50083_.m_49966_(), x, y + 1, z, rotation, sbb);
    }
    
    private void decorateNetherwart(final WorldGenLevel world, final Random decoRNG, final BoundingBox sbb, final Rotation rotation, final int y, final boolean isTop) {
        final TFStructureDecorator netherDeco = this.deco;
        this.makePillarFrame(world, sbb, netherDeco, rotation, 12, y, 9, 4, 4, 7, true);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 10, 14, y + 1, 14, Blocks.f_50135_.m_49966_(), rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 2, 10, 14, y + 2, 14, Blocks.f_50200_.m_49966_(), rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 4, 10, 14, y + 4, 14, Blocks.f_50135_.m_49966_(), rotation);
        this.makePillarFrame(world, sbb, netherDeco, rotation, 5, y, 12, 3, isTop ? 4 : 9, 3, true);
        this.setBlockStateRotated(world, netherDeco.blockState, 6, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, netherDeco.blockState, 6, y + (isTop ? 4 : 9), 13, rotation, sbb);
        this.setSpawnerRotated(world, 6, y + 3, 13, rotation, (EntityType<?>)EntityType.f_20551_, sbb);
        this.destroyTower(world, decoRNG, 12, y, 3, 2, sbb);
    }
    
    private void decorateBotanical(final WorldGenLevel world, final ChunkGenerator generator, final Random decoRNG, final BoundingBox sbb, final Rotation rotation, final int y) {
        this.makePillarFrame(world, sbb, this.deco, rotation, 12, y, 12, 4, 4, 4, true);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 13, 14, y + 1, 14, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 4, 13, 14, y + 4, 14, this.deco.blockState, rotation);
        this.placeRandomPlant(world, decoRNG, 13, y + 2, 13, rotation, sbb);
        this.placeRandomPlant(world, decoRNG, 13, y + 2, 14, rotation, sbb);
        this.placeRandomPlant(world, decoRNG, 14, y + 2, 13, rotation, sbb);
        this.placeRandomPlant(world, decoRNG, 14, y + 2, 14, rotation, sbb);
        for (int py = 1; py <= 4; ++py) {
            this.setBlockStateRotated(world, this.deco.pillarState, 12, y + py, 4, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.pillarState, 15, y + py, 4, rotation, sbb);
        }
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, true), 13, y + 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, true), 14, y + 1, 4, rotation, sbb);
        this.placeTreasureRotated(world, 13, y + 2, 4, this.m_73549_(), rotation, TFTreasure.DARKTOWER_CACHE, sbb);
        this.setBlockStateRotated(world, Blocks.f_50091_.m_49966_(), 14, y + 2, 4, rotation, sbb);
        final BlockState slab = (BlockState)Blocks.f_50399_.m_49966_().m_61124_((Property)SlabBlock.f_56353_, (Comparable)SlabType.TOP);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, true), 12, y + 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, slab, 13, y + 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, slab, 14, y + 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, true), 15, y + 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, true), 12, y + 1, 10, rotation, sbb);
        this.setBlockStateRotated(world, slab, 13, y + 1, 10, rotation, sbb);
        this.setBlockStateRotated(world, slab, 14, y + 1, 10, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, true), 15, y + 1, 10, rotation, sbb);
        for (int x = 12; x <= 15; ++x) {
            this.placeRandomPlant(world, decoRNG, x, y + 2, 7, rotation, sbb);
            this.placeRandomPlant(world, decoRNG, x, y + 2, 10, rotation, sbb);
        }
        this.placeTreePlanter(world, generator, decoRNG.nextInt(5), 6, y + 1, 12, rotation, sbb);
    }
    
    private void placeTreePlanter(final WorldGenLevel world, final ChunkGenerator generator, final int treeNum, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb) {
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), x - 1, y, z, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, false), x + 1, y, z, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), x, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), x, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50493_.m_49966_(), x, y, z, rotation, sbb);
        final int dx = this.getXWithOffsetRotated(x, z, rotation);
        final int dy = this.m_73544_(y + 1);
        final int dz = this.getZWithOffsetRotated(x, z, rotation);
        if (sbb.m_71051_((Vec3i)new BlockPos(dx, dy, dz))) {
            ConfiguredFeature configuredFeature = switch (treeNum) {
                case 1 -> Features.f_126954_;
                case 2 -> Features.f_126950_;
                case 3 -> ConfiguredFeatures.TWILIGHT_OAK_BASE;
                case 4 -> ConfiguredFeatures.RAINBOW_OAK_TREE_BASE;
                default -> Features.f_126948_;
            };
            final ConfiguredFeature<?, ?> treeGen = (ConfiguredFeature<?, ?>)configuredFeature;
            for (int i = 0; i < 100; ++i) {
                if (treeGen.m_65385_(world, generator, world.m_5822_(), new BlockPos(dx, dy, dz))) {
                    break;
                }
            }
        }
    }
    
    private void placeRandomPlant(final WorldGenLevel world, final Random decoRNG, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb) {
        final Block flowerPot = (Block)BlockTagGenerator.DARK_TOWER_ALLOWED_POTS.m_13288_(decoRNG);
        final BlockState flowerPotState = flowerPot.m_49966_();
        this.setBlockStateRotated(world, (decoRNG.nextInt(10) == 0) ? Blocks.f_50276_.m_49966_() : flowerPotState, x, y, z, rotation, sbb);
    }
    
    private void makeBottomEntrance(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        this.makeFirePit(world, this.deco, 13, y + 1, 3, rotation, sbb);
        this.makeFirePit(world, this.deco, 3, y + 1, 13, rotation, sbb);
        this.makeFirePit(world, this.deco, 13, y + 1, 13, rotation, sbb);
        this.makePillarFrame(world, sbb, this.deco, rotation, 7, y, 7, 3, 4, 3, false);
    }
    
    protected void addTimberMaze(final WorldGenLevel world, final Random rand, final BoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        Rotation floorside = Rotation.NONE;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            floorside = floorside.m_55952_(Rotation.CLOCKWISE_90);
            this.makeTimberBeams(world, rand, sbb, floorside, y, y == bottom && bottom != spacing, y >= top - spacing, top);
        }
    }
    
    protected void makeTimberBeams(final WorldGenLevel world, final Random rand, final BoundingBox sbb, final Rotation rotation, final int y, final boolean isBottom, final boolean isTop, final int top) {
        final BlockState beamID = ((RotatedPillarBlock)TFBlocks.TWILIGHT_OAK_LOG.get()).m_49966_();
        final BlockState beamStateNS = (BlockState)beamID.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Z);
        final BlockState beamStateUD = (BlockState)beamID.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Y);
        final BlockState beamStateEW = (BlockState)beamID.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.X);
        for (int z = 1; z < this.size - 1; ++z) {
            this.setBlockStateRotated(world, beamStateNS, 4, y, z, rotation, sbb);
            this.setBlockStateRotated(world, beamStateNS, 9, y, z, rotation, sbb);
            this.setBlockStateRotated(world, beamStateNS, 14, y, z, rotation, sbb);
        }
        int z = this.pickBetweenExcluding(3, this.size - 3, rand, 4, 9, 14);
        for (int x = 5; x < 9; ++x) {
            this.setBlockStateRotated(world, beamStateEW, x, y, z, rotation, sbb);
        }
        z = this.pickBetweenExcluding(3, this.size - 3, rand, 4, 9, 14);
        for (int x = 10; x < 14; ++x) {
            this.setBlockStateRotated(world, beamStateEW, x, y, z, rotation, sbb);
        }
        final int x2 = 4;
        final int z2 = this.pickFrom(rand, 4, 9, 14);
        final int x3 = 9;
        final int z3 = this.pickFrom(rand, 4, 9, 14);
        final int x4 = 14;
        final int z4 = this.pickFrom(rand, 4, 9, 14);
        for (int by = 1; by < 5; ++by) {
            if (!isBottom || this.checkPost(world, x2, y - 5, z2, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x2, y - by, z2, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.WEST), x2 + 1, y - by, z2, rotation, sbb);
            }
            if (!isBottom || this.checkPost(world, x3, y - 5, z3, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x3, y - by, z3, rotation, sbb);
            }
            if (!isBottom || this.checkPost(world, x4, y - 5, z4, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x4, y - by, z4, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.EAST), x4 - 1, y - by, z4, rotation, sbb);
            }
        }
        if (isTop) {
            final Rotation topFloorRotation = RotationUtil.ROTATIONS[(this.f_73383_.m_162396_() + top + 1) % 4];
            final int ladderX = 4;
            final int ladderZ = 10;
            for (int by2 = 1; by2 < 5; ++by2) {
                this.setBlockStateRotated(world, beamStateUD, ladderX, y + by2, 9, topFloorRotation, sbb);
                this.setBlockStateRotated(world, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.NORTH), ladderX, y + by2, ladderZ, topFloorRotation, sbb);
            }
            this.setBlockStateRotated(world, DarkTowerMainComponent.AIR, ladderX, y + 6, 9, topFloorRotation, sbb);
            this.setBlockStateRotated(world, this.deco.fenceState, ladderX + 1, y + 5, ladderZ, topFloorRotation, sbb);
            this.setBlockStateRotated(world, this.deco.fenceState, ladderX - 1, y + 5, ladderZ, topFloorRotation, sbb);
            this.setBlockStateRotated(world, this.deco.fenceState, ladderX + 1, y + 6, ladderZ, topFloorRotation, sbb);
            this.setBlockStateRotated(world, this.deco.fenceState, ladderX - 1, y + 6, ladderZ, topFloorRotation, sbb);
        }
        if (!isBottom && !isTop) {
            final int sx = this.pickFrom(rand, 6, 7, 11);
            final int sz = this.pickFrom(rand, 6, 11, 12);
            this.makeMiniGhastSpawner(world, y, sx, sz, sbb);
        }
        final int lx = this.pickFrom(rand, 2, 12, 16);
        final int lz = 2 + rand.nextInt(15);
        this.setBlockStateRotated(world, Blocks.f_50261_.m_49966_(), lx, y + 2, lz, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.CEILING, rand.nextBoolean() ? Direction.EAST : Direction.NORTH, false), lx, y + 1, lz, rotation, sbb);
    }
    
    private void makeMiniGhastSpawner(final WorldGenLevel world, final int y, final int sx, final int sz, final BoundingBox sbb) {
        this.setSpawner(world, sx, y + 2, sz, sbb, TFEntities.CARMINITE_GHASTLING, spawner -> {
            final BaseSpawner base = spawner.m_59801_();
            base.f_45453_ = 16;
            base.f_45451_ = 2;
            base.f_45449_ = 1;
        });
    }
    
    protected void addBuilderPlatforms(final WorldGenLevel world, final Random rand, final BoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        Rotation floorside = Rotation.NONE;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top - spacing; y += spacing) {
            this.makeBuilderPlatforms(world, rand, sbb, floorside, y);
            floorside = floorside.m_55952_(Rotation.CLOCKWISE_90);
            floorside = floorside.m_55952_(RotationUtil.ROTATIONS[rand.nextInt(3)]);
        }
        this.makeBuilderPlatform(world, rand, Rotation.CLOCKWISE_90, bottom, 5, true, sbb);
        this.makeBuilderPlatform(world, rand, Rotation.COUNTERCLOCKWISE_90, bottom, 5, true, sbb);
        for (int y = bottom - 4; y < bottom; ++y) {
            this.setBlockStateRotated(world, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.WEST), 1, y, 5, Rotation.CLOCKWISE_90, sbb);
            this.setBlockStateRotated(world, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.WEST), 1, y, 5, Rotation.COUNTERCLOCKWISE_90, sbb);
        }
        this.addTopBuilderPlatform(world, rand, top, spacing, sbb);
    }
    
    protected void makeBuilderPlatforms(final WorldGenLevel world, final Random rand, final BoundingBox sbb, final Rotation rotation, final int y) {
        final int z = this.size / 2 + rand.nextInt(5) - rand.nextInt(5);
        this.makeBuilderPlatform(world, rand, rotation, y, z, false, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.WEST), 1, y + 1, z, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.WEST), 1, y + 2, z, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.WEST), 1, y + 3, z, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.WEST), 1, y + 4, z, rotation, sbb);
        this.makeBuilderPlatform(world, rand, rotation, y + 5, z, true, sbb);
        if (y % 2 == 1) {
            final int sx = this.pickFrom(rand, 5, 9, 13);
            final int sz = (sx == 9) ? (rand.nextBoolean() ? 5 : 13) : 9;
            final BlockState antibuilder = ((Block)TFBlocks.ANTIBUILDER.get()).m_49966_();
            this.setBlockStateRotated(world, antibuilder, sx, y + 2, sz, rotation, sbb);
        }
        else {
            final int sx = rand.nextBoolean() ? 5 : 13;
            final int sz = rand.nextBoolean() ? 5 : 13;
            this.makeLampCluster(world, rand, sx, y, sz, rotation, sbb);
        }
    }
    
    private void addTopBuilderPlatform(final WorldGenLevel world, final Random rand, final int top, final int spacing, final BoundingBox sbb) {
        final Rotation rotation = RotationUtil.ROTATIONS[(this.f_73383_.m_162396_() + top + 1) % 4];
        this.fillBlocksRotated(world, sbb, 5, top - spacing, 9, 7, top - spacing, 11, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, 6, top - spacing, 9, 6, top, 9, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, 6, top - spacing + 1, 10, 6, top - 1, 10, (BlockState)Blocks.f_50155_.m_49966_().m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.NORTH), rotation);
        this.setBlockStateRotated(world, DarkTowerMainComponent.AIR, 6, top + 1, 9, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 5, top, 10, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 7, top, 10, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 5, top + 1, 10, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 7, top + 1, 10, rotation, sbb);
        final BlockState inactiveBuilder = ((Block)TFBlocks.CARMINITE_BUILDER.get()).m_49966_();
        this.setBlockStateRotated(world, inactiveBuilder, 7, top - spacing, 10, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.FLOOR, rand.nextBoolean() ? Direction.EAST : Direction.NORTH, false), 7, top - spacing + 1, 11, rotation, sbb);
    }
    
    private void makeBuilderPlatform(final WorldGenLevel world, final Random rand, final Rotation rotation, final int y, final int z, final boolean hole, final BoundingBox sbb) {
        this.setBlockStateRotated(world, this.deco.accentState, 1, y, z - 1, rotation, sbb);
        if (!hole) {
            this.setBlockStateRotated(world, this.deco.accentState, 1, y, z, rotation, sbb);
        }
        this.setBlockStateRotated(world, this.deco.accentState, 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 2, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 2, y, z, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 2, y, z + 1, rotation, sbb);
        final BlockState inactiveBuilder = ((Block)TFBlocks.CARMINITE_BUILDER.get()).m_49966_();
        this.setBlockStateRotated(world, inactiveBuilder, 2, y, hole ? (z + 1) : (z - 1), rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.FLOOR, rand.nextBoolean() ? Direction.EAST : Direction.NORTH, false), 2, y + 1, z, rotation, sbb);
    }
    
    private void makeLampCluster(final WorldGenLevel world, final Random rand, final int sx, final int y, final int sz, final Rotation rotation, final BoundingBox sbb) {
        final int radius = 4;
        for (int i = 0; i < 5; ++i) {
            int lx = sx;
            int ly = y;
            int lz = sz;
            for (int move = 0; move < 10; ++move) {
                this.setBlockStateRotated(world, Blocks.f_50261_.m_49966_(), lx, ly, lz, rotation, sbb);
                int direction = rand.nextInt(8);
                if (direction > 5) {
                    direction -= 2;
                }
                final Direction facing = Direction.values()[direction];
                lx += facing.m_122429_();
                ly += facing.m_122430_();
                lz += facing.m_122431_();
                if (lx > sx + radius || lx < sx - radius || ly > y + radius || ly < y - radius || lz > sz + radius) {
                    break;
                }
                if (lz < sz - radius) {
                    break;
                }
            }
        }
        for (int i = 0; i < 5; ++i) {
            int lx = sx;
            int ly = y;
            int lz = sz;
            final Direction[] directions = new Direction[10];
            for (int move2 = 0; move2 < 10; ++move2) {
                int direction2 = rand.nextInt(8);
                if (direction2 > 5) {
                    direction2 -= 2;
                }
                directions[move2] = Direction.values()[direction2];
            }
            for (int move2 = 0; move2 < 10; ++move2) {
                final Direction direction3 = directions[move2];
                lx += direction3.m_122429_();
                ly += direction3.m_122430_();
                lz += direction3.m_122431_();
                if (lx > sx + radius || lx < sx - radius || ly > y + radius || ly < y - radius || lz > sz + radius) {
                    break;
                }
                if (lz < sz - radius) {
                    break;
                }
                if (this.getBlockStateFromPosRotated(world, lx, ly, lz, sbb, rotation).m_60734_() != Blocks.f_50261_) {
                    AttachFace face = null;
                    Direction orientation = null;
                    switch (direction3) {
                        case NORTH: {
                            face = AttachFace.WALL;
                            orientation = Direction.SOUTH;
                            break;
                        }
                        case SOUTH: {
                            face = AttachFace.WALL;
                            orientation = Direction.NORTH;
                            break;
                        }
                        case EAST: {
                            face = AttachFace.WALL;
                            orientation = Direction.WEST;
                            break;
                        }
                        case WEST: {
                            face = AttachFace.WALL;
                            orientation = Direction.EAST;
                            break;
                        }
                        case UP: {
                            face = AttachFace.FLOOR;
                            orientation = Direction.EAST;
                            break;
                        }
                        default: {
                            face = AttachFace.CEILING;
                            orientation = Direction.NORTH;
                            break;
                        }
                    }
                    this.setBlockStateRotated(world, DarkTowerWingComponent.getLeverState(Blocks.f_50164_.m_49966_(), face, orientation, false), lx, ly, lz, rotation, sbb);
                    break;
                }
            }
        }
    }
}
