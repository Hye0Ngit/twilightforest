// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

public class ChillAuraEnchantment extends Enchantment
{
    public ChillAuraEnchantment(final Enchantment.Rarity rarity) {
        super(rarity, EnchantmentType.ARMOR, new EquipmentSlotType[] { EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET });
    }
    
    public boolean canApplyAtEnchantingTable(final ItemStack stack) {
        return false;
    }
    
    public boolean func_230310_i_() {
        return false;
    }
    
    public boolean func_230309_h_() {
        return false;
    }
}
