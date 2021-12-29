// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.level.GameRules;
import twilightforest.loot.TFTreasure;
import twilightforest.block.TwilightChest;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import twilightforest.advancements.TFAdvancements;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.world.registration.TFFeature;
import net.minecraft.core.Vec3i;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import twilightforest.entity.TFPart;
import net.minecraft.network.protocol.game.ClientboundAddMobPacket;
import net.minecraftforge.entity.PartEntity;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.util.EntityUtil;
import twilightforest.util.WorldUtil;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.core.BlockPos;
import java.util.Iterator;
import java.util.function.ToDoubleFunction;
import java.util.Comparator;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import net.minecraft.world.BossEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;
import java.util.List;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.Mob;

public class Hydra extends Mob implements Enemy
{
    private static final int TICKS_BEFORE_HEALING = 1000;
    private static final int HEAD_RESPAWN_TICKS = 100;
    private static final int HEAD_MAX_DAMAGE = 120;
    private static final float ARMOR_MULTIPLIER = 8.0f;
    private static final int MAX_HEALTH = 360;
    private static float HEADS_ACTIVITY_FACTOR;
    private static final int SECONDARY_FLAME_CHANCE = 10;
    private static final int SECONDARY_MORTAR_CHANCE = 16;
    private final HydraPart[] partArray;
    public final int numHeads = 7;
    public final HydraHeadContainer[] hc;
    public final HydraSmallPart body;
    private final HydraSmallPart leftLeg;
    private final HydraSmallPart rightLeg;
    private final HydraSmallPart tail;
    private final ServerBossEvent bossInfo;
    private float randomYawVelocity;
    private int ticksSinceDamaged;
    private final List<ServerPlayer> hurtBy;
    private int numTicksToChaseTarget;
    
    public Hydra(final EntityType<? extends Hydra> type, final Level world) {
        super((EntityType)type, world);
        this.hc = new HydraHeadContainer[7];
        this.bossInfo = new ServerBossEvent(this.m_5446_(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);
        this.randomYawVelocity = 0.0f;
        this.ticksSinceDamaged = 0;
        this.hurtBy = new ArrayList<ServerPlayer>();
        final List<HydraPart> parts = new ArrayList<HydraPart>();
        this.body = new HydraSmallPart(this, 6.0f, 6.0f);
        this.leftLeg = new HydraSmallPart(this, 2.0f, 3.0f);
        this.rightLeg = new HydraSmallPart(this, 2.0f, 3.0f);
        this.tail = new HydraSmallPart(this, 6.0f, 2.0f);
        parts.add(this.body);
        parts.add(this.leftLeg);
        parts.add(this.rightLeg);
        parts.add(this.tail);
        for (int i = 0; i < 7; ++i) {
            this.hc[i] = new HydraHeadContainer(this, i, i < 3);
            parts.add(this.hc[i].headEntity);
            Collections.addAll(parts, this.hc[i].getNeckArray());
        }
        this.partArray = parts.toArray(new HydraPart[0]);
        this.f_19811_ = true;
        this.m_5825_();
        this.f_21364_ = 511;
    }
    
    public void m_6593_(@Nullable final Component name) {
        super.m_6593_(name);
        this.bossInfo.m_6456_(this.m_5446_());
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 360.0).m_22268_(Attributes.f_22279_, 0.28);
    }
    
    public void m_6457_(final ServerPlayer player) {
        super.m_6457_(player);
        this.bossInfo.m_6543_(player);
    }
    
    public void m_6452_(final ServerPlayer player) {
        super.m_6452_(player);
        this.bossInfo.m_6539_(player);
    }
    
    public void m_6043_() {
        if (this.f_19853_.m_46791_() == Difficulty.PEACEFUL) {
            this.f_19853_.m_46597_(this.m_142538_().m_142082_(0, 2, 0), ((Block)TFBlocks.HYDRA_BOSS_SPAWNER.get()).m_49966_());
            this.m_146870_();
            for (final HydraHeadContainer container : this.hc) {
                if (container.headEntity != null) {
                    container.headEntity.m_146870_();
                }
            }
        }
        else {
            super.m_6043_();
        }
    }
    
    protected float m_5632_(final float p_110146_1_, float p_110146_2_) {
        final float f = Mth.m_14177_(p_110146_1_ - this.f_20883_);
        this.f_20883_ += f * 0.3f;
        float f2 = Mth.m_14177_(this.m_146908_() - this.f_20883_);
        final boolean flag = f2 < -90.0f || f2 >= 90.0f;
        if (f2 < -75.0f) {
            f2 = -75.0f;
        }
        if (f2 >= 75.0f) {
            f2 = 75.0f;
        }
        this.f_20883_ = this.m_146908_() - f2;
        if (f2 * f2 > 2500.0f) {
            this.f_20883_ += f2 * 0.2f;
        }
        if (flag) {
            p_110146_2_ *= -1.0f;
        }
        return p_110146_2_;
    }
    
    public void m_8107_() {
        this.m_20095_();
        this.body.m_8119_();
        this.leftLeg.m_8119_();
        this.rightLeg.m_8119_();
        for (int i = 0; i < 7; ++i) {
            this.hc[i].tick();
        }
        if (this.f_20916_ > 0) {
            for (int i = 0; i < 7; ++i) {
                this.hc[i].setHurtTime(this.f_20916_);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.f_19853_.f_46443_ && this.ticksSinceDamaged > 1000 && this.ticksSinceDamaged % 5 == 0) {
            this.m_5634_(1.0f);
        }
        this.setDifficultyVariables();
        super.m_8107_();
        final float angle = (this.f_20883_ + 180.0f) * 3.141593f / 180.0f;
        double dx = this.m_20185_() - Mth.m_14031_(angle) * 3.0;
        double dy = this.m_20186_() + 0.1;
        double dz = this.m_20189_() + Mth.m_14089_(angle) * 3.0;
        this.body.m_6034_(dx, dy, dz);
        dx = this.m_20185_() - Mth.m_14031_(angle) * 10.5;
        dy = this.m_20186_() + 0.1;
        dz = this.m_20189_() + Mth.m_14089_(angle) * 10.5;
        this.tail.m_6034_(dx, dy, dz);
        if (!this.f_19853_.f_46443_) {
            if (this.f_20916_ == 0) {
                this.collideWithEntities(this.f_19853_.m_45933_((Entity)this, this.body.m_142469_()), (Entity)this.body);
                this.collideWithEntities(this.f_19853_.m_45933_((Entity)this, this.tail.m_142469_()), (Entity)this.tail);
            }
            this.destroyBlocksInAABB(this.body.m_142469_());
            this.destroyBlocksInAABB(this.tail.m_142469_());
            for (int j = 0; j < 7; ++j) {
                if (this.hc[j].headEntity != null && this.hc[j].isActive()) {
                    this.destroyBlocksInAABB(this.hc[j].headEntity.m_142469_());
                }
            }
            if (this.f_19797_ % 20 == 0 && this.isUnsteadySurfaceBeneath()) {
                this.destroyBlocksInAABB(this.m_142469_().m_82386_(0.0, -1.0, 0.0));
            }
            this.bossInfo.m_142711_(this.m_21223_() / this.m_21233_());
        }
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128344_("NumHeads", (byte)this.countActiveHeads());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.activateNumberOfHeads(compound.m_128445_("NumHeads"));
        if (this.m_8077_()) {
            this.bossInfo.m_6456_(this.m_5446_());
        }
    }
    
    protected void m_8024_() {
        this.f_20900_ = 0.0f;
        this.f_20902_ = 0.0f;
        final float f = 48.0f;
        for (int i = 0; i < 7; ++i) {
            if (this.hc[i].isActive() && this.hc[i].getDamageTaken() > 120) {
                this.hc[i].setNextState(HydraHeadContainer.State.DYING);
                this.hc[i].endCurrentAction();
                this.hc[i].setRespawnCounter(100);
                final int otherHead = this.getRandomDeadHead();
                if (otherHead != -1) {
                    this.hc[otherHead].setRespawnCounter(100);
                }
            }
        }
        if (this.f_19796_.nextFloat() < 0.7f) {
            final Player entityplayer1 = this.f_19853_.m_45930_((Entity)this, (double)f);
            if (entityplayer1 != null && !entityplayer1.m_7500_()) {
                this.m_6710_((LivingEntity)entityplayer1);
                this.numTicksToChaseTarget = 100 + this.f_19796_.nextInt(20);
            }
            else {
                this.randomYawVelocity = (this.f_19796_.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.m_5448_() != null) {
            this.m_21391_((Entity)this.m_5448_(), 10.0f, (float)this.m_8132_());
            for (int i = 0; i < 7; ++i) {
                if (!this.hc[i].isAttacking() && !this.hc[i].isSecondaryAttacking) {
                    this.hc[i].setTargetEntity((Entity)this.m_5448_());
                }
            }
            if (this.m_5448_().m_6084_()) {
                final float distance = this.m_5448_().m_20270_((Entity)this);
                if (this.m_21574_().m_148306_((Entity)this.m_5448_())) {
                    this.attackEntity((Entity)this.m_5448_(), distance);
                }
            }
            if (this.numTicksToChaseTarget-- <= 0 || !this.m_5448_().m_6084_() || this.m_5448_().m_20280_((Entity)this) > f * f) {
                this.m_6710_((LivingEntity)null);
            }
        }
        else {
            if (this.f_19796_.nextFloat() < 0.05f) {
                this.randomYawVelocity = (this.f_19796_.nextFloat() - 0.5f) * 20.0f;
            }
            this.m_146922_(this.m_146908_() + this.randomYawVelocity);
            this.m_146926_(0.0f);
            for (int i = 0; i < 7; ++i) {
                if (this.hc[i].isIdle()) {
                    this.hc[i].setTargetEntity(null);
                }
            }
        }
        this.secondaryAttacks();
    }
    
    private void setDifficultyVariables() {
        if (this.f_19853_.m_46791_() != Difficulty.HARD) {
            Hydra.HEADS_ACTIVITY_FACTOR = 0.3f;
        }
        else {
            Hydra.HEADS_ACTIVITY_FACTOR = 0.5f;
        }
    }
    
    private int getRandomDeadHead() {
        for (int i = 0; i < 7; ++i) {
            if (this.hc[i].canRespawn()) {
                return i;
            }
        }
        return -1;
    }
    
    private void activateNumberOfHeads(final int howMany) {
        for (int moreHeads = howMany - this.countActiveHeads(), i = 0; i < moreHeads; ++i) {
            final int otherHead = this.getRandomDeadHead();
            if (otherHead != -1) {
                this.hc[otherHead].setNextState(HydraHeadContainer.State.IDLE);
                this.hc[otherHead].endCurrentAction();
            }
        }
    }
    
    private void attackEntity(final Entity target, final float distance) {
        final int BITE_CHANCE = 10;
        final int FLAME_CHANCE = 100;
        final int MORTAR_CHANCE = 160;
        final boolean targetAbove = target.m_142469_().f_82289_ > this.m_142469_().f_82292_;
        for (int i = 0; i < 3; ++i) {
            if (this.hc[i].isIdle() && !this.areTooManyHeadsAttacking(i)) {
                if (distance > 4.0f && distance < 10.0f && this.f_19796_.nextInt(BITE_CHANCE) == 0 && this.countActiveHeads() > 2 && !this.areOtherHeadsBiting(i)) {
                    this.hc[i].setNextState(HydraHeadContainer.State.BITE_BEGINNING);
                }
                else if (distance > 0.0f && distance < 20.0f && this.f_19796_.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(HydraHeadContainer.State.FLAME_BEGINNING);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.f_19796_.nextInt(MORTAR_CHANCE) == 0) {
                    this.hc[i].setNextState(HydraHeadContainer.State.MORTAR_BEGINNING);
                }
            }
        }
        for (int i = 3; i < 7; ++i) {
            if (this.hc[i].isIdle() && !this.areTooManyHeadsAttacking(i)) {
                if (distance > 0.0f && distance < 20.0f && this.f_19796_.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(HydraHeadContainer.State.FLAME_BEGINNING);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.f_19796_.nextInt(MORTAR_CHANCE) == 0) {
                    this.hc[i].setNextState(HydraHeadContainer.State.MORTAR_BEGINNING);
                }
            }
        }
    }
    
    private boolean areTooManyHeadsAttacking(final int testHead) {
        int otherAttacks = 0;
        for (int i = 0; i < 7; ++i) {
            if (i != testHead && this.hc[i].isAttacking()) {
                ++otherAttacks;
                if (this.hc[i].isBiting()) {
                    otherAttacks += 2;
                }
            }
        }
        return otherAttacks >= 1.0f + this.countActiveHeads() * Hydra.HEADS_ACTIVITY_FACTOR;
    }
    
    private int countActiveHeads() {
        int count = 0;
        for (int i = 0; i < 7; ++i) {
            if (this.hc[i].isActive()) {
                ++count;
            }
        }
        return count;
    }
    
    private boolean areOtherHeadsBiting(final int testHead) {
        for (int i = 0; i < 7; ++i) {
            if (i != testHead && this.hc[i].isBiting()) {
                return true;
            }
        }
        return false;
    }
    
    private void secondaryAttacks() {
        for (int i = 0; i < 7; ++i) {
            if (this.hc[i].headEntity == null) {
                return;
            }
        }
        final LivingEntity secondaryTarget = this.findSecondaryTarget(20.0);
        if (secondaryTarget != null) {
            final float distance = secondaryTarget.m_20270_((Entity)this);
            for (int j = 1; j < 7; ++j) {
                if (this.hc[j].isActive() && this.hc[j].isIdle() && this.isTargetOnThisSide(j, (Entity)secondaryTarget)) {
                    if (distance > 0.0f && distance < 20.0f && this.f_19796_.nextInt(10) == 0) {
                        this.hc[j].setTargetEntity((Entity)secondaryTarget);
                        this.hc[j].isSecondaryAttacking = true;
                        this.hc[j].setNextState(HydraHeadContainer.State.FLAME_BEGINNING);
                    }
                    else if (distance > 8.0f && distance < 32.0f && this.f_19796_.nextInt(16) == 0) {
                        this.hc[j].setTargetEntity((Entity)secondaryTarget);
                        this.hc[j].isSecondaryAttacking = true;
                        this.hc[j].setNextState(HydraHeadContainer.State.MORTAR_BEGINNING);
                    }
                }
            }
        }
    }
    
    private boolean isTargetOnThisSide(final int headNum, final Entity target) {
        final double headDist = this.distanceSqXZ((Entity)this.hc[headNum].headEntity, target);
        final double middleDist = this.distanceSqXZ((Entity)this, target);
        return headDist < middleDist;
    }
    
    private double distanceSqXZ(final Entity headEntity, final Entity target) {
        final double distX = headEntity.m_20185_() - target.m_20185_();
        final double distZ = headEntity.m_20189_() - target.m_20189_();
        return distX * distX + distZ * distZ;
    }
    
    @Nullable
    private LivingEntity findSecondaryTarget(final double range) {
        return (LivingEntity)this.f_19853_.m_45976_((Class)LivingEntity.class, new AABB(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_20185_() + 1.0, this.m_20186_() + 1.0, this.m_20189_() + 1.0).m_82377_(range, range, range)).stream().filter(e -> !(e instanceof Hydra)).filter(e -> e != this.m_5448_() && !this.isAnyHeadTargeting((Entity)e) && this.m_21574_().m_148306_((Entity)e) && EntitySelector.f_20406_.test(e)).min(Comparator.comparingDouble((ToDoubleFunction<? super T>)this::m_20280_)).orElse(null);
    }
    
    private boolean isAnyHeadTargeting(final Entity targetEntity) {
        for (int i = 0; i < 7; ++i) {
            if (this.hc[i].targetEntity != null && this.hc[i].targetEntity.equals((Object)targetEntity)) {
                return true;
            }
        }
        return false;
    }
    
    private void collideWithEntities(final List<Entity> entities, final Entity part) {
        final double d0 = (part.m_142469_().f_82288_ + part.m_142469_().f_82291_) / 2.0;
        final double d2 = (part.m_142469_().f_82290_ + part.m_142469_().f_82293_) / 2.0;
        for (final Entity entity : entities) {
            if (entity instanceof LivingEntity) {
                final double d3 = entity.m_20185_() - d0;
                final double d4 = entity.m_20189_() - d2;
                final double d5 = d3 * d3 + d4 * d4;
                entity.m_5997_(d3 / d5 * 4.0, 0.20000000298023224, d4 / d5 * 4.0);
            }
        }
    }
    
    private boolean isUnsteadySurfaceBeneath() {
        final int minX = Mth.m_14107_(this.m_142469_().f_82288_);
        final int minZ = Mth.m_14107_(this.m_142469_().f_82290_);
        final int maxX = Mth.m_14107_(this.m_142469_().f_82291_);
        final int maxZ = Mth.m_14107_(this.m_142469_().f_82293_);
        final int minY = Mth.m_14107_(this.m_142469_().f_82289_);
        int solid = 0;
        int total = 0;
        final int dy = minY - 1;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dz = minZ; dz <= maxZ; ++dz) {
                ++total;
                if (this.f_19853_.m_8055_(new BlockPos(dx, dy, dz)).m_60767_().m_76333_()) {
                    ++solid;
                }
            }
        }
        return solid / (float)total < 0.6f;
    }
    
    private void destroyBlocksInAABB(final AABB box) {
        if (ForgeEventFactory.getMobGriefingEvent(this.f_19853_, (Entity)this)) {
            for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
                if (EntityUtil.canDestroyBlock(this.f_19853_, pos, (Entity)this)) {
                    this.f_19853_.m_46961_(pos, false);
                }
            }
        }
    }
    
    public int m_8132_() {
        return 500;
    }
    
    public boolean attackEntityFromPart(final HydraPart part, final DamageSource source, final float damage) {
        if (!this.f_19853_.f_46443_ && source == DamageSource.f_19310_) {
            this.destroyBlocksInAABB(part.m_142469_());
        }
        if (source.m_7639_() == this || source.m_7640_() == this) {
            return false;
        }
        if (this.getParts() != null) {
            for (final PartEntity<?> partEntity : this.getParts()) {
                if (partEntity == source.m_7639_() || partEntity == source.m_7640_()) {
                    return false;
                }
            }
        }
        HydraHeadContainer headCon = null;
        for (int i = 0; i < 7; ++i) {
            if (this.hc[i].headEntity == part) {
                headCon = this.hc[i];
            }
            else if (part instanceof HydraNeck && this.hc[i].headEntity == ((HydraNeck)part).head && !this.hc[i].isActive()) {
                return false;
            }
        }
        final double range = this.calculateRange(source);
        if (range > 400 + ((source.m_7640_() instanceof HydraMortarHead) ? 200 : 0)) {
            return false;
        }
        if (headCon != null && !headCon.isActive()) {
            return false;
        }
        boolean tookDamage;
        if (headCon != null && headCon.getCurrentMouthOpen() > 0.5) {
            tookDamage = super.m_6469_(source, damage);
            headCon.addDamage(damage);
        }
        else {
            final int armoredDamage = Math.round(damage / 8.0f);
            tookDamage = super.m_6469_(source, (float)armoredDamage);
            if (headCon != null) {
                headCon.addDamage((float)armoredDamage);
            }
        }
        if (tookDamage) {
            this.ticksSinceDamaged = 0;
        }
        return tookDamage;
    }
    
    private double calculateRange(final DamageSource damagesource) {
        return (damagesource.m_7639_() != null) ? this.m_20280_(damagesource.m_7639_()) : -1.0;
    }
    
    public boolean m_6469_(final DamageSource src, final float damage) {
        final Entity 7639_ = src.m_7639_();
        if (7639_ instanceof final ServerPlayer player) {
            if (!this.hurtBy.contains(player)) {
                this.hurtBy.add(player);
            }
        }
        return src == DamageSource.f_19317_ && super.m_6469_(src, damage);
    }
    
    public boolean isMultipartEntity() {
        return true;
    }
    
    @Nullable
    public PartEntity<?>[] getParts() {
        return this.partArray;
    }
    
    public void m_142223_(final ClientboundAddMobPacket p_147206_) {
        super.m_142223_(p_147206_);
        TFPart.assignPartIDs((Entity)this);
    }
    
    public boolean m_6087_() {
        return false;
    }
    
    public boolean m_6094_() {
        return false;
    }
    
    protected void m_7324_(final Entity entity) {
    }
    
    public void m_147240_(final double strength, final double xRatio, final double zRatio) {
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.HYDRA_GROWL;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.HYDRA_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.HYDRA_DEATH;
    }
    
    protected float m_6121_() {
        return 2.0f;
    }
    
    public void m_6667_(final DamageSource cause) {
        super.m_6667_(cause);
        if (!this.f_19853_.f_46443_) {
            TFGenerationSettings.markStructureConquered(this.f_19853_, new BlockPos((Vec3i)this.m_142538_()), TFFeature.HYDRA_LAIR);
            for (final ServerPlayer player : this.hurtBy) {
                TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
            }
            TFTreasure.entityDropsIntoContainer((LivingEntity)this, this.m_7771_(true, cause).m_78975_(LootContextParamSets.f_81415_), ((TwilightChest)TFBlocks.MANGROVE_CHEST.get()).m_49966_(), new BlockPos(this.m_20182_()));
        }
    }
    
    protected boolean m_6125_() {
        return false;
    }
    
    public boolean m_6785_(final double distance) {
        return false;
    }
    
    public boolean m_6060_() {
        return false;
    }
    
    protected void m_6153_() {
        ++this.f_20919_;
        if (this.f_20919_ == 1) {
            for (int i = 0; i < 7; ++i) {
                this.hc[i].setRespawnCounter(-1);
                if (this.hc[i].isActive()) {
                    this.hc[i].setNextState(HydraHeadContainer.State.IDLE);
                    this.hc[i].endCurrentAction();
                    this.hc[i].setHurtTime(200);
                }
            }
        }
        if (this.f_20919_ <= 140 && this.f_20919_ % 20 == 0) {
            final int headToDie = this.f_20919_ / 20 - 1;
            if (this.hc[headToDie].isActive()) {
                this.hc[headToDie].setNextState(HydraHeadContainer.State.DYING);
                this.hc[headToDie].endCurrentAction();
            }
        }
        if (this.f_20919_ == 200) {
            if (!this.f_19853_.f_46443_ && (this.m_6124_() || (this.f_20889_ > 0 && this.m_6149_() && this.f_19853_.m_46469_().m_46207_(GameRules.f_46135_)))) {
                int i = this.m_6552_(this.f_20888_);
                i = ForgeEventFactory.getExperienceDrop((LivingEntity)this, this.f_20888_, i);
                while (i > 0) {
                    final int j = ExperienceOrb.m_20782_(i);
                    i -= j;
                    this.f_19853_.m_7967_((Entity)new ExperienceOrb(this.f_19853_, this.m_20185_(), this.m_20186_(), this.m_20189_(), j));
                }
            }
            this.m_146870_();
        }
        for (int i = 0; i < 20; ++i) {
            final double vx = this.f_19796_.nextGaussian() * 0.02;
            final double vy = this.f_19796_.nextGaussian() * 0.02;
            final double vz = this.f_19796_.nextGaussian() * 0.02;
            this.f_19853_.m_7106_((ParticleOptions)((this.f_19796_.nextInt(2) == 0) ? ParticleTypes.f_123812_ : ParticleTypes.f_123813_), this.m_20185_() + this.f_19796_.nextFloat() * this.body.m_20205_() * 2.0f - this.body.m_20205_(), this.m_20186_() + this.f_19796_.nextFloat() * this.body.m_20206_(), this.m_20189_() + this.f_19796_.nextFloat() * this.body.m_20205_() * 2.0f - this.body.m_20205_(), vx, vy, vz);
        }
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    static {
        Hydra.HEADS_ACTIVITY_FACTOR = 0.3f;
    }
}
