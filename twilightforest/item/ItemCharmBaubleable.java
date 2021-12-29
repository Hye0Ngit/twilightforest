// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.compat.Baubles;
import twilightforest.compat.TFCompat;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumRarity;

public class ItemCharmBaubleable extends ItemTF
{
    ItemCharmBaubleable(final EnumRarity rarity) {
        super(rarity);
    }
    
    @Nullable
    public ICapabilityProvider initCapabilities(final ItemStack stack, @Nullable final NBTTagCompound nbt) {
        return (ICapabilityProvider)(TFCompat.BAUBLES.isActivated() ? new Baubles.BasicBaubleProvider() : null);
    }
}
