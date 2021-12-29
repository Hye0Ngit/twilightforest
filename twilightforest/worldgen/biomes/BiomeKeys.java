// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.biomes;

import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.TwilightForestMod;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;

public class BiomeKeys
{
    public static final DeferredRegister<Biome> BIOMES;
    public static final RegistryKey<Biome> FOREST;
    public static final RegistryKey<Biome> DENSE_FOREST;
    public static final RegistryKey<Biome> FIREFLY_FOREST;
    public static final RegistryKey<Biome> CLEARING;
    public static final RegistryKey<Biome> OAK_SAVANNAH;
    public static final RegistryKey<Biome> STREAM;
    public static final RegistryKey<Biome> LAKE;
    public static final RegistryKey<Biome> MUSHROOM_FOREST;
    public static final RegistryKey<Biome> DENSE_MUSHROOM_FOREST;
    public static final RegistryKey<Biome> ENCHANTED_FOREST;
    public static final RegistryKey<Biome> SPOOKY_FOREST;
    public static final RegistryKey<Biome> SWAMP;
    public static final RegistryKey<Biome> FIRE_SWAMP;
    public static final RegistryKey<Biome> DARK_FOREST;
    public static final RegistryKey<Biome> DARK_FOREST_CENTER;
    public static final RegistryKey<Biome> SNOWY_FOREST;
    public static final RegistryKey<Biome> GLACIER;
    public static final RegistryKey<Biome> HIGHLANDS;
    public static final RegistryKey<Biome> THORNLANDS;
    public static final RegistryKey<Biome> FINAL_PLATEAU;
    public static final BiomeDictionary.Type TWILIGHT;
    
    private static RegistryKey<Biome> makeKey(final String name) {
        BiomeKeys.BIOMES.register(name, () -> new Biome.Builder().func_205415_a(Biome.RainType.NONE).func_205419_a(Biome.Category.NONE).func_205421_a(0.0f).func_205417_d(0.0f).func_205420_b(0.0f).func_205414_c(0.0f).func_235097_a_(new BiomeAmbience.Builder().func_235239_a_(0).func_235246_b_(0).func_235248_c_(0).func_242539_d(0).func_235238_a_()).func_242457_a(new BiomeGenerationSettings.Builder().func_242517_a(ConfiguredSurfaceBuilders.field_244178_j).func_242508_a()).func_242458_a(new MobSpawnInfo.Builder().func_242577_b()).func_242456_a(Biome.TemperatureModifier.NONE).func_242455_a());
        return (RegistryKey<Biome>)RegistryKey.func_240903_a_(Registry.field_239720_u_, TwilightForestMod.prefix(name));
    }
    
    public static void addBiomeTypes() {
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.DENSE_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.FIREFLY_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.LUSH });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.CLEARING, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SPARSE });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.OAK_SAVANNAH, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPARSE });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.STREAM, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.RIVER });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.LAKE, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.OCEAN });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.MUSHROOM_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.DENSE_MUSHROOM_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.ENCHANTED_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.SPOOKY_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.SWAMP, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WET });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.FIRE_SWAMP, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.HOT });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.DARK_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.DARK_FOREST_CENTER, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.SNOWY_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.GLACIER, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.WASTELAND });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.HIGHLANDS, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.THORNLANDS, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.WASTELAND });
        BiomeDictionary.addTypes((RegistryKey)BiomeKeys.FINAL_PLATEAU, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.MESA, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.WASTELAND });
    }
    
    static {
        BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, "twilightforest");
        FOREST = makeKey("forest");
        DENSE_FOREST = makeKey("dense_forest");
        FIREFLY_FOREST = makeKey("firefly_forest");
        CLEARING = makeKey("clearing");
        OAK_SAVANNAH = makeKey("oak_savannah");
        STREAM = makeKey("stream");
        LAKE = makeKey("lake");
        MUSHROOM_FOREST = makeKey("mushroom_forest");
        DENSE_MUSHROOM_FOREST = makeKey("dense_mushroom_forest");
        ENCHANTED_FOREST = makeKey("enchanted_forest");
        SPOOKY_FOREST = makeKey("spooky_forest");
        SWAMP = makeKey("swamp");
        FIRE_SWAMP = makeKey("fire_swamp");
        DARK_FOREST = makeKey("dark_forest");
        DARK_FOREST_CENTER = makeKey("dark_forest_center");
        SNOWY_FOREST = makeKey("snowy_forest");
        GLACIER = makeKey("glacier");
        HIGHLANDS = makeKey("highlands");
        THORNLANDS = makeKey("thornlands");
        FINAL_PLATEAU = makeKey("final_plateau");
        TWILIGHT = BiomeDictionary.Type.getType("TWILIGHT", new BiomeDictionary.Type[0]);
    }
}
