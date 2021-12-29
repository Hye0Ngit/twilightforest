// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import twilightforest.client.ModelRegisterCallback;

public class ItemTFFieryArmor extends ItemTFArmor implements ModelRegisterCallback
{
    public ItemTFFieryArmor(final ItemArmor.ArmorMaterial armorMaterial, final EntityEquipmentSlot armorType, final EnumRarity rarity) {
        super(armorMaterial, armorType, rarity);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EntityEquipmentSlot slot, final String layer) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return "twilightforest:textures/armor/fiery_2.png";
        }
        return "twilightforest:textures/armor/fiery_1.png";
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack stack = new ItemStack((Item)this);
            list.add((Object)stack);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add(I18n.func_135052_a(this.func_77658_a() + ".tooltip", new Object[0]));
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final EntityEquipmentSlot armorSlot, final ModelBiped oldModel) {
        return TwilightForestMod.proxy.getFieryArmorModel(armorSlot);
    }
}
