// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.particles.IParticleData;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.world.ClientWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.SpriteTexturedParticle;

@OnlyIn(Dist.CLIENT)
public class GhastTrapParticle extends SpriteTexturedParticle
{
    private final float reddustParticleScale;
    private final double originX;
    private final double originY;
    private final double originZ;
    
    GhastTrapParticle(final ClientWorld world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        this(world, x, y, z, 3.0f, vx, vy, vz);
    }
    
    GhastTrapParticle(final ClientWorld world, final double x, final double y, final double z, final float scale, final double mx, final double my, final double mz) {
        super(world, x + mx, y + my, z + mz, mx, my, mz);
        this.field_187129_i = mx;
        this.field_187130_j = my;
        this.field_187131_k = mz;
        this.originX = x;
        this.originY = y;
        this.originZ = z;
        final float brightness = (float)Math.random() * 0.4f;
        this.field_70552_h = 1.0f;
        this.field_70553_i = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * brightness;
        this.field_70551_j = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * brightness;
        this.field_70544_f *= 0.75f * scale;
        this.reddustParticleScale = this.field_70544_f;
        this.field_70547_e = (int)(10.0 / (Math.random() * 0.8 + 0.2));
        this.field_190017_n = true;
    }
    
    public IParticleRenderType func_217558_b() {
        return IParticleRenderType.field_217602_b;
    }
    
    public float func_217561_b(final float partialTicks) {
        float f6 = (this.field_70546_d + partialTicks) / this.field_70547_e * 32.0f;
        f6 = MathHelper.func_76131_a(f6, 0.0f, 1.0f);
        return this.reddustParticleScale * f6;
    }
    
    public void func_189213_a() {
        this.field_187123_c = this.field_187126_f;
        this.field_187124_d = this.field_187127_g;
        this.field_187125_e = this.field_187128_h;
        float proportion = this.field_70546_d / (float)this.field_70547_e;
        proportion = 1.0f - proportion;
        this.field_187126_f = this.originX + this.field_187129_i * proportion;
        this.field_187127_g = this.originY + this.field_187130_j * proportion;
        this.field_187128_h = this.originZ + this.field_187131_k * proportion;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_187112_i();
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        private final IAnimatedSprite spriteSet;
        
        public Factory(final IAnimatedSprite sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle makeParticle(final BasicParticleType typeIn, final ClientWorld worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final GhastTrapParticle particle = new GhastTrapParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.func_217566_b(this.spriteSet);
            return (Particle)particle;
        }
    }
}
