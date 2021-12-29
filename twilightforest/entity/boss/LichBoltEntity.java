// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.entity.Entity;
import twilightforest.util.TFDamageSources;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.IRendersAsItem;
import twilightforest.entity.projectile.TFThrowableEntity;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class LichBoltEntity extends TFThrowableEntity implements IRendersAsItem
{
    public LichBoltEntity(final EntityType<? extends LichBoltEntity> type, final World world) {
        super(type, world);
    }
    
    public LichBoltEntity(final EntityType<? extends LichBoltEntity> type, final World world, final LivingEntity owner) {
        super(type, world, owner);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    private void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.func_226277_ct_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.func_226278_cu_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.func_226281_cx_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double s1 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.field_70146_Z.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197625_r, dx, dy, dz, s1, s2, s3);
        }
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final float amount) {
        super.func_70097_a(damagesource, amount);
        if (!this.field_70170_p.field_72995_K && damagesource.func_76346_g() != null) {
            final Vector3d vec3d = damagesource.func_76346_g().func_70040_Z();
            this.func_70186_c(vec3d.field_72450_a, vec3d.field_72448_b, vec3d.field_72449_c, 1.5f, 0.1f);
            if (damagesource.func_76364_f() instanceof LivingEntity) {
                this.func_212361_a(damagesource.func_76364_f());
            }
            return true;
        }
        return false;
    }
    
    protected float func_70185_h() {
        return 0.001f;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            final ItemStack itemId = new ItemStack((IItemProvider)Items.field_151079_bi);
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_195594_a((IParticleData)new ItemParticleData(ParticleTypes.field_197591_B, itemId), this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05);
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70227_a(final RayTraceResult result) {
        if (result instanceof EntityRayTraceResult) {
            final Entity entityHit = ((EntityRayTraceResult)result).func_216348_a();
            if (entityHit instanceof LichBoltEntity || entityHit instanceof LichBombEntity || (entityHit instanceof LichEntity && ((LichEntity)entityHit).isShadowClone())) {
                return;
            }
            if (!this.field_70170_p.field_72995_K) {
                if (entityHit instanceof LivingEntity) {
                    entityHit.func_70097_a(TFDamageSources.LICH_BOLT, 6.0f);
                }
                this.field_70170_p.func_72960_a((Entity)this, (byte)3);
                this.func_70106_y();
            }
        }
    }
    
    public ItemStack func_184543_l() {
        return new ItemStack((IItemProvider)Items.field_151079_bi);
    }
}
