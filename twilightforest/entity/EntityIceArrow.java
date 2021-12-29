// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityArrow;

public class EntityIceArrow extends EntityArrow
{
    public EntityIceArrow(final World par1World) {
        super(par1World);
    }
    
    public EntityIceArrow(final World world, final EntityPlayer player, final float velocity) {
        super(world, (EntityLivingBase)player, velocity);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
    }
}
