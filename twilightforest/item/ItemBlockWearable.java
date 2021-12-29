// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockWearable extends ItemBlock
{
    public ItemBlockWearable(final Block block) {
        super(block);
    }
    
    public boolean isValidArmor(final ItemStack stack, final EntityEquipmentSlot armorType, final Entity entity) {
        return armorType == EntityEquipmentSlot.HEAD;
    }
    
    @Nullable
    public EntityEquipmentSlot getEquipmentSlot(final ItemStack stack) {
        return EntityEquipmentSlot.HEAD;
    }
}
