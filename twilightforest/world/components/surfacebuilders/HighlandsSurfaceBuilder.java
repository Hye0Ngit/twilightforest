// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.surfacebuilders;

import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import java.util.Random;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.surfacebuilders.DefaultSurfaceBuilder;

public class HighlandsSurfaceBuilder extends DefaultSurfaceBuilder
{
    public HighlandsSurfaceBuilder(final Codec<SurfaceBuilderBaseConfiguration> config) {
        super((Codec)config);
    }
    
    public void m_142263_(final Random rand, final ChunkAccess primer, final Biome biome, final int x, final int z, final int startheight, final double noiseVal, final BlockState defaultBlock, final BlockState defaultFluid, final int sealevel, final int minSurfaceLevel, final long seed, final SurfaceBuilderBaseConfiguration config) {
        BlockState topBlock = config.m_6743_();
        if (noiseVal > 1.75) {
            topBlock = Blocks.f_50546_.m_49966_();
        }
        else if (noiseVal > -0.95) {
            topBlock = Blocks.f_50599_.m_49966_();
        }
        this.m_163918_(rand, primer, biome, x, z, startheight, noiseVal, defaultBlock, defaultFluid, topBlock, config.m_6744_(), config.m_142434_(), sealevel, minSurfaceLevel);
    }
}
