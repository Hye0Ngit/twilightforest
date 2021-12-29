// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.courtyard;

import net.minecraft.util.Direction;
import net.minecraft.nbt.IntNBT;
import twilightforest.enums.Diagonals;
import net.minecraft.util.Rotation;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import twilightforest.structures.TFStructureComponent;

public abstract class StructureMazeGenerator extends TFStructureComponent
{
    protected int[][] maze;
    private int[][] cornerClipping;
    private int widthInCellCount;
    private int heightInCellCount;
    
    public StructureMazeGenerator(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.cornerClipping = new int[4][2];
        this.widthInCellCount = nbt.func_74762_e("mazeWidth");
        this.heightInCellCount = nbt.func_74762_e("mazeHeight");
        this.maze = new int[this.widthInCellCount - 1][this.heightInCellCount - 1];
        final ListNBT mazeX = nbt.func_150295_c("maze", 9);
        for (int x = 0; x < this.widthInCellCount - 1; ++x) {
            final INBT mazeY = mazeX.get(x);
            if (mazeY instanceof ListNBT) {
                for (int y = 0; y < this.heightInCellCount - 1; ++y) {
                    this.maze[x][y] = ((ListNBT)mazeY).func_186858_c(y);
                }
            }
        }
    }
    
    StructureMazeGenerator(final IStructurePieceType type, final TFFeature feature, final Random rand, final int i, final int widthInCellCount, final int heightInCellCount) {
        super(type, feature, i);
        this.cornerClipping = new int[4][2];
        this.widthInCellCount = widthInCellCount;
        this.heightInCellCount = heightInCellCount;
        generateMaze(this.maze = new int[widthInCellCount - 1][heightInCellCount - 1], this.cornerClipping, rand, this.widthInCellCount, this.heightInCellCount, 2);
    }
    
    public void func_74861_a(final StructurePiece structureComponent, final List<StructurePiece> list, final Random random) {
        super.func_74861_a(structureComponent, (List)list, random);
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
    
    private void processInnerWallsAndFloor(final StructurePiece structureComponent, final List<StructurePiece> list, final Random random, final int offset, final Rotation[] rotations) {
        for (int x = 0; x < this.widthInCellCount - 1; ++x) {
            for (int y = 0; y < this.heightInCellCount - 1; ++y) {
                final boolean xCenter = x == this.widthInCellCount / 2 - 1;
                final boolean yCenter = y == this.heightInCellCount / 2 - 1;
                if (xCenter || yCenter || (this.maze[x][y] & 0x10) != 0x10) {
                    int rotation = 0;
                    int xBB = this.field_74887_e.field_78897_a + x * 12 + offset;
                    final int yBB = this.field_74887_e.field_78895_b + 1;
                    int zBB = this.field_74887_e.field_78896_c + y * 12 + offset;
                    if (!xCenter || !yCenter) {
                        TFStructureComponent structure = null;
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
                                    structure = new NagaCourtyardTerraceStatueComponent(this.getFeatureType(), this.maze[x][y], xBB - 6, yBB - 3, zBB - 6, rotations[random.nextInt(rotations.length)]);
                                    break;
                                }
                                if (random.nextBoolean()) {
                                    structure = new NagaCourtyardTerraceBrazierComponent(this.getFeatureType(), this.maze[x][y], xBB - 6, yBB - 3, zBB - 6, Rotation.NONE);
                                    break;
                                }
                                structure = new NagaCourtyardTerraceDuctComponent(this.getFeatureType(), this.maze[x][y], xBB - 6, yBB - 3, zBB - 6, rotations[random.nextInt(rotations.length)]);
                                break;
                            }
                        }
                        list.add(structure);
                        structure.func_74861_a(structureComponent, (List)list, random);
                    }
                    xBB = this.field_74887_e.field_78897_a + x * 12 + offset;
                    zBB = this.field_74887_e.field_78896_c + y * 12 + offset;
                    final boolean connectWest = WallFacing.WEST.unpackAndTest(this.maze[x][y]);
                    final boolean connectNorth = WallFacing.NORTH.unpackAndTest(this.maze[x][y]);
                    final boolean connectEast = WallFacing.EAST.unpackAndTest(this.maze[x][y]);
                    final boolean connectSouth = WallFacing.SOUTH.unpackAndTest(this.maze[x][y]);
                    if (connectWest) {
                        final NagaCourtyardHedgePadderComponent padding = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB - 1, yBB, zBB, Rotation.NONE);
                        list.add(padding);
                        padding.func_74861_a(structureComponent, (List)list, random);
                        if (x > 0 && (this.maze[x - 1][y] & 0x10) != 0x10) {
                            final NagaCourtyardHedgePadderComponent padding2 = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB - 7, yBB, zBB, Rotation.NONE);
                            list.add(padding2);
                            padding2.func_74861_a(structureComponent, (List)list, random);
                        }
                        final NagaCourtyardHedgeLineComponent structureLine = new NagaCourtyardHedgeLineComponent(this.getFeatureType(), this.maze[x][y], xBB - 6, yBB, zBB, Rotation.NONE);
                        list.add(structureLine);
                        structureLine.func_74861_a(structureComponent, (List)list, random);
                    }
                    if (connectNorth) {
                        final NagaCourtyardHedgePadderComponent padding = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB + 4, yBB, zBB - 1, Rotation.CLOCKWISE_90);
                        list.add(padding);
                        padding.func_74861_a(structureComponent, (List)list, random);
                        if (y > 0 && (this.maze[x][y - 1] & 0x10) != 0x10) {
                            final NagaCourtyardHedgePadderComponent padding2 = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB + 4, yBB, zBB - 7, Rotation.CLOCKWISE_90);
                            list.add(padding2);
                            padding2.func_74861_a(structureComponent, (List)list, random);
                        }
                        final NagaCourtyardHedgeLineComponent structureLine = new NagaCourtyardHedgeLineComponent(this.getFeatureType(), this.maze[x][y], xBB, yBB, zBB - 6, Rotation.CLOCKWISE_90);
                        list.add(structureLine);
                        structureLine.func_74861_a(structureComponent, (List)list, random);
                    }
                    if ((x >= this.widthInCellCount - 2 || (this.maze[x + 1][y] & 0x10) == 0x10) && connectEast) {
                        final NagaCourtyardHedgePadderComponent padding = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB + 5, yBB, zBB, Rotation.NONE);
                        list.add(padding);
                        padding.func_74861_a(structureComponent, (List)list, random);
                        final NagaCourtyardHedgeLineComponent structureLine = new NagaCourtyardHedgeLineComponent(this.getFeatureType(), this.maze[x][y], xBB + 6, yBB, zBB, Rotation.NONE);
                        list.add(structureLine);
                        structureLine.func_74861_a(structureComponent, (List)list, random);
                    }
                    if ((y >= this.heightInCellCount - 2 || (this.maze[x][y + 1] & 0x10) == 0x10) && connectSouth) {
                        final NagaCourtyardHedgePadderComponent padding = new NagaCourtyardHedgePadderComponent(this.getFeatureType(), this.maze[x][y], xBB + 4, yBB, zBB + 5, Rotation.CLOCKWISE_90);
                        list.add(padding);
                        padding.func_74861_a(structureComponent, (List)list, random);
                        final NagaCourtyardHedgeLineComponent structureLine = new NagaCourtyardHedgeLineComponent(this.getFeatureType(), this.maze[x][y], xBB, yBB, zBB + 6, Rotation.CLOCKWISE_90);
                        list.add(structureLine);
                        structureLine.func_74861_a(structureComponent, (List)list, random);
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
                        final NagaCourtyardPathComponent path = new NagaCourtyardPathComponent(this.getFeatureType(), this.maze[x][y], xBB - 1, yBB - 1, zBB - 1);
                        list.add(path);
                        path.func_74861_a(structureComponent, (List)list, random);
                    }
                    if (hasNoTerrace && westHasNoTerraceOrIsSafe && !connectWest) {
                        final NagaCourtyardPathComponent path2 = new NagaCourtyardPathComponent(this.getFeatureType(), this.maze[x][y], xBB - 7, yBB - 1, zBB - 1);
                        list.add(path2);
                        path2.func_74861_a(structureComponent, (List)list, random);
                    }
                    if (hasNoTerrace && northHasNoTerraceOrIsSafe && !connectNorth) {
                        final NagaCourtyardPathComponent path2 = new NagaCourtyardPathComponent(this.getFeatureType(), this.maze[x][y], xBB - 1, yBB - 1, zBB - 7);
                        list.add(path2);
                        path2.func_74861_a(structureComponent, (List)list, random);
                    }
                    if (hasNoTerrace && eastHasNoTerraceOrIsSafe) {
                        final NagaCourtyardPathComponent path2 = new NagaCourtyardPathComponent(this.getFeatureType(), this.maze[x][y], xBB + 5, yBB - 1, zBB - 1);
                        list.add(path2);
                        path2.func_74861_a(structureComponent, (List)list, random);
                    }
                    if (hasNoTerrace && southHasNoTerraceOrIsSafe) {
                        final NagaCourtyardPathComponent path2 = new NagaCourtyardPathComponent(this.getFeatureType(), this.maze[x][y], xBB - 1, yBB - 1, zBB + 5);
                        list.add(path2);
                        path2.func_74861_a(structureComponent, (List)list, random);
                    }
                    if (hasNoTerrace && westHasNoTerraceOrIsSafe && northHasNoTerraceOrIsSafe && westNorthHasNoTerraceOrIsSafe) {
                        final NagaCourtyardPathComponent path2 = new NagaCourtyardPathComponent(this.getFeatureType(), this.maze[x][y], xBB - 7, yBB - 1, zBB - 7);
                        list.add(path2);
                        path2.func_74861_a(structureComponent, (List)list, random);
                    }
                    if (hasNoTerrace && westHasNoTerraceOrIsSafe && southHasNoTerraceOrIsSafe && westSouthHasNoTerraceOrIsSafe) {
                        final NagaCourtyardPathComponent path2 = new NagaCourtyardPathComponent(this.getFeatureType(), this.maze[x][y], xBB - 7, yBB - 1, zBB + 5);
                        list.add(path2);
                        path2.func_74861_a(structureComponent, (List)list, random);
                    }
                    if (hasNoTerrace && eastHasNoTerraceOrIsSafe && northHasNoTerraceOrIsSafe && eastNorthHasNoTerraceOrIsSafe) {
                        final NagaCourtyardPathComponent path2 = new NagaCourtyardPathComponent(this.getFeatureType(), this.maze[x][y], xBB + 5, yBB - 1, zBB - 7);
                        list.add(path2);
                        path2.func_74861_a(structureComponent, (List)list, random);
                    }
                    if (hasNoTerrace && eastHasNoTerraceOrIsSafe && southHasNoTerraceOrIsSafe && eastSouthHasNoTerraceOrIsSafe) {
                        final NagaCourtyardPathComponent path2 = new NagaCourtyardPathComponent(this.getFeatureType(), this.maze[x][y], xBB + 5, yBB - 1, zBB + 5);
                        list.add(path2);
                        path2.func_74861_a(structureComponent, (List)list, random);
                    }
                }
            }
        }
    }
    
    private void processOuterWalls(final StructurePiece structureComponent, final List<StructurePiece> list, final Random random, final int offset, final Rotation[] rotations) {
        for (final Diagonals diagonal : Diagonals.values()) {
            final int zBoundX = diagonal.isTop() ? (this.field_74887_e.field_78896_c + this.cornerClipping[diagonal.ordinal()][0] * 12 - 3) : (this.field_74887_e.field_78892_f - this.cornerClipping[diagonal.ordinal()][0] * 12 + 1);
            final NagaCourtyardWallPadderComponent paddingStartX = new NagaCourtyardWallPadderComponent(this.getFeatureType(), this.cornerClipping[diagonal.ordinal()][1] * 2 + 1, diagonal.isLeft() ? (this.field_74887_e.field_78897_a + 2) : (this.field_74887_e.field_78893_d - 2), this.field_74887_e.field_78895_b, zBoundX, Rotation.NONE);
            list.add(paddingStartX);
            paddingStartX.func_74861_a(structureComponent, (List)list, random);
            final int xPadOffset = diagonal.isLeft() ? 11 : -1;
            for (int i = 0; i < this.cornerClipping[diagonal.ordinal()][1] - 1; ++i) {
                final int xBound = diagonal.isLeft() ? (this.field_74887_e.field_78897_a + i * 12 + 3) : (this.field_74887_e.field_78893_d - i * 12 - 13);
                final NagaCourtyardWallComponent wall = new NagaCourtyardWallComponent(this.getFeatureType(), i * 2, xBound, this.field_74887_e.field_78895_b, zBoundX, Rotation.NONE);
                list.add(wall);
                wall.func_74861_a(structureComponent, (List)list, random);
                final NagaCourtyardWallPadderComponent padding = new NagaCourtyardWallPadderComponent(this.getFeatureType(), i * 2 + 1, xBound + xPadOffset, this.field_74887_e.field_78895_b, zBoundX, Rotation.NONE);
                list.add(padding);
                padding.func_74861_a(structureComponent, (List)list, random);
            }
            final int xBoundZ = diagonal.isLeft() ? (this.field_74887_e.field_78897_a + this.cornerClipping[diagonal.ordinal()][1] * 12 - 1) : (this.field_74887_e.field_78893_d - this.cornerClipping[diagonal.ordinal()][1] * 12 + 3);
            final NagaCourtyardWallPadderComponent paddingStartZ = new NagaCourtyardWallPadderComponent(this.getFeatureType(), this.cornerClipping[diagonal.ordinal()][1] * 2 + 1, xBoundZ, this.field_74887_e.field_78895_b, diagonal.isTop() ? (this.field_74887_e.field_78896_c + 2) : (this.field_74887_e.field_78892_f - 2), Rotation.CLOCKWISE_90);
            list.add(paddingStartZ);
            paddingStartZ.func_74861_a(structureComponent, (List)list, random);
            final int zPadOffset = diagonal.isTop() ? 11 : -1;
            for (int j = 0; j < this.cornerClipping[diagonal.ordinal()][0] - 1; ++j) {
                final int zBound = diagonal.isTop() ? (this.field_74887_e.field_78896_c + j * 12 + 3) : (this.field_74887_e.field_78892_f - j * 12 - 13);
                final NagaCourtyardWallComponent wall2 = new NagaCourtyardWallComponent(this.getFeatureType(), j * 2, xBoundZ - 10, this.field_74887_e.field_78895_b, zBound, Rotation.CLOCKWISE_90);
                list.add(wall2);
                wall2.func_74861_a(structureComponent, (List)list, random);
                final NagaCourtyardWallPadderComponent padding2 = new NagaCourtyardWallPadderComponent(this.getFeatureType(), j * 2 + 1, xBoundZ, this.field_74887_e.field_78895_b, zBound + zPadOffset, Rotation.CLOCKWISE_90);
                list.add(padding2);
                padding2.func_74861_a(structureComponent, (List)list, random);
            }
            final int wallCornerInnerX = this.field_74887_e.field_78897_a + diagonal.operationX.convert(this.cornerClipping[diagonal.ordinal()][1], this.widthInCellCount - 1) * 12 + (diagonal.isLeft() ? -3 : 3);
            final int wallCornerInnerZ = this.field_74887_e.field_78896_c + diagonal.operationY.convert(this.cornerClipping[diagonal.ordinal()][0], this.heightInCellCount - 1) * 12 + (diagonal.isTop() ? -3 : 3);
            final NagaCourtyardWallCornerComponent corner1 = new NagaCourtyardWallCornerComponent(this.getFeatureType(), diagonal.ordinal() * 3, wallCornerInnerX, this.field_74887_e.field_78895_b, diagonal.isTop() ? (this.field_74887_e.field_78896_c - 3) : (this.field_74887_e.field_78892_f - 1), rotations[diagonal.ordinal() % rotations.length]);
            list.add(corner1);
            corner1.func_74861_a(structureComponent, (List)list, random);
            final NagaCourtyardWallCornerComponent corner2 = new NagaCourtyardWallCornerComponent(this.getFeatureType(), diagonal.ordinal() * 3 + 1, diagonal.isLeft() ? (this.field_74887_e.field_78897_a - 3) : (this.field_74887_e.field_78893_d - 1), this.field_74887_e.field_78895_b, wallCornerInnerZ, rotations[diagonal.ordinal() % rotations.length]);
            list.add(corner2);
            corner2.func_74861_a(structureComponent, (List)list, random);
            final NagaCourtyardWallCornerAltComponent innerCorner = new NagaCourtyardWallCornerAltComponent(this.getFeatureType(), diagonal.ordinal() * 3 + 3, wallCornerInnerX + (diagonal.isLeft() ? -6 : 2), this.field_74887_e.field_78895_b, wallCornerInnerZ + (diagonal.isTop() ? -6 : 2), rotations[diagonal.ordinal() % rotations.length]);
            list.add(innerCorner);
            innerCorner.func_74861_a(structureComponent, (List)list, random);
        }
        for (int k = this.cornerClipping[3][1]; k < this.widthInCellCount - 1 - this.cornerClipping[0][1]; ++k) {
            final NagaCourtyardWallComponent wall3 = new NagaCourtyardWallComponent(this.getFeatureType(), k, this.field_74887_e.field_78897_a + k * 12 + offset - 3, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 3, Rotation.NONE);
            list.add(wall3);
            wall3.func_74861_a(structureComponent, (List)list, random);
            final NagaCourtyardWallPadderComponent padding3 = new NagaCourtyardWallPadderComponent(this.getFeatureType(), k, this.field_74887_e.field_78897_a + k * 12 + offset - 4, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 3, Rotation.NONE);
            list.add(padding3);
            padding3.func_74861_a(structureComponent, (List)list, random);
        }
        final NagaCourtyardWallPadderComponent padding4 = new NagaCourtyardWallPadderComponent(this.getFeatureType(), this.widthInCellCount - 1 - this.cornerClipping[0][1], this.field_74887_e.field_78897_a + (this.widthInCellCount - 1 - this.cornerClipping[0][1]) * 12 + offset - 4, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 3, Rotation.NONE);
        list.add(padding4);
        padding4.func_74861_a(structureComponent, (List)list, random);
        for (int l = this.cornerClipping[2][1]; l < this.widthInCellCount - 1 - this.cornerClipping[1][1]; ++l) {
            final NagaCourtyardWallComponent wall4 = new NagaCourtyardWallComponent(this.getFeatureType(), l, this.field_74887_e.field_78897_a + l * 12 + offset - 3, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, Rotation.NONE);
            list.add(wall4);
            wall4.func_74861_a(structureComponent, (List)list, random);
            final NagaCourtyardWallPadderComponent padding5 = new NagaCourtyardWallPadderComponent(this.getFeatureType(), l, this.field_74887_e.field_78897_a + l * 12 + offset - 4, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, Rotation.NONE);
            list.add(padding5);
            padding5.func_74861_a(structureComponent, (List)list, random);
        }
        final NagaCourtyardWallPadderComponent padding6 = new NagaCourtyardWallPadderComponent(this.getFeatureType(), this.widthInCellCount - 1 - this.cornerClipping[1][1], this.field_74887_e.field_78897_a + (this.widthInCellCount - 1 - this.cornerClipping[1][1]) * 12 + offset - 4, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, Rotation.NONE);
        list.add(padding6);
        padding6.func_74861_a(structureComponent, (List)list, random);
        for (int m = this.cornerClipping[3][0]; m < this.heightInCellCount - 1 - this.cornerClipping[2][0]; ++m) {
            final NagaCourtyardWallComponent wall5 = new NagaCourtyardWallComponent(this.getFeatureType(), m, this.field_74887_e.field_78897_a - 11, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + m * 12 + offset - 3, Rotation.CLOCKWISE_90);
            list.add(wall5);
            wall5.func_74861_a(structureComponent, (List)list, random);
            final NagaCourtyardWallPadderComponent padding7 = new NagaCourtyardWallPadderComponent(this.getFeatureType(), m, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + m * 12 + offset - 4, Rotation.CLOCKWISE_90);
            list.add(padding7);
            padding7.func_74861_a(structureComponent, (List)list, random);
        }
        final NagaCourtyardWallPadderComponent padding8 = new NagaCourtyardWallPadderComponent(this.getFeatureType(), this.heightInCellCount - 1 - this.cornerClipping[2][0], this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + (this.heightInCellCount - 1 - this.cornerClipping[2][0]) * 12 + offset - 4, Rotation.CLOCKWISE_90);
        list.add(padding8);
        padding8.func_74861_a(structureComponent, (List)list, random);
        for (int i2 = this.cornerClipping[0][0]; i2 < this.heightInCellCount - 1 - this.cornerClipping[1][0]; ++i2) {
            final NagaCourtyardWallComponent wall6 = new NagaCourtyardWallComponent(this.getFeatureType(), i2, this.field_74887_e.field_78893_d - 7, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + i2 * 12 + offset - 3, Rotation.CLOCKWISE_90);
            list.add(wall6);
            wall6.func_74861_a(structureComponent, (List)list, random);
            final NagaCourtyardWallPadderComponent padding9 = new NagaCourtyardWallPadderComponent(this.getFeatureType(), i2, this.field_74887_e.field_78893_d + 3, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + i2 * 12 + offset - 4, Rotation.CLOCKWISE_90);
            list.add(padding9);
            padding9.func_74861_a(structureComponent, (List)list, random);
        }
        final NagaCourtyardWallPadderComponent padding10 = new NagaCourtyardWallPadderComponent(this.getFeatureType(), this.heightInCellCount - 1 - this.cornerClipping[1][0], this.field_74887_e.field_78893_d + 3, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + (this.heightInCellCount - 1 - this.cornerClipping[1][0]) * 12 + offset - 4, Rotation.CLOCKWISE_90);
        list.add(padding10);
        padding10.func_74861_a(structureComponent, (List)list, random);
    }
    
    private static String getStringFromFacings(final int directions) {
        switch (directions & 0xF) {
            case 2: {
                return " \u2577 ";
            }
            case 1: {
                return " \u2576\u2500";
            }
            case 8: {
                return " \u2575 ";
            }
            case 4: {
                return "\u2500\u2574 ";
            }
            case 9: {
                return " \u2514\u2500";
            }
            case 12: {
                return "\u2500\u2518 ";
            }
            case 6: {
                return "\u2500\u2510 ";
            }
            case 3: {
                return " \u250c\u2500";
            }
            case 13: {
                return "\u2500\u2534\u2500";
            }
            case 14: {
                return "\u2500\u2524 ";
            }
            case 7: {
                return "\u2500\u252c\u2500";
            }
            case 11: {
                return " \u251c\u2500";
            }
            case 10: {
                return " \u2502 ";
            }
            case 5: {
                return "\u2500\u2500\u2500";
            }
            case 15: {
                return "\u2500\u253c\u2500";
            }
            default: {
                return " \u2022 ";
            }
        }
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        final ListNBT mazeX = new ListNBT();
        for (int x = 0; x < this.widthInCellCount - 1; ++x) {
            final ListNBT mazeY = new ListNBT();
            for (int y = 0; y < this.heightInCellCount - 1; ++y) {
                mazeY.add((Object)IntNBT.func_229692_a_(this.maze[x][y]));
            }
            mazeX.add((Object)mazeY);
        }
        tagCompound.func_74768_a("mazeWidth", this.widthInCellCount);
        tagCompound.func_74768_a("mazeHeight", this.heightInCellCount);
        tagCompound.func_218657_a("maze", (INBT)mazeX);
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
