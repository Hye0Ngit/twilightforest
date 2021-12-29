// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.util.SoundEvent;
import twilightforest.biomes.TFBiomes;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import twilightforest.TFSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAITFThrowRider;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFYeti extends EntityMob implements IHostileMount
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Boolean> ANGER_FLAG;
    private static final AttributeModifier ANGRY_MODIFIER;
    
    public EntityTFYeti(final World world) {
        super(world);
        this.func_70105_a(1.4f, 2.4f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFThrowRider(this, 1.0, false) {
            @Override
            protected void func_190102_a(final EntityLivingBase p_190102_1_, final double p_190102_2_) {
                super.func_190102_a(p_190102_1_, p_190102_2_);
                if (!EntityTFYeti.this.func_184188_bt().isEmpty()) {
                    EntityTFYeti.this.func_184185_a(TFSounds.ALPHAYETI_GRAB, 1.0f, 1.25f + EntityTFYeti.this.func_70681_au().nextFloat() * 0.5f);
                }
            }
            
            @Override
            public void func_75251_c() {
                if (!EntityTFYeti.this.func_184188_bt().isEmpty()) {
                    EntityTFYeti.this.func_184185_a(TFSounds.ALPHAYETI_THROW, 1.0f, 1.25f + EntityTFYeti.this.func_70681_au().nextFloat() * 0.5f);
                }
                super.func_75251_c();
            }
        });
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.38);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(4.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFYeti.ANGER_FLAG, (Object)false);
    }
    
    public void func_70636_d() {
        if (!this.func_184188_bt().isEmpty() && this.func_184188_bt().get(0).func_70093_af()) {
            this.func_184188_bt().get(0).func_70095_a(false);
        }
        super.func_70636_d();
        if (!this.func_184188_bt().isEmpty()) {
            this.func_70671_ap().func_75651_a((Entity)this.func_184188_bt().get(0), 100.0f, 100.0f);
            final Vec3d riderPos = this.getRiderPosition(this.func_184188_bt().get(0));
            this.func_145771_j(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
        }
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        if (source.func_76346_g() != null) {
            this.setAngry(true);
        }
        return super.func_70097_a(source, amount);
    }
    
    public boolean isAngry() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFYeti.ANGER_FLAG);
    }
    
    public void setAngry(final boolean anger) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFYeti.ANGER_FLAG, (Object)anger);
        if (!this.field_70170_p.field_72995_K) {
            if (anger) {
                if (!this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_180374_a(EntityTFYeti.ANGRY_MODIFIER)) {
                    this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(EntityTFYeti.ANGRY_MODIFIER);
                }
            }
            else {
                this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111124_b(EntityTFYeti.ANGRY_MODIFIER);
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74757_a("Angry", this.isAngry());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setAngry(compound.func_74767_n("Angry"));
    }
    
    public void func_184232_k(final Entity passenger) {
        final Vec3d riderPos = this.getRiderPosition(passenger);
        passenger.func_70107_b(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
    }
    
    public double func_70042_X() {
        return 2.25;
    }
    
    private Vec3d getRiderPosition(@Nullable final Entity passenger) {
        if (passenger != null) {
            final float distance = 0.4f;
            final double dx = Math.cos((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double dz = Math.sin((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return new Vec3d(this.field_70165_t + dx, this.field_70163_u + this.func_70042_X() + passenger.func_70033_W(), this.field_70161_v + dz);
        }
        return new Vec3d(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
    
    public boolean canRiderInteract() {
        return true;
    }
    
    public boolean func_70601_bi() {
        if (this.field_70170_p.func_180494_b(new BlockPos((Entity)this)) == TFBiomes.snowy_forest) {
            return this.field_70170_p.func_72855_b(this.func_174813_aQ()) && this.field_70170_p.func_184144_a((Entity)this, this.func_174813_aQ()).size() == 0;
        }
        return super.func_70601_bi();
    }
    
    protected boolean func_70814_o() {
        return this.field_70170_p.func_180494_b(new BlockPos((Entity)this)) == TFBiomes.snowy_forest || super.func_70814_o();
    }
    
    protected float func_70647_i() {
        return super.func_70647_i() + 0.55f;
    }
    
    @Nullable
    protected SoundEvent func_184639_G() {
        return TFSounds.ALPHAYETI_GROWL;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.ALPHAYETI_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ALPHAYETI_DIE;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFYeti.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/yeti");
        ANGER_FLAG = EntityDataManager.func_187226_a((Class)EntityTFYeti.class, DataSerializers.field_187198_h);
        ANGRY_MODIFIER = new AttributeModifier("Angry follow range boost", 24.0, 0).func_111168_a(false);
    }
}
