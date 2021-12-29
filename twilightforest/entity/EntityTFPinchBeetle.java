// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAITFChargeAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFPinchBeetle extends EntityMob implements IHostileMount
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFPinchBeetle(final World world) {
        super(world);
        this.func_70105_a(1.2f, 1.1f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFChargeAttack((EntityCreature)this, 2.0f, false));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0);
        this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111128_a(2.0);
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return SoundEvents.field_187821_fM;
    }
    
    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187819_fL;
    }
    
    protected void func_180429_a(final BlockPos pos, final Block block) {
        this.func_184185_a(SoundEvents.field_187823_fN, 0.15f, 1.0f);
    }
    
    public void func_70636_d() {
        if (!this.func_184188_bt().isEmpty()) {
            this.func_70105_a(1.9f, 2.0f);
            if (this.func_184188_bt().get(0).func_70093_af()) {
                this.func_184188_bt().get(0).func_70095_a(false);
            }
        }
        else {
            this.func_70105_a(1.2f, 1.1f);
        }
        super.func_70636_d();
        if (!this.func_184188_bt().isEmpty()) {
            this.func_70671_ap().func_75651_a((Entity)this.func_184188_bt().get(0), 100.0f, 100.0f);
            final Vec3d riderPos = this.getRiderPosition();
            this.func_145771_j(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
        }
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (this.func_184188_bt().isEmpty() && !entity.func_184218_aH()) {
            entity.func_184220_m((Entity)this);
        }
        return super.func_70652_k(entity);
    }
    
    public float func_70047_e() {
        return 0.25f;
    }
    
    public void func_184232_k(final Entity passenger) {
        if (!this.func_184188_bt().isEmpty()) {
            final Vec3d riderPos = this.getRiderPosition();
            this.func_184188_bt().get(0).func_70107_b(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
        }
    }
    
    public double func_70042_X() {
        return 0.75;
    }
    
    private Vec3d getRiderPosition() {
        if (!this.func_184188_bt().isEmpty()) {
            final float distance = 0.9f;
            final double dx = Math.cos((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double dz = Math.sin((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return new Vec3d(this.field_70165_t + dx, this.field_70163_u + this.func_70042_X() + this.func_184188_bt().get(0).func_70033_W(), this.field_70161_v + dz);
        }
        return new Vec3d(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
    
    public boolean canRiderInteract() {
        return true;
    }
    
    protected ResourceLocation func_184647_J() {
        return EntityTFPinchBeetle.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/pinch_beetle");
    }
}
