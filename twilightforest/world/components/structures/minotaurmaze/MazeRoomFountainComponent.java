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

public class MazeRoomFountainComponent extends MazeRoomComponent
{
    public MazeRoomFountainComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMRF, nbt);
    }
    
    public MazeRoomFountainComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRF, feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.m_73441_(world, sbb, 5, 1, 5, 10, 1, 10, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeRoomFountainComponent.AIR, false);
        this.m_73441_(world, sbb, 6, 1, 6, 9, 1, 9, Blocks.f_49990_.m_49966_(), MazeRoomFountainComponent.AIR, false);
        return true;
    }
}
