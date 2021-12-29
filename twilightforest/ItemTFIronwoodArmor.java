// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFIronwoodArmor extends st implements IArmorTextureProvider
{
    public ItemTFIronwoodArmor(final int par1, final su par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public uw e(final um par1ItemStack) {
        return uw.b;
    }
    
    public String getArmorTextureFile(final um itemstack) {
        if (itemstack.c == TFItems.ironwoodPlate.cg || itemstack.c == TFItems.ironwoodHelm.cg || itemstack.c == TFItems.ironwoodBoots.cg) {
            return "/twilightforest/ironwood_1.png";
        }
        if (itemstack.c == TFItems.ironwoodLegs.cg) {
            return "/twilightforest/ironwood_2.png";
        }
        return "/twilightforest/ironwood_1.png";
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        final um istack = new um(par1, 1, 0);
        switch (this.a) {
            case 0: {
                istack.a(TFEnchantment.i, 1);
                break;
            }
            case 1: {
                istack.a(TFEnchantment.c, 1);
                break;
            }
            case 2: {
                istack.a(TFEnchantment.c, 1);
                break;
            }
            case 3: {
                istack.a(TFEnchantment.e, 1);
                break;
            }
        }
        par3List.add(istack);
    }
    
    public boolean a(final um par1ItemStack, final um par2ItemStack) {
        return par2ItemStack.c == TFItems.ironwoodIngot.cg || super.a(par1ItemStack, par2ItemStack);
    }
}
