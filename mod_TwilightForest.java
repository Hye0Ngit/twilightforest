import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class mod_TwilightForest extends BaseModMp
{
    public static boolean SAPIexists;
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
    public static boolean shouldOtherModsGenerateInTwlightForest;
    public static int fireflyRenderID;
    public static int cicadaRenderID;
    
    mod_TwilightForest() {
        ModLoader.SetInGameHook((BaseMod)this, true, true);
        ModLoader.RegisterEntityID((Class)EntityTFBoar.class, "Wild Boar", mod_TwilightForest.idMobWildBoar);
        ModLoader.RegisterEntityID((Class)EntityTFBighorn.class, "Bighorn Sheep", mod_TwilightForest.idMobBighornSheep);
        ModLoader.RegisterEntityID((Class)EntityTFDeer.class, "Wild Deer", mod_TwilightForest.idMobWildDeer);
        ModLoader.RegisterEntityID((Class)EntityTFRedcap.class, "Redcap", mod_TwilightForest.idMobRedcap);
        ModLoader.RegisterEntityID((Class)EntityTFSwarmSpider.class, "Swarm Spider", mod_TwilightForest.idMobSwarmSpider);
        ModLoader.RegisterEntityID((Class)EntityTFNaga.class, "Naga", mod_TwilightForest.idMobNaga);
        ModLoader.RegisterEntityID((Class)EntityTFNagaSegment.class, "Naga Segment", mod_TwilightForest.idMobNagaSegment);
        ModLoader.RegisterEntityID((Class)EntityTFSkeletonDruid.class, "Skeleton Druid", mod_TwilightForest.idMobSkeletonDruid);
        ModLoader.RegisterEntityID((Class)EntityTFHostileWolf.class, "Hostile Wolf", mod_TwilightForest.idMobHostileWolf);
        ModLoader.RegisterEntityID((Class)EntityTFWraith.class, "Twilight Wraith", mod_TwilightForest.idMobTwilightWraith);
        ModLoader.RegisterEntityID((Class)EntityTFHedgeSpider.class, "Hedge Spider", mod_TwilightForest.idMobHedgeSpider);
        ModLoaderMp.RegisterEntityTrackerEntry((Class)EntityTFNatureBolt.class, true, mod_TwilightForest.idVehicleSpawnNatureBolt);
        ModLoaderMp.RegisterEntityTracker((Class)EntityTFNatureBolt.class, 160, 5);
        new TFBlocks();
        new TFItems();
        ModLoader.AddRecipe(new jm(ud.z, 4), new Object[] { "w", 'w', TFBlocks.wood });
        ModLoader.AddRecipe(new jm(hg.ah, 1), new Object[] { "n n", "nnn", "nnn", 'n', TFItems.nagaScale });
        ModLoader.AddRecipe(new jm(hg.ai, 1), new Object[] { "nnn", "n n", "n n", 'n', TFItems.nagaScale });
        mod_TwilightForest.fireflyRenderID = ModLoader.getUniqueBlockModelID((BaseMod)this, false);
        mod_TwilightForest.cicadaRenderID = ModLoader.getUniqueBlockModelID((BaseMod)this, false);
        this.addTileEntityMapping(TileEntityTFFirefly.class, "Firefly");
        this.addTileEntityMapping(TileEntityTFCicada.class, "Cicada");
        this.addTileEntityMapping(TileEntityTFBossSpawner.class, "Boss Spawner");
    }
    
    public void GenerateSurface(final fq world, final Random random, final int i, final int j) {
    }
    
    protected void makeSupplyChest(final fq world, final Random random, final int cx, final int cz) {
        final int spawnX = world.C.c();
        final int spawnZ = world.C.e();
        if (spawnX != 0 && spawnZ != 0 && spawnX >= cx && spawnX <= cx + 16 && spawnZ >= cz && spawnZ <= cz + 16) {
            System.out.println("Making supply chest at " + spawnX + ", " + spawnZ);
            final int dx = spawnX + random.nextInt(8) - random.nextInt(8);
            final int dz = spawnZ + random.nextInt(8) - random.nextInt(8);
            final int dy = world.e(dx, dz);
            world.e(dx, dy, dz, ud.aw.bO);
            final kd tec = (kd)world.b(dx, dy, dz);
            if (tec != null && tec.c() > 0) {
                tec.a(0, new jm(hg.as));
                tec.a(1, new jm(hg.A));
                tec.a(2, new jm(hg.z));
                tec.a(3, new jm(hg.B));
                tec.a(4, new jm(hg.p));
                tec.a(5, new jm(ud.ar, 14));
                tec.a(6, new jm(hg.h));
                tec.a(7, new jm((ud)ud.ai, 64));
                tec.a(8, new jm((ud)ud.ag, 64));
                tec.a(9, new jm((ud)ud.af, 64));
                tec.a(10, new jm((ud)ud.ah, 64));
                tec.a(11, new jm(hg.m, 64));
                tec.a(12, new jm(hg.aw, 1));
            }
        }
    }
    
    public void OnTickInGame(final MinecraftServer mcs) {
        final int dimension = 0;
        hk playerInPortal = null;
        for (final hk player : mcs.a(dimension).i) {
            if (player != null && player.K > 0.8 && player.I == 0) {
                playerInPortal = player;
            }
        }
        if (playerInPortal != null) {
            this.interceptPortal(mcs, playerInPortal);
        }
        this.checkForPortalPool(mcs, 0);
        this.checkForPortalPool(mcs, 7);
    }
    
    protected void checkForPortalPool(final MinecraftServer mcs, final int dimension) {
        final Iterator iterator = this.getTrackedEntitySet(mcs, dimension).iterator();
        while (iterator.hasNext()) {
            final se entity = iterator.next().a;
            if (entity instanceof ia && entity.bV && ((ia)entity).a.c == hg.m.bN) {
                System.out.println("I found a diamond in the water!");
                final int dx = iy.b(entity.bm);
                final int dy = iy.b(entity.bn);
                final int dz = iy.b(entity.bo);
                if (!((BlockTFPortal)TFBlocks.portal).tryToCreatePortal((fq)mcs.a(dimension), dx, dy, dz)) {
                    continue;
                }
                mcs.a(dimension).a((se)new d((fq)mcs.a(dimension), (double)dx, (double)dy, (double)dz));
            }
        }
    }
    
    private Set getTrackedEntitySet(final MinecraftServer mcs, final int dimension) {
        for (int i = 0; i < vb.class.getDeclaredFields().length; ++i) {
            try {
                if (ModLoader.getPrivateValue((Class)vb.class, (Object)mcs.b(dimension), i) instanceof Set) {
                    return (Set)ModLoader.getPrivateValue((Class)vb.class, (Object)mcs.b(dimension), i);
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
        return null;
    }
    
    public void interceptPortal(final MinecraftServer mcs, final hk player) {
        final boolean inTwilightPortal = this.isAABBInBlockID((fq)mcs.a(player.w), player.bw, TFBlocks.portal.bO);
        if (player.w == 7) {
            this.usePortal(mcs, player, 0);
        }
        else if (player.w == 0 && inTwilightPortal) {
            this.usePortal(mcs, player, 7);
        }
    }
    
    public boolean isAABBInBlockID(final fq world, final fb axisalignedbb, final int blockID) {
        final int i = iy.b(axisalignedbb.a);
        final int j = iy.b(axisalignedbb.d + 1.0);
        final int k = iy.b(axisalignedbb.b);
        final int l = iy.b(axisalignedbb.e + 1.0);
        final int i2 = iy.b(axisalignedbb.c);
        final int j2 = iy.b(axisalignedbb.f + 1.0);
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
    
    public void usePortal(final MinecraftServer mcs, final hk player, final int dimension) {
        player.I = 10;
        player.K = 0.0f;
        if (dimension == 0) {
            this.sendToSurface(mcs, player);
        }
        else if (dimension == 7) {
            this.sendToTwilightForest(mcs, player);
        }
        if (player.aq()) {}
    }
    
    public void sendToTwilightForest(final MinecraftServer mcs, final hk player) {
        mcs.h.a((ft)player, 7);
    }
    
    public void sendToSurface(final MinecraftServer mcs, final hk player) {
        mcs.h.a((ft)player, 0);
    }
    
    public void addTileEntityMapping(final Class classToMap, final String nameToMap) {
        Map nameToClassMap = null;
        Map classToNameMap = null;
        try {
            nameToClassMap = (Map)ModLoader.getPrivateValue((Class)ow.class, (Object)new ow(), 0);
            classToNameMap = (Map)ModLoader.getPrivateValue((Class)ow.class, (Object)new ow(), 1);
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
    
    public static void addToAxeEffectiveList(final ud toAdd) {
        ud[] effectiveList = null;
        int listIndexInClass = -1;
        try {
            for (int i = 0; i < ec.class.getDeclaredFields().length; ++i) {
                if (ModLoader.getPrivateValue((Class)ec.class, (Object)hg.g, i) instanceof ud[]) {
                    listIndexInClass = i;
                    break;
                }
            }
            if (listIndexInClass <= -1) {
                System.out.println("Could not locate the array of blocks the axe is effective against.  Thus, not changing it.");
                return;
            }
            effectiveList = (ud[])ModLoader.getPrivateValue((Class)ec.class, (Object)hg.g, listIndexInClass);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        final ud[] newEffectiveList = new ud[effectiveList.length + 1];
        System.arraycopy(effectiveList, 0, (Object)newEffectiveList, 0, effectiveList.length);
        newEffectiveList[effectiveList.length] = toAdd;
        try {
            for (int j = 0; j < hg.d.length; ++j) {
                if (hg.d[j] instanceof sl) {
                    ModLoader.setPrivateValue((Class)ec.class, (Object)hg.d[j], listIndexInClass, (Object)newEffectiveList);
                }
            }
        }
        catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        }
        catch (SecurityException e4) {
            e4.printStackTrace();
        }
        catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        }
    }
    
    public static void addToFireBurnRate(final int blockID, final int chanceToEncourageFire, final int abilityToCatchFire) {
        int[] chanceList = null;
        int[] abilityList = null;
        try {
            chanceList = (int[])ModLoader.getPrivateValue((Class)yw.class, (Object)ud.at, 0);
            abilityList = (int[])ModLoader.getPrivateValue((Class)yw.class, (Object)ud.at, 1);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        chanceList[blockID] = chanceToEncourageFire;
        abilityList[blockID] = abilityToCatchFire;
    }
    
    public static void addToFireBurnRate(final int blockID, final int blockIDCopyFrom) {
        try {
            for (int i = 0; i < yw.class.getDeclaredFields().length; ++i) {
                final Object field = ModLoader.getPrivateValue((Class)yw.class, (Object)ud.at, i);
                if (field instanceof int[] && ((int[])field).length == 256) {
                    final int[] fireList = (int[])field;
                    fireList[blockID] = fireList[blockIDCopyFrom];
                }
            }
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
    
    public String getVersion() {
        return "1.6r2";
    }
    
    public void load() {
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
        mod_TwilightForest.idMobWildBoar = 77;
        mod_TwilightForest.idMobBighornSheep = 78;
        mod_TwilightForest.idMobWildDeer = 79;
        mod_TwilightForest.idMobRedcap = 80;
        mod_TwilightForest.idMobSwarmSpider = 81;
        mod_TwilightForest.idMobNaga = 82;
        mod_TwilightForest.idMobNagaSegment = 83;
        mod_TwilightForest.idMobSkeletonDruid = 84;
        mod_TwilightForest.idMobHostileWolf = 85;
        mod_TwilightForest.idMobTwilightWraith = 86;
        mod_TwilightForest.idMobHedgeSpider = 87;
        mod_TwilightForest.idVehicleSpawnNatureBolt = 88;
        mod_TwilightForest.shouldOtherModsGenerateInTwlightForest = false;
    }
}
