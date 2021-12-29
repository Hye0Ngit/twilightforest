// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item.recipe;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import twilightforest.enums.CompressedVariant;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFRecipes
{
    @SubscribeEvent
    public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
        OreDictionary.registerOre("logWood", new ItemStack(TFBlocks.twilight_log, 1, 32767));
        OreDictionary.registerOre("logWood", new ItemStack(TFBlocks.magic_log, 1, 32767));
        OreDictionary.registerOre("treeSapling", new ItemStack((Block)TFBlocks.twilight_sapling, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new ItemStack((Block)TFBlocks.twilight_leaves, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new ItemStack((Block)TFBlocks.magic_leaves, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new ItemStack((Block)TFBlocks.twilight_leaves_3, 1, 32767));
        OreDictionary.registerOre("treeLeaves", new ItemStack(TFBlocks.dark_leaves, 1, 32767));
        OreDictionary.registerOre("plankWood", new ItemStack(TFBlocks.tower_wood, 1, 32767));
        OreDictionary.registerOre("feather", new ItemStack(TFItems.raven_feather));
        OreDictionary.registerOre("ingotFiery", new ItemStack(TFItems.fiery_ingot));
        OreDictionary.registerOre("blockFiery", new ItemStack(TFBlocks.block_storage, 1, CompressedVariant.FIERY.ordinal()));
        OreDictionary.registerOre("oreIronwood", new ItemStack(TFItems.ironwood_raw));
        OreDictionary.registerOre("ingotIronwood", new ItemStack(TFItems.ironwood_ingot));
        OreDictionary.registerOre("ingotSteeleaf", new ItemStack(TFItems.steeleaf_ingot));
        OreDictionary.registerOre("blockSteeleaf", new ItemStack(TFBlocks.block_storage, 1, CompressedVariant.STEELLEAF.ordinal()));
        OreDictionary.registerOre("oreKnightmetal", new ItemStack(TFItems.armor_shard_cluster));
        OreDictionary.registerOre("ingotKnightmetal", new ItemStack(TFItems.knightmetal_ingot));
        OreDictionary.registerOre("blockKnightmetal", new ItemStack(TFBlocks.knightmetal_block));
        OreDictionary.registerOre("carminite", new ItemStack(TFItems.carminite));
        OreDictionary.registerOre("furArctic", new ItemStack(TFItems.arctic_fur));
        OreDictionary.registerOre("plankWood", new ItemStack((Block)TFBlocks.twilight_oak_planks));
        OreDictionary.registerOre("stairWood", new ItemStack((Block)TFBlocks.twilight_oak_stairs));
        OreDictionary.registerOre("slabWood", new ItemStack((Block)TFBlocks.twilight_oak_slab));
        OreDictionary.registerOre("fenceWood", new ItemStack((Block)TFBlocks.twilight_oak_fence));
        OreDictionary.registerOre("fenceGateWood", new ItemStack((Block)TFBlocks.twilight_oak_gate));
        OreDictionary.registerOre("plankWood", new ItemStack((Block)TFBlocks.canopy_planks));
        OreDictionary.registerOre("stairWood", new ItemStack((Block)TFBlocks.canopy_stairs));
        OreDictionary.registerOre("slabWood", new ItemStack((Block)TFBlocks.canopy_slab));
        OreDictionary.registerOre("fenceWood", new ItemStack((Block)TFBlocks.canopy_fence));
        OreDictionary.registerOre("fenceGateWood", new ItemStack((Block)TFBlocks.canopy_gate));
        OreDictionary.registerOre("plankWood", new ItemStack((Block)TFBlocks.mangrove_planks));
        OreDictionary.registerOre("stairWood", new ItemStack((Block)TFBlocks.mangrove_stairs));
        OreDictionary.registerOre("slabWood", new ItemStack((Block)TFBlocks.mangrove_slab));
        OreDictionary.registerOre("fenceWood", new ItemStack((Block)TFBlocks.mangrove_fence));
        OreDictionary.registerOre("fenceGateWood", new ItemStack((Block)TFBlocks.mangrove_gate));
        OreDictionary.registerOre("plankWood", new ItemStack((Block)TFBlocks.dark_planks));
        OreDictionary.registerOre("stairWood", new ItemStack((Block)TFBlocks.dark_stairs));
        OreDictionary.registerOre("slabWood", new ItemStack((Block)TFBlocks.dark_slab));
        OreDictionary.registerOre("fenceWood", new ItemStack((Block)TFBlocks.dark_fence));
        OreDictionary.registerOre("fenceGateWood", new ItemStack((Block)TFBlocks.dark_gate));
        OreDictionary.registerOre("plankWood", new ItemStack((Block)TFBlocks.time_planks));
        OreDictionary.registerOre("stairWood", new ItemStack((Block)TFBlocks.time_stairs));
        OreDictionary.registerOre("slabWood", new ItemStack((Block)TFBlocks.time_slab));
        OreDictionary.registerOre("fenceWood", new ItemStack((Block)TFBlocks.time_fence));
        OreDictionary.registerOre("fenceGateWood", new ItemStack((Block)TFBlocks.time_gate));
        OreDictionary.registerOre("plankWood", new ItemStack((Block)TFBlocks.trans_planks));
        OreDictionary.registerOre("stairWood", new ItemStack((Block)TFBlocks.trans_stairs));
        OreDictionary.registerOre("slabWood", new ItemStack((Block)TFBlocks.trans_slab));
        OreDictionary.registerOre("fenceWood", new ItemStack((Block)TFBlocks.trans_fence));
        OreDictionary.registerOre("fenceGateWood", new ItemStack((Block)TFBlocks.trans_gate));
        OreDictionary.registerOre("plankWood", new ItemStack((Block)TFBlocks.mine_planks));
        OreDictionary.registerOre("stairWood", new ItemStack((Block)TFBlocks.mine_stairs));
        OreDictionary.registerOre("slabWood", new ItemStack((Block)TFBlocks.mine_slab));
        OreDictionary.registerOre("fenceWood", new ItemStack((Block)TFBlocks.mine_fence));
        OreDictionary.registerOre("fenceGateWood", new ItemStack((Block)TFBlocks.mine_gate));
        OreDictionary.registerOre("plankWood", new ItemStack((Block)TFBlocks.sort_planks));
        OreDictionary.registerOre("stairWood", new ItemStack((Block)TFBlocks.sort_stairs));
        OreDictionary.registerOre("slabWood", new ItemStack((Block)TFBlocks.sort_slab));
        OreDictionary.registerOre("fenceWood", new ItemStack((Block)TFBlocks.sort_fence));
        OreDictionary.registerOre("fenceGateWood", new ItemStack((Block)TFBlocks.sort_gate));
        GameRegistry.addSmelting(TFBlocks.twilight_log, new ItemStack(Items.field_151044_h, 1, 1), 0.1f);
        GameRegistry.addSmelting(TFBlocks.magic_log, new ItemStack(Items.field_151044_h, 1, 1), 0.1f);
        GameRegistry.addSmelting(TFItems.ironwood_raw, new ItemStack(TFItems.ironwood_ingot, 2), 1.0f);
        GameRegistry.addSmelting(TFItems.raw_venison, new ItemStack(TFItems.cooked_venison), 0.3f);
        GameRegistry.addSmelting(TFItems.raw_meef, new ItemStack(TFItems.cooked_meef), 0.3f);
        GameRegistry.addSmelting(TFItems.armor_shard_cluster, new ItemStack(TFItems.knightmetal_ingot), 1.0f);
        event.getRegistry().register(new TFArmorDyeingRecipe().setRegistryName("twilightforest", "arctic_armor_dyeing"));
        event.getRegistry().register(new TFMapCloningRecipe(TFItems.magic_map, TFItems.magic_map_empty).setRegistryName("twilightforest", "magic_map_cloning"));
        event.getRegistry().register(new TFMapCloningRecipe(TFItems.maze_map, TFItems.maze_map_empty).setRegistryName("twilightforest", "maze_map_cloning"));
        event.getRegistry().register(new TFMapCloningRecipe(TFItems.ore_map, TFItems.ore_map_empty).setRegistryName("twilightforest", "ore_map_cloning"));
    }
}
