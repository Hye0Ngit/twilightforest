// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.item.BehaviorTFMobEggDispense;
import net.minecraft.block.BlockDispenser;
import net.minecraft.server.MinecraftServer;
import thaumcraft.api.ThaumcraftApi;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import twilightforest.tileentity.TileEntityTFCinderFurnace;
import twilightforest.tileentity.TileEntityTFSnowQueenSpawner;
import twilightforest.tileentity.TileEntityTFKnightPhantomsSpawner;
import twilightforest.tileentity.TileEntityTFCReactorActive;
import twilightforest.tileentity.TileEntityTFGhastTrapActive;
import twilightforest.tileentity.TileEntityTFGhastTrapInactive;
import twilightforest.tileentity.TileEntityTFTowerBossSpawner;
import twilightforest.tileentity.TileEntityTFTrophy;
import twilightforest.tileentity.TileEntityTFReverter;
import twilightforest.tileentity.TileEntityTFTowerBuilder;
import twilightforest.tileentity.TileEntityTFMoonworm;
import twilightforest.tileentity.TileEntityTFFlameJet;
import twilightforest.tileentity.TileEntityTFPoppingJet;
import twilightforest.tileentity.TileEntityTFSmoker;
import twilightforest.tileentity.TileEntityTFHydraSpawner;
import twilightforest.tileentity.TileEntityTFLichSpawner;
import twilightforest.tileentity.TileEntityTFNagaSpawner;
import twilightforest.tileentity.TileEntityTFCicada;
import cpw.mods.fml.common.registry.GameRegistry;
import twilightforest.tileentity.TileEntityTFFirefly;
import twilightforest.entity.EntityTFSlideBlock;
import twilightforest.entity.EntityTFCubeOfAnnihilation;
import twilightforest.entity.EntityTFChainBlock;
import twilightforest.entity.EntityTFIceSnowball;
import twilightforest.entity.EntitySeekerArrow;
import twilightforest.entity.boss.EntityTFIceBomb;
import twilightforest.entity.boss.EntityTFFallingIce;
import twilightforest.entity.boss.EntityTFThrownPick;
import twilightforest.entity.boss.EntityTFThrownAxe;
import twilightforest.entity.EntityTFCharmEffect;
import twilightforest.entity.EntityTFSlimeProjectile;
import twilightforest.entity.EntityTFMoonwormShot;
import twilightforest.entity.boss.EntityTFLichBomb;
import twilightforest.entity.boss.EntityTFHydraMortar;
import twilightforest.entity.EntityTFTomeBolt;
import twilightforest.entity.EntityTFTwilightWandBolt;
import twilightforest.entity.boss.EntityTFLichBolt;
import twilightforest.entity.EntityTFNatureBolt;
import cpw.mods.fml.common.registry.EntityRegistry;
import twilightforest.entity.boss.EntityTFHydraHead;
import twilightforest.entity.EntityTFRovingCube;
import twilightforest.entity.EntityTFAdherent;
import twilightforest.entity.EntityTFHarbingerCube;
import twilightforest.entity.boss.EntityTFIceCrystal;
import twilightforest.entity.EntityTFArmoredGiant;
import twilightforest.entity.EntityTFGiantMiner;
import twilightforest.entity.EntityTFTroll;
import twilightforest.entity.boss.EntityTFSnowQueen;
import twilightforest.entity.EntityTFIceExploder;
import twilightforest.entity.EntityTFIceShooter;
import twilightforest.entity.EntityTFSnowGuardian;
import twilightforest.entity.EntityTFWinterWolf;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import twilightforest.entity.EntityTFYeti;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import twilightforest.entity.EntityTFHelmetCrab;
import twilightforest.entity.EntityTFGoblinKnightLower;
import twilightforest.entity.EntityTFGoblinKnightUpper;
import twilightforest.entity.EntityTFBlockGoblin;
import twilightforest.entity.boss.EntityTFUrGhast;
import twilightforest.entity.EntityTFTowerBroodling;
import twilightforest.entity.EntityTFTowerTermite;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import twilightforest.entity.EntityTFKingSpider;
import twilightforest.entity.EntityTFMistWolf;
import twilightforest.entity.EntityTFRedcapSapper;
import twilightforest.entity.EntityTFMazeSlime;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.entity.boss.EntityTFMinoshroom;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.entity.EntityTFDeathTome;
import twilightforest.entity.EntityTFMosquitoSwarm;
import twilightforest.entity.EntityTFKobold;
import twilightforest.entity.passive.EntityTFQuestRam;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.entity.passive.EntityTFBunny;
import twilightforest.entity.passive.EntityTFSquirrel;
import twilightforest.entity.passive.EntityTFTinyBird;
import twilightforest.entity.EntityTFLoyalZombie;
import twilightforest.entity.boss.EntityTFLichMinion;
import twilightforest.entity.passive.EntityTFPenguin;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.entity.boss.EntityTFHydra;
import twilightforest.entity.EntityTFHedgeSpider;
import twilightforest.entity.EntityTFWraith;
import twilightforest.entity.EntityTFHostileWolf;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.boss.EntityTFNaga;
import twilightforest.entity.EntityTFSwarmSpider;
import twilightforest.entity.EntityTFRedcap;
import twilightforest.entity.passive.EntityTFDeer;
import twilightforest.entity.passive.EntityTFBighorn;
import net.minecraft.entity.Entity;
import twilightforest.entity.TFCreatures;
import twilightforest.entity.passive.EntityTFBoar;
import net.minecraft.command.ICommand;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.common.DimensionManager;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import twilightforest.item.TFRecipes;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.FMLLog;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.structures.StructureTFMajorFeatureStart;
import net.minecraftforge.common.AchievementPage;
import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.Mod;

@Mod(modid = "TwilightForest", name = "The Twilight Forest", version = "2.3.8dev")
public class TwilightForestMod
{
    public static final String ID = "TwilightForest";
    public static final String VERSION = "2.3.8dev";
    public static final String MODEL_DIR = "twilightforest:textures/model/";
    public static final String GUI_DIR = "twilightforest:textures/gui/";
    public static final String ENVRIO_DIR = "twilightforest:textures/environment/";
    public static final String ARMOR_DIR = "twilightforest:textures/armor/";
    public static final String ENFORCED_PROGRESSION_RULE = "tfEnforcedProgression";
    public static final int GUI_ID_UNCRAFTING = 1;
    public static final int GUI_ID_FURNACE = 2;
    public static int dimensionID;
    public static int backupdimensionID;
    public static int dimensionProviderID;
    public static boolean creatureCompatibility;
    public static boolean silentCicadas;
    public static boolean allowPortalsInOtherDimensions;
    public static boolean adminOnlyPortals;
    public static String twilightForestSeed;
    public static boolean disablePortalCreation;
    public static boolean disableUncrafting;
    public static boolean oldMapGen;
    public static String portalCreationItemString;
    public static float canopyCoverage;
    public static int twilightOakChance;
    public static int idMobWildBoar;
    public static int idMobBighornSheep;
    public static int idMobWildDeer;
    public static int idMobRedcap;
    public static int idMobSwarmSpider;
    public static int idMobNaga;
    public static int idMobNagaSegment;
    public static int idMobSkeletonDruid;
    public static int idMobHostileWolf;
    public static int idMobTwilightWraith;
    public static int idMobHedgeSpider;
    public static int idMobHydra;
    public static int idMobLich;
    public static int idMobPenguin;
    public static int idMobLichMinion;
    public static int idMobLoyalZombie;
    public static int idMobTinyBird;
    public static int idMobSquirrel;
    public static int idMobBunny;
    public static int idMobRaven;
    public static int idMobQuestRam;
    public static int idMobKobold;
    public static int idMobBoggard;
    public static int idMobMosquitoSwarm;
    public static int idMobDeathTome;
    public static int idMobMinotaur;
    public static int idMobMinoshroom;
    public static int idMobFireBeetle;
    public static int idMobSlimeBeetle;
    public static int idMobPinchBeetle;
    public static int idMobMazeSlime;
    public static int idMobRedcapSapper;
    public static int idMobMistWolf;
    public static int idMobKingSpider;
    public static int idMobFirefly;
    public static int idMobMiniGhast;
    public static int idMobTowerGhast;
    public static int idMobTowerGolem;
    public static int idMobTowerTermite;
    public static int idMobTowerBroodling;
    public static int idMobTowerBoss;
    public static int idMobBlockGoblin;
    public static int idMobGoblinKnightUpper;
    public static int idMobGoblinKnightLower;
    public static int idMobHelmetCrab;
    public static int idMobKnightPhantom;
    public static int idMobYeti;
    public static int idMobYetiBoss;
    public static int idMobWinterWolf;
    public static int idMobSnowGuardian;
    public static int idMobStableIceCore;
    public static int idMobUnstableIceCore;
    public static int idMobSnowQueen;
    public static int idMobTroll;
    public static int idMobGiantMiner;
    public static int idMobArmoredGiant;
    public static int idMobIceCrystal;
    public static int idMobHarbingerCube;
    public static int idMobAdherent;
    public static int idMobRovingCube;
    public static int idVehicleSpawnNatureBolt;
    public static int idVehicleSpawnLichBolt;
    public static int idVehicleSpawnTwilightWandBolt;
    public static int idVehicleSpawnTomeBolt;
    public static int idVehicleSpawnHydraMortar;
    public static int idVehicleSpawnLichBomb;
    public static int idVehicleSpawnMoonwormShot;
    public static int idVehicleSpawnSlimeBlob;
    public static int idVehicleSpawnCharmEffect;
    public static int idVehicleSpawnThrownAxe;
    public static int idVehicleSpawnThrownPick;
    public static int idVehicleSpawnFallingIce;
    public static int idVehicleSpawnThrownIce;
    public static int idVehicleSpawnSeekerArrow;
    public static int idVehicleSpawnIceSnowball;
    public static int idVehicleSpawnChainBlock;
    public static int idVehicleSpawnCubeOfAnnihilation;
    public static int idVehicleSpawnSlideBlock;
    public static int idBiomeLake;
    public static int idBiomeTwilightForest;
    public static int idBiomeTwilightForestVariant;
    public static int idBiomeHighlands;
    public static int idBiomeMushrooms;
    public static int idBiomeSwamp;
    public static int idBiomeStream;
    public static int idBiomeSnowfield;
    public static int idBiomeGlacier;
    public static int idBiomeClearing;
    public static int idBiomeOakSavanna;
    public static int idBiomeFireflyForest;
    public static int idBiomeDeepMushrooms;
    public static int idBiomeDarkForestCenter;
    public static int idBiomeHighlandsCenter;
    public static int idBiomeDarkForest;
    public static int idBiomeEnchantedForest;
    public static int idBiomeFireSwamp;
    public static int idBiomeThornlands;
    public static boolean hasBiomeIdConflicts;
    public static boolean hasAssignedBiomeID;
    public static final TFEventListener eventListener;
    public static final TFTickHandler tickHandler;
    public static FMLEventChannel genericChannel;
    @Mod.Instance("TwilightForest")
    public static TwilightForestMod instance;
    @SidedProxy(clientSide = "twilightforest.client.TFClientProxy", serverSide = "twilightforest.TFCommonProxy")
    public static TFCommonProxy proxy;
    
    public TwilightForestMod() {
        TwilightForestMod.instance = this;
    }
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        this.loadConfiguration(config);
        TwilightForestMod.proxy.doPreLoadRegistration();
        TFBlocks.registerBlocks();
        TFItems.registerItems();
        AchievementPage.registerAchievementPage((AchievementPage)new TFAchievementPage());
        new StructureTFMajorFeatureStart();
        TFBiomeBase.assignBlankBiomeIds();
        if (TwilightForestMod.hasAssignedBiomeID) {
            FMLLog.info("[TwilightForest] Twilight Forest mod has auto-assigned some biome IDs.  This will break any existing Twilight Forest saves.", new Object[0]);
            this.saveBiomeIds(config);
        }
        TwilightForestMod.hasBiomeIdConflicts = TFBiomeBase.areThereBiomeIdConflicts();
    }
    
    @Mod.EventHandler
    public void load(final FMLInitializationEvent evt) {
        this.registerCreatures();
        TFRecipes.registerRecipes();
        this.registerTileEntities();
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)TwilightForestMod.instance, (IGuiHandler)TwilightForestMod.proxy);
        MinecraftForge.EVENT_BUS.register((Object)TwilightForestMod.eventListener);
        FMLCommonHandler.instance().bus().register((Object)TwilightForestMod.eventListener);
        FMLCommonHandler.instance().bus().register((Object)TwilightForestMod.tickHandler);
        Item portalItem;
        if (Item.field_150901_e.func_148741_d(TwilightForestMod.portalCreationItemString)) {
            portalItem = (Item)Item.field_150901_e.func_82594_a(TwilightForestMod.portalCreationItemString);
            if (portalItem != Items.field_151045_i) {
                FMLLog.info("Set Twilight Forest portal item to %s", new Object[] { portalItem.func_77658_a() });
            }
        }
        else if (Block.field_149771_c.func_148741_d(TwilightForestMod.portalCreationItemString)) {
            portalItem = Item.func_150898_a((Block)Block.field_149771_c.func_82594_a(TwilightForestMod.portalCreationItemString));
            FMLLog.info("Set Twilight Forest portal item to %s", new Object[] { portalItem.func_77658_a() });
        }
        else {
            FMLLog.info("Twilight Forest config lists portal item as '%s'.  Not found, defaulting to diamond.", new Object[] { TwilightForestMod.portalCreationItemString });
            portalItem = Items.field_151045_i;
        }
        TwilightForestMod.tickHandler.portalItem = portalItem;
        final TFMapPacketHandler mapPacketHandler = new TFMapPacketHandler();
        NetworkRegistry.INSTANCE.newEventDrivenChannel("magicmap").register((Object)mapPacketHandler);
        NetworkRegistry.INSTANCE.newEventDrivenChannel("mazemap").register((Object)mapPacketHandler);
        TwilightForestMod.genericChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel("TwilightForest");
        TwilightForestMod.proxy.doOnLoadRegistration();
        DimensionManager.registerProviderType(TwilightForestMod.dimensionProviderID, (Class)WorldProviderTwilightForest.class, false);
        TFBiomeBase.registerWithBiomeDictionary();
    }
    
    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent evt) {
        if (!DimensionManager.isDimensionRegistered(TwilightForestMod.dimensionID)) {
            DimensionManager.registerDimension(TwilightForestMod.dimensionID, TwilightForestMod.dimensionProviderID);
        }
        else {
            FMLLog.warning("[TwilightForest] Twilight Forest detected that the configured dimension id '%d' is being used.  Using backup ID.  It is recommended that you configure this mod to use a unique dimension ID.", new Object[] { TwilightForestMod.dimensionID });
            DimensionManager.registerDimension(TwilightForestMod.backupdimensionID, TwilightForestMod.dimensionProviderID);
            TwilightForestMod.dimensionID = TwilightForestMod.backupdimensionID;
        }
        if (Loader.isModLoaded("Thaumcraft")) {
            this.registerThaumcraftIntegration();
        }
        else {
            FMLLog.info("[TwilightForest] Did not find Thaumcraft, did not load ThaumcraftApi integration.", new Object[0]);
        }
        TwilightForestMod.hasBiomeIdConflicts = TFBiomeBase.areThereBiomeIdConflicts();
    }
    
    @Mod.EventHandler
    public void startServer(final FMLServerStartingEvent event) {
        this.registerDispenseBehaviors(event.getServer());
        event.registerServerCommand((ICommand)new CommandTFProgress());
    }
    
    private void registerCreatures() {
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFBoar.class, "Wild Boar", TwilightForestMod.idMobWildBoar, 8611131, 16773066);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFBighorn.class, "Bighorn Sheep", TwilightForestMod.idMobBighornSheep, 14405295, 14141297);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFDeer.class, "Wild Deer", TwilightForestMod.idMobWildDeer, 8080686, 4924445);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFRedcap.class, "Redcap", TwilightForestMod.idMobRedcap, 3881580, 11214356);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFSwarmSpider.class, "Swarm Spider", TwilightForestMod.idMobSwarmSpider, 3277358, 1516830);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFNaga.class, "Naga", TwilightForestMod.idMobNaga, 10801942, 1783819);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFSkeletonDruid.class, "Skeleton Druid", TwilightForestMod.idMobSkeletonDruid, 10724259, 2767639);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFHostileWolf.class, "Hostile Wolf", TwilightForestMod.idMobHostileWolf, 14144467, 11214356);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFWraith.class, "Twilight Wraith", TwilightForestMod.idMobTwilightWraith, 5263440, 8618883);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFHedgeSpider.class, "Hedge Spider", TwilightForestMod.idMobHedgeSpider, 2318099, 5645907);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFHydra.class, "Hydra", TwilightForestMod.idMobHydra, 1321280, 2719851);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFLich.class, "Twilight Lich", TwilightForestMod.idMobLich, 11314313, 3540082);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFPenguin.class, "Glacier Penguin", TwilightForestMod.idMobPenguin, 1185051, 16379346);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFLichMinion.class, "Lich Minion", TwilightForestMod.idMobLichMinion);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFLoyalZombie.class, "Loyal Zombie", TwilightForestMod.idMobLoyalZombie);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFTinyBird.class, "Tiny Bird", TwilightForestMod.idMobTinyBird, 3386077, 1149166);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFSquirrel.class, "Forest Squirrel", TwilightForestMod.idMobSquirrel, 9457426, 15658734);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFBunny.class, "Forest Bunny", TwilightForestMod.idMobBunny, 16711406, 13413017);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFRaven.class, "Forest Raven", TwilightForestMod.idMobRaven, 17, 2236979);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFQuestRam.class, "Questing Ram", TwilightForestMod.idMobQuestRam);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFKobold.class, "Twilight Kobold", TwilightForestMod.idMobKobold, 3612822, 9002267);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFMosquitoSwarm.class, "Mosquito Swarm", TwilightForestMod.idMobMosquitoSwarm, 526596, 2961185);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFDeathTome.class, "Death Tome", TwilightForestMod.idMobDeathTome, 7818786, 14405054);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFMinotaur.class, "Minotaur", TwilightForestMod.idMobMinotaur, 4141092, 11173222);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFMinoshroom.class, "Minoshroom", TwilightForestMod.idMobMinoshroom, 11014162, 11173222);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFFireBeetle.class, "Fire Beetle", TwilightForestMod.idMobFireBeetle, 1903360, 13332261);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFSlimeBeetle.class, "Slime Beetle", TwilightForestMod.idMobSlimeBeetle, 792070, 6334284);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFPinchBeetle.class, "Pinch Beetle", TwilightForestMod.idMobPinchBeetle, 12358439, 2364937);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFMazeSlime.class, "Maze Slime", TwilightForestMod.idMobMazeSlime, 10724259, 2767639);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFRedcapSapper.class, "Redcap Sapper", TwilightForestMod.idMobRedcapSapper, 5725473, 11214356);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFMistWolf.class, "Mist Wolf", TwilightForestMod.idMobMistWolf, 3806225, 14862474);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFKingSpider.class, "King Spider", TwilightForestMod.idMobKingSpider, 2890254, 16760855);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFMobileFirefly.class, "Firefly", TwilightForestMod.idMobFirefly, 10801942, 12250626);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFMiniGhast.class, "Mini Ghast", TwilightForestMod.idMobMiniGhast, 12369084, 10961731);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFTowerGhast.class, "Tower Ghast", TwilightForestMod.idMobTowerGhast, 12369084, 12023928);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFTowerGolem.class, "Tower Golem", TwilightForestMod.idMobTowerGolem, 7028000, 14867930);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFTowerTermite.class, "Tower Termite", TwilightForestMod.idMobTowerTermite, 6105889, 11313210);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFTowerBroodling.class, "Redscale Broodling", TwilightForestMod.idMobTowerBroodling, 3423252, 12250626);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFUrGhast.class, "Tower Boss", TwilightForestMod.idMobTowerBoss, 12369084, 12023928);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFBlockGoblin.class, "Block&Chain Goblin", TwilightForestMod.idMobBlockGoblin, 13887420, 2047999);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFGoblinKnightUpper.class, "Upper Goblin Knight", TwilightForestMod.idMobGoblinKnightUpper);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFGoblinKnightLower.class, "Lower Goblin Knight", TwilightForestMod.idMobGoblinKnightLower, 5660757, 13887420);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFHelmetCrab.class, "Helmet Crab", TwilightForestMod.idMobHelmetCrab, 16486475, 13887420);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFKnightPhantom.class, "Knight Phantom", TwilightForestMod.idMobKnightPhantom, 10905403, 13887420);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFYeti.class, "Yeti", TwilightForestMod.idMobYeti, 14606046, 4617659);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFYetiAlpha.class, "Yeti Boss", TwilightForestMod.idMobYetiBoss, 13487565, 2705518);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFWinterWolf.class, "WinterWolf", TwilightForestMod.idMobWinterWolf, 14672869, 11713738);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFSnowGuardian.class, "SnowGuardian", TwilightForestMod.idMobSnowGuardian, 13887420, 16711422);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFIceShooter.class, "Stable Ice Core", TwilightForestMod.idMobStableIceCore, 10600435, 7340280);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFIceExploder.class, "Unstable Ice Core", TwilightForestMod.idMobUnstableIceCore, 10136821, 10162085);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFSnowQueen.class, "Snow Queen", TwilightForestMod.idMobSnowQueen, 11645652, 8847470);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFTroll.class, "Troll", TwilightForestMod.idMobTroll, 10398095, 11572366);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFGiantMiner.class, "Giant Miner", TwilightForestMod.idMobGiantMiner, 2169682, 10132122);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFArmoredGiant.class, "Armored Giant", TwilightForestMod.idMobArmoredGiant, 2331537, 10132122);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFIceCrystal.class, "Ice Crystal", TwilightForestMod.idMobIceCrystal, 14477822, 11389691);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFHarbingerCube.class, "Harbinger Cube", TwilightForestMod.idMobHarbingerCube, 10, 9109504);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFAdherent.class, "Adherent", TwilightForestMod.idMobAdherent, 655360, 139);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFRovingCube.class, "RovingCube", TwilightForestMod.idMobRovingCube, 655360, 155);
        EntityRegistry.registerModEntity((Class)EntityTFHydraHead.class, "HydraHead", 11, (Object)this, 150, 3, false);
        EntityRegistry.registerModEntity((Class)EntityTFNatureBolt.class, "tfnaturebolt", TwilightForestMod.idVehicleSpawnNatureBolt, (Object)this, 150, 5, true);
        EntityRegistry.registerModEntity((Class)EntityTFLichBolt.class, "tflichbolt", TwilightForestMod.idVehicleSpawnLichBolt, (Object)this, 150, 2, true);
        EntityRegistry.registerModEntity((Class)EntityTFTwilightWandBolt.class, "tftwilightwandbolt", TwilightForestMod.idVehicleSpawnTwilightWandBolt, (Object)this, 150, 5, true);
        EntityRegistry.registerModEntity((Class)EntityTFTomeBolt.class, "tftomebolt", TwilightForestMod.idVehicleSpawnTomeBolt, (Object)this, 150, 5, true);
        EntityRegistry.registerModEntity((Class)EntityTFHydraMortar.class, "tfhydramortar", TwilightForestMod.idVehicleSpawnHydraMortar, (Object)this, 150, 3, true);
        EntityRegistry.registerModEntity((Class)EntityTFLichBomb.class, "tflichbomb", TwilightForestMod.idVehicleSpawnLichBomb, (Object)this, 150, 3, true);
        EntityRegistry.registerModEntity((Class)EntityTFMoonwormShot.class, "tfmoonwormshot", TwilightForestMod.idVehicleSpawnMoonwormShot, (Object)this, 150, 3, true);
        EntityRegistry.registerModEntity((Class)EntityTFSlimeProjectile.class, "tfslimeblob", TwilightForestMod.idVehicleSpawnSlimeBlob, (Object)this, 150, 3, true);
        EntityRegistry.registerModEntity((Class)EntityTFCharmEffect.class, "tfcharmeffect", TwilightForestMod.idVehicleSpawnCharmEffect, (Object)this, 80, 3, true);
        EntityRegistry.registerModEntity((Class)EntityTFThrownAxe.class, "tfthrownaxe", TwilightForestMod.idVehicleSpawnThrownAxe, (Object)this, 80, 3, true);
        EntityRegistry.registerModEntity((Class)EntityTFThrownPick.class, "tfthrownpick", TwilightForestMod.idVehicleSpawnThrownPick, (Object)this, 80, 3, true);
        EntityRegistry.registerModEntity((Class)EntityTFFallingIce.class, "tffallingice", TwilightForestMod.idVehicleSpawnFallingIce, (Object)this, 80, 3, true);
        EntityRegistry.registerModEntity((Class)EntityTFIceBomb.class, "tfthrownice", TwilightForestMod.idVehicleSpawnThrownIce, (Object)this, 80, 2, true);
        EntityRegistry.registerModEntity((Class)EntitySeekerArrow.class, "tfSeekerArrow", TwilightForestMod.idVehicleSpawnSeekerArrow, (Object)this, 150, 1, true);
        EntityRegistry.registerModEntity((Class)EntityTFIceSnowball.class, "tficesnowball", TwilightForestMod.idVehicleSpawnIceSnowball, (Object)this, 150, 3, true);
        EntityRegistry.registerModEntity((Class)EntityTFChainBlock.class, "tfchainBlock", TwilightForestMod.idVehicleSpawnChainBlock, (Object)this, 80, 1, true);
        EntityRegistry.registerModEntity((Class)EntityTFCubeOfAnnihilation.class, "tfcubeannihilation", TwilightForestMod.idVehicleSpawnCubeOfAnnihilation, (Object)this, 80, 1, true);
        EntityRegistry.registerModEntity((Class)EntityTFSlideBlock.class, "tfslideblock", TwilightForestMod.idVehicleSpawnSlideBlock, (Object)this, 80, 1, true);
    }
    
    private void registerTileEntities() {
        GameRegistry.registerTileEntity((Class)TileEntityTFFirefly.class, "Firefly");
        GameRegistry.registerTileEntity((Class)TileEntityTFCicada.class, "Cicada");
        GameRegistry.registerTileEntity((Class)TileEntityTFNagaSpawner.class, "Naga Spawner");
        GameRegistry.registerTileEntity((Class)TileEntityTFLichSpawner.class, "Lich Spawner");
        GameRegistry.registerTileEntity((Class)TileEntityTFHydraSpawner.class, "Hydra Spawner");
        GameRegistry.registerTileEntity((Class)TileEntityTFSmoker.class, "Swamp Smoker");
        GameRegistry.registerTileEntity((Class)TileEntityTFPoppingJet.class, "Popping Flame Jet");
        GameRegistry.registerTileEntity((Class)TileEntityTFFlameJet.class, "Lit Flame Jet");
        GameRegistry.registerTileEntity((Class)TileEntityTFMoonworm.class, "Moonworm");
        GameRegistry.registerTileEntity((Class)TileEntityTFTowerBuilder.class, "Tower Builder");
        GameRegistry.registerTileEntity((Class)TileEntityTFReverter.class, "Tower Reverter");
        GameRegistry.registerTileEntity((Class)TileEntityTFTrophy.class, "TF Trophy");
        GameRegistry.registerTileEntity((Class)TileEntityTFTowerBossSpawner.class, "Tower Boss Spawner");
        GameRegistry.registerTileEntity((Class)TileEntityTFGhastTrapInactive.class, "Inactive Ghast Trap");
        GameRegistry.registerTileEntity((Class)TileEntityTFGhastTrapActive.class, "Active Ghast Trap");
        GameRegistry.registerTileEntity((Class)TileEntityTFCReactorActive.class, "Active Carminite Reactor");
        GameRegistry.registerTileEntity((Class)TileEntityTFKnightPhantomsSpawner.class, "Knight Phantom Spawner");
        GameRegistry.registerTileEntity((Class)TileEntityTFSnowQueenSpawner.class, "Snow Queen Spawner");
        GameRegistry.registerTileEntity((Class)TileEntityTFCinderFurnace.class, "Cinder Furnace");
    }
    
    private void registerThaumcraftIntegration() {
        try {
            this.registerTCObjectTag(TFItems.nagaScale, -1, new AspectList().add(Aspect.MOTION, 2).add(Aspect.ARMOR, 3));
            this.registerTCObjectTag(TFItems.scepterTwilight, -1, new AspectList().add(Aspect.MAGIC, 8).add(Aspect.ELDRITCH, 8).add(Aspect.WEAPON, 8));
            this.registerTCObjectTag(TFItems.scepterLifeDrain, -1, new AspectList().add(Aspect.MAGIC, 8).add(Aspect.LIFE, 8).add(Aspect.HUNGER, 8));
            this.registerTCObjectTag(TFItems.scepterZombie, -1, new AspectList().add(Aspect.MAGIC, 8).add(Aspect.UNDEAD, 8).add(Aspect.ENTROPY, 8));
            this.registerTCObjectTag(TFItems.magicMapFocus, -1, new AspectList().add(Aspect.MAGIC, 4).add(Aspect.SENSES, 8));
            this.registerTCObjectTag(TFItems.mazeMapFocus, -1, new AspectList().add(Aspect.MAGIC, 4).add(Aspect.SENSES, 8).add(Aspect.ORDER, 4));
            this.registerTCObjectTag(TFItems.feather, -1, new AspectList().add(Aspect.FLIGHT, 2).add(Aspect.AIR, 1).add(Aspect.DARKNESS, 1));
            this.registerTCObjectTag(TFItems.liveRoot, -1, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.TREE, 2).add(Aspect.LIFE, 2));
            this.registerTCObjectTag(TFItems.ironwoodIngot, -1, new AspectList().add(Aspect.MAGIC, 2).add(Aspect.TREE, 1).add(Aspect.METAL, 4).add(Aspect.CRAFT, 2));
            this.registerTCObjectTag(TFItems.torchberries, -1, new AspectList().add(Aspect.PLANT, 2).add(Aspect.LIGHT, 2));
            this.registerTCObjectTag(TFItems.fieryBlood, -1, new AspectList().add(Aspect.FIRE, 8).add(Aspect.LIFE, 8).add(Aspect.MAGIC, 4));
            this.registerTCObjectTag(TFItems.trophy, -1, new AspectList().add(Aspect.LIFE, 6).add(Aspect.BEAST, 6).add(Aspect.SOUL, 6));
            this.registerTCObjectTag(TFItems.steeleafIngot, -1, new AspectList().add(Aspect.PLANT, 4).add(Aspect.METAL, 2));
            this.registerTCObjectTag(TFItems.minotaurAxe, -1, new AspectList().add(Aspect.TOOL, 2).add(Aspect.WEAPON, 4).add(Aspect.CRYSTAL, 6).add(Aspect.GREED, 8));
            this.registerTCObjectTag(TFItems.mazebreakerPick, -1, new AspectList().add(Aspect.CRYSTAL, 6).add(Aspect.TOOL, 8).add(Aspect.MINE, 8));
            this.registerTCObjectTag(TFItems.oreMagnet, -1, new AspectList().add(Aspect.GREED, 10).add(Aspect.TOOL, 6).add(Aspect.METAL, 8).add(Aspect.MOTION, 6));
            this.registerTCObjectTag(TFItems.crumbleHorn, -1, new AspectList().add(Aspect.ENTROPY, 12).add(Aspect.BEAST, 2));
            this.registerTCObjectTag(TFItems.peacockFan, -1, new AspectList().add(Aspect.AIR, 8).add(Aspect.MOTION, 6).add(Aspect.FLIGHT, 10));
            this.registerTCObjectTag(TFItems.moonwormQueen, -1, new AspectList().add(Aspect.LIGHT, 12).add(Aspect.MAGIC, 1));
            this.registerTCObjectTag(TFItems.charmOfLife1, -1, new AspectList().add(Aspect.LIFE, 2).add(Aspect.HEAL, 2).add(Aspect.GREED, 4));
            this.registerTCObjectTag(TFItems.charmOfKeeping1, -1, new AspectList().add(Aspect.DEATH, 1).add(Aspect.TRAVEL, 2).add(Aspect.GREED, 4));
            this.registerTCObjectTag(TFItems.towerKey, -1, new AspectList().add(Aspect.MECHANISM, 4).add(Aspect.MAGIC, 4));
            this.registerTCObjectTag(TFItems.transformPowder, -1, new AspectList().add(Aspect.MAGIC, 8).add(Aspect.EXCHANGE, 4));
            this.registerTCObjectTag(TFItems.borerEssence, -1, new AspectList().add(Aspect.BEAST, 2).add(Aspect.TREE, 2).add(Aspect.SOUL, 4).add(Aspect.MAGIC, 2));
            this.registerTCObjectTag(TFItems.armorShard, -1, new AspectList().add(Aspect.METAL, 1));
            this.registerTCObjectTag(TFItems.knightMetal, -1, new AspectList().add(Aspect.METAL, 8).add(Aspect.ORDER, 1));
            this.registerTCObjectTag(TFItems.phantomHelm, -1, new AspectList().add(Aspect.METAL, 6).add(Aspect.ARMOR, 6).add(Aspect.UNDEAD, 6));
            this.registerTCObjectTag(TFItems.phantomPlate, -1, new AspectList().add(Aspect.METAL, 8).add(Aspect.ARMOR, 8).add(Aspect.UNDEAD, 8));
            this.registerTCObjectTag(TFItems.armorShard, -1, new AspectList().add(Aspect.METAL, 1));
            this.registerTCObjectTag(TFItems.lampOfCinders, -1, new AspectList().add(Aspect.FIRE, 4).add(Aspect.MAGIC, 4).add(Aspect.TOOL, 4));
            this.registerTCObjectTag(TFItems.fieryTears, -1, new AspectList().add(Aspect.FIRE, 8).add(Aspect.LIFE, 8).add(Aspect.MAGIC, 4));
            this.registerTCObjectTag(TFItems.alphaFur, -1, new AspectList().add(Aspect.COLD, 3).add(Aspect.BEAST, 3).add(Aspect.MAGIC, 4).add(Aspect.ARMOR, 1));
            this.registerTCObjectTag(TFItems.iceBomb, -1, new AspectList().add(Aspect.COLD, 3).add(Aspect.AIR, 1));
            this.registerTCObjectTag(TFItems.arcticFur, -1, new AspectList().add(Aspect.COLD, 3).add(Aspect.BEAST, 3));
            this.registerTCObjectTag(TFItems.tripleBow, -1, new AspectList().add(Aspect.TREE, 6).add(Aspect.BEAST, 6).add(Aspect.CLOTH, 6).add(Aspect.WEAPON, 9).add(Aspect.AIR, 3));
            this.registerTCObjectTag(TFItems.seekerBow, -1, new AspectList().add(Aspect.MIND, 3).add(Aspect.BEAST, 2).add(Aspect.CLOTH, 2).add(Aspect.WEAPON, 3).add(Aspect.AIR, 1));
            this.registerTCObjectTag(TFItems.iceBow, -1, new AspectList().add(Aspect.COLD, 2).add(Aspect.BEAST, 2).add(Aspect.CLOTH, 2).add(Aspect.WEAPON, 3).add(Aspect.AIR, 1));
            this.registerTCObjectTag(TFItems.enderBow, -1, new AspectList().add(Aspect.TRAVEL, 2).add(Aspect.BEAST, 2).add(Aspect.CLOTH, 2).add(Aspect.WEAPON, 3).add(Aspect.AIR, 1));
            this.registerTCObjectTag(TFItems.iceSword, -1, new AspectList().add(Aspect.WEAPON, 4).add(Aspect.CRYSTAL, 4).add(Aspect.COLD, 4));
            this.registerTCObjectTag(TFItems.glassSword, -1, new AspectList().add(Aspect.WEAPON, 5).add(Aspect.CRYSTAL, 4));
            this.registerTCObjectTag(TFItems.cubeTalisman, -1, new AspectList().add(Aspect.VOID, 4).add(Aspect.MAGIC, 4).add(Aspect.ENTROPY, 4));
            this.registerTCObjectTag(TFItems.cubeOfAnnihilation, -1, new AspectList().add(Aspect.VOID, 7).add(Aspect.MAGIC, 7).add(Aspect.ENTROPY, 7));
            this.registerTCObjectTag(TFItems.venisonRaw, -1, new AspectList().add(Aspect.HUNGER, 2).add(Aspect.FLESH, 4).add(Aspect.BEAST, 2));
            this.registerTCObjectTag(TFItems.venisonCooked, -1, new AspectList().add(Aspect.HUNGER, 4).add(Aspect.FLESH, 4).add(Aspect.CRAFT, 1));
            this.registerTCObjectTag(TFItems.hydraChop, -1, new AspectList().add(Aspect.HUNGER, 6).add(Aspect.FLESH, 6).add(Aspect.LIFE, 4));
            this.registerTCObjectTag(TFItems.meefRaw, -1, new AspectList().add(Aspect.BEAST, 2).add(Aspect.FLESH, 4).add(Aspect.LIFE, 2));
            this.registerTCObjectTag(TFItems.meefSteak, -1, new AspectList().add(Aspect.FIRE, 1).add(Aspect.BEAST, 1).add(Aspect.FLESH, 4).add(Aspect.LIFE, 2));
            this.registerTCObjectTag(TFItems.meefStroganoff, -1, new AspectList().add(Aspect.HUNGER, 4).add(Aspect.BEAST, 2).add(Aspect.FLESH, 4));
            this.registerTCObjectTag(TFItems.mazeWafer, -1, new AspectList().add(Aspect.HUNGER, 2));
            this.registerTCObjectTag(TFItems.experiment115, -1, new AspectList().add(Aspect.HUNGER, 3).add(Aspect.MECHANISM, 1));
            this.registerTCObjectTag(TFBlocks.firefly, -1, new AspectList().add(Aspect.FLIGHT, 1).add(Aspect.LIGHT, 2));
            this.registerTCObjectTag(TFBlocks.leaves, -1, new AspectList().add(Aspect.PLANT, 2));
            this.registerTCObjectTag(TFBlocks.mazestone, -1, new AspectList().add(Aspect.ORDER, 2).add(Aspect.TRAP, 1).add(Aspect.ARMOR, 1));
            this.registerTCObjectTag(TFBlocks.hedge, 0, new AspectList().add(Aspect.PLANT, 1).add(Aspect.WEAPON, 1));
            this.registerTCObjectTag(TFBlocks.hedge, 1, new AspectList().add(Aspect.PLANT, 3).add(Aspect.DARKNESS, 1));
            this.registerTCObjectTag(TFBlocks.root, -1, new AspectList().add(Aspect.TREE, 2));
            this.registerTCObjectTag(TFBlocks.cicada, -1, new AspectList().add(Aspect.SENSES, 2));
            this.registerTCObjectTag(TFBlocks.uncraftingTable, -1, new AspectList().add(Aspect.TREE, 4).add(Aspect.ENTROPY, 8).add(Aspect.EXCHANGE, 12).add(Aspect.CRAFT, 16));
            this.registerTCObjectTag(TFBlocks.fireJet, -1, new AspectList().add(Aspect.FIRE, 4).add(Aspect.AIR, 2).add(Aspect.MOTION, 2));
            this.registerTCObjectTag(TFBlocks.nagastone, -1, new AspectList().add(Aspect.ORDER, 2).add(Aspect.MOTION, 2));
            this.registerTCObjectTag(TFBlocks.magicLeaves, -1, new AspectList().add(Aspect.PLANT, 2));
            this.registerTCObjectTag(TFBlocks.towerWood, -1, new AspectList().add(Aspect.TREE, 2).add(Aspect.MECHANISM, 2));
            this.registerTCObjectTag(TFBlocks.towerDevice, -1, new AspectList().add(Aspect.TREE, 4).add(Aspect.MECHANISM, 4).add(Aspect.MAGIC, 4));
            this.registerTCObjectTag(TFBlocks.towerTranslucent, -1, new AspectList().add(Aspect.TREE, 4).add(Aspect.MECHANISM, 4).add(Aspect.MAGIC, 4).add(Aspect.VOID, 2));
            this.registerTCObjectTag(TFBlocks.trophy, -1, new AspectList().add(Aspect.LIFE, 6).add(Aspect.BEAST, 6).add(Aspect.SOUL, 6));
            this.registerTCObjectTag(TFBlocks.plant, 3, new AspectList().add(Aspect.PLANT, 1));
            this.registerTCObjectTag(TFBlocks.plant, 4, new AspectList().add(Aspect.PLANT, 1));
            this.registerTCObjectTag(TFBlocks.plant, 5, new AspectList().add(Aspect.PLANT, 2));
            this.registerTCObjectTag(TFBlocks.plant, 8, new AspectList().add(Aspect.PLANT, 2).add(Aspect.MAGIC, 1));
            this.registerTCObjectTag(TFBlocks.plant, 9, new AspectList().add(Aspect.PLANT, 2).add(Aspect.DARKNESS, 1).add(Aspect.LIGHT, 1));
            this.registerTCObjectTag(TFBlocks.plant, 10, new AspectList().add(Aspect.PLANT, 2).add(Aspect.DARKNESS, 1));
            this.registerTCObjectTag(TFBlocks.plant, 11, new AspectList().add(Aspect.PLANT, 2).add(Aspect.DARKNESS, 1));
            this.registerTCObjectTag(TFBlocks.plant, 13, new AspectList().add(Aspect.PLANT, 2).add(Aspect.LIGHT, 2));
            this.registerTCObjectTag(TFBlocks.plant, 14, new AspectList().add(Aspect.PLANT, 2));
            this.registerTCObjectTag(TFBlocks.sapling, -1, new AspectList().add(Aspect.PLANT, 4).add(Aspect.TREE, 2));
            this.registerTCObjectTag(TFBlocks.moonworm, -1, new AspectList().add(Aspect.DARKNESS, 2).add(Aspect.LIGHT, 2));
            this.registerTCObjectTag(TFBlocks.shield, -1, new AspectList().add(Aspect.TRAP, 1).add(Aspect.MAGIC, 1).add(Aspect.ARMOR, 1));
            this.registerTCObjectTag(TFBlocks.trophyPedestal, -1, new AspectList().add(Aspect.GREED, 6).add(Aspect.BEAST, 5));
            this.registerTCObjectTag(TFBlocks.auroraBlock, -1, new AspectList().add(Aspect.COLD, 2).add(Aspect.CRYSTAL, 2));
            this.registerTCObjectTag(TFBlocks.underBrick, -1, new AspectList().add(Aspect.DARKNESS, 2).add(Aspect.EARTH, 2));
            this.registerTCObjectTag(TFBlocks.portal, -1, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.MOTION, 2));
            this.registerTCObjectTag(TFBlocks.trophy, -1, new AspectList().add(Aspect.PLANT, 2).add(Aspect.LIGHT, 10));
            this.registerTCObjectTag(TFBlocks.shield, -1, new AspectList().add(Aspect.EARTH, 1).add(Aspect.ORDER, 2).add(Aspect.ARMOR, 2));
            this.registerTCObjectTag(TFBlocks.thorns, -1, new AspectList().add(Aspect.PLANT, 3).add(Aspect.ENTROPY, 2).add(Aspect.TRAP, 2));
            this.registerTCObjectTag(TFBlocks.thornRose, -1, new AspectList().add(Aspect.PLANT, 1).add(Aspect.TRAP, 1).add(Aspect.SENSES, 2));
            this.registerTCObjectTag(TFBlocks.burntThorns, -1, new AspectList().add(Aspect.ENTROPY, 2).add(Aspect.FIRE, 1));
            this.registerTCObjectTag(TFBlocks.leaves3, -1, new AspectList().add(Aspect.PLANT, 2));
            this.registerTCObjectTag(TFBlocks.deadrock, -1, new AspectList().add(Aspect.EARTH, 1).add(Aspect.ENTROPY, 1).add(Aspect.DEATH, 1));
            this.registerTCObjectTag(TFBlocks.darkleaves, -1, new AspectList().add(Aspect.PLANT, 2).add(Aspect.DARKNESS, 2));
            this.registerTCObjectTag(TFBlocks.auroraPillar, -1, new AspectList().add(Aspect.COLD, 2).add(Aspect.ORDER, 2));
            this.registerTCObjectTag((Block)TFBlocks.auroraSlab, -1, new AspectList().add(Aspect.COLD, 2).add(Aspect.ORDER, 2));
            this.registerTCObjectTag((Block)TFBlocks.auroraDoubleSlab, -1, new AspectList().add(Aspect.COLD, 2).add(Aspect.ORDER, 2));
            this.registerTCObjectTag(TFBlocks.trollSteinn, -1, new AspectList().add(Aspect.EARTH, 1).add(Aspect.ORDER, 1).add(Aspect.CRYSTAL, 1));
            this.registerTCObjectTag(TFBlocks.wispyCloud, -1, new AspectList().add(Aspect.WEATHER, 1).add(Aspect.AIR, 1).add(Aspect.FLIGHT, 1));
            this.registerTCObjectTag(TFBlocks.fluffyCloud, -1, new AspectList().add(Aspect.WEATHER, 2).add(Aspect.AIR, 2));
            this.registerTCObjectTag(TFBlocks.giantCobble, -1, new AspectList().add(Aspect.EARTH, 8).add(Aspect.ENTROPY, 8));
            this.registerTCObjectTag(TFBlocks.giantLog, -1, new AspectList().add(Aspect.TREE, 32));
            this.registerTCObjectTag(TFBlocks.giantLeaves, -1, new AspectList().add(Aspect.PLANT, 32));
            this.registerTCObjectTag(TFBlocks.giantObsidian, -1, new AspectList().add(Aspect.FIRE, 16).add(Aspect.DARKNESS, 8).add(Aspect.EARTH, 16));
            this.registerTCObjectTag(TFBlocks.uberousSoil, -1, new AspectList().add(Aspect.EARTH, 4).add(Aspect.SENSES, 2).add(Aspect.PLANT, 2));
            this.registerTCObjectTag(TFBlocks.hugeStalk, -1, new AspectList().add(Aspect.PLANT, 2).add(Aspect.TREE, 2));
            this.registerTCObjectTag(TFBlocks.hugeGloomBlock, -1, new AspectList().add(Aspect.PLANT, 2).add(Aspect.DARKNESS, 1).add(Aspect.LIGHT, 1));
            this.registerTCObjectTag(TFBlocks.trollVidr, -1, new AspectList().add(Aspect.PLANT, 2));
            this.registerTCObjectTag(TFBlocks.unripeTrollBer, -1, new AspectList().add(Aspect.PLANT, 2).add(Aspect.DARKNESS, 1));
            this.registerTCObjectTag(TFBlocks.trollBer, -1, new AspectList().add(Aspect.PLANT, 2).add(Aspect.LIGHT, 4));
            this.registerTCObjectTag(TFBlocks.knightmetalStorage, -1, new AspectList().add(Aspect.METAL, 12).add(Aspect.ORDER, 12));
            this.registerTCObjectTag(TFBlocks.hugeLilyPad, -1, new AspectList().add(Aspect.WATER, 3).add(Aspect.PLANT, 6));
            this.registerTCObjectTag(TFBlocks.hugeWaterLily, -1, new AspectList().add(Aspect.WATER, 2).add(Aspect.PLANT, 2).add(Aspect.SENSES, 2));
            this.registerTCObjectTag(TFBlocks.slider, -1, new AspectList().add(Aspect.MOTION, 4).add(Aspect.TRAP, 6));
            this.registerTCObjectTag(TFBlocks.castleBlock, -1, new AspectList().add(Aspect.ORDER, 2));
            this.registerTCObjectTag(TFBlocks.castleMagic, -1, new AspectList().add(Aspect.ORDER, 2).add(Aspect.MAGIC, 3).add(Aspect.ENERGY, 2));
            this.registerTCObjectTag(TFBlocks.forceField, -1, new AspectList().add(Aspect.MAGIC, 3).add(Aspect.ARMOR, 4));
            FMLLog.info("[TwilightForest] Loaded ThaumcraftApi integration.", new Object[0]);
        }
        catch (Exception e) {
            FMLLog.warning("[TwilightForest] Had an %s error while trying to register with ThaumcraftApi.", new Object[] { e.getLocalizedMessage() });
        }
    }
    
    private void registerTCObjectTag(final Block block, int meta, final AspectList list) {
        if (meta == -1) {
            meta = 32767;
        }
        ThaumcraftApi.registerObjectTag(new ItemStack(block, 1, meta), list);
    }
    
    private void registerTCObjectTag(final Item item, int meta, final AspectList list) {
        if (meta == -1) {
            meta = 32767;
        }
        ThaumcraftApi.registerObjectTag(new ItemStack(item, 1, meta), list);
    }
    
    private void registerDispenseBehaviors(final MinecraftServer minecraftServer) {
        BlockDispenser.field_149943_a.func_82595_a((Object)TFItems.spawnEgg, (Object)new BehaviorTFMobEggDispense(minecraftServer));
    }
    
    private void loadConfiguration(final Configuration configFile) {
        configFile.load();
        TwilightForestMod.dimensionID = configFile.get("dimension", "dimensionID", 7).getInt();
        configFile.get("dimension", "dimensionID", 7).comment = "What ID number to assign to the Twilight Forest dimension.  Change if you are having conflicts with another mod.";
        TwilightForestMod.dimensionProviderID = configFile.get("dimension", "dimensionProviderID", -777).getInt();
        configFile.get("dimension", "dimensionProviderID", 7).comment = "Dimension provider ID.  Does not normally need to be changed, but the option is provided to work around a bug in MCPC+";
        TwilightForestMod.silentCicadas = configFile.get("general", "SilentCicadas", false).getBoolean(false);
        configFile.get("general", "SilentCicadas", false).comment = "Make cicadas silent  for those having sound library problems, or otherwise finding them annoying";
        TwilightForestMod.allowPortalsInOtherDimensions = configFile.get("general", "AllowPortalsInOtherDimensions", false).getBoolean(false);
        configFile.get("general", "AllowPortalsInOtherDimensions", false).comment = "Allow portals to the Twilight Forest to be made outside of dimension 0.  May be considered an exploit.";
        TwilightForestMod.adminOnlyPortals = configFile.get("general", "AdminOnlyPortals", false).getBoolean(false);
        configFile.get("general", "AdminOnlyPortals", false).comment = "Allow portals only for admins (ops).  This severly reduces the range in which the mod usually scans for valid portal conditions, and it scans near ops only.";
        TwilightForestMod.twilightForestSeed = configFile.get("general", "TwilightForestSeed", "").getString();
        configFile.get("general", "TwilightForestSeed", "").comment = "If set, this will override the normal world seed when generating parts of the Twilight Forest Dimension.";
        TwilightForestMod.disablePortalCreation = configFile.get("general", "DisablePortalCreation", false).getBoolean(false);
        configFile.get("general", "DisablePortalCreation", false).comment = "Disable Twilight Forest portal creation entirely.  Provided for server operators looking to restrict action to the dimension.";
        TwilightForestMod.disableUncrafting = configFile.get("general", "DisableUncrafting", false).getBoolean(false);
        configFile.get("general", "DisableUncrafting", false).comment = "Disable the uncrafting function of the uncrafting table.  Provided as an option when interaction with other mods produces exploitable recipes.";
        TwilightForestMod.oldMapGen = configFile.get("general", "OldMapGen", false).getBoolean(false);
        configFile.get("general", "OldMapGen", false).comment = "Use old (pre Minecraft 1.7) map gen.  May not be fully supported.";
        TwilightForestMod.portalCreationItemString = configFile.get("general", "PortalCreationItem", "diamond").getString();
        configFile.get("general", "PortalCreationItem", "diamond").comment = "Item to create the Twilight Forest Portal.  Defaults to 'diamond'";
        TwilightForestMod.canopyCoverage = (float)configFile.get("Performance", "CanopyCoverage", 1.7).getDouble(1.7);
        configFile.get("performance", "CanopyCoverage", 1.7).comment = "Amount of canopy coverage, from 0.0 on up.  Lower numbers improve chunk generation speed at the cost of a thinner forest.";
        TwilightForestMod.twilightOakChance = configFile.get("Performance", "TwilightOakChance", 48).getInt(48);
        configFile.get("Performance", "TwilightOakChance", 48).comment = "Chance that a chunk in the Twilight Forest will contain a twilight oak tree.  Higher numbers reduce the number of trees, increasing performance.";
        TwilightForestMod.idMobWildBoar = 177;
        TwilightForestMod.idMobBighornSheep = 178;
        TwilightForestMod.idMobWildDeer = 179;
        TwilightForestMod.idMobRedcap = 180;
        TwilightForestMod.idMobSwarmSpider = 181;
        TwilightForestMod.idMobNaga = 182;
        TwilightForestMod.idMobNagaSegment = 183;
        TwilightForestMod.idMobSkeletonDruid = 184;
        TwilightForestMod.idMobHostileWolf = 185;
        TwilightForestMod.idMobTwilightWraith = 186;
        TwilightForestMod.idMobHedgeSpider = 187;
        TwilightForestMod.idMobHydra = 189;
        TwilightForestMod.idMobLich = 190;
        TwilightForestMod.idMobPenguin = 191;
        TwilightForestMod.idMobLichMinion = 192;
        TwilightForestMod.idMobLoyalZombie = 193;
        TwilightForestMod.idMobTinyBird = 194;
        TwilightForestMod.idMobSquirrel = 195;
        TwilightForestMod.idMobBunny = 196;
        TwilightForestMod.idMobRaven = 197;
        TwilightForestMod.idMobQuestRam = 198;
        TwilightForestMod.idMobKobold = 199;
        TwilightForestMod.idMobBoggard = 201;
        TwilightForestMod.idMobMosquitoSwarm = 202;
        TwilightForestMod.idMobDeathTome = 203;
        TwilightForestMod.idMobMinotaur = 204;
        TwilightForestMod.idMobMinoshroom = 205;
        TwilightForestMod.idMobFireBeetle = 206;
        TwilightForestMod.idMobSlimeBeetle = 207;
        TwilightForestMod.idMobPinchBeetle = 208;
        TwilightForestMod.idMobMazeSlime = 209;
        TwilightForestMod.idMobRedcapSapper = 210;
        TwilightForestMod.idMobMistWolf = 211;
        TwilightForestMod.idMobKingSpider = 212;
        TwilightForestMod.idMobFirefly = 213;
        TwilightForestMod.idMobMiniGhast = 214;
        TwilightForestMod.idMobTowerGhast = 215;
        TwilightForestMod.idMobTowerGolem = 216;
        TwilightForestMod.idMobTowerTermite = 218;
        TwilightForestMod.idMobTowerBroodling = 219;
        TwilightForestMod.idMobTowerBoss = 217;
        TwilightForestMod.idMobBlockGoblin = 220;
        TwilightForestMod.idMobGoblinKnightUpper = 221;
        TwilightForestMod.idMobGoblinKnightLower = 222;
        TwilightForestMod.idMobHelmetCrab = 223;
        TwilightForestMod.idMobKnightPhantom = 224;
        TwilightForestMod.idMobYeti = 225;
        TwilightForestMod.idMobYetiBoss = 226;
        TwilightForestMod.idMobWinterWolf = 227;
        TwilightForestMod.idMobSnowGuardian = 228;
        TwilightForestMod.idMobStableIceCore = 229;
        TwilightForestMod.idMobUnstableIceCore = 230;
        TwilightForestMod.idMobSnowQueen = 231;
        TwilightForestMod.idMobTroll = 232;
        TwilightForestMod.idMobGiantMiner = 233;
        TwilightForestMod.idMobArmoredGiant = 234;
        TwilightForestMod.idMobIceCrystal = 235;
        TwilightForestMod.idMobHarbingerCube = 236;
        TwilightForestMod.idMobAdherent = 237;
        TwilightForestMod.idBiomeLake = configFile.get("biome", "biome.id.Lake", -1).getInt();
        TwilightForestMod.idBiomeTwilightForest = configFile.get("biome", "biome.id.TwilightForest", -1).getInt();
        TwilightForestMod.idBiomeTwilightForestVariant = configFile.get("biome", "biome.id.TwilightForestVariant", -1).getInt();
        TwilightForestMod.idBiomeHighlands = configFile.get("biome", "biome.id.Highlands", -1).getInt();
        TwilightForestMod.idBiomeMushrooms = configFile.get("biome", "biome.id.Mushrooms", -1).getInt();
        TwilightForestMod.idBiomeSwamp = configFile.get("biome", "biome.id.Swamp", -1).getInt();
        TwilightForestMod.idBiomeStream = configFile.get("biome", "biome.id.Stream", -1).getInt();
        TwilightForestMod.idBiomeSnowfield = configFile.get("biome", "biome.id.Snowfield", -1).getInt();
        TwilightForestMod.idBiomeGlacier = configFile.get("biome", "biome.id.Glacier", -1).getInt();
        TwilightForestMod.idBiomeClearing = configFile.get("biome", "biome.id.Clearing", -1).getInt();
        TwilightForestMod.idBiomeOakSavanna = configFile.get("biome", "biome.id.OakSavanna", -1).getInt();
        TwilightForestMod.idBiomeFireflyForest = configFile.get("biome", "biome.id.LightedForest", -1).getInt();
        TwilightForestMod.idBiomeDeepMushrooms = configFile.get("biome", "biome.id.DeepMushrooms", -1).getInt();
        TwilightForestMod.idBiomeDarkForestCenter = configFile.get("biome", "biome.id.DarkForestCenter", -1).getInt();
        TwilightForestMod.idBiomeHighlandsCenter = configFile.get("biome", "biome.id.HighlandsCenter", -1).getInt();
        TwilightForestMod.idBiomeDarkForest = configFile.get("biome", "biome.id.DarkForest", -1).getInt();
        TwilightForestMod.idBiomeEnchantedForest = configFile.get("biome", "biome.id.EnchantedForest", -1).getInt();
        TwilightForestMod.idBiomeFireSwamp = configFile.get("biome", "biome.id.FireSwamp", -1).getInt();
        TwilightForestMod.idBiomeThornlands = configFile.get("biome", "biome.id.Thornlands", -1).getInt();
        if (configFile.hasChanged()) {
            configFile.save();
        }
    }
    
    private void saveBiomeIds(final Configuration config) {
        config.get("biome", "biome.id.Lake", -1).set(TwilightForestMod.idBiomeLake);
        config.get("biome", "biome.id.TwilightForest", -1).set(TwilightForestMod.idBiomeTwilightForest);
        config.get("biome", "biome.id.TwilightForestVariant", -1).set(TwilightForestMod.idBiomeTwilightForestVariant);
        config.get("biome", "biome.id.Highlands", -1).set(TwilightForestMod.idBiomeHighlands);
        config.get("biome", "biome.id.Mushrooms", -1).set(TwilightForestMod.idBiomeMushrooms);
        config.get("biome", "biome.id.Swamp", -1).set(TwilightForestMod.idBiomeSwamp);
        config.get("biome", "biome.id.Stream", -1).set(TwilightForestMod.idBiomeStream);
        config.get("biome", "biome.id.Snowfield", -1).set(TwilightForestMod.idBiomeSnowfield);
        config.get("biome", "biome.id.Glacier", -1).set(TwilightForestMod.idBiomeGlacier);
        config.get("biome", "biome.id.Clearing", -1).set(TwilightForestMod.idBiomeClearing);
        config.get("biome", "biome.id.OakSavanna", -1).set(TwilightForestMod.idBiomeOakSavanna);
        config.get("biome", "biome.id.LightedForest", -1).set(TwilightForestMod.idBiomeFireflyForest);
        config.get("biome", "biome.id.DeepMushrooms", -1).set(TwilightForestMod.idBiomeDeepMushrooms);
        config.get("biome", "biome.id.DarkForestCenter", -1).set(TwilightForestMod.idBiomeDarkForestCenter);
        config.get("biome", "biome.id.HighlandsCenter", -1).set(TwilightForestMod.idBiomeHighlandsCenter);
        config.get("biome", "biome.id.DarkForest", -1).set(TwilightForestMod.idBiomeDarkForest);
        config.get("biome", "biome.id.EnchantedForest", -1).set(TwilightForestMod.idBiomeEnchantedForest);
        config.get("biome", "biome.id.FireSwamp", -1).set(TwilightForestMod.idBiomeFireSwamp);
        config.get("biome", "biome.id.Thornlands", -1).set(TwilightForestMod.idBiomeThornlands);
        config.save();
    }
    
    public static void setDimensionID(final int dim) {
        if (TwilightForestMod.dimensionID != dim) {
            FMLLog.info("[TwilightForest] Server has a different dimension ID (%d) for the Twilight Forest.  Changing this on the client.  This change will not be saved.", new Object[] { dim });
            DimensionManager.unregisterDimension(TwilightForestMod.dimensionID);
            DimensionManager.registerDimension(TwilightForestMod.dimensionID = dim, TwilightForestMod.dimensionProviderID);
        }
    }
    
    static {
        TwilightForestMod.backupdimensionID = -777;
        TwilightForestMod.idVehicleSpawnNatureBolt = 1;
        TwilightForestMod.idVehicleSpawnLichBolt = 2;
        TwilightForestMod.idVehicleSpawnTwilightWandBolt = 3;
        TwilightForestMod.idVehicleSpawnTomeBolt = 4;
        TwilightForestMod.idVehicleSpawnHydraMortar = 5;
        TwilightForestMod.idVehicleSpawnLichBomb = 6;
        TwilightForestMod.idVehicleSpawnMoonwormShot = 7;
        TwilightForestMod.idVehicleSpawnSlimeBlob = 8;
        TwilightForestMod.idVehicleSpawnCharmEffect = 9;
        TwilightForestMod.idVehicleSpawnThrownAxe = 10;
        TwilightForestMod.idVehicleSpawnThrownPick = 13;
        TwilightForestMod.idVehicleSpawnFallingIce = 14;
        TwilightForestMod.idVehicleSpawnThrownIce = 15;
        TwilightForestMod.idVehicleSpawnSeekerArrow = 16;
        TwilightForestMod.idVehicleSpawnIceSnowball = 17;
        TwilightForestMod.idVehicleSpawnChainBlock = 18;
        TwilightForestMod.idVehicleSpawnCubeOfAnnihilation = 19;
        TwilightForestMod.idVehicleSpawnSlideBlock = 20;
        TwilightForestMod.hasBiomeIdConflicts = false;
        TwilightForestMod.hasAssignedBiomeID = false;
        eventListener = new TFEventListener();
        tickHandler = new TFTickHandler();
    }
}
