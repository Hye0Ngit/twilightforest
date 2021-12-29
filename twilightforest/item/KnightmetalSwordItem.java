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
import net.minecraft.world.item.SwordItem;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class KnightmetalSwordItem extends SwordItem
{
    private static final int BONUS_DAMAGE = 2;
    
    public KnightmetalSwordItem(final Tier material, final Item.Properties props) {
        super(material, 3, -2.4f, props);
    }
    
    @SubscribeEvent
    public static void onDamage(final LivingHurtEvent evt) {
        final LivingEntity target = evt.getEntityLiving();
        if (!target.f_19853_.f_46443_) {
            final Entity 7640_ = evt.getSource().m_7640_();
            if (7640_ instanceof final LivingEntity living) {
                final ItemStack weapon = living.m_21205_();
                if (!weapon.m_41619_()) {
                    if (target.m_21230_() > 0 && (weapon.m_150930_((Item)TFItems.KNIGHTMETAL_PICKAXE.get()) || weapon.m_150930_((Item)TFItems.KNIGHTMETAL_SWORD.get()))) {
                        if (target.m_21207_() > 0.0f) {
                            final int moreBonus = (int)(2.0f * target.m_21207_());
                            evt.setAmount(evt.getAmount() + moreBonus);
                        }
                        else {
                            evt.setAmount(evt.getAmount() + 2.0f);
                        }
                        ((ServerLevel)target.f_19853_).m_7726_().m_8394_((Entity)target, (Packet)new ClientboundAnimatePacket((Entity)target, 5));
                    }
                    else if (target.m_21230_() == 0 && weapon.m_150930_((Item)TFItems.KNIGHTMETAL_AXE.get())) {
                        evt.setAmount(evt.getAmount() + 2.0f);
                        ((ServerLevel)target.f_19853_).m_7726_().m_8394_((Entity)target, (Packet)new ClientboundAnimatePacket((Entity)target, 5));
                    }
                }
            }
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> list, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)list, flags);
        list.add((Component)new TranslatableComponent(this.m_5524_() + ".tooltip").m_130940_(ChatFormatting.GRAY));
    }
}
