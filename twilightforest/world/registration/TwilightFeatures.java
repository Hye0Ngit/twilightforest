// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import java.util.Optional;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;
import twilightforest.world.components.placements.ChunkCenterDecorator;
import twilightforest.world.components.placements.OutOfStructureFilter;
import java.util.ArrayList;
import twilightforest.TwilightForestMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.ConfiguredDecorator;
import twilightforest.world.components.placements.ChunkBlanketingDecorator;
import net.minecraft.world.level.levelgen.feature.configurations.NoneDecoratorConfiguration;
import twilightforest.world.components.placements.StructureClearingConfig;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import twilightforest.world.components.feature.trees.treeplacers.DangleFromTreeDecorator;
import twilightforest.world.components.feature.trees.treeplacers.TreeRootsDecorator;
import twilightforest.world.components.feature.trees.treeplacers.TrunkSideDecorator;
import twilightforest.world.components.feature.trees.treeplacers.TreeCorePlacer;
import twilightforest.world.components.feature.trees.treeplacers.LeafSpheroidFoliagePlacer;
import twilightforest.world.components.feature.trees.treeplacers.TrunkRiser;
import twilightforest.world.components.feature.trees.treeplacers.BranchingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import java.util.List;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public final class TwilightFeatures
{
    private static final List<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES;
    private static final List<TreeDecoratorType<?>> TREE_DECORATOR_TYPES;
    public static final TrunkPlacerType<BranchingTrunkPlacer> TRUNK_BRANCHING;
    public static final TrunkPlacerType<TrunkRiser> TRUNK_RISER;
    public static final FoliagePlacerType<LeafSpheroidFoliagePlacer> FOLIAGE_SPHEROID;
    public static final TreeDecoratorType<TreeCorePlacer> CORE_PLACER;
    public static final TreeDecoratorType<TrunkSideDecorator> TRUNKSIDE_DECORATOR;
    public static final TreeDecoratorType<TreeRootsDecorator> TREE_ROOTS;
    public static final TreeDecoratorType<DangleFromTreeDecorator> DANGLING_DECORATOR;
    public static final FeatureDecorator<StructureClearingConfig> PLACEMENT_NO_STRUCTURE;
    public static final FeatureDecorator<NoneDecoratorConfiguration> CHUNK_CENTERER;
    public static final FeatureDecorator<ChunkBlanketingDecorator.ChunkBlanketingConfig> PLACEMENT_CHUNK_BLANKETING;
    public static final ConfiguredDecorator<?> OCCUPIES_SURFACE_CLEARANCE;
    public static final ConfiguredDecorator<?> OCCUPIES_UNDERGROUND_CLEARANCE;
    public static final ConfiguredDecorator<?> OCCUPIES_STRUCTURE_CLEARANCE;
    public static final ConfiguredDecorator<?> CONFIGURED_CHUNK_CENTERER;
    public static final ConfiguredDecorator<?> CONFIGURED_THORNLANDS_BLANKETING;
    
    private static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliage(final ResourceLocation name, final Codec<P> codec) {
        final FoliagePlacerType<P> type = (FoliagePlacerType<P>)new FoliagePlacerType((Codec)codec);
        type.setRegistryName(name);
        TwilightFeatures.FOLIAGE_PLACER_TYPES.add(type);
        return type;
    }
    
    private static <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunk(final ResourceLocation name, final Codec<P> codec) {
        return (TrunkPlacerType<P>)Registry.m_122965_(Registry.f_122859_, name, (Object)new TrunkPlacerType((Codec)codec));
    }
    
    private static <P extends TreeDecorator> TreeDecoratorType<P> registerTreeFeature(final ResourceLocation name, final Codec<P> codec) {
        final TreeDecoratorType<P> type = (TreeDecoratorType<P>)new TreeDecoratorType((Codec)codec);
        type.setRegistryName(name);
        TwilightFeatures.TREE_DECORATOR_TYPES.add(type);
        return type;
    }
    
    protected static <FC extends FeatureConfiguration, F extends Feature<FC>> ConfiguredFeature<FC, F> registerWorldFeature(final ResourceLocation rl, final ConfiguredFeature<FC, F> feature) {
        return (ConfiguredFeature<FC, F>)Registry.m_122965_(BuiltinRegistries.f_123861_, rl, (Object)feature);
    }
    
    @SubscribeEvent
    public static void registerFoliagePlacers(final RegistryEvent.Register<FoliagePlacerType<?>> evt) {
        evt.getRegistry().registerAll((IForgeRegistryEntry[])TwilightFeatures.FOLIAGE_PLACER_TYPES.toArray((IForgeRegistryEntry[])new FoliagePlacerType[0]));
    }
    
    @SubscribeEvent
    public static void registerTreeDecorators(final RegistryEvent.Register<TreeDecoratorType<?>> evt) {
        evt.getRegistry().registerAll((IForgeRegistryEntry[])TwilightFeatures.TREE_DECORATOR_TYPES.toArray((IForgeRegistryEntry[])new TreeDecoratorType[0]));
    }
    
    @SubscribeEvent
    public static void registerPlacementConfigs(final RegistryEvent.Register<FeatureDecorator<?>> evt) {
        evt.getRegistry().register((IForgeRegistryEntry)TwilightFeatures.PLACEMENT_NO_STRUCTURE.setRegistryName(TwilightForestMod.prefix("no_structure")));
        evt.getRegistry().register((IForgeRegistryEntry)TwilightFeatures.CHUNK_CENTERER.setRegistryName(TwilightForestMod.prefix("chunk_centerer")));
        evt.getRegistry().register((IForgeRegistryEntry)TwilightFeatures.PLACEMENT_CHUNK_BLANKETING.setRegistryName(TwilightForestMod.prefix("chunk_blanketing")));
    }
    
    static {
        FOLIAGE_PLACER_TYPES = new ArrayList<FoliagePlacerType<?>>();
        TREE_DECORATOR_TYPES = new ArrayList<TreeDecoratorType<?>>();
        TRUNK_BRANCHING = registerTrunk(TwilightForestMod.prefix("branching_trunk_placer"), BranchingTrunkPlacer.CODEC);
        TRUNK_RISER = registerTrunk(TwilightForestMod.prefix("trunk_mover_upper"), TrunkRiser.CODEC);
        FOLIAGE_SPHEROID = registerFoliage(TwilightForestMod.prefix("spheroid_foliage_placer"), LeafSpheroidFoliagePlacer.CODEC);
        CORE_PLACER = registerTreeFeature(TwilightForestMod.prefix("core_placer"), TreeCorePlacer.CODEC);
        TRUNKSIDE_DECORATOR = registerTreeFeature(TwilightForestMod.prefix("trunkside_decorator"), TrunkSideDecorator.CODEC);
        TREE_ROOTS = registerTreeFeature(TwilightForestMod.prefix("tree_roots"), TreeRootsDecorator.CODEC);
        DANGLING_DECORATOR = registerTreeFeature(TwilightForestMod.prefix("dangle_from_tree_decorator"), DangleFromTreeDecorator.CODEC);
        PLACEMENT_NO_STRUCTURE = new OutOfStructureFilter(StructureClearingConfig.CODEC);
        CHUNK_CENTERER = new ChunkCenterDecorator((Codec<NoneDecoratorConfiguration>)NoneDecoratorConfiguration.f_67810_);
        PLACEMENT_CHUNK_BLANKETING = new ChunkBlanketingDecorator(ChunkBlanketingDecorator.ChunkBlanketingConfig.CODEC);
        OCCUPIES_SURFACE_CLEARANCE = TwilightFeatures.PLACEMENT_NO_STRUCTURE.m_70720_((DecoratorConfiguration)new StructureClearingConfig(true, false, 0));
        OCCUPIES_UNDERGROUND_CLEARANCE = TwilightFeatures.PLACEMENT_NO_STRUCTURE.m_70720_((DecoratorConfiguration)new StructureClearingConfig(false, true, 0));
        OCCUPIES_STRUCTURE_CLEARANCE = TwilightFeatures.PLACEMENT_NO_STRUCTURE.m_70720_((DecoratorConfiguration)new StructureClearingConfig(true, true, 0));
        CONFIGURED_CHUNK_CENTERER = TwilightFeatures.CHUNK_CENTERER.m_70720_((DecoratorConfiguration)NoneDecoratorConfiguration.f_67811_);
        CONFIGURED_THORNLANDS_BLANKETING = TwilightFeatures.PLACEMENT_CHUNK_BLANKETING.m_70720_((DecoratorConfiguration)new ChunkBlanketingDecorator.ChunkBlanketingConfig(0.7f, Heightmap.Types.OCEAN_FLOOR_WG, Optional.of(TwilightForestMod.prefix("thornlands"))));
    }
}
