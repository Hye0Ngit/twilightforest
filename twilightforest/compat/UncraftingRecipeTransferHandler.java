// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import net.minecraft.inventory.Container;
import java.util.ArrayList;
import net.minecraft.inventory.Slot;
import java.util.List;
import twilightforest.inventory.ContainerTFUncrafting;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;

public class UncraftingRecipeTransferHandler implements IRecipeTransferInfo<ContainerTFUncrafting>
{
    public Class<ContainerTFUncrafting> getContainerClass() {
        return ContainerTFUncrafting.class;
    }
    
    public String getRecipeCategoryUid() {
        return "minecraft.crafting";
    }
    
    public boolean canHandle(final ContainerTFUncrafting container) {
        return true;
    }
    
    public List<Slot> getRecipeSlots(final ContainerTFUncrafting container) {
        final List<Slot> slots = new ArrayList<Slot>();
        for (int i = 11; i < 20; ++i) {
            slots.add(container.func_75139_a(i));
        }
        return slots;
    }
    
    public List<Slot> getInventorySlots(final ContainerTFUncrafting container) {
        final List<Slot> slots = new ArrayList<Slot>();
        for (int i = 20; i < container.field_75151_b.size(); ++i) {
            slots.add(container.func_75139_a(i));
        }
        return slots;
    }
}
