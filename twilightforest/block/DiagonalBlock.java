// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import net.minecraft.util.Direction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.Block;

public class DiagonalBlock extends Block
{
    public static final BooleanProperty IS_ROTATED;
    
    public DiagonalBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)DiagonalBlock.IS_ROTATED });
    }
    
    public BlockState rotate(final BlockState state, final IWorld world, final BlockPos pos, final Rotation rot) {
        return (BlockState)((rot == Rotation.NONE || rot == Rotation.CLOCKWISE_180) ? state : state.func_206870_a((Property)DiagonalBlock.IS_ROTATED, (Comparable)!(boolean)state.func_177229_b((Property)DiagonalBlock.IS_ROTATED)));
    }
    
    @Deprecated
    public BlockState func_185471_a(final BlockState state, final Mirror mirrorIn) {
        return (BlockState)((mirrorIn == Mirror.NONE) ? state : state.func_206870_a((Property)DiagonalBlock.IS_ROTATED, (Comparable)!(boolean)state.func_177229_b((Property)DiagonalBlock.IS_ROTATED)));
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        final boolean rot = context.func_195992_f().func_176734_d() == Direction.WEST;
        return (BlockState)this.func_176223_P().func_206870_a((Property)DiagonalBlock.IS_ROTATED, (Comparable)rot);
    }
    
    static {
        IS_ROTATED = BooleanProperty.func_177716_a("is_rotated");
    }
}
