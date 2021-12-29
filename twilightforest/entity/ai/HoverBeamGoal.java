// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Optional;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.Arrays;
import java.util.Objects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import java.util.EnumSet;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import twilightforest.entity.boss.SnowQueenEntity;

public class HoverBeamGoal extends HoverBaseGoal<SnowQueenEntity>
{
    private int hoverTimer;
    private int beamTimer;
    private int seekTimer;
    private final int maxHoverTime;
    private final int maxBeamTime;
    private final int maxSeekTime;
    private double beamY;
    private boolean isInPosition;
    
    public HoverBeamGoal(final SnowQueenEntity snowQueen, final int hoverTime, final int dropTime) {
        super((MobEntity)snowQueen, 3.0f, 4.0f);
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.maxHoverTime = hoverTime;
        this.maxSeekTime = hoverTime;
        this.maxBeamTime = dropTime;
        this.hoverTimer = 0;
        this.isInPosition = false;
    }
    
    public boolean func_75250_a() {
        final LivingEntity target = ((SnowQueenEntity)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((SnowQueenEntity)this.attacker).getCurrentPhase() == SnowQueenEntity.Phase.BEAM;
    }
    
    public boolean func_75253_b() {
        final LivingEntity target = ((SnowQueenEntity)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((SnowQueenEntity)this.attacker).getCurrentPhase() == SnowQueenEntity.Phase.BEAM && this.seekTimer < this.maxSeekTime && this.beamTimer < this.maxBeamTime;
    }
    
    public void func_75251_c() {
        this.seekTimer = 0;
        this.hoverTimer = 0;
        this.beamTimer = 0;
        this.isInPosition = false;
        ((SnowQueenEntity)this.attacker).setBreathing(false);
    }
    
    public void func_75246_d() {
        if (((SnowQueenEntity)this.attacker).func_70092_e(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
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
            ((SnowQueenEntity)this.attacker).setBreathing(true);
            this.doRayAttack();
            this.hoverPosY -= 0.05000000074505806;
            if (this.hoverPosY < this.beamY) {
                this.hoverPosY = this.beamY;
            }
        }
        final double offsetX = this.hoverPosX - ((SnowQueenEntity)this.attacker).func_226277_ct_();
        final double offsetY = this.hoverPosY - ((SnowQueenEntity)this.attacker).func_226278_cu_();
        final double offsetZ = this.hoverPosZ - ((SnowQueenEntity)this.attacker).func_226281_cx_();
        double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
        distanceDesired = MathHelper.func_76133_a(distanceDesired);
        if (distanceDesired > 0.5) {
            final double velX = offsetX / distanceDesired * 0.05;
            double velY = offsetY / distanceDesired * 0.1;
            final double velZ = offsetZ / distanceDesired * 0.05;
            velY += 0.019999999552965164;
            ((SnowQueenEntity)this.attacker).func_70024_g(velX, velY, velZ);
        }
        final LivingEntity target = ((SnowQueenEntity)this.attacker).func_70638_az();
        if (target != null) {
            final float tracking = this.isInPosition ? 1.0f : 20.0f;
            ((SnowQueenEntity)this.attacker).func_70625_a((Entity)target, tracking, tracking);
            ((SnowQueenEntity)this.attacker).func_70671_ap().func_75651_a((Entity)target, tracking, tracking);
        }
    }
    
    private void doRayAttack() {
        final double range = 20.0;
        final double offset = 10.0;
        final Vector3d srcVec = new Vector3d(((SnowQueenEntity)this.attacker).func_226277_ct_(), ((SnowQueenEntity)this.attacker).func_226278_cu_() + 0.25, ((SnowQueenEntity)this.attacker).func_226281_cx_());
        final Vector3d lookVec = ((SnowQueenEntity)this.attacker).func_70676_i(1.0f);
        final Vector3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final List<Entity> possibleList = ((SnowQueenEntity)this.attacker).field_70170_p.func_72839_b((Entity)this.attacker, ((SnowQueenEntity)this.attacker).func_174813_aQ().func_72317_d(lookVec.field_72450_a * offset, lookVec.field_72448_b * offset, lookVec.field_72449_c * offset).func_72314_b(range, range, range));
        double hitDist = 0.0;
        if (((SnowQueenEntity)this.attacker).isMultipartEntity()) {
            possibleList.removeAll(Arrays.asList((Object[])Objects.requireNonNull((T[])((SnowQueenEntity)this.attacker).getParts())));
        }
        for (final Entity possibleEntity : possibleList) {
            if (possibleEntity.func_70067_L() && possibleEntity != this.attacker) {
                final float borderSize = possibleEntity.func_70111_Y();
                final AxisAlignedBB collisionBB = possibleEntity.func_174813_aQ().func_72314_b((double)borderSize, (double)borderSize, (double)borderSize);
                final Optional<Vector3d> interceptPos = collisionBB.func_216365_b(srcVec, destVec);
                if (collisionBB.func_72318_a(srcVec)) {
                    if (0.0 >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    ((SnowQueenEntity)this.attacker).doBreathAttack(possibleEntity);
                    hitDist = 0.0;
                }
                else {
                    if (!interceptPos.isPresent()) {
                        continue;
                    }
                    final double possibleDist = srcVec.func_72438_d((Vector3d)interceptPos.get());
                    if (possibleDist >= hitDist && hitDist != 0.0) {
                        continue;
                    }
                    ((SnowQueenEntity)this.attacker).doBreathAttack(possibleEntity);
                    hitDist = possibleDist;
                }
            }
        }
    }
    
    @Override
    protected void makeNewHoverSpot(final LivingEntity target) {
        super.makeNewHoverSpot(target);
        this.beamY = target.func_226278_cu_();
        this.seekTimer = 0;
    }
}
