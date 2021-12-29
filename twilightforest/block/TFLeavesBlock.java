// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.Direction;
import twilightforest.TFConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.LeavesBlock;

public class TFLeavesBlock extends LeavesBlock
{
    protected TFLeavesBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public int func_200011_d(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        return (int)TFConfig.COMMON_CONFIG.PERFORMANCE.leavesLightOpacity.get();
    }
    
    public int getFlammability(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return 60;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return 30;
    }
}
