// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import twilightforest.util.TFDamageSources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import twilightforest.entity.SlideBlockEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import javax.annotation.Nullable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.RotatedPillarBlock;

public class SliderBlock extends RotatedPillarBlock implements IWaterLoggable
{
    public static final IntegerProperty DELAY;
    public static final BooleanProperty WATERLOGGED;
    private static final int TICK_TIME = 80;
    private static final int OFFSET_TIME = 20;
    private static final int PLAYER_RANGE = 32;
    private static final float BLOCK_DAMAGE = 5.0f;
    private static final VoxelShape Y_BB;
    private static final VoxelShape Z_BB;
    private static final VoxelShape X_BB;
    
    protected SliderBlock() {
        super(AbstractBlock.Properties.func_200949_a(Material.field_151573_f, MaterialColor.field_151664_l).func_200948_a(2.0f, 10.0f).func_200944_c().func_226896_b_());
        this.func_180632_j((BlockState)((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)SliderBlock.field_176298_M, (Comparable)Direction.Axis.Y)).func_206870_a((Property)SliderBlock.DELAY, (Comparable)0)).func_206870_a((Property)SliderBlock.WATERLOGGED, (Comparable)false));
    }
    
    public FluidState func_204507_t(final BlockState state) {
        return state.func_177229_b((Property)SliderBlock.WATERLOGGED) ? Fluids.field_204546_a.func_207204_a(false) : super.func_204507_t(state);
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final FluidState fluidstate = context.func_195991_k().func_204610_c(context.func_195995_a());
        final boolean flag = fluidstate.func_206886_c() == Fluids.field_204546_a;
        return (BlockState)super.func_196258_a(context).func_206870_a((Property)SliderBlock.WATERLOGGED, (Comparable)flag);
    }
    
    public BlockState func_196271_a(final BlockState stateIn, final Direction facing, final BlockState facingState, final IWorld worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.func_177229_b((Property)SliderBlock.WATERLOGGED)) {
            worldIn.func_205219_F_().func_205360_a(currentPos, (Object)Fluids.field_204546_a, Fluids.field_204546_a.func_205569_a((IWorldReader)worldIn));
        }
        return super.func_196271_a(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)SliderBlock.DELAY, (Property)SliderBlock.WATERLOGGED });
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        switch ((Direction.Axis)state.func_177229_b((Property)SliderBlock.field_176298_M)) {
            default: {
                return SliderBlock.Y_BB;
            }
            case X: {
                return SliderBlock.X_BB;
            }
            case Z: {
                return SliderBlock.Z_BB;
            }
        }
    }
    
    @Deprecated
    public void func_225534_a_(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        if (!world.field_72995_K && this.isConnectedInRange((World)world, pos)) {
            final SlideBlockEntity slideBlock = new SlideBlockEntity(TFEntities.slider, (World)world, pos.func_177958_n() + 0.5, pos.func_177956_o(), pos.func_177952_p() + 0.5, state);
            world.func_217376_c((Entity)slideBlock);
        }
        this.scheduleBlockUpdate((World)world, pos);
    }
    
    public boolean isConnectedInRange(final World world, final BlockPos pos) {
        final Direction.Axis axis = (Direction.Axis)world.func_180495_p(pos).func_177229_b((Property)SliderBlock.field_176298_M);
        switch (axis) {
            case Y: {
                return this.anyPlayerInRange(world, pos) || this.isConnectedInRangeRecursive(world, pos, Direction.UP) || this.isConnectedInRangeRecursive(world, pos, Direction.DOWN);
            }
            case X: {
                return this.anyPlayerInRange(world, pos) || this.isConnectedInRangeRecursive(world, pos, Direction.WEST) || this.isConnectedInRangeRecursive(world, pos, Direction.EAST);
            }
            case Z: {
                return this.anyPlayerInRange(world, pos) || this.isConnectedInRangeRecursive(world, pos, Direction.NORTH) || this.isConnectedInRangeRecursive(world, pos, Direction.SOUTH);
            }
            default: {
                return this.anyPlayerInRange(world, pos);
            }
        }
    }
    
    private boolean isConnectedInRangeRecursive(final World world, final BlockPos pos, final Direction dir) {
        final BlockPos dPos = pos.func_177972_a(dir);
        return world.func_180495_p(pos) == world.func_180495_p(dPos) && (this.anyPlayerInRange(world, dPos) || this.isConnectedInRangeRecursive(world, dPos, dir));
    }
    
    private boolean anyPlayerInRange(final World world, final BlockPos pos) {
        return world.func_217366_a(pos.func_177958_n() + 0.5, pos.func_177956_o() + 0.5, pos.func_177952_p() + 0.5, 32.0, false) != null;
    }
    
    public void scheduleBlockUpdate(final World world, final BlockPos pos) {
        final int offset = (int)world.func_180495_p(pos).func_177229_b((Property)SliderBlock.DELAY);
        final int update = 80 - (int)(world.func_82737_E() - offset * 20) % 80;
        world.func_205220_G_().func_205360_a(pos, (Object)this, update);
    }
    
    @Deprecated
    public void func_220082_b(final BlockState state, final World world, final BlockPos pos, final BlockState oldState, final boolean isMoving) {
        this.scheduleBlockUpdate(world, pos);
    }
    
    @Deprecated
    public void func_196262_a(final BlockState state, final World worldIn, final BlockPos pos, final Entity entity) {
        entity.func_70097_a(TFDamageSources.SLIDER, 5.0f);
        if (entity instanceof LivingEntity) {
            final double kx = (pos.func_177958_n() + 0.5 - entity.func_226277_ct_()) * 2.0;
            final double kz = (pos.func_177952_p() + 0.5 - entity.func_226281_cx_()) * 2.0;
            ((LivingEntity)entity).func_233627_a_(2.0f, kx, kz);
        }
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.nyi"));
        super.func_190948_a(stack, worldIn, (List)tooltip, flagIn);
    }
    
    static {
        DELAY = IntegerProperty.func_177719_a("delay", 0, 3);
        WATERLOGGED = BlockStateProperties.field_208198_y;
        Y_BB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.3125, 0.0, 0.3125, 0.6875, 1.0, 0.6875));
        Z_BB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.3125, 0.3125, 0.0, 0.6875, 0.6875, 1.0));
        X_BB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.0, 0.3125, 0.3125, 1.0, 0.6875, 0.6875));
    }
}
