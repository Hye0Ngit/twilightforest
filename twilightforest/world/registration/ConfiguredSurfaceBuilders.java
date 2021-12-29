// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import twilightforest.TwilightForestMod;
import net.minecraft.core.Registry;
import twilightforest.world.components.surfacebuilders.GlacierSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import twilightforest.world.components.surfacebuilders.FillingSurfaceBuilder;

public class ConfiguredSurfaceBuilders
{
    public static final FillingSurfaceBuilder.FillingSurfaceBuilderConfig DEADROCK_CONFIG;
    public static final SurfaceBuilderBaseConfiguration HIGHLANDS_CONFIG;
    public static final SurfaceBuilderBaseConfiguration SNOW_CONFIG;
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> CONFIGURED_GRAVEL;
    public static final GlacierSurfaceBuilder.GlacierSurfaceConfig GLACIER_CONFIG;
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> CONFIGURED_HIGHLANDS;
    public static final ConfiguredSurfaceBuilder<FillingSurfaceBuilder.FillingSurfaceBuilderConfig> CONFIGURED_PLATEAU;
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> CONFIGURED_SNOW;
    public static final ConfiguredSurfaceBuilder<GlacierSurfaceBuilder.GlacierSurfaceConfig> CONFIGURED_GLACIER;
    
    public static void registerConfigurations(final Registry<ConfiguredSurfaceBuilder<?>> registry) {
        Registry.m_122965_((Registry)registry, TwilightForestMod.prefix("coarse_podzol_surface"), (Object)ConfiguredSurfaceBuilders.CONFIGURED_HIGHLANDS);
        Registry.m_122965_((Registry)registry, TwilightForestMod.prefix("deadrock_filler"), (Object)ConfiguredSurfaceBuilders.CONFIGURED_PLATEAU);
        Registry.m_122965_((Registry)registry, TwilightForestMod.prefix("heavy_snow"), (Object)ConfiguredSurfaceBuilders.CONFIGURED_SNOW);
        Registry.m_122965_((Registry)registry, TwilightForestMod.prefix("all_gravel"), (Object)ConfiguredSurfaceBuilders.CONFIGURED_GRAVEL);
        Registry.m_122965_((Registry)registry, TwilightForestMod.prefix("glacier"), (Object)ConfiguredSurfaceBuilders.CONFIGURED_GLACIER);
    }
    
    static {
        DEADROCK_CONFIG = new FillingSurfaceBuilder.FillingSurfaceBuilderConfig(BlockConstants.WEATHERED_DEADROCK, BlockConstants.CRACKED_DEADROCK, BlockConstants.CRACKED_DEADROCK, BlockConstants.DEADROCK);
        HIGHLANDS_CONFIG = new SurfaceBuilderBaseConfiguration(BlockConstants.PODZOL, BlockConstants.COARSE_DIRT, BlockConstants.SAND);
        SNOW_CONFIG = new SurfaceBuilderBaseConfiguration(BlockConstants.SNOW, BlockConstants.SNOW, BlockConstants.PACKED_ICE);
        CONFIGURED_GRAVEL = SurfaceBuilder.f_75214_.m_75223_((SurfaceBuilderConfiguration)SurfaceBuilder.f_75199_);
        GLACIER_CONFIG = new GlacierSurfaceBuilder.GlacierSurfaceConfig(() -> ConfiguredSurfaceBuilders.CONFIGURED_GRAVEL, 30, 2, BlockConstants.PACKED_ICE, BlockConstants.ICE);
        CONFIGURED_HIGHLANDS = TwilightSurfaceBuilders.HIGHLANDS.m_75223_((SurfaceBuilderConfiguration)ConfiguredSurfaceBuilders.HIGHLANDS_CONFIG);
        CONFIGURED_PLATEAU = TwilightSurfaceBuilders.DEADROCK_FILLING.m_75223_((SurfaceBuilderConfiguration)ConfiguredSurfaceBuilders.DEADROCK_CONFIG);
        CONFIGURED_SNOW = SurfaceBuilder.f_75214_.m_75223_((SurfaceBuilderConfiguration)ConfiguredSurfaceBuilders.SNOW_CONFIG);
        CONFIGURED_GLACIER = TwilightSurfaceBuilders.GLACIER.m_75223_((SurfaceBuilderConfiguration)ConfiguredSurfaceBuilders.GLACIER_CONFIG);
    }
}
