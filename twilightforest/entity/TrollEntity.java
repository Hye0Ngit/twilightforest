// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import java.util.Random;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import twilightforest.TFSounds;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.boss.IceBombEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import java.util.Iterator;
import twilightforest.util.WorldUtil;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.MonsterEntity;

public class TrollEntity extends MonsterEntity implements IRangedAttackMob
{
    private static final DataParameter<Boolean> ROCK_FLAG;
    private static final AttributeModifier ROCK_MODIFIER;
    private RangedAttackGoal aiArrowAttack;
    private MeleeAttackGoal aiAttackOnCollide;
    
    public TrollEntity(final EntityType<? extends TrollEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    public void func_184651_r() {
        this.aiArrowAttack = new RangedAttackGoal((IRangedAttackMob)this, 1.0, 20, 60, 15.0f);
        this.aiAttackOnCollide = new MeleeAttackGoal((CreatureEntity)this, 1.2, false);
        this.field_70714_bg.func_75776_a(1, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(2, (Goal)new RestrictSunGoal((CreatureEntity)this));
        this.field_70714_bg.func_75776_a(3, (Goal)new FleeSunGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
        if (this.field_70170_p != null && !this.field_70170_p.field_72995_K) {
            this.setCombatTask();
        }
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 30.0).func_233815_a_(Attributes.field_233821_d_, 0.28).func_233815_a_(Attributes.field_233823_f_, 7.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)TrollEntity.ROCK_FLAG, (Object)false);
    }
    
    public boolean hasRock() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)TrollEntity.ROCK_FLAG);
    }
    
    public void setHasRock(final boolean rock) {
        this.field_70180_af.func_187227_b((DataParameter)TrollEntity.ROCK_FLAG, (Object)rock);
        if (!this.field_70170_p.field_72995_K) {
            if (rock) {
                if (!this.func_110148_a(Attributes.field_233819_b_).func_180374_a(TrollEntity.ROCK_MODIFIER)) {
                    this.func_110148_a(Attributes.field_233819_b_).func_233767_b_(TrollEntity.ROCK_MODIFIER);
                }
            }
            else {
                this.func_110148_a(Attributes.field_233819_b_).func_111124_b(TrollEntity.ROCK_MODIFIER);
            }
            this.setCombatTask();
        }
    }
    
    public boolean func_70652_k(final Entity entity) {
        this.func_184609_a(Hand.MAIN_HAND);
        return super.func_70652_k(entity);
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74757_a("HasRock", this.hasRock());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setHasRock(compound.func_74767_n("HasRock"));
    }
    
    private void setCombatTask() {
        this.field_70714_bg.func_85156_a((Goal)this.aiAttackOnCollide);
        this.field_70714_bg.func_85156_a((Goal)this.aiArrowAttack);
        if (this.hasRock()) {
            this.field_70714_bg.func_75776_a(4, (Goal)this.aiArrowAttack);
        }
        else {
            this.field_70714_bg.func_75776_a(4, (Goal)this.aiAttackOnCollide);
        }
    }
    
    protected void func_70609_aI() {
        super.func_70609_aI();
        if (this.field_70725_aQ % 5 == 0) {
            this.ripenTrollBerNearby(this.field_70725_aQ / 5);
        }
    }
    
    private void ripenTrollBerNearby(final int offset) {
        final int range = 12;
        for (final BlockPos pos : WorldUtil.getAllAround(new BlockPos((Vector3i)this.func_233580_cy_()), range)) {
            this.ripenBer(offset, pos);
        }
    }
    
    private void ripenBer(final int offset, final BlockPos pos) {
        if (this.field_70170_p.func_180495_p(pos).func_177230_c() == TFBlocks.unripe_trollber.get() && this.field_70146_Z.nextBoolean() && Math.abs(pos.func_177958_n() + pos.func_177956_o() + pos.func_177952_p()) % 5 == offset) {
            this.field_70170_p.func_175656_a(pos, ((Block)TFBlocks.trollber.get()).func_176223_P());
            this.field_70170_p.func_217379_c(2004, pos, 0);
        }
    }
    
    public void func_82196_d(final LivingEntity target, final float distanceFactor) {
        if (this.hasRock()) {
            final IceBombEntity ice = new IceBombEntity(TFEntities.thrown_ice, this.field_70170_p, (LivingEntity)this);
            final double d0 = target.func_226277_ct_() - this.func_226277_ct_();
            final double d2 = target.func_174813_aQ().field_72338_b + target.func_213302_cg() / 3.0f - ice.func_226278_cu_();
            final double d3 = target.func_226281_cx_() - this.func_226281_cx_();
            final double d4 = MathHelper.func_76133_a(d0 * d0 + d3 * d3);
            ice.func_70186_c(d0, d2 + d4 * 0.20000000298023224, d3, 1.6f, (float)(14 - this.field_70170_p.func_175659_aa().func_151525_a() * 4));
            this.func_184185_a(TFSounds.ICEBOMB_FIRED, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_217376_c((Entity)ice);
        }
    }
    
    public static boolean canSpawn(final EntityType<? extends TrollEntity> type, final IWorld world, final SpawnReason reason, final BlockPos pos, final Random rand) {
        final BlockPos blockpos = pos.func_177977_b();
        return world.func_180495_p(blockpos).func_177230_c() != TFBlocks.giant_obsidian.get() && !world.func_226660_f_(pos) && pos.func_177956_o() < 60;
    }
    
    static {
        ROCK_FLAG = EntityDataManager.func_187226_a((Class)TrollEntity.class, DataSerializers.field_187198_h);
        ROCK_MODIFIER = new AttributeModifier("Rock follow boost", 24.0, AttributeModifier.Operation.ADDITION);
    }
}
