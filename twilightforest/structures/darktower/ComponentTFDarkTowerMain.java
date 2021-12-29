// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.util.Facing;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.entity.TFCreatures;
import net.minecraft.world.gen.feature.WorldGenerator;
import twilightforest.world.TFGenSmallRainboak;
import twilightforest.world.TFGenSmallTwilightOak;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import twilightforest.structures.StructureTFDecorator;
import twilightforest.TFTreasure;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import twilightforest.structures.TFMaze;
import twilightforest.structures.EnumDarkTowerDoor;
import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.structures.StructureTFComponent;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.StructureDecoratorDarkTower;
import cpw.mods.fml.common.FMLLog;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFDarkTowerMain extends ComponentTFDarkTowerWing
{
    private boolean placedKeys;
    
    public ComponentTFDarkTowerMain(final World world, final Random rand, final int index, final int x, final int y, final int z) {
        this(world, rand, index, x + 19, y, z + 19, 2);
    }
    
    public ComponentTFDarkTowerMain(final World world, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        super(index, x, y, z, 19, 56 + rand.nextInt(32) / 5 * 5, rotation);
        this.placedKeys = false;
        if (this.field_74887_e.field_78894_e > 245) {
            final int amtToLower = (this.field_74887_e.field_78894_e - 245) / 5 * 5 + 5;
            FMLLog.info("[TwilightForest] Lowering Dark Tower max height by %d to be within world bounds", new Object[] { amtToLower });
            this.height -= amtToLower;
            final StructureBoundingBox field_74887_e = this.field_74887_e;
            field_74887_e.field_78894_e -= amtToLower;
        }
        if (this.deco == null) {
            this.deco = new StructureDecoratorDarkTower();
        }
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
        if (this.func_74877_c() > 0) {
            this.addOpening(0, 1, this.size / 2, 2);
        }
        int mainDir = -1;
        if (this.func_74877_c() < 2) {
            mainDir = rand.nextInt(4);
            for (int i = 0; i < 4; ++i) {
                if (i != mainDir) {
                    final int[] dest = this.getValidOpening(rand, i);
                    final int childHeight = this.validateChildHeight(21 + rand.nextInt(10), 11);
                    this.makeTowerWing(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], 11, childHeight, i);
                }
            }
        }
        else {
            for (int i = 0; i < 4; ++i) {
                final int[] dest = this.getValidOpening(rand, i);
                this.makeBossTrapWing(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], i);
            }
        }
        if (this.func_74877_c() > 0) {
            for (int i = 0; i < 4; ++i) {
                if (i != 2) {
                    final int[] dest = this.getValidOpening(rand, i);
                    dest[1] = 1;
                    final int childHeight = this.validateChildHeight(21 + rand.nextInt(10), 11);
                    this.makeTowerWing(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], 11, childHeight, i);
                }
            }
            this.makeABeard(parent, list, rand);
        }
        else {
            for (int i = 0; i < 4; i += 2) {
                final int[] dest = this.getValidOpening(rand, i);
                dest[1] = 1;
                final int childHeight = this.validateChildHeight(10 + rand.nextInt(5), 9);
                this.makeEntranceTower(list, rand, 5, dest[0], dest[1], dest[2], 9, childHeight, i);
            }
        }
        if (mainDir > -1) {
            final int[] dest2 = this.getValidOpening(rand, mainDir);
            this.makeNewLargeTower(list, rand, this.func_74877_c() + 1, dest2[0], dest2[1], dest2[2], mainDir);
        }
        this.makeARoof(parent, list, rand);
        if (!this.placedKeys && this.func_74877_c() < 2) {
            final ArrayList possibleKeyTowers = new ArrayList();
            int smallTowers = 0;
            for (final Object piece : list) {
                if (piece instanceof ComponentTFDarkTowerWing) {
                    final ComponentTFDarkTowerWing wing = (ComponentTFDarkTowerWing)piece;
                    if (wing.size != 9 || wing.func_74877_c() != this.func_74877_c()) {
                        continue;
                    }
                    ++smallTowers;
                    possibleKeyTowers.add(wing);
                }
            }
            for (int j = 0; j < 4; ++j) {
                if (possibleKeyTowers.size() < 1) {
                    FMLLog.warning("[TwilightForest] Dark forest tower could not find four small towers to place keys in.", new Object[0]);
                    break;
                }
                final int towerNum = rand.nextInt(possibleKeyTowers.size());
                possibleKeyTowers.get(towerNum).setKeyTower(true);
                possibleKeyTowers.remove(towerNum);
            }
            this.placedKeys = true;
        }
    }
    
    private boolean makeEntranceTower(final List list, final Random rand, final int index, final int x, final int y, final int z, final int childSize, final int childHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final ComponentTFDarkTowerBridge bridge = new ComponentTFDarkTowerEntranceBridge(index, dx[0], dx[1], dx[2], childSize, childHeight, direction);
        list.add(bridge);
        bridge.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
    
    private boolean makeNewLargeTower(final List list, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        final int wingSize = 15;
        final int wingHeight = 56;
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final ComponentTFDarkTowerMainBridge bridge = new ComponentTFDarkTowerMainBridge(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.add(bridge);
        bridge.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation, EnumDarkTowerDoor.LOCKED);
        return true;
    }
    
    private boolean makeBossTrapWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        final int wingSize = 11;
        final int wingHeight = 9;
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final ComponentTFDarkTowerBossBridge bridge = new ComponentTFDarkTowerBossBridge(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.add(bridge);
        bridge.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
    
    @Override
    public void makeARoof(final StructureComponent parent, final List list, final Random rand) {
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
                    this.func_74870_b(world, this.deco.accentID, this.deco.accentMeta, x, -1, z, sbb);
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
            this.decorateBossSpawner(world, decoRNG, sbb, 0, this.height - 6);
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
        int rotation = (this.field_74887_e.field_78895_b + bottom) % 4;
        if (bottom == 0) {
            this.makeLargeStairsUp(world, sbb, rotation, 0);
            rotation += 3;
            rotation %= 4;
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
            rotation += 3;
            rotation %= 4;
        }
    }
    
    protected void addThreeQuarterFloorsDecorateBoss(final World world, final Random decoRNG, final StructureBoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        int rotation = (this.field_74887_e.field_78895_b + bottom) % 4;
        if (bottom == 0) {
            this.makeLargeStairsUp(world, sbb, rotation, 0);
            rotation += 3;
            rotation %= 4;
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
            rotation += 3;
            rotation %= 4;
        }
    }
    
    private void decorateFloor(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y, final boolean isBottom, final boolean isTop) {
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
    
    protected void makeThreeQuarterFloor(final World world, final StructureBoundingBox sbb, final int rotation, final int y, final boolean isBottom, final boolean isTowerTopFloor) {
        final int half = this.size / 2;
        this.fillBlocksRotated(world, sbb, half + 1, y, 1, this.size - 2, y, half + 1, this.deco.blockID, this.deco.blockMeta, rotation);
        this.fillBlocksRotated(world, sbb, 1, y, half + 1, this.size - 2, y, this.size - 2, this.deco.blockID, this.deco.blockMeta, rotation);
        final int startZ = isBottom ? 1 : 3;
        this.fillBlocksRotated(world, sbb, 1, y, half, half, y, half, this.deco.accentID, this.deco.accentMeta, rotation);
        this.fillBlocksRotated(world, sbb, half, y, startZ, half, y, half, this.deco.accentID, this.deco.accentMeta, rotation);
        this.fillBlocksRotated(world, sbb, 1, y + 1, half, half, y + 1, half, this.deco.fenceID, this.deco.fenceMeta, rotation);
        this.fillBlocksRotated(world, sbb, half, y + 1, startZ, half, y + 1, half, this.deco.fenceID, this.deco.fenceMeta, rotation);
        if (isTowerTopFloor) {
            this.fillBlocksRotated(world, sbb, 1, y + 0, half - 2, 3, y + 0, half, this.deco.accentID, this.deco.accentMeta, rotation);
            this.fillBlocksRotated(world, sbb, 1, y + 1, half - 2, 3, y + 1, half, this.deco.fenceID, this.deco.fenceMeta, rotation);
            this.fillBlocksRotated(world, sbb, 1, y + 0, half - 1, 2, y + 0, half, this.deco.blockID, this.deco.blockMeta, rotation);
            this.fillBlocksRotated(world, sbb, 1, y + 1, half - 1, 2, y + 1, half, 0, 0, rotation);
        }
    }
    
    protected void makeLargeStairsUp(final World world, final StructureBoundingBox sbb, final int rotation, final int y) {
        for (int i = 0; i < 5; ++i) {
            final int z = this.size / 2 - i + 4;
            final int sy = y + i + 1;
            this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), 1, sy, z, rotation, sbb);
            this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), 2, sy, z, rotation, sbb);
            this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 1, sy, z - 1, rotation, sbb);
            this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 2, sy, z - 1, rotation, sbb);
            this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 3, sy, z - 1, rotation, sbb);
            if (i > 0 && i < 4) {
                this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 3, sy, z, rotation, sbb);
                this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 3, sy + 1, z, rotation, sbb);
                this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 3, sy + 2, z, rotation, sbb);
            }
            else if (i == 0) {
                this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), 3, sy, z, rotation, sbb);
            }
        }
    }
    
    private void decorateReappearingMaze(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y) {
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
            case 0: {
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
            case 1: {
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
            case 2: {
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
            case 3: {
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
        maze.wallBlockID = this.deco.blockID;
        maze.wallBlockMeta = this.deco.blockMeta;
        maze.headBlockID = this.deco.accentID;
        maze.headBlockMeta = this.deco.accentMeta;
        maze.pillarBlockID = this.deco.accentID;
        maze.pillarBlockMeta = this.deco.accentMeta;
        maze.doorBlockID = TFBlocks.towerDevice.field_71990_ca;
        maze.doorBlockMeta = 0;
        maze.torchRarity = 0.0f;
        maze.tall = 3;
        maze.head = 1;
        maze.oddBias = 2;
        maze.copyToStructure(world, 0, y + 1, 0, this, sbb);
        this.decorateMazeDeadEnds(world, decoRNG, maze, y, rotation, sbb);
    }
    
    protected void decorateMazeDeadEnds(final World world, final Random decoRNG, final TFMaze maze, final int y, final int rotation, final StructureBoundingBox sbb) {
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
    
    private void decorateDeadEnd(final World world, final Random decoRNG, final TFMaze maze, final int mx, final int y, final int mz, final int facing, final int rotation, final StructureBoundingBox sbb) {
        final int x = mx * 3 + 1;
        final int z = mz * 3 + 1;
        switch (facing) {
            case 0: {
                this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, x + 0, y + 1, z + 1, sbb);
                this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, x + 1, y + 1, z + 1, sbb);
                this.func_74864_a(world, Block.field_72077_au.field_71990_ca, 0, x + 0, y + 2, z + 1, sbb);
                this.placeTreasureAtCurrentPosition(world, decoRNG, x + 1, y + 2, z + 1, TFTreasure.darktower_cache, sbb);
                break;
            }
            case 1: {
                this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, x + 0, y + 1, z + 0, sbb);
                this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, x + 0, y + 1, z + 1, sbb);
                this.func_74864_a(world, Block.field_72077_au.field_71990_ca, rotation, x + 0, y + 2, z + 0, sbb);
                this.placeTreasureAtCurrentPosition(world, decoRNG, x + 0, y + 2, z + 1, TFTreasure.darktower_cache, sbb);
                break;
            }
            case 2: {
                this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, x + 0, y + 1, z + 0, sbb);
                this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, x + 1, y + 1, z + 0, sbb);
                this.func_74864_a(world, Block.field_72077_au.field_71990_ca, rotation, x + 0, y + 2, z + 0, sbb);
                this.placeTreasureAtCurrentPosition(world, decoRNG, x + 1, y + 2, z + 0, TFTreasure.darktower_cache, sbb);
                break;
            }
            case 3: {
                this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, x + 1, y + 1, z + 0, sbb);
                this.func_74864_a(world, this.deco.accentID, this.deco.accentMeta, x + 1, y + 1, z + 1, sbb);
                this.func_74864_a(world, Block.field_72077_au.field_71990_ca, rotation, x + 1, y + 2, z + 0, sbb);
                this.placeTreasureAtCurrentPosition(world, decoRNG, x + 1, y + 2, z + 1, TFTreasure.darktower_cache, sbb);
                break;
            }
        }
    }
    
    private void decorateUnbuilderMaze(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y) {
        for (int x = this.size / 2; x < this.size - 1; ++x) {
            for (int z = 3; z < this.size - 1; ++z) {
                if (x % 2 == 1 && z % 2 == 1) {
                    for (int py = 1; py < 5; ++py) {
                        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, x, y + py, z, rotation, sbb);
                    }
                }
                else if (x % 2 == 1 || z % 2 == 1) {
                    for (int py = 1; py < 5; ++py) {
                        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, x, y + py, z, rotation, sbb);
                    }
                    if (x != this.size / 2 && x != this.size - 2 && z != this.size - 2) {
                        int ay = decoRNG.nextInt(4) + 1;
                        this.placeBlockRotated(world, 0, 0, x, y + ay, z, rotation, sbb);
                        if (x > this.size - 7) {
                            ay = decoRNG.nextInt(3) + 1;
                            this.placeBlockRotated(world, 0, 0, x, y + ay, z, rotation, sbb);
                        }
                    }
                }
            }
        }
        this.placeBlockRotated(world, TFBlocks.towerDevice.field_71990_ca, 9, 15, y + 2, 7, rotation, sbb);
        this.placeBlockRotated(world, TFBlocks.towerDevice.field_71990_ca, 9, 11, y + 3, 7, rotation, sbb);
        this.placeBlockRotated(world, TFBlocks.towerDevice.field_71990_ca, 9, 15, y + 2, 13, rotation, sbb);
        this.placeBlockRotated(world, TFBlocks.towerDevice.field_71990_ca, 9, 11, y + 3, 13, rotation, sbb);
        this.placeBlockRotated(world, TFBlocks.towerDevice.field_71990_ca, 9, 5, y + 3, 13, rotation, sbb);
    }
    
    private void decorateLounge(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y) {
        this.fillBlocksRotated(world, sbb, 17, y + 1, 1, 17, y + 4, 6, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 1, 17, y + 4, 1, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 2, 16, y + 1, 5, this.deco.blockID, this.deco.blockMeta, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 2, 12, y + 1, 6, this.deco.stairID, this.getStairMeta(0 + rotation), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 6, 16, y + 1, 6, this.deco.stairID, this.getStairMeta(3 + rotation), rotation);
        this.makeDispenserPillar(world, this.deco, 13, y, 1, this.getStairMeta(3 + rotation), rotation, sbb);
        this.makeDispenserPillar(world, this.deco, 15, y, 1, this.getStairMeta(3 + rotation), rotation, sbb);
        this.makeDispenserPillar(world, this.deco, 17, y, 3, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeDispenserPillar(world, this.deco, 17, y, 5, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeStonePillar(world, this.deco, 12, y, 1, this.getStairMeta(3 + rotation), rotation, sbb);
        this.makeStonePillar(world, this.deco, 17, y, 6, this.getStairMeta(0 + rotation), rotation, sbb);
        this.placeBlockRotated(world, Block.field_72106_bF.field_71990_ca, 0, 13, y + 2, 5, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72108_bG.field_71990_ca, 3, 15, y + 2, 3, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 10, y + 1, 17, 17, y + 4, 17, this.deco.blockID, this.deco.blockMeta, rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 10, 17, y + 4, 17, this.deco.blockID, this.deco.blockMeta, rotation);
        this.fillBlocksRotated(world, sbb, 11, y + 1, 17, 12, y + 4, 17, Block.field_72093_an.field_71990_ca, 0, rotation);
        this.fillBlocksRotated(world, sbb, 14, y + 1, 17, 15, y + 4, 17, Block.field_72093_an.field_71990_ca, 0, rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 11, 17, y + 4, 12, Block.field_72093_an.field_71990_ca, 0, rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 14, 17, y + 4, 15, Block.field_72093_an.field_71990_ca, 0, rotation);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation) + 4, 13, y + 1, 14, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, 14, y + 1, 14, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 14, y + 1, 13, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation) + 4, 13, y + 1, 13, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), 11, y + 1, 13, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), 13, y + 1, 11, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72078_bL.field_71990_ca, 0, 8, y + 3, 8, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, decoRNG.nextBoolean() ? 0 : 7, 8, y + 2, 8, rotation, sbb);
        this.placeTreePlanter(world, decoRNG.nextInt(5), 6, y + 1, 12, rotation, sbb);
    }
    
    private void makeDispenserPillar(final World world, final StructureTFDecorator forgeDeco, final int x, final int y, final int z, final int stairMeta, final int rotation, final StructureBoundingBox sbb) {
        this.placeBlockRotated(world, forgeDeco.stairID, stairMeta + 4, x, y + 2, z, rotation, sbb);
        this.placeBlockRotated(world, Block.field_71958_P.field_71990_ca, stairMeta + 4, x, y + 3, z, rotation, sbb);
        this.placeBlockRotated(world, forgeDeco.stairID, stairMeta, x, y + 4, z, rotation, sbb);
    }
    
    private void decorateBossSpawner(final World world, final Random rand, final StructureBoundingBox sbb, final int rotation, final int y) {
        this.placeBlockRotated(world, TFBlocks.bossSpawner.field_71990_ca, 3, 9, y + 4, 9, rotation, sbb);
    }
    
    private void decorateExperiment(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y) {
        this.fillBlocksRotated(world, sbb, 17, y + 1, 1, 17, y + 4, 6, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 1, 17, y + 4, 1, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 2, 16, y + 1, 5, this.deco.blockID, this.deco.blockMeta, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 2, 12, y + 1, 6, this.deco.stairID, this.getStairMeta(0 + rotation), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 6, 16, y + 1, 6, this.deco.stairID, this.getStairMeta(3 + rotation), rotation);
        this.makeWoodPillar(world, this.deco, 13, y, 1, this.getStairMeta(3 + rotation), rotation, sbb);
        this.makeWoodPillar(world, this.deco, 15, y, 1, this.getStairMeta(3 + rotation), rotation, sbb);
        this.makeWoodPillar(world, this.deco, 17, y, 3, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeWoodPillar(world, this.deco, 17, y, 5, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeStonePillar(world, this.deco, 12, y, 1, this.getStairMeta(3 + rotation), rotation, sbb);
        this.makeStonePillar(world, this.deco, 17, y, 6, this.getStairMeta(0 + rotation), rotation, sbb);
        this.placeBlockRotated(world, Block.field_72060_ay.field_71990_ca, 0, 14, y + 2, 4, rotation, sbb);
        this.placeItemFrameRotated(world, 13, y + 2, 1, rotation, 0, new ItemStack(TFItems.borerEssence), sbb);
        this.placeItemFrameRotated(world, 14, y + 2, 1, rotation, 0, new ItemStack(Item.field_77767_aC), sbb);
        this.placeItemFrameRotated(world, 15, y + 2, 1, rotation, 0, new ItemStack(TFItems.borerEssence), sbb);
        this.placeItemFrameRotated(world, 13, y + 3, 1, rotation, 0, new ItemStack(Item.field_77767_aC), sbb);
        this.placeItemFrameRotated(world, 14, y + 3, 1, rotation, 0, new ItemStack(Item.field_77732_bp), sbb);
        this.placeItemFrameRotated(world, 15, y + 3, 1, rotation, 0, new ItemStack(Item.field_77767_aC), sbb);
        this.placeItemFrameRotated(world, 13, y + 4, 1, rotation, 0, new ItemStack(TFItems.borerEssence), sbb);
        this.placeItemFrameRotated(world, 14, y + 4, 1, rotation, 0, new ItemStack(Item.field_77767_aC), sbb);
        this.placeItemFrameRotated(world, 15, y + 4, 1, rotation, 0, new ItemStack(TFItems.borerEssence), sbb);
        this.placeItemFrameRotated(world, 17, y + 2, 3, rotation, 1, new ItemStack(TFBlocks.towerWood, 1, 1), sbb);
        this.placeItemFrameRotated(world, 17, y + 2, 4, rotation, 1, new ItemStack(TFBlocks.towerWood, 1, 0), sbb);
        this.placeItemFrameRotated(world, 17, y + 2, 5, rotation, 1, new ItemStack(TFBlocks.towerWood, 1, 1), sbb);
        this.placeItemFrameRotated(world, 17, y + 3, 3, rotation, 1, new ItemStack(TFBlocks.towerWood, 1, 0), sbb);
        this.placeItemFrameRotated(world, 17, y + 3, 4, rotation, 1, new ItemStack(TFItems.carminite), sbb);
        this.placeItemFrameRotated(world, 17, y + 3, 5, rotation, 1, new ItemStack(TFBlocks.towerWood, 1, 0), sbb);
        this.placeItemFrameRotated(world, 17, y + 4, 3, rotation, 1, new ItemStack(TFBlocks.towerWood, 1, 1), sbb);
        this.placeItemFrameRotated(world, 17, y + 4, 4, rotation, 1, new ItemStack(TFBlocks.towerWood, 1, 0), sbb);
        this.placeItemFrameRotated(world, 17, y + 4, 5, rotation, 1, new ItemStack(TFBlocks.towerWood, 1, 1), sbb);
        if (y < this.height - 13) {
            this.placeBlockRotated(world, Block.field_72089_ap.field_71990_ca, 0, 13, y + 1, 13, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72089_ap.field_71990_ca, 0, 15, y + 1, 13, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72089_ap.field_71990_ca, 0, 13, y + 1, 15, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72089_ap.field_71990_ca, 0, 15, y + 1, 15, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 13, y + 1, 14, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 14, y + 1, 13, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 15, y + 1, 14, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 14, y + 1, 15, rotation, sbb);
            this.placeBlockRotated(world, Block.field_94341_cq.field_71990_ca, 0, 14, y + 1, 14, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 13, y + 2, 13, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 15, y + 2, 13, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 13, y + 2, 15, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 15, y + 2, 15, rotation, sbb);
            this.placeBlockRotated(world, TFBlocks.towerDevice.field_71990_ca, 12, 14, y + 2, 14, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72089_ap.field_71990_ca, 0, 13, y + 3, 13, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72089_ap.field_71990_ca, 0, 15, y + 3, 13, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72089_ap.field_71990_ca, 0, 13, y + 3, 15, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72089_ap.field_71990_ca, 0, 15, y + 3, 15, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 13, y + 3, 14, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 14, y + 3, 13, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 15, y + 3, 14, rotation, sbb);
            this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, 14, y + 3, 15, rotation, sbb);
            this.placeBlockRotated(world, Block.field_94341_cq.field_71990_ca, 0, 14, y + 3, 14, rotation, sbb);
        }
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 14, y + 1, 17, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, this.getLeverMeta(rotation, 4), 13, y + 1, 17, rotation, sbb);
        this.placeBlockRotated(world, Block.field_71963_Z.field_71990_ca, 5 - this.getStairMeta(3 + rotation), 14, y + 2, 17, rotation, sbb);
        this.placeBlockRotated(world, Block.field_94341_cq.field_71990_ca, 0, 14, y + 2, 16, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 17, y + 1, 14, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, this.getLeverMeta(rotation, 2), 17, y + 1, 13, rotation, sbb);
        this.placeBlockRotated(world, Block.field_71963_Z.field_71990_ca, 5 - this.getStairMeta(2 + rotation), 17, y + 2, 14, rotation, sbb);
        this.placeBlockRotated(world, Block.field_94341_cq.field_71990_ca, 0, 16, y + 2, 14, rotation, sbb);
        this.placeBlockRotated(world, Block.field_94341_cq.field_71990_ca, 0, 14, y + 2, 11, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 14, y + 1, 11, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, this.getLeverMeta(rotation, 4) + 8, 13, y + 1, 11, rotation, sbb);
        this.placeBlockRotated(world, Block.field_71963_Z.field_71990_ca, 5 - this.getStairMeta(1 + rotation), 14, y + 2, 10, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 14, y + 1, 9, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, this.getLeverMeta(rotation, 4), 13, y + 1, 9, rotation, sbb);
        this.placeBlockRotated(world, Block.field_71956_V.field_71990_ca, 5 - this.getStairMeta(1 + rotation), 14, y + 2, 9, rotation, sbb);
        this.placeBlockRotated(world, Block.field_94341_cq.field_71990_ca, 0, 11, y + 2, 14, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 11, y + 1, 14, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, this.getLeverMeta(rotation, 2) + 8, 11, y + 1, 13, rotation, sbb);
        this.placeBlockRotated(world, Block.field_71963_Z.field_71990_ca, 5 - this.getStairMeta(0 + rotation), 10, y + 2, 14, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 9, y + 1, 14, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, this.getLeverMeta(rotation, 2), 9, y + 1, 13, rotation, sbb);
        this.placeBlockRotated(world, Block.field_71956_V.field_71990_ca, 5 - this.getStairMeta(0 + rotation), 9, y + 2, 14, rotation, sbb);
    }
    
    private void makeWoodPillar(final World world, final StructureTFDecorator forgeDeco, final int x, final int y, final int z, final int stairMeta, final int rotation, final StructureBoundingBox sbb) {
        this.placeBlockRotated(world, TFBlocks.log.field_71990_ca, 3, x, y + 2, z, rotation, sbb);
        this.placeBlockRotated(world, TFBlocks.log.field_71990_ca, 3, x, y + 3, z, rotation, sbb);
        this.placeBlockRotated(world, TFBlocks.log.field_71990_ca, 3, x, y + 4, z, rotation, sbb);
    }
    
    private void placeItemFrameRotated(final World world, final int x, final int y, final int z, final int rotation, final int direction, final ItemStack itemStack, final StructureBoundingBox sbb) {
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.func_74862_a(y);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.func_78890_b(dx, dy, dz)) {
            final EntityItemFrame frame = new EntityItemFrame(world, dx, dy, dz, (this.getCoordBaseMode() + direction + rotation) % 4);
            if (itemStack != null) {
                frame.func_82334_a(itemStack);
            }
            world.func_72838_d((Entity)frame);
        }
    }
    
    private void decorateAquarium(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y) {
        this.makePillarFrame(world, sbb, this.deco, rotation, 12, y, 3, 4, 4, 13, false);
        this.fillBlocksRotated(world, sbb, 13, y + 4, 4, 14, y + 4, 14, Block.field_71942_A.field_71990_ca, 0, rotation);
        this.makePillarFrame(world, sbb, this.deco, rotation, 6, y, 12, 4, 4, 4, false);
        this.fillBlocksRotated(world, sbb, 6, y + 5, 12, 9, y + 5, 15, this.deco.accentID, this.deco.accentMeta, rotation);
        this.fillBlocksRotated(world, sbb, 7, y + 4, 13, 8, y + 5, 14, Block.field_71942_A.field_71990_ca, 0, rotation);
    }
    
    private void decorateForge(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y) {
        final StructureTFDecorator forgeDeco = this.deco;
        this.fillBlocksRotated(world, sbb, 17, y + 1, 1, 17, y + 4, 6, forgeDeco.pillarID, forgeDeco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 1, 17, y + 4, 1, forgeDeco.pillarID, forgeDeco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 17, 17, y + 4, 17, forgeDeco.pillarID, forgeDeco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 17, y + 1, 12, 17, y + 4, 17, forgeDeco.pillarID, forgeDeco.pillarMeta, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 2, 16, y + 1, 5, forgeDeco.blockID, forgeDeco.blockMeta, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 2, 12, y + 1, 6, forgeDeco.stairID, this.getStairMeta(0 + rotation), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 6, 16, y + 1, 6, forgeDeco.stairID, this.getStairMeta(3 + rotation), rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 13, 16, y + 1, 16, forgeDeco.blockID, forgeDeco.blockMeta, rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 12, 12, y + 1, 16, forgeDeco.stairID, this.getStairMeta(0 + rotation), rotation);
        this.fillBlocksRotated(world, sbb, 12, y + 1, 12, 16, y + 1, 12, forgeDeco.stairID, this.getStairMeta(1 + rotation), rotation);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 13, y, 1, this.getStairMeta(3 + rotation), rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 15, y, 1, this.getStairMeta(3 + rotation), rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 17, y, 3, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 17, y, 5, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 13, y, 17, this.getStairMeta(1 + rotation), rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 15, y, 17, this.getStairMeta(1 + rotation), rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 17, y, 13, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeFurnacePillar(world, forgeDeco, decoRNG, 17, y, 15, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 12, y, 1, this.getStairMeta(3 + rotation), rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 17, y, 6, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 12, y, 17, this.getStairMeta(1 + rotation), rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 17, y, 12, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 17, y, 9, this.getStairMeta(0 + rotation), rotation, sbb);
        this.makeStonePillar(world, forgeDeco, 9, y, 17, this.getStairMeta(1 + rotation), rotation, sbb);
        this.placeBlockRotated(world, Block.field_82510_ck.field_71990_ca, decoRNG.nextInt(16), 13, y + 2, 5, rotation, sbb);
        this.placeBlockRotated(world, Block.field_82510_ck.field_71990_ca, decoRNG.nextInt(16), 13, y + 2, 13, rotation, sbb);
        this.makeFirePit(world, forgeDeco, 6, y + 1, 12, rotation, sbb);
    }
    
    private void makeFurnacePillar(final World world, final StructureTFDecorator forgeDeco, final Random rand, final int x, final int y, final int z, final int stairMeta, final int rotation, final StructureBoundingBox sbb) {
        this.placeBlockRotated(world, forgeDeco.stairID, stairMeta + 4, x, y + 2, z, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72051_aB.field_71990_ca, stairMeta + 4, x, y + 3, z, rotation, sbb);
        final int amount = rand.nextBoolean() ? (rand.nextInt(5) + 4) : 0;
        if (amount > 0) {
            final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
            final int dy = this.func_74862_a(y + 3);
            final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
            if (sbb.func_78890_b(dx, dy, dz) && world.func_72798_a(dx, dy, dz) == Block.field_72051_aB.field_71990_ca) {
                final IInventory inv = (IInventory)world.func_72796_p(dx, dy, dz);
                inv.func_70299_a(1, new ItemStack(Item.field_77705_m, amount, 1));
            }
        }
        this.placeBlockRotated(world, forgeDeco.stairID, stairMeta, x, y + 4, z, rotation, sbb);
    }
    
    private void makeStonePillar(final World world, final StructureTFDecorator forgeDeco, final int x, final int y, final int z, final int stairMeta, final int rotation, final StructureBoundingBox sbb) {
        for (int py = 1; py <= 4; ++py) {
            this.placeBlockRotated(world, forgeDeco.pillarID, forgeDeco.pillarMeta, x, y + py, z, rotation, sbb);
        }
        int sx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int sy = this.func_74862_a(y + 1);
        int sz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        switch (stairMeta) {
            case 0: {
                --sx;
                break;
            }
            case 1: {
                ++sx;
                break;
            }
            case 2: {
                --sz;
                break;
            }
            case 3: {
                ++sz;
                break;
            }
        }
        if (sbb.func_78890_b(sx, sy, sz)) {
            world.func_72832_d(sx, sy + 0, sz, forgeDeco.stairID, stairMeta, 0);
            world.func_72832_d(sx, sy + 3, sz, forgeDeco.stairID, stairMeta + 4, 0);
        }
    }
    
    private void makeFirePit(final World world, final StructureTFDecorator myDeco, final int x, final int y, final int z, final int rotation, final StructureBoundingBox sbb) {
        this.placeBlockRotated(world, myDeco.pillarID, myDeco.pillarMeta, x + 1, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, myDeco.pillarID, myDeco.pillarMeta, x + 1, y, z - 1, rotation, sbb);
        this.placeBlockRotated(world, myDeco.pillarID, myDeco.pillarMeta, x - 1, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, myDeco.pillarID, myDeco.pillarMeta, x - 1, y, z - 1, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(0 + rotation), x - 1, y, z + 0, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(2 + rotation), x + 1, y, z + 0, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(3 + rotation), x + 0, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(1 + rotation), x + 0, y, z - 1, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72012_bb.field_71990_ca, 0, x, y, z, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72067_ar.field_71990_ca, 0, x, y + 1, z, rotation, sbb);
    }
    
    private void decorateNetherwart(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y, final boolean isTop) {
        final StructureTFDecorator netherDeco = this.deco;
        this.makePillarFrame(world, sbb, netherDeco, rotation, 12, y, 9, 4, 4, 7, true);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 10, 14, y + 1, 14, Block.field_72013_bc.field_71990_ca, 0, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 2, 10, 14, y + 2, 14, Block.field_72094_bD.field_71990_ca, 0, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 4, 10, 14, y + 4, 14, Block.field_72013_bc.field_71990_ca, 0, rotation);
        this.makePillarFrame(world, sbb, netherDeco, rotation, 5, y, 12, 3, isTop ? 4 : 9, 3, true);
        this.placeBlockRotated(world, netherDeco.blockID, netherDeco.blockMeta, 6, y + 1, 13, rotation, sbb);
        this.placeBlockRotated(world, netherDeco.blockID, netherDeco.blockMeta, 6, y + (isTop ? 4 : 9), 13, rotation, sbb);
        this.placeSpawnerRotated(world, 6, y + 3, 13, rotation, "Blaze", sbb);
        this.destroyTower(world, decoRNG, 12, y, 3, 2, sbb);
    }
    
    private void decorateBotanical(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y) {
        this.makePillarFrame(world, sbb, this.deco, rotation, 12, y, 12, 4, 4, 4, true);
        this.fillBlocksRotated(world, sbb, 13, y + 1, 13, 14, y + 1, 14, this.deco.blockID, this.deco.blockMeta, rotation);
        this.fillBlocksRotated(world, sbb, 13, y + 4, 13, 14, y + 4, 14, this.deco.blockID, this.deco.blockMeta, rotation);
        this.placeRandomPlant(world, decoRNG, 13, y + 2, 13, rotation, sbb);
        this.placeRandomPlant(world, decoRNG, 13, y + 2, 14, rotation, sbb);
        this.placeRandomPlant(world, decoRNG, 14, y + 2, 13, rotation, sbb);
        this.placeRandomPlant(world, decoRNG, 14, y + 2, 14, rotation, sbb);
        for (int py = 1; py <= 4; ++py) {
            this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, 12, y + py, 4, rotation, sbb);
            this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, 15, y + py, 4, rotation, sbb);
        }
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 13, y + 1, 4, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation) + 4, 14, y + 1, 4, rotation, sbb);
        this.placeTreasureRotated(world, 13, y + 2, 4, rotation, TFTreasure.basement, sbb);
        this.placeBlockRotated(world, Block.field_72060_ay.field_71990_ca, 0, 14, y + 2, 4, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 12, y + 1, 7, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72092_bO.field_71990_ca, 9, 13, y + 1, 7, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72092_bO.field_71990_ca, 9, 14, y + 1, 7, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation) + 4, 15, y + 1, 7, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 12, y + 1, 10, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72092_bO.field_71990_ca, 9, 13, y + 1, 10, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72092_bO.field_71990_ca, 9, 14, y + 1, 10, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation) + 4, 15, y + 1, 10, rotation, sbb);
        for (int x = 12; x <= 15; ++x) {
            this.placeRandomPlant(world, decoRNG, x, y + 2, 7, rotation, sbb);
            this.placeRandomPlant(world, decoRNG, x, y + 2, 10, rotation, sbb);
        }
        this.placeTreePlanter(world, decoRNG.nextInt(5), 6, y + 1, 12, rotation, sbb);
    }
    
    private void placeTreePlanter(final World world, final int treeNum, final int x, final int y, final int z, final int rotation, final StructureBoundingBox sbb) {
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, x + 1, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, x + 1, y, z - 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, x - 1, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.pillarID, this.deco.pillarMeta, x - 1, y, z - 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), x - 1, y, z + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), x + 1, y, z + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), x + 0, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation), x + 0, y, z - 1, rotation, sbb);
        this.placeBlockRotated(world, Block.field_71979_v.field_71990_ca, 0, x, y, z, rotation, sbb);
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.func_74862_a(y + 1);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.func_78890_b(dx, dy, dz)) {
            WorldGenerator treeGen = null;
            switch (treeNum) {
                default: {
                    treeGen = (WorldGenerator)new WorldGenTrees(false);
                    break;
                }
                case 1: {
                    treeGen = (WorldGenerator)new WorldGenTrees(true, 3, 3, 3, false);
                    break;
                }
                case 2: {
                    treeGen = (WorldGenerator)new WorldGenForest(false);
                    break;
                }
                case 3: {
                    treeGen = new TFGenSmallTwilightOak(false);
                    break;
                }
                case 4: {
                    treeGen = new TFGenSmallRainboak(false);
                    break;
                }
            }
            for (int i = 0; i < 100; ++i) {
                if (treeGen.func_76484_a(world, world.field_73012_v, dx, dy, dz)) {
                    break;
                }
            }
        }
    }
    
    private void placeRandomPlant(final World world, final Random decoRNG, final int x, final int y, final int z, final int rotation, final StructureBoundingBox sbb) {
        final int potMeta = decoRNG.nextInt(12);
        this.placeBlockRotated(world, Block.field_82516_cf.field_71990_ca, potMeta, x, y, z, rotation, sbb);
    }
    
    private void makeBottomEntrance(final World world, final Random decoRNG, final StructureBoundingBox sbb, final int rotation, final int y) {
        this.makeFirePit(world, this.deco, 13, y + 1, 3, rotation, sbb);
        this.makeFirePit(world, this.deco, 3, y + 1, 13, rotation, sbb);
        this.makeFirePit(world, this.deco, 13, y + 1, 13, rotation, sbb);
        this.makePillarFrame(world, sbb, this.deco, rotation, 7, y, 7, 3, 4, 3, false);
    }
    
    protected void addTimberMaze(final World world, final Random rand, final StructureBoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        int floorside = 0;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            floorside = ++floorside % 4;
            this.makeTimberBeams(world, rand, sbb, floorside, y, y == bottom && bottom != spacing, y >= top - spacing, top);
        }
    }
    
    protected void makeTimberBeams(final World world, final Random rand, final StructureBoundingBox sbb, final int rotation, final int y, final boolean isBottom, final boolean isTop, final int top) {
        final int beamID = TFBlocks.log.field_71990_ca;
        final int beamMetaBase = 3;
        final int beamMetaNS = ((this.field_74885_f + rotation) % 2 == 0) ? 4 : 8;
        final int beamMetaEW = (beamMetaNS == 4) ? 8 : 4;
        final int beamMetaUD = 0;
        for (int z = 1; z < this.size - 1; ++z) {
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaEW, 4, y, z, rotation, sbb);
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaEW, 9, y, z, rotation, sbb);
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaEW, 14, y, z, rotation, sbb);
        }
        int z = this.pickBetweenExcluding(3, this.size - 3, rand, 4, 9, 14);
        for (int x = 5; x < 9; ++x) {
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaNS, x, y, z, rotation, sbb);
        }
        z = this.pickBetweenExcluding(3, this.size - 3, rand, 4, 9, 14);
        for (int x = 10; x < 14; ++x) {
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaNS, x, y, z, rotation, sbb);
        }
        final int x2 = 4;
        final int z2 = this.pickFrom(rand, 4, 9, 14);
        final int x3 = 9;
        final int z3 = this.pickFrom(rand, 4, 9, 14);
        final int x4 = 14;
        final int z4 = this.pickFrom(rand, 4, 9, 14);
        for (int by = 1; by < 5; ++by) {
            if (!isBottom || this.checkPost(world, x2, y - 5, z2, rotation, sbb)) {
                this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaUD, x2, y - by, z2, rotation, sbb);
                this.placeBlockRotated(world, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(2, rotation), x2 + 1, y - by, z2, rotation, sbb);
            }
            if (!isBottom || this.checkPost(world, x3, y - 5, z3, rotation, sbb)) {
                this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaUD, x3, y - by, z3, rotation, sbb);
            }
            if (!isBottom || this.checkPost(world, x4, y - 5, z4, rotation, sbb)) {
                this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaUD, x4, y - by, z4, rotation, sbb);
                this.placeBlockRotated(world, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(4, rotation), x4 - 1, y - by, z4, rotation, sbb);
            }
        }
        if (isTop) {
            final int topFloorRotation = (this.field_74887_e.field_78895_b + top + 1) % 4;
            final int ladderX = 4;
            final int ladderZ = 10;
            final int ladderMeta = 3;
            for (int by2 = 1; by2 < 5; ++by2) {
                this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaUD, ladderX, y + by2, 9, topFloorRotation, sbb);
                this.placeBlockRotated(world, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(ladderMeta, topFloorRotation), ladderX, y + by2, ladderZ, topFloorRotation, sbb);
            }
            this.placeBlockRotated(world, 0, 0, ladderX, y + 6, 9, topFloorRotation, sbb);
            this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, ladderX + 1, y + 5, ladderZ, topFloorRotation, sbb);
            this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, ladderX - 1, y + 5, ladderZ, topFloorRotation, sbb);
            this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, ladderX + 1, y + 6, ladderZ, topFloorRotation, sbb);
            this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, ladderX - 1, y + 6, ladderZ, topFloorRotation, sbb);
        }
        if (!isBottom && !isTop) {
            final int sx = this.pickFrom(rand, 6, 7, 11);
            final int sz = this.pickFrom(rand, 6, 11, 12);
            this.makeMiniGhastSpawner(world, rand, y, sx, sz, sbb);
        }
        final int lx = this.pickFrom(rand, 2, 12, 16);
        final int lz = 2 + rand.nextInt(15);
        this.placeBlockRotated(world, Block.field_72078_bL.field_71990_ca, 0, lx, y + 2, lz, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, rand.nextBoolean() ? 0 : 7, lx, y + 1, lz, rotation, sbb);
    }
    
    private void makeMiniGhastSpawner(final World world, final Random rand, final int y, final int sx, final int sz, final StructureBoundingBox sbb) {
        final TileEntityMobSpawner spawner = this.placeSpawnerAtCurrentPosition(world, rand, sx, y + 2, sz, TFCreatures.getSpawnerNameFor("Mini Ghast"), sbb);
        if (spawner != null) {
            final NBTTagCompound tags = new NBTTagCompound();
            spawner.func_70310_b(tags);
            tags.func_74777_a("SpawnRange", (short)16);
            tags.func_74777_a("MaxNearbyEntities", (short)world.field_73013_u);
            tags.func_74777_a("SpawnCount", (short)1);
            spawner.func_70307_a(tags);
        }
    }
    
    protected void addBuilderPlatforms(final World world, final Random rand, final StructureBoundingBox sbb, int bottom, final int top) {
        final int spacing = 5;
        int floorside = 0;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top - spacing; y += spacing) {
            this.makeBuilderPlatforms(world, rand, sbb, floorside, y, y == bottom && bottom != spacing, y >= top - spacing);
            floorside += 1 + rand.nextInt(3);
            floorside %= 4;
        }
        this.makeBuilderPlatform(world, rand, 1, bottom, 5, true, sbb);
        this.makeBuilderPlatform(world, rand, 3, bottom, 5, true, sbb);
        for (int y = bottom - 4; y < bottom; ++y) {
            this.placeBlockRotated(world, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(2, 1), 1, y, 5, 1, sbb);
            this.placeBlockRotated(world, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(2, 3), 1, y, 5, 3, sbb);
        }
        this.addTopBuilderPlatform(world, rand, bottom, top, spacing, sbb);
    }
    
    protected void makeBuilderPlatforms(final World world, final Random rand, final StructureBoundingBox sbb, final int rotation, final int y, final boolean bottom, final boolean top) {
        final int z = this.size / 2 + rand.nextInt(5) - rand.nextInt(5);
        this.makeBuilderPlatform(world, rand, rotation, y, z, false, sbb);
        this.placeBlockRotated(world, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(2, rotation), 1, y + 1, z, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(2, rotation), 1, y + 2, z, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(2, rotation), 1, y + 3, z, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(2, rotation), 1, y + 4, z, rotation, sbb);
        this.makeBuilderPlatform(world, rand, rotation, y + 5, z, true, sbb);
        if (y % 2 == 1) {
            final int sx = this.pickFrom(rand, 5, 9, 13);
            final int sz = (sx == 9) ? (rand.nextBoolean() ? 5 : 13) : 9;
            this.placeBlockRotated(world, TFBlocks.towerDevice.field_71990_ca, 9, sx, y + 2, sz, rotation, sbb);
        }
        else {
            final int sx = rand.nextBoolean() ? 5 : 13;
            final int sz = rand.nextBoolean() ? 5 : 13;
            this.makeLampCluster(world, rand, sx, y, sz, rotation, sbb);
        }
    }
    
    private void addTopBuilderPlatform(final World world, final Random rand, final int bottom, final int top, final int spacing, final StructureBoundingBox sbb) {
        final int rotation = (this.field_74887_e.field_78895_b + top + 1) % 4;
        this.fillBlocksRotated(world, sbb, 5, top - spacing, 9, 7, top - spacing, 11, this.deco.accentID, this.deco.accentMeta, rotation);
        this.fillBlocksRotated(world, sbb, 6, top - spacing, 9, 6, top, 9, this.deco.accentID, this.deco.accentMeta, rotation);
        this.fillBlocksRotated(world, sbb, 6, top - spacing + 1, 10, 6, top - 1, 10, Block.field_72055_aF.field_71990_ca, this.getLadderMeta(3, rotation), rotation);
        this.placeBlockRotated(world, 0, 0, 6, top + 1, 9, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 5, top + 0, 10, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 7, top + 0, 10, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 5, top + 1, 10, rotation, sbb);
        this.placeBlockRotated(world, this.deco.fenceID, this.deco.fenceMeta, 7, top + 1, 10, rotation, sbb);
        this.placeBlockRotated(world, TFBlocks.towerDevice.field_71990_ca, 6, 7, top - spacing, 10, rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, rand.nextBoolean() ? 5 : 6, 7, top - spacing + 1, 11, rotation, sbb);
    }
    
    private void makeBuilderPlatform(final World world, final Random rand, final int rotation, final int y, final int z, final boolean hole, final StructureBoundingBox sbb) {
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 1, y, z - 1, rotation, sbb);
        if (!hole) {
            this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 1, y, z - 0, rotation, sbb);
        }
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 1, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 2, y, z - 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 2, y, z - 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, 2, y, z + 1, rotation, sbb);
        this.placeBlockRotated(world, TFBlocks.towerDevice.field_71990_ca, 6, 2, y, hole ? (z + 1) : (z - 1), rotation, sbb);
        this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, rand.nextBoolean() ? 5 : 6, 2, y + 1, z + 0, rotation, sbb);
    }
    
    private void makeLampCluster(final World world, final Random rand, final int sx, final int y, final int sz, final int rotation, final StructureBoundingBox sbb) {
        final int radius = 4;
        for (int i = 0; i < 5; ++i) {
            int lx = sx;
            int ly = y;
            int lz = sz;
            for (int move = 0; move < 10; ++move) {
                this.placeBlockRotated(world, Block.field_72078_bL.field_71990_ca, 0, lx, ly, lz, rotation, sbb);
                int direction = rand.nextInt(8);
                if (direction > 5) {
                    direction -= 2;
                }
                lx += Facing.field_71586_b[direction];
                ly += Facing.field_71587_c[direction];
                lz += Facing.field_71585_d[direction];
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
            final int[] directions = new int[10];
            for (int move2 = 0; move2 < 10; ++move2) {
                directions[move2] = rand.nextInt(8);
                if (directions[move2] > 5) {
                    final int[] array = directions;
                    final int n = move2;
                    array[n] -= 2;
                }
            }
            for (int move2 = 0; move2 < 10; ++move2) {
                final int direction2 = directions[move2];
                lx += Facing.field_71586_b[direction2];
                ly += Facing.field_71587_c[direction2];
                lz += Facing.field_71585_d[direction2];
                if (lx > sx + radius || lx < sx - radius || ly > y + radius || ly < y - radius || lz > sz + radius) {
                    break;
                }
                if (lz < sz - radius) {
                    break;
                }
                if (this.getBlockIDRotated(world, lx, ly, lz, rotation, sbb) != Block.field_72078_bL.field_71990_ca) {
                    this.placeBlockRotated(world, Block.field_72043_aJ.field_71990_ca, this.getLeverMeta(rotation, direction2), lx, ly, lz, rotation, sbb);
                    break;
                }
            }
        }
    }
}
