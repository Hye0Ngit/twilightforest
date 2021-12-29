// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.SoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.Goal;
import twilightforest.entity.ai.HeavySpearAttackGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.MonsterEntity;

public class UpperGoblinKnightEntity extends MonsterEntity
{
    private static final int SHIELD_DAMAGE_THRESHOLD = 10;
    private static final DataParameter<Byte> DATA_EQUIP;
    private static final AttributeModifier ARMOR_MODIFIER;
    private static final AttributeModifier DAMAGE_MODIFIER;
    public static final int HEAVY_SPEAR_TIMER_START = 60;
    private int shieldHits;
    public int heavySpearTimer;
    
    public UpperGoblinKnightEntity(final EntityType<? extends UpperGoblinKnightEntity> type, final World world) {
        super((EntityType)type, world);
        this.shieldHits = 0;
        this.setHasArmor(true);
        this.setHasShield(true);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new HeavySpearAttackGoal(this));
        this.field_70714_bg.func_75776_a(1, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(3, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, false));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 30.0).func_233815_a_(Attributes.field_233821_d_, 0.28).func_233815_a_(Attributes.field_233823_f_, 8.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)UpperGoblinKnightEntity.DATA_EQUIP, (Object)0);
    }
    
    public boolean hasArmor() {
        return ((byte)this.field_70180_af.func_187225_a((DataParameter)UpperGoblinKnightEntity.DATA_EQUIP) & 0x1) > 0;
    }
    
    private void setHasArmor(final boolean flag) {
        final byte otherFlags = (byte)this.field_70180_af.func_187225_a((DataParameter)UpperGoblinKnightEntity.DATA_EQUIP);
        this.field_70180_af.func_187227_b((DataParameter)UpperGoblinKnightEntity.DATA_EQUIP, (Object)(flag ? ((byte)(otherFlags | 0x1)) : ((byte)(otherFlags & 0xFFFFFFFE))));
        if (!this.field_70170_p.field_72995_K) {
            if (flag) {
                if (!this.func_110148_a(Attributes.field_233826_i_).func_180374_a(UpperGoblinKnightEntity.ARMOR_MODIFIER)) {
                    this.func_110148_a(Attributes.field_233826_i_).func_233767_b_(UpperGoblinKnightEntity.ARMOR_MODIFIER);
                }
            }
            else {
                this.func_110148_a(Attributes.field_233826_i_).func_111124_b(UpperGoblinKnightEntity.ARMOR_MODIFIER);
            }
        }
    }
    
    public boolean hasShield() {
        return ((byte)this.field_70180_af.func_187225_a((DataParameter)UpperGoblinKnightEntity.DATA_EQUIP) & 0x2) > 0;
    }
    
    public void setHasShield(final boolean flag) {
        final byte otherFlags = (byte)this.field_70180_af.func_187225_a((DataParameter)UpperGoblinKnightEntity.DATA_EQUIP);
        this.field_70180_af.func_187227_b((DataParameter)UpperGoblinKnightEntity.DATA_EQUIP, (Object)(flag ? ((byte)(otherFlags | 0x2)) : ((byte)(otherFlags & 0xFFFFFFFD))));
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74757_a("hasArmor", this.hasArmor());
        compound.func_74757_a("hasShield", this.hasShield());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
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
    
    protected SoundEvent func_184639_G() {
        return TFSounds.GOBLIN_KNIGHT_AMBIENT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.GOBLIN_KNIGHT_DEATH;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.GOBLIN_KNIGHT_HURT;
    }
    
    public void func_70619_bc() {
        super.func_70619_bc();
        if (this.func_70089_S()) {
            if (this.func_184187_bx() instanceof LivingEntity && this.func_70638_az() == null) {
                this.func_70624_b(((MobEntity)this.func_184187_bx()).func_70638_az());
            }
            if (this.func_70638_az() instanceof PlayerEntity && ((PlayerEntity)this.func_70638_az()).field_71075_bZ.field_75102_a) {
                this.func_70624_b((LivingEntity)null);
            }
            if (!this.func_184218_aH() && this.hasShield()) {
                this.breakShield();
            }
            if (this.heavySpearTimer > 0) {
                if (!this.func_110148_a(Attributes.field_233823_f_).func_180374_a(UpperGoblinKnightEntity.DAMAGE_MODIFIER)) {
                    this.func_110148_a(Attributes.field_233823_f_).func_233767_b_(UpperGoblinKnightEntity.DAMAGE_MODIFIER);
                }
            }
            else {
                this.func_110148_a(Attributes.field_233823_f_).func_188479_b(UpperGoblinKnightEntity.DAMAGE_MODIFIER.func_111167_a());
            }
        }
    }
    
    public void landHeavySpearAttack() {
        final Vector3d vector = this.func_70040_Z();
        final double dist = 1.25;
        final double px = this.func_226277_ct_() + vector.field_72450_a * dist;
        final double py = this.func_174813_aQ().field_72338_b - 0.75;
        final double pz = this.func_226281_cx_() + vector.field_72449_c * dist;
        for (int i = 0; i < 50; ++i) {
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197594_E, px, py, pz, (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.25f), 0.0, (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.25f));
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
        if (this.func_184187_bx() instanceof LivingEntity) {
            this.field_70761_aq = ((LivingEntity)this.func_184187_bx()).field_70761_aq;
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 4) {
            this.heavySpearTimer = 60;
        }
        else if (id == 5) {
            final ItemStack broken = new ItemStack((IItemProvider)Items.field_151030_Z);
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
        this.func_184609_a(Hand.MAIN_HAND);
        return super.func_70652_k(entity);
    }
    
    public boolean func_70097_a(final DamageSource damageSource, final float amount) {
        if (damageSource == DamageSource.field_76368_d && this.func_184187_bx() != null) {
            return false;
        }
        final Entity attacker = damageSource.func_76346_g();
        if (attacker != null && !damageSource.func_180136_u()) {
            final double dx = this.func_226277_ct_() - attacker.func_226277_ct_();
            final double dz = this.func_226281_cx_() - attacker.func_226281_cx_();
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
        final LivingEntity toKnockback = (LivingEntity)((this.func_184187_bx() instanceof LivingEntity) ? ((LivingEntity)this.func_184187_bx()) : this);
        if (source.func_76346_g() != null) {
            double d0;
            double d2;
            for (d0 = source.func_76346_g().func_226277_ct_() - this.func_226277_ct_(), d2 = source.func_76346_g().func_226281_cx_() - this.func_226281_cx_(); d0 * d0 + d2 * d2 < 1.0E-4; d0 = (Math.random() - Math.random()) * 0.01, d2 = (Math.random() - Math.random()) * 0.01) {}
            toKnockback.func_233627_a_(0.0f, d0 / 4.0, d2 / 4.0);
            if (source.func_76346_g() instanceof LivingEntity) {
                this.func_70604_c((LivingEntity)source.func_76346_g());
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
    
    static {
        DATA_EQUIP = EntityDataManager.func_187226_a((Class)UpperGoblinKnightEntity.class, DataSerializers.field_187191_a);
        ARMOR_MODIFIER = new AttributeModifier("Armor boost", 20.0, AttributeModifier.Operation.ADDITION);
        DAMAGE_MODIFIER = new AttributeModifier("Heavy spear attack boost", 12.0, AttributeModifier.Operation.ADDITION);
    }
}
