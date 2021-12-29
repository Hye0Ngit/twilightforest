// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.BowItem;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class EnderBowItem extends BowItem
{
    private static final String KEY = "twilightforest:ender";
    
    public EnderBowItem(final Item.Properties props) {
        super(props);
    }
    
    @SubscribeEvent
    public static void onHit(final ProjectileImpactEvent evt) {
        final Projectile arrow = evt.getProjectile();
        final Entity 37282_ = arrow.m_37282_();
        if (37282_ instanceof final Player player) {
            if (evt.getRayTraceResult() instanceof final EntityHitResult entityHitResult) {
                final Entity 82443_ = entityHitResult.m_82443_();
                if (82443_ instanceof final LivingEntity living) {
                    if (arrow.getPersistentData().m_128441_("twilightforest:ender") && player.m_20202_() == null) {
                        final double sourceX = player.m_20185_();
                        final double sourceY = player.m_20186_();
                        final double sourceZ = player.m_20189_();
                        final float sourceYaw = player.m_146908_();
                        final float sourcePitch = player.m_146909_();
                        player.m_146922_(living.m_146908_());
                        player.m_146926_(living.m_146909_());
                        player.m_6021_(living.m_20185_(), living.m_20186_(), living.m_20189_());
                        player.m_5496_(SoundEvents.f_11757_, 1.0f, 1.0f);
                        living.m_146922_(sourceYaw);
                        living.m_146926_(sourcePitch);
                        living.m_6021_(sourceX, sourceY, sourceZ);
                        living.m_5496_(SoundEvents.f_11757_, 1.0f, 1.0f);
                    }
                }
            }
        }
    }
    
    public AbstractArrow customArrow(final AbstractArrow arrow) {
        arrow.getPersistentData().m_128379_("twilightforest:ender", true);
        return arrow;
    }
}
