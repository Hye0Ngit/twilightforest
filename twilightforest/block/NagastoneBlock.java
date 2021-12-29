// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.state.StateContainer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import twilightforest.enums.NagastoneVariant;
import net.minecraft.state.EnumProperty;
import net.minecraft.block.Block;

public class NagastoneBlock extends Block
{
    public static final EnumProperty<NagastoneVariant> VARIANT;
    
    public NagastoneBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)NagastoneBlock.VARIANT, (Comparable)NagastoneVariant.SOLID));
    }
    
    public BlockState func_196271_a(final BlockState state, final Direction directionToNeighbor, final BlockState neighborState, final IWorld world, final BlockPos pos, final BlockPos neighborPos) {
        return this.getVariant(world, pos);
    }
    
    public BlockState func_196258_a(final BlockItemUseContext ctx) {
        return this.getVariant((IWorld)ctx.func_195991_k(), ctx.func_195995_a());
    }
    
    private BlockState getVariant(final IWorld world, final BlockPos pos) {
        int connectionCount = 0;
        final Direction[] facings = new Direction[2];
        for (final Direction side : Direction.values()) {
            final BlockState neighborState = world.func_180495_p(pos.func_177972_a(side));
            if (neighborState.func_177230_c() == this || (neighborState.func_177230_c() == TFBlocks.naga_stone_head.get() && side == neighborState.func_177229_b((Property)TFHorizontalBlock.field_185512_D))) {
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
                stateOut = (BlockState)this.func_176223_P().func_206870_a((Property)NagastoneBlock.VARIANT, (Comparable)NagastoneVariant.getVariantFromDoubleFacing(facings[0], facings[1]));
                break;
            }
            default: {
                stateOut = this.func_176223_P();
                break;
            }
        }
        return stateOut;
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)NagastoneBlock.VARIANT });
    }
    
    static {
        VARIANT = EnumProperty.func_177709_a("variant", (Class)NagastoneVariant.class);
    }
}
