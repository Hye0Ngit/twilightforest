// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

public class TFBlocks
{
    public static amj log;
    public static amj leaves;
    public static amj firefly;
    public static amj portal;
    public static amj mazestone;
    public static amj hedge;
    public static amj bossSpawner;
    public static amj fireflyJar;
    public static amj plant;
    public static amj cicada;
    public static amj root;
    public static amj uncraftingTable;
    public static amj fireJet;
    public static amj nagastone;
    public static amj sapling;
    public static amj magicLog;
    public static amj magicLogSpecial;
    public static amj magicLeaves;
    public static amj moonworm;
    public static amj towerWood;
    
    public TFBlocks() {
        TFBlocks.log = new BlockTFLog(TwilightForestMod.idBlockLog).b("TFLog");
        TFBlocks.leaves = new BlockTFLeaves(TwilightForestMod.idBlockLeaves, 52).b("TFLeaves");
        TFBlocks.firefly = new BlockTFFirefly(TwilightForestMod.idBlockFirefly).b("TFFirefly");
        TFBlocks.cicada = new BlockTFCicada(TwilightForestMod.idBlockCicada).b("TFCicada");
        TFBlocks.portal = new BlockTFPortal(TwilightForestMod.idBlockPortal, 14).b("TFPortal");
        TFBlocks.mazestone = new BlockTFMazestone(TwilightForestMod.idBlockMazestone, 72).b("TFMazestone");
        TFBlocks.hedge = new BlockTFHedge(TwilightForestMod.idBlockHedge).b("TFHedge");
        TFBlocks.bossSpawner = new BlockTFBossSpawner(TwilightForestMod.idBlockBossSpawner).b("TFBossSpawner");
        TFBlocks.fireflyJar = new BlockTFFireflyJar(TwilightForestMod.idBlockFireflyJar).b("TFFireflyJar");
        TFBlocks.plant = new BlockTFPlant(TwilightForestMod.idBlockPlant).b("TFPlant");
        TFBlocks.root = new BlockTFRoots(TwilightForestMod.idBlockRoots).b("TFRoots");
        TFBlocks.uncraftingTable = new BlockTFUncraftingTable(TwilightForestMod.idBlockUncraftingTable).b("TFUncraftingTable");
        TFBlocks.fireJet = new BlockTFFireJet(TwilightForestMod.idBlockFireJet).b("TFFireJet");
        TFBlocks.nagastone = new BlockTFNagastone(TwilightForestMod.idBlockNagastone).b("TFNagastone");
        TFBlocks.sapling = new BlockTFSapling(TwilightForestMod.idBlockSapling).b("TFSapling");
        TFBlocks.magicLog = new BlockTFMagicLog(TwilightForestMod.idBlockMagicLog).b("TFMagicLog");
        TFBlocks.magicLogSpecial = new BlockTFMagicLogSpecial(TwilightForestMod.idBlockMagicLogSpecial).b("TFMagicLogSpecial");
        TFBlocks.magicLeaves = new BlockTFMagicLeaves(TwilightForestMod.idBlockMagicLeaves).b("TFMagicLeaves");
        TFBlocks.moonworm = new BlockTFMoonworm(TwilightForestMod.idBlockMoonworm).b("TFMoonworm");
        TFBlocks.towerWood = new BlockTFTowerWood(TwilightForestMod.idBlockTowerWood).b("TFTowerStone");
        MinecraftForge.setBlockHarvestLevel(TFBlocks.log, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.root, "axe", 0);
        amj.setBurnProperties(TFBlocks.log.cm, 5, 5);
        amj.setBurnProperties(TFBlocks.leaves.cm, 30, 60);
        this.registerBlocks();
    }
    
    public void registerBlocks() {
        GameRegistry.registerBlock(TFBlocks.log, (Class)ItemBlockTFLog.class);
        GameRegistry.registerBlock(TFBlocks.root, (Class)ItemBlockTFMeta.class);
        GameRegistry.registerBlock(TFBlocks.leaves, (Class)ItemBlockTFLeaves.class);
        GameRegistry.registerBlock(TFBlocks.firefly, (Class)ItemBlockTFMeta.class);
        GameRegistry.registerBlock(TFBlocks.cicada, (Class)ItemBlockTFMeta.class);
        GameRegistry.registerBlock(TFBlocks.portal);
        GameRegistry.registerBlock(TFBlocks.mazestone, (Class)ItemBlockTFMeta.class);
        GameRegistry.registerBlock(TFBlocks.hedge, (Class)ItemBlockTFMeta.class);
        GameRegistry.registerBlock(TFBlocks.bossSpawner);
        GameRegistry.registerBlock(TFBlocks.fireflyJar);
        GameRegistry.registerBlock(TFBlocks.plant, (Class)ItemBlockTFPlant.class);
        GameRegistry.registerBlock(TFBlocks.uncraftingTable);
        GameRegistry.registerBlock(TFBlocks.fireJet, (Class)ItemBlockTFMeta.class);
        GameRegistry.registerBlock(TFBlocks.nagastone, (Class)ItemBlockTFMeta.class);
        GameRegistry.registerBlock(TFBlocks.sapling, (Class)ItemBlockTFMeta.class);
        GameRegistry.registerBlock(TFBlocks.moonworm, (Class)ItemBlockTFMeta.class);
        OreDictionary.registerOre("woodLog", new um(TFBlocks.log, 1, 0));
        OreDictionary.registerOre("woodLog", new um(TFBlocks.log, 1, 1));
        OreDictionary.registerOre("woodLog", new um(TFBlocks.log, 1, 2));
        OreDictionary.registerOre("woodLog", new um(TFBlocks.log, 1, 3));
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.log, 1, 0), "en_US", "Twilight Oak Wood");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.log, 1, 1), "en_US", "Canopy Tree Wood");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.log, 1, 2), "en_US", "Mangrove Wood");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.log, 1, 3), "en_US", "Darkwood Wood");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.root, 1, 0), "en_US", "Roots");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.root, 1, 1), "en_US", "Liveroots");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.log, 1, 8), "en_US", "Twilight Oak Log");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.log, 1, 9), "en_US", "Canopy Tree Log");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.log, 1, 10), "en_US", "Mangrove Log");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.log, 1, 11), "en_US", "Darkwood Log");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.log, 1, 14), "en_US", "Liveroots");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.leaves, 1, 0), "en_US", "Twilight Oak Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.leaves, 1, 1), "en_US", "Canopy Tree Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.leaves, 1, 2), "en_US", "Mangrove Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.leaves, 1, 3), "en_US", "Rainbow Oak Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.firefly, 1, 0), "en_US", "Firefly");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.cicada, 1, 0), "en_US", "Cicada");
        LanguageRegistry.instance().addNameForObject((Object)TFBlocks.portal, "en_US", "Twilight Forest Portal");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.mazestone, 1, 0), "en_US", "Mazestone");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.mazestone, 1, 1), "en_US", "Mazestone Brick");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.mazestone, 1, 2), "en_US", "Chiseled Mazestone");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.mazestone, 1, 3), "en_US", "Decorative Mazestone Brick");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.mazestone, 1, 4), "en_US", "Cracked Mazestone Brick");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.mazestone, 1, 5), "en_US", "Mossy? Mazestone Brick [NYI]");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.mazestone, 1, 6), "en_US", "Mazestone Mosiac");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.mazestone, 1, 7), "en_US", "Mazestone Border");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.mazestone, 1, 8), "en_US", "Mazestone Ceiling");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.hedge, 1, 0), "en_US", "Hedge");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.hedge, 1, 1), "en_US", "Darkwood Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.hedge, 1, 2), "en_US", "Hedge");
        LanguageRegistry.instance().addNameForObject((Object)TFBlocks.bossSpawner, "en_US", "Boss Spawner");
        LanguageRegistry.instance().addNameForObject((Object)TFBlocks.fireflyJar, "en_US", "Firefly Jar");
        LanguageRegistry.instance().addNameForObject((Object)TFBlocks.uncraftingTable, "en_US", "Uncrafting Table");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.fireJet, 1, 0), "en_US", "Smoking block");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.fireJet, 1, 8), "en_US", "Fire Jet");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.fireJet, 1, 9), "en_US", "Fire Jet - popping");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.fireJet, 1, 10), "en_US", "Fire Jet - flame");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.plant, 1, 0), "en_US", "Sapling [NYI]");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.plant, 1, 8), "en_US", "Fiddlehead");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.plant, 1, 9), "en_US", "Mushgloom");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.plant, 1, 13), "en_US", "Torchberry Plant");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.plant, 1, 14), "en_US", "Root Strands");
        for (int i = 0; i < 4; ++i) {
            LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.nagastone, 1, i), "en_US", "Nagastone Head");
        }
        for (int i = 4; i < 16; ++i) {
            LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.nagastone, 1, i), "en_US", "Nagastone");
        }
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.sapling, 1, 0), "en_US", "Sickly Twilight Oak Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.sapling, 1, 1), "en_US", "Canopy Tree Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.sapling, 1, 2), "en_US", "Twilight Mangrove Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.sapling, 1, 3), "en_US", "Darkwood Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.sapling, 1, 4), "en_US", "Robust Twilight Oak Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.sapling, 1, 5), "en_US", "Tree of Time Sapling [NYI]");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.sapling, 1, 9), "en_US", "Rainbow Oak Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new um(TFBlocks.moonworm, 1, 0), "en_US", "Moonworm");
    }
}
