// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTFFood extends xw
{
    protected yb looksLike;
    protected boolean isSoup;
    
    public ItemTFFood(final int par1, final int par2) {
        super(par1, par2, false);
        this.a((wv)TFItems.creativeTab);
        this.setSoup(true);
    }
    
    public ItemTFFood(final int par1, final int par2, final float par3, final boolean par4) {
        super(par1, par2, par3, par4);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yb getLooksLike() {
        return this.looksLike;
    }
    
    public ItemTFFood setLooksLike(final yb itemLike) {
        this.looksLike = itemLike;
        return this;
    }
    
    public mr b_(final int par1) {
        if (this.looksLike != null) {
            return this.looksLike.b_(0);
        }
        return super.b_(par1);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        if (this.looksLike == null) {
            this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
        }
    }
    
    public boolean isSoup() {
        return this.isSoup;
    }
    
    public void setSoup(final boolean isSoup) {
        this.isSoup = isSoup;
        this.d(1);
    }
    
    public yd b(final yd par1ItemStack, final abv par2World, final ue par3EntityPlayer) {
        super.b(par1ItemStack, par2World, par3EntityPlayer);
        if (this.isSoup) {
            return new yd(yb.G);
        }
        return par1ItemStack;
    }
}
