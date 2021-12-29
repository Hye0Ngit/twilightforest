// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.Block;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.Item;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;

public class TFRecipes
{
    public static void registerRecipes() {
        OreDictionary.registerOre("logWood", new ItemStack(TFBlocks.log, 1, 32767));
        OreDictionary.registerOre("logWood", new ItemStack(TFBlocks.magicLog, 1, 32767));
        OreDictionary.registerOre("treeSapling", new ItemStack(TFBlocks.sapling, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new ItemStack(TFBlocks.leaves, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new ItemStack(TFBlocks.magicLeaves, 1, 32767));
        OreDictionary.registerOre("plankWood", new ItemStack(TFBlocks.towerWood, 1, 32767));
        OreDictionary.registerOre("ingotFiery", new ItemStack(TFItems.fieryIngot));
        OreDictionary.registerOre("oreIronwood", new ItemStack(TFItems.ironwoodRaw));
        OreDictionary.registerOre("ingotIronwood", new ItemStack(TFItems.ironwoodIngot));
        OreDictionary.registerOre("ingotSteeleaf", new ItemStack(TFItems.steeleafIngot));
        OreDictionary.registerOre("oreKnightmetal", new ItemStack(TFItems.shardCluster));
        OreDictionary.registerOre("ingotKnightmetal", new ItemStack(TFItems.knightMetal));
        RecipeSorter.register("TwilightForest:mapcloning", (Class)TFMapCloningRecipe.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addSmelting(TFBlocks.log, new ItemStack(Items.field_151044_h, 1, 1), 0.1f);
        GameRegistry.addSmelting(TFBlocks.magicLog, new ItemStack(Items.field_151044_h, 1, 1), 0.1f);
        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 4, 0), new Object[] { "w", 'w', new ItemStack(TFBlocks.log, 1, 0) });
        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 4, 1), new Object[] { "w", 'w', new ItemStack(TFBlocks.log, 1, 1) });
        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 4, 2), new Object[] { "w", 'w', new ItemStack(TFBlocks.log, 1, 2) });
        GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 4, 1), new Object[] { "w", 'w', new ItemStack(TFBlocks.log, 1, 3) });
        addEnchantedRecipe(TFItems.plateNaga, Enchantment.field_77329_d, 3, "# #", "###", "###", '#', TFItems.nagaScale);
        addEnchantedRecipe(TFItems.legsNaga, Enchantment.field_77332_c, 3, "###", "# #", "# #", '#', TFItems.nagaScale);
        GameRegistry.addShapelessRecipe(new ItemStack(TFBlocks.fireflyJar, 1, 0), new Object[] { TFBlocks.firefly, Items.field_151069_bo });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterTwilight), new Object[] { new ItemStack(TFItems.scepterTwilight, 1, TFItems.scepterTwilight.func_77612_l()), Items.field_151079_bi });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterLifeDrain), new Object[] { new ItemStack(TFItems.scepterLifeDrain, 1, TFItems.scepterLifeDrain.func_77612_l()), Items.field_151071_bq });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Items.field_151078_bh), new ItemStack((Item)Items.field_151068_bn, 1, 16281) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Items.field_151078_bh), new ItemStack((Item)Items.field_151068_bn, 1, 16313) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Items.field_151078_bh), new ItemStack((Item)Items.field_151068_bn, 1, 16345) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Items.field_151078_bh), new ItemStack((Item)Items.field_151068_bn, 1, 16377) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Items.field_151078_bh), new ItemStack((Item)Items.field_151068_bn, 1, 8201) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Items.field_151078_bh), new ItemStack((Item)Items.field_151068_bn, 1, 8265) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Items.field_151078_bh), new ItemStack((Item)Items.field_151068_bn, 1, 8233) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.magicMapFocus), new Object[] { TFItems.feather, TFItems.torchberries, Items.field_151114_aO });
        GameRegistry.addRecipe(new ItemStack(TFItems.emptyMagicMap), new Object[] { "###", "#X#", "###", '#', Items.field_151121_aF, 'X', TFItems.magicMapFocus });
        GameRegistry.addRecipe(new ItemStack(TFItems.emptyMazeMap), new Object[] { "###", "#X#", "###", '#', Items.field_151121_aF, 'X', TFItems.mazeMapFocus });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.emptyOreMap), new Object[] { new ItemStack(TFItems.mazeMap, 1, 32767), Blocks.field_150340_R, Blocks.field_150484_ah, Blocks.field_150339_S });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.emptyOreMap), new Object[] { new ItemStack(TFItems.emptyMazeMap, 1, 32767), Blocks.field_150340_R, Blocks.field_150484_ah, Blocks.field_150339_S });
        GameRegistry.addRecipe(new ItemStack(Items.field_151032_g, 4), new Object[] { "X", "#", "Y", 'Y', TFItems.feather, 'X', Items.field_151145_ak, '#', Items.field_151055_y });
        GameRegistry.addShapelessRecipe(new ItemStack(Items.field_151055_y), new Object[] { new ItemStack(TFBlocks.plant, 1, 14) });
        GameRegistry.addRecipe(new ItemStack(Blocks.field_150478_aa, 5), new Object[] { "B", "S", 'B', TFItems.torchberries, 'S', Items.field_151055_y });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.ironwoodRaw), new Object[] { TFItems.liveRoot, Items.field_151042_j, Items.field_151074_bl });
        GameRegistry.addSmelting(TFItems.ironwoodRaw, new ItemStack(TFItems.ironwoodIngot, 2), 1.0f);
        addEnchantedRecipe(TFItems.ironwoodHelm, Enchantment.field_77341_i, 1, "###", "# #", '#', TFItems.ironwoodIngot);
        addEnchantedRecipe(TFItems.ironwoodPlate, Enchantment.field_77332_c, 1, "# #", "###", "###", '#', TFItems.ironwoodIngot);
        addEnchantedRecipe(TFItems.ironwoodLegs, Enchantment.field_77332_c, 1, "###", "# #", "# #", '#', TFItems.ironwoodIngot);
        addEnchantedRecipe(TFItems.ironwoodBoots, Enchantment.field_77330_e, 1, "# #", "# #", '#', TFItems.ironwoodIngot);
        addEnchantedRecipe(TFItems.ironwoodSword, Enchantment.field_77337_m, 1, "#", "#", "X", '#', TFItems.ironwoodIngot, 'X', Items.field_151055_y);
        addEnchantedRecipe(TFItems.ironwoodShovel, Enchantment.field_77347_r, 1, "#", "X", "X", '#', TFItems.ironwoodIngot, 'X', Items.field_151055_y);
        addEnchantedRecipe(TFItems.ironwoodPick, Enchantment.field_77349_p, 1, "###", " X ", " X ", '#', TFItems.ironwoodIngot, 'X', Items.field_151055_y);
        addEnchantedRecipe(TFItems.ironwoodAxe, Enchantment.field_77346_s, 1, "##", "#X", " X", '#', TFItems.ironwoodIngot, 'X', Items.field_151055_y);
        addEnchantedRecipe(TFItems.ironwoodHoe, null, 0, "##", " X", " X", '#', TFItems.ironwoodIngot, 'X', Items.field_151055_y);
        GameRegistry.addRecipe(new ItemStack(TFBlocks.uncraftingTable), new Object[] { "###", "#X#", "###", '#', Blocks.field_150462_ai, 'X', TFItems.mazeMapFocus });
        GameRegistry.addSmelting(TFItems.venisonRaw, new ItemStack(TFItems.venisonCooked), 0.3f);
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.fieryIngot), new Object[] { TFItems.fieryBlood, Items.field_151042_j });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.fieryIngot), new Object[] { TFItems.fieryTears, Items.field_151042_j });
        GameRegistry.addRecipe(new ItemStack(TFItems.fieryHelm), new Object[] { "###", "# #", '#', TFItems.fieryIngot });
        GameRegistry.addRecipe(new ItemStack(TFItems.fieryPlate), new Object[] { "# #", "###", "###", '#', TFItems.fieryIngot });
        GameRegistry.addRecipe(new ItemStack(TFItems.fieryLegs), new Object[] { "###", "# #", "# #", '#', TFItems.fieryIngot });
        GameRegistry.addRecipe(new ItemStack(TFItems.fieryBoots), new Object[] { "# #", "# #", '#', TFItems.fieryIngot });
        addEnchantedRecipe(TFItems.fierySword, Enchantment.field_77334_n, 2, "#", "#", "X", '#', TFItems.fieryIngot, 'X', Items.field_151072_bj);
        GameRegistry.addRecipe(new ItemStack(TFItems.fieryPick), new Object[] { "###", " X ", " X ", '#', TFItems.fieryIngot, 'X', Items.field_151072_bj });
        addEnchantedRecipe(TFItems.steeleafHelm, Enchantment.field_77328_g, 2, "###", "# #", '#', TFItems.steeleafIngot);
        addEnchantedRecipe(TFItems.steeleafPlate, Enchantment.field_77327_f, 2, "# #", "###", "###", '#', TFItems.steeleafIngot);
        addEnchantedRecipe(TFItems.steeleafLegs, Enchantment.field_77329_d, 2, "###", "# #", "# #", '#', TFItems.steeleafIngot);
        addEnchantedRecipe(TFItems.steeleafBoots, Enchantment.field_77330_e, 2, "# #", "# #", '#', TFItems.steeleafIngot);
        addEnchantedRecipe(TFItems.steeleafSword, Enchantment.field_77335_o, 2, "#", "#", "X", '#', TFItems.steeleafIngot, 'X', Items.field_151055_y);
        addEnchantedRecipe(TFItems.steeleafShovel, Enchantment.field_77349_p, 2, "#", "X", "X", '#', TFItems.steeleafIngot, 'X', Items.field_151055_y);
        addEnchantedRecipe(TFItems.steeleafPick, Enchantment.field_77346_s, 2, "###", " X ", " X ", '#', TFItems.steeleafIngot, 'X', Items.field_151055_y);
        addEnchantedRecipe(TFItems.steeleafAxe, Enchantment.field_77349_p, 2, "##", "#X", " X", '#', TFItems.steeleafIngot, 'X', Items.field_151055_y);
        addEnchantedRecipe(TFItems.steeleafHoe, null, 0, "##", " X", " X", '#', TFItems.steeleafIngot, 'X', Items.field_151055_y);
        GameRegistry.addSmelting(TFItems.meefRaw, new ItemStack(TFItems.meefSteak), 0.3f);
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.moonwormQueen), new Object[] { new ItemStack(TFItems.moonwormQueen, 1, 32767), TFItems.torchberries, TFItems.torchberries, TFItems.torchberries });
        GameRegistry.addRecipe(new ItemStack(TFItems.emptyMagicMap), new Object[] { "###", "#X#", "###", '#', Items.field_151121_aF, 'X', TFItems.magicMapFocus });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.charmOfKeeping2), new Object[] { TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1 });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.charmOfKeeping3), new Object[] { TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2 });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.charmOfLife2), new Object[] { TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1 });
        GameRegistry.addRecipe((IRecipe)new TFMapCloningRecipe(TFItems.magicMap, TFItems.emptyMagicMap));
        GameRegistry.addRecipe((IRecipe)new TFMapCloningRecipe(TFItems.mazeMap, TFItems.emptyMazeMap));
        GameRegistry.addRecipe((IRecipe)new TFMapCloningRecipe(TFItems.oreMap, TFItems.emptyOreMap));
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerWood, 4, 0), new Object[] { "##", "##", '#', new ItemStack(TFBlocks.log, 1, 3) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerWood, 3, 1), new Object[] { "#", "#", "#", '#', new ItemStack(TFBlocks.towerWood, 1, 0) });
        GameRegistry.addRecipe(new ItemStack(TFItems.carminite), new Object[] { "brb", "rgr", "brb", 'b', new ItemStack(TFItems.borerEssence), 'r', new ItemStack(Items.field_151137_ax), 'g', new ItemStack(Items.field_151073_bk) });
        GameRegistry.addRecipe(new ItemStack(TFItems.carminite), new Object[] { "rbr", "bgb", "rbr", 'b', new ItemStack(TFItems.borerEssence), 'r', new ItemStack(Items.field_151137_ax), 'g', new ItemStack(Items.field_151073_bk) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerDevice, 8, 2), new Object[] { "ewe", "wcw", "ewe", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'w', new ItemStack(TFBlocks.towerWood, 1, 0), 'c', new ItemStack(TFItems.carminite) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerDevice, 2, 0), new Object[] { "ere", "rcr", "ere", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'r', new ItemStack(Items.field_151137_ax), 'c', new ItemStack(TFItems.carminite) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerDevice, 1, 6), new Object[] { "ece", "cdc", "ece", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'd', new ItemStack(Blocks.field_150367_z), 'c', new ItemStack(TFItems.carminite) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerDevice, 1, 12), new Object[] { "ece", "coc", "ece", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'o', new ItemStack(Blocks.field_150450_ax), 'c', new ItemStack(TFItems.carminite) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.fireJet, 1, 1), new Object[] { "ere", "rsr", "ere", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'r', new ItemStack(Items.field_151137_ax), 's', new ItemStack(TFBlocks.fireJet, 1, 0) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.fireJet, 1, 11), new Object[] { "ere", "rjr", "lll", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'r', new ItemStack(Items.field_151137_ax), 'l', new ItemStack(Items.field_151129_at), 'j', new ItemStack(TFBlocks.fireJet, 1, 8) });
        GameRegistry.addRecipe(new ItemStack(TFItems.shardCluster), new Object[] { "###", "###", "###", '#', TFItems.armorShard });
        GameRegistry.addSmelting(TFItems.shardCluster, new ItemStack(TFItems.knightMetal), 1.0f);
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyHelm), new Object[] { "###", "# #", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyPlate), new Object[] { "# #", "###", "###", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyLegs), new Object[] { "###", "# #", "# #", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyBoots), new Object[] { "# #", "# #", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlySword), new Object[] { "#", "#", "X", '#', TFItems.knightMetal, 'X', Items.field_151055_y });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyPick), new Object[] { "###", " X ", " X ", '#', TFItems.knightMetal, 'X', Items.field_151055_y });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyAxe), new Object[] { "##", "#X", " X", '#', TFItems.knightMetal, 'X', Items.field_151055_y });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyAxe), new Object[] { "##", "X#", "X ", '#', TFItems.knightMetal, 'X', Items.field_151055_y });
        addEnchantedRecipe(TFItems.yetiHelm, Enchantment.field_77332_c, 2, "###", "# #", '#', TFItems.alphaFur);
        addEnchantedRecipe(TFItems.yetiPlate, Enchantment.field_77332_c, 2, "# #", "###", "###", '#', TFItems.alphaFur);
        addEnchantedRecipe(TFItems.yetiLegs, Enchantment.field_77332_c, 2, "###", "# #", "# #", '#', TFItems.alphaFur);
        addEnchantedRecipe(TFItems.yetiBoots, Enchantment.field_77332_c, 2, Enchantment.field_77330_e, 4, "# #", "# #", '#', TFItems.alphaFur);
        GameRegistry.addRecipe(new ItemStack(TFItems.arcticHelm), new Object[] { "###", "# #", '#', TFItems.arcticFur });
        GameRegistry.addRecipe(new ItemStack(TFItems.arcticPlate), new Object[] { "# #", "###", "###", '#', TFItems.arcticFur });
        GameRegistry.addRecipe(new ItemStack(TFItems.arcticLegs), new Object[] { "###", "# #", "# #", '#', TFItems.arcticFur });
        GameRegistry.addRecipe(new ItemStack(TFItems.arcticBoots), new Object[] { "# #", "# #", '#', TFItems.arcticFur });
        GameRegistry.addRecipe(new ItemStack((Block)TFBlocks.auroraSlab, 6, 0), new Object[] { "###", '#', TFBlocks.auroraBlock });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.auroraPillar, 2, 0), new Object[] { "#", "#", '#', TFBlocks.auroraBlock });
        GameRegistry.addRecipe(new ItemStack(TFItems.giantPick), new Object[] { "###", " X ", " X ", '#', TFBlocks.giantCobble, 'X', TFBlocks.giantLog });
        GameRegistry.addRecipe(new ItemStack(TFItems.giantSword), new Object[] { "#", "#", "X", '#', TFBlocks.giantCobble, 'X', TFBlocks.giantLog });
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150347_e, 64), new Object[] { new ItemStack(TFBlocks.giantCobble) });
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150344_f, 64), new Object[] { new ItemStack(TFBlocks.giantLog) });
        GameRegistry.addShapelessRecipe(new ItemStack((Block)Blocks.field_150362_t, 64), new Object[] { new ItemStack(TFBlocks.giantLeaves) });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightmetalRing), new Object[] { " # ", "# #", " # ", '#', TFItems.knightMetal });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.chainBlock), new Object[] { TFItems.knightmetalRing, TFItems.knightMetal, TFItems.knightMetal, TFItems.knightMetal, TFBlocks.knightmetalStorage });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.knightMetal, 9), new Object[] { new ItemStack(TFBlocks.knightmetalStorage) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.knightmetalStorage), new Object[] { "###", "###", "###", '#', TFItems.knightMetal });
    }
    
    public static void addEnchantedRecipe(final Item item, final Enchantment enchantment, final int enchantmentLevel, final Object... ingredientArray) {
        final ItemStack result = new ItemStack(item);
        if (enchantment != null) {
            result.func_77966_a(enchantment, enchantmentLevel);
        }
        GameRegistry.addRecipe(result, ingredientArray);
    }
    
    public static void addEnchantedRecipe(final Item item, final Enchantment enchantment, final int enchantmentLevel, final Enchantment enchantment2, final int enchantmentLevel2, final Object... ingredientArray) {
        final ItemStack result = new ItemStack(item);
        if (enchantment != null) {
            result.func_77966_a(enchantment, enchantmentLevel);
        }
        if (enchantment2 != null) {
            result.func_77966_a(enchantment2, enchantmentLevel2);
        }
        GameRegistry.addRecipe(result, ingredientArray);
    }
}
