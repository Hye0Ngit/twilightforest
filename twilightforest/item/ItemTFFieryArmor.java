// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFEnchantment;
import java.util.List;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFFieryArmor extends ui implements IArmorTextureProvider
{
    public ItemTFFieryArmor(final int par1, final uk par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.a((uy)TFItems.creativeTab);
    }
    
    public wr f(final wg par1ItemStack) {
        return wr.c;
    }
    
    public String getArmorTextureFile(final wg itemstack) {
        if (itemstack.c == TFItems.fieryPlate.cp || itemstack.c == TFItems.fieryHelm.cp || itemstack.c == TFItems.fieryBoots.cp) {
            return "/mods/twilightforest/textures/armor/fiery_1.png";
        }
        if (itemstack.c == TFItems.fieryLegs.cp) {
            return "/mods/twilightforest/textures/armor/fiery_2.png";
        }
        return "/mods/twilightforest/textures/armor/fiery_1.png";
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        final wg istack = new wg(par1, 1, 0);
        istack.a(TFEnchantment.reactFire, 2);
        par3List.add(istack);
    }
    
    public boolean a(final wg par1ItemStack, final wg par2ItemStack) {
        return par2ItemStack.c == TFItems.fieryIngot.cp || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
