// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.particles.IParticleData;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.SuspendedTownParticle;

public class ProtectionParticle extends SuspendedTownParticle
{
    ProtectionParticle(final ClientWorld world, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        super(world, x, y, z, velX, velY, velZ);
    }
    
    public int func_189214_a(final float partialTicks) {
        return 15728880;
    }
    
    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        private final IAnimatedSprite spriteSet;
        
        public Factory(final IAnimatedSprite spriteSet) {
            this.spriteSet = spriteSet;
        }
        
        public Particle makeParticle(final BasicParticleType data, final ClientWorld world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
            final ProtectionParticle particle = new ProtectionParticle(world, x, y, z, vx, vy, vz);
            particle.func_217568_a(this.spriteSet);
            particle.func_70538_b(1.0f, 1.0f, 1.0f);
            return (Particle)particle;
        }
    }
}
