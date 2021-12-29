// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
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
import twilightforest.world.components.feature.config.SpikeConfig;

public class YetiCaveComponent extends HollowHillComponent
{
    private static final SpikeConfig BLUE_ICE_SPIKE;
    private static final SpikeConfig PACKED_ICE_SPIKE;
    private static final SpikeConfig ICE_SPIKE;
    
    public YetiCaveComponent(final ServerLevel level, final CompoundTag nbt) {
        super(TFFeature.TFYeti, nbt);
    }
    
    public YetiCaveComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z) {
        super(TFFeature.TFYeti, feature, i, 2, x, y, z);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int sn = 64;
        for (int i = 0; i < sn; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomCeilingCoordinates(rand, 24.0f);
            this.generateBlockSpike(world, YetiCaveComponent.BLUE_ICE_SPIKE, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomCeilingCoordinates(rand, 24.0f);
            this.generateBlockSpike(world, YetiCaveComponent.PACKED_ICE_SPIKE, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomCeilingCoordinates(rand, 24.0f);
            this.generateBlockSpike(world, YetiCaveComponent.ICE_SPIKE, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomCeilingCoordinates(rand, 24.0f);
            this.generateBlockSpike(world, YetiCaveComponent.STONE_STALACTITE, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), sbb);
        }
        final BlockState yetiSpawner = ((Block)TFBlocks.ALPHA_YETI_BOSS_SPAWNER.get()).m_49966_();
        this.setBlockStateRotated(world, yetiSpawner, this.radius, 1, this.radius, Rotation.NONE, sbb);
        return true;
    }
    
    @Override
    boolean isInHill(final int cx, final int cz) {
        return cx < this.radius * 2 && cx > 0 && cz < this.radius * 2 && cz > 0;
    }
    
    @Override
    BlockPos.MutableBlockPos randomCeilingCoordinates(final Random rand, final float maximumRadius) {
        final int rad = (int)maximumRadius;
        final int x = rand.nextInt(rad * 2) - rad;
        final int z = rand.nextInt(rad * 2) - rad;
        final int dist = Math.min(Math.abs(x), Math.abs(z));
        return new BlockPos.MutableBlockPos(this.radius + x, 17 - dist / 6, this.radius + z);
    }
    
    static {
        BLUE_ICE_SPIKE = new SpikeConfig((BlockStateProvider)new SimpleStateProvider(Blocks.f_50568_.m_49966_()), (IntProvider)UniformInt.m_146622_(8, 8), (IntProvider)ConstantInt.m_146483_(4), true);
        PACKED_ICE_SPIKE = new SpikeConfig((BlockStateProvider)new SimpleStateProvider(Blocks.f_50354_.m_49966_()), (IntProvider)UniformInt.m_146622_(5, 9), (IntProvider)ConstantInt.m_146483_(4), true);
        ICE_SPIKE = new SpikeConfig((BlockStateProvider)new SimpleStateProvider(Blocks.f_50126_.m_49966_()), (IntProvider)UniformInt.m_146622_(6, 10), (IntProvider)ConstantInt.m_146483_(4), true);
    }
}
