// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.init.SoundEvents;
import twilightforest.entity.boss.EntityTFIceBomb;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.block.TFBlocks;
import java.util.Iterator;
import twilightforest.util.WorldUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFTroll extends EntityMob implements IRangedAttackMob
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Boolean> ROCK_FLAG;
    private static final AttributeModifier ROCK_MODIFIER;
    private EntityAIAttackRanged aiArrowAttack;
    private EntityAIAttackMelee aiAttackOnCollide;
    
    public EntityTFTroll(final World world) {
        super(world);
        this.func_70105_a(1.4f, 2.4f);
    }
    
    public void func_184651_r() {
        this.aiArrowAttack = new EntityAIAttackRanged((IRangedAttackMob)this, 1.0, 20, 60, 15.0f);
        this.aiAttackOnCollide = new EntityAIAttackMelee((EntityCreature)this, 1.2, false);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIRestrictSun((EntityCreature)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIFleeSun((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
        if (this.field_70170_p != null && !this.field_70170_p.field_72995_K) {
            this.setCombatTask();
        }
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFTroll.ROCK_FLAG, (Object)false);
    }
    
    public boolean hasRock() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFTroll.ROCK_FLAG);
    }
    
    public void setHasRock(final boolean rock) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFTroll.ROCK_FLAG, (Object)rock);
        if (!this.field_70170_p.field_72995_K) {
            if (rock) {
                if (!this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_180374_a(EntityTFTroll.ROCK_MODIFIER)) {
                    this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(EntityTFTroll.ROCK_MODIFIER);
                }
            }
            else {
                this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111124_b(EntityTFTroll.ROCK_MODIFIER);
            }
            this.setCombatTask();
        }
    }
    
    public boolean func_70652_k(final Entity entity) {
        this.func_184609_a(EnumHand.MAIN_HAND);
        return super.func_70652_k(entity);
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74757_a("HasRock", this.hasRock());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setHasRock(compound.func_74767_n("HasRock"));
    }
    
    private void setCombatTask() {
        this.field_70714_bg.func_85156_a((EntityAIBase)this.aiAttackOnCollide);
        this.field_70714_bg.func_85156_a((EntityAIBase)this.aiArrowAttack);
        if (this.hasRock()) {
            this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.aiArrowAttack);
        }
        else {
            this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.aiAttackOnCollide);
        }
    }
    
    protected void func_70609_aI() {
        super.func_70609_aI();
        if (this.field_70725_aQ % 5 == 0) {
            this.ripenTrollBerNearby(this.field_70725_aQ / 5);
        }
        if (this.field_70725_aQ == 1) {}
    }
    
    private void ripenTrollBerNearby(final int offset) {
        final int range = 12;
        for (final BlockPos pos : WorldUtil.getAllAround(new BlockPos((Entity)this), range)) {
            this.ripenBer(offset, pos);
        }
    }
    
    private void ripenBer(final int offset, final BlockPos pos) {
        if (this.field_70170_p.func_180495_p(pos).func_177230_c() == TFBlocks.unripe_trollber && this.field_70146_Z.nextBoolean() && Math.abs(pos.func_177958_n() + pos.func_177956_o() + pos.func_177952_p()) % 5 == offset) {
            this.field_70170_p.func_175656_a(pos, TFBlocks.trollber.func_176223_P());
            this.field_70170_p.func_175718_b(2004, pos, 0);
        }
    }
    
    private void makeTrollStoneInAABB(final AxisAlignedBB aabb) {
        final int minX = MathHelper.func_76143_f(aabb.field_72340_a);
        final int minY = MathHelper.func_76143_f(aabb.field_72338_b);
        final int minZ = MathHelper.func_76143_f(aabb.field_72339_c);
        final int maxX = MathHelper.func_76128_c(aabb.field_72336_d);
        final int maxY = MathHelper.func_76128_c(aabb.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(aabb.field_72334_f);
        for (final BlockPos pos : BlockPos.func_177980_a(new BlockPos(minX, minY, minZ), new BlockPos(maxX, maxY, maxZ))) {
            if (this.field_70170_p.func_175623_d(pos)) {
                this.field_70170_p.func_175656_a(pos, TFBlocks.trollsteinn.func_176223_P());
                this.field_70170_p.func_175718_b(2001, pos, Block.func_176210_f(TFBlocks.trollsteinn.func_176223_P()));
            }
        }
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFTroll.LOOT_TABLE;
    }
    
    public void func_82196_d(final EntityLivingBase target, final float distanceFactor) {
        if (this.hasRock()) {
            final EntityTFIceBomb ice = new EntityTFIceBomb(this.field_70170_p, (EntityLivingBase)this);
            final double d0 = target.field_70165_t - this.field_70165_t;
            final double d2 = target.func_174813_aQ().field_72338_b + target.field_70131_O / 3.0f - ice.field_70163_u;
            final double d3 = target.field_70161_v - this.field_70161_v;
            final double d4 = MathHelper.func_76133_a(d0 * d0 + d3 * d3);
            ice.func_70186_c(d0, d2 + d4 * 0.20000000298023224, d3, 1.6f, (float)(14 - this.field_70170_p.func_175659_aa().func_151525_a() * 4));
            this.func_184185_a(SoundEvents.field_187737_v, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_72838_d((Entity)ice);
        }
    }
    
    public void func_184724_a(final boolean swingingArms) {
    }
    
    protected void func_82168_bl() {
        final int i = 6;
        if (this.field_82175_bq) {
            ++this.field_110158_av;
            if (this.field_110158_av >= i) {
                this.field_110158_av = 0;
                this.field_82175_bq = false;
            }
        }
        else {
            this.field_110158_av = 0;
        }
        this.field_70733_aJ = this.field_110158_av / (float)i;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/troll");
        ROCK_FLAG = EntityDataManager.func_187226_a((Class)EntityTFTroll.class, DataSerializers.field_187198_h);
        ROCK_MODIFIER = new AttributeModifier("Rock follow boost", 24.0, 0).func_111168_a(false);
    }
}
