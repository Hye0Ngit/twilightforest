// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
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

public class StrongholdSmallStairsComponent extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    public boolean hasTreasure;
    public boolean chestTrapped;
    
    public StrongholdSmallStairsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSSS, nbt);
        this.enterBottom = nbt.m_128471_("enterBottom");
        this.hasTreasure = nbt.m_128471_("hasTreasure");
        this.chestTrapped = nbt.m_128471_("chestTrapped");
    }
    
    public StrongholdSmallStairsComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSSS, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("enterBottom", this.enterBottom);
        tagCompound.m_128379_("hasTreasure", this.hasTreasure);
        tagCompound.m_128379_("chestTrapped", this.chestTrapped);
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
            return BoundingBox.m_71031_(x, y, z, -4, -1, 0, 9, 14, 9, facing);
        }
        return BoundingBox.m_71031_(x, y, z, -4, -8, 0, 9, 14, 9, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, Rotation.NONE, 4, 8, 9);
        }
        else {
            this.addDoor(4, 8, 0);
            this.addNewComponent(parent, list, random, Rotation.NONE, 4, 1, 9);
        }
        this.hasTreasure = random.nextBoolean();
        this.chestTrapped = (random.nextInt(3) == 0);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 13, 8, rand, this.deco.randomBlocks);
        this.m_73441_(world, sbb, 1, 7, 1, 7, 7, 7, this.deco.platformState, Blocks.f_50016_.m_49966_(), false);
        this.m_73535_(world, sbb, 2, 7, 2, 6, 7, 6);
        final Rotation rotation = this.enterBottom ? Rotation.NONE : Rotation.CLOCKWISE_180;
        for (int y = 1; y < 8; ++y) {
            for (int x = 3; x < 6; ++x) {
                this.setBlockStateRotated(world, Blocks.f_50016_.m_49966_(), x, y + 1, y, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.NORTH), x, y, y, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, x, y - 1, y, rotation, sbb);
            }
        }
        if (this.hasTreasure) {
            this.placeTreasureRotated(world, 4, 1, 6, this.m_73549_().m_122424_(), rotation, TFTreasure.STRONGHOLD_CACHE, this.chestTrapped, sbb);
            if (this.chestTrapped) {
                this.setBlockStateRotated(world, Blocks.f_50077_.m_49966_(), 4, 0, 6, rotation, sbb);
            }
            for (int z = 5; z < 8; ++z) {
                this.setBlockStateRotated(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.WEST), 3, 1, z, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.EAST), 5, 1, z, rotation, sbb);
            }
            this.setBlockStateRotated(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.NORTH), 4, 1, 5, rotation, sbb);
            this.setBlockStateRotated(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.SOUTH), 4, 1, 7, rotation, sbb);
            this.setBlockStateRotated(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.NORTH), 4, 2, 6, rotation, sbb);
        }
        if (this.enterBottom) {
            this.placeWallStatue(world, 4, 8, 1, Rotation.CLOCKWISE_180, sbb);
        }
        else {
            this.placeWallStatue(world, 4, 8, 7, Rotation.NONE, sbb);
        }
        this.placeDoors(world, sbb);
        return true;
    }
}
