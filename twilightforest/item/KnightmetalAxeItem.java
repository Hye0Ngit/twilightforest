// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

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
import net.minecraft.item.AxeItem;

public class KnightmetalAxeItem extends AxeItem
{
    protected KnightmetalAxeItem(final IItemTier material, final Item.Properties props) {
        super(material, 6.0f, material.func_200928_b() * 0.05f - 3.4f, props);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltips, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltips, flags);
        tooltips.add((ITextComponent)new TranslationTextComponent(this.func_77658_a() + ".tooltip"));
    }
}
