// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.IRendersAsItem;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class SlimeProjectileEntity extends TFThrowableEntity implements IRendersAsItem
{
    public SlimeProjectileEntity(final EntityType<? extends SlimeProjectileEntity> type, final World world) {
        super(type, world);
    }
    
    public SlimeProjectileEntity(final EntityType<? extends SlimeProjectileEntity> type, final World world, final LivingEntity thrower) {
        super(type, world, thrower);
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
            final double dx = this.func_226277_ct_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.func_226278_cu_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.func_226281_cx_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197592_C, dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        super.func_70097_a(source, amount);
        this.die();
        return true;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197592_C, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.field_70146_Z.nextGaussian() * 0.05, this.field_70146_Z.nextDouble() * 0.2, this.field_70146_Z.nextGaussian() * 0.05);
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70227_a(final RayTraceResult result) {
        if (result instanceof EntityRayTraceResult) {
            final Entity target = ((EntityRayTraceResult)result).func_216348_a();
            if (!this.field_70170_p.field_72995_K && target instanceof LivingEntity) {
                target.func_70097_a(DamageSource.func_76356_a((Entity)this, this.func_234616_v_()), 4.0f);
                if (target instanceof PlayerEntity) {
                    for (final ItemStack stack : target.func_184193_aE()) {
                        stack.func_222118_a(this.field_70146_Z.nextInt(1), (LivingEntity)target, user -> user.func_213361_c(stack.getEquipmentSlot()));
                    }
                }
            }
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
    
    public ItemStack func_184543_l() {
        return new ItemStack((IItemProvider)Items.field_151123_aH);
    }
}
