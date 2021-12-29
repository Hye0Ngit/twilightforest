// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TwilightForestMod;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFDimensions
{
    public static long seed;
    
    public static void init() {
        Registry.func_218322_a(Registry.field_239689_aA_, TwilightForestMod.prefix("smart_distribution"), (Object)TFBiomeDistributor.TF_CODEC);
        Registry.func_218322_a(Registry.field_239689_aA_, TwilightForestMod.prefix("grid"), (Object)TFBiomeProvider.TF_CODEC);
        Registry.func_218322_a(Registry.field_239690_aB_, TwilightForestMod.prefix("featured_noise"), (Object)ChunkGeneratorTwilightForest.CODEC);
        Registry.func_218322_a(Registry.field_239690_aB_, TwilightForestMod.prefix("sky_noise"), (Object)ChunkGeneratorTwilightSky.CODEC);
    }
}
