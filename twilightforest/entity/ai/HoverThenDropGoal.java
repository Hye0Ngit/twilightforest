// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import twilightforest.entity.boss.SnowQueen;

public class HoverThenDropGoal extends HoverBaseGoal<SnowQueen>
{
    private int hoverTimer;
    private int dropTimer;
    private int seekTimer;
    private final int maxHoverTime;
    private final int maxDropTime;
    private final int maxSeekTime;
    private double dropY;
    
    public HoverThenDropGoal(final SnowQueen snowQueen, final int hoverTime, final int dropTime) {
        super((Mob)snowQueen, 6.0f, 0.0f);
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.maxHoverTime = hoverTime;
        this.maxSeekTime = hoverTime;
        this.maxDropTime = dropTime;
        this.hoverTimer = 0;
    }
    
    public boolean m_8036_() {
        final LivingEntity target = ((SnowQueen)this.attacker).m_5448_();
        return target != null && target.m_6084_() && ((SnowQueen)this.attacker).getCurrentPhase() == SnowQueen.Phase.DROP;
    }
    
    public boolean m_8045_() {
        final LivingEntity target = ((SnowQueen)this.attacker).m_5448_();
        if (target == null || !target.m_6084_()) {
            return false;
        }
        if (((SnowQueen)this.attacker).getCurrentPhase() != SnowQueen.Phase.DROP) {
            return false;
        }
        if (this.seekTimer > this.maxSeekTime) {
            return false;
        }
        if (((SnowQueen)this.attacker).m_20275_(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
            ++this.hoverTimer;
            return true;
        }
        if (this.dropTimer < this.maxDropTime) {
            return true;
        }
        ((SnowQueen)this.attacker).incrementSuccessfulDrops();
        return false;
    }
    
    public void m_8041_() {
        this.hoverTimer = 0;
        this.dropTimer = 0;
    }
    
    public void m_8037_() {
        if (this.hoverTimer > 0) {
            ++this.hoverTimer;
        }
        else {
            ++this.seekTimer;
        }
        if (this.hoverTimer < this.maxHoverTime) {
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
            final LivingEntity target = ((SnowQueen)this.attacker).m_5448_();
            if (target != null) {
                ((SnowQueen)this.attacker).m_21391_((Entity)target, 30.0f, 30.0f);
                ((SnowQueen)this.attacker).m_21563_().m_24960_((Entity)target, 30.0f, 30.0f);
            }
        }
        else {
            ++this.dropTimer;
            if (((SnowQueen)this.attacker).m_20186_() > this.dropY) {
                ((SnowQueen)this.attacker).destroyBlocksInAABB(((SnowQueen)this.attacker).m_142469_().m_82377_(1.0, 0.5, 1.0));
            }
        }
    }
    
    @Override
    protected void makeNewHoverSpot(final LivingEntity target) {
        super.makeNewHoverSpot(target);
        this.dropY = target.m_20186_() - 1.0;
        this.seekTimer = 0;
    }
}
