// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.LevelAccessor;
import java.util.Objects;
import java.util.Optional;
import twilightforest.world.registration.biomes.BiomeKeys;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import javax.annotation.Nullable;
import net.minecraft.world.phys.Vec3;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.PathfinderMob;
import twilightforest.entity.ai.ThrowRiderGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.IHostileMount;
import net.minecraft.world.entity.monster.Monster;

public class Yeti extends Monster implements IHostileMount
{
    private static final EntityDataAccessor<Boolean> ANGER_FLAG;
    private static final AttributeModifier ANGRY_MODIFIER;
    
    public Yeti(final EntityType<? extends Yeti> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new ThrowRiderGoal(this, 1.0, false) {
            @Override
            protected void m_6739_(final LivingEntity victim, final double p_190102_2_) {
                super.m_6739_(victim, p_190102_2_);
                if (!Yeti.this.m_20197_().isEmpty()) {
                    Yeti.this.m_5496_(TFSounds.YETI_GRAB, 1.0f, 1.25f + Yeti.this.m_21187_().nextFloat() * 0.5f);
                }
            }
            
            @Override
            public void m_8041_() {
                if (!Yeti.this.m_20197_().isEmpty()) {
                    Yeti.this.m_5496_(TFSounds.YETI_THROW, 1.0f, 1.25f + Yeti.this.m_21187_().nextFloat() * 0.5f);
                }
                super.m_8041_();
            }
        });
        this.f_21345_.m_25352_(2, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(3, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(3, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 20.0).m_22268_(Attributes.f_22279_, 0.38).m_22268_(Attributes.f_22281_, 0.0).m_22268_(Attributes.f_22277_, 4.0);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)Yeti.ANGER_FLAG, (Object)false);
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (!this.m_20197_().isEmpty()) {
            this.m_21563_().m_24960_((Entity)this.m_20197_().get(0), 100.0f, 100.0f);
        }
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        if (source.m_7639_() != null && !source.m_19390_()) {
            this.setAngry(true);
        }
        return super.m_6469_(source, amount);
    }
    
    public boolean isAngry() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)Yeti.ANGER_FLAG);
    }
    
    public void setAngry(final boolean anger) {
        this.f_19804_.m_135381_((EntityDataAccessor)Yeti.ANGER_FLAG, (Object)anger);
        if (!this.f_19853_.f_46443_) {
            if (anger) {
                if (!this.m_21051_(Attributes.f_22277_).m_22109_(Yeti.ANGRY_MODIFIER)) {
                    this.m_21051_(Attributes.f_22277_).m_22118_(Yeti.ANGRY_MODIFIER);
                }
            }
            else {
                this.m_21051_(Attributes.f_22277_).m_22130_(Yeti.ANGRY_MODIFIER);
            }
        }
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128379_("Angry", this.isAngry());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setAngry(compound.m_128471_("Angry"));
    }
    
    public void m_7332_(final Entity passenger) {
        final Vec3 riderPos = this.getRiderPosition(passenger);
        passenger.m_6034_(riderPos.f_82479_, riderPos.f_82480_, riderPos.f_82481_);
    }
    
    public double m_6048_() {
        return 2.25;
    }
    
    private Vec3 getRiderPosition(@Nullable final Entity passenger) {
        if (passenger != null) {
            final float distance = 0.4f;
            final double dx = Math.cos((this.m_146908_() + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double dz = Math.sin((this.m_146908_() + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return new Vec3(this.m_20185_() + dx, this.m_20186_() + this.m_6048_() + passenger.m_6049_(), this.m_20189_() + dz);
        }
        return new Vec3(this.m_20185_(), this.m_20186_(), this.m_20189_());
    }
    
    public boolean canRiderInteract() {
        return true;
    }
    
    public static boolean yetiSnowyForestSpawnHandler(final EntityType<? extends Yeti> entityType, final ServerLevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        final Optional<ResourceKey<Biome>> key = world.m_45837_(pos);
        if (Objects.equals(key, Optional.of(BiomeKeys.SNOWY_FOREST))) {
            return m_21400_((EntityType)entityType, (LevelAccessor)world, reason, pos, random);
        }
        return normalYetiSpawnHandler(entityType, world, reason, pos, random);
    }
    
    public static boolean normalYetiSpawnHandler(final EntityType<? extends Monster> entity, final ServerLevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        return world.m_46791_() != Difficulty.PEACEFUL && isValidLightLevel(world, pos, random) && m_21400_((EntityType)entity, (LevelAccessor)world, reason, pos, random);
    }
    
    public static boolean isValidLightLevel(final ServerLevelAccessor world, final BlockPos blockPos, final Random random) {
        final Optional<ResourceKey<Biome>> key = world.m_45837_(blockPos);
        if (world.m_45517_(LightLayer.SKY, blockPos) > random.nextInt(32)) {
            return Objects.equals(key, Optional.of(BiomeKeys.SNOWY_FOREST));
        }
        final int i = world.m_6018_().m_46470_() ? world.m_46849_(blockPos, 10) : world.m_46803_(blockPos);
        return i <= random.nextInt(8) || Objects.equals(key, Optional.of(BiomeKeys.SNOWY_FOREST));
    }
    
    public float m_6100_() {
        return super.m_6100_() + 0.55f;
    }
    
    @Nullable
    protected SoundEvent m_7515_() {
        return TFSounds.YETI_GROWL;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.YETI_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.YETI_DEATH;
    }
    
    static {
        ANGER_FLAG = SynchedEntityData.m_135353_((Class)Yeti.class, EntityDataSerializers.f_135035_);
        ANGRY_MODIFIER = new AttributeModifier("Angry follow range boost", 24.0, AttributeModifier.Operation.ADDITION);
    }
}
