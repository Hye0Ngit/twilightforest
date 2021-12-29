// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.monster.Monster;
import java.util.Objects;
import java.util.Optional;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.BreathAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.syncher.EntityDataAccessor;
import twilightforest.entity.IBreathAttacker;

public class WinterWolf extends HostileWolf implements IBreathAttacker
{
    private static final EntityDataAccessor<Boolean> BREATH_FLAG;
    private static final float BREATH_DAMAGE = 2.0f;
    
    public WinterWolf(final EntityType<? extends WinterWolf> type, final Level world) {
        super(type, world);
        this.m_30397_(DyeColor.LIGHT_BLUE);
    }
    
    @Override
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(2, (Goal)new BreathAttackGoal<Object>(this, 5.0f, 30, 0.1f));
        this.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(6, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return HostileWolf.registerAttributes().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22281_, 6.0);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)WinterWolf.BREATH_FLAG, (Object)false);
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (this.isBreathing()) {
            if (this.f_19853_.f_46443_) {
                this.spawnBreathParticles();
            }
            this.playBreathSound();
        }
    }
    
    private void spawnBreathParticles() {
        final Vec3 look = this.m_20154_();
        final double dist = 0.5;
        final double px = this.m_20185_() + look.f_82479_ * 0.5;
        final double py = this.m_20186_() + 1.25 + look.f_82480_ * 0.5;
        final double pz = this.m_20189_() + look.f_82481_ * 0.5;
        for (int i = 0; i < 10; ++i) {
            double dx = look.f_82479_;
            double dy = look.f_82480_;
            double dz = look.f_82481_;
            final double spread = 5.0 + this.m_21187_().nextDouble() * 2.5;
            final double velocity = 3.0 + this.m_21187_().nextDouble() * 0.15;
            dx += this.m_21187_().nextGaussian() * 0.007499999832361937 * spread;
            dy += this.m_21187_().nextGaussian() * 0.007499999832361937 * spread;
            dz += this.m_21187_().nextGaussian() * 0.007499999832361937 * spread;
            dx *= velocity;
            dy *= velocity;
            dz *= velocity;
            this.f_19853_.m_7106_((ParticleOptions)TFParticleType.SNOW.get(), px, py, pz, dx, dy, dz);
        }
    }
    
    @Override
    protected SoundEvent getTargetSound() {
        return TFSounds.WINTER_WOLF_TARGET;
    }
    
    @Override
    protected SoundEvent m_7515_() {
        return TFSounds.WINTER_WOLF_AMBIENT;
    }
    
    @Override
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.WINTER_WOLF_HURT;
    }
    
    private void playBreathSound() {
        this.m_5496_(TFSounds.WINTER_WOLF_SHOOT, this.f_19796_.nextFloat() * 0.5f, this.f_19796_.nextFloat() * 0.5f);
    }
    
    @Override
    protected SoundEvent m_5592_() {
        return TFSounds.WINTER_WOLF_DEATH;
    }
    
    public float m_6100_() {
        return (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.2f + 0.6f;
    }
    
    @Override
    public boolean isBreathing() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)WinterWolf.BREATH_FLAG);
    }
    
    @Override
    public void setBreathing(final boolean flag) {
        this.f_19804_.m_135381_((EntityDataAccessor)WinterWolf.BREATH_FLAG, (Object)flag);
    }
    
    @Override
    public void doBreathAttack(final Entity target) {
        target.m_6469_(DamageSource.m_19370_((LivingEntity)this), 2.0f);
    }
    
    public static boolean canSpawnHere(final EntityType<? extends WinterWolf> entity, final ServerLevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random random) {
        final Optional<ResourceKey<Biome>> key = world.m_45837_(pos);
        return (world.m_46791_() != Difficulty.PEACEFUL && Objects.equals(key, Optional.of(BiomeKeys.SNOWY_FOREST))) || Monster.m_33008_(world, pos, random);
    }
    
    static {
        BREATH_FLAG = SynchedEntityData.m_135353_((Class)WinterWolf.class, EntityDataSerializers.f_135035_);
    }
}
