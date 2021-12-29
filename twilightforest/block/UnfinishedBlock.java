// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.IBlockReader;
import net.minecraft.item.ItemStack;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class UnfinishedBlock extends Block
{
    private boolean nyi;
    
    public UnfinishedBlock(final AbstractBlock.Properties properties, final boolean nyi) {
        super(properties);
        this.nyi = nyi;
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        if (this.nyi) {
            tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.nyi"));
        }
        else {
            tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.wip0"));
            tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.wip1"));
        }
        super.func_190948_a(stack, worldIn, (List)tooltip, flagIn);
    }
}
