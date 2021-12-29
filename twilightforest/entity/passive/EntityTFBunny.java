// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.EntityCreature;

public class EntityTFBunny extends EntityCreature implements IAnimals
{
    public EntityTFBunny(final World par1World) {
        super(par1World);
        this.field_70750_az = "/mods/twilightforest/textures/model/bunnydutch.png";
        this.func_70105_a(0.3f, 0.7f);
        this.field_70138_W = 1.0f;
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 0.38f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 0.18f, Item.field_77690_S.field_77779_bT, true));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 2.0f, 0.23f, 0.4f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.25f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.38f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.setBunnyType(this.field_70146_Z.nextInt(4));
    }
    
    public int func_70667_aM() {
        return 1;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (Object)0);
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public String func_70073_O() {
        switch (this.getBunnyType()) {
            case 0: {
                return "/mods/twilightforest/textures/model/bunnydutch.png";
            }
            case 1: {
                return "/mods/twilightforest/textures/model/bunnydutch.png";
            }
            case 2: {
                return "/mods/twilightforest/textures/model/bunnywhite.png";
            }
            case 3: {
                return "/mods/twilightforest/textures/model/bunnybrown.png";
            }
            default: {
                return super.func_70073_O();
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("BunnyType", this.getBunnyType());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setBunnyType(par1NBTTagCompound.func_74762_e("BunnyType"));
    }
    
    public int getBunnyType() {
        return this.field_70180_af.func_75683_a(16);
    }
    
    public void setBunnyType(final int par1) {
        this.field_70180_af.func_75692_b(16, (Object)(byte)par1);
    }
    
    public float func_70603_bj() {
        return 0.3f;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public float func_70783_a(final int par1, final int par2, final int par3) {
        final Material underMaterial = this.field_70170_p.func_72803_f(par1, par2 - 1, par3);
        if (underMaterial == Material.field_76257_i) {
            return -1.0f;
        }
        if (underMaterial == Material.field_76245_d) {
            return -1.0f;
        }
        if (underMaterial == Material.field_76247_b) {
            return 10.0f;
        }
        return this.field_70170_p.func_72801_o(par1, par2, par3) - 0.5f;
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
}
