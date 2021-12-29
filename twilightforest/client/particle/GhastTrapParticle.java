// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.util.Mth;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.TextureSheetParticle;

@OnlyIn(Dist.CLIENT)
public class GhastTrapParticle extends TextureSheetParticle
{
    private final float reddustParticleScale;
    private final double originX;
    private final double originY;
    private final double originZ;
    
    GhastTrapParticle(final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        this(world, x, y, z, 3.0f, vx, vy, vz);
    }
    
    GhastTrapParticle(final ClientLevel world, final double x, final double y, final double z, final float scale, final double mx, final double my, final double mz) {
        super(world, x + mx, y + my, z + mz, mx, my, mz);
        this.f_107215_ = mx;
        this.f_107216_ = my;
        this.f_107217_ = mz;
        this.originX = x;
        this.originY = y;
        this.originZ = z;
        final float brightness = (float)Math.random() * 0.4f;
        this.f_107227_ = 1.0f;
        this.f_107228_ = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * brightness;
        this.f_107229_ = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * brightness;
        this.f_107663_ *= 0.75f * scale;
        this.reddustParticleScale = this.f_107663_;
        this.f_107225_ = (int)(10.0 / (Math.random() * 0.8 + 0.2));
        this.f_107219_ = true;
    }
    
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }
    
    public float m_5902_(final float partialTicks) {
        float f6 = (this.f_107224_ + partialTicks) / this.f_107225_ * 32.0f;
        f6 = Mth.m_14036_(f6, 0.0f, 1.0f);
        return this.reddustParticleScale * f6;
    }
    
    public void m_5989_() {
        this.f_107209_ = this.f_107212_;
        this.f_107210_ = this.f_107213_;
        this.f_107211_ = this.f_107214_;
        float proportion = this.f_107224_ / (float)this.f_107225_;
        proportion = 1.0f - proportion;
        this.f_107212_ = this.originX + this.f_107215_ * proportion;
        this.f_107213_ = this.originY + this.f_107216_ * proportion;
        this.f_107214_ = this.originZ + this.f_107217_ * proportion;
        if (this.f_107224_++ >= this.f_107225_) {
            this.m_107274_();
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
            final GhastTrapParticle particle = new GhastTrapParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.m_108339_(this.spriteSet);
            return (Particle)particle;
        }
    }
}
