// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraftforge.common.Tags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.block.Block;
import twilightforest.TwilightForestMod;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import java.util.function.Supplier;
import net.minecraft.data.IFinishedRecipe;
import java.util.Collection;
import java.util.List;
import net.minecraftforge.common.crafting.CompoundIngredient;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import net.minecraftforge.common.crafting.NBTIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import java.util.function.Consumer;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.RecipeProvider;

public abstract class CraftingDataHelper extends RecipeProvider
{
    public CraftingDataHelper(final DataGenerator generator) {
        super(generator);
    }
    
    protected final Ingredient itemWithNBT(final RegistryObject<? extends IItemProvider> item, final Consumer<CompoundNBT> nbtSetter) {
        return this.itemWithNBT((IItemProvider)item.get(), nbtSetter);
    }
    
    protected final Ingredient itemWithNBT(final IItemProvider item, final Consumer<CompoundNBT> nbtSetter) {
        final ItemStack stack = new ItemStack(item);
        final CompoundNBT nbt = new CompoundNBT();
        nbtSetter.accept(nbt);
        stack.func_77982_d(nbt);
        try {
            final Constructor<NBTIngredient> constructor = NBTIngredient.class.getDeclaredConstructor(ItemStack.class);
            constructor.setAccessible(true);
            return (Ingredient)constructor.newInstance(stack);
        }
        catch (Throwable e) {
            e.printStackTrace();
            return Ingredient.func_193369_a(new ItemStack[] { stack });
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
    
    protected final void charmRecipe(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final Supplier<? extends Item> item) {
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)result.get()).func_200491_b((IItemProvider)item.get(), 4).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)item.get())).func_200485_a((Consumer)consumer, TwilightForestMod.prefix(name));
    }
    
    protected final void castleBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> criteria, final IItemProvider... ingredients) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 4).func_200472_a("##").func_200472_a("##").func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(ingredients)).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)criteria.get())).func_200467_a((Consumer)consumer, this.locCastle(name));
    }
    
    protected final void stairsBlock(final Consumer<IFinishedRecipe> consumer, final ResourceLocation loc, final Supplier<? extends Block> result, final Supplier<? extends Block> criteria, final IItemProvider... ingredients) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 8).func_200472_a("#  ").func_200472_a("## ").func_200472_a("###").func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(ingredients)).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)criteria.get())).func_200467_a((Consumer)consumer, loc);
    }
    
    protected final void stairsRightBlock(final Consumer<IFinishedRecipe> consumer, final ResourceLocation loc, final Supplier<? extends Block> result, final Supplier<? extends Block> criteria, final IItemProvider... ingredients) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 8).func_200472_a("###").func_200472_a(" ##").func_200472_a("  #").func_200471_a(Character.valueOf('#'), Ingredient.func_199804_a(ingredients)).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)criteria.get())).func_200467_a((Consumer)consumer, loc);
    }
    
    protected final void reverseStairsBlock(final Consumer<IFinishedRecipe> consumer, final ResourceLocation loc, final Supplier<? extends Block> result, final Supplier<? extends Block> criteria, final IItemProvider ingredient) {
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)result.get(), 3).func_200487_b(ingredient).func_200487_b(ingredient).func_200487_b(ingredient).func_200487_b(ingredient).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)criteria.get())).func_200485_a((Consumer)consumer, loc);
    }
    
    protected final void compressedBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final ITag.INamedTag<Item> ingredient) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("###").func_200472_a("###").func_200472_a("###").func_200469_a(Character.valueOf('#'), (ITag)ingredient).func_200465_a("has_item", (ICriterionInstance)func_200409_a((ITag)ingredient)).func_200467_a((Consumer)consumer, TwilightForestMod.prefix("compressed_blocks/" + name));
    }
    
    protected final void reverseCompressBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final ITag.INamedTag<Item> ingredient) {
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)result.get(), 9).func_203221_a((ITag)ingredient).func_200483_a("has_item", (ICriterionInstance)func_200409_a((ITag)ingredient)).func_200485_a((Consumer)consumer, TwilightForestMod.prefix("compressed_blocks/reversed/" + name));
    }
    
    protected final void helmetItem(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final ITag.INamedTag<Item> material) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("###").func_200472_a("# #").func_200469_a(Character.valueOf('#'), (ITag)material).func_200465_a("has_item", (ICriterionInstance)func_200409_a((ITag)material)).func_200467_a((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void chestplateItem(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final ITag.INamedTag<Item> material) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("# #").func_200472_a("###").func_200472_a("###").func_200469_a(Character.valueOf('#'), (ITag)material).func_200465_a("has_item", (ICriterionInstance)func_200409_a((ITag)material)).func_200467_a((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void leggingsItem(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final ITag.INamedTag<Item> material) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("###").func_200472_a("# #").func_200472_a("# #").func_200469_a(Character.valueOf('#'), (ITag)material).func_200465_a("has_item", (ICriterionInstance)func_200409_a((ITag)material)).func_200467_a((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void bootsItem(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final ITag.INamedTag<Item> material) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("# #").func_200472_a("# #").func_200469_a(Character.valueOf('#'), (ITag)material).func_200465_a("has_item", (ICriterionInstance)func_200409_a((ITag)material)).func_200467_a((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void pickaxeItem(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final ITag.INamedTag<Item> material, final ITag.INamedTag<Item> handle) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("###").func_200472_a(" X ").func_200472_a(" X ").func_200469_a(Character.valueOf('#'), (ITag)material).func_200469_a(Character.valueOf('X'), (ITag)handle).func_200465_a("has_item", (ICriterionInstance)func_200409_a((ITag)material)).func_200467_a((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void swordItem(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final ITag.INamedTag<Item> material, final ITag.INamedTag<Item> handle) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("#").func_200472_a("#").func_200472_a("X").func_200469_a(Character.valueOf('#'), (ITag)material).func_200469_a(Character.valueOf('X'), (ITag)handle).func_200465_a("has_item", (ICriterionInstance)func_200409_a((ITag)material)).func_200467_a((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void axeItem(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Item> result, final ITag.INamedTag<Item> material, final ITag.INamedTag<Item> handle) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("##").func_200472_a("#X").func_200472_a(" X").func_200469_a(Character.valueOf('#'), (ITag)material).func_200469_a(Character.valueOf('X'), (ITag)handle).func_200465_a("has_item", (ICriterionInstance)func_200409_a((ITag)material)).func_200467_a((Consumer)consumer, this.locEquip(name));
    }
    
    protected final void buttonBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)result.get()).func_200487_b((IItemProvider)material.get()).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200485_a((Consumer)consumer, this.locWood(name + "_button"));
    }
    
    protected final void doorBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 3).func_200472_a("##").func_200472_a("##").func_200472_a("##").func_200462_a(Character.valueOf('#'), (IItemProvider)material.get()).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200467_a((Consumer)consumer, this.locWood(name + "_door"));
    }
    
    protected final void fenceBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 3).func_200472_a("#S#").func_200472_a("#S#").func_200462_a(Character.valueOf('#'), (IItemProvider)material.get()).func_200469_a(Character.valueOf('S'), (ITag)Tags.Items.RODS_WOODEN).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200467_a((Consumer)consumer, this.locWood(name + "_fence"));
    }
    
    protected final void gateBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("S#S").func_200472_a("S#S").func_200462_a(Character.valueOf('#'), (IItemProvider)material.get()).func_200469_a(Character.valueOf('S'), (ITag)Tags.Items.RODS_WOODEN).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200467_a((Consumer)consumer, this.locWood(name + "_gate"));
    }
    
    protected final void planksBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapelessRecipeBuilder.func_200488_a((IItemProvider)result.get(), 4).func_200487_b((IItemProvider)material.get()).func_200483_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200485_a((Consumer)consumer, this.locWood(name + "_planks"));
    }
    
    protected final void plateBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.func_200470_a((IItemProvider)result.get()).func_200472_a("##").func_200462_a(Character.valueOf('#'), (IItemProvider)material.get()).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200467_a((Consumer)consumer, this.locWood(name + "_plate"));
    }
    
    protected final void slabBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 6).func_200472_a("###").func_200462_a(Character.valueOf('#'), (IItemProvider)material.get()).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200467_a((Consumer)consumer, this.locWood(name + "_slab"));
    }
    
    protected final void trapdoorBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 6).func_200472_a("###").func_200472_a("###").func_200462_a(Character.valueOf('#'), (IItemProvider)material.get()).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200467_a((Consumer)consumer, this.locWood(name + "_trapdoor"));
    }
    
    protected final void woodBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 3).func_200472_a("##").func_200472_a("##").func_200462_a(Character.valueOf('#'), (IItemProvider)material.get()).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200467_a((Consumer)consumer, this.locWood(name + "_wood"));
    }
    
    protected final void strippedWoodBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 3).func_200472_a("##").func_200472_a("##").func_200462_a(Character.valueOf('#'), (IItemProvider)material.get()).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200467_a((Consumer)consumer, this.locWood(name + "_stripped_wood"));
    }
    
    protected final void signBlock(final Consumer<IFinishedRecipe> consumer, final String name, final Supplier<? extends Block> result, final Supplier<? extends Block> material) {
        ShapedRecipeBuilder.func_200468_a((IItemProvider)result.get(), 3).func_200472_a("###").func_200472_a("###").func_200472_a(" - ").func_200462_a(Character.valueOf('#'), (IItemProvider)material.get()).func_200469_a(Character.valueOf('-'), (ITag)Tags.Items.RODS_WOODEN).func_200465_a("has_item", (ICriterionInstance)func_200403_a((IItemProvider)material.get())).func_200467_a((Consumer)consumer, this.locWood(name + "_wood"));
    }
    
    protected final void fieryConversion(final Consumer<IFinishedRecipe> consumer, final Supplier<? extends Item> result, final Item armor, final int vials) {
        ShapelessRecipeBuilder.func_200486_a((IItemProvider)result.get()).func_200487_b((IItemProvider)armor).func_200492_a(Ingredient.func_199805_a((ITag)ItemTagGenerator.FIERY_VIAL), vials).func_200483_a("has_item", (ICriterionInstance)func_200409_a((ITag)ItemTagGenerator.FIERY_VIAL)).func_200485_a((Consumer)consumer, this.locEquip("fiery_" + armor.getRegistryName().func_110623_a()));
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
