// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
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

public class StrongholdUpperAscenderComponent extends StructureTFStrongholdComponent
{
    boolean exitTop;
    
    public StrongholdUpperAscenderComponent(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSUA, nbt);
        this.exitTop = nbt.m_128471_("exitTop");
    }
    
    public StrongholdUpperAscenderComponent(final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(StrongholdPieces.TFSUA, feature, i, facing, x, y, z);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("exitTop", this.exitTop);
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        if (y < -7) {
            this.exitTop = true;
            return BoundingBox.m_71031_(x, y, z, -2, -1, 0, 5, 10, 10, facing);
        }
        this.exitTop = false;
        return BoundingBox.m_71031_(x, y, z, -2, -6, 0, 5, 10, 10, facing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(parent, list, random);
        this.addNewUpperComponent(parent, list, random, Rotation.NONE, 2, this.exitTop ? 6 : 1, 10);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.placeUpperStrongholdWalls(world, sbb, 0, 0, 0, 4, 9, 9, rand, this.deco.randomBlocks);
        this.placeSmallDoorwayAt(world, 2, 2, this.exitTop ? 1 : 6, 0, sbb);
        this.placeSmallDoorwayAt(world, 0, 2, this.exitTop ? 6 : 1, 9, sbb);
        if (this.exitTop) {
            this.makeStairsAt(world, 1, 3, Direction.NORTH, sbb);
            this.makeStairsAt(world, 2, 4, Direction.NORTH, sbb);
            this.makeStairsAt(world, 3, 5, Direction.NORTH, sbb);
            this.makeStairsAt(world, 4, 6, Direction.NORTH, sbb);
            this.makeStairsAt(world, 5, 7, Direction.NORTH, sbb);
            this.makePlatformAt(world, 5, 8, sbb);
        }
        else {
            this.makeStairsAt(world, 1, 6, Direction.NORTH, sbb);
            this.makeStairsAt(world, 2, 5, Direction.NORTH, sbb);
            this.makeStairsAt(world, 3, 4, Direction.NORTH, sbb);
            this.makeStairsAt(world, 4, 3, Direction.NORTH, sbb);
            this.makeStairsAt(world, 5, 2, Direction.NORTH, sbb);
            this.makePlatformAt(world, 5, 1, sbb);
        }
        return true;
    }
    
    private void makeStairsAt(final WorldGenLevel world, final int y, final int z, final Direction facing, final BoundingBox sbb) {
        if (this.m_73398_((BlockGetter)world, 0, y, z, sbb).m_60734_() != Blocks.f_50016_ || this.m_73398_((BlockGetter)world, 4, y, z, sbb).m_60734_() != Blocks.f_50016_) {
            for (int x = 1; x < 4; ++x) {
                this.m_73434_(world, (BlockState)Blocks.f_50194_.m_49966_().m_61124_((Property)StairBlock.f_56841_, (Comparable)facing.m_122424_()), x, y, z, sbb);
            }
        }
    }
    
    private void makePlatformAt(final WorldGenLevel world, final int y, final int z, final BoundingBox sbb) {
        if (this.m_73398_((BlockGetter)world, 0, y, z, sbb).m_60734_() != Blocks.f_50016_ || this.m_73398_((BlockGetter)world, 4, y, z, sbb).m_60734_() != Blocks.f_50016_) {
            for (int x = 1; x < 4; ++x) {
                this.m_73434_(world, Blocks.f_50222_.m_49966_(), x, y, z, sbb);
            }
        }
    }
    
    @Override
    public boolean isComponentProtected() {
        return false;
    }
}
