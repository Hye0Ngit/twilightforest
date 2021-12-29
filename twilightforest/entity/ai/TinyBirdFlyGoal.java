// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.EnumSet;
import twilightforest.entity.passive.TinyBirdEntity;
import net.minecraft.entity.ai.goal.Goal;

public class TinyBirdFlyGoal extends Goal
{
    private TinyBirdEntity entity;
    
    public TinyBirdFlyGoal(final TinyBirdEntity bird) {
        this.entity = bird;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
    }
    
    public boolean func_75250_a() {
        return !this.entity.isBirdLanded();
    }
}
