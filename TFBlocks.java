// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBlocks
{
    public static yy wood;
    public static yy leaves;
    public static yy firefly;
    public static yy cicada;
    public static yy portal;
    public static yy mazestone;
    public static yy hedge;
    public static yy bossSpawner;
    
    public TFBlocks() {
        TFBlocks.wood = new BlockTFLog(mod_TwilightForest.idBlockLog).c(2.0f).a(yy.c).a("TFLog");
        TFBlocks.leaves = new BlockTFLeaves(mod_TwilightForest.idBlockLeaves, 52).c(0.2f).h(1).a(yy.e).a("TFLeaves").l();
        TFBlocks.firefly = new BlockTFFirefly(mod_TwilightForest.idBlockFirefly).c(0.0f).a(0.9375f).a("TFFirefly");
        TFBlocks.cicada = new BlockTFCicada(mod_TwilightForest.idBlockCicada).c(0.0f).a("TFCicada");
        TFBlocks.portal = new BlockTFPortal(mod_TwilightForest.idBlockPortal, 14).c(0.0f).a("TFPortal");
        TFBlocks.mazestone = new BlockTFMazestone(mod_TwilightForest.idBlockMazestone, 72).c(20.0f).b(5.0f).a(yy.f).a("TFMazestone");
        TFBlocks.hedge = new BlockTFHedge(mod_TwilightForest.idBlockHedge).c(2.0f).b(10.0f).a(yy.e).a("TFHedge");
        TFBlocks.bossSpawner = new BlockTFBossSpawner(mod_TwilightForest.idBlockBossSpawner).c(20.0f).b(10.0f).a("TFBossSpawner");
        ModLoader.RegisterBlock(TFBlocks.wood, (Class)ItemTFLog.class);
        ModLoader.RegisterBlock(TFBlocks.leaves, (Class)og.class);
        ModLoader.RegisterBlock(TFBlocks.firefly);
        ModLoader.RegisterBlock(TFBlocks.cicada);
        ModLoader.RegisterBlock(TFBlocks.portal);
        ModLoader.RegisterBlock(TFBlocks.mazestone);
        ModLoader.RegisterBlock(TFBlocks.hedge);
        ModLoader.RegisterBlock(TFBlocks.bossSpawner);
        ModLoader.AddName((Object)new dk(TFBlocks.wood, 1, 0), "Twilight Oak Log");
        ModLoader.AddName((Object)new dk(TFBlocks.wood, 1, 1), "Canopy Tree Log");
        ModLoader.AddName((Object)new dk(TFBlocks.wood, 1, 2), "Mangrove Log");
        ModLoader.AddName((Object)new dk(TFBlocks.leaves, 1, 0), "Twilight Oak Leaves");
        ModLoader.AddName((Object)new dk(TFBlocks.leaves, 1, 1), "Canopy Tree Leaves");
        ModLoader.AddName((Object)new dk(TFBlocks.leaves, 1, 2), "Mangrove Leaves");
        ModLoader.AddName((Object)TFBlocks.firefly, "Firefly");
        ModLoader.AddName((Object)TFBlocks.cicada, "Cicada");
        ModLoader.AddName((Object)TFBlocks.portal, "Twilight Forest Portal");
        ModLoader.AddName((Object)TFBlocks.mazestone, "Mazestone");
        ModLoader.AddName((Object)TFBlocks.hedge, "Hedge");
        ModLoader.AddName((Object)TFBlocks.bossSpawner, "Boss Spawner");
        mod_TwilightForest.addToAxeEffectiveList(TFBlocks.wood);
        mod_TwilightForest.addToFireBurnRate(TFBlocks.wood.bM, yy.J.bM);
        mod_TwilightForest.addToFireBurnRate(TFBlocks.leaves.bM, yy.K.bM);
    }
}
