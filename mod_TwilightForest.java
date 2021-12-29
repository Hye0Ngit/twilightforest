import net.minecraft.client.Minecraft;
import java.util.Random;
import java.util.Map;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class mod_TwilightForest extends BaseMod
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
    public static int fireflyRenderID;
    public static int cicadaRenderID;
    
    mod_TwilightForest() {
        ModLoader.SetInGameHook((BaseMod)this, true, true);
        ModLoader.SetInGUIHook((BaseMod)this, true, true);
        ModLoader.RegisterEntityID((Class)EntityTFBoar.class, "Wild Boar", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFBighorn.class, "Bighorn Sheep", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFDeer.class, "Wild Deer", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFRedcap.class, "Redcap", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFSwarmSpider.class, "Swarm Spider", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFNaga.class, "Naga", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFNagaSegment.class, "Naga Segment", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFSkeletonDruid.class, "Skeleton Druid", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFHostileWolf.class, "Hostile Wolf", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFWraith.class, "Twilight Wraith", ModLoader.getUniqueEntityId());
        ModLoader.RegisterEntityID((Class)EntityTFHedgeSpider.class, "Hedge Spider", ModLoader.getUniqueEntityId());
        new TFBlocks();
        new TFItems();
        ModLoader.AddRecipe(new dk(yy.x, 4), new Object[] { "w", 'w', TFBlocks.wood });
        ModLoader.AddRecipe(new dk(acy.ah, 1), new Object[] { "n n", "nnn", "nnn", 'n', TFItems.nagaScale });
        ModLoader.AddRecipe(new dk(acy.ai, 1), new Object[] { "nnn", "n n", "n n", 'n', TFItems.nagaScale });
        mod_TwilightForest.fireflyRenderID = ModLoader.getUniqueBlockModelID((BaseMod)this, false);
        mod_TwilightForest.cicadaRenderID = ModLoader.getUniqueBlockModelID((BaseMod)this, false);
        this.addTileEntityMapping(TileEntityTFFirefly.class, "Firefly");
        this.addTileEntityMapping(TileEntityTFCicada.class, "Cicada");
        this.addTileEntityMapping(TileEntityTFBossSpawner.class, "Boss Spawner");
        this.addTileEntityRendererMapping(TileEntityTFFirefly.class, new TileEntityTFFireflyRenderer());
        this.addTileEntityRendererMapping(TileEntityTFCicada.class, new TileEntityTFCicadaRenderer());
        this.addTileEntityRendererMapping(TileEntityTFBossSpawner.class, (du)new on());
    }
    
    public void AddRenderer(final Map map) {
        map.put(EntityTFBoar.class, new yf((al)new ModelTFBoar(), (al)new je(0.5f), 0.7f));
        map.put(EntityTFBighorn.class, new ahr((al)new ModelTFBighorn(), (al)new ModelTFBighornFur(), 0.7f));
        map.put(EntityTFDeer.class, new lj((al)new ModelTFDeer(), 0.7f));
        map.put(EntityTFRedcap.class, new tp((fa)new ModelTFRedcap(), 0.625f));
        map.put(EntityTFSwarmSpider.class, new RenderTFSwarmSpider());
        map.put(EntityTFNaga.class, new RenderTFNaga(new ModelTFNaga(), 0.625f));
        map.put(EntityTFNagaSegment.class, new RenderTFNaga(new ModelTFNaga(), 0.625f));
        map.put(EntityTFTinyFirefly.class, new RenderTFTinyFirefly());
        map.put(EntityTFSkeletonDruid.class, new tp((fa)new ModelTFSkeletonDruid(), 0.5f));
        map.put(EntityTFWraith.class, new RenderTFWraith((fa)new le(), 0.5f));
        map.put(EntityTFNatureBolt.class, new cd(acy.R.a(0)));
    }
    
    public void GenerateSurface(final ry world, final Random random, final int i, final int j) {
    }
    
    protected void makeSupplyChest(final ry world, final Random random, final int cx, final int cz) {
        final int spawnX = world.C.c();
        final int spawnZ = world.C.e();
        if (spawnX != 0 && spawnZ != 0 && spawnX >= cx && spawnX <= cx + 16 && spawnZ >= cz && spawnZ <= cz + 16) {
            System.out.println("Making supply chest at " + spawnX + ", " + spawnZ);
            final int dx = spawnX + random.nextInt(8) - random.nextInt(8);
            final int dz = spawnZ + random.nextInt(8) - random.nextInt(8);
            final int dy = world.f(dx, dz);
            world.g(dx, dy, dz, yy.au.bM);
            final tu tec = (tu)world.b(dx, dy, dz);
            if (tec != null && tec.c() > 0) {
                tec.a(0, new dk(acy.as));
                tec.a(1, new dk(acy.A));
                tec.a(2, new dk(acy.z));
                tec.a(3, new dk(acy.B));
                tec.a(4, new dk(acy.p));
                tec.a(5, new dk(yy.ap, 14));
                tec.a(6, new dk(acy.h));
                tec.a(7, new dk((yy)yy.ag, 64));
                tec.a(8, new dk((yy)yy.ae, 64));
                tec.a(9, new dk((yy)yy.ad, 64));
                tec.a(10, new dk((yy)yy.af, 64));
                tec.a(11, new dk(acy.m, 64));
                tec.a(12, new dk(acy.aw, 1));
            }
        }
    }
    
    public boolean OnTickInGame(final float f, final Minecraft mc) {
        if (!mc.f.I && mc.h != null && mc.h.ca > 0.8 && mc.h.bY == 0) {
            this.interceptPortal(mc);
        }
        if (mc.h != null && mc.h.bK == 7 && !(mc.f instanceof TFWorld)) {
            this.sendToTwilightForest(mc);
        }
        if (mc.h != null && mc.f.y instanceof WorldProviderTwilightForest && mc.h.bK != 7) {
            mc.h.bK = 7;
            System.err.println("Found the player in the wrong dimension.");
        }
        for (int j = 0; j < mc.f.g.size(); ++j) {
            final ia entity = mc.f.g.get(j);
            if (entity instanceof ih && entity.ab && ((ih)entity).a.c == acy.m.bM) {
                System.out.println("I found a diamond in the water!");
                ((BlockTFPortal)TFBlocks.portal).tryToCreatePortal(mc.f, (int)entity.s, (int)entity.t, (int)entity.u);
            }
        }
        return true;
    }
    
    public boolean OnTickInGUI(final float f, final Minecraft mc, final xe guiscreen) {
        if (mc.h != null && mc.h.bK == 7 && !(mc.f.y instanceof WorldProviderTwilightForest)) {
            this.sendToTwilightForest(mc);
        }
        return true;
    }
    
    public void interceptPortal(final Minecraft mc) {
        final boolean inTwilightPortal = this.isAABBInBlockID(mc.f, mc.h.C, TFBlocks.portal.bM);
        if (mc.h.bK == 7) {
            this.usePortal(mc, 0);
        }
        else if (mc.h.bK == 0 && inTwilightPortal) {
            this.usePortal(mc, 7);
        }
    }
    
    public boolean isAABBInBlockID(final ry world, final c axisalignedbb, final int blockID) {
        final int i = me.c(axisalignedbb.a);
        final int j = me.c(axisalignedbb.d + 1.0);
        final int k = me.c(axisalignedbb.b);
        final int l = me.c(axisalignedbb.e + 1.0);
        final int i2 = me.c(axisalignedbb.c);
        final int j2 = me.c(axisalignedbb.f + 1.0);
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
        mc.h.bY = 10;
        mc.h.ca = 0.0f;
        if (dimension == 0) {
            this.sendToSurface(mc);
        }
        else if (dimension == 7) {
            this.sendToTwilightForest(mc);
        }
        if (mc.h.K()) {
            mc.h.c(mc.h.s, mc.h.t, mc.h.u, mc.h.y, mc.h.z);
            mc.f.a((ia)mc.h, false);
            new TFTeleporter().a(mc.f, (ia)mc.h);
        }
    }
    
    public void sendToTwilightForest(final Minecraft mc) {
        mc.f.b((ia)mc.h);
        mc.h.K = false;
        double newY = mc.h.t;
        if (mc.h.bK == 0) {
            newY *= 0.5;
        }
        mc.h.c(mc.h.s, newY, mc.h.u, mc.h.y, mc.h.z);
        if (mc.h.K()) {
            mc.f.a((ia)mc.h, false);
        }
        ry world = null;
        world = new TFWorld(mc.f, new WorldProviderTwilightForest());
        mc.a(world, "Entering the Twilight Forest", (vi)mc.h);
        mc.h.o = mc.f;
        mc.h.bK = 7;
    }
    
    public void sendToSurface(final Minecraft mc) {
        mc.f.b((ia)mc.h);
        mc.h.K = false;
        double newY = mc.h.t;
        if (mc.h.bK == 0) {
            newY *= 2.0;
        }
        mc.h.c(mc.h.s, newY, mc.h.u, mc.h.y, mc.h.z);
        if (mc.h.K()) {
            mc.f.a((ia)mc.h, false);
        }
        ry world1 = null;
        world1 = new ry(mc.f, k.a(0));
        mc.a(world1, "Leaving the Twilight Forest", (vi)mc.h);
        mc.h.o = mc.f;
        mc.h.bK = 0;
    }
    
    public void addTileEntityMapping(final Class classToMap, final String nameToMap) {
        Map nameToClassMap = null;
        Map classToNameMap = null;
        try {
            nameToClassMap = (Map)ModLoader.getPrivateValue((Class)bq.class, (Object)new bq(), 0);
            classToNameMap = (Map)ModLoader.getPrivateValue((Class)bq.class, (Object)new bq(), 1);
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
    
    public void addTileEntityRendererMapping(final Class classToMap, final du rendererForMap) {
        Map specialRendererMap = null;
        try {
            specialRendererMap = (Map)ModLoader.getPrivateValue((Class)ah.class, (Object)ah.a, 0);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        specialRendererMap.put(classToMap, rendererForMap);
        rendererForMap.a(ah.a);
    }
    
    public static void addToAxeEffectiveList(final yy toAdd) {
        yy[] effectiveList = null;
        int listIndexInClass = -1;
        try {
            for (int i = 0; i < ads.class.getDeclaredFields().length; ++i) {
                if (ModLoader.getPrivateValue((Class)ads.class, (Object)acy.g, i) instanceof yy[]) {
                    listIndexInClass = i;
                    break;
                }
            }
            if (listIndexInClass <= -1) {
                System.out.println("Could not locate the array of blocks the axe is effective against.  Thus, not changing it.");
                return;
            }
            effectiveList = (yy[])ModLoader.getPrivateValue((Class)ads.class, (Object)acy.g, listIndexInClass);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        final yy[] newEffectiveList = new yy[effectiveList.length + 1];
        System.arraycopy(effectiveList, 0, (Object)newEffectiveList, 0, effectiveList.length);
        newEffectiveList[effectiveList.length] = toAdd;
        try {
            for (int j = 0; j < acy.d.length; ++j) {
                if (acy.d[j] instanceof ago) {
                    ModLoader.setPrivateValue((Class)ads.class, (Object)acy.d[j], listIndexInClass, (Object)newEffectiveList);
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
            chanceList = (int[])ModLoader.getPrivateValue((Class)wj.class, (Object)yy.ar, 0);
            abilityList = (int[])ModLoader.getPrivateValue((Class)wj.class, (Object)yy.ar, 1);
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
            for (int i = 0; i < wj.class.getDeclaredFields().length; ++i) {
                final Object field = ModLoader.getPrivateValue((Class)wj.class, (Object)yy.ar, i);
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
    
    public boolean RenderWorldBlock(final acr renderblocks, final kq blockAccess, final int x, final int y, final int z, final yy block, final int l) {
        if (l == mod_TwilightForest.fireflyRenderID) {
            return BlockTFFirefly.renderFirefly(renderblocks, blockAccess, x, y, z, block);
        }
        return l == mod_TwilightForest.cicadaRenderID && BlockTFCicada.renderCicada(renderblocks, blockAccess, x, y, z, block);
    }
    
    public String getVersion() {
        return "1.5r1";
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
    }
}
