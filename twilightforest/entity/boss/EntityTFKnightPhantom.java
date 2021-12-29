// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.util.math.Vec3i;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;
import com.google.common.primitives.Ints;
import com.google.common.collect.Lists;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.List;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import twilightforest.world.TFWorld;
import twilightforest.TFFeature;
import twilightforest.loot.TFTreasure;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import twilightforest.entity.ai.EntityAITFFindEntityNearestPlayer;
import twilightforest.entity.ai.EntityAIPhantomThrowWeapon;
import twilightforest.entity.ai.EntityAIPhantomAttackStart;
import twilightforest.entity.ai.EntityAITFPhantomUpdateFormationAndMove;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAITFPhantomWatchAndAttack;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import javax.annotation.Nullable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.entity.EntityLiving;
import twilightforest.entity.NoClipMoveHelper;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.EntityFlying;

public class EntityTFKnightPhantom extends EntityFlying implements IMob
{
    private static final DataParameter<Boolean> FLAG_CHARGING;
    private static final AttributeModifier CHARGING_MODIFIER;
    private int number;
    private int ticksProgress;
    private Formation currentFormation;
    private BlockPos chargePos;
    private BlockPos homePosition;
    private float maximumHomeDistance;
    
    public EntityTFKnightPhantom(final World world) {
        super(world);
        this.chargePos = BlockPos.field_177992_a;
        this.homePosition = BlockPos.field_177992_a;
        this.maximumHomeDistance = -1.0f;
        this.func_70105_a(1.5f, 3.0f);
        this.field_70145_X = true;
        this.field_70178_ae = true;
        this.currentFormation = Formation.HOVER;
        this.field_70728_aV = 93;
        this.field_70765_h = new NoClipMoveHelper((EntityLiving)this);
    }
    
    public IEntityLivingData func_180482_a(final DifficultyInstance difficulty, @Nullable final IEntityLivingData livingdata) {
        final IEntityLivingData data = super.func_180482_a(difficulty, livingdata);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);
        return data;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(TFItems.knightmetal_sword));
        this.func_184201_a(EntityEquipmentSlot.CHEST, new ItemStack(TFItems.phantom_chestplate));
        this.func_184201_a(EntityEquipmentSlot.HEAD, new ItemStack(TFItems.phantom_helmet));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFKnightPhantom.FLAG_CHARGING, (Object)false);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAITFPhantomWatchAndAttack(this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFPhantomUpdateFormationAndMove(this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIPhantomAttackStart(this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIPhantomThrowWeapon(this));
        this.field_70715_bh.func_75776_a(0, (EntityAIBase)new EntityAITFFindEntityNearestPlayer((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(35.0);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
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
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public boolean func_180431_b(final DamageSource src) {
        return src == DamageSource.field_76368_d || super.func_180431_b(src);
    }
    
    protected void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
            if (this.hasHome() && this.getNumber() == 0) {
                this.field_70170_p.func_175656_a(this.getHomePosition(), TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.KNIGHT_PHANTOM));
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
                final Item particleID = this.field_70146_Z.nextBoolean() ? TFItems.phantom_helmet : TFItems.knightmetal_sword;
                this.field_70170_p.func_175688_a(EnumParticleTypes.ITEM_CRACK, this.field_70165_t + (this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * (this.field_70131_O - 0.75) + 0.5, this.field_70161_v + (this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, 0.0, -0.1, 0.0, new int[] { Item.func_150891_b(particleID) });
                this.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, this.field_70165_t + (this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * (this.field_70131_O - 0.75) + 0.5, this.field_70161_v + (this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, 0.0, 0.1, 0.0, new int[0]);
            }
        }
    }
    
    protected void func_70609_aI() {
        super.func_70609_aI();
        for (int i = 0; i < 20; ++i) {
            final double d0 = this.field_70146_Z.nextGaussian() * 0.02;
            final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
            final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
            this.field_70170_p.func_175688_a(EnumParticleTypes.EXPLOSION_NORMAL, this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d0, d2, d3, new int[0]);
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K && this.getNearbyKnights().isEmpty()) {
            final BlockPos treasurePos = this.hasHome() ? this.getHomePosition().func_177977_b() : new BlockPos((Entity)this);
            TFTreasure.stronghold_boss.generateChest(this.field_70170_p, treasurePos, false);
            TFWorld.markStructureConquered(this.field_70170_p, treasurePos, TFFeature.KNIGHT_STRONGHOLD);
        }
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        if (this.func_184583_d(source)) {
            this.func_184185_a(SoundEvents.field_187767_eL, 1.0f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        }
        return super.func_70097_a(source, amount);
    }
    
    public boolean func_70652_k(final Entity entityIn) {
        float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
        int i = 0;
        if (entityIn instanceof EntityLivingBase) {
            f += EnchantmentHelper.func_152377_a(this.func_184614_ca(), ((EntityLivingBase)entityIn).func_70668_bt());
            i += EnchantmentHelper.func_77501_a((EntityLivingBase)this);
        }
        final boolean flag = entityIn.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), f);
        if (flag) {
            if (i > 0 && entityIn instanceof EntityLivingBase) {
                ((EntityLivingBase)entityIn).func_70653_a((Entity)this, i * 0.5f, (double)MathHelper.func_76126_a(this.field_70177_z * 0.017453292f), (double)(-MathHelper.func_76134_b(this.field_70177_z * 0.017453292f)));
                this.field_70159_w *= 0.6;
                this.field_70179_y *= 0.6;
            }
            final int j = EnchantmentHelper.func_90036_a((EntityLivingBase)this);
            if (j > 0) {
                entityIn.func_70015_d(j * 4);
            }
            if (entityIn instanceof EntityPlayer) {
                final EntityPlayer entityplayer = (EntityPlayer)entityIn;
                final ItemStack itemstack = this.func_184614_ca();
                final ItemStack itemstack2 = entityplayer.func_184587_cr() ? entityplayer.func_184607_cu() : ItemStack.field_190927_a;
                if (!itemstack.func_190926_b() && !itemstack2.func_190926_b() && itemstack.func_77973_b() instanceof ItemAxe && itemstack2.func_77973_b() == Items.field_185159_cQ) {
                    final float f2 = 0.25f + EnchantmentHelper.func_185293_e((EntityLivingBase)this) * 0.05f;
                    if (this.field_70146_Z.nextFloat() < f2) {
                        entityplayer.func_184811_cZ().func_185145_a(Items.field_185159_cQ, 100);
                        this.field_70170_p.func_72960_a((Entity)entityplayer, (byte)30);
                    }
                }
            }
            this.func_174815_a((EntityLivingBase)this, entityIn);
        }
        return flag;
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    public void func_70653_a(final Entity entity, final float damage, final double xRatio, final double zRatio) {
        this.field_70160_al = true;
        final float f = MathHelper.func_76133_a(xRatio * xRatio + zRatio * zRatio);
        final float distance = 0.2f;
        this.field_70159_w /= 2.0;
        this.field_70181_x /= 2.0;
        this.field_70179_y /= 2.0;
        this.field_70159_w -= xRatio / f * distance;
        this.field_70181_x += distance;
        this.field_70179_y -= zRatio / f * distance;
        if (this.field_70181_x > 0.4000000059604645) {
            this.field_70181_x = 0.4000000059604645;
        }
    }
    
    public List<EntityTFKnightPhantom> getNearbyKnights() {
        return this.field_70170_p.func_175647_a((Class)EntityTFKnightPhantom.class, new AxisAlignedBB(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 8.0, 32.0), EntitySelectors.field_94557_a);
    }
    
    private void updateMyNumber() {
        final List<Integer> nums = Lists.newArrayList();
        final List<EntityTFKnightPhantom> knights = this.getNearbyKnights();
        for (final EntityTFKnightPhantom knight : knights) {
            if (knight == this) {
                continue;
            }
            nums.add(knight.getNumber());
            if (knight.getNumber() != 0) {
                continue;
            }
            this.setHomePosAndDistance(knight.getHomePosition(), 20);
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
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFKnightPhantom.FLAG_CHARGING);
    }
    
    private void setChargingAtPlayer(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFKnightPhantom.FLAG_CHARGING, (Object)flag);
        if (!this.field_70170_p.field_72995_K) {
            if (flag) {
                if (!this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_180374_a(EntityTFKnightPhantom.CHARGING_MODIFIER)) {
                    this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111121_a(EntityTFKnightPhantom.CHARGING_MODIFIER);
                }
            }
            else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111124_b(EntityTFKnightPhantom.CHARGING_MODIFIER);
            }
        }
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.WRAITH;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.WRAITH;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.WRAITH;
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
        return this.func_184614_ca().func_77973_b() == TFItems.knightmetal_sword;
    }
    
    public boolean isAxeKnight() {
        return this.func_184614_ca().func_77973_b() == TFItems.knightmetal_axe;
    }
    
    public boolean isPickKnight() {
        return this.func_184614_ca().func_77973_b() == TFItems.knightmetal_pickaxe;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(final int number) {
        switch ((this.number = number) % 3) {
            case 0: {
                this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(TFItems.knightmetal_sword));
                break;
            }
            case 1: {
                this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(TFItems.knightmetal_axe));
                break;
            }
            case 2: {
                this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(TFItems.knightmetal_pickaxe));
                break;
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        if (this.hasHome()) {
            final BlockPos home = this.getHomePosition();
            compound.func_74782_a("Home", (NBTBase)this.func_70087_a(new double[] { home.func_177958_n(), home.func_177956_o(), home.func_177952_p() }));
        }
        compound.func_74768_a("MyNumber", this.getNumber());
        compound.func_74768_a("Formation", this.getFormationAsNumber());
        compound.func_74768_a("TicksProgress", this.getTicksProgress());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        if (compound.func_150297_b("Home", 9)) {
            final NBTTagList nbttaglist = compound.func_150295_c("Home", 6);
            final int hx = (int)nbttaglist.func_150309_d(0);
            final int hy = (int)nbttaglist.func_150309_d(1);
            final int hz = (int)nbttaglist.func_150309_d(2);
            this.setHomePosAndDistance(new BlockPos(hx, hy, hz), 20);
        }
        else {
            this.detachHome();
        }
        this.setNumber(compound.func_74762_e("MyNumber"));
        this.switchToFormationByNumber(compound.func_74762_e("Formation"));
        this.setTicksProgress(compound.func_74762_e("TicksProgress"));
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    public boolean isWithinHomeDistanceCurrentPosition() {
        return this.isWithinHomeDistanceFromPosition(new BlockPos((Entity)this));
    }
    
    public boolean isWithinHomeDistanceFromPosition(final BlockPos pos) {
        return this.maximumHomeDistance == -1.0f || this.homePosition.func_177951_i((Vec3i)pos) < this.maximumHomeDistance * this.maximumHomeDistance;
    }
    
    public void setHomePosAndDistance(final BlockPos pos, final int distance) {
        this.chargePos = pos;
        this.homePosition = pos;
        this.maximumHomeDistance = (float)distance;
    }
    
    public BlockPos getHomePosition() {
        return this.homePosition;
    }
    
    public float getMaximumHomeDistance() {
        return this.maximumHomeDistance;
    }
    
    public void detachHome() {
        this.maximumHomeDistance = -1.0f;
    }
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
    
    static {
        FLAG_CHARGING = EntityDataManager.func_187226_a((Class)EntityTFKnightPhantom.class, DataSerializers.field_187198_h);
        CHARGING_MODIFIER = new AttributeModifier("Charging attack boost", 7.0, 0).func_111168_a(false);
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
