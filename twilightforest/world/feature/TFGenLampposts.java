// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenLampposts extends Feature<BlockStateFeatureConfig>
{
    private static final Rotation[] ROTATIONS;
    
    public TFGenLampposts(final Codec<BlockStateFeatureConfig> configIn) {
        super((Codec)configIn);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final BlockStateFeatureConfig config) {
        if (world.func_180495_p(pos.func_177977_b()).func_177230_c() != Blocks.field_196658_i) {
            return false;
        }
        final int height = 1 + rand.nextInt(4);
        for (int dy = 0; dy <= height; ++dy) {
            final BlockState state = world.func_180495_p(pos.func_177981_b(dy));
            if (!state.func_177230_c().isAir(state, (IBlockReader)world, pos.func_177981_b(dy)) && !state.func_185904_a().func_76222_j()) {
                return false;
            }
        }
        for (int dy = 0; dy < height; ++dy) {
            world.func_180501_a(pos.func_177981_b(dy), ((Block)TFBlocks.canopy_fence.get()).func_176223_P(), 18);
        }
        world.func_180501_a(pos.func_177981_b(height), config.field_227270_a_.func_185907_a(TFGenLampposts.ROTATIONS[rand.nextInt(TFGenLampposts.ROTATIONS.length)]), 18);
        return true;
    }
    
    static {
        ROTATIONS = Rotation.values();
    }
}
