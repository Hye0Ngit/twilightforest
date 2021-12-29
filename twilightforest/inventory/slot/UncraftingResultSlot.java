// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory.slot;

import java.util.Iterator;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.CraftingInventory;
import twilightforest.inventory.UncraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.CraftingResultSlot;

public class UncraftingResultSlot extends CraftingResultSlot
{
    private final PlayerEntity player;
    private final IInventory inputSlot;
    private final UncraftingInventory uncraftingMatrix;
    private final CraftingInventory assemblyMatrix;
    
    public UncraftingResultSlot(final PlayerEntity player, final IInventory input, final IInventory uncraftingMatrix, final IInventory assemblyMatrix, final IInventory result, final int slotIndex, final int x, final int y) {
        super(player, (CraftingInventory)assemblyMatrix, result, slotIndex, x, y);
        this.player = player;
        this.inputSlot = input;
        this.uncraftingMatrix = (UncraftingInventory)uncraftingMatrix;
        this.assemblyMatrix = (CraftingInventory)assemblyMatrix;
    }
    
    public ItemStack func_190901_a(final PlayerEntity player, final ItemStack stack) {
        boolean combined = true;
        for (final IRecipe<CraftingInventory> recipe : player.field_70170_p.func_199532_z().func_215370_b(IRecipeType.field_222149_a, (IInventory)this.assemblyMatrix, this.player.field_70170_p)) {
            if (Container.func_195929_a(recipe.func_77571_b(), stack)) {
                combined = false;
                break;
            }
        }
        if (combined) {
            if (this.uncraftingMatrix.recraftingCost > 0) {
                this.player.func_82242_a(-this.uncraftingMatrix.recraftingCost);
            }
            for (int i = 0; i < this.uncraftingMatrix.func_70302_i_(); ++i) {
                this.uncraftingMatrix.func_70299_a(i, ItemStack.field_190927_a);
            }
            this.inputSlot.func_70298_a(0, this.uncraftingMatrix.numberOfInputItems);
        }
        this.func_75208_c(stack);
        for (int i = 0; i < this.assemblyMatrix.func_70302_i_(); ++i) {
            this.assemblyMatrix.func_70298_a(i, 1);
        }
        return stack;
    }
}
