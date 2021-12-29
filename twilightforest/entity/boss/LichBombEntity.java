// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.ExplosionContext;
import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import twilightforest.util.TFDamageSources;
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
public class LichBombEntity extends TFThrowableEntity implements IRendersAsItem
{
    public LichBombEntity(final EntityType<? extends LichBombEntity> type, final World world) {
        super(type, world);
    }
    
    public LichBombEntity(final EntityType<? extends LichBombEntity> type, final World world, final LivingEntity thrower) {
        super(type, world, thrower);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    private void makeTrail() {
        for (int i = 0; i < 1; ++i) {
            final double sx = 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) + this.func_213322_ci().func_82615_a();
            final double sy = 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) + this.func_213322_ci().func_82617_b();
            final double sz = 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) + this.func_213322_ci().func_82616_c();
            final double dx = this.func_226277_ct_() + sx;
            final double dy = this.func_226278_cu_() + sy;
            final double dz = this.func_226281_cx_() + sz;
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197631_x, dx, dy, dz, sx * -0.25, sy * -0.25, sz * -0.25);
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
            this.field_70170_p.func_230546_a_((Entity)this, TFDamageSources.LICH_BOMB, (ExplosionContext)null, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 2.0f, false, Explosion.Mode.NONE);
            this.func_70106_y();
        }
    }
    
    protected float func_70185_h() {
        return 0.001f;
    }
    
    protected void func_70227_a(final RayTraceResult result) {
        if (result instanceof EntityRayTraceResult && (((EntityRayTraceResult)result).func_216348_a() instanceof LichBoltEntity || ((EntityRayTraceResult)result).func_216348_a() instanceof LichBombEntity || ((EntityRayTraceResult)result).func_216348_a() instanceof LichEntity)) {
            return;
        }
        this.explode();
    }
    
    public ItemStack func_184543_l() {
        return new ItemStack((IItemProvider)Items.field_151064_bs);
    }
}
