// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import twilightforest.entity.projectile.IceArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.BowItem;

public class IceBowItem extends BowItem
{
    public IceBowItem(final Item.Properties props) {
        super(props);
    }
    
    public AbstractArrowEntity customArrow(final AbstractArrowEntity arrow) {
        if (arrow.func_234616_v_() instanceof LivingEntity) {
            return new IceArrowEntity(arrow.field_70170_p, (LivingEntity)arrow.func_234616_v_());
        }
        return arrow;
    }
    
    public boolean func_82789_a(final ItemStack toRepair, final ItemStack repairWith) {
        return repairWith.func_77973_b() == Blocks.field_150432_aD.func_199767_j() || super.func_82789_a(toRepair, repairWith);
    }
}
