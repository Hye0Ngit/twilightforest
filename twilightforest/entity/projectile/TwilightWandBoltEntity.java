// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.IRendersAsItem;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class TwilightWandBoltEntity extends TFThrowableEntity implements IRendersAsItem
{
    public TwilightWandBoltEntity(final EntityType<? extends TwilightWandBoltEntity> type, final World world) {
        super(type, world);
    }
    
    public TwilightWandBoltEntity(final World world, final LivingEntity thrower) {
        super(TFEntities.wand_bolt, world, thrower);
        this.func_234612_a_((Entity)thrower, thrower.field_70125_A, thrower.field_70177_z, 0.0f, 1.5f, 1.0f);
    }
    
    public TwilightWandBoltEntity(final World worldIn, final double x, final double y, final double z) {
        super(TFEntities.wand_bolt, worldIn, x, y, z);
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
    
    protected float func_70185_h() {
        return 0.003f;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            final IParticleData particle = (IParticleData)new ItemParticleData(ParticleTypes.field_197591_B, new ItemStack((IItemProvider)Items.field_151079_bi));
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_195590_a(particle, false, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05);
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70227_a(final RayTraceResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result instanceof EntityRayTraceResult && ((EntityRayTraceResult)result).func_216348_a() instanceof LivingEntity) {
                ((EntityRayTraceResult)result).func_216348_a().func_70097_a(DamageSource.func_76354_b((Entity)this, this.func_234616_v_()), 6.0f);
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        super.func_70097_a(source, amount);
        if (!this.field_70170_p.field_72995_K && source.func_76346_g() != null) {
            final Vector3d vec3d = source.func_76346_g().func_70040_Z();
            this.func_70186_c(vec3d.field_72450_a, vec3d.field_72448_b, vec3d.field_72449_c, 1.5f, 0.1f);
            if (source.func_76364_f() instanceof LivingEntity) {
                this.func_212361_a(source.func_76364_f());
            }
            return true;
        }
        return false;
    }
    
    public ItemStack func_184543_l() {
        return new ItemStack((IItemProvider)Items.field_151079_bi);
    }
}
