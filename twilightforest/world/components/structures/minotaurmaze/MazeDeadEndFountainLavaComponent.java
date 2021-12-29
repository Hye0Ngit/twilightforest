// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

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

public class MazeDeadEndFountainLavaComponent extends MazeDeadEndFountainComponent
{
    public MazeDeadEndFountainLavaComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMDEFL, nbt);
    }
    
    public MazeDeadEndFountainLavaComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMDEFL, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.m_73434_(world, MazeDeadEndFountainLavaComponent.AIR, 2, 3, 4, sbb);
        this.m_73434_(world, MazeDeadEndFountainLavaComponent.AIR, 3, 3, 4, sbb);
        this.m_73434_(world, Blocks.f_49991_.m_49966_(), 2, 3, 4, sbb);
        this.m_73434_(world, Blocks.f_49991_.m_49966_(), 3, 3, 4, sbb);
        return true;
    }
}
