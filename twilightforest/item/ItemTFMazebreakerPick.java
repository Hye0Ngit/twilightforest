// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.EnumRarity;
import twilightforest.block.TFBlocks;
import net.minecraft.block.state.IBlockState;
import javax.annotation.Nonnull;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemPickaxe;

public class ItemTFMazebreakerPick extends ItemPickaxe implements ModelRegisterCallback
{
    protected ItemTFMazebreakerPick(final Item.ToolMaterial material) {
        super(material);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            istack.func_77966_a(Enchantments.field_185305_q, 4);
            istack.func_77966_a(Enchantments.field_185307_s, 3);
            istack.func_77966_a(Enchantments.field_185308_t, 2);
            list.add((Object)istack);
        }
    }
    
    public float func_150893_a(@Nonnull final ItemStack stack, final IBlockState state) {
        final float destroySpeed = super.func_150893_a(stack, state);
        return (state.func_177230_c() == TFBlocks.maze_stone) ? (destroySpeed * 16.0f) : destroySpeed;
    }
    
    @Nonnull
    public EnumRarity func_77613_e(final ItemStack stack) {
        return EnumRarity.RARE;
    }
}
