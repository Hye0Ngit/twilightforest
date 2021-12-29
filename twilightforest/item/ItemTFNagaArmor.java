// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTFNagaArmor extends wg
{
    public ItemTFNagaArmor(final int par1, final wi par2EnumArmorMaterial, final int par3, final int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.a((wv)TFItems.creativeTab);
    }
    
    public String getArmorTexture(final yd itemstack, final nm entity, final int slot, final int layer) {
        if (itemstack.d == TFItems.plateNaga.cv) {
            return "twilightforest:textures/armor/naga_scale_1.png";
        }
        if (itemstack.d == TFItems.legsNaga.cv) {
            return "twilightforest:textures/armor/naga_scale_2.png";
        }
        return "twilightforest:textures/armor/naga_scale_1.png";
    }
    
    public boolean a(final yd par1ItemStack, final yd par2ItemStack) {
        return par2ItemStack.d == TFItems.nagaScale.cv || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
