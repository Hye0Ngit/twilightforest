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

public class SteeleafArmorItem extends ArmorItem
{
    public SteeleafArmorItem(final IArmorMaterial material, final EquipmentSlotType slot, final Item.Properties props) {
        super(material, slot, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlotType slot, final String layer) {
        if (slot == EquipmentSlotType.LEGS) {
            return "twilightforest:textures/armor/steeleaf_2.png";
        }
        return "twilightforest:textures/armor/steeleaf_1.png";
    }
    
    public void func_150895_a(final ItemGroup tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((IItemProvider)this);
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
