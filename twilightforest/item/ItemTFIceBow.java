// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import twilightforest.entity.EntityIceArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFIceBow extends ItemTFBowBase
{
    public ItemTFIceBow() {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public EntityArrow customizeArrow(final EntityArrow arrow) {
        if (arrow.field_70250_c instanceof EntityLivingBase) {
            return new EntityIceArrow(arrow.field_70170_p, (EntityLivingBase)arrow.field_70250_c);
        }
        return arrow;
    }
    
    public boolean func_82789_a(final ItemStack toRepair, final ItemStack repairWith) {
        return repairWith.func_77973_b() == Item.func_150898_a(Blocks.field_150432_aD) || super.func_82789_a(toRepair, repairWith);
    }
}
