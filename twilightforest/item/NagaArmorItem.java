// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;

public class NagaArmorItem extends ArmorItem
{
    protected NagaArmorItem(final ArmorMaterial materialIn, final EquipmentSlot equipmentSlotIn, final Item.Properties props) {
        super(materialIn, equipmentSlotIn, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlot slot, final String layer) {
        if (slot == EquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/naga_scale_2.png";
        }
        return "twilightforest:textures/armor/naga_scale_1.png";
    }
    
    public void m_6787_(final CreativeModeTab tab, final NonNullList<ItemStack> list) {
        if (this.m_41389_(tab)) {
            final ItemStack istack = new ItemStack((ItemLike)this);
            switch (this.f_40377_) {
                case CHEST: {
                    istack.m_41663_(Enchantments.f_44966_, 3);
                    break;
                }
                case LEGS: {
                    istack.m_41663_(Enchantments.f_44965_, 3);
                    break;
                }
            }
            list.add((Object)istack);
        }
    }
}
