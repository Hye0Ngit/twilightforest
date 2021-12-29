// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFAdherent extends EntityMob implements IRangedAttackMob, ITFCharger
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Boolean> CHARGE_FLAG;
    
    public EntityTFAdherent(final World world) {
        super(world);
        this.func_70105_a(0.8f, 2.2f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIRestrictSun((EntityCreature)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIFleeSun((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackRanged((IRangedAttackMob)this, 1.0, 60, 10.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFAdherent.CHARGE_FLAG, (Object)false);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
    }
    
    public void func_82196_d(final EntityLivingBase attackTarget, final float extraDamage) {
        final EntityTFNatureBolt natureBolt = new EntityTFNatureBolt(this.field_70170_p, (EntityLivingBase)this);
        this.func_184185_a(SoundEvents.field_187557_bK, 1.0f, 1.0f / (this.field_70146_Z.nextFloat() * 0.4f + 0.8f));
        final double d0 = attackTarget.field_70163_u + attackTarget.func_70047_e() - 1.100000023841858;
        final double d2 = attackTarget.field_70165_t - this.field_70165_t;
        final double d3 = d0 - natureBolt.field_70163_u;
        final double d4 = attackTarget.field_70161_v - this.field_70161_v;
        final float f = MathHelper.func_76133_a(d2 * d2 + d4 * d4) * 0.2f;
        natureBolt.func_70186_c(d2, d3 + f, d4, 0.6f, (float)(10 - this.field_70170_p.func_175659_aa().func_151525_a() * 4));
        this.field_70170_p.func_72838_d((Entity)natureBolt);
    }
    
    public void func_184724_a(final boolean swingingArms) {
    }
    
    public boolean isCharging() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFAdherent.CHARGE_FLAG);
    }
    
    public void setCharging(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFAdherent.CHARGE_FLAG, (Object)flag);
    }
    
    protected ResourceLocation func_184647_J() {
        return EntityTFAdherent.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/adherent");
        CHARGE_FLAG = EntityDataManager.func_187226_a((Class)EntityTFAdherent.class, DataSerializers.field_187198_h);
    }
}
