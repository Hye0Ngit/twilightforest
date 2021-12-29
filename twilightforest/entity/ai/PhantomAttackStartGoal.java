// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;
import java.util.EnumSet;
import twilightforest.entity.boss.KnightPhantom;
import net.minecraft.world.entity.ai.goal.Goal;

public class PhantomAttackStartGoal extends Goal
{
    private final KnightPhantom boss;
    
    public PhantomAttackStartGoal(final KnightPhantom entity) {
        this.boss = entity;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        return this.boss.m_5448_() != null && this.boss.getCurrentFormation() == KnightPhantom.Formation.ATTACK_PLAYER_START;
    }
    
    public void m_8037_() {
        final LivingEntity target = this.boss.m_5448_();
        if (target != null) {
            final BlockPos targetPos = new BlockPos(target.f_19790_, target.f_19791_, target.f_19792_);
            if (this.boss.m_21444_(targetPos)) {
                this.boss.setChargePos(targetPos);
            }
            else {
                this.boss.setChargePos(this.boss.m_21534_());
            }
        }
    }
}
