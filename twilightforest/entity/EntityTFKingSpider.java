// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntitySpider;

public class EntityTFKingSpider extends EntitySpider
{
    public EntityTFKingSpider(final World world) {
        super(world);
        this.field_70750_az = "/mods/twilightforest/textures/model/kingspider.png";
        this.func_70105_a(1.6f, 1.6f);
        this.field_70697_bw = 0.35f;
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityLiving)this, (Class)EntityPlayer.class, this.field_70697_bw, false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, this.field_70697_bw));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.2f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIHurtByTarget((EntityLiving)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, true));
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected Entity func_70782_k() {
        final double var2 = 16.0;
        return (Entity)this.field_70170_p.func_72856_b((Entity)this, var2);
    }
    
    public float func_70840_n() {
        return 1.9f;
    }
    
    public float func_70603_bj() {
        return 2.0f;
    }
    
    public int func_70667_aM() {
        return 30;
    }
    
    public int func_82193_c(final Entity par1Entity) {
        return 6;
    }
    
    public boolean func_70617_f_() {
        return false;
    }
    
    public void func_82163_bD() {
        final EntityTFSkeletonDruid druid = new EntityTFSkeletonDruid(this.field_70170_p);
        druid.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0f);
        druid.func_82163_bD();
        this.field_70170_p.func_72838_d((Entity)druid);
        druid.func_70078_a((Entity)this);
    }
}
