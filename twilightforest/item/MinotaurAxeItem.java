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
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.AxeItem;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class MinotaurAxeItem extends AxeItem
{
    private static final int BONUS_CHARGING_DAMAGE = 7;
    
    protected MinotaurAxeItem(final Tier material, final Item.Properties props) {
        super(material, 6.0f, material.m_6624_() * 0.05f - 3.4f, props);
    }
    
    @SubscribeEvent
    public static void onAttack(final LivingHurtEvent evt) {
        final LivingEntity target = evt.getEntityLiving();
        final Entity source = evt.getSource().m_7640_();
        if (!target.f_19853_.f_46443_ && source instanceof LivingEntity && source.m_20142_() && (evt.getSource().m_19385_().equals("player") || evt.getSource().m_19385_().equals("mob"))) {
            final ItemStack weapon = ((LivingEntity)evt.getSource().m_7640_()).m_21205_();
            if (!weapon.m_41619_() && weapon.m_41720_() instanceof MinotaurAxeItem) {
                evt.setAmount(evt.getAmount() + 7.0f);
                ((ServerLevel)target.f_19853_).m_7726_().m_8394_((Entity)target, (Packet)new ClientboundAnimatePacket((Entity)target, 5));
            }
        }
    }
    
    public int m_6473_() {
        return Tiers.GOLD.m_6601_();
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltip, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)tooltip, flags);
        tooltip.add((Component)new TranslatableComponent("item.twilightforest.minotaur_axe.tooltip").m_130940_(ChatFormatting.GRAY));
    }
}
