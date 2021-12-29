// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.IWorld;
import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import twilightforest.world.feature.config.CaveStalactiteConfig;
import com.mojang.serialization.Codec;

public class TFGenOutsideStalagmite extends TFGenCaveStalactite
{
    public TFGenOutsideStalagmite(final Codec<CaveStalactiteConfig> configIn) {
        super(configIn);
    }
    
    @Override
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final CaveStalactiteConfig config) {
        final int length = rand.nextInt(10) + 5;
        return FeatureUtil.isAreaSuitable((IWorld)world, pos, 1, length, 1) && this.makeSpike((IWorld)world, rand, pos.func_177977_b(), length, config);
    }
}
