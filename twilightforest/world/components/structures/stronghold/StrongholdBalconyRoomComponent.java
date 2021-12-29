// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

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

public class StrongholdBalconyRoomComponent extends StructureTFStrongholdComponent
{
    boolean enterBottom;
    
    public StrongholdBalconyRoomComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSBalR, nbt);
        this.enterBottom = nbt.m_128471_("enterBottom");
    }
    
    public StrongholdBalconyRoomComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSBalR, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("enterBottom", this.enterBottom);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        if (y > -15) {
            this.enterBottom = false;
        }
        else if (y < -21) {
            this.enterBottom = true;
        }
        else {
            this.enterBottom = ((z & 0x1) == 0x0);
        }
        if (this.enterBottom) {
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 18, 14, 27, facing);
        }
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -8, 0, 18, 14, 27, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addNewComponent(parent, list, random, Rotation.NONE, 13, 1, 27);
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 13);
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 18, 1, 13);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 8, 27);
        this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 8, 4);
        this.addNewComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 18, 8, 22);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 13, 8, -1);
        }
        else {
            this.addDoor(13, 8, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 4, 1, -1);
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 13, 26, rand, this.deco.randomBlocks);
        this.m_73464_(world, sbb, 1, 6, 1, 16, 7, 25, false, rand, this.deco.randomBlocks);
        this.m_73441_(world, sbb, 4, 8, 4, 13, 8, 22, this.deco.fenceState, Blocks.f_50016_.m_49966_(), false);
        this.m_73535_(world, sbb, 5, 6, 5, 12, 8, 21);
        this.placeStairsAndPillars(world, sbb, Rotation.NONE);
        this.placeStairsAndPillars(world, sbb, Rotation.CLOCKWISE_180);
        this.placeDoors(world, sbb);
        return true;
    }
    
    private void placeStairsAndPillars(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation) {
        this.fillBlocksRotated(world, sbb, 4, 1, 4, 4, 12, 4, this.deco.pillarState, rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), false), 4, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), false), 5, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 4, 5, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), true), 5, 5, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 4, 12, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.m_55954_(Direction.WEST), true), 5, 12, 4, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 13, 1, 4, 13, 12, 4, this.deco.pillarState, rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), false), 13, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.m_55954_(Direction.WEST), false), 12, 1, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 13, 5, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.m_55954_(Direction.WEST), true), 12, 5, 4, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 13, 12, 5, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.m_55954_(Direction.WEST), true), 12, 12, 4, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 13, 1, 8, 13, 12, 8, this.deco.pillarState, rotation);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), false), 13, 1, 9, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.m_55954_(Direction.WEST), false), 13, 1, 7, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.m_55954_(Direction.WEST), false), 12, 1, 8, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 13, 5, 9, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.m_55954_(Direction.WEST), true), 13, 5, 7, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.m_55954_(Direction.WEST), true), 13, 12, 9, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_90.m_55954_(Direction.WEST), true), 13, 12, 7, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.m_55954_(Direction.WEST), true), 12, 12, 8, rotation, sbb);
        for (int y = 1; y < 8; ++y) {
            for (int z = 5; z < 8; ++z) {
                this.setBlockStateRotated(world, StrongholdBalconyRoomComponent.AIR, y + 6, y + 1, z, rotation, sbb);
                this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Rotation.NONE.m_55954_(Direction.WEST), false), y + 6, y, z, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, y + 6, y - 1, z, rotation, sbb);
            }
        }
    }
}
