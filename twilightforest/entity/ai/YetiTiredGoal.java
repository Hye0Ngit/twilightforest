// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.TFSounds;
import java.util.EnumSet;
import twilightforest.entity.boss.AlphaYeti;
import net.minecraft.world.entity.ai.goal.Goal;

public class YetiTiredGoal extends Goal
{
    private AlphaYeti yeti;
    private int tiredDuration;
    private int tiredTimer;
    
    public YetiTiredGoal(final AlphaYeti entityTFYetiAlpha, final int i) {
        this.yeti = entityTFYetiAlpha;
        this.tiredDuration = i;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
    }
    
    public boolean m_8036_() {
        return this.yeti.isTired();
    }
    
    public boolean m_8045_() {
        return this.tiredTimer < this.tiredDuration;
    }
    
    public boolean m_6767_() {
        return false;
    }
    
    public void m_8056_() {
        this.tiredTimer = 0;
    }
    
    public void m_8041_() {
        this.tiredTimer = 0;
        this.yeti.setTired(false);
    }
    
    public void m_8037_() {
        if (++this.tiredTimer % 10 == 0) {
            this.yeti.m_5496_(TFSounds.ALPHAYETI_PANT, 4.0f, 0.5f + this.yeti.m_21187_().nextFloat() * 0.5f);
        }
    }
}
