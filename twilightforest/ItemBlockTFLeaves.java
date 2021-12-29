// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemBlockTFLeaves extends vl
{
    public ItemBlockTFLeaves(final int par1) {
        super(par1);
        this.a(true);
        this.e(0);
    }
    
    public int b(final int i) {
        final int j = ke.a(i, 0, 15);
        return TFBlocks.leaves.a(2, j);
    }
    
    public String c_(final um itemstack) {
        final int meta = itemstack.j();
        return super.a() + "." + meta;
    }
    
    public int a(final int i) {
        return i;
    }
}
