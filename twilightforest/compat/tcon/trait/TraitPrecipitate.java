// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.tcon.trait;

import javax.annotation.Nullable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractProjectileTrait;

public class TraitPrecipitate extends AbstractProjectileTrait
{
    public TraitPrecipitate() {
        super("precipitate", TextFormatting.DARK_GREEN);
    }
    
    public void miningSpeed(final ItemStack tool, final PlayerEvent.BreakSpeed event) {
        event.setNewSpeed(event.getNewSpeed() + this.getBonusPercentage(event.getEntityLiving()) * event.getOriginalSpeed());
    }
    
    public void onLaunch(final EntityProjectileBase projectileBase, final World world, @Nullable final EntityLivingBase shooter) {
        final float bonus = this.getBonusPercentage(shooter);
        projectileBase.field_70159_w += projectileBase.field_70159_w * bonus;
        projectileBase.field_70181_x += projectileBase.field_70181_x * bonus;
        projectileBase.field_70179_y += projectileBase.field_70179_y * bonus;
    }
    
    private float getBonusPercentage(final EntityLivingBase entity) {
        if (entity == null) {
            return 0.1f;
        }
        final float maxHealth = entity.func_110138_aP();
        return (maxHealth - entity.func_110143_aJ()) / maxHealth;
    }
}
