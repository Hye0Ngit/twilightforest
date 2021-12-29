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

public class StrongholdUpperRightTurnComponent extends StructureTFStrongholdComponent
{
    public StrongholdUpperRightTurnComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSURT, nbt);
    }
    
    public StrongholdUpperRightTurnComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSURT, feature, i, facing, x, y, z);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return BoundingBox.m_71031_(x, y, z, -2, -1, 0, 5, 5, 5, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addNewUpperComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 2);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 4, 4, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, 2, 2, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, 1, 0, 1, 2, sbb);
        return true;
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
