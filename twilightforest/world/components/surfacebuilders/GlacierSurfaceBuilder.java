// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.surfacebuilders;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import java.util.function.Supplier;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import java.util.Random;
import com.mojang.serialization.Codec;

public class GlacierSurfaceBuilder extends DelegatingSurfaceBuilder<GlacierSurfaceConfig>
{
    public GlacierSurfaceBuilder(final Codec<GlacierSurfaceConfig> config) {
        super(config);
    }
    
    public void apply(final Random random, final ChunkAccess chunkIn, final Biome biomeIn, final int x, final int z, final int startHeight, final double noise, final BlockState defaultBlock, final BlockState defaultFluid, final int seaLevel, final int minSurfaceLevel, final long seed, final GlacierSurfaceConfig config) {
        config.surfaceBuilder.m_163848_(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed);
        final int oceanFloorHeight = chunkIn.m_5885_(Heightmap.Types.OCEAN_FLOOR_WG, x, z);
        final int depthStart = Math.min(startHeight, oceanFloorHeight);
        final int targetHeight = Math.max(seaLevel, oceanFloorHeight) + config.mainHeight;
        final BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos(x, depthStart, z);
        for (int y = depthStart; y < targetHeight; ++y) {
            chunkIn.m_6978_((BlockPos)mutablePos.m_142448_(y), config.mainState, false);
        }
        for (int y = 0; y < config.topHeight; ++y) {
            chunkIn.m_6978_((BlockPos)mutablePos.m_122184_(0, 1, 0), config.topState, false);
        }
    }
    
    public static class GlacierSurfaceConfig extends DelegatingConfig
    {
        public static Codec<GlacierSurfaceConfig> CODEC;
        private final int mainHeight;
        private final int topHeight;
        private final BlockState mainState;
        private final BlockState topState;
        
        public GlacierSurfaceConfig(final Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier, final int mainHeight, final int topHeight, final BlockState mainState, final BlockState topState) {
            super(configuredSurfaceBuilderSupplier);
            this.mainHeight = mainHeight;
            this.topHeight = topHeight;
            this.mainState = mainState;
            this.topState = topState;
        }
        
        static {
            GlacierSurfaceConfig.CODEC = (Codec<GlacierSurfaceConfig>)RecordCodecBuilder.create(instance -> DelegatingConfig.startCodec((RecordCodecBuilder.Instance<DelegatingConfig>)instance).and(instance.group((App)Codec.intRange(1, 64).fieldOf("main_thickness").forGetter(o -> o.mainHeight), (App)Codec.intRange(1, 16).fieldOf("top_thickness").forGetter(o -> o.topHeight), (App)BlockState.f_61039_.fieldOf("main_state").forGetter(o -> o.mainState), (App)BlockState.f_61039_.fieldOf("top_state").forGetter(o -> o.topState))).apply((Applicative)instance, GlacierSurfaceConfig::new));
        }
    }
}
