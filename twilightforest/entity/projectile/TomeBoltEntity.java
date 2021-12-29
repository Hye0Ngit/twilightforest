// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.Entity;
import twilightforest.util.TFDamageSources;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.IRendersAsItem;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class TomeBoltEntity extends TFThrowableEntity implements IRendersAsItem
{
    public TomeBoltEntity(final EntityType<? extends TomeBoltEntity> type, final World world, final LivingEntity thrower) {
        super(type, world, thrower);
    }
    
    public TomeBoltEntity(final EntityType<? extends TomeBoltEntity> type, final World world) {
        super(type, world);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.makeTrail();
    }
    
    protected float func_70185_h() {
        return 0.003f;
    }
    
    private void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.func_226277_ct_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dy = this.func_226278_cu_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            final double dz = this.func_226281_cx_() + 0.5 * (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble());
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197614_g, dx, dy, dz, 0.0, 0.0, 0.0);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            final IParticleData particle = (IParticleData)new ItemParticleData(ParticleTypes.field_197591_B, new ItemStack((IItemProvider)Items.field_151121_aF));
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
            if (result instanceof EntityRayTraceResult) {
                final EntityRayTraceResult entityRay = (EntityRayTraceResult)result;
                if (entityRay.func_216348_a() instanceof LivingEntity && entityRay.func_216348_a().func_70097_a(TFDamageSources.LOST_WORDS((Entity)this, (LivingEntity)this.func_234616_v_()), 3.0f)) {
                    final int duration = (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) ? 2 : ((this.field_70170_p.func_175659_aa() == Difficulty.NORMAL) ? 6 : 8);
                    ((LivingEntity)entityRay.func_216348_a()).func_195064_c(new EffectInstance(Effects.field_76421_d, duration * 20, 1));
                }
            }
            this.field_70170_p.func_72960_a((Entity)this, (byte)3);
            this.func_70106_y();
        }
    }
    
    public ItemStack func_184543_l() {
        return new ItemStack((IItemProvider)Items.field_151121_aF);
    }
}
