// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.EffectInstance;
import twilightforest.potions.TFPotions;
import net.minecraft.potion.Effect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class IceSwordItem extends SwordItem
{
    public IceSwordItem(final IItemTier toolMaterial, final Item.Properties props) {
        super(toolMaterial, 3, -2.4f, props);
    }
    
    public boolean func_77644_a(final ItemStack stack, final LivingEntity target, final LivingEntity attacker) {
        final boolean result = super.func_77644_a(stack, target, attacker);
        if (result) {
            if (!target.field_70170_p.field_72995_K) {
                target.func_195064_c(new EffectInstance((Effect)TFPotions.frosty.get(), 200, 2));
            }
            else {
                target.field_70170_p.func_195594_a((IParticleData)TFParticleType.SNOW.get(), target.func_226277_ct_(), target.func_226278_cu_() + target.func_213302_cg() * 0.5, target.func_226281_cx_(), target.func_213311_cf() * 0.5, target.func_213302_cg() * 0.5, target.func_213311_cf() * 0.5);
            }
        }
        return result;
    }
}
