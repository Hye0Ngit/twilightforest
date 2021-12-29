// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import twilightforest.enchantment.TFEnchantment;
import net.minecraft.enchantment.Enchantment;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemTFYetiArmor extends ItemArmor
{
    public ItemTFYetiArmor(final ItemArmor.ArmorMaterial par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par2EnumArmorMaterial, renderIndex, armorType);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.epic;
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final int slot, final String layer) {
        switch (slot) {
            default: {
                return "twilightforest:textures/armor/yetiarmor_1.png";
            }
            case 1:
            case 2: {
                return "twilightforest:textures/armor/yetiarmor_2.png";
            }
        }
    }
    
    public void func_150895_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        final ItemStack istack = new ItemStack(par1, 1, 0);
        switch (this.field_77881_a) {
            case 0: {
                istack.func_77966_a(Enchantment.field_77332_c, 2);
                istack.func_77966_a(TFEnchantment.chillAura, 1);
                break;
            }
            case 1: {
                istack.func_77966_a(Enchantment.field_77332_c, 2);
                istack.func_77966_a(TFEnchantment.chillAura, 1);
                break;
            }
            case 2: {
                istack.func_77966_a(Enchantment.field_77332_c, 2);
                istack.func_77966_a(TFEnchantment.chillAura, 1);
                break;
            }
            case 3: {
                istack.func_77966_a(Enchantment.field_77332_c, 2);
                istack.func_77966_a(Enchantment.field_77330_e, 4);
                break;
            }
        }
        par3List.add(istack);
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == TFItems.alphaFur || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        return TwilightForestMod.proxy.getYetiArmorModel(armorSlot);
    }
}
