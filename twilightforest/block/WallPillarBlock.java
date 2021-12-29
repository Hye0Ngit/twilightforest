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
import net.minecraft.fluid.FluidState;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.item.ItemStack;
import net.minecraft.block.SixWayBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.block.Block;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.block.IWaterLoggable;

public class WallPillarBlock extends ConnectableRotatedPillarBlock implements IWaterLoggable
{
    private final VoxelShape TOP_X;
    private final VoxelShape BOTTOM_X;
    private final VoxelShape PILLAR_X;
    private final VoxelShape NO_TOP_X;
    private final VoxelShape NO_BOTTOM_X;
    private final VoxelShape FULL_X;
    private final VoxelShape TOP_Y;
    private final VoxelShape BOTTOM_Y;
    private final VoxelShape PILLAR_Y;
    private final VoxelShape NO_TOP_Y;
    private final VoxelShape NO_BOTTOM_Y;
    private final VoxelShape FULL_Y;
    private final VoxelShape TOP_Z;
    private final VoxelShape BOTTOM_Z;
    private final VoxelShape PILLAR_Z;
    private final VoxelShape NO_TOP_Z;
    private final VoxelShape NO_BOTTOM_Z;
    private final VoxelShape FULL_Z;
    public static final BooleanProperty WATERLOGGED;
    
    public WallPillarBlock(final Material material, final double width, final double height) {
        super(AbstractBlock.Properties.func_200945_a(material).func_200948_a(1.5f, 10.0f).func_235861_h_().harvestTool(ToolType.PICKAXE).func_226896_b_(), width, height);
        this.TOP_X = Block.func_208617_a(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
        this.BOTTOM_X = Block.func_208617_a(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        this.PILLAR_X = Block.func_208617_a(0.0, 2.0, 2.0, 16.0, 14.0, 14.0);
        this.NO_TOP_X = VoxelShapes.func_197872_a(this.PILLAR_X, this.BOTTOM_X);
        this.NO_BOTTOM_X = VoxelShapes.func_197872_a(this.PILLAR_X, this.TOP_X);
        this.FULL_X = VoxelShapes.func_216384_a(this.PILLAR_X, new VoxelShape[] { this.BOTTOM_X, this.TOP_X });
        this.TOP_Y = Block.func_208617_a(0.0, 13.0, 0.0, 16.0, 16.0, 16.0);
        this.BOTTOM_Y = Block.func_208617_a(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);
        this.PILLAR_Y = Block.func_208617_a(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
        this.NO_TOP_Y = VoxelShapes.func_197872_a(this.PILLAR_Y, this.BOTTOM_Y);
        this.NO_BOTTOM_Y = VoxelShapes.func_197872_a(this.PILLAR_Y, this.TOP_Y);
        this.FULL_Y = VoxelShapes.func_216384_a(this.PILLAR_Y, new VoxelShape[] { this.BOTTOM_Y, this.TOP_Y });
        this.TOP_Z = Block.func_208617_a(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        this.BOTTOM_Z = Block.func_208617_a(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        this.PILLAR_Z = Block.func_208617_a(2.0, 2.0, 0.0, 14.0, 14.0, 16.0);
        this.NO_TOP_Z = VoxelShapes.func_197872_a(this.PILLAR_Z, this.BOTTOM_Z);
        this.NO_BOTTOM_Z = VoxelShapes.func_197872_a(this.PILLAR_Z, this.TOP_Z);
        this.FULL_Z = VoxelShapes.func_216384_a(this.PILLAR_Z, new VoxelShape[] { this.BOTTOM_Z, this.TOP_Z });
        this.func_180632_j((BlockState)this.func_176223_P().func_206870_a((Property)WallPillarBlock.WATERLOGGED, (Comparable)false));
    }
    
    @Override
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader world, final BlockPos pos, final ISelectionContext context) {
        switch ((Direction.Axis)state.func_177229_b((Property)WallPillarBlock.field_176298_M)) {
            case X: {
                return ((boolean)state.func_177229_b((Property)SixWayBlock.field_196495_y) && (boolean)state.func_177229_b((Property)SixWayBlock.field_196490_b)) ? this.PILLAR_X : (state.func_177229_b((Property)SixWayBlock.field_196495_y) ? this.NO_TOP_X : (state.func_177229_b((Property)SixWayBlock.field_196490_b) ? this.NO_BOTTOM_X : this.FULL_X));
            }
            default: {
                return ((boolean)state.func_177229_b((Property)SixWayBlock.field_196496_z) && (boolean)state.func_177229_b((Property)SixWayBlock.field_196489_A)) ? this.PILLAR_Y : (state.func_177229_b((Property)SixWayBlock.field_196496_z) ? this.NO_TOP_Y : (state.func_177229_b((Property)SixWayBlock.field_196489_A) ? this.NO_BOTTOM_Y : this.FULL_Y));
            }
            case Z: {
                return ((boolean)state.func_177229_b((Property)SixWayBlock.field_196488_a) && (boolean)state.func_177229_b((Property)SixWayBlock.field_196492_c)) ? this.PILLAR_Z : (state.func_177229_b((Property)SixWayBlock.field_196488_a) ? this.NO_TOP_Z : (state.func_177229_b((Property)SixWayBlock.field_196492_c) ? this.NO_BOTTOM_Z : this.FULL_Z));
            }
        }
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.nyi"));
        super.func_190948_a(stack, worldIn, (List)tooltip, flagIn);
    }
    
    @Override
    public boolean canConnectTo(final BlockState state, final boolean solidSide) {
        final Block block = state.func_177230_c();
        return block instanceof WallPillarBlock;
    }
    
    public FluidState func_204507_t(final BlockState state) {
        return state.func_177229_b((Property)WallPillarBlock.WATERLOGGED) ? Fluids.field_204546_a.func_207204_a(false) : super.func_204507_t(state);
    }
    
    @Nullable
    @Override
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final FluidState fluidstate = context.func_195991_k().func_204610_c(context.func_195995_a());
        final boolean flag = fluidstate.func_206886_c() == Fluids.field_204546_a;
        return (BlockState)super.func_196258_a(context).func_206870_a((Property)WallPillarBlock.WATERLOGGED, (Comparable)flag);
    }
    
    @Override
    public BlockState func_196271_a(final BlockState stateIn, final Direction facing, final BlockState facingState, final IWorld worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.func_177229_b((Property)WallPillarBlock.WATERLOGGED)) {
            worldIn.func_205219_F_().func_205360_a(currentPos, (Object)Fluids.field_204546_a, Fluids.field_204546_a.func_205569_a((IWorldReader)worldIn));
        }
        return super.func_196271_a(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    @Override
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a(builder);
        builder.func_206894_a(new Property[] { (Property)WallPillarBlock.WATERLOGGED });
    }
    
    static {
        WATERLOGGED = BlockStateProperties.field_208198_y;
    }
}
