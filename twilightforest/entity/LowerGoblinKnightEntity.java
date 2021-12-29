// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import javax.annotation.Nullable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
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
import twilightforest.entity.ai.RiderSpearAttackGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.MonsterEntity;

public class LowerGoblinKnightEntity extends MonsterEntity
{
    private static final DataParameter<Boolean> ARMOR;
    private static final AttributeModifier ARMOR_MODIFIER;
    
    public LowerGoblinKnightEntity(final EntityType<? extends LowerGoblinKnightEntity> type, final World world) {
        super((EntityType)type, world);
        this.setHasArmor(true);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new RiderSpearAttackGoal(this));
        this.field_70714_bg.func_75776_a(1, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(3, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, false));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 20.0).func_233815_a_(Attributes.field_233821_d_, 0.28).func_233815_a_(Attributes.field_233823_f_, 4.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)LowerGoblinKnightEntity.ARMOR, (Object)false);
    }
    
    public boolean hasArmor() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)LowerGoblinKnightEntity.ARMOR);
    }
    
    private void setHasArmor(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)LowerGoblinKnightEntity.ARMOR, (Object)flag);
        if (!this.field_70170_p.field_72995_K) {
            if (flag) {
                if (!this.func_110148_a(Attributes.field_233826_i_).func_180374_a(LowerGoblinKnightEntity.ARMOR_MODIFIER)) {
                    this.func_110148_a(Attributes.field_233826_i_).func_233767_b_(LowerGoblinKnightEntity.ARMOR_MODIFIER);
                }
            }
            else {
                this.func_110148_a(Attributes.field_233826_i_).func_111124_b(LowerGoblinKnightEntity.ARMOR_MODIFIER);
            }
        }
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74757_a("hasArmor", this.hasArmor());
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setHasArmor(compound.func_74767_n("hasArmor"));
    }
    
    @Nullable
    public ILivingEntityData func_213386_a(final IServerWorld worldIn, final DifficultyInstance difficulty, final SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable final CompoundNBT dataTag) {
        livingData = super.func_213386_a(worldIn, difficulty, reason, livingData, dataTag);
        final UpperGoblinKnightEntity upper = new UpperGoblinKnightEntity(TFEntities.goblin_knight_upper, this.field_70170_p);
        upper.func_70012_b(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.field_70177_z, 0.0f);
        upper.func_213386_a(worldIn, difficulty, SpawnReason.NATURAL, livingData, dataTag);
        upper.func_184220_m((Entity)this);
        return livingData;
    }
    
    public double func_70042_X() {
        return 1.0;
    }
    
    public void func_70619_bc() {
        if (this.func_184207_aI() && this.func_184188_bt().get(0) instanceof LivingEntity && this.func_70638_az() == null) {
            this.func_70624_b(this.func_184188_bt().get(0).func_70638_az());
        }
        if (this.func_70638_az() instanceof PlayerEntity && ((PlayerEntity)this.func_70638_az()).field_71075_bZ.field_75102_a) {
            this.func_70624_b((LivingEntity)null);
        }
        super.func_70619_bc();
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (this.func_184207_aI() && this.func_184188_bt().get(0) instanceof LivingEntity) {
            return this.func_184188_bt().get(0).func_70652_k(entity);
        }
        return super.func_70652_k(entity);
    }
    
    @Nullable
    protected SoundEvent func_184639_G() {
        return this.func_184207_aI() ? TFSounds.GOBLIN_KNIGHT_MUFFLED_AMBIENT : TFSounds.GOBLIN_KNIGHT_AMBIENT;
    }
    
    protected SoundEvent func_184615_bR() {
        return this.func_184207_aI() ? TFSounds.GOBLIN_KNIGHT_MUFFLED_DEATH : TFSounds.GOBLIN_KNIGHT_DEATH;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return this.func_184207_aI() ? TFSounds.GOBLIN_KNIGHT_MUFFLED_HURT : TFSounds.GOBLIN_KNIGHT_HURT;
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        Entity attacker = null;
        if (source.func_76346_g() != null) {
            attacker = source.func_76346_g();
        }
        if (source.func_76346_g() != null) {
            attacker = source.func_76346_g();
        }
        if (attacker != null && !source.func_180136_u()) {
            final double dx = this.func_226277_ct_() - attacker.func_226277_ct_();
            final double dz = this.func_226281_cx_() - attacker.func_226281_cx_();
            final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
            final float difference = MathHelper.func_76135_e((this.field_70761_aq - angle) % 360.0f);
            UpperGoblinKnightEntity upper = null;
            if (this.func_184207_aI() && this.func_184188_bt().get(0) instanceof UpperGoblinKnightEntity) {
                upper = this.func_184188_bt().get(0);
            }
            if (upper != null && upper.hasShield() && difference > 150.0f && difference < 230.0f && upper.takeHitOnShield(source, amount)) {
                return false;
            }
            if (this.hasArmor() && (difference > 300.0f || difference < 60.0f)) {
                this.breakArmor();
            }
        }
        return super.func_70097_a(source, amount);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 5) {
            final ItemStack broken = new ItemStack((IItemProvider)Items.field_151030_Z);
            this.func_70669_a(broken);
            this.func_70669_a(broken);
            this.func_70669_a(broken);
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    private void breakArmor() {
        this.field_70170_p.func_72960_a((Entity)this, (byte)5);
        this.setHasArmor(false);
    }
    
    static {
        ARMOR = EntityDataManager.func_187226_a((Class)LowerGoblinKnightEntity.class, DataSerializers.field_187198_h);
        ARMOR_MODIFIER = new AttributeModifier("Armor boost", 17.0, AttributeModifier.Operation.ADDITION);
    }
}
