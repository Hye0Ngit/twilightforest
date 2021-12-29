// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import net.minecraft.util.Mth;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class HydraLairComponent extends HollowHillComponent
{
    public HydraLairComponent(final ServerLevel level, final CompoundTag nbt) {
        super(TFFeature.TFHydra, nbt);
    }
    
    public HydraLairComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z) {
        super(TFFeature.TFHydra, feature, i, 2, x, y + 2, z);
    }
    
    public void m_142537_(final StructurePiece structurecomponent, final StructurePieceAccessor accessor, final Random random) {
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int stalacts = 64;
        final int stalags = 8;
        for (int i = 0; i < stalacts; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomCeilingCoordinates(rand, (float)this.radius);
            this.generateOreStalactite(world, (Vec3i)dest.m_122184_(0, 1, 0), sbb);
        }
        for (int i = 0; i < stalacts; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomCeilingCoordinates(rand, (float)this.radius);
            this.generateBlockSpike(world, HydraLairComponent.STONE_STALACTITE, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), sbb);
        }
        for (int i = 0; i < stalags; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomFloorCoordinates(rand, (float)this.radius);
            this.generateBlockSpike(world, HydraLairComponent.STONE_STALAGMITE, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), sbb);
        }
        this.m_73434_(world, ((Block)TFBlocks.HYDRA_BOSS_SPAWNER.get()).m_49966_(), 27, 3, 27, sbb);
        return true;
    }
    
    @Override
    BlockPos.MutableBlockPos randomFloorCoordinates(final Random rand, final float maximumRadius) {
        final float degree = rand.nextFloat() * 4.537856f + 1.7453294f;
        final float radius = maximumRadius * 0.9f * (rand.nextFloat() * 0.35f + 0.65f);
        final float dist = Mth.m_14116_(radius * radius);
        final float height = 4.0f - Mth.m_14089_(dist / this.hdiam * 3.1415927f) * (this.hdiam / 20.0f);
        return new BlockPos.MutableBlockPos((double)(maximumRadius - Mth.m_14089_(degree) * radius), (double)height, (double)(maximumRadius - Mth.m_14031_(degree) * radius));
    }
    
    @Override
    BlockPos.MutableBlockPos randomCeilingCoordinates(final Random rand, final float maximumRadius) {
        final float degree = rand.nextFloat() * 4.537856f + 1.7453294f;
        final float radius = rand.nextFloat() * 0.9f * maximumRadius;
        final float dist = Mth.m_14116_(radius * radius);
        final float height = Mth.m_14089_(dist / this.hdiam * 3.1415927f) * (this.hdiam / 4.0f);
        return new BlockPos.MutableBlockPos((double)(maximumRadius - Mth.m_14089_(degree) * radius), (double)height, (double)(maximumRadius - Mth.m_14031_(degree) * radius));
    }
}
