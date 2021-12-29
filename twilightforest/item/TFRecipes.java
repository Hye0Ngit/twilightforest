// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.crafting.IRecipe;
import twilightforest.TFEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;

public class TFRecipes
{
    public TFRecipes() {
        OreDictionary.registerOre("woodLog", new ItemStack(TFBlocks.log, 1, 32767));
        OreDictionary.registerOre("woodLog", new ItemStack(TFBlocks.magicLog, 1, 32767));
        OreDictionary.registerOre("treeSapling", new ItemStack(TFBlocks.sapling, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new ItemStack(TFBlocks.leaves, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new ItemStack(TFBlocks.magicLeaves, 1, 32767));
        OreDictionary.registerOre("plankWood", new ItemStack(TFBlocks.towerWood, 1, 32767));
        GameRegistry.addRecipe(new ItemStack(Block.field_71988_x, 4, 0), new Object[] { "w", 'w', new ItemStack(TFBlocks.log, 1, 0) });
        GameRegistry.addRecipe(new ItemStack(Block.field_71988_x, 4, 1), new Object[] { "w", 'w', new ItemStack(TFBlocks.log, 1, 1) });
        GameRegistry.addRecipe(new ItemStack(Block.field_71988_x, 4, 2), new Object[] { "w", 'w', new ItemStack(TFBlocks.log, 1, 2) });
        GameRegistry.addRecipe(new ItemStack(Block.field_71988_x, 4, 1), new Object[] { "w", 'w', new ItemStack(TFBlocks.log, 1, 3) });
        GameRegistry.addSmelting(TFBlocks.log.field_71990_ca, new ItemStack(Item.field_77705_m, 1, 1), 0.1f);
        this.addEnchantedRecipe(TFItems.plateNaga, Enchantment.field_77329_d, 3, "# #", "###", "###", '#', TFItems.nagaScale);
        this.addEnchantedRecipe(TFItems.legsNaga, Enchantment.field_77332_c, 3, "###", "# #", "# #", '#', TFItems.nagaScale);
        GameRegistry.addShapelessRecipe(new ItemStack(TFBlocks.fireflyJar, 1, 0), new Object[] { TFBlocks.firefly, Item.field_77729_bt });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterTwilight), new Object[] { new ItemStack(TFItems.scepterTwilight, 1, TFItems.scepterTwilight.func_77612_l()), Item.field_77730_bn });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterLifeDrain), new Object[] { new ItemStack(TFItems.scepterLifeDrain, 1, TFItems.scepterLifeDrain.func_77612_l()), Item.field_77723_bv });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Item.field_77737_bm), new ItemStack((Item)Item.field_77726_bs, 1, 16281) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Item.field_77737_bm), new ItemStack((Item)Item.field_77726_bs, 1, 16313) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Item.field_77737_bm), new ItemStack((Item)Item.field_77726_bs, 1, 16345) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Item.field_77737_bm), new ItemStack((Item)Item.field_77726_bs, 1, 16377) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Item.field_77737_bm), new ItemStack((Item)Item.field_77726_bs, 1, 8201) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Item.field_77737_bm), new ItemStack((Item)Item.field_77726_bs, 1, 8265) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.scepterZombie), new Object[] { new ItemStack(TFItems.scepterZombie, 1, TFItems.scepterZombie.func_77612_l()), new ItemStack(Item.field_77737_bm), new ItemStack((Item)Item.field_77726_bs, 1, 8233) });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.magicMapFocus), new Object[] { TFItems.feather, TFItems.torchberries, Item.field_77751_aT });
        GameRegistry.addRecipe(new ItemStack(TFItems.emptyMagicMap), new Object[] { "###", "#X#", "###", '#', Item.field_77759_aK, 'X', TFItems.magicMapFocus });
        GameRegistry.addRecipe(new ItemStack(TFItems.emptyMazeMap), new Object[] { "###", "#X#", "###", '#', Item.field_77759_aK, 'X', TFItems.mazeMapFocus });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.emptyOreMap), new Object[] { new ItemStack(TFItems.mazeMap, 1, 32767), Block.field_72105_ah, Block.field_72071_ax, Block.field_72083_ai });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.emptyOreMap), new Object[] { new ItemStack(TFItems.emptyMazeMap, 1, 32767), Block.field_72105_ah, Block.field_72071_ax, Block.field_72083_ai });
        GameRegistry.addRecipe(new ItemStack(Item.field_77704_l, 4), new Object[] { "X", "#", "Y", 'Y', TFItems.feather, 'X', Item.field_77804_ap, '#', Item.field_77669_D });
        GameRegistry.addShapelessRecipe(new ItemStack(Item.field_77669_D), new Object[] { new ItemStack(TFBlocks.plant, 1, 14) });
        GameRegistry.addRecipe(new ItemStack(Block.field_72069_aq, 5), new Object[] { "B", "S", 'B', TFItems.torchberries, 'S', Item.field_77669_D });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.ironwoodRaw), new Object[] { TFItems.liveRoot, Item.field_77703_o, Item.field_77733_bq });
        GameRegistry.addSmelting(TFItems.ironwoodRaw.field_77779_bT, new ItemStack(TFItems.ironwoodIngot, 2), 1.0f);
        this.addEnchantedRecipe(TFItems.ironwoodHelm, Enchantment.field_77341_i, 1, "###", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodPlate, Enchantment.field_77332_c, 1, "# #", "###", "###", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodLegs, Enchantment.field_77332_c, 1, "###", "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodBoots, Enchantment.field_77330_e, 1, "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodSword, Enchantment.field_77337_m, 1, "#", "#", "X", '#', TFItems.ironwoodIngot, 'X', Item.field_77669_D);
        this.addEnchantedRecipe(TFItems.ironwoodShovel, Enchantment.field_77347_r, 1, "#", "X", "X", '#', TFItems.ironwoodIngot, 'X', Item.field_77669_D);
        this.addEnchantedRecipe(TFItems.ironwoodPick, Enchantment.field_77349_p, 1, "###", " X ", " X ", '#', TFItems.ironwoodIngot, 'X', Item.field_77669_D);
        this.addEnchantedRecipe(TFItems.ironwoodAxe, Enchantment.field_77346_s, 1, "##", "#X", " X", '#', TFItems.ironwoodIngot, 'X', Item.field_77669_D);
        this.addEnchantedRecipe(TFItems.ironwoodHoe, null, 0, "##", " X", " X", '#', TFItems.ironwoodIngot, 'X', Item.field_77669_D);
        GameRegistry.addRecipe(new ItemStack(TFBlocks.uncraftingTable), new Object[] { "###", "#X#", "###", '#', Block.field_72060_ay, 'X', TFItems.mazeMapFocus });
        GameRegistry.addSmelting(TFItems.venisonRaw.field_77779_bT, new ItemStack(TFItems.venisonCooked), 0.3f);
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.fieryIngot), new Object[] { TFItems.fieryBlood, Item.field_77703_o });
        this.addEnchantedRecipe(TFItems.fieryHelm, TFEnchantment.reactFire, 2, "###", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryPlate, TFEnchantment.reactFire, 2, "# #", "###", "###", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryLegs, TFEnchantment.reactFire, 2, "###", "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryBoots, TFEnchantment.reactFire, 2, "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fierySword, Enchantment.field_77334_n, 2, "#", "#", "X", '#', TFItems.fieryIngot, 'X', Item.field_77731_bo);
        GameRegistry.addRecipe(new ItemStack(TFItems.fieryPick), new Object[] { "###", " X ", " X ", '#', TFItems.fieryIngot, 'X', Item.field_77731_bo });
        this.addEnchantedRecipe(TFItems.steeleafHelm, Enchantment.field_77328_g, 2, "###", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafPlate, Enchantment.field_77327_f, 2, "# #", "###", "###", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafLegs, Enchantment.field_77329_d, 2, "###", "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafBoots, Enchantment.field_77330_e, 2, "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafSword, Enchantment.field_77335_o, 2, "#", "#", "X", '#', TFItems.steeleafIngot, 'X', Item.field_77669_D);
        this.addEnchantedRecipe(TFItems.steeleafShovel, Enchantment.field_77349_p, 2, "#", "X", "X", '#', TFItems.steeleafIngot, 'X', Item.field_77669_D);
        this.addEnchantedRecipe(TFItems.steeleafPick, Enchantment.field_77346_s, 2, "###", " X ", " X ", '#', TFItems.steeleafIngot, 'X', Item.field_77669_D);
        this.addEnchantedRecipe(TFItems.steeleafAxe, Enchantment.field_77349_p, 2, "##", "#X", " X", '#', TFItems.steeleafIngot, 'X', Item.field_77669_D);
        this.addEnchantedRecipe(TFItems.steeleafHoe, null, 0, "##", " X", " X", '#', TFItems.steeleafIngot, 'X', Item.field_77669_D);
        GameRegistry.addSmelting(TFItems.meefRaw.field_77779_bT, new ItemStack(TFItems.meefSteak), 0.3f);
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.moonwormQueen), new Object[] { new ItemStack(TFItems.moonwormQueen, 1, 32767), TFItems.torchberries, TFItems.torchberries, TFItems.torchberries });
        GameRegistry.addRecipe(new ItemStack(TFItems.emptyMagicMap), new Object[] { "###", "#X#", "###", '#', Item.field_77759_aK, 'X', TFItems.magicMapFocus });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.charmOfKeeping2), new Object[] { TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1 });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.charmOfKeeping3), new Object[] { TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2 });
        GameRegistry.addShapelessRecipe(new ItemStack(TFItems.charmOfLife2), new Object[] { TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1 });
        GameRegistry.addRecipe((IRecipe)new TFMapCloningRecipe(TFItems.magicMap.field_77779_bT, TFItems.emptyMagicMap.field_77779_bT));
        GameRegistry.addRecipe((IRecipe)new TFMapCloningRecipe(TFItems.mazeMap.field_77779_bT, TFItems.emptyMazeMap.field_77779_bT));
        GameRegistry.addRecipe((IRecipe)new TFMapCloningRecipe(TFItems.oreMap.field_77779_bT, TFItems.emptyOreMap.field_77779_bT));
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerWood, 4, 0), new Object[] { "##", "##", '#', new ItemStack(TFBlocks.log, 1, 3) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerWood, 3, 1), new Object[] { "#", "#", "#", '#', new ItemStack(TFBlocks.towerWood, 1, 0) });
        GameRegistry.addRecipe(new ItemStack(TFItems.carminite), new Object[] { "brb", "rgr", "brb", 'b', new ItemStack(TFItems.borerEssence), 'r', new ItemStack(Item.field_77767_aC), 'g', new ItemStack(Item.field_77732_bp) });
        GameRegistry.addRecipe(new ItemStack(TFItems.carminite), new Object[] { "rbr", "bgb", "rbr", 'b', new ItemStack(TFItems.borerEssence), 'r', new ItemStack(Item.field_77767_aC), 'g', new ItemStack(Item.field_77732_bp) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerDevice, 8, 2), new Object[] { "ewe", "wcw", "ewe", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'w', new ItemStack(TFBlocks.towerWood, 1, 0), 'c', new ItemStack(TFItems.carminite) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerDevice, 2, 0), new Object[] { "ere", "rcr", "ere", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'r', new ItemStack(Item.field_77767_aC), 'c', new ItemStack(TFItems.carminite) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerDevice, 1, 6), new Object[] { "ece", "cdc", "ece", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'd', new ItemStack(Block.field_71958_P), 'c', new ItemStack(TFItems.carminite) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.towerDevice, 1, 12), new Object[] { "ece", "coc", "ece", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'o', new ItemStack(Block.field_72047_aN), 'c', new ItemStack(TFItems.carminite) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.fireJet, 1, 1), new Object[] { "ere", "rsr", "ere", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'r', new ItemStack(Item.field_77767_aC), 's', new ItemStack(TFBlocks.fireJet, 1, 0) });
        GameRegistry.addRecipe(new ItemStack(TFBlocks.fireJet, 1, 11), new Object[] { "ere", "rjr", "lll", 'e', new ItemStack(TFBlocks.towerWood, 1, 1), 'r', new ItemStack(Item.field_77767_aC), 'l', new ItemStack(Item.field_77775_ay), 'j', new ItemStack(TFBlocks.fireJet, 1, 8) });
        GameRegistry.addRecipe(new ItemStack(TFItems.shardCluster), new Object[] { "###", "###", "###", '#', TFItems.armorShard });
        GameRegistry.addSmelting(TFItems.shardCluster.field_77779_bT, new ItemStack(TFItems.knightMetal), 1.0f);
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyHelm), new Object[] { "###", "# #", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyPlate), new Object[] { "# #", "###", "###", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyLegs), new Object[] { "###", "# #", "# #", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyBoots), new Object[] { "# #", "# #", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlySword), new Object[] { "#", "#", "X", '#', TFItems.knightMetal, 'X', Item.field_77669_D });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyPick), new Object[] { "###", " X ", " X ", '#', TFItems.knightMetal, 'X', Item.field_77669_D });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyAxe), new Object[] { "##", "#X", " X", '#', TFItems.knightMetal, 'X', Item.field_77669_D });
        GameRegistry.addRecipe(new ItemStack(TFItems.knightlyAxe), new Object[] { "##", "X#", "X ", '#', TFItems.knightMetal, 'X', Item.field_77669_D });
    }
    
    public void addEnchantedRecipe(final Item item, final Enchantment enchantment, final int enchantmentLevel, final Object... ingredientArray) {
        final ItemStack result = new ItemStack(item);
        if (enchantment != null) {
            result.func_77966_a(enchantment, enchantmentLevel);
        }
        GameRegistry.addRecipe(result, ingredientArray);
    }
}
