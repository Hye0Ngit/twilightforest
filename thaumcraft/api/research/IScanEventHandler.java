// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.research;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;

public interface IScanEventHandler
{
    ScanResult scanPhenomena(final ItemStack p0, final World p1, final EntityPlayer p2);
}
