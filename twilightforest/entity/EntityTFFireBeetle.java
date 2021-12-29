// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.Vec3;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.ai.EntityAITFBreathAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFFireBeetle extends EntityMob implements IBreathAttacker
{
    public static final int BREATH_DURATION = 10;
    public static final int BREATH_DAMAGE = 2;
    
    public EntityTFFireBeetle(final World world) {
        super(world);
        this.func_70105_a(1.1f, 0.75f);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFBreathAttack((EntityLiving)this, 1.0f, 5.0f, 30, 0.1f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    public EntityTFFireBeetle(final World world, final double x, final double y, final double z) {
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
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(25.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0);
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
    
    protected void func_145780_a(final int var1, final int var2, final int var3, final Block var4) {
        this.field_70170_p.func_72956_a((Entity)this, "mob.spider.step", 0.15f, 1.0f);
    }
    
    protected Item func_146068_u() {
        return Items.field_151016_H;
    }
    
    public boolean isBreathing() {
        return this.field_70180_af.func_75683_a(17) != 0;
    }
    
    public void setBreathing(final boolean flag) {
        if (flag) {
            this.field_70180_af.func_75692_b(17, (Object)127);
        }
        else {
            this.field_70180_af.func_75692_b(17, (Object)0);
        }
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isBreathing()) {
            final Vec3 look = this.func_70040_Z();
            final double dist = 0.9;
            final double px = this.field_70165_t + look.field_72450_a * dist;
            final double py = this.field_70163_u + 0.25 + look.field_72448_b * dist;
            final double pz = this.field_70161_v + look.field_72449_c * dist;
            for (int i = 0; i < 2; ++i) {
                double dx = look.field_72450_a;
                double dy = look.field_72448_b;
                double dz = look.field_72449_c;
                final double spread = 5.0 + this.func_70681_au().nextDouble() * 2.5;
                final double velocity = 0.15 + this.func_70681_au().nextDouble() * 0.15;
                dx += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dy += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dz += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                this.field_70170_p.func_72869_a(this.getFlameParticle(), px, py, pz, dx, dy, dz);
            }
            this.playBreathSound();
        }
    }
    
    public String getFlameParticle() {
        return "flame";
    }
    
    public void playBreathSound() {
        this.field_70170_p.func_72908_a(this.field_70165_t + 0.5, this.field_70163_u + 0.5, this.field_70161_v + 0.5, "mob.ghast.fireball", this.field_70146_Z.nextFloat() * 0.5f, this.field_70146_Z.nextFloat() * 0.5f);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_70070_b(final float par1) {
        if (this.isBreathing()) {
            return 15728880;
        }
        return super.func_70070_b(par1);
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public int func_70646_bf() {
        return 500;
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
    
    public void doBreathAttack(final Entity target) {
        if (!target.func_70045_F() && target.func_70097_a(DamageSource.field_76372_a, 2.0f)) {
            target.func_70015_d(10);
        }
    }
}
