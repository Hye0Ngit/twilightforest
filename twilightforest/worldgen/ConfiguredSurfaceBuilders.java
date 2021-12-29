// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen;

import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import twilightforest.world.surfacebuilders.TFSurfaceBuilders;
import twilightforest.TwilightForestMod;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ConfiguredSurfaceBuilders
{
    public static final SurfaceBuilderConfig DEADROCK_CONFIG;
    public static final SurfaceBuilderConfig HIGHLANDS_CONFIG;
    public static final SurfaceBuilderConfig SNOW_CONFIG;
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> CONFIGURED_TF_DEFAULT;
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> CONFIGURED_HIGHLANDS;
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> CONFIGURED_PLATEAU;
    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> CONFIGURED_SNOW;
    
    public static void registerConfigurations(final Registry<ConfiguredSurfaceBuilder<?>> registry) {
        Registry.func_218322_a((Registry)registry, TwilightForestMod.prefix("coarse_podzol_highlands"), (Object)ConfiguredSurfaceBuilders.CONFIGURED_HIGHLANDS);
        Registry.func_218322_a((Registry)registry, TwilightForestMod.prefix("deadrock_plateau"), (Object)ConfiguredSurfaceBuilders.CONFIGURED_PLATEAU);
    }
    
    static {
        DEADROCK_CONFIG = new SurfaceBuilderConfig(BlockConstants.WEATHERED_DEADROCK, BlockConstants.CRACKED_DEADROCK, BlockConstants.DEADROCK);
        HIGHLANDS_CONFIG = new SurfaceBuilderConfig(BlockConstants.PODZOL, BlockConstants.COARSE_DIRT, BlockConstants.GRASS_BLOCK);
        SNOW_CONFIG = new SurfaceBuilderConfig(BlockConstants.SNOW, BlockConstants.SNOW, BlockConstants.PACKED_ICE);
        CONFIGURED_TF_DEFAULT = TFSurfaceBuilders.DEFAULT_TF.func_242929_a((ISurfaceBuilderConfig)SurfaceBuilder.field_215390_A);
        CONFIGURED_HIGHLANDS = TFSurfaceBuilders.HIGHLANDS.func_242929_a((ISurfaceBuilderConfig)ConfiguredSurfaceBuilders.HIGHLANDS_CONFIG);
        CONFIGURED_PLATEAU = TFSurfaceBuilders.PLATEAU.func_242929_a((ISurfaceBuilderConfig)ConfiguredSurfaceBuilders.DEADROCK_CONFIG);
        CONFIGURED_SNOW = SurfaceBuilder.field_215396_G.func_242929_a((ISurfaceBuilderConfig)ConfiguredSurfaceBuilders.SNOW_CONFIG);
    }
}
