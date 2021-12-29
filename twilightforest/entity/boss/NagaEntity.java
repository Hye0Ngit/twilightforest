// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.entity.ai.controller.MovementController;
import java.util.EnumSet;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import java.util.Random;
import net.minecraftforge.entity.PartEntity;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFFeature;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntArrayNBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.server.ServerWorld;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import twilightforest.network.ThrowPlayerPacket;
import net.minecraftforge.fml.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.block.BlockState;
import java.util.Iterator;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.util.EntityUtil;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.entity.monster.MonsterEntity;

public class NagaEntity extends MonsterEntity
{
    private static final int TICKS_BEFORE_HEALING = 600;
    private static final int MAX_SEGMENTS = 12;
    private static final int LEASH_X = 46;
    private static final int LEASH_Y = 7;
    private static final int LEASH_Z = 46;
    private static final double DEFAULT_SPEED = 0.3;
    private int currentSegmentCount;
    private final float healthPerSegment;
    private final NagaSegmentEntity[] bodySegments;
    private AIMovementPattern movementAI;
    private int ticksSinceDamaged;
    private final ServerBossInfo bossInfo;
    private final AttributeModifier slowSpeed;
    private final AttributeModifier fastSpeed;
    private static final DataParameter<Boolean> DATA_DAZE;
    private static final DataParameter<Boolean> DATA_CHARGE;
    
    public NagaEntity(final EntityType<? extends NagaEntity> type, final World world) {
        super((EntityType)type, world);
        this.currentSegmentCount = 0;
        this.bodySegments = new NagaSegmentEntity[12];
        this.ticksSinceDamaged = 0;
        this.bossInfo = new ServerBossInfo(this.func_145748_c_(), BossInfo.Color.GREEN, BossInfo.Overlay.NOTCHED_10);
        this.slowSpeed = new AttributeModifier("Naga Slow Speed", 0.25, AttributeModifier.Operation.ADDITION);
        this.fastSpeed = new AttributeModifier("Naga Fast Speed", 0.5, AttributeModifier.Operation.ADDITION);
        this.field_70138_W = 2.0f;
        this.healthPerSegment = this.func_110138_aP() / 10.0f;
        this.field_70728_aV = 217;
        this.field_70158_ak = true;
        for (int i = 0; i < this.bodySegments.length; ++i) {
            this.bodySegments[i] = new NagaSegmentEntity(this);
        }
        this.goNormal();
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)NagaEntity.DATA_DAZE, (Object)false);
        this.field_70180_af.func_187214_a((DataParameter)NagaEntity.DATA_CHARGE, (Object)false);
    }
    
    public boolean isDazed() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)NagaEntity.DATA_DAZE);
    }
    
    protected void setDazed(final boolean daze) {
        this.field_70180_af.func_187227_b((DataParameter)NagaEntity.DATA_DAZE, (Object)daze);
    }
    
    public boolean isCharging() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)NagaEntity.DATA_CHARGE);
    }
    
    protected void setCharging(final boolean charge) {
        this.field_70180_af.func_187227_b((DataParameter)NagaEntity.DATA_CHARGE, (Object)charge);
    }
    
    private float getMaxHealthPerDifficulty() {
        switch (this.field_70170_p.func_175659_aa()) {
            case EASY: {
                return 120.0f;
            }
            default: {
                return 200.0f;
            }
            case HARD: {
                return 250.0f;
            }
        }
    }
    
    public void func_200203_b(@Nullable final ITextComponent name) {
        super.func_200203_b(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    public boolean func_213397_c(final double p_213397_1_) {
        return false;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(2, (Goal)new AIAttack(this));
        this.field_70714_bg.func_75776_a(3, (Goal)new AISmash(this));
        this.field_70714_bg.func_75776_a(4, (Goal)(this.movementAI = new AIMovementPattern(this)));
        this.field_70714_bg.func_75776_a(8, (Goal)new RandomWalkingGoal(this, 1.0, 1) {
            public void func_75249_e() {
                NagaEntity.this.goNormal();
                super.func_75249_e();
            }
            
            protected Vector3d func_190864_f() {
                return RandomPositionGenerator.func_75463_a(this.field_75457_a, 30, 7);
            }
        });
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, false));
        this.field_70765_h = new NagaMoveHelper((MobEntity)this);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K || !ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this)) {
            return;
        }
        final AxisAlignedBB bb = this.func_174813_aQ();
        final int minx = MathHelper.func_76128_c(bb.field_72340_a - 0.75);
        final int miny = MathHelper.func_76128_c(bb.field_72338_b + 1.01);
        final int minz = MathHelper.func_76128_c(bb.field_72339_c - 0.75);
        final int maxx = MathHelper.func_76128_c(bb.field_72336_d + 0.75);
        final int maxy = MathHelper.func_76128_c(bb.field_72337_e + 0.0);
        final int maxz = MathHelper.func_76128_c(bb.field_72334_f + 0.75);
        final BlockPos min = new BlockPos(minx, miny, minz);
        final BlockPos max = new BlockPos(maxx, maxy, maxz);
        if (this.field_70170_p.func_175707_a(min, max)) {
            for (final BlockPos pos : BlockPos.func_218278_a(min, max)) {
                final BlockState state = this.field_70170_p.func_180495_p(pos);
                if (state.func_185904_a() == Material.field_151584_j && EntityUtil.canDestroyBlock(this.field_70170_p, pos, state, (Entity)this)) {
                    this.field_70170_p.func_175655_b(pos, true);
                }
            }
        }
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 200.0).func_233815_a_(Attributes.field_233821_d_, 0.3).func_233815_a_(Attributes.field_233823_f_, 5.0).func_233815_a_(Attributes.field_233819_b_, 80.0);
    }
    
    private void setSegmentsPerHealth() {
        final int oldSegments = this.currentSegmentCount;
        final int newSegments = MathHelper.func_76125_a((int)(this.func_110143_aJ() / this.healthPerSegment + ((this.func_110143_aJ() > 0.0f) ? 2 : 0)), 0, 12);
        this.currentSegmentCount = newSegments;
        if (newSegments < oldSegments) {
            for (int i = newSegments; i < oldSegments; ++i) {
                this.bodySegments[i].selfDestruct();
            }
        }
        else if (newSegments > oldSegments) {
            this.activateBodySegments();
        }
        if (!this.field_70170_p.field_72995_K) {
            double newSpeed = 0.3 - newSegments * -0.016666668f;
            if (newSpeed < 0.0) {
                newSpeed = 0.0;
            }
            this.func_110148_a(Attributes.field_233821_d_).func_111128_a(newSpeed);
        }
    }
    
    public boolean func_226271_bk_() {
        return false;
    }
    
    public boolean func_180799_ab() {
        return false;
    }
    
    public void func_70071_h_() {
        if (this.field_70725_aQ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.field_70146_Z.nextGaussian() * 0.02;
                final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                this.field_70170_p.func_195594_a((IParticleData)(this.field_70146_Z.nextBoolean() ? ParticleTypes.field_197626_s : ParticleTypes.field_197627_t), this.func_226277_ct_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextFloat() * this.func_213302_cg(), this.func_226281_cx_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), d, d2, d3);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.field_70170_p.field_72995_K && this.ticksSinceDamaged > 600 && this.ticksSinceDamaged % 20 == 0) {
            this.func_70691_i(1.0f);
        }
        this.setSegmentsPerHealth();
        super.func_70071_h_();
        this.moveSegments();
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.func_70638_az() != null && (this.func_70068_e((Entity)this.func_70638_az()) > 6400.0 || !this.isEntityWithinHomeArea((Entity)this.func_70638_az()))) {
            this.func_70624_b((LivingEntity)null);
        }
        final double d = this.func_213311_cf() * 4.0f;
        Vector3d vec3d = this.func_70781_l() ? this.func_70661_as().func_75505_d().func_75878_a((Entity)this) : null;
        while (vec3d != null && vec3d.func_186679_c(this.func_226277_ct_(), vec3d.field_72448_b, this.func_226281_cx_()) < d * d) {
            this.func_70661_as().func_75505_d().func_75875_a();
            if (this.func_70661_as().func_75505_d().func_75879_b()) {
                vec3d = null;
            }
            else {
                vec3d = this.func_70661_as().func_75505_d().func_75878_a((Entity)this);
            }
        }
        if (!this.func_213383_dH()) {
            this.func_70624_b((LivingEntity)null);
            this.func_70661_as().func_75484_a(this.func_70661_as().func_179680_a(this.func_213384_dI(), 0), 1.0);
        }
        this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.NAGA_HISS;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.NAGA_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.NAGA_HURT;
    }
    
    private void crumbleBelowTarget(final int range) {
        if (!ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this)) {
            return;
        }
        final int floor = (int)this.func_174813_aQ().field_72338_b;
        final int targetY = (int)this.func_70638_az().func_174813_aQ().field_72338_b;
        if (targetY > floor) {
            final int dx = (int)this.func_70638_az().func_226277_ct_() + this.field_70146_Z.nextInt(range) - this.field_70146_Z.nextInt(range);
            final int dz = (int)this.func_70638_az().func_226281_cx_() + this.field_70146_Z.nextInt(range) - this.field_70146_Z.nextInt(range);
            int dy = targetY - this.field_70146_Z.nextInt(range) + this.field_70146_Z.nextInt((range > 1) ? (range - 1) : range);
            if (dy <= floor) {
                dy = targetY;
            }
            final BlockPos pos = new BlockPos(dx, dy, dz);
            if (EntityUtil.canDestroyBlock(this.field_70170_p, pos, (Entity)this)) {
                this.field_70170_p.func_175655_b(pos, true);
                for (int k = 0; k < 20; ++k) {
                    final double d = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                    this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197614_g, this.func_226277_ct_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextFloat() * this.func_213302_cg(), this.func_226281_cx_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), d, d2, d3);
                }
            }
        }
    }
    
    private void goSlow() {
        this.func_110148_a(Attributes.field_233821_d_).func_111124_b(this.slowSpeed);
        this.func_110148_a(Attributes.field_233821_d_).func_111124_b(this.fastSpeed);
        this.func_110148_a(Attributes.field_233821_d_).func_233767_b_(this.slowSpeed);
    }
    
    private void goNormal() {
        this.func_110148_a(Attributes.field_233821_d_).func_111124_b(this.slowSpeed);
        this.func_110148_a(Attributes.field_233821_d_).func_111124_b(this.fastSpeed);
    }
    
    private void goFast() {
        this.func_110148_a(Attributes.field_233821_d_).func_111124_b(this.slowSpeed);
        this.func_110148_a(Attributes.field_233821_d_).func_111124_b(this.fastSpeed);
        this.func_110148_a(Attributes.field_233821_d_).func_233767_b_(this.fastSpeed);
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    private BlockPos findCirclePoint(final boolean clockwise, final double radius, final double rotation) {
        final LivingEntity toCircle = this.func_70638_az();
        final double vecx = this.func_226277_ct_() - toCircle.func_226277_ct_();
        final double vecz = this.func_226281_cx_() - toCircle.func_226281_cx_();
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)(clockwise ? rotation : (-rotation));
        final double dx = MathHelper.func_76134_b(rangle) * radius;
        final double dz = MathHelper.func_76126_a(rangle) * radius;
        final double dy = Math.min(this.func_174813_aQ().field_72338_b, toCircle.func_226278_cu_());
        return new BlockPos(toCircle.func_226277_ct_() + dx, dy, toCircle.func_226281_cx_() + dz);
    }
    
    public boolean func_180431_b(final DamageSource src) {
        return (src.func_76346_g() != null && !this.isEntityWithinHomeArea(src.func_76346_g())) || (src.func_76364_f() != null && !this.isEntityWithinHomeArea(src.func_76364_f())) || src.func_76347_k() || src.func_94541_c() || super.func_180431_b(src);
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        if (source != DamageSource.field_76379_h && super.func_70097_a(source, amount)) {
            this.ticksSinceDamaged = 0;
            return true;
        }
        return false;
    }
    
    public boolean func_70652_k(final Entity toAttack) {
        if (this.movementAI.movementState == MovementState.CHARGE && toAttack instanceof LivingEntity && ((LivingEntity)toAttack).func_184585_cz()) {
            final Vector3d motion = this.func_213322_ci();
            toAttack.func_70024_g(motion.field_72450_a * 1.25, 0.5, motion.field_72449_c * 1.25);
            this.func_213293_j(motion.field_72450_a * -1.5, motion.field_72448_b + 0.5, motion.field_72449_c * -1.5);
            if (toAttack instanceof ServerPlayerEntity) {
                TFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity)toAttack), (Object)new ThrowPlayerPacket((float)toAttack.func_213322_ci().func_82615_a(), (float)toAttack.func_213322_ci().func_82617_b(), (float)toAttack.func_213322_ci().func_82616_c()));
            }
            this.func_70097_a(DamageSource.field_76377_j, 4.0f);
            this.field_70170_p.func_184133_a((PlayerEntity)null, toAttack.func_233580_cy_(), SoundEvents.field_187767_eL, SoundCategory.PLAYERS, 1.0f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
            this.movementAI.doDaze();
            return false;
        }
        final boolean result = super.func_70652_k(toAttack);
        if (result) {
            toAttack.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70177_z * 3.141593f / 180.0f) * 2.0f), 0.4000000059604645, (double)(MathHelper.func_76134_b(this.field_70177_z * 3.141593f / 180.0f) * 2.0f));
        }
        return result;
    }
    
    public float func_180484_a(final BlockPos pos) {
        if (!this.func_213389_a(pos)) {
            return Float.MIN_VALUE;
        }
        return 0.0f;
    }
    
    public void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            if (this.func_213384_dI() != BlockPos.field_177992_a) {
                this.field_70170_p.func_175656_a(this.func_213384_dI(), ((Block)TFBlocks.boss_spawner_naga.get()).func_176223_P());
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    public void func_70106_y() {
        super.func_70106_y();
        if (this.field_70170_p instanceof ServerWorld) {
            for (final NagaSegmentEntity seg : this.bodySegments) {
                seg.func_70106_y();
            }
        }
    }
    
    public boolean func_213389_a(final BlockPos pos) {
        if (this.func_213391_dJ() == -1.0f) {
            return true;
        }
        final int distX = Math.abs(this.func_213384_dI().func_177958_n() - pos.func_177958_n());
        final int distY = Math.abs(this.func_213384_dI().func_177956_o() - pos.func_177956_o());
        final int distZ = Math.abs(this.func_213384_dI().func_177952_p() - pos.func_177952_p());
        return distX <= 46 && distY <= 7 && distZ <= 46;
    }
    
    private boolean isEntityWithinHomeArea(final Entity entity) {
        return this.func_213389_a(entity.func_233580_cy_());
    }
    
    private void activateBodySegments() {
        for (int i = 0; i < this.currentSegmentCount; ++i) {
            final NagaSegmentEntity segment = this.bodySegments[i];
            segment.activate();
            segment.func_70012_b(this.func_226277_ct_() + 0.1 * i, this.func_226278_cu_() + 0.5, this.func_226281_cx_() + 0.1 * i, this.field_70146_Z.nextFloat() * 360.0f, 0.0f);
            for (int j = 0; j < 20; ++j) {
                final double d0 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197627_t, segment.func_226277_ct_() + this.field_70146_Z.nextFloat() * segment.func_213311_cf() * 2.0f - segment.func_213311_cf() - d0 * 10.0, segment.func_226278_cu_() + this.field_70146_Z.nextFloat() * segment.func_213302_cg() - d2 * 10.0, segment.func_226281_cx_() + this.field_70146_Z.nextFloat() * segment.func_213311_cf() * 2.0f - segment.func_213311_cf() - d3 * 10.0, d0, d2, d3);
            }
        }
    }
    
    private void moveSegments() {
        for (int i = 0; i < this.bodySegments.length; ++i) {
            this.bodySegments[i].func_70071_h_();
            final Entity leader = (Entity)((i == 0) ? this : this.bodySegments[i - 1]);
            final double followX = leader.func_226277_ct_();
            final double followY = leader.func_226278_cu_();
            final double followZ = leader.func_226281_cx_();
            final float angle = (leader.field_70177_z + 180.0f) * 3.141593f / 180.0f;
            final double straightenForce = 0.05 + 1.0 / (i + 1) * 0.5;
            final double idealX = -MathHelper.func_76126_a(angle) * straightenForce;
            final double idealZ = MathHelper.func_76134_b(angle) * straightenForce;
            Vector3d diff = new Vector3d(this.bodySegments[i].func_226277_ct_() - followX, this.bodySegments[i].func_226278_cu_() - followY, this.bodySegments[i].func_226281_cx_() - followZ);
            diff = diff.func_72432_b();
            diff = diff.func_72441_c(idealX, 0.0, idealZ).func_72432_b();
            final double f = 2.0;
            final double destX = followX + f * diff.field_72450_a;
            final double destY = followY + f * diff.field_72448_b;
            final double destZ = followZ + f * diff.field_72449_c;
            this.bodySegments[i].func_70107_b(destX, destY, destZ);
            final double distance = MathHelper.func_76133_a(diff.field_72450_a * diff.field_72450_a + diff.field_72449_c * diff.field_72449_c);
            if (i == 0) {
                diff = diff.func_72441_c(0.0, -0.15, 0.0);
            }
            this.bodySegments[i].func_70101_b((float)(Math.atan2(diff.field_72449_c, diff.field_72450_a) * 180.0 / 3.141592653589793) + 90.0f, -(float)(Math.atan2(diff.field_72448_b, distance) * 180.0 / 3.141592653589793));
        }
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        if (this.func_213384_dI() != BlockPos.field_177992_a) {
            final BlockPos home = this.func_213384_dI();
            compound.func_218657_a("Home", (INBT)new IntArrayNBT(new int[] { home.func_177958_n(), home.func_177956_o(), home.func_177952_p() }));
        }
        super.func_213281_b(compound);
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        if (compound.func_150297_b("Home", 11)) {
            final int[] home = compound.func_74759_k("Home");
            this.func_213390_a(new BlockPos(home[0], home[1], home[2]), 20);
        }
        else {
            this.func_213394_dL();
        }
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFGenerationSettings.markStructureConquered(this.field_70170_p, new BlockPos((Vector3i)this.func_233580_cy_()), TFFeature.NAGA_COURTYARD);
        }
    }
    
    public boolean isMultipartEntity() {
        return true;
    }
    
    @Nullable
    public PartEntity<?>[] getParts() {
        return this.bodySegments;
    }
    
    public void func_184178_b(final ServerPlayerEntity player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final ServerPlayerEntity player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static /* synthetic */ float access$800(final NagaEntity x0) {
        return x0.func_70599_aP();
    }
    
    static /* synthetic */ float access$900(final NagaEntity x0) {
        return x0.func_70647_i();
    }
    
    static {
        DATA_DAZE = EntityDataManager.func_187226_a((Class)NagaEntity.class, DataSerializers.field_187198_h);
        DATA_CHARGE = EntityDataManager.func_187226_a((Class)NagaEntity.class, DataSerializers.field_187198_h);
    }
    
    static class AIAttack extends Goal
    {
        private final NagaEntity taskOwner;
        private int attackTick;
        
        AIAttack(final NagaEntity taskOwner) {
            this.attackTick = 20;
            this.taskOwner = taskOwner;
        }
        
        public boolean func_75250_a() {
            final LivingEntity target = this.taskOwner.func_70638_az();
            return target != null && target.func_174813_aQ().field_72337_e > this.taskOwner.func_174813_aQ().field_72338_b - 2.5 && target.func_174813_aQ().field_72338_b < this.taskOwner.func_174813_aQ().field_72337_e + 2.5 && this.taskOwner.func_70068_e((Entity)target) <= 4.0 && this.taskOwner.func_70635_at().func_75522_a((Entity)target);
        }
        
        public void func_75246_d() {
            if (this.attackTick > 0) {
                --this.attackTick;
            }
        }
        
        public void func_75251_c() {
            this.attackTick = 20;
        }
        
        public void func_75249_e() {
            this.taskOwner.func_70652_k((Entity)this.taskOwner.func_70638_az());
            this.attackTick = 20;
        }
    }
    
    static class AISmash extends Goal
    {
        private final NagaEntity taskOwner;
        
        AISmash(final NagaEntity taskOwner) {
            this.taskOwner = taskOwner;
        }
        
        public boolean func_75250_a() {
            return this.taskOwner.field_70123_F && ForgeEventFactory.getMobGriefingEvent(this.taskOwner.field_70170_p, (Entity)this.taskOwner);
        }
        
        public void func_75249_e() {
            if (this.taskOwner.field_70170_p.field_72995_K) {
                return;
            }
            final AxisAlignedBB bb = this.taskOwner.func_174813_aQ();
            final int minx = MathHelper.func_76128_c(bb.field_72340_a - 0.75);
            final int miny = MathHelper.func_76128_c(bb.field_72338_b + 1.01);
            final int minz = MathHelper.func_76128_c(bb.field_72339_c - 0.75);
            final int maxx = MathHelper.func_76128_c(bb.field_72336_d + 0.75);
            final int maxy = MathHelper.func_76128_c(bb.field_72337_e + 0.0);
            final int maxz = MathHelper.func_76128_c(bb.field_72334_f + 0.75);
            final BlockPos min = new BlockPos(minx, miny, minz);
            final BlockPos max = new BlockPos(maxx, maxy, maxz);
            if (this.taskOwner.field_70170_p.func_175707_a(min, max)) {
                for (final BlockPos pos : BlockPos.func_218278_a(min, max)) {
                    if (EntityUtil.canDestroyBlock(this.taskOwner.field_70170_p, pos, (Entity)this.taskOwner)) {
                        this.taskOwner.field_70170_p.func_175655_b(pos, true);
                    }
                }
            }
        }
    }
    
    enum MovementState
    {
        INTIMIDATE, 
        CRUMBLE, 
        CHARGE, 
        CIRCLE, 
        DAZE;
    }
    
    static class AIMovementPattern extends Goal
    {
        private final NagaEntity taskOwner;
        private MovementState movementState;
        private int stateCounter;
        private boolean clockwise;
        
        AIMovementPattern(final NagaEntity taskOwner) {
            this.taskOwner = taskOwner;
            this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
            this.func_75251_c();
        }
        
        public boolean func_75250_a() {
            return this.taskOwner.func_70638_az() != null;
        }
        
        public void func_75251_c() {
            this.movementState = MovementState.CIRCLE;
            this.stateCounter = 15;
            this.clockwise = false;
        }
        
        public void func_75246_d() {
            if (!this.taskOwner.func_70661_as().func_75500_f()) {
                this.taskOwner.setDazed(false);
                return;
            }
            switch (this.movementState) {
                case INTIMIDATE: {
                    this.taskOwner.func_70661_as().func_75499_g();
                    this.taskOwner.func_70671_ap().func_75651_a((Entity)this.taskOwner.func_70638_az(), 30.0f, 30.0f);
                    this.taskOwner.func_70625_a((Entity)this.taskOwner.func_70638_az(), 30.0f, 30.0f);
                    this.taskOwner.field_191988_bg = 0.1f;
                    break;
                }
                case CRUMBLE: {
                    this.taskOwner.func_70661_as().func_75499_g();
                    this.taskOwner.crumbleBelowTarget(2);
                    this.taskOwner.crumbleBelowTarget(3);
                    break;
                }
                case CHARGE: {
                    final BlockPos tpoint = this.taskOwner.findCirclePoint(this.clockwise, 14.0, 3.141592653589793);
                    this.taskOwner.func_70661_as().func_75492_a((double)tpoint.func_177958_n(), (double)tpoint.func_177956_o(), (double)tpoint.func_177952_p(), 1.0);
                    this.taskOwner.setCharging(true);
                    break;
                }
                case CIRCLE: {
                    double radius = (this.stateCounter % 2 == 0) ? 12.0 : 14.0;
                    double rotation = 1.0;
                    if (this.stateCounter == 2) {
                        radius = 16.0;
                    }
                    if (this.stateCounter == 1) {
                        rotation = 0.1;
                    }
                    final BlockPos tpoint2 = this.taskOwner.findCirclePoint(this.clockwise, radius, rotation);
                    this.taskOwner.func_70661_as().func_75492_a((double)tpoint2.func_177958_n(), (double)tpoint2.func_177956_o(), (double)tpoint2.func_177952_p(), 1.0);
                    break;
                }
                case DAZE: {
                    this.taskOwner.setDazed(true);
                    this.taskOwner.setCharging(false);
                    break;
                }
            }
            --this.stateCounter;
            if (this.stateCounter <= 0) {
                this.transitionState();
            }
        }
        
        private void transitionState() {
            this.taskOwner.setDazed(false);
            this.taskOwner.setCharging(false);
            switch (this.movementState) {
                case INTIMIDATE: {
                    this.clockwise = !this.clockwise;
                    if (this.taskOwner.func_70638_az().func_174813_aQ().field_72338_b > this.taskOwner.func_174813_aQ().field_72337_e) {
                        this.doCrumblePlayer();
                        break;
                    }
                    this.doCharge();
                    break;
                }
                case CRUMBLE: {
                    this.doCharge();
                    break;
                }
                case CHARGE:
                case DAZE: {
                    this.doCircle();
                    break;
                }
                case CIRCLE: {
                    this.doIntimidate();
                    break;
                }
            }
        }
        
        private void doDaze() {
            this.movementState = MovementState.DAZE;
            this.taskOwner.func_70661_as().func_75499_g();
            this.stateCounter = 60 + this.taskOwner.field_70146_Z.nextInt(40);
        }
        
        private void doCircle() {
            this.movementState = MovementState.CIRCLE;
            this.stateCounter += 10 + this.taskOwner.field_70146_Z.nextInt(10);
            this.taskOwner.goNormal();
        }
        
        private void doCrumblePlayer() {
            this.movementState = MovementState.CRUMBLE;
            this.stateCounter = 20 + this.taskOwner.field_70146_Z.nextInt(20);
            this.taskOwner.goSlow();
        }
        
        private void doCharge() {
            this.movementState = MovementState.CHARGE;
            this.stateCounter = 3;
            this.taskOwner.goFast();
        }
        
        private void doIntimidate() {
            this.movementState = MovementState.INTIMIDATE;
            this.taskOwner.func_184185_a(TFSounds.NAGA_RATTLE, NagaEntity.access$800(this.taskOwner) * 4.0f, NagaEntity.access$900(this.taskOwner));
            this.stateCounter += 15 + this.taskOwner.field_70146_Z.nextInt(10);
            this.taskOwner.goSlow();
        }
    }
    
    static class NagaMoveHelper extends MovementController
    {
        public NagaMoveHelper(final MobEntity naga) {
            super(naga);
        }
        
        public void func_75641_c() {
            final MovementState currentState = ((NagaEntity)this.field_75648_a).movementAI.movementState;
            if (currentState == MovementState.DAZE) {
                this.field_75648_a.field_70702_br = 0.0f;
            }
            else if (currentState != MovementState.CHARGE && currentState != MovementState.INTIMIDATE) {
                this.field_75648_a.field_70702_br = MathHelper.func_76134_b(this.field_75648_a.field_70173_aa * 0.3f) * 0.6f;
            }
            else {
                final MobEntity field_75648_a = this.field_75648_a;
                field_75648_a.field_70702_br *= 0.8f;
            }
            super.func_75641_c();
        }
    }
}
