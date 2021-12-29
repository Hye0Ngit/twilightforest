// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.biomes;

import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import twilightforest.worldgen.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.feature.StructureFeature;
import twilightforest.TFStructures;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.RegistryKey;
import java.util.Map;

public final class BiomeMaker extends BiomeHelper
{
    public static final Map<RegistryKey<Biome>, Biome> BIOMES;
    
    private static Map<RegistryKey<Biome>, Biome> generateBiomes() {
        final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes = (ImmutableMap.Builder<RegistryKey<Biome>, Biome>)ImmutableMap.builder();
        commonBiomes(biomes);
        mushroomBiomes(biomes);
        rareBiomes(biomes);
        swampBiomes(biomes);
        darkForestBiomes(biomes);
        snowRegionBiomes(biomes);
        highlandsBiomes(biomes);
        return (Map<RegistryKey<Biome>, Biome>)biomes.build();
    }
    
    private static void commonBiomes(final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning().func_242571_a(), BiomeHelper.twilightForestGen(BiomeHelper.defaultGenSettingBuilder())).func_242455_a());
        biomes.put((Object)BiomeKeys.DENSE_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().func_235246_b_(21794), BiomeHelper.defaultMobSpawning().func_242571_a(), BiomeHelper.denseForestGen(BiomeHelper.defaultGenSettingBuilder())).func_205414_c(0.7f).func_205417_d(0.8f).func_205421_a(0.2f).func_205420_b(0.2f).func_242455_a());
        biomes.put((Object)BiomeKeys.FIREFLY_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning().func_242571_a(), BiomeHelper.fireflyForestGen(BiomeHelper.defaultGenSettingBuilder())).func_205414_c(0.5f).func_205417_d(1.0f).func_205421_a(0.125f).func_205420_b(0.05f).func_242455_a());
        biomes.put((Object)BiomeKeys.CLEARING, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning().func_242571_a(), BiomeHelper.addDefaultStructures(BiomeHelper.defaultGenSettingBuilder())).func_205419_a(Biome.Category.PLAINS).func_205414_c(0.8f).func_205417_d(0.4f).func_205421_a(0.125f).func_205420_b(0.05f).func_242455_a());
        biomes.put((Object)BiomeKeys.OAK_SAVANNAH, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning().func_242571_a(), BiomeHelper.oakSavannaGen(BiomeHelper.defaultGenSettingBuilder())).func_205419_a(Biome.Category.SAVANNA).func_205414_c(0.9f).func_205417_d(0.0f).func_205421_a(0.2f).func_205420_b(0.2f).func_242455_a());
    }
    
    private static void mushroomBiomes(final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.MUSHROOM_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning().func_242571_a(), BiomeHelper.mushroomForestGen(BiomeHelper.defaultGenSettingBuilder())).func_205414_c(0.8f).func_205417_d(0.8f).func_242455_a());
        biomes.put((Object)BiomeKeys.DENSE_MUSHROOM_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning().func_242571_a(), BiomeHelper.denseMushroomForestGen(BiomeHelper.defaultGenSettingBuilder().func_242516_a((StructureFeature)TFStructures.CONFIGURED_MUSHROOM_TOWER))).func_205414_c(0.8f).func_205417_d(1.0f).func_205421_a(0.125f).func_205420_b(0.05f).func_242455_a());
    }
    
    private static void rareBiomes(final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.SPOOKY_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().func_242541_f(12865827).func_242540_e(16745729).func_235246_b_(16421137), BiomeHelper.spookSpawning(), BiomeHelper.spookyForestGen(BiomeHelper.defaultGenSettingBuilder())).func_205414_c(0.5f).func_205417_d(1.0f).func_205421_a(0.125f).func_205420_b(0.05f).func_242455_a());
        biomes.put((Object)BiomeKeys.ENCHANTED_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().func_242540_e(65535).func_242541_f(65535).func_242537_a(BiomeGrassColors.ENCHANTED_FOREST), BiomeHelper.defaultMobSpawning(), BiomeHelper.enchantedForestGen(BiomeHelper.defaultGenSettingBuilder().func_242516_a((StructureFeature)TFStructures.CONFIGURED_QUEST_GROVE))).func_242455_a());
        biomes.put((Object)BiomeKeys.STREAM, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning(), BiomeHelper.defaultGenSettingBuilder()).func_205419_a(Biome.Category.RIVER).func_205414_c(0.5f).func_205417_d(0.1f).func_205421_a(-0.8f).func_205420_b(0.0f).func_242455_a());
        biomes.put((Object)BiomeKeys.LAKE, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning(), BiomeHelper.defaultGenSettingBuilder()).func_205419_a(Biome.Category.OCEAN).func_205414_c(0.66f).func_205417_d(1.0f).func_205421_a(-1.8f).func_205420_b(0.1f).func_242455_a());
    }
    
    private static void swampBiomes(final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.SWAMP, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().func_242541_f(6056270).func_242540_e(4809015).func_235246_b_(14745518).func_242537_a(BiomeGrassColors.SWAMP), BiomeHelper.swampSpawning(), BiomeHelper.swampGen(BiomeHelper.defaultGenSettingBuilder()).func_242516_a((StructureFeature)TFStructures.CONFIGURED_LABYRINTH)).func_205419_a(Biome.Category.SWAMP).func_205414_c(0.8f).func_205417_d(0.9f).func_205421_a(-0.25f).func_205420_b(0.25f).func_242455_a());
        biomes.put((Object)BiomeKeys.FIRE_SWAMP, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.whiteAshParticles(BiomeHelper.defaultAmbientBuilder().func_242541_f(5713443).func_242540_e(6563343).func_235246_b_(7089196)), new MobSpawnInfo.Builder(), BiomeHelper.fireSwampGen(BiomeHelper.defaultGenSettingBuilder()).func_242516_a((StructureFeature)TFStructures.CONFIGURED_HYDRA_LAIR)).func_205419_a(Biome.Category.SWAMP).func_205414_c(1.0f).func_205417_d(0.4f).func_205421_a(0.1f).func_205420_b(0.2f).func_242455_a());
    }
    
    private static void darkForestBiomes(final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.DARK_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().func_242541_f(4941652).func_242540_e(3890751).func_242537_a(BiomeGrassColors.DARK_FOREST), BiomeHelper.darkForestSpawning(), BiomeHelper.darkForestGen().func_242516_a((StructureFeature)TFStructures.CONFIGURED_KNIGHT_STRONGHOLD)).func_205414_c(0.7f).func_205417_d(0.8f).func_205421_a(0.125f).func_205420_b(0.05f).func_242455_a());
        biomes.put((Object)BiomeKeys.DARK_FOREST_CENTER, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().func_242541_f(6714688).func_242540_e(16351774).func_242537_a(BiomeGrassColors.DARK_FOREST_CENTER), new MobSpawnInfo.Builder(), BiomeHelper.darkForestCenterGen().func_242516_a((StructureFeature)TFStructures.CONFIGURED_DARK_TOWER)).func_205421_a(0.125f).func_205420_b(0.05f).func_242455_a());
    }
    
    private static void snowRegionBiomes(final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.SNOWY_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.snowForestSpawning(), BiomeHelper.snowyForestGen().func_242516_a((StructureFeature)TFStructures.CONFIGURED_YETI_CAVE)).func_205415_a(Biome.RainType.SNOW).func_205414_c(0.09f).func_205417_d(0.9f).func_205421_a(0.2f).func_205420_b(0.2f).func_242455_a());
        biomes.put((Object)BiomeKeys.GLACIER, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.penguinSpawning(), BiomeHelper.glacierGen().func_242516_a((StructureFeature)TFStructures.CONFIGURED_AURORA_PALACE)).func_205419_a(Biome.Category.ICY).func_205414_c(0.8f).func_205417_d(0.1f).func_205415_a(Biome.RainType.SNOW).func_242455_a());
    }
    
    private static void highlandsBiomes(final ImmutableMap.Builder<RegistryKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.HIGHLANDS, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning(), BiomeHelper.highlandsGen().func_242516_a((StructureFeature)TFStructures.CONFIGURED_TROLL_CAVE)).func_205419_a(Biome.Category.MESA).func_205414_c(0.4f).func_205417_d(0.7f).func_205421_a(3.5f).func_205420_b(0.05f).func_242455_a());
        biomes.put((Object)BiomeKeys.THORNLANDS, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), new MobSpawnInfo.Builder(), BiomeHelper.thornlandsGen()).func_205419_a(Biome.Category.NONE).func_205414_c(0.3f).func_205417_d(0.2f).func_205421_a(6.0f).func_205420_b(0.1f).func_242455_a());
        biomes.put((Object)BiomeKeys.FINAL_PLATEAU, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.ravenSpawning(), BiomeHelper.defaultGenSettingBuilder().func_242517_a((ConfiguredSurfaceBuilder)ConfiguredSurfaceBuilders.CONFIGURED_PLATEAU).func_242516_a((StructureFeature)TFStructures.CONFIGURED_FINAL_CASTLE)).func_205419_a(Biome.Category.MESA).func_205414_c(0.3f).func_205417_d(0.2f).func_205421_a(10.5f).func_205420_b(0.025f).func_242455_a());
    }
    
    static {
        BIOMES = generateBiomes();
    }
}
