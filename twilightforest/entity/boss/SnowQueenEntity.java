// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraftforge.entity.PartEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import twilightforest.util.WorldUtil;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.util.TFDamageSources;
import net.minecraft.entity.LivingEntity;
import java.util.Iterator;
import java.util.List;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFFeature;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import twilightforest.entity.ai.HoverBeamGoal;
import twilightforest.entity.ai.HoverThenDropGoal;
import net.minecraft.entity.ai.goal.Goal;
import twilightforest.entity.ai.HoverSummonGoal;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.network.datasync.DataParameter;
import twilightforest.entity.IBreathAttacker;
import net.minecraft.entity.monster.MonsterEntity;

public class SnowQueenEntity extends MonsterEntity implements IBreathAttacker
{
    private static final int MAX_SUMMONS = 6;
    private static final DataParameter<Boolean> BEAM_FLAG;
    private static final DataParameter<Byte> PHASE_FLAG;
    private final ServerBossInfo bossInfo;
    private static final int MAX_DAMAGE_WHILE_BEAMING = 25;
    private static final float BREATH_DAMAGE = 4.0f;
    public final SnowQueenIceShieldEntity[] iceArray;
    private int summonsRemaining;
    private int successfulDrops;
    private int maxDrops;
    private int damageWhileBeaming;
    
    public SnowQueenEntity(final EntityType<? extends SnowQueenEntity> type, final World world) {
        super((EntityType)type, world);
        this.bossInfo = new ServerBossInfo(this.func_145748_c_(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS);
        this.iceArray = new SnowQueenIceShieldEntity[7];
        this.summonsRemaining = 0;
        for (int i = 0; i < this.iceArray.length; ++i) {
            this.iceArray[i] = new SnowQueenIceShieldEntity(this);
        }
        this.setCurrentPhase(Phase.SUMMON);
        this.func_230279_az_();
        this.field_70728_aV = 317;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (Goal)new HoverSummonGoal(this));
        this.field_70714_bg.func_75776_a(2, (Goal)new HoverThenDropGoal(this, 80, 20));
        this.field_70714_bg.func_75776_a(3, (Goal)new HoverBeamGoal(this, 80, 100));
        this.field_70714_bg.func_75776_a(6, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, true));
        this.field_70714_bg.func_75776_a(8, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233821_d_, 0.23000000417232513).func_233815_a_(Attributes.field_233823_f_, 7.0).func_233815_a_(Attributes.field_233819_b_, 40.0).func_233815_a_(Attributes.field_233818_a_, 200.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)SnowQueenEntity.BEAM_FLAG, (Object)false);
        this.field_70180_af.func_187214_a((DataParameter)SnowQueenEntity.PHASE_FLAG, (Object)0);
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.SNOW_QUEEN_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.SNOW_QUEEN_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.SNOW_QUEEN_DEATH;
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
            this.field_70170_p.func_195594_a((IParticleData)TFParticleType.SNOW_GUARDIAN.get(), this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
        }
        if (this.getCurrentPhase() == Phase.DROP) {
            for (final Entity ice : this.iceArray) {
                final float px2 = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                final float py2 = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                final float pz2 = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                this.field_70170_p.func_195594_a((IParticleData)TFParticleType.SNOW_WARNING.get(), ice.field_70142_S + px2, ice.field_70137_T + py2, ice.field_70136_U + pz2, 0.0, 0.0, 0.0);
            }
        }
        if (this.isBreathing() && this.func_70089_S()) {
            final Vector3d look = this.func_70040_Z();
            final double dist = 0.5;
            final double px3 = this.func_226277_ct_() + look.field_72450_a * dist;
            final double py3 = this.func_226278_cu_() + 1.7000000476837158 + look.field_72448_b * dist;
            final double pz3 = this.func_226281_cx_() + look.field_72449_c * dist;
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
                this.field_70170_p.func_195594_a((IParticleData)TFParticleType.ICE_BEAM.get(), px3, py3, pz3, dx, dy, dz);
            }
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        for (int i = 0; i < this.iceArray.length; ++i) {
            this.iceArray[i].func_70071_h_();
            if (i < this.iceArray.length - 1) {
                final Vector3d blockPos = this.getIceShieldPosition(i);
                this.iceArray[i].func_70107_b(blockPos.field_72450_a, blockPos.field_72448_b, blockPos.field_72449_c);
            }
            else {
                this.iceArray[i].func_70107_b(this.func_226277_ct_(), this.func_226278_cu_() - 1.0, this.func_226281_cx_());
            }
            this.iceArray[i].field_70177_z = this.getIceShieldAngle(i);
            if (!this.field_70170_p.field_72995_K) {
                this.applyShieldCollisions((Entity)this.iceArray[i]);
            }
        }
        if (this.field_70725_aQ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.field_70146_Z.nextGaussian() * 0.02;
                final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                this.field_70170_p.func_195594_a((IParticleData)(this.field_70146_Z.nextBoolean() ? ParticleTypes.field_197626_s : ParticleTypes.field_197627_t), this.func_226277_ct_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextFloat() * this.func_213302_cg(), this.func_226281_cx_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), d, d2, d3);
            }
        }
    }
    
    public boolean func_213397_c(final double p_213397_1_) {
        return false;
    }
    
    public void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            if (this.func_213384_dI() != BlockPos.field_177992_a) {
                this.field_70170_p.func_175656_a(this.func_213384_dI(), ((Block)TFBlocks.boss_spawner_snow_queen.get()).func_176223_P());
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
            TFGenerationSettings.markStructureConquered(this.field_70170_p, this.func_233580_cy_(), TFFeature.ICE_TOWER);
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
            if (collided instanceof LivingEntity && super.func_70652_k(collided)) {
                final Vector3d motion = collided.func_213322_ci();
                collided.func_213293_j(motion.field_72450_a, motion.field_72448_b + 0.4, motion.field_72449_c);
                this.func_184185_a(TFSounds.SNOW_QUEEN_ATTACK, 1.0f, 1.0f);
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
        final boolean result = super.func_70097_a(TFDamageSources.SQUISH, damage);
        if (result && this.getCurrentPhase() == Phase.BEAM) {
            this.damageWhileBeaming += (int)damage;
        }
        return result;
    }
    
    private Vector3d getIceShieldPosition(final int idx) {
        return this.getIceShieldPosition(this.getIceShieldAngle(idx), 1.0f);
    }
    
    private float getIceShieldAngle(final int idx) {
        return 60.0f * idx + this.field_70173_aa * 5.0f;
    }
    
    private Vector3d getIceShieldPosition(final float angle, final float distance) {
        final double dx = Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dz = Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return new Vector3d(this.func_226277_ct_() + dx, this.func_226278_cu_() + this.getShieldYOffset(), this.func_226281_cx_() + dz);
    }
    
    private double getShieldYOffset() {
        return 0.10000000149011612;
    }
    
    public boolean func_225503_b_(final float distance, final float damageMultiplier) {
        return false;
    }
    
    public void destroyBlocksInAABB(final AxisAlignedBB box) {
        if (ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this)) {
            for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
                final BlockState state = this.field_70170_p.func_180495_p(pos);
                if (state.func_177230_c() == Blocks.field_150432_aD || state.func_177230_c() == Blocks.field_150403_cj) {
                    this.field_70170_p.func_175655_b(pos, false);
                }
            }
        }
    }
    
    public boolean isBreathing() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)SnowQueenEntity.BEAM_FLAG);
    }
    
    public void setBreathing(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)SnowQueenEntity.BEAM_FLAG, (Object)flag);
    }
    
    public Phase getCurrentPhase() {
        return Phase.values()[(byte)this.field_70180_af.func_187225_a((DataParameter)SnowQueenEntity.PHASE_FLAG)];
    }
    
    public void setCurrentPhase(final Phase currentPhase) {
        this.field_70180_af.func_187227_b((DataParameter)SnowQueenEntity.PHASE_FLAG, (Object)(byte)currentPhase.ordinal());
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
    
    public void summonMinionAt(final LivingEntity targetedEntity) {
        final IceCrystalEntity minion = new IceCrystalEntity(this.field_70170_p);
        minion.func_70080_a(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 0.0f, 0.0f);
        this.field_70170_p.func_217376_c((Entity)minion);
        for (int i = 0; i < 100; ++i) {
            double attemptX;
            double attemptY;
            double attemptZ;
            if (this.func_213384_dI() != BlockPos.field_177992_a) {
                final BlockPos home = this.func_213384_dI();
                attemptX = home.func_177958_n() + this.field_70146_Z.nextGaussian() * 7.0;
                attemptY = home.func_177956_o() + this.field_70146_Z.nextGaussian() * 2.0;
                attemptZ = home.func_177952_p() + this.field_70146_Z.nextGaussian() * 7.0;
            }
            else {
                attemptX = targetedEntity.func_226277_ct_() + this.field_70146_Z.nextGaussian() * 16.0;
                attemptY = targetedEntity.func_226278_cu_() + this.field_70146_Z.nextGaussian() * 8.0;
                attemptZ = targetedEntity.func_226281_cx_() + this.field_70146_Z.nextGaussian() * 16.0;
            }
            if (minion.func_213373_a(attemptX, attemptY, attemptZ, true)) {
                break;
            }
        }
        minion.func_70624_b(targetedEntity);
        minion.setToDieIn30Seconds();
        --this.summonsRemaining;
    }
    
    public int countMyMinions() {
        return this.field_70170_p.func_217357_a((Class)IceCrystalEntity.class, new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.func_226277_ct_() + 1.0, this.func_226278_cu_() + 1.0, this.func_226281_cx_() + 1.0).func_72314_b(32.0, 16.0, 32.0)).size();
    }
    
    public void incrementSuccessfulDrops() {
        ++this.successfulDrops;
    }
    
    public void doBreathAttack(final Entity target) {
        target.func_70097_a(TFDamageSources.CHILLING_BREATH, 4.0f);
    }
    
    public void func_200203_b(@Nullable final ITextComponent name) {
        super.func_200203_b(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    public void func_184178_b(final ServerPlayerEntity player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final ServerPlayerEntity player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    public boolean isMultipartEntity() {
        return true;
    }
    
    @Nullable
    public PartEntity<?>[] getParts() {
        return this.iceArray;
    }
    
    static {
        BEAM_FLAG = EntityDataManager.func_187226_a((Class)SnowQueenEntity.class, DataSerializers.field_187198_h);
        PHASE_FLAG = EntityDataManager.func_187226_a((Class)SnowQueenEntity.class, DataSerializers.field_187191_a);
    }
    
    public enum Phase
    {
        SUMMON, 
        DROP, 
        BEAM;
    }
}
