// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ThrowableEntity;

public abstract class TFThrowableEntity extends ThrowableEntity implements ITFProjectile
{
    public TFThrowableEntity(final EntityType<? extends TFThrowableEntity> type, final World worldIn) {
        super((EntityType)type, worldIn);
    }
    
    public TFThrowableEntity(final EntityType<? extends TFThrowableEntity> type, final World worldIn, final double x, final double y, final double z) {
        super((EntityType)type, x, y, z, worldIn);
    }
    
    public TFThrowableEntity(final EntityType<? extends TFThrowableEntity> type, final World worldIn, final LivingEntity throwerIn) {
        super((EntityType)type, throwerIn, worldIn);
    }
    
    protected void func_70088_a() {
    }
    
    public IPacket<?> func_213297_N() {
        return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
