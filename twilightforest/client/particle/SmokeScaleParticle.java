// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.client.particle.Particle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SmokeParticle;

public class SmokeScaleParticle extends SmokeParticle
{
    SmokeScaleParticle(final ClientLevel world, final double x, final double y, final double z, final double velX, final double velY, final double velZ, final float scale, final SpriteSet sprite) {
        super(world, x, y, z, velX, velY, velZ, scale, sprite);
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;
        
        public Factory(final SpriteSet sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle createParticle(final SimpleParticleType typeIn, final ClientLevel worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            return (Particle)new SmokeScaleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, 4.0f, this.spriteSet);
        }
    }
}
