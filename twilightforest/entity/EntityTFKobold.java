// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import twilightforest.entity.ai.EntityAITFFlockToSameKind;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAITFPanicOnFlockDeath;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFKobold extends EntityMob
{
    private boolean shy;
    
    public EntityTFKobold(final World world) {
        super(world);
        this.field_70750_az = "/mods/twilightforest/textures/model/kobold.png";
        this.field_70697_bw = 0.28f;
        this.func_70105_a(0.8f, 1.1f);
        this.shy = true;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFPanicOnFlockDeath((EntityCreature)this, 0.38f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.28f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityLiving)this, (Class)EntityPlayer.class, this.field_70697_bw, false));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFFlockToSameKind((EntityLiving)this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityLiving)this, true));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, true));
    }
    
    public EntityTFKobold(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(17, (Object)0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public int func_70667_aM() {
        return 13;
    }
    
    protected String func_70639_aQ() {
        return "mob.tf.kobold.kobold";
    }
    
    protected String func_70621_aR() {
        return "mob.tf.kobold.hurt";
    }
    
    protected String func_70673_aS() {
        return "mob.tf.kobold.die";
    }
    
    protected int func_70633_aT() {
        return Item.field_77685_T.field_77779_bT;
    }
    
    protected void func_70628_a(final boolean flag, final int i) {
        super.func_70628_a(flag, i);
        if (this.field_70146_Z.nextInt(2) == 0) {
            this.func_70025_b(Item.field_77733_bq.field_77779_bT, 1 + i);
        }
    }
    
    public boolean isShy() {
        return this.shy && this.field_70718_bc <= 0;
    }
    
    public boolean isPanicked() {
        return this.field_70180_af.func_75683_a(17) != 0;
    }
    
    public void setPanicked(final boolean flag) {
        if (flag) {
            this.field_70180_af.func_75692_b(17, (Object)127);
        }
        else {
            this.field_70180_af.func_75692_b(17, (Object)0);
        }
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isPanicked()) {
            for (int i = 0; i < 2; ++i) {
                this.field_70170_p.func_72869_a("splash", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 0.5, this.field_70163_u + this.func_70047_e(), this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 0.5, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    public int func_82193_c(final Entity par1Entity) {
        return 3;
    }
}
