// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import twilightforest.client.ModelRegisterCallback;

public class ItemTFIronwoodArmor extends ItemTFArmor implements ModelRegisterCallback
{
    public ItemTFIronwoodArmor(final ItemArmor.ArmorMaterial armorMaterial, final EntityEquipmentSlot armorType, final EnumRarity rarity) {
        super(armorMaterial, armorType, rarity);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EntityEquipmentSlot slot, final String layer) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/ironwood_2.png";
        }
        return "twilightforest:textures/armor/ironwood_1.png";
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            switch (this.field_77881_a) {
                case HEAD: {
                    istack.func_77966_a(Enchantments.field_185299_g, 1);
                    break;
                }
                case CHEST: {
                    istack.func_77966_a(Enchantments.field_180310_c, 1);
                    break;
                }
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
