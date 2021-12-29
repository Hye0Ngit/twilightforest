// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.MathHelper;
import twilightforest.entity.ITFCharger;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFChargeAttack extends EntityAIBase
{
    protected static final double MIN_RANGE_SQ = 16.0;
    protected static final double MAX_RANGE_SQ = 64.0;
    protected static final int FREQ = 1;
    protected EntityCreature charger;
    protected EntityLivingBase chargeTarget;
    protected double chargeX;
    protected double chargeY;
    protected double chargeZ;
    protected float speed;
    protected int windup;
    protected boolean hasAttacked;
    
    public EntityAITFChargeAttack(final EntityCreature entityLiving, final float f) {
        this.charger = entityLiving;
        this.speed = f;
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
        final Vec3 chargePos = this.findChargePoint((Entity)this.charger, (Entity)this.chargeTarget, 2.1);
        final boolean canSeeTargetFromDest = this.chargeTarget.field_70170_p.func_72933_a(Vec3.func_72443_a(this.chargeTarget.field_70165_t, this.chargeTarget.field_70163_u + this.chargeTarget.func_70047_e(), this.chargeTarget.field_70161_v), chargePos) == null;
        if (chargePos == null || !canSeeTargetFromDest) {
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
        final double var1 = this.charger.field_70130_N * 2.1f * this.charger.field_70130_N * 2.1f;
        if (this.charger.func_70092_e(this.chargeTarget.field_70165_t, this.chargeTarget.field_70121_D.field_72338_b, this.chargeTarget.field_70161_v) <= var1 && !this.hasAttacked) {
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
    
    protected Vec3 findChargePoint(final Entity attacker, final Entity target, final double overshoot) {
        final double vecx = target.field_70165_t - attacker.field_70165_t;
        final double vecz = target.field_70161_v - attacker.field_70161_v;
        final float rangle = (float)Math.atan2(vecz, vecx);
        final double distance = MathHelper.func_76133_a(vecx * vecx + vecz * vecz);
        final double dx = MathHelper.func_76134_b(rangle) * (distance + overshoot);
        final double dz = MathHelper.func_76126_a(rangle) * (distance + overshoot);
        return Vec3.func_72443_a(attacker.field_70165_t + dx, target.field_70163_u, attacker.field_70161_v + dz);
    }
}
