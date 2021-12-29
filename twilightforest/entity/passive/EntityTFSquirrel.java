// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import twilightforest.TwilightForestMod;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.ai.EntityAITFTempt;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.EntityCreature;

public class EntityTFSquirrel extends EntityCreature implements IAnimals
{
    public static final ResourceLocation LOOT_TABLE;
    protected static final Ingredient SEEDS;
    
    public EntityTFSquirrel(final World world) {
        super(world);
        this.func_70105_a(0.3f, 0.5f);
        this.field_70138_W = 1.0f;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.3799999952316284));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFTempt(this, 1.0, true, EntityTFSquirrel.SEEDS));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 2.0f, 0.800000011920929, 1.399999976158142));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 1.25));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
    }
    
    public void func_180430_e(final float distance, final float multiplier) {
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFSquirrel.LOOT_TABLE;
    }
    
    public float func_70047_e() {
        return this.field_70131_O * 0.7f;
    }
    
    public float func_70603_bj() {
        return 0.3f;
    }
    
    public float func_180484_a(final BlockPos pos) {
        final Material underMaterial = this.field_70170_p.func_180495_p(pos.func_177977_b()).func_185904_a();
        if (underMaterial == Material.field_151584_j) {
            return 12.0f;
        }
        if (underMaterial == Material.field_151575_d) {
            return 15.0f;
        }
        if (underMaterial == Material.field_151577_b) {
            return 10.0f;
        }
        return this.field_70170_p.func_175724_o(pos) - 0.5f;
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/squirrel");
        SEEDS = Ingredient.func_193368_a(new Item[] { Items.field_151014_N, Items.field_151081_bc, Items.field_151080_bb, Items.field_185163_cU });
    }
}
