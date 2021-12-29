// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import java.util.EnumSet;
import twilightforest.entity.boss.KnightPhantomEntity;
import net.minecraft.entity.ai.goal.Goal;

public class PhantomAttackStartGoal extends Goal
{
    private final KnightPhantomEntity boss;
    
    public PhantomAttackStartGoal(final KnightPhantomEntity entity) {
        this.boss = entity;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.LOOK));
    }
    
    public boolean func_75250_a() {
        return this.boss.func_70638_az() != null && this.boss.getCurrentFormation() == KnightPhantomEntity.Formation.ATTACK_PLAYER_START;
    }
    
    public void func_75246_d() {
        final LivingEntity target = this.boss.func_70638_az();
        if (target != null) {
            final BlockPos targetPos = new BlockPos(target.field_70142_S, target.field_70137_T, target.field_70136_U);
            if (this.boss.func_213389_a(targetPos)) {
                this.boss.setChargePos(targetPos);
            }
            else {
                this.boss.setChargePos(this.boss.func_213384_dI());
            }
        }
    }
}
