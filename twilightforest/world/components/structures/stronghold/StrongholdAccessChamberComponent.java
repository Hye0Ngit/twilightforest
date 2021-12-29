// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
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

public class StrongholdAccessChamberComponent extends StructureTFStrongholdComponent
{
    public StrongholdAccessChamberComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSAC, nbt);
    }
    
    public StrongholdAccessChamberComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSAC, feature, i, facing, x, y, z);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return BoundingBox.m_71031_(x, y, z, -4, 1, 0, 9, 5, 9, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addNewUpperComponent(parent, list, random, Rotation.NONE, 4, 1, 9);
        this.addNewUpperComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 4);
        this.addNewUpperComponent(parent, list, random, Rotation.CLOCKWISE_180, 4, 1, -1);
        this.addNewUpperComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 9, 1, 4);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73464_(world, sbb, 0, 0, 0, 8, 4, 8, true, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, 0, 4, 1, 8, sbb);
        this.placeSmallDoorwayAt(world, 1, 0, 1, 4, sbb);
        this.placeSmallDoorwayAt(world, 2, 4, 1, 0, sbb);
        this.placeSmallDoorwayAt(world, 3, 8, 1, 4, sbb);
        final BlockState defaultState = Blocks.f_50223_.m_49966_();
        this.m_73441_(world, sbb, 2, -2, 2, 6, 0, 6, defaultState, StrongholdAccessChamberComponent.AIR, false);
        this.m_73535_(world, sbb, 3, -2, 3, 5, 2, 5);
        this.m_73441_(world, sbb, 2, 0, 3, 2, 0, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), false), StrongholdAccessChamberComponent.AIR, false);
        this.m_73441_(world, sbb, 6, 0, 2, 6, 0, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.m_55954_(Direction.WEST), false), StrongholdAccessChamberComponent.AIR, false);
        this.m_73441_(world, sbb, 3, 0, 2, 5, 0, 2, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), false), StrongholdAccessChamberComponent.AIR, false);
        this.m_73441_(world, sbb, 3, 0, 6, 5, 0, 6, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.m_55954_(Direction.WEST), false), StrongholdAccessChamberComponent.AIR, false);
        this.m_73434_(world, this.deco.pillarState, 2, 0, 2, sbb);
        this.m_73434_(world, ((Block)TFBlocks.TROPHY_PEDESTAL.get()).m_49966_(), 2, 1, 2, sbb);
        this.m_73441_(world, sbb, 2, -1, 2, 6, -1, 6, ((Block)TFBlocks.STRONGHOLD_SHIELD.get()).m_49966_(), StrongholdAccessChamberComponent.AIR, false);
        return true;
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
