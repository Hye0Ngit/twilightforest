// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.LivingEntity;
import java.util.Iterator;
import java.util.List;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.TFPart;

public class NagaSegment extends TFPart<Naga>
{
    public static final ResourceLocation RENDERER;
    private int deathCounter;
    
    public NagaSegment(final Naga naga) {
        super((Entity)naga);
        this.m_6034_(naga.m_20185_(), naga.m_20186_(), naga.m_20189_());
    }
    
    protected void m_8097_() {
        this.f_19793_ = 2.0f;
        this.deactivate();
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public ResourceLocation renderer() {
        return NagaSegment.RENDERER;
    }
    
    public boolean m_6469_(final DamageSource src, final float damage) {
        return !this.m_20145_() && ((Naga)this.getParent()).m_6469_(src, damage * 2.0f / 3.0f);
    }
    
    public boolean m_7306_(final Entity entityIn) {
        return entityIn == this || entityIn == this.getParent();
    }
    
    protected void m_7378_(final CompoundTag compound) {
    }
    
    protected void m_7380_(final CompoundTag compound) {
    }
    
    @Override
    public void m_8119_() {
        super.m_8119_();
        ++this.f_19797_;
        if (!this.m_20145_()) {
            this.collideWithOthers();
        }
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter <= 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.f_19796_.nextGaussian() * 0.02;
                    final double d2 = this.f_19796_.nextGaussian() * 0.02;
                    final double d3 = this.f_19796_.nextGaussian() * 0.02;
                    final SimpleParticleType explosionType = this.f_19796_.nextBoolean() ? ParticleTypes.f_123812_ : ParticleTypes.f_123813_;
                    this.f_19853_.m_7106_((ParticleOptions)explosionType, this.m_20185_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), this.m_20186_() + this.f_19796_.nextFloat() * this.m_20206_(), this.m_20189_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), d, d2, d3);
                }
                this.deactivate();
            }
        }
    }
    
    private void collideWithOthers() {
        final List<Entity> list = this.f_19853_.m_45933_((Entity)this, this.m_142469_().m_82377_(0.2, 0.0, 0.2));
        for (final Entity entity : list) {
            if (entity.m_6094_()) {
                this.collideWithEntity(entity);
            }
        }
    }
    
    private void collideWithEntity(final Entity entity) {
        entity.m_7334_((Entity)this);
        if (entity instanceof LivingEntity && !(entity instanceof Naga)) {
            int attackStrength = 2;
            if (entity instanceof Animal) {
                attackStrength *= 3;
            }
            entity.m_6469_(DamageSource.m_19370_((LivingEntity)this.getParent()), (float)attackStrength);
        }
    }
    
    public void deactivate() {
        this.setSize(EntityDimensions.m_20395_(0.0f, 0.0f));
        this.m_6842_(true);
    }
    
    public void activate() {
        this.setSize(EntityDimensions.m_20395_(1.8f, 1.8f));
        this.m_6842_(false);
    }
    
    public void m_19915_(final float yaw, final float pitch) {
        super.m_19915_(yaw, pitch);
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
    }
    
    public void selfDestruct() {
        this.deathCounter = 10;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    static {
        RENDERER = TwilightForestMod.prefix("naga_segment");
    }
}
