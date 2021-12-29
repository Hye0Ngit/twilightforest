// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ItemTFNagaArmor extends ItemArmor
{
    public ItemTFNagaArmor(final ItemArmor.ArmorMaterial par2EnumArmorMaterial, final int par3, final int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final int slot, final String layer) {
        if (itemstack.func_77973_b() == TFItems.plateNaga) {
            return "twilightforest:textures/armor/naga_scale_1.png";
        }
        if (itemstack.func_77973_b() == TFItems.legsNaga) {
            return "twilightforest:textures/armor/naga_scale_2.png";
        }
        return "twilightforest:textures/armor/naga_scale_1.png";
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == TFItems.nagaScale || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
