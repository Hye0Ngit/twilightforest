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
import net.minecraft.core.Direction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import twilightforest.entity.TFEntities;
import twilightforest.entity.monster.LoyalZombie;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.entity.Entity;
import twilightforest.util.EntityUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import javax.annotation.Nonnull;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;

public class ZombieWandItem extends Item
{
    protected ZombieWandItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, @Nonnull final InteractionHand hand) {
        final ItemStack stack = player.m_21120_(hand);
        if (stack.m_41773_() == stack.m_41776_()) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)stack);
        }
        if (!world.f_46443_) {
            final BlockHitResult blockray = EntityUtil.rayTrace((Entity)player, 20.0);
            if (blockray.m_6662_() != HitResult.Type.MISS) {
                final LoyalZombie zombie = (LoyalZombie)TFEntities.LOYAL_ZOMBIE.m_20615_(world);
                final Direction face = blockray.m_82434_();
                zombie.m_19890_((double)(blockray.m_82425_().m_123341_() + 0.5f + face.m_122429_()), (double)(blockray.m_82425_().m_123342_() + face.m_122430_()), (double)(blockray.m_82425_().m_123343_() + 0.5f + face.m_122431_()), 1.0f, 1.0f);
                zombie.m_7105_(true);
                zombie.m_21816_(player.m_142081_());
                zombie.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 1200, 1));
                world.m_7967_((Entity)zombie);
                stack.m_41629_(1, world.f_46441_, (ServerPlayer)null);
            }
        }
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)stack);
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
