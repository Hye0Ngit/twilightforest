// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class MazeUpperEntranceComponent extends TFStructureComponentOld
{
    public MazeUpperEntranceComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMUE, nbt);
    }
    
    public MazeUpperEntranceComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMUE, feature, i, x, y, z);
        this.m_73519_(Direction.Plane.HORIZONTAL.m_122560_(rand));
        this.f_73383_ = new BoundingBox(x, y, z, x + 15, y + 4, z + 15);
    }
    
    public void m_142537_(final StructurePiece structurecomponent, final StructurePieceAccessor list, final Random random) {
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73476_(world, sbb, rand, 0.7f, 0, 5, 0, 15, 5, 15, ((Block)TFBlocks.MAZESTONE.get()).m_49966_(), MazeUpperEntranceComponent.AIR, true, false);
        this.m_73441_(world, sbb, 0, 0, 0, 15, 0, 15, ((Block)TFBlocks.MAZESTONE_MOSAIC.get()).m_49966_(), MazeUpperEntranceComponent.AIR, false);
        this.m_73441_(world, sbb, 0, 1, 0, 15, 1, 15, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeUpperEntranceComponent.AIR, true);
        this.m_73441_(world, sbb, 0, 2, 0, 15, 3, 15, ((Block)TFBlocks.MAZESTONE_BRICK.get()).m_49966_(), MazeUpperEntranceComponent.AIR, true);
        this.m_73441_(world, sbb, 0, 4, 0, 15, 4, 15, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeUpperEntranceComponent.AIR, true);
        this.m_73476_(world, sbb, rand, 0.2f, 0, 0, 0, 15, 5, 15, Blocks.f_49994_.m_49966_(), MazeUpperEntranceComponent.AIR, true, false);
        this.m_73441_(world, sbb, 6, 1, 0, 9, 4, 0, Blocks.f_50132_.m_49966_(), MazeUpperEntranceComponent.AIR, false);
        this.m_73535_(world, sbb, 7, 1, 0, 8, 3, 0);
        this.m_73441_(world, sbb, 6, 1, 15, 9, 4, 15, Blocks.f_50132_.m_49966_(), MazeUpperEntranceComponent.AIR, false);
        this.m_73535_(world, sbb, 7, 1, 15, 8, 3, 15);
        this.m_73441_(world, sbb, 0, 1, 6, 0, 4, 9, Blocks.f_50132_.m_49966_(), MazeUpperEntranceComponent.AIR, false);
        this.m_73535_(world, sbb, 0, 1, 7, 0, 3, 8);
        this.m_73441_(world, sbb, 15, 1, 6, 15, 4, 9, Blocks.f_50132_.m_49966_(), MazeUpperEntranceComponent.AIR, false);
        this.m_73535_(world, sbb, 15, 1, 7, 15, 3, 8);
        this.m_73535_(world, sbb, 1, 1, 1, 14, 4, 14);
        this.m_73441_(world, sbb, 5, 1, 5, 10, 1, 10, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeUpperEntranceComponent.AIR, false);
        this.m_73441_(world, sbb, 5, 4, 5, 10, 4, 10, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeUpperEntranceComponent.AIR, false);
        this.m_73476_(world, sbb, rand, 0.7f, 5, 2, 5, 10, 3, 10, Blocks.f_50183_.m_49966_(), MazeUpperEntranceComponent.AIR, false, false);
        this.m_73535_(world, sbb, 6, 0, 6, 9, 4, 9);
        return true;
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BEARD;
    }
}
