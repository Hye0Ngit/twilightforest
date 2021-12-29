// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;

public abstract class HoverBaseGoal<T extends MobEntity> extends Goal
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
    
    public void func_75249_e() {
        final LivingEntity target = this.attacker.func_70638_az();
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
            hx = target.func_226277_ct_() + (this.attacker.func_70681_au().nextFloat() - this.attacker.func_70681_au().nextFloat()) * this.hoverRadius;
            hy = target.func_226278_cu_() + this.hoverHeight;
            hz = target.func_226281_cx_() + (this.attacker.func_70681_au().nextFloat() - this.attacker.func_70681_au().nextFloat()) * this.hoverRadius;
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
        final float radius = this.attacker.func_213311_cf() / 2.0f;
        final AxisAlignedBB aabb = new AxisAlignedBB(hx - radius, hy, hz - radius, hx + radius, hy + this.attacker.func_213302_cg(), hz + radius);
        return !this.attacker.field_70170_p.func_195585_a((Entity)this.attacker, VoxelShapes.func_197881_a(aabb)) || !this.attacker.field_70170_p.func_226665_a__((Entity)this.attacker, aabb);
    }
    
    protected boolean canEntitySee(final Entity entity, final double dx, final double dy, final double dz) {
        return entity.field_70170_p.func_217299_a(new RayTraceContext(new Vector3d(entity.func_226277_ct_(), entity.func_226278_cu_() + entity.func_70047_e(), entity.func_226281_cx_()), new Vector3d(dx, dy, dz), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, entity)) == null;
    }
}
