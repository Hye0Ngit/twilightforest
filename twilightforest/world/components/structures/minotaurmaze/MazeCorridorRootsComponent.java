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
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MazeCorridorRootsComponent extends MazeCorridorComponent
{
    public MazeCorridorRootsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMCR, nbt);
    }
    
    public MazeCorridorRootsComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMCR, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                final int freq = x;
                if (rand.nextInt(freq + 2) > 0) {
                    final int length = rand.nextInt(6);
                    this.m_73434_(world, Blocks.f_50493_.m_49966_(), x, 6, z, sbb);
                    for (int y = 6 - length; y < 6; ++y) {
                        this.m_73434_(world, ((Block)TFBlocks.ROOT_STRAND.get()).m_49966_(), x, y, z, sbb);
                    }
                    if (rand.nextInt(freq + 1) > 1) {
                        this.m_73434_(world, Blocks.f_49994_.m_49966_(), x, 1, z, sbb);
                        if (rand.nextInt(freq + 1) > 1) {
                            this.m_73434_(world, Blocks.f_49994_.m_49966_(), x, 2, z, sbb);
                        }
                    }
                }
            }
        }
        return true;
    }
}
