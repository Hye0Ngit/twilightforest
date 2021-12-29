// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import twilightforest.TwilightForestMod;
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
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFIceMob;

public class EntityTFIceCrystal extends EntityTFIceMob
{
    public static final ResourceLocation LOOT_TABLE;
    private int crystalAge;
    private int maxCrystalAge;
    
    public EntityTFIceCrystal(final World world) {
        super(world);
        this.maxCrystalAge = -1;
        this.func_70105_a(0.6f, 1.8f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0);
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFIceCrystal.LOOT_TABLE;
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.ICE_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.ICE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ICE_DEATH;
    }
    
    public void setToDieIn30Seconds() {
        this.maxCrystalAge = 600;
    }
    
    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            ++this.crystalAge;
            if (this.maxCrystalAge > 0 && this.crystalAge >= this.maxCrystalAge) {
                this.func_70106_y();
            }
        }
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/ice_crystal");
    }
}
