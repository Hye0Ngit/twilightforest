// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class ItemTFIronwoodHoe extends ItemHoe
{
    public ItemTFIronwoodHoe(final int par1, final EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.field_77993_c == TFItems.ironwoodIngot.field_77779_bT || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
