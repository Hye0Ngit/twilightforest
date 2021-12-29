// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MazeDeadEndPaintingComponent extends MazeDeadEndComponent
{
    public MazeDeadEndPaintingComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMDEP, nbt);
    }
    
    public MazeDeadEndPaintingComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMDEP, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.m_73434_(world, (BlockState)Blocks.f_50082_.m_49966_().m_61124_((Property)WallTorchBlock.f_58119_, (Comparable)Direction.WEST), 1, 3, 3, sbb);
        this.m_73434_(world, (BlockState)Blocks.f_50082_.m_49966_().m_61124_((Property)WallTorchBlock.f_58119_, (Comparable)Direction.EAST), 4, 3, 3, sbb);
        return true;
    }
}
