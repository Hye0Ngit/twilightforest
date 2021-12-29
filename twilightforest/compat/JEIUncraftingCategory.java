// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.constants.VanillaTypes;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import twilightforest.TFConfig;
import net.minecraft.tags.Tag;
import twilightforest.data.ItemTagGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import twilightforest.item.recipe.UncraftingRecipe;
import com.google.common.collect.ImmutableList;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.ItemLike;
import twilightforest.TwilightForestMod;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.network.chat.TranslatableComponent;
import mezz.jei.api.gui.drawable.IDrawable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingRecipe;
import mezz.jei.api.recipe.category.IRecipeCategory;

public class JEIUncraftingCategory implements IRecipeCategory<CraftingRecipe>
{
    public static ResourceLocation UNCRAFTING;
    public static final int width = 116;
    public static final int height = 54;
    private final IDrawable background;
    private final IDrawable icon;
    private final TranslatableComponent localizedName;
    
    public JEIUncraftingCategory(final IGuiHelper guiHelper) {
        final ResourceLocation location = TwilightForestMod.getGuiTexture("uncrafting_jei.png");
        this.background = (IDrawable)guiHelper.createDrawable(location, 0, 0, 116, 54);
        this.icon = guiHelper.createDrawableIngredient((Object)new ItemStack((ItemLike)TFBlocks.UNCRAFTING_TABLE.get()));
        this.localizedName = new TranslatableComponent("gui.uncrafting_jei");
    }
    
    public ResourceLocation getUid() {
        return JEIUncraftingCategory.UNCRAFTING;
    }
    
    public Class<? extends CraftingRecipe> getRecipeClass() {
        return CraftingRecipe.class;
    }
    
    public Component getTitle() {
        return (Component)this.localizedName;
    }
    
    public IDrawable getBackground() {
        return this.background;
    }
    
    public IDrawable getIcon() {
        return this.icon;
    }
    
    public void setIngredients(final CraftingRecipe craftingRecipe, final IIngredients iIngredients) {
        final ImmutableList.Builder<ItemStack> inputBuilder = (ImmutableList.Builder<ItemStack>)ImmutableList.builder();
        ItemStack i = null;
        if (craftingRecipe instanceof final UncraftingRecipe uncraftingRecipe) {
            final ItemStack[] 43908_ = uncraftingRecipe.getIngredient().m_43908_();
            for (int length = 43908_.length, k = 0; k < length; ++k) {
                i = 43908_[k];
                inputBuilder.add((Object)new ItemStack((ItemLike)i.m_41720_(), ((UncraftingRecipe)craftingRecipe).getCount()));
            }
        }
        else {
            inputBuilder.add((Object)craftingRecipe.m_8043_());
        }
        final List<List<ItemStack>> outputList = new ArrayList<List<ItemStack>>();
        craftingRecipe.m_7527_().forEach(i -> outputList.add(Arrays.asList(i.m_43908_())));
        for (int j = 0; j < outputList.size(); ++j) {
            final List<ItemStack> newList = outputList.get(j);
            outputList.set(j, newList.stream().filter(o -> !o.m_150922_((Tag)ItemTagGenerator.BANNED_UNCRAFTING_INGREDIENTS)).filter(o -> !o.m_41720_().hasContainerItem(o)).filter(o -> !((List)TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.disableUncraftingRecipes.get()).contains(craftingRecipe.m_6423_().toString())).filter(o -> (boolean)TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.flipUncraftingModIdList.get() == ((List)TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.blacklistedUncraftingModIds.get()).contains(craftingRecipe.m_6423_().m_135827_())).collect((Collector<? super Object, ?, List<ItemStack>>)Collectors.toList()));
        }
        if (!outputList.stream().allMatch(o -> o.stream().allMatch(ItemStack::m_41619_))) {
            iIngredients.setInputLists(VanillaTypes.ITEM, (List)ImmutableList.of((Object)inputBuilder.build()));
            iIngredients.setOutputLists(VanillaTypes.ITEM, (List)outputList);
        }
    }
    
    public void setRecipe(final IRecipeLayout iRecipeLayout, final CraftingRecipe craftingRecipe, final IIngredients iIngredients) {
        int i = 0;
        final List<List<ItemStack>> outputs = iIngredients.getOutputs(VanillaTypes.ITEM);
        for (int j = 0, k = 0; j - k < outputs.size() && j < 9; ++j) {
            final int x = j % 3;
            final int y = j / 3;
            if ((craftingRecipe.m_8004_(x, 3) | craftingRecipe.m_8004_(3, y)) && !(craftingRecipe instanceof ShapelessRecipe)) {
                ++k;
            }
            else {
                iRecipeLayout.getItemStacks().init(++i, true, x * 18 + 62, y * 18);
                iRecipeLayout.getItemStacks().set(i, (List)outputs.get(j - k));
            }
        }
        iRecipeLayout.getItemStacks().init(++i, false, 4, 18);
        iRecipeLayout.getItemStacks().set(i, (List)iIngredients.getInputs(VanillaTypes.ITEM).get(0));
    }
    
    static {
        JEIUncraftingCategory.UNCRAFTING = TwilightForestMod.prefix("uncrafting_jei");
    }
}
