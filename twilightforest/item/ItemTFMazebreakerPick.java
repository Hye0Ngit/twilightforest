// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.block.TFBlocks;
import java.util.List;

public class ItemTFMazebreakerPick extends ym
{
    protected ItemTFMazebreakerPick(final int par1, final yc par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((wv)TFItems.creativeTab);
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        final yd istack = new yd(par1, 1, 0);
        istack.a(aat.r, 4);
        istack.a(aat.t, 3);
        istack.a(aat.u, 2);
        par3List.add(istack);
    }
    
    public float a(final yd par1ItemStack, final aqw par2Block) {
        final float strVsBlock = super.a(par1ItemStack, par2Block);
        return (par2Block == TFBlocks.mazestone) ? (strVsBlock * 16.0f) : strVsBlock;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
