// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TwilightForestMod;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import twilightforest.entity.ai.EntityAITFTempt;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;

public class EntityTFRaven extends EntityTFTinyBird
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFRaven(final World world) {
        super(world);
        this.func_70105_a(0.3f, 0.5f);
        this.field_70138_W = 1.0f;
    }
    
    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFTempt((EntityCreature)this, 0.8500000238418579, true, EntityTFRaven.SEEDS));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000001192092895);
    }
    
    @Override
    protected SoundEvent func_184639_G() {
        return TFSounds.RAVEN_CAW;
    }
    
    @Override
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.RAVEN_SQUAWK;
    }
    
    @Override
    protected SoundEvent func_184615_bR() {
        return TFSounds.RAVEN_SQUAWK;
    }
    
    @Override
    public ResourceLocation func_184647_J() {
        return EntityTFRaven.LOOT_TABLE;
    }
    
    @Override
    public float func_70047_e() {
        return this.field_70131_O * 0.75f;
    }
    
    @Override
    public float func_70603_bj() {
        return 0.3f;
    }
    
    @Override
    public boolean isSpooked() {
        return this.field_70737_aN > 0;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/raven");
    }
}
