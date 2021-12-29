// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import forge.MinecraftForge;
import forge.MinecraftForgeClient;

public class TFBlocks
{
    public static pb wood;
    public static pb leaves;
    public static pb critter;
    public static pb portal;
    public static pb mazestone;
    public static pb hedge;
    public static pb bossSpawner;
    public static pb complex;
    public static pb plant;
    
    public TFBlocks() {
        MinecraftForgeClient.preloadTexture("/twilightforest/terrain.png");
        TFBlocks.wood = new BlockTFLog(mod_TwilightForest.idBlockLog).a("TFLog");
        TFBlocks.leaves = new BlockTFLeaves(mod_TwilightForest.idBlockLeaves, 52).a("TFLeaves");
        TFBlocks.critter = new BlockTFCritter(mod_TwilightForest.idBlockCritter).a("TFFirefly");
        TFBlocks.portal = new BlockTFPortal(mod_TwilightForest.idBlockPortal, 14).a("TFPortal");
        TFBlocks.mazestone = new BlockTFMazestone(mod_TwilightForest.idBlockMazestone, 72).a("TFMazestone");
        TFBlocks.hedge = new BlockTFHedge(mod_TwilightForest.idBlockHedge).a("TFHedge");
        TFBlocks.bossSpawner = new BlockTFBossSpawner(mod_TwilightForest.idBlockBossSpawner).a("TFBossSpawner");
        TFBlocks.complex = new BlockTFComplex(mod_TwilightForest.idBlockFireflyJar).a("TFComplexBlock");
        TFBlocks.plant = new BlockTFPlant(mod_TwilightForest.idBlockPlant).a("TFPlant");
        ModLoader.registerBlock(TFBlocks.wood, (Class)ItemBlockTFLog.class);
        ModLoader.registerBlock(TFBlocks.leaves, (Class)ItemBlockTFLeaves.class);
        ModLoader.registerBlock(TFBlocks.critter, (Class)ItemBlockTFCritter.class);
        ModLoader.registerBlock(TFBlocks.portal);
        ModLoader.registerBlock(TFBlocks.mazestone);
        ModLoader.registerBlock(TFBlocks.hedge, (Class)ItemTFHedge.class);
        ModLoader.registerBlock(TFBlocks.bossSpawner);
        ModLoader.registerBlock(TFBlocks.complex, (Class)ItemBlockTFComplex.class);
        ModLoader.registerBlock(TFBlocks.plant, (Class)ItemBlockTFPlant.class);
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 0), "Twilight Oak Wood");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 1), "Canopy Tree Wood");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 2), "Mangrove Wood");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 3), "Darkwood Wood");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 6), "Roots");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 7), "Rotten Wood");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 8), "Twilight Oak Log");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 9), "Canopy Tree Log");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 10), "Mangrove Log");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 11), "Darkwood Log");
        ModLoader.addName((Object)new aan(TFBlocks.wood, 1, 14), "Liveroots");
        ModLoader.addName((Object)new aan(TFBlocks.leaves, 1, 0), "Twilight Oak Leaves");
        ModLoader.addName((Object)new aan(TFBlocks.leaves, 1, 1), "Canopy Tree Leaves");
        ModLoader.addName((Object)new aan(TFBlocks.leaves, 1, 2), "Mangrove Leaves");
        ModLoader.addName((Object)new aan(TFBlocks.critter, 1, 0), "Firefly");
        ModLoader.addName((Object)new aan(TFBlocks.critter, 1, 1), "Cicada");
        ModLoader.addName((Object)TFBlocks.portal, "Twilight Forest Portal");
        ModLoader.addName((Object)TFBlocks.mazestone, "Mazestone");
        ModLoader.addName((Object)new aan(TFBlocks.hedge, 1, 0), "Hedge");
        ModLoader.addName((Object)new aan(TFBlocks.hedge, 1, 1), "Darkwood Leaves");
        ModLoader.addName((Object)TFBlocks.bossSpawner, "Boss Spawner");
        ModLoader.addName((Object)new aan(TFBlocks.complex, 1, 0), "Firefly Jar");
        ModLoader.addName((Object)new aan(TFBlocks.complex, 1, 1), "Goblin Tinkering Table");
        ModLoader.addName((Object)new aan(TFBlocks.plant, 1, 0), "Sapling");
        ModLoader.addName((Object)new aan(TFBlocks.plant, 1, 8), "Fiddlehead");
        ModLoader.addName((Object)new aan(TFBlocks.plant, 1, 9), "Mushgloom");
        ModLoader.addName((Object)new aan(TFBlocks.plant, 1, 13), "Torchberry Plant");
        ModLoader.addName((Object)new aan(TFBlocks.plant, 1, 14), "Root Strands");
        ModLoader.addName((Object)new aan(TFBlocks.plant, 1, 15), "Rotten Chunk");
        MinecraftForge.setBlockHarvestLevel(TFBlocks.wood, "axe", 0);
        pb.setBurnProperties(TFBlocks.wood.bO, 5, 5);
        pb.setBurnProperties(TFBlocks.leaves.bO, 30, 60);
    }
}
