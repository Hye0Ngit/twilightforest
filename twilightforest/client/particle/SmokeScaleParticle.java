// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.particles.IParticleData;
import net.minecraft.client.particle.Particle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.SmokeParticle;

public class SmokeScaleParticle extends SmokeParticle
{
    SmokeScaleParticle(final ClientWorld world, final double x, final double y, final double z, final double velX, final double velY, final double velZ, final float scale, final IAnimatedSprite sprite) {
        super(world, x, y, z, velX, velY, velZ, scale, sprite);
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        private final IAnimatedSprite spriteSet;
        
        public Factory(final IAnimatedSprite sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle makeParticle(final BasicParticleType typeIn, final ClientWorld worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            return (Particle)new SmokeScaleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, 4.0f, this.spriteSet);
        }
    }
}
