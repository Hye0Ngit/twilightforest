// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.LivingEntity;
import java.util.Iterator;
import java.util.List;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.client.renderer.entity.NagaSegmentRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import twilightforest.entity.TFPartEntity;

public class NagaSegmentEntity extends TFPartEntity<NagaEntity>
{
    private int deathCounter;
    
    public NagaSegmentEntity(final NagaEntity naga) {
        super((Entity)naga);
        this.func_70107_b(naga.func_226277_ct_(), naga.func_226278_cu_(), naga.func_226281_cx_());
    }
    
    protected void func_70088_a() {
        this.field_70138_W = 2.0f;
        this.deactivate();
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public EntityRenderer<?> renderer(final EntityRendererManager manager) {
        return new NagaSegmentRenderer<Object>(manager);
    }
    
    public boolean func_70097_a(final DamageSource src, final float damage) {
        return !this.func_82150_aj() && ((NagaEntity)this.getParent()).func_70097_a(src, damage * 2.0f / 3.0f);
    }
    
    public boolean func_70028_i(final Entity entityIn) {
        return entityIn == this || entityIn == this.getParent();
    }
    
    protected void func_70037_a(final CompoundNBT compound) {
    }
    
    protected void func_213281_b(final CompoundNBT compound) {
    }
    
    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        ++this.field_70173_aa;
        if (!this.func_82150_aj()) {
            this.collideWithOthers();
        }
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter <= 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                    final BasicParticleType explosionType = this.field_70146_Z.nextBoolean() ? ParticleTypes.field_197626_s : ParticleTypes.field_197627_t;
                    this.field_70170_p.func_195594_a((IParticleData)explosionType, this.func_226277_ct_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextFloat() * this.func_213302_cg(), this.func_226281_cx_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), d, d2, d3);
                }
                this.deactivate();
            }
        }
    }
    
    private void collideWithOthers() {
        final List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.func_174813_aQ().func_72314_b(0.2, 0.0, 0.2));
        for (final Entity entity : list) {
            if (entity.func_70104_M()) {
                this.collideWithEntity(entity);
            }
        }
    }
    
    private void collideWithEntity(final Entity entity) {
        entity.func_70108_f((Entity)this);
        if (entity instanceof LivingEntity && !(entity instanceof NagaEntity)) {
            int attackStrength = 2;
            if (entity instanceof AnimalEntity) {
                attackStrength *= 3;
            }
            entity.func_70097_a(DamageSource.func_76358_a((LivingEntity)this.getParent()), (float)attackStrength);
        }
    }
    
    public void deactivate() {
        this.setSize(EntitySize.func_220314_b(0.0f, 0.0f));
        this.func_82142_c(true);
    }
    
    public void activate() {
        this.setSize(EntitySize.func_220314_b(1.8f, 1.8f));
        this.func_82142_c(false);
    }
    
    public void func_70101_b(final float yaw, final float pitch) {
        super.func_70101_b(yaw, pitch);
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
    }
    
    public void selfDestruct() {
        this.deathCounter = 10;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
}
