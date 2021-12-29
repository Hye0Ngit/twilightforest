// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.tcon.trait;

import javax.annotation.Nullable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractProjectileTrait;

public class TraitVeiled extends AbstractProjectileTrait
{
    public TraitVeiled() {
        super("veiled", TextFormatting.GRAY);
    }
    
    public void onLaunch(final EntityProjectileBase projectileBase, final World world, @Nullable final EntityLivingBase shooter) {
        projectileBase.func_82142_c(true);
    }
}
