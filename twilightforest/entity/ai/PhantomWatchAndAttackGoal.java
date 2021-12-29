// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraft.item.ShieldItem;
import net.minecraft.entity.Entity;
import twilightforest.entity.boss.KnightPhantomEntity;
import net.minecraft.entity.ai.goal.Goal;

public class PhantomWatchAndAttackGoal extends Goal
{
    private final KnightPhantomEntity boss;
    private int attackTime;
    private int guardCoolDownTime;
    private boolean isGuard;
    
    public PhantomWatchAndAttackGoal(final KnightPhantomEntity entity) {
        this.boss = entity;
    }
    
    public boolean func_75250_a() {
        return this.boss.func_70638_az() != null;
    }
    
    public void func_75246_d() {
        final LivingEntity target = this.boss.func_70638_az();
        if (target != null) {
            this.boss.func_70625_a((Entity)target, 10.0f, 500.0f);
            if (target.func_70089_S()) {
                final float f1 = target.func_70032_d((Entity)this.boss);
                if (this.boss.func_70635_at().func_75522_a((Entity)target) && this.attackTime-- <= 0 && f1 < 2.0f && target.func_174813_aQ().field_72337_e > this.boss.func_174813_aQ().field_72338_b && this.boss.func_70638_az().func_174813_aQ().field_72338_b < this.boss.func_174813_aQ().field_72337_e) {
                    this.attackTime = 20;
                    this.boss.func_70652_k((Entity)target);
                }
                if (this.boss.func_184592_cb().func_77973_b() instanceof ShieldItem && this.boss.getCurrentFormation() != KnightPhantomEntity.Formation.ATTACK_PLAYER_ATTACK && this.isGuard) {
                    this.boss.func_184598_c(Hand.OFF_HAND);
                }
                else {
                    this.boss.func_184602_cy();
                }
                if (this.isGuard) {
                    if (this.guardCoolDownTime <= 180) {
                        ++this.guardCoolDownTime;
                    }
                    else {
                        this.isGuard = false;
                    }
                }
                else if (this.guardCoolDownTime > 0) {
                    --this.guardCoolDownTime;
                }
                else {
                    this.isGuard = true;
                }
            }
        }
    }
}
