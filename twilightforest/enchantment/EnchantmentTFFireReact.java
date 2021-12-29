// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.Enchantment;

public class EnchantmentTFFireReact extends Enchantment
{
    public EnchantmentTFFireReact(final Enchantment.Rarity rarity) {
        super(rarity, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] { EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET });
        this.func_77322_b("tfFireReact");
    }
}
