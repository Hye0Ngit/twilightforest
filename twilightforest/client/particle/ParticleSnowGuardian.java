// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.world.World;

public class ParticleSnowGuardian extends ParticleSnow
{
    public ParticleSnowGuardian(final World world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final float scale) {
        super(world, x, y, z, vx, vy, vz, scale);
        this.field_70547_e = 10 + this.field_187136_p.nextInt(15);
        final float field_70552_h = 0.75f + this.field_187136_p.nextFloat() * 0.25f;
        this.field_70551_j = field_70552_h;
        this.field_70553_i = field_70552_h;
        this.field_70552_h = field_70552_h;
    }
}
