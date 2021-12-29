// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;
import java.util.List;

public class ItemTFMazebreakerPick extends uy
{
    protected ItemTFMazebreakerPick(final int par1, final uq par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((tj)TFItems.creativeTab);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        final ur istack = new ur(par1, 1, 0);
        istack.a(xc.r, 4);
        istack.a(xc.t, 3);
        istack.a(xc.u, 2);
        par3List.add(istack);
    }
    
    public float a(final ur par1ItemStack, final amq par2Block) {
        final float strVsBlock = super.a(par1ItemStack, par2Block);
        return (par2Block == TFBlocks.mazestone) ? (strVsBlock * 16.0f) : strVsBlock;
    }
}
