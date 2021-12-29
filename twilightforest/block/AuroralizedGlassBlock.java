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
import net.minecraft.block.AbstractGlassBlock;

public class AuroralizedGlassBlock extends AbstractGlassBlock
{
    public AuroralizedGlassBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.nyi"));
        super.func_190948_a(stack, worldIn, (List)tooltip, flagIn);
    }
}
