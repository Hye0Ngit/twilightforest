// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.SmithingRecipeBuilder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.crafting.conditions.ICondition;
import twilightforest.item.recipe.UncraftingEnabledCondition;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import twilightforest.item.TFItems;
import twilightforest.TwilightForestMod;
import net.minecraft.item.Items;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraft.block.Blocks;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.util.IItemProvider;
import net.minecraft.block.Block;
import java.util.function.Supplier;
import twilightforest.block.TFBlocks;
import net.minecraft.data.IFinishedRecipe;
import java.util.function.Consumer;
import java.nio.file.Path;
import com.google.gson.JsonObject;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.DataGenerator;

public class CraftingGenerator extends CraftingDataHelper
{
    public CraftingGenerator(final DataGenerator generator) {
        super(generator);
    }
    
    protected void func_208310_b(final DirectoryCache p_208310_1_, final JsonObject p_208310_2_, final Path p_208310_3_) {
    }
    
    protected void func_200404_a(final Consumer<IFinishedRecipe> consumer) {
        this.blockCompressionRecipes(consumer);
        this.equipmentRecipes(consumer);
        this.emptyMapRecipes(consumer);
        this.woodRecipes(consumer);
        this.fieryConversions(consumer);
        this.nagastoneRecipes(consumer);
        this.darkTowerRecipes(consumer);
        this.castleRecipes(consumer);
        this.slabBlock(consumer, "aurora_slab", (Supplier<? extends Block>)TFBlocks.aurora_slab, (Supplier<? extends Block>)TFBlocks.aurora_block);
        ShapedRecipeBuilder.func_200468_a((IItemProvider)TFBlocks.aurora_pillar.get(), 2).func_200472_a("#").func_200472_a("#").func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.aurora_block.get() })).func_200465_a("has_" + TFBlocks.aurora_pillar.getId().func_110623_a(), (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.aurora_pillar.get())).func_200464_a((Consumer)consumer);
        ShapedRecipeBuilder.func_200468_a((IItemProvider)TFBlocks.iron_ladder.get(), 3).func_200472_a("-#-").func_200472_a("-#-").func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_150411_aY })).func_200469_a(Character.valueOf('-'), (ITag)Tags.Items.NUGGETS_IRON).func_200465_a("has_" + TFBlocks.iron_ladder.getId().func_110623_a(), (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.iron_ladder.get())).func_200464_a((Consumer)consumer);
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFBlocks.firefly_jar.get()).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.firefly.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151069_bo })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.firefly.get())).func_200482_a((Consumer)consumer);
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFBlocks.cicada_jar.get()).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.cicada.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151069_bo })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.cicada.get())).func_200482_a((Consumer)consumer);
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)Items.field_151055_y).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.root_strand.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.root_strand.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix("root_stick"));
        ShapedRecipeBuilder.func_200468_a((IItemProvider)Blocks.field_150478_aa, 5).func_200472_a("\u2234").func_200472_a("|").func_200471_a(Character.valueOf('\u2234'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.torchberries.get() })).func_200469_a(Character.valueOf('|'), (ITag)Tags.Items.RODS_WOODEN).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.torchberries.get())).func_200467_a((Consumer)consumer, TwilightForestMod.prefix("berry_torch"));
        ConditionalRecipe.builder().addCondition((ICondition)new UncraftingEnabledCondition()).addRecipe((Consumer)ShapedRecipeBuilder.func_200470_a((IItemProvider)TFBlocks.uncrafting_table.get()).func_200472_a("###").func_200472_a("#X#").func_200472_a("###").func_200462_a(Character.valueOf('#'), (IItemProvider)Blocks.field_150462_ai).func_200462_a(Character.valueOf('X'), (IItemProvider)TFItems.maze_map_focus.get()).func_200465_a("has_uncrafting_table", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.uncrafting_table.get()))::func_200464_a).build((Consumer)consumer, TwilightForestMod.prefix("uncrafting_table"));
        this.cookingRecipes(consumer, "smelted", (CookingRecipeSerializer<?>)IRecipeSerializer.field_222171_o, 200);
        this.cookingRecipes(consumer, "smoked", (CookingRecipeSerializer<?>)IRecipeSerializer.field_222173_q, 100);
        this.cookingRecipes(consumer, "campfired", (CookingRecipeSerializer<?>)IRecipeSerializer.field_222174_r, 600);
        this.ingotRecipes(consumer, "smelted", (CookingRecipeSerializer<?>)IRecipeSerializer.field_222171_o, 200);
        this.ingotRecipes(consumer, "blasted", (CookingRecipeSerializer<?>)IRecipeSerializer.field_222172_p, 100);
        this.crackedWoodRecipes(consumer, "smoked", (CookingRecipeSerializer<?>)IRecipeSerializer.field_222173_q, 100);
        this.crackedStoneRecipes(consumer, "smelted", (CookingRecipeSerializer<?>)IRecipeSerializer.field_222171_o, 200);
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.armor_shard_cluster.get()).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.armor_shard.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix("material/" + TFItems.armor_shard_cluster.getId().func_110623_a()));
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)TFBlocks.underbrick_mossy.get(), 1).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_150395_bd })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.underbrick.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.underbrick.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix("underbrick_mossy"));
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)TFBlocks.maze_stone_mossy.get(), 1).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_150395_bd })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.maze_stone_brick.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.maze_stone_brick.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix("maze_stone/maze_stone_mossy"));
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.carminite.get()).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.borer_essence.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.borer_essence.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.borer_essence.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.borer_essence.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151073_bk })).func_203221_a((ITag)Tags.Items.DUSTS_REDSTONE).func_203221_a((ITag)Tags.Items.DUSTS_REDSTONE).func_203221_a((ITag)Tags.Items.DUSTS_REDSTONE).func_203221_a((ITag)Tags.Items.DUSTS_REDSTONE).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.borer_essence.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix("material/" + TFItems.carminite.getId().func_110623_a()));
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.ironwood_raw.get()).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.liveroot.get() })).func_203221_a((ITag)Tags.Items.INGOTS_IRON).func_203221_a((ITag)Tags.Items.NUGGETS_GOLD).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.liveroot.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix("material/" + TFItems.ironwood_raw.getId().func_110623_a()));
    }
    
    private void darkTowerRecipes(final Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFBlocks.encased_fire_jet.get()).func_200472_a("#\u2234#").func_200472_a("\u2234^\u2234").func_200472_a("uuu").func_200469_a(Character.valueOf('\u2234'), (ITag)Tags.Items.DUSTS_REDSTONE).func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.tower_wood_encased.get() })).func_200471_a(Character.valueOf('^'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.fire_jet.get() })).func_200471_a(Character.valueOf('u'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151129_at })).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.fire_jet.get())).func_200464_a((Consumer)consumer);
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFBlocks.encased_smoker.get()).func_200472_a("#\u2234#").func_200472_a("\u2234^\u2234").func_200472_a("#\u2234#").func_200469_a(Character.valueOf('\u2234'), (ITag)Tags.Items.DUSTS_REDSTONE).func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.tower_wood_encased.get() })).func_200471_a(Character.valueOf('^'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.smoker.get() })).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.smoker.get())).func_200464_a((Consumer)consumer);
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFBlocks.carminite_builder.get()).func_200472_a("#6#").func_200472_a("6o6").func_200472_a("#6#").func_200469_a(Character.valueOf('6'), (ITag)ItemTagGenerator.CARMINITE_GEMS).func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.tower_wood_encased.get() })).func_200471_a(Character.valueOf('o'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_150367_z })).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.carminite.get())).func_200464_a((Consumer)consumer);
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFBlocks.carminite_reactor.get()).func_200472_a("#6#").func_200472_a("6%6").func_200472_a("#6#").func_200469_a(Character.valueOf('6'), (ITag)ItemTagGenerator.CARMINITE_GEMS).func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.tower_wood_encased.get() })).func_200469_a(Character.valueOf('%'), (ITag)Tags.Items.ORES_REDSTONE).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.carminite_reactor.get())).func_200464_a((Consumer)consumer);
        ShapedRecipeBuilder.func_200468_a((IItemProvider)TFBlocks.reappearing_block.get(), 2).func_200472_a("#\u2234#").func_200472_a("\u22346\u2234").func_200472_a("#\u2234#").func_200469_a(Character.valueOf('\u2234'), (ITag)Tags.Items.DUSTS_REDSTONE).func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.tower_wood_encased.get() })).func_200469_a(Character.valueOf('6'), (ITag)ItemTagGenerator.CARMINITE_GEMS).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.reappearing_block.get())).func_200464_a((Consumer)consumer);
        ShapedRecipeBuilder.func_200468_a((IItemProvider)TFBlocks.vanishing_block.get(), 8).func_200472_a("#w#").func_200472_a("w6w").func_200472_a("#w#").func_200469_a(Character.valueOf('w'), (ITag)ItemTagGenerator.TOWERWOOD).func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.tower_wood_encased.get() })).func_200469_a(Character.valueOf('6'), (ITag)ItemTagGenerator.CARMINITE_GEMS).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.reappearing_block.get())).func_200464_a((Consumer)consumer);
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFBlocks.tower_wood_mossy.get()).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.tower_wood.get() })).func_200487_b((IItemProvider)Items.field_221796_dh).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.tower_wood.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix("wood/" + TFBlocks.tower_wood_mossy.getId().func_110623_a()));
    }
    
    private void equipmentRecipes(final Consumer<IFinishedRecipe> consumer) {
        this.bootsItem(consumer, "arctic_boots", (Supplier<? extends Item>)TFItems.arctic_boots, ItemTagGenerator.ARCTIC_FUR);
        this.chestplateItem(consumer, "arctic_chestplate", (Supplier<? extends Item>)TFItems.arctic_chestplate, ItemTagGenerator.ARCTIC_FUR);
        this.helmetItem(consumer, "arctic_helmet", (Supplier<? extends Item>)TFItems.arctic_helmet, ItemTagGenerator.ARCTIC_FUR);
        this.leggingsItem(consumer, "arctic_leggings", (Supplier<? extends Item>)TFItems.arctic_leggings, ItemTagGenerator.ARCTIC_FUR);
        this.bootsItem(consumer, "fiery_boots", (Supplier<? extends Item>)TFItems.fiery_boots, ItemTagGenerator.FIERY_INGOTS);
        this.chestplateItem(consumer, "fiery_chestplate", (Supplier<? extends Item>)TFItems.fiery_chestplate, ItemTagGenerator.FIERY_INGOTS);
        this.helmetItem(consumer, "fiery_helmet", (Supplier<? extends Item>)TFItems.fiery_helmet, ItemTagGenerator.FIERY_INGOTS);
        this.leggingsItem(consumer, "fiery_leggings", (Supplier<? extends Item>)TFItems.fiery_leggings, ItemTagGenerator.FIERY_INGOTS);
        this.swordItem(consumer, "fiery_sword", (Supplier<? extends Item>)TFItems.fiery_sword, ItemTagGenerator.FIERY_INGOTS, (ITag.INamedTag<Item>)Tags.Items.RODS_BLAZE);
        this.pickaxeItem(consumer, "fiery_pickaxe", (Supplier<? extends Item>)TFItems.fiery_pickaxe, ItemTagGenerator.FIERY_INGOTS, (ITag.INamedTag<Item>)Tags.Items.RODS_BLAZE);
        this.bootsItem(consumer, "knightmetal_boots", (Supplier<? extends Item>)TFItems.knightmetal_boots, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.chestplateItem(consumer, "knightmetal_chestplate", (Supplier<? extends Item>)TFItems.knightmetal_chestplate, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.helmetItem(consumer, "knightmetal_helmet", (Supplier<? extends Item>)TFItems.knightmetal_helmet, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.leggingsItem(consumer, "knightmetal_leggings", (Supplier<? extends Item>)TFItems.knightmetal_leggings, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.pickaxeItem(consumer, "knightmetal_pickaxe", (Supplier<? extends Item>)TFItems.knightmetal_pickaxe, ItemTagGenerator.KNIGHTMETAL_INGOTS, (ITag.INamedTag<Item>)Tags.Items.RODS_WOODEN);
        this.swordItem(consumer, "knightmetal_sword", (Supplier<? extends Item>)TFItems.knightmetal_sword, ItemTagGenerator.KNIGHTMETAL_INGOTS, (ITag.INamedTag<Item>)Tags.Items.RODS_WOODEN);
        this.axeItem(consumer, "knightmetal_axe", (Supplier<? extends Item>)TFItems.knightmetal_axe, ItemTagGenerator.KNIGHTMETAL_INGOTS, (ITag.INamedTag<Item>)Tags.Items.RODS_WOODEN);
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFItems.giant_pickaxe.get()).func_200472_a("###").func_200472_a(" X ").func_200472_a(" X ").func_200462_a(Character.valueOf('#'), (IItemProvider)TFBlocks.giant_cobblestone.get()).func_200462_a(Character.valueOf('X'), (IItemProvider)TFBlocks.giant_log.get()).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.giant_cobblestone.get())).func_200467_a((Consumer)consumer, this.locEquip(TFItems.giant_pickaxe.getId().func_110623_a()));
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFItems.giant_sword.get()).func_200472_a(" # ").func_200472_a(" # ").func_200472_a(" X ").func_200462_a(Character.valueOf('#'), (IItemProvider)TFBlocks.giant_cobblestone.get()).func_200462_a(Character.valueOf('X'), (IItemProvider)TFBlocks.giant_log.get()).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.giant_cobblestone.get())).func_200467_a((Consumer)consumer, this.locEquip(TFItems.giant_sword.getId().func_110623_a()));
        this.charmRecipe(consumer, "charm_of_keeping_2", (Supplier<? extends Item>)TFItems.charm_of_keeping_2, (Supplier<? extends Item>)TFItems.charm_of_keeping_1);
        this.charmRecipe(consumer, "charm_of_keeping_3", (Supplier<? extends Item>)TFItems.charm_of_keeping_3, (Supplier<? extends Item>)TFItems.charm_of_keeping_2);
        this.charmRecipe(consumer, "charm_of_life_2", (Supplier<? extends Item>)TFItems.charm_of_life_2, (Supplier<? extends Item>)TFItems.charm_of_life_1);
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.moonworm_queen.get()).func_200487_b((IItemProvider)TFItems.moonworm_queen.get()).func_200491_b((IItemProvider)TFItems.torchberries.get(), 3).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.moonworm_queen.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix("moonworm_queen"));
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)Blocks.field_150347_e, 64).func_200487_b((IItemProvider)TFBlocks.giant_cobblestone.get()).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.giant_cobblestone.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix(TFBlocks.giant_cobblestone.getId().func_110623_a() + "_to_" + Blocks.field_150347_e.func_199767_j().getRegistryName().func_110623_a()));
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)Blocks.field_196662_n, 64).func_200487_b((IItemProvider)TFBlocks.giant_log.get()).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.giant_log.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix(TFBlocks.giant_log.getId().func_110623_a() + "_to_" + Blocks.field_196662_n.func_199767_j().getRegistryName().func_110623_a()));
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)Blocks.field_196642_W, 64).func_200487_b((IItemProvider)TFBlocks.giant_leaves.get()).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.giant_log.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix(TFBlocks.giant_leaves.getId().func_110623_a() + "_to_" + Blocks.field_196642_W.func_199767_j().getRegistryName().func_110623_a()));
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.block_and_chain.get()).func_203221_a((ITag)ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL).func_203221_a((ITag)ItemTagGenerator.KNIGHTMETAL_INGOTS).func_203221_a((ITag)ItemTagGenerator.KNIGHTMETAL_INGOTS).func_203221_a((ITag)ItemTagGenerator.KNIGHTMETAL_INGOTS).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.knightmetal_ring.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.knightmetal_block.get())).func_200485_a((Consumer)consumer, this.locEquip(TFItems.block_and_chain.getId().func_110623_a()));
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFItems.knightmetal_ring.get()).func_200472_a(" - ").func_200472_a("- -").func_200472_a(" - ").func_200469_a(Character.valueOf('-'), (ITag)ItemTagGenerator.KNIGHTMETAL_INGOTS).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.knightmetal_ingot.get())).func_200467_a((Consumer)consumer, this.locEquip(TFItems.knightmetal_ring.getId().func_110623_a()));
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFItems.knightmetal_shield.get()).func_200472_a("-#").func_200472_a("-o").func_200472_a("-#").func_200469_a(Character.valueOf('-'), (ITag)ItemTagGenerator.KNIGHTMETAL_INGOTS).func_200469_a(Character.valueOf('#'), (ITag)ItemTagGenerator.TOWERWOOD).func_200471_a(Character.valueOf('o'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.knightmetal_ring.get() })).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.knightmetal_ingot.get())).func_200467_a((Consumer)consumer, this.locEquip(TFItems.knightmetal_shield.getId().func_110623_a()));
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.lifedrain_scepter.get()).func_200489_a(this.itemWithNBT((RegistryObject<? extends IItemProvider>)TFItems.lifedrain_scepter, nbt -> nbt.func_74768_a("Damage", ((Item)TFItems.lifedrain_scepter.get()).func_77612_l()))).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151071_bq })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.lifedrain_scepter.get())).func_200485_a((Consumer)consumer, this.locEquip(TFItems.lifedrain_scepter.getId().func_110623_a()));
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.shield_scepter.get()).func_200489_a(this.itemWithNBT((RegistryObject<? extends IItemProvider>)TFItems.shield_scepter, nbt -> nbt.func_74768_a("Damage", ((Item)TFItems.shield_scepter.get()).func_77612_l()))).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151153_ao })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.shield_scepter.get())).func_200485_a((Consumer)consumer, this.locEquip(TFItems.shield_scepter.getId().func_110623_a()));
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.twilight_scepter.get()).func_200489_a(this.itemWithNBT((RegistryObject<? extends IItemProvider>)TFItems.twilight_scepter, nbt -> nbt.func_74768_a("Damage", ((Item)TFItems.twilight_scepter.get()).func_77612_l()))).func_203221_a((ITag)Tags.Items.ENDER_PEARLS).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.twilight_scepter.get())).func_200485_a((Consumer)consumer, this.locEquip(TFItems.twilight_scepter.getId().func_110623_a()));
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.zombie_scepter.get()).func_200489_a(this.multipleIngredients(this.itemWithNBT((IItemProvider)Items.field_151068_bn, nbt -> nbt.func_74778_a("Potion", "minecraft:strength")), this.itemWithNBT((IItemProvider)Items.field_151068_bn, nbt -> nbt.func_74778_a("Potion", "minecraft:strong_strength")), this.itemWithNBT((IItemProvider)Items.field_151068_bn, nbt -> nbt.func_74778_a("Potion", "minecraft:long_strength")))).func_200489_a(this.itemWithNBT((RegistryObject<? extends IItemProvider>)TFItems.zombie_scepter, nbt -> nbt.func_74768_a("Damage", ((Item)TFItems.zombie_scepter.get()).func_77612_l()))).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151078_bh })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.zombie_scepter.get())).func_200485_a((Consumer)consumer, this.locEquip(TFItems.zombie_scepter.getId().func_110623_a()));
    }
    
    private void blockCompressionRecipes(final Consumer<IFinishedRecipe> consumer) {
        this.reverseCompressBlock(consumer, "arctic_block_to_item", (Supplier<? extends Item>)TFItems.arctic_fur, ItemTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR);
        this.reverseCompressBlock(consumer, "carminite_block_to_item", (Supplier<? extends Item>)TFItems.carminite, ItemTagGenerator.STORAGE_BLOCKS_CARMINITE);
        this.reverseCompressBlock(consumer, "fiery_block_to_ingot", (Supplier<? extends Item>)TFItems.fiery_ingot, ItemTagGenerator.STORAGE_BLOCKS_FIERY);
        this.reverseCompressBlock(consumer, "ironwood_block_ingot", (Supplier<? extends Item>)TFItems.ironwood_ingot, ItemTagGenerator.STORAGE_BLOCKS_IRONWOOD);
        this.reverseCompressBlock(consumer, "knightmetal_block_ingot", (Supplier<? extends Item>)TFItems.knightmetal_ingot, ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL);
        this.reverseCompressBlock(consumer, "steeleaf_block_ingot", (Supplier<? extends Item>)TFItems.steeleaf_ingot, ItemTagGenerator.STORAGE_BLOCKS_STEELEAF);
        this.compressedBlock(consumer, "arctic_block", (Supplier<? extends Block>)TFBlocks.arctic_fur_block, ItemTagGenerator.ARCTIC_FUR);
        this.compressedBlock(consumer, "carminite_block", (Supplier<? extends Block>)TFBlocks.carminite_block, ItemTagGenerator.CARMINITE_GEMS);
        this.compressedBlock(consumer, "fiery_block", (Supplier<? extends Block>)TFBlocks.fiery_block, ItemTagGenerator.FIERY_INGOTS);
        this.compressedBlock(consumer, "ironwood_block", (Supplier<? extends Block>)TFBlocks.ironwood_block, ItemTagGenerator.IRONWOOD_INGOTS);
        this.compressedBlock(consumer, "knightmetal_block", (Supplier<? extends Block>)TFBlocks.knightmetal_block, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.compressedBlock(consumer, "steeleaf_block", (Supplier<? extends Block>)TFBlocks.steeleaf_block, ItemTagGenerator.STEELEAF_INGOTS);
    }
    
    private void emptyMapRecipes(final Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.magic_map_focus.get()).func_200487_b((IItemProvider)TFItems.raven_feather.get()).func_200487_b((IItemProvider)TFItems.torchberries.get()).func_203221_a((ITag)Tags.Items.DUSTS_GLOWSTONE).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.torchberries.get())).func_200482_a((Consumer)consumer);
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFItems.magic_map_empty.get()).func_200472_a("###").func_200472_a("#\u2022#").func_200472_a("###").func_200469_a(Character.valueOf('#'), (ITag)ItemTagGenerator.PAPER).func_200471_a(Character.valueOf('\u2022'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.magic_map_focus.get() })).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.magic_map_focus.get())).func_200464_a((Consumer)consumer);
        ShapedRecipeBuilder.func_200470_a((IItemProvider)TFItems.maze_map_empty.get()).func_200472_a("###").func_200472_a("#\u2022#").func_200472_a("###").func_200469_a(Character.valueOf('#'), (ITag)ItemTagGenerator.PAPER).func_200471_a(Character.valueOf('\u2022'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.maze_map_focus.get() })).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.maze_map_focus.get())).func_200464_a((Consumer)consumer);
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.ore_map_empty.get()).func_200487_b((IItemProvider)TFItems.maze_map_empty.get()).func_203221_a((ITag)Tags.Items.STORAGE_BLOCKS_DIAMOND).func_203221_a((ITag)Tags.Items.STORAGE_BLOCKS_GOLD).func_203221_a((ITag)Tags.Items.STORAGE_BLOCKS_IRON).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.ore_magnet.get())).func_200482_a((Consumer)consumer);
    }
    
    private void woodRecipes(final Consumer<IFinishedRecipe> consumer) {
        this.buttonBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.canopy_button, (Supplier<? extends Block>)TFBlocks.canopy_planks);
        this.buttonBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.dark_button, (Supplier<? extends Block>)TFBlocks.dark_planks);
        this.buttonBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.mangrove_button, (Supplier<? extends Block>)TFBlocks.mangrove_planks);
        this.buttonBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.mine_button, (Supplier<? extends Block>)TFBlocks.mine_planks);
        this.buttonBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.sort_button, (Supplier<? extends Block>)TFBlocks.sort_planks);
        this.buttonBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.time_button, (Supplier<? extends Block>)TFBlocks.time_planks);
        this.buttonBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.trans_button, (Supplier<? extends Block>)TFBlocks.trans_planks);
        this.buttonBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.twilight_oak_button, (Supplier<? extends Block>)TFBlocks.twilight_oak_planks);
        this.doorBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.canopy_door, (Supplier<? extends Block>)TFBlocks.canopy_planks);
        this.doorBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.dark_door, (Supplier<? extends Block>)TFBlocks.dark_planks);
        this.doorBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.mangrove_door, (Supplier<? extends Block>)TFBlocks.mangrove_planks);
        this.doorBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.mine_door, (Supplier<? extends Block>)TFBlocks.mine_planks);
        this.doorBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.sort_door, (Supplier<? extends Block>)TFBlocks.sort_planks);
        this.doorBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.time_door, (Supplier<? extends Block>)TFBlocks.time_planks);
        this.doorBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.trans_door, (Supplier<? extends Block>)TFBlocks.trans_planks);
        this.doorBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.twilight_oak_door, (Supplier<? extends Block>)TFBlocks.twilight_oak_planks);
        this.fenceBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.canopy_fence, (Supplier<? extends Block>)TFBlocks.canopy_planks);
        this.fenceBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.dark_fence, (Supplier<? extends Block>)TFBlocks.dark_planks);
        this.fenceBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.mangrove_fence, (Supplier<? extends Block>)TFBlocks.mangrove_planks);
        this.fenceBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.mine_fence, (Supplier<? extends Block>)TFBlocks.mine_planks);
        this.fenceBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.sort_fence, (Supplier<? extends Block>)TFBlocks.sort_planks);
        this.fenceBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.time_fence, (Supplier<? extends Block>)TFBlocks.time_planks);
        this.fenceBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.trans_fence, (Supplier<? extends Block>)TFBlocks.trans_planks);
        this.fenceBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.twilight_oak_fence, (Supplier<? extends Block>)TFBlocks.twilight_oak_planks);
        this.gateBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.canopy_gate, (Supplier<? extends Block>)TFBlocks.canopy_planks);
        this.gateBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.dark_gate, (Supplier<? extends Block>)TFBlocks.dark_planks);
        this.gateBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.mangrove_gate, (Supplier<? extends Block>)TFBlocks.mangrove_planks);
        this.gateBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.mine_gate, (Supplier<? extends Block>)TFBlocks.mine_planks);
        this.gateBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.sort_gate, (Supplier<? extends Block>)TFBlocks.sort_planks);
        this.gateBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.time_gate, (Supplier<? extends Block>)TFBlocks.time_planks);
        this.gateBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.trans_gate, (Supplier<? extends Block>)TFBlocks.trans_planks);
        this.gateBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.twilight_oak_gate, (Supplier<? extends Block>)TFBlocks.twilight_oak_planks);
        this.planksBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.canopy_planks, (Supplier<? extends Block>)TFBlocks.canopy_log);
        this.planksBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.dark_planks, (Supplier<? extends Block>)TFBlocks.dark_log);
        this.planksBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.mangrove_planks, (Supplier<? extends Block>)TFBlocks.mangrove_log);
        this.planksBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.mine_planks, (Supplier<? extends Block>)TFBlocks.mining_log);
        this.planksBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.sort_planks, (Supplier<? extends Block>)TFBlocks.sorting_log);
        this.planksBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.time_planks, (Supplier<? extends Block>)TFBlocks.time_log);
        this.planksBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.trans_planks, (Supplier<? extends Block>)TFBlocks.transformation_log);
        this.planksBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.twilight_oak_planks, (Supplier<? extends Block>)TFBlocks.oak_log);
        this.planksBlock(consumer, "canopy_from_stripped", (Supplier<? extends Block>)TFBlocks.canopy_planks, (Supplier<? extends Block>)TFBlocks.stripped_canopy_log);
        this.planksBlock(consumer, "darkwood_from_stripped", (Supplier<? extends Block>)TFBlocks.dark_planks, (Supplier<? extends Block>)TFBlocks.stripped_dark_log);
        this.planksBlock(consumer, "mangrove_from_stripped", (Supplier<? extends Block>)TFBlocks.mangrove_planks, (Supplier<? extends Block>)TFBlocks.stripped_mangrove_log);
        this.planksBlock(consumer, "mine_from_stripped", (Supplier<? extends Block>)TFBlocks.mine_planks, (Supplier<? extends Block>)TFBlocks.stripped_mining_log);
        this.planksBlock(consumer, "sort_from_stripped", (Supplier<? extends Block>)TFBlocks.sort_planks, (Supplier<? extends Block>)TFBlocks.stripped_sorting_log);
        this.planksBlock(consumer, "time_from_stripped", (Supplier<? extends Block>)TFBlocks.time_planks, (Supplier<? extends Block>)TFBlocks.stripped_time_log);
        this.planksBlock(consumer, "trans_from_stripped", (Supplier<? extends Block>)TFBlocks.trans_planks, (Supplier<? extends Block>)TFBlocks.stripped_transformation_log);
        this.planksBlock(consumer, "twilight_oak_from_stripped", (Supplier<? extends Block>)TFBlocks.twilight_oak_planks, (Supplier<? extends Block>)TFBlocks.stripped_oak_log);
        this.planksBlock(consumer, "canopy_from_wood", (Supplier<? extends Block>)TFBlocks.canopy_planks, (Supplier<? extends Block>)TFBlocks.canopy_wood);
        this.planksBlock(consumer, "darkwood_from_wood", (Supplier<? extends Block>)TFBlocks.dark_planks, (Supplier<? extends Block>)TFBlocks.dark_wood);
        this.planksBlock(consumer, "mangrove_from_wood", (Supplier<? extends Block>)TFBlocks.mangrove_planks, (Supplier<? extends Block>)TFBlocks.mangrove_wood);
        this.planksBlock(consumer, "mine_from_wood", (Supplier<? extends Block>)TFBlocks.mine_planks, (Supplier<? extends Block>)TFBlocks.mining_wood);
        this.planksBlock(consumer, "sort_from_wood", (Supplier<? extends Block>)TFBlocks.sort_planks, (Supplier<? extends Block>)TFBlocks.sorting_wood);
        this.planksBlock(consumer, "time_from_wood", (Supplier<? extends Block>)TFBlocks.time_planks, (Supplier<? extends Block>)TFBlocks.time_wood);
        this.planksBlock(consumer, "trans_from_wood", (Supplier<? extends Block>)TFBlocks.trans_planks, (Supplier<? extends Block>)TFBlocks.transformation_wood);
        this.planksBlock(consumer, "twilight_oak_from_wood", (Supplier<? extends Block>)TFBlocks.twilight_oak_planks, (Supplier<? extends Block>)TFBlocks.oak_wood);
        this.planksBlock(consumer, "canopy_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.canopy_planks, (Supplier<? extends Block>)TFBlocks.stripped_canopy_wood);
        this.planksBlock(consumer, "darkwood_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.dark_planks, (Supplier<? extends Block>)TFBlocks.stripped_dark_wood);
        this.planksBlock(consumer, "mangrove_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.mangrove_planks, (Supplier<? extends Block>)TFBlocks.stripped_mangrove_wood);
        this.planksBlock(consumer, "mine_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.mine_planks, (Supplier<? extends Block>)TFBlocks.stripped_mining_wood);
        this.planksBlock(consumer, "sort_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.sort_planks, (Supplier<? extends Block>)TFBlocks.stripped_sorting_wood);
        this.planksBlock(consumer, "time_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.time_planks, (Supplier<? extends Block>)TFBlocks.stripped_time_wood);
        this.planksBlock(consumer, "trans_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.trans_planks, (Supplier<? extends Block>)TFBlocks.stripped_transformation_wood);
        this.planksBlock(consumer, "twilight_oak_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.twilight_oak_planks, (Supplier<? extends Block>)TFBlocks.stripped_oak_wood);
        this.woodBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.canopy_wood, (Supplier<? extends Block>)TFBlocks.canopy_log);
        this.woodBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.dark_wood, (Supplier<? extends Block>)TFBlocks.dark_log);
        this.woodBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.mangrove_wood, (Supplier<? extends Block>)TFBlocks.mangrove_log);
        this.woodBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.mining_wood, (Supplier<? extends Block>)TFBlocks.mining_log);
        this.woodBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.sorting_wood, (Supplier<? extends Block>)TFBlocks.sorting_log);
        this.woodBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.time_wood, (Supplier<? extends Block>)TFBlocks.time_log);
        this.woodBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.transformation_wood, (Supplier<? extends Block>)TFBlocks.transformation_log);
        this.woodBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.oak_wood, (Supplier<? extends Block>)TFBlocks.oak_log);
        this.strippedWoodBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.stripped_canopy_wood, (Supplier<? extends Block>)TFBlocks.stripped_canopy_log);
        this.strippedWoodBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.stripped_dark_wood, (Supplier<? extends Block>)TFBlocks.stripped_dark_log);
        this.strippedWoodBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.stripped_mangrove_wood, (Supplier<? extends Block>)TFBlocks.stripped_mangrove_log);
        this.strippedWoodBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.stripped_mining_wood, (Supplier<? extends Block>)TFBlocks.stripped_mining_log);
        this.strippedWoodBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.stripped_sorting_wood, (Supplier<? extends Block>)TFBlocks.stripped_sorting_log);
        this.strippedWoodBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.stripped_time_wood, (Supplier<? extends Block>)TFBlocks.stripped_time_log);
        this.strippedWoodBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.stripped_transformation_wood, (Supplier<? extends Block>)TFBlocks.stripped_transformation_log);
        this.strippedWoodBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.stripped_oak_wood, (Supplier<? extends Block>)TFBlocks.stripped_oak_log);
        this.plateBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.canopy_plate, (Supplier<? extends Block>)TFBlocks.canopy_planks);
        this.plateBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.dark_plate, (Supplier<? extends Block>)TFBlocks.dark_planks);
        this.plateBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.mangrove_plate, (Supplier<? extends Block>)TFBlocks.mangrove_planks);
        this.plateBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.mine_plate, (Supplier<? extends Block>)TFBlocks.mine_planks);
        this.plateBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.sort_plate, (Supplier<? extends Block>)TFBlocks.sort_planks);
        this.plateBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.time_plate, (Supplier<? extends Block>)TFBlocks.time_planks);
        this.plateBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.trans_plate, (Supplier<? extends Block>)TFBlocks.trans_planks);
        this.plateBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.twilight_oak_plate, (Supplier<? extends Block>)TFBlocks.twilight_oak_planks);
        this.slabBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.canopy_slab, (Supplier<? extends Block>)TFBlocks.canopy_planks);
        this.slabBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.dark_slab, (Supplier<? extends Block>)TFBlocks.dark_planks);
        this.slabBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.mangrove_slab, (Supplier<? extends Block>)TFBlocks.mangrove_planks);
        this.slabBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.mine_slab, (Supplier<? extends Block>)TFBlocks.mine_planks);
        this.slabBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.sort_slab, (Supplier<? extends Block>)TFBlocks.sort_planks);
        this.slabBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.time_slab, (Supplier<? extends Block>)TFBlocks.time_planks);
        this.slabBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.trans_slab, (Supplier<? extends Block>)TFBlocks.trans_planks);
        this.slabBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.twilight_oak_slab, (Supplier<? extends Block>)TFBlocks.twilight_oak_planks);
        this.stairsBlock(consumer, this.locWood("canopy_stairs"), (Supplier<? extends Block>)TFBlocks.canopy_stairs, (Supplier<? extends Block>)TFBlocks.canopy_planks, (IItemProvider)TFBlocks.canopy_planks.get());
        this.stairsBlock(consumer, this.locWood("darkwood_stairs"), (Supplier<? extends Block>)TFBlocks.dark_stairs, (Supplier<? extends Block>)TFBlocks.dark_planks, (IItemProvider)TFBlocks.dark_planks.get());
        this.stairsBlock(consumer, this.locWood("mangrove_stairs"), (Supplier<? extends Block>)TFBlocks.mangrove_stairs, (Supplier<? extends Block>)TFBlocks.mangrove_planks, (IItemProvider)TFBlocks.mangrove_planks.get());
        this.stairsBlock(consumer, this.locWood("mine_stairs"), (Supplier<? extends Block>)TFBlocks.mine_stairs, (Supplier<? extends Block>)TFBlocks.mine_planks, (IItemProvider)TFBlocks.mine_planks.get());
        this.stairsBlock(consumer, this.locWood("sort_stairs"), (Supplier<? extends Block>)TFBlocks.sort_stairs, (Supplier<? extends Block>)TFBlocks.sort_planks, (IItemProvider)TFBlocks.sort_planks.get());
        this.stairsBlock(consumer, this.locWood("time_stairs"), (Supplier<? extends Block>)TFBlocks.time_stairs, (Supplier<? extends Block>)TFBlocks.time_planks, (IItemProvider)TFBlocks.time_planks.get());
        this.stairsBlock(consumer, this.locWood("trans_stairs"), (Supplier<? extends Block>)TFBlocks.trans_stairs, (Supplier<? extends Block>)TFBlocks.trans_planks, (IItemProvider)TFBlocks.trans_planks.get());
        this.stairsBlock(consumer, this.locWood("twilight_oak_stairs"), (Supplier<? extends Block>)TFBlocks.twilight_oak_stairs, (Supplier<? extends Block>)TFBlocks.twilight_oak_planks, (IItemProvider)TFBlocks.twilight_oak_planks.get());
        this.trapdoorBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.canopy_trapdoor, (Supplier<? extends Block>)TFBlocks.canopy_planks);
        this.trapdoorBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.dark_trapdoor, (Supplier<? extends Block>)TFBlocks.dark_planks);
        this.trapdoorBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.mangrove_trapdoor, (Supplier<? extends Block>)TFBlocks.mangrove_planks);
        this.trapdoorBlock(consumer, "mine", (Supplier<? extends Block>)TFBlocks.mine_trapdoor, (Supplier<? extends Block>)TFBlocks.mine_planks);
        this.trapdoorBlock(consumer, "sort", (Supplier<? extends Block>)TFBlocks.sort_trapdoor, (Supplier<? extends Block>)TFBlocks.sort_planks);
        this.trapdoorBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.time_trapdoor, (Supplier<? extends Block>)TFBlocks.time_planks);
        this.trapdoorBlock(consumer, "trans", (Supplier<? extends Block>)TFBlocks.trans_trapdoor, (Supplier<? extends Block>)TFBlocks.trans_planks);
        this.trapdoorBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.twilight_oak_trapdoor, (Supplier<? extends Block>)TFBlocks.twilight_oak_planks);
        this.signBlock(consumer, "canopy_sign", (Supplier<? extends Block>)TFBlocks.canopy_sign, (Supplier<? extends Block>)TFBlocks.canopy_planks);
        this.signBlock(consumer, "darkwood_sign", (Supplier<? extends Block>)TFBlocks.darkwood_sign, (Supplier<? extends Block>)TFBlocks.dark_planks);
        this.signBlock(consumer, "mangrove_sign", (Supplier<? extends Block>)TFBlocks.mangrove_sign, (Supplier<? extends Block>)TFBlocks.mangrove_planks);
        this.signBlock(consumer, "mine_sign", (Supplier<? extends Block>)TFBlocks.mine_sign, (Supplier<? extends Block>)TFBlocks.mine_planks);
        this.signBlock(consumer, "sort_sign", (Supplier<? extends Block>)TFBlocks.sort_sign, (Supplier<? extends Block>)TFBlocks.sort_planks);
        this.signBlock(consumer, "time_sign", (Supplier<? extends Block>)TFBlocks.time_sign, (Supplier<? extends Block>)TFBlocks.time_planks);
        this.signBlock(consumer, "trans_sign", (Supplier<? extends Block>)TFBlocks.trans_sign, (Supplier<? extends Block>)TFBlocks.trans_planks);
        this.signBlock(consumer, "twilight_oak_sign", (Supplier<? extends Block>)TFBlocks.twilight_oak_sign, (Supplier<? extends Block>)TFBlocks.twilight_oak_planks);
    }
    
    private void nagastoneRecipes(final Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)TFBlocks.spiral_bricks.get(), 8).func_200472_a("BSS").func_200472_a("BSS").func_200472_a("BBB").func_200471_a(Character.valueOf('B'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_196696_di, (IItemProvider)Blocks.field_196698_dj, (IItemProvider)Blocks.field_196700_dk, (IItemProvider)Blocks.field_196702_dl })).func_200471_a(Character.valueOf('S'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_150333_U, (IItemProvider)Blocks.field_196573_bB })).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.spiral_bricks.get())).func_200467_a((Consumer)consumer, this.locNaga("nagastone_spiral"));
        this.stairsBlock(consumer, this.locNaga("nagastone_stairs_left"), (Supplier<? extends Block>)TFBlocks.nagastone_stairs_left, (Supplier<? extends Block>)TFBlocks.etched_nagastone, (IItemProvider)TFBlocks.etched_nagastone.get());
        this.stairsRightBlock(consumer, this.locNaga("nagastone_stairs_right"), (Supplier<? extends Block>)TFBlocks.nagastone_stairs_right, (Supplier<? extends Block>)TFBlocks.etched_nagastone, (IItemProvider)TFBlocks.etched_nagastone.get());
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)TFBlocks.etched_nagastone.get(), 3).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_right.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_right.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_right.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_right.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.etched_nagastone.get())).func_200485_a((Consumer)consumer, this.locNaga("nagastone_stairs_reverse"));
        this.stairsBlock(consumer, this.locNaga("nagastone_stairs_left_mossy"), (Supplier<? extends Block>)TFBlocks.nagastone_stairs_mossy_left, (Supplier<? extends Block>)TFBlocks.etched_nagastone_mossy, (IItemProvider)TFBlocks.etched_nagastone_mossy.get());
        this.stairsRightBlock(consumer, this.locNaga("nagastone_stairs_right_mossy"), (Supplier<? extends Block>)TFBlocks.nagastone_stairs_mossy_right, (Supplier<? extends Block>)TFBlocks.etched_nagastone_mossy, (IItemProvider)TFBlocks.etched_nagastone_mossy.get());
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)TFBlocks.etched_nagastone_mossy.get(), 3).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_mossy_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_mossy_right.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_mossy_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_mossy_right.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_mossy_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_mossy_right.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_mossy_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_mossy_right.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.etched_nagastone_mossy.get())).func_200485_a((Consumer)consumer, this.locNaga("nagastone_stairs_mossy_reverse"));
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)TFBlocks.etched_nagastone_mossy.get(), 1).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_150395_bd })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.etched_nagastone.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.etched_nagastone.get())).func_200485_a((Consumer)consumer, this.locNaga("etched_nagastone_mossy"));
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)TFBlocks.nagastone_pillar_mossy.get(), 1).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_150395_bd })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_pillar.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.nagastone_pillar.get())).func_200485_a((Consumer)consumer, this.locNaga("nagastone_pillar_mossy"));
        this.stairsBlock(consumer, this.locNaga("nagastone_stairs_left_weathered"), (Supplier<? extends Block>)TFBlocks.nagastone_stairs_weathered_left, (Supplier<? extends Block>)TFBlocks.etched_nagastone_weathered, (IItemProvider)TFBlocks.etched_nagastone_weathered.get());
        this.stairsRightBlock(consumer, this.locNaga("nagastone_stairs_right_weathered"), (Supplier<? extends Block>)TFBlocks.nagastone_stairs_weathered_right, (Supplier<? extends Block>)TFBlocks.etched_nagastone_weathered, (IItemProvider)TFBlocks.etched_nagastone_weathered.get());
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)TFBlocks.etched_nagastone_weathered.get(), 3).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_weathered_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_weathered_right.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_weathered_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_weathered_right.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_weathered_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_weathered_right.get() })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_stairs_weathered_left.get(), (IItemProvider)TFBlocks.nagastone_stairs_weathered_right.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.etched_nagastone_weathered.get())).func_200485_a((Consumer)consumer, this.locNaga("nagastone_stairs_weathered_reverse"));
    }
    
    private void castleRecipes(final Consumer<IFinishedRecipe> consumer) {
        this.castleBlock(consumer, "castle_paver", (Supplier<? extends Block>)TFBlocks.castle_brick_frame, (Supplier<? extends Block>)TFBlocks.castle_brick, (IItemProvider)TFBlocks.castle_brick.get(), (IItemProvider)TFBlocks.castle_brick_worn.get(), (IItemProvider)TFBlocks.castle_brick_cracked.get(), (IItemProvider)TFBlocks.castle_brick_mossy.get());
        this.castleBlock(consumer, "castle_pillar_bold", (Supplier<? extends Block>)TFBlocks.castle_pillar_bold, (Supplier<? extends Block>)TFBlocks.castle_brick_frame, (IItemProvider)TFBlocks.castle_brick_frame.get());
        this.castleBlock(consumer, "castle_pillar_bold_none", (Supplier<? extends Block>)TFBlocks.castle_pillar_bold_tile, (Supplier<? extends Block>)TFBlocks.castle_pillar_bold, (IItemProvider)TFBlocks.castle_pillar_bold_tile.get());
        ShapedRecipeBuilder.func_200468_a((IItemProvider)TFBlocks.castle_pillar_encased.get(), 6).func_200472_a("#H#").func_200472_a("#H#").func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.castle_brick.get(), (IItemProvider)TFBlocks.castle_brick_worn.get(), (IItemProvider)TFBlocks.castle_brick_cracked.get(), (IItemProvider)TFBlocks.castle_brick_mossy.get(), (IItemProvider)TFBlocks.castle_brick_frame.get() })).func_200471_a(Character.valueOf('H'), Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.castle_pillar_encased.get(), (IItemProvider)TFBlocks.castle_pillar_encased_tile.get(), (IItemProvider)TFBlocks.castle_pillar_bold_tile.get() })).func_200465_a("has_" + ((Block)TFBlocks.castle_pillar_encased.get()).getRegistryName().func_110623_a(), (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.castle_pillar_encased.get())).func_200467_a((Consumer)consumer, this.locCastle("castle_pillar_encased"));
        this.castleBlock(consumer, "castle_pillar_encased_none", (Supplier<? extends Block>)TFBlocks.castle_pillar_bold_tile, (Supplier<? extends Block>)TFBlocks.castle_pillar_bold_tile, (IItemProvider)TFBlocks.castle_pillar_bold.get(), (IItemProvider)TFBlocks.castle_pillar_bold_tile.get());
        this.stairsBlock(consumer, this.locCastle("castleblock_stairs_bold"), (Supplier<? extends Block>)TFBlocks.castle_stairs_bold, (Supplier<? extends Block>)TFBlocks.castle_pillar_bold, (IItemProvider)TFBlocks.castle_pillar_bold.get(), (IItemProvider)TFBlocks.castle_pillar_bold_tile.get());
        this.reverseStairsBlock(consumer, this.locCastle("castleblock_stairs_bold_reverse"), (Supplier<? extends Block>)TFBlocks.castle_pillar_bold, (Supplier<? extends Block>)TFBlocks.castle_stairs_bold, (IItemProvider)TFBlocks.castle_stairs_bold.get());
        this.stairsBlock(consumer, this.locCastle("castleblock_stairs_brick"), (Supplier<? extends Block>)TFBlocks.castle_stairs_brick, (Supplier<? extends Block>)TFBlocks.castle_brick, (IItemProvider)TFBlocks.castle_brick.get());
        this.reverseStairsBlock(consumer, this.locCastle("castleblock_stairs_brick_reverse"), (Supplier<? extends Block>)TFBlocks.castle_brick, (Supplier<? extends Block>)TFBlocks.castle_stairs_brick, (IItemProvider)TFBlocks.castle_stairs_brick.get());
        this.stairsBlock(consumer, this.locCastle("castleblock_stairs_cracked"), (Supplier<? extends Block>)TFBlocks.castle_stairs_cracked, (Supplier<? extends Block>)TFBlocks.castle_brick_cracked, (IItemProvider)TFBlocks.castle_brick_cracked.get());
        this.reverseStairsBlock(consumer, this.locCastle("castleblock_stairs_cracked_reverse"), (Supplier<? extends Block>)TFBlocks.castle_brick_cracked, (Supplier<? extends Block>)TFBlocks.castle_brick_cracked, (IItemProvider)TFBlocks.castle_stairs_cracked.get());
        this.stairsBlock(consumer, this.locCastle("castleblock_stairs_encased"), (Supplier<? extends Block>)TFBlocks.castle_stairs_encased, (Supplier<? extends Block>)TFBlocks.castle_pillar_encased, (IItemProvider)TFBlocks.castle_pillar_encased.get(), (IItemProvider)TFBlocks.castle_pillar_encased_tile.get());
        this.reverseStairsBlock(consumer, this.locCastle("castleblock_stairs_encased_reverse"), (Supplier<? extends Block>)TFBlocks.castle_pillar_encased, (Supplier<? extends Block>)TFBlocks.castle_stairs_encased, (IItemProvider)TFBlocks.castle_stairs_encased.get());
        this.stairsBlock(consumer, this.locCastle("castleblock_stairs_mossy"), (Supplier<? extends Block>)TFBlocks.castle_stairs_mossy, (Supplier<? extends Block>)TFBlocks.castle_brick_mossy, (IItemProvider)TFBlocks.castle_brick_mossy.get());
        this.reverseStairsBlock(consumer, this.locCastle("castleblock_stairs_mossy_reverse"), (Supplier<? extends Block>)TFBlocks.castle_brick_mossy, (Supplier<? extends Block>)TFBlocks.castle_brick_mossy, (IItemProvider)TFBlocks.castle_stairs_mossy.get());
        this.stairsBlock(consumer, this.locCastle("castleblock_stairs_worn"), (Supplier<? extends Block>)TFBlocks.castle_stairs_worn, (Supplier<? extends Block>)TFBlocks.castle_brick_worn, (IItemProvider)TFBlocks.castle_brick_worn.get());
        this.reverseStairsBlock(consumer, this.locCastle("castleblock_stairs_worn_reverse"), (Supplier<? extends Block>)TFBlocks.castle_brick_worn, (Supplier<? extends Block>)TFBlocks.castle_brick_worn, (IItemProvider)TFBlocks.castle_stairs_worn.get());
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)TFBlocks.castle_brick_mossy.get(), 1).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Blocks.field_150395_bd })).func_200489_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.castle_brick.get() })).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.castle_brick.get())).func_200485_a((Consumer)consumer, this.locCastle("castle_brick_mossy"));
    }
    
    private void fieryConversions(final Consumer<IFinishedRecipe> consumer) {
        SmithingRecipeBuilder.func_240502_a_(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)Items.field_151042_j }), Ingredient.func_199805_a((ITag)ItemTagGenerator.FIERY_VIAL), (Item)TFItems.fiery_ingot.get()).func_240503_a_("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.fiery_ingot.get())).func_240505_a_((Consumer)consumer, TwilightForestMod.prefix("material/fiery_iron_ingot"));
        this.fieryConversion(consumer, (Supplier<? extends Item>)TFItems.fiery_helmet, Items.field_151028_Y, 5);
        this.fieryConversion(consumer, (Supplier<? extends Item>)TFItems.fiery_chestplate, Items.field_151030_Z, 8);
        this.fieryConversion(consumer, (Supplier<? extends Item>)TFItems.fiery_leggings, Items.field_151165_aa, 7);
        this.fieryConversion(consumer, (Supplier<? extends Item>)TFItems.fiery_boots, Items.field_151167_ab, 4);
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.fiery_sword.get()).func_200487_b((IItemProvider)Items.field_151040_l).func_200492_a(Ingredient.func_199805_a((ITag)ItemTagGenerator.FIERY_VIAL), 2).func_200489_a(Ingredient.func_199805_a((ITag)Tags.Items.RODS_BLAZE)).func_200483_a("has_item", (ICriterionInstance)func_200409_a((ITag)ItemTagGenerator.FIERY_VIAL)).func_200485_a((Consumer)consumer, this.locEquip("fiery_" + Items.field_151040_l.getRegistryName().func_110623_a()));
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)TFItems.fiery_pickaxe.get()).func_200487_b((IItemProvider)Items.field_151035_b).func_200492_a(Ingredient.func_199805_a((ITag)ItemTagGenerator.FIERY_VIAL), 3).func_200492_a(Ingredient.func_199805_a((ITag)Tags.Items.RODS_BLAZE), 2).func_200483_a("has_item", (ICriterionInstance)func_200409_a((ITag)ItemTagGenerator.FIERY_VIAL)).func_200485_a((Consumer)consumer, this.locEquip("fiery_" + Items.field_151035_b.getRegistryName().func_110623_a()));
    }
    
    private void cookingRecipes(final Consumer<IFinishedRecipe> consumer, final String processName, final CookingRecipeSerializer<?> process, final int smeltingTime) {
        CookingRecipeBuilder.func_218631_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.raw_meef.get() }), (IItemProvider)TFItems.cooked_meef.get(), 0.3f, smeltingTime, (CookingRecipeSerializer)process).func_218628_a("has_food", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.raw_meef.get())).func_218632_a((Consumer)consumer, TwilightForestMod.prefix("food/" + processName + "_meef").toString());
        CookingRecipeBuilder.func_218631_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.raw_venison.get() }), (IItemProvider)TFItems.cooked_venison.get(), 0.3f, smeltingTime, (CookingRecipeSerializer)process).func_218628_a("has_food", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.raw_venison.get())).func_218632_a((Consumer)consumer, TwilightForestMod.prefix("food/" + processName + "_venison").toString());
    }
    
    private void ingotRecipes(final Consumer<IFinishedRecipe> consumer, final String processName, final CookingRecipeSerializer<?> process, final int smeltingTime) {
        CookingRecipeBuilder.func_218631_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.armor_shard_cluster.get() }), (IItemProvider)TFItems.knightmetal_ingot.get(), 1.0f, smeltingTime, (CookingRecipeSerializer)process).func_218628_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFItems.armor_shard_cluster.get())).func_218632_a((Consumer)consumer, TwilightForestMod.prefix("material/" + processName + "_knightmetal_ingot").toString());
    }
    
    private void crackedWoodRecipes(final Consumer<IFinishedRecipe> consumer, final String processName, final CookingRecipeSerializer<?> process, final int smeltingTime) {
        CookingRecipeBuilder.func_218631_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.tower_wood.get() }), (IItemProvider)TFBlocks.tower_wood_cracked.get(), 0.3f, smeltingTime, (CookingRecipeSerializer)process).func_218628_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.tower_wood.get())).func_218632_a((Consumer)consumer, TwilightForestMod.prefix("wood/" + processName + "_cracked_towerwood").toString());
    }
    
    private void crackedStoneRecipes(final Consumer<IFinishedRecipe> consumer, final String processName, final CookingRecipeSerializer<?> process, final int smeltingTime) {
        CookingRecipeBuilder.func_218631_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.nagastone_pillar.get() }), (IItemProvider)TFBlocks.nagastone_pillar_weathered.get(), 0.3f, smeltingTime, (CookingRecipeSerializer)process).func_218628_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.nagastone_pillar.get())).func_218632_a((Consumer)consumer, TwilightForestMod.prefix("nagastone/" + processName + "_cracked_nagastone_pillar").toString());
        CookingRecipeBuilder.func_218631_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.etched_nagastone.get() }), (IItemProvider)TFBlocks.etched_nagastone_weathered.get(), 0.3f, smeltingTime, (CookingRecipeSerializer)process).func_218628_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.etched_nagastone.get())).func_218632_a((Consumer)consumer, TwilightForestMod.prefix("nagastone/" + processName + "_cracked_etched_nagastone").toString());
        CookingRecipeBuilder.func_218631_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.maze_stone_brick.get() }), (IItemProvider)TFBlocks.maze_stone_cracked.get(), 0.3f, smeltingTime, (CookingRecipeSerializer)process).func_218628_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.maze_stone_brick.get())).func_218632_a((Consumer)consumer, TwilightForestMod.prefix("maze_stone/" + processName + "_maze_stone_cracked").toString());
        CookingRecipeBuilder.func_218631_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.castle_brick.get() }), (IItemProvider)TFBlocks.castle_brick_cracked.get(), 0.3f, smeltingTime, (CookingRecipeSerializer)process).func_218628_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.castle_brick.get())).func_218632_a((Consumer)consumer, TwilightForestMod.prefix("castleblock/" + processName + "_cracked_castle_brick").toString());
        CookingRecipeBuilder.func_218631_a(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFBlocks.underbrick.get() }), (IItemProvider)TFBlocks.underbrick_cracked.get(), 0.3f, smeltingTime, (CookingRecipeSerializer)process).func_218628_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)TFBlocks.underbrick.get())).func_218632_a((Consumer)consumer, TwilightForestMod.prefix(processName + "_cracked_underbrick").toString());
    }
}
