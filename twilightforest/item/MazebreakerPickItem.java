// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.MazestoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nonnull;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;

public class MazebreakerPickItem extends PickaxeItem
{
    protected MazebreakerPickItem(final Tier material, final Item.Properties props) {
        super(material, 1, -2.8f, props);
    }
    
    public void m_6787_(final CreativeModeTab tab, final NonNullList<ItemStack> list) {
        if (this.m_41389_(tab)) {
            final ItemStack istack = new ItemStack((ItemLike)this);
            istack.m_41663_(Enchantments.f_44984_, 4);
            istack.m_41663_(Enchantments.f_44986_, 3);
            istack.m_41663_(Enchantments.f_44987_, 2);
            list.add((Object)istack);
        }
    }
    
    public float m_8102_(@Nonnull final ItemStack stack, final BlockState state) {
        final float destroySpeed = super.m_8102_(stack, state);
        return (state.m_60734_() instanceof MazestoneBlock) ? (destroySpeed * 16.0f) : destroySpeed;
    }
}
