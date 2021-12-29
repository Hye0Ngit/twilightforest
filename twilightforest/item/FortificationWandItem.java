// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.server.level.ServerPlayer;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import javax.annotation.Nonnull;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;

public class FortificationWandItem extends Item
{
    protected FortificationWandItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, @Nonnull final InteractionHand hand) {
        final ItemStack stack = player.m_21120_(hand);
        if (stack.m_41773_() == stack.m_41776_()) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)stack);
        }
        if (!world.f_46443_) {
            player.getCapability((Capability)CapabilityList.SHIELDS).ifPresent(cap -> {
                cap.replenishShields();
                stack.m_41629_(1, world.f_46441_, (ServerPlayer)null);
            });
        }
        if (!player.m_7500_()) {
            player.m_36335_().m_41524_((Item)this, 1200);
        }
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19090_((Object)stack);
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
