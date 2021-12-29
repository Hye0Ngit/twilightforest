// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.Vec3;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import java.util.Collection;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import net.minecraft.world.Explosion;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;

public class EntityTFHydraMortar extends EntityThrowable
{
    private static final int BURN_FACTOR = 5;
    private static final int DIRECT_DAMAGE = 18;
    public EntityLivingBase playerReflects;
    public int fuse;
    public boolean megaBlast;
    
    public EntityTFHydraMortar(final World par1World) {
        super(par1World);
        this.playerReflects = null;
        this.fuse = 80;
        this.megaBlast = false;
        this.func_70105_a(0.75f, 0.75f);
    }
    
    public EntityTFHydraMortar(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.playerReflects = null;
        this.fuse = 80;
        this.megaBlast = false;
        this.func_70105_a(0.75f, 0.75f);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.func_70048_i(this.field_70165_t, (this.field_70121_D.field_72338_b + this.field_70121_D.field_72337_e) / 2.0, this.field_70161_v);
        if (this.field_70122_E) {
            if (!this.field_70170_p.field_72995_K) {
                this.field_70159_w *= 0.9;
                this.field_70181_x *= 0.9;
                this.field_70179_y *= 0.9;
            }
            if (this.fuse-- <= 0) {
                this.detonate();
            }
        }
    }
    
    public void setToBlasting() {
        this.megaBlast = true;
    }
    
    protected void func_70184_a(final MovingObjectPosition mop) {
        if (mop.field_72308_g == null && !this.megaBlast) {
            this.field_70181_x = 0.0;
            this.field_70122_E = true;
        }
        else {
            this.detonate();
        }
    }
    
    public float func_82146_a(final Explosion par1Explosion, final World par2World, final int par3, final int par4, final int par5, final Block par6Block) {
        float var6 = super.func_82146_a(par1Explosion, par2World, par3, par4, par5, par6Block);
        if (this.megaBlast && par6Block != Block.field_71986_z && par6Block != Block.field_72102_bH && par6Block != Block.field_72104_bI) {
            var6 = Math.min(0.8f, var6);
        }
        return var6;
    }
    
    protected void detonate() {
        final float explosionPower = this.megaBlast ? 4.0f : 0.1f;
        this.field_70170_p.func_72885_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, explosionPower, true, true);
        if (!this.field_70170_p.field_72995_K) {
            final List<Entity> nearbyList = new ArrayList<Entity>(this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(1.0, 1.0, 1.0)));
            for (final Entity nearby : nearbyList) {
                if (nearby.func_70097_a(DamageSource.func_76362_a((EntityFireball)null, (Entity)this.func_85052_h()), 18.0f) && !nearby.func_70045_F()) {
                    nearby.func_70015_d(5);
                }
            }
        }
        this.func_70106_y();
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final float i) {
        this.func_70018_K();
        if (damagesource.func_76346_g() != null && !this.field_70170_p.field_72995_K) {
            final Vec3 vec3d = damagesource.func_76346_g().func_70040_Z();
            if (vec3d != null) {
                this.func_70186_c(vec3d.field_72450_a, vec3d.field_72448_b + 1.0, vec3d.field_72449_c, 1.5f, 0.1f);
                this.field_70122_E = false;
                this.fuse += 20;
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
    
    public boolean func_70027_ad() {
        return true;
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.5f;
    }
    
    protected float func_70185_h() {
        return 0.05f;
    }
    
    protected float func_70182_d() {
        return 0.75f;
    }
    
    protected float func_70183_g() {
        return -20.0f;
    }
}
