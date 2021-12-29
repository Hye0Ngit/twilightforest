// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;

public class GiantSwordItem extends SwordItem
{
    public GiantSwordItem(final Tier material, final Item.Properties props) {
        super(material, 10, -3.5f, props);
    }
    
    public boolean m_6832_(final ItemStack stack, final ItemStack material) {
        return material.m_41720_() == TFItems.IRONWOOD_INGOT.get() || super.m_6832_(stack, material);
    }
}
