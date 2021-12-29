// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.placements;

import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.ChunkPos;
import twilightforest.world.registration.TFFeature;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;

public class OutOfStructureFilter extends FeatureDecorator<StructureClearingConfig>
{
    public OutOfStructureFilter(final Codec<StructureClearingConfig> codec) {
        super((Codec)codec);
    }
    
    public Stream<BlockPos> getPositions(final DecorationContext worldDecoratingHelper, final Random random, final StructureClearingConfig config, final BlockPos blockPos) {
        final ChunkGenerator f_8328_ = worldDecoratingHelper.m_162168_().m_6018_().m_7726_().f_8328_;
        if (!(f_8328_ instanceof ChunkGeneratorTwilight)) {
            return Stream.of(blockPos);
        }
        final ChunkGeneratorTwilight tfChunkGen = (ChunkGeneratorTwilight)f_8328_;
        final BlockPos.MutableBlockPos featurePos = TFFeature.getNearestCenterXYZ(blockPos.m_123341_() >> 4, blockPos.m_123343_() >> 4).m_122032_();
        final TFFeature feature = tfChunkGen.getFeatureCached(new ChunkPos((BlockPos)featurePos), worldDecoratingHelper.m_162168_());
        if ((!config.occupiesSurface() || feature.surfaceDecorationsAllowed) && (!config.occupiesUnderground() || feature.undergroundDecoAllowed)) {
            return Stream.of(blockPos);
        }
        featurePos.m_122178_(Math.abs(featurePos.m_123341_() - blockPos.m_123341_()), 0, Math.abs(featurePos.m_123343_() - blockPos.m_123343_()));
        final int size = feature.size * 16 + config.additionalClearance();
        return (featurePos.m_123341_() < size && featurePos.m_123343_() < size) ? Stream.empty() : Stream.of(blockPos);
    }
}
