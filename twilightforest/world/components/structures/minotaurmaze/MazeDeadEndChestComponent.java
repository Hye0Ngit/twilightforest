// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.loot.TFTreasure;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.block.Blocks;
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

public class MazeDeadEndChestComponent extends MazeDeadEndComponent
{
    public MazeDeadEndChestComponent(final ServerLevel level, final CompoundTag nbt) {
        this(MinotaurMazePieces.TFMMDEC, nbt);
    }
    
    public MazeDeadEndChestComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public MazeDeadEndChestComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(type, feature, i, x, y, z, rotation);
        this.m_73519_(rotation);
        this.spawnListIndex = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73434_(world, Blocks.f_50705_.m_49966_(), 2, 1, 4, sbb);
        this.m_73434_(world, Blocks.f_50705_.m_49966_(), 3, 1, 4, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(Blocks.f_50086_.m_49966_(), Direction.NORTH, false), 2, 1, 3, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(Blocks.f_50086_.m_49966_(), Direction.NORTH, false), 3, 1, 3, sbb);
        this.setDoubleLootChest(world, 2, 2, 4, 3, 2, 4, Direction.SOUTH, TFTreasure.LABYRINTH_DEAD_END, sbb, false);
        this.m_73441_(world, sbb, 1, 1, 0, 4, 3, 1, ((Block)TFBlocks.CUT_MAZESTONE.get()).m_49966_(), MazeDeadEndChestComponent.AIR, false);
        this.m_73441_(world, sbb, 1, 4, 0, 4, 4, 1, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeDeadEndChestComponent.AIR, false);
        this.m_73441_(world, sbb, 2, 1, 0, 3, 3, 1, Blocks.f_50183_.m_49966_(), MazeDeadEndChestComponent.AIR, false);
        return true;
    }
}
