import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import net.minecraft.server.MinecraftServer;
import java.util.Random;
import forge.AchievementPage;
import forge.DimensionManager;
import forge.MinecraftForge;
import forge.Configuration;
import forge.NetworkMod;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class mod_TwilightForest extends NetworkMod
{
    public static mod_TwilightForest instance;
    static Configuration configFile;
    public static int idBlockFirefly;
    public static int idBlockCicada;
    public static int idBlockPortal;
    public static int idBlockLog;
    public static int idBlockLeaves;
    public static int idBlockMazestone;
    public static int idBlockHedge;
    public static int idBlockBossSpawner;
    public static int idBlockFireflyJar;
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
    public static boolean shouldOtherModsGenerateInTwlightForest;
    public static int fireflyRenderID;
    public static int cicadaRenderID;
    public static int fireflyJarRenderID;
    
    public mod_TwilightForest() {
        mod_TwilightForest.instance = this;
    }
    
    public void load() {
        MinecraftForge.versionDetect("Twilight Forest", 3, 1, 0);
        DimensionManager.registerDimension(7, (zl)new WorldProviderTwilightForest(), false);
        ModLoader.setInGameHook((BaseMod)this, true, true);
        this.registerCreatures();
        new TFBlocks();
        new TFItems();
        this.addRecipes();
        this.registerTileEntities();
        MinecraftForge.registerAchievementPage((AchievementPage)new TFAchievementPage());
    }
    
    private void addRecipes() {
        ModLoader.addRecipe(new kp(vz.x, 4, 0), new Object[] { "w", 'w', new kp(TFBlocks.wood, 1, 0) });
        ModLoader.addRecipe(new kp(vz.x, 4, 1), new Object[] { "w", 'w', new kp(TFBlocks.wood, 1, 1) });
        ModLoader.addRecipe(new kp(vz.x, 4, 2), new Object[] { "w", 'w', new kp(TFBlocks.wood, 1, 2) });
        ModLoader.addRecipe(new kp(vz.x, 4, 0), new Object[] { "w", 'w', new kp(TFBlocks.wood, 1, 8) });
        ModLoader.addRecipe(new kp(vz.x, 4, 1), new Object[] { "w", 'w', new kp(TFBlocks.wood, 1, 9) });
        ModLoader.addRecipe(new kp(vz.x, 4, 2), new Object[] { "w", 'w', new kp(TFBlocks.wood, 1, 10) });
        ModLoader.addSmelting(TFBlocks.wood.bO, new kp(id.l, 1, 1));
        ModLoader.addRecipe(new kp(TFItems.plateNaga, 1), new Object[] { "n n", "nnn", "nnn", 'n', TFItems.nagaScale });
        ModLoader.addRecipe(new kp(TFItems.legsNaga, 1), new Object[] { "nnn", "n n", "n n", 'n', TFItems.nagaScale });
        ModLoader.addShapelessRecipe(new kp(TFBlocks.fireflyJar), new Object[] { TFBlocks.firefly, id.bs });
        ModLoader.addShapelessRecipe(new kp(TFItems.scepterTwilight), new Object[] { new kp(TFItems.scepterTwilight, 1, TFItems.scepterTwilight.f()), id.bm });
        ModLoader.addShapelessRecipe(new kp(TFItems.scepterLifeDrain), new Object[] { new kp(TFItems.scepterLifeDrain, 1, TFItems.scepterLifeDrain.f()), id.bu });
        ModLoader.addShapelessRecipe(new kp(TFItems.scepterZombie), new Object[] { new kp(TFItems.scepterZombie, 1, TFItems.scepterZombie.f()), id.bl, new kp((id)id.br, 1, 8201) });
        ModLoader.addShapelessRecipe(new kp(TFItems.magicMapFocus), new Object[] { TFItems.feather, id.bv, id.aS });
        ModLoader.addRecipe(new kp(TFItems.magicMap, 1), new Object[] { "###", "#X#", "###", '#', id.aJ, 'X', TFItems.magicMapFocus });
        ModLoader.addShapelessRecipe(new kp(TFItems.magicMap), new Object[] { new kp(TFItems.magicMap, 1, -1), id.aJ });
        ModLoader.addRecipe(new kp(TFItems.mazeMap, 1), new Object[] { "###", "#X#", "###", '#', id.aJ, 'X', TFItems.mazeMapFocus });
        ModLoader.addShapelessRecipe(new kp(TFItems.mazeMap), new Object[] { new kp(TFItems.mazeMap, 1, -1), id.aJ });
        ModLoader.addShapelessRecipe(new kp(TFItems.oreMap), new Object[] { new kp(TFItems.mazeMap, 1, -1), vz.ah, vz.ax, vz.ai });
        ModLoader.addShapelessRecipe(new kp(TFItems.oreMap), new Object[] { new kp(TFItems.oreMap, 1, -1), id.aJ, id.l, id.aB });
        ModLoader.addRecipe(new kp(id.k, 4), new Object[] { "X", "#", "Y", 'Y', TFItems.feather, 'X', id.ao, '#', id.C });
    }
    
    private void registerTileEntities() {
        ModLoader.registerTileEntity((Class)TileEntityTFFirefly.class, "Firefly");
        ModLoader.registerTileEntity((Class)TileEntityTFCicada.class, "Cicada");
        ModLoader.registerTileEntity((Class)TileEntityTFNagaSpawner.class, "Naga Spawner");
        ModLoader.registerTileEntity((Class)TileEntityTFLichSpawner.class, "Lich Spawner");
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
        MinecraftForge.registerEntity((Class)EntityTFNatureBolt.class, (NetworkMod)this, mod_TwilightForest.idVehicleSpawnNatureBolt, 150, 5, true);
        MinecraftForge.registerEntity((Class)EntityTFLichBolt.class, (NetworkMod)this, mod_TwilightForest.idVehicleSpawnLichBolt, 150, 5, true);
        MinecraftForge.registerEntity((Class)EntityTFTwilightWandBolt.class, (NetworkMod)this, mod_TwilightForest.idVehicleSpawnTwilightWandBolt, 150, 5, true);
    }
    
    public void generateSurface(final ge world, final Random random, final int i, final int j) {
    }
    
    protected void makeSupplyChest(final ge world, final Random random, final int cx, final int cz) {
        final int spawnX = world.x.c();
        final int spawnZ = world.x.e();
        if (spawnX != 0 && spawnZ != 0 && spawnX >= cx && spawnX <= cx + 16 && spawnZ >= cz && spawnZ <= cz + 16) {
            System.out.println("Making supply chest at " + spawnX + ", " + spawnZ);
            final int dx = spawnX + random.nextInt(8) - random.nextInt(8);
            final int dz = spawnZ + random.nextInt(8) - random.nextInt(8);
            final int dy = world.g(dx, dz);
            world.e(dx, dy, dz, vz.au.bO);
            final lh tec = (lh)world.b(dx, dy, dz);
            if (tec != null && tec.c() > 0) {
                tec.a(0, new kp(id.as));
                tec.a(1, new kp(id.A));
                tec.a(2, new kp(id.z));
                tec.a(3, new kp(id.B));
                tec.a(4, new kp(id.p));
                tec.a(5, new kp(vz.ap, 14));
                tec.a(6, new kp(id.h));
                tec.a(7, new kp((vz)vz.ag, 64));
                tec.a(8, new kp((vz)vz.ae, 64));
                tec.a(9, new kp((vz)vz.ad, 64));
                tec.a(10, new kp((vz)vz.af, 64));
                tec.a(11, new kp(id.m, 64));
                tec.a(12, new kp(id.aw, 1));
            }
        }
    }
    
    public boolean onTickInGame(final MinecraftServer mcs) {
        this.checkForPlayerInPortal(mcs, 0);
        this.checkForPlayerInPortal(mcs, 7);
        this.checkForPortalPool(mcs, 0);
        this.checkForPortalPool(mcs, 7);
        return true;
    }
    
    private void checkForPlayerInPortal(final MinecraftServer mcs, final int dimension) {
        final ArrayList markedPlayers = new ArrayList();
        for (final ih player : this.getPlayerList(mcs, dimension)) {
            if (player.K > 0.6 && player.I == 0) {
                markedPlayers.add(player);
            }
        }
        for (final ih player : markedPlayers) {
            player.I = 10;
            player.K = 0.0f;
        }
        for (final ih player : markedPlayers) {
            this.interceptPortal(mcs, player);
        }
    }
    
    protected void checkForPortalPool(final MinecraftServer mcs, final int dimension) {
        final double CHECKRADIUS = 32.0;
        for (final ih player : this.getPlayerList(mcs, dimension)) {
            final List itemList = mcs.a(dimension).a((Class)ja.class, player.bw.b(CHECKRADIUS, CHECKRADIUS, CHECKRADIUS));
            for (final ja entityItem : itemList) {
                if (entityItem.bV && entityItem.a.c == id.m.bP) {
                    final int dx = kb.b(entityItem.bm);
                    final int dy = kb.b(entityItem.bn);
                    final int dz = kb.b(entityItem.bo);
                    if (!((BlockTFPortal)TFBlocks.portal).tryToCreatePortal((ge)mcs.a(dimension), dx, dy, dz)) {
                        continue;
                    }
                    mcs.a(dimension).a((tv)new d((ge)mcs.a(dimension), (double)dx, (double)dy, (double)dz));
                    player.a((xo)TFAchievementPage.twilightPortal);
                }
            }
        }
    }
    
    public List getPlayerList(final MinecraftServer mcs, final int dimension) {
        return new ArrayList(mcs.a(dimension).d);
    }
    
    public void interceptPortal(final MinecraftServer mcs, final ih player) {
        final boolean inTwilightPortal = this.isAABBInBlockID((ge)mcs.a(player.w), player.bw, TFBlocks.portal.bO);
        if (player.w == 7) {
            this.usePortal(mcs, player, 0);
        }
        else if (player.w == 0 && inTwilightPortal) {
            this.usePortal(mcs, player, 7);
            player.a((xo)TFAchievementPage.twilightPortal);
            player.a((xo)TFAchievementPage.twilightArrival);
        }
    }
    
    public boolean isAABBInBlockID(final ge world, final fp axisalignedbb, final int blockID) {
        final int i = kb.b(axisalignedbb.a);
        final int j = kb.b(axisalignedbb.d + 1.0);
        final int k = kb.b(axisalignedbb.b);
        final int l = kb.b(axisalignedbb.e + 1.0);
        final int i2 = kb.b(axisalignedbb.c);
        final int j2 = kb.b(axisalignedbb.f + 1.0);
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
    
    public void usePortal(final MinecraftServer mcs, final ih player, final int dimension) {
        player.I = 10;
        player.K = 0.0f;
        mcs.h.sendPlayerToOtherDimension((gi)player, dimension, (vw)new TFTeleporter());
        if (player.aE()) {}
    }
    
    public void takenFromCrafting(final ih player, final kp itemStack, final ni inventory) {
        if ((itemStack.c == TFItems.plateNaga.bP || itemStack.c == TFItems.legsNaga.bP) && itemStack.p() == null) {
            vo.a(player.bS, itemStack, 10 + player.bS.nextInt(30));
            player.a((xo)TFAchievementPage.twilightNagaArmors);
        }
        if (itemStack.c == TFItems.magicMapFocus.bP) {
            player.a((xo)TFAchievementPage.twilightMagicMapFocus);
        }
        if (itemStack.c == TFItems.magicMap.bP) {
            player.a((xo)TFAchievementPage.twilightMagicMap);
        }
        if (itemStack.c == TFItems.mazeMap.bP) {
            player.a((xo)TFAchievementPage.twilightMazeMap);
        }
        if (itemStack.c == TFItems.oreMap.bP) {
            player.a((xo)TFAchievementPage.twilightOreMap);
        }
    }
    
    private static void loadConfiguration() {
        mod_TwilightForest.configFile.load();
        mod_TwilightForest.idBlockFirefly = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Firefly", 130).value);
        mod_TwilightForest.idBlockCicada = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Cicada", 131).value);
        mod_TwilightForest.idBlockPortal = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Portal", 132).value);
        mod_TwilightForest.idBlockLog = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Log", 133).value);
        mod_TwilightForest.idBlockLeaves = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Leaves", 134).value);
        mod_TwilightForest.idBlockMazestone = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Mazestone", 135).value);
        mod_TwilightForest.idBlockHedge = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("Hedge", 136).value);
        mod_TwilightForest.idBlockBossSpawner = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("BossSpawner", 137).value);
        mod_TwilightForest.idBlockFireflyJar = Integer.parseInt(mod_TwilightForest.configFile.getOrCreateBlockIdProperty("FireflyJar", 138).value);
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
        mod_TwilightForest.shouldOtherModsGenerateInTwlightForest = Boolean.parseBoolean(mod_TwilightForest.configFile.getOrCreateBooleanProperty("shouldOtherModsGenerateInTwlightForest", "general", false).value);
        mod_TwilightForest.configFile.save();
    }
    
    public String getVersion() {
        return "1.9.1";
    }
    
    public boolean clientSideRequired() {
        return true;
    }
    
    public boolean serverSideRequired() {
        return false;
    }
    
    static {
        mod_TwilightForest.configFile = new Configuration(new File("config/TwilightForest.cfg"));
        loadConfiguration();
        mod_TwilightForest.idVehicleSpawnNatureBolt = 1;
        mod_TwilightForest.idVehicleSpawnLichBolt = 2;
        mod_TwilightForest.idVehicleSpawnTwilightWandBolt = 3;
    }
}
