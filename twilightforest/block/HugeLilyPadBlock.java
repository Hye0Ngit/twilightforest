// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.material.PushReaction;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Iterator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import twilightforest.enums.HugeLilypadPiece;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.WaterlilyBlock;

public class HugeLilyPadBlock extends WaterlilyBlock
{
    public static final DirectionProperty FACING;
    public static final EnumProperty<HugeLilypadPiece> PIECE;
    private static final VoxelShape SHAPE;
    private boolean isSelfDestructing;
    
    protected HugeLilyPadBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.isSelfDestructing = false;
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)HugeLilyPadBlock.FACING, (Comparable)Direction.NORTH)).m_61124_((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.NW));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder.m_61104_(new Property[] { (Property)HugeLilyPadBlock.FACING, (Property)HugeLilyPadBlock.PIECE }));
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return HugeLilyPadBlock.SHAPE;
    }
    
    public VoxelShape m_7952_(final BlockState state, final BlockGetter level, final BlockPos pos) {
        return Shapes.m_83040_();
    }
    
    public void m_6810_(final BlockState state, final Level world, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if (!this.isSelfDestructing) {
            this.setGiantBlockToAir(world, pos, state);
        }
    }
    
    private void setGiantBlockToAir(final Level world, final BlockPos pos, final BlockState state) {
        this.isSelfDestructing = true;
        for (final BlockPos check : this.getAllMyBlocks(pos, state)) {
            final BlockState stateThere = world.m_8055_(check);
            if (stateThere.m_60734_() == this) {
                world.m_46961_(check, false);
            }
        }
        this.isSelfDestructing = false;
    }
    
    public List<BlockPos> getAllMyBlocks(final BlockPos pos, final BlockState state) {
        final List<BlockPos> pieces = Lists.newArrayListWithCapacity(4);
        if (state.m_60734_() == this) {
            BlockPos blockPos = switch ((HugeLilypadPiece)state.m_61143_((Property)HugeLilyPadBlock.PIECE)) {
                case NE -> pos.m_142125_();
                case SE -> pos.m_142127_().m_142125_();
                case SW -> pos.m_142127_();
                default -> pos;
            };
            final BlockPos nwPos = blockPos;
            pieces.add(nwPos);
            pieces.add(nwPos.m_142128_());
            pieces.add(nwPos.m_142126_());
            pieces.add(nwPos.m_142128_().m_142126_());
        }
        return pieces;
    }
    
    @Deprecated
    public PushReaction m_5537_(final BlockState state) {
        return PushReaction.BLOCK;
    }
    
    static {
        FACING = TFHorizontalBlock.f_54117_;
        PIECE = EnumProperty.m_61587_("piece", (Class)HugeLilypadPiece.class);
        SHAPE = Block.m_49796_(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    }
}
