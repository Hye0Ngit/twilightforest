// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import javax.annotation.Nonnull;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import com.google.common.collect.Multimap;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemSword;

public class ItemTFGiantSword extends ItemSword implements ModelRegisterCallback
{
    public ItemTFGiantSword(final Item.ToolMaterial material) {
        super(material);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_82789_a(final ItemStack stack, final ItemStack material) {
        return material.func_77973_b() == TFItems.ironwood_ingot || super.func_82789_a(stack, material);
    }
    
    @Nonnull
    public Multimap<String, AttributeModifier> func_111205_h(final EntityEquipmentSlot equipmentSlot) {
        final Multimap<String, AttributeModifier> multimap = (Multimap<String, AttributeModifier>)super.func_111205_h(equipmentSlot);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            final AttributeModifier damageModifier = new AttributeModifier(ItemTFGiantSword.field_111210_e, "Weapon modifier", (double)(10.0f + this.func_150931_i()), 0);
            final AttributeModifier speedModifier = new AttributeModifier(ItemTFGiantSword.field_185050_h, "Weapon modifier", -3.5, 0);
            multimap.remove((Object)SharedMonsterAttributes.field_111264_e.func_111108_a(), (Object)damageModifier);
            multimap.remove((Object)SharedMonsterAttributes.field_188790_f.func_111108_a(), (Object)speedModifier);
            multimap.put((Object)SharedMonsterAttributes.field_111264_e.func_111108_a(), (Object)damageModifier);
            multimap.put((Object)SharedMonsterAttributes.field_188790_f.func_111108_a(), (Object)speedModifier);
            multimap.put((Object)EntityPlayer.REACH_DISTANCE.func_111108_a(), (Object)new AttributeModifier(TFItems.GIANT_REACH_MODIFIER, "Weapon modifier", 2.5, 0));
        }
        return multimap;
    }
}
