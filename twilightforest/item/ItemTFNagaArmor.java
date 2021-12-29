// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFNagaArmor extends ui implements IArmorTextureProvider
{
    public ItemTFNagaArmor(final int par1, final uk par2EnumArmorMaterial, final int par3, final int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.a((uy)TFItems.creativeTab);
    }
    
    public String getArmorTextureFile(final wg itemstack) {
        if (itemstack.c == TFItems.plateNaga.cp) {
            return "/twilightforest/naga_scale_1.png";
        }
        if (itemstack.c == TFItems.legsNaga.cp) {
            return "/twilightforest/naga_scale_2.png";
        }
        return "/twilightforest/naga_scale_1.png";
    }
    
    public boolean a(final wg par1ItemStack, final wg par2ItemStack) {
        return par2ItemStack.c == TFItems.nagaScale.cp || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
