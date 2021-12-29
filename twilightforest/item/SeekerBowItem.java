// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.EntityType;
import twilightforest.entity.projectile.SeekerArrowEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.BowItem;

public class SeekerBowItem extends BowItem
{
    public SeekerBowItem(final Item.Properties props) {
        super(props);
    }
    
    public AbstractArrowEntity customArrow(final AbstractArrowEntity arrow) {
        if (arrow.func_234616_v_() instanceof LivingEntity) {
            return new SeekerArrowEntity(TFEntities.seeker_arrow, arrow.field_70170_p, (LivingEntity)arrow.func_234616_v_());
        }
        return arrow;
    }
}
