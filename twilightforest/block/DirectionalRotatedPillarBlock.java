// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.RotatedPillarBlock;

public abstract class DirectionalRotatedPillarBlock extends RotatedPillarBlock
{
    public static final BooleanProperty REVERSED;
    
    public DirectionalRotatedPillarBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)DirectionalRotatedPillarBlock.REVERSED });
    }
    
    public BlockState func_196258_a(final BlockItemUseContext context) {
        return (BlockState)super.func_196258_a(context).func_206870_a((Property)DirectionalRotatedPillarBlock.REVERSED, (Comparable)(context.func_196000_l().func_176743_c() == Direction.AxisDirection.NEGATIVE));
    }
    
    @Deprecated
    public BlockState func_185471_a(final BlockState state, final Mirror mirror) {
        if (mirror != Mirror.NONE) {
            final Direction.Axis axis = (Direction.Axis)state.func_177229_b((Property)DirectionalRotatedPillarBlock.field_176298_M);
            if (axis == Direction.Axis.Y || (mirror == Mirror.LEFT_RIGHT && axis == Direction.Axis.Z) || (mirror == Mirror.FRONT_BACK && axis == Direction.Axis.X)) {
                return (BlockState)state.func_235896_a_((Property)DirectionalRotatedPillarBlock.REVERSED);
            }
        }
        return super.func_185471_a(state, mirror);
    }
    
    static {
        REVERSED = BooleanProperty.func_177716_a("reversed");
    }
}
