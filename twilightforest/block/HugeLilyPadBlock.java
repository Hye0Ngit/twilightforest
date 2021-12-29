// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.PushReaction;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Iterator;
import net.minecraft.world.World;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import twilightforest.enums.HugeLilypadPiece;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BushBlock;

public class HugeLilyPadBlock extends BushBlock
{
    public static final DirectionProperty FACING;
    public static final EnumProperty<HugeLilypadPiece> PIECE;
    private static final VoxelShape AABB;
    private boolean isSelfDestructing;
    
    protected HugeLilyPadBlock(final AbstractBlock.Properties props) {
        super(props);
        this.isSelfDestructing = false;
        this.func_180632_j((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)HugeLilyPadBlock.FACING, (Comparable)Direction.NORTH)).func_206870_a((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.NW));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)HugeLilyPadBlock.FACING, (Property)HugeLilyPadBlock.PIECE });
    }
    
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return HugeLilyPadBlock.AABB;
    }
    
    protected boolean func_200014_a_(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        final FluidState ifluidstate = worldIn.func_204610_c(pos);
        return ifluidstate.func_206886_c() == Fluids.field_204546_a;
    }
    
    public void func_196243_a(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if (!this.isSelfDestructing) {
            this.setGiantBlockToAir(world, pos, state);
        }
    }
    
    private void setGiantBlockToAir(final World world, final BlockPos pos, final BlockState state) {
        this.isSelfDestructing = true;
        for (final BlockPos check : this.getAllMyBlocks(pos, state)) {
            final BlockState stateThere = world.func_180495_p(check);
            if (stateThere.func_177230_c() == this) {
                world.func_175655_b(check, false);
            }
        }
        this.isSelfDestructing = false;
    }
    
    public List<BlockPos> getAllMyBlocks(final BlockPos pos, final BlockState state) {
        final List<BlockPos> pieces = Lists.newArrayListWithCapacity(4);
        if (state.func_177230_c() == this) {
            BlockPos nwPos = pos;
            switch ((HugeLilypadPiece)state.func_177229_b((Property)HugeLilyPadBlock.PIECE)) {
                case NE: {
                    nwPos = nwPos.func_177976_e();
                    break;
                }
                case SE: {
                    nwPos = nwPos.func_177978_c().func_177976_e();
                    break;
                }
                case SW: {
                    nwPos = nwPos.func_177978_c();
                    break;
                }
            }
            pieces.add(nwPos);
            pieces.add(nwPos.func_177968_d());
            pieces.add(nwPos.func_177974_f());
            pieces.add(nwPos.func_177968_d().func_177974_f());
        }
        return pieces;
    }
    
    @Deprecated
    public PushReaction func_149656_h(final BlockState state) {
        return PushReaction.BLOCK;
    }
    
    @Deprecated
    public void func_196262_a(final BlockState state, final World worldIn, final BlockPos pos, final Entity entityIn) {
        super.func_196262_a(state, worldIn, pos, entityIn);
        if (entityIn instanceof BoatEntity) {
            worldIn.func_175655_b(new BlockPos((Vector3i)pos), true);
        }
    }
    
    static {
        FACING = TFHorizontalBlock.field_185512_D;
        PIECE = EnumProperty.func_177709_a("piece", (Class)HugeLilypadPiece.class);
        AABB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.015625, 1.0));
    }
}
