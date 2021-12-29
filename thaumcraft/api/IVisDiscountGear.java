// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api;

import thaumcraft.api.aspects.Aspect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IVisDiscountGear
{
    int getVisDiscount(final ItemStack p0, final EntityPlayer p1, final Aspect p2);
}
