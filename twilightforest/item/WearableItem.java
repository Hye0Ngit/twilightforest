// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class WearableItem extends BlockItem
{
    public WearableItem(final Block block, final Item.Properties props) {
        super(block, props);
    }
    
    public boolean canEquip(final ItemStack stack, final EquipmentSlotType armorType, final Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }
    
    @Nullable
    public EquipmentSlotType getEquipmentSlot(final ItemStack stack) {
        return EquipmentSlotType.HEAD;
    }
}
