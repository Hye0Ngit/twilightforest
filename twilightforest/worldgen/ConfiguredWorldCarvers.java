// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen;

import net.minecraft.world.gen.carver.ICarverConfig;
import com.mojang.serialization.Codec;
import twilightforest.TwilightForestMod;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import twilightforest.world.TFCavesCarver;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfiguredWorldCarvers
{
    public static final TFCavesCarver TFCAVES;
    public static final TFCavesCarver HIGHLANDCAVES;
    public static final ConfiguredCarver<ProbabilityConfig> TFCAVES_CONFIGURED;
    public static final ConfiguredCarver<ProbabilityConfig> HIGHLANDCAVES_CONFIGURED;
    
    @SubscribeEvent
    public static void register(final RegistryEvent.Register<WorldCarver<?>> evt) {
        evt.getRegistry().register((IForgeRegistryEntry)ConfiguredWorldCarvers.TFCAVES);
        evt.getRegistry().register((IForgeRegistryEntry)ConfiguredWorldCarvers.HIGHLANDCAVES);
    }
    
    public static void registerConfigurations(final Registry<ConfiguredCarver<?>> registry) {
        Registry.func_218322_a((Registry)registry, TwilightForestMod.prefix("tf_caves"), (Object)ConfiguredWorldCarvers.TFCAVES_CONFIGURED);
        Registry.func_218322_a((Registry)registry, TwilightForestMod.prefix("highland_caves"), (Object)ConfiguredWorldCarvers.HIGHLANDCAVES_CONFIGURED);
    }
    
    static {
        TFCAVES = new TFCavesCarver((Codec<ProbabilityConfig>)ProbabilityConfig.field_236576_b_, 256, false);
        HIGHLANDCAVES = new TFCavesCarver((Codec<ProbabilityConfig>)ProbabilityConfig.field_236576_b_, 256, true);
        ConfiguredWorldCarvers.TFCAVES.setRegistryName("twilightforest", "tf_caves");
        ConfiguredWorldCarvers.HIGHLANDCAVES.setRegistryName("twilightforest", "highland_caves");
        TFCAVES_CONFIGURED = ConfiguredWorldCarvers.TFCAVES.func_242761_a((ICarverConfig)new ProbabilityConfig(0.03f));
        HIGHLANDCAVES_CONFIGURED = ConfiguredWorldCarvers.HIGHLANDCAVES.func_242761_a((ICarverConfig)new ProbabilityConfig(0.03f));
    }
}
