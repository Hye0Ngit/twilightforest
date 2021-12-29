// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import java.util.function.Predicate;
import net.minecraft.world.entity.EntitySelector;
import twilightforest.entity.monster.UpperGoblinKnight;
import java.util.EnumSet;
import twilightforest.entity.monster.LowerGoblinKnight;
import net.minecraft.world.entity.ai.goal.Goal;

public class RiderSpearAttackGoal extends Goal
{
    private final LowerGoblinKnight entity;
    
    public RiderSpearAttackGoal(final LowerGoblinKnight lowerKnight) {
        this.entity = lowerKnight;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        if (!this.entity.m_20197_().isEmpty() && this.entity.m_20197_().get(0) instanceof UpperGoblinKnight && this.entity.m_5448_() != null && EntitySelector.f_20406_.and(EntitySelector.f_20403_).test(this.entity.m_5448_())) {
            final int timer = this.entity.m_20197_().get(0).heavySpearTimer;
            return timer > 0 && timer < 60;
        }
        return false;
    }
}
