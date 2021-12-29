// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.StandingAndWallBlockItem;

public class TrophyItem extends StandingAndWallBlockItem
{
    public TrophyItem(final Block floorBlockIn, final Block wallBlockIn, final Item.Properties builder) {
        super(floorBlockIn, wallBlockIn, builder);
    }
    
    public boolean canEquip(final ItemStack stack, final EquipmentSlot armorType, final Entity entity) {
        return armorType == EquipmentSlot.HEAD;
    }
    
    @Nullable
    public EquipmentSlot getEquipmentSlot(final ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
}
