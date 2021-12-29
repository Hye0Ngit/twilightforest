// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.boss.KnightPhantom;
import net.minecraft.world.entity.ai.goal.Goal;

public class PhantomWatchAndAttackGoal extends Goal
{
    private final KnightPhantom boss;
    private int attackTime;
    private int guardCoolDownTime;
    private boolean isGuard;
    
    public PhantomWatchAndAttackGoal(final KnightPhantom entity) {
        this.boss = entity;
    }
    
    public boolean m_8036_() {
        return this.boss.m_5448_() != null;
    }
    
    public void m_8037_() {
        final LivingEntity target = this.boss.m_5448_();
        if (target != null) {
            this.boss.m_21391_((Entity)target, 10.0f, 500.0f);
            if (target.m_6084_()) {
                final float f1 = target.m_20270_((Entity)this.boss);
                if (this.boss.m_21574_().m_148306_((Entity)target) && this.attackTime-- <= 0 && f1 < 2.0f && target.m_142469_().f_82292_ > this.boss.m_142469_().f_82289_ && this.boss.m_5448_().m_142469_().f_82289_ < this.boss.m_142469_().f_82292_) {
                    this.attackTime = 20;
                    this.boss.m_7327_((Entity)target);
                }
                if (this.boss.m_21206_().m_41720_() instanceof ShieldItem && this.boss.getCurrentFormation() != KnightPhantom.Formation.ATTACK_PLAYER_ATTACK && this.isGuard) {
                    this.boss.m_6672_(InteractionHand.OFF_HAND);
                }
                else {
                    this.boss.m_5810_();
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
