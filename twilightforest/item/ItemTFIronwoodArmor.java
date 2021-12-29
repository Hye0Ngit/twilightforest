// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemTFIronwoodArmor extends ui implements IArmorTextureProvider
{
    public ItemTFIronwoodArmor(final int par1, final uk par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.a((uy)TFItems.creativeTab);
    }
    
    public wr f(final wg par1ItemStack) {
        return wr.b;
    }
    
    public String getArmorTextureFile(final wg itemstack) {
        if (itemstack.c == TFItems.ironwoodPlate.cp || itemstack.c == TFItems.ironwoodHelm.cp || itemstack.c == TFItems.ironwoodBoots.cp) {
            return "/mods/twilightforest/textures/armor/ironwood_1.png";
        }
        if (itemstack.c == TFItems.ironwoodLegs.cp) {
            return "/mods/twilightforest/textures/armor/ironwood_2.png";
        }
        return "/mods/twilightforest/textures/armor/ironwood_1.png";
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        final wg istack = new wg(par1, 1, 0);
        switch (this.b) {
            case 0: {
                istack.a(yt.j, 1);
                break;
            }
            case 1: {
                istack.a(yt.d, 1);
                break;
            }
            case 2: {
                istack.a(yt.d, 1);
                break;
            }
            case 3: {
                istack.a(yt.f, 1);
                break;
            }
        }
        par3List.add(istack);
    }
    
    public boolean a(final wg par1ItemStack, final wg par2ItemStack) {
        return par2ItemStack.c == TFItems.ironwoodIngot.cp || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
