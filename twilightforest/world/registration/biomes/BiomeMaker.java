// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration.biomes;

import net.minecraft.world.level.biome.MobSpawnSettings;
import twilightforest.world.components.BiomeGrassColors;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceKey;
import java.util.Map;

public final class BiomeMaker extends BiomeHelper
{
    public static final Map<ResourceKey<Biome>, Biome> BIOMES;
    
    private static Map<ResourceKey<Biome>, Biome> generateBiomes() {
        final ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes = (ImmutableMap.Builder<ResourceKey<Biome>, Biome>)ImmutableMap.builder();
        commonBiomes(biomes);
        mushroomBiomes(biomes);
        rareBiomes(biomes);
        swampBiomes(biomes);
        darkForestBiomes(biomes);
        snowRegionBiomes(biomes);
        highlandsBiomes(biomes);
        return (Map<ResourceKey<Biome>, Biome>)biomes.build();
    }
    
    private static void commonBiomes(final ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.fireflyParticles(BiomeHelper.defaultAmbientBuilder()), BiomeHelper.defaultMobSpawning().m_48367_(), BiomeHelper.twilightForestGen()).m_47592_());
        biomes.put((Object)BiomeKeys.DENSE_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.fireflyParticles(BiomeHelper.defaultAmbientBuilder()).m_48034_(21794), BiomeHelper.defaultMobSpawning().m_48367_(), BiomeHelper.denseForestGen()).m_47609_(0.7f).m_47611_(0.8f).m_47593_(0.1f).m_47607_(0.2f).m_47592_());
        biomes.put((Object)BiomeKeys.FIREFLY_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.fireflyForestParticles(BiomeHelper.defaultAmbientBuilder()), BiomeHelper.defaultMobSpawning().m_48367_(), BiomeHelper.fireflyForestGen()).m_47609_(0.5f).m_47611_(1.0f).m_47593_(0.0625f).m_47607_(0.05f).m_47592_());
        biomes.put((Object)BiomeKeys.CLEARING, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning().m_48367_(), BiomeHelper.clearingGen()).m_47595_(Biome.BiomeCategory.PLAINS).m_47609_(0.8f).m_47611_(0.4f).m_47593_(0.005f).m_47607_(0.005f).m_47592_());
        biomes.put((Object)BiomeKeys.OAK_SAVANNAH, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning().m_48367_(), BiomeHelper.oakSavannaGen()).m_47595_(Biome.BiomeCategory.SAVANNA).m_47609_(0.9f).m_47611_(0.0f).m_47593_(0.05f).m_47607_(0.1f).m_47592_());
    }
    
    private static void mushroomBiomes(final ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.MUSHROOM_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.fireflyParticles(BiomeHelper.defaultAmbientBuilder()), BiomeHelper.defaultMobSpawning().m_48367_(), BiomeHelper.mushroomForestGen()).m_47609_(0.8f).m_47611_(0.8f).m_47592_());
        biomes.put((Object)BiomeKeys.DENSE_MUSHROOM_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.fireflyParticles(BiomeHelper.defaultAmbientBuilder()), BiomeHelper.defaultMobSpawning().m_48367_(), BiomeHelper.denseMushroomForestGen()).m_47609_(0.8f).m_47611_(1.0f).m_47593_(0.05f).m_47607_(0.05f).m_47592_());
    }
    
    private static void rareBiomes(final ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.SPOOKY_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().m_48045_(12865827).m_48043_(16745729).m_48034_(16421137).m_48031_(BiomeGrassColors.SPOOKY_FOREST), BiomeHelper.spookSpawning(), BiomeHelper.spookyForestGen()).m_47609_(0.5f).m_47611_(1.0f).m_47607_(0.05f).m_47592_());
        biomes.put((Object)BiomeKeys.ENCHANTED_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.fireflyParticles(BiomeHelper.defaultAmbientBuilder()).m_48043_(65535).m_48045_(65535).m_48031_(BiomeGrassColors.ENCHANTED_FOREST), BiomeHelper.defaultMobSpawning(), BiomeHelper.enchantedForestGen()).m_47597_(Biome.Precipitation.NONE).m_47592_());
        biomes.put((Object)BiomeKeys.STREAM, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning(), BiomeHelper.streamsAndLakes(false)).m_47595_(Biome.BiomeCategory.RIVER).m_47609_(0.5f).m_47611_(0.1f).m_47593_(-0.8f).m_47607_(0.0f).m_47592_());
        biomes.put((Object)BiomeKeys.LAKE, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning(), BiomeHelper.streamsAndLakes(true)).m_47595_(Biome.BiomeCategory.OCEAN).m_47609_(0.66f).m_47611_(1.0f).m_47593_(-0.9f).m_47607_(0.1f).m_47592_());
    }
    
    private static void swampBiomes(final ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.SWAMP, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().m_48045_(6056270).m_48043_(4809015).m_48034_(14745518).m_48031_(BiomeGrassColors.SWAMP), BiomeHelper.swampSpawning(), BiomeHelper.swampGen()).m_47595_(Biome.BiomeCategory.SWAMP).m_47609_(0.8f).m_47611_(0.9f).m_47593_(-0.125f).m_47607_(0.15f).m_47592_());
        biomes.put((Object)BiomeKeys.FIRE_SWAMP, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.whiteAshParticles(BiomeHelper.defaultAmbientBuilder().m_48045_(5713443).m_48043_(6563343).m_48034_(7089196)), new MobSpawnSettings.Builder(), BiomeHelper.fireSwampGen()).m_47595_(Biome.BiomeCategory.SWAMP).m_47597_(Biome.Precipitation.NONE).m_47609_(1.0f).m_47611_(0.4f).m_47593_(0.025f).m_47607_(0.05f).m_47592_());
    }
    
    private static void darkForestBiomes(final ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.DARK_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().m_48045_(4941652).m_48043_(3890751).m_48031_(BiomeGrassColors.DARK_FOREST), BiomeHelper.darkForestSpawning(), BiomeHelper.darkForestGen()).m_47609_(0.7f).m_47611_(0.8f).m_47593_(0.025f).m_47607_(0.025f).m_47592_());
        biomes.put((Object)BiomeKeys.DARK_FOREST_CENTER, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder().m_48045_(6714688).m_48043_(16351774).m_48031_(BiomeGrassColors.DARK_FOREST_CENTER), new MobSpawnSettings.Builder(), BiomeHelper.darkForestCenterGen()).m_47593_(0.025f).m_47607_(0.025f).m_47592_());
    }
    
    private static void snowRegionBiomes(final ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.SNOWY_FOREST, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.snowForestSpawning(), BiomeHelper.snowyForestGen()).m_47597_(Biome.Precipitation.SNOW).m_47609_(0.09f).m_47611_(0.9f).m_47593_(0.05f).m_47607_(0.15f).m_47592_());
        biomes.put((Object)BiomeKeys.GLACIER, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.penguinSpawning(), BiomeHelper.glacierGen()).m_47595_(Biome.BiomeCategory.ICY).m_47609_(0.8f).m_47611_(0.1f).m_47597_(Biome.Precipitation.SNOW).m_47592_());
    }
    
    private static void highlandsBiomes(final ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        biomes.put((Object)BiomeKeys.HIGHLANDS, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.defaultMobSpawning(), BiomeHelper.highlandsGen()).m_47595_(Biome.BiomeCategory.MESA).m_47609_(0.4f).m_47611_(0.7f).m_47593_(1.75f).m_47607_(0.05f).m_47592_());
        biomes.put((Object)BiomeKeys.THORNLANDS, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), new MobSpawnSettings.Builder(), BiomeHelper.thornlandsGen()).m_47595_(Biome.BiomeCategory.NONE).m_47609_(0.3f).m_47611_(0.2f).m_47593_(3.0f).m_47607_(0.1f).m_47592_());
        biomes.put((Object)BiomeKeys.FINAL_PLATEAU, (Object)BiomeHelper.biomeWithDefaults(BiomeHelper.defaultAmbientBuilder(), BiomeHelper.ravenSpawning(), BiomeHelper.plateauGen()).m_47595_(Biome.BiomeCategory.MESA).m_47609_(1.0f).m_47611_(0.2f).m_47593_(5.25f).m_47607_(0.025f).m_47592_());
    }
    
    static {
        BIOMES = generateBiomes();
    }
}
