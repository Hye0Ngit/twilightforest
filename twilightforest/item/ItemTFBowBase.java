// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumRarity;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemBow;

public abstract class ItemTFBowBase extends ItemBow implements ModelRegisterCallback
{
    private static final EnumRarity RARITY;
    
    public EnumRarity func_77613_e(final ItemStack stack) {
        return stack.func_77948_v() ? ((EnumRarity.RARE.compareTo((Enum)ItemTFBowBase.RARITY) > 0) ? EnumRarity.RARE : ItemTFBowBase.RARITY) : ItemTFBowBase.RARITY;
    }
    
    static {
        RARITY = EnumRarity.UNCOMMON;
    }
}
