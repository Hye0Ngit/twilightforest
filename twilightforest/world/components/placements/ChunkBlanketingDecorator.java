// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.placements;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;
import net.minecraft.resources.ResourceLocation;
import java.util.ArrayList;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;

public class ChunkBlanketingDecorator extends FeatureDecorator<ChunkBlanketingConfig>
{
    public ChunkBlanketingDecorator(final Codec<ChunkBlanketingConfig> codec) {
        super((Codec)codec);
    }
    
    public Stream<BlockPos> getPositions(final DecorationContext context, final Random random, final ChunkBlanketingConfig config, final BlockPos placement) {
        final int chunkOriginX = placement.m_123341_() & 0xFFFFFFF0;
        final int chunkOriginZ = placement.m_123343_() & 0xFFFFFFF0;
        final ArrayList<BlockPos> coordinates = new ArrayList<BlockPos>();
        for (int zInChunk = 0; zInChunk < 16; ++zInChunk) {
            for (int xInChunk = 0; xInChunk < 16; ++xInChunk) {
                if (random.nextFloat() <= config.integrity) {
                    final BlockPos pos = new BlockPos(chunkOriginX + xInChunk, context.m_70590_(config.heightmap, chunkOriginX + xInChunk, chunkOriginZ + zInChunk), chunkOriginZ + zInChunk);
                    if (config.biomeRLOptional.isPresent()) {
                        if (config.biomeRLOptional.get().equals((Object)context.m_162168_().m_46857_(pos).getRegistryName())) {
                            coordinates.add(pos);
                        }
                    }
                    else {
                        coordinates.add(pos);
                    }
                }
            }
        }
        return coordinates.stream();
    }
    
    public static class ChunkBlanketingConfig implements DecoratorConfiguration
    {
        public static final Codec<ChunkBlanketingConfig> CODEC;
        public final float integrity;
        public final Heightmap.Types heightmap;
        public final Optional<ResourceLocation> biomeRLOptional;
        
        public ChunkBlanketingConfig(final float integrity, final Heightmap.Types heightmap, final Optional<ResourceLocation> biomeRLOptional) {
            this.integrity = integrity;
            this.heightmap = heightmap;
            this.biomeRLOptional = biomeRLOptional;
        }
        
        static {
            CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.floatRange(0.0f, 1.0f).fieldOf("integrity").forGetter(o -> o.integrity), (App)Heightmap.Types.f_64274_.fieldOf("heightmap").forGetter(o -> o.heightmap), (App)ResourceLocation.f_135803_.optionalFieldOf("biome_lock").forGetter(o -> o.biomeRLOptional)).apply((Applicative)instance, ChunkBlanketingConfig::new));
        }
    }
}
