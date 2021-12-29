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
import net.minecraft.client.renderer.ActiveRenderInfo;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.SpriteTexturedParticle;

public class FireflyParticle extends SpriteTexturedParticle
{
    private final int halfLife;
    
    FireflyParticle(final ClientWorld world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        super(world, x, y, z, vx, vy, vz);
        this.field_187129_i *= 2.1;
        this.field_187130_j *= 2.1;
        this.field_187131_k *= 2.1;
        this.field_70552_h = 0.9f;
        this.field_70553_i = 1.0f;
        this.field_70551_j = 0.0f;
        this.field_70544_f = 0.2f + this.field_187136_p.nextFloat() * 0.1f;
        this.field_70547_e = 10 + this.field_187136_p.nextInt(21);
        this.halfLife = this.field_70547_e / 2;
        this.field_190017_n = true;
    }
    
    public IParticleRenderType func_217558_b() {
        return IParticleRenderType.field_217603_c;
    }
    
    public void func_225606_a_(final IVertexBuilder buffer, final ActiveRenderInfo entity, final float partialTicks) {
        this.field_82339_as = this.getGlowBrightness();
        super.func_225606_a_(buffer, entity, partialTicks);
    }
    
    public void func_189213_a() {
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_187112_i();
        }
    }
    
    public float getGlowBrightness() {
        final int lifeTime = this.field_70547_e - this.field_70546_d;
        if (lifeTime <= this.halfLife) {
            return lifeTime / (float)this.halfLife;
        }
        return Math.max(1.0f - (lifeTime - (float)this.halfLife) / this.halfLife, 0.0f);
    }
    
    public int func_189214_a(final float partialTicks) {
        return 15728880;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        private final IAnimatedSprite spriteSet;
        
        public Factory(final IAnimatedSprite sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle makeParticle(final BasicParticleType typeIn, final ClientWorld worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final FireflyParticle particle = new FireflyParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.func_217568_a(this.spriteSet);
            return (Particle)particle;
        }
    }
}
