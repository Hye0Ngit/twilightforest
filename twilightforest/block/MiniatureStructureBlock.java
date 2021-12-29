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
import net.minecraftforge.common.ToolType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class MiniatureStructureBlock extends Block
{
    public MiniatureStructureBlock() {
        super(AbstractBlock.Properties.func_200945_a(Material.field_175972_I).func_235861_h_().harvestTool(ToolType.PICKAXE).func_200943_b(0.75f).func_226896_b_());
    }
    
    public void func_190948_a(final ItemStack stack, @Nullable final IBlockReader worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
        tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.misc.nyi"));
        super.func_190948_a(stack, worldIn, (List)tooltip, flagIn);
    }
}
