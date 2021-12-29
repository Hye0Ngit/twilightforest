// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.LadderBlock;

public class IronLadderBlock extends LadderBlock
{
    public static final BooleanProperty LEFT;
    public static final BooleanProperty RIGHT;
    
    IronLadderBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.m_49966_().m_61124_((Property)IronLadderBlock.LEFT, (Comparable)false)).m_61124_((Property)IronLadderBlock.RIGHT, (Comparable)false));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)IronLadderBlock.LEFT, (Property)IronLadderBlock.RIGHT });
    }
    
    public BlockState m_7417_(final BlockState state, final Direction direction, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        final Direction facing = (Direction)state.m_61143_((Property)LadderBlock.f_54337_);
        final BlockState superUpdated = super.m_7417_(state, direction, facingState, worldIn, currentPos, facingPos);
        if (superUpdated.m_60734_() != this) {
            return superUpdated;
        }
        final BlockState leftState = worldIn.m_8055_(currentPos.m_142300_(facing.m_122428_()));
        final BlockState rightState = worldIn.m_8055_(currentPos.m_142300_(facing.m_122427_()));
        return (BlockState)((BlockState)superUpdated.m_61124_((Property)IronLadderBlock.LEFT, (Comparable)(leftState.m_60734_() instanceof IronLadderBlock && leftState.m_61143_((Property)LadderBlock.f_54337_) == facing))).m_61124_((Property)IronLadderBlock.RIGHT, (Comparable)(rightState.m_60734_() instanceof IronLadderBlock && rightState.m_61143_((Property)LadderBlock.f_54337_) == facing));
    }
    
    static {
        LEFT = BooleanProperty.m_61465_("left");
        RIGHT = BooleanProperty.m_61465_("right");
    }
}
