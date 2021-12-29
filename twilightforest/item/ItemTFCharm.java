// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTFCharm extends ItemTF
{
    protected ItemTFCharm(final int par1) {
        super(par1);
        this.a((uy)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
