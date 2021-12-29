// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item.recipe;

import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.RecipeSerializer;
import java.util.List;
import twilightforest.item.TFItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.ArrayList;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CustomRecipe;

public class MoonwormQueenRepairRecipe extends CustomRecipe
{
    public MoonwormQueenRepairRecipe(final ResourceLocation pId) {
        super(pId);
    }
    
    public boolean matches(final CraftingContainer inv, final Level level) {
        ItemStack queen = null;
        final List<ItemStack> berries = new ArrayList<ItemStack>();
        for (int i = 0; i < inv.m_6643_(); ++i) {
            final ItemStack stackInQuestion = inv.m_8020_(i);
            if (!stackInQuestion.m_41619_()) {
                if (stackInQuestion.m_150930_((Item)TFItems.MOONWORM_QUEEN.get()) && stackInQuestion.m_41768_()) {
                    queen = stackInQuestion;
                }
                if (stackInQuestion.m_150930_((Item)TFItems.TORCHBERRIES.get())) {
                    berries.add(stackInQuestion);
                }
            }
        }
        return queen != null && !berries.isEmpty();
    }
    
    public ItemStack assemble(final CraftingContainer inv) {
        final List<Item> berries = new ArrayList<Item>();
        ItemStack queen = null;
        for (int i = 0; i < inv.m_6643_(); ++i) {
            final ItemStack itemstack = inv.m_8020_(i);
            if (!itemstack.m_41619_()) {
                if (itemstack.m_150930_((Item)TFItems.MOONWORM_QUEEN.get())) {
                    if (queen != null) {
                        return ItemStack.f_41583_;
                    }
                    queen = itemstack;
                }
                if (itemstack.m_150930_((Item)TFItems.TORCHBERRIES.get())) {
                    berries.add(itemstack.m_41720_());
                }
            }
        }
        if (!berries.isEmpty() && queen != null && queen.m_41768_()) {
            final ItemStack newQueen = ((Item)TFItems.MOONWORM_QUEEN.get()).m_7968_();
            newQueen.m_41721_(queen.m_41773_() - berries.size() * 64);
            return newQueen;
        }
        return ItemStack.f_41583_;
    }
    
    public boolean m_8004_(final int width, final int height) {
        return width * height >= 2;
    }
    
    public RecipeSerializer<?> m_7707_() {
        return (RecipeSerializer<?>)TFRecipes.MOONWORM_QUEEN_REPAIR_RECIPE.get();
    }
}
