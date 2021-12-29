// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory.slot;

import java.util.Iterator;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.CraftingContainer;
import twilightforest.inventory.UncraftingInventory;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ResultSlot;

public class UncraftingResultSlot extends ResultSlot
{
    private final Player player;
    private final Container inputSlot;
    private final UncraftingInventory uncraftingMatrix;
    private final CraftingContainer assemblyMatrix;
    
    public UncraftingResultSlot(final Player player, final Container input, final Container uncraftingMatrix, final Container assemblyMatrix, final Container result, final int slotIndex, final int x, final int y) {
        super(player, (CraftingContainer)assemblyMatrix, result, slotIndex, x, y);
        this.player = player;
        this.inputSlot = input;
        this.uncraftingMatrix = (UncraftingInventory)uncraftingMatrix;
        this.assemblyMatrix = (CraftingContainer)assemblyMatrix;
    }
    
    public void m_142406_(final Player player, final ItemStack stack) {
        boolean combined = true;
        for (final Recipe<CraftingContainer> recipe : player.f_19853_.m_7465_().m_44056_(RecipeType.f_44107_, (Container)this.assemblyMatrix, this.player.f_19853_)) {
            if (ItemStack.m_150942_(recipe.m_8043_(), stack)) {
                combined = false;
                break;
            }
        }
        if (combined) {
            if (this.uncraftingMatrix.recraftingCost > 0) {
                this.player.m_6749_(-this.uncraftingMatrix.recraftingCost);
            }
            for (int i = 0; i < this.uncraftingMatrix.m_6643_(); ++i) {
                this.uncraftingMatrix.m_6836_(i, ItemStack.f_41583_);
            }
            this.inputSlot.m_7407_(0, this.uncraftingMatrix.numberOfInputItems);
        }
        this.m_5845_(stack);
        for (int i = 0; i < this.assemblyMatrix.m_6643_(); ++i) {
            this.assemblyMatrix.m_7407_(i, 1);
        }
    }
}
