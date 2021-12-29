// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.item.ItemBlockTFMeta;
import cpw.mods.fml.common.registry.GameRegistry;
import twilightforest.item.ItemBlockTFPlant;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import twilightforest.TwilightForestMod;
import net.minecraft.block.Block;

public class TFBlocks
{
    public static Block log;
    public static Block leaves;
    public static Block firefly;
    public static Block portal;
    public static Block mazestone;
    public static Block hedge;
    public static Block bossSpawner;
    public static Block fireflyJar;
    public static Block plant;
    public static Block cicada;
    public static Block root;
    public static Block uncraftingTable;
    public static Block fireJet;
    public static Block nagastone;
    public static Block sapling;
    public static Block magicLog;
    public static Block magicLogSpecial;
    public static Block magicLeaves;
    public static Block moonworm;
    public static Block towerWood;
    public static Block towerDevice;
    public static Block towerTranslucent;
    public static Block trophy;
    public static Block shield;
    public static Block trophyPedestal;
    public static Block auroraBrick;
    public static Block underBrick;
    
    public TFBlocks() {
        TFBlocks.log = new BlockTFLog(TwilightForestMod.idBlockLog).func_71864_b("TFLog");
        TFBlocks.leaves = new BlockTFLeaves(TwilightForestMod.idBlockLeaves).func_71864_b("TFLeaves");
        TFBlocks.firefly = new BlockTFFirefly(TwilightForestMod.idBlockFirefly).func_71864_b("TFFirefly");
        TFBlocks.cicada = new BlockTFCicada(TwilightForestMod.idBlockCicada).func_71864_b("TFCicada");
        TFBlocks.portal = new BlockTFPortal(TwilightForestMod.idBlockPortal).func_71864_b("TFPortal");
        TFBlocks.mazestone = new BlockTFMazestone(TwilightForestMod.idBlockMazestone).func_71864_b("TFMazestone");
        TFBlocks.hedge = new BlockTFHedge(TwilightForestMod.idBlockHedge).func_71864_b("TFHedge");
        TFBlocks.bossSpawner = new BlockTFBossSpawner(TwilightForestMod.idBlockBossSpawner).func_71864_b("TFBossSpawner");
        TFBlocks.fireflyJar = new BlockTFFireflyJar(TwilightForestMod.idBlockFireflyJar).func_71864_b("TFFireflyJar");
        TFBlocks.plant = new BlockTFPlant(TwilightForestMod.idBlockPlant).func_71864_b("TFPlant");
        TFBlocks.root = new BlockTFRoots(TwilightForestMod.idBlockRoots).func_71864_b("TFRoots");
        TFBlocks.uncraftingTable = new BlockTFUncraftingTable(TwilightForestMod.idBlockUncraftingTable).func_71864_b("TFUncraftingTable");
        TFBlocks.fireJet = new BlockTFFireJet(TwilightForestMod.idBlockFireJet).func_71864_b("TFFireJet");
        TFBlocks.nagastone = new BlockTFNagastone(TwilightForestMod.idBlockNagastone).func_71864_b("TFNagastone");
        TFBlocks.sapling = new BlockTFSapling(TwilightForestMod.idBlockSapling).func_71864_b("TFSapling");
        TFBlocks.magicLog = new BlockTFMagicLog(TwilightForestMod.idBlockMagicLog).func_71864_b("TFMagicLog");
        TFBlocks.magicLogSpecial = new BlockTFMagicLogSpecial(TwilightForestMod.idBlockMagicLogSpecial).func_71864_b("TFMagicLogSpecial");
        TFBlocks.magicLeaves = new BlockTFMagicLeaves(TwilightForestMod.idBlockMagicLeaves).func_71864_b("TFMagicLeaves");
        TFBlocks.moonworm = new BlockTFMoonworm(TwilightForestMod.idBlockMoonworm).func_71864_b("TFMoonworm");
        TFBlocks.towerWood = new BlockTFTowerWood(TwilightForestMod.idBlockTowerWood).func_71864_b("TFTowerStone");
        TFBlocks.towerDevice = new BlockTFTowerDevice(TwilightForestMod.idBlockTowerDevice).func_71864_b("TFTowerDevice");
        TFBlocks.towerTranslucent = new BlockTFTowerTranslucent(TwilightForestMod.idBlockTowerTranslucent).func_71864_b("TFTowerTranslucent");
        TFBlocks.trophy = new BlockTFTrophy(TwilightForestMod.idBlockTrophy).func_71864_b("TFTrophy");
        TFBlocks.shield = new BlockTFShield(TwilightForestMod.idBlockShield).func_71864_b("TFShield");
        TFBlocks.trophyPedestal = new BlockTFTrophyPedestal(TwilightForestMod.idBlockTrophyPedestal).func_71864_b("TFTrophyPedestal");
        TFBlocks.auroraBrick = new BlockTFAuroraBrick(TwilightForestMod.idBlockAuroraBrick).func_71864_b("TFAuroraBrick");
        TFBlocks.underBrick = new BlockTFUnderBrick(TwilightForestMod.idBlockUnderBrick).func_71864_b("TFUnderBrick");
        MinecraftForge.setBlockHarvestLevel(TFBlocks.magicLog, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.magicLogSpecial, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.log, "axe", 0);
        MinecraftForge.setBlockHarvestLevel(TFBlocks.root, "axe", 0);
        Block.setBurnProperties(TFBlocks.log.field_71990_ca, 5, 5);
        Block.setBurnProperties(TFBlocks.leaves.field_71990_ca, 30, 60);
        this.registerBlocks();
    }
    
    public void registerBlocks() {
        this.registerMyBlock(TFBlocks.log);
        this.registerMyBlock(TFBlocks.root);
        this.registerMyBlock(TFBlocks.leaves);
        this.registerMyBlock(TFBlocks.firefly, ItemBlock.class);
        this.registerMyBlock(TFBlocks.cicada, ItemBlock.class);
        this.registerMyBlock(TFBlocks.portal, ItemBlock.class);
        this.registerMyBlock(TFBlocks.mazestone);
        this.registerMyBlock(TFBlocks.hedge);
        this.registerMyBlock(TFBlocks.bossSpawner);
        this.registerMyBlock(TFBlocks.fireflyJar, ItemBlock.class);
        this.registerMyBlock(TFBlocks.plant, ItemBlockTFPlant.class);
        this.registerMyBlock(TFBlocks.uncraftingTable, ItemBlock.class);
        this.registerMyBlock(TFBlocks.fireJet);
        this.registerMyBlock(TFBlocks.nagastone);
        this.registerMyBlock(TFBlocks.sapling);
        this.registerMyBlock(TFBlocks.moonworm, ItemBlock.class);
        this.registerMyBlock(TFBlocks.magicLog);
        this.registerMyBlock(TFBlocks.magicLeaves);
        this.registerMyBlock(TFBlocks.magicLogSpecial);
        this.registerMyBlock(TFBlocks.towerWood);
        this.registerMyBlock(TFBlocks.towerDevice);
        this.registerMyBlock(TFBlocks.towerTranslucent);
        this.registerMyBlock(TFBlocks.trophy);
        this.registerMyBlock(TFBlocks.shield);
        this.registerMyBlock(TFBlocks.trophyPedestal);
        this.registerMyBlock(TFBlocks.auroraBrick);
        this.registerMyBlock(TFBlocks.underBrick);
    }
    
    private void registerMyBlock(final Block block, final Class pickup) {
        GameRegistry.registerBlock(block, pickup, block.func_71917_a(), "TwilightForest");
    }
    
    private void registerMyBlock(final Block block) {
        GameRegistry.registerBlock(block, (Class)ItemBlockTFMeta.class, block.func_71917_a(), "TwilightForest");
    }
}
