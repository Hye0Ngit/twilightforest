// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityThrowable;

public abstract class EntityTFThrowable extends EntityThrowable implements ITFProjectile
{
    public EntityTFThrowable(final World worldIn) {
        super(worldIn);
    }
    
    public EntityTFThrowable(final World worldIn, final double x, final double y, final double z) {
        super(worldIn, x, y, z);
    }
    
    public EntityTFThrowable(final World worldIn, final EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }
    
    public void setThrower(final Entity entity) {
        if (entity instanceof EntityLivingBase) {
            this.field_70192_c = (EntityLivingBase)entity;
        }
    }
}
