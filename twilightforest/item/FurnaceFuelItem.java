// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import javax.annotation.Nullable;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;

public class FurnaceFuelItem extends BlockItem
{
    private final int burntime;
    
    public FurnaceFuelItem(final Block block, final Item.Properties properties, final int burn) {
        super(block, properties);
        this.burntime = burn;
    }
    
    public int getBurnTime(final ItemStack itemStack, @Nullable final RecipeType<?> recipeType) {
        return this.burntime;
    }
}
