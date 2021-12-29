// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;
import net.minecraft.client.particle.EntityAuraFX;

public class EntityTFProtectionFX extends EntityAuraFX
{
    public EntityTFProtectionFX(final World world, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        super(world, x, y, z, velX, velY, velZ);
        this.func_70536_a(82);
        this.func_70538_b(1.0f, 1.0f, 1.0f);
    }
    
    public float func_70013_c(final float par1) {
        return 1.0f;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_70070_b(final float par1) {
        return 15728880;
    }
}
