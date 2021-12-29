// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Items;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFSnowGuardian extends EntityMob
{
    public EntityTFSnowGuardian(final World par1World) {
        super(par1World);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.func_70105_a(0.6f, 1.8f);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected String func_70639_aQ() {
        return "TwilightForest:mob.ice.noise";
    }
    
    protected String func_70621_aR() {
        return "TwilightForest:mob.ice.hurt";
    }
    
    protected String func_70673_aS() {
        return "TwilightForest:mob.ice.death";
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.8f;
    }
    
    protected void func_82164_bB() {
        final int type = this.field_70146_Z.nextInt(4);
        this.func_70062_b(0, new ItemStack(this.makeItemForSlot(0, type)));
        this.func_70062_b(3, new ItemStack(this.makeItemForSlot(3, type)));
        this.func_70062_b(4, new ItemStack(this.makeItemForSlot(4, type)));
    }
    
    protected Item makeItemForSlot(final int slot, final int type) {
        switch (slot) {
            default: {
                switch (type) {
                    default: {
                        return TFItems.ironwoodSword;
                    }
                    case 1: {
                        return TFItems.steeleafSword;
                    }
                    case 2: {
                        return TFItems.knightlySword;
                    }
                    case 3: {
                        return TFItems.knightlySword;
                    }
                }
                break;
            }
            case 1: {
                switch (type) {
                    default: {
                        return TFItems.ironwoodBoots;
                    }
                    case 1: {
                        return TFItems.steeleafBoots;
                    }
                    case 2: {
                        return TFItems.knightlyBoots;
                    }
                    case 3: {
                        return TFItems.arcticBoots;
                    }
                }
                break;
            }
            case 2: {
                switch (type) {
                    default: {
                        return TFItems.ironwoodLegs;
                    }
                    case 1: {
                        return TFItems.steeleafLegs;
                    }
                    case 2: {
                        return TFItems.knightlyLegs;
                    }
                    case 3: {
                        return TFItems.arcticLegs;
                    }
                }
                break;
            }
            case 3: {
                switch (type) {
                    default: {
                        return TFItems.ironwoodPlate;
                    }
                    case 1: {
                        return TFItems.steeleafPlate;
                    }
                    case 2: {
                        return TFItems.knightlyPlate;
                    }
                    case 3: {
                        return TFItems.arcticPlate;
                    }
                }
                break;
            }
            case 4: {
                switch (type) {
                    default: {
                        return TFItems.ironwoodHelm;
                    }
                    case 1: {
                        return TFItems.steeleafHelm;
                    }
                    case 2: {
                        return TFItems.knightlyHelm;
                    }
                    case 3: {
                        return TFItems.arcticHelm;
                    }
                }
                break;
            }
        }
    }
    
    protected Item func_146068_u() {
        return Items.field_151126_ay;
    }
    
    protected void func_82162_bC() {
        super.func_82162_bC();
    }
    
    public IEntityLivingData func_110161_a(final IEntityLivingData par1EntityLivingData) {
        final IEntityLivingData data = super.func_110161_a(par1EntityLivingData);
        this.func_82164_bB();
        return data;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        for (int i = 0; i < 3; ++i) {
            final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            final float py = this.func_70047_e() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
            final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowguardian", this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
        }
    }
    
    public int func_70641_bl() {
        return 8;
    }
}
