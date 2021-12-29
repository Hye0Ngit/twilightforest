// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.text.TextFormatting;
import twilightforest.TwilightForestMod;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.ModList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import twilightforest.tileentity.TFTileEntities;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;

public class CicadaBlock extends CritterBlock
{
    protected CicadaBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Nullable
    @Override
    public TileEntity createTileEntity(final BlockState state, final IBlockReader world) {
        return ((TileEntityType)TFTileEntities.CICADA.get()).func_200968_a();
    }
    
    @Override
    public ItemStack getSquishResult() {
        return new ItemStack((IItemProvider)Items.field_196120_bj, 1);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_190948_a(final ItemStack stack, final IBlockReader world, final List<ITextComponent> tooltip, final ITooltipFlag flag) {
        super.func_190948_a(stack, world, (List)tooltip, flag);
        if (ModList.get().isLoaded("immersiveengineering")) {
            tooltip.add((ITextComponent)new TranslationTextComponent("block.twilightforest.cicada.desc").func_240699_a_(TwilightForestMod.getRarity().field_77937_e).func_240699_a_(TextFormatting.ITALIC));
        }
    }
}
