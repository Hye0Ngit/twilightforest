// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import twilightforest.entity.projectile.ITFProjectile;
import net.minecraft.entity.projectile.FireballEntity;

public class UrGhastFireballEntity extends FireballEntity implements ITFProjectile
{
    public UrGhastFireballEntity(final World world, final UrGhastEntity entityTFTowerBoss, final double x, final double y, final double z) {
        super(world, (LivingEntity)entityTFTowerBoss, x, y, z);
    }
    
    protected void func_70227_a(final RayTraceResult result) {
        if (result instanceof EntityRayTraceResult && !this.field_70170_p.field_72995_K && !(((EntityRayTraceResult)result).func_216348_a() instanceof DamagingProjectileEntity)) {
            if (((EntityRayTraceResult)result).func_216348_a() != null) {
                ((EntityRayTraceResult)result).func_216348_a().func_70097_a(DamageSource.func_233547_a_((AbstractFireballEntity)this, this.func_234616_v_()), 16.0f);
                this.func_174815_a((LivingEntity)this.func_234616_v_(), ((EntityRayTraceResult)result).func_216348_a());
            }
            final boolean flag = ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, this.func_234616_v_());
            this.field_70170_p.func_217398_a((Entity)null, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), (float)this.field_92057_e, flag, flag ? Explosion.Mode.BREAK : Explosion.Mode.NONE);
            this.func_70106_y();
        }
    }
    
    public void func_70186_c(final double x, final double y, final double z, final float scale, final float dist) {
        final Vector3d vec3d = new Vector3d(x, y, z).func_72432_b().func_72441_c(this.field_70146_Z.nextGaussian() * 0.007499999832361937 * dist, this.field_70146_Z.nextGaussian() * 0.007499999832361937 * dist, this.field_70146_Z.nextGaussian() * 0.007499999832361937 * dist).func_186678_a((double)scale);
        this.func_213317_d(vec3d);
        final float f = MathHelper.func_76133_a(func_213296_b(vec3d));
        this.field_70177_z = (float)(MathHelper.func_181159_b(vec3d.field_72450_a, z) * 57.2957763671875);
        this.field_70125_A = (float)(MathHelper.func_181159_b(vec3d.field_72448_b, (double)f) * 57.2957763671875);
        this.field_70126_B = this.field_70177_z;
        this.field_70127_C = this.field_70125_A;
    }
}
