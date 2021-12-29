// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTF extends we
{
    private boolean isRare;
    
    protected ItemTF(final int par1) {
        super(par1);
        this.isRare = false;
        this.a((uy)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public wr f(final wg par1ItemStack) {
        return this.isRare ? wr.c : wr.b;
    }
    
    public ItemTF makeRare() {
        this.isRare = true;
        return this;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
