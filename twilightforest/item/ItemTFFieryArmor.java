// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFEnchantment;
import java.util.List;

public class ItemTFFieryArmor extends wg
{
    public ItemTFFieryArmor(final int par1, final wi par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yp f(final yd par1ItemStack) {
        return yp.d;
    }
    
    public String getArmorTexture(final yd itemstack, final nm entity, final int slot, final int layer) {
        if (itemstack.d == TFItems.fieryPlate.cv || itemstack.d == TFItems.fieryHelm.cv || itemstack.d == TFItems.fieryBoots.cv) {
            return "twilightforest:textures/armor/fiery_1.png";
        }
        if (itemstack.d == TFItems.fieryLegs.cv) {
            return "twilightforest:textures/armor/fiery_2.png";
        }
        return "twilightforest:textures/armor/fiery_1.png";
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        final yd istack = new yd(par1, 1, 0);
        istack.a(TFEnchantment.reactFire, 2);
        par3List.add(istack);
    }
    
    public boolean a(final yd par1ItemStack, final yd par2ItemStack) {
        return par2ItemStack.d == TFItems.fieryIngot.cv || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
