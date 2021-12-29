// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.util.TFEntityNames;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.world.gen.feature.WorldGenerator;
import twilightforest.world.feature.TFGenSmallRainboak;
import twilightforest.world.feature.TFGenSmallTwilightOak;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.block.BlockSlab;
import twilightforest.util.VanillaEntityNames;
import net.minecraft.inventory.IInventory;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockAnvil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import twilightforest.enums.WoodVariant;
import twilightforest.block.BlockTFLog;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import net.minecraft.block.BlockDispenser;
import twilightforest.structures.StructureTFDecorator;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockChest;
import twilightforest.loot.TFTreasure;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerDeviceVariant;
import twilightforest.block.BlockTFTowerDevice;
import twilightforest.block.TFBlocks;
import twilightforest.structures.TFMaze;
import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.util.RotationUtil;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.TwilightForestMod;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFDarkTowerMain extends ComponentTFDarkTowerWing
{
    private boolean placedKeys;
    
    public ComponentTFDarkTowerMain() {
        this.placedKeys = false;
    }
    
    public ComponentTFDarkTowerMain(final TFFeature feature, final World world, final Random rand, final int index, final int x, final int y, final int z) {
        this(feature, world, rand, index, x + 10, y, z + 10, EnumFacing.NORTH);
    }
    
    public ComponentTFDarkTowerMain(final TFFeature feature, final World world, final Random rand, final int index, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, index, x, y, z, 19, 56 + rand.nextInt(32) / 5 * 5, rotation);
        this.placedKeys = false;
        if (this.field_74887_e.field_78894_e > 245) {
            final int amtToLower = (this.field_74887_e.field_78894_e - 245) / 5 * 5 + 5;
            TwilightForestMod.LOGGER.info("Lowering Dark Tower max height by {} to be within world bounds", (Object)amtToLower);
            this.height -= amtToLower;
            final StructureBoundingBox field_74887_e = this.field_74887_e;
            field_74887_e.field_78894_e -= amtToLower;
        }
        if (this.deco == null) {
            this.deco = new StructureDecoratorDarkTower();
        }
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        if (this.func_74877_c() > 0) {
            this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        }
        Rotation mainDir = null;
        if (this.func_74877_c() < 2) {
            mainDir = RotationUtil.ROTATIONS[rand.nextInt(RotationUtil.ROTATIONS.length)];
            for (final Rotation rotation : RotationUtil.ROTATIONS) {
                if (rotation != mainDir) {
                    final int[] dest = this.getValidOpening(rand, rotation);
                    final int childHeight = this.validateChildHeight(21 + rand.nextInt(10), 11);
                    this.makeTowerWing(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], 11, childHeight, rotation);
                }
            }
        }
        else {
            for (final Rotation i : RotationUtil.ROTATIONS) {
                final int[] dest = this.getValidOpening(rand, i);
                this.makeBossTrapWing(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], i);
            }
        }
        if (this.func_74877_c() > 0) {
            for (final Rotation i : RotationUtil.ROTATIONS) {
                if (i != Rotation.CLOCKWISE_180) {
                    final int[] dest = this.getValidOpening(rand, i);
                    dest[1] = 1;
                    final int childHeight = this.validateChildHeight(21 + rand.nextInt(10), 11);
                    this.makeTowerWing(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], 11, childHeight, i);
                }
            }
            this.makeABeard(parent, list, rand);
        }
        else {
            for (final Rotation rotation : new Rotation[] { Rotation.NONE, Rotation.CLOCKWISE_180 }) {
                final int[] dest = this.getValidOpening(rand, rotation);
                dest[1] = 1;
                final int childHeight = this.validateChildHeight(10 + rand.nextInt(5), 9);
                this.makeEntranceTower(list, rand, 5, dest[0], dest[1], dest[2], 9, childHeight, rotation);
            }
        }
        if (mainDir != null) {
            final int[] dest2 = this.getValidOpening(rand, mainDir);
            this.makeNewLargeTower(list, rand, this.func_74877_c() + 1, dest2[0], dest2[1], dest2[2], mainDir);
        }
        this.makeARoof(parent, list, rand);
        if (!this.placedKeys && this.func_74877_c() < 2) {
            final ArrayList<ComponentTFDarkTowerWing> possibleKeyTowers = new ArrayList<ComponentTFDarkTowerWing>();
            for (final Object piece : list) {
                if (piece instanceof ComponentTFDarkTowerWing) {
                    final ComponentTFDarkTowerWing wing = (ComponentTFDarkTowerWing)piece;
                    if (wing.size != 9 || wing.func_74877_c() != this.func_74877_c()) {
                        continue;
                    }
                    possibleKeyTowers.add(wing);
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
    
    private boolean makeEntranceTower(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int childSize, final int childHeight, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final ComponentTFDarkTowerBridge bridge = new ComponentTFDarkTowerEntranceBridge(this.getFeatureType(), index, dx[0], dx[1], dx[2], childSize, childHeight, direction);
        list.add(bridge);
        bridge.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
    
    private boolean makeNewLargeTower(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        final int wingSize = 15;
        final int wingHeight = 56;
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final ComponentTFDarkTowerMainBridge bridge = new ComponentTFDarkTowerMainBridge(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.add(bridge);
        bridge.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation, EnumDarkTowerDoor.LOCKED);
        return true;
    }
    
    private boolean makeBossTrapWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        final int wingSize = 11;
        final int wingHeight = 9;
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final ComponentTFDarkTowerBossBridge bridge = new ComponentTFDarkTowerBossBridge(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.add(bridge);
        bridge.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
    
    @Override
    public void makeARoof(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (this.func_74877_c() < 2) {
            super.makeARoof(parent, list, rand);
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        if (this.func_74877_c() == 0) {
            for (int x = 0; x < this.size; ++x) {
                for (int z = 0; z < this.size; ++z) {
                    this.func_175811_a(world, this.deco.accentState, x, -1, z, sbb);
                }
            }
        }
        this.nullifySkyLightForBoundingBox(world);
        final int totalFloors = this.height / 5;
        final boolean beamMaze = decoRNG.nextBoolean();
        int centerFloors = beamMaze ? 4 : (totalFloors / 2);
        final int bottomFloors = (totalFloors - centerFloors) / 2;
        centerFloors = totalFloors - bottomFloors * 2;
        final int topFloorsStartY = this.height - (bottomFloors * 5 + 1);
        this.addThreeQuarterFloors(world, decoRNG, sbb, 0, bottomFloors * 5);
        if (this.func_74877_c() < 2) {
            this.addThreeQuarterFloors(world, decoRNG, sbb, topFloorsStartY, this.height - 1);
        }
        else {
            this.addThreeQuarterFloorsDecorateBoss(world, decoRNG, sbb, topFloorsStartY, this.height - 1);
            this.destroyTower(world, decoRNG, 12, this.height + 4, 3, 4, sbb);
            this.destroyTower(world, decoRNG, 3, this.height + 4, 12, 4, sbb);
            this.destroyTower(world, decoRNG, 3, this.height + 4, 3, 4, sbb);
            this.destroyTower(world, decoRNG, 12, this.height + 4, 12, 4, sbb);
            this.destroyTower(world, decoRNG, 8, this.height + 4, 8, 5, sbb);
            this.decorateBossSpawner(world, decoRNG, sbb, Rotation.NONE, this.height - 6);
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
    
    protected void addThreeQuarterFloors(final World world, final Random decoRNG, final StructureBoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        Rotation rotation = RotationUtil.ROTATIONS[(this.field_74887_e.field_78895_b + bottom) % 4];
        if (bottom == 0) {
            this.makeLargeStairsUp(world, sbb, rotation, 0);
            rotation = rotation.func_185830_a(Rotation.COUNTERCLOCKWISE_90);
            this.makeBottomEntrance(world, decoRNG, sbb, rotation, bottom);
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
                this.decorateFloor(world, decoRNG, sbb, rotation, y, isBottomFloor, isTopFloor);
            }
            rotation = rotation.func_185830_a(Rotation.COUNTERCLOCKWISE_90);
        }
    }
    
    protected void addThreeQuarterFloorsDecorateBoss(final World world, final Random decoRNG, final StructureBoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        Rotation rotation = RotationUtil.ROTATIONS[(this.field_74887_e.field_78895_b + bottom) % 4];
        if (bottom == 0) {
            this.makeLargeStairsUp(world, sbb, rotation, 0);
            rotation = rotation.func_185830_a(Rotation.COUNTERCLOCKWISE_90);
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            final boolean isBottomFloor = y == bottom && bottom != spacing;
            final boolean isTopFloor = y >= top - spacing;
            final boolean isTowerTopFloor = y >= this.height - spacing - 2;
            this.makeThreeQuarterFloor(world, sbb, rotation, y, isBottomFloor, isTowerTopFloor);
            if (!isTopFloor) {
                this.makeLargeStairsUp(world, sbb, rotation, y);
                this.decorateExperiment(world, decoRNG, sbb, rotation, y);
            }
            rotation = rotation.func_185830_a(Rotation.COUNTERCLOCKWISE_90);
        }
    }
    
    private void decorateFloor(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y, final boolean isBottom, final boolean isTop) {
        if (isTop) {
            switch (decoRNG.nextInt(3)) {
                default: {
                    this.decorateAquarium(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 1: {
                    this.decorateBotanical(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 2: {
                    this.decorateNetherwart(world, decoRNG, sbb, rotation, y, isTop);
                    break;
                }
            }
        }
        else if (isBottom) {
            switch (decoRNG.nextInt(4)) {
                default: {
                    this.decorateAquarium(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 1: {
                    this.decorateBotanical(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 2: {
                    if (y + this.field_74887_e.field_78895_b > 64) {
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
                    this.decorateReappearingMaze(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 2: {
                    this.decorateUnbuilderMaze(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 3: {
                    this.decorateAquarium(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 4: {
                    this.decorateBotanical(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 5: {
                    if (y + this.field_74887_e.field_78895_b > 64) {
                        this.decorateNetherwart(world, decoRNG, sbb, rotation, y, isTop);
                        break;
                    }
                }
                case 6: {
                    this.decorateLounge(world, decoRNG, sbb, rotation, y);
                    break;
                }
                case 7: {
                    this.decorateForge(world, decoRNG, sbb, rotation, y);
                    break;
                }
            }
        }
    }
    
    protected void makeThreeQuarterFloor(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int y, final boolean isBottom, final boolean isTowerTopFloor) {
        final int half = this.size / 2;
        this.fillBlocksRotated(world, sbb, half + 1, y, 1, this.size - 2, y, half + 1, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 1, y, half + 1, this.size - 2, y, this.size - 2, this.deco.blockState, rotation);
        final int startZ = isBottom ? 1 : 3;
        this.fillBlocksRotated(world, sbb, 1, y, half, half, y, half, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, half, y, startZ, half, y, half, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, 1, y + 1, half, half, y + 1, half, this.deco.fenceState, rotation);
        this.fillBlocksRotated(world, sbb, half, y + 1, startZ, half, y + 1, half, this.deco.fenceState, rotation);
        if (isTowerTopFloor) {
            this.fillBlocksRotated(world, sbb, 1, y + 0, half - 2, 3, y + 0, half, this.deco.accentState, rotation);
            this.fillBlocksRotated(world, sbb, 1, y + 1, half - 2, 3, y + 1, half, this.deco.fenceState, rotation);
            this.fillBlocksRotated(world, sbb, 1, y + 0, half - 1, 2, y + 0, half, this.deco.fenceState, rotation);
            this.fillBlocksRotated(world, sbb, 1, y + 1, half - 1, 2, y + 1, half, ComponentTFDarkTowerMain.AIR, rotation);
        }
    }
    
    protected void makeLargeStairsUp(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        for (int i = 0; i < 5; ++i) {
            final int z = this.size / 2 - i + 4;
            final int sy = y + i + 1;
            this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), 1, sy, z, rotation, sbb);
            this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), 2, sy, z, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 1, sy, z - 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 2, sy, z - 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 3, sy, z - 1, rotation, sbb);
            if (i > 0 && i < 4) {
                this.setBlockStateRotated(world, this.deco.accentState, 3, sy, z, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.fenceState, 3, sy + 1, z, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.fenceState, 3, sy + 2, z, rotation, sbb);
            }
            else if (i == 0) {
                this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, false), 3, sy, z, rotation, sbb);
            }
        }
    }
    
    private void decorateReappearingMaze(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        final int mazeSize = 6;
        final TFMaze maze = new TFMaze(mazeSize, mazeSize);
        maze.setSeed(world.func_72905_C() + this.field_74887_e.field_78897_a * 90342903 + y * 90342903 ^ (long)this.field_74887_e.field_78896_c);
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
        maze.doorBlockState = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.REAPPEARING_INACTIVE);
        maze.torchRarity = 0.0f;
        maze.tall = 3;
        maze.head = 1;
        maze.oddBias = 2;
        maze.copyToStructure(world, 0, y + 1, 0, this, sbb);
        this.decorateMazeDeadEnds(world, decoRNG, maze, y, rotation, sbb);
    }
    
    protected void decorateMazeDeadEnds(final World world, final Random decoRNG, final TFMaze maze, final int y, final Rotation rotation, final StructureBoundingBox sbb) {
        for (int x = 0; x < maze.width; ++x) {
            for (int z = 0; z < maze.depth; ++z) {
                if (!maze.isWall(x, z, x - 1, z) && maze.isWall(x, z, x + 1, z) && maze.isWall(x, z, x, z - 1) && maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(world, decoRNG, maze, x, y, z, 3, rotation, sbb);
                }
                if (maze.isWall(x, z, x - 1, z) && !maze.isWall(x, z, x + 1, z) && maze.isWall(x, z, x, z - 1) && maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(world, decoRNG, maze, x, y, z, 1, rotation, sbb);
                }
                if (maze.isWall(x, z, x - 1, z) && maze.isWall(x, z, x + 1, z) && !maze.isWall(x, z, x, z - 1) && maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(world, decoRNG, maze, x, y, z, 0, rotation, sbb);
                }
                if (maze.isWall(x, z, x - 1, z) && maze.isWall(x, z, x + 1, z) && maze.isWall(x, z, x, z - 1) && !maze.isWall(x, z, x, z + 1)) {
                    this.decorateDeadEnd(world, decoRNG, maze, x, y, z, 2, rotation, sbb);
                }
            }
        }
    }
    
    private void decorateDeadEnd(final World world, final Random decoRNG, final TFMaze maze, final int mx, final int y, final int mz, final int facing, final Rotation rotation, final StructureBoundingBox sbb) {
        final int x = mx * 3 + 1;
        final int z = mz * 3 + 1;
        switch (facing) {
            case 0: {
                this.func_175811_a(world, this.deco.accentState, x + 0, y + 1, z + 1, sbb);
                this.func_175811_a(world, this.deco.accentState, x + 1, y + 1, z + 1, sbb);
                this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P(), x + 0, y + 2, z + 1, sbb);
                this.placeTreasureAtCurrentPosition(world, decoRNG, x + 1, y + 2, z + 1, TFTreasure.darktower_cache, sbb);
                break;
            }
            case 1: {
                this.func_175811_a(world, this.deco.accentState, x + 0, y + 1, z + 0, sbb);
                this.func_175811_a(world, this.deco.accentState, x + 0, y + 1, z + 1, sbb);
                this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P().func_177226_a((IProperty)BlockChest.field_176459_a, (Comparable)EnumFacing.SOUTH), x + 0, y + 2, z + 0, sbb);
                this.placeTreasureAtCurrentPosition(world, decoRNG, x + 0, y + 2, z + 1, TFTreasure.darktower_cache, sbb);
                break;
            }
            case 2: {
                this.func_175811_a(world, this.deco.accentState, x + 0, y + 1, z + 0, sbb);
                this.func_175811_a(world, this.deco.accentState, x + 1, y + 1, z + 0, sbb);
                this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P().func_177226_a((IProperty)BlockChest.field_176459_a, (Comparable)EnumFacing.SOUTH), x + 0, y + 2, z + 0, sbb);
                this.placeTreasureAtCurrentPosition(world, decoRNG, x + 1, y + 2, z + 0, TFTreasure.darktower_cache, sbb);
                break;
            }
            case 3: {
                this.func_175811_a(world, this.deco.accentState, x + 1, y + 1, z + 0, sbb);
                this.func_175811_a(world, this.deco.accentState, x + 1, y + 1, z + 1, sbb);
                this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P().func_177226_a((IProperty)BlockChest.field_176459_a, (Comparable)EnumFacing.SOUTH), x + 1, y + 2, z + 0, sbb);
                this.placeTreasureAtCurrentPosition(world, decoRNG, x + 1, y + 2, z + 1, TFTreasure.darktower_cache, sbb);
                break;
            }
        }
    }
    
    private void decorateUnbuilderMaze(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
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
                        this.setBlockStateRotated(world, ComponentTFDarkTowerMain.AIR, x, y + ay, z, rotation, sbb);
                        if (x > this.size - 7) {
                            ay = decoRNG.nextInt(3) + 1;
                            this.setBlockStateRotated(world, ComponentTFDarkTowerMain.AIR, x, y + ay, z, rotation, sbb);
                        }
                    }
                }
            }
        }
        final IBlockState antiBuilderBlockState = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.ANTIBUILDER);
        this.setBlockStateRotated(world, antiBuilderBlockState, 15, y + 2, 7, rotation, sbb);
        this.setBlockStateRotated(world, antiBuilderBlockState, 11, y + 3, 7, rotation, sbb);
        this.setBlockStateRotated(world, antiBuilderBlockState, 15, y + 2, 13, rotation, sbb);
        this.setBlockStateRotated(world, antiBuilderBlockState, 11, y + 3, 13, rotation, sbb);
        this.setBlockStateRotated(world, antiBuilderBlockState, 5, y + 3, 13, rotation, sbb);
    }
    
    private void decorateLounge(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        this.fillBlocksRotated(world, sbb, 17, y + 1, 1, 17, y + 4, 6, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 1, 17, y + 4, 1, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 2, 16, y + 1, 5, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 2, 12, y + 1, 6, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 6, 16, y + 1, 6, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), rotation);
        this.makeDispenserPillar(world, this.deco, 13, y, 1, EnumFacing.SOUTH, rotation, sbb);
        this.makeDispenserPillar(world, this.deco, 15, y, 1, EnumFacing.SOUTH, rotation, sbb);
        this.makeDispenserPillar(world, this.deco, 17, y, 3, EnumFacing.WEST, rotation, sbb);
        this.makeDispenserPillar(world, this.deco, 17, y, 5, EnumFacing.WEST, rotation, sbb);
        this.makeStonePillar(world, this.deco, 12, y, 1, EnumFacing.NORTH, rotation, sbb);
        this.makeStonePillar(world, this.deco, 17, y, 6, EnumFacing.EAST, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150382_bo.func_176223_P(), 13, y + 2, 5, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150383_bp.func_176223_P().func_177226_a((IProperty)BlockCauldron.field_176591_a, (Comparable)3), 15, y + 2, 3, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 10, y + 1, 17, 17, y + 4, 17, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 10, 17, y + 4, 17, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 11, y + 1, 17, 12, y + 4, 17, Blocks.field_150342_X.func_176223_P(), rotation);
        this.fillBlocksRotated(world, sbb, 14, y + 1, 17, 15, y + 4, 17, Blocks.field_150342_X.func_176223_P(), rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 11, 17, y + 4, 12, Blocks.field_150342_X.func_176223_P(), rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 14, 17, y + 4, 15, Blocks.field_150342_X.func_176223_P(), rotation);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, true), 13, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, true), 14, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, true), 14, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, true), 13, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, false), 11, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), 13, y + 1, 11, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150379_bu.func_176223_P(), 8, y + 3, 8, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), decoRNG.nextBoolean() ? BlockLever.EnumOrientation.DOWN_X : BlockLever.EnumOrientation.DOWN_Z, rotation, false), 8, y + 2, 8, rotation, sbb);
        this.placeTreePlanter(world, decoRNG.nextInt(5), 6, y + 1, 12, rotation, sbb);
    }
    
    private void makeDispenserPillar(final World world, final StructureTFDecorator forgeDeco, final int x, final int y, final int z, final EnumFacing stairMeta, final Rotation rotation, final StructureBoundingBox sbb) {
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(forgeDeco.stairState, stairMeta, rotation, true), x, y + 2, z, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150367_z.func_176223_P().func_177226_a((IProperty)BlockDispenser.field_176441_a, (Comparable)stairMeta), x, y + 3, z, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(forgeDeco.stairState, stairMeta, rotation, false), x, y + 4, z, rotation, sbb);
    }
    
    private void decorateBossSpawner(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        this.setBlockStateRotated(world, TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.UR_GHAST), 9, y + 4, 9, rotation, sbb);
    }
    
    private void decorateExperiment(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        final IBlockState obsidian = Blocks.field_150343_Z.func_176223_P();
        final IBlockState netherrack = Blocks.field_150424_aL.func_176223_P();
        final IBlockState redstone = Blocks.field_150451_bX.func_176223_P();
        final IBlockState inactiveReactor = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.REACTOR_INACTIVE);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 1, 17, y + 4, 6, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 1, 17, y + 4, 1, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 2, 16, y + 1, 5, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 2, 12, y + 1, 6, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 6, 16, y + 1, 6, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), rotation);
        this.makeWoodPillar(world, this.deco, 13, y, 1, rotation, sbb);
        this.makeWoodPillar(world, this.deco, 15, y, 1, rotation, sbb);
        this.makeWoodPillar(world, this.deco, 17, y, 3, rotation, sbb);
        this.makeWoodPillar(world, this.deco, 17, y, 5, rotation, sbb);
        this.makeStonePillar(world, this.deco, 12, y, 1, EnumFacing.NORTH, rotation, sbb);
        this.makeStonePillar(world, this.deco, 17, y, 6, EnumFacing.EAST, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150462_ai.func_176223_P(), 14, y + 2, 4, rotation, sbb);
        this.placeItemFrameRotated(world, 13, y + 2, 1, rotation, EnumFacing.SOUTH, new ItemStack(TFItems.borer_essence), sbb);
        this.placeItemFrameRotated(world, 14, y + 2, 1, rotation, EnumFacing.SOUTH, new ItemStack(Items.field_151137_ax), sbb);
        this.placeItemFrameRotated(world, 15, y + 2, 1, rotation, EnumFacing.SOUTH, new ItemStack(TFItems.borer_essence), sbb);
        this.placeItemFrameRotated(world, 13, y + 3, 1, rotation, EnumFacing.SOUTH, new ItemStack(Items.field_151137_ax), sbb);
        this.placeItemFrameRotated(world, 14, y + 3, 1, rotation, EnumFacing.SOUTH, new ItemStack(Items.field_151073_bk), sbb);
        this.placeItemFrameRotated(world, 15, y + 3, 1, rotation, EnumFacing.SOUTH, new ItemStack(Items.field_151137_ax), sbb);
        this.placeItemFrameRotated(world, 13, y + 4, 1, rotation, EnumFacing.SOUTH, new ItemStack(TFItems.borer_essence), sbb);
        this.placeItemFrameRotated(world, 14, y + 4, 1, rotation, EnumFacing.SOUTH, new ItemStack(Items.field_151137_ax), sbb);
        this.placeItemFrameRotated(world, 15, y + 4, 1, rotation, EnumFacing.SOUTH, new ItemStack(TFItems.borer_essence), sbb);
        this.placeItemFrameRotated(world, 17, y + 2, 3, rotation, EnumFacing.WEST, new ItemStack(TFBlocks.tower_wood, 1, 1), sbb);
        this.placeItemFrameRotated(world, 17, y + 2, 4, rotation, EnumFacing.WEST, new ItemStack(TFBlocks.tower_wood, 1, 0), sbb);
        this.placeItemFrameRotated(world, 17, y + 2, 5, rotation, EnumFacing.WEST, new ItemStack(TFBlocks.tower_wood, 1, 1), sbb);
        this.placeItemFrameRotated(world, 17, y + 3, 3, rotation, EnumFacing.WEST, new ItemStack(TFBlocks.tower_wood, 1, 0), sbb);
        this.placeItemFrameRotated(world, 17, y + 3, 4, rotation, EnumFacing.WEST, new ItemStack(TFItems.carminite), sbb);
        this.placeItemFrameRotated(world, 17, y + 3, 5, rotation, EnumFacing.WEST, new ItemStack(TFBlocks.tower_wood, 1, 0), sbb);
        this.placeItemFrameRotated(world, 17, y + 4, 3, rotation, EnumFacing.WEST, new ItemStack(TFBlocks.tower_wood, 1, 1), sbb);
        this.placeItemFrameRotated(world, 17, y + 4, 4, rotation, EnumFacing.WEST, new ItemStack(TFBlocks.tower_wood, 1, 0), sbb);
        this.placeItemFrameRotated(world, 17, y + 4, 5, rotation, EnumFacing.WEST, new ItemStack(TFBlocks.tower_wood, 1, 1), sbb);
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
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), BlockLever.EnumOrientation.EAST, rotation, false), 13, y + 1, 17, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150331_J.func_176223_P().func_177226_a((IProperty)BlockPistonBase.field_176387_N, (Comparable)EnumFacing.SOUTH), 14, y + 2, 17, rotation, sbb);
        this.setBlockStateRotated(world, redstone, 14, y + 2, 16, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 17, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), BlockLever.EnumOrientation.SOUTH, rotation, false), 17, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150331_J.func_176223_P().func_177226_a((IProperty)BlockPistonBase.field_176387_N, (Comparable)EnumFacing.EAST), 17, y + 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, redstone, 16, y + 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, redstone, 14, y + 2, 11, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 14, y + 1, 11, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), BlockLever.EnumOrientation.EAST, rotation, true), 13, y + 1, 11, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150331_J.func_176223_P().func_177226_a((IProperty)BlockPistonBase.field_176387_N, (Comparable)EnumFacing.NORTH), 14, y + 2, 10, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 14, y + 1, 9, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), BlockLever.EnumOrientation.EAST, rotation, false), 13, y + 1, 9, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150320_F.func_176223_P().func_177226_a((IProperty)BlockPistonBase.field_176387_N, (Comparable)EnumFacing.NORTH), 14, y + 2, 9, rotation, sbb);
        this.setBlockStateRotated(world, redstone, 11, y + 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 11, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), BlockLever.EnumOrientation.SOUTH, rotation, true), 11, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150331_J.func_176223_P().func_177226_a((IProperty)BlockPistonBase.field_176387_N, (Comparable)EnumFacing.WEST), 10, y + 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 9, y + 1, 14, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), BlockLever.EnumOrientation.SOUTH, rotation, false), 9, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150320_F.func_176223_P().func_177226_a((IProperty)BlockPistonBase.field_176387_N, (Comparable)EnumFacing.WEST), 9, y + 2, 14, rotation, sbb);
    }
    
    private void makeWoodPillar(final World world, final StructureTFDecorator forgeDeco, final int x, final int y, final int z, final Rotation rotation, final StructureBoundingBox sbb) {
        final IBlockState log = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.DARK);
        this.setBlockStateRotated(world, log, x, y + 2, z, rotation, sbb);
        this.setBlockStateRotated(world, log, x, y + 3, z, rotation, sbb);
        this.setBlockStateRotated(world, log, x, y + 4, z, rotation, sbb);
    }
    
    private void placeItemFrameRotated(final World world, final int x, final int y, final int z, final Rotation rotation, final EnumFacing direction, final ItemStack itemStack, final StructureBoundingBox sbb) {
        final int dx = this.getXWithOffsetRotated(x, z, rotation);
        final int dy = this.func_74862_a(y);
        final int dz = this.getZWithOffsetRotated(x, z, rotation);
        final EnumFacing facing = this.field_186169_c.func_185830_a(rotation).func_185831_a(direction).func_176734_d();
        final BlockPos pos = new BlockPos(dx, dy, dz).func_177972_a(facing);
        if (sbb.func_175898_b((Vec3i)pos)) {
            final EntityItemFrame frame = new EntityItemFrame(world, pos, facing);
            if (!itemStack.func_190926_b()) {
                frame.func_82334_a(itemStack);
            }
            world.func_72838_d((Entity)frame);
        }
    }
    
    private void decorateAquarium(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        this.makePillarFrame(world, sbb, this.deco, rotation, 12, y, 3, 4, 4, 13, false);
        this.fillBlocksRotated(world, sbb, 13, y + 4, 4, 14, y + 4, 14, Blocks.field_150358_i.func_176223_P(), rotation);
        this.makePillarFrame(world, sbb, this.deco, rotation, 6, y, 12, 4, 4, 4, false);
        this.fillBlocksRotated(world, sbb, 6, y + 5, 12, 9, y + 5, 15, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, 7, y + 4, 13, 8, y + 5, 14, Blocks.field_150358_i.func_176223_P(), rotation);
    }
    
    private void decorateForge(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        final StructureTFDecorator forgeDeco = this.deco;
        this.fillBlocksRotated(world, sbb, 17, y + 1, 1, 17, y + 4, 6, forgeDeco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 1, 17, y + 4, 1, forgeDeco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 17, 17, y + 4, 17, forgeDeco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 12, 17, y + 4, 17, forgeDeco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 2, 16, y + 1, 5, forgeDeco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 2, 12, y + 1, 6, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 6, 16, y + 1, 6, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 13, 16, y + 1, 16, forgeDeco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 12, 12, y + 1, 16, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 12, 16, y + 1, 12, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false), rotation);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 13, y, 1, EnumFacing.SOUTH, rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 15, y, 1, EnumFacing.SOUTH, rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 17, y, 3, EnumFacing.WEST, rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 17, y, 5, EnumFacing.WEST, rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 13, y, 17, EnumFacing.NORTH, rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 15, y, 17, EnumFacing.NORTH, rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 17, y, 13, EnumFacing.WEST, rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 17, y, 15, EnumFacing.WEST, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 17, y, 6, EnumFacing.WEST, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 12, y, 17, EnumFacing.NORTH, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 17, y, 12, EnumFacing.WEST, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 17, y, 9, EnumFacing.WEST, rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 9, y, 17, EnumFacing.NORTH, rotation, sbb);
        IBlockState anvil = Blocks.field_150467_bQ.func_176223_P().func_177226_a((IProperty)BlockAnvil.field_176505_b, (Comparable)decoRNG.nextInt(2)).func_177226_a((IProperty)BlockAnvil.field_176506_a, (Comparable)EnumFacing.field_176754_o[decoRNG.nextInt(4)]);
        this.setBlockStateRotated(world, anvil, 13, y + 2, 5, rotation, sbb);
        anvil = Blocks.field_150467_bQ.func_176223_P().func_177226_a((IProperty)BlockAnvil.field_176505_b, (Comparable)decoRNG.nextInt(2)).func_177226_a((IProperty)BlockAnvil.field_176506_a, (Comparable)EnumFacing.field_176754_o[decoRNG.nextInt(4)]);
        this.setBlockStateRotated(world, anvil, 13, y + 2, 13, rotation, sbb);
        this.makeFirePit(world, forgeDeco, 6, y + 1, 12, rotation, sbb);
    }
    
    private void makeFurnacePillar(final World world, final StructureTFDecorator forgeDeco, final Random rand, final int x, final int y, final int z, final EnumFacing direction, final Rotation rotation, final StructureBoundingBox sbb) {
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, direction, rotation, true), x, y + 2, z, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150460_al.func_176223_P().func_177226_a((IProperty)BlockFurnace.field_176447_a, (Comparable)direction), x, y + 3, z, rotation, sbb);
        final int amount = rand.nextBoolean() ? (rand.nextInt(5) + 4) : 0;
        if (amount > 0) {
            final int dx = this.getXWithOffsetRotated(x, z, rotation);
            final int dy = this.func_74862_a(y + 3);
            final int dz = this.getZWithOffsetRotated(x, z, rotation);
            final BlockPos pos = new BlockPos(dx, dy, dz);
            if (sbb.func_175898_b((Vec3i)pos) && world.func_180495_p(pos).func_177230_c() == Blocks.field_150460_al) {
                final IInventory inv = (IInventory)world.func_175625_s(pos);
                inv.func_70299_a(1, new ItemStack(Items.field_151044_h, amount, 1));
            }
        }
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, direction, rotation, false), x, y + 4, z, rotation, sbb);
    }
    
    private void makeStonePillar(final World world, final StructureTFDecorator forgeDeco, final int x, final int y, final int z, final EnumFacing stairDirection, final Rotation rotation, final StructureBoundingBox sbb) {
        for (int py = 1; py <= 4; ++py) {
            this.setBlockStateRotated(world, forgeDeco.pillarState, x, y + py, z, rotation, sbb);
        }
    }
    
    private void makeFirePit(final World world, final StructureTFDecorator myDeco, final int x, final int y, final int z, final Rotation rotation, final StructureBoundingBox sbb) {
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), x - 1, y, z + 0, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, false), x + 1, y, z + 0, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), x + 0, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false), x + 0, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, myDeco.pillarState, x + 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, myDeco.pillarState, x + 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, myDeco.pillarState, x - 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, myDeco.pillarState, x - 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150424_aL.func_176223_P(), x, y, z, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150480_ab.func_176223_P(), x, y + 1, z, rotation, sbb);
    }
    
    private void decorateNetherwart(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y, final boolean isTop) {
        final StructureTFDecorator netherDeco = this.deco;
        this.makePillarFrame(world, sbb, netherDeco, rotation, 12, y, 9, 4, 4, 7, true);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 10, 14, y + 1, 14, Blocks.field_150425_aM.func_176223_P(), rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 2, 10, 14, y + 2, 14, Blocks.field_150388_bm.func_176223_P(), rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 4, 10, 14, y + 4, 14, Blocks.field_150425_aM.func_176223_P(), rotation);
        this.makePillarFrame(world, sbb, netherDeco, rotation, 5, y, 12, 3, isTop ? 4 : 9, 3, true);
        this.setBlockStateRotated(world, netherDeco.blockState, 6, y + 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, netherDeco.blockState, 6, y + (isTop ? 4 : 9), 13, rotation, sbb);
        this.setSpawnerRotated(world, 6, y + 3, 13, rotation, VanillaEntityNames.BLAZE, sbb);
        this.destroyTower(world, decoRNG, 12, y, 3, 2, sbb);
    }
    
    private void decorateBotanical(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
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
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, true), 13, y + 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, true), 14, y + 1, 4, rotation, sbb);
        this.placeTreasureRotated(world, 13, y + 2, 4, rotation, TFTreasure.basement, sbb);
        this.setBlockStateRotated(world, Blocks.field_150462_ai.func_176223_P(), 14, y + 2, 4, rotation, sbb);
        final IBlockState slab = Blocks.field_150376_bx.func_176223_P().func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.TOP).func_177226_a((IProperty)BlockWoodSlab.field_176557_b, (Comparable)BlockPlanks.EnumType.SPRUCE);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, true), 12, y + 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, slab, 13, y + 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, slab, 14, y + 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, true), 15, y + 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, true), 12, y + 1, 10, rotation, sbb);
        this.setBlockStateRotated(world, slab, 13, y + 1, 10, rotation, sbb);
        this.setBlockStateRotated(world, slab, 14, y + 1, 10, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, true), 15, y + 1, 10, rotation, sbb);
        for (int x = 12; x <= 15; ++x) {
            this.placeRandomPlant(world, decoRNG, x, y + 2, 7, rotation, sbb);
            this.placeRandomPlant(world, decoRNG, x, y + 2, 10, rotation, sbb);
        }
        this.placeTreePlanter(world, decoRNG.nextInt(5), 6, y + 1, 12, rotation, sbb);
    }
    
    private void placeTreePlanter(final World world, final int treeNum, final int x, final int y, final int z, final Rotation rotation, final StructureBoundingBox sbb) {
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), x - 1, y, z + 0, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, false), x + 1, y, z + 0, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), x + 0, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false), x + 0, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150346_d.func_176223_P(), x, y, z, rotation, sbb);
        final int dx = this.getXWithOffsetRotated(x, z, rotation);
        final int dy = this.func_74862_a(y + 1);
        final int dz = this.getZWithOffsetRotated(x, z, rotation);
        if (sbb.func_175898_b((Vec3i)new BlockPos(dx, dy, dz))) {
            WorldGenerator treeGen = null;
            switch (treeNum) {
                default: {
                    treeGen = (WorldGenerator)new WorldGenTrees(false);
                    break;
                }
                case 1: {
                    final IBlockState leaves = Blocks.field_150362_t.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)BlockPlanks.EnumType.JUNGLE).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
                    final IBlockState wood = Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.JUNGLE);
                    treeGen = (WorldGenerator)new WorldGenTrees(true, 3, wood, leaves, false);
                    break;
                }
                case 2: {
                    treeGen = (WorldGenerator)new WorldGenBirchTree(true, false);
                    break;
                }
                case 3: {
                    treeGen = (WorldGenerator)new TFGenSmallTwilightOak(false);
                    break;
                }
                case 4: {
                    treeGen = (WorldGenerator)new TFGenSmallRainboak(false);
                    break;
                }
            }
            for (int i = 0; i < 100; ++i) {
                if (treeGen.func_180709_b(world, world.field_73012_v, new BlockPos(dx, dy, dz))) {
                    break;
                }
            }
        }
    }
    
    private void placeRandomPlant(final World world, final Random decoRNG, final int x, final int y, final int z, final Rotation rotation, final StructureBoundingBox sbb) {
        final int potMeta = decoRNG.nextInt(15);
        final IBlockState flowerPotState = Blocks.field_150457_bL.func_176223_P().func_177226_a((IProperty)BlockFlowerPot.field_176444_a, (Comparable)potMeta);
        this.setBlockStateRotated(world, flowerPotState, x, y, z, rotation, sbb);
    }
    
    private void makeBottomEntrance(final World world, final Random decoRNG, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        this.makeFirePit(world, this.deco, 13, y + 1, 3, rotation, sbb);
        this.makeFirePit(world, this.deco, 3, y + 1, 13, rotation, sbb);
        this.makeFirePit(world, this.deco, 13, y + 1, 13, rotation, sbb);
        this.makePillarFrame(world, sbb, this.deco, rotation, 7, y, 7, 3, 4, 3, false);
    }
    
    protected void addTimberMaze(final World world, final Random rand, final StructureBoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        Rotation floorside = Rotation.NONE;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            floorside = floorside.func_185830_a(Rotation.CLOCKWISE_90);
            this.makeTimberBeams(world, rand, sbb, floorside, y, y == bottom && bottom != spacing, y >= top - spacing, top);
        }
    }
    
    protected void makeTimberBeams(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y, final boolean isBottom, final boolean isTop, final int top) {
        final IBlockState beamID = TFBlocks.twilight_log.func_176223_P();
        final IBlockState beamStateNS = beamID.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z);
        final IBlockState beamStateUD = beamID.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Y);
        final IBlockState beamStateEW = beamID.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X);
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
                this.setBlockStateRotated(world, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.WEST), x2 + 1, y - by, z2, rotation, sbb);
            }
            if (!isBottom || this.checkPost(world, x3, y - 5, z3, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x3, y - by, z3, rotation, sbb);
            }
            if (!isBottom || this.checkPost(world, x4, y - 5, z4, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x4, y - by, z4, rotation, sbb);
                this.setBlockStateRotated(world, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.EAST), x4 - 1, y - by, z4, rotation, sbb);
            }
        }
        if (isTop) {
            final Rotation topFloorRotation = RotationUtil.ROTATIONS[(this.field_74887_e.field_78895_b + top + 1) % 4];
            final int ladderX = 4;
            final int ladderZ = 10;
            for (int by2 = 1; by2 < 5; ++by2) {
                this.setBlockStateRotated(world, beamStateUD, ladderX, y + by2, 9, topFloorRotation, sbb);
                this.setBlockStateRotated(world, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.NORTH), ladderX, y + by2, ladderZ, topFloorRotation, sbb);
            }
            this.setBlockStateRotated(world, ComponentTFDarkTowerMain.AIR, ladderX, y + 6, 9, topFloorRotation, sbb);
            this.setBlockStateRotated(world, this.deco.fenceState, ladderX + 1, y + 5, ladderZ, topFloorRotation, sbb);
            this.setBlockStateRotated(world, this.deco.fenceState, ladderX - 1, y + 5, ladderZ, topFloorRotation, sbb);
            this.setBlockStateRotated(world, this.deco.fenceState, ladderX + 1, y + 6, ladderZ, topFloorRotation, sbb);
            this.setBlockStateRotated(world, this.deco.fenceState, ladderX - 1, y + 6, ladderZ, topFloorRotation, sbb);
        }
        if (!isBottom && !isTop) {
            final int sx = this.pickFrom(rand, 6, 7, 11);
            final int sz = this.pickFrom(rand, 6, 11, 12);
            this.makeMiniGhastSpawner(world, rand, y, sx, sz, sbb);
        }
        final int lx = this.pickFrom(rand, 2, 12, 16);
        final int lz = 2 + rand.nextInt(15);
        this.setBlockStateRotated(world, Blocks.field_150379_bu.func_176223_P(), lx, y + 2, lz, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), rand.nextBoolean() ? BlockLever.EnumOrientation.DOWN_X : BlockLever.EnumOrientation.DOWN_Z, rotation, false), lx, y + 1, lz, rotation, sbb);
    }
    
    private void makeMiniGhastSpawner(final World world, final Random rand, final int y, final int sx, final int sz, final StructureBoundingBox sbb) {
        final TileEntityMobSpawner spawner = this.setSpawner(world, sx, y + 2, sz, sbb, TFEntityNames.MINI_GHAST);
        if (spawner != null) {
            final NBTTagCompound tags = new NBTTagCompound();
            spawner.func_189515_b(tags);
            tags.func_74777_a("SpawnRange", (short)16);
            tags.func_74777_a("MaxNearbyEntities", (short)2);
            tags.func_74777_a("SpawnCount", (short)1);
            spawner.func_145839_a(tags);
        }
    }
    
    protected void addBuilderPlatforms(final World world, final Random rand, final StructureBoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        Rotation floorside = Rotation.NONE;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top - spacing; y += spacing) {
            this.makeBuilderPlatforms(world, rand, sbb, floorside, y, y == bottom && bottom != spacing, y >= top - spacing);
            floorside = floorside.func_185830_a(Rotation.CLOCKWISE_90);
            floorside = floorside.func_185830_a(RotationUtil.ROTATIONS[rand.nextInt(3)]);
        }
        this.makeBuilderPlatform(world, rand, Rotation.CLOCKWISE_90, bottom, 5, true, sbb);
        this.makeBuilderPlatform(world, rand, Rotation.COUNTERCLOCKWISE_90, bottom, 5, true, sbb);
        for (int y = bottom - 4; y < bottom; ++y) {
            this.setBlockStateRotated(world, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.WEST), 1, y, 5, Rotation.CLOCKWISE_90, sbb);
            this.setBlockStateRotated(world, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.WEST), 1, y, 5, Rotation.COUNTERCLOCKWISE_90, sbb);
        }
        this.addTopBuilderPlatform(world, rand, bottom, top, spacing, sbb);
    }
    
    protected void makeBuilderPlatforms(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y, final boolean bottom, final boolean top) {
        final int z = this.size / 2 + rand.nextInt(5) - rand.nextInt(5);
        this.makeBuilderPlatform(world, rand, rotation, y, z, false, sbb);
        this.setBlockStateRotated(world, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.WEST), 1, y + 1, z, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.WEST), 1, y + 2, z, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.WEST), 1, y + 3, z, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.WEST), 1, y + 4, z, rotation, sbb);
        this.makeBuilderPlatform(world, rand, rotation, y + 5, z, true, sbb);
        if (y % 2 == 1) {
            final int sx = this.pickFrom(rand, 5, 9, 13);
            final int sz = (sx == 9) ? (rand.nextBoolean() ? 5 : 13) : 9;
            final IBlockState antibuilder = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.ANTIBUILDER);
            this.setBlockStateRotated(world, antibuilder, sx, y + 2, sz, rotation, sbb);
        }
        else {
            final int sx = rand.nextBoolean() ? 5 : 13;
            final int sz = rand.nextBoolean() ? 5 : 13;
            this.makeLampCluster(world, rand, sx, y, sz, rotation, sbb);
        }
    }
    
    private void addTopBuilderPlatform(final World world, final Random rand, final int bottom, final int top, final int spacing, final StructureBoundingBox sbb) {
        final Rotation rotation = RotationUtil.ROTATIONS[(this.field_74887_e.field_78895_b + top + 1) % 4];
        this.fillBlocksRotated(world, sbb, 5, top - spacing, 9, 7, top - spacing, 11, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, 6, top - spacing, 9, 6, top, 9, this.deco.accentState, rotation);
        this.fillBlocksRotated(world, sbb, 6, top - spacing + 1, 10, 6, top - 1, 10, Blocks.field_150468_ap.func_176223_P().func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.NORTH), rotation);
        this.setBlockStateRotated(world, ComponentTFDarkTowerMain.AIR, 6, top + 1, 9, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 5, top + 0, 10, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 7, top + 0, 10, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 5, top + 1, 10, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 7, top + 1, 10, rotation, sbb);
        final IBlockState inactiveBuilder = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE);
        this.setBlockStateRotated(world, inactiveBuilder, 7, top - spacing, 10, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), rand.nextBoolean() ? BlockLever.EnumOrientation.UP_Z : BlockLever.EnumOrientation.UP_X, rotation, false), 7, top - spacing + 1, 11, rotation, sbb);
    }
    
    private void makeBuilderPlatform(final World world, final Random rand, final Rotation rotation, final int y, final int z, final boolean hole, final StructureBoundingBox sbb) {
        this.setBlockStateRotated(world, this.deco.accentState, 1, y, z - 1, rotation, sbb);
        if (!hole) {
            this.setBlockStateRotated(world, this.deco.accentState, 1, y, z - 0, rotation, sbb);
        }
        this.setBlockStateRotated(world, this.deco.accentState, 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 2, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 2, y, z - 0, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, 2, y, z + 1, rotation, sbb);
        final IBlockState inactiveBuilder = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE);
        this.setBlockStateRotated(world, inactiveBuilder, 2, y, hole ? (z + 1) : (z - 1), rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), rand.nextBoolean() ? BlockLever.EnumOrientation.UP_Z : BlockLever.EnumOrientation.UP_X, rotation, false), 2, y + 1, z + 0, rotation, sbb);
    }
    
    private void makeLampCluster(final World world, final Random rand, final int sx, final int y, final int sz, final Rotation rotation, final StructureBoundingBox sbb) {
        final int radius = 4;
        for (int i = 0; i < 5; ++i) {
            int lx = sx;
            int ly = y;
            int lz = sz;
            for (int move = 0; move < 10; ++move) {
                this.setBlockStateRotated(world, Blocks.field_150379_bu.func_176223_P(), lx, ly, lz, rotation, sbb);
                int direction = rand.nextInt(8);
                if (direction > 5) {
                    direction -= 2;
                }
                final EnumFacing facing = EnumFacing.field_82609_l[direction];
                lx += facing.func_82601_c();
                ly += facing.func_96559_d();
                lz += facing.func_82599_e();
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
            final EnumFacing[] directions = new EnumFacing[10];
            for (int move2 = 0; move2 < 10; ++move2) {
                int direction2 = rand.nextInt(8);
                if (direction2 > 5) {
                    direction2 -= 2;
                }
                directions[move2] = EnumFacing.field_82609_l[direction2];
            }
            for (int move2 = 0; move2 < 10; ++move2) {
                final EnumFacing direction3 = directions[move2];
                lx += direction3.func_82601_c();
                ly += direction3.func_96559_d();
                lz += direction3.func_82599_e();
                if (lx > sx + radius || lx < sx - radius || ly > y + radius || ly < y - radius || lz > sz + radius) {
                    break;
                }
                if (lz < sz - radius) {
                    break;
                }
                if (this.getBlockStateFromPosRotated(world, lx, ly, lz, sbb, rotation).func_177230_c() != Blocks.field_150379_bu) {
                    BlockLever.EnumOrientation orientation = null;
                    switch (direction3) {
                        case NORTH: {
                            orientation = BlockLever.EnumOrientation.SOUTH;
                            break;
                        }
                        case SOUTH: {
                            orientation = BlockLever.EnumOrientation.NORTH;
                            break;
                        }
                        case EAST: {
                            orientation = BlockLever.EnumOrientation.WEST;
                            break;
                        }
                        case WEST: {
                            orientation = BlockLever.EnumOrientation.EAST;
                            break;
                        }
                        case UP: {
                            orientation = BlockLever.EnumOrientation.UP_Z;
                            break;
                        }
                        default: {
                            orientation = BlockLever.EnumOrientation.DOWN_X;
                            break;
                        }
                    }
                    this.setBlockStateRotated(world, ComponentTFDarkTowerWing.getLeverState(Blocks.field_150442_at.func_176223_P(), orientation, rotation, false), lx, ly, lz, rotation, sbb);
                    break;
                }
            }
        }
    }
}
