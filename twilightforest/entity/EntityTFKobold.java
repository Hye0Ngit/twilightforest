// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import twilightforest.entity.ai.EntityAITFFlockToSameKind;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAITFPanicOnFlockDeath;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFKobold extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Boolean> PANICKED;
    
    public EntityTFKobold(final World world) {
        super(world);
        this.func_70105_a(0.8f, 1.1f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFPanicOnFlockDeath((EntityCreature)this, 2.0f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.3f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFFlockToSameKind((EntityLiving)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFKobold.PANICKED, (Object)false);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(13.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.KOBOLD_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.KOBOLD_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.KOBOLD_DEATH;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFKobold.LOOT_TABLE;
    }
    
    public boolean isPanicked() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFKobold.PANICKED);
    }
    
    public void setPanicked(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFKobold.PANICKED, (Object)flag);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K && this.isPanicked()) {
            for (int i = 0; i < 2; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.WATER_SPLASH, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 0.5, this.field_70163_u + this.func_70047_e(), this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 0.5, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/kobold");
        PANICKED = EntityDataManager.func_187226_a((Class)EntityTFKobold.class, DataSerializers.field_187198_h);
    }
}
