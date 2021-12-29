// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import com.google.common.collect.ImmutableSet;
import twilightforest.entity.SwarmSpiderEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.CreatureAttribute;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFFeature;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.LivingEntity;
import twilightforest.TFSounds;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.LichMinionsGoal;
import twilightforest.entity.ai.LichShadowsGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import twilightforest.entity.TFEntities;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.Entity;
import java.util.Set;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.MonsterEntity;

public class LichEntity extends MonsterEntity
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
    private LichEntity masterLich;
    private int attackCooldown;
    private final ServerBossInfo bossInfo;
    
    public LichEntity(final EntityType<? extends LichEntity> type, final World world) {
        super((EntityType)type, world);
        this.bossInfo = new ServerBossInfo(this.func_145748_c_(), BossInfo.Color.YELLOW, BossInfo.Overlay.NOTCHED_6);
        this.setShadowClone(false);
        this.masterLich = null;
        this.func_230279_az_();
        this.field_70728_aV = 217;
    }
    
    public LichEntity(final World world, final LichEntity otherLich) {
        this(TFEntities.lich, world);
        this.setShadowClone(true);
        this.masterLich = otherLich;
    }
    
    public LichEntity getMasterLich() {
        return this.masterLich;
    }
    
    public int getAttackCooldown() {
        return this.attackCooldown;
    }
    
    public void setAttackCooldown(final int cooldown) {
        this.attackCooldown = cooldown;
    }
    
    public void func_200203_b(@Nullable final ITextComponent name) {
        super.func_200203_b(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new LichShadowsGoal(this));
        this.field_70714_bg.func_75776_a(2, (Goal)new LichMinionsGoal(this));
        this.field_70714_bg.func_75776_a(3, (Goal)new MeleeAttackGoal(this, 0.75, true) {
            public boolean func_75250_a() {
                return LichEntity.this.getPhase() == 3 && super.func_75250_a();
            }
            
            public void func_75249_e() {
                super.func_75249_e();
                LichEntity.this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)Items.field_151010_B));
            }
        });
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, false));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)LichEntity.DATA_ISCLONE, (Object)false);
        this.field_70180_af.func_187214_a((DataParameter)LichEntity.DATA_SHIELDSTRENGTH, (Object)5);
        this.field_70180_af.func_187214_a((DataParameter)LichEntity.DATA_MINIONSLEFT, (Object)9);
        this.field_70180_af.func_187214_a((DataParameter)LichEntity.DATA_ATTACKTYPE, (Object)0);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 100.0).func_233815_a_(Attributes.field_233823_f_, 3.0).func_233815_a_(Attributes.field_233821_d_, 0.45000001788139343);
    }
    
    public void func_184178_b(final ServerPlayerEntity player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final ServerPlayerEntity player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    public boolean func_213397_c(final double p_213397_1_) {
        return false;
    }
    
    public void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL && !this.isShadowClone()) {
            if (this.func_213394_dL()) {
                this.field_70170_p.func_175656_a(this.func_213384_dI(), ((Block)TFBlocks.boss_spawner_lich.get()).func_176223_P());
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
        if (this.getMinionsToSummon() > 0 || this.countMyMinions() > 0) {
            return 2;
        }
        return 3;
    }
    
    public void func_70636_d() {
        final float angle = this.field_70761_aq * 3.141593f / 180.0f;
        final double dx = this.func_226277_ct_() + MathHelper.func_76134_b(angle) * 0.65;
        final double dy = this.func_226278_cu_() + this.func_213302_cg() * 0.94;
        final double dz = this.func_226281_cx_() + MathHelper.func_76126_a(angle) * 0.65;
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
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197625_r, dx + this.field_70146_Z.nextGaussian() * 0.025, dy + this.field_70146_Z.nextGaussian() * 0.025, dz + this.field_70146_Z.nextGaussian() * 0.025, (double)red, (double)grn, (double)blu);
        }
        if (this.getPhase() == 3) {
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197609_b, this.func_226277_ct_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), this.func_226278_cu_() + 1.0 + this.field_70146_Z.nextFloat() * this.func_213302_cg(), this.func_226281_cx_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), this.field_70146_Z.nextGaussian() * 0.02, this.field_70146_Z.nextGaussian() * 0.02, this.field_70146_Z.nextGaussian() * 0.02);
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
            this.func_184185_a(TFSounds.LICH_CLONE_HURT, 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            return false;
        }
        if (src.func_76346_g() instanceof LichEntity) {
            return false;
        }
        if (src != DamageSource.field_76380_i && this.getShieldStrength() > 0) {
            if (src.func_82725_o() && damage > 2.0f) {
                if (this.getShieldStrength() > 0) {
                    this.setShieldStrength(this.getShieldStrength() - 1);
                    this.func_184185_a(TFSounds.SHIELD_BREAK, 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                }
            }
            else {
                this.func_184185_a(TFSounds.SHIELD_BREAK, 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                if (src.func_76346_g() instanceof LivingEntity) {
                    this.func_70604_c((LivingEntity)src.func_76346_g());
                }
            }
            return false;
        }
        if (super.func_70097_a(src, damage)) {
            if (this.func_70643_av() instanceof LichEntity && ((LichEntity)this.func_70643_av()).masterLich == this.masterLich) {
                this.func_70604_c((LivingEntity)null);
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
        final double sx = this.func_226277_ct_() + MathHelper.func_76134_b(bodyFacingAngle) * 0.65;
        final double sy = this.func_226278_cu_() + this.func_213302_cg() * 0.82;
        final double sz = this.func_226281_cx_() + MathHelper.func_76126_a(bodyFacingAngle) * 0.65;
        final double tx = this.func_70638_az().func_226277_ct_() - sx;
        final double ty = this.func_70638_az().func_174813_aQ().field_72338_b + this.func_70638_az().func_213302_cg() / 2.0f - (this.func_226278_cu_() + this.func_213302_cg() / 2.0f);
        final double tz = this.func_70638_az().func_226281_cx_() - sz;
        this.func_184185_a(TFSounds.LICH_SHOOT, this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
        final LichBoltEntity projectile = new LichBoltEntity(TFEntities.lich_bolt, this.field_70170_p, (LivingEntity)this);
        projectile.func_70012_b(sx, sy, sz, this.field_70177_z, this.field_70125_A);
        projectile.func_70186_c(tx, ty, tz, 0.5f, 1.0f);
        this.field_70170_p.func_217376_c((Entity)projectile);
    }
    
    public void launchBombAt() {
        final float bodyFacingAngle = this.field_70761_aq * 3.141593f / 180.0f;
        final double sx = this.func_226277_ct_() + MathHelper.func_76134_b(bodyFacingAngle) * 0.65;
        final double sy = this.func_226278_cu_() + this.func_213302_cg() * 0.82;
        final double sz = this.func_226281_cx_() + MathHelper.func_76126_a(bodyFacingAngle) * 0.65;
        final double tx = this.func_70638_az().func_226277_ct_() - sx;
        final double ty = this.func_70638_az().func_174813_aQ().field_72338_b + this.func_70638_az().func_213302_cg() / 2.0f - (this.func_226278_cu_() + this.func_213302_cg() / 2.0f);
        final double tz = this.func_70638_az().func_226281_cx_() - sz;
        this.func_184185_a(TFSounds.LICH_SHOOT, this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
        final LichBombEntity projectile = new LichBombEntity(TFEntities.lich_bomb, this.field_70170_p, (LivingEntity)this);
        projectile.func_70012_b(sx, sy, sz, this.field_70177_z, this.field_70125_A);
        projectile.func_70186_c(tx, ty, tz, 0.35f, 1.0f);
        this.field_70170_p.func_217376_c((Entity)projectile);
    }
    
    private void popNearbyMob() {
        final List<MobEntity> nearbyMobs = this.field_70170_p.func_175647_a((Class)MobEntity.class, new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.func_226277_ct_() + 1.0, this.func_226278_cu_() + 1.0, this.func_226281_cx_() + 1.0).func_72314_b(32.0, 16.0, 32.0), e -> LichEntity.POPPABLE.contains(e.getClass()));
        for (final MobEntity mob : nearbyMobs) {
            if (this.func_70635_at().func_75522_a((Entity)mob)) {
                mob.func_70656_aK();
                mob.func_70106_y();
                this.makeRedMagicTrail(mob.func_226277_ct_(), mob.func_226278_cu_() + mob.func_213302_cg() / 2.0, mob.func_226281_cx_(), this.func_226277_ct_(), this.func_226278_cu_() + this.func_213302_cg() / 2.0, this.func_226281_cx_());
                break;
            }
        }
    }
    
    public boolean wantsNewClone(final LichEntity clone) {
        return clone.isShadowClone() && this.countMyClones() < 2;
    }
    
    public void setMaster(final LichEntity lich) {
        this.masterLich = lich;
    }
    
    public int countMyClones() {
        int count = 0;
        for (final LichEntity nearbyLich : this.getNearbyLiches()) {
            if (nearbyLich.isShadowClone() && nearbyLich.getMasterLich() == this) {
                ++count;
            }
        }
        return count;
    }
    
    public List<LichEntity> getNearbyLiches() {
        return this.field_70170_p.func_217357_a((Class)this.getClass(), new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.func_226277_ct_() + 1.0, this.func_226278_cu_() + 1.0, this.func_226281_cx_() + 1.0).func_72314_b(32.0, 16.0, 32.0));
    }
    
    public boolean wantsNewMinion() {
        return this.countMyMinions() < 3;
    }
    
    public int countMyMinions() {
        return (int)this.field_70170_p.func_217357_a((Class)LichMinionEntity.class, new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.func_226277_ct_() + 1.0, this.func_226278_cu_() + 1.0, this.func_226281_cx_() + 1.0).func_72314_b(32.0, 16.0, 32.0)).stream().filter(m -> m.master == this).count();
    }
    
    public void teleportToSightOfEntity(final Entity entity) {
        final Vector3d dest = this.findVecInLOSOf(entity);
        final double srcX = this.func_226277_ct_();
        final double srcY = this.func_226278_cu_();
        final double srcZ = this.func_226281_cx_();
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
    public Vector3d findVecInLOSOf(final Entity targetEntity) {
        if (targetEntity == null) {
            return null;
        }
        final double origX = this.func_226277_ct_();
        final double origY = this.func_226278_cu_();
        final double origZ = this.func_226281_cx_();
        for (int tries = 100, i = 0; i < tries; ++i) {
            final double tx = targetEntity.func_226277_ct_() + this.field_70146_Z.nextGaussian() * 16.0;
            final double ty = targetEntity.func_226278_cu_();
            final double tz = targetEntity.func_226281_cx_() + this.field_70146_Z.nextGaussian() * 16.0;
            final boolean destClear = this.func_213373_a(tx, ty, tz, true);
            final boolean canSeeTargetAtDest = this.func_70685_l(targetEntity);
            this.func_70634_a(origX, origY, origZ);
            if (destClear && canSeeTargetAtDest) {
                return new Vector3d(tx, ty, tz);
            }
        }
        return null;
    }
    
    private void teleportToNoChecks(final double destX, final double destY, final double destZ) {
        final double srcX = this.func_226277_ct_();
        final double srcY = this.func_226278_cu_();
        final double srcZ = this.func_226281_cx_();
        this.func_70634_a(destX, destY, destZ);
        this.makeTeleportTrail(srcX, srcY, srcZ, destX, destY, destZ);
        this.field_70170_p.func_184148_a((PlayerEntity)null, srcX, srcY, srcZ, TFSounds.LICH_TELEPORT, this.func_184176_by(), 1.0f, 1.0f);
        this.func_184185_a(TFSounds.LICH_TELEPORT, 1.0f, 1.0f);
        this.field_70703_bu = false;
    }
    
    public void makeTeleportTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 128, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 2.0;
            final double ty = srcY + (destY - srcY) * trailFactor + this.field_70146_Z.nextDouble() * this.func_213302_cg();
            final double tz = srcZ + (destZ - srcZ) * trailFactor + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 2.0;
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197620_m, tx, ty, tz, (double)f, (double)f2, (double)f3);
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
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197625_r, tx, ty, tz, (double)f, (double)f2, (double)f3);
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
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197625_r, tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public boolean isShadowClone() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)LichEntity.DATA_ISCLONE);
    }
    
    public void setShadowClone(final boolean shadowClone) {
        this.bossInfo.func_186758_d(!shadowClone);
        this.field_70180_af.func_187227_b((DataParameter)LichEntity.DATA_ISCLONE, (Object)shadowClone);
    }
    
    public byte getShieldStrength() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)LichEntity.DATA_SHIELDSTRENGTH);
    }
    
    public void setShieldStrength(final int shieldStrength) {
        this.field_70180_af.func_187227_b((DataParameter)LichEntity.DATA_SHIELDSTRENGTH, (Object)(byte)shieldStrength);
    }
    
    public byte getMinionsToSummon() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)LichEntity.DATA_MINIONSLEFT);
    }
    
    public void setMinionsToSummon(final int minionsToSummon) {
        this.field_70180_af.func_187227_b((DataParameter)LichEntity.DATA_MINIONSLEFT, (Object)(byte)minionsToSummon);
    }
    
    public byte getNextAttackType() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)LichEntity.DATA_ATTACKTYPE);
    }
    
    public void setNextAttackType(final int attackType) {
        this.field_70180_af.func_187227_b((DataParameter)LichEntity.DATA_ATTACKTYPE, (Object)(byte)attackType);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.LICH_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.LICH_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.LICH_DEATH;
    }
    
    public ResourceLocation func_184647_J() {
        return this.isShadowClone() ? null : LichEntity.LOOT_TABLE;
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74757_a("ShadowClone", this.isShadowClone());
        compound.func_74774_a("ShieldStrength", this.getShieldStrength());
        compound.func_74774_a("MinionsToSummon", this.getMinionsToSummon());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
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
            TFGenerationSettings.markStructureConquered(this.field_70170_p, new BlockPos((Vector3i)this.func_233580_cy_()), TFFeature.LICH_TOWER);
        }
    }
    
    public CreatureAttribute func_70668_bt() {
        return CreatureAttribute.field_223223_b_;
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/lich");
        POPPABLE = (Set)ImmutableSet.of((Object)SkeletonEntity.class, (Object)ZombieEntity.class, (Object)EndermanEntity.class, (Object)SpiderEntity.class, (Object)CreeperEntity.class, (Object)SwarmSpiderEntity.class, (Object[])new Class[0]);
        DATA_ISCLONE = EntityDataManager.func_187226_a((Class)LichEntity.class, DataSerializers.field_187198_h);
        DATA_SHIELDSTRENGTH = EntityDataManager.func_187226_a((Class)LichEntity.class, DataSerializers.field_187191_a);
        DATA_MINIONSLEFT = EntityDataManager.func_187226_a((Class)LichEntity.class, DataSerializers.field_187191_a);
        DATA_ATTACKTYPE = EntityDataManager.func_187226_a((Class)LichEntity.class, DataSerializers.field_187191_a);
    }
}
