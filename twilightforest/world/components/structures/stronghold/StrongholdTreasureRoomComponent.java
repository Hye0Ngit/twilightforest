// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import twilightforest.loot.TFTreasure;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
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

public class StrongholdTreasureRoomComponent extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    
    public StrongholdTreasureRoomComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFTreaR, nbt);
        this.enterBottom = nbt.m_128471_("enterBottom");
    }
    
    public StrongholdTreasureRoomComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFTreaR, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("enterBottom", this.enterBottom);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return BoundingBox.m_71031_(x, y, z, -4, -1, 0, 9, 7, 18, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addDoor(4, 1, 0);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 17, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 4, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 1, 1, 13, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 4, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 13, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 4, 1, 16, Rotation.NONE, sbb);
        this.m_73464_(world, sbb, 1, 1, 8, 7, 5, 9, false, rand, this.deco.randomBlocks);
        this.m_73441_(world, sbb, 3, 1, 8, 5, 4, 9, Blocks.f_50183_.m_49966_(), Blocks.f_50183_.m_49966_(), false);
        this.setSpawner(world, 4, 1, 4, sbb, TFEntities.HELMET_CRAB);
        this.setSpawner(world, 4, 4, 15, sbb, TFEntities.HELMET_CRAB);
        this.manualTreaurePlacement(world, 2, 4, 13, Direction.WEST, TFTreasure.STRONGHOLD_ROOM, false, sbb);
        this.manualTreaurePlacement(world, 6, 4, 13, Direction.EAST, TFTreasure.STRONGHOLD_ROOM, false, sbb);
        this.placeDoors(world, sbb);
        return true;
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
}
