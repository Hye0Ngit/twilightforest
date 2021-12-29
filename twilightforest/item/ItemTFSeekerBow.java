// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.entity.EntitySeekerArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFSeekerBow extends ItemTFBowBase
{
    public ItemTFSeekerBow() {
        this.func_111206_d("TwilightForest:seekerbow");
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Override
    protected EntityArrow getArrow(final World world, final EntityPlayer entityPlayer, final float velocity) {
        return new EntitySeekerArrow(world, entityPlayer, velocity * 0.5f);
    }
}
