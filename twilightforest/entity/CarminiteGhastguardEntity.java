// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.SoundEvents;
import net.minecraft.entity.ai.controller.MovementController;
import java.util.EnumSet;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.ISeedReader;
import twilightforest.TFFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import twilightforest.entity.boss.UrGhastEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.GhastEntity;

public class CarminiteGhastguardEntity extends GhastEntity
{
    private static final DataParameter<Byte> ATTACK_STATUS;
    private static final DataParameter<Byte> ATTACK_TIMER;
    private static final DataParameter<Byte> ATTACK_PREVTIMER;
    private AIAttack attackAI;
    protected float wanderFactor;
    private int inTrapCounter;
    private BlockPos homePosition;
    private float maximumHomeDistance;
    
    public CarminiteGhastguardEntity(final EntityType<? extends CarminiteGhastguardEntity> type, final World world) {
        super((EntityType)type, world);
        this.homePosition = BlockPos.field_177992_a;
        this.maximumHomeDistance = -1.0f;
        this.wanderFactor = 16.0f;
        this.inTrapCounter = 0;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)CarminiteGhastguardEntity.ATTACK_STATUS, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)CarminiteGhastguardEntity.ATTACK_TIMER, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)CarminiteGhastguardEntity.ATTACK_PREVTIMER, (Object)0);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(5, (Goal)new AIHomedFly(this));
        if (!(this instanceof UrGhastEntity)) {
            this.field_70714_bg.func_75776_a(5, (Goal)new AIRandomFly(this));
        }
        this.field_70714_bg.func_75776_a(7, (Goal)new GhastEntity.LookAroundGoal((GhastEntity)this));
        this.field_70714_bg.func_75776_a(7, (Goal)(this.attackAI = new AIAttack(this)));
        this.field_70715_bh.func_75776_a(1, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.GHASTGUARD_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.GHASTGUARD_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.GHASTGUARD_DEATH;
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return GhastEntity.func_234290_eH_().func_233815_a_(Attributes.field_233818_a_, 30.0).func_233815_a_(Attributes.field_233819_b_, 64.0);
    }
    
    protected float func_70599_aP() {
        return 0.5f;
    }
    
    public int func_70627_aG() {
        return 160;
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    public void func_70636_d() {
        if (this.func_70013_c() > 0.5f) {
            this.field_70708_bq += 2;
        }
        if (this.field_70146_Z.nextBoolean()) {
            this.field_70170_p.func_195594_a((IParticleData)RedstoneParticleData.field_197564_a, this.func_226277_ct_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextDouble() * this.func_213302_cg() - 0.25, this.func_226281_cx_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf(), 0.0, 0.0, 0.0);
        }
        super.func_70636_d();
    }
    
    protected void func_70619_bc() {
        this.findHome();
        if (this.inTrapCounter > 0) {
            --this.inTrapCounter;
            this.func_70624_b((LivingEntity)null);
        }
        final int status = (this.func_70638_az() != null && this.shouldAttack(this.func_70638_az())) ? 1 : 0;
        this.field_70180_af.func_187227_b((DataParameter)CarminiteGhastguardEntity.ATTACK_STATUS, (Object)(byte)status);
        this.field_70180_af.func_187227_b((DataParameter)CarminiteGhastguardEntity.ATTACK_TIMER, (Object)(byte)this.attackAI.attackTimer);
        this.field_70180_af.func_187227_b((DataParameter)CarminiteGhastguardEntity.ATTACK_PREVTIMER, (Object)(byte)this.attackAI.prevAttackTimer);
    }
    
    public int getAttackStatus() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)CarminiteGhastguardEntity.ATTACK_STATUS);
    }
    
    public int getAttackTimer() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)CarminiteGhastguardEntity.ATTACK_TIMER);
    }
    
    public int getPrevAttackTimer() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)CarminiteGhastguardEntity.ATTACK_PREVTIMER);
    }
    
    protected boolean shouldAttack(final LivingEntity living) {
        return true;
    }
    
    public int func_70646_bf() {
        return 500;
    }
    
    protected void spitFireball() {
        final Vector3d vec3d = this.func_70676_i(1.0f);
        final double d2 = this.func_70638_az().func_226277_ct_() - (this.func_226277_ct_() + vec3d.field_72450_a * 4.0);
        final double d3 = this.func_70638_az().func_174813_aQ().field_72338_b + this.func_70638_az().func_213302_cg() / 2.0f - (0.5 + this.func_226278_cu_() + this.func_213302_cg() / 2.0f);
        final double d4 = this.func_70638_az().func_226281_cx_() - (this.func_226281_cx_() + vec3d.field_72449_c * 4.0);
        final FireballEntity entitylargefireball = new FireballEntity(this.field_70170_p, (LivingEntity)this, d2, d3, d4);
        entitylargefireball.field_92057_e = this.func_175453_cd();
        entitylargefireball.func_70107_b(this.func_226277_ct_() + vec3d.field_72450_a * 4.0, this.func_226278_cu_() + this.func_213302_cg() / 2.0f + 0.5, this.func_226281_cx_() + vec3d.field_72449_c * 4.0);
        this.field_70170_p.func_217376_c((Entity)entitylargefireball);
        if (this.field_70146_Z.nextInt(6) == 0) {
            this.func_70624_b((LivingEntity)null);
        }
    }
    
    public static boolean ghastSpawnHandler(final EntityType<? extends CarminiteGhastguardEntity> entityType, final IWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        return world.func_175659_aa() != Difficulty.PEACEFUL && func_223315_a((EntityType)entityType, world, reason, pos, random);
    }
    
    public boolean func_205019_a(final IWorldReader world) {
        return world.func_226668_i_((Entity)this) && !world.func_72953_d(this.func_174813_aQ());
    }
    
    private void findHome() {
        if (!this.hasHome()) {
            final int chunkX = MathHelper.func_76128_c(this.func_226277_ct_()) >> 4;
            final int chunkZ = MathHelper.func_76128_c(this.func_226281_cx_()) >> 4;
            final TFFeature nearFeature = TFFeature.getFeatureForRegion(chunkX, chunkZ, (ISeedReader)this.field_70170_p);
            if (nearFeature != TFFeature.DARK_TOWER) {
                this.func_213394_dL();
                this.field_70708_bq += 5;
            }
            else {
                final BlockPos cc = TFFeature.getNearestCenterXYZ(chunkX, chunkZ);
                this.func_213390_a(cc.func_177981_b(128), 64);
            }
        }
    }
    
    public void setInTrap() {
        this.inTrapCounter = 10;
    }
    
    public boolean func_213383_dH() {
        return this.func_213389_a(this.func_233580_cy_());
    }
    
    public boolean func_213389_a(final BlockPos pos) {
        return this.maximumHomeDistance == -1.0f || (pos.func_177956_o() > 64 && pos.func_177956_o() < 210 && this.homePosition.func_177951_i((Vector3i)pos) < this.maximumHomeDistance * this.maximumHomeDistance);
    }
    
    public void func_213390_a(final BlockPos pos, final int distance) {
        this.homePosition = pos;
        this.maximumHomeDistance = (float)distance;
    }
    
    public BlockPos func_213384_dI() {
        return this.homePosition;
    }
    
    public float func_213391_dJ() {
        return this.maximumHomeDistance;
    }
    
    public boolean func_213394_dL() {
        this.maximumHomeDistance = -1.0f;
        return false;
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
    
    static /* synthetic */ float access$300(final CarminiteGhastguardEntity x0) {
        return x0.func_70647_i();
    }
    
    static /* synthetic */ float access$400(final CarminiteGhastguardEntity x0) {
        return x0.func_70647_i();
    }
    
    static {
        ATTACK_STATUS = EntityDataManager.func_187226_a((Class)CarminiteGhastguardEntity.class, DataSerializers.field_187191_a);
        ATTACK_TIMER = EntityDataManager.func_187226_a((Class)CarminiteGhastguardEntity.class, DataSerializers.field_187191_a);
        ATTACK_PREVTIMER = EntityDataManager.func_187226_a((Class)CarminiteGhastguardEntity.class, DataSerializers.field_187191_a);
    }
    
    public static class AIRandomFly extends Goal
    {
        private final CarminiteGhastguardEntity parentEntity;
        
        public AIRandomFly(final CarminiteGhastguardEntity ghast) {
            this.parentEntity = ghast;
            this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean func_75250_a() {
            final MovementController entitymovehelper = this.parentEntity.func_70605_aq();
            if (!entitymovehelper.func_75640_a()) {
                return this.parentEntity.func_70638_az() == null;
            }
            final double d0 = entitymovehelper.func_179917_d() - this.parentEntity.func_226277_ct_();
            final double d2 = entitymovehelper.func_179919_e() - this.parentEntity.func_226278_cu_();
            final double d3 = entitymovehelper.func_179918_f() - this.parentEntity.func_226281_cx_();
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return this.parentEntity.func_70638_az() == null && (d4 < 1.0 || d4 > 3600.0);
        }
        
        public boolean func_75253_b() {
            return false;
        }
        
        public void func_75249_e() {
            final Random random = this.parentEntity.func_70681_au();
            final double d0 = this.parentEntity.func_226277_ct_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d2 = this.parentEntity.func_226278_cu_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d3 = this.parentEntity.func_226281_cx_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            this.parentEntity.func_70605_aq().func_75642_a(d0, d2, d3, 1.0);
        }
    }
    
    public static class AIHomedFly extends Goal
    {
        private final CarminiteGhastguardEntity parentEntity;
        
        AIHomedFly(final CarminiteGhastguardEntity ghast) {
            this.parentEntity = ghast;
            this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean func_75250_a() {
            final MovementController entitymovehelper = this.parentEntity.func_70605_aq();
            if (!entitymovehelper.func_75640_a()) {
                return !this.parentEntity.func_213383_dH();
            }
            final double d0 = entitymovehelper.func_179917_d() - this.parentEntity.func_226277_ct_();
            final double d2 = entitymovehelper.func_179919_e() - this.parentEntity.func_226278_cu_();
            final double d3 = entitymovehelper.func_179918_f() - this.parentEntity.func_226281_cx_();
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return (d4 < 1.0 || d4 > 3600.0) && !this.parentEntity.func_213383_dH();
        }
        
        public boolean func_75253_b() {
            return false;
        }
        
        public void func_75249_e() {
            final Random random = this.parentEntity.func_70681_au();
            final double d0 = this.parentEntity.func_226277_ct_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d2 = this.parentEntity.func_226278_cu_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            final double d3 = this.parentEntity.func_226281_cx_() + (random.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
            this.parentEntity.func_70605_aq().func_75642_a(d0, d2, d3, 1.0);
            if (this.parentEntity.func_195048_a(Vector3d.func_237491_b_((Vector3i)this.parentEntity.func_213384_dI())) > 256.0) {
                final Vector3d vecToHome = Vector3d.func_237491_b_((Vector3i)this.parentEntity.func_213384_dI()).func_178788_d(this.parentEntity.func_213303_ch()).func_72432_b();
                final double targetX = this.parentEntity.func_226277_ct_() + vecToHome.field_72450_a * this.parentEntity.wanderFactor + (this.parentEntity.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
                final double targetY = this.parentEntity.func_226278_cu_() + vecToHome.field_72448_b * this.parentEntity.wanderFactor + (this.parentEntity.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
                final double targetZ = this.parentEntity.func_226281_cx_() + vecToHome.field_72449_c * this.parentEntity.wanderFactor + (this.parentEntity.field_70146_Z.nextFloat() * 2.0f - 1.0f) * this.parentEntity.wanderFactor;
                this.parentEntity.func_70605_aq().func_75642_a(targetX, targetY, targetZ, 1.0);
            }
            else {
                this.parentEntity.func_70605_aq().func_75642_a(this.parentEntity.func_213384_dI().func_177958_n() + 0.5, (double)this.parentEntity.func_213384_dI().func_177956_o(), this.parentEntity.func_213384_dI().func_177952_p() + 0.5, 1.0);
            }
        }
    }
    
    public static class AIAttack extends Goal
    {
        private final CarminiteGhastguardEntity parentEntity;
        public int attackTimer;
        public int prevAttackTimer;
        
        public AIAttack(final CarminiteGhastguardEntity ghast) {
            this.parentEntity = ghast;
        }
        
        public boolean func_75250_a() {
            return this.parentEntity.func_70638_az() != null && this.parentEntity.shouldAttack(this.parentEntity.func_70638_az());
        }
        
        public void func_75249_e() {
            final int n = 0;
            this.prevAttackTimer = n;
            this.attackTimer = n;
        }
        
        public void func_75251_c() {
            this.parentEntity.func_175454_a(false);
        }
        
        public void func_75246_d() {
            final LivingEntity entitylivingbase = this.parentEntity.func_70638_az();
            if (entitylivingbase.func_70068_e((Entity)this.parentEntity) < 4096.0 && this.parentEntity.func_70635_at().func_75522_a((Entity)entitylivingbase)) {
                this.prevAttackTimer = this.attackTimer;
                ++this.attackTimer;
                this.parentEntity.func_70671_ap().func_75651_a((Entity)entitylivingbase, 10.0f, (float)this.parentEntity.func_70646_bf());
                if (this.attackTimer == 10) {
                    this.parentEntity.func_184185_a(SoundEvents.field_187559_bL, 10.0f, CarminiteGhastguardEntity.access$300(this.parentEntity));
                }
                if (this.attackTimer == 20) {
                    if (this.parentEntity.shouldAttack(entitylivingbase)) {
                        this.parentEntity.func_184185_a(SoundEvents.field_187557_bK, 10.0f, CarminiteGhastguardEntity.access$400(this.parentEntity));
                        this.parentEntity.spitFireball();
                        this.prevAttackTimer = this.attackTimer;
                    }
                    this.attackTimer = -40;
                }
            }
            else if (this.attackTimer > 0) {
                this.prevAttackTimer = this.attackTimer;
                --this.attackTimer;
            }
            this.parentEntity.func_175454_a(this.attackTimer > 10);
        }
    }
}
