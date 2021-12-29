// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.Item;
import net.minecraft.entity.EnumCreatureAttribute;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import twilightforest.entity.ai.EntityAITFMagicAttack;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFSlimeBeetle extends EntityMob
{
    public EntityTFSlimeBeetle(final World world) {
        super(world);
        this.field_70750_az = "/mods/twilightforest/textures/model/slimebeetle.png";
        this.field_70697_bw = 0.23f;
        this.func_70105_a(0.9f, 1.75f);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 2.0f, 0.23f, 0.4f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITFMagicAttack((EntityLiving)this, this.field_70697_bw, 4, 30));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityLiving)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, true));
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public int func_70667_aM() {
        return 25;
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
        super.func_70636_d();
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public int func_82193_c(final Entity par1Entity) {
        return 4;
    }
    
    @SideOnly(Side.CLIENT)
    public float func_70053_R() {
        return 1.1f;
    }
    
    public float func_70047_e() {
        return 0.25f;
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    protected int func_70633_aT() {
        return Item.field_77761_aM.field_77779_bT;
    }
}
