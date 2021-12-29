// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import javax.annotation.Nullable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.HorizontalBlock;

public class TFHorizontalBlock extends HorizontalBlock
{
    protected TFHorizontalBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)TFHorizontalBlock.field_185512_D });
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        return (BlockState)this.func_176223_P().func_206870_a((Property)TFHorizontalBlock.field_185512_D, (Comparable)context.func_195992_f().func_176734_d());
    }
}
