// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import twilightforest.block.TwilightChest;
import net.minecraftforge.common.Tags;
import net.minecraft.tags.Tag;
import net.minecraft.resources.ResourceLocation;
import twilightforest.block.TFBlocks;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Block;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import java.util.function.Supplier;
import net.minecraft.data.recipes.FinishedRecipe;
import java.util.Collection;
import java.util.List;
import net.minecraftforge.common.crafting.CompoundIngredient;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import net.minecraftforge.common.crafting.NBTIngredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundTag;
import java.util.function.Consumer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeProvider;

public abstract class CraftingDataHelper extends RecipeProvider
{
    public CraftingDataHelper(final DataGenerator generator) {
        super(generator);
    }
    
    protected final Ingredient itemWithNBT(final RegistryObject<? extends ItemLike> item, final Consumer<CompoundTag> nbtSetter) {
        return this.itemWithNBT((ItemLike)item.get(), nbtSetter);
    }
    
    protected final Ingredient itemWithNBT(final ItemLike item, final Consumer<CompoundTag> nbtSetter) {
        final ItemStack stack = new ItemStack(item);
        final CompoundTag nbt = new CompoundTag();
        nbtSetter.accept(nbt);
        stack.m_41751_(nbt);
        try {
            final Constructor<NBTIngredient> constructor = NBTIngredient.class.getDeclaredConstructor(ItemStack.class);
            constructor.setAccessible(true);
            return (Ingredient)constructor.newInstance(stack);
        }
        catch (Throwable e) {
            e.printStackTrace();
            return Ingredient.m_43927_(new ItemStack[] { stack });
        }
    }
    
    protected final Ingredient multipleIngredients(final Ingredient... ingredientArray) {
        final List<Ingredient> ingredientList = (List<Ingredient>)ImmutableList.copyOf((Object[])ingredientArray);
        try {
            final Constructor<CompoundIngredient> constructor = CompoundIngredient.class.getDeclaredConstructor(List.class);
            constructor.setAccessible(true);
            return (Ingredient)constructor.newInstance(ingredientList);
        }
        catch (Throwable e) {
            e.printStackTrace();
            return Ingredient.merge((Collection)ingredientList);
        }
    }
    
    protected final void charmRecipe(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Supplier<? extends Item> item) {
        ShapelessRecipeBuilder.m_126189_((ItemLike)result.get()).m_126211_((ItemLike)item.get(), 4).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)item.get())).m_142700_((Consumer)consumer, TwilightForestMod.prefix(name));
    }
    
    protected final void castleBlock(final Consumer<FinishedRecipe> consumer, final Supplier<? extends Block> result, final ItemLike... ingredients) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 4).m_126130_("##").m_126130_("##").m_126124_(Character.valueOf('#'), Ingredient.m_43929_(ingredients)).m_142284_("has_castle_brick", (CriterionTriggerInstance)m_125977_((ItemLike)TFBlocks.CASTLE_BRICK.get())).m_142700_((Consumer)consumer, this.locCastle(((Block)result.get()).getRegistryName().m_135815_()));
    }
    
    protected final void stairsBlock(final Consumer<FinishedRecipe> consumer, final ResourceLocation loc, final Supplier<? extends Block> result, final Supplier<? extends Block> criteria, final ItemLike... ingredients) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 8).m_126130_("#  ").m_126130_("## ").m_126130_("###").m_126124_(Character.valueOf('#'), Ingredient.m_43929_(ingredients)).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)criteria.get())).m_142700_((Consumer)consumer, loc);
    }
    
    protected final void stairsRightBlock(final Consumer<FinishedRecipe> consumer, final ResourceLocation loc, final Supplier<? extends Block> result, final Supplier<? extends Block> criteria, final ItemLike... ingredients) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 8).m_126130_("###").m_126130_(" ##").m_126130_("  #").m_126124_(Character.valueOf('#'), Ingredient.m_43929_(ingredients)).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)criteria.get())).m_142700_((Consumer)consumer, loc);
    }
    
    protected final void compressedBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Tag.Named<Item> ingredient) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("###").m_126130_("###").m_126130_("###").m_126121_(Character.valueOf('#'), (Tag)ingredient).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)ingredient)).m_142700_((Consumer)consumer, TwilightForestMod.prefix("compressed_blocks/" + name));
    }
    
    protected final void reverseCompressBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Tag.Named<Item> ingredient) {
        ShapelessRecipeBuilder.m_126191_((ItemLike)result.get(), 9).m_126182_((Tag)ingredient).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)ingredient)).m_142700_((Consumer)consumer, TwilightForestMod.prefix("compressed_blocks/reversed/" + name));
    }
    
    protected final void helmetItem(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Tag.Named<Item> material) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("###").m_126130_("# #").m_126121_(Character.valueOf('#'), (Tag)material).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)material)).m_142700_((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void chestplateItem(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Tag.Named<Item> material) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("# #").m_126130_("###").m_126130_("###").m_126121_(Character.valueOf('#'), (Tag)material).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)material)).m_142700_((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void leggingsItem(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Tag.Named<Item> material) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("###").m_126130_("# #").m_126130_("# #").m_126121_(Character.valueOf('#'), (Tag)material).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)material)).m_142700_((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void bootsItem(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Tag.Named<Item> material) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("# #").m_126130_("# #").m_126121_(Character.valueOf('#'), (Tag)material).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)material)).m_142700_((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void pickaxeItem(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Tag.Named<Item> material, final Tag.Named<Item> handle) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("###").m_126130_(" X ").m_126130_(" X ").m_126121_(Character.valueOf('#'), (Tag)material).m_126121_(Character.valueOf('X'), (Tag)handle).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)material)).m_142700_((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void swordItem(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Tag.Named<Item> material, final Tag.Named<Item> handle) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("#").m_126130_("#").m_126130_("X").m_126121_(Character.valueOf('#'), (Tag)material).m_126121_(Character.valueOf('X'), (Tag)handle).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)material)).m_142700_((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void axeItem(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Tag.Named<Item> material, final Tag.Named<Item> handle) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("##").m_126130_("#X").m_126130_(" X").m_126121_(Character.valueOf('#'), (Tag)material).m_126121_(Character.valueOf('X'), (Tag)handle).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)material)).m_142700_((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void buttonBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapelessRecipeBuilder.m_126189_((ItemLike)result.get()).m_126209_((ItemLike)material.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_button"));
    }
    
    protected final void doorBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 3).m_126130_("##").m_126130_("##").m_126130_("##").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_door"));
    }
    
    protected final void fenceBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 3).m_126130_("#S#").m_126130_("#S#").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_126121_(Character.valueOf('S'), (Tag)Tags.Items.RODS_WOODEN).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_fence"));
    }
    
    protected final void gateBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("S#S").m_126130_("S#S").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_126121_(Character.valueOf('S'), (Tag)Tags.Items.RODS_WOODEN).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_gate"));
    }
    
    protected final void planksBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapelessRecipeBuilder.m_126191_((ItemLike)result.get(), 4).m_126209_((ItemLike)material.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_planks"));
    }
    
    protected final void plateBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126116_((ItemLike)result.get()).m_126130_("##").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_plate"));
    }
    
    protected final void slabBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 6).m_126130_("###").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_slab"));
    }
    
    protected final void bannerPattern(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> trophy, final Supplier<? extends Item> result) {
        ShapelessRecipeBuilder.m_126189_((ItemLike)result.get()).m_126184_(Ingredient.m_43911_((Tag)ItemTagGenerator.PAPER)).m_126184_(Ingredient.m_43929_(new ItemLike[] { (ItemLike)((Block)trophy.get()).m_5456_() })).m_142284_("has_trophy", (CriterionTriggerInstance)m_125977_((ItemLike)trophy.get())).m_176498_((Consumer)consumer);
    }
    
    protected final void trapdoorBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 2).m_126130_("###").m_126130_("###").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_trapdoor"));
    }
    
    protected final void woodBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 3).m_126130_("##").m_126130_("##").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_wood"));
    }
    
    protected final void strippedWoodBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 3).m_126130_("##").m_126130_("##").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_stripped_wood"));
    }
    
    protected final void signBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 3).m_126130_("###").m_126130_("###").m_126130_(" - ").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_126121_(Character.valueOf('-'), (Tag)Tags.Items.RODS_WOODEN).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_wood"));
    }
    
    protected final void banisterBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        this.banisterBlock(consumer, name, result, (Block)material.get());
    }
    
    protected final void banisterBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Block material) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 3).m_126130_("---").m_126130_("| |").m_126127_(Character.valueOf('-'), (ItemLike)material).m_126121_(Character.valueOf('|'), (Tag)Tags.Items.RODS_WOODEN).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material)).m_142700_((Consumer)consumer, this.locWood(name + "_banister"));
    }
    
    protected final void chestBlock(final Consumer<FinishedRecipe> consumer, final String name, final Supplier<? extends TwilightChest> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.m_126118_((ItemLike)result.get(), 2).m_126130_("###").m_126130_("#C#").m_126130_("###").m_126127_(Character.valueOf('#'), (ItemLike)material.get()).m_126121_(Character.valueOf('C'), (Tag)Tags.Items.CHESTS_WOODEN).m_142284_("has_item", (CriterionTriggerInstance)m_125977_((ItemLike)material.get())).m_142700_((Consumer)consumer, this.locWood(name + "_chest"));
    }
    
    protected final void fieryConversion(final Consumer<FinishedRecipe> consumer, final Supplier<? extends Item> result, final Item armor, final int vials) {
        ShapelessRecipeBuilder.m_126189_((ItemLike)result.get()).m_126209_((ItemLike)armor).m_126186_(Ingredient.m_43911_((Tag)ItemTagGenerator.FIERY_VIAL), vials).m_142284_("has_item", (CriterionTriggerInstance)m_125975_((Tag)ItemTagGenerator.FIERY_VIAL)).m_142700_((Consumer)consumer, this.locEquip("fiery_" + armor.getRegistryName().m_135815_()));
    }
    
    protected final ResourceLocation locCastle(final String name) {
        return TwilightForestMod.prefix("castleblock/" + name);
    }
    
    protected final ResourceLocation locEquip(final String name) {
        return TwilightForestMod.prefix("equipment/" + name);
    }
    
    protected final ResourceLocation locNaga(final String name) {
        return TwilightForestMod.prefix("nagastone/" + name);
    }
    
    protected final ResourceLocation locWood(final String name) {
        return TwilightForestMod.prefix("wood/" + name);
    }
}
