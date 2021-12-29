// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import twilightforest.TFEnchantment;
import java.util.List;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraftforge.common.IArmorTextureProvider;
import net.minecraft.item.ItemArmor;

public class ItemTFFieryArmor extends ItemArmor implements IArmorTextureProvider
{
    public ItemTFFieryArmor(final int par1, final EnumArmorMaterial par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    public String getArmorTextureFile(final ItemStack itemstack) {
        if (itemstack.field_77993_c == TFItems.fieryPlate.field_77779_bT || itemstack.field_77993_c == TFItems.fieryHelm.field_77779_bT || itemstack.field_77993_c == TFItems.fieryBoots.field_77779_bT) {
            return "/mods/twilightforest/textures/armor/fiery_1.png";
        }
        if (itemstack.field_77993_c == TFItems.fieryLegs.field_77779_bT) {
            return "/mods/twilightforest/textures/armor/fiery_2.png";
        }
        return "/mods/twilightforest/textures/armor/fiery_1.png";
    }
    
    public void func_77633_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        final ItemStack istack = new ItemStack(par1, 1, 0);
        istack.func_77966_a(TFEnchantment.reactFire, 2);
        par3List.add(istack);
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.field_77993_c == TFItems.fieryIngot.field_77779_bT || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
}
