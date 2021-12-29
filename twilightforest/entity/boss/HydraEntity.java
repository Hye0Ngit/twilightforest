// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.world.GameRules;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFFeature;
import net.minecraft.util.math.vector.Vector3i;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.entity.PartEntity;
import net.minecraft.util.DamageSource;
import twilightforest.util.EntityUtil;
import twilightforest.util.WorldUtil;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.math.BlockPos;
import java.util.Iterator;
import java.util.function.ToDoubleFunction;
import java.util.Comparator;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.MobEntity;

public class HydraEntity extends MobEntity implements IMob
{
    private static final int TICKS_BEFORE_HEALING = 1000;
    private static final int HEAD_RESPAWN_TICKS = 100;
    private static final int HEAD_MAX_DAMAGE = 120;
    private static final float ARMOR_MULTIPLIER = 8.0f;
    private static final int MAX_HEALTH = 360;
    private static float HEADS_ACTIVITY_FACTOR;
    private static final int SECONDARY_FLAME_CHANCE = 10;
    private static final int SECONDARY_MORTAR_CHANCE = 16;
    private final HydraPartEntity[] partArray;
    public final int numHeads = 7;
    public final HydraHeadContainer[] hc;
    public final HydraSmallPartEntity body;
    private final HydraSmallPartEntity leftLeg;
    private final HydraSmallPartEntity rightLeg;
    private final HydraSmallPartEntity tail;
    private final ServerBossInfo bossInfo;
    private float randomYawVelocity;
    private int ticksSinceDamaged;
    private int numTicksToChaseTarget;
    
    public HydraEntity(final EntityType<? extends HydraEntity> type, final World world) {
        super((EntityType)type, world);
        this.hc = new HydraHeadContainer[7];
        this.bossInfo = new ServerBossInfo(this.func_145748_c_(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS);
        this.randomYawVelocity = 0.0f;
        this.ticksSinceDamaged = 0;
        final List<HydraPartEntity> parts = new ArrayList<HydraPartEntity>();
        this.body = new HydraSmallPartEntity(this, 6.0f, 6.0f);
        this.leftLeg = new HydraSmallPartEntity(this, 2.0f, 3.0f);
        this.rightLeg = new HydraSmallPartEntity(this, 2.0f, 3.0f);
        this.tail = new HydraSmallPartEntity(this, 6.0f, 2.0f);
        parts.add(this.body);
        parts.add(this.leftLeg);
        parts.add(this.rightLeg);
        parts.add(this.tail);
        for (int i = 0; i < 7; ++i) {
            this.hc[i] = new HydraHeadContainer(this, i, i < 3);
            parts.add(this.hc[i].headEntity);
            Collections.addAll(parts, this.hc[i].getNeckArray());
        }
        this.partArray = parts.toArray(new HydraPartEntity[0]);
        this.field_70158_ak = true;
        this.func_230279_az_();
        this.field_70728_aV = 511;
    }
    
    public void func_200203_b(@Nullable final ITextComponent name) {
        super.func_200203_b(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 360.0).func_233815_a_(Attributes.field_233821_d_, 0.28);
    }
    
    public void func_184178_b(final ServerPlayerEntity player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final ServerPlayerEntity player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    public void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            this.field_70170_p.func_175656_a(this.func_233580_cy_().func_177982_a(0, 2, 0), ((Block)TFBlocks.boss_spawner_hydra.get()).func_176223_P());
            this.func_70106_y();
            for (final HydraHeadContainer container : this.hc) {
                if (container.headEntity != null) {
                    container.headEntity.func_70106_y();
                }
            }
        }
        else {
            super.func_70623_bb();
        }
    }
    
    protected float func_110146_f(final float p_110146_1_, float p_110146_2_) {
        final float f = MathHelper.func_76142_g(p_110146_1_ - this.field_70761_aq);
        this.field_70761_aq += f * 0.3f;
        float f2 = MathHelper.func_76142_g(this.field_70177_z - this.field_70761_aq);
        final boolean flag = f2 < -90.0f || f2 >= 90.0f;
        if (f2 < -75.0f) {
            f2 = -75.0f;
        }
        if (f2 >= 75.0f) {
            f2 = 75.0f;
        }
        this.field_70761_aq = this.field_70177_z - f2;
        if (f2 * f2 > 2500.0f) {
            this.field_70761_aq += f2 * 0.2f;
        }
        if (flag) {
            p_110146_2_ *= -1.0f;
        }
        return p_110146_2_;
    }
    
    public void func_70636_d() {
        this.func_70066_B();
        this.body.func_70071_h_();
        this.leftLeg.func_70071_h_();
        this.rightLeg.func_70071_h_();
        for (int i = 0; i < 7; ++i) {
            this.hc[i].tick();
        }
        if (this.field_70737_aN > 0) {
            for (int i = 0; i < 7; ++i) {
                this.hc[i].setHurtTime(this.field_70737_aN);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.field_70170_p.field_72995_K && this.ticksSinceDamaged > 1000 && this.ticksSinceDamaged % 5 == 0) {
            this.func_70691_i(1.0f);
        }
        this.setDifficultyVariables();
        super.func_70636_d();
        final float angle = (this.field_70761_aq + 180.0f) * 3.141593f / 180.0f;
        double dx = this.func_226277_ct_() - MathHelper.func_76126_a(angle) * 3.0;
        double dy = this.func_226278_cu_() + 0.1;
        double dz = this.func_226281_cx_() + MathHelper.func_76134_b(angle) * 3.0;
        this.body.func_70107_b(dx, dy, dz);
        dx = this.func_226277_ct_() - MathHelper.func_76126_a(angle) * 10.5;
        dy = this.func_226278_cu_() + 0.1;
        dz = this.func_226281_cx_() + MathHelper.func_76134_b(angle) * 10.5;
        this.tail.func_70107_b(dx, dy, dz);
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70737_aN == 0) {
                this.collideWithEntities(this.field_70170_p.func_72839_b((Entity)this, this.body.func_174813_aQ()), (Entity)this.body);
                this.collideWithEntities(this.field_70170_p.func_72839_b((Entity)this, this.tail.func_174813_aQ()), (Entity)this.tail);
            }
            this.destroyBlocksInAABB(this.body.func_174813_aQ());
            this.destroyBlocksInAABB(this.tail.func_174813_aQ());
            for (int j = 0; j < 7; ++j) {
                if (this.hc[j].headEntity != null && this.hc[j].isActive()) {
                    this.destroyBlocksInAABB(this.hc[j].headEntity.func_174813_aQ());
                }
            }
            if (this.field_70173_aa % 20 == 0 && this.isUnsteadySurfaceBeneath()) {
                this.destroyBlocksInAABB(this.func_174813_aQ().func_72317_d(0.0, -1.0, 0.0));
            }
            this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
        }
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74774_a("NumHeads", (byte)this.countActiveHeads());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.activateNumberOfHeads(compound.func_74771_c("NumHeads"));
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    protected void func_70619_bc() {
        this.field_70702_br = 0.0f;
        this.field_191988_bg = 0.0f;
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
        if (this.field_70146_Z.nextFloat() < 0.7f) {
            final PlayerEntity entityplayer1 = this.field_70170_p.func_217362_a((Entity)this, (double)f);
            if (entityplayer1 != null && !entityplayer1.func_184812_l_()) {
                this.func_70624_b((LivingEntity)entityplayer1);
                this.numTicksToChaseTarget = 100 + this.field_70146_Z.nextInt(20);
            }
            else {
                this.randomYawVelocity = (this.field_70146_Z.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.func_70638_az() != null) {
            this.func_70625_a((Entity)this.func_70638_az(), 10.0f, (float)this.func_70646_bf());
            for (int i = 0; i < 7; ++i) {
                if (!this.hc[i].isAttacking() && !this.hc[i].isSecondaryAttacking) {
                    this.hc[i].setTargetEntity((Entity)this.func_70638_az());
                }
            }
            if (this.func_70638_az().func_70089_S()) {
                final float distance = this.func_70638_az().func_70032_d((Entity)this);
                if (this.func_70635_at().func_75522_a((Entity)this.func_70638_az())) {
                    this.attackEntity((Entity)this.func_70638_az(), distance);
                }
            }
            if (this.numTicksToChaseTarget-- <= 0 || !this.func_70638_az().func_70089_S() || this.func_70638_az().func_70068_e((Entity)this) > f * f) {
                this.func_70624_b((LivingEntity)null);
            }
        }
        else {
            if (this.field_70146_Z.nextFloat() < 0.05f) {
                this.randomYawVelocity = (this.field_70146_Z.nextFloat() - 0.5f) * 20.0f;
            }
            this.field_70177_z += this.randomYawVelocity;
            this.field_70125_A = 0.0f;
            for (int i = 0; i < 7; ++i) {
                if (this.hc[i].isIdle()) {
                    this.hc[i].setTargetEntity(null);
                }
            }
        }
        this.secondaryAttacks();
    }
    
    private void setDifficultyVariables() {
        if (this.field_70170_p.func_175659_aa() != Difficulty.HARD) {
            HydraEntity.HEADS_ACTIVITY_FACTOR = 0.3f;
        }
        else {
            HydraEntity.HEADS_ACTIVITY_FACTOR = 0.5f;
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
        final boolean targetAbove = target.func_174813_aQ().field_72338_b > this.func_174813_aQ().field_72337_e;
        for (int i = 0; i < 3; ++i) {
            if (this.hc[i].isIdle() && !this.areTooManyHeadsAttacking(i)) {
                if (distance > 4.0f && distance < 10.0f && this.field_70146_Z.nextInt(BITE_CHANCE) == 0 && this.countActiveHeads() > 2 && !this.areOtherHeadsBiting(i)) {
                    this.hc[i].setNextState(HydraHeadContainer.State.BITE_BEGINNING);
                }
                else if (distance > 0.0f && distance < 20.0f && this.field_70146_Z.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(HydraHeadContainer.State.FLAME_BEGINNING);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.field_70146_Z.nextInt(MORTAR_CHANCE) == 0) {
                    this.hc[i].setNextState(HydraHeadContainer.State.MORTAR_BEGINNING);
                }
            }
        }
        for (int i = 3; i < 7; ++i) {
            if (this.hc[i].isIdle() && !this.areTooManyHeadsAttacking(i)) {
                if (distance > 0.0f && distance < 20.0f && this.field_70146_Z.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(HydraHeadContainer.State.FLAME_BEGINNING);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.field_70146_Z.nextInt(MORTAR_CHANCE) == 0) {
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
        return otherAttacks >= 1.0f + this.countActiveHeads() * HydraEntity.HEADS_ACTIVITY_FACTOR;
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
            final float distance = secondaryTarget.func_70032_d((Entity)this);
            for (int j = 1; j < 7; ++j) {
                if (this.hc[j].isActive() && this.hc[j].isIdle() && this.isTargetOnThisSide(j, (Entity)secondaryTarget)) {
                    if (distance > 0.0f && distance < 20.0f && this.field_70146_Z.nextInt(10) == 0) {
                        this.hc[j].setTargetEntity((Entity)secondaryTarget);
                        this.hc[j].isSecondaryAttacking = true;
                        this.hc[j].setNextState(HydraHeadContainer.State.FLAME_BEGINNING);
                    }
                    else if (distance > 8.0f && distance < 32.0f && this.field_70146_Z.nextInt(16) == 0) {
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
        final double distX = headEntity.func_226277_ct_() - target.func_226277_ct_();
        final double distZ = headEntity.func_226281_cx_() - target.func_226281_cx_();
        return distX * distX + distZ * distZ;
    }
    
    @Nullable
    private LivingEntity findSecondaryTarget(final double range) {
        return (LivingEntity)this.field_70170_p.func_217357_a((Class)LivingEntity.class, new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.func_226277_ct_() + 1.0, this.func_226278_cu_() + 1.0, this.func_226281_cx_() + 1.0).func_72314_b(range, range, range)).stream().filter(e -> !(e instanceof HydraEntity)).filter(e -> e != this.func_70638_az() && !this.isAnyHeadTargeting((Entity)e) && this.func_70635_at().func_75522_a((Entity)e) && EntityPredicates.field_233583_f_.test(e)).min(Comparator.comparingDouble((ToDoubleFunction<? super T>)this::func_70068_e)).orElse(null);
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
        final double d0 = (part.func_174813_aQ().field_72340_a + part.func_174813_aQ().field_72336_d) / 2.0;
        final double d2 = (part.func_174813_aQ().field_72339_c + part.func_174813_aQ().field_72334_f) / 2.0;
        for (final Entity entity : entities) {
            if (entity instanceof LivingEntity) {
                final double d3 = entity.func_226277_ct_() - d0;
                final double d4 = entity.func_226281_cx_() - d2;
                final double d5 = d3 * d3 + d4 * d4;
                entity.func_70024_g(d3 / d5 * 4.0, 0.20000000298023224, d4 / d5 * 4.0);
            }
        }
    }
    
    private boolean isUnsteadySurfaceBeneath() {
        final int minX = MathHelper.func_76128_c(this.func_174813_aQ().field_72340_a);
        final int minZ = MathHelper.func_76128_c(this.func_174813_aQ().field_72339_c);
        final int maxX = MathHelper.func_76128_c(this.func_174813_aQ().field_72336_d);
        final int maxZ = MathHelper.func_76128_c(this.func_174813_aQ().field_72334_f);
        final int minY = MathHelper.func_76128_c(this.func_174813_aQ().field_72338_b);
        int solid = 0;
        int total = 0;
        final int dy = minY - 1;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dz = minZ; dz <= maxZ; ++dz) {
                ++total;
                if (this.field_70170_p.func_180495_p(new BlockPos(dx, dy, dz)).func_185904_a().func_76220_a()) {
                    ++solid;
                }
            }
        }
        return solid / (float)total < 0.6f;
    }
    
    private void destroyBlocksInAABB(final AxisAlignedBB box) {
        if (ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this)) {
            for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
                if (EntityUtil.canDestroyBlock(this.field_70170_p, pos, (Entity)this)) {
                    this.field_70170_p.func_175655_b(pos, false);
                }
            }
        }
    }
    
    public int func_70646_bf() {
        return 500;
    }
    
    public boolean attackEntityFromPart(final HydraPartEntity part, final DamageSource source, final float damage) {
        if (!this.field_70170_p.field_72995_K && source == DamageSource.field_76368_d) {
            this.destroyBlocksInAABB(part.func_174813_aQ());
        }
        if (source.func_76346_g() == this || source.func_76364_f() == this) {
            return false;
        }
        if (this.getParts() != null) {
            for (final PartEntity<?> partEntity : this.getParts()) {
                if (partEntity == source.func_76346_g() || partEntity == source.func_76364_f()) {
                    return false;
                }
            }
        }
        HydraHeadContainer headCon = null;
        for (int i = 0; i < 7; ++i) {
            if (this.hc[i].headEntity == part) {
                headCon = this.hc[i];
            }
            else if (part instanceof HydraNeckEntity && this.hc[i].headEntity == ((HydraNeckEntity)part).head && !this.hc[i].isActive()) {
                return false;
            }
        }
        final double range = this.calculateRange(source);
        if (range > 400 + ((source.func_76364_f() instanceof HydraMortarHead) ? 200 : 0)) {
            return false;
        }
        if (headCon != null && !headCon.isActive()) {
            return false;
        }
        boolean tookDamage;
        if (headCon != null && headCon.getCurrentMouthOpen() > 0.5) {
            tookDamage = super.func_70097_a(source, damage);
            headCon.addDamage(damage);
        }
        else {
            final int armoredDamage = Math.round(damage / 8.0f);
            tookDamage = super.func_70097_a(source, (float)armoredDamage);
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
        return (damagesource.func_76346_g() != null) ? this.func_70068_e(damagesource.func_76346_g()) : -1.0;
    }
    
    public boolean func_70097_a(final DamageSource src, final float damage) {
        return src == DamageSource.field_76380_i && super.func_70097_a(src, damage);
    }
    
    public boolean isMultipartEntity() {
        return true;
    }
    
    @Nullable
    public PartEntity<?>[] getParts() {
        return this.partArray;
    }
    
    public boolean func_70067_L() {
        return false;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_82167_n(final Entity entity) {
    }
    
    public void func_233627_a_(final float strength, final double xRatio, final double zRatio) {
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.HYDRA_GROWL;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.HYDRA_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.HYDRA_DEATH;
    }
    
    protected float func_70599_aP() {
        return 2.0f;
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFGenerationSettings.markStructureConquered(this.field_70170_p, new BlockPos((Vector3i)this.func_233580_cy_()), TFFeature.HYDRA_LAIR);
        }
    }
    
    public boolean func_213397_c(final double distance) {
        return false;
    }
    
    public boolean func_70027_ad() {
        return false;
    }
    
    protected void func_70609_aI() {
        ++this.field_70725_aQ;
        if (this.field_70725_aQ == 1) {
            for (int i = 0; i < 7; ++i) {
                this.hc[i].setRespawnCounter(-1);
                if (this.hc[i].isActive()) {
                    this.hc[i].setNextState(HydraHeadContainer.State.IDLE);
                    this.hc[i].endCurrentAction();
                    this.hc[i].setHurtTime(200);
                }
            }
        }
        if (this.field_70725_aQ <= 140 && this.field_70725_aQ % 20 == 0) {
            final int headToDie = this.field_70725_aQ / 20 - 1;
            if (this.hc[headToDie].isActive()) {
                this.hc[headToDie].setNextState(HydraHeadContainer.State.DYING);
                this.hc[headToDie].endCurrentAction();
            }
        }
        if (this.field_70725_aQ == 200) {
            if (!this.field_70170_p.field_72995_K && (this.func_70684_aJ() || (this.field_70718_bc > 0 && this.func_146066_aG() && this.field_70170_p.func_82736_K().func_223586_b(GameRules.field_223602_e)))) {
                int i = this.func_70693_a(this.field_70717_bb);
                i = ForgeEventFactory.getExperienceDrop((LivingEntity)this, this.field_70717_bb, i);
                while (i > 0) {
                    final int j = ExperienceOrbEntity.func_70527_a(i);
                    i -= j;
                    this.field_70170_p.func_217376_c((Entity)new ExperienceOrbEntity(this.field_70170_p, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), j));
                }
            }
            this.func_70106_y();
        }
        for (int i = 0; i < 20; ++i) {
            final double vx = this.field_70146_Z.nextGaussian() * 0.02;
            final double vy = this.field_70146_Z.nextGaussian() * 0.02;
            final double vz = this.field_70146_Z.nextGaussian() * 0.02;
            this.field_70170_p.func_195594_a((IParticleData)((this.field_70146_Z.nextInt(2) == 0) ? ParticleTypes.field_197626_s : ParticleTypes.field_197627_t), this.func_226277_ct_() + this.field_70146_Z.nextFloat() * this.body.func_213311_cf() * 2.0f - this.body.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextFloat() * this.body.func_213302_cg(), this.func_226281_cx_() + this.field_70146_Z.nextFloat() * this.body.func_213311_cf() * 2.0f - this.body.func_213311_cf(), vx, vy, vz);
        }
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        HydraEntity.HEADS_ACTIVITY_FACTOR = 0.3f;
    }
}
