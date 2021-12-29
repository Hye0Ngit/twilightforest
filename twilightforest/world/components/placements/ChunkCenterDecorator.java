// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.placements;

import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.NoneDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;

public class ChunkCenterDecorator extends FeatureDecorator<NoneDecoratorConfiguration>
{
    public ChunkCenterDecorator(final Codec<NoneDecoratorConfiguration> codec) {
        super((Codec)codec);
    }
    
    public Stream<BlockPos> getPositions(final DecorationContext pContext, final Random pRandom, final NoneDecoratorConfiguration pConfig, final BlockPos pos) {
        return Stream.of(new BlockPos((pos.m_123341_() & 0xFFFFFFF0) + 8, pos.m_123342_(), (pos.m_123343_() & 0xFFFFFFF0) + 8));
    }
}
