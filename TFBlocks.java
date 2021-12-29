// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBlocks
{
    public static ud wood;
    public static ud leaves;
    public static ud firefly;
    public static ud cicada;
    public static ud portal;
    public static ud mazestone;
    public static ud hedge;
    public static ud bossSpawner;
    
    public TFBlocks() {
        TFBlocks.wood = new BlockTFLog(mod_TwilightForest.idBlockLog).c(2.0f).a(ud.e).a("TFLog");
        TFBlocks.leaves = new BlockTFLeaves(mod_TwilightForest.idBlockLeaves, 52).c(0.2f).g(1).a(ud.g).a("TFLeaves").i();
        TFBlocks.firefly = new BlockTFFirefly(mod_TwilightForest.idBlockFirefly).c(0.0f).a(0.9375f).a("TFFirefly");
        TFBlocks.cicada = new BlockTFCicada(mod_TwilightForest.idBlockCicada).c(0.0f).a("TFCicada");
        TFBlocks.portal = new BlockTFPortal(mod_TwilightForest.idBlockPortal, 14).c(-1.0f).a(ud.j).a(0.75f).a("TFPortal");
        TFBlocks.mazestone = new BlockTFMazestone(mod_TwilightForest.idBlockMazestone, 72).c(20.0f).b(5.0f).a(ud.h).a("TFMazestone");
        TFBlocks.hedge = new BlockTFHedge(mod_TwilightForest.idBlockHedge).c(2.0f).b(10.0f).a(ud.g).a("TFHedge");
        TFBlocks.bossSpawner = new BlockTFBossSpawner(mod_TwilightForest.idBlockBossSpawner).c(20.0f).b(10.0f).a("TFBossSpawner");
        ModLoader.RegisterBlock(TFBlocks.wood, (Class)ItemTFLog.class);
        ModLoader.RegisterBlock(TFBlocks.leaves, (Class)ui.class);
        ModLoader.RegisterBlock(TFBlocks.firefly);
        ModLoader.RegisterBlock(TFBlocks.cicada);
        ModLoader.RegisterBlock(TFBlocks.portal);
        ModLoader.RegisterBlock(TFBlocks.mazestone);
        ModLoader.RegisterBlock(TFBlocks.hedge);
        ModLoader.RegisterBlock(TFBlocks.bossSpawner);
        mod_TwilightForest.addToAxeEffectiveList(TFBlocks.wood);
        mod_TwilightForest.addToFireBurnRate(TFBlocks.wood.bO, ud.L.bO);
        mod_TwilightForest.addToFireBurnRate(TFBlocks.leaves.bO, ud.M.bO);
    }
}
