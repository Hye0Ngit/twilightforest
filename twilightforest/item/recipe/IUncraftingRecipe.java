// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item.recipe;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.CraftingRecipe;

public interface IUncraftingRecipe extends CraftingRecipe
{
    default RecipeType<?> m_6671_() {
        return TFRecipes.UNCRAFTING_RECIPE;
    }
}
