// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.BlockState;
import twilightforest.tileentity.TFSignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.WoodType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.WallSignBlock;

public class TFWallSignBlock extends WallSignBlock
{
    public TFWallSignBlock(final AbstractBlock.Properties properties, final WoodType type) {
        super(properties, type);
    }
    
    public TileEntity func_196283_a_(final IBlockReader worldIn) {
        return (TileEntity)new TFSignTileEntity();
    }
    
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }
}
