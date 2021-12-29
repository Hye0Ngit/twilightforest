// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemTFFood extends ItemFood
{
    protected Item looksLike;
    protected boolean isSoup;
    
    public ItemTFFood(final int par1, final int par2) {
        super(par1, par2, false);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.setSoup(true);
    }
    
    public ItemTFFood(final int par1, final int par2, final float par3, final boolean par4) {
        super(par1, par2, par3, par4);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public Item getLooksLike() {
        return this.looksLike;
    }
    
    public ItemTFFood setLooksLike(final Item itemLike) {
        this.looksLike = itemLike;
        return this;
    }
    
    public Icon func_77617_a(final int par1) {
        if (this.looksLike != null) {
            return this.looksLike.func_77617_a(0);
        }
        return super.func_77617_a(par1);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        if (this.looksLike == null) {
            this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
        }
    }
    
    public boolean isSoup() {
        return this.isSoup;
    }
    
    public void setSoup(final boolean isSoup) {
        this.isSoup = isSoup;
        this.func_77625_d(1);
    }
    
    public ItemStack func_77654_b(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        super.func_77654_b(par1ItemStack, par2World, par3EntityPlayer);
        if (this.isSoup) {
            return new ItemStack(Item.field_77670_E);
        }
        return par1ItemStack;
    }
}
