// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.EntityPredicates;
import java.util.EnumSet;
import twilightforest.entity.UpperGoblinKnightEntity;
import net.minecraft.entity.ai.goal.Goal;

public class HeavySpearAttackGoal extends Goal
{
    private UpperGoblinKnightEntity entity;
    
    public HeavySpearAttackGoal(final UpperGoblinKnightEntity upperKnight) {
        this.entity = upperKnight;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public void func_75246_d() {
        if (this.entity.heavySpearTimer == 25) {
            this.entity.landHeavySpearAttack();
        }
    }
    
    public boolean func_75250_a() {
        return this.entity.heavySpearTimer > 0 && this.entity.heavySpearTimer < 60 && EntityPredicates.field_233583_f_.test(this.entity.func_70638_az());
    }
}
