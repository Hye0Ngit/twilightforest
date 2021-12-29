// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.IWorldReader;
import twilightforest.block.TFPlantBlock;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenPlantRoots extends Feature<NoFeatureConfig>
{
    public TFGenPlantRoots(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random random, BlockPos pos, final NoFeatureConfig config) {
        final int copyX = pos.func_177958_n();
        final int copyZ = pos.func_177952_p();
        while (pos.func_177956_o() > 5) {
            if (world.func_175623_d(pos) && TFPlantBlock.canPlaceRootAt((IWorldReader)world, pos) && random.nextInt(6) > 0) {
                world.func_180501_a(pos, ((Block)TFBlocks.root_strand.get()).func_176223_P(), 18);
            }
            else {
                pos = new BlockPos(copyX + random.nextInt(4) - random.nextInt(4), pos.func_177956_o(), copyZ + random.nextInt(4) - random.nextInt(4));
            }
            pos = pos.func_177977_b();
        }
        return true;
    }
}
