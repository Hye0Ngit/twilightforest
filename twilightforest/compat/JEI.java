// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.IModPlugin;

@JEIPlugin
public class JEI implements IModPlugin
{
    public void register(final IModRegistry registry) {
        registry.addRecipeCatalyst((Object)new ItemStack(TFBlocks.uncrafting_table), new String[] { "minecraft.crafting" });
        final IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
        recipeTransferRegistry.addRecipeTransferHandler((IRecipeTransferInfo)new UncraftingRecipeTransferHandler());
    }
}
