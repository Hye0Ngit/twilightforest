// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntitySpider;

public class EntityTFKingSpider extends EntitySpider
{
    public EntityTFKingSpider(final World world) {
        super(world);
        this.func_70105_a(1.6f, 1.6f);
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.3f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.20000000298023224));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
    }
    
    protected Entity func_70782_k() {
        final double var2 = 16.0;
        return (Entity)this.field_70170_p.func_72856_b((Entity)this, var2);
    }
    
    public float spiderScaleAmount() {
        return 1.9f;
    }
    
    public float func_70603_bj() {
        return 2.0f;
    }
    
    public boolean func_70617_f_() {
        return false;
    }
    
    public EntityLivingData func_110161_a(final EntityLivingData par1EntityLivingData) {
        final Object par1EntityLivingData2 = super.func_110161_a(par1EntityLivingData);
        final EntityTFSkeletonDruid druid = new EntityTFSkeletonDruid(this.field_70170_p);
        druid.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0f);
        druid.func_110161_a((EntityLivingData)null);
        this.field_70170_p.func_72838_d((Entity)druid);
        druid.func_70078_a((Entity)this);
        return (EntityLivingData)par1EntityLivingData2;
    }
    
    public double func_70042_X() {
        return this.field_70131_O * 0.5;
    }
}
