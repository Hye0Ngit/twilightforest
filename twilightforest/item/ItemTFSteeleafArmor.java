// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFSteeleafArmor extends ui implements IArmorTextureProvider
{
    public ItemTFSteeleafArmor(final int par1, final uk par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.a((uy)TFItems.creativeTab);
    }
    
    public wr f(final wg par1ItemStack) {
        return wr.b;
    }
    
    public String getArmorTextureFile(final wg itemstack) {
        if (itemstack.c == TFItems.steeleafPlate.cp || itemstack.c == TFItems.steeleafHelm.cp || itemstack.c == TFItems.steeleafBoots.cp) {
            return "/mods/twilightforest/textures/armor/steeleaf_1.png";
        }
        if (itemstack.c == TFItems.steeleafLegs.cp) {
            return "/mods/twilightforest/textures/armor/steeleaf_2.png";
        }
        return "/mods/twilightforest/textures/armor/steeleaf_1.png";
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        final wg istack = new wg(par1, 1, 0);
        switch (this.b) {
            case 0: {
                istack.a(yt.h, 2);
                break;
            }
            case 1: {
                istack.a(yt.g, 2);
                break;
            }
            case 2: {
                istack.a(yt.e, 2);
                break;
            }
            case 3: {
                istack.a(yt.f, 2);
                break;
            }
        }
        par3List.add(istack);
    }
    
    public boolean a(final wg par1ItemStack, final wg par2ItemStack) {
        return par2ItemStack.c == TFItems.steeleafIngot.cp || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
