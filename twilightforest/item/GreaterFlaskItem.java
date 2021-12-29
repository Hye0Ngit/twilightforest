// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class GreaterFlaskItem extends BrittleFlaskItem
{
    public GreaterFlaskItem(final Item.Properties properties) {
        super(properties);
    }
    
    @Override
    public ItemStack m_7968_() {
        final ItemStack stack = new ItemStack((ItemLike)this);
        stack.m_41784_().m_128405_("Uses", 0);
        PotionUtils.m_43549_(stack, Potions.f_43598_);
        return stack;
    }
    
    @Override
    public boolean m_142522_(final ItemStack stack) {
        return false;
    }
    
    public Rarity m_41460_(final ItemStack stack) {
        return PotionUtils.m_43547_(stack).isEmpty() ? Rarity.UNCOMMON : Rarity.RARE;
    }
    
    @Override
    public boolean canBreak() {
        return false;
    }
    
    @Override
    public boolean canBeRefilled(final ItemStack stack) {
        return true;
    }
    
    @Override
    public void m_7373_(final ItemStack stack, @Nullable final Level level, final List<Component> tooltip, final TooltipFlag flag) {
        PotionUtils.m_43555_(stack, (List)tooltip, 1.0f);
        tooltip.add((Component)new TranslatableComponent("item.twilightforest.flask_doses", new Object[] { stack.m_41784_().m_128451_("Uses"), 4 }).m_130940_(ChatFormatting.GRAY));
    }
    
    @Override
    public void m_6787_(final CreativeModeTab tab, final NonNullList<ItemStack> items) {
        if (this.m_41389_(tab)) {
            final ItemStack stack = new ItemStack((ItemLike)this);
            stack.m_41784_().m_128405_("Uses", 0);
            items.add((Object)stack);
        }
    }
}
