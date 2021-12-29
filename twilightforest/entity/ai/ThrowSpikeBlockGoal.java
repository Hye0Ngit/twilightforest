// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import java.util.EnumSet;
import twilightforest.entity.SpikeBlockEntity;
import twilightforest.entity.BlockChainGoblinEntity;
import net.minecraft.entity.ai.goal.Goal;

public class ThrowSpikeBlockGoal extends Goal
{
    protected BlockChainGoblinEntity attacker;
    protected SpikeBlockEntity spikeBlock;
    
    public ThrowSpikeBlockGoal(final BlockChainGoblinEntity entityTFBlockGoblin, final SpikeBlockEntity entitySpikeBlock) {
        this.attacker = entityTFBlockGoblin;
        this.spikeBlock = entitySpikeBlock;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean func_75250_a() {
        final LivingEntity target = this.attacker.func_70638_az();
        return target != null && this.attacker.func_70068_e((Entity)target) <= 42.0 && this.attacker.func_70089_S() && this.attacker.func_70685_l((Entity)target) && this.attacker.field_70170_p.field_73012_v.nextInt(56) == 0;
    }
    
    public boolean func_75253_b() {
        return this.attacker.getChainMoveLength() > 0.0f;
    }
    
    public void func_75249_e() {
        this.attacker.setThrowing(true);
    }
}
