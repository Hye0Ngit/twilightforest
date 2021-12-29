// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import twilightforest.entity.EntityTFThrowable;

public class EntityTFLichBomb extends EntityTFThrowable
{
    public EntityTFLichBomb(final World world) {
        super(world);
    }
    
    public EntityTFLichBomb(final World world, final EntityLivingBase thrower) {
        super(world, thrower);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    private void makeTrail() {
        for (int i = 0; i < 1; ++i) {
            final double sx = 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) + this.field_70159_w;
            final double sy = 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) + this.field_70181_x;
            final double sz = 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) + this.field_70179_y;
            final double dx = this.field_70165_t + sx;
            final double dy = this.field_70163_u + sy;
            final double dz = this.field_70161_v + sz;
            this.field_70170_p.func_175688_a(EnumParticleTypes.FLAME, dx, dy, dz, sx * -0.25, sy * -0.25, sz * -0.25, new int[0]);
        }
    }
    
    public boolean func_70027_ad() {
        return true;
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        super.func_70097_a(source, amount);
        if (source.func_76364_f() != null) {
            if (!source.func_94541_c()) {
                this.explode();
            }
            return true;
        }
        return false;
    }
    
    private void explode() {
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72885_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 2.0f, false, false);
            this.func_70106_y();
        }
    }
    
    protected float func_70185_h() {
        return 0.001f;
    }
    
    protected void func_70184_a(final RayTraceResult result) {
        if (result.field_72308_g instanceof EntityTFLichBolt || result.field_72308_g instanceof EntityTFLichBomb || result.field_72308_g instanceof EntityTFLich) {
            return;
        }
        this.explode();
    }
}
