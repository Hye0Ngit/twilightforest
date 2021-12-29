// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.MazestoneBlock;
import net.minecraft.block.BlockState;
import javax.annotation.Nonnull;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class MazebreakerPickItem extends PickaxeItem
{
    protected MazebreakerPickItem(final IItemTier material, final Item.Properties props) {
        super(material, 1, -2.8f, props);
    }
    
    public void func_150895_a(final ItemGroup tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((IItemProvider)this);
            istack.func_77966_a(Enchantments.field_185305_q, 4);
            istack.func_77966_a(Enchantments.field_185307_s, 3);
            istack.func_77966_a(Enchantments.field_185308_t, 2);
            list.add((Object)istack);
        }
    }
    
    public float func_150893_a(@Nonnull final ItemStack stack, final BlockState state) {
        final float destroySpeed = super.func_150893_a(stack, state);
        return (state.func_177230_c() instanceof MazestoneBlock) ? (destroySpeed * 16.0f) : destroySpeed;
    }
}
