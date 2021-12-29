// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.potion.Potion;
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
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityTameable;

public class EntityTFLoyalZombie extends EntityTameable
{
    public EntityTFLoyalZombie(final World par1World) {
        super(par1World);
        this.func_70105_a(0.6f, 1.8f);
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.4f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0, true));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIFollowOwner((EntityTameable)this, 1.0, 10.0f, 2.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIOwnerHurtByTarget((EntityTameable)this));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIOwnerHurtTarget((EntityTameable)this));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.field_70715_bh.func_75776_a(4, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityMob.class, 0, true));
    }
    
    public EntityAnimal createChild(final EntityAgeable entityanimal) {
        return null;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final int attackpower = 7;
        final boolean success = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), (float)attackpower);
        if (success) {
            par1Entity.field_70181_x += 0.2000000059604645;
        }
        return success;
    }
    
    public void func_70636_d() {
        if (!this.field_70170_p.field_72995_K && this.func_70660_b(Potion.field_76420_g) == null) {
            this.func_70015_d(100);
        }
        super.func_70636_d();
    }
    
    protected boolean func_70692_ba() {
        return !this.func_70909_n();
    }
    
    public int func_70658_aO() {
        return 3;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected String func_70639_aQ() {
        return "mob.zombie.say";
    }
    
    protected String func_70621_aR() {
        return "mob.zombie.hurt";
    }
    
    protected String func_70673_aS() {
        return "mob.zombie.death";
    }
    
    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
        this.field_70170_p.func_72956_a((Entity)this, "mob.zombie.step", 0.15f, 1.0f);
    }
    
    protected int func_70633_aT() {
        return 0;
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.UNDEAD;
    }
}
