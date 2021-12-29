// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorld;
import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenStoneCircle extends Feature<NoFeatureConfig>
{
    public TFGenStoneCircle(final Codec<NoFeatureConfig> configIn) {
        super((Codec)configIn);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        if (!FeatureUtil.isAreaSuitable((IWorld)world, pos.func_177982_a(-3, 0, -3), 6, 4, 6)) {
            return false;
        }
        final BlockState mossyCobble = Blocks.field_150341_Y.func_176223_P();
        for (int cy = 0; cy <= 2; ++cy) {
            world.func_180501_a(pos.func_177982_a(-3, cy, 0), mossyCobble, 3);
            world.func_180501_a(pos.func_177982_a(3, cy, 0), mossyCobble, 3);
            world.func_180501_a(pos.func_177982_a(0, cy, -3), mossyCobble, 3);
            world.func_180501_a(pos.func_177982_a(0, cy, 3), mossyCobble, 3);
            world.func_180501_a(pos.func_177982_a(-2, cy, -2), mossyCobble, 3);
            world.func_180501_a(pos.func_177982_a(2, cy, -2), mossyCobble, 3);
            world.func_180501_a(pos.func_177982_a(-2, cy, 2), mossyCobble, 3);
            world.func_180501_a(pos.func_177982_a(2, cy, 2), mossyCobble, 3);
        }
        return true;
    }
}
