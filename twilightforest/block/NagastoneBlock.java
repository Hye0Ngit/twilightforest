// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import twilightforest.enums.NagastoneVariant;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.Block;

public class NagastoneBlock extends Block
{
    public static final EnumProperty<NagastoneVariant> VARIANT;
    
    public NagastoneBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)NagastoneBlock.VARIANT, (Comparable)NagastoneVariant.SOLID));
    }
    
    public BlockState m_7417_(final BlockState state, final Direction directionToNeighbor, final BlockState neighborState, final LevelAccessor world, final BlockPos pos, final BlockPos neighborPos) {
        return this.getVariant(world, pos);
    }
    
    public BlockState m_5573_(final BlockPlaceContext ctx) {
        return this.getVariant((LevelAccessor)ctx.m_43725_(), ctx.m_8083_());
    }
    
    private BlockState getVariant(final LevelAccessor world, final BlockPos pos) {
        int connectionCount = 0;
        final Direction[] facings = new Direction[2];
        for (final Direction side : Direction.values()) {
            final BlockState neighborState = world.m_8055_(pos.m_142300_(side));
            if (neighborState.m_60734_() == this || (neighborState.m_60734_() == TFBlocks.NAGASTONE_HEAD.get() && side == neighborState.m_61143_((Property)TFHorizontalBlock.f_54117_))) {
                facings[connectionCount++] = side;
                if (connectionCount >= 2) {
                    break;
                }
            }
        }
        BlockState stateOut = null;
        switch (connectionCount) {
            case 1: {
                facings[1] = facings[0];
            }
            case 2: {
                stateOut = (BlockState)this.m_49966_().m_61124_((Property)NagastoneBlock.VARIANT, (Comparable)NagastoneVariant.getVariantFromDoubleFacing(facings[0], facings[1]));
                break;
            }
            default: {
                stateOut = this.m_49966_();
                break;
            }
        }
        return stateOut;
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)NagastoneBlock.VARIANT });
    }
    
    static {
        VARIANT = EnumProperty.m_61587_("variant", (Class)NagastoneVariant.class);
    }
}
