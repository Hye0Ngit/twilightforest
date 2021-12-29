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
public class LargeFlameParticle extends TextureSheetParticle
{
    private final float flameScale;
    
    LargeFlameParticle(final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        super(world, x, y, z, vx, vy, vz);
        this.f_107215_ = this.f_107215_ * 0.009999999776482582 + vx;
        this.f_107216_ = this.f_107216_ * 0.009999999776482582 + vy;
        this.f_107217_ = this.f_107217_ * 0.009999999776482582 + vz;
        this.f_107663_ *= 5.0;
        this.flameScale = this.f_107663_;
        final float f_107227_ = 1.0f;
        this.f_107229_ = f_107227_;
        this.f_107228_ = f_107227_;
        this.f_107227_ = f_107227_;
        this.f_107225_ = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.f_107219_ = false;
    }
    
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }
    
    public float m_5902_(final float partialTicks) {
        final float relativeAge = (this.f_107224_ + partialTicks) / this.f_107225_;
        return this.flameScale * (1.0f - relativeAge * relativeAge * 0.5f);
    }
    
    public int m_6355_(final float partialTicks) {
        float var2 = (this.f_107224_ + partialTicks) / this.f_107225_;
        if (var2 < 0.0f) {
            var2 = 0.0f;
        }
        if (var2 > 1.0f) {
            var2 = 1.0f;
        }
        final int var3 = super.m_6355_(partialTicks);
        int var4 = var3 & 0xFF;
        final int var5 = var3 >> 16 & 0xFF;
        var4 += (int)(var2 * 15.0f * 16.0f);
        if (var4 > 240) {
            var4 = 240;
        }
        return var4 | var5 << 16;
    }
    
    public void m_5989_() {
        this.f_107209_ = this.f_107212_;
        this.f_107210_ = this.f_107213_;
        this.f_107211_ = this.f_107214_;
        if (this.f_107224_++ >= this.f_107225_) {
            this.m_107274_();
        }
        this.f_107216_ += 0.004;
        this.m_6257_(this.f_107215_, this.f_107216_, this.f_107217_);
        this.f_107215_ *= 0.9599999785423279;
        this.f_107216_ *= 0.9599999785423279;
        this.f_107217_ *= 0.9599999785423279;
        if (this.f_107218_) {
            this.f_107215_ *= 0.699999988079071;
            this.f_107217_ *= 0.699999988079071;
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;
        
        public Factory(final SpriteSet sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle createParticle(final SimpleParticleType typeIn, final ClientLevel worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final LargeFlameParticle particle = new LargeFlameParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.m_108335_(this.spriteSet);
            return (Particle)particle;
        }
    }
}
