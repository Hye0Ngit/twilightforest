// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import twilightforest.world.components.structures.TFStructureComponentOld;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class StrongholdBossRoomComponent extends StructureTFStrongholdComponent
{
    public StrongholdBossRoomComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSBR, nbt);
    }
    
    public StrongholdBossRoomComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSBR, feature, i, facing, x, y, z);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 27, 7, 27, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addDoor(13, 1, 0);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 26, 6, 26, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 1, 1, 1, 3, 5, 25, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 23, 1, 1, 25, 5, 25, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 4, 1, 1, 22, 5, 3, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 4, 1, 23, 22, 5, 25, false, rand, this.deco.randomBlocks);
        this.m_73441_(world, sbb, 1, 1, 1, 2, 5, 25, Blocks.f_50080_.m_49966_(), Blocks.f_50080_.m_49966_(), false);
        this.m_73441_(world, sbb, 24, 1, 1, 25, 5, 25, Blocks.f_50080_.m_49966_(), Blocks.f_50080_.m_49966_(), false);
        this.m_73441_(world, sbb, 4, 1, 1, 22, 5, 2, Blocks.f_50080_.m_49966_(), Blocks.f_50080_.m_49966_(), false);
        this.m_73441_(world, sbb, 4, 1, 24, 22, 5, 25, Blocks.f_50080_.m_49966_(), Blocks.f_50080_.m_49966_(), false);
        this.m_73464_(world, sbb, 4, 1, 4, 4, 5, 7, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 5, 1, 4, 5, 5, 5, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 6, 1, 4, 7, 5, 4, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 4, 1, 19, 4, 5, 22, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 5, 1, 21, 5, 5, 22, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 6, 1, 22, 7, 5, 22, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 22, 1, 4, 22, 5, 7, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 21, 1, 4, 21, 5, 5, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 19, 1, 4, 20, 5, 4, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 22, 1, 19, 22, 5, 22, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 21, 1, 21, 21, 5, 22, false, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 19, 1, 22, 20, 5, 22, false, rand, this.deco.randomBlocks);
        this.placePillarDecorations(world, sbb, Rotation.NONE);
        this.placePillarDecorations(world, sbb, Rotation.CLOCKWISE_90);
        this.placePillarDecorations(world, sbb, Rotation.CLOCKWISE_180);
        this.placePillarDecorations(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.placeSarcophagus(world, sbb, 8, 1, 8, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 13, 1, 8, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 18, 1, 8, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 8, 1, 15, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 13, 1, 15, Rotation.NONE);
        this.placeSarcophagus(world, sbb, 18, 1, 15, Rotation.NONE);
        this.m_73535_(world, sbb, 12, 1, 1, 14, 4, 2);
        this.m_73441_(world, sbb, 12, 1, 3, 14, 4, 3, Blocks.f_50183_.m_49966_(), Blocks.f_50183_.m_49966_(), false);
        this.m_73434_(world, ((Block)TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER.get()).m_49966_(), 13, 2, 13, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void placeSarcophagus(final WorldGenLevel world, final BoundingBox sbb, final int x, final int y, final int z, final Rotation rotation) {
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z + 3, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x + 1, y, z, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, x - 1, y, z + 3, rotation, sbb);
        if (world.m_5822_().nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.f_50081_.m_49966_(), x + 1, y + 1, z, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x + 1, y + 1, z, rotation, sbb);
        }
        if (world.m_5822_().nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.f_50081_.m_49966_(), x - 1, y + 1, z, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x - 1, y + 1, z, rotation, sbb);
        }
        if (world.m_5822_().nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.f_50081_.m_49966_(), x + 1, y + 1, z + 3, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x + 1, y + 1, z + 3, rotation, sbb);
        }
        if (world.m_5822_().nextInt(7) == 0) {
            this.setBlockStateRotated(world, Blocks.f_50081_.m_49966_(), x - 1, y + 1, z + 3, rotation, sbb);
        }
        else {
            this.setBlockStateRotated(world, this.deco.fenceState, x - 1, y + 1, z + 3, rotation, sbb);
        }
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.m_55954_(Direction.WEST), false), x, y, z, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), false), x, y, z + 3, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), false), x + 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), false), x + 1, y, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.m_55954_(Direction.WEST), false), x - 1, y, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.m_55954_(Direction.WEST), false), x - 1, y, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50405_.m_49966_(), x, y + 1, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50405_.m_49966_(), x, y + 1, z + 2, rotation, sbb);
    }
    
    protected void placePillarDecorations(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation) {
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), false), 4, 1, 8, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), false), 8, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 4, 5, 8, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), true), 8, 5, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), false), 5, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), false), 6, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), false), 6, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 5, 5, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), true), 6, 5, 6, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), true), 6, 5, 5, rotation, sbb);
    }
    
    @Override
    protected void placeDoorwayAt(final WorldGenLevel world, final int x, final int y, final int z, final BoundingBox sbb) {
        if (x == 0 || x == this.getXSize()) {
            this.m_73441_(world, sbb, x, y, z - 1, x, y + 3, z + 1, Blocks.f_50183_.m_49966_(), Blocks.f_50016_.m_49966_(), false);
        }
        else {
            this.m_73441_(world, sbb, x - 1, y, z, x + 1, y + 3, z, Blocks.f_50183_.m_49966_(), Blocks.f_50016_.m_49966_(), false);
        }
    }
    
    @Override
    protected boolean isValidBreakInPoint(final int wx, final int wy, final int wz) {
        return false;
    }
}
