// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

public abstract class TFThrowable extends ThrowableProjectile implements ITFProjectile
{
    public TFThrowable(final EntityType<? extends TFThrowable> type, final Level worldIn) {
        super((EntityType)type, worldIn);
    }
    
    public TFThrowable(final EntityType<? extends TFThrowable> type, final Level worldIn, final double x, final double y, final double z) {
        super((EntityType)type, x, y, z, worldIn);
    }
    
    public TFThrowable(final EntityType<? extends TFThrowable> type, final Level worldIn, final LivingEntity throwerIn) {
        super((EntityType)type, throwerIn, worldIn);
    }
    
    protected void m_8097_() {
    }
    
    public Packet<?> m_5654_() {
        return (Packet<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
