// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import javax.annotation.Nullable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityTameable;

public class EntityTFLoyalZombie extends EntityTameable
{
    public EntityTFLoyalZombie(final World world) {
        super(world);
        this.func_70105_a(0.6f, 1.8f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, true));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIFollowOwner((EntityTameable)this, 1.0, 10.0f, 2.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIOwnerHurtByTarget((EntityTameable)this));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIOwnerHurtTarget((EntityTameable)this));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(4, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityMob.class, true));
    }
    
    public EntityAnimal createChild(final EntityAgeable entityanimal) {
        return null;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
        this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111128_a(3.0);
    }
    
    public boolean func_70652_k(final Entity entity) {
        final boolean success = entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 7.0f);
        if (success) {
            entity.field_70181_x += 0.2;
        }
        return success;
    }
    
    public void func_70636_d() {
        if (!this.field_70170_p.field_72995_K && this.func_70660_b(MobEffects.field_76420_g) == null) {
            this.func_70015_d(100);
        }
        super.func_70636_d();
    }
    
    public boolean func_142018_a(final EntityLivingBase target, final EntityLivingBase owner) {
        if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast)) {
            if (target instanceof EntityTFLoyalZombie) {
                final EntityTFLoyalZombie zombie = (EntityTFLoyalZombie)target;
                if (zombie.func_70909_n() && zombie.func_70902_q() == owner) {
                    return false;
                }
            }
            return (!(target instanceof EntityPlayer) || !(owner instanceof EntityPlayer) || ((EntityPlayer)owner).func_96122_a((EntityPlayer)target)) && (!(target instanceof AbstractHorse) || !((AbstractHorse)target).func_110248_bS());
        }
        return false;
    }
    
    protected boolean func_70692_ba() {
        return !this.func_70909_n();
    }
    
    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187899_gZ;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return SoundEvents.field_187934_hh;
    }
    
    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187930_hd;
    }
    
    protected void func_180429_a(final BlockPos pos, final Block block) {
        this.func_184185_a(SoundEvents.field_187939_hm, 0.15f, 1.0f);
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.UNDEAD;
    }
}
