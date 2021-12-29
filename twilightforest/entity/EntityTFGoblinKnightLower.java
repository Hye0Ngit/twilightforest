// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAITFRiderSpearAttack;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFGoblinKnightLower extends EntityMob
{
    private static final int DATA_EQUIP = 17;
    
    public EntityTFGoblinKnightLower(final World par1World) {
        super(par1World);
        this.field_70750_az = "/mods/twilightforest/textures/model/doublegoblin.png";
        this.field_70697_bw = 0.28f;
        this.func_70105_a(0.7f, 1.1f);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAITFRiderSpearAttack(this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityLiving)this, (Class)EntityPlayer.class, this.field_70697_bw, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityLiving)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, false));
        this.setHasArmor(true);
    }
    
    public int func_70667_aM() {
        return 20;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(17, (Object)0);
    }
    
    public boolean hasArmor() {
        return (this.field_70180_af.func_75683_a(17) & 0x1) > 0;
    }
    
    public void setHasArmor(final boolean flag) {
        byte otherFlags = this.field_70180_af.func_75683_a(17);
        otherFlags &= 0x7E;
        if (flag) {
            this.field_70180_af.func_75692_b(17, (Object)(byte)(otherFlags | 0x1));
        }
        else {
            this.field_70180_af.func_75692_b(17, (Object)otherFlags);
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("hasArmor", this.hasArmor());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setHasArmor(par1NBTTagCompound.func_74767_n("hasArmor"));
    }
    
    public void func_82163_bD() {
        final EntityTFGoblinKnightUpper upper = new EntityTFGoblinKnightUpper(this.field_70170_p);
        upper.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0f);
        upper.func_82163_bD();
        this.field_70170_p.func_72838_d((Entity)upper);
        upper.func_70078_a((Entity)this);
    }
    
    public double func_70042_X() {
        return 1.0;
    }
    
    public void func_70071_h_() {
        if (this.func_70089_S() && this.field_70153_n != null && this.field_70153_n instanceof EntityLiving && this.func_70638_az() == null) {
            this.func_70624_b(((EntityLiving)this.field_70153_n).func_70638_az());
        }
        super.func_70071_h_();
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityLiving) {
            return ((EntityLiving)this.field_70153_n).func_70652_k(par1Entity);
        }
        return super.func_70652_k(par1Entity);
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final int damageAmount) {
        Entity attacker = null;
        if (par1DamageSource.func_76364_f() != null) {
            attacker = par1DamageSource.func_76364_f();
        }
        if (par1DamageSource.func_76346_g() != null) {
            attacker = par1DamageSource.func_76346_g();
        }
        if (attacker != null) {
            final double dx = this.field_70165_t - attacker.field_70165_t;
            final double dz = this.field_70161_v - attacker.field_70161_v;
            final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
            final float difference = MathHelper.func_76135_e((this.field_70761_aq - angle) % 360.0f);
            EntityTFGoblinKnightUpper upper = null;
            if (this.field_70153_n != null && this.field_70153_n instanceof EntityTFGoblinKnightUpper) {
                upper = (EntityTFGoblinKnightUpper)this.field_70153_n;
            }
            if (upper != null && upper.hasShield() && difference > 150.0f && difference < 230.0f && upper.takeHitOnShield(par1DamageSource, damageAmount)) {
                return false;
            }
            if (this.hasArmor() && (difference > 300.0f || difference < 60.0f)) {
                this.breakArmor();
            }
        }
        final boolean attackSuccess = super.func_70097_a(par1DamageSource, damageAmount);
        return attackSuccess;
    }
    
    public void breakArmor() {
        this.func_70669_a(new ItemStack((Item)Item.field_77822_ae));
        this.func_70669_a(new ItemStack((Item)Item.field_77822_ae));
        this.func_70669_a(new ItemStack((Item)Item.field_77822_ae));
        this.setHasArmor(false);
    }
    
    public int func_70658_aO() {
        int armor = super.func_70658_aO();
        if (this.hasArmor()) {
            armor += 17;
        }
        if (armor > 20) {
            armor = 20;
        }
        return armor;
    }
    
    protected int func_70633_aT() {
        return TFItems.armorShard.field_77779_bT;
    }
}
