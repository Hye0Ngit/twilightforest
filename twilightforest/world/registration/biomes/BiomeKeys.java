// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration.biomes;

import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.TwilightForestMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;

public class BiomeKeys
{
    public static final DeferredRegister<Biome> BIOMES;
    public static final ResourceKey<Biome> FOREST;
    public static final ResourceKey<Biome> DENSE_FOREST;
    public static final ResourceKey<Biome> FIREFLY_FOREST;
    public static final ResourceKey<Biome> CLEARING;
    public static final ResourceKey<Biome> OAK_SAVANNAH;
    public static final ResourceKey<Biome> STREAM;
    public static final ResourceKey<Biome> LAKE;
    public static final ResourceKey<Biome> MUSHROOM_FOREST;
    public static final ResourceKey<Biome> DENSE_MUSHROOM_FOREST;
    public static final ResourceKey<Biome> ENCHANTED_FOREST;
    public static final ResourceKey<Biome> SPOOKY_FOREST;
    public static final ResourceKey<Biome> SWAMP;
    public static final ResourceKey<Biome> FIRE_SWAMP;
    public static final ResourceKey<Biome> DARK_FOREST;
    public static final ResourceKey<Biome> DARK_FOREST_CENTER;
    public static final ResourceKey<Biome> SNOWY_FOREST;
    public static final ResourceKey<Biome> GLACIER;
    public static final ResourceKey<Biome> HIGHLANDS;
    public static final ResourceKey<Biome> THORNLANDS;
    public static final ResourceKey<Biome> FINAL_PLATEAU;
    public static final BiomeDictionary.Type TWILIGHT;
    
    private static ResourceKey<Biome> makeKey(final String name) {
        BiomeKeys.BIOMES.register(name, () -> new Biome.BiomeBuilder().m_47597_(Biome.Precipitation.NONE).m_47595_(Biome.BiomeCategory.NONE).m_47593_(0.0f).m_47611_(0.0f).m_47607_(0.0f).m_47609_(0.0f).m_47603_(new BiomeSpecialEffects.Builder().m_48019_(0).m_48034_(0).m_48037_(0).m_48040_(0).m_48018_()).m_47601_(new BiomeGenerationSettings.Builder().m_47851_(SurfaceBuilders.f_127285_).m_47831_()).m_47605_(new MobSpawnSettings.Builder().m_48381_()).m_47599_(Biome.TemperatureModifier.NONE).m_47592_());
        return (ResourceKey<Biome>)ResourceKey.m_135785_(Registry.f_122885_, TwilightForestMod.prefix(name));
    }
    
    public static void addBiomeTypes() {
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.DENSE_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.FIREFLY_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.LUSH });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.CLEARING, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SPARSE });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.OAK_SAVANNAH, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPARSE });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.STREAM, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.RIVER });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.LAKE, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.OCEAN });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.MUSHROOM_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.DENSE_MUSHROOM_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MUSHROOM });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.ENCHANTED_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.SPOOKY_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.SWAMP, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WET });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.FIRE_SWAMP, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.HOT });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.DARK_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.DARK_FOREST_CENTER, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.SNOWY_FOREST, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.GLACIER, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.WASTELAND });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.HIGHLANDS, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.THORNLANDS, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.WASTELAND });
        BiomeDictionary.addTypes((ResourceKey)BiomeKeys.FINAL_PLATEAU, new BiomeDictionary.Type[] { BiomeKeys.TWILIGHT, BiomeDictionary.Type.MESA, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.WASTELAND });
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
