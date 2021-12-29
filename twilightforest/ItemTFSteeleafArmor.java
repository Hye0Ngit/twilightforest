// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFSteeleafArmor extends st implements IArmorTextureProvider
{
    public ItemTFSteeleafArmor(final int par1, final su par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public uw e(final um par1ItemStack) {
        return uw.b;
    }
    
    public String getArmorTextureFile(final um itemstack) {
        if (itemstack.c == TFItems.steeleafPlate.cg || itemstack.c == TFItems.steeleafHelm.cg || itemstack.c == TFItems.steeleafBoots.cg) {
            return "/twilightforest/steeleaf_1.png";
        }
        if (itemstack.c == TFItems.steeleafLegs.cg) {
            return "/twilightforest/steeleaf_2.png";
        }
        return "/twilightforest/steeleaf_1.png";
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        final um istack = new um(par1, 1, 0);
        switch (this.a) {
            case 0: {
                istack.a(TFEnchantment.g, 2);
                break;
            }
            case 1: {
                istack.a(TFEnchantment.f, 2);
                break;
            }
            case 2: {
                istack.a(TFEnchantment.d, 2);
                break;
            }
            case 3: {
                istack.a(TFEnchantment.e, 2);
                break;
            }
        }
        par3List.add(istack);
    }
    
    public boolean a(final um par1ItemStack, final um par2ItemStack) {
        return par2ItemStack.c == TFItems.steeleafIngot.cg || super.a(par1ItemStack, par2ItemStack);
    }
}
