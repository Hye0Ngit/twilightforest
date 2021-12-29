// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

public class MazeRoomCollapseComponent extends MazeRoomComponent
{
    public MazeRoomCollapseComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMRC, nbt);
    }
    
    public MazeRoomCollapseComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRC, feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                int gravel = rand.nextInt(dist);
                final int root = rand.nextInt(dist);
                if (gravel > 0) {
                    ++gravel;
                    this.m_73441_(world, sbb, x, 1, z, x, gravel, z, Blocks.f_49994_.m_49966_(), MazeRoomCollapseComponent.AIR, false);
                    this.m_73535_(world, sbb, x, gravel, z, x, gravel + 5, z);
                }
                else if (root > 0) {
                    this.m_73441_(world, sbb, x, 5, z, x, 5 + root, z, Blocks.f_50493_.m_49966_(), MazeRoomCollapseComponent.AIR, true);
                    this.m_73441_(world, sbb, x, 5 - rand.nextInt(5), z, x, 5, z, ((Block)TFBlocks.ROOT_STRAND.get()).m_49966_(), MazeRoomCollapseComponent.AIR, false);
                }
                else if (rand.nextInt(dist + 1) > 0) {
                    this.m_73535_(world, sbb, x, 5, z, x, 5, z);
                }
            }
        }
        return true;
    }
}
