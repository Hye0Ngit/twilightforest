// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFGiantMiner extends EntityMob
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFGiantMiner(final World world) {
        super(world);
        this.func_70105_a(this.field_70130_N * 4.0f, this.field_70131_O * 4.0f);
        for (final EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
            this.func_184642_a(slot, 0.0f);
        }
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackMelee(this, 1.0, false) {
            protected double func_179512_a(final EntityLivingBase attackTarget) {
                return this.field_75441_b.field_70130_N * this.field_75441_b.field_70131_O;
            }
        });
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(80.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(2.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0);
    }
    
    public IEntityLivingData func_180482_a(final DifficultyInstance difficulty, final IEntityLivingData livingdata) {
        final IEntityLivingData data = super.func_180482_a(difficulty, livingdata);
        this.func_180481_a(difficulty);
        this.func_180483_b(difficulty);
        return data;
    }
    
    protected void func_180481_a(final DifficultyInstance difficulty) {
        this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.field_151050_s));
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFGiantMiner.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/giant_miner");
    }
}
