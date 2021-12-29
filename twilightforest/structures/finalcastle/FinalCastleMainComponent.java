// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.util.RotationUtil;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Iterator;
import twilightforest.TwilightForestMod;
import java.util.Collection;
import java.util.LinkedList;
import net.minecraft.block.BlockState;
import net.minecraft.util.Rotation;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class FinalCastleMainComponent extends TFStructureComponentOld
{
    public FinalCastleMainComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCMain, nbt);
    }
    
    public FinalCastleMainComponent(final TFFeature feature, final Random rand, final int i, int x, final int y, int z) {
        super(FinalCastlePieces.TFFCMain, feature, i);
        this.func_186164_a(Direction.SOUTH);
        this.spawnListIndex = 1;
        x = x + 127 >> 8 << 8;
        z = z + 127 >> 8 << 8;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -24, 120, -24, 48, 40, 48, Direction.SOUTH);
        final BlockPos cc = TFFeature.getNearestCenterXYZ(x >> 4, z >> 4);
        final int cx = x >> 8 << 8;
        final int cz = z >> 8 << 8;
        if (this.deco == null) {
            this.deco = new StructureTFDecoratorCastle();
        }
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        final FinalCastleFoundation48Component foundation = new FinalCastleFoundation48Component(this.getFeatureType(), rand, 4, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final TFStructureComponentOld roof = new FinalCastleRoof48CrenellatedComponent(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a((StructurePiece)this, (List)list, rand);
        final TFStructureComponentOld gazebo = new FinalCastleBossGazeboComponent(this.getFeatureType(), rand, 5, this);
        list.add(gazebo);
        gazebo.func_74861_a((StructurePiece)this, (List)list, rand);
        final FinalCastleStairTowerComponent tower0 = new FinalCastleStairTowerComponent(this.getFeatureType(), rand, 3, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c, Direction.NORTH);
        list.add(tower0);
        tower0.func_74861_a(this, list, rand);
        final FinalCastleLargeTowerComponent tower2 = new FinalCastleLargeTowerComponent(this.getFeatureType(), rand, 3, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c, Direction.EAST);
        list.add(tower2);
        tower2.func_74861_a(this, list, rand);
        final FinalCastleStairTowerComponent tower3 = new FinalCastleStairTowerComponent(this.getFeatureType(), rand, 3, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f, Direction.WEST);
        list.add(tower3);
        tower3.func_74861_a(this, list, rand);
        final FinalCastleStairTowerComponent tower4 = new FinalCastleStairTowerComponent(this.getFeatureType(), rand, 3, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f, Direction.SOUTH);
        list.add(tower4);
        tower4.func_74861_a(this, list, rand);
        BlockPos dest = new BlockPos(this.field_74887_e.field_78897_a - 4, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c - 24);
        this.buildTowerMaze(list, rand, 48, 0, 24, 60, Direction.SOUTH, ((Block)TFBlocks.castle_rune_brick_pink.get()).func_176223_P(), dest);
        dest = new BlockPos(this.field_74887_e.field_78893_d + 4, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 24);
        this.buildTowerMaze(list, rand, 0, 30, 24, 60, Direction.NORTH, ((Block)TFBlocks.castle_rune_brick_blue.get()).func_176223_P(), dest);
        final FinalCastleDungeonStepsComponent steps0 = new FinalCastleDungeonStepsComponent(this.getFeatureType(), rand, 5, this.field_74887_e.field_78897_a + 18, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c + 18, Direction.SOUTH);
        list.add(steps0);
        steps0.func_74861_a(this, list, rand);
        final FinalCastleDungeonStepsComponent steps2 = steps0.buildMoreStepsTowards(parent, list, rand, Rotation.COUNTERCLOCKWISE_90);
        final FinalCastleDungeonStepsComponent steps3 = steps2.buildMoreStepsTowards(parent, list, rand, Rotation.COUNTERCLOCKWISE_90);
        final FinalCastleDungeonStepsComponent steps4 = steps3.buildMoreStepsTowards(parent, list, rand, Rotation.COUNTERCLOCKWISE_90);
        steps4.buildLevelUnder(parent, list, rand, 1);
        final BlockPos mc = this.offsetTowerCCoords(48, 23, 25, 1, Direction.SOUTH);
        final FinalCastleMuralComponent mural0 = new FinalCastleMuralComponent(this.getFeatureType(), rand, 7, mc.func_177958_n(), mc.func_177956_o(), mc.func_177952_p(), 35, 30, Direction.SOUTH);
        list.add(mural0);
        mural0.func_74861_a((StructurePiece)this, (List)list, rand);
        final BlockPos mc2 = this.offsetTowerCCoords(48, 33, 24, -1, Direction.SOUTH);
        final FinalCastleMuralComponent mural2 = new FinalCastleMuralComponent(this.getFeatureType(), rand, 7, mc2.func_177958_n(), mc2.func_177956_o(), mc.func_177952_p(), 19, 12, Direction.NORTH);
        list.add(mural2);
        mural2.func_74861_a((StructurePiece)this, (List)list, rand);
    }
    
    private void buildTowerMaze(final List<StructurePiece> list, final Random rand, final int x, final int y, final int z, final int howFar, final Direction direction, final BlockState type, final BlockPos dest) {
        boolean complete = false;
        int iterations = 0;
        while (!complete && iterations < 15) {
            ++iterations;
            final List<StructurePiece> before = new LinkedList<StructurePiece>(list);
            final BlockPos tc = this.offsetTowerCCoords(x, y, z, howFar, direction);
            final FinalCastleMazeTower13Component sTower = new FinalCastleMazeTower13Component(FinalCastlePieces.TFFCSiTo, this.getFeatureType(), rand, 3, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), type, direction);
            final BlockPos bc = this.offsetTowerCCoords(x, y, z, 1, direction);
            final FinalCastleBridgeComponent bridge = new FinalCastleBridgeComponent(this.getFeatureType(), this.func_74877_c() + 1, bc.func_177958_n(), bc.func_177956_o(), bc.func_177952_p(), howFar - 7, direction);
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            list.add(sTower);
            sTower.buildTowards(this, list, rand, dest);
            if (this.isMazeComplete(list, type)) {
                complete = true;
            }
            else {
                TwilightForestMod.LOGGER.info("Tower maze color {} INCOMPLETE, retrying!", (Object)type);
                list.clear();
                list.addAll(before);
            }
        }
    }
    
    private boolean isMazeComplete(final List<StructurePiece> list, final BlockState type) {
        if (list.size() > 60) {
            TwilightForestMod.LOGGER.warn("Maze of color {} is getting a bit excessive.", (Object)type);
        }
        for (final StructurePiece structurecomponent : list) {
            final MutableBoundingBox boundingBox = structurecomponent.func_74874_b();
            final int x = boundingBox.field_78893_d - boundingBox.field_78897_a / 2 + boundingBox.field_78897_a;
            final int y = boundingBox.field_78894_e - boundingBox.field_78895_b / 2 + boundingBox.field_78895_b;
            final int z = boundingBox.field_78892_f - boundingBox.field_78896_c / 2 + boundingBox.field_78896_c;
            if (type == ((Block)TFBlocks.castle_rune_brick_pink.get()).func_176223_P() && structurecomponent instanceof FinalCastleEntranceTowerComponent) {
                return true;
            }
            if (type == ((Block)TFBlocks.castle_rune_brick_blue.get()).func_176223_P() && structurecomponent instanceof FinalCastleBellTower21Component) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected BlockPos offsetTowerCCoords(final int x, final int y, final int z, final int howFar, final Direction direction) {
        int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        int dz = this.func_74873_b(x, z);
        switch (direction) {
            case SOUTH: {
                dx += howFar;
                break;
            }
            case WEST: {
                dz += howFar;
                break;
            }
            case NORTH: {
                dx -= howFar;
                break;
            }
            case EAST: {
                dz -= howFar;
                break;
            }
        }
        return new BlockPos(dx, dy, dz);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_74882_a(world, sbb, 0, 0, 0, 48, 40, 48, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 13, 30, 1, 47, 30, 12, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 13, 31, 12, 36, 31, 12, this.deco.fenceState, this.deco.fenceState, false);
        this.func_74882_a(world, sbb, 13, 30, 36, 47, 30, 47, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 13, 31, 36, 36, 31, 36, this.deco.fenceState, this.deco.fenceState, false);
        this.func_74882_a(world, sbb, 1, 30, 1, 12, 30, 47, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 12, 31, 12, 12, 31, 36, this.deco.fenceState, this.deco.fenceState, false);
        this.func_74882_a(world, sbb, 38, 25, 13, 47, 25, 35, false, rand, this.deco.randomBlocks);
        for (int i = 0; i < 5; ++i) {
            int y = 30 - i;
            this.makeMezzTopStairs(world, sbb, y, 10 + i, Direction.SOUTH);
            this.makeMezzTopStairs(world, sbb, y, 38 - i, Direction.NORTH);
            y = 25 - i;
            final int x = 37 - i;
            final BlockState stairState = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false);
            this.func_175804_a(world, sbb, x, y, 14, x, y, 22, stairState, stairState, false);
            this.func_175804_a(world, sbb, x, y - 1, 14, x, y - 1, 22, this.deco.blockState, this.deco.blockState, false);
            this.func_175804_a(world, sbb, x, y, 26, x, y, 34, stairState, stairState, false);
            this.func_175804_a(world, sbb, x, y - 1, 26, x, y - 1, 34, this.deco.blockState, this.deco.blockState, false);
        }
        for (int x2 = 11; x2 < 47; x2 += 12) {
            for (int z = 11; z < 47; z += 12) {
                this.func_175804_a(world, sbb, x2, 1, z, x2 + 2, 40, z + 2, this.deco.pillarState, this.deco.blockState, false);
                this.makePillarBase(world, sbb, x2, z, 1, false);
                this.makePillarBase(world, sbb, x2, z, 19, true);
                this.makePillarBase(world, sbb, x2, z, 21, false);
                this.makePillarBase(world, sbb, x2, z, 39, true);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            for (int z2 = 11; z2 < 47; z2 += 12) {
                if (z2 == 23) {
                    if (rotation == Rotation.NONE) {
                        continue;
                    }
                    if (rotation == Rotation.CLOCKWISE_180) {
                        continue;
                    }
                }
                this.fillBlocksRotated(world, sbb, 1, 1, z2, 1, 40, z2 + 2, this.deco.pillarState, rotation);
                this.makeHalfPillarBase(world, sbb, rotation, 1, z2, false);
                this.makeHalfPillarBase(world, sbb, rotation, 19, z2, true);
                this.makeHalfPillarBase(world, sbb, rotation, 21, z2, false);
                this.makeHalfPillarBase(world, sbb, rotation, 39, z2, true);
            }
        }
        this.func_74882_a(world, sbb, 1, 20, 1, 47, 20, 47, false, rand, this.deco.randomBlocks);
        final BlockState fieldBlock = ((Block)TFBlocks.force_field_pink.get()).func_176223_P();
        this.func_175804_a(world, sbb, 12, 1, 12, 24, 10, 12, fieldBlock, fieldBlock, false);
        this.func_175804_a(world, sbb, 12, 1, 12, 12, 10, 24, fieldBlock, fieldBlock, false);
        this.func_175804_a(world, sbb, 24, 1, 12, 24, 10, 24, fieldBlock, fieldBlock, false);
        this.func_175804_a(world, sbb, 12, 1, 24, 24, 10, 24, fieldBlock, fieldBlock, false);
        this.func_175804_a(world, sbb, 12, 10, 12, 24, 10, 24, fieldBlock, fieldBlock, false);
        this.func_175804_a(world, sbb, 17, 1, 12, 19, 4, 12, ((Block)TFBlocks.castle_door_pink.get()).func_176223_P(), FinalCastleMainComponent.AIR, false);
        this.func_175804_a(world, sbb, 17, 1, 24, 19, 4, 24, ((Block)TFBlocks.castle_door_pink.get()).func_176223_P(), FinalCastleMainComponent.AIR, false);
        this.makeSmallTowerStairs(world, sbb, Rotation.NONE);
        this.makeSmallTowerStairs(world, sbb, Rotation.CLOCKWISE_90);
        this.makeSmallTowerStairs(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.makeLargeTowerStairs(world, sbb, Rotation.CLOCKWISE_180);
        this.func_175804_a(world, sbb, 48, 1, 23, 48, 4, 25, ((Block)TFBlocks.castle_door_yellow.get()).func_176223_P(), FinalCastleMainComponent.AIR, false);
        this.func_175804_a(world, sbb, 0, 31, 23, 0, 34, 25, ((Block)TFBlocks.castle_door_purple.get()).func_176223_P(), FinalCastleMainComponent.AIR, false);
        return true;
    }
    
    private void makeSmallTowerStairs(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation) {
        for (int y = 1; y < 4; ++y) {
            final int z = 40 + y;
            this.fillBlocksRotated(world, sbb, 1, 1, z, 4, y, z, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 2, y, z, 3, y, z, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), rotation);
        }
    }
    
    private void makeLargeTowerStairs(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation) {
        final BlockState stairState = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false);
        for (int y = 1; y < 4; ++y) {
            final int z = 38 + y;
            this.fillBlocksRotated(world, sbb, 2, 1, z, 6, y, z, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 3, y, z, 5, y, z, stairState, rotation);
        }
    }
    
    private void makeMezzTopStairs(final ISeedReader world, final MutableBoundingBox sbb, final int y, final int z, final Direction stairMeta) {
        final BlockState stairState = TFStructureComponentOld.getStairState(this.deco.stairState, stairMeta, false);
        this.func_175804_a(world, sbb, 38, y, z, 46, y, z, stairState, stairState, false);
        this.func_175804_a(world, sbb, 38, y - 1, z, 46, y - 1, z, this.deco.blockState, this.deco.blockState, false);
        this.func_74878_a(world, sbb, 38, y + 1, z, 46, y + 3, z);
    }
    
    private void makeHalfPillarBase(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y, final int z, final boolean isFlipped) {
        this.fillBlocksRotated(world, sbb, 2, y, z - 1, 2, y, z + 3, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, isFlipped), rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, isFlipped), 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, isFlipped), 1, y, z + 3, rotation, sbb);
    }
    
    private void makePillarBase(final ISeedReader world, final MutableBoundingBox sbb, final int x, final int z, final int y, final boolean isFlipped) {
        this.func_175804_a(world, sbb, x, y, z + 3, x + 3, y, z + 3, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, isFlipped), FinalCastleMainComponent.AIR, false);
        this.func_175804_a(world, sbb, x - 1, y, z - 1, x + 2, y, z - 1, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, isFlipped), FinalCastleMainComponent.AIR, false);
        this.func_175804_a(world, sbb, x + 3, y, z - 1, x + 3, y, z + 2, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, isFlipped), FinalCastleMainComponent.AIR, false);
        this.func_175804_a(world, sbb, x - 1, y, z, x - 1, y, z + 3, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, isFlipped), FinalCastleMainComponent.AIR, false);
    }
}
