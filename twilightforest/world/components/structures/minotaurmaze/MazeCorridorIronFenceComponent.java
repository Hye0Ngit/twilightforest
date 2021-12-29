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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MazeCorridorIronFenceComponent extends MazeCorridorComponent
{
    public MazeCorridorIronFenceComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMCIF, nbt);
    }
    
    public MazeCorridorIronFenceComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMCIF, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73441_(world, sbb, 1, 4, 2, 4, 4, 3, ((Block)TFBlocks.DECORATIVE_MAZESTONE.get()).m_49966_(), MazeCorridorIronFenceComponent.AIR, false);
        this.m_73441_(world, sbb, 1, 1, 2, 4, 3, 3, ((Block)TFBlocks.CUT_MAZESTONE.get()).m_49966_(), MazeCorridorIronFenceComponent.AIR, false);
        this.m_73441_(world, sbb, 2, 1, 2, 3, 3, 3, Blocks.f_50183_.m_49966_(), Blocks.f_50016_.m_49966_(), false);
        return true;
    }
}
