// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import java.util.Arrays;
import java.util.Collection;
import com.google.common.primitives.Ints;
import com.google.common.collect.Lists;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.AxeItem;
import net.minecraft.util.Mth;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundEvents;
import java.util.Iterator;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.Entity;
import twilightforest.advancements.TFAdvancements;
import twilightforest.world.registration.TFGenerationSettings;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.loot.TFTreasure;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.Item;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import twilightforest.entity.ai.PhantomThrowWeaponGoal;
import twilightforest.entity.ai.PhantomAttackStartGoal;
import twilightforest.entity.ai.PhantomUpdateFormationAndMoveGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import twilightforest.entity.ai.PhantomWatchAndAttackGoal;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.Mob;
import twilightforest.entity.NoClipMoveHelper;
import java.util.ArrayList;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.FlyingMob;

public class KnightPhantom extends FlyingMob implements Enemy
{
    private static final EntityDataAccessor<Boolean> FLAG_CHARGING;
    private static final AttributeModifier CHARGING_MODIFIER;
    private int number;
    private int ticksProgress;
    private Formation currentFormation;
    private BlockPos chargePos;
    private final List<ServerPlayer> hurtBy;
    private BlockPos homePosition;
    private float maximumHomeDistance;
    
    public KnightPhantom(final EntityType<? extends KnightPhantom> type, final Level world) {
        super((EntityType)type, world);
        this.chargePos = BlockPos.f_121853_;
        this.hurtBy = new ArrayList<ServerPlayer>();
        this.homePosition = BlockPos.f_121853_;
        this.maximumHomeDistance = -1.0f;
        this.f_19794_ = true;
        this.m_5825_();
        this.currentFormation = Formation.HOVER;
        this.f_21364_ = 93;
        this.f_21342_ = new NoClipMoveHelper((Mob)this);
    }
    
    @Nullable
    public SpawnGroupData m_6518_(final ServerLevelAccessor worldIn, final DifficultyInstance difficulty, final MobSpawnType reason, @Nullable final SpawnGroupData spawnDataIn, @Nullable final CompoundTag dataTag) {
        final SpawnGroupData data = super.m_6518_(worldIn, difficulty, reason, spawnDataIn, dataTag);
        this.m_6851_(difficulty);
        this.m_6850_(difficulty);
        return data;
    }
    
    protected void m_6851_(final DifficultyInstance difficulty) {
        this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.KNIGHTMETAL_SWORD.get()));
        this.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)TFItems.PHANTOM_CHESTPLATE.get()));
        this.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)TFItems.PHANTOM_HELMET.get()));
    }
    
    protected void m_8097_() {
        super.m_8097_();
        this.f_19804_.m_135372_((EntityDataAccessor)KnightPhantom.FLAG_CHARGING, (Object)false);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new PhantomWatchAndAttackGoal(this));
        this.f_21345_.m_25352_(1, (Goal)new PhantomUpdateFormationAndMoveGoal(this));
        this.f_21345_.m_25352_(2, (Goal)new PhantomAttackStartGoal(this));
        this.f_21345_.m_25352_(3, (Goal)new PhantomThrowWeaponGoal(this));
        this.f_21346_.m_25352_(0, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, false));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.m_21552_().m_22268_(Attributes.f_22276_, 35.0).m_22268_(Attributes.f_22281_, 1.0);
    }
    
    public Formation getCurrentFormation() {
        return this.currentFormation;
    }
    
    public BlockPos getChargePos() {
        return this.chargePos;
    }
    
    public void setChargePos(final BlockPos pos) {
        this.chargePos = pos;
    }
    
    public boolean m_6785_(final double p_213397_1_) {
        return false;
    }
    
    public boolean m_6673_(final DamageSource src) {
        return src == DamageSource.f_19310_ || super.m_6673_(src);
    }
    
    public void m_6043_() {
        if (this.f_19853_.m_46791_() == Difficulty.PEACEFUL) {
            if (this.hasHome() && this.getNumber() == 0) {
                this.f_19853_.m_46597_(this.m_21534_(), ((Block)TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER.get()).m_49966_());
            }
            this.m_146870_();
        }
        else {
            super.m_6043_();
        }
    }
    
    public void m_8107_() {
        super.m_8107_();
        if (this.isChargingAtPlayer()) {
            for (int i = 0; i < 4; ++i) {
                final Item particleID = (Item)(this.f_19796_.nextBoolean() ? TFItems.PHANTOM_HELMET.get() : ((Item)TFItems.KNIGHTMETAL_SWORD.get()));
                this.f_19853_.m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, new ItemStack((ItemLike)particleID)), this.m_20185_() + (this.f_19796_.nextFloat() - 0.5) * this.m_20205_(), this.m_20186_() + this.f_19796_.nextFloat() * (this.m_20206_() - 0.75) + 0.5, this.m_20189_() + (this.f_19796_.nextFloat() - 0.5) * this.m_20205_(), 0.0, -0.1, 0.0);
                this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123762_, this.m_20185_() + (this.f_19796_.nextFloat() - 0.5) * this.m_20205_(), this.m_20186_() + this.f_19796_.nextFloat() * (this.m_20206_() - 0.75) + 0.5, this.m_20189_() + (this.f_19796_.nextFloat() - 0.5) * this.m_20205_(), 0.0, 0.1, 0.0);
            }
        }
    }
    
    protected void m_6153_() {
        super.m_6153_();
        for (int i = 0; i < 20; ++i) {
            final double d0 = this.f_19796_.nextGaussian() * 0.02;
            final double d2 = this.f_19796_.nextGaussian() * 0.02;
            final double d3 = this.f_19796_.nextGaussian() * 0.02;
            this.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123813_, this.m_20185_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), this.m_20186_() + this.f_19796_.nextFloat() * this.m_20206_(), this.m_20189_() + this.f_19796_.nextFloat() * this.m_20205_() * 2.0f - this.m_20205_(), d0, d2, d3);
        }
    }
    
    public void m_6667_(final DamageSource cause) {
        super.m_6667_(cause);
        final Level f_19853_ = this.f_19853_;
        if (f_19853_ instanceof final ServerLevel serverLevel) {
            if (this.getNearbyKnights().isEmpty() && cause != DamageSource.f_19317_) {
                final BlockPos treasurePos = this.hasHome() ? this.m_21534_().m_7495_() : new BlockPos((Vec3i)this.m_142538_());
                TFTreasure.STRONGHOLD_BOSS.generateChest((WorldGenLevel)serverLevel, treasurePos, Direction.NORTH, false);
                TFGenerationSettings.markStructureConquered(this.f_19853_, treasurePos, TFFeature.KNIGHT_STRONGHOLD);
                for (final ServerPlayer player : this.hurtBy) {
                    TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
                }
                for (final ServerPlayer player : this.f_19853_.m_45976_((Class)ServerPlayer.class, new AABB(this.homePosition).m_82400_(10.0))) {
                    TFAdvancements.HURT_BOSS.trigger(player, (Entity)this);
                }
            }
        }
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        if (this.m_21275_(source)) {
            this.m_5496_(SoundEvents.f_12346_, 1.0f, 0.8f + this.f_19853_.f_46441_.nextFloat() * 0.4f);
        }
        final Entity 7639_ = source.m_7639_();
        if (7639_ instanceof final ServerPlayer player) {
            if (!this.hurtBy.contains(player)) {
                this.hurtBy.add(player);
            }
        }
        return super.m_6469_(source, amount);
    }
    
    public boolean m_7327_(final Entity entity) {
        float f = (float)this.m_21133_(Attributes.f_22281_);
        float f2 = (float)this.m_21133_(Attributes.f_22282_);
        if (entity instanceof final LivingEntity living) {
            f += EnchantmentHelper.m_44833_(this.m_21205_(), living.m_6336_());
            f2 += EnchantmentHelper.m_44894_((LivingEntity)this);
        }
        final int i = EnchantmentHelper.m_44914_((LivingEntity)this);
        if (i > 0) {
            entity.m_20254_(i * 4);
        }
        final boolean flag = entity.m_6469_(TFDamageSources.haunt((LivingEntity)this), f);
        if (flag) {
            if (f2 > 0.0f && entity instanceof LivingEntity) {
                final LivingEntity living2 = (LivingEntity)entity;
                living2.m_147240_((double)(f2 * 0.5f), (double)Mth.m_14031_(this.m_146908_() * 0.017453292f), (double)(-Mth.m_14089_(this.m_146908_() * 0.017453292f)));
                this.m_20256_(this.m_20184_().m_82542_(0.6, 1.0, 0.6));
            }
            if (entity instanceof final Player player) {
                this.maybeDisableShield(player, this.m_21205_(), player.m_6117_() ? player.m_21211_() : ItemStack.f_41583_);
            }
            this.m_19970_((LivingEntity)this, entity);
            this.m_21335_(entity);
        }
        return flag;
    }
    
    private void maybeDisableShield(final Player p_21425_, final ItemStack p_21426_, final ItemStack p_21427_) {
        if (!p_21426_.m_41619_() && !p_21427_.m_41619_() && p_21426_.m_41720_() instanceof AxeItem && p_21427_.m_150930_(Items.f_42740_)) {
            final float f = 0.25f + EnchantmentHelper.m_44926_((LivingEntity)this) * 0.05f;
            if (this.f_19796_.nextFloat() < f) {
                p_21425_.m_36335_().m_41524_(Items.f_42740_, 100);
                this.f_19853_.m_7605_((Entity)p_21425_, (byte)30);
            }
        }
    }
    
    public boolean m_6094_() {
        return true;
    }
    
    public void m_147240_(final double damage, final double xRatio, final double zRatio) {
        this.f_19812_ = true;
        final float f = Mth.m_14116_((float)(xRatio * xRatio + zRatio * zRatio));
        final float distance = 0.2f;
        this.m_20256_(new Vec3(this.m_20184_().m_7096_() / 2.0, this.m_20184_().m_7098_() / 2.0, this.m_20184_().m_7094_() / 2.0));
        this.m_20256_(new Vec3(this.m_20184_().m_7096_() - xRatio / f * distance, this.m_20184_().m_7098_() + distance, this.m_20184_().m_7094_() - zRatio / f * distance));
        if (this.m_20184_().m_7098_() > 0.4000000059604645) {
            this.m_20334_(this.m_20184_().m_7096_(), 0.4000000059604645, this.m_20184_().m_7094_());
        }
    }
    
    public List<KnightPhantom> getNearbyKnights() {
        return this.f_19853_.m_6443_((Class)KnightPhantom.class, new AABB(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_20185_() + 1.0, this.m_20186_() + 1.0, this.m_20189_() + 1.0).m_82377_(32.0, 8.0, 32.0), LivingEntity::m_6084_);
    }
    
    private void updateMyNumber() {
        final List<Integer> nums = Lists.newArrayList();
        final List<KnightPhantom> knights = this.getNearbyKnights();
        for (final KnightPhantom knight : knights) {
            if (knight == this) {
                continue;
            }
            nums.add(knight.getNumber());
            if (knight.getNumber() != 0) {
                continue;
            }
            this.m_21446_(knight.m_21534_(), 20);
        }
        if (nums.isEmpty()) {
            return;
        }
        final int[] n = Ints.toArray((Collection)nums);
        Arrays.sort(n);
        final int smallest = n[0];
        final int largest = knights.size() + 1;
        int smallestUnused = largest + 1;
        if (smallest > 0) {
            smallestUnused = 0;
        }
        else {
            for (int i = 1; i < largest; ++i) {
                if (Arrays.binarySearch(n, i) < 0) {
                    smallestUnused = i;
                    break;
                }
            }
        }
        if (this.number > smallestUnused || nums.contains(this.number)) {
            this.setNumber(smallestUnused);
        }
    }
    
    public boolean isChargingAtPlayer() {
        return (boolean)this.f_19804_.m_135370_((EntityDataAccessor)KnightPhantom.FLAG_CHARGING);
    }
    
    private void setChargingAtPlayer(final boolean flag) {
        this.f_19804_.m_135381_((EntityDataAccessor)KnightPhantom.FLAG_CHARGING, (Object)flag);
        if (!this.f_19853_.f_46443_) {
            if (flag) {
                if (!this.m_21051_(Attributes.f_22281_).m_22109_(KnightPhantom.CHARGING_MODIFIER)) {
                    this.m_21051_(Attributes.f_22281_).m_22118_(KnightPhantom.CHARGING_MODIFIER);
                }
            }
            else {
                this.m_21051_(Attributes.f_22281_).m_22130_(KnightPhantom.CHARGING_MODIFIER);
            }
        }
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.PHANTOM_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.PHANTOM_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.PHANTOM_DEATH;
    }
    
    private void switchToFormationByNumber(final int formationNumber) {
        this.currentFormation = Formation.values()[formationNumber];
        this.ticksProgress = 0;
    }
    
    public void switchToFormation(final Formation formation) {
        this.currentFormation = formation;
        this.ticksProgress = 0;
        this.updateMyNumber();
        this.setChargingAtPlayer(this.currentFormation == Formation.ATTACK_PLAYER_START || this.currentFormation == Formation.ATTACK_PLAYER_ATTACK);
    }
    
    private int getFormationAsNumber() {
        return this.currentFormation.ordinal();
    }
    
    public int getTicksProgress() {
        return this.ticksProgress;
    }
    
    public void setTicksProgress(final int ticksProgress) {
        this.ticksProgress = ticksProgress;
    }
    
    public int getMaxTicksForFormation() {
        return this.currentFormation.duration;
    }
    
    public boolean isSwordKnight() {
        return this.m_21205_().m_41720_() == TFItems.KNIGHTMETAL_SWORD.get();
    }
    
    public boolean isAxeKnight() {
        return this.m_21205_().m_41720_() == TFItems.KNIGHTMETAL_AXE.get();
    }
    
    public boolean isPickKnight() {
        return this.m_21205_().m_41720_() == TFItems.KNIGHTMETAL_PICKAXE.get();
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(final int number) {
        switch ((this.number = number) % 3) {
            case 0: {
                this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.KNIGHTMETAL_SWORD.get()));
                break;
            }
            case 1: {
                this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.KNIGHTMETAL_AXE.get()));
                break;
            }
            case 2: {
                this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.KNIGHTMETAL_PICKAXE.get()));
                break;
            }
        }
    }
    
    public void m_7380_(final CompoundTag compound) {
        super.m_7380_(compound);
        if (this.hasHome()) {
            final BlockPos home = this.m_21534_();
            compound.m_128365_("Home", (Tag)this.m_20063_(new double[] { home.m_123341_(), home.m_123342_(), home.m_123343_() }));
        }
        compound.m_128405_("MyNumber", this.getNumber());
        compound.m_128405_("Formation", this.getFormationAsNumber());
        compound.m_128405_("TicksProgress", this.getTicksProgress());
    }
    
    public void m_7378_(final CompoundTag compound) {
        super.m_7378_(compound);
        if (compound.m_128425_("Home", 9)) {
            final ListTag nbttaglist = compound.m_128437_("Home", 6);
            final int hx = (int)nbttaglist.m_128772_(0);
            final int hy = (int)nbttaglist.m_128772_(1);
            final int hz = (int)nbttaglist.m_128772_(2);
            this.m_21446_(new BlockPos(hx, hy, hz), 20);
        }
        else {
            this.m_21536_();
        }
        this.setNumber(compound.m_128451_("MyNumber"));
        this.switchToFormationByNumber(compound.m_128451_("Formation"));
        this.setTicksProgress(compound.m_128451_("TicksProgress"));
    }
    
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    public boolean m_6072_() {
        return false;
    }
    
    public boolean m_21533_() {
        return this.m_21444_(new BlockPos((Vec3i)this.m_142538_()));
    }
    
    public boolean m_21444_(final BlockPos pos) {
        return this.maximumHomeDistance == -1.0f || this.homePosition.m_123331_((Vec3i)pos) < this.maximumHomeDistance * this.maximumHomeDistance;
    }
    
    public void m_21446_(final BlockPos pos, final int distance) {
        this.chargePos = pos;
        this.homePosition = pos;
        this.maximumHomeDistance = (float)distance;
    }
    
    public BlockPos m_21534_() {
        return this.homePosition;
    }
    
    public float m_21535_() {
        return this.maximumHomeDistance;
    }
    
    public boolean m_21536_() {
        this.maximumHomeDistance = -1.0f;
        return false;
    }
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
    
    static {
        FLAG_CHARGING = SynchedEntityData.m_135353_((Class)KnightPhantom.class, EntityDataSerializers.f_135035_);
        CHARGING_MODIFIER = new AttributeModifier("Charging attack boost", 7.0, AttributeModifier.Operation.ADDITION);
    }
    
    public enum Formation
    {
        HOVER(90), 
        LARGE_CLOCKWISE(180), 
        SMALL_CLOCKWISE(90), 
        LARGE_ANTICLOCKWISE(180), 
        SMALL_ANTICLOCKWISE(90), 
        CHARGE_PLUSX(180), 
        CHARGE_MINUSX(180), 
        CHARGE_PLUSZ(180), 
        CHARGE_MINUSZ(180), 
        WAITING_FOR_LEADER(10), 
        ATTACK_PLAYER_START(50), 
        ATTACK_PLAYER_ATTACK(50);
        
        final int duration;
        
        private Formation(final int duration) {
            this.duration = duration;
        }
    }
}
