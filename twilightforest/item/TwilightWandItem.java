// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.entity.projectile.TwilightWandBolt;
import twilightforest.TFSounds;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;

public class TwilightWandItem extends Item
{
    protected TwilightWandItem(final Item.Properties props) {
        super(props);
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, final InteractionHand hand) {
        final ItemStack stack = player.m_21120_(hand);
        if (stack.m_41773_() == stack.m_41776_()) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)player.m_21120_(hand));
        }
        player.m_5496_(TFSounds.SCEPTER_PEARL, 1.0f, (world.f_46441_.nextFloat() - world.f_46441_.nextFloat()) * 0.2f + 1.0f);
        if (!world.f_46443_) {
            world.m_7967_((Entity)new TwilightWandBolt(world, (LivingEntity)player));
            stack.m_41629_(1, world.f_46441_, (ServerPlayer)null);
        }
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19090_((Object)player.m_21120_(hand));
    }
    
    public boolean m_8120_(final ItemStack pStack) {
        return false;
    }
    
    public boolean isBookEnchantable(final ItemStack stack, final ItemStack book) {
        return false;
    }
    
    public boolean canApplyAtEnchantingTable(final ItemStack stack, final Enchantment enchantment) {
        return false;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltip, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)tooltip, flags);
        tooltip.add((Component)new TranslatableComponent("twilightforest.scepter_charges", new Object[] { stack.m_41776_() - stack.m_41773_() }).m_130940_(ChatFormatting.GRAY));
    }
}
