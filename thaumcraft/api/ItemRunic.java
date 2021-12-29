// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

public class ItemRunic extends Item implements IRunicArmor
{
    int charge;
    
    public ItemRunic(final int charge) {
        this.charge = charge;
    }
    
    public int getRunicCharge(final ItemStack itemstack) {
        return this.charge;
    }
}
