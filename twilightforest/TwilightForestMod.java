// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.util.text.TextFormatting;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.tileentity.spawner.TileEntityTFFinalBossSpawner;
import twilightforest.tileentity.spawner.TileEntityTFAlphaYetiSpawner;
import twilightforest.tileentity.spawner.TileEntityTFMinoshroomSpawner;
import twilightforest.tileentity.TileEntityTFCinderFurnace;
import twilightforest.tileentity.spawner.TileEntityTFSnowQueenSpawner;
import twilightforest.tileentity.spawner.TileEntityTFKnightPhantomsSpawner;
import twilightforest.tileentity.TileEntityTFCReactorActive;
import twilightforest.tileentity.TileEntityTFGhastTrapActive;
import twilightforest.tileentity.TileEntityTFGhastTrapInactive;
import twilightforest.tileentity.spawner.TileEntityTFTowerBossSpawner;
import twilightforest.tileentity.TileEntityTFTrophy;
import twilightforest.tileentity.TileEntityTFAntibuilder;
import twilightforest.tileentity.TileEntityTFTowerBuilder;
import twilightforest.tileentity.TileEntityTFFlameJet;
import twilightforest.tileentity.TileEntityTFPoppingJet;
import twilightforest.tileentity.TileEntityTFSmoker;
import twilightforest.tileentity.spawner.TileEntityTFHydraSpawner;
import twilightforest.tileentity.spawner.TileEntityTFLichSpawner;
import net.minecraftforge.fml.common.registry.GameRegistry;
import twilightforest.tileentity.spawner.TileEntityTFNagaSpawner;
import net.minecraftforge.common.DimensionManager;
import net.minecraft.command.ICommand;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import twilightforest.world.feature.TFGenCaveStalactite;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import twilightforest.loot.TFTreasure;
import twilightforest.advancements.TFAdvancements;
import twilightforest.network.TFPacketHandler;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import twilightforest.item.TFItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import twilightforest.compat.TFCompat;
import twilightforest.structures.hollowtree.TFHollowTreePieces;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import twilightforest.structures.start.StructureStartNothing;
import twilightforest.capabilities.CapabilityList;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraft.item.EnumRarity;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.DimensionType;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "twilightforest", name = "The Twilight Forest", version = "3.11.1021", acceptedMinecraftVersions = "[1.12.2]", dependencies = "after:ctm@[MC1.12.2-0.3.2.18,);before:immersiveengineering@[0.12-83,);before:tconstruct;required-after:forge@[14.23.5.2813,);after:thaumcraft@[6.1.BETA21,)", updateJSON = "https://raw.githubusercontent.com/TeamTwilight/twilightforest/1.12.x/update.json")
public class TwilightForestMod
{
    public static final String ID = "twilightforest";
    public static final String NAME = "The Twilight Forest";
    public static final String VERSION = "3.11.1021";
    private static final String MODEL_DIR = "textures/model/";
    private static final String GUI_DIR = "textures/gui/";
    private static final String ENVIRO_DIR = "textures/environment/";
    public static final String ARMOR_DIR = "twilightforest:textures/armor/";
    public static final String ENFORCED_PROGRESSION_RULE = "tfEnforcedProgression";
    public static final int GUI_ID_UNCRAFTING = 1;
    public static final int GUI_ID_FURNACE = 2;
    public static DimensionType dimType;
    public static int backupDimensionID;
    public static final Logger LOGGER;
    private static final EnumRarity rarity;
    private static boolean compat;
    @Mod.Instance("twilightforest")
    public static TwilightForestMod instance;
    @SidedProxy(clientSide = "twilightforest.client.TFClientProxy", serverSide = "twilightforest.TFCommonProxy")
    public static TFCommonProxy proxy;
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        if (Loader.isModLoaded("sponge")) {
            TwilightForestMod.LOGGER.info("It looks like you have Sponge installed! You may notice Hydras spawning incorrectly with floating heads.\nIf so, please update Sponge to resolve this issue. Have fun!");
        }
        registerTileEntities();
        TwilightForestMod.dimType = DimensionType.register("twilight_forest", "_twilightforest", TFConfig.dimension.dimensionID, (Class)WorldProviderTwilightForest.class, false);
        WorldProviderTwilightForest.syncFromConfig();
        TwilightForestMod.proxy.preInit();
        CapabilityList.registerCapabilities();
        TFFeature.init();
        TwilightForestMod.LOGGER.debug("There are {} entries in TFFeature enum. Maximum structure size is {}", (Object)TFFeature.getCount(), (Object)TFFeature.getMaxSize());
        MapGenStructureIO.func_143034_b((Class)StructureStartNothing.class, "TFNothing");
        TFHollowTreePieces.registerPieces();
        TwilightForestMod.compat = TFConfig.doCompat;
        if (TwilightForestMod.compat) {
            try {
                TFCompat.preInitCompat();
            }
            catch (Exception e) {
                TwilightForestMod.compat = false;
                TwilightForestMod.LOGGER.error("Had an error loading preInit compatibility!");
                TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
            }
        }
        else {
            TwilightForestMod.LOGGER.warn("Skipping compatibility!");
        }
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent evt) {
        TFItems.initRepairMaterials();
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)TwilightForestMod.instance, (IGuiHandler)TwilightForestMod.proxy);
        TFPacketHandler.init();
        TwilightForestMod.proxy.init();
        TFAdvancements.init();
        TFTreasure.init();
        if (TwilightForestMod.compat) {
            try {
                TFCompat.initCompat();
            }
            catch (Exception e) {
                TwilightForestMod.compat = false;
                TwilightForestMod.LOGGER.error("Had an error loading init compatibility!");
                TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
            }
        }
        TFDataFixers.init();
    }
    
    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent evt) {
        registerDimension();
        checkOriginDimension();
        if (TwilightForestMod.compat) {
            try {
                TFCompat.postInitCompat();
            }
            catch (Exception e) {
                TwilightForestMod.compat = false;
                TwilightForestMod.LOGGER.error("Had an error loading postInit compatibility!");
                TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
            }
        }
        TFConfig.build();
        TFGenCaveStalactite.loadStalactites();
    }
    
    @Mod.EventHandler
    public void onIMC(final FMLInterModComms.IMCEvent event) {
        IMCHandler.onIMC(event);
    }
    
    @Mod.EventHandler
    public void startServer(final FMLServerStartingEvent event) {
        event.registerServerCommand((ICommand)new CommandTF());
    }
    
    private static void registerDimension() {
        if (DimensionManager.isDimensionRegistered(TFConfig.dimension.dimensionID)) {
            TwilightForestMod.LOGGER.warn("Detected that the configured dimension ID '{}' is being used. Using backup ID ({}). It is recommended that you configure this mod to use a unique dimension ID.", (Object)TFConfig.dimension.dimensionID, (Object)TwilightForestMod.backupDimensionID);
            TFConfig.dimension.dimensionID = TwilightForestMod.backupDimensionID;
        }
        DimensionManager.registerDimension(TFConfig.dimension.dimensionID, TwilightForestMod.dimType);
    }
    
    static void checkOriginDimension() {
        if (!DimensionManager.isDimensionRegistered(TFConfig.originDimension)) {
            TwilightForestMod.LOGGER.warn("Detected that the configured origin dimension ID ({}) is not registered. Defaulting to the overworld.", (Object)TFConfig.originDimension);
            TFConfig.originDimension = 0;
        }
        else if (TFConfig.originDimension == TFConfig.dimension.dimensionID) {
            TwilightForestMod.LOGGER.warn("Detected that the configured origin dimension ID ({}) is already used for the Twilight Forest. Defaulting to the overworld.", (Object)TFConfig.originDimension);
            TFConfig.originDimension = 0;
        }
    }
    
    private static void registerTileEntities() {
        TwilightForestMod.proxy.registerCritterTileEntities();
        GameRegistry.registerTileEntity((Class)TileEntityTFNagaSpawner.class, prefix("naga_spawner"));
        GameRegistry.registerTileEntity((Class)TileEntityTFLichSpawner.class, prefix("lich_spawner"));
        GameRegistry.registerTileEntity((Class)TileEntityTFHydraSpawner.class, prefix("hydra_spawner"));
        GameRegistry.registerTileEntity((Class)TileEntityTFSmoker.class, prefix("smoker"));
        GameRegistry.registerTileEntity((Class)TileEntityTFPoppingJet.class, prefix("popping_jet"));
        GameRegistry.registerTileEntity((Class)TileEntityTFFlameJet.class, prefix("flame_jet"));
        GameRegistry.registerTileEntity((Class)TileEntityTFTowerBuilder.class, prefix("tower_builder"));
        GameRegistry.registerTileEntity((Class)TileEntityTFAntibuilder.class, prefix("tower_reverter"));
        GameRegistry.registerTileEntity((Class)TileEntityTFTrophy.class, prefix("trophy"));
        GameRegistry.registerTileEntity((Class)TileEntityTFTowerBossSpawner.class, prefix("tower_boss_spawner"));
        GameRegistry.registerTileEntity((Class)TileEntityTFGhastTrapInactive.class, prefix("ghast_trap_inactive"));
        GameRegistry.registerTileEntity((Class)TileEntityTFGhastTrapActive.class, prefix("ghast_trap_active"));
        GameRegistry.registerTileEntity((Class)TileEntityTFCReactorActive.class, prefix("carminite_reactor_active"));
        GameRegistry.registerTileEntity((Class)TileEntityTFKnightPhantomsSpawner.class, prefix("knight_phantom_spawner"));
        GameRegistry.registerTileEntity((Class)TileEntityTFSnowQueenSpawner.class, prefix("snow_queen_spawner"));
        GameRegistry.registerTileEntity((Class)TileEntityTFCinderFurnace.class, prefix("cinder_furnace"));
        GameRegistry.registerTileEntity((Class)TileEntityTFMinoshroomSpawner.class, prefix("minoshroom_spawner"));
        GameRegistry.registerTileEntity((Class)TileEntityTFAlphaYetiSpawner.class, prefix("alpha_yeti_spawner"));
        GameRegistry.registerTileEntity((Class)TileEntityTFFinalBossSpawner.class, prefix("final_boss_spawner"));
    }
    
    public static ResourceLocation prefix(final String name) {
        return new ResourceLocation("twilightforest", name);
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
    
    public static EnumRarity getRarity() {
        return (TwilightForestMod.rarity != null) ? TwilightForestMod.rarity : EnumRarity.EPIC;
    }
    
    static {
        TwilightForestMod.backupDimensionID = -777;
        LOGGER = LogManager.getLogger("twilightforest");
        rarity = EnumHelper.addRarity("TWILIGHT", TextFormatting.DARK_GREEN, "Twilight");
        TwilightForestMod.compat = true;
    }
}
