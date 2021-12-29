// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import twilightforest.entity.projectile.MoonwormShotEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.block.AnvilBlock;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorld;
import javax.annotation.Nullable;
import net.minecraft.world.IWorldReader;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.DirectionalBlock;

public abstract class CritterBlock extends DirectionalBlock implements IWaterLoggable
{
    private final float WIDTH;
    public static final BooleanProperty WATERLOGGED;
    private final VoxelShape DOWN_BB;
    private final VoxelShape UP_BB;
    private final VoxelShape NORTH_BB;
    private final VoxelShape SOUTH_BB;
    private final VoxelShape WEST_BB;
    private final VoxelShape EAST_BB;
    
    protected CritterBlock(final AbstractBlock.Properties props) {
        super(props);
        this.WIDTH = this.getWidth();
        this.DOWN_BB = VoxelShapes.func_197881_a(new AxisAlignedBB((double)(0.5f - this.WIDTH), (double)(1.0f - this.WIDTH * 2.0f), 0.20000000298023224, (double)(0.5f + this.WIDTH), 1.0, 0.800000011920929));
        this.UP_BB = VoxelShapes.func_197881_a(new AxisAlignedBB((double)(0.5f - this.WIDTH), 0.0, 0.20000000298023224, (double)(0.5f + this.WIDTH), (double)(this.WIDTH * 2.0f), 0.800000011920929));
        this.NORTH_BB = VoxelShapes.func_197881_a(new AxisAlignedBB((double)(0.5f - this.WIDTH), 0.20000000298023224, (double)(1.0f - this.WIDTH * 2.0f), (double)(0.5f + this.WIDTH), 0.800000011920929, 1.0));
        this.SOUTH_BB = VoxelShapes.func_197881_a(new AxisAlignedBB((double)(0.5f - this.WIDTH), 0.20000000298023224, 0.0, (double)(0.5f + this.WIDTH), 0.800000011920929, (double)(this.WIDTH * 2.0f)));
        this.WEST_BB = VoxelShapes.func_197881_a(new AxisAlignedBB((double)(1.0f - this.WIDTH * 2.0f), 0.20000000298023224, (double)(0.5f - this.WIDTH), 1.0, 0.800000011920929, (double)(0.5f + this.WIDTH)));
        this.EAST_BB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.0, 0.20000000298023224, (double)(0.5f - this.WIDTH), (double)(this.WIDTH * 2.0f), 0.800000011920929, (double)(0.5f + this.WIDTH)));
        this.func_180632_j((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)CritterBlock.field_176387_N, (Comparable)Direction.UP)).func_206870_a((Property)CritterBlock.WATERLOGGED, (Comparable)false));
    }
    
    public float getWidth() {
        return 0.15f;
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        switch ((Direction)state.func_177229_b((Property)CritterBlock.field_176387_N)) {
            case DOWN: {
                return this.DOWN_BB;
            }
            default: {
                return this.UP_BB;
            }
            case NORTH: {
                return this.NORTH_BB;
            }
            case SOUTH: {
                return this.SOUTH_BB;
            }
            case WEST: {
                return this.WEST_BB;
            }
            case EAST: {
                return this.EAST_BB;
            }
        }
    }
    
    public FluidState func_204507_t(final BlockState state) {
        return state.func_177229_b((Property)CritterBlock.WATERLOGGED) ? Fluids.field_204546_a.func_207204_a(false) : super.func_204507_t(state);
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final Direction clicked = context.func_196000_l();
        final FluidState fluidstate = context.func_195991_k().func_204610_c(context.func_195995_a());
        BlockState state = (BlockState)((BlockState)this.func_176223_P().func_206870_a((Property)CritterBlock.field_176387_N, (Comparable)clicked)).func_206870_a((Property)CritterBlock.WATERLOGGED, (Comparable)(fluidstate.func_206886_c() == Fluids.field_204546_a));
        if (this.func_196260_a(state, (IWorldReader)context.func_195991_k(), context.func_195995_a())) {
            return state;
        }
        for (final Direction dir : context.func_196009_e()) {
            state = (BlockState)this.func_176223_P().func_206870_a((Property)CritterBlock.field_176387_N, (Comparable)dir.func_176734_d());
            if (this.func_196260_a(state, (IWorldReader)context.func_195991_k(), context.func_195995_a())) {
                return state;
            }
        }
        return null;
    }
    
    @Deprecated
    public BlockState func_196271_a(final BlockState state, final Direction direction, final BlockState neighborState, final IWorld world, final BlockPos pos, final BlockPos neighborPos) {
        if (state.func_177229_b((Property)CritterBlock.WATERLOGGED)) {
            world.func_205219_F_().func_205360_a(pos, (Object)Fluids.field_204546_a, Fluids.field_204546_a.func_205569_a((IWorldReader)world));
        }
        if (!this.func_196260_a(state, (IWorldReader)world, pos)) {
            return Blocks.field_150350_a.func_176223_P();
        }
        return super.func_196271_a(state, direction, neighborState, world, pos, neighborPos);
    }
    
    @Deprecated
    public boolean func_196260_a(final BlockState state, final IWorldReader world, final BlockPos pos) {
        final Direction facing = (Direction)state.func_177229_b((Property)DirectionalBlock.field_176387_N);
        final BlockPos restingPos = pos.func_177972_a(facing.func_176734_d());
        return func_220055_a(world, restingPos, facing);
    }
    
    public abstract ItemStack getSquishResult();
    
    public BlockState func_185499_a(final BlockState state, final Rotation rot) {
        return (BlockState)state.func_206870_a((Property)CritterBlock.field_176387_N, (Comparable)rot.func_185831_a((Direction)state.func_177229_b((Property)CritterBlock.field_176387_N)));
    }
    
    public void func_196243_a(final BlockState state, final World worldIn, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if (newState.func_177230_c() instanceof AnvilBlock) {
            worldIn.func_184133_a((PlayerEntity)null, pos, TFSounds.BUG_SQUISH, SoundCategory.BLOCKS, 1.0f, 1.0f);
            final ItemEntity squish = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
            squish.func_199701_a_(this.getSquishResult().getStack());
        }
        super.func_196243_a(state, worldIn, pos, newState, isMoving);
    }
    
    public ActionResultType func_225533_a_(final BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        final ItemStack stack = player.func_184586_b(handIn);
        if (stack.func_77973_b() == Items.field_151069_bo) {
            if (this == TFBlocks.firefly.get()) {
                if (!player.func_184812_l_()) {
                    stack.func_190918_g(1);
                }
                player.field_71071_by.func_70441_a(new ItemStack((IItemProvider)TFBlocks.firefly_jar.get()));
                worldIn.func_175656_a(pos, ((boolean)state.func_177229_b((Property)CritterBlock.WATERLOGGED)) ? Blocks.field_150355_j.func_176223_P() : Blocks.field_150350_a.func_176223_P());
                return ActionResultType.SUCCESS;
            }
            if (this == TFBlocks.cicada.get()) {
                if (!player.func_184812_l_()) {
                    stack.func_190918_g(1);
                }
                player.field_71071_by.func_70441_a(new ItemStack((IItemProvider)TFBlocks.cicada_jar.get()));
                worldIn.func_175656_a(pos, ((boolean)state.func_177229_b((Property)CritterBlock.WATERLOGGED)) ? Blocks.field_150355_j.func_176223_P() : Blocks.field_150350_a.func_176223_P());
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }
    
    public void func_196262_a(final BlockState state, final World worldIn, final BlockPos pos, final Entity entityIn) {
        if (entityIn instanceof ProjectileEntity && !(entityIn instanceof MoonwormShotEntity)) {
            worldIn.func_175656_a(pos, ((boolean)state.func_177229_b((Property)CritterBlock.WATERLOGGED)) ? Blocks.field_150355_j.func_176223_P() : Blocks.field_150350_a.func_176223_P());
            final ItemEntity squish = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
            squish.func_199701_a_(this.getSquishResult().getStack());
        }
    }
    
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }
    
    @Nullable
    public abstract TileEntity createTileEntity(final BlockState p0, final IBlockReader p1);
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)CritterBlock.field_176387_N, (Property)CritterBlock.WATERLOGGED });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.field_208198_y;
    }
}
