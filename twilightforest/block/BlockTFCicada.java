// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.tileentity.TileEntityTFCicada;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTFCicada extends BlockTFCritter
{
    public static int sprCicada;
    
    protected BlockTFCicada(final int index) {
        super(index);
    }
    
    @Override
    public TileEntity createTileEntity(final World world, final int metadata) {
        return new TileEntityTFCicada();
    }
    
    static {
        BlockTFCicada.sprCicada = 5;
    }
}
