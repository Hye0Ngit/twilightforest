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
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MazeDeadEndFountainComponent extends MazeDeadEndComponent
{
    public MazeDeadEndFountainComponent(final ServerLevel level, final CompoundTag nbt) {
        this(MinotaurMazePieces.TFMMDEF, nbt);
    }
    
    public MazeDeadEndFountainComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public MazeDeadEndFountainComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(type, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.m_73441_(world, sbb, 1, 1, 4, 4, 4, 4, ((Block)TFBlocks.MAZESTONE_BRICK.get()).m_49966_(), MazeDeadEndFountainComponent.AIR, false);
        this.m_73434_(world, Blocks.f_49990_.m_49966_(), 2, 3, 4, sbb);
        this.m_73434_(world, Blocks.f_49990_.m_49966_(), 3, 3, 4, sbb);
        this.m_73434_(world, MazeDeadEndFountainComponent.AIR, 2, 0, 3, sbb);
        this.m_73434_(world, MazeDeadEndFountainComponent.AIR, 3, 0, 3, sbb);
        return true;
    }
}
