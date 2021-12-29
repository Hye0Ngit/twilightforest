// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;

public class LootOnlyEnchantment extends Enchantment
{
    protected LootOnlyEnchantment(final Enchantment.Rarity rarity, final EnchantmentCategory category, final EquipmentSlot[] applicableSlots) {
        super(rarity, category, applicableSlots);
    }
    
    public boolean m_6594_() {
        return false;
    }
    
    public boolean m_6591_() {
        return true;
    }
    
    public boolean m_6592_() {
        return false;
    }
}
