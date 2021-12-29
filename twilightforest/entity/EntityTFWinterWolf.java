// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.biomes.TFBiomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.Vec3d;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import twilightforest.entity.ai.EntityAITFBreathAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;

public class EntityTFWinterWolf extends EntityTFHostileWolf implements IBreathAttacker
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Boolean> BREATH_FLAG;
    private static final float BREATH_DAMAGE = 2.0f;
    
    public EntityTFWinterWolf(final World world) {
        super(world);
        this.func_70105_a(1.4f, 1.9f);
        this.func_175547_a(EnumDyeColor.LIGHT_BLUE);
    }
    
    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFBreathAttack<Object>(this, 1.0f, 5.0f, 30, 0.1f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    @Override
    protected void setAttributes() {
        super.setAttributes();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFWinterWolf.BREATH_FLAG, (Object)false);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isBreathing()) {
            if (this.field_70170_p.field_72995_K) {
                this.spawnBreathParticles();
            }
            this.playBreathSound();
        }
    }
    
    private void spawnBreathParticles() {
        final Vec3d look = this.func_70040_Z();
        final double dist = 0.5;
        final double px = this.field_70165_t + look.field_72450_a * 0.5;
        final double py = this.field_70163_u + 1.25 + look.field_72448_b * 0.5;
        final double pz = this.field_70161_v + look.field_72449_c * 0.5;
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
            TwilightForestMod.proxy.spawnParticle(TFParticleType.SNOW, px, py, pz, dx, dy, dz);
        }
    }
    
    private void playBreathSound() {
        this.func_184185_a(SoundEvents.field_187557_bK, this.field_70146_Z.nextFloat() * 0.5f, this.field_70146_Z.nextFloat() * 0.5f);
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.6f;
    }
    
    @Override
    public boolean isBreathing() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFWinterWolf.BREATH_FLAG);
    }
    
    @Override
    public void setBreathing(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFWinterWolf.BREATH_FLAG, (Object)flag);
    }
    
    @Override
    public void doBreathAttack(final Entity target) {
        target.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 2.0f);
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return this.field_70170_p.func_180494_b(new BlockPos((Entity)this)) == TFBiomes.snowy_forest || super.isValidLightLevel();
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFWinterWolf.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/winter_wolf");
        BREATH_FLAG = EntityDataManager.func_187226_a((Class)EntityTFWinterWolf.class, DataSerializers.field_187198_h);
    }
}
