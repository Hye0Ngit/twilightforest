// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TwilightForestMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.StatCollector;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemTFFieryArmor extends ItemArmor
{
    public ItemTFFieryArmor(final ItemArmor.ArmorMaterial par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par2EnumArmorMaterial, renderIndex, armorType);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.epic;
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final int slot, final String layer) {
        if (itemstack.func_77973_b() == TFItems.fieryPlate || itemstack.func_77973_b() == TFItems.fieryHelm || itemstack.func_77973_b() == TFItems.fieryBoots) {
            return "twilightforest:textures/armor/fiery_1.png";
        }
        if (itemstack.func_77973_b() == TFItems.fieryLegs) {
            return "twilightforest:textures/armor/fiery_2.png";
        }
        return "twilightforest:textures/armor/fiery_1.png";
    }
    
    public void func_150895_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        final ItemStack istack = new ItemStack(par1, 1, 0);
        par3List.add(istack);
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == TFItems.fieryIngot || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(StatCollector.func_74838_a(this.func_77658_a() + ".tooltip"));
    }
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        return TwilightForestMod.proxy.getFieryArmorModel(armorSlot);
    }
}
