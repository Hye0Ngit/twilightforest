// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;

public class GiantLogBlock extends GiantBlock
{
    public static final EnumProperty<Direction.Axis> AXIS;
    
    public GiantLogBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)this.func_176223_P().func_206870_a((Property)GiantLogBlock.AXIS, (Comparable)Direction.Axis.Y));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)GiantLogBlock.AXIS });
    }
    
    static {
        AXIS = BlockStateProperties.field_208148_A;
    }
}
