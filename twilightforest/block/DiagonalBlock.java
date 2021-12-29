// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Block;

public class DiagonalBlock extends Block
{
    public static final BooleanProperty IS_ROTATED;
    
    public DiagonalBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)DiagonalBlock.IS_ROTATED });
    }
    
    public BlockState rotate(final BlockState state, final LevelAccessor world, final BlockPos pos, final Rotation rot) {
        return (BlockState)((rot == Rotation.NONE || rot == Rotation.CLOCKWISE_180) ? state : state.m_61124_((Property)DiagonalBlock.IS_ROTATED, (Comparable)!(boolean)state.m_61143_((Property)DiagonalBlock.IS_ROTATED)));
    }
    
    @Deprecated
    public BlockState m_6943_(final BlockState state, final Mirror mirrorIn) {
        return (BlockState)((mirrorIn == Mirror.NONE) ? state : state.m_61124_((Property)DiagonalBlock.IS_ROTATED, (Comparable)!(boolean)state.m_61143_((Property)DiagonalBlock.IS_ROTATED)));
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        final boolean rot = context.m_8125_().m_122424_() == Direction.WEST;
        return (BlockState)this.m_49966_().m_61124_((Property)DiagonalBlock.IS_ROTATED, (Comparable)rot);
    }
    
    static {
        IS_ROTATED = BooleanProperty.m_61465_("is_rotated");
    }
}
