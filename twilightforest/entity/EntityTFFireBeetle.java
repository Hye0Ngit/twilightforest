// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
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
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFFireBeetle extends EntityMob implements IBreathAttacker
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Boolean> BREATHING;
    private static final int BREATH_DURATION = 10;
    private static final int BREATH_DAMAGE = 2;
    
    public EntityTFFireBeetle(final World world) {
        super(world);
        this.field_70178_ae = true;
        this.func_70105_a(1.1f, 0.75f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFBreathAttack<Object>(this, 1.0f, 5.0f, 30, 0.1f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFFireBeetle.BREATHING, (Object)false);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(25.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0);
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
    
    public ResourceLocation func_184647_J() {
        return EntityTFFireBeetle.LOOT_TABLE;
    }
    
    public boolean isBreathing() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFFireBeetle.BREATHING);
    }
    
    public void setBreathing(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFFireBeetle.BREATHING, (Object)flag);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isBreathing()) {
            final Vec3d look = this.func_70040_Z();
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
                this.field_70170_p.func_175688_a(EnumParticleTypes.FLAME, px, py, pz, dx, dy, dz, new int[0]);
            }
            this.func_184185_a(SoundEvents.field_187557_bK, this.field_70146_Z.nextFloat() * 0.5f, this.field_70146_Z.nextFloat() * 0.5f);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int func_70070_b() {
        if (this.isBreathing()) {
            return 15728880;
        }
        return super.func_70070_b();
    }
    
    public int func_70646_bf() {
        return 500;
    }
    
    public float func_70047_e() {
        return this.field_70131_O * 0.6f;
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    public void doBreathAttack(final Entity target) {
        if (!target.func_70045_F() && target.func_70097_a(DamageSource.field_76372_a, 2.0f)) {
            target.func_70015_d(10);
        }
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/fire_beetle");
        BREATHING = EntityDataManager.func_187226_a((Class)EntityTFFireBeetle.class, DataSerializers.field_187198_h);
    }
}
