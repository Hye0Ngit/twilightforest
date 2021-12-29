// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.LadderBlock;

public class IronLadderBlock extends LadderBlock
{
    public static final BooleanProperty LEFT;
    public static final BooleanProperty RIGHT;
    
    IronLadderBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.func_176223_P().func_206870_a((Property)IronLadderBlock.LEFT, (Comparable)false)).func_206870_a((Property)IronLadderBlock.RIGHT, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)IronLadderBlock.LEFT, (Property)IronLadderBlock.RIGHT });
    }
    
    public BlockState func_196271_a(final BlockState state, final Direction direction, final BlockState facingState, final IWorld worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        final Direction facing = (Direction)state.func_177229_b((Property)LadderBlock.field_176382_a);
        final BlockState superUpdated = super.func_196271_a(state, direction, facingState, worldIn, currentPos, facingPos);
        if (superUpdated.func_177230_c() != this) {
            return superUpdated;
        }
        final BlockState leftState = worldIn.func_180495_p(currentPos.func_177972_a(facing.func_176735_f()));
        final BlockState rightState = worldIn.func_180495_p(currentPos.func_177972_a(facing.func_176746_e()));
        return (BlockState)((BlockState)superUpdated.func_206870_a((Property)IronLadderBlock.LEFT, (Comparable)(leftState.func_177230_c() instanceof IronLadderBlock && leftState.func_177229_b((Property)LadderBlock.field_176382_a) == facing))).func_206870_a((Property)IronLadderBlock.RIGHT, (Comparable)(rightState.func_177230_c() instanceof IronLadderBlock && rightState.func_177229_b((Property)LadderBlock.field_176382_a) == facing));
    }
    
    static {
        LEFT = BooleanProperty.func_177716_a("left");
        RIGHT = BooleanProperty.func_177716_a("right");
    }
}
