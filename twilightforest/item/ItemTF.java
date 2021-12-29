// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import javax.annotation.Nonnull;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.Item;

public class ItemTF extends Item implements ModelRegisterCallback
{
    private final EnumRarity RARITY;
    
    protected ItemTF() {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.RARITY = EnumRarity.COMMON;
    }
    
    protected ItemTF(final EnumRarity rarity) {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.RARITY = rarity;
    }
    
    @Nonnull
    public EnumRarity func_77613_e(final ItemStack stack) {
        return stack.func_77948_v() ? ((EnumRarity.RARE.compareTo((Enum)this.RARITY) > 0) ? EnumRarity.RARE : this.RARITY) : this.RARITY;
    }
}
