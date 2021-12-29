// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemBlockTFMeta extends vl
{
    private final amj myBlock;
    
    public ItemBlockTFMeta(final int par1) {
        super(par1);
        this.a(true);
        this.e(0);
        this.myBlock = amj.p[par1 + 256];
    }
    
    public int a(final int i) {
        return i;
    }
    
    public String c_(final um itemstack) {
        final int meta = itemstack.j();
        return super.a() + "." + meta;
    }
    
    public int b(final int i) {
        final int j = ke.a(i, 0, 15);
        return this.myBlock.a(2, j);
    }
}
