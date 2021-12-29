// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.item.ItemBlockTFMeta;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import twilightforest.item.ItemBlockTFAuroraSlab;
import twilightforest.item.ItemBlockTFDeadrock;
import twilightforest.item.ItemBlockTFThorns;
import twilightforest.item.ItemBlockTFPlant;
import net.minecraft.item.ItemBlock;
import net.minecraft.block.BlockSlab;
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
    public static Block thorns;
    public static Block burntThorns;
    public static Block thornRose;
    public static Block leaves3;
    public static Block deadrock;
    public static Block darkleaves;
    public static Block auroraPillar;
    public static BlockSlab auroraSlab;
    public static BlockSlab auroraDoubleSlab;
    public static Block trollSteinn;
    public static Block trollLjos;
    public static Block wispyCloud;
    public static Block fluffyCloud;
    
    public static void registerBlocks() {
        TFBlocks.log = new BlockTFLog().func_149663_c("TFLog");
        TFBlocks.leaves = new BlockTFLeaves().func_149663_c("TFLeaves").func_149658_d("leaves_oak");
        TFBlocks.firefly = new BlockTFFirefly().func_149663_c("TFFirefly");
        TFBlocks.cicada = new BlockTFCicada().func_149663_c("TFCicada");
        TFBlocks.portal = new BlockTFPortal().func_149663_c("TFPortal");
        TFBlocks.mazestone = new BlockTFMazestone().func_149663_c("TFMazestone");
        TFBlocks.hedge = new BlockTFHedge().func_149663_c("TFHedge");
        TFBlocks.bossSpawner = new BlockTFBossSpawner().func_149663_c("TFBossSpawner");
        TFBlocks.fireflyJar = new BlockTFFireflyJar().func_149663_c("TFFireflyJar");
        TFBlocks.plant = new BlockTFPlant().func_149663_c("TFPlant");
        TFBlocks.root = new BlockTFRoots().func_149663_c("TFRoots");
        TFBlocks.uncraftingTable = new BlockTFUncraftingTable().func_149663_c("TFUncraftingTable");
        TFBlocks.fireJet = new BlockTFFireJet().func_149663_c("TFFireJet");
        TFBlocks.nagastone = new BlockTFNagastone().func_149663_c("TFNagastone");
        TFBlocks.sapling = new BlockTFSapling().func_149663_c("TFSapling");
        TFBlocks.magicLog = new BlockTFMagicLog().func_149663_c("TFMagicLog");
        TFBlocks.magicLogSpecial = new BlockTFMagicLogSpecial().func_149663_c("TFMagicLogSpecial");
        TFBlocks.magicLeaves = new BlockTFMagicLeaves().func_149663_c("TFMagicLeaves");
        TFBlocks.moonworm = new BlockTFMoonworm().func_149663_c("TFMoonworm");
        TFBlocks.towerWood = new BlockTFTowerWood().func_149663_c("TFTowerStone");
        TFBlocks.towerDevice = new BlockTFTowerDevice().func_149663_c("TFTowerDevice");
        TFBlocks.towerTranslucent = new BlockTFTowerTranslucent().func_149663_c("TFTowerTranslucent");
        TFBlocks.trophy = new BlockTFTrophy().func_149663_c("TFTrophy");
        TFBlocks.shield = new BlockTFShield().func_149663_c("TFShield");
        TFBlocks.trophyPedestal = new BlockTFTrophyPedestal().func_149663_c("TFTrophyPedestal");
        TFBlocks.auroraBrick = new BlockTFAuroraBrick().func_149663_c("TFAuroraBrick");
        TFBlocks.underBrick = new BlockTFUnderBrick().func_149663_c("TFUnderBrick");
        TFBlocks.thorns = new BlockTFThorns().func_149663_c("TFThorns");
        TFBlocks.burntThorns = new BlockTFBurntThorns().func_149663_c("TFBurntThorns");
        TFBlocks.thornRose = new BlockTFThornRose().func_149663_c("TFThornRose").func_149658_d("TwilightForest:thornRose");
        TFBlocks.leaves3 = new BlockTFLeaves3().func_149663_c("TFLeaves3").func_149658_d("leaves_oak");
        TFBlocks.deadrock = new BlockTFDeadrock().func_149663_c("TFDeadrock");
        TFBlocks.darkleaves = new BlockTFDarkLeaves().func_149663_c("DarkLeaves");
        TFBlocks.auroraPillar = new BlockTFAuroraPillar().func_149663_c("AuroraPillar");
        TFBlocks.auroraSlab = (BlockSlab)new BlockTFAuroraSlab(false).func_149663_c("AuroraSlab");
        TFBlocks.auroraDoubleSlab = (BlockSlab)new BlockTFAuroraSlab(true).func_149663_c("AuroraDoubleSlab");
        TFBlocks.trollSteinn = new BlockTFTrollSteinn().func_149663_c("TrollSteinn");
        TFBlocks.trollLjos = new BlockTFTrollLjos().func_149663_c("TrollLjos");
        TFBlocks.wispyCloud = new BlockTFWispyCloud().func_149663_c("WispyCloud");
        TFBlocks.fluffyCloud = new BlockTFFluffyCloud().func_149663_c("FluffyCloud");
        registerMyBlock(TFBlocks.log);
        registerMyBlock(TFBlocks.root);
        registerMyBlock(TFBlocks.leaves);
        registerMyBlock(TFBlocks.firefly, ItemBlock.class);
        registerMyBlock(TFBlocks.cicada, ItemBlock.class);
        registerMyBlock(TFBlocks.portal, ItemBlock.class);
        registerMyBlock(TFBlocks.mazestone);
        registerMyBlock(TFBlocks.hedge);
        registerMyBlock(TFBlocks.bossSpawner);
        registerMyBlock(TFBlocks.fireflyJar, ItemBlock.class);
        registerMyBlock(TFBlocks.plant, ItemBlockTFPlant.class);
        registerMyBlock(TFBlocks.uncraftingTable, ItemBlock.class);
        registerMyBlock(TFBlocks.fireJet);
        registerMyBlock(TFBlocks.nagastone);
        registerMyBlock(TFBlocks.sapling);
        registerMyBlock(TFBlocks.moonworm, ItemBlock.class);
        registerMyBlock(TFBlocks.magicLog);
        registerMyBlock(TFBlocks.magicLeaves);
        registerMyBlock(TFBlocks.magicLogSpecial);
        registerMyBlock(TFBlocks.towerWood);
        registerMyBlock(TFBlocks.towerDevice);
        registerMyBlock(TFBlocks.towerTranslucent);
        registerMyBlock(TFBlocks.trophy);
        registerMyBlock(TFBlocks.shield);
        registerMyBlock(TFBlocks.trophyPedestal);
        registerMyBlock(TFBlocks.auroraBrick, ItemBlock.class);
        registerMyBlock(TFBlocks.underBrick);
        registerMyBlock(TFBlocks.thorns, (Class<? extends ItemBlock>)ItemBlockTFThorns.class, TFBlocks.thorns, ((BlockTFThorns)TFBlocks.thorns).getNames());
        registerMyBlock(TFBlocks.burntThorns, ItemBlock.class);
        registerMyBlock(TFBlocks.thornRose, ItemBlock.class);
        registerMyBlock(TFBlocks.leaves3);
        registerMyBlock(TFBlocks.deadrock, (Class<? extends ItemBlock>)ItemBlockTFDeadrock.class, TFBlocks.deadrock, BlockTFDeadrock.names);
        registerMyBlock(TFBlocks.darkleaves, ItemBlock.class);
        registerMyBlock(TFBlocks.auroraPillar, ItemBlock.class);
        registerMyBlock((Block)TFBlocks.auroraSlab, (Class<? extends ItemBlock>)ItemBlockTFAuroraSlab.class, TFBlocks.auroraSlab, TFBlocks.auroraDoubleSlab, false);
        registerMyBlock((Block)TFBlocks.auroraDoubleSlab, (Class<? extends ItemBlock>)ItemBlockTFAuroraSlab.class, TFBlocks.auroraSlab, TFBlocks.auroraDoubleSlab, true);
        Blocks.field_150480_ab.setFireInfo(TFBlocks.log, 5, 5);
        Blocks.field_150480_ab.setFireInfo(TFBlocks.leaves, 30, 60);
        Blocks.field_150480_ab.setFireInfo(TFBlocks.leaves3, 30, 60);
    }
    
    private static void registerMyBlock(final Block block, final Class<? extends ItemBlock> pickup, final BlockSlab singleSlab, final BlockSlab doubleSlab, final boolean isDouble) {
        GameRegistry.registerBlock(block, (Class)pickup, block.func_149739_a(), new Object[] { singleSlab, doubleSlab, isDouble });
    }
    
    private static void registerMyBlock(final Block block, final Class<? extends ItemBlock> pickup, final Block blockAgain, final String[] names) {
        GameRegistry.registerBlock(block, (Class)pickup, block.func_149739_a(), new Object[] { blockAgain, names });
    }
    
    private static void registerMyBlock(final Block block, final Class<? extends ItemBlock> pickup) {
        GameRegistry.registerBlock(block, (Class)pickup, block.func_149739_a());
    }
    
    private static void registerMyBlock(final Block block) {
        GameRegistry.registerBlock(block, (Class)ItemBlockTFMeta.class, block.func_149739_a());
    }
}
