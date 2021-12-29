// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.block.Block;

public class ThornRoseBlock extends Block
{
    private static final float RADIUS = 0.4f;
    private static final VoxelShape AABB;
    
    protected ThornRoseBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return ThornRoseBlock.AABB;
    }
    
    public boolean func_196260_a(final BlockState state, final IWorldReader world, final BlockPos pos) {
        for (final Direction d : Direction.values()) {
            if (world.func_180495_p(pos.func_177972_a(d)).func_177230_c() instanceof ThornsBlock) {
                return true;
            }
        }
        return false;
    }
    
    public BlockState func_196271_a(final BlockState state, final Direction dirToNeighbor, final BlockState neighborState, final IWorld world, final BlockPos pos, final BlockPos neighborPos) {
        return this.func_196260_a(state, (IWorldReader)world, pos) ? state : Blocks.field_150350_a.func_176223_P();
    }
    
    static {
        AABB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.09999999403953552, 0.09999999403953552, 0.09999999403953552, 0.8999999761581421, 0.8999999761581421, 0.8999999761581421));
    }
}
