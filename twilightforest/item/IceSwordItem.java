// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffectInstance;
import twilightforest.potions.TFMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;

public class IceSwordItem extends SwordItem
{
    public IceSwordItem(final Tier toolMaterial, final Item.Properties props) {
        super(toolMaterial, 3, -2.4f, props);
    }
    
    public boolean m_7579_(final ItemStack stack, final LivingEntity target, final LivingEntity attacker) {
        final boolean result = super.m_7579_(stack, target, attacker);
        if (result) {
            if (!target.f_19853_.f_46443_) {
                target.m_7292_(new MobEffectInstance((MobEffect)TFMobEffects.FROSTY.get(), 200, 2));
            }
            else {
                target.f_19853_.m_7106_((ParticleOptions)TFParticleType.SNOW.get(), target.m_20185_(), target.m_20186_() + target.m_20206_() * 0.5, target.m_20189_(), target.m_20205_() * 0.5, target.m_20206_() * 0.5, target.m_20205_() * 0.5);
            }
        }
        return result;
    }
}
