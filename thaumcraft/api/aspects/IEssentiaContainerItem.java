// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.aspects;

import net.minecraft.item.ItemStack;

public interface IEssentiaContainerItem
{
    AspectList getAspects(final ItemStack p0);
    
    void setAspects(final ItemStack p0, final AspectList p1);
}
