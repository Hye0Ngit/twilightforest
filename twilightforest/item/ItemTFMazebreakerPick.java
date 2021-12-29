// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.block.TFBlocks;
import java.util.List;

public class ItemTFMazebreakerPick extends wo
{
    protected ItemTFMazebreakerPick(final int par1, final wf par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((uy)TFItems.creativeTab);
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        final wg istack = new wg(par1, 1, 0);
        istack.a(yt.r, 4);
        istack.a(yt.t, 3);
        istack.a(yt.u, 2);
        par3List.add(istack);
    }
    
    public float a(final wg par1ItemStack, final aou par2Block) {
        final float strVsBlock = super.a(par1ItemStack, par2Block);
        return (par2Block == TFBlocks.mazestone) ? (strVsBlock * 16.0f) : strVsBlock;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
