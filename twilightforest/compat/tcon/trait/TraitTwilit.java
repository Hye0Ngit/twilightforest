// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.tcon.trait;

import com.google.common.collect.ImmutableList;
import slimeknights.tconstruct.library.Util;
import java.util.List;
import net.minecraft.nbt.NBTTagCompound;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.world.TFWorld;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractProjectileTrait;

public class TraitTwilit extends AbstractProjectileTrait
{
    private static final float bonus = 2.0f;
    
    public TraitTwilit() {
        super("twilit", TextFormatting.GOLD);
    }
    
    public void miningSpeed(final ItemStack tool, final PlayerEvent.BreakSpeed event) {
        if (TFWorld.isTwilightForest(event.getEntity().field_70170_p)) {
            event.setNewSpeed(event.getNewSpeed() + 2.0f);
        }
    }
    
    public float damage(final ItemStack tool, final EntityLivingBase player, final EntityLivingBase target, final float damage, final float newDamage, final boolean isCritical) {
        if (TFWorld.isTwilightForest(target.field_70170_p)) {
            return super.damage(tool, player, target, damage, newDamage, isCritical);
        }
        return super.damage(tool, player, target, damage, newDamage + 2.0f, isCritical);
    }
    
    public void onLaunch(final EntityProjectileBase projectileBase, final World world, @Nullable final EntityLivingBase shooter) {
        if (!TFWorld.isTwilightForest(projectileBase.field_70170_p)) {
            return;
        }
        projectileBase.field_70159_w += projectileBase.field_70159_w * 2.0 * 0.10000000149011612;
        projectileBase.field_70181_x += projectileBase.field_70181_x * 2.0 * 0.10000000149011612;
        projectileBase.field_70179_y += projectileBase.field_70179_y * 2.0 * 0.10000000149011612;
    }
    
    public List<String> getExtraInfo(final ItemStack tool, final NBTTagCompound modifierTag) {
        final String speed = String.format("modifier.%s.extra.speed", this.getModifierIdentifier());
        final String damage = String.format("modifier.%s.extra.damage", this.getModifierIdentifier());
        return (List<String>)ImmutableList.of((Object)Util.translateFormatted(speed, new Object[] { Util.df.format(2.0) }), (Object)Util.translateFormatted(damage, new Object[] { Util.df.format(2.0) }));
    }
}
