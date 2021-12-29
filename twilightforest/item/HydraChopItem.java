// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

public class HydraChopItem extends Item
{
    public HydraChopItem(final Item.Properties props) {
        super(props);
    }
    
    public ItemStack func_77654_b(final ItemStack itemStack, final World world, final LivingEntity living) {
        if (living instanceof ServerPlayerEntity && ((ServerPlayerEntity)living).func_71024_bL().func_75116_a() <= 0) {
            TFAdvancements.CONSUME_HYDRA_CHOP.trigger((ServerPlayerEntity)living);
        }
        return super.func_77654_b(itemStack, world, living);
    }
}
