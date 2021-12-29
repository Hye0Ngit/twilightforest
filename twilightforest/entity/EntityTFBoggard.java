// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.ai.EntityAITFChargeAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFBoggard extends EntityMob
{
    private boolean shy;
    
    public EntityTFBoggard(final World world) {
        super(world);
        this.field_70750_az = "/mob/pigzombie.png";
        this.field_70697_bw = 0.28f;
        this.func_70105_a(0.8f, 1.1f);
        this.shy = true;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFChargeAttack((EntityLiving)this, 0.55f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityLiving)this, (Class)EntityPlayer.class, this.field_70697_bw, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityLiving)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, false));
    }
    
    public EntityTFBoggard(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public int func_70667_aM() {
        return 14;
    }
    
    protected String func_70639_aQ() {
        return "mob.tf.redcap.redcap";
    }
    
    protected String func_70621_aR() {
        return "mob.tf.redcap.hurt";
    }
    
    protected String func_70673_aS() {
        return "mob.tf.redcap.die";
    }
    
    protected int func_70633_aT() {
        return Item.field_77818_ag.field_77779_bT;
    }
    
    protected void func_70628_a(final boolean flag, final int i) {
        if (this.field_70146_Z.nextInt(5) == 0) {
            this.func_70025_b(TFItems.mazeMapFocus.field_77779_bT, 1 + i);
        }
        if (this.field_70146_Z.nextInt(6) == 0) {
            this.func_70025_b(Item.field_77818_ag.field_77779_bT, 1 + i);
        }
        if (this.field_70146_Z.nextInt(9) == 0) {
            this.func_70025_b(Item.field_77696_g.field_77779_bT, 1 + i);
        }
    }
    
    public boolean isShy() {
        return this.shy && this.field_70718_bc <= 0;
    }
    
    public boolean isTargetLookingAtMe() {
        final double dx = this.field_70165_t - this.field_70789_a.field_70165_t;
        final double dz = this.field_70161_v - this.field_70789_a.field_70161_v;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = MathHelper.func_76135_e((this.field_70789_a.field_70177_z - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
            final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
            final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.hill1) {
                ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHill1);
            }
        }
    }
    
    public void func_70612_e(final float par1, final float par2) {
        super.func_70612_e(par1, par2);
    }
}
