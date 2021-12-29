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
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.SpriteTexturedParticle;

public class LeafRuneParticle extends SpriteTexturedParticle
{
    LeafRuneParticle(final ClientWorld world, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        super(world, x, y, z, velX, velY, velZ);
        this.field_187129_i = velX;
        this.field_187130_j = velY;
        this.field_187131_k = velZ;
        this.field_70544_f = this.field_187136_p.nextFloat() * 0.25f;
        this.field_70547_e = (int)(Math.random() * 10.0) + 40;
        this.field_70545_g = 0.3f + this.field_187136_p.nextFloat() * 0.6f;
    }
    
    public IParticleRenderType func_217558_b() {
        return IParticleRenderType.field_217602_b;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        private final IAnimatedSprite spriteSet;
        
        public Factory(final IAnimatedSprite sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle makeParticle(final BasicParticleType typeIn, final ClientWorld worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final LeafRuneParticle particle = new LeafRuneParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.func_217568_a(this.spriteSet);
            return (Particle)particle;
        }
    }
}
