// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.material.Material;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenHugeWaterLily extends Feature<NoFeatureConfig>
{
    public TFGenHugeWaterLily(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random random, final BlockPos pos, final NoFeatureConfig config) {
        for (int i = 0; i < 4; ++i) {
            final BlockPos pos_ = pos.func_177982_a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (this.shouldPlacePadAt((IWorld)world, pos_)) {
                world.func_180501_a(pos_, ((Block)TFBlocks.huge_waterlily.get()).func_176223_P(), 18);
            }
        }
        return true;
    }
    
    private boolean shouldPlacePadAt(final IWorld world, final BlockPos pos) {
        return world.func_175623_d(pos) && world.func_180495_p(pos.func_177977_b()).func_185904_a() == Material.field_151586_h;
    }
}
