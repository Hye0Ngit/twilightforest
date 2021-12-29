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
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.SwordItem;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class FierySwordItem extends SwordItem
{
    public FierySwordItem(final Tier toolMaterial, final Item.Properties props) {
        super(toolMaterial, 3, -2.4f, props);
    }
    
    public boolean m_7579_(final ItemStack stack, final LivingEntity target, final LivingEntity attacker) {
        final boolean result = super.m_7579_(stack, target, attacker);
        if (result && !target.f_19853_.f_46443_ && !target.m_5825_()) {
            target.m_20254_(15);
        }
        else {
            for (int var1 = 0; var1 < 20; ++var1) {
                final double px = target.m_20185_() + target.f_19853_.f_46441_.nextFloat() * target.m_20205_() * 2.0f - target.m_20205_();
                final double py = target.m_20186_() + target.f_19853_.f_46441_.nextFloat() * target.m_20206_();
                final double pz = target.m_20189_() + target.f_19853_.f_46441_.nextFloat() * target.m_20205_() * 2.0f - target.m_20205_();
                target.f_19853_.m_7106_((ParticleOptions)ParticleTypes.f_123744_, px, py, pz, 0.02, 0.02, 0.02);
            }
        }
        return result;
    }
    
    @SubscribeEvent
    public static void setFireBeforeDeath(final LivingAttackEvent event) {
        final Entity 7639_ = event.getSource().m_7639_();
        if (7639_ instanceof final LivingEntity living) {
            if (living.m_21205_().m_150930_((Item)TFItems.FIERY_SWORD.get())) {
                event.getEntityLiving().m_20254_(1);
            }
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_7373_(final ItemStack stack, @Nullable final Level world, final List<Component> tooltip, final TooltipFlag flags) {
        super.m_7373_(stack, world, (List)tooltip, flags);
        tooltip.add((Component)new TranslatableComponent(this.m_5524_() + ".tooltip").m_130940_(ChatFormatting.GRAY));
    }
}
