// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFSlimeBeetle extends EntityMob implements IRangedAttackMob
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFSlimeBeetle(final World world) {
        super(world);
        this.func_70105_a(0.9f, 1.75f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 3.0f, 1.25, 2.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackRanged((IRangedAttackMob)this, 1.0, 30, 10.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(25.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0);
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return SoundEvents.field_187821_fM;
    }
    
    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187819_fL;
    }
    
    protected void func_180429_a(final BlockPos pos, final Block block) {
        this.func_184185_a(SoundEvents.field_187823_fN, 0.15f, 1.0f);
    }
    
    public float func_70047_e() {
        return 0.25f;
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFSlimeBeetle.LOOT_TABLE;
    }
    
    public void func_82196_d(final EntityLivingBase target, final float distanceFactor) {
        final EntityThrowable projectile = new EntityTFSlimeProjectile(this.field_70170_p, (EntityLivingBase)this);
        this.func_184185_a(SoundEvents.field_187900_fz, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        final double tx = target.field_70165_t - this.field_70165_t;
        final double ty = target.field_70163_u + target.func_70047_e() - 1.100000023841858 - projectile.field_70163_u;
        final double tz = target.field_70161_v - this.field_70161_v;
        final float heightOffset = MathHelper.func_76133_a(tx * tx + tz * tz) * 0.2f;
        projectile.func_70186_c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
        this.field_70170_p.func_72838_d((Entity)projectile);
    }
    
    public void func_184724_a(final boolean swingingArms) {
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/slime_beetle");
    }
}
