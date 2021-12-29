// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class DarkLeavesBlock extends Block
{
    protected DarkLeavesBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public int getFlammability(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return 1;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return 0;
    }
}
