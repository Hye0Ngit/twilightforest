// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.item.ItemBlockTFMeta;
import cpw.mods.fml.common.registry.GameRegistry;
import twilightforest.item.ItemBlockTFPlant;
import net.minecraftforge.common.MinecraftForge;
import twilightforest.TwilightForestMod;

public class TFBlocks
{
    public static aou log;
    public static aou leaves;
    public static aou firefly;
    public static aou portal;
    public static aou mazestone;
    public static aou hedge;
    public static aou bossSpawner;
    public static aou fireflyJar;
    public static aou plant;
    public static aou cicada;
    public static aou root;
    public static aou uncraftingTable;
    public static aou fireJet;
    public static aou nagastone;
    public static aou sapling;
    public static aou magicLog;
    public static aou magicLogSpecial;
    public static aou magicLeaves;
    public static aou moonworm;
    public static aou towerWood;
    public static aou towerDevice;
    public static aou towerTranslucent;
    public static aou trophy;
    
    public TFBlocks() {
        TFBlocks.log = new BlockTFLog(TwilightForestMod.idBlockLog).c("TFLog");
        TFBlocks.leaves = new BlockTFLeaves(TwilightForestMod.idBlockLeaves).c("TFLeaves");
        TFBlocks.firefly = new BlockTFFirefly(TwilightForestMod.idBlockFirefly).c("TFFirefly");
        TFBlocks.cicada = new BlockTFCicada(TwilightForestMod.idBlockCicada).c("TFCicada");
        TFBlocks.portal = new BlockTFPortal(TwilightForestMod.idBlockPortal).c("TFPortal");
        TFBlocks.mazestone = new BlockTFMazestone(TwilightForestMod.idBlockMazestone).c("TFMazestone");
        TFBlocks.hedge = new BlockTFHedge(TwilightForestMod.idBlockHedge).c("TFHedge");
        TFBlocks.bossSpawner = new BlockTFBossSpawner(TwilightForestMod.idBlockBossSpawner).c("TFBossSpawner");
        TFBlocks.fireflyJar = new BlockTFFireflyJar(TwilightForestMod.idBlockFireflyJar).c("TFFireflyJar");
        TFBlocks.plant = new BlockTFPlant(TwilightForestMod.idBlockPlant).c("TFPlant");
        TFBlocks.root = new BlockTFRoots(TwilightForestMod.idBlockRoots).c("TFRoots");
        TFBlocks.uncraftingTable = new BlockTFUncraftingTable(TwilightForestMod.idBlockUncraftingTable).c("TFUncraftingTable");
        TFBlocks.fireJet = new BlockTFFireJet(TwilightForestMod.idBlockFireJet).c("TFFireJet");
        TFBlocks.nagastone = new BlockTFNagastone(TwilightForestMod.idBlockNagastone).c("TFNagastone");
        TFBlocks.sapling = new BlockTFSapling(TwilightForestMod.idBlockSapling).c("TFSapling");
        TFBlocks.magicLog = new BlockTFMagicLog(TwilightForestMod.idBlockMagicLog).c("TFMagicLog");
        TFBlocks.magicLogSpecial = new BlockTFMagicLogSpecial(TwilightForestMod.idBlockMagicLogSpecial).c("TFMagicLogSpecial");
        TFBlocks.magicLeaves = new BlockTFMagicLeaves(TwilightForestMod.idBlockMagicLeaves).c("TFMagicLeaves");
        TFBlocks.moonworm = new BlockTFMoonworm(TwilightForestMod.idBlockMoonworm).c("TFMoonworm");
        TFBlocks.towerWood = new BlockTFTowerWood(TwilightForestMod.idBlockTowerWood).c("TFTowerStone");
        TFBlocks.towerDevice = new BlockTFTowerDevice(TwilightForestMod.idBlockTowerDevice).c("TFTowerDevice");
        TFBlocks.towerTranslucent = new BlockTFTowerTranslucent(TwilightForestMod.idBlockTowerTranslucent).c("TFTowerTranslucent");
        TFBlocks.trophy = new BlockTFTrophy(TwilightForestMod.idBlockTrophy).c("TFTrophy");
        MinecraftForge.setBlockHarvestLevel(TFBlocks.magicLog, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.magicLogSpecial, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.log, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.root, "axe", 0);
        aou.setBurnProperties(TFBlocks.log.cz, 5, 5);
        aou.setBurnProperties(TFBlocks.leaves.cz, 30, 60);
        this.registerBlocks();
    }
    
    public void registerBlocks() {
        this.registerMyBlock(TFBlocks.log);
        this.registerMyBlock(TFBlocks.root);
        this.registerMyBlock(TFBlocks.leaves);
        this.registerMyBlock(TFBlocks.firefly, xh.class);
        this.registerMyBlock(TFBlocks.cicada, xh.class);
        this.registerMyBlock(TFBlocks.portal, xh.class);
        this.registerMyBlock(TFBlocks.mazestone);
        this.registerMyBlock(TFBlocks.hedge);
        this.registerMyBlock(TFBlocks.bossSpawner);
        this.registerMyBlock(TFBlocks.fireflyJar, xh.class);
        this.registerMyBlock(TFBlocks.plant, ItemBlockTFPlant.class);
        this.registerMyBlock(TFBlocks.uncraftingTable, xh.class);
        this.registerMyBlock(TFBlocks.fireJet);
        this.registerMyBlock(TFBlocks.nagastone);
        this.registerMyBlock(TFBlocks.sapling);
        this.registerMyBlock(TFBlocks.moonworm, xh.class);
        this.registerMyBlock(TFBlocks.magicLog);
        this.registerMyBlock(TFBlocks.magicLeaves);
        this.registerMyBlock(TFBlocks.magicLogSpecial);
        this.registerMyBlock(TFBlocks.towerWood);
        this.registerMyBlock(TFBlocks.towerDevice);
        this.registerMyBlock(TFBlocks.towerTranslucent);
        this.registerMyBlock(TFBlocks.trophy);
    }
    
    private void registerMyBlock(final aou block, final Class pickup) {
        GameRegistry.registerBlock(block, pickup, block.a(), "TwilightForest");
    }
    
    private void registerMyBlock(final aou block) {
        GameRegistry.registerBlock(block, (Class)ItemBlockTFMeta.class, block.a(), "TwilightForest");
    }
}
