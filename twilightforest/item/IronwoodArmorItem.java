// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemGroup;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;

public class IronwoodArmorItem extends ArmorItem
{
    public IronwoodArmorItem(final IArmorMaterial armorMaterial, final EquipmentSlotType armorType, final Item.Properties props) {
        super(armorMaterial, armorType, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlotType slot, final String layer) {
        if (slot == EquipmentSlotType.LEGS) {
            return "twilightforest:textures/armor/ironwood_2.png";
        }
        return "twilightforest:textures/armor/ironwood_1.png";
    }
    
    public void func_150895_a(final ItemGroup tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((IItemProvider)this);
            switch (this.func_185083_B_()) {
                case HEAD: {
                    istack.func_77966_a(Enchantments.field_185299_g, 1);
                    break;
                }
                case CHEST:
                case LEGS: {
                    istack.func_77966_a(Enchantments.field_180310_c, 1);
                    break;
                }
                case FEET: {
                    istack.func_77966_a(Enchantments.field_180309_e, 1);
                    break;
                }
            }
            list.add((Object)istack);
        }
    }
}
