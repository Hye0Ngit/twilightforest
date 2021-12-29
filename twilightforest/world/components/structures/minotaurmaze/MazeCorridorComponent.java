// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class MazeCorridorComponent extends TFStructureComponentOld
{
    public MazeCorridorComponent(final ServerLevel level, final CompoundTag nbt) {
        this(MinotaurMazePieces.TFMMC, nbt);
    }
    
    public MazeCorridorComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public MazeCorridorComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(type, feature, i, x, y, z);
        this.m_73519_(rotation);
        this.f_73383_ = new BoundingBox(x, y, z, x + 5, y + 5, z + 5);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73441_(world, sbb, 1, 1, 2, 4, 4, 3, Blocks.f_50132_.m_49966_(), MazeCorridorComponent.AIR, false);
        this.m_73535_(world, sbb, 2, 1, 2, 3, 3, 3);
        return true;
    }
}
