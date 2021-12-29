// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
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

public class StrongholdTrainingRoomComponent extends StructureTFStrongholdComponent
{
    public StrongholdTrainingRoomComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSTR, nbt);
    }
    
    public StrongholdTrainingRoomComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSTR, feature, i, facing, x, y, z);
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
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 6, 17, rand, this.deco.randomBlocks);
        this.placeCornerStatue(world, 2, 1, 2, 0, sbb);
        this.placeCornerStatue(world, 15, 1, 15, 3, sbb);
        this.m_73476_(world, sbb, rand, 0.7f, 4, 0, 4, 8, 0, 8, Blocks.f_49992_.m_49966_(), Blocks.f_49992_.m_49966_(), false, false);
        this.m_73476_(world, sbb, rand, 0.7f, 9, 0, 4, 13, 0, 8, Blocks.f_49992_.m_49966_(), Blocks.f_49992_.m_49966_(), false, false);
        this.m_73476_(world, sbb, rand, 0.7f, 9, 0, 9, 13, 0, 13, Blocks.f_49992_.m_49966_(), Blocks.f_49992_.m_49966_(), false, false);
        this.placeTrainingDummy(world, sbb, Rotation.NONE);
        this.placeTrainingDummy(world, sbb, Rotation.CLOCKWISE_90);
        this.placeTrainingDummy(world, sbb, Rotation.CLOCKWISE_180);
        this.m_73441_(world, sbb, 5, 0, 10, 7, 0, 12, Blocks.f_50652_.m_49966_(), Blocks.f_50652_.m_49966_(), false);
        this.m_73434_(world, this.deco.pillarState, 5, 1, 12, sbb);
        this.m_73434_(world, this.deco.pillarState, 5, 2, 12, sbb);
        this.m_73434_(world, this.deco.pillarState, 6, 1, 12, sbb);
        this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)CarvedPumpkinBlock.f_51367_, (Comparable)Direction.EAST), 6, 2, 12, sbb);
        this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)CarvedPumpkinBlock.f_51367_, (Comparable)Direction.EAST), 7, 1, 12, sbb);
        this.m_73434_(world, this.deco.pillarState, 5, 1, 11, sbb);
        this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)CarvedPumpkinBlock.f_51367_, (Comparable)Direction.NORTH), 5, 2, 11, sbb);
        this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)CarvedPumpkinBlock.f_51367_, (Comparable)Direction.NORTH), 5, 1, 10, sbb);
        this.m_73434_(world, Blocks.f_50322_.m_49966_(), 6, 1, 11, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void placeTrainingDummy(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation) {
        this.fillBlocksRotated(world, sbb, 5, 0, 5, 7, 0, 7, Blocks.f_49992_.m_49966_(), rotation);
        this.setBlockStateRotated(world, this.deco.fenceState, 6, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50742_.m_49966_(), 6, 2, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50132_.m_49966_(), 5, 2, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50132_.m_49966_(), 7, 2, 6, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.f_50133_.m_49966_(), 6, 3, 6, rotation, sbb);
    }
}
