// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class ArmoredGiantEntity extends GiantMinerEntity
{
    public ArmoredGiantEntity(final EntityType<? extends ArmoredGiantEntity> type, final World world) {
        super(type, world);
    }
    
    @Override
    protected void func_180481_a(final DifficultyInstance difficulty) {
        super.func_180481_a(difficulty);
        this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)Items.field_151052_q));
        this.func_184201_a(EquipmentSlotType.HEAD, new ItemStack((IItemProvider)Items.field_151028_Y));
        this.func_184201_a(EquipmentSlotType.CHEST, new ItemStack((IItemProvider)Items.field_151030_Z));
        this.func_184201_a(EquipmentSlotType.LEGS, new ItemStack((IItemProvider)Items.field_151165_aa));
        this.func_184201_a(EquipmentSlotType.FEET, new ItemStack((IItemProvider)Items.field_151167_ab));
    }
}
