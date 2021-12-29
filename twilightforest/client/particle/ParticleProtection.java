// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.World;
import net.minecraft.client.particle.ParticleSuspendedTown;

public class ParticleProtection extends ParticleSuspendedTown
{
    public ParticleProtection(final World world, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        super(world, x, y, z, velX, velY, velZ);
        this.func_70536_a(82);
        this.func_70538_b(1.0f, 1.0f, 1.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_189214_a(final float partialTicks) {
        return 15728880;
    }
}
