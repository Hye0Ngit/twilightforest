// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import twilightforest.entity.TFPartEntity;

public abstract class HydraPartEntity extends TFPartEntity<HydraEntity>
{
    final float maxHealth = 1000.0f;
    float health;
    private EntitySize cacheSize;
    
    public HydraPartEntity(final HydraEntity hydra) {
        super((Entity)hydra);
        this.health = 1000.0f;
    }
    
    protected void func_70088_a() {
        this.func_230279_az_();
    }
    
    public boolean canEntityBeSeen(final Entity entityIn) {
        final Vector3d vector3d = new Vector3d(this.func_226277_ct_(), this.func_226280_cw_(), this.func_226281_cx_());
        final Vector3d vector3d2 = new Vector3d(entityIn.func_226277_ct_(), entityIn.func_226280_cw_(), entityIn.func_226281_cx_());
        return this.field_70170_p.func_217299_a(new RayTraceContext(vector3d, vector3d2, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, (Entity)this)).func_216346_c() == RayTraceResult.Type.MISS;
    }
    
    public HydraPartEntity(final HydraEntity parent, final float width, final float height) {
        this(parent);
        this.setSize(EntitySize.func_220314_b(width, height));
        this.func_213323_x_();
    }
    
    @Override
    protected void setSize(final EntitySize size) {
        super.setSize(size);
        this.cacheSize = size;
    }
    
    @Override
    public void func_70071_h_() {
        this.func_70066_B();
        super.func_70071_h_();
        if (this.hurtTime > 0) {
            --this.hurtTime;
        }
        if (this.health <= 0.0f) {
            ++this.deathTime;
        }
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        return this.getParent() != null && ((HydraEntity)this.getParent()).attackEntityFromPart(this, source, amount);
    }
    
    protected void func_70037_a(final CompoundNBT compound) {
    }
    
    protected void func_213281_b(final CompoundNBT compound) {
    }
    
    public boolean func_70028_i(final Entity entity) {
        return this == entity || this.getParent() == entity;
    }
    
    protected void func_70101_b(final float yaw, final float pitch) {
        this.field_70177_z = yaw % 360.0f;
        this.field_70125_A = pitch % 360.0f;
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    public void activate() {
        this.field_213325_aI = this.cacheSize;
        this.func_213323_x_();
    }
    
    public void deactivate() {
        this.field_213325_aI = EntitySize.func_220314_b(0.0f, 0.0f);
        this.func_213323_x_();
    }
}
