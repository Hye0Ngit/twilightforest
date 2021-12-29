// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
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
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class MazeRoomComponent extends TFStructureComponentOld
{
    public MazeRoomComponent(final ServerLevel level, final CompoundTag nbt) {
        this(MinotaurMazePieces.TFMMR, nbt);
    }
    
    public MazeRoomComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public MazeRoomComponent(final StructurePieceType type, final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(type, feature, i, x, y, z);
        this.m_73519_(Direction.Plane.HORIZONTAL.m_122560_(rand));
        this.f_73383_ = new BoundingBox(x, y, z, x + 15, y + 4, z + 15);
    }
    
    public void m_142537_(final StructurePiece structurecomponent, final StructurePieceAccessor list, final Random random) {
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73441_(world, sbb, 1, 0, 1, 14, 0, 14, ((Block)TFBlocks.MAZESTONE_BORDER.get()).m_49966_(), MazeRoomComponent.AIR, true);
        this.m_73441_(world, sbb, 2, 0, 2, 13, 0, 13, ((Block)TFBlocks.MAZESTONE_MOSAIC.get()).m_49966_(), MazeRoomComponent.AIR, true);
        if (this.m_73398_((BlockGetter)world, 7, 1, 0, sbb).m_60734_() == Blocks.f_50016_) {
            this.m_73441_(world, sbb, 6, 1, 0, 9, 4, 0, Blocks.f_50132_.m_49966_(), MazeRoomComponent.AIR, false);
            this.m_73535_(world, sbb, 7, 1, 0, 8, 3, 0);
        }
        if (this.m_73398_((BlockGetter)world, 7, 1, 15, sbb).m_60734_() == Blocks.f_50016_) {
            this.m_73441_(world, sbb, 6, 1, 15, 9, 4, 15, Blocks.f_50132_.m_49966_(), MazeRoomComponent.AIR, false);
            this.m_73535_(world, sbb, 7, 1, 15, 8, 3, 15);
        }
        if (this.m_73398_((BlockGetter)world, 0, 1, 7, sbb).m_60734_() == Blocks.f_50016_) {
            this.m_73441_(world, sbb, 0, 1, 6, 0, 4, 9, Blocks.f_50132_.m_49966_(), MazeRoomComponent.AIR, false);
            this.m_73535_(world, sbb, 0, 1, 7, 0, 3, 8);
        }
        if (this.m_73398_((BlockGetter)world, 15, 1, 7, sbb).m_60734_() == Blocks.f_50016_) {
            this.m_73441_(world, sbb, 15, 1, 6, 15, 4, 9, Blocks.f_50132_.m_49966_(), MazeRoomComponent.AIR, false);
            this.m_73535_(world, sbb, 15, 1, 7, 15, 3, 8);
        }
        return true;
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BURY;
    }
}
