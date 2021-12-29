// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import twilightforest.world.components.TFBiomeProvider;
import twilightforest.world.components.TFBiomeDistributor;
import twilightforest.TwilightForestMod;
import net.minecraft.core.Registry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFDimensions
{
    public static long seed;
    
    public static void init() {
        Registry.m_122965_(Registry.f_122889_, TwilightForestMod.prefix("smart_distribution"), (Object)TFBiomeDistributor.TF_CODEC);
        Registry.m_122965_(Registry.f_122889_, TwilightForestMod.prefix("grid"), (Object)TFBiomeProvider.TF_CODEC);
        Registry.m_122965_(Registry.f_122890_, TwilightForestMod.prefix("structure_locating_wrapper"), (Object)ChunkGeneratorTwilight.CODEC);
    }
}
