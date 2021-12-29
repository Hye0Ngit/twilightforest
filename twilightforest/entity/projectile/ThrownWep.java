// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.Entity;
import twilightforest.util.TFDamageSources;
import twilightforest.item.TFItems;
import twilightforest.entity.boss.KnightPhantom;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.syncher.EntityDataAccessor;

public class ThrownWep extends TFThrowable
{
    private static final EntityDataAccessor<ItemStack> DATA_ITEMSTACK;
    private static final EntityDataAccessor<Float> DATA_VELOCITY;
    private float projectileDamage;
    
    public ThrownWep(final EntityType<? extends ThrownWep> type, final Level world, final LivingEntity thrower) {
        super(type, world, thrower);
        this.projectileDamage = 6.0f;
    }
    
    public ThrownWep(final EntityType<? extends ThrownWep> type, final Level world) {
        super(type, world);
        this.projectileDamage = 6.0f;
    }
    
    public ThrownWep setDamage(final float damage) {
        this.projectileDamage = damage;
        return this;
    }
    
    @Override
    protected void m_8097_() {
        this.f_19804_.m_135372_((EntityDataAccessor)ThrownWep.DATA_ITEMSTACK, (Object)ItemStack.f_41583_);
        this.f_19804_.m_135372_((EntityDataAccessor)ThrownWep.DATA_VELOCITY, (Object)0.001f);
    }
    
    public ThrownWep setItem(final ItemStack stack) {
        this.f_19804_.m_135381_((EntityDataAccessor)ThrownWep.DATA_ITEMSTACK, (Object)stack);
        return this;
    }
    
    public ItemStack getItem() {
        return (ItemStack)this.f_19804_.m_135370_((EntityDataAccessor)ThrownWep.DATA_ITEMSTACK);
    }
    
    public ThrownWep setVelocity(final float velocity) {
        this.f_19804_.m_135381_((EntityDataAccessor)ThrownWep.DATA_VELOCITY, (Object)velocity);
        return this;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7822_(final byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123755_, this.m_20185_(), this.m_20186_(), this.m_20189_(), 0.0, 0.0, 0.0);
            }
        }
        else {
            super.m_7822_(id);
        }
    }
    
    protected void m_6532_(final HitResult result) {
        if (result instanceof final EntityHitResult entityHitResult) {
            if (entityHitResult.m_82443_() instanceof KnightPhantom || entityHitResult.m_82443_() == this.m_37282_()) {
                return;
            }
            if (!this.f_19853_.f_46443_) {
                if (((EntityHitResult)result).m_82443_() != null) {
                    ((EntityHitResult)result).m_82443_().m_6469_((this.getItem().m_41720_() == TFItems.KNIGHTMETAL_PICKAXE.get()) ? TFDamageSources.THROWN_PICKAXE : TFDamageSources.THROWN_AXE, this.projectileDamage);
                }
                this.f_19853_.m_7605_((Entity)this, (byte)3);
                this.m_146870_();
            }
        }
    }
    
    public boolean m_6087_() {
        return true;
    }
    
    public float m_6143_() {
        return 1.0f;
    }
    
    protected float m_7139_() {
        return (float)this.f_19804_.m_135370_((EntityDataAccessor)ThrownWep.DATA_VELOCITY);
    }
    
    static {
        DATA_ITEMSTACK = SynchedEntityData.m_135353_((Class)ThrownWep.class, EntityDataSerializers.f_135033_);
        DATA_VELOCITY = SynchedEntityData.m_135353_((Class)ThrownWep.class, EntityDataSerializers.f_135029_);
    }
}
