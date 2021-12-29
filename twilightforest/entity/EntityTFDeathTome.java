// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.WorldServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFDeathTome extends EntityMob implements IRangedAttackMob
{
    public static final ResourceLocation LOOT_TABLE;
    public static final ResourceLocation HURT_LOOT_TABLE;
    
    public EntityTFDeathTome(final World world) {
        super(world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackRanged((IRangedAttackMob)this, 1.0, 60, 10.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        for (int i = 0; i < 1; ++i) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.ENCHANTMENT_TABLE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (this.field_70131_O - 0.75) + 0.5, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, 0.0, 0.5, 0.0, new int[0]);
        }
    }
    
    public boolean func_70097_a(final DamageSource src, float damage) {
        if (src.func_76347_k()) {
            damage *= 2.0f;
        }
        if (super.func_70097_a(src, damage)) {
            if (!this.field_70170_p.field_72995_K) {
                final LootContext ctx = new LootContext.Builder((WorldServer)this.field_70170_p).func_186473_a(src).func_186472_a((Entity)this).func_186471_a();
                for (final ItemStack stack : this.field_70170_p.func_184146_ak().func_186521_a(EntityTFDeathTome.HURT_LOOT_TABLE).func_186462_a(this.field_70170_p.field_73012_v, ctx)) {
                    this.func_70099_a(stack, 1.0f);
                }
            }
            return true;
        }
        return false;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFDeathTome.LOOT_TABLE;
    }
    
    @Nullable
    protected SoundEvent func_184639_G() {
        return TFSounds.TOME_IDLE;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.TOME_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.TOME_DEATH;
    }
    
    public void func_82196_d(final EntityLivingBase target, final float distanceFactor) {
        final EntityThrowable projectile = new EntityTFTomeBolt(this.field_70170_p, (EntityLivingBase)this);
        final double tx = target.field_70165_t - this.field_70165_t;
        final double ty = target.field_70163_u + target.func_70047_e() - 1.100000023841858 - projectile.field_70163_u;
        final double tz = target.field_70161_v - this.field_70161_v;
        final float heightOffset = MathHelper.func_76133_a(tx * tx + tz * tz) * 0.2f;
        projectile.func_70186_c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
        this.field_70170_p.func_72838_d((Entity)projectile);
    }
    
    public void func_184724_a(final boolean swingingArms) {
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/death_tome");
        HURT_LOOT_TABLE = TwilightForestMod.prefix("entities/death_tome_hurt");
    }
}
