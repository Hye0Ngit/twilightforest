// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.entity.Entity;
import twilightforest.TFFeature;
import net.minecraft.util.MathHelper;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityWolf;

public class EntityTFHostileWolf extends EntityWolf implements IMob
{
    public EntityTFHostileWolf(final World world) {
        super(world);
        this.func_70916_h(true);
        this.field_70715_bh.func_75776_a(4, (EntityAIBase)new EntityAINearestAttackableTarget((EntityLiving)this, (Class)EntityPlayer.class, 16.0f, 0, true));
    }
    
    public EntityTFHostileWolf(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    public int func_70667_aM() {
        return 10;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public boolean func_70601_bi() {
        final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
        final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
        if (TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.hedgeMaze) {
            return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).size() == 0 && !this.field_70170_p.func_72953_d(this.field_70121_D);
        }
        return this.isValidMobLightLevel() && this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).size() == 0 && !this.field_70170_p.func_72953_d(this.field_70121_D);
    }
    
    protected boolean isValidMobLightLevel() {
        final int var1 = MathHelper.func_76128_c(this.field_70165_t);
        final int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
        final int var3 = MathHelper.func_76128_c(this.field_70161_v);
        if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, var1, var2, var3) > this.field_70146_Z.nextInt(32)) {
            return false;
        }
        int var4 = this.field_70170_p.func_72957_l(var1, var2, var3);
        if (this.field_70170_p.func_72911_I()) {
            final int var5 = this.field_70170_p.field_73008_k;
            this.field_70170_p.field_73008_k = 10;
            var4 = this.field_70170_p.func_72957_l(var1, var2, var3);
            this.field_70170_p.field_73008_k = var5;
        }
        return var4 <= this.field_70146_Z.nextInt(8);
    }
    
    public boolean func_70877_b(final ItemStack par1ItemStack) {
        return false;
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        return false;
    }
}
