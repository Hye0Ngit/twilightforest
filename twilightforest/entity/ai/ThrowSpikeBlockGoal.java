// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import java.util.EnumSet;
import twilightforest.entity.SpikeBlock;
import twilightforest.entity.monster.BlockChainGoblin;
import net.minecraft.world.entity.ai.goal.Goal;

public class ThrowSpikeBlockGoal extends Goal
{
    protected BlockChainGoblin attacker;
    protected SpikeBlock spikeBlock;
    
    public ThrowSpikeBlockGoal(final BlockChainGoblin entityTFBlockGoblin, final SpikeBlock entitySpikeBlock) {
        this.attacker = entityTFBlockGoblin;
        this.spikeBlock = entitySpikeBlock;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        final LivingEntity target = this.attacker.m_5448_();
        return target != null && this.attacker.m_20280_((Entity)target) <= 42.0 && this.attacker.m_6084_() && this.attacker.m_142582_((Entity)target) && this.attacker.f_19853_.f_46441_.nextInt(56) == 0;
    }
    
    public boolean m_8045_() {
        return this.attacker.getChainMoveLength() > 0.0f;
    }
    
    public void m_8056_() {
        this.attacker.setThrowing(true);
    }
}
