// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.controller.MovementController;

public class NoClipMoveHelper extends MovementController
{
    private final LivingEntity parentEntity;
    private int courseChangeCooldown;
    
    public NoClipMoveHelper(final MobEntity entity) {
        super(entity);
        this.parentEntity = (LivingEntity)entity;
    }
    
    public void func_75641_c() {
        if (this.field_188491_h == MovementController.Action.MOVE_TO) {
            final double dx = this.func_179917_d() - this.parentEntity.func_226277_ct_();
            final double dy = this.func_179919_e() - this.parentEntity.func_226278_cu_();
            final double dz = this.func_179918_f() - this.parentEntity.func_226281_cx_();
            double dist = dx * dx + dy * dy + dz * dz;
            if (this.courseChangeCooldown-- <= 0) {
                this.courseChangeCooldown += this.parentEntity.func_70681_au().nextInt(5) + 2;
                dist = MathHelper.func_76133_a(dist);
                this.parentEntity.func_213317_d(this.parentEntity.func_213322_ci().func_72441_c(dx / dist * 0.1 * this.field_75645_e, dy / dist * 0.1 * this.field_75645_e, dz / dist * 0.1 * this.field_75645_e));
            }
        }
    }
}
