// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityMoveHelper;

public class NoClipMoveHelper extends EntityMoveHelper
{
    private final EntityLiving parentEntity;
    private int courseChangeCooldown;
    
    public NoClipMoveHelper(final EntityLiving entity) {
        super(entity);
        this.parentEntity = entity;
    }
    
    public void func_75641_c() {
        if (this.field_188491_h == EntityMoveHelper.Action.MOVE_TO) {
            final double d0 = this.field_75646_b - this.parentEntity.field_70165_t;
            final double d2 = this.field_75647_c - this.parentEntity.field_70163_u;
            final double d3 = this.field_75644_d - this.parentEntity.field_70161_v;
            double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            if (this.courseChangeCooldown-- <= 0) {
                this.courseChangeCooldown += this.parentEntity.func_70681_au().nextInt(5) + 2;
                d4 = MathHelper.func_76133_a(d4);
                final EntityLiving parentEntity = this.parentEntity;
                parentEntity.field_70159_w += d0 / d4 * 0.1 * this.field_75645_e;
                final EntityLiving parentEntity2 = this.parentEntity;
                parentEntity2.field_70181_x += d2 / d4 * 0.1 * this.field_75645_e;
                final EntityLiving parentEntity3 = this.parentEntity;
                parentEntity3.field_70179_y += d3 / d4 * 0.1 * this.field_75645_e;
            }
        }
    }
}
