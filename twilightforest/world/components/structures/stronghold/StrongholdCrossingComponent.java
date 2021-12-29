// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class StrongholdCrossingComponent extends StructureTFStrongholdComponent
{
    public StrongholdCrossingComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSCr, nbt);
    }
    
    public StrongholdCrossingComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSCr, feature, i, facing, x, y, z);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -1, 0, 18, 7, 18, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addDoor(13, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 18);
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 13);
        this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 18, 1, 4);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 6, 17, rand, this.deco.randomBlocks);
        this.placeCornerStatue(world, 2, 1, 2, 0, sbb);
        this.placeCornerStatue(world, 15, 1, 15, 3, sbb);
        this.fillBlocksRotated(world, sbb, 8, 1, 8, 9, 5, 9, this.deco.pillarState, Rotation.NONE);
        this.placeWallStatue(world, 8, 1, 7, Rotation.NONE, sbb);
        this.placeWallStatue(world, 7, 1, 9, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 9, 1, 10, Rotation.CLOCKWISE_180, sbb);
        this.placeWallStatue(world, 10, 1, 8, Rotation.CLOCKWISE_90, sbb);
        this.placeTableAndChairs(world, sbb, Rotation.NONE);
        this.placeTableAndChairs(world, sbb, Rotation.CLOCKWISE_90);
        this.placeTableAndChairs(world, sbb, Rotation.CLOCKWISE_180);
        this.placeTableAndChairs(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void placeTableAndChairs(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation) {
        final BlockState oakStairs = Blocks.f_50086_.m_49966_();
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(oakStairs, Rotation.NONE.m_55954_(Direction.WEST), true), 5, 1, 3, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(oakStairs, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 5, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(oakStairs, Rotation.CLOCKWISE_90.m_55954_(Direction.WEST), true), 6, 1, 3, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(oakStairs, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), true), 6, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50269_.m_49966_().m_61124_((Property)StairBlock.f_56841_, (Comparable)Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST)), 5, 1, 2, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50269_.m_49966_().m_61124_((Property)StairBlock.f_56841_, (Comparable)Rotation.NONE.m_55954_(Direction.WEST)), 7, 1, 3, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50269_.m_49966_().m_61124_((Property)StairBlock.f_56841_, (Comparable)Rotation.CLOCKWISE_90.m_55954_(Direction.WEST)), 6, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50269_.m_49966_().m_61124_((Property)StairBlock.f_56841_, (Comparable)Rotation.CLOCKWISE_180.m_55954_(Direction.WEST)), 4, 1, 4, rotation, sbb);
    }
}
