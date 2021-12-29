// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.util.EntityUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.ForgeEventFactory;
import twilightforest.entity.ITFCharger;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;

public class ChargeAttackGoal extends Goal
{
    private static final double MIN_RANGE_SQ = 16.0;
    private static final double MAX_RANGE_SQ = 64.0;
    private static final int FREQ = 1;
    private CreatureEntity charger;
    private LivingEntity chargeTarget;
    private double chargeX;
    private double chargeY;
    private double chargeZ;
    protected float speed;
    private final boolean canBreak;
    private int windup;
    private boolean hasAttacked;
    
    public ChargeAttackGoal(final CreatureEntity entityLiving, final float f, final boolean canBreak) {
        this.charger = entityLiving;
        this.speed = f;
        this.canBreak = canBreak;
        this.windup = 0;
        this.hasAttacked = false;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean func_75250_a() {
        this.chargeTarget = this.charger.func_70638_az();
        if (this.chargeTarget == null) {
            return false;
        }
        final double distance = this.charger.func_70068_e((Entity)this.chargeTarget);
        if (distance < 16.0 || distance > 64.0) {
            return false;
        }
        if (!this.charger.func_233570_aj_()) {
            return false;
        }
        final Vector3d chargePos = this.findChargePoint((Entity)this.charger, (Entity)this.chargeTarget, 2.1);
        final boolean canSeeTargetFromDest = this.charger.func_70635_at().func_75522_a((Entity)this.chargeTarget);
        if (!canSeeTargetFromDest) {
            return false;
        }
        this.chargeX = chargePos.field_72450_a;
        this.chargeY = chargePos.field_72448_b;
        this.chargeZ = chargePos.field_72449_c;
        return this.charger.func_70681_au().nextInt(1) == 0;
    }
    
    public void func_75249_e() {
        this.windup = 15 + this.charger.func_70681_au().nextInt(30);
        this.charger.func_70031_b(true);
    }
    
    public boolean func_75253_b() {
        return this.windup > 0 || !this.charger.func_70661_as().func_75500_f();
    }
    
    public void func_75246_d() {
        this.charger.func_70671_ap().func_75650_a(this.chargeX, this.chargeY - 1.0, this.chargeZ, 10.0f, (float)this.charger.func_70646_bf());
        if (this.windup > 0) {
            if (--this.windup == 0) {
                this.charger.func_70661_as().func_75492_a(this.chargeX, this.chargeY, this.chargeZ, (double)this.speed);
            }
            else {
                final CreatureEntity charger = this.charger;
                charger.field_70721_aZ += (float)0.8;
                if (this.charger instanceof ITFCharger) {
                    ((ITFCharger)this.charger).setCharging(true);
                }
            }
        }
        else if (this.canBreak && !this.charger.field_70170_p.field_72995_K && ForgeEventFactory.getMobGriefingEvent(this.charger.field_70170_p, (Entity)this.charger)) {
            final AxisAlignedBB bb = this.charger.func_174813_aQ();
            final int minx = MathHelper.func_76128_c(bb.field_72340_a - 0.75);
            final int miny = MathHelper.func_76128_c(bb.field_72338_b + 0.0);
            final int minz = MathHelper.func_76128_c(bb.field_72339_c - 0.75);
            final int maxx = MathHelper.func_76128_c(bb.field_72336_d + 0.75);
            final int maxy = MathHelper.func_76128_c(bb.field_72337_e + 0.15);
            final int maxz = MathHelper.func_76128_c(bb.field_72334_f + 0.75);
            final BlockPos min = new BlockPos(minx, miny, minz);
            final BlockPos max = new BlockPos(maxx, maxy, maxz);
            if (this.charger.field_70170_p.func_175707_a(min, max)) {
                for (final BlockPos pos : BlockPos.func_218278_a(min, max)) {
                    if (EntityUtil.canDestroyBlock(this.charger.field_70170_p, pos, (Entity)this.charger) && this.charger.field_70170_p.func_175625_s(pos) == null) {
                        this.charger.field_70170_p.func_175655_b(pos, true);
                    }
                }
            }
        }
        final double rangeSq = this.charger.func_213311_cf() * 2.1f * this.charger.func_213311_cf() * 2.1f;
        if (this.charger.func_70092_e(this.chargeTarget.func_226277_ct_(), this.chargeTarget.func_174813_aQ().field_72338_b, this.chargeTarget.func_226281_cx_()) <= rangeSq && !this.hasAttacked) {
            this.hasAttacked = true;
            this.charger.func_70652_k((Entity)this.chargeTarget);
        }
    }
    
    public void func_75251_c() {
        this.windup = 0;
        this.chargeTarget = null;
        this.hasAttacked = false;
        this.charger.func_70031_b(false);
        if (this.charger instanceof ITFCharger) {
            ((ITFCharger)this.charger).setCharging(false);
        }
    }
    
    protected Vector3d findChargePoint(final Entity attacker, final Entity target, final double overshoot) {
        final double vecx = target.func_226277_ct_() - attacker.func_226277_ct_();
        final double vecz = target.func_226281_cx_() - attacker.func_226281_cx_();
        final float rangle = (float)Math.atan2(vecz, vecx);
        final double distance = MathHelper.func_76133_a(vecx * vecx + vecz * vecz);
        final double dx = MathHelper.func_76134_b(rangle) * (distance + overshoot);
        final double dz = MathHelper.func_76126_a(rangle) * (distance + overshoot);
        return new Vector3d(attacker.func_226277_ct_() + dx, target.func_226278_cu_(), attacker.func_226281_cx_() + dz);
    }
}
