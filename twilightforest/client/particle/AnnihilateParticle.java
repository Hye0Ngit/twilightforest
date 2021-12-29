// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.particles.IParticleData;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.world.ClientWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.SpriteTexturedParticle;

@OnlyIn(Dist.CLIENT)
public class AnnihilateParticle extends SpriteTexturedParticle
{
    float initialParticleScale;
    
    public AnnihilateParticle(final ClientWorld world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final float scale) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.field_187129_i *= 0.10000000149011612;
        this.field_187130_j *= 0.10000000149011612;
        this.field_187131_k *= 0.10000000149011612;
        this.field_187129_i += vx * 0.4;
        this.field_187130_j += vy * 0.4;
        this.field_187131_k += vz * 0.4;
        final float field_70552_h = 1.0f;
        this.field_70551_j = field_70552_h;
        this.field_70553_i = field_70552_h;
        this.field_70552_h = field_70552_h;
        this.field_70544_f *= 0.75f;
        this.field_70544_f *= scale;
        this.initialParticleScale = this.field_70544_f;
        this.field_70547_e = (int)(60.0 / (Math.random() * 0.8 + 0.6));
        this.field_70547_e *= (int)scale;
        this.field_190017_n = true;
    }
    
    public IParticleRenderType func_217558_b() {
        return IParticleRenderType.field_217602_b;
    }
    
    public void func_189213_a() {
        this.field_187123_c = this.field_187126_f;
        this.field_187124_d = this.field_187127_g;
        this.field_187125_e = this.field_187128_h;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_187112_i();
        }
        this.func_187110_a(this.field_187129_i, this.field_187130_j, this.field_187131_k);
        this.field_187129_i *= 0.9599999785423279;
        this.field_187130_j *= 0.9599999785423279;
        this.field_187131_k *= 0.9599999785423279;
        if (this.field_187132_l) {
            this.field_187129_i *= 0.699999988079071;
            this.field_187131_k *= 0.699999988079071;
        }
        this.field_70544_f *= (float)0.97;
        if (this.field_70544_f < 0.04f) {
            this.func_187112_i();
        }
        final float blacken = 0.985f;
        this.field_70552_h *= blacken;
        this.field_70553_i *= blacken;
        this.field_70551_j *= blacken;
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
            final AnnihilateParticle particle = new AnnihilateParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, 0.75f);
            particle.func_217568_a(this.spriteSet);
            return (Particle)particle;
        }
    }
}
