// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;

public class ReappearingBlock extends VanishingBlock
{
    public ReappearingBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)this.func_176223_P().func_206870_a((Property)ReappearingBlock.VANISHED, (Comparable)false));
    }
    
    @Override
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a(builder);
        builder.func_206894_a(new Property[] { (Property)ReappearingBlock.VANISHED });
    }
}
