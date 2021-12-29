// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import twilightforest.entity.ai.EntityAITFMagicAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFDeathTome extends EntityMob
{
    public EntityTFDeathTome(final World par1World) {
        super(par1World);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFMagicAttack((EntityLiving)this, 1.0f, 2, 60));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    public int getAttackStrength(final Entity par1Entity) {
        return 4;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        for (int i = 0; i < 1; ++i) {
            this.field_70170_p.func_72869_a("enchantmenttable", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (this.field_70131_O - 0.75) + 0.5, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, 0.0, 0.5, 0.0);
        }
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, float par2) {
        if (par1DamageSource.func_76347_k()) {
            par2 *= 2.0f;
        }
        if (super.func_70097_a(par1DamageSource, par2)) {
            if (this.field_70146_Z.nextInt(2) == 0) {
                this.func_145778_a(Items.field_151121_aF, 1, 1.0f);
            }
            return true;
        }
        return false;
    }
    
    protected Item func_146068_u() {
        return Items.field_151121_aF;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int var3 = this.field_70146_Z.nextInt(3 + par2), var4 = 0; var4 < var3; ++var4) {
            this.func_145779_a(Items.field_151121_aF, 1);
        }
        if (this.field_70146_Z.nextInt(5) - par2 <= 0) {
            this.func_145779_a(Items.field_151099_bA, 1);
        }
        else {
            this.func_145779_a(Items.field_151122_aG, 1);
        }
    }
    
    protected void func_70600_l(final int par1) {
        this.func_145779_a(TFItems.magicMapFocus, 1);
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
}
