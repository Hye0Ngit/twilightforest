// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.RotatedPillarBlock;

public class TFLogBlock extends RotatedPillarBlock
{
    protected TFLogBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    public int getFlammability(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return 5;
    }
    
    public int getFireSpreadSpeed(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction face) {
        return 5;
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        if (stack.func_77973_b() == ((RotatedPillarBlock)TFBlocks.cinder_log.get()).func_199767_j()) {
            tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.nyi"));
        }
        super.func_190948_a(stack, worldIn, (List)tooltip, flagIn);
    }
}
