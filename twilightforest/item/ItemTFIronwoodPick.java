// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ItemTFIronwoodPick extends ym
{
    protected ItemTFIronwoodPick(final int par1, final yc par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((wv)TFItems.creativeTab);
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        final yd istack = new yd(par1, 1, 0);
        istack.a(aat.r, 1);
        par3List.add(istack);
    }
    
    public boolean a(final yd par1ItemStack, final yd par2ItemStack) {
        return par2ItemStack.d == TFItems.ironwoodIngot.cv || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
