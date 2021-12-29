// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import twilightforest.entity.projectile.IceArrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BowItem;

public class IceBowItem extends BowItem
{
    public IceBowItem(final Item.Properties props) {
        super(props);
    }
    
    public AbstractArrow customArrow(final AbstractArrow arrow) {
        return new IceArrow(arrow.f_19853_, arrow.m_37282_());
    }
    
    public boolean m_6832_(final ItemStack toRepair, final ItemStack repairWith) {
        final Item 41720_ = toRepair.m_41720_();
        if (41720_ instanceof final BlockItem blockItem) {
            if (BlockTags.f_13047_.m_8110_((Object)blockItem.m_40614_())) {
                return true;
            }
        }
        if (!super.m_6832_(toRepair, repairWith)) {
            return false;
        }
        return true;
    }
}
