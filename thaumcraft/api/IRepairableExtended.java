// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IRepairableExtended extends IRepairable
{
    boolean doRepair(final ItemStack p0, final EntityPlayer p1, final int p2);
}
