import forge.MinecraftForge;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBlocks
{
    public static vz wood;
    public static vz leaves;
    public static vz firefly;
    public static vz cicada;
    public static vz portal;
    public static vz mazestone;
    public static vz hedge;
    public static vz bossSpawner;
    public static vz fireflyJar;
    
    public TFBlocks() {
        TFBlocks.wood = new BlockTFLog(mod_TwilightForest.idBlockLog).c(2.0f).a(vz.e).a("TFLog");
        TFBlocks.leaves = new BlockTFLeaves(mod_TwilightForest.idBlockLeaves, 52).c(0.2f).f(1).a(vz.g).a("TFLeaves").j();
        TFBlocks.firefly = new BlockTFFirefly(mod_TwilightForest.idBlockFirefly).c(0.0f).a(0.9375f).a("TFFirefly");
        TFBlocks.cicada = new BlockTFCicada(mod_TwilightForest.idBlockCicada).c(0.0f).a("TFCicada");
        TFBlocks.portal = new BlockTFPortal(mod_TwilightForest.idBlockPortal, 14).c(-1.0f).a(vz.j).a(0.75f).a("TFPortal");
        TFBlocks.mazestone = new BlockTFMazestone(mod_TwilightForest.idBlockMazestone, 72).c(20.0f).b(5.0f).a(vz.h).a("TFMazestone");
        TFBlocks.hedge = new BlockTFHedge(mod_TwilightForest.idBlockHedge).c(2.0f).b(10.0f).a(vz.g).a("TFHedge");
        TFBlocks.bossSpawner = new BlockTFBossSpawner(mod_TwilightForest.idBlockBossSpawner).c(20.0f).b(10.0f).a("TFBossSpawner");
        TFBlocks.fireflyJar = new BlockTFFireflyJar(mod_TwilightForest.idBlockFireflyJar).c(0.3f).a(vz.j).a(0.625f).a("TFFireflyJar");
        ModLoader.registerBlock(TFBlocks.wood, (Class)ItemTFLog.class);
        ModLoader.registerBlock(TFBlocks.leaves, (Class)wf.class);
        ModLoader.registerBlock(TFBlocks.firefly);
        ModLoader.registerBlock(TFBlocks.cicada);
        ModLoader.registerBlock(TFBlocks.portal);
        ModLoader.registerBlock(TFBlocks.mazestone);
        ModLoader.registerBlock(TFBlocks.hedge);
        ModLoader.registerBlock(TFBlocks.bossSpawner);
        ModLoader.registerBlock(TFBlocks.fireflyJar);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.wood, "axe", 0);
        vz.blockFireSpreadSpeed[TFBlocks.wood.bO] = vz.blockFireSpreadSpeed[vz.J.bO];
        vz.blockFlammability[TFBlocks.wood.bO] = vz.blockFlammability[vz.J.bO];
        vz.blockFireSpreadSpeed[TFBlocks.leaves.bO] = vz.blockFireSpreadSpeed[vz.K.bO];
        vz.blockFlammability[TFBlocks.leaves.bO] = vz.blockFlammability[vz.K.bO];
    }
}
