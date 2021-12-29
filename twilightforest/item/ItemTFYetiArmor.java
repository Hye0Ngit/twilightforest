// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
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

public class ItemTFYetiArmor extends ItemTFArmor implements ModelRegisterCallback
{
    public ItemTFYetiArmor(final ItemArmor.ArmorMaterial material, final EntityEquipmentSlot slot, final EnumRarity rarity) {
        super(material, slot, rarity);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final EntityEquipmentSlot slot, final String layer) {
        if (slot == EntityEquipmentSlot.LEGS || slot == EntityEquipmentSlot.CHEST) {
            return "twilightforest:textures/armor/yetiarmor_2.png";
        }
        return "twilightforest:textures/armor/yetiarmor_1.png";
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            switch (this.field_77881_a) {
                case HEAD:
                case CHEST:
                case LEGS: {
                    istack.func_77966_a(Enchantments.field_180310_c, 2);
                    break;
                }
                case FEET: {
                    istack.func_77966_a(Enchantments.field_180310_c, 2);
                    istack.func_77966_a(Enchantments.field_180309_e, 4);
                    break;
                }
            }
            list.add((Object)istack);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final EntityEquipmentSlot armorSlot, final ModelBiped _default) {
        return TwilightForestMod.proxy.getYetiArmorModel(armorSlot);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltips, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltips, flags);
        tooltips.add(I18n.func_135052_a(this.func_77658_a() + ".tooltip", new Object[0]));
    }
}
