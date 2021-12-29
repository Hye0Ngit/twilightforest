// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import twilightforest.util.RotationUtil;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Iterator;
import java.util.List;
import twilightforest.TwilightForestMod;
import java.util.Collection;
import java.util.LinkedList;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleMainComponent extends TFStructureComponentOld
{
    public FinalCastleMainComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCMain, nbt);
    }
    
    public FinalCastleMainComponent(final TFFeature feature, final Random rand, final int i, int x, final int y, int z) {
        super(FinalCastlePieces.TFFCMain, feature, i, x, y, z);
        this.m_73519_(Direction.SOUTH);
        this.spawnListIndex = 1;
        x = x + 127 >> 8 << 8;
        z = z + 127 >> 8 << 8;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -24, 120, -24, 48, 40, 48, Direction.SOUTH);
        final BlockPos cc = TFFeature.getNearestCenterXYZ(x >> 4, z >> 4);
        final int cx = x >> 8 << 8;
        final int cz = z >> 8 << 8;
        if (this.deco == null) {
            this.deco = new StructureTFDecoratorCastle();
        }
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        final FinalCastleFoundation48Component foundation = new FinalCastleFoundation48Component(this.getFeatureType(), rand, 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)foundation);
        foundation.m_142537_(this, list, rand);
        final TFStructureComponentOld roof = new FinalCastleRoof48CrenellatedComponent(this.getFeatureType(), 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)roof);
        roof.m_142537_((StructurePiece)this, list, rand);
        final TFStructureComponentOld gazebo = new FinalCastleBossGazeboComponent(this.getFeatureType(), rand, 5, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)gazebo);
        gazebo.m_142537_((StructurePiece)this, list, rand);
        final FinalCastleStairTowerComponent tower0 = new FinalCastleStairTowerComponent(this.getFeatureType(), rand, 3, this.f_73383_.m_162395_(), this.f_73383_.m_162396_() + 3, this.f_73383_.m_162398_(), Direction.NORTH);
        list.m_142679_((StructurePiece)tower0);
        tower0.m_142537_(this, list, rand);
        final FinalCastleLargeTowerComponent tower2 = new FinalCastleLargeTowerComponent(this.getFeatureType(), rand, 3, this.f_73383_.m_162399_(), this.f_73383_.m_162396_() + 3, this.f_73383_.m_162398_(), Direction.EAST);
        list.m_142679_((StructurePiece)tower2);
        tower2.m_142537_(this, list, rand);
        final FinalCastleStairTowerComponent tower3 = new FinalCastleStairTowerComponent(this.getFeatureType(), rand, 3, this.f_73383_.m_162395_(), this.f_73383_.m_162396_() + 3, this.f_73383_.m_162401_(), Direction.WEST);
        list.m_142679_((StructurePiece)tower3);
        tower3.m_142537_(this, list, rand);
        final FinalCastleStairTowerComponent tower4 = new FinalCastleStairTowerComponent(this.getFeatureType(), rand, 3, this.f_73383_.m_162399_(), this.f_73383_.m_162396_() + 3, this.f_73383_.m_162401_(), Direction.SOUTH);
        list.m_142679_((StructurePiece)tower4);
        tower4.m_142537_(this, list, rand);
        BlockPos dest = new BlockPos(this.f_73383_.m_162395_() - 4, this.f_73383_.m_162400_(), this.f_73383_.m_162398_() - 24);
        this.buildTowerMaze(list, rand, 48, 0, 24, 60, Direction.SOUTH, ((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get()).m_49966_(), dest);
        dest = new BlockPos(this.f_73383_.m_162399_() + 4, this.f_73383_.m_162396_(), this.f_73383_.m_162401_() + 24);
        this.buildTowerMaze(list, rand, 0, 30, 24, 60, Direction.NORTH, ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_(), dest);
        final FinalCastleDungeonStepsComponent steps0 = new FinalCastleDungeonStepsComponent(this.getFeatureType(), rand, 5, this.f_73383_.m_162395_() + 18, this.f_73383_.m_162396_() + 1, this.f_73383_.m_162398_() + 18, Direction.SOUTH);
        list.m_142679_((StructurePiece)steps0);
        steps0.m_142537_(this, list, rand);
        final FinalCastleDungeonStepsComponent steps2 = steps0.buildMoreStepsTowards(parent, list, rand, Rotation.COUNTERCLOCKWISE_90);
        final FinalCastleDungeonStepsComponent steps3 = steps2.buildMoreStepsTowards(parent, list, rand, Rotation.COUNTERCLOCKWISE_90);
        final FinalCastleDungeonStepsComponent steps4 = steps3.buildMoreStepsTowards(parent, list, rand, Rotation.COUNTERCLOCKWISE_90);
        steps4.buildLevelUnder(parent, list, rand, 1);
        final BlockPos mc = this.offsetTowerCCoords(48, 23, 25, 1, Direction.SOUTH);
        final FinalCastleMuralComponent mural0 = new FinalCastleMuralComponent(this.getFeatureType(), 7, mc.m_123341_(), mc.m_123342_(), mc.m_123343_(), 35, 30, Direction.SOUTH);
        list.m_142679_((StructurePiece)mural0);
        mural0.m_142537_((StructurePiece)this, list, rand);
        final BlockPos mc2 = this.offsetTowerCCoords(48, 33, 24, -1, Direction.SOUTH);
        final FinalCastleMuralComponent mural2 = new FinalCastleMuralComponent(this.getFeatureType(), 7, mc2.m_123341_(), mc2.m_123342_(), mc.m_123343_(), 19, 12, Direction.NORTH);
        list.m_142679_((StructurePiece)mural2);
        mural2.m_142537_((StructurePiece)this, list, rand);
    }
    
    private void buildTowerMaze(final StructurePieceAccessor list, final Random rand, final int x, final int y, final int z, final int howFar, final Direction direction, final BlockState type, final BlockPos dest) {
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            boolean complete = false;
            int iterations = 0;
            while (!complete && iterations < 15) {
                ++iterations;
                final List<StructurePiece> before = new LinkedList<StructurePiece>(start.m_73602_());
                final BlockPos tc = this.offsetTowerCCoords(x, y, z, howFar, direction);
                final FinalCastleMazeTower13Component sTower = new FinalCastleMazeTower13Component(FinalCastlePieces.TFFCSiTo, this.getFeatureType(), rand, 3, tc.m_123341_(), tc.m_123342_(), tc.m_123343_(), type, direction);
                final BlockPos bc = this.offsetTowerCCoords(x, y, z, 1, direction);
                final FinalCastleBridgeComponent bridge = new FinalCastleBridgeComponent(this.getFeatureType(), this.m_73548_() + 1, bc.m_123341_(), bc.m_123342_(), bc.m_123343_(), howFar - 7, direction);
                list.m_142679_((StructurePiece)bridge);
                bridge.m_142537_(this, list, rand);
                list.m_142679_((StructurePiece)sTower);
                sTower.buildTowards(this, list, rand, dest);
                if (this.isMazeComplete(list, type)) {
                    complete = true;
                }
                else {
                    TwilightForestMod.LOGGER.info("Tower maze color {} INCOMPLETE, retrying!", (Object)type);
                    start.m_73602_().clear();
                    start.m_73602_().addAll(before);
                }
            }
        }
    }
    
    private boolean isMazeComplete(final StructurePieceAccessor list, final BlockState type) {
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            if (start.m_73602_().size() > 60) {
                TwilightForestMod.LOGGER.warn("Maze of color {} is getting a bit excessive.", (Object)type);
            }
            for (final StructurePiece structurecomponent : start.m_73602_()) {
                final BoundingBox boundingBox = structurecomponent.m_73547_();
                final int x = boundingBox.m_162399_() - boundingBox.m_162395_() / 2 + boundingBox.m_162395_();
                final int y = boundingBox.m_162400_() - boundingBox.m_162396_() / 2 + boundingBox.m_162396_();
                final int z = boundingBox.m_162401_() - boundingBox.m_162398_() / 2 + boundingBox.m_162398_();
                if (type == ((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get()).m_49966_() && structurecomponent instanceof FinalCastleEntranceTowerComponent) {
                    return true;
                }
                if (type == ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_() && structurecomponent instanceof FinalCastleBellTower21Component) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    protected BlockPos offsetTowerCCoords(final int x, final int y, final int z, final int howFar, final Direction direction) {
        int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        int dz = this.m_73525_(x, z);
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
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73464_(world, sbb, 0, 0, 0, 48, 40, 48, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 13, 30, 1, 47, 30, 12, false, rand, this.deco.randomBlocks);
        this.m_73441_(world, sbb, 13, 31, 12, 36, 31, 12, this.deco.fenceState, this.deco.fenceState, false);
        this.m_73464_(world, sbb, 13, 30, 36, 47, 30, 47, false, rand, this.deco.randomBlocks);
        this.m_73441_(world, sbb, 13, 31, 36, 36, 31, 36, this.deco.fenceState, this.deco.fenceState, false);
        this.m_73464_(world, sbb, 1, 30, 1, 12, 30, 47, false, rand, this.deco.randomBlocks);
        this.m_73441_(world, sbb, 12, 31, 12, 12, 31, 36, this.deco.fenceState, this.deco.fenceState, false);
        this.m_73464_(world, sbb, 38, 25, 13, 47, 25, 35, false, rand, this.deco.randomBlocks);
        for (int i = 0; i < 5; ++i) {
            int y = 30 - i;
            this.makeMezzTopStairs(world, sbb, y, 10 + i, Direction.SOUTH);
            this.makeMezzTopStairs(world, sbb, y, 38 - i, Direction.NORTH);
            y = 25 - i;
            final int x = 37 - i;
            final BlockState stairState = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false);
            this.m_73441_(world, sbb, x, y, 14, x, y, 22, stairState, stairState, false);
            this.m_73441_(world, sbb, x, y - 1, 14, x, y - 1, 22, this.deco.blockState, this.deco.blockState, false);
            this.m_73441_(world, sbb, x, y, 26, x, y, 34, stairState, stairState, false);
            this.m_73441_(world, sbb, x, y - 1, 26, x, y - 1, 34, this.deco.blockState, this.deco.blockState, false);
        }
        for (int x2 = 11; x2 < 47; x2 += 12) {
            for (int z = 11; z < 47; z += 12) {
                this.m_73441_(world, sbb, x2, 1, z, x2 + 2, 40, z + 2, this.deco.pillarState, this.deco.blockState, false);
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
        this.m_73464_(world, sbb, 1, 20, 1, 47, 20, 47, false, rand, this.deco.randomBlocks);
        final BlockState fieldBlock = ((Block)TFBlocks.PINK_FORCE_FIELD.get()).m_49966_();
        this.m_73441_(world, sbb, 12, 1, 12, 24, 10, 12, fieldBlock, fieldBlock, false);
        this.m_73441_(world, sbb, 12, 1, 12, 12, 10, 24, fieldBlock, fieldBlock, false);
        this.m_73441_(world, sbb, 24, 1, 12, 24, 10, 24, fieldBlock, fieldBlock, false);
        this.m_73441_(world, sbb, 12, 1, 24, 24, 10, 24, fieldBlock, fieldBlock, false);
        this.m_73441_(world, sbb, 12, 10, 12, 24, 10, 24, fieldBlock, fieldBlock, false);
        this.m_73441_(world, sbb, 17, 1, 12, 19, 4, 12, ((Block)TFBlocks.PINK_CASTLE_DOOR.get()).m_49966_(), FinalCastleMainComponent.AIR, false);
        this.m_73441_(world, sbb, 17, 1, 24, 19, 4, 24, ((Block)TFBlocks.PINK_CASTLE_DOOR.get()).m_49966_(), FinalCastleMainComponent.AIR, false);
        this.makeSmallTowerStairs(world, sbb, Rotation.NONE);
        this.makeSmallTowerStairs(world, sbb, Rotation.CLOCKWISE_90);
        this.makeSmallTowerStairs(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.makeLargeTowerStairs(world, sbb, Rotation.CLOCKWISE_180);
        this.m_73441_(world, sbb, 48, 1, 23, 48, 4, 25, ((Block)TFBlocks.YELLOW_CASTLE_DOOR.get()).m_49966_(), FinalCastleMainComponent.AIR, false);
        this.m_73441_(world, sbb, 0, 31, 23, 0, 34, 25, ((Block)TFBlocks.VIOLET_CASTLE_DOOR.get()).m_49966_(), FinalCastleMainComponent.AIR, false);
        return true;
    }
    
    private void makeSmallTowerStairs(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation) {
        for (int y = 1; y < 4; ++y) {
            final int z = 40 + y;
            this.fillBlocksRotated(world, sbb, 1, 1, z, 4, y, z, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 2, y, z, 3, y, z, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), rotation);
        }
    }
    
    private void makeLargeTowerStairs(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation) {
        final BlockState stairState = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false);
        for (int y = 1; y < 4; ++y) {
            final int z = 38 + y;
            this.fillBlocksRotated(world, sbb, 2, 1, z, 6, y, z, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 3, y, z, 5, y, z, stairState, rotation);
        }
    }
    
    private void makeMezzTopStairs(final WorldGenLevel world, final BoundingBox sbb, final int y, final int z, final Direction stairMeta) {
        final BlockState stairState = TFStructureComponentOld.getStairState(this.deco.stairState, stairMeta, false);
        this.m_73441_(world, sbb, 38, y, z, 46, y, z, stairState, stairState, false);
        this.m_73441_(world, sbb, 38, y - 1, z, 46, y - 1, z, this.deco.blockState, this.deco.blockState, false);
        this.m_73535_(world, sbb, 38, y + 1, z, 46, y + 3, z);
    }
    
    private void makeHalfPillarBase(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y, final int z, final boolean isFlipped) {
        this.fillBlocksRotated(world, sbb, 2, y, z - 1, 2, y, z + 3, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, isFlipped), rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, isFlipped), 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, isFlipped), 1, y, z + 3, rotation, sbb);
    }
    
    private void makePillarBase(final WorldGenLevel world, final BoundingBox sbb, final int x, final int z, final int y, final boolean isFlipped) {
        this.m_73441_(world, sbb, x, y, z + 3, x + 3, y, z + 3, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, isFlipped), FinalCastleMainComponent.AIR, false);
        this.m_73441_(world, sbb, x - 1, y, z - 1, x + 2, y, z - 1, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, isFlipped), FinalCastleMainComponent.AIR, false);
        this.m_73441_(world, sbb, x + 3, y, z - 1, x + 3, y, z + 2, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, isFlipped), FinalCastleMainComponent.AIR, false);
        this.m_73441_(world, sbb, x - 1, y, z, x - 1, y, z + 3, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, isFlipped), FinalCastleMainComponent.AIR, false);
    }
}
