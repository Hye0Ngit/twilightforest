// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.core.particles.ParticleOptions;
import java.util.Random;
import net.minecraft.client.particle.Particle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.Camera;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LightLayer;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.TextureSheetParticle;

public class WanderingFireflyParticle extends TextureSheetParticle
{
    private final int halfLife;
    private final boolean fromJar;
    
    public WanderingFireflyParticle(final ClientLevel level, final double posX, final double posY, final double posZ, final float movementX, final float movementY, final float movementZ, final double additionalX, final double additionalY, final double additionalZ, final SpriteSet set, final boolean fromJar) {
        super(level, posX, posY, posZ, 0.0, 0.0, 0.0);
        this.f_107215_ *= movementX;
        this.f_107216_ *= movementY;
        this.f_107217_ *= movementZ;
        this.f_107215_ += additionalX;
        this.f_107216_ += additionalY;
        this.f_107217_ += additionalZ;
        this.f_107227_ = 0.9f;
        this.f_107228_ = 1.0f;
        this.f_107229_ = 0.0f;
        this.m_108335_(set);
        this.f_107663_ = 0.2f + this.f_107223_.nextFloat() * 0.1f;
        this.f_107225_ = 30 + this.f_107223_.nextInt(21);
        this.halfLife = this.f_107225_ / 2;
        this.f_172259_ = true;
        this.f_107219_ = true;
        this.fromJar = fromJar;
    }
    
    public void m_5989_() {
        if (!this.fromJar && this.f_107208_.m_45517_(LightLayer.SKY, new BlockPos(this.f_107212_, this.f_107213_, this.f_107214_)) < 1) {
            this.m_107274_();
        }
        super.m_5989_();
    }
    
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107431_;
    }
    
    public void m_5744_(final VertexConsumer buffer, final Camera entity, final float partialTicks) {
        this.f_107230_ = this.getGlowBrightness();
        super.m_5744_(buffer, entity, partialTicks);
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
        
        public Particle createParticle(final SimpleParticleType type, final ClientLevel world, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final Random rand = world.f_46441_;
            final double speedX = rand.nextFloat() * (rand.nextBoolean() ? -3.9 : 3.9) * rand.nextFloat() * 0.1;
            final double speedY = rand.nextFloat() * -0.25 * rand.nextFloat() * 0.1;
            final double speedZ = rand.nextFloat() * (rand.nextBoolean() ? -3.9 : 3.9) * rand.nextFloat() * 0.1;
            return (Particle)new WanderingFireflyParticle(world, x, y, z, 0.1f, 0.1f, 0.1f, speedX, speedY, speedZ, this.spriteSet, false);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class FromJarFactory implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;
        
        public FromJarFactory(final SpriteSet sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle createParticle(final SimpleParticleType type, final ClientLevel world, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final Random rand = world.f_46441_;
            final double speedX = rand.nextFloat() * (rand.nextBoolean() ? -3.9 : 3.9) * rand.nextFloat() * 0.1;
            final double speedY = rand.nextFloat() * -0.25 * rand.nextFloat() * 0.1;
            final double speedZ = rand.nextFloat() * (rand.nextBoolean() ? -3.9 : 3.9) * rand.nextFloat() * 0.1;
            return (Particle)new WanderingFireflyParticle(world, x, y, z, 0.1f, 0.1f, 0.1f, speedX, speedY, speedZ, this.spriteSet, true);
        }
    }
}
