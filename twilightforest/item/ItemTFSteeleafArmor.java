// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.List;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFSteeleafArmor extends su implements IArmorTextureProvider
{
    public ItemTFSteeleafArmor(final int par1, final sv par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.a((tj)TFItems.creativeTab);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public vb f(final ur par1ItemStack) {
        return vb.b;
    }
    
    public String getArmorTextureFile(final ur itemstack) {
        if (itemstack.c == TFItems.steeleafPlate.cj || itemstack.c == TFItems.steeleafHelm.cj || itemstack.c == TFItems.steeleafBoots.cj) {
            return "/twilightforest/steeleaf_1.png";
        }
        if (itemstack.c == TFItems.steeleafLegs.cj) {
            return "/twilightforest/steeleaf_2.png";
        }
        return "/twilightforest/steeleaf_1.png";
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        final ur istack = new ur(par1, 1, 0);
        switch (this.a) {
            case 0: {
                istack.a(xc.h, 2);
                break;
            }
            case 1: {
                istack.a(xc.g, 2);
                break;
            }
            case 2: {
                istack.a(xc.e, 2);
                break;
            }
            case 3: {
                istack.a(xc.f, 2);
                break;
            }
        }
        par3List.add(istack);
    }
    
    public boolean a(final ur par1ItemStack, final ur par2ItemStack) {
        return par2ItemStack.c == TFItems.steeleafIngot.cj || super.a(par1ItemStack, par2ItemStack);
    }
}
