// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.entity.EntitySeekerArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFSeekerBow extends ItemTFBowBase
{
    public ItemTFSeekerBow() {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public EntityArrow customizeArrow(final EntityArrow arrow) {
        if (arrow.field_70250_c instanceof EntityLivingBase) {
            return new EntitySeekerArrow(arrow.field_70170_p, (EntityLivingBase)arrow.field_70250_c);
        }
        return arrow;
    }
}
