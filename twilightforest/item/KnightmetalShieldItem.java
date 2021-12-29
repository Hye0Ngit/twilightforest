// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.ShieldItem;

public class KnightmetalShieldItem extends ShieldItem
{
    public KnightmetalShieldItem(final Item.Properties props) {
        super(props);
    }
    
    public ITextComponent func_200295_i(final ItemStack stack) {
        return (ITextComponent)new TranslationTextComponent(this.func_77667_c(stack));
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World worldIn, final List<ITextComponent> tooltip, final ITooltipFlag flagIn) {
    }
    
    public boolean func_82789_a(final ItemStack toRepair, final ItemStack repair) {
        return repair.func_77973_b() == TFItems.knightmetal_ingot.get() || (!ItemTags.field_199905_b.func_230235_a_((Object)repair.func_77973_b()) && super.func_82789_a(toRepair, repair));
    }
    
    public boolean isShield(final ItemStack stack, @Nullable final LivingEntity entity) {
        return true;
    }
}
