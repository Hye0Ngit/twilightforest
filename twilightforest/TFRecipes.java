// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.item.TFItems;
import cpw.mods.fml.common.registry.GameRegistry;
import twilightforest.block.TFBlocks;

public class TFRecipes
{
    public TFRecipes() {
        GameRegistry.addRecipe(new ur(amq.A, 4, 0), new Object[] { "w", 'w', new ur(TFBlocks.log, 1, 0) });
        GameRegistry.addRecipe(new ur(amq.A, 4, 1), new Object[] { "w", 'w', new ur(TFBlocks.log, 1, 1) });
        GameRegistry.addRecipe(new ur(amq.A, 4, 2), new Object[] { "w", 'w', new ur(TFBlocks.log, 1, 2) });
        GameRegistry.addRecipe(new ur(amq.A, 4, 1), new Object[] { "w", 'w', new ur(TFBlocks.log, 1, 3) });
        GameRegistry.addSmelting(TFBlocks.log.cm, new ur(up.m, 1, 1), 0.1f);
        this.addEnchantedRecipe(TFItems.plateNaga, xc.e, 3, "# #", "###", "###", '#', TFItems.nagaScale);
        this.addEnchantedRecipe(TFItems.legsNaga, xc.d, 3, "###", "# #", "# #", '#', TFItems.nagaScale);
        GameRegistry.addShapelessRecipe(new ur(TFBlocks.fireflyJar, 1, 0), new Object[] { TFBlocks.firefly, up.bt });
        GameRegistry.addShapelessRecipe(new ur(TFItems.scepterTwilight), new Object[] { new ur(TFItems.scepterTwilight, 1, TFItems.scepterTwilight.m()), up.bn });
        GameRegistry.addShapelessRecipe(new ur(TFItems.scepterLifeDrain), new Object[] { new ur(TFItems.scepterLifeDrain, 1, TFItems.scepterLifeDrain.m()), up.bv });
        GameRegistry.addShapelessRecipe(new ur(TFItems.scepterZombie), new Object[] { new ur(TFItems.scepterZombie, 1, TFItems.scepterZombie.m()), new ur(up.bm), new ur((up)up.bs, 1, 16281) });
        GameRegistry.addShapelessRecipe(new ur(TFItems.scepterZombie), new Object[] { new ur(TFItems.scepterZombie, 1, TFItems.scepterZombie.m()), new ur(up.bm), new ur((up)up.bs, 1, 16313) });
        GameRegistry.addShapelessRecipe(new ur(TFItems.scepterZombie), new Object[] { new ur(TFItems.scepterZombie, 1, TFItems.scepterZombie.m()), new ur(up.bm), new ur((up)up.bs, 1, 16345) });
        GameRegistry.addShapelessRecipe(new ur(TFItems.scepterZombie), new Object[] { new ur(TFItems.scepterZombie, 1, TFItems.scepterZombie.m()), new ur(up.bm), new ur((up)up.bs, 1, 16377) });
        GameRegistry.addShapelessRecipe(new ur(TFItems.magicMapFocus), new Object[] { TFItems.feather, TFItems.torchberries, up.aT });
        GameRegistry.addRecipe(new ur(TFItems.emptyMagicMap, 1), new Object[] { "###", "#X#", "###", '#', up.aK, 'X', TFItems.magicMapFocus });
        GameRegistry.addRecipe(new ur(TFItems.emptyMazeMap, 1), new Object[] { "###", "#X#", "###", '#', up.aK, 'X', TFItems.mazeMapFocus });
        GameRegistry.addShapelessRecipe(new ur(TFItems.emptyOreMap), new Object[] { new ur(TFItems.mazeMap, 1, -1), amq.ak, amq.aA, amq.al });
        GameRegistry.addRecipe(new ur(up.l, 4), new Object[] { "X", "#", "Y", 'Y', TFItems.feather, 'X', up.ap, '#', up.D });
        GameRegistry.addShapelessRecipe(new ur(up.D, 1), new Object[] { new ur(TFBlocks.plant, 1, 14) });
        GameRegistry.addRecipe(new ur(amq.at, 5), new Object[] { "B", "S", 'B', TFItems.torchberries, 'S', up.D });
        GameRegistry.addShapelessRecipe(new ur(TFItems.ironwoodRaw), new Object[] { TFItems.liveRoot, up.o, up.bq });
        GameRegistry.addSmelting(TFItems.ironwoodRaw.cj, new ur(TFItems.ironwoodIngot, 2), 1.0f);
        this.addEnchantedRecipe(TFItems.ironwoodHelm, xc.j, 1, "###", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodPlate, xc.d, 1, "# #", "###", "###", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodLegs, xc.d, 1, "###", "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodBoots, xc.f, 1, "# #", "# #", '#', TFItems.ironwoodIngot);
        this.addEnchantedRecipe(TFItems.ironwoodSword, xc.o, 1, "#", "#", "X", '#', TFItems.ironwoodIngot, 'X', up.D);
        this.addEnchantedRecipe(TFItems.ironwoodShovel, xc.t, 1, "#", "X", "X", '#', TFItems.ironwoodIngot, 'X', up.D);
        this.addEnchantedRecipe(TFItems.ironwoodPick, xc.r, 1, "###", " X ", " X ", '#', TFItems.ironwoodIngot, 'X', up.D);
        this.addEnchantedRecipe(TFItems.ironwoodAxe, xc.u, 1, "##", "#X", " X", '#', TFItems.ironwoodIngot, 'X', up.D);
        this.addEnchantedRecipe(TFItems.ironwoodHoe, null, 0, "##", " X", " X", '#', TFItems.ironwoodIngot, 'X', up.D);
        GameRegistry.addRecipe(new ur(TFBlocks.uncraftingTable, 1, 1), new Object[] { "###", "#X#", "###", '#', amq.aB, 'X', TFItems.mazeMapFocus });
        GameRegistry.addSmelting(TFItems.venisonRaw.cj, new ur(TFItems.venisonCooked), 0.3f);
        GameRegistry.addShapelessRecipe(new ur(TFItems.fieryIngot), new Object[] { TFItems.fieryBlood, up.o });
        this.addEnchantedRecipe(TFItems.fieryHelm, TFEnchantment.reactFire, 2, "###", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryPlate, TFEnchantment.reactFire, 2, "# #", "###", "###", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryLegs, TFEnchantment.reactFire, 2, "###", "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fieryBoots, TFEnchantment.reactFire, 2, "# #", "# #", '#', TFItems.fieryIngot);
        this.addEnchantedRecipe(TFItems.fierySword, xc.p, 2, "#", "#", "X", '#', TFItems.fieryIngot, 'X', up.bo);
        GameRegistry.addRecipe(new ur(TFItems.fieryPick, 1), new Object[] { "###", " X ", " X ", '#', TFItems.fieryIngot, 'X', up.bo });
        this.addEnchantedRecipe(TFItems.steeleafHelm, xc.h, 2, "###", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafPlate, xc.g, 2, "# #", "###", "###", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafLegs, xc.e, 2, "###", "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafBoots, xc.f, 2, "# #", "# #", '#', TFItems.steeleafIngot);
        this.addEnchantedRecipe(TFItems.steeleafSword, xc.q, 2, "#", "#", "X", '#', TFItems.steeleafIngot, 'X', up.D);
        this.addEnchantedRecipe(TFItems.steeleafShovel, xc.r, 2, "#", "X", "X", '#', TFItems.steeleafIngot, 'X', up.D);
        this.addEnchantedRecipe(TFItems.steeleafPick, xc.u, 2, "###", " X ", " X ", '#', TFItems.steeleafIngot, 'X', up.D);
        this.addEnchantedRecipe(TFItems.steeleafAxe, xc.r, 2, "##", "#X", " X", '#', TFItems.steeleafIngot, 'X', up.D);
        this.addEnchantedRecipe(TFItems.steeleafHoe, null, 0, "##", " X", " X", '#', TFItems.steeleafIngot, 'X', up.D);
        GameRegistry.addSmelting(TFItems.meefRaw.cj, new ur(TFItems.meefSteak), 0.3f);
        GameRegistry.addShapelessRecipe(new ur(TFItems.moonwormQueen), new Object[] { new ur(TFItems.moonwormQueen, 1, TFItems.moonwormQueen.m()), TFItems.torchberries, TFItems.torchberries, TFItems.torchberries });
        GameRegistry.addRecipe(new ur(TFItems.emptyMagicMap, 1), new Object[] { "###", "#X#", "###", '#', up.aK, 'X', TFItems.magicMapFocus });
        GameRegistry.addShapelessRecipe(new ur(TFItems.charmOfKeeping2), new Object[] { TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1, TFItems.charmOfKeeping1 });
        GameRegistry.addShapelessRecipe(new ur(TFItems.charmOfKeeping3), new Object[] { TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2, TFItems.charmOfKeeping2 });
        GameRegistry.addShapelessRecipe(new ur(TFItems.charmOfLife2), new Object[] { TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1, TFItems.charmOfLife1 });
        GameRegistry.addRecipe((wp)new TFMapCloningRecipe(TFItems.magicMap.cj, TFItems.emptyMagicMap.cj));
        GameRegistry.addRecipe((wp)new TFMapCloningRecipe(TFItems.mazeMap.cj, TFItems.emptyMazeMap.cj));
        GameRegistry.addRecipe((wp)new TFMapCloningRecipe(TFItems.oreMap.cj, TFItems.emptyOreMap.cj));
    }
    
    public void addEnchantedRecipe(final up item, final xc enchantment, final int enchantmentLevel, final Object... ingredientArray) {
        final ur result = new ur(item);
        if (enchantment != null) {
            result.a(enchantment, enchantmentLevel);
        }
        GameRegistry.addRecipe(result, ingredientArray);
    }
}
