// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SuspendedTownParticle;

public class ProtectionParticle extends SuspendedTownParticle
{
    ProtectionParticle(final ClientLevel world, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        super(world, x, y, z, velX, velY, velZ);
    }
    
    public int m_6355_(final float partialTicks) {
        return 15728880;
    }
    
    public static class Factory implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;
        
        public Factory(final SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }
        
        public Particle createParticle(final SimpleParticleType data, final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
            final ProtectionParticle particle = new ProtectionParticle(world, x, y, z, vx, vy, vz);
            particle.m_108335_(this.spriteSet);
            particle.m_107253_(1.0f, 1.0f, 1.0f);
            return (Particle)particle;
        }
    }
}
