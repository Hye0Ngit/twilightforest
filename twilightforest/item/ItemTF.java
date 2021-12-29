// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTF extends yb
{
    private boolean isRare;
    
    protected ItemTF(final int par1) {
        super(par1);
        this.isRare = false;
        this.a((wv)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public yp f(final yd par1ItemStack) {
        return this.isRare ? yp.c : yp.b;
    }
    
    public ItemTF makeRare() {
        this.isRare = true;
        return this;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
