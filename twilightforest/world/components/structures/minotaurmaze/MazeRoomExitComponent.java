// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MazeRoomExitComponent extends MazeRoomComponent
{
    public MazeRoomExitComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMRE, nbt);
    }
    
    public MazeRoomExitComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRE, feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.m_73441_(world, sbb, 5, -5, 5, 10, 0, 10, ((Block)TFBlocks.MAZESTONE_BRICK.get()).m_49966_(), MazeRoomExitComponent.AIR, false);
        this.m_73441_(world, sbb, 5, 1, 5, 10, 1, 10, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeRoomExitComponent.AIR, false);
        this.m_73441_(world, sbb, 5, 2, 5, 10, 3, 10, Blocks.f_50183_.m_49966_(), MazeRoomExitComponent.AIR, false);
        this.m_73441_(world, sbb, 5, 4, 5, 10, 4, 10, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeRoomExitComponent.AIR, false);
        this.m_73535_(world, sbb, 6, -5, 6, 9, 4, 9);
        return true;
    }
}
