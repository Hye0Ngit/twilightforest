// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import java.util.function.Predicate;
import net.minecraft.world.entity.EntitySelector;
import java.util.EnumSet;
import twilightforest.entity.monster.UpperGoblinKnight;
import net.minecraft.world.entity.ai.goal.Goal;

public class HeavySpearAttackGoal extends Goal
{
    private final UpperGoblinKnight entity;
    
    public HeavySpearAttackGoal(final UpperGoblinKnight upperKnight) {
        this.entity = upperKnight;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public void m_8037_() {
        if (this.entity.heavySpearTimer == 25) {
            this.entity.landHeavySpearAttack();
        }
    }
    
    public boolean m_8036_() {
        return this.entity.heavySpearTimer > 0 && this.entity.heavySpearTimer < 60 && this.entity.m_5448_() != null && EntitySelector.f_20406_.and(EntitySelector.f_20403_).test(this.entity.m_5448_());
    }
}
