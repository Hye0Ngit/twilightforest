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

public class NagaArmorItem extends ArmorItem
{
    protected NagaArmorItem(final IArmorMaterial materialIn, final EquipmentSlotType equipmentSlotIn, final Item.Properties props) {
        super(materialIn, equipmentSlotIn, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlotType slot, final String layer) {
        if (slot == EquipmentSlotType.LEGS) {
            return "twilightforest:textures/armor/naga_scale_2.png";
        }
        return "twilightforest:textures/armor/naga_scale_1.png";
    }
    
    public void func_150895_a(final ItemGroup tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((IItemProvider)this);
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
