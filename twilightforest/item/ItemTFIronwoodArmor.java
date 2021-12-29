// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import java.util.List;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraftforge.common.IArmorTextureProvider;
import net.minecraft.item.ItemArmor;

public class ItemTFIronwoodArmor extends ItemArmor implements IArmorTextureProvider
{
    public ItemTFIronwoodArmor(final int par1, final EnumArmorMaterial par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.uncommon;
    }
    
    public String getArmorTextureFile(final ItemStack itemstack) {
        if (itemstack.field_77993_c == TFItems.ironwoodPlate.field_77779_bT || itemstack.field_77993_c == TFItems.ironwoodHelm.field_77779_bT || itemstack.field_77993_c == TFItems.ironwoodBoots.field_77779_bT) {
            return "/mods/twilightforest/textures/armor/ironwood_1.png";
        }
        if (itemstack.field_77993_c == TFItems.ironwoodLegs.field_77779_bT) {
            return "/mods/twilightforest/textures/armor/ironwood_2.png";
        }
        return "/mods/twilightforest/textures/armor/ironwood_1.png";
    }
    
    public void func_77633_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        final ItemStack istack = new ItemStack(par1, 1, 0);
        switch (this.field_77881_a) {
            case 0: {
                istack.func_77966_a(Enchantment.field_77341_i, 1);
                break;
            }
            case 1: {
                istack.func_77966_a(Enchantment.field_77332_c, 1);
                break;
            }
            case 2: {
                istack.func_77966_a(Enchantment.field_77332_c, 1);
                break;
            }
            case 3: {
                istack.func_77966_a(Enchantment.field_77330_e, 1);
                break;
            }
        }
        par3List.add(istack);
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.field_77993_c == TFItems.ironwoodIngot.field_77779_bT || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
}
