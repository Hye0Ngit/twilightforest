// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.surfacebuilders;

import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import twilightforest.world.ChunkGeneratorTwilightBase;
import twilightforest.world.TFGenerationSettings;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import java.util.Random;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class TFDefaultSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig>
{
    public TFDefaultSurfaceBuilder(final Codec<SurfaceBuilderConfig> config) {
        super((Codec)config);
    }
    
    public void buildSurface(final Random rand, final IChunk primer, final Biome biome, final int x, final int z, final int startheight, final double noiseVal, final BlockState defaultBlock, final BlockState defaultFluid, final int sealevel, final long seed, final SurfaceBuilderConfig config) {
        this.genTwilightBiomeTerrain(rand, primer, biome, x, z, startheight, noiseVal, defaultBlock, defaultFluid, config.func_204108_a(), config.func_204109_b(), config.func_204110_c(), sealevel);
    }
    
    protected void genTwilightBiomeTerrain(final Random rand, final IChunk primer, final Biome biome, final int x, final int z, final int startHeight, final double noiseVal, final BlockState defaultBlock, final BlockState defaultFluid, final BlockState top, final BlockState middle, final BlockState bottom, final int sealevel) {
        BlockState topState = top;
        BlockState middleState = middle;
        int generatedDirtDepth = -1;
        final int dirtDepth = (int)(noiseVal / 3.0 + 3.0 + rand.nextDouble() * 0.25);
        final int localX = x & 0xF;
        final int localZ = z & 0xF;
        final BlockPos.Mutable mutable = new BlockPos.Mutable();
        final boolean generateBedrock = true;
        for (int y = startHeight; y >= 0; --y) {
            mutable.func_181079_c(localX, y, localZ);
            if (generateBedrock && y <= rand.nextInt(5)) {
                primer.func_177436_a((BlockPos)mutable, Blocks.field_150357_h.func_176223_P(), false);
            }
            else {
                final BlockState stateHere = primer.func_180495_p((BlockPos)mutable);
                if (stateHere.func_177230_c() != Blocks.field_150350_a) {
                    if (stateHere.func_177230_c() == Blocks.field_150348_b) {
                        if (generatedDirtDepth == -1) {
                            if (dirtDepth <= 0) {
                                topState = Blocks.field_150350_a.func_176223_P();
                                middleState = defaultBlock;
                            }
                            else if (y >= sealevel - 4 && y <= sealevel + 1) {
                                topState = top;
                                middleState = middle;
                            }
                            if (y < sealevel && (topState == null || topState.func_177230_c() == Blocks.field_150350_a)) {
                                if (biome.func_225486_c((BlockPos)mutable.func_181079_c(x, y, z)) < 0.15f) {
                                    topState = Blocks.field_150432_aD.func_176223_P();
                                }
                                else {
                                    topState = defaultFluid;
                                }
                                mutable.func_181079_c(localZ, y, localX);
                            }
                            generatedDirtDepth = dirtDepth;
                            if (y >= sealevel - 1) {
                                primer.func_177436_a((BlockPos)mutable, topState, false);
                            }
                            else if (y < sealevel - 7 - dirtDepth) {
                                topState = Blocks.field_150350_a.func_176223_P();
                                middleState = defaultBlock;
                                primer.func_177436_a((BlockPos)mutable, bottom, false);
                            }
                            else {
                                primer.func_177436_a((BlockPos)mutable, middleState, false);
                            }
                        }
                        else if (generatedDirtDepth > 0) {
                            --generatedDirtDepth;
                            primer.func_177436_a((BlockPos)mutable, middleState, false);
                            if (generatedDirtDepth == 0 && middleState.func_177230_c() == Blocks.field_150354_m) {
                                generatedDirtDepth = rand.nextInt(4) + Math.max(0, y - 63);
                                middleState = ((middleState == Blocks.field_196611_F.func_176223_P()) ? Blocks.field_180395_cM.func_176223_P() : Blocks.field_150322_A.func_176223_P());
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static boolean shouldGenerateBedrock(final World world) {
        final ChunkGeneratorTwilightBase generator = TFGenerationSettings.getChunkGenerator(world);
        return generator == null || generator.shouldGenerateBedrock();
    }
}
