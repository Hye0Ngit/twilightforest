import java.io.File;
import twilightforest.GuiTFGoblinCrafting;
import twilightforest.ItemTFMazeMap;
import twilightforest.ItemTFMagicMap;
import twilightforest.BlockTFPlant;
import twilightforest.BlockTFComplex;
import twilightforest.TFEnchantedRecipe;
import java.util.HashMap;
import twilightforest.TFTeleporter;
import java.util.Iterator;
import java.util.List;
import twilightforest.TFWorld;
import twilightforest.TFWorldClient;
import twilightforest.BlockTFPortal;
import java.util.Random;
import twilightforest.ModelTFHydraNeck;
import twilightforest.EntityTFHydraNeck;
import twilightforest.ModelTFHydraHead;
import twilightforest.EntityTFHydraHead;
import twilightforest.ModelTFQuestRam;
import twilightforest.ModelTFRaven;
import twilightforest.ModelTFBunny;
import twilightforest.ModelTFSquirrel;
import twilightforest.RenderTFBird;
import twilightforest.ModelTFTinyBird;
import twilightforest.ModelTFLoyalZombie;
import twilightforest.ModelTFLichMinion;
import twilightforest.ModelTFPenguin;
import twilightforest.RenderTFLich;
import twilightforest.ModelTFLich;
import twilightforest.RenderTFHydra;
import twilightforest.ModelTFHydra;
import twilightforest.RenderTFWraith;
import twilightforest.ModelTFSkeletonDruid;
import twilightforest.RenderTFTinyFirefly;
import twilightforest.EntityTFTinyFirefly;
import twilightforest.RenderTFNaga;
import twilightforest.ModelTFNaga;
import twilightforest.ModelTFRedcap;
import twilightforest.ModelTFDeer;
import twilightforest.ModelTFBighornFur;
import twilightforest.ModelTFBighorn;
import twilightforest.ModelTFBoar;
import java.util.Map;
import twilightforest.EntityTFTwilightWandBolt;
import twilightforest.EntityTFLichBolt;
import twilightforest.EntityTFNatureBolt;
import twilightforest.EntityTFQuestRam;
import twilightforest.EntityTFRaven;
import twilightforest.EntityTFBunny;
import twilightforest.EntityTFSquirrel;
import twilightforest.EntityTFTinyBird;
import twilightforest.EntityTFLoyalZombie;
import twilightforest.EntityTFLichMinion;
import twilightforest.EntityTFPenguin;
import twilightforest.EntityTFLich;
import twilightforest.EntityTFHydra;
import twilightforest.EntityTFHedgeSpider;
import twilightforest.EntityTFWraith;
import twilightforest.EntityTFHostileWolf;
import twilightforest.EntityTFSkeletonDruid;
import twilightforest.EntityTFNagaSegment;
import twilightforest.EntityTFNaga;
import twilightforest.EntityTFSwarmSpider;
import twilightforest.EntityTFRedcap;
import twilightforest.EntityTFDeer;
import twilightforest.EntityTFBighorn;
import twilightforest.EntityTFBoar;
import twilightforest.TileEntityTFLichSpawner;
import twilightforest.TileEntityTFNagaSpawner;
import twilightforest.TileEntityTFCicadaRenderer;
import twilightforest.TileEntityTFCicada;
import twilightforest.TileEntityTFFireflyRenderer;
import twilightforest.TileEntityTFFirefly;
import net.minecraft.client.Minecraft;
import forge.AchievementPage;
import twilightforest.TFAchievementPage;
import twilightforest.TFPortalCache;
import twilightforest.TFSounds;
import forge.IItemRenderer;
import forge.MinecraftForgeClient;
import twilightforest.TFMagicMapRenderer;
import twilightforest.TFItems;
import twilightforest.TFBlocks;
import forge.DimensionManager;
import twilightforest.WorldProviderTwilightForest;
import forge.MinecraftForge;
import forge.Configuration;
import forge.IGuiHandler;
import forge.NetworkMod;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class mod_TwilightForest extends NetworkMod implements IGuiHandler
{
    public static mod_TwilightForest instance;
    static Configuration configFile;
    public static int idBlockCritter;
    public static int idBlockPortal;
    public static int idBlockLog;
    public static int idBlockLeaves;
    public static int idBlockMazestone;
    public static int idBlockHedge;
    public static int idBlockBossSpawner;
    public static int idBlockFireflyJar;
    public static int idBlockPlant;
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
    public static int idVehicleSpawnNatureBolt;
    public static int idVehicleSpawnLichBolt;
    public static int idVehicleSpawnTwilightWandBolt;
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
    public static int idBiomeRuins;
    public static boolean shouldOtherModsGenerateInTwlightForest;
    public static int critterRenderID;
    public static int blockComplexRenderID;
    public static int plantRenderID;
    
    public mod_TwilightForest() {
        mod_TwilightForest.instance = this;
    }
    
    public void load() {
        MinecraftForge.versionDetect("Twilight Forest", 3, 1, 3);
        DimensionManager.registerDimension(7, (alb)new WorldProviderTwilightForest(), false);
        ModLoader.setInGameHook((BaseMod)this, true, true);
        ModLoader.setInGUIHook((BaseMod)this, true, true);
        this.registerCreatures();
        new TFBlocks();
        new TFItems();
        this.addRecipes();
        mod_TwilightForest.blockComplexRenderID = ModLoader.getUniqueBlockModelID((BaseMod)this, true);
        mod_TwilightForest.plantRenderID = ModLoader.getUniqueBlockModelID((BaseMod)this, false);
        mod_TwilightForest.critterRenderID = ModLoader.getUniqueBlockModelID((BaseMod)this, false);
        final Minecraft mc = ModLoader.getMinecraftInstance();
        MinecraftForgeClient.registerItemRenderer(TFItems.magicMap.bQ, (IItemRenderer)new TFMagicMapRenderer(mc.q, mc.A, mc.p));
        this.registerTileEntities();
        if (this.exists(MinecraftForge.class.getCanonicalName().replace("MinecraftForge", "ISoundHandler"))) {
            TFSounds.registerYourself();
        }
        else {
            ModLoader.getLogger().fine("Twilight Forest mod cannot register sounds.  This error is non-fatal and can be solved by upgrading to Forge version 3.1.3 or higher.");
            System.err.println("Twilight Forest mod cannot register sounds.  This error is non-fatal and can be solved by upgrading to Forge version 3.1.3 or higher.");
        }
        new TFPortalCache();
        MinecraftForge.registerAchievementPage((AchievementPage)new TFAchievementPage());
        MinecraftForge.setGuiHandler((BaseMod)this, (IGuiHandler)this);
    }
    
    public boolean exists(final String className) {
        try {
            Class.forName(className);
            return true;
        }
        catch (ClassNotFoundException exception) {
            return false;
        }
    }
    
    private void addRecipes() {
        ModLoader.addRecipe(new aan(pb.x, 4, 0), new Object[] { "w", 'w', new aan(TFBlocks.wood, 1, 0) });
        ModLoader.addRecipe(new aan(pb.x, 4, 1), new Object[] { "w", 'w', new aan(TFBlocks.wood, 1, 1) });
        ModLoader.addRecipe(new aan(pb.x, 4, 2), new Object[] { "w", 'w', new aan(TFBlocks.wood, 1, 2) });
        ModLoader.addRecipe(new aan(pb.x, 4, 1), new Object[] { "w", 'w', new aan(TFBlocks.wood, 1, 3) });
        ModLoader.addRecipe(new aan(pb.x, 4, 0), new Object[] { "w", 'w', new aan(TFBlocks.wood, 1, 8) });
        ModLoader.addRecipe(new aan(pb.x, 4, 1), new Object[] { "w", 'w', new aan(TFBlocks.wood, 1, 9) });
        ModLoader.addRecipe(new aan(pb.x, 4, 2), new Object[] { "w", 'w', new aan(TFBlocks.wood, 1, 10) });
        ModLoader.addRecipe(new aan(pb.x, 4, 1), new Object[] { "w", 'w', new aan(TFBlocks.wood, 1, 11) });
        ModLoader.addSmelting(TFBlocks.wood.bO, new aan(yr.m, 1, 1));
        ModLoader.addRecipe(new aan(TFItems.plateNaga, 1), new Object[] { "n n", "nnn", "nnn", 'n', TFItems.nagaScale });
        ModLoader.addRecipe(new aan(TFItems.legsNaga, 1), new Object[] { "nnn", "n n", "n n", 'n', TFItems.nagaScale });
        ModLoader.addShapelessRecipe(new aan(TFBlocks.complex, 1, 0), new Object[] { TFBlocks.critter, yr.bt });
        ModLoader.addShapelessRecipe(new aan(TFItems.scepterTwilight), new Object[] { new aan(TFItems.scepterTwilight, 1, TFItems.scepterTwilight.h()), yr.bn });
        ModLoader.addShapelessRecipe(new aan(TFItems.scepterLifeDrain), new Object[] { new aan(TFItems.scepterLifeDrain, 1, TFItems.scepterLifeDrain.h()), yr.bv });
        ModLoader.addShapelessRecipe(new aan(TFItems.scepterZombie), new Object[] { new aan(TFItems.scepterZombie, 1, TFItems.scepterZombie.h()), yr.bm, new aan((yr)yr.bs, 1, 8201) });
        ModLoader.addShapelessRecipe(new aan(TFItems.magicMapFocus), new Object[] { TFItems.feather, yr.bw, yr.aT });
        ModLoader.addRecipe(new aan(TFItems.magicMap, 1), new Object[] { "###", "#X#", "###", '#', yr.aK, 'X', TFItems.magicMapFocus });
        ModLoader.addShapelessRecipe(new aan(TFItems.magicMap), new Object[] { new aan(TFItems.magicMap, 1, -1), yr.aK });
        ModLoader.addRecipe(new aan(TFItems.mazeMap, 1), new Object[] { "###", "#X#", "###", '#', yr.aK, 'X', TFItems.mazeMapFocus });
        ModLoader.addShapelessRecipe(new aan(TFItems.mazeMap), new Object[] { new aan(TFItems.mazeMap, 1, -1), yr.aK });
        ModLoader.addShapelessRecipe(new aan(TFItems.oreMap), new Object[] { new aan(TFItems.mazeMap, 1, -1), pb.ah, pb.ax, pb.ai });
        ModLoader.addShapelessRecipe(new aan(TFItems.oreMap), new Object[] { new aan(TFItems.oreMap, 1, -1), yr.aK, yr.m, yr.aC });
        ModLoader.addRecipe(new aan(yr.l, 4), new Object[] { "X", "#", "Y", 'Y', TFItems.feather, 'X', yr.ap, '#', yr.D });
        ModLoader.addShapelessRecipe(new aan(yr.D, 1), new Object[] { new aan(TFBlocks.plant, 1, 14) });
        ModLoader.addRecipe(new aan(pb.aq, 5), new Object[] { "B", "S", 'B', TFItems.torchberries, 'S', yr.D });
        ModLoader.addShapelessRecipe(new aan(TFItems.ironwoodRaw), new Object[] { TFItems.liveRoot, yr.o, yr.bq });
        ModLoader.addSmelting(TFItems.ironwoodRaw.bQ, new aan(TFItems.ironwoodIngot));
        this.addEnchantedRecipe(TFItems.ironwoodHelm, jt.h, 1, "###", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodPlate, jt.b, 1, "# #", "###", "###", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodLegs, jt.b, 1, "###", "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodBoots, jt.d, 1, "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodSword, jt.l, 1, "#", "#", "X", '#', TFItems.ironwoodIngot, 'X', yr.D);
        this.addEnchantedRecipe(TFItems.ironwoodShovel, jt.q, 1, "#", "X", "X", '#', TFItems.ironwoodIngot, 'X', yr.D);
        this.addEnchantedRecipe(TFItems.ironwoodPick, jt.o, 1, "###", " X ", " X ", '#', TFItems.ironwoodIngot, 'X', yr.D);
        this.addEnchantedRecipe(TFItems.ironwoodAxe, jt.r, 1, "##", "#X", " X", '#', TFItems.ironwoodIngot, 'X', yr.D);
        this.addEnchantedRecipe(TFItems.ironwoodHoe, null, 0, "##", " X", " X", '#', TFItems.ironwoodIngot, 'X', yr.D);
        ModLoader.addRecipe(new aan(TFBlocks.complex, 1, 1), new Object[] { "###", "#X#", "###", '#', pb.ay, 'X', TFItems.mazeMapFocus });
    }
    
    private void registerTileEntities() {
        ModLoader.registerTileEntity((Class)TileEntityTFFirefly.class, "Firefly", (aar)new TileEntityTFFireflyRenderer());
        ModLoader.registerTileEntity((Class)TileEntityTFCicada.class, "Cicada", (aar)new TileEntityTFCicadaRenderer());
        ModLoader.registerTileEntity((Class)TileEntityTFNagaSpawner.class, "Naga Spawner", (aar)new af());
        ModLoader.registerTileEntity((Class)TileEntityTFLichSpawner.class, "Lich Spawner", (aar)new af());
    }
    
    private void registerCreatures() {
        ModLoader.registerEntityID((Class)EntityTFBoar.class, "Wild Boar", mod_TwilightForest.idMobWildBoar, 8611131, 16773066);
        ModLoader.registerEntityID((Class)EntityTFBighorn.class, "Bighorn Sheep", mod_TwilightForest.idMobBighornSheep, 14405295, 14141297);
        ModLoader.registerEntityID((Class)EntityTFDeer.class, "Wild Deer", mod_TwilightForest.idMobWildDeer, 8080686, 4924445);
        ModLoader.registerEntityID((Class)EntityTFRedcap.class, "Redcap", mod_TwilightForest.idMobRedcap, 3881580, 11214356);
        ModLoader.registerEntityID((Class)EntityTFSwarmSpider.class, "Swarm Spider", mod_TwilightForest.idMobSwarmSpider, 3277358, 1516830);
        ModLoader.registerEntityID((Class)EntityTFNaga.class, "Naga", mod_TwilightForest.idMobNaga, 10801942, 1783819);
        ModLoader.registerEntityID((Class)EntityTFNagaSegment.class, "Naga Segment", mod_TwilightForest.idMobNagaSegment);
        ModLoader.registerEntityID((Class)EntityTFSkeletonDruid.class, "Skeleton Druid", mod_TwilightForest.idMobSkeletonDruid, 10724259, 2767639);
        ModLoader.registerEntityID((Class)EntityTFHostileWolf.class, "Hostile Wolf", mod_TwilightForest.idMobHostileWolf, 14144467, 11214356);
        ModLoader.registerEntityID((Class)EntityTFWraith.class, "Twilight Wraith", mod_TwilightForest.idMobTwilightWraith, 5263440, 8618883);
        ModLoader.registerEntityID((Class)EntityTFHedgeSpider.class, "Hedge Spider", mod_TwilightForest.idMobHedgeSpider, 2318099, 5645907);
        ModLoader.registerEntityID((Class)EntityTFHydra.class, "Hydra", mod_TwilightForest.idMobHydra, 1321280, 2719851);
        ModLoader.registerEntityID((Class)EntityTFLich.class, "Twilight Lich", mod_TwilightForest.idMobLich, 11314313, 3540082);
        ModLoader.registerEntityID((Class)EntityTFPenguin.class, "Penguin", mod_TwilightForest.idMobPenguin, 1185051, 16379346);
        ModLoader.registerEntityID((Class)EntityTFLichMinion.class, "Lich Minion", mod_TwilightForest.idMobLichMinion);
        ModLoader.registerEntityID((Class)EntityTFLoyalZombie.class, "Loyal Zombie", mod_TwilightForest.idMobLoyalZombie);
        ModLoader.registerEntityID((Class)EntityTFTinyBird.class, "Tiny Bird", mod_TwilightForest.idMobTinyBird, 3386077, 1149166);
        ModLoader.registerEntityID((Class)EntityTFSquirrel.class, "Forest Squirrel", mod_TwilightForest.idMobSquirrel, 9457426, 15658734);
        ModLoader.registerEntityID((Class)EntityTFBunny.class, "Forest Bunny", mod_TwilightForest.idMobBunny, 16711406, 13413017);
        ModLoader.registerEntityID((Class)EntityTFRaven.class, "Forest Raven", mod_TwilightForest.idMobRaven, 17, 2236979);
        ModLoader.registerEntityID((Class)EntityTFQuestRam.class, "Questing Ram", mod_TwilightForest.idMobQuestRam);
        MinecraftForge.registerEntity((Class)EntityTFNatureBolt.class, (NetworkMod)this, mod_TwilightForest.idVehicleSpawnNatureBolt, 150, 5, true);
        MinecraftForge.registerEntity((Class)EntityTFLichBolt.class, (NetworkMod)this, mod_TwilightForest.idVehicleSpawnLichBolt, 150, 5, true);
        MinecraftForge.registerEntity((Class)EntityTFTwilightWandBolt.class, (NetworkMod)this, mod_TwilightForest.idVehicleSpawnTwilightWandBolt, 150, 5, true);
        ModLoader.addLocalization("entity.Wild Boar.name", "Wild Boar");
        ModLoader.addLocalization("entity.Bighorn Sheep.name", "Bighorn Sheep");
        ModLoader.addLocalization("entity.Wild Deer.name", "Wild Deer");
        ModLoader.addLocalization("entity.Redcap.name", "Redcap");
        ModLoader.addLocalization("entity.Swarm Spider.name", "Swarm Spider");
        ModLoader.addLocalization("entity.Naga.name", "Naga");
        ModLoader.addLocalization("entity.Naga Segment.name", "Naga Segment");
        ModLoader.addLocalization("entity.Skeleton Druid.name", "Skeleton Druid");
        ModLoader.addLocalization("entity.Hostile Wolf.name", "Hostile Wolf");
        ModLoader.addLocalization("entity.Twilight Wraith.name", "Twilight Wraith");
        ModLoader.addLocalization("entity.Hedge Spider.name", "Hedge Spider");
        ModLoader.addLocalization("entity.Hydra.name", "Hydra [WIP]");
        ModLoader.addLocalization("entity.Twilight Lich.name", "Twilight Lich");
        ModLoader.addLocalization("entity.Penguin.name", "Penguin");
        ModLoader.addLocalization("entity.Tiny Bird.name", "Tiny Bird");
        ModLoader.addLocalization("entity.Forest Squirrel.name", "Forest Squirrel");
        ModLoader.addLocalization("entity.Forest Bunny.name", "Forest Bunny");
        ModLoader.addLocalization("entity.Forest Raven.name", "Forest Raven");
        ModLoader.addLocalization("entity.Questing Ram.name", "Questing Ram [WIP]");
    }
    
    public void addRenderer(final Map map) {
        map.put(EntityTFBoar.class, new ix((ho)new ModelTFBoar(), (ho)new dl(0.5f), 0.7f));
        map.put(EntityTFBighorn.class, new alq((ho)new ModelTFBighorn(), (ho)new ModelTFBighornFur(), 0.7f));
        map.put(EntityTFDeer.class, new ajh((ho)new ModelTFDeer(), 0.7f));
        map.put(EntityTFRedcap.class, new tg((xg)new ModelTFRedcap(), 0.625f));
        map.put(EntityTFNaga.class, new RenderTFNaga(new ModelTFNaga(), 0.625f));
        map.put(EntityTFNagaSegment.class, new RenderTFNaga(new ModelTFNaga(), 0.625f));
        map.put(EntityTFTinyFirefly.class, new RenderTFTinyFirefly());
        map.put(EntityTFSkeletonDruid.class, new tg((xg)new ModelTFSkeletonDruid(), 0.5f));
        map.put(EntityTFWraith.class, new RenderTFWraith((xg)new wr(), 0.5f));
        map.put(EntityTFHydra.class, new RenderTFHydra(new ModelTFHydra(), 1.0f));
        map.put(EntityTFLich.class, new RenderTFLich((xg)new ModelTFLich(), 1.0f));
        map.put(EntityTFPenguin.class, new gn((ho)new ModelTFPenguin(), 1.0f));
        map.put(EntityTFLichMinion.class, new tg((xg)new ModelTFLichMinion(), 1.0f));
        map.put(EntityTFLoyalZombie.class, new tg((xg)new ModelTFLoyalZombie(), 1.0f));
        map.put(EntityTFTinyBird.class, new RenderTFBird(new ModelTFTinyBird(), 1.0f));
        map.put(EntityTFSquirrel.class, new fe((ho)new ModelTFSquirrel(), 1.0f));
        map.put(EntityTFBunny.class, new fe((ho)new ModelTFBunny(), 1.0f));
        map.put(EntityTFRaven.class, new RenderTFBird(new ModelTFRaven(), 1.0f));
        map.put(EntityTFQuestRam.class, new fe((ho)new ModelTFQuestRam(), 1.0f));
        map.put(EntityTFNatureBolt.class, new cr(yr.S.b(0)));
        map.put(EntityTFLichBolt.class, new cr(yr.bn.b(0)));
        map.put(EntityTFTwilightWandBolt.class, new cr(yr.bn.b(0)));
        map.put(EntityTFHydraHead.class, new fe((ho)new ModelTFHydraHead(), 1.0f));
        map.put(EntityTFHydraNeck.class, new fe((ho)new ModelTFHydraNeck(), 1.0f));
    }
    
    public void generateSurface(final xd world, final Random random, final int i, final int j) {
    }
    
    protected void makeSupplyChest(final xd world, final Random random, final int cx, final int cz) {
        final int spawnX = world.x.c();
        final int spawnZ = world.x.e();
        if (spawnX != 0 && spawnZ != 0 && spawnX >= cx && spawnX <= cx + 16 && spawnZ >= cz && spawnZ <= cz + 16) {
            System.out.println("Making supply chest at " + spawnX + ", " + spawnZ);
            final int dx = spawnX + random.nextInt(8) - random.nextInt(8);
            final int dz = spawnZ + random.nextInt(8) - random.nextInt(8);
            final int dy = world.g(dx, dz);
            world.g(dx, dy, dz, pb.au.bO);
            final hb tec = (hb)world.b(dx, dy, dz);
            if (tec != null && tec.a() > 0) {
                tec.a(0, new aan(yr.at));
                tec.a(1, new aan(yr.B));
                tec.a(2, new aan(yr.A));
                tec.a(3, new aan(yr.C));
                tec.a(4, new aan(yr.q));
                tec.a(5, new aan(pb.ap, 14));
                tec.a(6, new aan(yr.i));
                tec.a(7, new aan((pb)pb.ag, 64));
                tec.a(8, new aan((pb)pb.ae, 64));
                tec.a(9, new aan((pb)pb.ad, 64));
                tec.a(10, new aan((pb)pb.af, 64));
                tec.a(11, new aan(yr.n, 64));
                tec.a(12, new aan(yr.ax, 1));
                tec.a(13, new aan(TFItems.scepterTwilight, 1));
                tec.a(14, new aan(TFItems.scepterLifeDrain, 1));
                tec.a(15, new aan(TFItems.scepterZombie, 1));
                tec.a(16, new aan(TFItems.nagaScale, 64));
            }
        }
    }
    
    public boolean onTickInGame(final float f, final Minecraft mc) {
        lv.a("Twilight Forest tick");
        if (mc.f != null && mc.h != null) {
            final List itemList = mc.f.a((Class)fq.class, mc.h.y.b(32.0, 32.0, 32.0));
            for (final fq entityItem : itemList) {
                if (entityItem.X && entityItem.a.c == yr.n.bQ) {
                    final Random rand = new Random();
                    for (int k = 0; k < 2; ++k) {
                        final double d = rand.nextGaussian() * 0.02;
                        final double d2 = rand.nextGaussian() * 0.02;
                        final double d3 = rand.nextGaussian() * 0.02;
                        mc.f.a("spell", entityItem.o, entityItem.p + 0.2, entityItem.q, d, d2, d3);
                    }
                    if (mc.l()) {
                        continue;
                    }
                    final int dx = gk.c(entityItem.o);
                    final int dy = gk.c(entityItem.p);
                    final int dz = gk.c(entityItem.q);
                    if (!((BlockTFPortal)TFBlocks.portal).tryToCreatePortal(mc.f, dx, dy, dz)) {
                        continue;
                    }
                    mc.h.a((ajw)TFAchievementPage.twilightPortal);
                }
            }
        }
        if (mc.l()) {
            if (mc.h.aB == 7 && !(mc.f instanceof TFWorldClient)) {
                sendToTwilightForestMulti(mc);
            }
        }
        else {
            if (!mc.l() && mc.h != null && mc.h.aR > 0.8 && mc.h.aP == 0) {
                this.interceptPortal(mc);
            }
            if (!mc.l() && mc.h != null && mc.h.aB == 7 && !(mc.f instanceof TFWorld)) {
                this.sendToTwilightForest(mc);
            }
            if (mc.h != null && mc.f.t instanceof WorldProviderTwilightForest && mc.h.aB != 7) {
                mc.h.aB = 7;
                System.err.println("Found the player in the wrong dimension.");
            }
        }
        lv.b();
        return true;
    }
    
    public boolean onTickInGUI(final float f, final Minecraft mc, final vp guiscreen) {
        if (mc.l()) {
            if (mc.h.aB == 7 && !(mc.f instanceof TFWorldClient)) {
                sendToTwilightForestMulti(mc);
            }
            return true;
        }
        if (mc.f != null && mc.h != null && mc.h.aB == 7 && !(mc.f.t instanceof WorldProviderTwilightForest)) {
            this.sendToTwilightForest(mc);
        }
        return true;
    }
    
    public void interceptPortal(final Minecraft mc) {
        final boolean inTwilightPortal = this.isAABBInBlockID(mc.f, mc.h.y, TFBlocks.portal.bO);
        if (mc.h.aB == 7) {
            mc.h.aP = 10;
            mc.h.aR = 0.0f;
            mc.usePortal(0, (ox)new TFTeleporter());
        }
        else if (mc.h.aB == 0 && inTwilightPortal) {
            mc.h.aP = 10;
            mc.h.aR = 0.0f;
            mc.usePortal(7, (ox)new TFTeleporter());
        }
    }
    
    public boolean isAABBInBlockID(final xd world, final wu axisalignedbb, final int blockID) {
        final int i = gk.c(axisalignedbb.a);
        final int j = gk.c(axisalignedbb.d + 1.0);
        final int k = gk.c(axisalignedbb.b);
        final int l = gk.c(axisalignedbb.e + 1.0);
        final int i2 = gk.c(axisalignedbb.c);
        final int j2 = gk.c(axisalignedbb.f + 1.0);
        for (int k2 = i; k2 < j; ++k2) {
            for (int l2 = k; l2 < l; ++l2) {
                for (int i3 = i2; i3 < j2; ++i3) {
                    if (world.a(k2, l2, i3) == blockID) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void usePortal(final Minecraft mc, final int dimension) {
        mc.h.aP = 10;
        mc.h.aR = 0.0f;
        if (dimension == 0) {
            this.sendToSurface(mc);
        }
        else if (dimension == 7) {
            this.sendToTwilightForest(mc);
        }
        if (mc.h.M()) {
            mc.h.c(mc.h.o, mc.h.p, mc.h.q, mc.h.u, mc.h.v);
            mc.f.a((nn)mc.h, false);
            new TFTeleporter().a(mc.f, (nn)mc.h);
        }
    }
    
    public void sendToTwilightForest(final Minecraft mc) {
        if (mc.f instanceof je) {
            return;
        }
        mc.f.b((nn)mc.h);
        mc.h.G = false;
        double newY = mc.h.p;
        if (mc.h.aB == 0) {
            newY *= 0.5;
        }
        mc.h.c(mc.h.o, newY, mc.h.q, mc.h.u, mc.h.v);
        if (mc.h.M()) {
            mc.f.a((nn)mc.h, false);
        }
        xd world = null;
        world = new TFWorld(mc.f, new WorldProviderTwilightForest());
        mc.a(world, "Entering the Twilight Forest", (yw)mc.h);
        mc.h.k = mc.f;
        mc.h.aB = 7;
        mc.h.a((ajw)TFAchievementPage.twilightPortal);
        mc.h.a((ajw)TFAchievementPage.twilightArrival);
    }
    
    public static void sendToTwilightForestMulti(final Minecraft mc) {
        final boolean isCreative = ((rk)mc.c).h();
        final TFWorldClient tfWorld = new TFWorldClient((je)mc.f);
        tfWorld.F = true;
        mc.a((xd)tfWorld, "Entering the Twilight Forest", (yw)mc.h);
        tfWorld.clearAllButOnePlayer((yw)mc.h);
        mc.h.k = mc.f;
        mc.h.aB = 7;
        ((rk)mc.c).a(isCreative);
        setWorldClient(mc, (TFWorldClient)mc.f);
        mc.h.a((ajw)TFAchievementPage.twilightPortal);
        mc.h.a((ajw)TFAchievementPage.twilightArrival);
    }
    
    private static void setWorldClient(final Minecraft mc, final TFWorldClient newWorld) {
        final adl nch = mc.q();
        for (int i = 0; i < adl.class.getDeclaredFields().length; ++i) {
            try {
                if (ModLoader.getPrivateValue((Class)adl.class, (Object)nch, i) instanceof je) {
                    ModLoader.setPrivateValue((Class)adl.class, (Object)nch, i, (Object)newWorld);
                }
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            catch (SecurityException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public void sendToSurface(final Minecraft mc) {
        mc.f.b((nn)mc.h);
        mc.h.G = false;
        double newY = mc.h.p;
        if (mc.h.aB == 0) {
            newY *= 2.0;
        }
        mc.h.c(mc.h.o, newY, mc.h.q, mc.h.u, mc.h.v);
        if (mc.h.M()) {
            mc.f.a((nn)mc.h, false);
        }
        xd world1 = null;
        world1 = new xd(mc.f, alb.a(0));
        mc.a(world1, "Leaving the Twilight Forest", (yw)mc.h);
        mc.h.k = mc.f;
        mc.h.aB = 0;
    }
    
    public void addEnchantedRecipe(final yr item, final jt enchantment, final int enchantmentLevel, final Object... ingredientArray) {
        final aan result = new aan(item);
        if (enchantment != null) {
            result.a(enchantment, enchantmentLevel);
        }
        String ingredientString = "";
        int ingIndex = 0;
        int width = 0;
        int height = 0;
        if (ingredientArray[ingIndex] instanceof String[]) {
            final String[] var7 = (String[])ingredientArray[ingIndex++];
            for (int var8 = 0; var8 < var7.length; ++var8) {
                final String var9 = var7[var8];
                ++height;
                width = var9.length();
                ingredientString += var9;
            }
        }
        else {
            while (ingredientArray[ingIndex] instanceof String) {
                final String var10 = (String)ingredientArray[ingIndex++];
                ++height;
                width = var10.length();
                ingredientString += var10;
            }
        }
        final HashMap ingredientMap = new HashMap();
        while (ingIndex < ingredientArray.length) {
            final Character var11 = (Character)ingredientArray[ingIndex];
            aan var12 = null;
            if (ingredientArray[ingIndex + 1] instanceof yr) {
                var12 = new aan((yr)ingredientArray[ingIndex + 1]);
            }
            else if (ingredientArray[ingIndex + 1] instanceof pb) {
                var12 = new aan((pb)ingredientArray[ingIndex + 1], 1, -1);
            }
            else if (ingredientArray[ingIndex + 1] instanceof aan) {
                var12 = (aan)ingredientArray[ingIndex + 1];
            }
            ingredientMap.put(var11, var12);
            ingIndex += 2;
        }
        final aan[] recipeItems = new aan[width * height];
        for (int var13 = 0; var13 < width * height; ++var13) {
            final char var14 = ingredientString.charAt(var13);
            if (ingredientMap.containsKey(var14)) {
                recipeItems[var13] = ingredientMap.get(var14).k();
            }
            else {
                recipeItems[var13] = null;
            }
        }
        fr.a().b().add(new TFEnchantedRecipe(width, height, recipeItems, result));
    }
    
    public void takenFromCrafting(final yw player, final aan itemStack, final io inventory) {
        if ((itemStack.c == TFItems.plateNaga.bQ || itemStack.c == TFItems.legsNaga.bQ) && itemStack.p() == null) {
            ais.a(player.U, itemStack, 10 + player.U.nextInt(30));
            player.a((ajw)TFAchievementPage.twilightNagaArmors);
        }
        if (itemStack.c == TFItems.magicMapFocus.bQ) {
            player.a((ajw)TFAchievementPage.twilightMagicMapFocus);
        }
        if (itemStack.c == TFItems.magicMap.bQ) {
            player.a((ajw)TFAchievementPage.twilightMagicMap);
        }
        if (itemStack.c == TFItems.mazeMap.bQ) {
            player.a((ajw)TFAchievementPage.twilightMazeMap);
        }
        if (itemStack.c == TFItems.oreMap.bQ) {
            player.a((ajw)TFAchievementPage.twilightOreMap);
        }
    }
    
    public boolean renderWorldBlock(final vl renderblocks, final ali blockAccess, final int x, final int y, final int z, final pb block, final int renderType) {
        if (renderType == mod_TwilightForest.blockComplexRenderID) {
            return BlockTFComplex.renderComplex(renderblocks, blockAccess, x, y, z, block);
        }
        return renderType == mod_TwilightForest.plantRenderID && BlockTFPlant.renderPlant(renderblocks, blockAccess, x, y, z, block);
    }
    
    public void renderInvBlock(final vl renderblocks, final pb block, final int meta, final int modelID) {
        if (modelID == mod_TwilightForest.blockComplexRenderID) {
            BlockTFComplex.renderInvBlock(renderblocks, block, meta);
        }
    }
    
    public void onPacketData(final lg net, final short id, final byte[] data) {
        if (data[0] == 16 || data[0] == 17 || data[0] == 18) {
            ItemTFMagicMap.getMPMapData(id, ModLoader.getMinecraftInstance().f).loadDataFromByteArray(data);
        }
        if (data[0] == 19 || data[0] == 20) {
            ItemTFMazeMap.getMPMapData(id, ModLoader.getMinecraftInstance().f).loadDataFromByteArray(data);
        }
    }
    
    public Object getGuiElement(final int ID, final yw player, final xd world, final int x, final int y, final int z) {
        if (ID == 1) {
            return new GuiTFGoblinCrafting(player.ap, world, x, y, z);
        }
        return null;
    }
    
    private static void loadConfiguration() {
        mod_TwilightForest.configFile.load();
        mod_TwilightForest.idBlockCritter = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Critter", 130).value);
        mod_TwilightForest.idBlockPortal = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Portal", 132).value);
        mod_TwilightForest.idBlockLog = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Log", 133).value);
        mod_TwilightForest.idBlockLeaves = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Leaves", 134).value);
        mod_TwilightForest.idBlockMazestone = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Mazestone", 135).value);
        mod_TwilightForest.idBlockHedge = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Hedge", 136).value);
        mod_TwilightForest.idBlockBossSpawner = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("BossSpawner", 137).value);
        mod_TwilightForest.idBlockFireflyJar = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("FireflyJar", 138).value);
        mod_TwilightForest.idBlockPlant = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Plant", 139).value);
        mod_TwilightForest.idItemNagaScale = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("NagaScale", "item", 7701).value);
        mod_TwilightForest.idItemPlateNaga = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("PlateNaga", "item", 7702).value);
        mod_TwilightForest.idItemLegsNaga = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("LegsNaga", "item", 7703).value);
        mod_TwilightForest.idItemScepterTwilight = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("ScepterTwilight", "item", 7704).value);
        mod_TwilightForest.idItemScepterLifeDrain = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("ScepterLifeDrain", "item", 7705).value);
        mod_TwilightForest.idItemScepterZombie = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("ScepterZombie", "item", 7706).value);
        mod_TwilightForest.idItemWandPacification = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("WandPacification", "item", 7707).value);
        mod_TwilightForest.idItemOreMeter = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("OreMeter", "item", 7708).value);
        mod_TwilightForest.idItemMagicMap = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("MagicMap", "item", 7709).value);
        mod_TwilightForest.idItemMazeMap = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("MazeMap", "item", 7710).value);
        mod_TwilightForest.idItemOreMap = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("OreMap", "item", 7711).value);
        mod_TwilightForest.idItemFeather = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("Feather", "item", 7712).value);
        mod_TwilightForest.idItemMagicMapFocus = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("MagicMapFocus", "item", 7713).value);
        mod_TwilightForest.idItemMazeMapFocus = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("MazeMapFocus", "item", 7714).value);
        mod_TwilightForest.idItemLiveRoot = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("LiveRoot", "item", 7716).value);
        mod_TwilightForest.idItemIronwoodRaw = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodRaw", "item", 7717).value);
        mod_TwilightForest.idItemIronwoodIngot = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodIngot", "item", 7718).value);
        mod_TwilightForest.idItemIronwoodHelm = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodHelm", "item", 7719).value);
        mod_TwilightForest.idItemIronwoodPlate = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodPlate", "item", 7720).value);
        mod_TwilightForest.idItemIronwoodLegs = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodLegs", "item", 7721).value);
        mod_TwilightForest.idItemIronwoodBoots = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodBoots", "item", 7722).value);
        mod_TwilightForest.idItemIronwoodSword = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodSword", "item", 7723).value);
        mod_TwilightForest.idItemIronwoodShovel = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodShovel", "item", 7724).value);
        mod_TwilightForest.idItemIronwoodPick = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodPick", "item", 7725).value);
        mod_TwilightForest.idItemIronwoodAxe = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodAxe", "item", 7726).value);
        mod_TwilightForest.idItemIronwoodHoe = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("IronwoodHoe", "item", 7727).value);
        mod_TwilightForest.idItemTorchberries = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("Torchberries", "item", 7728).value);
        mod_TwilightForest.idMobWildBoar = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.WildBoar", "general", 177).value);
        mod_TwilightForest.idMobBighornSheep = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.BighornSheep", "general", 178).value);
        mod_TwilightForest.idMobWildDeer = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.WildDeer", "general", 179).value);
        mod_TwilightForest.idMobRedcap = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.Redcap", "general", 180).value);
        mod_TwilightForest.idMobSwarmSpider = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.SwarmSpider", "general", 181).value);
        mod_TwilightForest.idMobNaga = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.Naga", "general", 182).value);
        mod_TwilightForest.idMobNagaSegment = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.NagaSegment", "general", 183).value);
        mod_TwilightForest.idMobSkeletonDruid = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.SkeletonDruid", "general", 184).value);
        mod_TwilightForest.idMobHostileWolf = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.HostileWolf", "general", 185).value);
        mod_TwilightForest.idMobTwilightWraith = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.TwilightWraith", "general", 186).value);
        mod_TwilightForest.idMobHedgeSpider = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.HedgeSpider", "general", 187).value);
        mod_TwilightForest.idMobHydra = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.Hydra", "general", 189).value);
        mod_TwilightForest.idMobLich = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.Lich", "general", 190).value);
        mod_TwilightForest.idMobPenguin = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.Penguin", "general", 191).value);
        mod_TwilightForest.idMobLichMinion = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.LichMinion", "general", 192).value);
        mod_TwilightForest.idMobLoyalZombie = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.LoyalZombie", "general", 193).value);
        mod_TwilightForest.idMobTinyBird = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.TinyBird", "general", 194).value);
        mod_TwilightForest.idMobSquirrel = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.Squirrel", "general", 195).value);
        mod_TwilightForest.idMobBunny = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.Bunny", "general", 196).value);
        mod_TwilightForest.idMobRaven = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.Raven", "general", 197).value);
        mod_TwilightForest.idMobQuestRam = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("entity.id.QuestRam", "general", 198).value);
        mod_TwilightForest.idBiomeLake = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.Lake", "general", 70).value);
        mod_TwilightForest.idBiomeTwilightForest = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.TwilightForest", "general", 71).value);
        mod_TwilightForest.idBiomeTwilightForestVariant = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.TwilightForestVariant", "general", 72).value);
        mod_TwilightForest.idBiomeHighlands = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.Highlands", "general", 73).value);
        mod_TwilightForest.idBiomeMushrooms = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.Mushrooms", "general", 74).value);
        mod_TwilightForest.idBiomeSwamp = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.Swamp", "general", 75).value);
        mod_TwilightForest.idBiomeStream = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.Stream", "general", 76).value);
        mod_TwilightForest.idBiomeSnowfield = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.Snowfield", "general", 77).value);
        mod_TwilightForest.idBiomeGlacier = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.Glacier", "general", 78).value);
        mod_TwilightForest.idBiomeClearing = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.Clearing", "general", 79).value);
        mod_TwilightForest.idBiomeClearingBorder = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.ClearingBorder", "general", 80).value);
        mod_TwilightForest.idBiomeLakeBorder = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.LakeBorder", "general", 81).value);
        mod_TwilightForest.idBiomeDeepMushrooms = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.DeepMushrooms", "general", 82).value);
        mod_TwilightForest.idBiomeMajorFeature = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.MajorFeature", "general", 83).value);
        mod_TwilightForest.idBiomeMinorFeature = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.MinorFeature", "general", 84).value);
        mod_TwilightForest.idBiomeDarkForest = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.DarkForest", "general", 85).value);
        mod_TwilightForest.idBiomeEnchantedForest = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.EnchantedForest", "general", 86).value);
        mod_TwilightForest.idBiomeRuins = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateIntProperty("biome.id.Ruins", "general", 87).value);
        mod_TwilightForest.shouldOtherModsGenerateInTwlightForest = Boolean.parseBoolean(mod_TwilightForest.configFile.getOrCreateBooleanProperty("shouldOtherModsGenerateInTwlightForest", "general", false).value);
        mod_TwilightForest.configFile.save();
    }
    
    public String getVersion() {
        return "1.10.1";
    }
    
    public boolean clientSideRequired() {
        return true;
    }
    
    public boolean serverSideRequired() {
        return false;
    }
    
    static {
        mod_TwilightForest.configFile = new Configuration(new File(Minecraft.b(), "config/TwilightForest.cfg"));
        loadConfiguration();
        mod_TwilightForest.idVehicleSpawnNatureBolt = 1;
        mod_TwilightForest.idVehicleSpawnLichBolt = 2;
        mod_TwilightForest.idVehicleSpawnTwilightWandBolt = 3;
    }
}
