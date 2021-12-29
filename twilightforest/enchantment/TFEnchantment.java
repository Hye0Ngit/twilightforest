// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import twilightforest.item.YetiArmorItem;
import java.util.Iterator;
import twilightforest.item.FieryArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;

public class TFEnchantment extends Enchantment
{
    protected TFEnchantment(final Enchantment.Rarity rarity, final EnchantmentCategory type, final EquipmentSlot[] slots) {
        super(rarity, type, slots);
    }
    
    public static int getFieryAuraLevel(final Inventory inventory, final DamageSource source) {
        int modifier = 0;
        for (final ItemStack armor : inventory.f_35975_) {
            if (!armor.m_41619_() && armor.m_41720_() instanceof FieryArmorItem) {
                modifier += 5;
            }
        }
        return modifier;
    }
    
    public static int getChillAuraLevel(final Inventory inventory, final DamageSource source) {
        int modifier = 0;
        for (final ItemStack armor : inventory.f_35975_) {
            if (!armor.m_41619_() && armor.m_41720_() instanceof YetiArmorItem) {
                ++modifier;
            }
        }
        return modifier;
    }
}
