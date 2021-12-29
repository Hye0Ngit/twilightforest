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
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.TextureSheetParticle;

public class LeafRuneParticle extends TextureSheetParticle
{
    LeafRuneParticle(final ClientLevel world, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        super(world, x, y, z, velX, velY, velZ);
        this.f_107215_ = velX;
        this.f_107216_ = velY;
        this.f_107217_ = velZ;
        this.f_107663_ = this.f_107223_.nextFloat() * 0.25f;
        this.f_107225_ = (int)(Math.random() * 10.0) + 40;
        this.f_107226_ = 0.3f + this.f_107223_.nextFloat() * 0.6f;
    }
    
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;
        
        public Factory(final SpriteSet sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle createParticle(final SimpleParticleType typeIn, final ClientLevel worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final LeafRuneParticle particle = new LeafRuneParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.m_108335_(this.spriteSet);
            return (Particle)particle;
        }
    }
}
