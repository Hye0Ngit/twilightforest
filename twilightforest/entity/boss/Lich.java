// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.MobType;
import twilightforest.loot.TFTreasure;
import twilightforest.block.TwilightChest;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import twilightforest.advancements.TFAdvancements;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.world.registration.TFFeature;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import twilightforest.entity.monster.LichMinion;
import twilightforest.data.EntityTagGenerator;
import twilightforest.entity.projectile.LichBomb;
import twilightforest.entity.projectile.LichBolt;
import java.util.Iterator;
import net.minecraft.world.phys.AABB;
import twilightforest.block.AbstractLightableBlock;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.TFSounds;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.LichMinionsGoal;
import twilightforest.entity.ai.LichShadowsGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import twilightforest.entity.TFEntities;
import java.util.ArrayList;
import net.minecraft.world.BossEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;
import java.util.List;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Monster;

public class Lich extends Monster
{
    public static final ResourceLocation LOOT_TABLE;
    private static final EntityDataAccessor<Boolean> DATA_ISCLONE;
    private static final EntityDataAccessor<Byte> DATA_SHIELDSTRENGTH;
    private static final EntityDataAccessor<Byte> DATA_MINIONSLEFT;
    private static final EntityDataAccessor<Byte> DATA_ATTACKTYPE;
    public static final int MAX_SHADOW_CLONES = 2;
    public static final int INITIAL_SHIELD_STRENGTH = 6;
    public static final int MAX_ACTIVE_MINIONS = 3;
    public static final int INITIAL_MINIONS_TO_SUMMON = 9;
    public static final int MAX_HEALTH = 100;
    private Lich masterLich;
    private int attackCooldown;
    private int spawnTime;
    private final ServerBossEvent bossInfo;
    private final List<ServerPlayer> hurtBy;
    
    public Lich(final EntityType<? extends Lich> type, final Level world) {
        super((EntityType)type, world);
        this.bossInfo = new ServerBossEvent(this.m_5446_(), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.NOTCHED_6);
        this.hurtBy = new ArrayList<ServerPlayer>();
        this.setShadowClone(false);
        this.masterLich = null;
        this.m_5825_();
        this.f_21364_ = 217;
    }
    
    public Lich(final Level world, final Lich otherLich) {
        this(TFEntities.LICH, world);
        this.setShadowClone(true);
        this.masterLich = otherLich;
    }
    
    public Lich getMasterLich() {
        return this.masterLich;
    }
    
    public int getAttackCooldown() {
        return this.attackCooldown;
    }
    
    public void setAttackCooldown(final int cooldown) {
        this.attackCooldown = cooldown;
    }
    
    public void m_6593_(@Nullable final Component name) {
        super.m_6593_(name);
        this.bossInfo.m_6456_(this.m_5446_());
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new LichShadowsGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new LichMinionsGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal(this, 0.75, true) {
            public boolean m_8036_() {
                return Lich.this.getPhase() == 3 && super.m_8036_();
            }
            
            public void m_8056_() {
                super.m_8056_();
                Lich.this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42430_));
            }
        });
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, false));
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)Lich.DATA_ISCLONE, (Object)false);
        this.f_19804_.m_135372_((EntityDataAccessor)Lich.DATA_SHIELDSTRENGTH, (Object)6);
        this.f_19804_.m_135372_((EntityDataAccessor)Lich.DATA_MINIONSLEFT, (Object)9);
        this.f_19804_.m_135372_((EntityDataAccessor)Lich.DATA_ATTACKTYPE, (Object)0);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 100.0).m_22268_(Attributes.f_22281_, 3.0).m_22268_(Attributes.f_22279_, 0.45000001788139343);
    }
    
    public void m_6457_(final ServerPlayer player) {
        super.m_6457_(player);
        this.bossInfo.m_6543_(player);
    }
    
    public void m_6452_(final ServerPlayer player) {
        super.m_6452_(player);
        this.bossInfo.m_6539_(player);
    }
    
    public boolean m_6785_(final double p_213397_1_) {
        return false;
    }
    
    public void m_6043_() {
        if (this.f_19853_.m_46791_() == Difficulty.PEACEFUL && !this.isShadowClone()) {
            if (this.m_21536_()) {
                this.f_19853_.m_46597_(this.m_21534_(), ((Block)TFBlocks.LICH_BOSS_SPAWNER.get()).m_49966_());
            }
            this.m_146870_();
        }
        else {
            super.m_6043_();
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
    
    public void setExtinguishTimer() {
        this.spawnTime = 20;
    }
    
    public void m_8107_() {
        final float angle = this.f_20883_ * 3.141593f / 180.0f;
        final double dx = this.m_20185_() + Mth.m_14089_(angle) * 0.65;
        final double dy = this.m_20186_() + this.m_20206_() * 0.94;
        final double dz = this.m_20189_() + Mth.m_14031_(angle) * 0.65;
        final int factor = (80 - this.attackCooldown) / 10;
        for (int particles = (factor > 0) ? this.f_19796_.nextInt(factor) : 1, j1 = 0; j1 < particles; ++j1) {
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
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123811_, dx + this.f_19796_.nextGaussian() * 0.025, dy + this.f_19796_.nextGaussian() * 0.025, dz + this.f_19796_.nextGaussian() * 0.025, (double)red, (double)grn, (double)blu);
        }
        if (this.getPhase() == 3) {
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123792_, this.m_20185_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), this.m_20186_() + 1.0 + this.f_19796_.nextFloat() * this.m_20206_(), this.m_20189_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), this.f_19796_.nextGaussian() * 0.02, this.f_19796_.nextGaussian() * 0.02, this.f_19796_.nextGaussian() * 0.02);
        }
        if (!this.f_19853_.f_46443_) {
            if (this.getPhase() == 1) {
                this.bossInfo.m_142711_(this.getShieldStrength() / 6.0f);
            }
            else {
                this.bossInfo.m_5648_(BossEvent.BossBarOverlay.PROGRESS);
                this.bossInfo.m_142711_(this.m_21223_() / this.m_21233_());
                if (this.getPhase() == 2) {
                    this.bossInfo.m_6451_(BossEvent.BossBarColor.PURPLE);
                }
                else {
                    this.bossInfo.m_6451_(BossEvent.BossBarColor.RED);
                }
            }
        }
        super.m_8107_();
    }
    
    public boolean m_6469_(final DamageSource src, final float damage) {
        if ("inWall".equals(src.m_19385_()) && this.m_5448_() != null) {
            this.teleportToSightOfEntity((Entity)this.m_5448_());
        }
        if (this.isShadowClone() && src != DamageSource.f_19317_) {
            this.m_5496_(TFSounds.LICH_CLONE_HURT, 1.0f, ((this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            return false;
        }
        if (src.m_7639_() instanceof Lich) {
            return false;
        }
        if (src != DamageSource.f_19317_ && this.getShieldStrength() > 0) {
            if (src.m_19387_() && damage > 2.0f) {
                if (this.getShieldStrength() > 0) {
                    this.setShieldStrength(this.getShieldStrength() - 1);
                    this.m_5496_(TFSounds.SHIELD_BREAK, 1.0f, ((this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                }
            }
            else {
                this.m_5496_(TFSounds.SHIELD_BREAK, 1.0f, ((this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                if (src.m_7639_() instanceof final LivingEntity livingEntity) {
                    this.m_6703_(livingEntity);
                }
            }
            return false;
        }
        if (super.m_6469_(src, damage)) {
            if (this.m_142581_() instanceof Lich && ((Lich)this.m_142581_()).masterLich == this.masterLich) {
                this.m_6703_((LivingEntity)null);
            }
            if (this.getPhase() < 3 || this.f_19796_.nextInt(4) == 0) {
                this.teleportToSightOfEntity((Entity)this.m_5448_());
            }
            final Entity 7639_ = src.m_7639_();
            if (7639_ instanceof final ServerPlayer player) {
                if (!this.hurtBy.contains(player)) {
                    this.hurtBy.add(player);
                }
            }
            return true;
        }
        return false;
    }
    
    protected void m_8024_() {
        super.m_8024_();
        if (this.m_5448_() == null) {
            return;
        }
        if (this.attackCooldown > 0 && this.spawnTime <= 0) {
            --this.attackCooldown;
        }
        if (this.spawnTime > 0 && this.m_142582_((Entity)this.m_5448_())) {
            --this.spawnTime;
            if (this.spawnTime <= 0) {
                this.extinguishNearbyCandles();
            }
        }
        if (!this.isShadowClone() && this.attackCooldown % 15 == 0) {
            this.popNearbyMob();
        }
        this.m_21563_().m_24960_((Entity)this.m_5448_(), 100.0f, 100.0f);
    }
    
    private void extinguishNearbyCandles() {
        final AABB box = this.m_142469_().m_82400_(10.0);
        for (final BlockPos pos : BlockPos.m_121976_(Mth.m_14107_(box.f_82288_), Mth.m_14107_(box.f_82289_), Mth.m_14107_(box.f_82290_), Mth.m_14107_(box.f_82291_), Mth.m_14107_(box.f_82292_), Mth.m_14107_(box.f_82293_))) {
            if (this.f_19853_.m_8055_(pos).m_60734_() instanceof AbstractCandleBlock && (boolean)this.f_19853_.m_8055_(pos).m_61143_((Property)BlockStateProperties.f_61443_)) {
                this.f_19853_.m_46597_(pos, (BlockState)this.f_19853_.m_8055_(pos).m_61124_((Property)BlockStateProperties.f_61443_, (Comparable)false));
                this.f_19853_.m_5594_((Player)null, pos, SoundEvents.f_144098_, SoundSource.BLOCKS, 2.0f, 1.0f);
            }
            else {
                if (!(this.f_19853_.m_8055_(pos).m_60734_() instanceof AbstractLightableBlock) || this.f_19853_.m_8055_(pos).m_61143_((Property)AbstractLightableBlock.LIGHTING) != AbstractLightableBlock.Lighting.NORMAL) {
                    continue;
                }
                this.f_19853_.m_46597_(pos, (BlockState)this.f_19853_.m_8055_(pos).m_61124_((Property)AbstractLightableBlock.LIGHTING, (Comparable)AbstractLightableBlock.Lighting.OMINOUS));
                this.f_19853_.m_5594_((Player)null, pos, SoundEvents.f_144098_, SoundSource.BLOCKS, 2.0f, 0.75f);
            }
        }
    }
    
    public void launchBoltAt() {
        final float bodyFacingAngle = this.f_20883_ * 3.141593f / 180.0f;
        final double sx = this.m_20185_() + Mth.m_14089_(bodyFacingAngle) * 0.65;
        final double sy = this.m_20186_() + this.m_20206_() * 0.82;
        final double sz = this.m_20189_() + Mth.m_14031_(bodyFacingAngle) * 0.65;
        final double tx = this.m_5448_().m_20185_() - sx;
        final double ty = this.m_5448_().m_142469_().f_82289_ + this.m_5448_().m_20206_() / 2.0f - (this.m_20186_() + this.m_20206_() / 2.0f);
        final double tz = this.m_5448_().m_20189_() - sz;
        this.m_5496_(TFSounds.LICH_SHOOT, this.m_6121_(), (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.2f + 1.0f);
        final LichBolt projectile = new LichBolt(TFEntities.LICH_BOLT, this.f_19853_, (LivingEntity)this);
        projectile.m_7678_(sx, sy, sz, this.m_146908_(), this.m_146909_());
        projectile.m_6686_(tx, ty, tz, 0.5f, 1.0f);
        this.f_19853_.m_7967_((Entity)projectile);
    }
    
    public void launchBombAt() {
        final float bodyFacingAngle = this.f_20883_ * 3.141593f / 180.0f;
        final double sx = this.m_20185_() + Mth.m_14089_(bodyFacingAngle) * 0.65;
        final double sy = this.m_20186_() + this.m_20206_() * 0.82;
        final double sz = this.m_20189_() + Mth.m_14031_(bodyFacingAngle) * 0.65;
        final double tx = this.m_5448_().m_20185_() - sx;
        final double ty = this.m_5448_().m_142469_().f_82289_ + this.m_5448_().m_20206_() / 2.0f - (this.m_20186_() + this.m_20206_() / 2.0f);
        final double tz = this.m_5448_().m_20189_() - sz;
        this.m_5496_(TFSounds.LICH_SHOOT, this.m_6121_(), (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.2f + 1.0f);
        final LichBomb projectile = new LichBomb(TFEntities.LICH_BOMB, this.f_19853_, (LivingEntity)this);
        projectile.m_7678_(sx, sy, sz, this.m_146908_(), this.m_146909_());
        projectile.m_6686_(tx, ty, tz, 0.35f, 1.0f);
        this.f_19853_.m_7967_((Entity)projectile);
    }
    
    private void popNearbyMob() {
        final List<Mob> nearbyMobs = this.f_19853_.m_6443_((Class)Mob.class, new AABB(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_20185_() + 1.0, this.m_20186_() + 1.0, this.m_20189_() + 1.0).m_82377_(32.0, 16.0, 32.0), e -> EntityTagGenerator.LICH_POPPABLES.m_8110_((Object)e.m_6095_()));
        for (final Mob mob : nearbyMobs) {
            if (this.m_21574_().m_148306_((Entity)mob)) {
                mob.m_21373_();
                mob.m_146870_();
                this.makeRedMagicTrail(mob.m_20185_(), mob.m_20186_() + mob.m_20206_() / 2.0, mob.m_20189_(), this.m_20185_(), this.m_20186_() + this.m_20206_() / 2.0, this.m_20189_());
                break;
            }
        }
    }
    
    public boolean wantsNewClone(final Lich clone) {
        return clone.isShadowClone() && this.countMyClones() < 2;
    }
    
    public void setMaster(final Lich lich) {
        this.masterLich = lich;
    }
    
    public int countMyClones() {
        int count = 0;
        for (final Lich nearbyLich : this.getNearbyLiches()) {
            if (nearbyLich.isShadowClone() && nearbyLich.getMasterLich() == this) {
                ++count;
            }
        }
        return count;
    }
    
    public List<? extends Lich> getNearbyLiches() {
        return this.f_19853_.m_45976_((Class)this.getClass(), new AABB(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_20185_() + 1.0, this.m_20186_() + 1.0, this.m_20189_() + 1.0).m_82377_(32.0, 16.0, 32.0));
    }
    
    public boolean wantsNewMinion() {
        return this.countMyMinions() < 3;
    }
    
    public int countMyMinions() {
        return (int)this.f_19853_.m_45976_((Class)LichMinion.class, new AABB(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_20185_() + 1.0, this.m_20186_() + 1.0, this.m_20189_() + 1.0).m_82377_(32.0, 16.0, 32.0)).stream().filter(m -> m.master == this).count();
    }
    
    public void teleportToSightOfEntity(final Entity entity) {
        final Vec3 dest = this.findVecInLOSOf(entity);
        final double srcX = this.m_20185_();
        final double srcY = this.m_20186_();
        final double srcZ = this.m_20189_();
        if (dest != null) {
            this.teleportToNoChecks(dest.f_82479_, dest.f_82480_, dest.f_82481_);
            this.m_21563_().m_24960_(entity, 100.0f, 100.0f);
            this.f_20883_ = this.m_146908_();
            if (!this.m_21574_().m_148306_(entity)) {
                this.teleportToNoChecks(srcX, srcY, srcZ);
            }
        }
    }
    
    @Nullable
    public Vec3 findVecInLOSOf(final Entity targetEntity) {
        if (targetEntity == null) {
            return null;
        }
        final double origX = this.m_20185_();
        final double origY = this.m_20186_();
        final double origZ = this.m_20189_();
        for (int tries = 100, i = 0; i < tries; ++i) {
            final double tx = targetEntity.m_20185_() + this.f_19796_.nextGaussian() * 16.0;
            final double ty = targetEntity.m_20186_();
            final double tz = targetEntity.m_20189_() + this.f_19796_.nextGaussian() * 16.0;
            final boolean destClear = this.m_20984_(tx, ty, tz, true);
            final boolean canSeeTargetAtDest = this.m_142582_(targetEntity);
            this.m_6021_(origX, origY, origZ);
            if (destClear && canSeeTargetAtDest) {
                return new Vec3(tx, ty, tz);
            }
        }
        return null;
    }
    
    private void teleportToNoChecks(final double destX, final double destY, final double destZ) {
        final double srcX = this.m_20185_();
        final double srcY = this.m_20186_();
        final double srcZ = this.m_20189_();
        this.m_6021_(destX, destY, destZ);
        this.makeTeleportTrail(srcX, srcY, srcZ, destX, destY, destZ);
        this.f_19853_.m_6263_((Player)null, srcX, srcY, srcZ, TFSounds.LICH_TELEPORT, this.m_5720_(), 1.0f, 1.0f);
        this.m_5496_(TFSounds.LICH_TELEPORT, 1.0f, 1.0f);
        this.f_20899_ = false;
    }
    
    public void makeTeleportTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 128, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = (this.f_19796_.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.f_19796_.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.f_19796_.nextFloat() - 0.5f) * 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 2.0;
            final double ty = srcY + (destY - srcY) * trailFactor + this.f_19796_.nextDouble() * this.m_20206_();
            final double tz = srcZ + (destZ - srcZ) * trailFactor + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 2.0;
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123806_, tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    private void makeRedMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.f_19796_.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.f_19796_.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.f_19796_.nextGaussian() * 0.005;
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123811_, tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public void makeBlackMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 0.2f;
            final float f2 = 0.2f;
            final float f3 = 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.f_19796_.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.f_19796_.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.f_19796_.nextGaussian() * 0.005;
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123811_, tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public boolean isShadowClone() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)Lich.DATA_ISCLONE);
    }
    
    public void setShadowClone(final boolean shadowClone) {
        this.bossInfo.m_8321_(!shadowClone);
        this.f_19804_.m_135381_((EntityDataAccessor)Lich.DATA_ISCLONE, (Object)shadowClone);
    }
    
    public byte getShieldStrength() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)Lich.DATA_SHIELDSTRENGTH);
    }
    
    public void setShieldStrength(final int shieldStrength) {
        this.f_19804_.m_135381_((EntityDataAccessor)Lich.DATA_SHIELDSTRENGTH, (Object)(byte)shieldStrength);
    }
    
    public byte getMinionsToSummon() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)Lich.DATA_MINIONSLEFT);
    }
    
    public void setMinionsToSummon(final int minionsToSummon) {
        this.f_19804_.m_135381_((EntityDataAccessor)Lich.DATA_MINIONSLEFT, (Object)(byte)minionsToSummon);
    }
    
    public byte getNextAttackType() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)Lich.DATA_ATTACKTYPE);
    }
    
    public void setNextAttackType(final int attackType) {
        this.f_19804_.m_135381_((EntityDataAccessor)Lich.DATA_ATTACKTYPE, (Object)(byte)attackType);
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.LICH_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.LICH_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.LICH_DEATH;
    }
    
    public ResourceLocation m_7582_() {
        return this.isShadowClone() ? null : Lich.LOOT_TABLE;
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128379_("ShadowClone", this.isShadowClone());
        compound.m_128344_("ShieldStrength", this.getShieldStrength());
        compound.m_128344_("MinionsToSummon", this.getMinionsToSummon());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setShadowClone(compound.m_128471_("ShadowClone"));
        this.setShieldStrength(compound.m_128445_("ShieldStrength"));
        this.setMinionsToSummon(compound.m_128445_("MinionsToSummon"));
        if (this.m_8077_()) {
            this.bossInfo.m_6456_(this.m_5446_());
        }
    }
    
    public void m_6667_(final DamageSource cause) {
        super.m_6667_(cause);
        if (!this.f_19853_.f_46443_ && !this.isShadowClone()) {
            TFGenerationSettings.markStructureConquered(this.f_19853_, new BlockPos((Vec3i)this.m_142538_()), TFFeature.LICH_TOWER);
            for (final ServerPlayer player : this.hurtBy) {
                TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
            }
            TFTreasure.entityDropsIntoContainer((LivingEntity)this, this.m_7771_(true, cause).m_78975_(LootContextParamSets.f_81415_), this.f_19796_.nextBoolean() ? ((TwilightChest)TFBlocks.TWILIGHT_OAK_CHEST.get()).m_49966_() : ((TwilightChest)TFBlocks.CANOPY_CHEST.get()).m_49966_(), new BlockPos(this.m_20182_()));
        }
    }
    
    protected boolean m_6125_() {
        return false;
    }
    
    public MobType m_6336_() {
        return MobType.f_21641_;
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/lich");
        DATA_ISCLONE = SynchedEntityData.m_135353_((Class)Lich.class, EntityDataSerializers.f_135035_);
        DATA_SHIELDSTRENGTH = SynchedEntityData.m_135353_((Class)Lich.class, EntityDataSerializers.f_135027_);
        DATA_MINIONSLEFT = SynchedEntityData.m_135353_((Class)Lich.class, EntityDataSerializers.f_135027_);
        DATA_ATTACKTYPE = SynchedEntityData.m_135353_((Class)Lich.class, EntityDataSerializers.f_135027_);
    }
}
