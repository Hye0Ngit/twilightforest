// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFFeature;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public class TFBiomeDarkForestCenter extends TFBiomeDarkForest
{
    public TFBiomeDarkForestCenter(final Biome.BiomeProperties props) {
        super(props);
    }
    
    @Override
    public int func_180627_b(final BlockPos pos) {
        final double d0 = TFBiomeDarkForestCenter.field_180281_af.func_151601_a(pos.func_177958_n() * 0.0225, pos.func_177952_p() * 0.0225);
        return (d0 < -0.2) ? 6714688 : 5587220;
    }
    
    @Override
    public int func_180625_c(final BlockPos pos) {
        final double d0 = TFBiomeDarkForestCenter.field_180281_af.func_151601_a(pos.func_177958_n() * 0.0225, pos.func_177952_p() * 0.0225);
        return (d0 < -0.1) ? 16351774 : 15289876;
    }
    
    @Override
    protected ResourceLocation[] getRequiredAdvancements() {
        return new ResourceLocation[] { TwilightForestMod.prefix("progress_knights") };
    }
    
    @Override
    protected TFFeature getContainedFeature() {
        return TFFeature.DARK_TOWER;
    }
}
