// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import com.mojang.serialization.Codec;
import twilightforest.TwilightForestMod;
import net.minecraft.core.Registry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import twilightforest.world.components.TFCavesCarver;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfiguredWorldCarvers
{
    public static final TFCavesCarver TFCAVES;
    public static final TFCavesCarver HIGHLANDCAVES;
    public static final ConfiguredWorldCarver<CaveCarverConfiguration> TFCAVES_CONFIGURED;
    public static final ConfiguredWorldCarver<CaveCarverConfiguration> HIGHLANDCAVES_CONFIGURED;
    
    @SubscribeEvent
    public static void register(final RegistryEvent.Register<WorldCarver<?>> evt) {
        evt.getRegistry().register((IForgeRegistryEntry)ConfiguredWorldCarvers.TFCAVES);
        evt.getRegistry().register((IForgeRegistryEntry)ConfiguredWorldCarvers.HIGHLANDCAVES);
    }
    
    public static void registerConfigurations(final Registry<ConfiguredWorldCarver<?>> registry) {
        Registry.m_122965_((Registry)registry, TwilightForestMod.prefix("tf_caves"), (Object)ConfiguredWorldCarvers.TFCAVES_CONFIGURED);
        Registry.m_122965_((Registry)registry, TwilightForestMod.prefix("highland_caves"), (Object)ConfiguredWorldCarvers.HIGHLANDCAVES_CONFIGURED);
    }
    
    static {
        TFCAVES = new TFCavesCarver((Codec<CaveCarverConfiguration>)CaveCarverConfiguration.f_159154_, false);
        HIGHLANDCAVES = new TFCavesCarver((Codec<CaveCarverConfiguration>)CaveCarverConfiguration.f_159154_, true);
        ConfiguredWorldCarvers.TFCAVES.setRegistryName("twilightforest", "tf_caves");
        ConfiguredWorldCarvers.HIGHLANDCAVES.setRegistryName("twilightforest", "highland_caves");
        TFCAVES_CONFIGURED = ConfiguredWorldCarvers.TFCAVES.m_65063_((CarverConfiguration)new CaveCarverConfiguration(0.1f, (HeightProvider)UniformHeight.m_162034_(VerticalAnchor.m_158930_(5), VerticalAnchor.m_158922_(-5)), (FloatProvider)ConstantFloat.m_146458_(0.6f), VerticalAnchor.m_158921_(), false, CarverDebugSettings.m_159139_(false, Blocks.f_50058_.m_49966_(), Blocks.f_50211_.m_49966_(), Blocks.f_50214_.m_49966_(), Blocks.f_50108_.m_49966_()), (FloatProvider)ConstantFloat.m_146458_(1.0f), (FloatProvider)ConstantFloat.m_146458_(1.0f), (FloatProvider)ConstantFloat.m_146458_(-0.7f)));
        HIGHLANDCAVES_CONFIGURED = ConfiguredWorldCarvers.HIGHLANDCAVES.m_65063_((CarverConfiguration)new CaveCarverConfiguration(0.1f, (HeightProvider)BiasedToBottomHeight.m_161931_(VerticalAnchor.m_158930_(5), VerticalAnchor.m_158922_(65), 48), (FloatProvider)ConstantFloat.m_146458_(0.75f), VerticalAnchor.m_158921_(), false, CarverDebugSettings.m_159139_(false, Blocks.f_50058_.m_49966_(), Blocks.f_50211_.m_49966_(), Blocks.f_50214_.m_49966_(), Blocks.f_50108_.m_49966_()), (FloatProvider)ConstantFloat.m_146458_(1.0f), (FloatProvider)ConstantFloat.m_146458_(1.0f), (FloatProvider)ConstantFloat.m_146458_(-0.7f)));
    }
}
