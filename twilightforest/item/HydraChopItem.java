// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.advancements.TFAdvancements;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class HydraChopItem extends Item
{
    public HydraChopItem(final Item.Properties props) {
        super(props);
    }
    
    public ItemStack m_5922_(final ItemStack itemStack, final Level world, final LivingEntity living) {
        if (living instanceof ServerPlayer && ((ServerPlayer)living).m_36324_().m_38702_() <= 0) {
            TFAdvancements.CONSUME_HYDRA_CHOP.trigger((ServerPlayer)living);
        }
        return super.m_5922_(itemStack, world, living);
    }
}
