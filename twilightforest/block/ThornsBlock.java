// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorld;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.block.Block;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.FluidState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import twilightforest.util.TFDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.pathfinding.PathNodeType;
import javax.annotation.Nullable;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.material.Material;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.IWaterLoggable;

public class ThornsBlock extends ConnectableRotatedPillarBlock implements IWaterLoggable
{
    private static final BooleanProperty WATERLOGGED;
    private static final float THORN_DAMAGE = 4.0f;
    
    ThornsBlock(final AbstractBlock.Properties props) {
        super(props, 10.0);
        this.func_180632_j((BlockState)this.func_176223_P().func_206870_a((Property)ThornsBlock.WATERLOGGED, (Comparable)false));
    }
    
    @Override
    public boolean canConnectTo(final BlockState state, final boolean solidSide) {
        return state.func_177230_c() instanceof ThornsBlock || state.func_177230_c() == TFBlocks.thorn_rose.get() || state.func_177230_c() == TFBlocks.thorn_leaves.get() || state.func_185904_a() == Material.field_151585_k || state.func_185904_a() == Material.field_151578_c;
    }
    
    @Nullable
    public PathNodeType getAiPathNodeType(final BlockState state, final IBlockReader world, final BlockPos pos, @Nullable final MobEntity entity) {
        return PathNodeType.DAMAGE_CACTUS;
    }
    
    @Deprecated
    public void func_196262_a(final BlockState state, final World worldIn, final BlockPos pos, final Entity entity) {
        entity.func_70097_a(TFDamageSources.THORNS, 4.0f);
    }
    
    public void func_176199_a(final World world, final BlockPos pos, final Entity entity) {
        final BlockState state = world.func_180495_p(pos);
        if (state.func_177230_c() instanceof ThornsBlock && state.func_177229_b((Property)ThornsBlock.field_176298_M) == Direction.Axis.Y) {
            this.func_196262_a(state, world, pos, entity);
        }
        super.func_176199_a(world, pos, entity);
    }
    
    public boolean removedByPlayer(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final boolean willHarvest, final FluidState fluid) {
        if (!player.field_71075_bZ.field_75098_d) {
            if (!world.field_72995_K) {
                this.doThornBurst(world, pos, state);
            }
            return false;
        }
        return super.removedByPlayer(state, world, pos, player, willHarvest, fluid);
    }
    
    @Deprecated
    public PushReaction func_149656_h(final BlockState state) {
        return PushReaction.BLOCK;
    }
    
    private void doThornBurst(final World world, final BlockPos pos, final BlockState state) {
        switch ((Direction.Axis)state.func_177229_b((Property)ThornsBlock.field_176298_M)) {
            case Y: {
                this.growThorns(world, pos, Direction.UP);
                this.growThorns(world, pos, Direction.DOWN);
                break;
            }
            case X: {
                this.growThorns(world, pos, Direction.EAST);
                this.growThorns(world, pos, Direction.WEST);
                break;
            }
            case Z: {
                this.growThorns(world, pos, Direction.NORTH);
                this.growThorns(world, pos, Direction.SOUTH);
                break;
            }
        }
        this.growThorns(world, pos, Direction.func_239631_a_(world.field_73012_v));
        this.growThorns(world, pos, Direction.func_239631_a_(world.field_73012_v));
        this.growThorns(world, pos, Direction.func_239631_a_(world.field_73012_v));
    }
    
    private void growThorns(final World world, final BlockPos pos, final Direction dir) {
        for (int length = 1 + world.field_73012_v.nextInt(3), i = 1; i < length; ++i) {
            final BlockPos dPos = pos.func_177967_a(dir, i);
            if (!world.func_175623_d(dPos)) {
                break;
            }
            world.func_180501_a(dPos, (BlockState)((Block)TFBlocks.green_thorns.get()).func_176223_P().func_206870_a((Property)ThornsBlock.field_176298_M, (Comparable)dir.func_176740_k()), 2);
        }
    }
    
    public FluidState func_204507_t(final BlockState state) {
        return state.func_177229_b((Property)ThornsBlock.WATERLOGGED) ? Fluids.field_204546_a.func_207204_a(false) : super.func_204507_t(state);
    }
    
    @Nullable
    @Override
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final FluidState fluidstate = context.func_195991_k().func_204610_c(context.func_195995_a());
        final boolean flag = fluidstate.func_206886_c() == Fluids.field_204546_a;
        return (BlockState)super.func_196258_a(context).func_206870_a((Property)ThornsBlock.WATERLOGGED, (Comparable)flag);
    }
    
    @Override
    public BlockState func_196271_a(final BlockState stateIn, final Direction facing, final BlockState facingState, final IWorld worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.func_177229_b((Property)ThornsBlock.WATERLOGGED)) {
            worldIn.func_205219_F_().func_205360_a(currentPos, (Object)Fluids.field_204546_a, Fluids.field_204546_a.func_205569_a((IWorldReader)worldIn));
        }
        return super.func_196271_a(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    @Override
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a(builder);
        builder.func_206894_a(new Property[] { (Property)ThornsBlock.WATERLOGGED });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.field_208198_y;
    }
}
