// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TFEnchantment;
import java.util.List;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFFieryArmor extends su implements IArmorTextureProvider
{
    public ItemTFFieryArmor(final int par1, final sv par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.a((tj)TFItems.creativeTab);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public vb f(final ur par1ItemStack) {
        return vb.c;
    }
    
    public String getArmorTextureFile(final ur itemstack) {
        if (itemstack.c == TFItems.fieryPlate.cj || itemstack.c == TFItems.fieryHelm.cj || itemstack.c == TFItems.fieryBoots.cj) {
            return "/twilightforest/fiery_1.png";
        }
        if (itemstack.c == TFItems.fieryLegs.cj) {
            return "/twilightforest/fiery_2.png";
        }
        return "/twilightforest/fiery_1.png";
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        final ur istack = new ur(par1, 1, 0);
        istack.a(TFEnchantment.reactFire, 2);
        par3List.add(istack);
    }
    
    public boolean a(final ur par1ItemStack, final ur par2ItemStack) {
        return par2ItemStack.c == TFItems.fieryIngot.cj || super.a(par1ItemStack, par2ItemStack);
    }
}
