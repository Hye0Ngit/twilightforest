// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.init.SoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityTFSlimeProjectile extends EntityTFThrowable
{
    public EntityTFSlimeProjectile(final World world) {
        super(world);
    }
    
    public EntityTFSlimeProjectile(final World world, final EntityLivingBase thrower) {
        super(world, thrower);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    protected float func_70185_h() {
        return 0.006f;
    }
    
    private void makeTrail() {
        for (int i = 0; i < 2; ++i) {
            final double dx = this.field_70165_t + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.field_70163_u + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.field_70161_v + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            this.field_70170_p.func_175688_a(EnumParticleTypes.SLIME, dx, dy, dz, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        super.func_70097_a(source, amount);
        this.die();
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.SLIME, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05, new int[0]);
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70184_a(final RayTraceResult target) {
        if (!this.field_70170_p.field_72995_K && target.field_72308_g instanceof EntityLivingBase) {
            target.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.func_85052_h()), 8.0f);
        }
        this.die();
    }
    
    private void die() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_184185_a(SoundEvents.field_187886_fs, 1.0f, 1.0f / (this.field_70146_Z.nextFloat() * 0.4f + 0.8f));
            this.func_70106_y();
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
        }
    }
}
