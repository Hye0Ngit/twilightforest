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

public class MazeDeadEndTorchesComponent extends MazeDeadEndComponent
{
    public MazeDeadEndTorchesComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMDET, nbt);
    }
    
    public MazeDeadEndTorchesComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMDET, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.m_73441_(world, sbb, 2, 1, 4, 3, 4, 4, (BlockState)Blocks.f_50082_.m_49966_().m_61124_((Property)WallTorchBlock.f_58119_, (Comparable)Direction.SOUTH), MazeDeadEndTorchesComponent.AIR, false);
        this.m_73441_(world, sbb, 1, 1, 1, 1, 4, 4, (BlockState)Blocks.f_50082_.m_49966_().m_61124_((Property)WallTorchBlock.f_58119_, (Comparable)Direction.WEST), MazeDeadEndTorchesComponent.AIR, false);
        this.m_73441_(world, sbb, 4, 1, 1, 4, 4, 4, (BlockState)Blocks.f_50082_.m_49966_().m_61124_((Property)WallTorchBlock.f_58119_, (Comparable)Direction.EAST), MazeDeadEndTorchesComponent.AIR, false);
        return true;
    }
}
