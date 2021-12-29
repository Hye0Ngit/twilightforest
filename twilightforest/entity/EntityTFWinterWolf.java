// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
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

public class EntityTFWinterWolf extends EntityTFHostileWolf implements IBreathAttacker
{
    private static final int BREATH_FLAG = 21;
    public static final int BREATH_DURATION = 10;
    public static final int BREATH_DAMAGE = 2;
    
    public EntityTFWinterWolf(final World world) {
        super(world);
        this.func_70105_a(1.4f, 1.9f);
        this.field_70714_bg.field_75782_a.clear();
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFBreathAttack((EntityLiving)this, 1.0f, 5.0f, 30, 0.1f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70715_bh.field_75782_a.clear();
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(21, (Object)0);
    }
    
    public int getAttackStrength(final Entity par1Entity) {
        return 6;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final int damage = this.getAttackStrength(par1Entity);
        return par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), (float)damage);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isBreathing()) {
            final Vec3 look = this.func_70040_Z();
            final double dist = 0.5;
            final double px = this.field_70165_t + look.field_72450_a * dist;
            final double py = this.field_70163_u + 1.25 + look.field_72448_b * dist;
            final double pz = this.field_70161_v + look.field_72449_c * dist;
            for (int i = 0; i < 10; ++i) {
                double dx = look.field_72450_a;
                double dy = look.field_72448_b;
                double dz = look.field_72449_c;
                final double spread = 5.0 + this.func_70681_au().nextDouble() * 2.5;
                final double velocity = 3.0 + this.func_70681_au().nextDouble() * 0.15;
                dx += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dy += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dz += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowstuff", px, py, pz, dx, dy, dz);
            }
            this.playBreathSound();
        }
    }
    
    public void playBreathSound() {
        this.field_70170_p.func_72908_a(this.field_70165_t + 0.5, this.field_70163_u + 0.5, this.field_70161_v + 0.5, "mob.ghast.fireball", this.field_70146_Z.nextFloat() * 0.5f, this.field_70146_Z.nextFloat() * 0.5f);
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.6f;
    }
    
    @Override
    public boolean isBreathing() {
        return this.func_70096_w().func_75683_a(21) == 1;
    }
    
    @Override
    public void setBreathing(final boolean flag) {
        this.func_70096_w().func_75692_b(21, (Object)(byte)(flag ? 1 : 0));
    }
    
    @Override
    public void doBreathAttack(final Entity target) {
    }
    
    @Override
    protected boolean isValidLightLevel() {
        final int x = MathHelper.func_76128_c(this.field_70165_t);
        final int z = MathHelper.func_76128_c(this.field_70161_v);
        return this.field_70170_p.func_72807_a(x, z) == TFBiomeBase.tfSnow || super.isValidLightLevel();
    }
    
    protected Item func_146068_u() {
        return TFItems.arcticFur;
    }
}
