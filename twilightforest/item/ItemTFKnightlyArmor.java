// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLiving;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class ItemTFKnightlyArmor extends ItemArmor
{
    public ItemTFKnightlyArmor(final int par1, final EnumArmorMaterial par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final int slot, final int layer) {
        if (slot == 2) {
            return "/mods/twilightforest/textures/armor/knightly_2.png";
        }
        return "/mods/twilightforest/textures/armor/knightly_1.png";
    }
    
    public void func_77633_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        final ItemStack istack = new ItemStack(par1, 1, 0);
        par3List.add(istack);
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.field_77993_c == TFItems.knightMetal.field_77779_bT || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLiving entityLiving, final ItemStack itemStack, final int armorSlot) {
        return TwilightForestMod.proxy.getKnightlyArmorModel(armorSlot);
    }
}
