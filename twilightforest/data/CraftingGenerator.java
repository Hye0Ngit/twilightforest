// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import twilightforest.block.TwilightChest;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import twilightforest.item.recipe.TFRecipes;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import java.util.Objects;
import net.minecraftforge.common.crafting.conditions.ICondition;
import twilightforest.item.recipe.UncraftingEnabledCondition;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraft.tags.Tag;
import net.minecraftforge.common.Tags;
import net.minecraft.world.item.Items;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import java.util.function.Supplier;
import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;
import net.minecraft.data.recipes.FinishedRecipe;
import java.util.function.Consumer;
import java.nio.file.Path;
import com.google.gson.JsonObject;
import net.minecraft.data.HashCache;
import net.minecraft.data.DataGenerator;

public class CraftingGenerator extends CraftingDataHelper
{
    public CraftingGenerator(final DataGenerator generator) {
        super(generator);
    }
    
    protected void m_126013_(final HashCache p_208310_1_, final JsonObject p_208310_2_, final Path p_208310_3_) {
    }
    
    protected void m_176531_(final Consumer<FinishedRecipe> consumer) {
        this.blockCompressionRecipes(consumer);
        this.equipmentRecipes(consumer);
        this.emptyMapRecipes(consumer);
        this.woodRecipes(consumer);
        this.fieryConversions(consumer);
        this.nagastoneRecipes(consumer);
        this.darkTowerRecipes(consumer);
        this.castleRecipes(consumer);
        this.bannerPattern(consumer, "naga_banner_pattern", (Supplier<? extends Block>)TFBlocks.NAGA_TROPHY, (Supplier<? extends Item>)TFItems.NAGA_BANNER_PATTERN);
        this.bannerPattern(consumer, "lich_banner_pattern", (Supplier<? extends Block>)TFBlocks.LICH_TROPHY, (Supplier<? extends Item>)TFItems.LICH_BANNER_PATTERN);
        this.bannerPattern(consumer, "minoshroom_banner_pattern", (Supplier<? extends Block>)TFBlocks.MINOSHROOM_TROPHY, (Supplier<? extends Item>)TFItems.MINOSHROOM_BANNER_PATTERN);
        this.bannerPattern(consumer, "hydra_banner_pattern", (Supplier<? extends Block>)TFBlocks.HYDRA_TROPHY, (Supplier<? extends Item>)TFItems.HYDRA_BANNER_PATTERN);
        this.bannerPattern(consumer, "knight_phantom_banner_pattern", (Supplier<? extends Block>)TFBlocks.KNIGHT_PHANTOM_TROPHY, (Supplier<? extends Item>)TFItems.KNIGHT_PHANTOM_BANNER_PATTERN);
        this.bannerPattern(consumer, "ur_ghast_banner_pattern", (Supplier<? extends Block>)TFBlocks.UR_GHAST_TROPHY, (Supplier<? extends Item>)TFItems.UR_GHAST_BANNER_PATTERN);
        this.bannerPattern(consumer, "alpha_yeti_banner_pattern", (Supplier<? extends Block>)TFBlocks.ALPHA_YETI_TROPHY, (Supplier<? extends Item>)TFItems.ALPHA_YETI_BANNER_PATTERN);
        this.bannerPattern(consumer, "snow_queen_banner_pattern", (Supplier<? extends Block>)TFBlocks.SNOW_QUEEN_TROPHY, (Supplier<? extends Item>)TFItems.SNOW_QUEEN_BANNER_PATTERN);
        this.bannerPattern(consumer, "questing_ram_banner_pattern", (Supplier<? extends Block>)TFBlocks.QUEST_RAM_TROPHY, (Supplier<? extends Item>)TFItems.QUEST_RAM_BANNER_PATTERN);
        ShapedRecipeBuilder.m_126116_((ItemLike)Blocks.f_152544_).m_126130_("mmm").m_126130_("mtm").m_126130_("mmm").m_126124_(Character.valueOf('m'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.MOSS_PATCH.get() })).m_126124_(Character.valueOf('t'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.TRANSFORMATION_POWDER.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.TRANSFORMATION_POWDER.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("tf_moss_to_vanilla"));
        ShapelessRecipeBuilder.m_126191_((ItemLike)TFBlocks.MOSS_PATCH.get(), 8).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_151016_ })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.TRANSFORMATION_POWDER.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.TRANSFORMATION_POWDER.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("vanilla_to_tf_moss"));
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFBlocks.HUGE_LILY_PAD.get()).m_126186_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50196_ }), 4).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.TRANSFORMATION_POWDER.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.TRANSFORMATION_POWDER.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("vanilla_to_tf_lilypad"));
        ShapelessRecipeBuilder.m_126191_((ItemLike)Blocks.f_50196_, 4).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.HUGE_LILY_PAD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.TRANSFORMATION_POWDER.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.TRANSFORMATION_POWDER.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("tf_to_vanilla_lilypad"));
        this.slabBlock(consumer, "aurora_slab", (Supplier<? extends Block>)TFBlocks.AURORA_SLAB, (Supplier<? extends Block>)TFBlocks.AURORA_BLOCK);
        ShapedRecipeBuilder.m_126118_((ItemLike)TFBlocks.AURORA_PILLAR.get(), 2).m_126130_("#").m_126130_("#").m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.AURORA_BLOCK.get() })).m_142284_("has_" + TFBlocks.AURORA_PILLAR.getId().m_135815_(), (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.AURORA_PILLAR.get())).m_176498_((Consumer)consumer);
        ShapedRecipeBuilder.m_126118_((ItemLike)TFBlocks.IRON_LADDER.get(), 3).m_126130_("-#-").m_126130_("-#-").m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50183_ })).m_126121_(Character.valueOf('-'), (Tag)Tags.Items.NUGGETS_IRON).m_142284_("has_" + TFBlocks.IRON_LADDER.getId().m_135815_(), (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.IRON_LADDER.get())).m_176498_((Consumer)consumer);
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFBlocks.FIREFLY_JAR.get()).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.FIREFLY.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42590_ })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.FIREFLY.get())).m_176498_((Consumer)consumer);
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFBlocks.FIREFLY_SPAWNER.get()).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.FIREFLY_JAR.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.FIREFLY.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50112_ })).m_142284_("has_jar", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.FIREFLY_JAR.get())).m_176498_((Consumer)consumer);
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFBlocks.CICADA_JAR.get()).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.CICADA.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42590_ })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.CICADA.get())).m_176498_((Consumer)consumer);
        ShapelessRecipeBuilder.m_126189_((ItemLike)Items.f_42537_).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.HUGE_WATER_LILY.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.HUGE_WATER_LILY.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("waterlily_to_magenta"));
        ShapelessRecipeBuilder.m_126189_((ItemLike)Items.f_42497_).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.THORN_ROSE.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.THORN_ROSE.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("thorn_rose_to_red"));
        ShapelessRecipeBuilder.m_126189_((ItemLike)Items.f_42398_).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ROOT_STRAND.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.ROOT_STRAND.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("root_stick"));
        ShapedRecipeBuilder.m_126118_((ItemLike)Blocks.f_50081_, 5).m_126130_("\u2234").m_126130_("|").m_126124_(Character.valueOf('\u2234'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.TORCHBERRIES.get() })).m_126121_(Character.valueOf('|'), (Tag)Tags.Items.RODS_WOODEN).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.TORCHBERRIES.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("berry_torch"));
        final ConditionalRecipe.Builder addCondition = ConditionalRecipe.builder().addCondition((ICondition)new UncraftingEnabledCondition());
        final ShapedRecipeBuilder 142284_ = ShapedRecipeBuilder.m_126116_((ItemLike)TFBlocks.UNCRAFTING_TABLE.get()).m_126130_("###").m_126130_("#X#").m_126130_("###").m_126127_(Character.valueOf('#'), (ItemLike)Blocks.f_50091_).m_126127_(Character.valueOf('X'), (ItemLike)TFItems.MAZE_MAP_FOCUS.get()).m_142284_("has_uncrafting_table", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.UNCRAFTING_TABLE.get()));
        Objects.requireNonNull(142284_);
        addCondition.addRecipe((Consumer)142284_::m_176498_).build((Consumer)consumer, TwilightForestMod.prefix("uncrafting_table"));
        this.cookingRecipes(consumer, "smelted", (SimpleCookingSerializer<?>)RecipeSerializer.f_44091_, 200);
        this.cookingRecipes(consumer, "smoked", (SimpleCookingSerializer<?>)RecipeSerializer.f_44093_, 100);
        this.cookingRecipes(consumer, "campfired", (SimpleCookingSerializer<?>)RecipeSerializer.f_44094_, 600);
        this.ingotRecipes(consumer, "smelted", (SimpleCookingSerializer<?>)RecipeSerializer.f_44091_, 200);
        this.ingotRecipes(consumer, "blasted", (SimpleCookingSerializer<?>)RecipeSerializer.f_44092_, 100);
        this.crackedWoodRecipes(consumer, "smoked", (SimpleCookingSerializer<?>)RecipeSerializer.f_44093_, 100);
        this.crackedStoneRecipes(consumer, "smelted", (SimpleCookingSerializer<?>)RecipeSerializer.f_44091_, 200);
        ShapedRecipeBuilder.m_126116_((ItemLike)TFBlocks.EMPTY_CANOPY_BOOKSHELF.get()).m_126130_("---").m_126130_("   ").m_126130_("---").m_126127_(Character.valueOf('-'), (ItemLike)TFBlocks.CANOPY_SLAB.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.CANOPY_SLAB.get())).m_176498_((Consumer)consumer);
        ShapedRecipeBuilder.m_126116_((ItemLike)TFBlocks.CANOPY_BOOKSHELF.get()).m_126130_("---").m_126130_("BBB").m_126130_("---").m_126127_(Character.valueOf('-'), (ItemLike)TFBlocks.CANOPY_PLANKS.get()).m_126127_(Character.valueOf('B'), (ItemLike)Items.f_42517_).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.CANOPY_PLANKS.get())).m_176498_((Consumer)consumer);
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.ARMOR_SHARD_CLUSTER.get()).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.ARMOR_SHARD.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("material/" + TFItems.ARMOR_SHARD_CLUSTER.getId().m_135815_()));
        ShapelessRecipeBuilder.m_126191_((ItemLike)TFBlocks.MOSSY_UNDERBRICK.get(), 1).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50191_, (ItemLike)Blocks.f_152544_ })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.UNDERBRICK.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.UNDERBRICK.get())).m_176498_((Consumer)consumer);
        ShapelessRecipeBuilder.m_126191_((ItemLike)TFBlocks.MOSSY_MAZESTONE.get(), 1).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50191_, (ItemLike)Blocks.f_152544_ })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.MAZESTONE_BRICK.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.MAZESTONE_BRICK.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("maze_stone/mossy_mazestone"));
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.CARMINITE.get()).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.BORER_ESSENCE.get() })).m_126182_((Tag)Tags.Items.DUSTS_REDSTONE).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.BORER_ESSENCE.get() })).m_126182_((Tag)Tags.Items.DUSTS_REDSTONE).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42586_ })).m_126182_((Tag)Tags.Items.DUSTS_REDSTONE).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.BORER_ESSENCE.get() })).m_126182_((Tag)Tags.Items.DUSTS_REDSTONE).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.BORER_ESSENCE.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.BORER_ESSENCE.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("material/" + TFItems.CARMINITE.getId().m_135815_()));
        ShapelessRecipeBuilder.m_126191_((ItemLike)TFItems.RAW_IRONWOOD.get(), 2).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.LIVEROOT.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_151050_ })).m_126182_((Tag)Tags.Items.NUGGETS_GOLD).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.LIVEROOT.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("material/" + TFItems.RAW_IRONWOOD.getId().m_135815_()));
    }
    
    private void darkTowerRecipes(final Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.m_126116_((ItemLike)TFBlocks.ENCASED_FIRE_JET.get()).m_126130_("#\u2234#").m_126130_("\u2234^\u2234").m_126130_("uuu").m_126121_(Character.valueOf('\u2234'), (Tag)Tags.Items.DUSTS_REDSTONE).m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ENCASED_TOWERWOOD.get() })).m_126124_(Character.valueOf('^'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.FIRE_JET.get() })).m_126124_(Character.valueOf('u'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42448_ })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.FIRE_JET.get())).m_176498_((Consumer)consumer);
        ShapedRecipeBuilder.m_126116_((ItemLike)TFBlocks.ENCASED_SMOKER.get()).m_126130_("#\u2234#").m_126130_("\u2234^\u2234").m_126130_("#\u2234#").m_126121_(Character.valueOf('\u2234'), (Tag)Tags.Items.DUSTS_REDSTONE).m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ENCASED_TOWERWOOD.get() })).m_126124_(Character.valueOf('^'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.SMOKER.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.SMOKER.get())).m_176498_((Consumer)consumer);
        ShapedRecipeBuilder.m_126116_((ItemLike)TFBlocks.CARMINITE_BUILDER.get()).m_126130_("#6#").m_126130_("6o6").m_126130_("#6#").m_126121_(Character.valueOf('6'), (Tag)ItemTagGenerator.CARMINITE_GEMS).m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ENCASED_TOWERWOOD.get() })).m_126124_(Character.valueOf('o'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50061_ })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.CARMINITE.get())).m_176498_((Consumer)consumer);
        ShapedRecipeBuilder.m_126116_((ItemLike)TFBlocks.CARMINITE_REACTOR.get()).m_126130_("#6#").m_126130_("6%6").m_126130_("#6#").m_126121_(Character.valueOf('6'), (Tag)ItemTagGenerator.CARMINITE_GEMS).m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ENCASED_TOWERWOOD.get() })).m_126121_(Character.valueOf('%'), (Tag)Tags.Items.ORES_REDSTONE).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.CARMINITE_REACTOR.get())).m_176498_((Consumer)consumer);
        ShapedRecipeBuilder.m_126118_((ItemLike)TFBlocks.REAPPEARING_BLOCK.get(), 2).m_126130_("#\u2234#").m_126130_("\u22346\u2234").m_126130_("#\u2234#").m_126121_(Character.valueOf('\u2234'), (Tag)Tags.Items.DUSTS_REDSTONE).m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ENCASED_TOWERWOOD.get() })).m_126121_(Character.valueOf('6'), (Tag)ItemTagGenerator.CARMINITE_GEMS).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.REAPPEARING_BLOCK.get())).m_176498_((Consumer)consumer);
        ShapedRecipeBuilder.m_126118_((ItemLike)TFBlocks.VANISHING_BLOCK.get(), 8).m_126130_("#w#").m_126130_("w6w").m_126130_("#w#").m_126121_(Character.valueOf('w'), (Tag)ItemTagGenerator.TOWERWOOD).m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ENCASED_TOWERWOOD.get() })).m_126121_(Character.valueOf('6'), (Tag)ItemTagGenerator.CARMINITE_GEMS).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.REAPPEARING_BLOCK.get())).m_176498_((Consumer)consumer);
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFBlocks.MOSSY_TOWERWOOD.get()).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.TOWERWOOD.get() })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50191_, (ItemLike)Blocks.f_152544_ })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.TOWERWOOD.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix("wood/" + TFBlocks.MOSSY_TOWERWOOD.getId().m_135815_()));
    }
    
    private void equipmentRecipes(final Consumer<FinishedRecipe> consumer) {
        this.bootsItem(consumer, "arctic_boots", (Supplier<? extends Item>)TFItems.ARCTIC_BOOTS, ItemTagGenerator.ARCTIC_FUR);
        this.chestplateItem(consumer, "arctic_chestplate", (Supplier<? extends Item>)TFItems.ARCTIC_CHESTPLATE, ItemTagGenerator.ARCTIC_FUR);
        this.helmetItem(consumer, "arctic_helmet", (Supplier<? extends Item>)TFItems.ARCTIC_HELMET, ItemTagGenerator.ARCTIC_FUR);
        this.leggingsItem(consumer, "arctic_leggings", (Supplier<? extends Item>)TFItems.ARCTIC_LEGGINGS, ItemTagGenerator.ARCTIC_FUR);
        this.bootsItem(consumer, "fiery_boots", (Supplier<? extends Item>)TFItems.FIERY_BOOTS, ItemTagGenerator.FIERY_INGOTS);
        this.chestplateItem(consumer, "fiery_chestplate", (Supplier<? extends Item>)TFItems.FIERY_CHESTPLATE, ItemTagGenerator.FIERY_INGOTS);
        this.helmetItem(consumer, "fiery_helmet", (Supplier<? extends Item>)TFItems.FIERY_HELMET, ItemTagGenerator.FIERY_INGOTS);
        this.leggingsItem(consumer, "fiery_leggings", (Supplier<? extends Item>)TFItems.FIERY_LEGGINGS, ItemTagGenerator.FIERY_INGOTS);
        this.swordItem(consumer, "fiery_sword", (Supplier<? extends Item>)TFItems.FIERY_SWORD, ItemTagGenerator.FIERY_INGOTS, (Tag.Named<Item>)Tags.Items.RODS_BLAZE);
        this.pickaxeItem(consumer, "fiery_pickaxe", (Supplier<? extends Item>)TFItems.FIERY_PICKAXE, ItemTagGenerator.FIERY_INGOTS, (Tag.Named<Item>)Tags.Items.RODS_BLAZE);
        this.bootsItem(consumer, "knightmetal_boots", (Supplier<? extends Item>)TFItems.KNIGHTMETAL_BOOTS, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.chestplateItem(consumer, "knightmetal_chestplate", (Supplier<? extends Item>)TFItems.KNIGHTMETAL_CHESTPLATE, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.helmetItem(consumer, "knightmetal_helmet", (Supplier<? extends Item>)TFItems.KNIGHTMETAL_HELMET, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.leggingsItem(consumer, "knightmetal_leggings", (Supplier<? extends Item>)TFItems.KNIGHTMETAL_LEGGINGS, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.pickaxeItem(consumer, "knightmetal_pickaxe", (Supplier<? extends Item>)TFItems.KNIGHTMETAL_PICKAXE, ItemTagGenerator.KNIGHTMETAL_INGOTS, (Tag.Named<Item>)Tags.Items.RODS_WOODEN);
        this.swordItem(consumer, "knightmetal_sword", (Supplier<? extends Item>)TFItems.KNIGHTMETAL_SWORD, ItemTagGenerator.KNIGHTMETAL_INGOTS, (Tag.Named<Item>)Tags.Items.RODS_WOODEN);
        this.axeItem(consumer, "knightmetal_axe", (Supplier<? extends Item>)TFItems.KNIGHTMETAL_AXE, ItemTagGenerator.KNIGHTMETAL_INGOTS, (Tag.Named<Item>)Tags.Items.RODS_WOODEN);
        ShapedRecipeBuilder.m_126116_((ItemLike)TFItems.GIANT_PICKAXE.get()).m_126130_("###").m_126130_(" X ").m_126130_(" X ").m_126127_(Character.valueOf('#'), (ItemLike)TFBlocks.GIANT_COBBLESTONE.get()).m_126127_(Character.valueOf('X'), (ItemLike)TFBlocks.GIANT_LOG.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.GIANT_COBBLESTONE.get())).m_142700_((Consumer)consumer, this.locEquip(TFItems.GIANT_PICKAXE.getId().m_135815_()));
        ShapedRecipeBuilder.m_126116_((ItemLike)TFItems.GIANT_SWORD.get()).m_126130_("#").m_126130_("#").m_126130_("X").m_126127_(Character.valueOf('#'), (ItemLike)TFBlocks.GIANT_COBBLESTONE.get()).m_126127_(Character.valueOf('X'), (ItemLike)TFBlocks.GIANT_LOG.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.GIANT_COBBLESTONE.get())).m_142700_((Consumer)consumer, this.locEquip(TFItems.GIANT_SWORD.getId().m_135815_()));
        this.charmRecipe(consumer, "charm_of_keeping_2", (Supplier<? extends Item>)TFItems.CHARM_OF_KEEPING_2, (Supplier<? extends Item>)TFItems.CHARM_OF_KEEPING_1);
        this.charmRecipe(consumer, "charm_of_keeping_3", (Supplier<? extends Item>)TFItems.CHARM_OF_KEEPING_3, (Supplier<? extends Item>)TFItems.CHARM_OF_KEEPING_2);
        this.charmRecipe(consumer, "charm_of_life_2", (Supplier<? extends Item>)TFItems.CHARM_OF_LIFE_2, (Supplier<? extends Item>)TFItems.CHARM_OF_LIFE_1);
        SpecialRecipeBuilder.m_126357_((SimpleRecipeSerializer)TFRecipes.MOONWORM_QUEEN_REPAIR_RECIPE.get()).m_126359_((Consumer)consumer, TwilightForestMod.prefix("moonworm_queen_repair_recipe").toString());
        ShapelessRecipeBuilder.m_126191_((ItemLike)Blocks.f_50652_, 64).m_126209_((ItemLike)TFBlocks.GIANT_COBBLESTONE.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.GIANT_COBBLESTONE.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix(TFBlocks.GIANT_COBBLESTONE.getId().m_135815_() + "_to_" + Blocks.f_50652_.m_5456_().getRegistryName().m_135815_()));
        ShapelessRecipeBuilder.m_126191_((ItemLike)Blocks.f_50705_, 64).m_126209_((ItemLike)TFBlocks.GIANT_LOG.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.GIANT_LOG.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix(TFBlocks.GIANT_LOG.getId().m_135815_() + "_to_" + Blocks.f_50705_.m_5456_().getRegistryName().m_135815_()));
        ShapelessRecipeBuilder.m_126191_((ItemLike)Blocks.f_50050_, 64).m_126209_((ItemLike)TFBlocks.GIANT_LEAVES.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.GIANT_LOG.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix(TFBlocks.GIANT_LEAVES.getId().m_135815_() + "_to_" + Blocks.f_50050_.m_5456_().getRegistryName().m_135815_()));
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.BLOCK_AND_CHAIN.get()).m_126182_((Tag)ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL).m_126182_((Tag)ItemTagGenerator.KNIGHTMETAL_INGOTS).m_126182_((Tag)ItemTagGenerator.KNIGHTMETAL_INGOTS).m_126182_((Tag)ItemTagGenerator.KNIGHTMETAL_INGOTS).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.KNIGHTMETAL_RING.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.KNIGHTMETAL_BLOCK.get())).m_142700_((Consumer)consumer, this.locEquip(TFItems.BLOCK_AND_CHAIN.getId().m_135815_()));
        ShapedRecipeBuilder.m_126116_((ItemLike)TFItems.KNIGHTMETAL_RING.get()).m_126130_(" - ").m_126130_("- -").m_126130_(" - ").m_126121_(Character.valueOf('-'), (Tag)ItemTagGenerator.KNIGHTMETAL_INGOTS).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.KNIGHTMETAL_INGOT.get())).m_142700_((Consumer)consumer, this.locEquip(TFItems.KNIGHTMETAL_RING.getId().m_135815_()));
        ShapedRecipeBuilder.m_126116_((ItemLike)TFItems.KNIGHTMETAL_SHIELD.get()).m_126130_("-#").m_126130_("-o").m_126130_("-#").m_126121_(Character.valueOf('-'), (Tag)ItemTagGenerator.KNIGHTMETAL_INGOTS).m_126121_(Character.valueOf('#'), (Tag)ItemTagGenerator.TOWERWOOD).m_126124_(Character.valueOf('o'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.KNIGHTMETAL_RING.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.KNIGHTMETAL_INGOT.get())).m_142700_((Consumer)consumer, this.locEquip(TFItems.KNIGHTMETAL_SHIELD.getId().m_135815_()));
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.LIFEDRAIN_SCEPTER.get()).m_126184_(this.itemWithNBT((RegistryObject<? extends ItemLike>)TFItems.LIFEDRAIN_SCEPTER, nbt -> nbt.m_128405_("Damage", ((Item)TFItems.LIFEDRAIN_SCEPTER.get()).m_41462_()))).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42592_ })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.LIFEDRAIN_SCEPTER.get())).m_142700_((Consumer)consumer, this.locEquip(TFItems.LIFEDRAIN_SCEPTER.getId().m_135815_()));
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.FORTIFICATION_SCEPTER.get()).m_126184_(this.itemWithNBT((RegistryObject<? extends ItemLike>)TFItems.FORTIFICATION_SCEPTER, nbt -> nbt.m_128405_("Damage", ((Item)TFItems.FORTIFICATION_SCEPTER.get()).m_41462_()))).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42436_ })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.FORTIFICATION_SCEPTER.get())).m_142700_((Consumer)consumer, this.locEquip(TFItems.FORTIFICATION_SCEPTER.getId().m_135815_()));
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.TWILIGHT_SCEPTER.get()).m_126184_(this.itemWithNBT((RegistryObject<? extends ItemLike>)TFItems.TWILIGHT_SCEPTER, nbt -> nbt.m_128405_("Damage", ((Item)TFItems.TWILIGHT_SCEPTER.get()).m_41462_()))).m_126182_((Tag)Tags.Items.ENDER_PEARLS).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.TWILIGHT_SCEPTER.get())).m_142700_((Consumer)consumer, this.locEquip(TFItems.TWILIGHT_SCEPTER.getId().m_135815_()));
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.ZOMBIE_SCEPTER.get()).m_126184_(this.multipleIngredients(this.itemWithNBT((ItemLike)Items.f_42589_, nbt -> nbt.m_128359_("Potion", "minecraft:strength")), this.itemWithNBT((ItemLike)Items.f_42589_, nbt -> nbt.m_128359_("Potion", "minecraft:strong_strength")), this.itemWithNBT((ItemLike)Items.f_42589_, nbt -> nbt.m_128359_("Potion", "minecraft:long_strength")))).m_126184_(this.itemWithNBT((RegistryObject<? extends ItemLike>)TFItems.ZOMBIE_SCEPTER, nbt -> nbt.m_128405_("Damage", ((Item)TFItems.ZOMBIE_SCEPTER.get()).m_41462_()))).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42583_ })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.ZOMBIE_SCEPTER.get())).m_142700_((Consumer)consumer, this.locEquip(TFItems.ZOMBIE_SCEPTER.getId().m_135815_()));
    }
    
    private void blockCompressionRecipes(final Consumer<FinishedRecipe> consumer) {
        this.reverseCompressBlock(consumer, "arctic_block_to_item", (Supplier<? extends Item>)TFItems.ARCTIC_FUR, ItemTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR);
        this.reverseCompressBlock(consumer, "carminite_block_to_item", (Supplier<? extends Item>)TFItems.CARMINITE, ItemTagGenerator.STORAGE_BLOCKS_CARMINITE);
        this.reverseCompressBlock(consumer, "fiery_block_to_ingot", (Supplier<? extends Item>)TFItems.FIERY_INGOT, ItemTagGenerator.STORAGE_BLOCKS_FIERY);
        this.reverseCompressBlock(consumer, "ironwood_block_ingot", (Supplier<? extends Item>)TFItems.IRONWOOD_INGOT, ItemTagGenerator.STORAGE_BLOCKS_IRONWOOD);
        this.reverseCompressBlock(consumer, "knightmetal_block_ingot", (Supplier<? extends Item>)TFItems.KNIGHTMETAL_INGOT, ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL);
        this.reverseCompressBlock(consumer, "steeleaf_block_ingot", (Supplier<? extends Item>)TFItems.STEELEAF_INGOT, ItemTagGenerator.STORAGE_BLOCKS_STEELEAF);
        this.compressedBlock(consumer, "arctic_block", (Supplier<? extends Block>)TFBlocks.ARCTIC_FUR_BLOCK, ItemTagGenerator.ARCTIC_FUR);
        this.compressedBlock(consumer, "carminite_block", (Supplier<? extends Block>)TFBlocks.CARMINITE_BLOCK, ItemTagGenerator.CARMINITE_GEMS);
        this.compressedBlock(consumer, "fiery_block", (Supplier<? extends Block>)TFBlocks.FIERY_BLOCK, ItemTagGenerator.FIERY_INGOTS);
        this.compressedBlock(consumer, "ironwood_block", (Supplier<? extends Block>)TFBlocks.IRONWOOD_BLOCK, ItemTagGenerator.IRONWOOD_INGOTS);
        this.compressedBlock(consumer, "knightmetal_block", (Supplier<? extends Block>)TFBlocks.KNIGHTMETAL_BLOCK, ItemTagGenerator.KNIGHTMETAL_INGOTS);
        this.compressedBlock(consumer, "steeleaf_block", (Supplier<? extends Block>)TFBlocks.STEELEAF_BLOCK, ItemTagGenerator.STEELEAF_INGOTS);
    }
    
    private void emptyMapRecipes(final Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.MAGIC_MAP_FOCUS.get()).m_126209_((ItemLike)TFItems.RAVEN_FEATHER.get()).m_126209_((ItemLike)TFItems.TORCHBERRIES.get()).m_126182_((Tag)Tags.Items.DUSTS_GLOWSTONE).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.TORCHBERRIES.get())).m_176498_((Consumer)consumer);
        ShapedRecipeBuilder.m_126116_((ItemLike)TFItems.MAGIC_MAP.get()).m_126130_("###").m_126130_("#\u2022#").m_126130_("###").m_126121_(Character.valueOf('#'), (Tag)ItemTagGenerator.PAPER).m_126124_(Character.valueOf('\u2022'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.MAGIC_MAP_FOCUS.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.MAGIC_MAP_FOCUS.get())).m_176498_((Consumer)consumer);
        ShapedRecipeBuilder.m_126116_((ItemLike)TFItems.MAZE_MAP.get()).m_126130_("###").m_126130_("#\u2022#").m_126130_("###").m_126121_(Character.valueOf('#'), (Tag)ItemTagGenerator.PAPER).m_126124_(Character.valueOf('\u2022'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.MAZE_MAP_FOCUS.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.MAZE_MAP_FOCUS.get())).m_176498_((Consumer)consumer);
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.ORE_MAP.get()).m_126209_((ItemLike)TFItems.MAZE_MAP.get()).m_126182_((Tag)Tags.Items.STORAGE_BLOCKS_DIAMOND).m_126182_((Tag)Tags.Items.STORAGE_BLOCKS_GOLD).m_126182_((Tag)Tags.Items.STORAGE_BLOCKS_IRON).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.ORE_MAGNET.get())).m_176498_((Consumer)consumer);
    }
    
    private void woodRecipes(final Consumer<FinishedRecipe> consumer) {
        this.buttonBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_BUTTON, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS);
        this.buttonBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARK_BUTTON, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS);
        this.buttonBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_BUTTON, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS);
        this.buttonBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_BUTTON, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS);
        this.buttonBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_BUTTON, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS);
        this.buttonBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_BUTTON, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS);
        this.buttonBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_BUTTON, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS);
        this.buttonBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_BUTTON, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS);
        this.doorBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_DOOR, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS);
        this.doorBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARK_DOOR, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS);
        this.doorBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_DOOR, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS);
        this.doorBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_DOOR, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS);
        this.doorBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_DOOR, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS);
        this.doorBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_DOOR, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS);
        this.doorBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_DOOR, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS);
        this.doorBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_DOOR, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS);
        this.fenceBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_FENCE, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS);
        this.fenceBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARK_FENCE, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS);
        this.fenceBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_FENCE, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS);
        this.fenceBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_FENCE, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS);
        this.fenceBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_FENCE, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS);
        this.fenceBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_FENCE, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS);
        this.fenceBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_FENCE, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS);
        this.fenceBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_FENCE, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS);
        this.gateBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_GATE, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS);
        this.gateBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARK_GATE, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS);
        this.gateBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_GATE, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS);
        this.gateBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_GATE, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS);
        this.gateBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_GATE, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS);
        this.gateBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_GATE, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS);
        this.gateBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_GATE, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS);
        this.gateBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_GATE, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS);
        this.planksBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS, (Supplier<? extends Block>)TFBlocks.CANOPY_LOG);
        this.planksBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARK_PLANKS, (Supplier<? extends Block>)TFBlocks.DARK_LOG);
        this.planksBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS, (Supplier<? extends Block>)TFBlocks.MANGROVE_LOG);
        this.planksBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_PLANKS, (Supplier<? extends Block>)TFBlocks.MINING_LOG);
        this.planksBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS, (Supplier<? extends Block>)TFBlocks.SORTING_LOG);
        this.planksBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_PLANKS, (Supplier<? extends Block>)TFBlocks.TIME_LOG);
        this.planksBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_LOG);
        this.planksBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_LOG);
        this.planksBlock(consumer, "canopy_from_stripped", (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_CANOPY_LOG);
        this.planksBlock(consumer, "darkwood_from_stripped", (Supplier<? extends Block>)TFBlocks.DARK_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_DARK_LOG);
        this.planksBlock(consumer, "mangrove_from_stripped", (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_MANGROVE_LOG);
        this.planksBlock(consumer, "mining_from_stripped", (Supplier<? extends Block>)TFBlocks.MINING_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_MINING_LOG);
        this.planksBlock(consumer, "sorting_from_stripped", (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_SORTING_LOG);
        this.planksBlock(consumer, "time_from_stripped", (Supplier<? extends Block>)TFBlocks.TIME_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_TIME_LOG);
        this.planksBlock(consumer, "transformation_from_stripped", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_TRANSFORMATION_LOG);
        this.planksBlock(consumer, "twilight_oak_from_stripped", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_TWILIGHT_OAK_LOG);
        this.planksBlock(consumer, "canopy_from_wood", (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS, (Supplier<? extends Block>)TFBlocks.CANOPY_WOOD);
        this.planksBlock(consumer, "darkwood_from_wood", (Supplier<? extends Block>)TFBlocks.DARK_PLANKS, (Supplier<? extends Block>)TFBlocks.DARK_WOOD);
        this.planksBlock(consumer, "mangrove_from_wood", (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS, (Supplier<? extends Block>)TFBlocks.MANGROVE_WOOD);
        this.planksBlock(consumer, "mining_from_wood", (Supplier<? extends Block>)TFBlocks.MINING_PLANKS, (Supplier<? extends Block>)TFBlocks.MINING_WOOD);
        this.planksBlock(consumer, "sorting_from_wood", (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS, (Supplier<? extends Block>)TFBlocks.SORTING_WOOD);
        this.planksBlock(consumer, "time_from_wood", (Supplier<? extends Block>)TFBlocks.TIME_PLANKS, (Supplier<? extends Block>)TFBlocks.TIME_WOOD);
        this.planksBlock(consumer, "transformation_from_wood", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_WOOD);
        this.planksBlock(consumer, "twilight_oak_from_wood", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_WOOD);
        this.planksBlock(consumer, "canopy_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_CANOPY_WOOD);
        this.planksBlock(consumer, "darkwood_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.DARK_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_DARK_WOOD);
        this.planksBlock(consumer, "mangrove_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_MANGROVE_WOOD);
        this.planksBlock(consumer, "mining_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.MINING_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_MINING_WOOD);
        this.planksBlock(consumer, "sorting_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_SORTING_WOOD);
        this.planksBlock(consumer, "time_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.TIME_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_TIME_WOOD);
        this.planksBlock(consumer, "transformation_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_TRANSFORMATION_WOOD);
        this.planksBlock(consumer, "twilight_oak_from_stripped_wood", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS, (Supplier<? extends Block>)TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD);
        this.woodBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_WOOD, (Supplier<? extends Block>)TFBlocks.CANOPY_LOG);
        this.woodBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARK_WOOD, (Supplier<? extends Block>)TFBlocks.DARK_LOG);
        this.woodBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_WOOD, (Supplier<? extends Block>)TFBlocks.MANGROVE_LOG);
        this.woodBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_WOOD, (Supplier<? extends Block>)TFBlocks.MINING_LOG);
        this.woodBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_WOOD, (Supplier<? extends Block>)TFBlocks.SORTING_LOG);
        this.woodBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_WOOD, (Supplier<? extends Block>)TFBlocks.TIME_LOG);
        this.woodBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_WOOD, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_LOG);
        this.woodBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_WOOD, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_LOG);
        this.strippedWoodBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.STRIPPED_CANOPY_WOOD, (Supplier<? extends Block>)TFBlocks.STRIPPED_CANOPY_LOG);
        this.strippedWoodBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.STRIPPED_DARK_WOOD, (Supplier<? extends Block>)TFBlocks.STRIPPED_DARK_LOG);
        this.strippedWoodBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.STRIPPED_MANGROVE_WOOD, (Supplier<? extends Block>)TFBlocks.STRIPPED_MANGROVE_LOG);
        this.strippedWoodBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.STRIPPED_MINING_WOOD, (Supplier<? extends Block>)TFBlocks.STRIPPED_MINING_LOG);
        this.strippedWoodBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.STRIPPED_SORTING_WOOD, (Supplier<? extends Block>)TFBlocks.STRIPPED_SORTING_LOG);
        this.strippedWoodBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.STRIPPED_TIME_WOOD, (Supplier<? extends Block>)TFBlocks.STRIPPED_TIME_LOG);
        this.strippedWoodBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.STRIPPED_TRANSFORMATION_WOOD, (Supplier<? extends Block>)TFBlocks.STRIPPED_TRANSFORMATION_LOG);
        this.strippedWoodBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD, (Supplier<? extends Block>)TFBlocks.STRIPPED_TWILIGHT_OAK_LOG);
        this.plateBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_PLATE, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS);
        this.plateBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARK_PLATE, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS);
        this.plateBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_PLATE, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS);
        this.plateBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_PLATE, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS);
        this.plateBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_PLATE, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS);
        this.plateBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_PLATE, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS);
        this.plateBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLATE, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS);
        this.plateBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLATE, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS);
        this.slabBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_SLAB, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS);
        this.slabBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARK_SLAB, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS);
        this.slabBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_SLAB, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS);
        this.slabBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_SLAB, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS);
        this.slabBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_SLAB, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS);
        this.slabBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_SLAB, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS);
        this.slabBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_SLAB, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS);
        this.slabBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_SLAB, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS);
        this.stairsBlock(consumer, this.locWood("canopy_stairs"), (Supplier<? extends Block>)TFBlocks.CANOPY_STAIRS, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS, (ItemLike)TFBlocks.CANOPY_PLANKS.get());
        this.stairsBlock(consumer, this.locWood("darkwood_stairs"), (Supplier<? extends Block>)TFBlocks.DARK_STAIRS, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS, (ItemLike)TFBlocks.DARK_PLANKS.get());
        this.stairsBlock(consumer, this.locWood("mangrove_stairs"), (Supplier<? extends Block>)TFBlocks.MANGROVE_STAIRS, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS, (ItemLike)TFBlocks.MANGROVE_PLANKS.get());
        this.stairsBlock(consumer, this.locWood("mining_stairs"), (Supplier<? extends Block>)TFBlocks.MINING_STAIRS, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS, (ItemLike)TFBlocks.MINING_PLANKS.get());
        this.stairsBlock(consumer, this.locWood("sorting_stairs"), (Supplier<? extends Block>)TFBlocks.SORTING_STAIRS, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS, (ItemLike)TFBlocks.SORTING_PLANKS.get());
        this.stairsBlock(consumer, this.locWood("time_stairs"), (Supplier<? extends Block>)TFBlocks.TIME_STAIRS, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS, (ItemLike)TFBlocks.TIME_PLANKS.get());
        this.stairsBlock(consumer, this.locWood("transformation_stairs"), (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_STAIRS, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS, (ItemLike)TFBlocks.TRANSFORMATION_PLANKS.get());
        this.stairsBlock(consumer, this.locWood("twilight_oak_stairs"), (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_STAIRS, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS, (ItemLike)TFBlocks.TWILIGHT_OAK_PLANKS.get());
        this.trapdoorBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_TRAPDOOR, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS);
        this.trapdoorBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARK_TRAPDOOR, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS);
        this.trapdoorBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_TRAPDOOR, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS);
        this.trapdoorBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_TRAPDOOR, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS);
        this.trapdoorBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_TRAPDOOR, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS);
        this.trapdoorBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_TRAPDOOR, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS);
        this.trapdoorBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_TRAPDOOR, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS);
        this.trapdoorBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_TRAPDOOR, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS);
        this.signBlock(consumer, "canopy_sign", (Supplier<? extends Block>)TFBlocks.CANOPY_SIGN, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS);
        this.signBlock(consumer, "darkwood_sign", (Supplier<? extends Block>)TFBlocks.DARKWOOD_SIGN, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS);
        this.signBlock(consumer, "mangrove_sign", (Supplier<? extends Block>)TFBlocks.MANGROVE_SIGN, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS);
        this.signBlock(consumer, "mining_sign", (Supplier<? extends Block>)TFBlocks.MINING_SIGN, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS);
        this.signBlock(consumer, "sorting_sign", (Supplier<? extends Block>)TFBlocks.SORTING_SIGN, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS);
        this.signBlock(consumer, "time_sign", (Supplier<? extends Block>)TFBlocks.TIME_SIGN, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS);
        this.signBlock(consumer, "transformation_sign", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_SIGN, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS);
        this.signBlock(consumer, "twilight_oak_sign", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_SIGN, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS);
        this.banisterBlock(consumer, "canopy", (Supplier<? extends Block>)TFBlocks.CANOPY_BANISTER, (Supplier<? extends Block>)TFBlocks.CANOPY_SLAB);
        this.banisterBlock(consumer, "darkwood", (Supplier<? extends Block>)TFBlocks.DARKWOOD_BANISTER, (Supplier<? extends Block>)TFBlocks.DARK_SLAB);
        this.banisterBlock(consumer, "mangrove", (Supplier<? extends Block>)TFBlocks.MANGROVE_BANISTER, (Supplier<? extends Block>)TFBlocks.MANGROVE_SLAB);
        this.banisterBlock(consumer, "mining", (Supplier<? extends Block>)TFBlocks.MINING_BANISTER, (Supplier<? extends Block>)TFBlocks.MINING_SLAB);
        this.banisterBlock(consumer, "sorting", (Supplier<? extends Block>)TFBlocks.SORTING_BANISTER, (Supplier<? extends Block>)TFBlocks.SORTING_SLAB);
        this.banisterBlock(consumer, "time", (Supplier<? extends Block>)TFBlocks.TIME_BANISTER, (Supplier<? extends Block>)TFBlocks.TIME_SLAB);
        this.banisterBlock(consumer, "transformation", (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_BANISTER, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_SLAB);
        this.banisterBlock(consumer, "twilight_oak", (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_BANISTER, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_SLAB);
        this.banisterBlock(consumer, "oak", (Supplier<? extends Block>)TFBlocks.OAK_BANISTER, Blocks.f_50398_);
        this.banisterBlock(consumer, "spruce", (Supplier<? extends Block>)TFBlocks.SPRUCE_BANISTER, Blocks.f_50399_);
        this.banisterBlock(consumer, "birch", (Supplier<? extends Block>)TFBlocks.BIRCH_BANISTER, Blocks.f_50400_);
        this.banisterBlock(consumer, "jungle", (Supplier<? extends Block>)TFBlocks.JUNGLE_BANISTER, Blocks.f_50401_);
        this.banisterBlock(consumer, "acacia", (Supplier<? extends Block>)TFBlocks.ACACIA_BANISTER, Blocks.f_50402_);
        this.banisterBlock(consumer, "dark_oak", (Supplier<? extends Block>)TFBlocks.DARK_OAK_BANISTER, Blocks.f_50403_);
        this.banisterBlock(consumer, "crimson", (Supplier<? extends Block>)TFBlocks.CRIMSON_BANISTER, Blocks.f_50657_);
        this.banisterBlock(consumer, "warped", (Supplier<? extends Block>)TFBlocks.WARPED_BANISTER, Blocks.f_50658_);
        this.chestBlock(consumer, "twilight_oak", (Supplier<? extends TwilightChest>)TFBlocks.TWILIGHT_OAK_CHEST, (Supplier<? extends Block>)TFBlocks.TWILIGHT_OAK_PLANKS);
        this.chestBlock(consumer, "canopy", (Supplier<? extends TwilightChest>)TFBlocks.CANOPY_CHEST, (Supplier<? extends Block>)TFBlocks.CANOPY_PLANKS);
        this.chestBlock(consumer, "mangrove", (Supplier<? extends TwilightChest>)TFBlocks.MANGROVE_CHEST, (Supplier<? extends Block>)TFBlocks.MANGROVE_PLANKS);
        this.chestBlock(consumer, "darkwood", (Supplier<? extends TwilightChest>)TFBlocks.DARKWOOD_CHEST, (Supplier<? extends Block>)TFBlocks.DARK_PLANKS);
        this.chestBlock(consumer, "time", (Supplier<? extends TwilightChest>)TFBlocks.TIME_CHEST, (Supplier<? extends Block>)TFBlocks.TIME_PLANKS);
        this.chestBlock(consumer, "transformation", (Supplier<? extends TwilightChest>)TFBlocks.TRANSFORMATION_CHEST, (Supplier<? extends Block>)TFBlocks.TRANSFORMATION_PLANKS);
        this.chestBlock(consumer, "mining", (Supplier<? extends TwilightChest>)TFBlocks.MINING_CHEST, (Supplier<? extends Block>)TFBlocks.MINING_PLANKS);
        this.chestBlock(consumer, "sorting", (Supplier<? extends TwilightChest>)TFBlocks.SORTING_CHEST, (Supplier<? extends Block>)TFBlocks.SORTING_PLANKS);
    }
    
    private void nagastoneRecipes(final Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.m_126118_((ItemLike)TFBlocks.SPIRAL_BRICKS.get(), 8).m_126130_("BSS").m_126130_("BSS").m_126130_("BBB").m_126124_(Character.valueOf('B'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50222_, (ItemLike)Blocks.f_50223_, (ItemLike)Blocks.f_50224_, (ItemLike)Blocks.f_50225_ })).m_126124_(Character.valueOf('S'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50404_, (ItemLike)Blocks.f_50411_ })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.SPIRAL_BRICKS.get())).m_142700_((Consumer)consumer, this.locNaga("nagastone_spiral"));
        this.stairsBlock(consumer, this.locNaga("nagastone_stairs_left"), (Supplier<? extends Block>)TFBlocks.NAGASTONE_STAIRS_LEFT, (Supplier<? extends Block>)TFBlocks.ETCHED_NAGASTONE, (ItemLike)TFBlocks.ETCHED_NAGASTONE.get());
        this.stairsRightBlock(consumer, this.locNaga("nagastone_stairs_right"), (Supplier<? extends Block>)TFBlocks.NAGASTONE_STAIRS_RIGHT, (Supplier<? extends Block>)TFBlocks.ETCHED_NAGASTONE, (ItemLike)TFBlocks.ETCHED_NAGASTONE.get());
        this.stairsBlock(consumer, this.locNaga("mossy_nagastone_stairs_left"), (Supplier<? extends Block>)TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT, (Supplier<? extends Block>)TFBlocks.MOSSY_ETCHED_NAGASTONE, (ItemLike)TFBlocks.MOSSY_ETCHED_NAGASTONE.get());
        this.stairsRightBlock(consumer, this.locNaga("mossy_nagastone_stairs_right"), (Supplier<? extends Block>)TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT, (Supplier<? extends Block>)TFBlocks.MOSSY_ETCHED_NAGASTONE, (ItemLike)TFBlocks.MOSSY_ETCHED_NAGASTONE.get());
        ShapelessRecipeBuilder.m_126191_((ItemLike)TFBlocks.MOSSY_ETCHED_NAGASTONE.get(), 1).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50191_, (ItemLike)Blocks.f_152544_ })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ETCHED_NAGASTONE.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.ETCHED_NAGASTONE.get())).m_142700_((Consumer)consumer, this.locNaga("mossy_etched_nagastone"));
        ShapelessRecipeBuilder.m_126191_((ItemLike)TFBlocks.MOSSY_NAGASTONE_PILLAR.get(), 1).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50191_, (ItemLike)Blocks.f_152544_ })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.NAGASTONE_PILLAR.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.NAGASTONE_PILLAR.get())).m_142700_((Consumer)consumer, this.locNaga("mossy_nagastone_pillar"));
        this.stairsBlock(consumer, this.locNaga("cracked_nagastone_stairs_left"), (Supplier<? extends Block>)TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT, (Supplier<? extends Block>)TFBlocks.CRACKED_ETCHED_NAGASTONE, (ItemLike)TFBlocks.CRACKED_ETCHED_NAGASTONE.get());
        this.stairsRightBlock(consumer, this.locNaga("cracked_nagastone_stairs_right"), (Supplier<? extends Block>)TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT, (Supplier<? extends Block>)TFBlocks.CRACKED_ETCHED_NAGASTONE, (ItemLike)TFBlocks.CRACKED_ETCHED_NAGASTONE.get());
    }
    
    private void castleRecipes(final Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.m_126191_((ItemLike)TFBlocks.MOSSY_CASTLE_BRICK.get(), 1).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50191_, (ItemLike)Blocks.f_152544_ })).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.CASTLE_BRICK.get() })).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.CASTLE_BRICK.get())).m_142700_((Consumer)consumer, this.locCastle("mossy_castle_brick"));
        this.castleBlock(consumer, (Supplier<? extends Block>)TFBlocks.THICK_CASTLE_BRICK, (ItemLike)TFBlocks.CASTLE_BRICK.get(), (ItemLike)TFBlocks.WORN_CASTLE_BRICK.get(), (ItemLike)TFBlocks.CRACKED_CASTLE_BRICK.get(), (ItemLike)TFBlocks.MOSSY_CASTLE_BRICK.get());
        this.castleBlock(consumer, (Supplier<? extends Block>)TFBlocks.BOLD_CASTLE_BRICK_PILLAR, (ItemLike)TFBlocks.THICK_CASTLE_BRICK.get());
        this.castleBlock(consumer, (Supplier<? extends Block>)TFBlocks.BOLD_CASTLE_BRICK_TILE, (ItemLike)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get());
        ShapedRecipeBuilder.m_126118_((ItemLike)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get(), 4).m_126130_("##").m_126130_("##").m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.BOLD_CASTLE_BRICK_TILE.get() })).m_142284_("has_castle_brick", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.CASTLE_BRICK.get())).m_142700_((Consumer)consumer, this.locCastle("bold_castle_pillar_from_tile"));
        ShapedRecipeBuilder.m_126118_((ItemLike)TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.get(), 6).m_126130_("#H#").m_126130_("#H#").m_126124_(Character.valueOf('#'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.CASTLE_BRICK.get(), (ItemLike)TFBlocks.WORN_CASTLE_BRICK.get(), (ItemLike)TFBlocks.CRACKED_CASTLE_BRICK.get(), (ItemLike)TFBlocks.MOSSY_CASTLE_BRICK.get(), (ItemLike)TFBlocks.THICK_CASTLE_BRICK.get() })).m_126124_(Character.valueOf('H'), Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.get(), (ItemLike)TFBlocks.ENCASED_CASTLE_BRICK_TILE.get(), (ItemLike)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get(), (ItemLike)TFBlocks.BOLD_CASTLE_BRICK_TILE.get() })).m_142284_("has_castle_brick", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.CASTLE_BRICK.get())).m_142700_((Consumer)consumer, this.locCastle("encased_castle_pillar"));
        this.stairsBlock(consumer, this.locCastle("bold_castle_brick_stairs"), (Supplier<? extends Block>)TFBlocks.BOLD_CASTLE_BRICK_STAIRS, (Supplier<? extends Block>)TFBlocks.BOLD_CASTLE_BRICK_PILLAR, (ItemLike)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get(), (ItemLike)TFBlocks.BOLD_CASTLE_BRICK_TILE.get());
        this.stairsBlock(consumer, this.locCastle("castle_brick_stairs"), (Supplier<? extends Block>)TFBlocks.CASTLE_BRICK_STAIRS, (Supplier<? extends Block>)TFBlocks.CASTLE_BRICK, (ItemLike)TFBlocks.CASTLE_BRICK.get());
        this.stairsBlock(consumer, this.locCastle("cracked_castle_brick_stairs"), (Supplier<? extends Block>)TFBlocks.CRACKED_CASTLE_BRICK_STAIRS, (Supplier<? extends Block>)TFBlocks.CRACKED_CASTLE_BRICK, (ItemLike)TFBlocks.CRACKED_CASTLE_BRICK.get());
        this.stairsBlock(consumer, this.locCastle("encased_castle_brick_stairs"), (Supplier<? extends Block>)TFBlocks.ENCASED_CASTLE_BRICK_STAIRS, (Supplier<? extends Block>)TFBlocks.ENCASED_CASTLE_BRICK_PILLAR, (ItemLike)TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.get(), (ItemLike)TFBlocks.ENCASED_CASTLE_BRICK_TILE.get());
        this.stairsBlock(consumer, this.locCastle("mossy_castle_brick_stairs"), (Supplier<? extends Block>)TFBlocks.MOSSY_CASTLE_BRICK_STAIRS, (Supplier<? extends Block>)TFBlocks.MOSSY_CASTLE_BRICK, (ItemLike)TFBlocks.MOSSY_CASTLE_BRICK.get());
        this.stairsBlock(consumer, this.locCastle("worn_castle_brick_stairs"), (Supplier<? extends Block>)TFBlocks.WORN_CASTLE_BRICK_STAIRS, (Supplier<? extends Block>)TFBlocks.WORN_CASTLE_BRICK, (ItemLike)TFBlocks.WORN_CASTLE_BRICK.get());
    }
    
    private void fieryConversions(final Consumer<FinishedRecipe> consumer) {
        UpgradeRecipeBuilder.m_126385_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42416_ }), Ingredient.m_43911_((Tag)ItemTagGenerator.FIERY_VIAL), (Item)TFItems.FIERY_INGOT.get()).m_126389_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.FIERY_INGOT.get())).m_126395_((Consumer)consumer, TwilightForestMod.prefix("material/fiery_iron_ingot"));
        UpgradeRecipeBuilder.m_126385_(Ingredient.m_43911_((Tag)ItemTagGenerator.FIERY_VIAL), Ingredient.m_43929_(new ItemLike[] { (ItemLike)Items.f_42416_ }), (Item)TFItems.FIERY_INGOT.get()).m_126389_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.FIERY_INGOT.get())).m_126395_((Consumer)consumer, TwilightForestMod.prefix("material/fiery_iron_ingot_reversed"));
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.FIERY_INGOT.get()).m_126184_(Ingredient.m_43911_((Tag)ItemTagGenerator.FIERY_VIAL)).m_126184_(Ingredient.m_43911_((Tag)Tags.Items.INGOTS_IRON)).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)ItemTagGenerator.FIERY_VIAL)).m_142700_((Consumer)consumer, this.locEquip("fiery_ingot_crafting"));
        this.fieryConversion(consumer, (Supplier<? extends Item>)TFItems.FIERY_HELMET, Items.f_42468_, 5);
        this.fieryConversion(consumer, (Supplier<? extends Item>)TFItems.FIERY_CHESTPLATE, Items.f_42469_, 8);
        this.fieryConversion(consumer, (Supplier<? extends Item>)TFItems.FIERY_LEGGINGS, Items.f_42470_, 7);
        this.fieryConversion(consumer, (Supplier<? extends Item>)TFItems.FIERY_BOOTS, Items.f_42471_, 4);
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.FIERY_SWORD.get()).m_126209_((ItemLike)Items.f_42383_).m_126186_(Ingredient.m_43911_((Tag)ItemTagGenerator.FIERY_VIAL), 2).m_126184_(Ingredient.m_43911_((Tag)Tags.Items.RODS_BLAZE)).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)ItemTagGenerator.FIERY_VIAL)).m_142700_((Consumer)consumer, this.locEquip("fiery_" + Items.f_42383_.getRegistryName().m_135815_()));
        ShapelessRecipeBuilder.m_126189_((ItemLike)TFItems.FIERY_PICKAXE.get()).m_126209_((ItemLike)Items.f_42385_).m_126186_(Ingredient.m_43911_((Tag)ItemTagGenerator.FIERY_VIAL), 3).m_126186_(Ingredient.m_43911_((Tag)Tags.Items.RODS_BLAZE), 2).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)ItemTagGenerator.FIERY_VIAL)).m_142700_((Consumer)consumer, this.locEquip("fiery_" + Items.f_42385_.getRegistryName().m_135815_()));
    }
    
    private void cookingRecipes(final Consumer<FinishedRecipe> consumer, final String processName, final SimpleCookingSerializer<?> process, final int smeltingTime) {
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.RAW_MEEF.get() }), (ItemLike)TFItems.COOKED_MEEF.get(), 0.3f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_food", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.RAW_MEEF.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix("food/" + processName + "_meef").toString());
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.RAW_VENISON.get() }), (ItemLike)TFItems.COOKED_VENISON.get(), 0.3f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_food", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.RAW_VENISON.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix("food/" + processName + "_venison").toString());
    }
    
    private void ingotRecipes(final Consumer<FinishedRecipe> consumer, final String processName, final SimpleCookingSerializer<?> process, final int smeltingTime) {
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.ARMOR_SHARD_CLUSTER.get() }), (ItemLike)TFItems.KNIGHTMETAL_INGOT.get(), 1.0f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.ARMOR_SHARD_CLUSTER.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix("material/" + processName + "_knightmetal_ingot").toString());
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.RAW_IRONWOOD.get() }), (ItemLike)TFItems.IRONWOOD_INGOT.get(), 1.0f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFItems.RAW_IRONWOOD.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix("material/" + processName + "_ironwood_ingot").toString());
    }
    
    private void crackedWoodRecipes(final Consumer<FinishedRecipe> consumer, final String processName, final SimpleCookingSerializer<?> process, final int smeltingTime) {
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.TOWERWOOD.get() }), (ItemLike)TFBlocks.CRACKED_TOWERWOOD.get(), 0.3f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.TOWERWOOD.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix("wood/" + processName + "_cracked_towerwood").toString());
    }
    
    private void crackedStoneRecipes(final Consumer<FinishedRecipe> consumer, final String processName, final SimpleCookingSerializer<?> process, final int smeltingTime) {
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.NAGASTONE_PILLAR.get() }), (ItemLike)TFBlocks.CRACKED_NAGASTONE_PILLAR.get(), 0.3f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.NAGASTONE_PILLAR.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix("nagastone/" + processName + "_cracked_nagastone_pillar").toString());
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.ETCHED_NAGASTONE.get() }), (ItemLike)TFBlocks.CRACKED_ETCHED_NAGASTONE.get(), 0.3f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.ETCHED_NAGASTONE.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix("nagastone/" + processName + "_cracked_etched_nagastone").toString());
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.MAZESTONE_BRICK.get() }), (ItemLike)TFBlocks.CRACKED_MAZESTONE.get(), 0.3f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.MAZESTONE_BRICK.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix("maze_stone/" + processName + "_maze_stone_cracked").toString());
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.CASTLE_BRICK.get() }), (ItemLike)TFBlocks.CRACKED_CASTLE_BRICK.get(), 0.3f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.CASTLE_BRICK.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix("castleblock/" + processName + "_cracked_castle_brick").toString());
        SimpleCookingRecipeBuilder.m_126248_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.UNDERBRICK.get() }), (ItemLike)TFBlocks.CRACKED_UNDERBRICK.get(), 0.3f, smeltingTime, (SimpleCookingSerializer)process).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.UNDERBRICK.get())).m_176500_((Consumer)consumer, TwilightForestMod.prefix(processName + "_cracked_underbrick").toString());
    }
}
