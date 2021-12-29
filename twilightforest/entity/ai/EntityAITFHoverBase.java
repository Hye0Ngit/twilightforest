// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;

public abstract class EntityAITFHoverBase<T extends EntityLiving> extends EntityAIBase
{
    protected final T attacker;
    protected final float hoverHeight;
    protected final float hoverRadius;
    protected double hoverPosX;
    protected double hoverPosY;
    protected double hoverPosZ;
    
    protected EntityAITFHoverBase(final T snowQueen, final float hoverHeight, final float hoverRadius) {
        this.attacker = snowQueen;
        this.hoverHeight = hoverHeight;
        this.hoverRadius = hoverRadius;
    }
    
    public void func_75249_e() {
        final EntityLivingBase target = this.attacker.func_70638_az();
        if (target != null) {
            this.makeNewHoverSpot(target);
        }
    }
    
    protected void makeNewHoverSpot(final EntityLivingBase target) {
        double hx = 0.0;
        double hy = 0.0;
        double hz = 0.0;
        boolean found = false;
        for (int i = 0; i < 100; ++i) {
            hx = target.field_70165_t + (this.attacker.func_70681_au().nextFloat() - this.attacker.func_70681_au().nextFloat()) * this.hoverRadius;
            hy = target.field_70163_u + this.hoverHeight;
            hz = target.field_70161_v + (this.attacker.func_70681_au().nextFloat() - this.attacker.func_70681_au().nextFloat()) * this.hoverRadius;
            if (!this.isPositionOccupied(hx, hy, hz) && this.canEntitySee((Entity)this.attacker, hx, hy, hz) && this.canEntitySee((Entity)target, hx, hy, hz)) {
                found = true;
                break;
            }
        }
        if (!found) {
            TwilightForestMod.LOGGER.debug("Found no spots, giving up");
        }
        this.hoverPosX = hx;
        this.hoverPosY = hy;
        this.hoverPosZ = hz;
    }
    
    protected boolean isPositionOccupied(final double hx, final double hy, final double hz) {
        final float radius = this.attacker.field_70130_N / 2.0f;
        final AxisAlignedBB aabb = new AxisAlignedBB(hx - radius, hy, hz - radius, hx + radius, hy + this.attacker.field_70131_O, hz + radius);
        return !this.attacker.field_70170_p.func_72917_a(aabb, (Entity)this.attacker) || !this.attacker.field_70170_p.func_184144_a((Entity)this.attacker, aabb).isEmpty();
    }
    
    protected boolean canEntitySee(final Entity entity, final double dx, final double dy, final double dz) {
        return entity.field_70170_p.func_72933_a(new Vec3d(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v), new Vec3d(dx, dy, dz)) == null;
    }
}
