// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.world.gen.feature.IFeatureConfig;
import com.mojang.serialization.Codec;
import twilightforest.structures.start.TFStructure;
import java.util.HashMap;
import twilightforest.world.ChunkGeneratorTwilightBase;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import com.google.common.collect.ImmutableMap;
import net.minecraft.util.ResourceLocation;
import twilightforest.structures.finalcastle.FinalCastlePieces;
import twilightforest.structures.trollcave.TrollCavePieces;
import twilightforest.structures.icetower.IceTowerPieces;
import twilightforest.structures.darktower.DarkTowerPieces;
import twilightforest.structures.stronghold.StrongholdPieces;
import twilightforest.structures.minotaurmaze.MinotaurMazePieces;
import twilightforest.structures.lichtower.LichTowerPieces;
import twilightforest.structures.courtyard.NagaCourtyardPieces;
import twilightforest.structures.mushroomtower.MushroomTowerPieces;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.gen.feature.structure.Structure;
import java.util.Map;

public class TFStructures
{
    public static final Map<Structure<?>, StructureSeparationSettings> SEPARATION_SETTINGS;
    public static final Structure<NoFeatureConfig> HEDGE_MAZE;
    public static final StructureFeature<?, ?> CONFIGURED_HEDGE_MAZE;
    public static final Structure<NoFeatureConfig> QUEST_GROVE;
    public static final StructureFeature<?, ?> CONFIGURED_QUEST_GROVE;
    public static final Structure<NoFeatureConfig> MUSHROOM_TOWER;
    public static final StructureFeature<?, ?> CONFIGURED_MUSHROOM_TOWER;
    public static final Structure<NoFeatureConfig> HOLLOW_HILL_SMALL;
    public static final StructureFeature<?, ?> CONFIGURED_HOLLOW_HILL_SMALL;
    public static final Structure<NoFeatureConfig> HOLLOW_HILL_MEDIUM;
    public static final StructureFeature<?, ?> CONFIGURED_HOLLOW_HILL_MEDIUM;
    public static final Structure<NoFeatureConfig> HOLLOW_HILL_LARGE;
    public static final StructureFeature<?, ?> CONFIGURED_HOLLOW_HILL_LARGE;
    public static final Structure<NoFeatureConfig> NAGA_COURTYARD;
    public static final StructureFeature<?, ?> CONFIGURED_NAGA_COURTYARD;
    public static final Structure<NoFeatureConfig> LICH_TOWER;
    public static final StructureFeature<?, ?> CONFIGURED_LICH_TOWER;
    public static final Structure<NoFeatureConfig> LABYRINTH;
    public static final StructureFeature<?, ?> CONFIGURED_LABYRINTH;
    public static final Structure<NoFeatureConfig> HYDRA_LAIR;
    public static final StructureFeature<?, ?> CONFIGURED_HYDRA_LAIR;
    public static final Structure<NoFeatureConfig> KNIGHT_STRONGHOLD;
    public static final StructureFeature<?, ?> CONFIGURED_KNIGHT_STRONGHOLD;
    public static final Structure<NoFeatureConfig> DARK_TOWER;
    public static final StructureFeature<?, ?> CONFIGURED_DARK_TOWER;
    public static final Structure<NoFeatureConfig> YETI_CAVE;
    public static final StructureFeature<?, ?> CONFIGURED_YETI_CAVE;
    public static final Structure<NoFeatureConfig> AURORA_PALACE;
    public static final StructureFeature<?, ?> CONFIGURED_AURORA_PALACE;
    public static final Structure<NoFeatureConfig> TROLL_CAVE;
    public static final StructureFeature<?, ?> CONFIGURED_TROLL_CAVE;
    public static final Structure<NoFeatureConfig> FINAL_CASTLE;
    public static final StructureFeature<?, ?> CONFIGURED_FINAL_CASTLE;
    
    public static void register(final RegistryEvent.Register<Structure<?>> event) {
        TFStructures.SEPARATION_SETTINGS.clear();
        TFFeature.init();
        new MushroomTowerPieces();
        new NagaCourtyardPieces();
        new LichTowerPieces();
        new MinotaurMazePieces();
        new StrongholdPieces();
        new DarkTowerPieces();
        new IceTowerPieces();
        new TrollCavePieces();
        new FinalCastlePieces();
        register(event, TFStructures.HEDGE_MAZE, TFStructures.CONFIGURED_HEDGE_MAZE, TwilightForestMod.prefix("hedgemaze"), 1, 2);
        register(event, TFStructures.QUEST_GROVE, TFStructures.CONFIGURED_QUEST_GROVE, TwilightForestMod.prefix("questgrove"), 1, 2);
        register(event, TFStructures.MUSHROOM_TOWER, TFStructures.CONFIGURED_MUSHROOM_TOWER, TwilightForestMod.prefix("mushroomtower"), 1, 2);
        register(event, TFStructures.HOLLOW_HILL_SMALL, TFStructures.CONFIGURED_HOLLOW_HILL_SMALL, TwilightForestMod.prefix("hollowhillsmall"), 1, 2);
        register(event, TFStructures.HOLLOW_HILL_MEDIUM, TFStructures.CONFIGURED_HOLLOW_HILL_MEDIUM, TwilightForestMod.prefix("hollowhillmedium"), 1, 2);
        register(event, TFStructures.HOLLOW_HILL_LARGE, TFStructures.CONFIGURED_HOLLOW_HILL_LARGE, TwilightForestMod.prefix("hollowhilllarge"), 1, 2);
        register(event, TFStructures.NAGA_COURTYARD, TFStructures.CONFIGURED_NAGA_COURTYARD, TwilightForestMod.prefix("courtyard"), 1, 2);
        register(event, TFStructures.LICH_TOWER, TFStructures.CONFIGURED_LICH_TOWER, TwilightForestMod.prefix("lichtower"), 1, 2);
        register(event, TFStructures.LABYRINTH, TFStructures.CONFIGURED_LABYRINTH, TwilightForestMod.prefix("labyrinth"), 1, 2);
        register(event, TFStructures.HYDRA_LAIR, TFStructures.CONFIGURED_HYDRA_LAIR, TwilightForestMod.prefix("hydralair"), 1, 2);
        register(event, TFStructures.KNIGHT_STRONGHOLD, TFStructures.CONFIGURED_KNIGHT_STRONGHOLD, TwilightForestMod.prefix("knightstronghold"), 1, 2);
        register(event, TFStructures.DARK_TOWER, TFStructures.CONFIGURED_DARK_TOWER, TwilightForestMod.prefix("darktower"), 1, 2);
        register(event, TFStructures.YETI_CAVE, TFStructures.CONFIGURED_YETI_CAVE, TwilightForestMod.prefix("yeticave"), 1, 2);
        register(event, TFStructures.AURORA_PALACE, TFStructures.CONFIGURED_AURORA_PALACE, TwilightForestMod.prefix("aurorapalace"), 1, 2);
        register(event, TFStructures.TROLL_CAVE, TFStructures.CONFIGURED_TROLL_CAVE, TwilightForestMod.prefix("trollcave"), 1, 2);
        register(event, TFStructures.FINAL_CASTLE, TFStructures.CONFIGURED_FINAL_CASTLE, TwilightForestMod.prefix("finalcastle"), 1, 2);
    }
    
    private static void register(final RegistryEvent.Register<Structure<?>> event, final Structure<?> structure, final StructureFeature<?, ?> config, final ResourceLocation name, final int min, final int max) {
        event.getRegistry().register(structure.setRegistryName(name));
        Structure.field_236365_a_.put((Object)name.toString(), (Object)structure);
        final StructureSeparationSettings seperation = new StructureSeparationSettings(max, min, 472681346);
        DimensionStructuresSettings.field_236191_b_ = ImmutableMap.builder().putAll((Map)DimensionStructuresSettings.field_236191_b_).put((Object)structure, (Object)seperation).build();
        TFStructures.SEPARATION_SETTINGS.put(structure, seperation);
        Registry.func_218322_a(WorldGenRegistries.field_243654_f, new ResourceLocation(name.func_110624_b(), "configured_".concat(name.func_110623_a())), (Object)config);
        FlatGenerationSettings.field_202247_j.put(structure, config);
    }
    
    public static void load(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld && ((ServerWorld)event.getWorld()).func_72863_F().field_186029_c instanceof ChunkGeneratorTwilightBase) {
            final ServerWorld serverWorld = (ServerWorld)event.getWorld();
            final Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<Structure<?>, StructureSeparationSettings>(serverWorld.func_72863_F().field_186029_c.func_235957_b_().func_236195_a_());
            tempMap.putAll(TFStructures.SEPARATION_SETTINGS);
            serverWorld.func_72863_F().field_186029_c.func_235957_b_().field_236193_d_ = tempMap;
        }
    }
    
    static {
        SEPARATION_SETTINGS = new HashMap<Structure<?>, StructureSeparationSettings>();
        HEDGE_MAZE = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.HEDGE_MAZE);
        CONFIGURED_HEDGE_MAZE = TFStructures.HEDGE_MAZE.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        QUEST_GROVE = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.QUEST_GROVE);
        CONFIGURED_QUEST_GROVE = TFStructures.QUEST_GROVE.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        MUSHROOM_TOWER = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.MUSHROOM_TOWER);
        CONFIGURED_MUSHROOM_TOWER = TFStructures.MUSHROOM_TOWER.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        HOLLOW_HILL_SMALL = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.SMALL_HILL);
        CONFIGURED_HOLLOW_HILL_SMALL = TFStructures.HOLLOW_HILL_SMALL.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        HOLLOW_HILL_MEDIUM = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.MEDIUM_HILL);
        CONFIGURED_HOLLOW_HILL_MEDIUM = TFStructures.HOLLOW_HILL_MEDIUM.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        HOLLOW_HILL_LARGE = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.LARGE_HILL);
        CONFIGURED_HOLLOW_HILL_LARGE = TFStructures.HOLLOW_HILL_LARGE.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        NAGA_COURTYARD = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.NAGA_COURTYARD, true);
        CONFIGURED_NAGA_COURTYARD = TFStructures.NAGA_COURTYARD.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        LICH_TOWER = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.LICH_TOWER);
        CONFIGURED_LICH_TOWER = TFStructures.LICH_TOWER.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        LABYRINTH = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.LABYRINTH);
        CONFIGURED_LABYRINTH = TFStructures.LABYRINTH.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        HYDRA_LAIR = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.HYDRA_LAIR);
        CONFIGURED_HYDRA_LAIR = TFStructures.HYDRA_LAIR.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        KNIGHT_STRONGHOLD = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.KNIGHT_STRONGHOLD);
        CONFIGURED_KNIGHT_STRONGHOLD = TFStructures.KNIGHT_STRONGHOLD.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        DARK_TOWER = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.DARK_TOWER);
        CONFIGURED_DARK_TOWER = TFStructures.DARK_TOWER.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        YETI_CAVE = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.YETI_CAVE);
        CONFIGURED_YETI_CAVE = TFStructures.YETI_CAVE.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        AURORA_PALACE = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.ICE_TOWER);
        CONFIGURED_AURORA_PALACE = TFStructures.AURORA_PALACE.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        TROLL_CAVE = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.TROLL_CAVE);
        CONFIGURED_TROLL_CAVE = TFStructures.TROLL_CAVE.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
        FINAL_CASTLE = new TFStructure<NoFeatureConfig>((com.mojang.serialization.Codec<NoFeatureConfig>)NoFeatureConfig.field_236558_a_, TFFeature.FINAL_CASTLE);
        CONFIGURED_FINAL_CASTLE = TFStructures.FINAL_CASTLE.func_236391_a_((IFeatureConfig)IFeatureConfig.field_202429_e);
    }
}
