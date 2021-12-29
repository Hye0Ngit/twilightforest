// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.ChatFormatting;
import org.apache.logging.log4j.LogManager;
import net.minecraft.server.packs.PackResources;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.packs.repository.Pack;
import java.util.Locale;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;
import com.mojang.brigadier.CommandDispatcher;
import twilightforest.command.TFCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraft.world.level.block.Block;
import com.google.common.collect.Maps;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.core.cauldron.CauldronInteraction;
import twilightforest.dispenser.TFDispenserBehaviors;
import twilightforest.world.components.feature.BlockSpikeFeature;
import twilightforest.util.TFStats;
import twilightforest.world.registration.TFDimensions;
import twilightforest.advancements.TFAdvancements;
import twilightforest.network.TFPacketHandler;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import twilightforest.item.FieryPickItem;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import twilightforest.loot.TFTreasure;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import twilightforest.item.recipe.UncraftingEnabledCondition;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.nio.file.Path;
import java.io.IOException;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraftforge.resource.PathResourcePack;
import net.minecraftforge.fml.ModList;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import org.apache.commons.lang3.tuple.Pair;
import net.minecraft.world.level.block.state.properties.WoodType;
import twilightforest.compat.TFCompat;
import twilightforest.world.components.BiomeGrassColors;
import twilightforest.world.registration.TwilightFeatures;
import twilightforest.enchantment.TFEnchantments;
import twilightforest.inventory.TFContainers;
import twilightforest.world.registration.TFBiomeFeatures;
import twilightforest.world.registration.TFStructures;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import twilightforest.client.particle.TFParticleType;
import twilightforest.item.recipe.TFRecipes;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.sounds.SoundEvent;
import twilightforest.world.registration.biomes.BiomeKeys;
import twilightforest.potions.TFMobEffects;
import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;
import net.minecraft.world.entity.Entity;
import twilightforest.capabilities.CapabilityList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import java.util.function.Consumer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.ModLoadingContext;
import java.util.function.Function;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraft.world.item.Rarity;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.fml.common.Mod;

@Mod("twilightforest")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwilightForestMod
{
    public static final String ID = "twilightforest";
    private static final String MODEL_DIR = "textures/model/";
    private static final String GUI_DIR = "textures/gui/";
    private static final String ENVIRO_DIR = "textures/environment/";
    public static final String ARMOR_DIR = "twilightforest:textures/armor/";
    public static final GameRules.Key<GameRules.BooleanValue> ENFORCED_PROGRESSION_RULE;
    public static final Logger LOGGER;
    private static final Rarity rarity;
    
    public TwilightForestMod() {
        final Pair<TFConfig.Common, ForgeConfigSpec> specPair = (Pair<TFConfig.Common, ForgeConfigSpec>)new ForgeConfigSpec.Builder().configure((Function)TFConfig.Common::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, (IConfigSpec)specPair.getRight());
        TFConfig.COMMON_CONFIG = (TFConfig.Common)specPair.getLeft();
        final Pair<TFConfig.Client, ForgeConfigSpec> specPair2 = (Pair<TFConfig.Client, ForgeConfigSpec>)new ForgeConfigSpec.Builder().configure((Function)TFConfig.Client::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, (IConfigSpec)specPair2.getRight());
        TFConfig.CLIENT_CONFIG = (TFConfig.Client)specPair2.getLeft();
        ASMHooks.registerMultipartEvents(MinecraftForge.EVENT_BUS);
        MinecraftForge.EVENT_BUS.addListener((Consumer)this::registerCommands);
        final IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener((Consumer)CapabilityList::registerCapabilities);
        MinecraftForge.EVENT_BUS.addGenericListener((Class)Entity.class, (Consumer)CapabilityList::attachEntityCapability);
        TFBlocks.BLOCKS.register(modbus);
        TFItems.ITEMS.register(modbus);
        TFMobEffects.MOB_EFFECTS.register(modbus);
        BiomeKeys.BIOMES.register(modbus);
        modbus.addGenericListener((Class)SoundEvent.class, (Consumer)TFSounds::registerSounds);
        TFBlockEntities.TILE_ENTITIES.register(modbus);
        TFRecipes.RECIPE_SERIALIZERS.register(modbus);
        TFParticleType.PARTICLE_TYPES.register(modbus);
        modbus.addGenericListener((Class)StructureFeature.class, (Consumer)TFStructures::register);
        MinecraftForge.EVENT_BUS.addListener((Consumer)TFStructures::load);
        TFBiomeFeatures.FEATURES.register(modbus);
        TFContainers.CONTAINERS.register(modbus);
        TFEnchantments.ENCHANTMENTS.register(modbus);
        new TwilightFeatures();
        new BiomeGrassColors();
        if (TFConfig.COMMON_CONFIG.doCompat.get()) {
            try {
                TFCompat.preInitCompat();
            }
            catch (Exception e) {
                TFConfig.COMMON_CONFIG.doCompat.set((Object)false);
                TwilightForestMod.LOGGER.error("Had an error loading preInit compatibility!");
                TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
            }
        }
        else {
            TwilightForestMod.LOGGER.warn("Skipping compatibility!");
        }
        WoodType.m_61844_(TFBlocks.TWILIGHT_OAK);
        WoodType.m_61844_(TFBlocks.CANOPY);
        WoodType.m_61844_(TFBlocks.MANGROVE);
        WoodType.m_61844_(TFBlocks.DARKWOOD);
        WoodType.m_61844_(TFBlocks.TIMEWOOD);
        WoodType.m_61844_(TFBlocks.TRANSFORMATION);
        WoodType.m_61844_(TFBlocks.MINING);
        WoodType.m_61844_(TFBlocks.SORTING);
    }
    
    @SubscribeEvent
    public static void addClassicPack(final AddPackFindersEvent event) {
        try {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                final Path resourcePath = ModList.get().getModFileById("twilightforest").getFile().findResource(new String[] { "classic" });
                final PathResourcePack pack = new PathResourcePack(ModList.get().getModFileById("twilightforest").getFile().getFileName() + ":" + resourcePath, resourcePath);
                final PackMetadataSection metadataSection = (PackMetadataSection)pack.m_5550_((MetadataSectionSerializer)PackMetadataSection.f_10366_);
                if (metadataSection != null) {
                    event.addRepositorySource((packConsumer, packConstructor) -> packConsumer.accept(packConstructor.create("builtin/twilight_forest_legacy_resources", (Component)new TextComponent("Twilight Classic"), false, () -> pack, metadataSection, Pack.Position.TOP, PackSource.f_10528_, false)));
                }
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @SubscribeEvent
    public static void registerSerializers(final RegistryEvent.Register<RecipeSerializer<?>> evt) {
        CraftingHelper.register((IConditionSerializer)new UncraftingEnabledCondition.Serializer());
        TFTreasure.init();
    }
    
    @SubscribeEvent
    public static void registerLootModifiers(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> evt) {
        evt.getRegistry().register((IForgeRegistryEntry)new FieryPickItem.Serializer().setRegistryName("twilightforest:fiery_pick_smelting"));
        evt.getRegistry().register((IForgeRegistryEntry)new TFEventListener.Serializer().setRegistryName("twilightforest:giant_block_grouping"));
    }
    
    @SubscribeEvent
    public void sendIMCs(final InterModEnqueueEvent evt) {
        TFCompat.IMCSender();
    }
    
    @SubscribeEvent
    public static void init(final FMLCommonSetupEvent evt) {
        TFPacketHandler.init();
        TFAdvancements.init();
        BiomeKeys.addBiomeTypes();
        TFDimensions.init();
        TFStats.init();
        if (TFConfig.COMMON_CONFIG.doCompat.get()) {
            try {
                TFCompat.initCompat();
            }
            catch (Exception e) {
                TFConfig.COMMON_CONFIG.doCompat.set((Object)false);
                TwilightForestMod.LOGGER.error("Had an error loading init compatibility!");
                TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
            }
        }
        if (TFConfig.COMMON_CONFIG.doCompat.get()) {
            try {
                TFCompat.postInitCompat();
            }
            catch (Exception e) {
                TFConfig.COMMON_CONFIG.doCompat.set((Object)false);
                TwilightForestMod.LOGGER.error("Had an error loading postInit compatibility!");
                TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
            }
        }
        TFConfig.build();
        BlockSpikeFeature.loadStalactites();
        evt.enqueueWork(() -> {
            TFBlocks.tfCompostables();
            TFBlocks.tfBurnables();
            TFBlocks.tfPots();
            TFSounds.registerParrotSounds();
            TFDispenserBehaviors.init();
            CauldronInteraction.f_175607_.put(TFItems.ARCTIC_HELMET.get(), CauldronInteraction.f_175615_);
            CauldronInteraction.f_175607_.put(TFItems.ARCTIC_CHESTPLATE.get(), CauldronInteraction.f_175615_);
            CauldronInteraction.f_175607_.put(TFItems.ARCTIC_LEGGINGS.get(), CauldronInteraction.f_175615_);
            CauldronInteraction.f_175607_.put(TFItems.ARCTIC_BOOTS.get(), CauldronInteraction.f_175615_);
            (AxeItem.f_150683_ = Maps.newHashMap(AxeItem.f_150683_)).put(TFBlocks.TWILIGHT_OAK_LOG.get(), TFBlocks.STRIPPED_TWILIGHT_OAK_LOG.get());
            AxeItem.f_150683_.put(TFBlocks.CANOPY_LOG.get(), TFBlocks.STRIPPED_CANOPY_LOG.get());
            AxeItem.f_150683_.put(TFBlocks.MANGROVE_LOG.get(), TFBlocks.STRIPPED_MANGROVE_LOG.get());
            AxeItem.f_150683_.put(TFBlocks.DARK_LOG.get(), TFBlocks.STRIPPED_DARK_LOG.get());
            AxeItem.f_150683_.put(TFBlocks.TIME_LOG.get(), TFBlocks.STRIPPED_TIME_LOG.get());
            AxeItem.f_150683_.put(TFBlocks.TRANSFORMATION_LOG.get(), TFBlocks.STRIPPED_TRANSFORMATION_LOG.get());
            AxeItem.f_150683_.put(TFBlocks.MINING_LOG.get(), TFBlocks.STRIPPED_MINING_LOG.get());
            AxeItem.f_150683_.put(TFBlocks.SORTING_LOG.get(), TFBlocks.STRIPPED_SORTING_LOG.get());
            AxeItem.f_150683_.put(TFBlocks.TWILIGHT_OAK_WOOD.get(), TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD.get());
            AxeItem.f_150683_.put(TFBlocks.CANOPY_WOOD.get(), TFBlocks.STRIPPED_CANOPY_WOOD.get());
            AxeItem.f_150683_.put(TFBlocks.MANGROVE_WOOD.get(), TFBlocks.STRIPPED_MANGROVE_WOOD.get());
            AxeItem.f_150683_.put(TFBlocks.DARK_WOOD.get(), TFBlocks.STRIPPED_DARK_WOOD.get());
            AxeItem.f_150683_.put(TFBlocks.TIME_WOOD.get(), TFBlocks.STRIPPED_TIME_WOOD.get());
            AxeItem.f_150683_.put(TFBlocks.TRANSFORMATION_WOOD.get(), TFBlocks.STRIPPED_TRANSFORMATION_WOOD.get());
            AxeItem.f_150683_.put(TFBlocks.MINING_WOOD.get(), TFBlocks.STRIPPED_MINING_WOOD.get());
            AxeItem.f_150683_.put(TFBlocks.SORTING_WOOD.get(), TFBlocks.STRIPPED_SORTING_WOOD.get());
        });
    }
    
    public void registerCommands(final RegisterCommandsEvent event) {
        TFCommand.register((CommandDispatcher<CommandSourceStack>)event.getDispatcher());
    }
    
    public static ResourceLocation prefix(final String name) {
        return new ResourceLocation("twilightforest", name.toLowerCase(Locale.ROOT));
    }
    
    public static ResourceLocation getModelTexture(final String name) {
        return new ResourceLocation("twilightforest", "textures/model/" + name);
    }
    
    public static ResourceLocation getGuiTexture(final String name) {
        return new ResourceLocation("twilightforest", "textures/gui/" + name);
    }
    
    public static ResourceLocation getEnvTexture(final String name) {
        return new ResourceLocation("twilightforest", "textures/environment/" + name);
    }
    
    public static Rarity getRarity() {
        return (TwilightForestMod.rarity != null) ? TwilightForestMod.rarity : Rarity.EPIC;
    }
    
    static {
        ENFORCED_PROGRESSION_RULE = GameRules.m_46189_("tfEnforcedProgression", GameRules.Category.UPDATES, GameRules.BooleanValue.m_46250_(true));
        LOGGER = LogManager.getLogger("twilightforest");
        rarity = Rarity.create("TWILIGHT", ChatFormatting.DARK_GREEN);
    }
}
