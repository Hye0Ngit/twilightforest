// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumRarity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import twilightforest.client.ModelRegisterCallback;

public class ItemTFNagaArmor extends ItemTFArmor implements ModelRegisterCallback
{
    protected ItemTFNagaArmor(final ItemArmor.ArmorMaterial materialIn, final EntityEquipmentSlot equipmentSlotIn, final EnumRarity rarity) {
        super(materialIn, equipmentSlotIn, rarity);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EntityEquipmentSlot slot, final String layer) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/naga_scale_2.png";
        }
        return "twilightforest:textures/armor/naga_scale_1.png";
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            switch (this.field_77881_a) {
                case CHEST: {
                    istack.func_77966_a(Enchantments.field_77329_d, 3);
                    break;
                }
                case LEGS: {
                    istack.func_77966_a(Enchantments.field_180310_c, 3);
                    break;
                }
            }
            list.add((Object)istack);
        }
    }
}
