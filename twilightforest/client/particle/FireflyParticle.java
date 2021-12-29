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
import net.minecraft.client.Camera;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.TextureSheetParticle;

public class FireflyParticle extends TextureSheetParticle
{
    private final int halfLife;
    
    FireflyParticle(final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        super(world, x, y, z, vx, vy, vz);
        this.f_107215_ *= 2.1;
        this.f_107216_ *= 2.1;
        this.f_107217_ *= 2.1;
        this.f_107227_ = 0.9f;
        this.f_107228_ = 1.0f;
        this.f_107229_ = 0.0f;
        this.f_107663_ = 0.2f + this.f_107223_.nextFloat() * 0.1f;
        this.f_107225_ = 10 + this.f_107223_.nextInt(21);
        this.halfLife = this.f_107225_ / 2;
        this.f_107219_ = true;
    }
    
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107431_;
    }
    
    public void m_5744_(final VertexConsumer buffer, final Camera entity, final float partialTicks) {
        this.f_107230_ = this.getGlowBrightness();
        super.m_5744_(buffer, entity, partialTicks);
    }
    
    public void m_5989_() {
        if (this.f_107224_++ >= this.f_107225_) {
            this.m_107274_();
        }
    }
    
    public float getGlowBrightness() {
        final int lifeTime = this.f_107225_ - this.f_107224_;
        if (lifeTime <= this.halfLife) {
            return lifeTime / (float)this.halfLife;
        }
        return Math.max(1.0f - (lifeTime - (float)this.halfLife) / this.halfLife, 0.0f);
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
            final FireflyParticle particle = new FireflyParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.m_108335_(this.spriteSet);
            return (Particle)particle;
        }
    }
}
