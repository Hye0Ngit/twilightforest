// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.tileentity.TileEntityTFCicada;

public class BlockTFCicada extends BlockTFCritter
{
    public static int sprCicada;
    
    protected BlockTFCicada(final int index) {
        super(index);
    }
    
    @Override
    public aqj createTileEntity(final zv world, final int metadata) {
        return new TileEntityTFCicada();
    }
    
    static {
        BlockTFCicada.sprCicada = 5;
    }
}
