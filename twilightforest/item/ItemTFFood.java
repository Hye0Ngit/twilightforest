// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTFFood extends vz
{
    protected we looksLike;
    protected boolean isSoup;
    
    public ItemTFFood(final int par1, final int par2) {
        super(par1, par2, false);
        this.a((uy)TFItems.creativeTab);
        this.setSoup(true);
    }
    
    public ItemTFFood(final int par1, final int par2, final float par3, final boolean par4) {
        super(par1, par2, par3, par4);
        this.a((uy)TFItems.creativeTab);
    }
    
    public we getLooksLike() {
        return this.looksLike;
    }
    
    public ItemTFFood setLooksLike(final we itemLike) {
        this.looksLike = itemLike;
        return this;
    }
    
    public lx a_(final int par1) {
        if (this.looksLike != null) {
            return this.looksLike.a_(0);
        }
        return super.a_(par1);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        if (this.looksLike == null) {
            this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
        }
    }
    
    public boolean isSoup() {
        return this.isSoup;
    }
    
    public void setSoup(final boolean isSoup) {
        this.isSoup = isSoup;
        this.d(1);
    }
    
    public wg b(final wg par1ItemStack, final zv par2World, final sk par3EntityPlayer) {
        super.b(par1ItemStack, par2World, par3EntityPlayer);
        if (this.isSoup) {
            return new wg(we.F);
        }
        return par1ItemStack;
    }
}
