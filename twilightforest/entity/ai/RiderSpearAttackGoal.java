// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.EntityPredicates;
import twilightforest.entity.UpperGoblinKnightEntity;
import java.util.EnumSet;
import twilightforest.entity.LowerGoblinKnightEntity;
import net.minecraft.entity.ai.goal.Goal;

public class RiderSpearAttackGoal extends Goal
{
    private LowerGoblinKnightEntity entity;
    
    public RiderSpearAttackGoal(final LowerGoblinKnightEntity lowerKnight) {
        this.entity = lowerKnight;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean func_75250_a() {
        if (!this.entity.func_184188_bt().isEmpty() && this.entity.func_184188_bt().get(0) instanceof UpperGoblinKnightEntity && EntityPredicates.field_233583_f_.test(this.entity.func_70638_az())) {
            final int timer = this.entity.func_184188_bt().get(0).heavySpearTimer;
            return timer > 0 && timer < 60;
        }
        return false;
    }
}
