// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.world.World;

public class EntityTFSnowWarningFX extends EntityTFSnowFX
{
    public EntityTFSnowWarningFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12, final float par14) {
        super(par1World, par2, par4, par6, par8, par10, par12, par14);
        this.field_70547_e = 50;
    }
    
    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70181_x -= 0.019999999552965164;
    }
}
