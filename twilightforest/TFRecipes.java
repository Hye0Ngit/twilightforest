// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.item.TFItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import twilightforest.block.TFBlocks;

public class TFRecipes
{
    public TFRecipes() {
        OreDictionary.registerOre("woodLog", new wg(TFBlocks.log, 1, -1));
        OreDictionary.registerOre("woodLog", new wg(TFBlocks.magicLog, 1, -1));
        OreDictionary.registerOre("treeSapling", new wg(TFBlocks.sapling, 1, -1));
        OreDictionary.registerOre("treeLeaves", new wg(TFBlocks.leaves, 1, -1));
        OreDictionary.registerOre("treeLeaves", new wg(TFBlocks.magicLeaves, 1, -1));
        OreDictionary.registerOre("plankWood", new wg(TFBlocks.towerWood, 1, -1));
        GameRegistry.addRecipe(new wg(aou.B, 4, 0), new Object[] { "w", 'w', new wg(TFBlocks.log, 1, 0) });
        GameRegistry.addRecipe(new wg(aou.B, 4, 1), new Object[] { "w", 'w', new wg(TFBlocks.log, 1, 1) });
        GameRegistry.addRecipe(new wg(aou.B, 4, 2), new Object[] { "w", 'w', new wg(TFBlocks.log, 1, 2) });
        GameRegistry.addRecipe(new wg(aou.B, 4, 1), new Object[] { "w", 'w', new wg(TFBlocks.log, 1, 3) });
        GameRegistry.addSmelting(TFBlocks.log.cz, new wg(we.n, 1, 1), 0.1f);
        this.addEnchantedRecipe(TFItems.plateNaga, yt.e, 3, "# #", "###", "###", '#', TFItems.nagaScale);
        this.addEnchantedRecipe(TFItems.legsNaga, yt.d, 3, "###", "# #", "# #", '#', TFItems.nagaScale);
        GameRegistry.addShapelessRecipe(new wg(TFBlocks.fireflyJar, 1, 0), new Object[] { TFBlocks.firefly, we.bu });
        GameRegistry.addShapelessRecipe(new wg(TFItems.scepterTwilight), new Object[] { new wg(TFItems.scepterTwilight, 1, TFItems.scepterTwilight.n()), we.bo });
        GameRegistry.addShapelessRecipe(new wg(TFItems.scepterLifeDrain), new Object[] { new wg(TFItems.scepterLifeDrain, 1, TFItems.scepterLifeDrain.n()), we.bw });
        GameRegistry.addShapelessRecipe(new wg(TFItems.scepterZombie), new Object[] { new wg(TFItems.scepterZombie, 1, TFItems.scepterZombie.n()), new wg(we.bn), new wg((we)we.bt, 1, 16281) });
        GameRegistry.addShapelessRecipe(new wg(TFItems.scepterZombie), new Object[] { new wg(TFItems.scepterZombie, 1, TFItems.scepterZombie.n()), new wg(we.bn), new wg((we)we.bt, 1, 16313) });
        GameRegistry.addShapelessRecipe(new wg(TFItems.scepterZombie), new Object[] { new wg(TFItems.scepterZombie, 1, TFItems.scepterZombie.n()), new wg(we.bn), new wg((we)we.bt, 1, 16345) });
        GameRegistry.addShapelessRecipe(new wg(TFItems.scepterZombie), new Object[] { new wg(TFItems.scepterZombie, 1, TFItems.scepterZombie.n()), new wg(we.bn), new wg((we)we.bt, 1, 16377) });
        GameRegistry.addShapelessRecipe(new wg(TFItems.scepterZombie), new Object[] { new wg(TFItems.scepterZombie, 1, TFItems.scepterZombie.n()), new wg(we.bn), new wg((we)we.bt, 1, 8201) });
        GameRegistry.addShapelessRecipe(new wg(TFItems.scepterZombie), new Object[] { new wg(TFItems.scepterZombie, 1, TFItems.scepterZombie.n()), new wg(we.bn), new wg((we)we.bt, 1, 8265) });
        GameRegistry.addShapelessRecipe(new wg(TFItems.scepterZombie), new Object[] { new wg(TFItems.scepterZombie, 1, TFItems.scepterZombie.n()), new wg(we.bn), new wg((we)we.bt, 1, 8233) });
        GameRegistry.addShapelessRecipe(new wg(TFItems.magicMapFocus), new Object[] { TFItems.feather, TFItems.torchberries, we.aU });
        GameRegistry.addRecipe(new wg(TFItems.emptyMagicMap), new Object[] { "###", "#X#", "###", '#', we.aL, 'X', TFItems.magicMapFocus });
        GameRegistry.addRecipe(new wg(TFItems.emptyMazeMap), new Object[] { "###", "#X#", "###", '#', we.aL, 'X', TFItems.mazeMapFocus });
        GameRegistry.addShapelessRecipe(new wg(TFItems.emptyOreMap), new Object[] { new wg(TFItems.mazeMap, 1, -1), aou.al, aou.aB, aou.am });
        GameRegistry.addRecipe(new wg(we.m, 4), new Object[] { "X", "#", "Y", 'Y', TFItems.feather, 'X', we.aq, '#', we.E });
        GameRegistry.addShapelessRecipe(new wg(we.E), new Object[] { new wg(TFBlocks.plant, 1, 14) });
        GameRegistry.addRecipe(new wg(aou.au, 5), new Object[] { "B", "S", 'B', TFItems.torchberries, 'S', we.E });
        GameRegistry.addShapelessRecipe(new wg(TFItems.ironwoodRaw), new Object[] { TFItems.liveRoot, we.p, we.br });
        GameRegistry.addSmelting(TFItems.ironwoodRaw.cp, new wg(TFItems.ironwoodIngot, 2), 1.0f);
        this.addEnchantedRecipe(TFItems.ironwoodHelm, yt.j, 1, "###", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodPlate, yt.d, 1, "# #", "###", "###", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodLegs, yt.d, 1, "###", "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodBoots, yt.f, 1, "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodSword, yt.o, 1, "#", "#", "X", '#', TFItems.ironwoodIngot, 'X', we.E);
        this.addEnchantedRecipe(TFItems.ironwoodShovel, yt.t, 1, "#", "X", "X", '#', TFItems.ironwoodIngot, 'X', we.E);
        this.addEnchantedRecipe(TFItems.ironwoodPick, yt.r, 1, "###", " X ", " X ", '#', TFItems.ironwoodIngot, 'X', we.E);
        this.addEnchantedRecipe(TFItems.ironwoodAxe, yt.u, 1, "##", "#X", " X", '#', TFItems.ironwoodIngot, 'X', we.E);
        this.addEnchantedRecipe(TFItems.ironwoodHoe, null, 0, "##", " X", " X", '#', TFItems.ironwoodIngot, 'X', we.E);
        GameRegistry.addRecipe(new wg(TFBlocks.uncraftingTable), new Object[] { "###", "#X#", "###", '#', aou.aC, 'X', TFItems.mazeMapFocus });
        GameRegistry.addSmelting(TFItems.venisonRaw.cp, new wg(TFItems.venisonCooked), 0.3f);
        GameRegistry.addShapelessRecipe(new wg(TFItems.fieryIngot), new Object[] { TFItems.fieryBlood, we.p });
        this.addEnchantedRecipe(TFItems.fieryHelm, TFEnchantment.reactFire, 2, "###", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryPlate, TFEnchantment.reactFire, 2, "# #", "###", "###", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryLegs, TFEnchantment.reactFire, 2, "###", "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryBoots, TFEnchantment.reactFire, 2, "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fierySword, yt.p, 2, "#", "#", "X", '#', TFItems.fieryIngot, 'X', we.bp);
        GameRegistry.addRecipe(new wg(TFItems.fieryPick), new Object[] { "###", " X ", " X ", '#', TFItems.fieryIngot, 'X', we.bp });
        this.addEnchantedRecipe(TFItems.steeleafHelm, yt.h, 2, "###", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafPlate, yt.g, 2, "# #", "###", "###", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafLegs, yt.e, 2, "###", "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafBoots, yt.f, 2, "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafSword, yt.q, 2, "#", "#", "X", '#', TFItems.steeleafIngot, 'X', we.E);
        this.addEnchantedRecipe(TFItems.steeleafShovel, yt.r, 2, "#", "X", "X", '#', TFItems.steeleafIngot, 'X', we.E);
        this.addEnchantedRecipe(TFItems.steeleafPick, yt.u, 2, "###", " X ", " X ", '#', TFItems.steeleafIngot, 'X', we.E);
        this.addEnchantedRecipe(TFItems.steeleafAxe, yt.r, 2, "##", "#X", " X", '#', TFItems.steeleafIngot, 'X', we.E);
        this.addEnchantedRecipe(TFItems.steeleafHoe, null, 0, "##", " X", " X", '#', TFItems.steeleafIngot, 'X', we.E);
        GameRegistry.addSmelting(TFItems.meefRaw.cp, new wg(TFItems.meefSteak), 0.3f);
        GameRegistry.addShapelessRecipe(new wg(TFItems.moonwormQueen), new Object[] { new wg(TFItems.moonwormQueen, 1, -1), TFItems.torchberries, TFItems.torchberries, TFItems.torchberries });
        GameRegistry.addRecipe(new wg(TFItems.emptyMagicMap), new Object[] { "###", "#X#", "###", '#', we.aL, 'X', TFItems.magicMapFocus });
        GameRegistry.addShapelessRecipe(new wg(TFItems.charmOfKeeping2), new Object[] { TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1 });
        GameRegistry.addShapelessRecipe(new wg(TFItems.charmOfKeeping3), new Object[] { TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2 });
        GameRegistry.addShapelessRecipe(new wg(TFItems.charmOfLife2), new Object[] { TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1 });
        GameRegistry.addRecipe((yg)new TFMapCloningRecipe(TFItems.magicMap.cp, TFItems.emptyMagicMap.cp));
        GameRegistry.addRecipe((yg)new TFMapCloningRecipe(TFItems.mazeMap.cp, TFItems.emptyMazeMap.cp));
        GameRegistry.addRecipe((yg)new TFMapCloningRecipe(TFItems.oreMap.cp, TFItems.emptyOreMap.cp));
        GameRegistry.addRecipe(new wg(TFBlocks.towerWood, 4, 0), new Object[] { "##", "##", '#', new wg(TFBlocks.log, 1, 3) });
        GameRegistry.addRecipe(new wg(TFBlocks.towerWood, 3, 1), new Object[] { "#", "#", "#", '#', new wg(TFBlocks.towerWood, 1, 0) });
        GameRegistry.addRecipe(new wg(TFItems.carminite), new Object[] { "brb", "rgr", "brb", 'b', new wg(TFItems.borerEssence), 'r', new wg(we.aD), 'g', new wg(we.bq) });
        GameRegistry.addRecipe(new wg(TFItems.carminite), new Object[] { "rbr", "bgb", "rbr", 'b', new wg(TFItems.borerEssence), 'r', new wg(we.aD), 'g', new wg(we.bq) });
        GameRegistry.addRecipe(new wg(TFBlocks.towerDevice, 8, 2), new Object[] { "ewe", "wcw", "ewe", 'e', new wg(TFBlocks.towerWood, 1, 1), 'w', new wg(TFBlocks.towerWood, 1, 0), 'c', new wg(TFItems.carminite) });
        GameRegistry.addRecipe(new wg(TFBlocks.towerDevice, 2, 0), new Object[] { "ere", "rcr", "ere", 'e', new wg(TFBlocks.towerWood, 1, 1), 'r', new wg(we.aD), 'c', new wg(TFItems.carminite) });
        GameRegistry.addRecipe(new wg(TFBlocks.towerDevice, 1, 6), new Object[] { "ece", "cdc", "ece", 'e', new wg(TFBlocks.towerWood, 1, 1), 'd', new wg(aou.T), 'c', new wg(TFItems.carminite) });
        GameRegistry.addRecipe(new wg(TFBlocks.towerDevice, 1, 12), new Object[] { "ece", "coc", "ece", 'e', new wg(TFBlocks.towerWood, 1, 1), 'o', new wg(aou.aR), 'c', new wg(TFItems.carminite) });
    }
    
    public void addEnchantedRecipe(final we item, final yt enchantment, final int enchantmentLevel, final Object... ingredientArray) {
        final wg result = new wg(item);
        if (enchantment != null) {
            result.a(enchantment, enchantmentLevel);
        }
        GameRegistry.addRecipe(result, ingredientArray);
    }
}
