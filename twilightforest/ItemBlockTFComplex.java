// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemBlockTFComplex extends vd
{
    public ItemBlockTFComplex(final int par1) {
        super(par1);
        this.a(true);
        this.g(0);
    }
    
    public int a(final int i) {
        return i;
    }
    
    public String a(final aan itemstack) {
        final int meta = itemstack.i();
        return super.e() + "." + meta;
    }
    
    public int b(final int i) {
        final int j = gk.a(i, 0, 15);
        return TFBlocks.complex.a(2, j);
    }
}
