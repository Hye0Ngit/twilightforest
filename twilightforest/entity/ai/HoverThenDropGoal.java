// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import java.util.EnumSet;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import twilightforest.entity.boss.SnowQueenEntity;

public class HoverThenDropGoal extends HoverBaseGoal<SnowQueenEntity>
{
    private int hoverTimer;
    private int dropTimer;
    private int seekTimer;
    private final int maxHoverTime;
    private final int maxDropTime;
    private final int maxSeekTime;
    private double dropY;
    
    public HoverThenDropGoal(final SnowQueenEntity snowQueen, final int hoverTime, final int dropTime) {
        super((MobEntity)snowQueen, 6.0f, 0.0f);
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.maxHoverTime = hoverTime;
        this.maxSeekTime = hoverTime;
        this.maxDropTime = dropTime;
        this.hoverTimer = 0;
    }
    
    public boolean func_75250_a() {
        final LivingEntity target = ((SnowQueenEntity)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((SnowQueenEntity)this.attacker).getCurrentPhase() == SnowQueenEntity.Phase.DROP;
    }
    
    public boolean func_75253_b() {
        final LivingEntity target = ((SnowQueenEntity)this.attacker).func_70638_az();
        if (target == null || !target.func_70089_S()) {
            return false;
        }
        if (((SnowQueenEntity)this.attacker).getCurrentPhase() != SnowQueenEntity.Phase.DROP) {
            return false;
        }
        if (this.seekTimer > this.maxSeekTime) {
            return false;
        }
        if (((SnowQueenEntity)this.attacker).func_70092_e(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
            ++this.hoverTimer;
            return true;
        }
        if (this.dropTimer < this.maxDropTime) {
            return true;
        }
        ((SnowQueenEntity)this.attacker).incrementSuccessfulDrops();
        return false;
    }
    
    public void func_75251_c() {
        this.hoverTimer = 0;
        this.dropTimer = 0;
    }
    
    public void func_75246_d() {
        if (this.hoverTimer > 0) {
            ++this.hoverTimer;
        }
        else {
            ++this.seekTimer;
        }
        if (this.hoverTimer < this.maxHoverTime) {
            final double offsetX = this.hoverPosX - ((SnowQueenEntity)this.attacker).func_226277_ct_();
            final double offsetY = this.hoverPosY - ((SnowQueenEntity)this.attacker).func_226278_cu_();
            final double offsetZ = this.hoverPosZ - ((SnowQueenEntity)this.attacker).func_226281_cx_();
            double distanceDesired = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
            distanceDesired = MathHelper.func_76133_a(distanceDesired);
            final double velX = offsetX / distanceDesired * 0.05;
            double velY = offsetY / distanceDesired * 0.1;
            final double velZ = offsetZ / distanceDesired * 0.05;
            velY += 0.05000000074505806;
            ((SnowQueenEntity)this.attacker).func_70024_g(velX, velY, velZ);
            final LivingEntity target = ((SnowQueenEntity)this.attacker).func_70638_az();
            if (target != null) {
                ((SnowQueenEntity)this.attacker).func_70625_a((Entity)target, 30.0f, 30.0f);
                ((SnowQueenEntity)this.attacker).func_70671_ap().func_75651_a((Entity)target, 30.0f, 30.0f);
            }
        }
        else {
            ++this.dropTimer;
            if (((SnowQueenEntity)this.attacker).func_226278_cu_() > this.dropY) {
                ((SnowQueenEntity)this.attacker).destroyBlocksInAABB(((SnowQueenEntity)this.attacker).func_174813_aQ().func_72314_b(1.0, 0.5, 1.0));
            }
        }
    }
    
    @Override
    protected void makeNewHoverSpot(final LivingEntity target) {
        super.makeNewHoverSpot(target);
        this.dropY = target.func_226278_cu_() - 1.0;
        this.seekTimer = 0;
    }
}
