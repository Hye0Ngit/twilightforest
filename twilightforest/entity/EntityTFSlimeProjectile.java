// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFSlimeProjectile extends EntityThrowable
{
    public EntityTFSlimeProjectile(final World par1World) {
        super(par1World);
    }
    
    public EntityTFSlimeProjectile(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    protected float func_70185_h() {
        return 0.006f;
    }
    
    public void makeTrail() {
        for (int i = 0; i < 2; ++i) {
            final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            this.field_70170_p.func_72869_a("slime", dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final float i) {
        this.func_70018_K();
        this.pop();
        return true;
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g == null || !(par1MovingObjectPosition.field_72308_g instanceof EntityLivingBase) || par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), 8.0f)) {}
        this.pop();
    }
    
    protected void pop() {
        for (int i = 0; i < 8; ++i) {
            this.field_70170_p.func_72869_a("slime", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05);
        }
        this.field_70170_p.func_72956_a((Entity)this, "mob.slime.big", 1.0f, 1.0f / (this.field_70146_Z.nextFloat() * 0.4f + 0.8f));
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
}
