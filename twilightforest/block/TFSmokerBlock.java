// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import twilightforest.tileentity.TFSmokerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class TFSmokerBlock extends Block
{
    protected TFSmokerBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }
    
    @Nullable
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return new TFSmokerTileEntity();
    }
}
