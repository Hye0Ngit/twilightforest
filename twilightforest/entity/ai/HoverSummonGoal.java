// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import java.util.EnumSet;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import twilightforest.entity.boss.SnowQueenEntity;

public class HoverSummonGoal extends HoverBaseGoal<SnowQueenEntity>
{
    private static final int MAX_MINIONS_AT_ONCE = 4;
    private int seekTimer;
    private final int maxSeekTime;
    
    public HoverSummonGoal(final SnowQueenEntity snowQueen) {
        super((MobEntity)snowQueen, 6.0f, 6.0f);
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.maxSeekTime = 80;
    }
    
    public boolean func_75250_a() {
        final LivingEntity target = ((SnowQueenEntity)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((SnowQueenEntity)this.attacker).getCurrentPhase() == SnowQueenEntity.Phase.SUMMON && ((SnowQueenEntity)this.attacker).func_70635_at().func_75522_a((Entity)target);
    }
    
    public boolean func_75253_b() {
        final LivingEntity target = ((SnowQueenEntity)this.attacker).func_70638_az();
        return target != null && target.func_70089_S() && ((SnowQueenEntity)this.attacker).getCurrentPhase() == SnowQueenEntity.Phase.SUMMON && this.seekTimer <= this.maxSeekTime && this.canEntitySee((Entity)this.attacker, this.hoverPosX, this.hoverPosY, this.hoverPosZ);
    }
    
    public void func_75251_c() {
    }
    
    public void func_75246_d() {
        ++this.seekTimer;
        final LivingEntity target = ((SnowQueenEntity)this.attacker).func_70638_az();
        if (((SnowQueenEntity)this.attacker).func_70092_e(this.hoverPosX, this.hoverPosY, this.hoverPosZ) <= 1.0) {
            this.checkAndSummon();
            this.makeNewHoverSpot(target);
        }
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
        if (target != null) {
            ((SnowQueenEntity)this.attacker).func_70625_a((Entity)target, 30.0f, 30.0f);
            ((SnowQueenEntity)this.attacker).func_70671_ap().func_75651_a((Entity)target, 30.0f, 30.0f);
        }
    }
    
    @Override
    protected void makeNewHoverSpot(final LivingEntity target) {
        super.makeNewHoverSpot(target);
        this.seekTimer = 0;
    }
    
    private void checkAndSummon() {
        if (((SnowQueenEntity)this.attacker).getSummonsRemaining() > 0 && ((SnowQueenEntity)this.attacker).countMyMinions() < 4) {
            ((SnowQueenEntity)this.attacker).summonMinionAt(((SnowQueenEntity)this.attacker).func_70638_az());
        }
    }
}
