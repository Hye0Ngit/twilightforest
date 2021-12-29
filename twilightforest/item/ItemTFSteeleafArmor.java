// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ItemTFSteeleafArmor extends wg
{
    public ItemTFSteeleafArmor(final int par1, final wi par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yp f(final yd par1ItemStack) {
        return yp.b;
    }
    
    public String getArmorTexture(final yd itemstack, final nm entity, final int slot, final int layer) {
        if (itemstack.d == TFItems.steeleafPlate.cv || itemstack.d == TFItems.steeleafHelm.cv || itemstack.d == TFItems.steeleafBoots.cv) {
            return "twilightforest:textures/armor/steeleaf_1.png";
        }
        if (itemstack.d == TFItems.steeleafLegs.cv) {
            return "twilightforest:textures/armor/steeleaf_2.png";
        }
        return "twilightforest:textures/armor/steeleaf_1.png";
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        final yd istack = new yd(par1, 1, 0);
        switch (this.b) {
            case 0: {
                istack.a(aat.h, 2);
                break;
            }
            case 1: {
                istack.a(aat.g, 2);
                break;
            }
            case 2: {
                istack.a(aat.e, 2);
                break;
            }
            case 3: {
                istack.a(aat.f, 2);
                break;
            }
        }
        par3List.add(istack);
    }
    
    public boolean a(final yd par1ItemStack, final yd par2ItemStack) {
        return par2ItemStack.d == TFItems.steeleafIngot.cv || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
