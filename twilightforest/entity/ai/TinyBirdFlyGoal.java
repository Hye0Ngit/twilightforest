// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.EnumSet;
import twilightforest.entity.passive.TinyBird;
import net.minecraft.world.entity.ai.goal.Goal;

public class TinyBirdFlyGoal extends Goal
{
    private TinyBird entity;
    
    public TinyBirdFlyGoal(final TinyBird bird) {
        this.entity = bird;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
    }
    
    public boolean m_8036_() {
        return !this.entity.isBirdLanded();
    }
}
