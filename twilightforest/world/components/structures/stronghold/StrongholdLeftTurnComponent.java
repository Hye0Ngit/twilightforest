// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

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

public class StrongholdLeftTurnComponent extends StructureTFStrongholdComponent
{
    public StrongholdLeftTurnComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSLT, nbt);
    }
    
    public StrongholdLeftTurnComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSLT, feature, i, facing, x, y, z);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 7, 9, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addDoor(4, 1, 0);
        this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 9, 1, 4);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 8, rand, this.deco.randomBlocks);
        this.m_73535_(world, sbb, 1, 1, 1, 7, 5, 7);
        this.placeCornerStatue(world, 2, 1, 6, 1, sbb);
        this.placeDoors(world, sbb);
        return true;
    }
}
