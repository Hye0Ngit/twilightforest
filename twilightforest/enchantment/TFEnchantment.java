// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import twilightforest.item.YetiArmorItem;
import java.util.Iterator;
import twilightforest.item.FieryArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

public class TFEnchantment extends Enchantment
{
    protected TFEnchantment(final Enchantment.Rarity rarity, final EnchantmentType type, final EquipmentSlotType[] slots) {
        super(rarity, type, slots);
    }
    
    public static int getFieryAuraLevel(final PlayerInventory inventory, final DamageSource source) {
        int modifier = 0;
        for (final ItemStack armor : inventory.field_70460_b) {
            if (!armor.func_190926_b() && armor.func_77973_b() instanceof FieryArmorItem) {
                modifier += 5;
            }
        }
        return modifier;
    }
    
    public static int getChillAuraLevel(final PlayerInventory inventory, final DamageSource source) {
        int modifier = 0;
        for (final ItemStack armor : inventory.field_70460_b) {
            if (!armor.func_190926_b() && armor.func_77973_b() instanceof YetiArmorItem) {
                ++modifier;
            }
        }
        return modifier;
    }
}
