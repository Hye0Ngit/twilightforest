// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTF extends Item
{
    private boolean isRare;
    
    protected ItemTF(final int par1) {
        super(par1);
        this.isRare = false;
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return this.isRare ? EnumRarity.rare : EnumRarity.uncommon;
    }
    
    public ItemTF makeRare() {
        this.isRare = true;
        return this;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
