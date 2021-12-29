// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.world.World;

public class ParticleSnowWarning extends ParticleSnow
{
    public ParticleSnowWarning(final World world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final float scale) {
        super(world, x, y, z, vx, vy, vz, scale);
        this.field_70547_e = 50;
    }
    
    @Override
    public void func_189213_a() {
        super.func_189213_a();
        this.field_187130_j -= 0.019999999552965164;
    }
}
