// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.block.LilyPadBlock;

public class HugeWaterLilyBlock extends LilyPadBlock
{
    private static final VoxelShape AABB;
    
    protected HugeWaterLilyBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return HugeWaterLilyBlock.AABB;
    }
    
    static {
        AABB = func_208617_a(1.6, 1.6, 1.6, 14.4, 14.4, 14.4);
    }
}
