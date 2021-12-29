// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.LightType;
import net.minecraft.world.Difficulty;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.IWorld;
import java.util.Objects;
import java.util.Optional;
import twilightforest.worldgen.biomes.BiomeKeys;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import twilightforest.TFSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureEntity;
import twilightforest.entity.ai.ThrowRiderGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.MonsterEntity;

public class YetiEntity extends MonsterEntity implements IHostileMount
{
    private static final DataParameter<Boolean> ANGER_FLAG;
    private static final AttributeModifier ANGRY_MODIFIER;
    
    public YetiEntity(final EntityType<? extends YetiEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new ThrowRiderGoal(this, 1.0, false) {
            @Override
            protected void func_190102_a(final LivingEntity p_190102_1_, final double p_190102_2_) {
                super.func_190102_a(p_190102_1_, p_190102_2_);
                if (!YetiEntity.this.func_184188_bt().isEmpty()) {
                    YetiEntity.this.func_184185_a(TFSounds.YETI_GRAB, 1.0f, 1.25f + YetiEntity.this.func_70681_au().nextFloat() * 0.5f);
                }
            }
            
            @Override
            public void func_75251_c() {
                if (!YetiEntity.this.func_184188_bt().isEmpty()) {
                    YetiEntity.this.func_184185_a(TFSounds.YETI_THROW, 1.0f, 1.25f + YetiEntity.this.func_70681_au().nextFloat() * 0.5f);
                }
                super.func_75251_c();
            }
        });
        this.field_70714_bg.func_75776_a(2, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 20.0).func_233815_a_(Attributes.field_233821_d_, 0.38).func_233815_a_(Attributes.field_233823_f_, 0.0).func_233815_a_(Attributes.field_233819_b_, 4.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)YetiEntity.ANGER_FLAG, (Object)false);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.func_184188_bt().isEmpty()) {
            this.func_70671_ap().func_75651_a((Entity)this.func_184188_bt().get(0), 100.0f, 100.0f);
            final Vector3d riderPos = this.getRiderPosition(this.func_184188_bt().get(0));
            this.func_213282_i(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
        }
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        if (source.func_76346_g() != null && !source.func_180136_u()) {
            this.setAngry(true);
        }
        return super.func_70097_a(source, amount);
    }
    
    public boolean isAngry() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)YetiEntity.ANGER_FLAG);
    }
    
    public void setAngry(final boolean anger) {
        this.field_70180_af.func_187227_b((DataParameter)YetiEntity.ANGER_FLAG, (Object)anger);
        if (!this.field_70170_p.field_72995_K) {
            if (anger) {
                if (!this.func_110148_a(Attributes.field_233819_b_).func_180374_a(YetiEntity.ANGRY_MODIFIER)) {
                    this.func_110148_a(Attributes.field_233819_b_).func_233767_b_(YetiEntity.ANGRY_MODIFIER);
                }
            }
            else {
                this.func_110148_a(Attributes.field_233819_b_).func_111124_b(YetiEntity.ANGRY_MODIFIER);
            }
        }
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74757_a("Angry", this.isAngry());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setAngry(compound.func_74767_n("Angry"));
    }
    
    public void func_184232_k(final Entity passenger) {
        final Vector3d riderPos = this.getRiderPosition(passenger);
        passenger.func_70107_b(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
    }
    
    public double func_70042_X() {
        return 2.25;
    }
    
    private Vector3d getRiderPosition(@Nullable final Entity passenger) {
        if (passenger != null) {
            final float distance = 0.4f;
            final double dx = Math.cos((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double dz = Math.sin((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return new Vector3d(this.func_226277_ct_() + dx, this.func_226278_cu_() + this.func_70042_X() + passenger.func_70033_W(), this.func_226281_cx_() + dz);
        }
        return new Vector3d(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
    }
    
    public boolean canRiderInteract() {
        return true;
    }
    
    public static boolean yetiSnowyForestSpawnHandler(final EntityType<? extends YetiEntity> entityType, final IServerWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        final Optional<RegistryKey<Biome>> key = world.func_242406_i(pos);
        if (Objects.equals(key, Optional.of(BiomeKeys.SNOWY_FOREST))) {
            return func_223315_a((EntityType)entityType, (IWorld)world, reason, pos, random);
        }
        return normalYetiSpawnHandler(entityType, world, reason, pos, random);
    }
    
    public static boolean normalYetiSpawnHandler(final EntityType<? extends MonsterEntity> entity, final IServerWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        return world.func_175659_aa() != Difficulty.PEACEFUL && isValidLightLevel(world, pos, random) && func_223315_a((EntityType)entity, (IWorld)world, reason, pos, random);
    }
    
    public static boolean isValidLightLevel(final IServerWorld world, final BlockPos blockPos, final Random random) {
        final Optional<RegistryKey<Biome>> key = world.func_242406_i(blockPos);
        if (world.func_226658_a_(LightType.SKY, blockPos) > random.nextInt(32)) {
            return Objects.equals(key, Optional.of(BiomeKeys.SNOWY_FOREST));
        }
        final int i = world.func_201672_e().func_72911_I() ? world.func_205049_d(blockPos, 10) : world.func_201696_r(blockPos);
        return i <= random.nextInt(8) || Objects.equals(key, Optional.of(BiomeKeys.SNOWY_FOREST));
    }
    
    protected float func_70647_i() {
        return super.func_70647_i() + 0.55f;
    }
    
    @Nullable
    protected SoundEvent func_184639_G() {
        return TFSounds.YETI_GROWL;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.YETI_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.YETI_DEATH;
    }
    
    static {
        ANGER_FLAG = EntityDataManager.func_187226_a((Class)YetiEntity.class, DataSerializers.field_187198_h);
        ANGRY_MODIFIER = new AttributeModifier("Angry follow range boost", 24.0, AttributeModifier.Operation.ADDITION);
    }
}
