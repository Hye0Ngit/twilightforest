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
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFChargeAttack extends EntityAIBase
{
    private static final double MIN_RANGE_SQ = 16.0;
    private static final double MAX_RANGE_SQ = 64.0;
    private static final int FREQ = 1;
    private EntityCreature charger;
    private EntityLivingBase chargeTarget;
    private double chargeX;
    private double chargeY;
    private double chargeZ;
    protected float speed;
    private final boolean canBreak;
    private int windup;
    private boolean hasAttacked;
    
    public EntityAITFChargeAttack(final EntityCreature entityLiving, final float f, final boolean canBreak) {
        this.charger = entityLiving;
        this.speed = f;
        this.canBreak = canBreak;
        this.windup = 0;
        this.hasAttacked = false;
        this.func_75248_a(3);
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
        if (!this.charger.field_70122_E) {
            return false;
        }
        final Vec3d chargePos = this.findChargePoint((Entity)this.charger, (Entity)this.chargeTarget, 2.1);
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
                final EntityCreature charger = this.charger;
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
                for (final BlockPos pos : BlockPos.func_177980_a(min, max)) {
                    if (EntityUtil.canDestroyBlock(this.charger.field_70170_p, pos, (Entity)this.charger) && this.charger.field_70170_p.func_175625_s(pos) == null) {
                        this.charger.field_70170_p.func_175655_b(pos, true);
                    }
                }
            }
        }
        final double rangeSq = this.charger.field_70130_N * 2.1f * this.charger.field_70130_N * 2.1f;
        if (this.charger.func_70092_e(this.chargeTarget.field_70165_t, this.chargeTarget.func_174813_aQ().field_72338_b, this.chargeTarget.field_70161_v) <= rangeSq && !this.hasAttacked) {
            this.hasAttacked = true;
            this.charger.func_70652_k((Entity)this.chargeTarget);
        }
    }
    
    public void func_75251_c() {
        this.windup = 0;
        this.chargeTarget = null;
        this.hasAttacked = false;
        if (this.charger instanceof ITFCharger) {
            ((ITFCharger)this.charger).setCharging(false);
        }
    }
    
    protected Vec3d findChargePoint(final Entity attacker, final Entity target, final double overshoot) {
        final double vecx = target.field_70165_t - attacker.field_70165_t;
        final double vecz = target.field_70161_v - attacker.field_70161_v;
        final float rangle = (float)Math.atan2(vecz, vecx);
        final double distance = MathHelper.func_76133_a(vecx * vecx + vecz * vecz);
        final double dx = MathHelper.func_76134_b(rangle) * (distance + overshoot);
        final double dz = MathHelper.func_76126_a(rangle) * (distance + overshoot);
        return new Vec3d(attacker.field_70165_t + dx, target.field_70163_u, attacker.field_70161_v + dz);
    }
}
