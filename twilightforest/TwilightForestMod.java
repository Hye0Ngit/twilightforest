// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.item.BehaviorTFMobEggDispense;
import net.minecraft.block.BlockDispenser;
import net.minecraft.server.MinecraftServer;
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
import twilightforest.tileentity.TileEntityTFFirefly;
import twilightforest.entity.EntityTFCharmEffect;
import twilightforest.entity.EntityTFSlimeProjectile;
import twilightforest.entity.EntityTFMoonwormShot;
import twilightforest.entity.EntityTFLichBomb;
import twilightforest.entity.EntityTFHydraMortar;
import twilightforest.entity.EntityTFTomeBolt;
import twilightforest.entity.EntityTFTwilightWandBolt;
import twilightforest.entity.EntityTFLichBolt;
import twilightforest.entity.EntityTFNatureBolt;
import cpw.mods.fml.common.registry.EntityRegistry;
import twilightforest.entity.EntityTFHydraHead;
import twilightforest.entity.EntityTFHelmetCrab;
import twilightforest.entity.EntityTFGoblinKnightLower;
import twilightforest.entity.EntityTFGoblinKnightUpper;
import twilightforest.entity.EntityTFBlockGoblin;
import twilightforest.entity.EntityTFUrGhast;
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
import twilightforest.entity.EntityTFMinoshroom;
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
import twilightforest.entity.EntityTFLichMinion;
import twilightforest.entity.passive.EntityTFPenguin;
import twilightforest.entity.EntityTFLich;
import twilightforest.entity.EntityTFHydra;
import twilightforest.entity.EntityTFHedgeSpider;
import twilightforest.entity.EntityTFWraith;
import twilightforest.entity.EntityTFHostileWolf;
import twilightforest.entity.EntityTFSkeletonDruid;
import twilightforest.entity.EntityTFNagaSegment;
import twilightforest.entity.EntityTFNaga;
import twilightforest.entity.EntityTFSwarmSpider;
import twilightforest.entity.EntityTFRedcap;
import twilightforest.entity.passive.EntityTFDeer;
import twilightforest.entity.passive.EntityTFBighorn;
import twilightforest.entity.passive.EntityTFBoar;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import twilightforest.biomes.TFBiomeBase;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.common.DimensionManager;
import twilightforest.world.WorldProviderTwilightForest;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import twilightforest.entity.TFCreatures;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.AchievementPage;
import twilightforest.item.TFItems;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import twilightforest.block.TFBlocks;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.Mod;

@Mod(modid = "TwilightForest", name = "The Twilight Forest", version = "1.17.2")
@NetworkMod(channels = { "TwilightForest", "tfmagicmap", "tfmazemap" }, clientSideRequired = true, serverSideRequired = false, packetHandler = TFPacketHandler.class, connectionHandler = TFPacketHandler.class)
public class TwilightForestMod
{
    public static final String ID = "TwilightForest";
    public static final String VERSION = "1.17.2";
    public static final String MODEL_DIR = "/mods/twilightforest/textures/model/";
    public static final String GUI_DIR = "/mods/twilightforest/textures/gui/";
    public static final String ARMOR_DIR = "/mods/twilightforest/textures/armor/";
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
    public static int idBlockFirefly;
    public static int idBlockPortal;
    public static int idBlockLog;
    public static int idBlockLeaves;
    public static int idBlockMazestone;
    public static int idBlockHedge;
    public static int idBlockBossSpawner;
    public static int idBlockFireflyJar;
    public static int idBlockPlant;
    public static int idBlockRoots;
    public static int idBlockCicada;
    public static int idBlockUncraftingTable;
    public static int idBlockFireJet;
    public static int idBlockNagastone;
    public static int idBlockSapling;
    public static int idBlockMagicLog;
    public static int idBlockMagicLeaves;
    public static int idBlockMoonworm;
    public static int idBlockMagicLogSpecial;
    public static int idBlockTowerWood;
    public static int idBlockTowerDevice;
    public static int idBlockTowerAntenna;
    public static int idBlockTowerTranslucent;
    public static int idBlockTrophy;
    public static int idItemNagaScale;
    public static int idItemPlateNaga;
    public static int idItemLegsNaga;
    public static int idItemScepterTwilight;
    public static int idItemScepterLifeDrain;
    public static int idItemScepterZombie;
    public static int idItemWandPacification;
    public static int idItemOreMeter;
    public static int idItemMagicMap;
    public static int idItemMazeMap;
    public static int idItemOreMap;
    public static int idItemFeather;
    public static int idItemMagicMapFocus;
    public static int idItemMazeMapFocus;
    public static int idItemLiveRoot;
    public static int idItemIronwoodRaw;
    public static int idItemIronwoodIngot;
    public static int idItemIronwoodHelm;
    public static int idItemIronwoodPlate;
    public static int idItemIronwoodLegs;
    public static int idItemIronwoodBoots;
    public static int idItemIronwoodSword;
    public static int idItemIronwoodShovel;
    public static int idItemIronwoodPick;
    public static int idItemIronwoodAxe;
    public static int idItemIronwoodHoe;
    public static int idItemTorchberries;
    public static int idItemSpawnEgg;
    public static int idItemVenisonRaw;
    public static int idItemVenisonCooked;
    public static int idItemHydraChops;
    public static int idItemFieryBlood;
    public static int idItemTrophy;
    public static int idItemFieryIngot;
    public static int idItemFieryHelm;
    public static int idItemFieryPlate;
    public static int idItemFieryLegs;
    public static int idItemFieryBoots;
    public static int idItemFierySword;
    public static int idItemFieryPick;
    public static int idItemSteeleafIngot;
    public static int idItemSteeleafHelm;
    public static int idItemSteeleafPlate;
    public static int idItemSteeleafLegs;
    public static int idItemSteeleafBoots;
    public static int idItemSteeleafSword;
    public static int idItemSteeleafShovel;
    public static int idItemSteeleafPick;
    public static int idItemSteeleafAxe;
    public static int idItemSteeleafHoe;
    public static int idItemMinotaurAxe;
    public static int idItemMazebreakerPick;
    public static int idItemTransformPowder;
    public static int idItemMeefRaw;
    public static int idItemMeefSteak;
    public static int idItemMeefStroganoff;
    public static int idItemMazeWafer;
    public static int idItemEmptyMagicMap;
    public static int idItemEmptyMazeMap;
    public static int idItemEmptyOreMap;
    public static int idItemOreMagnet;
    public static int idItemCrumbleHorn;
    public static int idItemPeacockFan;
    public static int idItemMoonwormQueen;
    public static int idItemCharmOfLife1;
    public static int idItemCharmOfLife2;
    public static int idItemCharmOfKeeping1;
    public static int idItemCharmOfKeeping2;
    public static int idItemCharmOfKeeping3;
    public static int idItemTowerKey;
    public static int idItemBorerEssence;
    public static int idItemCarminite;
    public static int idItemExperiment115;
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
    public static int idVehicleSpawnNatureBolt;
    public static int idVehicleSpawnLichBolt;
    public static int idVehicleSpawnTwilightWandBolt;
    public static int idVehicleSpawnTomeBolt;
    public static int idVehicleSpawnHydraMortar;
    public static int idVehicleSpawnLichBomb;
    public static int idVehicleSpawnMoonwormShot;
    public static int idVehicleSpawnSlimeBlob;
    public static int idVehicleSpawnCharmEffect;
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
    public static int idBiomeClearingBorder;
    public static int idBiomeLakeBorder;
    public static int idBiomeDeepMushrooms;
    public static int idBiomeMajorFeature;
    public static int idBiomeMinorFeature;
    public static int idBiomeDarkForest;
    public static int idBiomeEnchantedForest;
    public static int idBiomeFireSwamp;
    public static boolean biomeIDConflicts;
    @Mod.Instance("TwilightForest")
    public static TwilightForestMod instance;
    @SidedProxy(clientSide = "twilightforest.client.TFClientProxy", serverSide = "twilightforest.TFCommonProxy")
    public static TFCommonProxy proxy;
    public static final TFEventListener eventListener;
    TFBlocks blocks;
    TFTickHandler tickHandler;
    
    public TwilightForestMod() {
        TwilightForestMod.instance = this;
    }
    
    @Mod.PreInit
    public void preInit(final FMLPreInitializationEvent event) {
        this.loadConfiguration(new Configuration(event.getSuggestedConfigurationFile()));
        TwilightForestMod.proxy.doPreLoadRegistration();
        new TFBlocks();
        new TFItems();
        AchievementPage.registerAchievementPage((AchievementPage)new TFAchievementPage());
    }
    
    @Mod.Init
    public void load(final FMLInitializationEvent evt) {
        new TFCreatures();
        this.registerCreatures();
        new TFRecipes();
        this.registerTileEntities();
        TwilightForestMod.proxy.doOnLoadRegistration();
        NetworkRegistry.instance().registerGuiHandler((Object)TwilightForestMod.instance, (IGuiHandler)TwilightForestMod.proxy);
        TickRegistry.registerScheduledTickHandler((IScheduledTickHandler)(this.tickHandler = new TFTickHandler()), Side.SERVER);
        MinecraftForge.EVENT_BUS.register((Object)TwilightForestMod.eventListener);
        GameRegistry.registerCraftingHandler((ICraftingHandler)TwilightForestMod.eventListener);
        GameRegistry.registerPlayerTracker((IPlayerTracker)TwilightForestMod.eventListener);
        DimensionManager.registerProviderType(TwilightForestMod.dimensionProviderID, (Class)WorldProviderTwilightForest.class, false);
        TFLocalization.loadLocalizations();
    }
    
    @Mod.PostInit
    public void postInit(final FMLPostInitializationEvent evt) {
        if (this.isDimensionUnregistered(TwilightForestMod.dimensionID)) {
            DimensionManager.registerDimension(TwilightForestMod.dimensionID, TwilightForestMod.dimensionProviderID);
        }
        else {
            FMLLog.warning("[TwilightForest] Twilight Forest detected that the configured dimension id '%d' is being used.  Using backup ID.  It is recommended that you configure this mod to use a unique dimension ID.", new Object[] { TwilightForestMod.dimensionID });
            DimensionManager.registerDimension(TwilightForestMod.backupdimensionID, TwilightForestMod.dimensionProviderID);
            TwilightForestMod.dimensionID = TwilightForestMod.backupdimensionID;
        }
        TwilightForestMod.biomeIDConflicts = TFBiomeBase.checkForBiomeConflicts();
    }
    
    @Mod.ServerStarting
    public void startServer(final FMLServerStartingEvent event) {
        this.registerDispenseBehaviors(event.getServer());
    }
    
    private void registerCreatures() {
        TFCreatures.registerTFCreature(EntityTFBoar.class, "Wild Boar", TwilightForestMod.idMobWildBoar, 8611131, 16773066);
        TFCreatures.registerTFCreature(EntityTFBighorn.class, "Bighorn Sheep", TwilightForestMod.idMobBighornSheep, 14405295, 14141297);
        TFCreatures.registerTFCreature(EntityTFDeer.class, "Wild Deer", TwilightForestMod.idMobWildDeer, 8080686, 4924445);
        TFCreatures.registerTFCreature(EntityTFRedcap.class, "Redcap", TwilightForestMod.idMobRedcap, 3881580, 11214356);
        TFCreatures.registerTFCreature(EntityTFSwarmSpider.class, "Swarm Spider", TwilightForestMod.idMobSwarmSpider, 3277358, 1516830);
        TFCreatures.registerTFCreature(EntityTFNaga.class, "Naga", TwilightForestMod.idMobNaga, 10801942, 1783819);
        TFCreatures.registerTFCreature(EntityTFNagaSegment.class, "Naga Segment", TwilightForestMod.idMobNagaSegment);
        TFCreatures.registerTFCreature(EntityTFSkeletonDruid.class, "Skeleton Druid", TwilightForestMod.idMobSkeletonDruid, 10724259, 2767639);
        TFCreatures.registerTFCreature(EntityTFHostileWolf.class, "Hostile Wolf", TwilightForestMod.idMobHostileWolf, 14144467, 11214356);
        TFCreatures.registerTFCreature(EntityTFWraith.class, "Twilight Wraith", TwilightForestMod.idMobTwilightWraith, 5263440, 8618883);
        TFCreatures.registerTFCreature(EntityTFHedgeSpider.class, "Hedge Spider", TwilightForestMod.idMobHedgeSpider, 2318099, 5645907);
        TFCreatures.registerTFCreature(EntityTFHydra.class, "Hydra", TwilightForestMod.idMobHydra, 1321280, 2719851);
        TFCreatures.registerTFCreature(EntityTFLich.class, "Twilight Lich", TwilightForestMod.idMobLich, 11314313, 3540082);
        TFCreatures.registerTFCreature(EntityTFPenguin.class, "Penguin", TwilightForestMod.idMobPenguin, 1185051, 16379346);
        TFCreatures.registerTFCreature(EntityTFLichMinion.class, "Lich Minion", TwilightForestMod.idMobLichMinion);
        TFCreatures.registerTFCreature(EntityTFLoyalZombie.class, "Loyal Zombie", TwilightForestMod.idMobLoyalZombie);
        TFCreatures.registerTFCreature(EntityTFTinyBird.class, "Tiny Bird", TwilightForestMod.idMobTinyBird, 3386077, 1149166);
        TFCreatures.registerTFCreature(EntityTFSquirrel.class, "Forest Squirrel", TwilightForestMod.idMobSquirrel, 9457426, 15658734);
        TFCreatures.registerTFCreature(EntityTFBunny.class, "Forest Bunny", TwilightForestMod.idMobBunny, 16711406, 13413017);
        TFCreatures.registerTFCreature(EntityTFRaven.class, "Forest Raven", TwilightForestMod.idMobRaven, 17, 2236979);
        TFCreatures.registerTFCreature(EntityTFQuestRam.class, "Questing Ram", TwilightForestMod.idMobQuestRam);
        TFCreatures.registerTFCreature(EntityTFKobold.class, "Twilight Kobold", TwilightForestMod.idMobKobold, 3612822, 9002267);
        TFCreatures.registerTFCreature(EntityTFBoggard.class, "Boggard", TwilightForestMod.idMobBoggard);
        TFCreatures.registerTFCreature(EntityTFMosquitoSwarm.class, "Mosquito Swarm", TwilightForestMod.idMobMosquitoSwarm, 526596, 2961185);
        TFCreatures.registerTFCreature(EntityTFDeathTome.class, "Death Tome", TwilightForestMod.idMobDeathTome, 7818786, 14405054);
        TFCreatures.registerTFCreature(EntityTFMinotaur.class, "Minotaur", TwilightForestMod.idMobMinotaur, 4141092, 11173222);
        TFCreatures.registerTFCreature(EntityTFMinoshroom.class, "Minoshroom", TwilightForestMod.idMobMinoshroom, 11014162, 11173222);
        TFCreatures.registerTFCreature(EntityTFFireBeetle.class, "Fire Beetle", TwilightForestMod.idMobFireBeetle, 1903360, 13332261);
        TFCreatures.registerTFCreature(EntityTFSlimeBeetle.class, "Slime Beetle", TwilightForestMod.idMobSlimeBeetle, 792070, 6334284);
        TFCreatures.registerTFCreature(EntityTFPinchBeetle.class, "Pinch Beetle", TwilightForestMod.idMobPinchBeetle, 12358439, 2364937);
        TFCreatures.registerTFCreature(EntityTFMazeSlime.class, "Maze Slime", TwilightForestMod.idMobMazeSlime, 10724259, 2767639);
        TFCreatures.registerTFCreature(EntityTFRedcapSapper.class, "Redcap Sapper", TwilightForestMod.idMobRedcapSapper, 5725473, 11214356);
        TFCreatures.registerTFCreature(EntityTFMistWolf.class, "Mist Wolf", TwilightForestMod.idMobMistWolf, 3806225, 14862474);
        TFCreatures.registerTFCreature(EntityTFKingSpider.class, "King Spider", TwilightForestMod.idMobKingSpider, 2890254, 16760855);
        TFCreatures.registerTFCreature(EntityTFMobileFirefly.class, "Firefly", TwilightForestMod.idMobFirefly, 10801942, 12250626);
        TFCreatures.registerTFCreature(EntityTFMiniGhast.class, "Mini Ghast", TwilightForestMod.idMobMiniGhast, 12369084, 10961731);
        TFCreatures.registerTFCreature(EntityTFTowerGhast.class, "Tower Ghast", TwilightForestMod.idMobTowerGhast, 12369084, 12023928);
        TFCreatures.registerTFCreature(EntityTFTowerGolem.class, "Tower Golem", TwilightForestMod.idMobTowerGolem, 7028000, 14867930);
        TFCreatures.registerTFCreature(EntityTFTowerTermite.class, "Tower Termite", TwilightForestMod.idMobTowerTermite, 6105889, 11313210);
        TFCreatures.registerTFCreature(EntityTFTowerBroodling.class, "Redscale Broodling", TwilightForestMod.idMobTowerBroodling, 3423252, 12250626);
        TFCreatures.registerTFCreature(EntityTFUrGhast.class, "Tower Boss", TwilightForestMod.idMobTowerBoss, 12369084, 12023928);
        TFCreatures.registerTFCreature(EntityTFBlockGoblin.class, "Block&Chain Goblin", TwilightForestMod.idMobBlockGoblin, 3881580, 11214356);
        TFCreatures.registerTFCreature(EntityTFGoblinKnightUpper.class, "Upper Goblin Knight", TwilightForestMod.idMobGoblinKnightUpper);
        TFCreatures.registerTFCreature(EntityTFGoblinKnightLower.class, "Lower Goblin Knight", TwilightForestMod.idMobGoblinKnightLower, 3881580, 11214356);
        TFCreatures.registerTFCreature(EntityTFHelmetCrab.class, "Helmet Crab", TwilightForestMod.idMobHelmetCrab, 16486475, 13887420);
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
    }
    
    private boolean isDimensionUnregistered(final int dimID) {
        try {
            DimensionManager.getProviderType(dimID);
            return false;
        }
        catch (IllegalArgumentException ex) {
            return true;
        }
    }
    
    private void registerThaumcraftIntegration() {
    }
    
    private void registerDispenseBehaviors(final MinecraftServer minecraftServer) {
        BlockDispenser.field_82527_a.func_82595_a((Object)TFItems.spawnEgg, (Object)new BehaviorTFMobEggDispense(minecraftServer));
    }
    
    private void loadConfiguration(final Configuration configFile) {
        configFile.load();
        TwilightForestMod.dimensionID = configFile.get("dimension", "dimensionID", 7).getInt();
        configFile.get("dimension", "dimensionID", 7).comment = "What ID number to assign to the Twilight Forest dimension.  Change if you are having conflicts with another mod.";
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
        TwilightForestMod.idBlockFirefly = configFile.getBlock("Critter", 2160).getInt();
        TwilightForestMod.idBlockPortal = configFile.getBlock("Portal", 2162).getInt();
        TwilightForestMod.idBlockLog = configFile.getBlock("Log", 2163).getInt();
        TwilightForestMod.idBlockLeaves = configFile.getBlock("Leaves", 2164).getInt();
        TwilightForestMod.idBlockMazestone = configFile.getBlock("Mazestone", 2165).getInt();
        TwilightForestMod.idBlockHedge = configFile.getBlock("Hedge", 2166).getInt();
        TwilightForestMod.idBlockBossSpawner = configFile.getBlock("BossSpawner", 2167).getInt();
        TwilightForestMod.idBlockFireflyJar = configFile.getBlock("FireflyJar", 2168).getInt();
        TwilightForestMod.idBlockPlant = configFile.getBlock("Plant", 2169).getInt();
        TwilightForestMod.idBlockRoots = configFile.getBlock("Roots", 2170).getInt();
        TwilightForestMod.idBlockCicada = configFile.getBlock("Cicada", 2171).getInt();
        TwilightForestMod.idBlockUncraftingTable = configFile.getBlock("UncraftingTable", 2172).getInt();
        TwilightForestMod.idBlockFireJet = configFile.getBlock("FireJet", 2173).getInt();
        TwilightForestMod.idBlockNagastone = configFile.getBlock("Nagastone", 2174).getInt();
        TwilightForestMod.idBlockSapling = configFile.getBlock("Sapling", 2175).getInt();
        TwilightForestMod.idBlockMagicLog = configFile.getBlock("MagicLog", 2176).getInt();
        TwilightForestMod.idBlockMagicLeaves = configFile.getBlock("MagicLeaves", 2177).getInt();
        TwilightForestMod.idBlockMoonworm = configFile.getBlock("Moonworm", 2178).getInt();
        TwilightForestMod.idBlockMagicLogSpecial = configFile.getBlock("MagicLogSpecial", 2179).getInt();
        TwilightForestMod.idBlockTowerWood = configFile.getBlock("TowerWood", 2180).getInt();
        TwilightForestMod.idBlockTowerDevice = configFile.getBlock("TowerDevice", 2181).getInt();
        TwilightForestMod.idBlockTowerAntenna = configFile.getBlock("TowerAntenna", 2182).getInt();
        TwilightForestMod.idBlockTowerTranslucent = configFile.getBlock("TowerTranslucent", 2183).getInt();
        TwilightForestMod.idBlockTrophy = configFile.getBlock("Trophy", 2184).getInt();
        TwilightForestMod.idItemNagaScale = configFile.getItem("NagaScale", 27701).getInt();
        TwilightForestMod.idItemPlateNaga = configFile.getItem("PlateNaga", 27702).getInt();
        TwilightForestMod.idItemLegsNaga = configFile.getItem("LegsNaga", 27703).getInt();
        TwilightForestMod.idItemScepterTwilight = configFile.getItem("ScepterTwilight", 27704).getInt();
        TwilightForestMod.idItemScepterLifeDrain = configFile.getItem("ScepterLifeDrain", 27705).getInt();
        TwilightForestMod.idItemScepterZombie = configFile.getItem("ScepterZombie", 27706).getInt();
        TwilightForestMod.idItemWandPacification = configFile.getItem("WandPacification", 27707).getInt();
        TwilightForestMod.idItemOreMeter = configFile.getItem("OreMeter", 27708).getInt();
        TwilightForestMod.idItemMagicMap = configFile.getItem("MagicMap", 27709).getInt();
        TwilightForestMod.idItemMazeMap = configFile.getItem("MazeMap", 27710).getInt();
        TwilightForestMod.idItemOreMap = configFile.getItem("OreMap", 27711).getInt();
        TwilightForestMod.idItemFeather = configFile.getItem("Feather", 27712).getInt();
        TwilightForestMod.idItemMagicMapFocus = configFile.getItem("MagicMapFocus", 27713).getInt();
        TwilightForestMod.idItemMazeMapFocus = configFile.getItem("MazeMapFocus", 27714).getInt();
        TwilightForestMod.idItemLiveRoot = configFile.getItem("LiveRoot", 27716).getInt();
        TwilightForestMod.idItemIronwoodRaw = configFile.getItem("IronwoodRaw", 27717).getInt();
        TwilightForestMod.idItemIronwoodIngot = configFile.getItem("IronwoodIngot", 27718).getInt();
        TwilightForestMod.idItemIronwoodHelm = configFile.getItem("IronwoodHelm", 27719).getInt();
        TwilightForestMod.idItemIronwoodPlate = configFile.getItem("IronwoodPlate", 27720).getInt();
        TwilightForestMod.idItemIronwoodLegs = configFile.getItem("IronwoodLegs", 27721).getInt();
        TwilightForestMod.idItemIronwoodBoots = configFile.getItem("IronwoodBoots", 27722).getInt();
        TwilightForestMod.idItemIronwoodSword = configFile.getItem("IronwoodSword", 27723).getInt();
        TwilightForestMod.idItemIronwoodShovel = configFile.getItem("IronwoodShovel", 27724).getInt();
        TwilightForestMod.idItemIronwoodPick = configFile.getItem("IronwoodPick", 27725).getInt();
        TwilightForestMod.idItemIronwoodAxe = configFile.getItem("IronwoodAxe", 27726).getInt();
        TwilightForestMod.idItemIronwoodHoe = configFile.getItem("IronwoodHoe", 27727).getInt();
        TwilightForestMod.idItemTorchberries = configFile.getItem("Torchberries", 27728).getInt();
        TwilightForestMod.idItemSpawnEgg = configFile.getItem("SpawnEgg", 27729).getInt();
        TwilightForestMod.idItemVenisonRaw = configFile.getItem("VenisonRaw", 27730).getInt();
        TwilightForestMod.idItemVenisonCooked = configFile.getItem("VenisonCooked", 27731).getInt();
        TwilightForestMod.idItemHydraChops = configFile.getItem("HydraChops", 27732).getInt();
        TwilightForestMod.idItemFieryBlood = configFile.getItem("FieryBlood", 27733).getInt();
        TwilightForestMod.idItemTrophy = configFile.getItem("HydraTrophy", 27734).getInt();
        TwilightForestMod.idItemFieryIngot = configFile.getItem("FieryIngot", 27735).getInt();
        TwilightForestMod.idItemFieryHelm = configFile.getItem("FieryHelm", 27736).getInt();
        TwilightForestMod.idItemFieryPlate = configFile.getItem("FieryPlate", 27737).getInt();
        TwilightForestMod.idItemFieryLegs = configFile.getItem("FieryLegs", 27738).getInt();
        TwilightForestMod.idItemFieryBoots = configFile.getItem("FieryBoots", 27739).getInt();
        TwilightForestMod.idItemFierySword = configFile.getItem("FierySword", 27740).getInt();
        TwilightForestMod.idItemFieryPick = configFile.getItem("FieryPick", 27741).getInt();
        TwilightForestMod.idItemSteeleafIngot = configFile.getItem("SteeleafIngot", 27742).getInt();
        TwilightForestMod.idItemSteeleafHelm = configFile.getItem("SteeleafHelm", 27743).getInt();
        TwilightForestMod.idItemSteeleafPlate = configFile.getItem("SteeleafPlate", 27744).getInt();
        TwilightForestMod.idItemSteeleafLegs = configFile.getItem("SteeleafLegs", 27745).getInt();
        TwilightForestMod.idItemSteeleafBoots = configFile.getItem("SteeleafBoots", 27746).getInt();
        TwilightForestMod.idItemSteeleafSword = configFile.getItem("SteeleafSword", 27747).getInt();
        TwilightForestMod.idItemSteeleafShovel = configFile.getItem("SteeleafShovel", 27748).getInt();
        TwilightForestMod.idItemSteeleafPick = configFile.getItem("SteeleafPick", 27749).getInt();
        TwilightForestMod.idItemSteeleafAxe = configFile.getItem("SteeleafAxe", 27750).getInt();
        TwilightForestMod.idItemSteeleafHoe = configFile.getItem("SteeleafHoe", 27751).getInt();
        TwilightForestMod.idItemMinotaurAxe = configFile.getItem("MinotaurAxe", 27752).getInt();
        TwilightForestMod.idItemMazebreakerPick = configFile.getItem("MazebreakerPick", 27753).getInt();
        TwilightForestMod.idItemTransformPowder = configFile.getItem("TransformPowder", 27754).getInt();
        TwilightForestMod.idItemMeefRaw = configFile.getItem("MeefRaw", 27755).getInt();
        TwilightForestMod.idItemMeefSteak = configFile.getItem("MeefSteak", 27756).getInt();
        TwilightForestMod.idItemMeefStroganoff = configFile.getItem("MeefStroganoff", 27757).getInt();
        TwilightForestMod.idItemMazeWafer = configFile.getItem("MazeWafer", 27758).getInt();
        TwilightForestMod.idItemEmptyMagicMap = configFile.getItem("EmptyMagicMap", 27759).getInt();
        TwilightForestMod.idItemEmptyMazeMap = configFile.getItem("EmptyMazeMap", 27760).getInt();
        TwilightForestMod.idItemEmptyOreMap = configFile.getItem("EmptyOreMap", 27761).getInt();
        TwilightForestMod.idItemOreMagnet = configFile.getItem("OreMagnet", 27762).getInt();
        TwilightForestMod.idItemCrumbleHorn = configFile.getItem("CrumbleHorn", 27763).getInt();
        TwilightForestMod.idItemPeacockFan = configFile.getItem("PeacockFan", 27764).getInt();
        TwilightForestMod.idItemMoonwormQueen = configFile.getItem("MoonwormQueen", 27765).getInt();
        TwilightForestMod.idItemCharmOfLife1 = configFile.getItem("CharmOfLife1", 27766).getInt();
        TwilightForestMod.idItemCharmOfLife2 = configFile.getItem("CharmOfLife2", 27767).getInt();
        TwilightForestMod.idItemCharmOfKeeping2 = configFile.getItem("CharmOfKeeping2", 27768).getInt();
        TwilightForestMod.idItemCharmOfKeeping3 = configFile.getItem("CharmOfKeeping3", 27769).getInt();
        TwilightForestMod.idItemCharmOfKeeping1 = configFile.getItem("CharmOfKeeping1", 27770).getInt();
        TwilightForestMod.idItemTowerKey = configFile.getItem("TowerKey", 27771).getInt();
        TwilightForestMod.idItemBorerEssence = configFile.getItem("BorerEssence", 27772).getInt();
        TwilightForestMod.idItemCarminite = configFile.getItem("Carminite", 27773).getInt();
        TwilightForestMod.idItemExperiment115 = configFile.getItem("Experiment115", 27774).getInt();
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
        TwilightForestMod.idBiomeLake = configFile.get("biome", "biome.id.Lake", 70).getInt();
        TwilightForestMod.idBiomeTwilightForest = configFile.get("biome", "biome.id.TwilightForest", 71).getInt();
        TwilightForestMod.idBiomeTwilightForestVariant = configFile.get("biome", "biome.id.TwilightForestVariant", 72).getInt();
        TwilightForestMod.idBiomeHighlands = configFile.get("biome", "biome.id.Highlands", 73).getInt();
        TwilightForestMod.idBiomeMushrooms = configFile.get("biome", "biome.id.Mushrooms", 74).getInt();
        TwilightForestMod.idBiomeSwamp = configFile.get("biome", "biome.id.Swamp", 75).getInt();
        TwilightForestMod.idBiomeStream = configFile.get("biome", "biome.id.Stream", 76).getInt();
        TwilightForestMod.idBiomeSnowfield = configFile.get("biome", "biome.id.Snowfield", 77).getInt();
        TwilightForestMod.idBiomeGlacier = configFile.get("biome", "biome.id.Glacier", 78).getInt();
        TwilightForestMod.idBiomeClearing = configFile.get("biome", "biome.id.Clearing", 79).getInt();
        TwilightForestMod.idBiomeClearingBorder = configFile.get("biome", "biome.id.ClearingBorder", 80).getInt();
        TwilightForestMod.idBiomeLakeBorder = configFile.get("biome", "biome.id.LakeBorder", 81).getInt();
        TwilightForestMod.idBiomeDeepMushrooms = configFile.get("biome", "biome.id.DeepMushrooms", 82).getInt();
        TwilightForestMod.idBiomeMajorFeature = configFile.get("biome", "biome.id.MajorFeature", 83).getInt();
        TwilightForestMod.idBiomeMinorFeature = configFile.get("biome", "biome.id.MinorFeature", 84).getInt();
        TwilightForestMod.idBiomeDarkForest = configFile.get("biome", "biome.id.DarkForest", 85).getInt();
        TwilightForestMod.idBiomeEnchantedForest = configFile.get("biome", "biome.id.EnchantedForest", 86).getInt();
        TwilightForestMod.idBiomeFireSwamp = configFile.get("biome", "biome.id.FireSwamp", 87).getInt();
        configFile.save();
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
        TwilightForestMod.dimensionProviderID = -777;
        TwilightForestMod.idVehicleSpawnNatureBolt = 1;
        TwilightForestMod.idVehicleSpawnLichBolt = 2;
        TwilightForestMod.idVehicleSpawnTwilightWandBolt = 3;
        TwilightForestMod.idVehicleSpawnTomeBolt = 4;
        TwilightForestMod.idVehicleSpawnHydraMortar = 5;
        TwilightForestMod.idVehicleSpawnLichBomb = 6;
        TwilightForestMod.idVehicleSpawnMoonwormShot = 7;
        TwilightForestMod.idVehicleSpawnSlimeBlob = 8;
        TwilightForestMod.idVehicleSpawnCharmEffect = 9;
        eventListener = new TFEventListener();
    }
}
