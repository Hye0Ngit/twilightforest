// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTF extends up
{
    private boolean isRare;
    
    protected ItemTF(final int par1) {
        super(par1);
        this.isRare = false;
        this.a((tj)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public vb f(final ur par1ItemStack) {
        return this.isRare ? vb.c : vb.b;
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public ItemTF makeRare() {
        this.isRare = true;
        return this;
    }
}
