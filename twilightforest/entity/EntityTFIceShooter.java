// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.IRangedAttackMob;

public class EntityTFIceShooter extends EntityTFIceMob implements IRangedAttackMob
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFIceShooter(final World world) {
        super(world);
        this.func_70105_a(0.8f, 1.8f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackRanged((IRangedAttackMob)this, 1.25, 20, 10.0f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
    }
    
    public float func_70047_e() {
        return this.field_70131_O * 0.6f;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFIceShooter.LOOT_TABLE;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.ICE_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.ICE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ICE_DEATH;
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    public void func_82196_d(final EntityLivingBase target, final float distanceFactor) {
        final EntityTFIceSnowball snowball = new EntityTFIceSnowball(this.field_70170_p, (EntityLivingBase)this);
        final double d0 = target.field_70163_u + target.func_70047_e() - 1.4;
        final double d2 = target.field_70165_t - this.field_70165_t;
        final double d3 = d0 - snowball.field_70163_u;
        final double d4 = target.field_70161_v - this.field_70161_v;
        final float f = MathHelper.func_76133_a(d2 * d2 + d4 * d4) * 0.2f;
        snowball.func_70186_c(d2, d3 + f, d4, 1.6f, 0.0f);
        this.func_184185_a(SoundEvents.field_187797_fA, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        this.field_70170_p.func_72838_d((Entity)snowball);
    }
    
    public void func_184724_a(final boolean swingingArms) {
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/ice_shooter");
    }
}
