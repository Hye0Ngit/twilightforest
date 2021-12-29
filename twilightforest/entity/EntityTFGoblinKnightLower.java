// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.DifficultyInstance;
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
import twilightforest.entity.ai.EntityAITFRiderSpearAttack;
import net.minecraft.world.World;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFGoblinKnightLower extends EntityMob
{
    private static final DataParameter<Boolean> ARMOR;
    private static final AttributeModifier ARMOR_MODIFIER;
    
    public EntityTFGoblinKnightLower(final World world) {
        super(world);
        this.func_70105_a(0.7f, 1.1f);
        this.setHasArmor(true);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAITFRiderSpearAttack(this));
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
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFGoblinKnightLower.ARMOR, (Object)false);
    }
    
    public boolean hasArmor() {
        return (boolean)this.field_70180_af.func_187225_a((DataParameter)EntityTFGoblinKnightLower.ARMOR);
    }
    
    private void setHasArmor(final boolean flag) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFGoblinKnightLower.ARMOR, (Object)flag);
        if (!this.field_70170_p.field_72995_K) {
            if (flag) {
                if (!this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_180374_a(EntityTFGoblinKnightLower.ARMOR_MODIFIER)) {
                    this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111121_a(EntityTFGoblinKnightLower.ARMOR_MODIFIER);
                }
            }
            else {
                this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111124_b(EntityTFGoblinKnightLower.ARMOR_MODIFIER);
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74757_a("hasArmor", this.hasArmor());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setHasArmor(compound.func_74767_n("hasArmor"));
    }
    
    public IEntityLivingData func_180482_a(final DifficultyInstance difficulty, IEntityLivingData livingData) {
        livingData = super.func_180482_a(difficulty, livingData);
        final EntityTFGoblinKnightUpper upper = new EntityTFGoblinKnightUpper(this.field_70170_p);
        upper.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0f);
        upper.func_180482_a(difficulty, (IEntityLivingData)null);
        this.field_70170_p.func_72838_d((Entity)upper);
        upper.func_184220_m((Entity)this);
        return livingData;
    }
    
    public double func_70042_X() {
        return 1.0;
    }
    
    public void func_70619_bc() {
        super.func_70619_bc();
        if (this.func_184207_aI() && this.func_184188_bt().get(0) instanceof EntityLiving && this.func_70638_az() == null) {
            this.func_70624_b(this.func_184188_bt().get(0).func_70638_az());
        }
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (this.func_184207_aI() && this.func_184188_bt().get(0) instanceof EntityLiving) {
            return this.func_184188_bt().get(0).func_70652_k(entity);
        }
        return super.func_70652_k(entity);
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        Entity attacker = null;
        if (source.func_76346_g() != null) {
            attacker = source.func_76346_g();
        }
        if (source.func_76346_g() != null) {
            attacker = source.func_76346_g();
        }
        if (attacker != null) {
            final double dx = this.field_70165_t - attacker.field_70165_t;
            final double dz = this.field_70161_v - attacker.field_70161_v;
            final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
            final float difference = MathHelper.func_76135_e((this.field_70761_aq - angle) % 360.0f);
            EntityTFGoblinKnightUpper upper = null;
            if (this.func_184207_aI() && this.func_184188_bt().get(0) instanceof EntityTFGoblinKnightUpper) {
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
    
    private void breakArmor() {
        this.func_70669_a(new ItemStack((Item)Items.field_151030_Z));
        this.func_70669_a(new ItemStack((Item)Items.field_151030_Z));
        this.func_70669_a(new ItemStack((Item)Items.field_151030_Z));
        this.setHasArmor(false);
    }
    
    static {
        ARMOR = EntityDataManager.func_187226_a((Class)EntityTFGoblinKnightLower.class, DataSerializers.field_187198_h);
        ARMOR_MODIFIER = new AttributeModifier("Armor boost", 17.0, 0).func_111168_a(false);
    }
}
