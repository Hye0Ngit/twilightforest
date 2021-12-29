// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFLichBolt extends EntityThrowable
{
    public EntityLivingBase playerReflects;
    
    public EntityTFLichBolt(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.playerReflects = null;
    }
    
    public EntityTFLichBolt(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.playerReflects = null;
    }
    
    public EntityTFLichBolt(final World par1World) {
        super(par1World);
        this.playerReflects = null;
    }
    
    protected float func_70182_d() {
        return 0.5f;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double s1 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.field_70170_p.func_72869_a("mobSpell", dx, dy, dz, s1, s2, s3);
        }
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final float i) {
        this.func_70018_K();
        if (damagesource.func_76346_g() != null) {
            final Vec3 vec3d = damagesource.func_76346_g().func_70040_Z();
            if (vec3d != null) {
                this.func_70186_c(vec3d.field_72450_a, vec3d.field_72448_b, vec3d.field_72449_c, 1.5f, 0.1f);
            }
            if (damagesource.func_76346_g() instanceof EntityLivingBase) {
                this.playerReflects = (EntityLivingBase)damagesource.func_76346_g();
            }
            return true;
        }
        return false;
    }
    
    public EntityLivingBase func_85052_h() {
        if (this.playerReflects != null) {
            return this.playerReflects;
        }
        return super.func_85052_h();
    }
    
    protected float func_70185_h() {
        return 0.001f;
    }
    
    protected void func_70184_a(final MovingObjectPosition par1MovingObjectPosition) {
        boolean passThrough = false;
        if (par1MovingObjectPosition.field_72308_g != null && (par1MovingObjectPosition.field_72308_g instanceof EntityTFLichBolt || par1MovingObjectPosition.field_72308_g instanceof EntityTFLichBomb)) {
            passThrough = true;
        }
        if (par1MovingObjectPosition.field_72308_g != null && par1MovingObjectPosition.field_72308_g instanceof EntityLivingBase) {
            if (par1MovingObjectPosition.field_72308_g instanceof EntityTFLich) {
                final EntityTFLich lich = (EntityTFLich)par1MovingObjectPosition.field_72308_g;
                if (lich.isShadowClone()) {
                    passThrough = true;
                }
            }
            if (passThrough || par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76354_b((Entity)this, (Entity)this.func_85052_h()), 6.0f)) {}
        }
        if (!passThrough) {
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_72869_a("iconcrack_" + Item.func_150891_b(Items.field_151079_bi), this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05);
            }
            if (!this.field_70170_p.field_72995_K) {
                this.func_70106_y();
            }
        }
    }
}
