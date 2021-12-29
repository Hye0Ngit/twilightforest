// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import twilightforest.entity.ITFProjectile;
import net.minecraft.entity.projectile.EntityLargeFireball;

public class EntityTFUrGhastFireball extends EntityLargeFireball implements ITFProjectile
{
    public EntityTFUrGhastFireball(final World world, final EntityTFUrGhast entityTFTowerBoss, final double x, final double y, final double z) {
        super(world, (EntityLivingBase)entityTFTowerBoss, x, y, z);
    }
    
    protected void func_70227_a(final RayTraceResult result) {
        if (!this.field_70170_p.field_72995_K && !(result.field_72308_g instanceof EntityFireball)) {
            if (result.field_72308_g != null) {
                result.field_72308_g.func_70097_a(DamageSource.func_76362_a((EntityFireball)this, (Entity)this.field_70235_a), 16.0f);
                this.func_174815_a(this.field_70235_a, result.field_72308_g);
            }
            final boolean flag = ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this.field_70235_a);
            this.field_70170_p.func_72885_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)this.field_92057_e, flag, flag);
            this.func_70106_y();
        }
    }
    
    public Entity getThrower() {
        return (Entity)this.field_70235_a;
    }
    
    public void setThrower(final Entity entity) {
        if (entity instanceof EntityLivingBase) {
            this.field_70235_a = (EntityLivingBase)entity;
        }
    }
}
