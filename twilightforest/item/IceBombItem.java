// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.projectile.IceBomb;
import twilightforest.entity.TFEntities;
import twilightforest.TFSounds;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;

public class IceBombItem extends Item
{
    public IceBombItem(final Item.Properties props) {
        super(props);
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, final InteractionHand hand) {
        player.m_5496_(TFSounds.ICEBOMB_FIRED, 0.5f, 0.4f / (world.f_46441_.nextFloat() * 0.4f + 0.8f));
        if (!world.f_46443_) {
            if (!player.m_150110_().f_35937_) {
                player.m_21120_(hand).m_41774_(1);
            }
            final IceBomb ice = new IceBomb(TFEntities.THROWN_ICE, world, (LivingEntity)player);
            ice.m_37251_((Entity)player, player.m_146909_(), player.m_146908_(), -20.0f, 0.75f, 1.0f);
            world.m_7967_((Entity)ice);
        }
        return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.SUCCESS, (Object)player.m_21120_(hand));
    }
}
