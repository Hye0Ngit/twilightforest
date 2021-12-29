import forge.MinecraftForge;
import forge.MinecraftForgeClient;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBlocks
{
    public static ox wood;
    public static ox leaves;
    public static ox firefly;
    public static ox cicada;
    public static ox portal;
    public static ox mazestone;
    public static ox hedge;
    public static ox bossSpawner;
    
    public TFBlocks() {
        MinecraftForgeClient.preloadTexture("/twilightforest/terrain.png");
        TFBlocks.wood = new BlockTFLog(mod_TwilightForest.idBlockLog).c(2.0f).a(ox.e).a("TFLog");
        TFBlocks.leaves = new BlockTFLeaves(mod_TwilightForest.idBlockLeaves, 52).c(0.2f).f(1).a(ox.g).a("TFLeaves").k();
        TFBlocks.firefly = new BlockTFFirefly(mod_TwilightForest.idBlockFirefly).c(0.0f).a(0.9375f).a("TFFirefly");
        TFBlocks.cicada = new BlockTFCicada(mod_TwilightForest.idBlockCicada).c(0.0f).a("TFCicada");
        TFBlocks.portal = new BlockTFPortal(mod_TwilightForest.idBlockPortal, 14).c(-1.0f).a(ox.j).a(0.75f).a("TFPortal");
        TFBlocks.mazestone = new BlockTFMazestone(mod_TwilightForest.idBlockMazestone, 72).c(20.0f).b(5.0f).a(ox.h).a("TFMazestone");
        TFBlocks.hedge = new BlockTFHedge(mod_TwilightForest.idBlockHedge).c(2.0f).b(10.0f).a(ox.g).a("TFHedge");
        TFBlocks.bossSpawner = new BlockTFBossSpawner(mod_TwilightForest.idBlockBossSpawner).c(20.0f).b(10.0f).a("TFBossSpawner");
        ModLoader.registerBlock(TFBlocks.wood, (Class)ItemTFLog.class);
        ModLoader.registerBlock(TFBlocks.leaves, (Class)pd.class);
        ModLoader.registerBlock(TFBlocks.firefly);
        ModLoader.registerBlock(TFBlocks.cicada);
        ModLoader.registerBlock(TFBlocks.portal);
        ModLoader.registerBlock(TFBlocks.mazestone);
        ModLoader.registerBlock(TFBlocks.hedge);
        ModLoader.registerBlock(TFBlocks.bossSpawner);
        ModLoader.addName((Object)new aai(TFBlocks.wood, 1, 0), "Twilight Oak Log");
        ModLoader.addName((Object)new aai(TFBlocks.wood, 1, 1), "Canopy Tree Log");
        ModLoader.addName((Object)new aai(TFBlocks.wood, 1, 2), "Mangrove Log");
        ModLoader.addName((Object)new aai(TFBlocks.leaves, 1, 0), "Twilight Oak Leaves");
        ModLoader.addName((Object)new aai(TFBlocks.leaves, 1, 1), "Canopy Tree Leaves");
        ModLoader.addName((Object)new aai(TFBlocks.leaves, 1, 2), "Mangrove Leaves");
        ModLoader.addName((Object)TFBlocks.firefly, "Firefly");
        ModLoader.addName((Object)TFBlocks.cicada, "Cicada");
        ModLoader.addName((Object)TFBlocks.portal, "Twilight Forest Portal");
        ModLoader.addName((Object)TFBlocks.mazestone, "Mazestone");
        ModLoader.addName((Object)TFBlocks.hedge, "Hedge");
        ModLoader.addName((Object)TFBlocks.bossSpawner, "Boss Spawner");
        MinecraftForge.setBlockHarvestLevel(TFBlocks.wood, "axe", 0);
        ox.blockFireSpreadSpeed[TFBlocks.wood.bO] = ox.blockFireSpreadSpeed[ox.J.bO];
        ox.blockFlammability[TFBlocks.wood.bO] = ox.blockFlammability[ox.J.bO];
        ox.blockFireSpreadSpeed[TFBlocks.leaves.bO] = ox.blockFireSpreadSpeed[ox.K.bO];
        ox.blockFlammability[TFBlocks.leaves.bO] = ox.blockFlammability[ox.K.bO];
    }
}
