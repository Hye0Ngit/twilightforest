// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class ItemTFMazebreakerPick extends ut
{
    protected ItemTFMazebreakerPick(final int par1, final ul par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        final um istack = new um(par1, 1, 0);
        istack.a(ww.p, 4);
        istack.a(ww.r, 3);
        istack.a(ww.s, 2);
        par3List.add(istack);
    }
    
    public float a(final um par1ItemStack, final amj par2Block) {
        final float strVsBlock = super.a(par1ItemStack, par2Block);
        return (par2Block == TFBlocks.mazestone) ? (strVsBlock * 16.0f) : strVsBlock;
    }
}
