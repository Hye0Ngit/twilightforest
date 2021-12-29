// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.Vec3d;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAITFHeavySpearAttack;
import net.minecraft.world.World;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFGoblinKnightUpper extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    private static final int SHIELD_DAMAGE_THRESHOLD = 10;
    private static final DataParameter<Byte> DATA_EQUIP;
    private static final AttributeModifier ARMOR_MODIFIER;
    private static final AttributeModifier DAMAGE_MODIFIER;
    public static final int HEAVY_SPEAR_TIMER_START = 60;
    private int shieldHits;
    public int heavySpearTimer;
    
    public EntityTFGoblinKnightUpper(final World world) {
        super(world);
        this.shieldHits = 0;
        this.func_70105_a(1.1f, 1.3f);
        this.setHasArmor(true);
        this.setHasShield(true);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAITFHeavySpearAttack(this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFGoblinKnightUpper.DATA_EQUIP, (Object)0);
    }
    
    public boolean hasArmor() {
        return ((byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFGoblinKnightUpper.DATA_EQUIP) & 0x1) > 0;
    }
    
    private void setHasArmor(final boolean flag) {
        final byte otherFlags = (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFGoblinKnightUpper.DATA_EQUIP);
        this.field_70180_af.func_187227_b((DataParameter)EntityTFGoblinKnightUpper.DATA_EQUIP, (Object)(flag ? ((byte)(otherFlags | 0x1)) : ((byte)(otherFlags & 0xFFFFFFFE))));
        if (!this.field_70170_p.field_72995_K) {
            if (flag) {
                if (!this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_180374_a(EntityTFGoblinKnightUpper.ARMOR_MODIFIER)) {
                    this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111121_a(EntityTFGoblinKnightUpper.ARMOR_MODIFIER);
                }
            }
            else {
                this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111124_b(EntityTFGoblinKnightUpper.ARMOR_MODIFIER);
            }
        }
    }
    
    public boolean hasShield() {
        return ((byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFGoblinKnightUpper.DATA_EQUIP) & 0x2) > 0;
    }
    
    public void setHasShield(final boolean flag) {
        final byte otherFlags = (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFGoblinKnightUpper.DATA_EQUIP);
        this.field_70180_af.func_187227_b((DataParameter)EntityTFGoblinKnightUpper.DATA_EQUIP, (Object)(flag ? ((byte)(otherFlags | 0x2)) : ((byte)(otherFlags & 0xFFFFFFFD))));
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74757_a("hasArmor", this.hasArmor());
        compound.func_74757_a("hasShield", this.hasShield());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setHasArmor(compound.func_74767_n("hasArmor"));
        this.setHasShield(compound.func_74767_n("hasShield"));
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if ((this.field_70170_p.field_72995_K || !this.func_175446_cd()) && this.heavySpearTimer > 0) {
            --this.heavySpearTimer;
        }
    }
    
    public void func_70619_bc() {
        super.func_70619_bc();
        if (this.func_70089_S()) {
            if (this.func_184187_bx() instanceof EntityLiving && this.func_70638_az() == null) {
                this.func_70624_b(((EntityLiving)this.func_184187_bx()).func_70638_az());
            }
            if (!this.func_184218_aH() && this.hasShield()) {
                this.breakShield();
            }
            if (this.heavySpearTimer > 0) {
                if (!this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_180374_a(EntityTFGoblinKnightUpper.DAMAGE_MODIFIER)) {
                    this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111121_a(EntityTFGoblinKnightUpper.DAMAGE_MODIFIER);
                }
            }
            else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_188479_b(EntityTFGoblinKnightUpper.DAMAGE_MODIFIER.func_111167_a());
            }
        }
    }
    
    public void landHeavySpearAttack() {
        final Vec3d vector = this.func_70040_Z();
        final double dist = 1.25;
        final double px = this.field_70165_t + vector.field_72450_a * dist;
        final double py = this.func_174813_aQ().field_72338_b - 0.75;
        final double pz = this.field_70161_v + vector.field_72449_c * dist;
        for (int i = 0; i < 50; ++i) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_LARGE, px, py, pz, (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.25f), 0.0, (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.25f), new int[0]);
        }
        final double radius = 1.5;
        final AxisAlignedBB spearBB = new AxisAlignedBB(px - radius, py - radius, pz - radius, px + radius, py + radius, pz + radius);
        final List<Entity> inBox = this.field_70170_p.func_175674_a((Entity)this, spearBB, e -> e != this.func_184187_bx());
        for (final Entity entity : inBox) {
            super.func_70652_k(entity);
        }
        if (!inBox.isEmpty()) {
            this.func_184185_a(SoundEvents.field_187718_dS, this.func_70599_aP(), this.func_70647_i());
        }
    }
    
    public void func_70098_U() {
        super.func_70098_U();
        if (this.func_184187_bx() instanceof EntityLiving) {
            this.field_70761_aq = ((EntityLiving)this.func_184187_bx()).field_70761_aq;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 4) {
            this.heavySpearTimer = 60;
        }
        else if (id == 5) {
            final ItemStack broken = new ItemStack((Item)Items.field_151030_Z);
            this.func_70669_a(broken);
            this.func_70669_a(broken);
            this.func_70669_a(broken);
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (this.heavySpearTimer > 0) {
            return false;
        }
        if (this.field_70146_Z.nextInt(2) == 0) {
            this.heavySpearTimer = 60;
            this.field_70170_p.func_72960_a((Entity)this, (byte)4);
            return false;
        }
        this.func_184609_a(EnumHand.MAIN_HAND);
        return super.func_70652_k(entity);
    }
    
    public boolean func_70097_a(final DamageSource damageSource, final float amount) {
        if (damageSource == DamageSource.field_76368_d && !this.func_184188_bt().isEmpty()) {
            return false;
        }
        final Entity attacker = damageSource.func_76346_g();
        if (attacker != null) {
            final double dx = this.field_70165_t - attacker.field_70165_t;
            final double dz = this.field_70161_v - attacker.field_70161_v;
            final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
            final float difference = MathHelper.func_76135_e((this.field_70761_aq - angle) % 360.0f);
            if (this.hasShield() && difference > 150.0f && difference < 230.0f) {
                if (this.takeHitOnShield(damageSource, amount)) {
                    return false;
                }
            }
            else if (this.hasShield() && this.field_70146_Z.nextBoolean()) {
                this.damageShield();
            }
            if (this.hasArmor() && (difference > 300.0f || difference < 60.0f)) {
                this.breakArmor();
            }
        }
        return super.func_70097_a(damageSource, amount);
    }
    
    private void breakArmor() {
        this.field_70170_p.func_72960_a((Entity)this, (byte)5);
        this.setHasArmor(false);
    }
    
    private void breakShield() {
        this.field_70170_p.func_72960_a((Entity)this, (byte)5);
        this.setHasShield(false);
    }
    
    public boolean takeHitOnShield(final DamageSource source, final float amount) {
        if (amount > 10.0f && !this.field_70170_p.field_72995_K) {
            this.damageShield();
        }
        else {
            this.func_184185_a(SoundEvents.field_187635_cQ, 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        }
        final EntityLiving toKnockback = (EntityLiving)((this.func_184187_bx() instanceof EntityLiving) ? ((EntityLiving)this.func_184187_bx()) : this);
        if (source.func_76346_g() != null) {
            double d0;
            double d2;
            for (d0 = source.func_76346_g().field_70165_t - this.field_70165_t, d2 = source.func_76346_g().field_70161_v - this.field_70161_v; d0 * d0 + d2 * d2 < 1.0E-4; d0 = (Math.random() - Math.random()) * 0.01, d2 = (Math.random() - Math.random()) * 0.01) {}
            toKnockback.func_70653_a(source.func_76346_g(), 0.0f, d0 / 4.0, d2 / 4.0);
            if (source.func_76346_g() instanceof EntityLiving) {
                this.func_70604_c((EntityLivingBase)source.func_76346_g());
            }
        }
        return true;
    }
    
    private void damageShield() {
        this.func_184185_a(SoundEvents.field_187928_hb, 0.25f, 0.25f);
        ++this.shieldHits;
        if (!this.field_70170_p.field_72995_K && this.shieldHits >= 3) {
            this.breakShield();
        }
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFGoblinKnightUpper.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/goblin_knight");
        DATA_EQUIP = EntityDataManager.func_187226_a((Class)EntityTFGoblinKnightUpper.class, DataSerializers.field_187191_a);
        ARMOR_MODIFIER = new AttributeModifier("Armor boost", 20.0, 0).func_111168_a(false);
        DAMAGE_MODIFIER = new AttributeModifier("Heavy spear attack boost", 12.0, 0).func_111168_a(false);
    }
}
