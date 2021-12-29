// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen;

import net.minecraft.world.gen.placement.IPlacementConfig;
import java.util.ArrayList;
import twilightforest.TwilightForestMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import com.mojang.serialization.Codec;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import twilightforest.worldgen.treeplacers.DangleFromTreeDecorator;
import twilightforest.worldgen.treeplacers.TreeRootsDecorator;
import twilightforest.worldgen.treeplacers.TrunkSideDecorator;
import twilightforest.worldgen.treeplacers.TreeCorePlacer;
import twilightforest.worldgen.treeplacers.LeafSpheroidFoliagePlacer;
import twilightforest.worldgen.treeplacers.HollowTrunkPlacer;
import twilightforest.worldgen.treeplacers.TrunkRiser;
import twilightforest.worldgen.treeplacers.BranchingTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import java.util.List;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public final class TwilightFeatures
{
    private static final List<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES;
    private static final List<TreeDecoratorType<?>> TREE_DECORATOR_TYPES;
    public static final TrunkPlacerType<BranchingTrunkPlacer> TRUNK_BRANCHING;
    public static final TrunkPlacerType<TrunkRiser> TRUNK_RISER;
    public static final TrunkPlacerType<HollowTrunkPlacer> HOLLOW_TRUNK;
    public static final FoliagePlacerType<LeafSpheroidFoliagePlacer> FOLIAGE_SPHEROID;
    public static final TreeDecoratorType<TreeCorePlacer> CORE_PLACER;
    public static final TreeDecoratorType<TrunkSideDecorator> TRUNKSIDE_DECORATOR;
    public static final TreeDecoratorType<TreeRootsDecorator> TREE_ROOTS;
    public static final TreeDecoratorType<DangleFromTreeDecorator> DANGLING_DECORATOR;
    public static final Placement<NoPlacementConfig> PLACEMENT_NOTFSTRUCTURE;
    public static final ConfiguredPlacement<?> CONFIGURED_PLACEMENT_NOTFSTRUCTURE;
    public static final ConfiguredPlacement<?> CONFIGURED_PLACEMENT_NOTFSTRUCTURE_WITHHEIGHTMAP;
    
    private static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliage(final ResourceLocation name, final Codec<P> codec) {
        final FoliagePlacerType<P> type = (FoliagePlacerType<P>)new FoliagePlacerType((Codec)codec);
        type.setRegistryName(name);
        TwilightFeatures.FOLIAGE_PLACER_TYPES.add(type);
        return type;
    }
    
    private static <P extends AbstractTrunkPlacer> TrunkPlacerType<P> registerTrunk(final ResourceLocation name, final Codec<P> codec) {
        return (TrunkPlacerType<P>)Registry.func_218322_a(Registry.field_239701_aw_, name, (Object)new TrunkPlacerType((Codec)codec));
    }
    
    private static <P extends TreeDecorator> TreeDecoratorType<P> registerTreeFeature(final ResourceLocation name, final Codec<P> codec) {
        final TreeDecoratorType<P> type = (TreeDecoratorType<P>)new TreeDecoratorType((Codec)codec);
        type.setRegistryName(name);
        TwilightFeatures.TREE_DECORATOR_TYPES.add(type);
        return type;
    }
    
    protected static <FC extends IFeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, F> registerWorldFeature(final ResourceLocation rl, final ConfiguredFeature<FC, F> feature) {
        return (ConfiguredFeature<FC, F>)Registry.func_218322_a(WorldGenRegistries.field_243653_e, rl, (Object)feature);
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
    public static void registerPlacementConfigs(final RegistryEvent.Register<Placement<?>> evt) {
        evt.getRegistry().register(TwilightFeatures.PLACEMENT_NOTFSTRUCTURE.setRegistryName(TwilightForestMod.prefix("nostructure")));
    }
    
    static {
        FOLIAGE_PLACER_TYPES = new ArrayList<FoliagePlacerType<?>>();
        TREE_DECORATOR_TYPES = new ArrayList<TreeDecoratorType<?>>();
        TRUNK_BRANCHING = registerTrunk(TwilightForestMod.prefix("branching_trunk_placer"), BranchingTrunkPlacer.CODEC);
        TRUNK_RISER = registerTrunk(TwilightForestMod.prefix("trunk_mover_upper"), TrunkRiser.CODEC);
        HOLLOW_TRUNK = registerTrunk(TwilightForestMod.prefix("hollow_trunk_placer"), HollowTrunkPlacer.CODEC);
        FOLIAGE_SPHEROID = registerFoliage(TwilightForestMod.prefix("spheroid_foliage_placer"), LeafSpheroidFoliagePlacer.CODEC);
        CORE_PLACER = registerTreeFeature(TwilightForestMod.prefix("core_placer"), TreeCorePlacer.CODEC);
        TRUNKSIDE_DECORATOR = registerTreeFeature(TwilightForestMod.prefix("trunkside_decorator"), TrunkSideDecorator.CODEC);
        TREE_ROOTS = registerTreeFeature(TwilightForestMod.prefix("tree_roots"), TreeRootsDecorator.CODEC);
        DANGLING_DECORATOR = registerTreeFeature(TwilightForestMod.prefix("dangle_from_tree_decorator"), DangleFromTreeDecorator.CODEC);
        PLACEMENT_NOTFSTRUCTURE = new OutOfStructurePlacement((Codec<NoPlacementConfig>)NoPlacementConfig.field_236555_a_);
        CONFIGURED_PLACEMENT_NOTFSTRUCTURE = TwilightFeatures.PLACEMENT_NOTFSTRUCTURE.func_227446_a_((IPlacementConfig)NoPlacementConfig.field_236556_b_);
        CONFIGURED_PLACEMENT_NOTFSTRUCTURE_WITHHEIGHTMAP = TwilightFeatures.CONFIGURED_PLACEMENT_NOTFSTRUCTURE.func_227228_a_(Placement.field_242904_h.func_227446_a_((IPlacementConfig)NoPlacementConfig.field_236556_b_));
    }
}
