// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.surfacebuilders;

import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import java.util.Random;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import com.mojang.serialization.Codec;

public class TFHighlandsSurfaceBuilder extends TFDefaultSurfaceBuilder
{
    public TFHighlandsSurfaceBuilder(final Codec<SurfaceBuilderConfig> config) {
        super(config);
    }
    
    @Override
    public void buildSurface(final Random rand, final IChunk primer, final Biome biome, final int x, final int z, final int startheight, final double noiseVal, final BlockState defaultBlock, final BlockState defaultFluid, final int sealevel, final long seed, final SurfaceBuilderConfig config) {
        BlockState topBlock = config.func_204108_a();
        final BlockState fillerBlock = config.func_204109_b();
        if (noiseVal > 1.75) {
            topBlock = Blocks.field_196660_k.func_176223_P();
        }
        else if (noiseVal > -0.95) {
            topBlock = Blocks.field_196661_l.func_176223_P();
        }
        this.genTwilightBiomeTerrain(rand, primer, biome, x, z, startheight, noiseVal, defaultBlock, defaultFluid, topBlock, fillerBlock, config.func_204110_c(), sealevel);
    }
}
