// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;

public class NoClipMoveHelper extends MoveControl
{
    private final LivingEntity parentEntity;
    private int courseChangeCooldown;
    
    public NoClipMoveHelper(final Mob entity) {
        super(entity);
        this.parentEntity = (LivingEntity)entity;
    }
    
    public void m_8126_() {
        if (this.f_24981_ == MoveControl.Operation.MOVE_TO) {
            final double dx = this.m_25000_() - this.parentEntity.m_20185_();
            final double dy = this.m_25001_() - this.parentEntity.m_20186_();
            final double dz = this.m_25002_() - this.parentEntity.m_20189_();
            double dist = dx * dx + dy * dy + dz * dz;
            if (this.courseChangeCooldown-- <= 0) {
                this.courseChangeCooldown += this.parentEntity.m_21187_().nextInt(5) + 2;
                dist = Mth.m_14116_((float)dist);
                this.parentEntity.m_20256_(this.parentEntity.m_20184_().m_82520_(dx / dist * 0.1 * this.f_24978_, dy / dist * 0.1 * this.f_24978_, dz / dist * 0.1 * this.f_24978_));
            }
        }
    }
}
