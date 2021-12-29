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
    public static aqw log;
    public static aqw leaves;
    public static aqw firefly;
    public static aqw portal;
    public static aqw mazestone;
    public static aqw hedge;
    public static aqw bossSpawner;
    public static aqw fireflyJar;
    public static aqw plant;
    public static aqw cicada;
    public static aqw root;
    public static aqw uncraftingTable;
    public static aqw fireJet;
    public static aqw nagastone;
    public static aqw sapling;
    public static aqw magicLog;
    public static aqw magicLogSpecial;
    public static aqw magicLeaves;
    public static aqw moonworm;
    public static aqw towerWood;
    public static aqw towerDevice;
    public static aqw towerTranslucent;
    public static aqw trophy;
    public static aqw shield;
    public static aqw trophyPedestal;
    
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
        TFBlocks.shield = new BlockTFShield(TwilightForestMod.idBlockShield).c("TFShield");
        TFBlocks.trophyPedestal = new BlockTFTrophyPedestal(TwilightForestMod.idBlockTrophyPedestal).c("TFTrophyPedestal");
        MinecraftForge.setBlockHarvestLevel(TFBlocks.magicLog, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.magicLogSpecial, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.log, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.root, "axe", 0);
        aqw.setBurnProperties(TFBlocks.log.cF, 5, 5);
        aqw.setBurnProperties(TFBlocks.leaves.cF, 30, 60);
        this.registerBlocks();
    }
    
    public void registerBlocks() {
        this.registerMyBlock(TFBlocks.log);
        this.registerMyBlock(TFBlocks.root);
        this.registerMyBlock(TFBlocks.leaves);
        this.registerMyBlock(TFBlocks.firefly, zg.class);
        this.registerMyBlock(TFBlocks.cicada, zg.class);
        this.registerMyBlock(TFBlocks.portal, zg.class);
        this.registerMyBlock(TFBlocks.mazestone);
        this.registerMyBlock(TFBlocks.hedge);
        this.registerMyBlock(TFBlocks.bossSpawner);
        this.registerMyBlock(TFBlocks.fireflyJar, zg.class);
        this.registerMyBlock(TFBlocks.plant, ItemBlockTFPlant.class);
        this.registerMyBlock(TFBlocks.uncraftingTable, zg.class);
        this.registerMyBlock(TFBlocks.fireJet);
        this.registerMyBlock(TFBlocks.nagastone);
        this.registerMyBlock(TFBlocks.sapling);
        this.registerMyBlock(TFBlocks.moonworm, zg.class);
        this.registerMyBlock(TFBlocks.magicLog);
        this.registerMyBlock(TFBlocks.magicLeaves);
        this.registerMyBlock(TFBlocks.magicLogSpecial);
        this.registerMyBlock(TFBlocks.towerWood);
        this.registerMyBlock(TFBlocks.towerDevice);
        this.registerMyBlock(TFBlocks.towerTranslucent);
        this.registerMyBlock(TFBlocks.trophy);
        this.registerMyBlock(TFBlocks.shield);
        this.registerMyBlock(TFBlocks.trophyPedestal);
    }
    
    private void registerMyBlock(final aqw block, final Class pickup) {
        GameRegistry.registerBlock(block, pickup, block.a(), "TwilightForest");
    }
    
    private void registerMyBlock(final aqw block) {
        GameRegistry.registerBlock(block, (Class)ItemBlockTFMeta.class, block.a(), "TwilightForest");
    }
}
