// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.registry.GameRegistry;

public class TFRecipes
{
    public TFRecipes() {
        GameRegistry.addRecipe(new um(amj.A, 4, 0), new Object[] { "w", 'w', new um(TFBlocks.log, 1, 0) });
        GameRegistry.addRecipe(new um(amj.A, 4, 1), new Object[] { "w", 'w', new um(TFBlocks.log, 1, 1) });
        GameRegistry.addRecipe(new um(amj.A, 4, 2), new Object[] { "w", 'w', new um(TFBlocks.log, 1, 2) });
        GameRegistry.addRecipe(new um(amj.A, 4, 1), new Object[] { "w", 'w', new um(TFBlocks.log, 1, 3) });
        GameRegistry.addSmelting(TFBlocks.log.cm, new um(uk.m, 1, 1), 0.1f);
        this.addEnchantedRecipe(TFItems.plateNaga, ww.d, 3, "# #", "###", "###", '#', TFItems.nagaScale);
        this.addEnchantedRecipe(TFItems.legsNaga, ww.c, 3, "###", "# #", "# #", '#', TFItems.nagaScale);
        GameRegistry.addShapelessRecipe(new um(TFBlocks.fireflyJar, 1, 0), new Object[] { TFBlocks.firefly, uk.bt });
        GameRegistry.addShapelessRecipe(new um(TFItems.scepterTwilight), new Object[] { new um(TFItems.scepterTwilight, 1, TFItems.scepterTwilight.m()), uk.bn });
        GameRegistry.addShapelessRecipe(new um(TFItems.scepterLifeDrain), new Object[] { new um(TFItems.scepterLifeDrain, 1, TFItems.scepterLifeDrain.m()), uk.bv });
        GameRegistry.addShapelessRecipe(new um(TFItems.scepterZombie), new Object[] { new um(TFItems.scepterZombie, 1, TFItems.scepterZombie.m()), new um(uk.bm), new um((uk)uk.bs, 1, 16281) });
        GameRegistry.addShapelessRecipe(new um(TFItems.scepterZombie), new Object[] { new um(TFItems.scepterZombie, 1, TFItems.scepterZombie.m()), new um(uk.bm), new um((uk)uk.bs, 1, 16313) });
        GameRegistry.addShapelessRecipe(new um(TFItems.scepterZombie), new Object[] { new um(TFItems.scepterZombie, 1, TFItems.scepterZombie.m()), new um(uk.bm), new um((uk)uk.bs, 1, 16345) });
        GameRegistry.addShapelessRecipe(new um(TFItems.scepterZombie), new Object[] { new um(TFItems.scepterZombie, 1, TFItems.scepterZombie.m()), new um(uk.bm), new um((uk)uk.bs, 1, 16377) });
        GameRegistry.addShapelessRecipe(new um(TFItems.magicMapFocus), new Object[] { TFItems.feather, TFItems.torchberries, uk.aT });
        GameRegistry.addRecipe(new um(TFItems.emptyMagicMap, 1), new Object[] { "###", "#X#", "###", '#', uk.aK, 'X', TFItems.magicMapFocus });
        GameRegistry.addRecipe(new um(TFItems.emptyMazeMap, 1), new Object[] { "###", "#X#", "###", '#', uk.aK, 'X', TFItems.mazeMapFocus });
        GameRegistry.addShapelessRecipe(new um(TFItems.emptyOreMap), new Object[] { new um(TFItems.mazeMap, 1, -1), amj.ak, amj.aA, amj.al });
        GameRegistry.addRecipe(new um(uk.l, 4), new Object[] { "X", "#", "Y", 'Y', TFItems.feather, 'X', uk.ap, '#', uk.D });
        GameRegistry.addShapelessRecipe(new um(uk.D, 1), new Object[] { new um(TFBlocks.plant, 1, 14) });
        GameRegistry.addRecipe(new um(amj.at, 5), new Object[] { "B", "S", 'B', TFItems.torchberries, 'S', uk.D });
        GameRegistry.addShapelessRecipe(new um(TFItems.ironwoodRaw), new Object[] { TFItems.liveRoot, uk.o, uk.bq });
        GameRegistry.addSmelting(TFItems.ironwoodRaw.cg, new um(TFItems.ironwoodIngot, 2), 1.0f);
        this.addEnchantedRecipe(TFItems.ironwoodHelm, ww.i, 1, "###", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodPlate, ww.c, 1, "# #", "###", "###", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodLegs, ww.c, 1, "###", "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodBoots, ww.e, 1, "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodSword, ww.m, 1, "#", "#", "X", '#', TFItems.ironwoodIngot, 'X', uk.D);
        this.addEnchantedRecipe(TFItems.ironwoodShovel, ww.r, 1, "#", "X", "X", '#', TFItems.ironwoodIngot, 'X', uk.D);
        this.addEnchantedRecipe(TFItems.ironwoodPick, ww.p, 1, "###", " X ", " X ", '#', TFItems.ironwoodIngot, 'X', uk.D);
        this.addEnchantedRecipe(TFItems.ironwoodAxe, ww.s, 1, "##", "#X", " X", '#', TFItems.ironwoodIngot, 'X', uk.D);
        this.addEnchantedRecipe(TFItems.ironwoodHoe, null, 0, "##", " X", " X", '#', TFItems.ironwoodIngot, 'X', uk.D);
        GameRegistry.addRecipe(new um(TFBlocks.uncraftingTable, 1, 1), new Object[] { "###", "#X#", "###", '#', amj.aB, 'X', TFItems.mazeMapFocus });
        GameRegistry.addSmelting(TFItems.venisonRaw.cg, new um(TFItems.venisonCooked), 0.3f);
        GameRegistry.addShapelessRecipe(new um(TFItems.fieryIngot), new Object[] { TFItems.fieryBlood, uk.o });
        this.addEnchantedRecipe(TFItems.fieryHelm, TFEnchantment.reactFire, 2, "###", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryPlate, TFEnchantment.reactFire, 2, "# #", "###", "###", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryLegs, TFEnchantment.reactFire, 2, "###", "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryBoots, TFEnchantment.reactFire, 2, "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fierySword, ww.n, 2, "#", "#", "X", '#', TFItems.fieryIngot, 'X', uk.bo);
        GameRegistry.addRecipe(new um(TFItems.fieryPick, 1), new Object[] { "###", " X ", " X ", '#', TFItems.fieryIngot, 'X', uk.bo });
        this.addEnchantedRecipe(TFItems.steeleafHelm, ww.g, 2, "###", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafPlate, ww.f, 2, "# #", "###", "###", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafLegs, ww.d, 2, "###", "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafBoots, ww.e, 2, "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafSword, ww.o, 2, "#", "#", "X", '#', TFItems.steeleafIngot, 'X', uk.D);
        this.addEnchantedRecipe(TFItems.steeleafShovel, ww.p, 2, "#", "X", "X", '#', TFItems.steeleafIngot, 'X', uk.D);
        this.addEnchantedRecipe(TFItems.steeleafPick, ww.s, 2, "###", " X ", " X ", '#', TFItems.steeleafIngot, 'X', uk.D);
        this.addEnchantedRecipe(TFItems.steeleafAxe, ww.p, 2, "##", "#X", " X", '#', TFItems.steeleafIngot, 'X', uk.D);
        this.addEnchantedRecipe(TFItems.steeleafHoe, null, 0, "##", " X", " X", '#', TFItems.steeleafIngot, 'X', uk.D);
        GameRegistry.addSmelting(TFItems.meefRaw.cg, new um(TFItems.meefSteak), 0.3f);
        GameRegistry.addShapelessRecipe(new um(TFItems.moonwormQueen), new Object[] { new um(TFItems.moonwormQueen, 1, TFItems.moonwormQueen.m()), TFItems.torchberries, TFItems.torchberries, TFItems.torchberries });
        GameRegistry.addRecipe(new um(TFItems.emptyMagicMap, 1), new Object[] { "###", "#X#", "###", '#', uk.aK, 'X', TFItems.magicMapFocus });
        GameRegistry.addShapelessRecipe(new um(TFItems.charmOfKeeping2), new Object[] { TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1 });
        GameRegistry.addShapelessRecipe(new um(TFItems.charmOfKeeping3), new Object[] { TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2 });
        GameRegistry.addShapelessRecipe(new um(TFItems.charmOfLife2), new Object[] { TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1 });
        GameRegistry.addRecipe((wj)new TFMapCloningRecipe(TFItems.magicMap.cg, TFItems.emptyMagicMap.cg));
        GameRegistry.addRecipe((wj)new TFMapCloningRecipe(TFItems.mazeMap.cg, TFItems.emptyMazeMap.cg));
        GameRegistry.addRecipe((wj)new TFMapCloningRecipe(TFItems.oreMap.cg, TFItems.emptyOreMap.cg));
    }
    
    public void addEnchantedRecipe(final uk item, final ww enchantment, final int enchantmentLevel, final Object... ingredientArray) {
        final um result = new um(item);
        if (enchantment != null) {
            result.a(enchantment, enchantmentLevel);
        }
        GameRegistry.addRecipe(result, ingredientArray);
    }
}
