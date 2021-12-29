// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import twilightforest.loot.TFTreasure;
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

public class StrongholdDeadEndComponent extends StructureTFStrongholdComponent
{
    private boolean chestTrapped;
    
    public StrongholdDeadEndComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSDE, nbt);
        this.chestTrapped = nbt.m_128471_("chestTrapped");
    }
    
    public StrongholdDeadEndComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSDE, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("chestTrapped", this.chestTrapped);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 9, 6, 9, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addDoor(4, 1, 0);
        this.chestTrapped = (random.nextInt(3) == 0);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 8, 6, 8, rand, this.deco.randomBlocks);
        this.placeWallStatue(world, 1, 1, 4, Rotation.CLOCKWISE_90, sbb);
        this.placeWallStatue(world, 7, 1, 4, Rotation.COUNTERCLOCKWISE_90, sbb);
        this.placeWallStatue(world, 4, 1, 7, Rotation.NONE, sbb);
        this.placeDoors(world, sbb);
        this.manualTreaurePlacement(world, 4, 1, 3, Direction.SOUTH, TFTreasure.STRONGHOLD_CACHE, this.chestTrapped, sbb);
        if (this.chestTrapped) {
            this.m_73434_(world, Blocks.f_50077_.m_49966_(), 4, 0, 3, sbb);
        }
        for (int z = 2; z < 5; ++z) {
            this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.WEST), 3, 1, z, sbb);
            this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.EAST), 5, 1, z, sbb);
        }
        this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.NORTH), 4, 1, 2, sbb);
        this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.SOUTH), 4, 1, 4, sbb);
        this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.NORTH), 4, 2, 3, sbb);
        return true;
    }
}
