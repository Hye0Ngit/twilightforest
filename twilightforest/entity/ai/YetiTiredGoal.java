// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.TFSounds;
import java.util.EnumSet;
import twilightforest.entity.boss.AlphaYetiEntity;
import net.minecraft.entity.ai.goal.Goal;

public class YetiTiredGoal extends Goal
{
    private AlphaYetiEntity yeti;
    private int tiredDuration;
    private int tiredTimer;
    
    public YetiTiredGoal(final AlphaYetiEntity entityTFYetiAlpha, final int i) {
        this.yeti = entityTFYetiAlpha;
        this.tiredDuration = i;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
    }
    
    public boolean func_75250_a() {
        return this.yeti.isTired();
    }
    
    public boolean func_75253_b() {
        return this.tiredTimer < this.tiredDuration;
    }
    
    public boolean func_220685_C_() {
        return false;
    }
    
    public void func_75249_e() {
        this.tiredTimer = 0;
    }
    
    public void func_75251_c() {
        this.tiredTimer = 0;
        this.yeti.setTired(false);
    }
    
    public void func_75246_d() {
        if (++this.tiredTimer % 10 == 0) {
            this.yeti.func_184185_a(TFSounds.ALPHAYETI_PANT, 4.0f, 0.5f + this.yeti.func_70681_au().nextFloat() * 0.5f);
        }
    }
}
