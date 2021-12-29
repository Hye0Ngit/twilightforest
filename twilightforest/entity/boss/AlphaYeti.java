// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import twilightforest.loot.TFTreasure;
import twilightforest.block.TwilightChest;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import twilightforest.advancements.TFAdvancements;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.world.registration.TFFeature;
import net.minecraft.core.Vec3i;
import twilightforest.block.TFBlocks;
import net.minecraft.world.Difficulty;
import twilightforest.entity.projectile.IceBomb;
import twilightforest.entity.TFEntities;
import twilightforest.entity.projectile.FallingIce;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.util.Mth;
import java.util.Iterator;
import twilightforest.util.EntityUtil;
import net.minecraft.core.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.sounds.SoundEvent;
import twilightforest.entity.projectile.TwilightWandBolt;
import net.minecraft.world.damagesource.DamageSource;
import javax.annotation.Nullable;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import twilightforest.TFSounds;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.entity.ai.ThrowRiderGoal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import twilightforest.entity.ai.YetiRampageGoal;
import net.minecraft.world.entity.PathfinderMob;
import twilightforest.entity.ai.StayNearHomeGoal;
import twilightforest.entity.ai.YetiTiredGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import java.util.ArrayList;
import net.minecraft.world.BossEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;
import java.util.List;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.IHostileMount;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;

public class AlphaYeti extends Monster implements RangedAttackMob, IHostileMount
{
    private static final EntityDataAccessor<Byte> RAMPAGE_FLAG;
    private static final EntityDataAccessor<Byte> TIRED_FLAG;
    private final ServerBossEvent bossInfo;
    private int collisionCounter;
    private boolean canRampage;
    private final List<ServerPlayer> hurtBy;
    
    public AlphaYeti(final EntityType<? extends AlphaYeti> type, final Level world) {
        super((EntityType)type, world);
        this.bossInfo = new ServerBossEvent(this.m_5446_(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS);
        this.hurtBy = new ArrayList<ServerPlayer>();
        this.f_21364_ = 317;
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new YetiTiredGoal(this, 100));
        this.f_21345_.m_25352_(2, (Goal)new StayNearHomeGoal((PathfinderMob)this, 2.0f));
        this.f_21345_.m_25352_(3, (Goal)new YetiRampageGoal(this, 10, 180));
        this.f_21345_.m_25352_(4, (Goal)new RangedAttackGoal(this, 1.0, 40, 40, 40.0f) {
            public boolean m_8036_() {
                return AlphaYeti.this.m_21187_().nextInt(50) > 0 && AlphaYeti.this.m_5448_() != null && AlphaYeti.this.m_20280_((Entity)AlphaYeti.this.m_5448_()) >= 16.0 && super.m_8036_();
            }
        });
        this.f_21345_.m_25352_(4, (Goal)new ThrowRiderGoal(this, 1.0, false) {
            @Override
            protected void m_6739_(final LivingEntity victim, final double p_190102_2_) {
                super.m_6739_(victim, p_190102_2_);
                if (!AlphaYeti.this.m_20197_().isEmpty()) {
                    AlphaYeti.this.m_5496_(TFSounds.ALPHAYETI_GRAB, 4.0f, 0.75f + AlphaYeti.this.m_21187_().nextFloat() * 0.25f);
                }
            }
            
            @Override
            public void m_8041_() {
                if (!AlphaYeti.this.m_20197_().isEmpty()) {
                    AlphaYeti.this.m_5496_(TFSounds.ALPHAYETI_THROW, 4.0f, 0.75f + AlphaYeti.this.m_21187_().nextFloat() * 0.25f);
                }
                super.m_8041_();
            }
        });
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 2.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)AlphaYeti.RAMPAGE_FLAG, (Object)0);
        this.f_19804_.m_135372_((EntityDataAccessor)AlphaYeti.TIRED_FLAG, (Object)0);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 200.0).m_22268_(Attributes.f_22279_, 0.38).m_22268_(Attributes.f_22281_, 1.0).m_22268_(Attributes.f_22277_, 40.0);
    }
    
    public void m_8107_() {
        if (!this.m_20197_().isEmpty() && this.m_20197_().get(0).m_6144_()) {
            this.m_20197_().get(0).m_20260_(false);
        }
        super.m_8107_();
        if (this.m_20160_()) {
            this.m_21563_().m_24960_((Entity)this.m_20197_().get(0), 100.0f, 100.0f);
        }
        if (!this.f_19853_.f_46443_) {
            this.bossInfo.m_142711_(this.m_21223_() / this.m_21233_());
            if (this.f_19862_ || this.f_19863_) {
                ++this.collisionCounter;
            }
            if (this.collisionCounter >= 15) {
                this.destroyBlocksInAABB(this.m_142469_());
                this.collisionCounter = 0;
            }
        }
        else {
            if (this.isRampaging()) {
                final float rotation = this.f_19797_ / 10.0f;
                for (int i = 0; i < 20; ++i) {
                    this.addSnowEffect(rotation + i * 50, i + rotation);
                }
                this.f_20924_ += (float)0.6;
            }
            if (this.isTired()) {
                for (int j = 0; j < 20; ++j) {
                    this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123769_, this.m_20185_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 0.5, this.m_20186_() + this.m_20192_(), this.m_20189_() + (this.f_19796_.nextDouble() - 0.5) * this.m_20205_() * 0.5, (double)((this.f_19796_.nextFloat() - 0.5f) * 0.75f), 0.0, (double)((this.f_19796_.nextFloat() - 0.5f) * 0.75f));
                }
            }
        }
    }
    
    private void addSnowEffect(final float rotation, final float hgt) {
        final double px = 3.0 * Math.cos(rotation);
        final double py = hgt % 5.0f;
        final double pz = 3.0 * Math.sin(rotation);
        this.f_19853_.m_7106_((ParticleOptions)TFParticleType.SNOW.get(), this.f_19790_ + px, this.f_19791_ + py, this.f_19792_ + pz, 0.0, 0.0, 0.0);
    }
    
    public void m_6710_(@Nullable final LivingEntity entity) {
        if (entity != null && entity != this.m_5448_()) {
            this.m_5496_(TFSounds.ALPHAYETI_ALERT, 4.0f, 0.5f + this.m_21187_().nextFloat() * 0.5f);
        }
        super.m_6710_(entity);
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        if (!this.canRampage && !this.isTired() && (source.m_19360_() || source.m_7640_() instanceof TwilightWandBolt)) {
            return false;
        }
        this.canRampage = true;
        final Entity 7639_ = source.m_7639_();
        if (7639_ instanceof final ServerPlayer player) {
            if (!this.hurtBy.contains(player)) {
                this.hurtBy.add(player);
            }
        }
        return super.m_6469_(source, amount);
    }
    
    @Nullable
    protected SoundEvent m_7515_() {
        return TFSounds.ALPHAYETI_GROWL;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.ALPHAYETI_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.ALPHAYETI_DEATH;
    }
    
    public float m_6100_() {
        return 0.5f + this.m_21187_().nextFloat() * 0.5f;
    }
    
    protected float m_6121_() {
        return 4.0f;
    }
    
    public void m_7332_(final Entity passenger) {
        final Vec3 riderPos = this.getRiderPosition();
        passenger.m_6034_(riderPos.f_82479_, riderPos.f_82480_, riderPos.f_82481_);
    }
    
    public double m_6048_() {
        return 5.75;
    }
    
    private Vec3 getRiderPosition() {
        if (this.m_20160_()) {
            final float distance = 0.4f;
            final double dx = Math.cos((this.m_146908_() + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double dz = Math.sin((this.m_146908_() + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return new Vec3(this.m_20185_() + dx, this.m_20186_() + this.m_6048_() + this.m_20197_().get(0).m_6049_(), this.m_20189_() + dz);
        }
        return new Vec3(this.m_20185_(), this.m_20186_(), this.m_20189_());
    }
    
    public boolean canRiderInteract() {
        return true;
    }
    
    public void destroyBlocksInAABB(final AABB box) {
        if (ForgeEventFactory.getMobGriefingEvent(this.f_19853_, (Entity)this)) {
            for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
                if (EntityUtil.canDestroyBlock(this.f_19853_, pos, (Entity)this)) {
                    this.f_19853_.m_46961_(pos, false);
                }
            }
        }
    }
    
    public void makeRandomBlockFall() {
        this.makeRandomBlockFall(30);
    }
    
    private void makeRandomBlockFall(final int range) {
        final int bx = Mth.m_14107_(this.m_20185_()) + this.m_21187_().nextInt(range) - this.m_21187_().nextInt(range);
        final int bz = Mth.m_14107_(this.m_20189_()) + this.m_21187_().nextInt(range) - this.m_21187_().nextInt(range);
        final int by = Mth.m_14107_(this.m_20186_() + this.m_20192_());
        this.makeBlockFallAbove(new BlockPos(bx, bz, by));
    }
    
    private void makeBlockFallAbove(final BlockPos pos) {
        if (this.f_19853_.m_46859_(pos)) {
            for (int i = 1; i < 30; ++i) {
                final BlockPos up = pos.m_6630_(i);
                if (!this.f_19853_.m_46859_(up)) {
                    this.makeBlockFall(up);
                    break;
                }
            }
        }
    }
    
    public void makeNearbyBlockFall() {
        this.makeRandomBlockFall(15);
    }
    
    public void makeBlockAboveTargetFall() {
        if (this.m_5448_() != null) {
            final int bx = Mth.m_14107_(this.m_5448_().m_20185_());
            final int bz = Mth.m_14107_(this.m_5448_().m_20189_());
            final int by = Mth.m_14107_(this.m_5448_().m_20186_() + this.m_5448_().m_20192_());
            this.makeBlockFallAbove(new BlockPos(bx, bz, by));
        }
    }
    
    private void makeBlockFall(final BlockPos pos) {
        this.f_19853_.m_46597_(pos, Blocks.f_50354_.m_49966_());
        this.f_19853_.m_46796_(2001, pos, Block.m_49956_(Blocks.f_50354_.m_49966_()));
        final FallingIce ice = new FallingIce(this.f_19853_, pos.m_123341_(), pos.m_123342_() - 3, pos.m_123343_());
        this.f_19853_.m_7967_((Entity)ice);
    }
    
    public void m_6504_(final LivingEntity target, final float distanceFactor) {
        if (!this.canRampage) {
            final IceBomb ice = new IceBomb(TFEntities.THROWN_ICE, this.f_19853_, (LivingEntity)this);
            final double d0 = target.m_20185_() - this.m_20185_();
            final double d2 = target.m_142469_().f_82289_ + target.m_20206_() / 3.0f - ice.m_20186_();
            final double d3 = target.m_20189_() - this.m_20189_();
            final double d4 = Mth.m_14116_((float)(d0 * d0 + d3 * d3));
            ice.m_6686_(d0, d2 + d4 * 0.20000000298023224, d3, 1.6f, (float)(14 - this.f_19853_.m_46791_().m_19028_() * 4));
            this.m_5496_(TFSounds.ALPHAYETI_ICE, 1.0f, 1.0f / (this.m_21187_().nextFloat() * 0.4f + 0.8f));
            this.f_19853_.m_7967_((Entity)ice);
        }
    }
    
    public boolean m_6785_(final double p_213397_1_) {
        return false;
    }
    
    public void m_6043_() {
        if (this.f_19853_.m_46791_() == Difficulty.PEACEFUL) {
            if (this.m_21534_() != BlockPos.f_121853_) {
                this.f_19853_.m_46597_(this.m_21534_(), ((Block)TFBlocks.ALPHA_YETI_BOSS_SPAWNER.get()).m_49966_());
            }
            this.m_142687_(Entity.RemovalReason.DISCARDED);
        }
        else {
            super.m_6043_();
        }
    }
    
    public boolean canRampage() {
        return this.canRampage;
    }
    
    public void setRampaging(final boolean rampaging) {
        this.f_19804_.m_135381_((EntityDataAccessor)AlphaYeti.RAMPAGE_FLAG, (Object)(byte)(rampaging ? 1 : 0));
    }
    
    public boolean isRampaging() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)AlphaYeti.RAMPAGE_FLAG) == 1;
    }
    
    public void setTired(final boolean tired) {
        this.f_19804_.m_135381_((EntityDataAccessor)AlphaYeti.TIRED_FLAG, (Object)(byte)(tired ? 1 : 0));
        this.canRampage = false;
    }
    
    public boolean isTired() {
        return (byte)this.f_19804_.m_135370_((EntityDataAccessor)AlphaYeti.TIRED_FLAG) == 1;
    }
    
    public boolean m_142535_(final float distance, final float multiplier, final DamageSource source) {
        if (!this.f_19853_.f_46443_ && this.isRampaging()) {
            this.m_5496_(TFSounds.ALPHAYETI_ICE, 1.0f, 1.0f / (this.m_21187_().nextFloat() * 0.4f + 0.8f));
            this.hitNearbyEntities();
        }
        return super.m_142535_(distance, multiplier, source);
    }
    
    private void hitNearbyEntities() {
        for (final LivingEntity entity : this.f_19853_.m_45976_((Class)LivingEntity.class, this.m_142469_().m_82377_(5.0, 0.0, 5.0))) {
            if (entity != this && entity.m_6469_(DamageSource.m_19370_((LivingEntity)this), 5.0f)) {
                entity.m_5997_(0.0, 0.4, 0.0);
            }
        }
    }
    
    public void m_6667_(final DamageSource cause) {
        super.m_6667_(cause);
        if (!this.f_19853_.f_46443_) {
            TFGenerationSettings.markStructureConquered(this.f_19853_, new BlockPos((Vec3i)this.m_142538_()), TFFeature.YETI_CAVE);
            for (final ServerPlayer player : this.hurtBy) {
                TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
            }
            TFTreasure.entityDropsIntoContainer((LivingEntity)this, this.m_7771_(true, cause).m_78975_(LootContextParamSets.f_81415_), ((TwilightChest)TFBlocks.CANOPY_CHEST.get()).m_49966_(), new BlockPos(this.m_20182_()));
        }
    }
    
    protected boolean m_6125_() {
        return false;
    }
    
    public void m_6593_(@Nullable final Component name) {
        super.m_6593_(name);
        this.bossInfo.m_6456_(this.m_5446_());
    }
    
    public void m_6457_(final ServerPlayer player) {
        super.m_6457_(player);
        this.bossInfo.m_6543_(player);
    }
    
    public void m_6452_(final ServerPlayer player) {
        super.m_6452_(player);
        this.bossInfo.m_6539_(player);
    }
    
    public void m_7380_(final CompoundTag compound) {
        final BlockPos home = this.m_21534_();
        compound.m_128365_("Home", (Tag)this.m_20063_(new double[] { home.m_123341_(), home.m_123342_(), home.m_123343_() }));
        compound.m_128379_("HasHome", this.m_21536_());
        super.m_7380_(compound);
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128425_("Home", 9)) {
            final ListTag nbttaglist = compound.m_128437_("Home", 6);
            final int hx = (int)nbttaglist.m_128772_(0);
            final int hy = (int)nbttaglist.m_128772_(1);
            final int hz = (int)nbttaglist.m_128772_(2);
            this.m_21446_(new BlockPos(hx, hy, hz), 30);
        }
        if (!compound.m_128471_("HasHome")) {
            this.m_21536_();
        }
        if (this.m_8077_()) {
            this.bossInfo.m_6456_(this.m_5446_());
        }
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    static {
        RAMPAGE_FLAG = SynchedEntityData.m_135353_((Class)AlphaYeti.class, EntityDataSerializers.f_135027_);
        TIRED_FLAG = SynchedEntityData.m_135353_((Class)AlphaYeti.class, EntityDataSerializers.f_135027_);
    }
}
