// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFFieryArmor extends st implements IArmorTextureProvider
{
    public ItemTFFieryArmor(final int par1, final su par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public uw e(final um par1ItemStack) {
        return uw.c;
    }
    
    public String getArmorTextureFile(final um itemstack) {
        if (itemstack.c == TFItems.fieryPlate.cg || itemstack.c == TFItems.fieryHelm.cg || itemstack.c == TFItems.fieryBoots.cg) {
            return "/twilightforest/fiery_1.png";
        }
        if (itemstack.c == TFItems.fieryLegs.cg) {
            return "/twilightforest/fiery_2.png";
        }
        return "/twilightforest/fiery_1.png";
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        final um istack = new um(par1, 1, 0);
        istack.a(TFEnchantment.reactFire, 2);
        par3List.add(istack);
    }
    
    public boolean a(final um par1ItemStack, final um par2ItemStack) {
        return par2ItemStack.c == TFItems.fieryIngot.cg || super.a(par1ItemStack, par2ItemStack);
    }
}
