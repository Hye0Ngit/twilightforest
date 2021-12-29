// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
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
import twilightforest.entity.ai.EntityAITFHeavySpearAttack;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFGoblinKnightUpper extends EntityMob
{
    private static final int SHIELD_DAMAGE_THRESHOLD = 10;
    private static final int DATA_EQUIP = 17;
    public int shieldHits;
    public int heavySpearTimer;
    
    public EntityTFGoblinKnightUpper(final World par1World) {
        super(par1World);
        this.field_70750_az = "/mods/twilightforest/textures/model/doublegoblin.png";
        this.field_70697_bw = 0.28f;
        this.func_70105_a(1.1f, 1.3f);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAITFHeavySpearAttack(this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityLiving)this, (Class)EntityPlayer.class, this.field_70697_bw, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityLiving)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, false));
        this.setHasArmor(true);
        this.setHasShield(true);
        this.shieldHits = 0;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public int func_70667_aM() {
        return 30;
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
    
    public boolean hasShield() {
        return (this.field_70180_af.func_75683_a(17) & 0x2) > 0;
    }
    
    public void setHasShield(final boolean flag) {
        byte otherFlags = this.field_70180_af.func_75683_a(17);
        otherFlags &= 0x7D;
        if (flag) {
            this.field_70180_af.func_75692_b(17, (Object)(byte)(otherFlags | 0x2));
        }
        else {
            this.field_70180_af.func_75692_b(17, (Object)otherFlags);
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("hasArmor", this.hasArmor());
        par1NBTTagCompound.func_74757_a("hasShield", this.hasShield());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setHasArmor(par1NBTTagCompound.func_74767_n("hasArmor"));
        this.setHasShield(par1NBTTagCompound.func_74767_n("hasShield"));
    }
    
    public void func_70071_h_() {
        if (this.func_70089_S()) {
            if (this.field_70154_o != null && this.field_70154_o instanceof EntityLiving && this.func_70638_az() == null) {
                this.func_70624_b(((EntityLiving)this.field_70154_o).func_70638_az());
            }
            if (this.heavySpearTimer > 0) {
                --this.heavySpearTimer;
                if (this.heavySpearTimer == 25) {
                    this.landHeavySpearAttack();
                }
            }
            if (this.field_70154_o == null && this.hasShield()) {
                this.breakShield();
            }
        }
        super.func_70071_h_();
    }
    
    private void landHeavySpearAttack() {
        final Vec3 vector = this.func_70040_Z();
        final double dist = 1.25;
        final double px = this.field_70165_t + vector.field_72450_a * dist;
        final double py = this.field_70121_D.field_72338_b - 0.75;
        final double pz = this.field_70161_v + vector.field_72449_c * dist;
        for (int i = 0; i < 50; ++i) {
            this.field_70170_p.func_72869_a("largesmoke", px, py, pz, (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.25f), 0.0, (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.25f));
        }
        final double radius = 1.5;
        final AxisAlignedBB spearBB = AxisAlignedBB.func_72332_a().func_72299_a(px - radius, py - radius, pz - radius, px + radius, py + radius, pz + radius);
        final List inBox = this.field_70170_p.func_72872_a((Class)Entity.class, spearBB);
        for (final Entity entity : inBox) {
            if (this.field_70154_o != null && entity != this.field_70154_o && entity != this) {
                super.func_70652_k(entity);
            }
        }
    }
    
    public int func_82193_c(final Entity par1Entity) {
        if (this.heavySpearTimer > 0) {
            return 20;
        }
        return 8;
    }
    
    public void func_70098_U() {
        super.func_70098_U();
        if (this.field_70154_o != null) {
            this.field_70761_aq = ((EntityLiving)this.field_70154_o).field_70761_aq;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte par1) {
        if (par1 == 4) {
            this.heavySpearTimer = 60;
        }
        else {
            super.func_70103_a(par1);
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (this.heavySpearTimer > 0) {
            return false;
        }
        if (this.field_70146_Z.nextInt(2) == 0) {
            this.startHeavySpearAttack();
            return false;
        }
        this.func_71038_i();
        return super.func_70652_k(par1Entity);
    }
    
    private void startHeavySpearAttack() {
        this.heavySpearTimer = 60;
        this.field_70170_p.func_72960_a((Entity)this, (byte)4);
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final int damageAmount) {
        if (par1DamageSource == DamageSource.field_76368_d && this.field_70154_o != null) {
            return false;
        }
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
            if (this.hasShield() && difference > 150.0f && difference < 230.0f) {
                if (this.takeHitOnShield(par1DamageSource, damageAmount)) {
                    return false;
                }
            }
            else if (this.hasShield() && this.field_70146_Z.nextBoolean()) {
                this.damageShield();
            }
            if (this.hasArmor() && (difference > 300.0f || difference < 60.0f)) {
                this.breakArmor();
            }
        }
        final boolean attackSuccess = super.func_70097_a(par1DamageSource, damageAmount);
        if (attackSuccess && this.field_70154_o != null && this.field_70154_o instanceof EntityLiving && attacker != null) {
            ((EntityLiving)this.field_70154_o).func_70653_a(attacker, damageAmount, 0.1, 0.1);
        }
        return attackSuccess;
    }
    
    public void breakArmor() {
        this.func_70669_a(new ItemStack((Item)Item.field_77822_ae));
        this.func_70669_a(new ItemStack((Item)Item.field_77822_ae));
        this.func_70669_a(new ItemStack((Item)Item.field_77822_ae));
        this.setHasArmor(false);
    }
    
    public void breakShield() {
        this.func_70669_a(new ItemStack((Item)Item.field_77822_ae));
        this.func_70669_a(new ItemStack((Item)Item.field_77822_ae));
        this.func_70669_a(new ItemStack((Item)Item.field_77822_ae));
        this.setHasShield(false);
    }
    
    public boolean takeHitOnShield(final DamageSource par1DamageSource, final int damageAmount) {
        if (damageAmount > 10 && !this.field_70170_p.field_72995_K) {
            this.damageShield();
        }
        else {
            this.field_70170_p.func_72956_a((Entity)this, "random.break", 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        }
        final EntityLiving toKnockback = (EntityLiving)((this.field_70154_o != null && this.field_70154_o instanceof EntityLiving) ? ((EntityLiving)this.field_70154_o) : this);
        if (par1DamageSource.func_76346_g() != null) {
            double d0;
            double d2;
            for (d0 = par1DamageSource.func_76346_g().field_70165_t - this.field_70165_t, d2 = par1DamageSource.func_76346_g().field_70161_v - this.field_70161_v; d0 * d0 + d2 * d2 < 1.0E-4; d0 = (Math.random() - Math.random()) * 0.01, d2 = (Math.random() - Math.random()) * 0.01) {}
            toKnockback.func_70653_a(par1DamageSource.func_76346_g(), 0, d0 / 4.0, d2 / 4.0);
            if (par1DamageSource.func_76346_g() instanceof EntityLiving) {
                this.func_70604_c((EntityLiving)par1DamageSource.func_76346_g());
            }
        }
        return true;
    }
    
    private void damageShield() {
        this.field_70170_p.func_72956_a((Entity)this, "mob.zombie.metal", 0.25f, 0.25f);
        ++this.shieldHits;
        if (!this.field_70170_p.field_72995_K && this.shieldHits >= 3) {
            this.breakShield();
        }
    }
    
    public int func_70658_aO() {
        int armor = super.func_70658_aO();
        if (this.hasArmor()) {
            armor += 20;
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
