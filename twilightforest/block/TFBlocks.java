// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.item.ItemBlockTFMeta;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.oredict.OreDictionary;
import twilightforest.item.ItemBlockTFPlant;
import twilightforest.item.ItemBlockTFLeaves;
import twilightforest.item.ItemBlockTFLog;
import net.minecraftforge.common.MinecraftForge;
import twilightforest.TwilightForestMod;

public class TFBlocks
{
    public static amq log;
    public static amq leaves;
    public static amq firefly;
    public static amq portal;
    public static amq mazestone;
    public static amq hedge;
    public static amq bossSpawner;
    public static amq fireflyJar;
    public static amq plant;
    public static amq cicada;
    public static amq root;
    public static amq uncraftingTable;
    public static amq fireJet;
    public static amq nagastone;
    public static amq sapling;
    public static amq magicLog;
    public static amq magicLogSpecial;
    public static amq magicLeaves;
    public static amq moonworm;
    public static amq towerWood;
    public static amq towerDevice;
    public static amq towerAntenna;
    
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
        TFBlocks.towerDevice = new BlockTFTowerDevice(TwilightForestMod.idBlockTowerDevice).b("TFTowerDevice");
        TFBlocks.towerAntenna = new BlockTFTowerWood(TwilightForestMod.idBlockTowerAntenna).b("TFTowerAntenna");
        MinecraftForge.setBlockHarvestLevel(TFBlocks.magicLog, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.magicLogSpecial, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.log, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.root, "axe", 0);
        amq.setBurnProperties(TFBlocks.log.cm, 5, 5);
        amq.setBurnProperties(TFBlocks.leaves.cm, 30, 60);
        this.registerBlocks();
    }
    
    public void registerBlocks() {
        this.registerMyBlock(TFBlocks.log, ItemBlockTFLog.class);
        this.registerMyBlock(TFBlocks.root);
        this.registerMyBlock(TFBlocks.leaves, ItemBlockTFLeaves.class);
        this.registerMyBlock(TFBlocks.firefly);
        this.registerMyBlock(TFBlocks.cicada);
        this.registerMyBlock(TFBlocks.portal);
        this.registerMyBlock(TFBlocks.mazestone);
        this.registerMyBlock(TFBlocks.hedge);
        this.registerMyBlock(TFBlocks.bossSpawner);
        this.registerMyBlock(TFBlocks.fireflyJar);
        this.registerMyBlock(TFBlocks.plant, ItemBlockTFPlant.class);
        this.registerMyBlock(TFBlocks.uncraftingTable);
        this.registerMyBlock(TFBlocks.fireJet);
        this.registerMyBlock(TFBlocks.nagastone);
        this.registerMyBlock(TFBlocks.sapling);
        this.registerMyBlock(TFBlocks.moonworm);
        this.registerMyBlock(TFBlocks.magicLog);
        this.registerMyBlock(TFBlocks.magicLeaves);
        this.registerMyBlock(TFBlocks.magicLogSpecial);
        this.registerMyBlock(TFBlocks.towerWood);
        this.registerMyBlock(TFBlocks.towerDevice);
        OreDictionary.registerOre("woodLog", new ur(TFBlocks.log, 1, -1));
        OreDictionary.registerOre("woodLog", new ur(TFBlocks.magicLog, 1, -1));
        OreDictionary.registerOre("treeSapling", new ur(TFBlocks.sapling, 1, -1));
        OreDictionary.registerOre("treeLeaves", new ur(TFBlocks.leaves, 1, -1));
        OreDictionary.registerOre("treeLeaves", new ur(TFBlocks.magicLeaves, 1, -1));
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.log, 1, 0), "en_US", "Twilight Oak Wood");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.log, 1, 1), "en_US", "Canopy Tree Wood");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.log, 1, 2), "en_US", "Mangrove Wood");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.log, 1, 3), "en_US", "Darkwood Wood");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.root, 1, 0), "en_US", "Roots");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.root, 1, 1), "en_US", "Liveroots");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.log, 1, 8), "en_US", "Twilight Oak Log");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.log, 1, 9), "en_US", "Canopy Tree Log");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.log, 1, 10), "en_US", "Mangrove Log");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.log, 1, 11), "en_US", "Darkwood Log");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.log, 1, 14), "en_US", "Liveroots");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.leaves, 1, 0), "en_US", "Twilight Oak Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.leaves, 1, 1), "en_US", "Canopy Tree Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.leaves, 1, 2), "en_US", "Mangrove Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.leaves, 1, 3), "en_US", "Rainbow Oak Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.firefly, 1, 0), "en_US", "Firefly");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.cicada, 1, 0), "en_US", "Cicada");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.portal, 1, 0), "en_US", "Twilight Forest Portal");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.mazestone, 1, 0), "en_US", "Mazestone");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.mazestone, 1, 1), "en_US", "Mazestone Brick");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.mazestone, 1, 2), "en_US", "Chiseled Mazestone");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.mazestone, 1, 3), "en_US", "Decorative Mazestone Brick");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.mazestone, 1, 4), "en_US", "Cracked Mazestone Brick");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.mazestone, 1, 5), "en_US", "Mossy? Mazestone Brick [NYI]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.mazestone, 1, 6), "en_US", "Mazestone Mosiac");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.mazestone, 1, 7), "en_US", "Mazestone Border");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.mazestone, 1, 8), "en_US", "Mazestone Ceiling");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.hedge, 1, 0), "en_US", "Hedge");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.hedge, 1, 1), "en_US", "Darkwood Leaves");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.hedge, 1, 2), "en_US", "Hedge");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.bossSpawner, 1, 0), "en_US", "Boss Spawner");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.fireflyJar, 1, 0), "en_US", "Firefly Jar");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.uncraftingTable, 1, 0), "en_US", "Uncrafting Table");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.fireJet, 1, 0), "en_US", "Smoking block");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.fireJet, 1, 8), "en_US", "Fire Jet");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.fireJet, 1, 9), "en_US", "Fire Jet - popping");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.fireJet, 1, 10), "en_US", "Fire Jet - flame");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.plant, 1, 0), "en_US", "Sapling [NYI]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.plant, 1, 8), "en_US", "Fiddlehead");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.plant, 1, 9), "en_US", "Mushgloom");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.plant, 1, 13), "en_US", "Torchberry Plant");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.plant, 1, 14), "en_US", "Root Strands");
        for (int i = 0; i < 4; ++i) {
            LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.nagastone, 1, i), "en_US", "Nagastone Head");
        }
        for (int i = 4; i < 16; ++i) {
            LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.nagastone, 1, i), "en_US", "Nagastone");
        }
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.sapling, 1, 0), "en_US", "Sickly Twilight Oak Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.sapling, 1, 1), "en_US", "Canopy Tree Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.sapling, 1, 2), "en_US", "Twilight Mangrove Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.sapling, 1, 3), "en_US", "Darkwood Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.sapling, 1, 4), "en_US", "Robust Twilight Oak Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.sapling, 1, 5), "en_US", "Tree of Time Sapling [WIP]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.sapling, 1, 9), "en_US", "Rainbow Oak Sapling");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.moonworm, 1, 0), "en_US", "Moonworm");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.magicLog, 1, 0), "en_US", "Timewood [WIP]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.magicLogSpecial, 1, 0), "en_US", "Timewood Clock [NYI]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.magicLeaves, 1, 0), "en_US", "Timewood Leaves [WIP]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.towerWood, 1, 0), "en_US", "Towerwood Planks");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.towerWood, 1, 1), "en_US", "Encased Towerwood");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.towerDevice, 1, 0), "en_US", "Source [WIP]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.towerDevice, 1, 1), "en_US", "Active Source [WIP]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.towerDevice, 1, 2), "en_US", "Vanishing Block [WIP]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.towerDevice, 1, 3), "en_US", "Active Vanishing Block [WIP]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.towerDevice, 1, 4), "en_US", "Locked Vanishing Block [WIP]");
        LanguageRegistry.instance().addNameForObject((Object)new ur(TFBlocks.towerDevice, 1, 5), "en_US", "Unlocked Vanishing Block [WIP]");
    }
    
    private void registerMyBlock(final amq block, final Class pickup) {
        GameRegistry.registerBlock(block, pickup, block.a(), "TwilightForest");
    }
    
    private void registerMyBlock(final amq block) {
        GameRegistry.registerBlock(block, (Class)ItemBlockTFMeta.class, block.a(), "TwilightForest");
    }
}
