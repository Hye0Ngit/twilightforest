// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import twilightforest.item.ItemTFYetiArmor;
import java.util.Iterator;
import twilightforest.item.ItemTFFieryArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.Enchantment;

public class TFEnchantment extends Enchantment
{
    protected TFEnchantment(final Enchantment.Rarity rarity, final EnumEnchantmentType type, final EntityEquipmentSlot[] slots) {
        super(rarity, type, slots);
    }
    
    public static int getFieryAuraLevel(final InventoryPlayer inventory, final DamageSource source) {
        int modifier = 0;
        for (final ItemStack armor : inventory.field_70460_b) {
            if (!armor.func_190926_b() && armor.func_77973_b() instanceof ItemTFFieryArmor) {
                modifier += 5;
            }
        }
        return modifier;
    }
    
    public static int getChillAuraLevel(final InventoryPlayer inventory, final DamageSource source) {
        int modifier = 0;
        for (final ItemStack armor : inventory.field_70460_b) {
            if (!armor.func_190926_b() && armor.func_77973_b() instanceof ItemTFYetiArmor) {
                ++modifier;
            }
        }
        return modifier;
    }
}
