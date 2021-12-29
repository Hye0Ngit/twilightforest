// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.ai.EntityAITFRedcapPlantTNT;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;

public class EntityTFRedcapSapper extends EntityTFRedcap
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFRedcapSapper(final World world) {
        super(world);
        this.heldPick = new ItemStack(TFItems.ironwood_pickaxe);
        this.heldTNT.func_190920_e(3);
    }
    
    @Override
    protected void func_180481_a(final DifficultyInstance difficulty) {
        super.func_180481_a(difficulty);
        this.func_184201_a(EntityEquipmentSlot.FEET, new ItemStack(TFItems.ironwood_boots));
    }
    
    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFRedcapPlantTNT(this));
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_188791_g).func_111128_a(2.0);
    }
    
    @Override
    public ResourceLocation func_184647_J() {
        return EntityTFRedcapSapper.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/redcap_sapper");
    }
}
