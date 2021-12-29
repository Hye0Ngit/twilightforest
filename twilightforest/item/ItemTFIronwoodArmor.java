// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.List;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFIronwoodArmor extends su implements IArmorTextureProvider
{
    public ItemTFIronwoodArmor(final int par1, final sv par2EnumArmorMaterial, final int renderIndex, final int armorType) {
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
        if (itemstack.c == TFItems.ironwoodPlate.cj || itemstack.c == TFItems.ironwoodHelm.cj || itemstack.c == TFItems.ironwoodBoots.cj) {
            return "/twilightforest/ironwood_1.png";
        }
        if (itemstack.c == TFItems.ironwoodLegs.cj) {
            return "/twilightforest/ironwood_2.png";
        }
        return "/twilightforest/ironwood_1.png";
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        final ur istack = new ur(par1, 1, 0);
        switch (this.a) {
            case 0: {
                istack.a(xc.j, 1);
                break;
            }
            case 1: {
                istack.a(xc.d, 1);
                break;
            }
            case 2: {
                istack.a(xc.d, 1);
                break;
            }
            case 3: {
                istack.a(xc.f, 1);
                break;
            }
        }
        par3List.add(istack);
    }
    
    public boolean a(final ur par1ItemStack, final ur par2ItemStack) {
        return par2ItemStack.c == TFItems.ironwoodIngot.cj || super.a(par1ItemStack, par2ItemStack);
    }
}
