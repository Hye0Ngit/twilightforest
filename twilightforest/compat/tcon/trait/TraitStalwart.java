// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.tcon.trait;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitStalwart extends AbstractTrait
{
    public TraitStalwart() {
        super("stalwart", TextFormatting.GRAY);
    }
    
    public void onHit(final ItemStack tool, final EntityLivingBase player, final EntityLivingBase target, final float damage, final boolean isCritical) {
        if (isCritical || TraitStalwart.random.nextInt(10) == 0) {
            player.func_70690_d(new PotionEffect(MobEffects.field_76429_m, 200));
        }
    }
}
