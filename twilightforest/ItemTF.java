// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemTF extends uk
{
    private boolean isRare;
    
    protected ItemTF(final int par1) {
        super(par1);
        this.isRare = false;
        this.a(th.l);
    }
    
    @SideOnly(Side.CLIENT)
    public uw e(final um par1ItemStack) {
        return this.isRare ? uw.c : uw.b;
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public ItemTF makeRare() {
        this.isRare = true;
        return this;
    }
}
