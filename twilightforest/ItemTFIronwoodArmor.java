// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import forge.IArmorTextureProvider;
import forge.ITextureProvider;

public class ItemTFIronwoodArmor extends ql implements ITextureProvider, IArmorTextureProvider
{
    public ItemTFIronwoodArmor(final int par1, final cg par2EnumArmorMaterial, final int par3, final int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public fo f(final aan par1ItemStack) {
        return fo.b;
    }
    
    public String getArmorTextureFile(final aan itemstack) {
        if (itemstack.c == TFItems.ironwoodPlate.bQ || itemstack.c == TFItems.ironwoodHelm.bQ || itemstack.c == TFItems.ironwoodBoots.bQ) {
            return "/twilightforest/ironwood_1.png";
        }
        if (itemstack.c == TFItems.ironwoodLegs.bQ) {
            return "/twilightforest/ironwood_2.png";
        }
        return "/twilightforest/ironwood_1.png";
    }
}
