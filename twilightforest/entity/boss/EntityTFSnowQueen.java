// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import twilightforest.util.WorldUtil;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.EntityLivingBase;
import java.util.Iterator;
import java.util.List;
import twilightforest.world.TFWorld;
import twilightforest.TFFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import twilightforest.client.particle.TFParticleType;
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
import twilightforest.entity.ai.EntityAITFHoverBeam;
import twilightforest.entity.ai.EntityAITFHoverThenDrop;
import twilightforest.entity.ai.EntityAITFHoverSummon;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.world.BossInfoServer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.IBreathAttacker;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFSnowQueen extends EntityMob implements IEntityMultiPart, IBreathAttacker
{
    public static final ResourceLocation LOOT_TABLE;
    private static final int MAX_SUMMONS = 6;
    private static final DataParameter<Boolean> BEAM_FLAG;
    private static final DataParameter<Byte> PHASE_FLAG;
    private final BossInfoServer bossInfo;
    private static final int MAX_DAMAGE_WHILE_BEAMING = 25;
    private static final float BREATH_DAMAGE = 4.0f;
    public final Entity[] iceArray;
    private int summonsRemaining;
    private int successfulDrops;
    private int maxDrops;
    private int damageWhileBeaming;
    
    public EntityTFSnowQueen(final World world) {
        super(world);
        this.bossInfo = new BossInfoServer(this.func_145748_c_(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS);
        this.iceArray = new Entity[7];
        this.summonsRemaining = 0;
        this.func_70105_a(0.7f, 2.2f);
        for (int i = 0; i < this.iceArray.length; ++i) {
            this.iceArray[i] = (Entity)new EntityTFSnowQueenIceShield(this);
        }
        this.setCurrentPhase(Phase.SUMMON);
        this.field_70178_ae = true;
        this.field_70728_aV = 317;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFHoverSummon(this, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFHoverThenDrop(this, 80, 20));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITFHoverBeam(this, 80, 100));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, true));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFSnowQueen.BEAM_FLAG, (Object)false);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFSnowQueen.PHASE_FLAG, (Object)0);
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
    
    public ResourceLocation func_184647_J() {
        return EntityTFSnowQueen.LOOT_TABLE;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
        }
        else {
            this.spawnParticles();
        }
    }
    
    private void spawnParticles() {
        for (int i = 0; i < 3; ++i) {
            final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            final float py = this.func_70047_e() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
            final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            TwilightForestMod.proxy.spawnParticle(TFParticleType.SNOW_GUARDIAN, this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
        }
        if (this.getCurrentPhase() == Phase.DROP) {
            for (final Entity ice : this.iceArray) {
                final float px2 = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                final float py2 = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                final float pz2 = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                TwilightForestMod.proxy.spawnParticle(TFParticleType.SNOW_WARNING, ice.field_70142_S + px2, ice.field_70137_T + py2, ice.field_70136_U + pz2, 0.0, 0.0, 0.0);
            }
        }
        if (this.isBreathing() && this.func_70089_S()) {
            final Vec3d look = this.func_70040_Z();
            final double dist = 0.5;
            final double px3 = this.field_70165_t + look.field_72450_a * dist;
            final double py3 = this.field_70163_u + 1.7000000476837158 + look.field_72448_b * dist;
            final double pz3 = this.field_70161_v + look.field_72449_c * dist;
            for (int j = 0; j < 10; ++j) {
                double dx = look.field_72450_a;
                double dy = 0.0;
                double dz = look.field_72449_c;
                final double spread = 2.0 + this.func_70681_au().nextDouble() * 2.5;
                final double velocity = 2.0 + this.func_70681_au().nextDouble() * 0.15;
                dx += this.func_70681_au().nextGaussian() * 0.0075 * spread;
                dy += this.func_70681_au().nextGaussian() * 0.0075 * spread;
                dz += this.func_70681_au().nextGaussian() * 0.0075 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                TwilightForestMod.proxy.spawnParticle(TFParticleType.ICE_BEAM, px3, py3, pz3, dx, dy, dz);
            }
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        for (int i = 0; i < this.iceArray.length; ++i) {
            this.iceArray[i].func_70071_h_();
            if (i < this.iceArray.length - 1) {
                final Vec3d blockPos = this.getIceShieldPosition(i);
                this.iceArray[i].func_70107_b(blockPos.field_72450_a, blockPos.field_72448_b, blockPos.field_72449_c);
                this.iceArray[i].field_70177_z = this.getIceShieldAngle(i);
            }
            else {
                this.iceArray[i].func_70107_b(this.field_70165_t, this.field_70163_u - 1.0, this.field_70161_v);
                this.iceArray[i].field_70177_z = this.getIceShieldAngle(i);
            }
            if (!this.field_70170_p.field_72995_K) {
                this.applyShieldCollisions(this.iceArray[i]);
            }
        }
        if (this.field_70725_aQ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.field_70146_Z.nextGaussian() * 0.02;
                final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                final EnumParticleTypes explosionType = this.field_70146_Z.nextBoolean() ? EnumParticleTypes.EXPLOSION_HUGE : EnumParticleTypes.EXPLOSION_NORMAL;
                this.field_70170_p.func_175688_a(explosionType, this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d, d2, d3, new int[0]);
            }
        }
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
            if (this.func_110175_bO()) {
                this.field_70170_p.func_175656_a(this.func_180486_cf(), TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.SNOW_QUEEN));
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFWorld.markStructureConquered(this.field_70170_p, new BlockPos((Entity)this), TFFeature.ICE_TOWER);
        }
    }
    
    private void applyShieldCollisions(final Entity collider) {
        final List<Entity> list = this.field_70170_p.func_72839_b(collider, collider.func_174813_aQ().func_72314_b(-0.20000000298023224, -0.20000000298023224, -0.20000000298023224));
        for (final Entity collided : list) {
            if (collided.func_70104_M()) {
                this.applyShieldCollision(collider, collided);
            }
        }
    }
    
    private void applyShieldCollision(final Entity collider, final Entity collided) {
        if (collided != this) {
            collided.func_70108_f(collider);
            if (collided instanceof EntityLivingBase && super.func_70652_k(collided)) {
                collided.field_70181_x += 0.4;
                this.func_184185_a(SoundEvents.field_187596_cD, 1.0f, 1.0f);
            }
        }
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.getCurrentPhase() == Phase.SUMMON && this.getSummonsRemaining() == 0 && this.countMyMinions() <= 0) {
            this.setCurrentPhase(Phase.DROP);
        }
        if (this.getCurrentPhase() == Phase.DROP && this.successfulDrops >= this.maxDrops) {
            this.setCurrentPhase(Phase.BEAM);
        }
        if (this.getCurrentPhase() == Phase.BEAM && this.damageWhileBeaming >= 25) {
            this.setCurrentPhase(Phase.SUMMON);
        }
    }
    
    public boolean func_70097_a(final DamageSource source, final float damage) {
        final boolean result = super.func_70097_a(source, damage);
        if (result && this.getCurrentPhase() == Phase.BEAM) {
            this.damageWhileBeaming += (int)damage;
        }
        return result;
    }
    
    private Vec3d getIceShieldPosition(final int idx) {
        return this.getIceShieldPosition(this.getIceShieldAngle(idx), 1.0f);
    }
    
    private float getIceShieldAngle(final int idx) {
        return 60.0f * idx + this.field_70173_aa * 5.0f;
    }
    
    private Vec3d getIceShieldPosition(final float angle, final float distance) {
        final double dx = Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dz = Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return new Vec3d(this.field_70165_t + dx, this.field_70163_u + this.getShieldYOffset(), this.field_70161_v + dz);
    }
    
    private double getShieldYOffset() {
        return 0.10000000149011612;
    }
    
    public void func_180430_e(final float distance, final float damageMultiplier) {
    }
    
    public World func_82194_d() {
        return this.field_70170_p;
    }
    
    public boolean func_70965_a(final MultiPartEntityPart part, final DamageSource source, final float damage) {
        return false;
    }
    
    public Entity[] func_70021_al() {
        return this.iceArray;
    }
    
    public void destroyBlocksInAABB(final AxisAlignedBB box) {
        if (ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this)) {
            for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
                final IBlockState state = this.field_70170_p.func_180495_p(pos);
                if (state.func_177230_c() == Blocks.field_150432_aD || state.func_177230_c() == Blocks.field_150403_cj) {
                    this.field_70170_p.func_175655_b(pos, false);
                }
            }
        }
    }
    
    public boolean isBreathing() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFSnowQueen.BEAM_FLAG);
    }
    
    public void setBreathing(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFSnowQueen.BEAM_FLAG, (Object)flag);
    }
    
    public Phase getCurrentPhase() {
        return Phase.values()[(byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFSnowQueen.PHASE_FLAG)];
    }
    
    public void setCurrentPhase(final Phase currentPhase) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFSnowQueen.PHASE_FLAG, (Object)(byte)currentPhase.ordinal());
        if (currentPhase == Phase.SUMMON) {
            this.setSummonsRemaining(6);
        }
        if (currentPhase == Phase.DROP) {
            this.successfulDrops = 0;
            this.maxDrops = 2 + this.field_70146_Z.nextInt(3);
        }
        if (currentPhase == Phase.BEAM) {
            this.damageWhileBeaming = 0;
        }
    }
    
    public int getSummonsRemaining() {
        return this.summonsRemaining;
    }
    
    public void setSummonsRemaining(final int summonsRemaining) {
        this.summonsRemaining = summonsRemaining;
    }
    
    public void summonMinionAt(final EntityLivingBase targetedEntity) {
        final EntityTFIceCrystal minion = new EntityTFIceCrystal(this.field_70170_p);
        minion.func_70080_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0f, 0.0f);
        this.field_70170_p.func_72838_d((Entity)minion);
        for (int i = 0; i < 100; ++i) {
            double attemptX;
            double attemptY;
            double attemptZ;
            if (this.func_110175_bO()) {
                final BlockPos home = this.func_180486_cf();
                attemptX = home.func_177958_n() + this.field_70146_Z.nextGaussian() * 7.0;
                attemptY = home.func_177956_o() + this.field_70146_Z.nextGaussian() * 2.0;
                attemptZ = home.func_177952_p() + this.field_70146_Z.nextGaussian() * 7.0;
            }
            else {
                attemptX = targetedEntity.field_70165_t + this.field_70146_Z.nextGaussian() * 16.0;
                attemptY = targetedEntity.field_70163_u + this.field_70146_Z.nextGaussian() * 8.0;
                attemptZ = targetedEntity.field_70161_v + this.field_70146_Z.nextGaussian() * 16.0;
            }
            if (minion.func_184595_k(attemptX, attemptY, attemptZ)) {
                break;
            }
        }
        minion.func_70624_b(targetedEntity);
        minion.setToDieIn30Seconds();
        --this.summonsRemaining;
    }
    
    public int countMyMinions() {
        return this.field_70170_p.func_72872_a((Class)EntityTFIceCrystal.class, new AxisAlignedBB(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0)).size();
    }
    
    public void incrementSuccessfulDrops() {
        ++this.successfulDrops;
    }
    
    public void doBreathAttack(final Entity target) {
        target.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 4.0f);
    }
    
    public void func_96094_a(final String name) {
        super.func_96094_a(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    public void func_184178_b(final EntityPlayerMP player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final EntityPlayerMP player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/snow_queen");
        BEAM_FLAG = EntityDataManager.func_187226_a((Class)EntityTFSnowQueen.class, DataSerializers.field_187198_h);
        PHASE_FLAG = EntityDataManager.func_187226_a((Class)EntityTFSnowQueen.class, DataSerializers.field_187191_a);
    }
    
    public enum Phase
    {
        SUMMON, 
        DROP, 
        BEAM;
    }
}
