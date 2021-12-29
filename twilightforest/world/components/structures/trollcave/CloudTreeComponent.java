// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.trollcave;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
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
import twilightforest.world.components.structures.TFStructureComponentOld;

public class CloudTreeComponent extends TFStructureComponentOld
{
    public CloudTreeComponent(final ServerLevel level, final CompoundTag nbt) {
        super(TrollCavePieces.TFClTr, nbt);
    }
    
    public CloudTreeComponent(final TFFeature feature, final int index, int x, int y, int z) {
        super(TrollCavePieces.TFClTr, feature, index, x, y, z);
        this.m_73519_(Direction.SOUTH);
        x = x >> 2 << 2;
        y = y >> 2 << 2;
        z = z >> 2 << 2;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 20, 28, 20, Direction.SOUTH);
        this.spawnListIndex = 1;
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73441_(world, sbb, 0, 12, 0, 19, 19, 19, ((Block)TFBlocks.GIANT_LEAVES.get()).m_49966_(), ((Block)TFBlocks.GIANT_LEAVES.get()).m_49966_(), false);
        this.m_73441_(world, sbb, 4, 20, 4, 15, 23, 15, ((Block)TFBlocks.GIANT_LEAVES.get()).m_49966_(), ((Block)TFBlocks.GIANT_LEAVES.get()).m_49966_(), false);
        this.m_73441_(world, sbb, 8, 24, 4, 11, 27, 15, ((Block)TFBlocks.GIANT_LEAVES.get()).m_49966_(), ((Block)TFBlocks.GIANT_LEAVES.get()).m_49966_(), false);
        this.m_73441_(world, sbb, 4, 24, 8, 15, 27, 11, ((Block)TFBlocks.GIANT_LEAVES.get()).m_49966_(), ((Block)TFBlocks.GIANT_LEAVES.get()).m_49966_(), false);
        this.m_73441_(world, sbb, 8, 0, 8, 11, 23, 11, ((Block)TFBlocks.GIANT_LOG.get()).m_49966_(), ((Block)TFBlocks.GIANT_LOG.get()).m_49966_(), false);
        this.m_73441_(world, sbb, 8, -4, 8, 11, -1, 11, ((Block)TFBlocks.FLUFFY_CLOUD.get()).m_49966_(), ((Block)TFBlocks.FLUFFY_CLOUD.get()).m_49966_(), false);
        return true;
    }
}
