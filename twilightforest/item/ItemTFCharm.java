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
        this.a((wv)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
