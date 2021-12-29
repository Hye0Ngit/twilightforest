// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.entity.Entity;
import twilightforest.util.TFDamageSources;
import twilightforest.item.TFItems;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import twilightforest.entity.projectile.TFThrowableEntity;

public class ThrownWepEntity extends TFThrowableEntity
{
    private static final DataParameter<ItemStack> DATA_ITEMSTACK;
    private static final DataParameter<Float> DATA_VELOCITY;
    private float projectileDamage;
    
    public ThrownWepEntity(final EntityType<? extends ThrownWepEntity> type, final World world, final LivingEntity thrower) {
        super(type, world, thrower);
        this.projectileDamage = 6.0f;
    }
    
    public ThrownWepEntity(final EntityType<? extends ThrownWepEntity> type, final World world) {
        super(type, world);
        this.projectileDamage = 6.0f;
    }
    
    public ThrownWepEntity setDamage(final float damage) {
        this.projectileDamage = damage;
        return this;
    }
    
    @Override
    protected void func_70088_a() {
        this.field_70180_af.func_187214_a((DataParameter)ThrownWepEntity.DATA_ITEMSTACK, (Object)ItemStack.field_190927_a);
        this.field_70180_af.func_187214_a((DataParameter)ThrownWepEntity.DATA_VELOCITY, (Object)0.001f);
    }
    
    public ThrownWepEntity setItem(final ItemStack stack) {
        this.field_70180_af.func_187227_b((DataParameter)ThrownWepEntity.DATA_ITEMSTACK, (Object)stack);
        return this;
    }
    
    public ItemStack getItem() {
        return (ItemStack)this.field_70180_af.func_187225_a((DataParameter)ThrownWepEntity.DATA_ITEMSTACK);
    }
    
    public ThrownWepEntity setVelocity(final float velocity) {
        this.field_70180_af.func_187227_b((DataParameter)ThrownWepEntity.DATA_VELOCITY, (Object)velocity);
        return this;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197594_E, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 0.0, 0.0, 0.0);
            }
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    protected void func_70227_a(final RayTraceResult result) {
        if (result instanceof EntityRayTraceResult) {
            if (((EntityRayTraceResult)result).func_216348_a() instanceof KnightPhantomEntity || ((EntityRayTraceResult)result).func_216348_a() == this.func_234616_v_()) {
                return;
            }
            if (!this.field_70170_p.field_72995_K) {
                if (((EntityRayTraceResult)result).func_216348_a() != null) {
                    ((EntityRayTraceResult)result).func_216348_a().func_70097_a((this.getItem().func_77973_b() == TFItems.knightmetal_pickaxe.get()) ? TFDamageSources.THROWN_PICKAXE : TFDamageSources.THROWN_AXE, this.projectileDamage);
                }
                this.field_70170_p.func_72960_a((Entity)this, (byte)3);
                this.func_70106_y();
            }
        }
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public float func_70111_Y() {
        return 1.0f;
    }
    
    protected float func_70185_h() {
        return (float)this.field_70180_af.func_187225_a((DataParameter)ThrownWepEntity.DATA_VELOCITY);
    }
    
    static {
        DATA_ITEMSTACK = EntityDataManager.func_187226_a((Class)ThrownWepEntity.class, DataSerializers.field_187196_f);
        DATA_VELOCITY = EntityDataManager.func_187226_a((Class)ThrownWepEntity.class, DataSerializers.field_187193_c);
    }
}
