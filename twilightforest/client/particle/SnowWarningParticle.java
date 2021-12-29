// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.multiplayer.ClientLevel;

public class SnowWarningParticle extends SnowParticle
{
    SnowWarningParticle(final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final float scale) {
        super(world, x, y, z, vx, vy, vz, scale);
        this.f_107225_ = 50;
    }
    
    @Override
    public void m_5989_() {
        super.m_5989_();
        this.f_107216_ -= 0.019999999552965164;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;
        
        public Factory(final SpriteSet sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle createParticle(final SimpleParticleType typeIn, final ClientLevel worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final SnowWarningParticle particle = new SnowWarningParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, 1.0f);
            particle.m_108335_(this.spriteSet);
            return (Particle)particle;
        }
    }
}
