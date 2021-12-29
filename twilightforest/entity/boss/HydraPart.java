// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.TFPart;

public abstract class HydraPart extends TFPart<Hydra>
{
    private static final EntityDataAccessor<Boolean> DATA_SIZEACTIVE;
    final float maxHealth = 1000.0f;
    float health;
    private EntityDimensions cacheSize;
    
    public HydraPart(final Hydra hydra) {
        super((Entity)hydra);
        this.health = 1000.0f;
    }
    
    protected void m_8097_() {
        this.m_5825_();
        this.f_19804_.m_135372_((EntityDataAccessor)HydraPart.DATA_SIZEACTIVE, (Object)true);
    }
    
    public void m_7350_(final EntityDataAccessor<?> pKey) {
        super.m_7350_((EntityDataAccessor)pKey);
        if (pKey == HydraPart.DATA_SIZEACTIVE) {
            if (this.f_19804_.m_135370_((EntityDataAccessor)HydraPart.DATA_SIZEACTIVE)) {
                this.activate();
            }
            else {
                this.deactivate();
            }
        }
    }
    
    public boolean canEntityBeSeen(final Entity entityIn) {
        final Vec3 vector3d = new Vec3(this.m_20185_(), this.m_20188_(), this.m_20189_());
        final Vec3 vector3d2 = new Vec3(entityIn.m_20185_(), entityIn.m_20188_(), entityIn.m_20189_());
        return this.f_19853_.m_45547_(new ClipContext(vector3d, vector3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this)).m_6662_() == HitResult.Type.MISS;
    }
    
    public HydraPart(final Hydra parent, final float width, final float height) {
        this(parent);
        this.setSize(EntityDimensions.m_20395_(width, height));
        this.m_6210_();
    }
    
    @Override
    protected void setSize(final EntityDimensions size) {
        super.setSize(size);
        this.cacheSize = size;
    }
    
    @Override
    public void m_8119_() {
        this.m_20095_();
        super.m_8119_();
        if (this.hurtTime > 0) {
            --this.hurtTime;
        }
        if (this.health <= 0.0f) {
            ++this.deathTime;
        }
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        return this.getParent() != null && ((Hydra)this.getParent()).attackEntityFromPart(this, source, amount);
    }
    
    protected void m_7378_(final CompoundTag compound) {
    }
    
    protected void m_7380_(final CompoundTag compound) {
    }
    
    public boolean m_7306_(final Entity entity) {
        return this == entity || this.getParent() == entity;
    }
    
    protected void m_19915_(final float yaw, final float pitch) {
        this.m_146922_(yaw % 360.0f);
        this.m_146926_(pitch % 360.0f);
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    public void activate() {
        this.f_19815_ = this.cacheSize;
        this.f_19804_.m_135381_((EntityDataAccessor)HydraPart.DATA_SIZEACTIVE, (Object)true);
    }
    
    public void deactivate() {
        this.f_19815_ = EntityDimensions.m_20395_(0.0f, 0.0f);
        this.f_19804_.m_135381_((EntityDataAccessor)HydraPart.DATA_SIZEACTIVE, (Object)false);
    }
    
    static {
        DATA_SIZEACTIVE = SynchedEntityData.m_135353_((Class)HydraPart.class, EntityDataSerializers.f_135035_);
    }
}
