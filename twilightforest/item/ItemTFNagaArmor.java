// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFNagaArmor extends su implements IArmorTextureProvider
{
    public ItemTFNagaArmor(final int par1, final sv par2EnumArmorMaterial, final int par3, final int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.a((tj)TFItems.creativeTab);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public vb f(final ur par1ItemStack) {
        return vb.c;
    }
    
    public String getArmorTextureFile(final ur itemstack) {
        if (itemstack.c == TFItems.plateNaga.cj) {
            return "/twilightforest/naga_scale_1.png";
        }
        if (itemstack.c == TFItems.legsNaga.cj) {
            return "/twilightforest/naga_scale_2.png";
        }
        return "/twilightforest/naga_scale_1.png";
    }
    
    public boolean a(final ur par1ItemStack, final ur par2ItemStack) {
        return par2ItemStack.c == TFItems.nagaScale.cj || super.a(par1ItemStack, par2ItemStack);
    }
}
