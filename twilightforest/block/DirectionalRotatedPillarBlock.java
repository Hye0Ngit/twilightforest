// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.Mirror;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.RotatedPillarBlock;

public abstract class DirectionalRotatedPillarBlock extends RotatedPillarBlock
{
    public static final BooleanProperty REVERSED;
    
    public DirectionalRotatedPillarBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)DirectionalRotatedPillarBlock.REVERSED });
    }
    
    public BlockState m_5573_(final BlockPlaceContext context) {
        return (BlockState)super.m_5573_(context).m_61124_((Property)DirectionalRotatedPillarBlock.REVERSED, (Comparable)(context.m_43719_().m_122421_() == Direction.AxisDirection.NEGATIVE));
    }
    
    @Deprecated
    public BlockState m_6943_(final BlockState state, final Mirror mirror) {
        if (mirror != Mirror.NONE) {
            final Direction.Axis axis = (Direction.Axis)state.m_61143_((Property)DirectionalRotatedPillarBlock.f_55923_);
            if (axis == Direction.Axis.Y || (mirror == Mirror.LEFT_RIGHT && axis == Direction.Axis.Z) || (mirror == Mirror.FRONT_BACK && axis == Direction.Axis.X)) {
                return (BlockState)state.m_61122_((Property)DirectionalRotatedPillarBlock.REVERSED);
            }
        }
        return super.m_6943_(state, mirror);
    }
    
    static {
        REVERSED = BooleanProperty.m_61465_("reversed");
    }
}
