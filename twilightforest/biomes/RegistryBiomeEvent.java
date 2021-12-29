// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public final class RegistryBiomeEvent
{
    public static final BiomeDictionary.Type TWILIGHT;
    
    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        final BiomeRegistry biomes = new BiomeRegistry((IForgeRegistry<Biome>)event.getRegistry());
        biomes.register("twilight_lake", new TFBiomeTwilightLake(new Biome.BiomeProperties("Twilight Lake").func_185410_a(0.66f).func_185395_b(1.0f).func_185398_c(-1.8f).func_185400_d(0.1f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.OCEAN);
        biomes.register("twilight_forest", new TFBiomeBase(new Biome.BiomeProperties("Twilight Forest")), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST);
        biomes.register("dense_twilight_forest", new TFBiomeTwilightForestVariant(new Biome.BiomeProperties("Dense Twilight Forest").func_185402_a(21794).func_185410_a(0.7f).func_185395_b(0.8f).func_185398_c(0.2f).func_185400_d(0.2f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE);
        biomes.register("twilight_highlands", new TFBiomeHighlands(new Biome.BiomeProperties("Twilight Highlands").func_185410_a(0.4f).func_185395_b(0.7f).func_185398_c(3.5f).func_185400_d(0.05f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS);
        biomes.register("mushroom_forest", new TFBiomeMushrooms(new Biome.BiomeProperties("Mushroom Forest").func_185410_a(0.8f).func_185395_b(0.8f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM);
        biomes.register("twilight_swamp", new TFBiomeSwamp(new Biome.BiomeProperties("Twilight Swamp").func_185410_a(0.8f).func_185395_b(0.9f).func_185398_c(-0.125f).func_185400_d(0.125f).func_185402_a(14745518)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WET);
        biomes.register("twilight_stream", new TFBiomeStream(new Biome.BiomeProperties("Twilight Stream").func_185410_a(0.5f).func_185395_b(0.1f).func_185398_c(-0.5f).func_185400_d(0.0f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.RIVER);
        biomes.register("snowy_forest", new TFBiomeSnow(new Biome.BiomeProperties("Snowy Forest").func_185410_a(0.09f).func_185395_b(0.9f).func_185398_c(0.2f).func_185400_d(0.2f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS);
        biomes.register("twilight_glacier", new TFBiomeGlacier(new Biome.BiomeProperties("Twilight Glacier").func_185410_a(0.0f).func_185395_b(0.1f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.WASTELAND);
        biomes.register("twilight_clearing", new TFBiomeClearing(new Biome.BiomeProperties("Twilight Clearing").func_185410_a(0.8f).func_185395_b(0.4f).func_185398_c(0.125f).func_185400_d(0.05f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SPARSE);
        biomes.register("oak_savannah", new TFBiomeOakSavanna(new Biome.BiomeProperties("Oak Savanna").func_185410_a(0.9f).func_185395_b(0.0f).func_185398_c(0.2f).func_185400_d(0.2f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPARSE);
        biomes.register("firefly_forest", new TFBiomeFireflyForest(new Biome.BiomeProperties("Firefly Forest").func_185410_a(0.5f).func_185395_b(1.0f).func_185398_c(0.125f).func_185400_d(0.05f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.LUSH);
        biomes.register("deep_mushroom_forest", new TFBiomeDeepMushrooms(new Biome.BiomeProperties("Deep Mushroom Forest").func_185410_a(0.8f).func_185395_b(1.0f).func_185398_c(0.125f).func_185400_d(0.05f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM);
        biomes.register("dark_forest", new TFBiomeDarkForest(new Biome.BiomeProperties("Dark Forest").func_185410_a(0.7f).func_185395_b(0.8f).func_185398_c(0.125f).func_185400_d(0.05f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY);
        biomes.register("enchanted_forest", new TFBiomeEnchantedForest(new Biome.BiomeProperties("Enchanted Forest")), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        biomes.register("fire_swamp", new TFBiomeFireSwamp(new Biome.BiomeProperties("Fire Swamp").func_185410_a(1.0f).func_185395_b(0.4f).func_185402_a(7089196).func_185398_c(0.1f).func_185400_d(0.2f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.HOT);
        biomes.register("dark_forest_center", new TFBiomeDarkForestCenter(new Biome.BiomeProperties("Dark Forest Center").func_185398_c(0.125f).func_185400_d(0.05f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL);
        biomes.register("highlands_center", new TFBiomeFinalPlateau(new Biome.BiomeProperties("Final Plateau").func_185410_a(0.3f).func_185395_b(0.2f).func_185398_c(10.5f).func_185400_d(0.025f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.MESA, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.WASTELAND);
        biomes.register("thornlands", new TFBiomeThornlands(new Biome.BiomeProperties("Thornlands").func_185410_a(0.3f).func_185395_b(0.2f).func_185398_c(6.0f).func_185400_d(0.1f)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.WASTELAND);
        biomes.register("spooky_forest", new TFBiomeSpookyForest(new Biome.BiomeProperties("Spooky Forest").func_185410_a(0.5f).func_185395_b(1.0f).func_185398_c(0.125f).func_185400_d(0.05f).func_185402_a(16421137)), RegistryBiomeEvent.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY);
    }
    
    static {
        TWILIGHT = BiomeDictionary.Type.getType("TWILIGHT", new BiomeDictionary.Type[0]);
    }
    
    private static class BiomeRegistry
    {
        private final IForgeRegistry<Biome> registry;
        
        BiomeRegistry(final IForgeRegistry<Biome> registry) {
            this.registry = registry;
        }
        
        public void register(final String registryName, final Biome biome, final BiomeDictionary.Type... biomeTypes) {
            biome.setRegistryName("twilightforest", registryName);
            this.registry.register((IForgeRegistryEntry)biome);
            BiomeDictionary.addTypes(biome, biomeTypes);
        }
    }
}
