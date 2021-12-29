// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import twilightforest.TwilightForestMod;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.EntityCreature;

public class EntityTFBunny extends EntityCreature implements IAnimals
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Byte> DATA_TYPE;
    
    public EntityTFBunny(final World world) {
        super(world);
        this.func_70105_a(0.3f, 0.6f);
        this.field_70138_W = 1.0f;
        this.setBunnyType(this.field_70146_Z.nextInt(4));
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 2.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.0, Items.field_151172_bF, true));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.0, Items.field_151150_bK, true));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.0, Item.func_150898_a((Block)Blocks.field_150327_N), true));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 2.0f, 0.800000011920929, 1.3300000429153442));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 0.800000011920929));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFBunny.DATA_TYPE, (Object)0);
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74768_a("BunnyType", this.getBunnyType());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setBunnyType(compound.func_74762_e("BunnyType"));
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFBunny.LOOT_TABLE;
    }
    
    public int getBunnyType() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFBunny.DATA_TYPE);
    }
    
    public void setBunnyType(final int type) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFBunny.DATA_TYPE, (Object)(byte)type);
    }
    
    public float func_70047_e() {
        return this.field_70131_O * 0.5f;
    }
    
    public float func_70603_bj() {
        return 0.3f;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public float func_180484_a(final BlockPos pos) {
        final Material underMaterial = this.field_70170_p.func_180495_p(pos.func_177977_b()).func_185904_a();
        if (underMaterial == Material.field_151584_j) {
            return -1.0f;
        }
        if (underMaterial == Material.field_151575_d) {
            return -1.0f;
        }
        if (underMaterial == Material.field_151577_b) {
            return 10.0f;
        }
        return this.field_70170_p.func_175724_o(pos) - 0.5f;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/bunny");
        DATA_TYPE = EntityDataManager.func_187226_a((Class)EntityTFBunny.class, DataSerializers.field_187191_a);
    }
}
