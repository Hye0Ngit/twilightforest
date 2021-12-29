// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.Difficulty;
import java.util.Random;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.TFSounds;
import net.minecraft.util.Mth;
import twilightforest.entity.projectile.IceBomb;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import twilightforest.block.TFBlocks;
import java.util.Iterator;
import twilightforest.util.WorldUtil;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.FleeSunGoal;
import net.minecraft.world.entity.ai.goal.RestrictSunGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;

public class Troll extends Monster implements RangedAttackMob
{
    private static final EntityDataAccessor<Boolean> ROCK_FLAG;
    private static final AttributeModifier ROCK_MODIFIER;
    private RangedAttackGoal aiArrowAttack;
    private MeleeAttackGoal aiAttackOnCollide;
    
    public Troll(final EntityType<? extends Troll> type, final Level world) {
        super((EntityType)type, world);
    }
    
    public void m_8099_() {
        this.aiArrowAttack = new RangedAttackGoal((RangedAttackMob)this, 1.0, 20, 60, 15.0f);
        this.aiAttackOnCollide = new MeleeAttackGoal((PathfinderMob)this, 1.2, false);
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(2, (Goal)new RestrictSunGoal((PathfinderMob)this));
        this.f_21345_.m_25352_(3, (Goal)new FleeSunGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
        if (this.f_19853_ != null && !this.f_19853_.f_46443_) {
            this.setCombatTask();
        }
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22279_, 0.28).m_22268_(Attributes.f_22281_, 7.0);
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)Troll.ROCK_FLAG, (Object)false);
    }
    
    public boolean hasRock() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)Troll.ROCK_FLAG);
    }
    
    public void setHasRock(final boolean rock) {
        this.f_19804_.m_135381_((EntityDataAccessor)Troll.ROCK_FLAG, (Object)rock);
        if (!this.f_19853_.f_46443_) {
            if (rock) {
                if (!this.m_21051_(Attributes.f_22277_).m_22109_(Troll.ROCK_MODIFIER)) {
                    this.m_21051_(Attributes.f_22277_).m_22118_(Troll.ROCK_MODIFIER);
                }
            }
            else {
                this.m_21051_(Attributes.f_22277_).m_22130_(Troll.ROCK_MODIFIER);
            }
            this.setCombatTask();
        }
    }
    
    public boolean m_7327_(final Entity entity) {
        this.m_6674_(InteractionHand.MAIN_HAND);
        return super.m_7327_(entity);
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        compound.m_128379_("HasRock", this.hasRock());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        this.setHasRock(compound.m_128471_("HasRock"));
    }
    
    private void setCombatTask() {
        this.f_21345_.m_25363_((Goal)this.aiAttackOnCollide);
        this.f_21345_.m_25363_((Goal)this.aiArrowAttack);
        if (this.hasRock()) {
            this.f_21345_.m_25352_(4, (Goal)this.aiArrowAttack);
        }
        else {
            this.f_21345_.m_25352_(4, (Goal)this.aiAttackOnCollide);
        }
    }
    
    protected void m_6153_() {
        super.m_6153_();
        if (this.f_20919_ % 5 == 0) {
            this.ripenTrollBerNearby(this.f_20919_ / 5);
        }
    }
    
    private void ripenTrollBerNearby(final int offset) {
        final int range = 12;
        for (final BlockPos pos : WorldUtil.getAllAround(new BlockPos((Vec3i)this.m_142538_()), range)) {
            this.ripenBer(offset, pos);
        }
    }
    
    private void ripenBer(final int offset, final BlockPos pos) {
        if (this.f_19853_.m_8055_(pos).m_60734_() == TFBlocks.UNRIPE_TROLLBER.get() && this.f_19796_.nextBoolean() && Math.abs(pos.m_123341_() + pos.m_123342_() + pos.m_123343_()) % 5 == offset) {
            this.f_19853_.m_46597_(pos, ((Block)TFBlocks.TROLLBER.get()).m_49966_());
            this.f_19853_.m_46796_(2004, pos, 0);
        }
    }
    
    public void m_6504_(final LivingEntity target, final float distanceFactor) {
        if (this.hasRock()) {
            final IceBomb ice = new IceBomb(TFEntities.THROWN_ICE, this.f_19853_, (LivingEntity)this);
            final double d0 = target.m_20185_() - this.m_20185_();
            final double d2 = target.m_142469_().f_82289_ + target.m_20206_() / 3.0f - ice.m_20186_();
            final double d3 = target.m_20189_() - this.m_20189_();
            final double d4 = Mth.m_14116_((float)(d0 * d0 + d3 * d3));
            ice.m_6686_(d0, d2 + d4 * 0.20000000298023224, d3, 1.6f, (float)(14 - this.f_19853_.m_46791_().m_19028_() * 4));
            this.m_5496_(TFSounds.ICEBOMB_FIRED, 1.0f, 1.0f / (this.m_21187_().nextFloat() * 0.4f + 0.8f));
            this.f_19853_.m_7967_((Entity)ice);
        }
    }
    
    public static boolean canSpawn(final EntityType<? extends Troll> type, final LevelAccessor world, final MobSpawnType reason, final BlockPos pos, final Random rand) {
        final BlockPos blockpos = pos.m_7495_();
        return world.m_46791_() != Difficulty.PEACEFUL && world.m_8055_(blockpos).m_60734_() != TFBlocks.GIANT_OBSIDIAN.get() && !world.m_45527_(pos);
    }
    
    static {
        ROCK_FLAG = SynchedEntityData.m_135353_((Class)Troll.class, EntityDataSerializers.f_135035_);
        ROCK_MODIFIER = new AttributeModifier("Rock follow boost", 24.0, AttributeModifier.Operation.ADDITION);
    }
}
