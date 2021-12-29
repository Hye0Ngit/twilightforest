// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.surfacebuilders;

import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import twilightforest.worldgen.BlockConstants;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import java.util.Random;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class TFPlateauSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig>
{
    public TFPlateauSurfaceBuilder(final Codec<SurfaceBuilderConfig> config) {
        super((Codec)config);
    }
    
    public void buildSurface(final Random rand, final IChunk primer, final Biome biome, final int x, final int z, final int startheight, final double noiseVal, final BlockState defaultBlock, final BlockState defaultFluid, final int sealevel, final long seed, final SurfaceBuilderConfig config) {
        this.genTwilightBiomeTerrain(rand, primer, biome, x, z, startheight, noiseVal, defaultBlock, defaultFluid, config.func_204108_a(), config.func_204109_b(), config.func_204110_c(), sealevel);
    }
    
    protected void genTwilightBiomeTerrain(final Random random, final IChunk chunkIn, final Biome biomeIn, final int x, final int z, final int startHeight, final double noise, final BlockState defaultBlock, final BlockState defaultFluid, final BlockState top, final BlockState middle, final BlockState bottom, final int sealevel) {
        BlockState blockstate = top;
        BlockState blockstate2 = middle;
        final BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        int i = -1;
        final int j = (int)(noise / 3.0 + 3.0 + random.nextDouble() * 0.25);
        final int k = x & 0xF;
        final int l = z & 0xF;
        for (int i2 = startHeight; i2 >= 0; --i2) {
            blockpos$mutable.func_181079_c(k, i2, l);
            final BlockState blockstate3 = chunkIn.func_180495_p((BlockPos)blockpos$mutable);
            if (blockstate3.func_196958_f()) {
                i = -1;
            }
            else if (blockstate3.func_203425_a(defaultBlock.func_177230_c())) {
                if (!chunkIn.func_180495_p((BlockPos)blockpos$mutable).func_203425_a((Block)TFBlocks.deadrock_weathered.get()) || !chunkIn.func_180495_p((BlockPos)blockpos$mutable).func_203425_a((Block)TFBlocks.deadrock_cracked.get())) {
                    chunkIn.func_177436_a((BlockPos)blockpos$mutable, BlockConstants.DEADROCK, false);
                }
                if (i == -1) {
                    if (j <= 0) {
                        blockstate = Blocks.field_150350_a.func_176223_P();
                        blockstate2 = defaultBlock;
                    }
                    else if (i2 >= sealevel - 4 && i2 <= sealevel + 1) {
                        blockstate = top;
                        blockstate2 = middle;
                    }
                    if (i2 < sealevel && (blockstate == null || blockstate.func_196958_f())) {
                        if (biomeIn.func_225486_c((BlockPos)blockpos$mutable.func_181079_c(x, i2, z)) < 0.15f) {
                            blockstate = Blocks.field_150432_aD.func_176223_P();
                        }
                        else {
                            blockstate = defaultFluid;
                        }
                        blockpos$mutable.func_181079_c(k, i2, l);
                    }
                    i = j;
                    if (i2 >= sealevel - 1) {
                        chunkIn.func_177436_a((BlockPos)blockpos$mutable, blockstate, false);
                    }
                    else if (i2 < sealevel - 7 - j) {
                        blockstate = Blocks.field_150350_a.func_176223_P();
                        blockstate2 = defaultBlock;
                        chunkIn.func_177436_a((BlockPos)blockpos$mutable, bottom, false);
                    }
                    else {
                        chunkIn.func_177436_a((BlockPos)blockpos$mutable, blockstate2, false);
                    }
                }
                else if (i > 0) {
                    --i;
                    chunkIn.func_177436_a((BlockPos)blockpos$mutable, blockstate2, false);
                    if (i == 0 && blockstate2.func_203425_a(Blocks.field_150354_m) && j > 1) {
                        i = random.nextInt(4) + Math.max(0, i2 - 63);
                        blockstate2 = (blockstate2.func_203425_a(Blocks.field_196611_F) ? Blocks.field_180395_cM.func_176223_P() : Blocks.field_150322_A.func_176223_P());
                    }
                }
            }
        }
    }
}
