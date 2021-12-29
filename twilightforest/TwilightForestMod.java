// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.util.text.TextFormatting;
import org.apache.logging.log4j.LogManager;
import java.lang.invoke.SerializedLambda;
import java.util.Locale;
import net.minecraft.util.ResourceLocation;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.CommandDispatcher;
import twilightforest.command.TFCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraft.block.WoodType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.entity.projectile.TwilightWandBoltEntity;
import twilightforest.dispenser.TransformationDispenseBehavior;
import twilightforest.dispenser.CrumbleDispenseBehavior;
import net.minecraft.item.Item;
import twilightforest.dispenser.FeatherFanDispenseBehavior;
import net.minecraft.block.Block;
import twilightforest.block.TrophyBlock;
import net.minecraft.item.ArmorItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.block.DispenserBlock;
import twilightforest.entity.projectile.MoonwormShotEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.IPosition;
import net.minecraft.world.World;
import twilightforest.dispenser.MoonwormDispenseBehavior;
import net.minecraft.util.IItemProvider;
import com.google.common.collect.Maps;
import net.minecraft.item.AxeItem;
import twilightforest.world.feature.TFGenCaveStalactite;
import twilightforest.world.TFDimensions;
import twilightforest.advancements.TFAdvancements;
import twilightforest.network.TFPacketHandler;
import twilightforest.capabilities.CapabilityList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import twilightforest.item.FieryPickItem;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import twilightforest.loot.TFTreasure;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import twilightforest.item.recipe.UncraftingEnabledCondition;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import org.apache.commons.lang3.tuple.Pair;
import twilightforest.compat.TFCompat;
import twilightforest.worldgen.biomes.BiomeGrassColors;
import twilightforest.worldgen.TwilightFeatures;
import twilightforest.inventory.TFContainers;
import twilightforest.world.feature.TFBiomeFeatures;
import net.minecraft.world.gen.feature.structure.Structure;
import twilightforest.client.particle.TFParticleType;
import twilightforest.tileentity.TFTileEntities;
import net.minecraft.util.SoundEvent;
import twilightforest.worldgen.biomes.BiomeKeys;
import twilightforest.potions.TFPotions;
import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import java.util.function.Consumer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.ModLoadingContext;
import java.util.function.Function;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.DistExecutor;
import twilightforest.client.TFClientSetup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.item.Rarity;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.GameRules;
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
    public static final GameRules.RuleKey<GameRules.BooleanValue> ENFORCED_PROGRESSION_RULE;
    public static final Logger LOGGER;
    private static final Rarity rarity;
    
    public TwilightForestMod() {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> TFClientSetup::addLegacyPack);
        final Pair<TFConfig.Common, ForgeConfigSpec> specPair = (Pair<TFConfig.Common, ForgeConfigSpec>)new ForgeConfigSpec.Builder().configure((Function)TFConfig.Common::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, (ForgeConfigSpec)specPair.getRight());
        TFConfig.COMMON_CONFIG = (TFConfig.Common)specPair.getLeft();
        final Pair<TFConfig.Client, ForgeConfigSpec> specPair2 = (Pair<TFConfig.Client, ForgeConfigSpec>)new ForgeConfigSpec.Builder().configure((Function)TFConfig.Client::new);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, (ForgeConfigSpec)specPair2.getRight());
        TFConfig.CLIENT_CONFIG = (TFConfig.Client)specPair2.getLeft();
        ASMHooks.registerMultipartEvents(MinecraftForge.EVENT_BUS);
        MinecraftForge.EVENT_BUS.addListener((Consumer)this::registerCommands);
        final IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        TFBlocks.BLOCKS.register(modbus);
        TFItems.ITEMS.register(modbus);
        TFPotions.POTIONS.register(modbus);
        BiomeKeys.BIOMES.register(modbus);
        modbus.addGenericListener((Class)SoundEvent.class, (Consumer)TFSounds::registerSounds);
        TFTileEntities.TILE_ENTITIES.register(modbus);
        TFParticleType.PARTICLE_TYPES.register(modbus);
        modbus.addGenericListener((Class)Structure.class, (Consumer)TFStructures::register);
        MinecraftForge.EVENT_BUS.addListener((Consumer)TFStructures::load);
        TFBiomeFeatures.FEATURES.register(modbus);
        TFContainers.CONTAINERS.register(modbus);
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
    }
    
    @SubscribeEvent
    public static void registerSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> evt) {
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
        CapabilityList.registerCapabilities();
        TFPacketHandler.init();
        TFAdvancements.init();
        BiomeKeys.addBiomeTypes();
        TFDimensions.init();
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
        TFGenCaveStalactite.loadStalactites();
        evt.enqueueWork(() -> {
            TFBlocks.tfCompostables();
            TFBlocks.TFBurnables();
            TFBlocks.TFPots();
            TFSounds.registerParrotSounds();
            (AxeItem.field_203176_a = Maps.newHashMap(AxeItem.field_203176_a)).put(TFBlocks.oak_log.get(), TFBlocks.stripped_oak_log.get());
            AxeItem.field_203176_a.put(TFBlocks.canopy_log.get(), TFBlocks.stripped_canopy_log.get());
            AxeItem.field_203176_a.put(TFBlocks.mangrove_log.get(), TFBlocks.stripped_mangrove_log.get());
            AxeItem.field_203176_a.put(TFBlocks.dark_log.get(), TFBlocks.stripped_dark_log.get());
            AxeItem.field_203176_a.put(TFBlocks.time_log.get(), TFBlocks.stripped_time_log.get());
            AxeItem.field_203176_a.put(TFBlocks.transformation_log.get(), TFBlocks.stripped_transformation_log.get());
            AxeItem.field_203176_a.put(TFBlocks.mining_log.get(), TFBlocks.stripped_mining_log.get());
            AxeItem.field_203176_a.put(TFBlocks.sorting_log.get(), TFBlocks.stripped_sorting_log.get());
            AxeItem.field_203176_a.put(TFBlocks.oak_wood.get(), TFBlocks.stripped_oak_wood.get());
            AxeItem.field_203176_a.put(TFBlocks.canopy_wood.get(), TFBlocks.stripped_canopy_wood.get());
            AxeItem.field_203176_a.put(TFBlocks.mangrove_wood.get(), TFBlocks.stripped_mangrove_wood.get());
            AxeItem.field_203176_a.put(TFBlocks.dark_wood.get(), TFBlocks.stripped_dark_wood.get());
            AxeItem.field_203176_a.put(TFBlocks.time_wood.get(), TFBlocks.stripped_time_wood.get());
            AxeItem.field_203176_a.put(TFBlocks.transformation_wood.get(), TFBlocks.stripped_transformation_wood.get());
            AxeItem.field_203176_a.put(TFBlocks.mining_wood.get(), TFBlocks.stripped_mining_wood.get());
            AxeItem.field_203176_a.put(TFBlocks.sorting_wood.get(), TFBlocks.stripped_sorting_wood.get());
            DispenserBlock.func_199774_a((IItemProvider)TFItems.moonworm_queen.get(), (IDispenseItemBehavior)new MoonwormDispenseBehavior() {
                @Override
                protected ProjectileEntity getProjectileEntity(final World worldIn, final IPosition position, final ItemStack stackIn) {
                    return (ProjectileEntity)new MoonwormShotEntity(worldIn, position.func_82615_a(), position.func_82617_b(), position.func_82616_c());
                }
            });
            final IDispenseItemBehavior idispenseitembehavior = (IDispenseItemBehavior)new OptionalDispenseBehavior() {
                protected ItemStack func_82487_b(final IBlockSource source, final ItemStack stack) {
                    this.func_239796_a_(ArmorItem.func_226626_a_(source, stack));
                    return stack;
                }
            };
            DispenserBlock.func_199774_a((IItemProvider)((TrophyBlock)TFBlocks.naga_trophy.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((TrophyBlock)TFBlocks.lich_trophy.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((TrophyBlock)TFBlocks.minoshroom_trophy.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((TrophyBlock)TFBlocks.hydra_trophy.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((TrophyBlock)TFBlocks.knight_phantom_trophy.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((TrophyBlock)TFBlocks.ur_ghast_trophy.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((TrophyBlock)TFBlocks.snow_queen_trophy.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((TrophyBlock)TFBlocks.quest_ram_trophy.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((Block)TFBlocks.cicada.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((Block)TFBlocks.firefly.get()).func_199767_j(), idispenseitembehavior);
            DispenserBlock.func_199774_a((IItemProvider)((Block)TFBlocks.moonworm.get()).func_199767_j(), idispenseitembehavior);
            final IDispenseItemBehavior pushmobsbehavior = (IDispenseItemBehavior)new FeatherFanDispenseBehavior();
            DispenserBlock.func_199774_a((IItemProvider)((Item)TFItems.peacock_fan.get()).func_199767_j(), pushmobsbehavior);
            final IDispenseItemBehavior crumblebehavior = (IDispenseItemBehavior)new CrumbleDispenseBehavior();
            DispenserBlock.func_199774_a((IItemProvider)((Item)TFItems.crumble_horn.get()).func_199767_j(), crumblebehavior);
            final IDispenseItemBehavior transformbehavior = (IDispenseItemBehavior)new TransformationDispenseBehavior();
            DispenserBlock.func_199774_a((IItemProvider)((Item)TFItems.transformation_powder.get()).func_199767_j(), transformbehavior);
            DispenserBlock.func_199774_a((IItemProvider)TFItems.twilight_scepter.get(), (IDispenseItemBehavior)new MoonwormDispenseBehavior() {
                @Override
                protected ProjectileEntity getProjectileEntity(final World worldIn, final IPosition position, final ItemStack stackIn) {
                    return (ProjectileEntity)new TwilightWandBoltEntity(worldIn, position.func_82615_a(), position.func_82617_b(), position.func_82616_c());
                }
                
                @Override
                protected void func_82485_a(final IBlockSource source) {
                    final BlockPos pos = source.func_180699_d();
                    source.func_197524_h().func_184133_a((PlayerEntity)null, pos, TFSounds.SCEPTER_PEARL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                }
            });
            return;
        });
        WoodType.func_227047_a_(TFBlocks.TWILIGHT_OAK);
        WoodType.func_227047_a_(TFBlocks.CANOPY);
        WoodType.func_227047_a_(TFBlocks.MANGROVE);
        WoodType.func_227047_a_(TFBlocks.DARKWOOD);
        WoodType.func_227047_a_(TFBlocks.TIMEWOOD);
        WoodType.func_227047_a_(TFBlocks.TRANSFORMATION);
        WoodType.func_227047_a_(TFBlocks.MINING);
        WoodType.func_227047_a_(TFBlocks.SORTING);
    }
    
    public void registerCommands(final RegisterCommandsEvent event) {
        TFCommand.register((CommandDispatcher<CommandSource>)event.getDispatcher());
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
        ENFORCED_PROGRESSION_RULE = GameRules.func_234903_a_("tfEnforcedProgression", GameRules.Category.UPDATES, GameRules.BooleanValue.func_223568_b(true));
        LOGGER = LogManager.getLogger("twilightforest");
        rarity = Rarity.create("TWILIGHT", TextFormatting.DARK_GREEN);
    }
}
