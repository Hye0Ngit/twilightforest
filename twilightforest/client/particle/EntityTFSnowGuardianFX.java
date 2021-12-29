// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.world.World;

public class EntityTFSnowGuardianFX extends EntityTFSnowFX
{
    public EntityTFSnowGuardianFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12, final float par14) {
        super(par1World, par2, par4, par6, par8, par10, par12, par14);
        this.field_70547_e = 10 + this.field_70146_Z.nextInt(15);
        final float field_70552_h = 0.75f + this.field_70146_Z.nextFloat() * 0.25f;
        this.field_70551_j = field_70552_h;
        this.field_70553_i = field_70552_h;
        this.field_70552_h = field_70552_h;
    }
}
