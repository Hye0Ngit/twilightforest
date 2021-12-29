// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class MazeEntranceShaftComponent extends TFStructureComponentOld
{
    private int averageGroundLevel;
    
    public MazeEntranceShaftComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMES, nbt);
        this.averageGroundLevel = Integer.MIN_VALUE;
    }
    
    public MazeEntranceShaftComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMES, feature, i, new BoundingBox(x, y, z, x + 6 - 1, y, z + 6 - 1).m_162371_(new BlockPos(x, 0, z)));
        this.averageGroundLevel = Integer.MIN_VALUE;
        this.m_73519_(Direction.Plane.HORIZONTAL.m_122560_(rand));
    }
    
    public void m_142537_(final StructurePiece structurecomponent, final StructurePieceAccessor list, final Random random) {
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockPos.MutableBlockPos pos = chunkPosIn.m_45615_().m_122032_().m_142451_(this.f_73383_.m_162395_()).m_142443_(this.f_73383_.m_162398_());
        this.f_73383_.m_162371_((BlockPos)pos.m_142448_(generator.m_6337_() - 9));
        this.m_73441_(world, sbb, 0, 0, 0, 5, this.f_73383_.m_71057_(), 5, ((Block)TFBlocks.MAZESTONE_BRICK.get()).m_49966_(), MazeEntranceShaftComponent.AIR, true);
        this.m_73535_(world, sbb, 1, 0, 1, 4, this.f_73383_.m_71057_(), 4);
        return true;
    }
}
