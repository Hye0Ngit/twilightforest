// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import twilightforest.item.TFItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAITFChargeAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFMinotaur extends EntityMob
{
    public EntityTFMinotaur(final World par1World) {
        super(par1World);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFChargeAttack((EntityCreature)this, 2.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, false));
        this.func_70062_b(0, new ItemStack(Item.field_77682_J));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(17, (Object)0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public boolean isCharging() {
        return this.field_70180_af.func_75683_a(17) != 0;
    }
    
    public void setCharging(final boolean flag) {
        if (flag) {
            this.field_70180_af.func_75692_b(17, (Object)127);
        }
        else {
            this.field_70180_af.func_75692_b(17, (Object)0);
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final boolean success = super.func_70652_k(par1Entity);
        if (success && this.isCharging()) {
            par1Entity.field_70181_x += 0.4000000059604645;
            this.field_70170_p.func_72956_a((Entity)this, "mob.irongolem.throw", 1.0f, 1.0f);
        }
        return success;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isCharging()) {
            this.field_70721_aZ += (float)0.6;
        }
    }
    
    protected String func_70639_aQ() {
        return "mob.cow.say";
    }
    
    protected String func_70621_aR() {
        return "mob.cow.hurt";
    }
    
    protected String func_70673_aS() {
        return "mob.cow.hurt";
    }
    
    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
        this.field_70170_p.func_72956_a((Entity)this, "mob.cow.step", 0.15f, 0.8f);
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.7f;
    }
    
    protected int func_70633_aT() {
        return TFItems.meefRaw.field_77779_bT;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int numDrops = this.field_70146_Z.nextInt(2) + this.field_70146_Z.nextInt(1 + par2), i = 0; i < numDrops; ++i) {
            if (this.func_70027_ad()) {
                this.func_70025_b(TFItems.meefSteak.field_77779_bT, 1);
            }
            else {
                this.func_70025_b(TFItems.meefRaw.field_77779_bT, 1);
            }
        }
    }
    
    protected void func_70600_l(final int par1) {
        this.func_70025_b(TFItems.mazeMapFocus.field_77779_bT, 1);
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
}
