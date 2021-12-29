// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.boss.EntityTFMinoshroom;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFGroundAttack extends EntityAIBase
{
    private static final double MIN_RANGE_SQ = 2.0;
    private static final double MAX_RANGE_SQ = 48.0;
    private static final int FREQ = 24;
    private EntityTFMinoshroom attacker;
    private EntityLivingBase attackTarget;
    private int attackTick;
    
    public EntityAITFGroundAttack(final EntityTFMinoshroom entityTFMinoshroom) {
        this.attacker = entityTFMinoshroom;
        this.func_75248_a(3);
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
        if (!this.attacker.field_70122_E) {
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
        this.attacker.func_70605_aq().field_188491_h = EntityMoveHelper.Action.WAIT;
        if (this.attackTick-- <= 0) {
            this.attacker.setGroundAttackCharge(false);
            this.attacker.func_184185_a(SoundEvents.field_187539_bB, 2.0f, 1.0f + this.attacker.func_70681_au().nextFloat() * 0.1f);
            final AxisAlignedBB selection = new AxisAlignedBB((double)(this.attacker.func_180425_c().func_177958_n() - 7.5f), (double)this.attacker.func_180425_c().func_177956_o(), (double)(this.attacker.func_180425_c().func_177952_p() - 7.5f), (double)(this.attacker.func_180425_c().func_177958_n() + 7.5f), (double)(this.attacker.func_180425_c().func_177956_o() + 3.0f), (double)(this.attacker.func_180425_c().func_177952_p() + 7.5f));
            final List<Entity> hit = this.attacker.field_70170_p.func_72872_a((Class)Entity.class, selection);
            for (final Entity entity : hit) {
                if (entity == this.attacker) {
                    continue;
                }
                if (!(entity instanceof EntityLivingBase) || !entity.field_70122_E) {
                    continue;
                }
                final Entity entity2 = entity;
                entity2.field_70181_x += 0.23;
                entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.attacker).func_76348_h(), (float)(this.attacker.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e() * 0.5));
            }
        }
    }
}
