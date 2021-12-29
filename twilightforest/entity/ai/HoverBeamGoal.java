// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Optional;
import net.minecraft.world.phys.AABB;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.Arrays;
import java.util.Objects;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import twilightforest.entity.boss.SnowQueen;

public class HoverBeamGoal extends HoverBaseGoal<SnowQueen>
{
    private int hoverTimer;
    private int beamTimer;
    private int seekTimer;
    private final int maxHoverTime;
    private final int maxBeamTime;
    private final int maxSeekTime;
    private double beamY;
    private boolean isInPosition;
    
    public HoverBeamGoal(final SnowQueen snowQueen, final int hoverTime, final int dropTime) {
        super((Mob)snowQueen, 3.0f, 4.0f);
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.maxHoverTime = hoverTime;
        this.maxSeekTime = hoverTime;
        this.maxBeamTime = dropTime;
        this.hoverTimer = 0;
        this.isInPosition = false;
    }
    
    public boolean m_8036_() {
        final LivingEntity target = ((SnowQueen)this.attacker).m_5448_();
        return target != null && target.m_6084_() && ((SnowQueen)this.attacker).getCurrentPhase() == SnowQueen.Phase.BEAM;
    }
    
    public boolean m_8045_() {
        final LivingEntity target = ((SnowQueen)this.attacker).m_5448_();
        return target != null && target.m_6084_() && ((SnowQueen)this.attacker).getCurrentPhase() == SnowQueen.Phase.BEAM && this.seekTimer < this.maxSeekTime && this.beamTimer < this.maxBeamTime;
    }
    
    public void m_8041_() {
        this.seekTimer = 0;
        this.hoverTimer = 0;
        this.beamTimer = 0;
        this.isInPosition = false;
        ((SnowQueen)this.attacker).setBreathing(false);
    }
    
    public void m_8037_() {
        if (((SnowQueen)this.attacker).m_20275_(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
            this.isInPosition = true;
        }
        if (this.isInPosition) {
            ++this.hoverTimer;
        }
        else {
            ++this.seekTimer;
        }
        if (this.hoverTimer >= this.maxHoverTime) {
            ++this.beamTimer;
            ((SnowQueen)this.attacker).setBreathing(true);
            this.doRayAttack();
            this.hoverPosY -= 0.05000000074505806;
            if (this.hoverPosY < this.beamY) {
                this.hoverPosY = this.beamY;
            }
        }
        final double offsetX = this.hoverPosX - ((SnowQueen)this.attacker).m_20185_();
        final double offsetY = this.hoverPosY - ((SnowQueen)this.attacker).m_20186_();
        final double offsetZ = this.hoverPosZ - ((SnowQueen)this.attacker).m_20189_();
        double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        distanceDesired = Mth.m_14116_((float)distanceDesired);
        if (distanceDesired > 0.5) {
            final double velX = offsetX / distanceDesired * 0.05;
            double velY = offsetY / distanceDesired * 0.1;
            final double velZ = offsetZ / distanceDesired * 0.05;
            velY += 0.019999999552965164;
            ((SnowQueen)this.attacker).m_5997_(velX, velY, velZ);
        }
        final LivingEntity target = ((SnowQueen)this.attacker).m_5448_();
        if (target != null) {
            final float tracking = this.isInPosition ? 1.0f : 20.0f;
            ((SnowQueen)this.attacker).m_21391_((Entity)target, tracking, tracking);
            ((SnowQueen)this.attacker).m_21563_().m_24960_((Entity)target, tracking, tracking);
        }
    }
    
    private void doRayAttack() {
        final double range = 20.0;
        final double offset = 10.0;
        final Vec3 srcVec = new Vec3(((SnowQueen)this.attacker).m_20185_(), ((SnowQueen)this.attacker).m_20186_() + 0.25, ((SnowQueen)this.attacker).m_20189_());
        final Vec3 lookVec = ((SnowQueen)this.attacker).m_20252_(1.0f);
        final Vec3 destVec = srcVec.m_82520_(lookVec.f_82479_ * range, lookVec.f_82480_ * range, lookVec.f_82481_ * range);
        final List<Entity> possibleList = ((SnowQueen)this.attacker).f_19853_.m_45933_((Entity)this.attacker, ((SnowQueen)this.attacker).m_142469_().m_82386_(lookVec.f_82479_ * offset, lookVec.f_82480_ * offset, lookVec.f_82481_ * offset).m_82377_(range, range, range));
        double hitDist = 0.0;
        if (((SnowQueen)this.attacker).isMultipartEntity()) {
            possibleList.removeAll(Arrays.asList((Object[])Objects.requireNonNull((T[])((SnowQueen)this.attacker).getParts())));
        }
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.m_6087_() && possibleEntity != this.attacker) {
                final float borderSize = possibleEntity.m_6143_();
                final AABB collisionBB = possibleEntity.m_142469_().m_82377_((double)borderSize, (double)borderSize, (double)borderSize);
                final Optional<Vec3> interceptPos = collisionBB.m_82371_(srcVec, destVec);
                if (collisionBB.m_82390_(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    ((SnowQueen)this.attacker).doBreathAttack(possibleEntity);
                    hitDist = 0.0;
                }
                else {
                    if (!interceptPos.isPresent()) {
                        continue;
                    }
                    final double possibleDist = srcVec.m_82554_((Vec3)interceptPos.get());
                    if (possibleDist >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    ((SnowQueen)this.attacker).doBreathAttack(possibleEntity);
                    hitDist = possibleDist;
                }
            }
        }
    }
    
    @Override
    protected void makeNewHoverSpot(final LivingEntity target) {
        super.makeNewHoverSpot(target);
        this.beamY = target.m_20186_();
        this.seekTimer = 0;
    }
}
