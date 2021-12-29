// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.world.components.structures.TFStructureComponentOld;
import twilightforest.loot.TFTreasure;
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

public class StrongholdTreasureCorridorComponent extends StructureTFStrongholdComponent
{
    public StrongholdTreasureCorridorComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSTC, nbt);
    }
    
    public StrongholdTreasureCorridorComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSTC, feature, i, facing, x, y, z);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 7, 27, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addDoor(4, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 27);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 26, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 9, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 1, 1, 17, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 9, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 17, Rotation.COUNTERCLOCKWISE_90, sbb);
        final Rotation rotation = ((this.f_73383_.m_162395_() ^ this.f_73383_.m_162398_()) % 2 == 0) ? Rotation.NONE : Rotation.CLOCKWISE_180;
        this.placeTreasureRotated(world, 8, 2, 13, (rotation == Rotation.NONE) ? this.m_73549_().m_122427_() : this.m_73549_().m_122428_(), rotation, TFTreasure.STRONGHOLD_CACHE, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, true), 8, 3, 12, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, true), 8, 3, 13, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, true), 8, 3, 14, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 8, 2, 12, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.fenceState, 8, 2, 14, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.SOUTH), 7, 1, 12, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.WEST), 7, 1, 13, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.NORTH), 7, 1, 14, rotation, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
}
