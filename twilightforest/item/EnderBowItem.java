// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.item.BowItem;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class EnderBowItem extends BowItem
{
    private static final String KEY = "twilightforest:ender";
    
    public EnderBowItem(final Item.Properties props) {
        super(props);
    }
    
    @SubscribeEvent
    public static void onHit(final ProjectileImpactEvent.Arrow evt) {
        final AbstractArrowEntity arrow = evt.getArrow();
        if (arrow.func_234616_v_() instanceof PlayerEntity && evt.getRayTraceResult() instanceof EntityRayTraceResult && ((EntityRayTraceResult)evt.getRayTraceResult()).func_216348_a() instanceof LivingEntity) {
            final PlayerEntity player = (PlayerEntity)arrow.func_234616_v_();
            final LivingEntity living = (LivingEntity)((EntityRayTraceResult)evt.getRayTraceResult()).func_216348_a();
            if (arrow.getPersistentData().func_74764_b("twilightforest:ender") && player.func_184187_bx() == null) {
                final double sourceX = player.func_226277_ct_();
                final double sourceY = player.func_226278_cu_();
                final double sourceZ = player.func_226281_cx_();
                final float sourceYaw = player.field_70177_z;
                final float sourcePitch = player.field_70125_A;
                player.field_70177_z = living.field_70177_z;
                player.field_70125_A = living.field_70125_A;
                player.func_70634_a(living.func_226277_ct_(), living.func_226278_cu_(), living.func_226281_cx_());
                player.func_184185_a(SoundEvents.field_187544_ad, 1.0f, 1.0f);
                living.field_70177_z = sourceYaw;
                living.field_70125_A = sourcePitch;
                living.func_70634_a(sourceX, sourceY, sourceZ);
                living.func_184185_a(SoundEvents.field_187544_ad, 1.0f, 1.0f);
            }
        }
    }
    
    public AbstractArrowEntity customArrow(final AbstractArrowEntity arrow) {
        arrow.getPersistentData().func_74757_a("twilightforest:ender", true);
        return arrow;
    }
}
