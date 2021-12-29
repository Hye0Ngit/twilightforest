// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TFEnchantment;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import twilightforest.block.TFBlocks;

public class TFRecipes
{
    public TFRecipes() {
        OreDictionary.registerOre("woodLog", new yd(TFBlocks.log, 1, 32767));
        OreDictionary.registerOre("woodLog", new yd(TFBlocks.magicLog, 1, 32767));
        OreDictionary.registerOre("treeSapling", new yd(TFBlocks.sapling, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new yd(TFBlocks.leaves, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new yd(TFBlocks.magicLeaves, 1, 32767));
        OreDictionary.registerOre("plankWood", new yd(TFBlocks.towerWood, 1, 32767));
        GameRegistry.addRecipe(new yd(aqw.C, 4, 0), new Object[] { "w", 'w', new yd(TFBlocks.log, 1, 0) });
        GameRegistry.addRecipe(new yd(aqw.C, 4, 1), new Object[] { "w", 'w', new yd(TFBlocks.log, 1, 1) });
        GameRegistry.addRecipe(new yd(aqw.C, 4, 2), new Object[] { "w", 'w', new yd(TFBlocks.log, 1, 2) });
        GameRegistry.addRecipe(new yd(aqw.C, 4, 1), new Object[] { "w", 'w', new yd(TFBlocks.log, 1, 3) });
        GameRegistry.addSmelting(TFBlocks.log.cF, new yd(yb.o, 1, 1), 0.1f);
        this.addEnchantedRecipe(TFItems.plateNaga, aat.e, 3, "# #", "###", "###", '#', TFItems.nagaScale);
        this.addEnchantedRecipe(TFItems.legsNaga, aat.d, 3, "###", "# #", "# #", '#', TFItems.nagaScale);
        GameRegistry.addShapelessRecipe(new yd(TFBlocks.fireflyJar, 1, 0), new Object[] { TFBlocks.firefly, yb.bv });
        GameRegistry.addShapelessRecipe(new yd(TFItems.scepterTwilight), new Object[] { new yd(TFItems.scepterTwilight, 1, TFItems.scepterTwilight.o()), yb.bp });
        GameRegistry.addShapelessRecipe(new yd(TFItems.scepterLifeDrain), new Object[] { new yd(TFItems.scepterLifeDrain, 1, TFItems.scepterLifeDrain.o()), yb.bx });
        GameRegistry.addShapelessRecipe(new yd(TFItems.scepterZombie), new Object[] { new yd(TFItems.scepterZombie, 1, TFItems.scepterZombie.o()), new yd(yb.bo), new yd((yb)yb.bu, 1, 16281) });
        GameRegistry.addShapelessRecipe(new yd(TFItems.scepterZombie), new Object[] { new yd(TFItems.scepterZombie, 1, TFItems.scepterZombie.o()), new yd(yb.bo), new yd((yb)yb.bu, 1, 16313) });
        GameRegistry.addShapelessRecipe(new yd(TFItems.scepterZombie), new Object[] { new yd(TFItems.scepterZombie, 1, TFItems.scepterZombie.o()), new yd(yb.bo), new yd((yb)yb.bu, 1, 16345) });
        GameRegistry.addShapelessRecipe(new yd(TFItems.scepterZombie), new Object[] { new yd(TFItems.scepterZombie, 1, TFItems.scepterZombie.o()), new yd(yb.bo), new yd((yb)yb.bu, 1, 16377) });
        GameRegistry.addShapelessRecipe(new yd(TFItems.scepterZombie), new Object[] { new yd(TFItems.scepterZombie, 1, TFItems.scepterZombie.o()), new yd(yb.bo), new yd((yb)yb.bu, 1, 8201) });
        GameRegistry.addShapelessRecipe(new yd(TFItems.scepterZombie), new Object[] { new yd(TFItems.scepterZombie, 1, TFItems.scepterZombie.o()), new yd(yb.bo), new yd((yb)yb.bu, 1, 8265) });
        GameRegistry.addShapelessRecipe(new yd(TFItems.scepterZombie), new Object[] { new yd(TFItems.scepterZombie, 1, TFItems.scepterZombie.o()), new yd(yb.bo), new yd((yb)yb.bu, 1, 8233) });
        GameRegistry.addShapelessRecipe(new yd(TFItems.magicMapFocus), new Object[] { TFItems.feather, TFItems.torchberries, yb.aV });
        GameRegistry.addRecipe(new yd(TFItems.emptyMagicMap), new Object[] { "###", "#X#", "###", '#', yb.aM, 'X', TFItems.magicMapFocus });
        GameRegistry.addRecipe(new yd(TFItems.emptyMazeMap), new Object[] { "###", "#X#", "###", '#', yb.aM, 'X', TFItems.mazeMapFocus });
        GameRegistry.addShapelessRecipe(new yd(TFItems.emptyOreMap), new Object[] { new yd(TFItems.mazeMap, 1, 32767), aqw.am, aqw.aC, aqw.an });
        GameRegistry.addShapelessRecipe(new yd(TFItems.emptyOreMap), new Object[] { new yd(TFItems.emptyMazeMap, 1, 32767), aqw.am, aqw.aC, aqw.an });
        GameRegistry.addRecipe(new yd(yb.n, 4), new Object[] { "X", "#", "Y", 'Y', TFItems.feather, 'X', yb.ar, '#', yb.F });
        GameRegistry.addShapelessRecipe(new yd(yb.F), new Object[] { new yd(TFBlocks.plant, 1, 14) });
        GameRegistry.addRecipe(new yd(aqw.av, 5), new Object[] { "B", "S", 'B', TFItems.torchberries, 'S', yb.F });
        GameRegistry.addShapelessRecipe(new yd(TFItems.ironwoodRaw), new Object[] { TFItems.liveRoot, yb.q, yb.bs });
        GameRegistry.addSmelting(TFItems.ironwoodRaw.cv, new yd(TFItems.ironwoodIngot, 2), 1.0f);
        this.addEnchantedRecipe(TFItems.ironwoodHelm, aat.j, 1, "###", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodPlate, aat.d, 1, "# #", "###", "###", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodLegs, aat.d, 1, "###", "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodBoots, aat.f, 1, "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodSword, aat.o, 1, "#", "#", "X", '#', TFItems.ironwoodIngot, 'X', yb.F);
        this.addEnchantedRecipe(TFItems.ironwoodShovel, aat.t, 1, "#", "X", "X", '#', TFItems.ironwoodIngot, 'X', yb.F);
        this.addEnchantedRecipe(TFItems.ironwoodPick, aat.r, 1, "###", " X ", " X ", '#', TFItems.ironwoodIngot, 'X', yb.F);
        this.addEnchantedRecipe(TFItems.ironwoodAxe, aat.u, 1, "##", "#X", " X", '#', TFItems.ironwoodIngot, 'X', yb.F);
        this.addEnchantedRecipe(TFItems.ironwoodHoe, null, 0, "##", " X", " X", '#', TFItems.ironwoodIngot, 'X', yb.F);
        GameRegistry.addRecipe(new yd(TFBlocks.uncraftingTable), new Object[] { "###", "#X#", "###", '#', aqw.aD, 'X', TFItems.mazeMapFocus });
        GameRegistry.addSmelting(TFItems.venisonRaw.cv, new yd(TFItems.venisonCooked), 0.3f);
        GameRegistry.addShapelessRecipe(new yd(TFItems.fieryIngot), new Object[] { TFItems.fieryBlood, yb.q });
        this.addEnchantedRecipe(TFItems.fieryHelm, TFEnchantment.reactFire, 2, "###", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryPlate, TFEnchantment.reactFire, 2, "# #", "###", "###", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryLegs, TFEnchantment.reactFire, 2, "###", "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryBoots, TFEnchantment.reactFire, 2, "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fierySword, aat.p, 2, "#", "#", "X", '#', TFItems.fieryIngot, 'X', yb.bq);
        GameRegistry.addRecipe(new yd(TFItems.fieryPick), new Object[] { "###", " X ", " X ", '#', TFItems.fieryIngot, 'X', yb.bq });
        this.addEnchantedRecipe(TFItems.steeleafHelm, aat.h, 2, "###", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafPlate, aat.g, 2, "# #", "###", "###", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafLegs, aat.e, 2, "###", "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafBoots, aat.f, 2, "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafSword, aat.q, 2, "#", "#", "X", '#', TFItems.steeleafIngot, 'X', yb.F);
        this.addEnchantedRecipe(TFItems.steeleafShovel, aat.r, 2, "#", "X", "X", '#', TFItems.steeleafIngot, 'X', yb.F);
        this.addEnchantedRecipe(TFItems.steeleafPick, aat.u, 2, "###", " X ", " X ", '#', TFItems.steeleafIngot, 'X', yb.F);
        this.addEnchantedRecipe(TFItems.steeleafAxe, aat.r, 2, "##", "#X", " X", '#', TFItems.steeleafIngot, 'X', yb.F);
        this.addEnchantedRecipe(TFItems.steeleafHoe, null, 0, "##", " X", " X", '#', TFItems.steeleafIngot, 'X', yb.F);
        GameRegistry.addSmelting(TFItems.meefRaw.cv, new yd(TFItems.meefSteak), 0.3f);
        GameRegistry.addShapelessRecipe(new yd(TFItems.moonwormQueen), new Object[] { new yd(TFItems.moonwormQueen, 1, 32767), TFItems.torchberries, TFItems.torchberries, TFItems.torchberries });
        GameRegistry.addRecipe(new yd(TFItems.emptyMagicMap), new Object[] { "###", "#X#", "###", '#', yb.aM, 'X', TFItems.magicMapFocus });
        GameRegistry.addShapelessRecipe(new yd(TFItems.charmOfKeeping2), new Object[] { TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1 });
        GameRegistry.addShapelessRecipe(new yd(TFItems.charmOfKeeping3), new Object[] { TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2 });
        GameRegistry.addShapelessRecipe(new yd(TFItems.charmOfLife2), new Object[] { TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1 });
        GameRegistry.addRecipe((aag)new TFMapCloningRecipe(TFItems.magicMap.cv, TFItems.emptyMagicMap.cv));
        GameRegistry.addRecipe((aag)new TFMapCloningRecipe(TFItems.mazeMap.cv, TFItems.emptyMazeMap.cv));
        GameRegistry.addRecipe((aag)new TFMapCloningRecipe(TFItems.oreMap.cv, TFItems.emptyOreMap.cv));
        GameRegistry.addRecipe(new yd(TFBlocks.towerWood, 4, 0), new Object[] { "##", "##", '#', new yd(TFBlocks.log, 1, 3) });
        GameRegistry.addRecipe(new yd(TFBlocks.towerWood, 3, 1), new Object[] { "#", "#", "#", '#', new yd(TFBlocks.towerWood, 1, 0) });
        GameRegistry.addRecipe(new yd(TFItems.carminite), new Object[] { "brb", "rgr", "brb", 'b', new yd(TFItems.borerEssence), 'r', new yd(yb.aE), 'g', new yd(yb.br) });
        GameRegistry.addRecipe(new yd(TFItems.carminite), new Object[] { "rbr", "bgb", "rbr", 'b', new yd(TFItems.borerEssence), 'r', new yd(yb.aE), 'g', new yd(yb.br) });
        GameRegistry.addRecipe(new yd(TFBlocks.towerDevice, 8, 2), new Object[] { "ewe", "wcw", "ewe", 'e', new yd(TFBlocks.towerWood, 1, 1), 'w', new yd(TFBlocks.towerWood, 1, 0), 'c', new yd(TFItems.carminite) });
        GameRegistry.addRecipe(new yd(TFBlocks.towerDevice, 2, 0), new Object[] { "ere", "rcr", "ere", 'e', new yd(TFBlocks.towerWood, 1, 1), 'r', new yd(yb.aE), 'c', new yd(TFItems.carminite) });
        GameRegistry.addRecipe(new yd(TFBlocks.towerDevice, 1, 6), new Object[] { "ece", "cdc", "ece", 'e', new yd(TFBlocks.towerWood, 1, 1), 'd', new yd(aqw.U), 'c', new yd(TFItems.carminite) });
        GameRegistry.addRecipe(new yd(TFBlocks.towerDevice, 1, 12), new Object[] { "ece", "coc", "ece", 'e', new yd(TFBlocks.towerWood, 1, 1), 'o', new yd(aqw.aS), 'c', new yd(TFItems.carminite) });
        GameRegistry.addRecipe(new yd(TFBlocks.fireJet, 1, 1), new Object[] { "ere", "rsr", "ere", 'e', new yd(TFBlocks.towerWood, 1, 1), 'r', new yd(yb.aE), 's', new yd(TFBlocks.fireJet, 1, 0) });
        GameRegistry.addRecipe(new yd(TFBlocks.fireJet, 1, 11), new Object[] { "ere", "rjr", "lll", 'e', new yd(TFBlocks.towerWood, 1, 1), 'r', new yd(yb.aE), 'l', new yd(yb.aA), 'j', new yd(TFBlocks.fireJet, 1, 8) });
        GameRegistry.addRecipe(new yd(TFItems.shardCluster), new Object[] { "###", "###", "###", '#', TFItems.armorShard });
        GameRegistry.addSmelting(TFItems.shardCluster.cv, new yd(TFItems.knightMetal), 1.0f);
        GameRegistry.addRecipe(new yd(TFItems.knightlyHelm), new Object[] { "###", "# #", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new yd(TFItems.knightlyPlate), new Object[] { "# #", "###", "###", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new yd(TFItems.knightlyLegs), new Object[] { "###", "# #", "# #", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new yd(TFItems.knightlyBoots), new Object[] { "# #", "# #", '#', TFItems.knightMetal });
        GameRegistry.addRecipe(new yd(TFItems.knightlySword), new Object[] { "#", "#", "X", '#', TFItems.knightMetal, 'X', yb.F });
        GameRegistry.addRecipe(new yd(TFItems.knightlyPick), new Object[] { "###", " X ", " X ", '#', TFItems.knightMetal, 'X', yb.F });
        GameRegistry.addRecipe(new yd(TFItems.knightlyAxe), new Object[] { "##", "#X", " X", '#', TFItems.knightMetal, 'X', yb.F });
        GameRegistry.addRecipe(new yd(TFItems.knightlyAxe), new Object[] { "##", "X#", "X ", '#', TFItems.knightMetal, 'X', yb.F });
    }
    
    public void addEnchantedRecipe(final yb item, final aat enchantment, final int enchantmentLevel, final Object... ingredientArray) {
        final yd result = new yd(item);
        if (enchantment != null) {
            result.a(enchantment, enchantmentLevel);
        }
        GameRegistry.addRecipe(result, ingredientArray);
    }
}
