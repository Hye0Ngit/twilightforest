import forge.MinecraftForge;
import net.minecraft.client.Minecraft;
import java.util.Random;
import java.util.Map;
import forge.DimensionManager;
import forge.NetworkMod;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class mod_TwilightForest extends NetworkMod
{
    @MLProp
    public static int idBlockFirefly;
    @MLProp
    public static int idBlockCicada;
    @MLProp
    public static int idBlockPortal;
    @MLProp
    public static int idBlockLog;
    @MLProp
    public static int idBlockLeaves;
    @MLProp
    public static int idBlockMazestone;
    @MLProp
    public static int idBlockHedge;
    @MLProp
    public static int idBlockBossSpawner;
    @MLProp
    public static int idItemNagaScale;
    @MLProp
    public static int idMobWildBoar;
    @MLProp
    public static int idMobBighornSheep;
    @MLProp
    public static int idMobWildDeer;
    @MLProp
    public static int idMobRedcap;
    @MLProp
    public static int idMobSwarmSpider;
    @MLProp
    public static int idMobNaga;
    @MLProp
    public static int idMobNagaSegment;
    @MLProp
    public static int idMobSkeletonDruid;
    @MLProp
    public static int idMobHostileWolf;
    @MLProp
    public static int idMobTwilightWraith;
    @MLProp
    public static int idMobHedgeSpider;
    @MLProp
    public static int idVehicleSpawnNatureBolt;
    @MLProp
    public static int idMobHydra;
    @MLProp
    public static int idMobLich;
    @MLProp
    public static int idMobPenguin;
    @MLProp
    public static boolean shouldOtherModsGenerateInTwlightForest;
    public static int fireflyRenderID;
    public static int cicadaRenderID;
    
    mod_TwilightForest() {
        DimensionManager.registerDimension(7, (akv)new WorldProviderTwilightForest(), true);
        ModLoader.setInGameHook((BaseMod)this, true, true);
        ModLoader.setInGUIHook((BaseMod)this, true, true);
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
        ModLoaderMp.registerNetClientHandlerEntity((Class)EntityTFNatureBolt.class, true, mod_TwilightForest.idVehicleSpawnNatureBolt);
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
        ModLoader.addLocalization("entity.Hydra.name", "Hydra");
        ModLoader.addLocalization("entity.Twilight Lich.name", "Twilight Lich");
        ModLoader.addLocalization("entity.Penguin.name", "Penguin");
        new TFBlocks();
        new TFItems();
        ModLoader.addRecipe(new aai(ox.x, 4), new Object[] { "w", 'w', TFBlocks.wood });
        ModLoader.addRecipe(new aai(ym.ai, 1), new Object[] { "n n", "nnn", "nnn", 'n', TFItems.nagaScale });
        ModLoader.addRecipe(new aai(ym.aj, 1), new Object[] { "nnn", "n n", "n n", 'n', TFItems.nagaScale });
        mod_TwilightForest.fireflyRenderID = ModLoader.getUniqueBlockModelID((BaseMod)this, false);
        mod_TwilightForest.cicadaRenderID = ModLoader.getUniqueBlockModelID((BaseMod)this, false);
        this.addTileEntityMapping(TileEntityTFFirefly.class, "Firefly");
        this.addTileEntityMapping(TileEntityTFCicada.class, "Cicada");
        this.addTileEntityMapping(TileEntityTFBossSpawner.class, "Boss Spawner");
        this.addTileEntityRendererMapping(TileEntityTFFirefly.class, new TileEntityTFFireflyRenderer());
        this.addTileEntityRendererMapping(TileEntityTFCicada.class, new TileEntityTFCicadaRenderer());
        this.addTileEntityRendererMapping(TileEntityTFBossSpawner.class, (aam)new ae());
    }
    
    public void addRenderer(final Map map) {
        map.put(EntityTFBoar.class, new iu((hl)new ModelTFBoar(), (hl)new dj(0.5f), 0.7f));
        map.put(EntityTFBighorn.class, new alk((hl)new ModelTFBighorn(), (hl)new ModelTFBighornFur(), 0.7f));
        map.put(EntityTFDeer.class, new ajb((hl)new ModelTFDeer(), 0.7f));
        map.put(EntityTFRedcap.class, new tc((xc)new ModelTFRedcap(), 0.625f));
        map.put(EntityTFSwarmSpider.class, new RenderTFSwarmSpider());
        map.put(EntityTFNaga.class, new RenderTFNaga(new ModelTFNaga(), 0.625f));
        map.put(EntityTFNagaSegment.class, new RenderTFNaga(new ModelTFNaga(), 0.625f));
        map.put(EntityTFTinyFirefly.class, new RenderTFTinyFirefly());
        map.put(EntityTFSkeletonDruid.class, new tc((xc)new ModelTFSkeletonDruid(), 0.5f));
        map.put(EntityTFWraith.class, new RenderTFWraith((xc)new wn(), 0.5f));
        map.put(EntityTFHydra.class, new RenderTFHydra(new ModelTFHydra(), 1.0f));
        map.put(EntityTFLich.class, new RenderTFLich((xc)new ModelTFLich(), 1.0f));
        map.put(EntityTFPenguin.class, new gk((hl)new ModelTFPenguin(), 1.0f));
        map.put(EntityTFNatureBolt.class, new cp(ym.S.b(0)));
        map.put(EntityTFLichBolt.class, new cp(ym.bn.b(0)));
        map.put(EntityTFHydraHead.class, new fb((hl)new ModelTFHydraHead(), 1.0f));
        map.put(EntityTFHydraNeck.class, new fb((hl)new ModelTFHydraNeck(), 1.0f));
    }
    
    public void generateSurface(final wz world, final Random random, final int i, final int j) {
    }
    
    protected void makeSupplyChest(final wz world, final Random random, final int cx, final int cz) {
        final int spawnX = world.x.c();
        final int spawnZ = world.x.e();
        if (spawnX != 0 && spawnZ != 0 && spawnX >= cx && spawnX <= cx + 16 && spawnZ >= cz && spawnZ <= cz + 16) {
            System.out.println("Making supply chest at " + spawnX + ", " + spawnZ);
            final int dx = spawnX + random.nextInt(8) - random.nextInt(8);
            final int dz = spawnZ + random.nextInt(8) - random.nextInt(8);
            final int dy = world.g(dx, dz);
            world.g(dx, dy, dz, ox.au.bO);
            final gy tec = (gy)world.b(dx, dy, dz);
            if (tec != null && tec.a() > 0) {
                tec.a(0, new aai(ym.at));
                tec.a(1, new aai(ym.B));
                tec.a(2, new aai(ym.A));
                tec.a(3, new aai(ym.C));
                tec.a(4, new aai(ym.q));
                tec.a(5, new aai(ox.ap, 14));
                tec.a(6, new aai(ym.i));
                tec.a(7, new aai((ox)ox.ag, 64));
                tec.a(8, new aai((ox)ox.ae, 64));
                tec.a(9, new aai((ox)ox.ad, 64));
                tec.a(10, new aai((ox)ox.af, 64));
                tec.a(11, new aai(ym.n, 64));
                tec.a(12, new aai(ym.ax, 1));
            }
        }
    }
    
    public boolean onTickInGame(final float f, final Minecraft mc) {
        for (int j = 0; j < mc.f.b.size(); ++j) {
            final nk entity = mc.f.b.get(j);
            if (entity instanceof fn && entity.X && ((fn)entity).a.c == ym.n.bQ) {
                final Random rand = new Random();
                for (int k = 0; k < 2; ++k) {
                    final double d = rand.nextGaussian() * 0.02;
                    final double d2 = rand.nextGaussian() * 0.02;
                    final double d3 = rand.nextGaussian() * 0.02;
                    mc.f.a("spell", entity.o, entity.p + 0.2, entity.q, d, d2, d3);
                }
                if (!mc.l()) {
                    final int dx = gh.c(entity.o);
                    final int dy = gh.c(entity.p);
                    final int dz = gh.c(entity.q);
                    if (((BlockTFPortal)TFBlocks.portal).tryToCreatePortal(mc.f, dx, dy, dz)) {}
                }
            }
        }
        if (mc.l()) {
            if (mc.h.aB == 7 && !(mc.f instanceof TFWorldClient)) {
                sendToTwilightForestMulti(mc);
            }
            return true;
        }
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
        return true;
    }
    
    public boolean onTickInGUI(final float f, final Minecraft mc, final vl guiscreen) {
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
            mc.usePortal(0, (ot)new TFTeleporter());
            mc.h.aP = 10;
            mc.h.aR = 0.0f;
        }
        else if (mc.h.aB == 0 && inTwilightPortal) {
            mc.usePortal(7, (ot)new TFTeleporter());
            mc.h.aP = 10;
            mc.h.aR = 0.0f;
        }
    }
    
    public boolean isAABBInBlockID(final wz world, final wq axisalignedbb, final int blockID) {
        final int i = gh.c(axisalignedbb.a);
        final int j = gh.c(axisalignedbb.d + 1.0);
        final int k = gh.c(axisalignedbb.b);
        final int l = gh.c(axisalignedbb.e + 1.0);
        final int i2 = gh.c(axisalignedbb.c);
        final int j2 = gh.c(axisalignedbb.f + 1.0);
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
            mc.f.a((nk)mc.h, false);
            new TFTeleporter().a(mc.f, (nk)mc.h);
        }
    }
    
    public void sendToTwilightForest(final Minecraft mc) {
        if (mc.f instanceof jb) {
            return;
        }
        mc.f.b((nk)mc.h);
        mc.h.G = false;
        double newY = mc.h.p;
        if (mc.h.aB == 0) {
            newY *= 0.5;
        }
        mc.h.c(mc.h.o, newY, mc.h.q, mc.h.u, mc.h.v);
        if (mc.h.M()) {
            mc.f.a((nk)mc.h, false);
        }
        wz world = null;
        world = new TFWorld(mc.f, new WorldProviderTwilightForest());
        mc.a(world, "Entering the Twilight Forest", (yr)mc.h);
        mc.h.k = mc.f;
        mc.h.aB = 7;
    }
    
    public static void sendToTwilightForestMulti(final Minecraft mc) {
        final boolean isCreative = ((rg)mc.c).h();
        final TFWorldClient tfWorld = new TFWorldClient((jb)mc.f);
        tfWorld.F = true;
        mc.a((wz)tfWorld, "Entering the Twilight Forest", (yr)mc.h);
        tfWorld.clearAllButOnePlayer((yr)mc.h);
        mc.h.k = mc.f;
        mc.h.aB = 7;
        ((rg)mc.c).a(isCreative);
        setWorldClient(mc, (TFWorldClient)mc.f);
        System.out.println("Successfully replaced world with TFWorld");
    }
    
    private static void setWorldClient(final Minecraft mc, final TFWorldClient newWorld) {
        final adg nch = mc.q();
        for (int i = 0; i < adg.class.getDeclaredFields().length; ++i) {
            try {
                if (ModLoader.getPrivateValue((Class)adg.class, (Object)nch, i) instanceof jb) {
                    ModLoader.setPrivateValue((Class)adg.class, (Object)nch, i, (Object)newWorld);
                }
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            catch (SecurityException e2) {
                e2.printStackTrace();
            }
            catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
        }
    }
    
    public void sendToSurface(final Minecraft mc) {
        mc.f.b((nk)mc.h);
        mc.h.G = false;
        double newY = mc.h.p;
        if (mc.h.aB == 0) {
            newY *= 2.0;
        }
        mc.h.c(mc.h.o, newY, mc.h.q, mc.h.u, mc.h.v);
        if (mc.h.M()) {
            mc.f.a((nk)mc.h, false);
        }
        wz world1 = null;
        world1 = new wz(mc.f, akv.a(0));
        mc.a(world1, "Leaving the Twilight Forest", (yr)mc.h);
        mc.h.k = mc.f;
        mc.h.aB = 0;
    }
    
    public void addTileEntityMapping(final Class classToMap, final String nameToMap) {
        Map nameToClassMap = null;
        Map classToNameMap = null;
        try {
            nameToClassMap = (Map)ModLoader.getPrivateValue((Class)kt.class, (Object)new kt(), 0);
            classToNameMap = (Map)ModLoader.getPrivateValue((Class)kt.class, (Object)new kt(), 1);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        if (classToNameMap.containsKey(nameToMap)) {
            throw new IllegalArgumentException("Duplicate id: " + nameToMap);
        }
        nameToClassMap.put(nameToMap, classToMap);
        classToNameMap.put(classToMap, nameToMap);
    }
    
    public void addTileEntityRendererMapping(final Class classToMap, final aam rendererForMap) {
        Map specialRendererMap = null;
        try {
            specialRendererMap = (Map)ModLoader.getPrivateValue((Class)acc.class, (Object)acc.a, 0);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        specialRendererMap.put(classToMap, rendererForMap);
        rendererForMap.a(acc.a);
    }
    
    public boolean renderWorldBlock(final vh renderblocks, final alc blockAccess, final int x, final int y, final int z, final ox block, final int l) {
        if (l == mod_TwilightForest.fireflyRenderID) {
            return BlockTFFirefly.renderFirefly(renderblocks, blockAccess, x, y, z, block);
        }
        return l == mod_TwilightForest.cicadaRenderID && BlockTFCicada.renderCicada(renderblocks, blockAccess, x, y, z, block);
    }
    
    public String getVersion() {
        return "1.7.1-forge";
    }
    
    public void load() {
        MinecraftForge.versionDetect("Twilight Forest", 1, 4, 0);
    }
    
    public boolean clientSideRequired() {
        return true;
    }
    
    public boolean serverSideRequired() {
        return false;
    }
    
    static {
        mod_TwilightForest.idBlockFirefly = 130;
        mod_TwilightForest.idBlockCicada = 131;
        mod_TwilightForest.idBlockPortal = 132;
        mod_TwilightForest.idBlockLog = 133;
        mod_TwilightForest.idBlockLeaves = 134;
        mod_TwilightForest.idBlockMazestone = 135;
        mod_TwilightForest.idBlockHedge = 136;
        mod_TwilightForest.idBlockBossSpawner = 137;
        mod_TwilightForest.idItemNagaScale = 7701;
        mod_TwilightForest.idMobWildBoar = 177;
        mod_TwilightForest.idMobBighornSheep = 178;
        mod_TwilightForest.idMobWildDeer = 179;
        mod_TwilightForest.idMobRedcap = 180;
        mod_TwilightForest.idMobSwarmSpider = 181;
        mod_TwilightForest.idMobNaga = 182;
        mod_TwilightForest.idMobNagaSegment = 183;
        mod_TwilightForest.idMobSkeletonDruid = 184;
        mod_TwilightForest.idMobHostileWolf = 185;
        mod_TwilightForest.idMobTwilightWraith = 186;
        mod_TwilightForest.idMobHedgeSpider = 187;
        mod_TwilightForest.idVehicleSpawnNatureBolt = 188;
        mod_TwilightForest.idMobHydra = 189;
        mod_TwilightForest.idMobLich = 190;
        mod_TwilightForest.idMobPenguin = 191;
        mod_TwilightForest.shouldOtherModsGenerateInTwlightForest = false;
    }
}
