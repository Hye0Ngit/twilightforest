// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.entity.projectile.SeekerArrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BowItem;

public class SeekerBowItem extends BowItem
{
    public SeekerBowItem(final Item.Properties props) {
        super(props);
    }
    
    public AbstractArrow customArrow(final AbstractArrow arrow) {
        return new SeekerArrow(arrow.f_19853_, arrow.m_37282_());
    }
}
