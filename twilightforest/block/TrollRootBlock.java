// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.tags.ITag;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.block.Block;

public class TrollRootBlock extends Block
{
    protected static final VoxelShape AABB;
    
    protected TrollRootBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public static boolean canPlaceRootBelow(final IWorldReader world, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        final Block block = state.func_177230_c();
        return block.func_203417_a((ITag)BlockTags.field_242172_aH) || block == TFBlocks.trollvidr.get() || block == TFBlocks.trollber.get() || block == TFBlocks.unripe_trollber.get();
    }
    
    @Deprecated
    public boolean func_196260_a(final BlockState state, final IWorldReader world, final BlockPos pos) {
        return canPlaceRootBelow(world, pos.func_177984_a());
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return TrollRootBlock.AABB;
    }
    
    @Deprecated
    public BlockState func_196271_a(final BlockState state, final Direction dirToNeighbor, final BlockState neighborState, final IWorld world, final BlockPos pos, final BlockPos neighborPos) {
        if (dirToNeighbor == Direction.UP) {
            return this.func_196260_a(state, (IWorldReader)world, pos) ? state : Blocks.field_150350_a.func_176223_P();
        }
        return state;
    }
    
    static {
        AABB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.1, 0.0, 0.1, 0.9, 1.0, 0.9));
    }
}
