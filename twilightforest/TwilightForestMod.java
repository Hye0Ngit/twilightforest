// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.item.BehaviorTFMobEggDispense;
import net.minecraft.block.BlockDispenser;
import net.minecraft.server.MinecraftServer;
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
import twilightforest.entity.EntityTFTroll;
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
import twilightforest.entity.EntityTFBoggard;
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
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.common.DimensionManager;
import twilightforest.world.WorldProviderTwilightForest;
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

@Mod(modid = "TwilightForest", name = "The Twilight Forest", version = "2.2.3")
public class TwilightForestMod
{
    public static final String ID = "TwilightForest";
    public static final String VERSION = "2.2.3";
    public static final String MODEL_DIR = "twilightforest:textures/model/";
    public static final String GUI_DIR = "twilightforest:textures/gui/";
    public static final String ARMOR_DIR = "twilightforest:textures/armor/";
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
    public static boolean enforcedProgression;
    public static boolean oldMapGen;
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
    public static int idBiomeLightedForest;
    public static int idBiomeDeepMushrooms;
    public static int idBiomeDarkForestCenter;
    public static int idBiomeHighlandsCenter;
    public static int idBiomeDarkForest;
    public static int idBiomeEnchantedForest;
    public static int idBiomeFireSwamp;
    public static int idBiomeThornlands;
    public static int idEnchantmentFieryAura;
    public static int idEnchantmentChillAura;
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
        TwilightForestMod.hasBiomeIdConflicts = TFBiomeBase.areThereBiomeIdConflicts();
    }
    
    @Mod.EventHandler
    public void startServer(final FMLServerStartingEvent event) {
        this.registerDispenseBehaviors(event.getServer());
        event.registerServerCommand((ICommand)new CommandTFFeature());
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
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFPenguin.class, "Penguin", TwilightForestMod.idMobPenguin, 1185051, 16379346);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFLichMinion.class, "Lich Minion", TwilightForestMod.idMobLichMinion);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFLoyalZombie.class, "Loyal Zombie", TwilightForestMod.idMobLoyalZombie);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFTinyBird.class, "Tiny Bird", TwilightForestMod.idMobTinyBird, 3386077, 1149166);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFSquirrel.class, "Forest Squirrel", TwilightForestMod.idMobSquirrel, 9457426, 15658734);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFBunny.class, "Forest Bunny", TwilightForestMod.idMobBunny, 16711406, 13413017);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFRaven.class, "Forest Raven", TwilightForestMod.idMobRaven, 17, 2236979);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFQuestRam.class, "Questing Ram", TwilightForestMod.idMobQuestRam);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFKobold.class, "Twilight Kobold", TwilightForestMod.idMobKobold, 3612822, 9002267);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFBoggard.class, "Boggard", TwilightForestMod.idMobBoggard);
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
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFSnowGuardian.class, "SnowGuardian", TwilightForestMod.idMobSnowGuardian, 14672869, 11713738);
        TFCreatures.registerTFCreature((Class<? extends Entity>)EntityTFTroll.class, "Troll", TwilightForestMod.idMobTroll, 14606046, 4617659);
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
        EntityRegistry.registerModEntity((Class)EntityTFIceBomb.class, "tfthrownice", TwilightForestMod.idVehicleSpawnThrownIce, (Object)this, 80, 3, true);
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
    }
    
    private void registerThaumcraftIntegration() {
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
        TwilightForestMod.enforcedProgression = configFile.get("general", "EnforcedProgression", true).getBoolean(true);
        configFile.get("general", "EnforcedProgression", true).comment = "Enforced progression through Twilight Forest dungeons/areas.";
        TwilightForestMod.oldMapGen = configFile.get("general", "OldMapGen", false).getBoolean(false);
        configFile.get("general", "OldMapGen", false).comment = "Use old (pre Minecraft 1.7) map gen.  May not be fully supported.";
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
        TwilightForestMod.idBiomeLightedForest = configFile.get("biome", "biome.id.LightedForest", -1).getInt();
        TwilightForestMod.idBiomeDeepMushrooms = configFile.get("biome", "biome.id.DeepMushrooms", -1).getInt();
        TwilightForestMod.idBiomeDarkForestCenter = configFile.get("biome", "biome.id.DarkForestCenter", -1).getInt();
        TwilightForestMod.idBiomeHighlandsCenter = configFile.get("biome", "biome.id.HighlandsCenter", -1).getInt();
        TwilightForestMod.idBiomeDarkForest = configFile.get("biome", "biome.id.DarkForest", -1).getInt();
        TwilightForestMod.idBiomeEnchantedForest = configFile.get("biome", "biome.id.EnchantedForest", -1).getInt();
        TwilightForestMod.idBiomeFireSwamp = configFile.get("biome", "biome.id.FireSwamp", -1).getInt();
        TwilightForestMod.idBiomeThornlands = configFile.get("biome", "biome.id.Thornlands", -1).getInt();
        TwilightForestMod.idEnchantmentFieryAura = configFile.get("enchantment", "enchantment.id.fieryaura", 136).getInt();
        TwilightForestMod.idEnchantmentChillAura = configFile.get("enchantment", "enchantment.id.chillaura", 137).getInt();
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
        config.get("biome", "biome.id.LightedForest", -1).set(TwilightForestMod.idBiomeLightedForest);
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
        TwilightForestMod.hasBiomeIdConflicts = false;
        TwilightForestMod.hasAssignedBiomeID = false;
        eventListener = new TFEventListener();
        tickHandler = new TFTickHandler();
    }
}
