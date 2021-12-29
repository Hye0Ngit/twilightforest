// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import twilightforest.client.UncraftingGui;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import java.util.List;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.CraftingRecipe;
import java.util.Collection;
import twilightforest.item.recipe.TFRecipes;
import net.minecraft.tags.Tag;
import twilightforest.data.ItemTagGenerator;
import net.minecraft.world.item.crafting.RecipeType;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import twilightforest.TwilightForestMod;
import twilightforest.inventory.UncraftingContainer;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.ItemLike;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

@JeiPlugin
public class JEI implements IModPlugin
{
    public void registerRecipeCatalysts(final IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack((ItemLike)TFBlocks.UNCRAFTING_TABLE.get()), new ResourceLocation[] { VanillaRecipeCategoryUid.CRAFTING });
        registration.addRecipeCatalyst(new ItemStack((ItemLike)TFBlocks.UNCRAFTING_TABLE.get()), new ResourceLocation[] { JEIUncraftingCategory.UNCRAFTING });
    }
    
    public void registerRecipeTransferHandlers(final IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler((Class)UncraftingContainer.class, VanillaRecipeCategoryUid.CRAFTING, 11, 9, 20, 36);
    }
    
    public ResourceLocation getPluginUid() {
        return TwilightForestMod.prefix("jei_plugin");
    }
    
    public void registerCategories(final IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new IRecipeCategory[] { (IRecipeCategory)new JEIUncraftingCategory(registration.getJeiHelpers().getGuiHelper()) });
    }
    
    public void registerRecipes(final IRecipeRegistration registration) {
        final RecipeManager manager = Objects.requireNonNull(Minecraft.m_91087_().f_91073_).m_7465_();
        final List<CraftingRecipe> recipes = manager.m_44013_(RecipeType.f_44107_);
        recipes.removeIf(recipe -> recipe.m_8043_().m_41619_() | recipe.m_8043_().m_150922_((Tag)ItemTagGenerator.BANNED_UNCRAFTABLES));
        recipes.addAll(manager.m_44013_((RecipeType)TFRecipes.UNCRAFTING_RECIPE));
        registration.addRecipes((Collection)recipes, JEIUncraftingCategory.UNCRAFTING);
    }
    
    public void registerGuiHandlers(final IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea((Class)UncraftingGui.class, 34, 33, 27, 20, new ResourceLocation[] { JEIUncraftingCategory.UNCRAFTING });
        registration.addRecipeClickArea((Class)UncraftingGui.class, 115, 33, 27, 20, new ResourceLocation[] { VanillaRecipeCategoryUid.CRAFTING });
    }
}
