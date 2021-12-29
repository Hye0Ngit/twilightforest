// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.monster.MonsterEntity;
import java.util.Objects;
import java.util.Optional;
import twilightforest.worldgen.biomes.BiomeKeys;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import twilightforest.TFSounds;
import javax.annotation.Nullable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3d;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.BreathAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.item.DyeColor;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;

public class WinterWolfEntity extends HostileWolfEntity implements IBreathAttacker
{
    private static final DataParameter<Boolean> BREATH_FLAG;
    private static final float BREATH_DAMAGE = 2.0f;
    
    public WinterWolfEntity(final EntityType<? extends WinterWolfEntity> type, final World world) {
        super(type, world);
        this.func_175547_a(DyeColor.LIGHT_BLUE);
    }
    
    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(2, (Goal)new BreathAttackGoal<Object>(this, 5.0f, 30, 0.1f));
        this.field_70714_bg.func_75776_a(3, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return HostileWolfEntity.registerAttributes().func_233815_a_(Attributes.field_233818_a_, 30.0).func_233815_a_(Attributes.field_233823_f_, 6.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)WinterWolfEntity.BREATH_FLAG, (Object)false);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isBreathing()) {
            if (this.field_70170_p.field_72995_K) {
                this.spawnBreathParticles();
            }
            this.playBreathSound();
        }
    }
    
    private void spawnBreathParticles() {
        final Vector3d look = this.func_70040_Z();
        final double dist = 0.5;
        final double px = this.func_226277_ct_() + look.field_72450_a * 0.5;
        final double py = this.func_226278_cu_() + 1.25 + look.field_72448_b * 0.5;
        final double pz = this.func_226281_cx_() + look.field_72449_c * 0.5;
        for (int i = 0; i < 10; ++i) {
            double dx = look.field_72450_a;
            double dy = look.field_72448_b;
            double dz = look.field_72449_c;
            final double spread = 5.0 + this.func_70681_au().nextDouble() * 2.5;
            final double velocity = 3.0 + this.func_70681_au().nextDouble() * 0.15;
            dx += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
            dy += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
            dz += this.func_70681_au().nextGaussian() * 0.007499999832361937 * spread;
            dx *= velocity;
            dy *= velocity;
            dz *= velocity;
            this.field_70170_p.func_195594_a((IParticleData)TFParticleType.SNOW.get(), px, py, pz, dx, dy, dz);
        }
    }
    
    @Override
    public void func_70624_b(@Nullable final LivingEntity entity) {
        if (entity != null && entity != this.func_70638_az()) {
            this.func_184185_a(TFSounds.WINTER_WOLF_TARGET, 4.0f, this.func_70647_i());
        }
        super.func_70624_b(entity);
    }
    
    @Override
    protected SoundEvent func_184639_G() {
        return TFSounds.WINTER_WOLF_IDLE;
    }
    
    @Override
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.WINTER_WOLF_HURT;
    }
    
    private void playBreathSound() {
        this.func_184185_a(TFSounds.WINTER_WOLF_SHOOT, this.field_70146_Z.nextFloat() * 0.5f, this.field_70146_Z.nextFloat() * 0.5f);
    }
    
    @Override
    protected SoundEvent func_184615_bR() {
        return TFSounds.WINTER_WOLF_DEATH;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.6f;
    }
    
    @Override
    public boolean isBreathing() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)WinterWolfEntity.BREATH_FLAG);
    }
    
    @Override
    public void setBreathing(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)WinterWolfEntity.BREATH_FLAG, (Object)flag);
    }
    
    @Override
    public void doBreathAttack(final Entity target) {
        target.func_70097_a(DamageSource.func_76358_a((LivingEntity)this), 2.0f);
    }
    
    public static boolean canSpawnHere(final EntityType<? extends WinterWolfEntity> entity, final IServerWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        final Optional<RegistryKey<Biome>> key = world.func_242406_i(pos);
        return Objects.equals(key, Optional.of(BiomeKeys.SNOWY_FOREST)) || MonsterEntity.func_223323_a(world, pos, random);
    }
    
    static {
        BREATH_FLAG = EntityDataManager.func_187226_a((Class)WinterWolfEntity.class, DataSerializers.field_187198_h);
    }
}
