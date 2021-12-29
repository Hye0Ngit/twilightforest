// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import forge.IArmorTextureProvider;
import forge.ITextureProvider;

public class ItemTFNagaArmor extends ql implements ITextureProvider, IArmorTextureProvider
{
    public ItemTFNagaArmor(final int par1, final cg par2EnumArmorMaterial, final int par3, final int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public fo f(final aan par1ItemStack) {
        return fo.c;
    }
    
    public String getArmorTextureFile(final aan itemstack) {
        if (itemstack.c == TFItems.plateNaga.bQ) {
            return "/twilightforest/naga_scale_1.png";
        }
        if (itemstack.c == TFItems.legsNaga.bQ) {
            return "/twilightforest/naga_scale_2.png";
        }
        return "/twilightforest/naga_scale_1.png";
    }
}
