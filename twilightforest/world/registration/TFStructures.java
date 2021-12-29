// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import java.util.List;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import com.mojang.serialization.Codec;
import twilightforest.world.components.structures.start.TFStructureStart;
import java.util.HashMap;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.StructureSettings;
import com.google.common.collect.ImmutableMap;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraft.resources.ResourceLocation;
import com.google.common.collect.ImmutableList;
import twilightforest.TwilightForestMod;
import twilightforest.world.components.structures.finalcastle.FinalCastlePieces;
import twilightforest.world.components.structures.trollcave.TrollCavePieces;
import twilightforest.world.components.structures.icetower.IceTowerPieces;
import twilightforest.world.components.structures.darktower.DarkTowerPieces;
import twilightforest.world.components.structures.stronghold.StrongholdPieces;
import twilightforest.world.components.structures.minotaurmaze.MinotaurMazePieces;
import twilightforest.world.components.structures.lichtowerrevamp.LichTowerRevampPieces;
import twilightforest.world.components.structures.lichtower.LichTowerPieces;
import twilightforest.world.components.structures.courtyard.NagaCourtyardPieces;
import twilightforest.world.components.structures.mushroomtower.MushroomTowerPieces;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import java.util.Map;

public class TFStructures
{
    public static final Map<StructureFeature<?>, StructureFeatureConfiguration> SEPARATION_SETTINGS;
    public static final StructureFeature<NoneFeatureConfiguration> HEDGE_MAZE;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_HEDGE_MAZE;
    public static final StructureFeature<NoneFeatureConfiguration> QUEST_GROVE;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_QUEST_GROVE;
    public static final StructureFeature<NoneFeatureConfiguration> MUSHROOM_TOWER;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_MUSHROOM_TOWER;
    public static final StructureFeature<NoneFeatureConfiguration> HOLLOW_HILL_SMALL;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_HOLLOW_HILL_SMALL;
    public static final StructureFeature<NoneFeatureConfiguration> HOLLOW_HILL_MEDIUM;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_HOLLOW_HILL_MEDIUM;
    public static final StructureFeature<NoneFeatureConfiguration> HOLLOW_HILL_LARGE;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_HOLLOW_HILL_LARGE;
    public static final StructureFeature<NoneFeatureConfiguration> NAGA_COURTYARD;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_NAGA_COURTYARD;
    public static final StructureFeature<NoneFeatureConfiguration> LICH_TOWER;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_LICH_TOWER;
    public static final StructureFeature<NoneFeatureConfiguration> LABYRINTH;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_LABYRINTH;
    public static final StructureFeature<NoneFeatureConfiguration> HYDRA_LAIR;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_HYDRA_LAIR;
    public static final StructureFeature<NoneFeatureConfiguration> KNIGHT_STRONGHOLD;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_KNIGHT_STRONGHOLD;
    public static final StructureFeature<NoneFeatureConfiguration> DARK_TOWER;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_DARK_TOWER;
    public static final StructureFeature<NoneFeatureConfiguration> YETI_CAVE;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_YETI_CAVE;
    public static final StructureFeature<NoneFeatureConfiguration> AURORA_PALACE;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_AURORA_PALACE;
    public static final StructureFeature<NoneFeatureConfiguration> TROLL_CAVE;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_TROLL_CAVE;
    public static final StructureFeature<NoneFeatureConfiguration> FINAL_CASTLE;
    public static final ConfiguredStructureFeature<?, ?> CONFIGURED_FINAL_CASTLE;
    
    public static void register(final RegistryEvent.Register<StructureFeature<?>> event) {
        TFStructures.SEPARATION_SETTINGS.clear();
        TFFeature.init();
        new MushroomTowerPieces();
        new NagaCourtyardPieces();
        new LichTowerPieces();
        new LichTowerRevampPieces();
        new MinotaurMazePieces();
        new StrongholdPieces();
        new DarkTowerPieces();
        new IceTowerPieces();
        new TrollCavePieces();
        new FinalCastlePieces();
        register(event, TFStructures.HEDGE_MAZE, TFStructures.CONFIGURED_HEDGE_MAZE, TwilightForestMod.prefix("hedge_maze"), 1, 2);
        register(event, TFStructures.QUEST_GROVE, TFStructures.CONFIGURED_QUEST_GROVE, TwilightForestMod.prefix("quest_grove"), 1, 2);
        register(event, TFStructures.MUSHROOM_TOWER, TFStructures.CONFIGURED_MUSHROOM_TOWER, TwilightForestMod.prefix("mushroom_tower"), 1, 2);
        register(event, TFStructures.HOLLOW_HILL_SMALL, TFStructures.CONFIGURED_HOLLOW_HILL_SMALL, TwilightForestMod.prefix("hollow_hill_small"), 1, 2);
        register(event, TFStructures.HOLLOW_HILL_MEDIUM, TFStructures.CONFIGURED_HOLLOW_HILL_MEDIUM, TwilightForestMod.prefix("hollow_hill_medium"), 1, 2);
        register(event, TFStructures.HOLLOW_HILL_LARGE, TFStructures.CONFIGURED_HOLLOW_HILL_LARGE, TwilightForestMod.prefix("hollow_hill_large"), 1, 2);
        register(event, TFStructures.NAGA_COURTYARD, TFStructures.CONFIGURED_NAGA_COURTYARD, TwilightForestMod.prefix("courtyard"), 1, 2);
        register(event, TFStructures.LICH_TOWER, TFStructures.CONFIGURED_LICH_TOWER, TwilightForestMod.prefix("lich_tower"), 1, 2);
        register(event, TFStructures.LABYRINTH, TFStructures.CONFIGURED_LABYRINTH, TwilightForestMod.prefix("labyrinth"), 1, 2);
        register(event, TFStructures.HYDRA_LAIR, TFStructures.CONFIGURED_HYDRA_LAIR, TwilightForestMod.prefix("hydra_lair"), 1, 2);
        register(event, TFStructures.KNIGHT_STRONGHOLD, TFStructures.CONFIGURED_KNIGHT_STRONGHOLD, TwilightForestMod.prefix("knight_stronghold"), 1, 2);
        register(event, TFStructures.DARK_TOWER, TFStructures.CONFIGURED_DARK_TOWER, TwilightForestMod.prefix("dark_tower"), 1, 2);
        register(event, TFStructures.YETI_CAVE, TFStructures.CONFIGURED_YETI_CAVE, TwilightForestMod.prefix("yeti_cave"), 1, 2);
        register(event, TFStructures.AURORA_PALACE, TFStructures.CONFIGURED_AURORA_PALACE, TwilightForestMod.prefix("aurora_palace"), 1, 2);
        register(event, TFStructures.TROLL_CAVE, TFStructures.CONFIGURED_TROLL_CAVE, TwilightForestMod.prefix("troll_cave"), 1, 2);
        register(event, TFStructures.FINAL_CASTLE, TFStructures.CONFIGURED_FINAL_CASTLE, TwilightForestMod.prefix("final_castle"), 1, 2);
        StructureFeature.f_67031_ = (List)ImmutableList.builder().addAll((Iterable)StructureFeature.f_67031_).add((Object[])new StructureFeature[] { TFStructures.HEDGE_MAZE, TFStructures.QUEST_GROVE, TFStructures.NAGA_COURTYARD, TFStructures.LICH_TOWER, TFStructures.LABYRINTH, TFStructures.KNIGHT_STRONGHOLD, TFStructures.DARK_TOWER, TFStructures.TROLL_CAVE, TFStructures.FINAL_CASTLE }).build();
    }
    
    private static void register(final RegistryEvent.Register<StructureFeature<?>> event, final StructureFeature<?> structure, final ConfiguredStructureFeature<?, ?> config, final ResourceLocation name, final int min, final int max) {
        event.getRegistry().register((IForgeRegistryEntry)structure.setRegistryName(name));
        StructureFeature.f_67012_.put((Object)name.toString(), (Object)structure);
        final StructureFeatureConfiguration seperation = new StructureFeatureConfiguration(max, min, 472681346);
        StructureSettings.f_64580_ = ImmutableMap.builder().putAll((Map)StructureSettings.f_64580_).put((Object)structure, (Object)seperation).build();
        TFStructures.SEPARATION_SETTINGS.put(structure, seperation);
        Registry.m_122965_(BuiltinRegistries.f_123862_, new ResourceLocation(name.m_135827_(), "configured_".concat(name.m_135815_())), (Object)config);
        FlatLevelGeneratorSettings.f_70349_.put(structure, config);
    }
    
    public static void load(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerLevel && ((ServerLevel)event.getWorld()).m_7726_().f_8328_ instanceof ChunkGeneratorTwilight) {
            final ServerLevel serverWorld = (ServerLevel)event.getWorld();
            final Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<StructureFeature<?>, StructureFeatureConfiguration>(serverWorld.m_7726_().f_8328_.m_62205_().m_64590_());
            tempMap.putAll(TFStructures.SEPARATION_SETTINGS);
            serverWorld.m_7726_().f_8328_.m_62205_().f_64582_ = tempMap;
        }
    }
    
    static {
        SEPARATION_SETTINGS = new HashMap<StructureFeature<?>, StructureFeatureConfiguration>();
        HEDGE_MAZE = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.HEDGE_MAZE);
        CONFIGURED_HEDGE_MAZE = TFStructures.HEDGE_MAZE.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        QUEST_GROVE = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.QUEST_GROVE);
        CONFIGURED_QUEST_GROVE = TFStructures.QUEST_GROVE.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        MUSHROOM_TOWER = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.MUSHROOM_TOWER);
        CONFIGURED_MUSHROOM_TOWER = TFStructures.MUSHROOM_TOWER.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        HOLLOW_HILL_SMALL = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.SMALL_HILL);
        CONFIGURED_HOLLOW_HILL_SMALL = TFStructures.HOLLOW_HILL_SMALL.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        HOLLOW_HILL_MEDIUM = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.MEDIUM_HILL);
        CONFIGURED_HOLLOW_HILL_MEDIUM = TFStructures.HOLLOW_HILL_MEDIUM.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        HOLLOW_HILL_LARGE = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.LARGE_HILL);
        CONFIGURED_HOLLOW_HILL_LARGE = TFStructures.HOLLOW_HILL_LARGE.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        NAGA_COURTYARD = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.NAGA_COURTYARD, true);
        CONFIGURED_NAGA_COURTYARD = TFStructures.NAGA_COURTYARD.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        LICH_TOWER = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.LICH_TOWER);
        CONFIGURED_LICH_TOWER = TFStructures.LICH_TOWER.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        LABYRINTH = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.LABYRINTH);
        CONFIGURED_LABYRINTH = TFStructures.LABYRINTH.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        HYDRA_LAIR = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.HYDRA_LAIR);
        CONFIGURED_HYDRA_LAIR = TFStructures.HYDRA_LAIR.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        KNIGHT_STRONGHOLD = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.KNIGHT_STRONGHOLD);
        CONFIGURED_KNIGHT_STRONGHOLD = TFStructures.KNIGHT_STRONGHOLD.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        DARK_TOWER = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.DARK_TOWER);
        CONFIGURED_DARK_TOWER = TFStructures.DARK_TOWER.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        YETI_CAVE = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.YETI_CAVE);
        CONFIGURED_YETI_CAVE = TFStructures.YETI_CAVE.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        AURORA_PALACE = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.ICE_TOWER);
        CONFIGURED_AURORA_PALACE = TFStructures.AURORA_PALACE.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        TROLL_CAVE = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.TROLL_CAVE);
        CONFIGURED_TROLL_CAVE = TFStructures.TROLL_CAVE.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        FINAL_CASTLE = new TFStructureStart<NoneFeatureConfiguration>((com.mojang.serialization.Codec<NoneFeatureConfiguration>)NoneFeatureConfiguration.f_67815_, TFFeature.FINAL_CASTLE);
        CONFIGURED_FINAL_CASTLE = TFStructures.FINAL_CASTLE.m_67065_((FeatureConfiguration)FeatureConfiguration.f_67737_);
    }
}
