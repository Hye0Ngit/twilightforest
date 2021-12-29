// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.enchantment.EnchantmentBindingCurse;
import net.minecraft.enchantment.EnchantmentVanishingCurse;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import twilightforest.client.ModelRegisterCallback;

public class ItemTFPhantomArmor extends ItemTFArmor implements ModelRegisterCallback
{
    public ItemTFPhantomArmor(final ItemArmor.ArmorMaterial armorMaterial, final EntityEquipmentSlot armorType, final EnumRarity rarity) {
        super(armorMaterial, armorType, rarity);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EntityEquipmentSlot slot, final String layer) {
        return "twilightforest:textures/armor/phantom_1.png";
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            list.add((Object)istack);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final EntityEquipmentSlot armorSlot, final ModelBiped original) {
        return TwilightForestMod.proxy.getPhantomArmorModel(armorSlot);
    }
    
    public boolean canApplyAtEnchantingTable(final ItemStack stack, final Enchantment enchantment) {
        return !(enchantment instanceof EnchantmentVanishingCurse) && !(enchantment instanceof EnchantmentBindingCurse) && enchantment.field_77351_y.func_77557_a(stack.func_77973_b());
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flag) {
        tooltip.add(I18n.func_135052_a(this.func_77658_a() + ".tooltip", new Object[0]));
    }
}
