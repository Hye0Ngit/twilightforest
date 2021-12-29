// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorld;
import javax.annotation.Nullable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.ITag;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SaplingBlock;

public class MangroveSaplingBlock extends SaplingBlock implements IWaterLoggable
{
    public static final BooleanProperty WATERLOGGED;
    
    protected MangroveSaplingBlock(final Tree tree, final AbstractBlock.Properties properties) {
        super(tree, properties);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)MangroveSaplingBlock.WATERLOGGED, (Comparable)false));
    }
    
    @Deprecated
    public FluidState func_204507_t(final BlockState state) {
        return state.func_177229_b((Property)MangroveSaplingBlock.WATERLOGGED) ? Fluids.field_204546_a.func_207204_a(false) : super.func_204507_t(state);
    }
    
    @Deprecated
    public void func_225534_a_(final BlockState state, final ServerWorld worldIn, final BlockPos pos, final Random rand) {
        if (!isInWater(state, (IBlockReader)worldIn, pos)) {
            worldIn.func_180501_a(pos, (BlockState)this.func_176223_P().func_206870_a((Property)MangroveSaplingBlock.WATERLOGGED, (Comparable)false), 2);
        }
    }
    
    protected static boolean isInWater(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        if (state.func_177229_b((Property)MangroveSaplingBlock.WATERLOGGED)) {
            return true;
        }
        for (final Direction direction : Direction.values()) {
            if (worldIn.func_204610_c(pos.func_177972_a(direction)).func_206884_a((ITag)FluidTags.field_206959_a)) {
                return true;
            }
        }
        return false;
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final FluidState fluidstate = context.func_195991_k().func_204610_c(context.func_195995_a());
        return (BlockState)this.func_176223_P().func_206870_a((Property)MangroveSaplingBlock.WATERLOGGED, (Comparable)(fluidstate.func_206884_a((ITag)FluidTags.field_206959_a) && fluidstate.func_206882_g() == 8));
    }
    
    public BlockState func_196271_a(final BlockState stateIn, final Direction facing, final BlockState facingState, final IWorld worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.func_177229_b((Property)MangroveSaplingBlock.WATERLOGGED)) {
            worldIn.func_205219_F_().func_205360_a(currentPos, (Object)Fluids.field_204546_a, Fluids.field_204546_a.func_205569_a((IWorldReader)worldIn));
        }
        return (facing == Direction.DOWN && !this.func_196260_a(stateIn, (IWorldReader)worldIn, currentPos)) ? Blocks.field_150350_a.func_176223_P() : super.func_196271_a(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        builder.func_206894_a(new Property[] { (Property)MangroveSaplingBlock.WATERLOGGED, (Property)MangroveSaplingBlock.field_176479_b });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.field_208198_y;
    }
}
