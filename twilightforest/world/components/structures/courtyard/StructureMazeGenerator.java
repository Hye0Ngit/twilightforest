// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import net.minecraft.core.Direction;
import net.minecraft.nbt.IntTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.enums.Diagonals;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.Tag;
import twilightforest.util.BoundingBoxUtils;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import twilightforest.world.components.structures.TFStructureComponent;

public abstract class StructureMazeGenerator extends TFStructureComponent
{
    protected int[][] maze;
    private int[][] cornerClipping;
    private int widthInCellCount;
    private int heightInCellCount;
    private final StructureManager structureManager;
    protected BoundingBox sizeConstraints;
    
    public StructureMazeGenerator(final StructureManager structureManager, final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.cornerClipping = new int[4][2];
        this.widthInCellCount = nbt.m_128451_("mazeWidth");
        this.heightInCellCount = nbt.m_128451_("mazeHeight");
        this.maze = new int[this.widthInCellCount - 1][this.heightInCellCount - 1];
        final ListTag mazeX = nbt.m_128437_("maze", 9);
        for (int x = 0; x < this.widthInCellCount - 1; ++x) {
            final Tag mazeY = mazeX.get(x);
            if (mazeY instanceof ListTag) {
                for (int y = 0; y < this.heightInCellCount - 1; ++y) {
                    this.maze[x][y] = ((ListTag)mazeY).m_128763_(y);
                }
            }
        }
        this.sizeConstraints = BoundingBoxUtils.NBTToBoundingBox(nbt.m_128469_("constraints"));
        this.structureManager = structureManager;
    }
    
    StructureMazeGenerator(final StructurePieceType type, final TFFeature feature, final Random rand, final int i, final int widthInCellCount, final int heightInCellCount, final int x, final int y, final int z, final StructureManager structureManager) {
        super(type, feature, i, x, y, z);
        this.cornerClipping = new int[4][2];
        this.widthInCellCount = widthInCellCount;
        this.heightInCellCount = heightInCellCount;
        this.structureManager = structureManager;
        generateMaze(this.maze = new int[widthInCellCount - 1][heightInCellCount - 1], this.cornerClipping, rand, this.widthInCellCount, this.heightInCellCount, 2);
        this.sizeConstraints = this.m_73547_();
    }
    
    public void m_142537_(final StructurePiece structureComponent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(structureComponent, list, random);
        final int offset = 6;
        final Rotation[] rotations = Rotation.values();
        this.processInnerWallsAndFloor(structureComponent, list, random, 6, rotations);
        this.processOuterWalls(structureComponent, list, random, 6, rotations);
    }
    
    private static void generateMaze(final int[][] maze, final int[][] cornerClippings, final Random random, final int widthInCellCount, final int heightInCellCount, final int maximumClipping) {
        final WallFacing[][] rotations = new WallFacing[maze.length][maze[0].length];
        for (int x = 0; x < widthInCellCount - 1; ++x) {
            for (int y = 0; y < heightInCellCount - 1; ++y) {
                rotations[x][y] = WallFacing.values()[random.nextInt(WallFacing.values().length)];
                final int[] array = maze[x];
                final int n = y;
                array[n] |= rotations[x][y].BYTE;
            }
        }
        final int[][] mazeLocal = maze.clone();
        final int halfWayPointX = widthInCellCount / 2 - 1;
        final int halfWayPointY = heightInCellCount / 2 - 1;
        for (int y2 = 0; y2 < heightInCellCount - 1; ++y2) {
            for (int x2 = 0; x2 < widthInCellCount - 1; ++x2) {
                if (x2 != halfWayPointX || y2 != halfWayPointY) {
                    if (rotations[x2][y2] == WallFacing.WEST && x2 > 0) {
                        if (!rotations[x2][y2].unpackAndTest(maze[x2 - 1][y2])) {
                            final int[] array2 = maze[x2 - 1];
                            final int n2 = y2;
                            array2[n2] |= rotations[x2][y2].OPPOSITE;
                        }
                        else {
                            final int[] array3 = maze[x2];
                            final int n3 = y2;
                            array3[n3] &= rotations[x2][y2].INVERTED;
                            final int[] array4 = maze[x2 - 1];
                            final int n4 = y2;
                            array4[n4] &= rotations[x2 - 1][y2].INVERTED_OPPOSITE;
                        }
                    }
                    if (rotations[x2][y2] == WallFacing.NORTH && y2 > 0) {
                        if (!rotations[x2][y2].unpackAndTest(maze[x2][y2 - 1])) {
                            final int[] array5 = maze[x2];
                            final int n5 = y2 - 1;
                            array5[n5] |= rotations[x2][y2].OPPOSITE;
                        }
                        else {
                            final int[] array6 = maze[x2];
                            final int n6 = y2;
                            array6[n6] &= rotations[x2][y2].INVERTED;
                            final int[] array7 = maze[x2];
                            final int n7 = y2 - 1;
                            array7[n7] &= rotations[x2][y2 - 1].INVERTED_OPPOSITE;
                        }
                    }
                    if (rotations[x2][y2] == WallFacing.EAST && x2 < widthInCellCount - 2) {
                        if (!rotations[x2][y2].unpackAndTest(maze[x2 + 1][y2])) {
                            final int[] array8 = maze[x2 + 1];
                            final int n8 = y2;
                            array8[n8] |= rotations[x2][y2].OPPOSITE;
                        }
                        else {
                            final int[] array9 = maze[x2];
                            final int n9 = y2;
                            array9[n9] &= rotations[x2][y2].INVERTED;
                            final int[] array10 = maze[x2 + 1];
                            final int n10 = y2;
                            array10[n10] &= rotations[x2 + 1][y2].INVERTED_OPPOSITE;
                        }
                    }
                    if (rotations[x2][y2] == WallFacing.SOUTH && y2 < heightInCellCount - 2) {
                        if (!rotations[x2][y2].unpackAndTest(maze[x2][y2 + 1])) {
                            final int[] array11 = maze[x2];
                            final int n11 = y2 + 1;
                            array11[n11] |= rotations[x2][y2].OPPOSITE;
                        }
                        else {
                            final int[] array12 = maze[x2];
                            final int n12 = y2;
                            array12[n12] &= rotations[x2][y2].INVERTED;
                            final int[] array13 = maze[x2];
                            final int n13 = y2 + 1;
                            array13[n13] &= rotations[x2][y2 + 1].INVERTED_OPPOSITE;
                        }
                    }
                }
            }
        }
        for (final WallFacing facing : WallFacing.values()) {
            final int[] array14 = maze[halfWayPointX + facing.xOffset];
            final int n14 = halfWayPointY + facing.zOffset;
            array14[n14] &= facing.INVERTED_OPPOSITE;
        }
        maze[halfWayPointX][halfWayPointY] = 16;
        for (int x3 = 1; x3 < maze.length; ++x3) {
            for (int y3 = 1; y3 < maze[x3].length; ++y3) {
                if (mazeLocal[x3][y3] == 0) {
                    if (mazeLocal[x3 - 1][y3] == 0) {
                        final int[] array15 = maze[x3];
                        final int n15 = y3;
                        array15[n15] |= WallFacing.WEST.BYTE;
                        final int[] array16 = maze[x3 - 1];
                        final int n16 = y3;
                        array16[n16] |= WallFacing.WEST.OPPOSITE;
                    }
                    if (mazeLocal[x3][y3 - 1] == 0) {
                        final int[] array17 = maze[x3];
                        final int n17 = y3;
                        array17[n17] |= WallFacing.NORTH.BYTE;
                        final int[] array18 = maze[x3];
                        final int n18 = y3 - 1;
                        array18[n18] |= WallFacing.NORTH.OPPOSITE;
                    }
                }
            }
        }
        for (final Diagonals diagonals : Diagonals.values()) {
            cornerClippings[diagonals.ordinal()][0] = random.nextInt(maximumClipping) + 1;
            cornerClippings[diagonals.ordinal()][1] = random.nextInt(maximumClipping) + 1;
            for (int y4 = 0; y4 < cornerClippings[diagonals.ordinal()][0]; ++y4) {
                for (int x4 = 0; x4 < cornerClippings[diagonals.ordinal()][1]; ++x4) {
                    final int[] array19 = maze[diagonals.operationX.convert(x4, widthInCellCount - 2)];
                    final int convert = diagonals.operationY.convert(y4, heightInCellCount - 2);
                    array19[convert] |= 0x10;
                }
            }
        }
    }
    
    private void processInnerWallsAndFloor(final StructurePiece structureComponent, final StructurePieceAccessor list, final Random random, final int offset, final Rotation[] rotations) {
        for (int x = 0; x < this.widthInCellCount - 1; ++x) {
            for (int y = 0; y < this.heightInCellCount - 1; ++y) {
                final boolean xCenter = x == this.widthInCellCount / 2 - 1;
                final boolean yCenter = y == this.heightInCellCount / 2 - 1;
                if (xCenter || yCenter || (this.maze[x][y] & 0x10) != 0x10) {
                    int rotation = 0;
                    int xBB = this.sizeConstraints.m_162395_() + x * 12 + offset;
                    final int yBB = this.sizeConstraints.m_162396_() + 1;
                    int zBB = this.sizeConstraints.m_162398_() + y * 12 + offset;
                    if (!xCenter || !yCenter) {
                        StructurePiece structure = null;
                        switch (this.maze[x][y] & 0xF) {
                            case 2: {
                                ++rotation;
                            }
                            case 1: {
                                ++rotation;
                            }
                            case 8: {
                                ++rotation;
                            }
                            case 4: {
                                final Rotation rotationCap = rotations[rotation];
                                if (random.nextBoolean()) {
                                    structure = new NagaCourtyardHedgeCapComponent(this.getFeatureType(), x * this.widthInCellCount + y, xBB, yBB, zBB, rotationCap);
                                    break;
                                }
                                structure = new NagaCourtyardHedgeCapPillarComponent(this.getFeatureType(), x * this.widthInCellCount + y, xBB, yBB, zBB, rotationCap);
                                break;
                            }
                            case 9: {
                                ++rotation;
                            }
                            case 12: {
                                ++rotation;
                            }
                            case 6: {
                                ++rotation;
                            }
                            case 3: {
                                final Rotation rotationCorner = rotations[rotation];
                                structure = new NagaCourtyardHedgeCornerComponent(this.getFeatureType(), this.maze[x][y], xBB, yBB, zBB, rotationCorner);
                                break;
                            }
                            case 13: {
                                ++rotation;
                            }
                            case 14: {
                                ++rotation;
                            }
                            case 7: {
                                ++rotation;
                            }
                            case 11: {
                                final Rotation rotationT = rotations[rotation];
                                structure = new NagaCourtyardHedgeTJunctionComponent(this.getFeatureType(), this.maze[x][y], xBB, yBB, zBB, rotationT);
                                break;
                            }
                            case 10: {
                                ++rotation;
                            }
                            case 5: {
                                final Rotation rotationLine = rotations[rotation];
                                structure = new NagaCourtyardHedgeLineComponent(this.getFeatureType(), this.maze[x][y], xBB, yBB, zBB, rotationLine);
                                break;
                            }
                            case 15: {
                                structure = new NagaCourtyardHedgeIntersectionComponent(this.getFeatureType(), this.maze[x][y], xBB, yBB, zBB, Rotation.NONE);
                                break;
                            }
                            default: {
                                if (random.nextInt(150) == 0) {
                                    structure = (StructurePiece)new CourtyardTerraceStatue(this.maze[x][y], xBB - 6, yBB - 3, zBB - 6, Rotation.NONE, this.structureManager);
                                    break;
                                }
                                if (random.nextBoolean()) {
                                    structure = (StructurePiece)new CourtyardTerraceBrazier(this.maze[x][y], xBB - 6, yBB - 3, zBB - 6, Rotation.NONE, this.structureManager);
                                    break;
                                }
                                structure = (StructurePiece)new CourtyardTerraceDuct(this.maze[x][y], xBB - 6, yBB - 3, zBB - 6, Rotation.NONE, this.structureManager);
                                break;
                            }
                        }
                        list.m_142679_(structure);
                        structure.m_142537_(structureComponent, list, random);
                    }
                    xBB = this.sizeConstraints.m_162395_() + x * 12 + offset;
                    zBB = this.sizeConstraints.m_162398_() + y * 12 + offset;
                    final boolean connectWest = WallFacing.WEST.unpackAndTest(this.maze[x][y]);
                    final boolean connectNorth = WallFacing.NORTH.unpackAndTest(this.maze[x][y]);
                    final boolean connectEast = WallFacing.EAST.unpackAndTest(this.maze[x][y]);
                    final boolean connectSouth = WallFacing.SOUTH.unpackAndTest(this.maze[x][y]);
                    if (connectWest) {
                        final NagaCourtyardHedgePadderComponent padding = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB - 1, yBB, zBB, Rotation.NONE);
                        list.m_142679_((StructurePiece)padding);
                        padding.m_142537_(structureComponent, list, random);
                        if (x > 0 && (this.maze[x - 1][y] & 0x10) != 0x10) {
                            final NagaCourtyardHedgePadderComponent padding2 = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB - 7, yBB, zBB, Rotation.NONE);
                            list.m_142679_((StructurePiece)padding2);
                            padding2.m_142537_(structureComponent, list, random);
                        }
                        final NagaCourtyardHedgeLineComponent structureLine = new NagaCourtyardHedgeLineComponent(this.getFeatureType(), this.maze[x][y], xBB - 6, yBB, zBB, Rotation.NONE);
                        list.m_142679_((StructurePiece)structureLine);
                        structureLine.m_142537_(structureComponent, list, random);
                    }
                    if (connectNorth) {
                        final NagaCourtyardHedgePadderComponent padding = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB + 4, yBB, zBB - 1, Rotation.CLOCKWISE_90);
                        list.m_142679_((StructurePiece)padding);
                        padding.m_142537_(structureComponent, list, random);
                        if (y > 0 && (this.maze[x][y - 1] & 0x10) != 0x10) {
                            final NagaCourtyardHedgePadderComponent padding2 = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB + 4, yBB, zBB - 7, Rotation.CLOCKWISE_90);
                            list.m_142679_((StructurePiece)padding2);
                            padding2.m_142537_(structureComponent, list, random);
                        }
                        final NagaCourtyardHedgeLineComponent structureLine = new NagaCourtyardHedgeLineComponent(this.getFeatureType(), this.maze[x][y], xBB, yBB, zBB - 6, Rotation.CLOCKWISE_90);
                        list.m_142679_((StructurePiece)structureLine);
                        structureLine.m_142537_(structureComponent, list, random);
                    }
                    if ((x >= this.widthInCellCount - 2 || (this.maze[x + 1][y] & 0x10) == 0x10) && connectEast) {
                        final NagaCourtyardHedgePadderComponent padding = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB + 5, yBB, zBB, Rotation.NONE);
                        list.m_142679_((StructurePiece)padding);
                        padding.m_142537_(structureComponent, list, random);
                        final NagaCourtyardHedgeLineComponent structureLine = new NagaCourtyardHedgeLineComponent(this.getFeatureType(), this.maze[x][y], xBB + 6, yBB, zBB, Rotation.NONE);
                        list.m_142679_((StructurePiece)structureLine);
                        structureLine.m_142537_(structureComponent, list, random);
                    }
                    if ((y >= this.heightInCellCount - 2 || (this.maze[x][y + 1] & 0x10) == 0x10) && connectSouth) {
                        final NagaCourtyardHedgePadderComponent padding = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB + 4, yBB, zBB + 5, Rotation.CLOCKWISE_90);
                        list.m_142679_((StructurePiece)padding);
                        padding.m_142537_(structureComponent, list, random);
                        final NagaCourtyardHedgeLineComponent structureLine = new NagaCourtyardHedgeLineComponent(this.getFeatureType(), this.maze[x][y], xBB, yBB, zBB + 6, Rotation.CLOCKWISE_90);
                        list.m_142679_((StructurePiece)structureLine);
                        structureLine.m_142537_(structureComponent, list, random);
                    }
                    final boolean hasNoTerrace = (this.maze[x][y] & 0xF) != 0x0;
                    final boolean westHasNoTerraceOrIsSafe = x == 0 || (this.maze[x - 1][y] & 0x10) == 0x10 || (this.maze[x - 1][y] & 0xF) != 0x0;
                    final boolean northHasNoTerraceOrIsSafe = y == 0 || (this.maze[x][y - 1] & 0x10) == 0x10 || (this.maze[x][y - 1] & 0xF) != 0x0;
                    final boolean eastHasNoTerraceOrIsSafe = x == this.widthInCellCount - 2 || (this.maze[x + 1][y] & 0x10) == 0x10;
                    final boolean southHasNoTerraceOrIsSafe = y == this.heightInCellCount - 2 || (this.maze[x][y + 1] & 0x10) == 0x10;
                    final boolean westNorthHasNoTerraceOrIsSafe = x == 0 || y == 0 || this.maze[x - 1][y - 1] != 0;
                    final boolean westSouthHasNoTerraceOrIsSafe = x == 0 || y >= this.heightInCellCount - 2 || this.maze[x - 1][y + 1] != 0;
                    final boolean eastNorthHasNoTerraceOrIsSafe = x >= this.widthInCellCount - 2 || y == 0 || this.maze[x + 1][y - 1] != 0;
                    final boolean eastSouthHasNoTerraceOrIsSafe = x >= this.widthInCellCount - 2 || y >= this.heightInCellCount - 2 || this.maze[x + 1][y + 1] != 0;
                    if (xCenter && yCenter) {
                        final CourtyardPathPiece path = new CourtyardPathPiece(this.maze[x][y], xBB - 1, yBB - 1, zBB - 1, this.structureManager);
                        list.m_142679_((StructurePiece)path);
                        path.m_142537_(structureComponent, list, random);
                    }
                    if (hasNoTerrace && westHasNoTerraceOrIsSafe && !connectWest) {
                        final CourtyardPathPiece path2 = new CourtyardPathPiece(this.maze[x][y], xBB - 7, yBB - 1, zBB - 1, this.structureManager);
                        list.m_142679_((StructurePiece)path2);
                        path2.m_142537_(structureComponent, list, random);
                    }
                    if (hasNoTerrace && northHasNoTerraceOrIsSafe && !connectNorth) {
                        final CourtyardPathPiece path2 = new CourtyardPathPiece(this.maze[x][y], xBB - 1, yBB - 1, zBB - 7, this.structureManager);
                        list.m_142679_((StructurePiece)path2);
                        path2.m_142537_(structureComponent, list, random);
                    }
                    if (hasNoTerrace && eastHasNoTerraceOrIsSafe) {
                        final CourtyardPathPiece path2 = new CourtyardPathPiece(this.maze[x][y], xBB + 5, yBB - 1, zBB - 1, this.structureManager);
                        list.m_142679_((StructurePiece)path2);
                        path2.m_142537_(structureComponent, list, random);
                    }
                    if (hasNoTerrace && southHasNoTerraceOrIsSafe) {
                        final CourtyardPathPiece path2 = new CourtyardPathPiece(this.maze[x][y], xBB - 1, yBB - 1, zBB + 5, this.structureManager);
                        list.m_142679_((StructurePiece)path2);
                        path2.m_142537_(structureComponent, list, random);
                    }
                    if (hasNoTerrace && westHasNoTerraceOrIsSafe && northHasNoTerraceOrIsSafe && westNorthHasNoTerraceOrIsSafe) {
                        final CourtyardPathPiece path2 = new CourtyardPathPiece(this.maze[x][y], xBB - 7, yBB - 1, zBB - 7, this.structureManager);
                        list.m_142679_((StructurePiece)path2);
                        path2.m_142537_(structureComponent, list, random);
                    }
                    if (hasNoTerrace && westHasNoTerraceOrIsSafe && southHasNoTerraceOrIsSafe && westSouthHasNoTerraceOrIsSafe) {
                        final CourtyardPathPiece path2 = new CourtyardPathPiece(this.maze[x][y], xBB - 7, yBB - 1, zBB + 5, this.structureManager);
                        list.m_142679_((StructurePiece)path2);
                        path2.m_142537_(structureComponent, list, random);
                    }
                    if (hasNoTerrace && eastHasNoTerraceOrIsSafe && northHasNoTerraceOrIsSafe && eastNorthHasNoTerraceOrIsSafe) {
                        final CourtyardPathPiece path2 = new CourtyardPathPiece(this.maze[x][y], xBB + 5, yBB - 1, zBB - 7, this.structureManager);
                        list.m_142679_((StructurePiece)path2);
                        path2.m_142537_(structureComponent, list, random);
                    }
                    if (hasNoTerrace && eastHasNoTerraceOrIsSafe && southHasNoTerraceOrIsSafe && eastSouthHasNoTerraceOrIsSafe) {
                        final CourtyardPathPiece path2 = new CourtyardPathPiece(this.maze[x][y], xBB + 5, yBB - 1, zBB + 5, this.structureManager);
                        list.m_142679_((StructurePiece)path2);
                        path2.m_142537_(structureComponent, list, random);
                    }
                }
            }
        }
    }
    
    private void processOuterWalls(final StructurePiece structureComponent, final StructurePieceAccessor list, final Random random, final int offset, final Rotation[] rotations) {
        for (final Diagonals diagonal : Diagonals.values()) {
            final int zBoundX = diagonal.isTop() ? (this.sizeConstraints.m_162398_() + this.cornerClipping[diagonal.ordinal()][0] * 12 - 3) : (this.sizeConstraints.m_162401_() - this.cornerClipping[diagonal.ordinal()][0] * 12 + 1);
            final CourtyardWallPadder paddingStartX = new CourtyardWallPadder(this.cornerClipping[diagonal.ordinal()][1] * 2 + 1, diagonal.isLeft() ? (this.sizeConstraints.m_162395_() + 2) : (this.sizeConstraints.m_162399_() - 2), this.sizeConstraints.m_162396_() + 1, zBoundX, Rotation.NONE, this.structureManager);
            list.m_142679_((StructurePiece)paddingStartX);
            paddingStartX.m_142537_(structureComponent, list, random);
            final int xPadOffset = diagonal.isLeft() ? 11 : -1;
            for (int i = 0; i < this.cornerClipping[diagonal.ordinal()][1] - 1; ++i) {
                final int xBound = diagonal.isLeft() ? (this.sizeConstraints.m_162395_() + i * 12 + 3) : (this.sizeConstraints.m_162399_() - i * 12 - 13);
                final CourtyardWall wall = new CourtyardWall(i * 2, xBound, this.sizeConstraints.m_162396_() + 1, zBoundX, Rotation.NONE, this.structureManager);
                list.m_142679_((StructurePiece)wall);
                wall.m_142537_(structureComponent, list, random);
                final CourtyardWallPadder padding = new CourtyardWallPadder(i * 2 + 1, xBound + xPadOffset, this.sizeConstraints.m_162396_() + 1, zBoundX, Rotation.NONE, this.structureManager);
                list.m_142679_((StructurePiece)padding);
                padding.m_142537_(structureComponent, list, random);
            }
            final int xBoundZ = diagonal.isLeft() ? (this.sizeConstraints.m_162395_() + this.cornerClipping[diagonal.ordinal()][1] * 12 - 1) : (this.sizeConstraints.m_162399_() - this.cornerClipping[diagonal.ordinal()][1] * 12 + 3);
            final CourtyardWallPadder paddingStartZ = new CourtyardWallPadder(this.cornerClipping[diagonal.ordinal()][1] * 2 + 1, xBoundZ, this.sizeConstraints.m_162396_() + 1, diagonal.isTop() ? (this.sizeConstraints.m_162398_() + 2) : (this.sizeConstraints.m_162401_() - 2), Rotation.CLOCKWISE_90, this.structureManager);
            list.m_142679_((StructurePiece)paddingStartZ);
            paddingStartZ.m_142537_(structureComponent, list, random);
            final int zPadOffset = diagonal.isTop() ? 11 : -1;
            for (int j = 0; j < this.cornerClipping[diagonal.ordinal()][0] - 1; ++j) {
                final int zBound = diagonal.isTop() ? (this.sizeConstraints.m_162398_() + j * 12 + 3) : (this.sizeConstraints.m_162401_() - j * 12 - 13);
                final CourtyardWall wall2 = new CourtyardWall(j * 2, xBoundZ, this.sizeConstraints.m_162396_() + 1, zBound, Rotation.CLOCKWISE_90, this.structureManager);
                list.m_142679_((StructurePiece)wall2);
                wall2.m_142537_(structureComponent, list, random);
                final CourtyardWallPadder padding2 = new CourtyardWallPadder(j * 2 + 1, xBoundZ, this.sizeConstraints.m_162396_() + 1, zBound + zPadOffset, Rotation.CLOCKWISE_90, this.structureManager);
                list.m_142679_((StructurePiece)padding2);
                padding2.m_142537_(structureComponent, list, random);
            }
            final int wallCornerInnerX = this.sizeConstraints.m_162395_() + diagonal.operationX.convert(this.cornerClipping[diagonal.ordinal()][1], this.widthInCellCount - 1) * 12;
            final int wallCornerInnerZ = this.sizeConstraints.m_162398_() + diagonal.operationY.convert(this.cornerClipping[diagonal.ordinal()][0], this.heightInCellCount - 1) * 12;
            final Rotation cornerRotation = rotations[diagonal.ordinal() % rotations.length];
            final boolean shiftX = cornerRotation == Rotation.CLOCKWISE_180 || cornerRotation == Rotation.COUNTERCLOCKWISE_90;
            final boolean shiftZ = cornerRotation == Rotation.CLOCKWISE_90 || cornerRotation == Rotation.CLOCKWISE_180;
            final CourtyardWallCornerOuter corner1 = new CourtyardWallCornerOuter(diagonal.ordinal() * 3, wallCornerInnerX + (shiftZ ? (shiftX ? 1 : 7) : (shiftX ? -3 : 3)), this.sizeConstraints.m_162396_() + 1, (diagonal.isTop() ? this.sizeConstraints.m_162398_() : (this.sizeConstraints.m_162401_() - 1)) + (shiftZ ? (shiftX ? 4 : 0) : (shiftX ? 1 : -3)), cornerRotation, this.structureManager);
            list.m_142679_((StructurePiece)corner1);
            corner1.m_142537_(structureComponent, list, random);
            final CourtyardWallCornerOuter corner2 = new CourtyardWallCornerOuter(diagonal.ordinal() * 3 + 1, (diagonal.isLeft() ? this.sizeConstraints.m_162395_() : (this.sizeConstraints.m_162399_() - 1)) + (shiftZ ? (shiftX ? 1 : 4) : (shiftX ? -3 : 0)), this.sizeConstraints.m_162396_() + 1, wallCornerInnerZ + (shiftZ ? (shiftX ? 7 : 3) : (shiftX ? 1 : -3)), cornerRotation, this.structureManager);
            list.m_142679_((StructurePiece)corner2);
            corner2.m_142537_(structureComponent, list, random);
            final CourtyardWallCornerInner innerCorner = new CourtyardWallCornerInner(diagonal.ordinal() * 3 + 3, wallCornerInnerX + (shiftZ ? (shiftX ? -1 : 13) : (shiftX ? -9 : 5)), this.sizeConstraints.m_162396_() + 1, wallCornerInnerZ + (shiftZ ? (shiftX ? 13 : 5) : (shiftX ? -1 : -9)), cornerRotation, this.structureManager);
            list.m_142679_((StructurePiece)innerCorner);
            innerCorner.m_142537_(structureComponent, list, random);
        }
        for (int k = this.cornerClipping[3][1]; k < this.widthInCellCount - 1 - this.cornerClipping[0][1]; ++k) {
            final CourtyardWall wall3 = new CourtyardWall(k, this.sizeConstraints.m_162395_() + k * 12 + offset - 3, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162398_() - 3, Rotation.NONE, this.structureManager);
            list.m_142679_((StructurePiece)wall3);
            wall3.m_142537_(structureComponent, list, random);
            final CourtyardWallPadder padding3 = new CourtyardWallPadder(k, this.sizeConstraints.m_162395_() + k * 12 + offset - 4, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162398_() - 3, Rotation.NONE, this.structureManager);
            list.m_142679_((StructurePiece)padding3);
            padding3.m_142537_(structureComponent, list, random);
        }
        final CourtyardWallPadder padding4 = new CourtyardWallPadder(this.widthInCellCount - 1 - this.cornerClipping[0][1], this.sizeConstraints.m_162395_() + (this.widthInCellCount - 1 - this.cornerClipping[0][1]) * 12 + offset - 4, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162398_() - 3, Rotation.NONE, this.structureManager);
        list.m_142679_((StructurePiece)padding4);
        padding4.m_142537_(structureComponent, list, random);
        for (int l = this.cornerClipping[2][1]; l < this.widthInCellCount - 1 - this.cornerClipping[1][1]; ++l) {
            final CourtyardWall wall4 = new CourtyardWall(l, this.sizeConstraints.m_162395_() + l * 12 + offset - 3, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162401_() + 1, Rotation.NONE, this.structureManager);
            list.m_142679_((StructurePiece)wall4);
            wall4.m_142537_(structureComponent, list, random);
            final CourtyardWallPadder padding5 = new CourtyardWallPadder(l, this.sizeConstraints.m_162395_() + l * 12 + offset - 4, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162401_() + 1, Rotation.NONE, this.structureManager);
            list.m_142679_((StructurePiece)padding5);
            padding5.m_142537_(structureComponent, list, random);
        }
        final CourtyardWallPadder padding6 = new CourtyardWallPadder(this.widthInCellCount - 1 - this.cornerClipping[1][1], this.sizeConstraints.m_162395_() + (this.widthInCellCount - 1 - this.cornerClipping[1][1]) * 12 + offset - 4, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162401_() + 1, Rotation.NONE, this.structureManager);
        list.m_142679_((StructurePiece)padding6);
        padding6.m_142537_(structureComponent, list, random);
        for (int m = this.cornerClipping[3][0]; m < this.heightInCellCount - 1 - this.cornerClipping[2][0]; ++m) {
            final CourtyardWall wall5 = new CourtyardWall(m, this.sizeConstraints.m_162395_() - 1, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162398_() + m * 12 + offset - 3, Rotation.CLOCKWISE_90, this.structureManager);
            list.m_142679_((StructurePiece)wall5);
            wall5.m_142537_(structureComponent, list, random);
            final CourtyardWallPadder padding7 = new CourtyardWallPadder(m, this.sizeConstraints.m_162395_() - 1, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162398_() + m * 12 + offset - 4, Rotation.CLOCKWISE_90, this.structureManager);
            list.m_142679_((StructurePiece)padding7);
            padding7.m_142537_(structureComponent, list, random);
        }
        final CourtyardWallPadder padding8 = new CourtyardWallPadder(this.heightInCellCount - 1 - this.cornerClipping[2][0], this.sizeConstraints.m_162395_() - 1, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162398_() + (this.heightInCellCount - 1 - this.cornerClipping[2][0]) * 12 + offset - 4, Rotation.CLOCKWISE_90, this.structureManager);
        list.m_142679_((StructurePiece)padding8);
        padding8.m_142537_(structureComponent, list, random);
        for (int i2 = this.cornerClipping[0][0]; i2 < this.heightInCellCount - 1 - this.cornerClipping[1][0]; ++i2) {
            final CourtyardWall wall6 = new CourtyardWall(i2, this.sizeConstraints.m_162399_() + 3, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162398_() + i2 * 12 + offset - 3, Rotation.CLOCKWISE_90, this.structureManager);
            list.m_142679_((StructurePiece)wall6);
            wall6.m_142537_(structureComponent, list, random);
            final CourtyardWallPadder padding9 = new CourtyardWallPadder(i2, this.sizeConstraints.m_162399_() + 3, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162398_() + i2 * 12 + offset - 4, Rotation.CLOCKWISE_90, this.structureManager);
            list.m_142679_((StructurePiece)padding9);
            padding9.m_142537_(structureComponent, list, random);
        }
        final CourtyardWallPadder padding10 = new CourtyardWallPadder(this.heightInCellCount - 1 - this.cornerClipping[1][0], this.sizeConstraints.m_162399_() + 3, this.sizeConstraints.m_162396_() + 1, this.sizeConstraints.m_162398_() + (this.heightInCellCount - 1 - this.cornerClipping[1][0]) * 12 + offset - 4, Rotation.CLOCKWISE_90, this.structureManager);
        list.m_142679_((StructurePiece)padding10);
        padding10.m_142537_(structureComponent, list, random);
    }
    
    private static String getStringFromFacings(final int directions) {
        return switch (directions & 0xF) {
            case 2 -> " \u2577 ";
            case 1 -> " \u2576\u2500";
            case 8 -> " \u2575 ";
            case 4 -> "\u2500\u2574 ";
            case 9 -> " \u2514\u2500";
            case 12 -> "\u2500\u2518 ";
            case 6 -> "\u2500\u2510 ";
            case 3 -> " \u250c\u2500";
            case 13 -> "\u2500\u2534\u2500";
            case 14 -> "\u2500\u2524 ";
            case 7 -> "\u2500\u252c\u2500";
            case 11 -> " \u251c\u2500";
            case 10 -> " \u2502 ";
            case 5 -> "\u2500\u2500\u2500";
            case 15 -> "\u2500\u253c\u2500";
            default -> " \u2022 ";
        };
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        final ListTag mazeX = new ListTag();
        for (int x = 0; x < this.widthInCellCount - 1; ++x) {
            final ListTag mazeY = new ListTag();
            for (int y = 0; y < this.heightInCellCount - 1; ++y) {
                mazeY.add((Object)IntTag.m_128679_(this.maze[x][y]));
            }
            mazeX.add((Object)mazeY);
        }
        tagCompound.m_128405_("mazeWidth", this.widthInCellCount);
        tagCompound.m_128405_("mazeHeight", this.heightInCellCount);
        tagCompound.m_128365_("maze", (Tag)mazeX);
        tagCompound.m_128365_("constraints", (Tag)BoundingBoxUtils.boundingBoxToNBT(this.sizeConstraints));
    }
    
    protected enum WallFacing
    {
        EAST(1, 4, 14, 11, Direction.EAST, 1, 0), 
        SOUTH(2, 8, 13, 7, Direction.SOUTH, 0, 1), 
        WEST(4, 1, 11, 14, Direction.WEST, -1, 0), 
        NORTH(8, 2, 7, 13, Direction.NORTH, 0, -1);
        
        private final int BYTE;
        private final int OPPOSITE;
        private final int INVERTED;
        private final int INVERTED_OPPOSITE;
        private final int xOffset;
        private final int zOffset;
        
        private WallFacing(final int bite, final int oppositeBite, final int inverted, final int invertedOpposite, final Direction enumFacing, final int xOffset, final int zOffset) {
            this.BYTE = bite;
            this.OPPOSITE = oppositeBite;
            this.INVERTED = inverted;
            this.INVERTED_OPPOSITE = invertedOpposite;
            this.xOffset = xOffset;
            this.zOffset = zOffset;
        }
        
        protected boolean unpackAndTest(final int directions) {
            return (this.BYTE & directions) == this.BYTE;
        }
    }
}
