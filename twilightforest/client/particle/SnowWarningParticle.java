// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.particles.IParticleData;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.world.ClientWorld;

public class SnowWarningParticle extends SnowParticle
{
    SnowWarningParticle(final ClientWorld world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final float scale) {
        super(world, x, y, z, vx, vy, vz, scale);
        this.field_70547_e = 50;
    }
    
    @Override
    public void func_189213_a() {
        super.func_189213_a();
        this.field_187130_j -= 0.019999999552965164;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        private final IAnimatedSprite spriteSet;
        
        public Factory(final IAnimatedSprite sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle makeParticle(final BasicParticleType typeIn, final ClientWorld worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final SnowWarningParticle particle = new SnowWarningParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, 1.0f);
            particle.func_217568_a(this.spriteSet);
            return (Particle)particle;
        }
    }
}
