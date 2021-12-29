// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.ai.EntityAITFChargeAttack;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAITFKidnapRider;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFPinchBeetle extends EntityMob
{
    public EntityTFPinchBeetle(final World world) {
        super(world);
        this.field_70750_az = "/mods/twilightforest/textures/model/pinchbeetle.png";
        this.field_70697_bw = 0.23f;
        this.func_70105_a(1.2f, 1.1f);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFKidnapRider((EntityCreature)this, 0.4f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFChargeAttack((EntityLiving)this, 0.4f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityLiving)this, (Class)EntityPlayer.class, this.field_70697_bw, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityLiving)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, true));
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public int func_70667_aM() {
        return 40;
    }
    
    public int func_70658_aO() {
        int var1 = super.func_70658_aO() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "mob.spider.say";
    }
    
    protected String func_70673_aS() {
        return "mob.spider.death";
    }
    
    protected void func_70036_a(final int var1, final int var2, final int var3, final int var4) {
        this.field_70170_p.func_72956_a((Entity)this, "mob.spider.step", 0.15f, 1.0f);
    }
    
    public void func_70636_d() {
        if (this.field_70153_n != null) {
            this.func_70105_a(1.9f, 2.0f);
        }
        else {
            this.func_70105_a(1.2f, 1.1f);
        }
        super.func_70636_d();
        if (this.field_70153_n != null) {
            this.func_70671_ap().func_75651_a(this.field_70153_n, 100.0f, 100.0f);
            final Vec3 riderPos = this.getRiderPosition();
            this.func_70048_i(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
        }
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public int func_82193_c(final Entity par1Entity) {
        return 8;
    }
    
    @SideOnly(Side.CLIENT)
    public float func_70053_R() {
        return 1.1f;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (this.field_70153_n == null && par1Entity.field_70154_o == null) {
            par1Entity.func_70078_a((Entity)this);
        }
        return super.func_70652_k(par1Entity);
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        return super.func_70085_c(par1EntityPlayer);
    }
    
    public float func_70047_e() {
        return 0.25f;
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    public void func_70043_V() {
        if (this.field_70153_n != null) {
            final Vec3 riderPos = this.getRiderPosition();
            this.field_70153_n.func_70107_b(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
        }
    }
    
    public double func_70042_X() {
        return 0.75;
    }
    
    public Vec3 getRiderPosition() {
        if (this.field_70153_n != null) {
            final float distance = 0.9f;
            final double var1 = Math.cos((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double var2 = Math.sin((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + var1, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + var2);
        }
        return this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
}
