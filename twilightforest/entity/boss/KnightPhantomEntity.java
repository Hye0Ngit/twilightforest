// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.INBT;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;
import com.google.common.primitives.Ints;
import com.google.common.collect.Lists;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.List;
import net.minecraft.item.Items;
import net.minecraft.item.AxeItem;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundEvents;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFFeature;
import net.minecraft.world.IWorld;
import net.minecraft.util.Direction;
import twilightforest.loot.TFTreasure;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.Item;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.Difficulty;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import twilightforest.entity.ai.PhantomThrowWeaponGoal;
import twilightforest.entity.ai.PhantomAttackStartGoal;
import twilightforest.entity.ai.PhantomUpdateFormationAndMoveGoal;
import net.minecraft.entity.ai.goal.Goal;
import twilightforest.entity.ai.PhantomWatchAndAttackGoal;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.MobEntity;
import twilightforest.entity.NoClipMoveHelper;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.FlyingEntity;

public class KnightPhantomEntity extends FlyingEntity implements IMob
{
    private static final DataParameter<Boolean> FLAG_CHARGING;
    private static final AttributeModifier CHARGING_MODIFIER;
    private int number;
    private int ticksProgress;
    private Formation currentFormation;
    private BlockPos chargePos;
    private BlockPos homePosition;
    private float maximumHomeDistance;
    
    public KnightPhantomEntity(final EntityType<? extends KnightPhantomEntity> type, final World world) {
        super((EntityType)type, world);
        this.chargePos = BlockPos.field_177992_a;
        this.homePosition = BlockPos.field_177992_a;
        this.maximumHomeDistance = -1.0f;
        this.field_70145_X = true;
        this.func_230279_az_();
        this.currentFormation = Formation.HOVER;
        this.field_70728_aV = 93;
        this.field_70765_h = new NoClipMoveHelper((MobEntity)this);
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficulty, final SpawnReason reason, @Nullable final ILivingEntityData spawnDataIn, @Nullable final CompoundNBT dataTag) {
        final ILivingEntityData data = super.func_213386_a(worldIn, difficulty, reason, spawnDataIn, dataTag);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);
        return data;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.knightmetal_sword.get()));
        this.func_184201_a(EquipmentSlotType.CHEST, new ItemStack((IItemProvider)TFItems.phantom_chestplate.get()));
        this.func_184201_a(EquipmentSlotType.HEAD, new ItemStack((IItemProvider)TFItems.phantom_helmet.get()));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)KnightPhantomEntity.FLAG_CHARGING, (Object)false);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new PhantomWatchAndAttackGoal(this));
        this.field_70714_bg.func_75776_a(1, (Goal)new PhantomUpdateFormationAndMoveGoal(this));
        this.field_70714_bg.func_75776_a(2, (Goal)new PhantomAttackStartGoal(this));
        this.field_70714_bg.func_75776_a(3, (Goal)new PhantomThrowWeaponGoal(this));
        this.field_70715_bh.func_75776_a(0, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, false));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 35.0).func_233815_a_(Attributes.field_233823_f_, 1.0);
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
    
    public boolean func_213397_c(final double p_213397_1_) {
        return false;
    }
    
    public boolean func_180431_b(final DamageSource src) {
        return src == DamageSource.field_76368_d || super.func_180431_b(src);
    }
    
    public void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            if (this.hasHome() && this.getNumber() == 0) {
                this.field_70170_p.func_175656_a(this.func_213384_dI(), ((Block)TFBlocks.boss_spawner_knight_phantom.get()).func_176223_P());
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isChargingAtPlayer()) {
            for (int i = 0; i < 4; ++i) {
                final Item particleID = (Item)(this.field_70146_Z.nextBoolean() ? TFItems.phantom_helmet.get() : ((Item)TFItems.knightmetal_sword.get()));
                this.field_70170_p.func_195594_a((IParticleData)new ItemParticleData(ParticleTypes.field_197591_B, new ItemStack((IItemProvider)particleID)), this.func_226277_ct_() + (this.field_70146_Z.nextFloat() - 0.5) * this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextFloat() * (this.func_213302_cg() - 0.75) + 0.5, this.func_226281_cx_() + (this.field_70146_Z.nextFloat() - 0.5) * this.func_213311_cf(), 0.0, -0.1, 0.0);
                this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197601_L, this.func_226277_ct_() + (this.field_70146_Z.nextFloat() - 0.5) * this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextFloat() * (this.func_213302_cg() - 0.75) + 0.5, this.func_226281_cx_() + (this.field_70146_Z.nextFloat() - 0.5) * this.func_213311_cf(), 0.0, 0.1, 0.0);
            }
        }
    }
    
    protected void func_70609_aI() {
        super.func_70609_aI();
        for (int i = 0; i < 20; ++i) {
            final double d0 = this.field_70146_Z.nextGaussian() * 0.02;
            final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
            final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197627_t, this.func_226277_ct_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextFloat() * this.func_213302_cg(), this.func_226281_cx_() + this.field_70146_Z.nextFloat() * this.func_213311_cf() * 2.0f - this.func_213311_cf(), d0, d2, d3);
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K && this.getNearbyKnights().isEmpty() && cause != DamageSource.field_76380_i) {
            final BlockPos treasurePos = this.hasHome() ? this.func_213384_dI().func_177977_b() : new BlockPos((Vector3i)this.func_233580_cy_());
            TFTreasure.stronghold_boss.generateChest((IWorld)this.field_70170_p, treasurePos, Direction.NORTH, false);
            TFGenerationSettings.markStructureConquered(this.field_70170_p, treasurePos, TFFeature.KNIGHT_STRONGHOLD);
        }
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        if (this.func_184583_d(source)) {
            this.func_184185_a(SoundEvents.field_187767_eL, 1.0f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        }
        return super.func_70097_a(source, amount);
    }
    
    public boolean func_70652_k(final Entity entityIn) {
        float f = (float)this.func_110148_a(Attributes.field_233823_f_).func_111126_e();
        int i = 0;
        if (entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.func_152377_a(this.func_184614_ca(), ((LivingEntity)entityIn).func_70668_bt());
            i += EnchantmentHelper.func_77501_a((LivingEntity)this);
        }
        final boolean flag = entityIn.func_70097_a(DamageSource.func_76358_a((LivingEntity)this), f);
        if (flag) {
            if (i > 0 && entityIn instanceof LivingEntity) {
                ((LivingEntity)entityIn).func_233627_a_(i * 0.5f, (double)MathHelper.func_76126_a(this.field_70177_z * 0.017453292f), (double)(-MathHelper.func_76134_b(this.field_70177_z * 0.017453292f)));
                this.func_213317_d(new Vector3d(this.func_213322_ci().func_82615_a() * 0.6, this.func_213322_ci().func_82617_b(), this.func_213322_ci().func_82616_c() * 0.6));
            }
            final int j = EnchantmentHelper.func_90036_a((LivingEntity)this);
            if (j > 0) {
                entityIn.func_70015_d(j * 4);
            }
            if (entityIn instanceof PlayerEntity) {
                final PlayerEntity entityplayer = (PlayerEntity)entityIn;
                final ItemStack itemstack = this.func_184614_ca();
                final ItemStack itemstack2 = entityplayer.func_184587_cr() ? entityplayer.func_184607_cu() : ItemStack.field_190927_a;
                if (!itemstack.func_190926_b() && !itemstack2.func_190926_b() && itemstack.func_77973_b() instanceof AxeItem && itemstack2.func_77973_b() == Items.field_185159_cQ) {
                    final float f2 = 0.25f + EnchantmentHelper.func_185293_e((LivingEntity)this) * 0.05f;
                    if (this.field_70146_Z.nextFloat() < f2) {
                        entityplayer.func_184811_cZ().func_185145_a(Items.field_185159_cQ, 100);
                        this.field_70170_p.func_72960_a((Entity)entityplayer, (byte)30);
                    }
                }
            }
            this.func_174815_a((LivingEntity)this, entityIn);
        }
        return flag;
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    public void func_233627_a_(final float damage, final double xRatio, final double zRatio) {
        this.field_70160_al = true;
        final float f = MathHelper.func_76133_a(xRatio * xRatio + zRatio * zRatio);
        final float distance = 0.2f;
        this.func_213317_d(new Vector3d(this.func_213322_ci().func_82615_a() / 2.0, this.func_213322_ci().func_82617_b() / 2.0, this.func_213322_ci().func_82616_c() / 2.0));
        this.func_213317_d(new Vector3d(this.func_213322_ci().func_82615_a() - xRatio / f * distance, this.func_213322_ci().func_82617_b() + distance, this.func_213322_ci().func_82616_c() - zRatio / f * distance));
        if (this.func_213322_ci().func_82617_b() > 0.4000000059604645) {
            this.func_213293_j(this.func_213322_ci().func_82615_a(), 0.4000000059604645, this.func_213322_ci().func_82616_c());
        }
    }
    
    public List<KnightPhantomEntity> getNearbyKnights() {
        return this.field_70170_p.func_175647_a((Class)KnightPhantomEntity.class, new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.func_226277_ct_() + 1.0, this.func_226278_cu_() + 1.0, this.func_226281_cx_() + 1.0).func_72314_b(32.0, 8.0, 32.0), LivingEntity::func_70089_S);
    }
    
    private void updateMyNumber() {
        final List<Integer> nums = Lists.newArrayList();
        final List<KnightPhantomEntity> knights = this.getNearbyKnights();
        for (final KnightPhantomEntity knight : knights) {
            if (knight == this) {
                continue;
            }
            nums.add(knight.getNumber());
            if (knight.getNumber() != 0) {
                continue;
            }
            this.func_213390_a(knight.func_213384_dI(), 20);
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
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)KnightPhantomEntity.FLAG_CHARGING);
    }
    
    private void setChargingAtPlayer(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)KnightPhantomEntity.FLAG_CHARGING, (Object)flag);
        if (!this.field_70170_p.field_72995_K) {
            if (flag) {
                if (!this.func_110148_a(Attributes.field_233823_f_).func_180374_a(KnightPhantomEntity.CHARGING_MODIFIER)) {
                    this.func_110148_a(Attributes.field_233823_f_).func_233767_b_(KnightPhantomEntity.CHARGING_MODIFIER);
                }
            }
            else {
                this.func_110148_a(Attributes.field_233823_f_).func_111124_b(KnightPhantomEntity.CHARGING_MODIFIER);
            }
        }
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.PHANTOM_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.PHANTOM_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
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
        return this.func_184614_ca().func_77973_b() == TFItems.knightmetal_sword.get();
    }
    
    public boolean isAxeKnight() {
        return this.func_184614_ca().func_77973_b() == TFItems.knightmetal_axe.get();
    }
    
    public boolean isPickKnight() {
        return this.func_184614_ca().func_77973_b() == TFItems.knightmetal_pickaxe.get();
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(final int number) {
        switch ((this.number = number) % 3) {
            case 0: {
                this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.knightmetal_sword.get()));
                break;
            }
            case 1: {
                this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.knightmetal_axe.get()));
                break;
            }
            case 2: {
                this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.knightmetal_pickaxe.get()));
                break;
            }
        }
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        if (this.hasHome()) {
            final BlockPos home = this.func_213384_dI();
            compound.func_218657_a("Home", (INBT)this.func_70087_a(new double[] { home.func_177958_n(), home.func_177956_o(), home.func_177952_p() }));
        }
        compound.func_74768_a("MyNumber", this.getNumber());
        compound.func_74768_a("Formation", this.getFormationAsNumber());
        compound.func_74768_a("TicksProgress", this.getTicksProgress());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        if (compound.func_150297_b("Home", 9)) {
            final ListNBT nbttaglist = compound.func_150295_c("Home", 6);
            final int hx = (int)nbttaglist.func_150309_d(0);
            final int hy = (int)nbttaglist.func_150309_d(1);
            final int hz = (int)nbttaglist.func_150309_d(2);
            this.func_213390_a(new BlockPos(hx, hy, hz), 20);
        }
        else {
            this.func_213394_dL();
        }
        this.setNumber(compound.func_74762_e("MyNumber"));
        this.switchToFormationByNumber(compound.func_74762_e("Formation"));
        this.setTicksProgress(compound.func_74762_e("TicksProgress"));
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    public boolean func_213383_dH() {
        return this.func_213389_a(new BlockPos((Vector3i)this.func_233580_cy_()));
    }
    
    public boolean func_213389_a(final BlockPos pos) {
        return this.maximumHomeDistance == -1.0f || this.homePosition.func_177951_i((Vector3i)pos) < this.maximumHomeDistance * this.maximumHomeDistance;
    }
    
    public void func_213390_a(final BlockPos pos, final int distance) {
        this.chargePos = pos;
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
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
    
    static {
        FLAG_CHARGING = EntityDataManager.func_187226_a((Class)KnightPhantomEntity.class, DataSerializers.field_187198_h);
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
