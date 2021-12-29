// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import com.google.common.collect.ImmutableSet;
import twilightforest.entity.EntityTFSwarmSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.EnumCreatureAttribute;
import twilightforest.world.TFWorld;
import twilightforest.TFFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundEvent;
import javax.annotation.Nullable;
import net.minecraft.util.math.Vec3d;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import twilightforest.entity.ai.EntityAITFLichMinions;
import twilightforest.entity.ai.EntityAITFLichShadows;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.Entity;
import java.util.Set;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFLich extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    private static final Set<Class<? extends Entity>> POPPABLE;
    private static final DataParameter<Boolean> DATA_ISCLONE;
    private static final DataParameter<Byte> DATA_SHIELDSTRENGTH;
    private static final DataParameter<Byte> DATA_MINIONSLEFT;
    private static final DataParameter<Byte> DATA_ATTACKTYPE;
    public static final int MAX_SHADOW_CLONES = 2;
    public static final int INITIAL_SHIELD_STRENGTH = 5;
    public static final int MAX_ACTIVE_MINIONS = 3;
    public static final int INITIAL_MINIONS_TO_SUMMON = 9;
    public static final int MAX_HEALTH = 100;
    private EntityTFLich masterLich;
    private int attackCooldown;
    private final BossInfoServer bossInfo;
    
    public EntityTFLich(final World world) {
        super(world);
        this.bossInfo = new BossInfoServer(this.func_145748_c_(), BossInfo.Color.YELLOW, BossInfo.Overlay.NOTCHED_6);
        this.func_70105_a(1.1f, 2.5f);
        this.setShadowClone(false);
        this.masterLich = null;
        this.field_70178_ae = true;
        this.field_70728_aV = 217;
    }
    
    public EntityTFLich(final World world, final EntityTFLich otherLich) {
        this(world);
        this.setShadowClone(true);
        this.masterLich = otherLich;
    }
    
    public EntityTFLich getMasterLich() {
        return this.masterLich;
    }
    
    public int getAttackCooldown() {
        return this.attackCooldown;
    }
    
    public void setAttackCooldown(final int cooldown) {
        this.attackCooldown = cooldown;
    }
    
    public void func_96094_a(final String name) {
        super.func_96094_a(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFLichShadows(this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFLichMinions(this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee(this, 1.0, true) {
            public boolean func_75250_a() {
                return EntityTFLich.this.getPhase() == 3 && super.func_75250_a();
            }
            
            public void func_75249_e() {
                super.func_75249_e();
                EntityTFLich.this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.field_151010_B));
            }
        });
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, false));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFLich.DATA_ISCLONE, (Object)false);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFLich.DATA_SHIELDSTRENGTH, (Object)5);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFLich.DATA_MINIONSLEFT, (Object)9);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFLich.DATA_ATTACKTYPE, (Object)0);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.45000001788139343);
    }
    
    public void func_184178_b(final EntityPlayerMP player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final EntityPlayerMP player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    public void func_70110_aj() {
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL && !this.isShadowClone()) {
            if (this.func_110175_bO()) {
                this.field_70170_p.func_175656_a(this.func_180486_cf(), TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.LICH));
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    public int getPhase() {
        if (this.isShadowClone() || this.getShieldStrength() > 0) {
            return 1;
        }
        if (this.getMinionsToSummon() > 0) {
            return 2;
        }
        return 3;
    }
    
    public void func_70636_d() {
        final float angle = this.field_70761_aq * 3.141593f / 180.0f;
        final double dx = this.field_70165_t + MathHelper.func_76134_b(angle) * 0.65;
        final double dy = this.field_70163_u + this.field_70131_O * 0.94;
        final double dz = this.field_70161_v + MathHelper.func_76126_a(angle) * 0.65;
        final int factor = (80 - this.attackCooldown) / 10;
        for (int particles = (factor > 0) ? this.field_70146_Z.nextInt(factor) : 1, j1 = 0; j1 < particles; ++j1) {
            float sparkle = 1.0f - (this.attackCooldown + 1.0f) / 60.0f;
            sparkle *= sparkle;
            float red = 0.37f * sparkle;
            float grn = 0.99f * sparkle;
            float blu = 0.89f * sparkle;
            if (this.getNextAttackType() != 0) {
                red = 0.99f * sparkle;
                grn = 0.47f * sparkle;
                blu = 0.0f * sparkle;
            }
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_MOB, dx + this.field_70146_Z.nextGaussian() * 0.025, dy + this.field_70146_Z.nextGaussian() * 0.025, dz + this.field_70146_Z.nextGaussian() * 0.025, (double)red, (double)grn, (double)blu, new int[0]);
        }
        if (this.getPhase() == 3) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.VILLAGER_ANGRY, this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + 1.0 + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70146_Z.nextGaussian() * 0.02, this.field_70146_Z.nextGaussian() * 0.02, this.field_70146_Z.nextGaussian() * 0.02, new int[0]);
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.getPhase() == 1) {
                this.bossInfo.func_186735_a((this.getShieldStrength() + 1) / 6.0f);
            }
            else {
                this.bossInfo.func_186746_a(BossInfo.Overlay.PROGRESS);
                this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
                if (this.getPhase() == 2) {
                    this.bossInfo.func_186745_a(BossInfo.Color.PURPLE);
                }
                else {
                    this.bossInfo.func_186745_a(BossInfo.Color.RED);
                }
            }
        }
        super.func_70636_d();
    }
    
    public boolean func_70097_a(final DamageSource src, final float damage) {
        if ("inWall".equals(src.func_76355_l()) && this.func_70638_az() != null) {
            this.teleportToSightOfEntity((Entity)this.func_70638_az());
        }
        if (this.isShadowClone() && src != DamageSource.field_76380_i) {
            this.func_184185_a(SoundEvents.field_187541_bC, 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            return false;
        }
        if (src.func_76346_g() instanceof EntityTFLich) {
            return false;
        }
        if (src != DamageSource.field_76380_i && this.getShieldStrength() > 0) {
            if (src.func_82725_o() && damage > 2.0f) {
                if (this.getShieldStrength() > 0) {
                    this.setShieldStrength(this.getShieldStrength() - 1);
                    this.func_184185_a(SoundEvents.field_187635_cQ, 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                }
            }
            else {
                this.func_184185_a(SoundEvents.field_187635_cQ, 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                if (src.func_76346_g() instanceof EntityLivingBase) {
                    this.func_70604_c((EntityLivingBase)src.func_76346_g());
                }
            }
            return false;
        }
        if (super.func_70097_a(src, damage)) {
            if (this.func_70643_av() instanceof EntityTFLich && ((EntityTFLich)this.func_70643_av()).masterLich == this.masterLich) {
                this.func_70604_c((EntityLivingBase)null);
            }
            if (this.getPhase() < 3 || this.field_70146_Z.nextInt(4) == 0) {
                this.teleportToSightOfEntity((Entity)this.func_70638_az());
            }
            return true;
        }
        return false;
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.func_70638_az() == null) {
            return;
        }
        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
        if (!this.isShadowClone() && this.attackCooldown % 15 == 0) {
            this.popNearbyMob();
        }
        this.func_70671_ap().func_75651_a((Entity)this.func_70638_az(), 100.0f, 100.0f);
    }
    
    public void launchBoltAt() {
        final float bodyFacingAngle = this.field_70761_aq * 3.141593f / 180.0f;
        final double sx = this.field_70165_t + MathHelper.func_76134_b(bodyFacingAngle) * 0.65;
        final double sy = this.field_70163_u + this.field_70131_O * 0.82;
        final double sz = this.field_70161_v + MathHelper.func_76126_a(bodyFacingAngle) * 0.65;
        final double tx = this.func_70638_az().field_70165_t - sx;
        final double ty = this.func_70638_az().func_174813_aQ().field_72338_b + this.func_70638_az().field_70131_O / 2.0f - (this.field_70163_u + this.field_70131_O / 2.0f);
        final double tz = this.func_70638_az().field_70161_v - sz;
        this.func_184185_a(SoundEvents.field_187557_bK, this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBolt projectile = new EntityTFLichBolt(this.field_70170_p, (EntityLivingBase)this);
        projectile.func_70012_b(sx, sy, sz, this.field_70177_z, this.field_70125_A);
        projectile.func_70186_c(tx, ty, tz, 0.5f, 1.0f);
        this.field_70170_p.func_72838_d((Entity)projectile);
    }
    
    public void launchBombAt() {
        final float bodyFacingAngle = this.field_70761_aq * 3.141593f / 180.0f;
        final double sx = this.field_70165_t + MathHelper.func_76134_b(bodyFacingAngle) * 0.65;
        final double sy = this.field_70163_u + this.field_70131_O * 0.82;
        final double sz = this.field_70161_v + MathHelper.func_76126_a(bodyFacingAngle) * 0.65;
        final double tx = this.func_70638_az().field_70165_t - sx;
        final double ty = this.func_70638_az().func_174813_aQ().field_72338_b + this.func_70638_az().field_70131_O / 2.0f - (this.field_70163_u + this.field_70131_O / 2.0f);
        final double tz = this.func_70638_az().field_70161_v - sz;
        this.func_184185_a(SoundEvents.field_187557_bK, this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBomb projectile = new EntityTFLichBomb(this.field_70170_p, (EntityLivingBase)this);
        projectile.func_70012_b(sx, sy, sz, this.field_70177_z, this.field_70125_A);
        projectile.func_70186_c(tx, ty, tz, 0.35f, 1.0f);
        this.field_70170_p.func_72838_d((Entity)projectile);
    }
    
    private void popNearbyMob() {
        final List<EntityLiving> nearbyMobs = this.field_70170_p.func_175647_a((Class)EntityLiving.class, new AxisAlignedBB(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0), e -> EntityTFLich.POPPABLE.contains(e.getClass()));
        for (final EntityLiving mob : nearbyMobs) {
            if (this.func_70635_at().func_75522_a((Entity)mob)) {
                mob.func_70656_aK();
                mob.func_70106_y();
                this.makeRedMagicTrail(mob.field_70165_t, mob.field_70163_u + mob.field_70131_O / 2.0, mob.field_70161_v, this.field_70165_t, this.field_70163_u + this.field_70131_O / 2.0, this.field_70161_v);
                break;
            }
        }
    }
    
    public boolean wantsNewClone(final EntityTFLich clone) {
        return clone.isShadowClone() && this.countMyClones() < 2;
    }
    
    public void setMaster(final EntityTFLich lich) {
        this.masterLich = lich;
    }
    
    public int countMyClones() {
        int count = 0;
        for (final EntityTFLich nearbyLich : this.getNearbyLiches()) {
            if (nearbyLich.isShadowClone() && nearbyLich.getMasterLich() == this) {
                ++count;
            }
        }
        return count;
    }
    
    public List<EntityTFLich> getNearbyLiches() {
        return this.field_70170_p.func_72872_a((Class)this.getClass(), new AxisAlignedBB(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0));
    }
    
    public boolean wantsNewMinion(final EntityTFLichMinion minion) {
        return this.countMyMinions() < 3;
    }
    
    public int countMyMinions() {
        return (int)this.field_70170_p.func_72872_a((Class)EntityTFLichMinion.class, new AxisAlignedBB(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0)).stream().filter(m -> m.master == this).count();
    }
    
    public void teleportToSightOfEntity(final Entity entity) {
        final Vec3d dest = this.findVecInLOSOf(entity);
        final double srcX = this.field_70165_t;
        final double srcY = this.field_70163_u;
        final double srcZ = this.field_70161_v;
        if (dest != null) {
            this.teleportToNoChecks(dest.field_72450_a, dest.field_72448_b, dest.field_72449_c);
            this.func_70671_ap().func_75651_a(entity, 100.0f, 100.0f);
            this.field_70761_aq = this.field_70177_z;
            if (!this.func_70635_at().func_75522_a(entity)) {
                this.teleportToNoChecks(srcX, srcY, srcZ);
            }
        }
    }
    
    @Nullable
    public Vec3d findVecInLOSOf(final Entity targetEntity) {
        if (targetEntity == null) {
            return null;
        }
        final double origX = this.field_70165_t;
        final double origY = this.field_70163_u;
        final double origZ = this.field_70161_v;
        for (int tries = 100, i = 0; i < tries; ++i) {
            final double tx = targetEntity.field_70165_t + this.field_70146_Z.nextGaussian() * 16.0;
            final double ty = targetEntity.field_70163_u;
            final double tz = targetEntity.field_70161_v + this.field_70146_Z.nextGaussian() * 16.0;
            final boolean destClear = this.func_184595_k(tx, ty, tz);
            final boolean canSeeTargetAtDest = this.func_70685_l(targetEntity);
            this.func_70634_a(origX, origY, origZ);
            if (destClear && canSeeTargetAtDest) {
                return new Vec3d(tx, ty, tz);
            }
        }
        return null;
    }
    
    private void teleportToNoChecks(final double destX, final double destY, final double destZ) {
        final double srcX = this.field_70165_t;
        final double srcY = this.field_70163_u;
        final double srcZ = this.field_70161_v;
        this.func_70634_a(destX, destY, destZ);
        this.makeTeleportTrail(srcX, srcY, srcZ, destX, destY, destZ);
        this.field_70170_p.func_184148_a((EntityPlayer)null, srcX, srcY, srcZ, SoundEvents.field_187534_aX, this.func_184176_by(), 1.0f, 1.0f);
        this.func_184185_a(SoundEvents.field_187534_aX, 1.0f, 1.0f);
        this.field_70703_bu = false;
    }
    
    public void makeTeleportTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 128, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 2.0;
            final double ty = srcY + (destY - srcY) * trailFactor + this.field_70146_Z.nextDouble() * this.field_70131_O;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 2.0;
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL, tx, ty, tz, (double)f, (double)f2, (double)f3, new int[0]);
        }
    }
    
    private void makeRedMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_MOB, tx, ty, tz, (double)f, (double)f2, (double)f3, new int[0]);
        }
    }
    
    public void makeBlackMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 0.2f;
            final float f2 = 0.2f;
            final float f3 = 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_MOB, tx, ty, tz, (double)f, (double)f2, (double)f3, new int[0]);
        }
    }
    
    public boolean isShadowClone() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFLich.DATA_ISCLONE);
    }
    
    public void setShadowClone(final boolean shadowClone) {
        this.bossInfo.func_186758_d(!shadowClone);
        this.field_70180_af.func_187227_b((DataParameter)EntityTFLich.DATA_ISCLONE, (Object)shadowClone);
    }
    
    public byte getShieldStrength() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFLich.DATA_SHIELDSTRENGTH);
    }
    
    public void setShieldStrength(final int shieldStrength) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFLich.DATA_SHIELDSTRENGTH, (Object)(byte)shieldStrength);
    }
    
    public byte getMinionsToSummon() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFLich.DATA_MINIONSLEFT);
    }
    
    public void setMinionsToSummon(final int minionsToSummon) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFLich.DATA_MINIONSLEFT, (Object)(byte)minionsToSummon);
    }
    
    public byte getNextAttackType() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFLich.DATA_ATTACKTYPE);
    }
    
    public void setNextAttackType(final int attackType) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFLich.DATA_ATTACKTYPE, (Object)(byte)attackType);
    }
    
    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187594_A;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return SoundEvents.field_187603_D;
    }
    
    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187600_C;
    }
    
    public ResourceLocation func_184647_J() {
        return this.isShadowClone() ? null : EntityTFLich.LOOT_TABLE;
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74757_a("ShadowClone", this.isShadowClone());
        compound.func_74774_a("ShieldStrength", this.getShieldStrength());
        compound.func_74774_a("MinionsToSummon", this.getMinionsToSummon());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setShadowClone(compound.func_74767_n("ShadowClone"));
        this.setShieldStrength(compound.func_74771_c("ShieldStrength"));
        this.setMinionsToSummon(compound.func_74771_c("MinionsToSummon"));
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K && !this.isShadowClone()) {
            TFWorld.markStructureConquered(this.field_70170_p, new BlockPos((Entity)this), TFFeature.LICH_TOWER);
        }
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/lich");
        POPPABLE = (Set)ImmutableSet.of((Object)EntitySkeleton.class, (Object)EntityZombie.class, (Object)EntityEnderman.class, (Object)EntitySpider.class, (Object)EntityCreeper.class, (Object)EntityTFSwarmSpider.class, (Object[])new Class[0]);
        DATA_ISCLONE = EntityDataManager.func_187226_a((Class)EntityTFLich.class, DataSerializers.field_187198_h);
        DATA_SHIELDSTRENGTH = EntityDataManager.func_187226_a((Class)EntityTFLich.class, DataSerializers.field_187191_a);
        DATA_MINIONSLEFT = EntityDataManager.func_187226_a((Class)EntityTFLich.class, DataSerializers.field_187191_a);
        DATA_ATTACKTYPE = EntityDataManager.func_187226_a((Class)EntityTFLich.class, DataSerializers.field_187191_a);
    }
}
