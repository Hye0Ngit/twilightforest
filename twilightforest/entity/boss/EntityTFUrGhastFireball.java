// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityLargeFireball;

public class EntityTFUrGhastFireball extends EntityLargeFireball
{
    public EntityTFUrGhastFireball(final World worldObj, final EntityTFUrGhast entityTFTowerBoss, final double x, final double y, final double z) {
        super(worldObj, (EntityLivingBase)entityTFTowerBoss, x, y, z);
    }
    
    protected void func_70227_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (!this.field_70170_p.field_72995_K && !(par1MovingObjectPosition.field_72308_g instanceof EntityFireball)) {
            if (par1MovingObjectPosition.field_72308_g != null) {
                par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76362_a((EntityFireball)this, (Entity)this.field_70235_a), 16.0f);
            }
            this.field_70170_p.func_72885_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)this.field_92057_e, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            this.func_70106_y();
        }
    }
}
