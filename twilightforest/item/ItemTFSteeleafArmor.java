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

public class ItemTFSteeleafArmor extends ItemTFArmor implements ModelRegisterCallback
{
    public ItemTFSteeleafArmor(final ItemArmor.ArmorMaterial material, final EntityEquipmentSlot slot, final EnumRarity rarity) {
        super(material, slot, rarity);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EntityEquipmentSlot slot, final String layer) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/steeleaf_2.png";
        }
        return "twilightforest:textures/armor/steeleaf_1.png";
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            switch (this.field_77881_a) {
                case HEAD: {
                    istack.func_77966_a(Enchantments.field_180308_g, 2);
                    break;
                }
                case CHEST: {
                    istack.func_77966_a(Enchantments.field_185297_d, 2);
                    break;
                }
                case LEGS: {
                    istack.func_77966_a(Enchantments.field_77329_d, 2);
                    break;
                }
                case FEET: {
                    istack.func_77966_a(Enchantments.field_180309_e, 2);
                    break;
                }
            }
            list.add((Object)istack);
        }
    }
}
