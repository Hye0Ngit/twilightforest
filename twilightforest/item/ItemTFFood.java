// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemFood;

public class ItemTFFood extends ItemFood implements ModelRegisterCallback
{
    public ItemTFFood(final int amount, final float saturation, final boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
    }
}
