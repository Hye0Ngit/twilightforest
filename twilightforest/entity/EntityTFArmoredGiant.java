// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;

public class EntityTFArmoredGiant extends EntityTFGiantMiner
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFArmoredGiant(final World world) {
        super(world);
    }
    
    @Override
    protected void func_180481_a(final DifficultyInstance difficulty) {
        super.func_180481_a(difficulty);
        this.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.field_151052_q));
        this.func_184201_a(EntityEquipmentSlot.HEAD, new ItemStack((Item)Items.field_151028_Y));
        this.func_184201_a(EntityEquipmentSlot.CHEST, new ItemStack((Item)Items.field_151030_Z));
        this.func_184201_a(EntityEquipmentSlot.LEGS, new ItemStack((Item)Items.field_151165_aa));
        this.func_184201_a(EntityEquipmentSlot.FEET, new ItemStack((Item)Items.field_151167_ab));
    }
    
    @Override
    public ResourceLocation func_184647_J() {
        return EntityTFArmoredGiant.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/armored_giant");
    }
}
