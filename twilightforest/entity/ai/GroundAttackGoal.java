// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundEvents;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.Entity;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import twilightforest.entity.boss.MinoshroomEntity;
import net.minecraft.entity.ai.goal.Goal;

public class GroundAttackGoal extends Goal
{
    private static final double MIN_RANGE_SQ = 2.0;
    private static final double MAX_RANGE_SQ = 48.0;
    private static final int FREQ = 24;
    private MinoshroomEntity attacker;
    private LivingEntity attackTarget;
    private int attackTick;
    
    public GroundAttackGoal(final MinoshroomEntity entityTFMinoshroom) {
        this.attacker = entityTFMinoshroom;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean func_75250_a() {
        this.attackTarget = this.attacker.func_70638_az();
        if (this.attackTarget == null) {
            return false;
        }
        final double distance = this.attacker.func_70068_e((Entity)this.attackTarget);
        if (distance < 2.0 || distance > 48.0) {
            return false;
        }
        if (!this.attacker.func_233570_aj_()) {
            return false;
        }
        if (this.attacker.func_70685_l((Entity)this.attackTarget)) {
            return this.attacker.func_70681_au().nextInt(24) == 0;
        }
        return this.attacker.func_70681_au().nextInt(20) == 0;
    }
    
    public void func_75249_e() {
        this.attackTick = 30 + this.attacker.func_70681_au().nextInt(30);
        this.attacker.setMaxCharge(this.attackTick);
        this.attacker.setGroundAttackCharge(true);
    }
    
    public boolean func_75253_b() {
        return this.attackTick >= 0;
    }
    
    public void func_75251_c() {
        this.attackTick = 0;
        this.attackTarget = null;
    }
    
    public void func_75246_d() {
        this.attacker.func_70671_ap().func_75651_a((Entity)this.attackTarget, 30.0f, 30.0f);
        this.attacker.func_70605_aq().field_188491_h = MovementController.Action.WAIT;
        if (this.attackTick-- <= 0) {
            this.attacker.setGroundAttackCharge(false);
            this.attacker.func_184185_a(SoundEvents.field_187539_bB, 2.0f, 1.0f + this.attacker.func_70681_au().nextFloat() * 0.1f);
            final AxisAlignedBB selection = new AxisAlignedBB((double)(this.attacker.func_233580_cy_().func_177958_n() - 7.5f), (double)this.attacker.func_233580_cy_().func_177956_o(), (double)(this.attacker.func_233580_cy_().func_177952_p() - 7.5f), (double)(this.attacker.func_233580_cy_().func_177958_n() + 7.5f), (double)(this.attacker.func_233580_cy_().func_177956_o() + 3.0f), (double)(this.attacker.func_233580_cy_().func_177952_p() + 7.5f));
            final List<Entity> hit = this.attacker.field_70170_p.func_217357_a((Class)Entity.class, selection);
            for (final Entity entity : hit) {
                if (entity == this.attacker) {
                    continue;
                }
                if (!(entity instanceof LivingEntity) || !entity.func_233570_aj_()) {
                    continue;
                }
                entity.func_70024_g(0.0, 0.23, 0.0);
                entity.func_70097_a(DamageSource.func_76358_a((LivingEntity)this.attacker).func_76348_h(), (float)(this.attacker.func_110148_a(Attributes.field_233823_f_).func_111126_e() * 0.5));
            }
        }
    }
}
