// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.GiantBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class GiantPickItem extends PickaxeItem
{
    protected GiantPickItem(final IItemTier material, final Item.Properties props) {
        super(material, 8, -3.5f, props);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add((ITextComponent)new TranslationTextComponent(this.func_77658_a() + ".tooltip"));
    }
    
    public float func_150893_a(final ItemStack stack, final BlockState state) {
        float destroySpeed = super.func_150893_a(stack, state);
        destroySpeed *= ((state.func_177230_c() == TFBlocks.giant_obsidian.get()) ? 64.0f : 1.0f);
        return (state.func_177230_c() instanceof GiantBlock) ? (destroySpeed * 64.0f) : destroySpeed;
    }
}
