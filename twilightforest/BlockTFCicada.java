// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class BlockTFCicada extends BlockTFCritter
{
    public static int sprCicada;
    
    protected BlockTFCicada(final int index) {
        super(index);
        this.cl = BlockTFCicada.sprCicada;
    }
    
    public int a(final int side, final int meta) {
        return BlockTFCicada.sprCicada;
    }
    
    @Override
    public anq createTileEntity(final xv world, final int metadata) {
        return new TileEntityTFCicada();
    }
    
    static {
        BlockTFCicada.sprCicada = 5;
    }
}
