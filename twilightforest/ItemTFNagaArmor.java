// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFNagaArmor extends st implements IArmorTextureProvider
{
    public ItemTFNagaArmor(final int par1, final su par2EnumArmorMaterial, final int par3, final int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public uw e(final um par1ItemStack) {
        return uw.c;
    }
    
    public String getArmorTextureFile(final um itemstack) {
        if (itemstack.c == TFItems.plateNaga.cg) {
            return "/twilightforest/naga_scale_1.png";
        }
        if (itemstack.c == TFItems.legsNaga.cg) {
            return "/twilightforest/naga_scale_2.png";
        }
        return "/twilightforest/naga_scale_1.png";
    }
    
    public boolean a(final um par1ItemStack, final um par2ItemStack) {
        return par2ItemStack.c == TFItems.nagaScale.cg || super.a(par1ItemStack, par2ItemStack);
    }
}
