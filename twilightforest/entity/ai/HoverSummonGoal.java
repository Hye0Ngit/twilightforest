// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import twilightforest.entity.boss.SnowQueen;

public class HoverSummonGoal extends HoverBaseGoal<SnowQueen>
{
    private static final int MAX_MINIONS_AT_ONCE = 4;
    private int seekTimer;
    private final int maxSeekTime;
    
    public HoverSummonGoal(final SnowQueen snowQueen) {
        super((Mob)snowQueen, 6.0f, 6.0f);
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.maxSeekTime = 80;
    }
    
    public boolean m_8036_() {
        final LivingEntity target = ((SnowQueen)this.attacker).m_5448_();
        return target != null && target.m_6084_() && ((SnowQueen)this.attacker).getCurrentPhase() == SnowQueen.Phase.SUMMON && ((SnowQueen)this.attacker).m_21574_().m_148306_((Entity)target);
    }
    
    public boolean m_8045_() {
        final LivingEntity target = ((SnowQueen)this.attacker).m_5448_();
        return target != null && target.m_6084_() && ((SnowQueen)this.attacker).getCurrentPhase() == SnowQueen.Phase.SUMMON && this.seekTimer <= this.maxSeekTime && this.canEntitySee((Entity)this.attacker, this.hoverPosX, this.hoverPosY, this.hoverPosZ);
    }
    
    public void m_8041_() {
    }
    
    public void m_8037_() {
        ++this.seekTimer;
        final LivingEntity target = ((SnowQueen)this.attacker).m_5448_();
        if (((SnowQueen)this.attacker).m_20275_(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
            this.checkAndSummon();
            this.makeNewHoverSpot(target);
        }
        final double offsetX = this.hoverPosX - ((SnowQueen)this.attacker).m_20185_();
        final double offsetY = this.hoverPosY - ((SnowQueen)this.attacker).m_20186_();
        final double offsetZ = this.hoverPosZ - ((SnowQueen)this.attacker).m_20189_();
        double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        distanceDesired = Mth.m_14116_((float)distanceDesired);
        final double velX = offsetX / distanceDesired * 0.05;
        double velY = offsetY / distanceDesired * 0.1;
        final double velZ = offsetZ / distanceDesired * 0.05;
        velY += 0.05000000074505806;
        ((SnowQueen)this.attacker).m_5997_(velX, velY, velZ);
        if (target != null) {
            ((SnowQueen)this.attacker).m_21391_((Entity)target, 30.0f, 30.0f);
            ((SnowQueen)this.attacker).m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
        }
    }
    
    @Override
    protected void makeNewHoverSpot(final LivingEntity target) {
        super.makeNewHoverSpot(target);
        this.seekTimer = 0;
    }
    
    private void checkAndSummon() {
        if (((SnowQueen)this.attacker).getSummonsRemaining() > 0 && ((SnowQueen)this.attacker).countMyMinions() < 4) {
            ((SnowQueen)this.attacker).summonMinionAt(((SnowQueen)this.attacker).m_5448_());
        }
    }
}
