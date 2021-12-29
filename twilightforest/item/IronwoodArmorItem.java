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

public class IronwoodArmorItem extends ArmorItem
{
    public IronwoodArmorItem(final ArmorMaterial armorMaterial, final EquipmentSlot armorType, final Item.Properties props) {
        super(armorMaterial, armorType, props);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EquipmentSlot slot, final String layer) {
        if (slot == EquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/ironwood_2.png";
        }
        return "twilightforest:textures/armor/ironwood_1.png";
    }
    
    public void m_6787_(final CreativeModeTab tab, final NonNullList<ItemStack> list) {
        if (this.m_41389_(tab)) {
            final ItemStack istack = new ItemStack((ItemLike)this);
            switch (this.m_40402_()) {
                case HEAD: {
                    istack.m_41663_(Enchantments.f_44971_, 1);
                    break;
                }
                case CHEST:
                case LEGS: {
                    istack.m_41663_(Enchantments.f_44965_, 1);
                    break;
                }
                case FEET: {
                    istack.m_41663_(Enchantments.f_44967_, 1);
                    break;
                }
            }
            list.add((Object)istack);
        }
    }
}
