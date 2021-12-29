// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

public class TFHorizontalBlock extends HorizontalDirectionalBlock
{
    protected TFHorizontalBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)TFHorizontalBlock.f_54117_ });
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        return (BlockState)this.m_49966_().m_61124_((Property)TFHorizontalBlock.f_54117_, (Comparable)context.m_8125_().m_122424_());
    }
}
