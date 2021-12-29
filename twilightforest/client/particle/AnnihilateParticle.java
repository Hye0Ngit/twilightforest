// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.TextureSheetParticle;

@OnlyIn(Dist.CLIENT)
public class AnnihilateParticle extends TextureSheetParticle
{
    float initialParticleScale;
    
    public AnnihilateParticle(final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final float scale) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.f_107215_ *= 0.10000000149011612;
        this.f_107216_ *= 0.10000000149011612;
        this.f_107217_ *= 0.10000000149011612;
        this.f_107215_ += vx * 0.4;
        this.f_107216_ += vy * 0.4;
        this.f_107217_ += vz * 0.4;
        final float f_107227_ = 1.0f;
        this.f_107229_ = f_107227_;
        this.f_107228_ = f_107227_;
        this.f_107227_ = f_107227_;
        this.f_107663_ *= 0.75f;
        this.f_107663_ *= scale;
        this.initialParticleScale = this.f_107663_;
        this.f_107225_ = (int)(60.0 / (Math.random() * 0.8 + 0.6));
        this.f_107225_ *= (int)scale;
        this.f_107219_ = true;
    }
    
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }
    
    public void m_5989_() {
        this.f_107209_ = this.f_107212_;
        this.f_107210_ = this.f_107213_;
        this.f_107211_ = this.f_107214_;
        if (this.f_107224_++ >= this.f_107225_) {
            this.m_107274_();
        }
        this.m_6257_(this.f_107215_, this.f_107216_, this.f_107217_);
        this.f_107215_ *= 0.9599999785423279;
        this.f_107216_ *= 0.9599999785423279;
        this.f_107217_ *= 0.9599999785423279;
        if (this.f_107218_) {
            this.f_107215_ *= 0.699999988079071;
            this.f_107217_ *= 0.699999988079071;
        }
        this.f_107663_ *= (float)0.97;
        if (this.f_107663_ < 0.04f) {
            this.m_107274_();
        }
        final float blacken = 0.985f;
        this.f_107227_ *= blacken;
        this.f_107228_ *= blacken;
        this.f_107229_ *= blacken;
    }
    
    public int m_6355_(final float partialTicks) {
        return 15728880;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;
        
        public Factory(final SpriteSet sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle createParticle(final SimpleParticleType typeIn, final ClientLevel worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final AnnihilateParticle particle = new AnnihilateParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, 0.75f);
            particle.m_108335_(this.spriteSet);
            return (Particle)particle;
        }
    }
}
