// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ReappearingBlock extends VanishingBlock
{
    public ReappearingBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)this.m_49966_().m_61124_((Property)ReappearingBlock.VANISHED, (Comparable)false));
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_(builder);
        builder.m_61104_(new Property[] { (Property)ReappearingBlock.VANISHED });
    }
    
    public PushReaction m_5537_(final BlockState pState) {
        return PushReaction.BLOCK;
    }
}
