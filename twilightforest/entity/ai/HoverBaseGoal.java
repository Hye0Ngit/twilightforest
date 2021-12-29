// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.AABB;
import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;

public abstract class HoverBaseGoal<T extends Mob> extends Goal
{
    protected final T attacker;
    protected final float hoverHeight;
    protected final float hoverRadius;
    protected double hoverPosX;
    protected double hoverPosY;
    protected double hoverPosZ;
    
    protected HoverBaseGoal(final T snowQueen, final float hoverHeight, final float hoverRadius) {
        this.attacker = snowQueen;
        this.hoverHeight = hoverHeight;
        this.hoverRadius = hoverRadius;
    }
    
    public void m_8056_() {
        final LivingEntity target = this.attacker.m_5448_();
        if (target != null) {
            this.makeNewHoverSpot(target);
        }
    }
    
    protected void makeNewHoverSpot(final LivingEntity target) {
        double hx = 0.0;
        double hy = 0.0;
        double hz = 0.0;
        boolean found = false;
        for (int i = 0; i < 100; ++i) {
            hx = target.m_20185_() + (this.attacker.m_21187_().nextFloat() - this.attacker.m_21187_().nextFloat()) * this.hoverRadius;
            hy = target.m_20186_() + this.hoverHeight;
            hz = target.m_20189_() + (this.attacker.m_21187_().nextFloat() - this.attacker.m_21187_().nextFloat()) * this.hoverRadius;
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
        final float radius = this.attacker.m_20205_() / 2.0f;
        final AABB aabb = new AABB(hx - radius, hy, hz - radius, hx + radius, hy + this.attacker.m_20206_(), hz + radius);
        return !this.attacker.f_19853_.m_5450_((Entity)this.attacker, Shapes.m_83064_(aabb)) || !this.attacker.f_19853_.m_45756_((Entity)this.attacker, aabb);
    }
    
    protected boolean canEntitySee(final Entity entity, final double dx, final double dy, final double dz) {
        return entity.f_19853_.m_45547_(new ClipContext(new Vec3(entity.m_20185_(), entity.m_20186_() + entity.m_20192_(), entity.m_20189_()), new Vec3(dx, dy, dz), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)) == null;
    }
}
