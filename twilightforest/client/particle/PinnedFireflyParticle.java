// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.particles.IParticleData;
import javax.annotation.Nullable;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.IAnimatedSprite;
import twilightforest.client.particle.data.PinnedFireflyData;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;

public class PinnedFireflyParticle extends FireflyParticle
{
    private final Entity follow;
    
    public PinnedFireflyParticle(final ClientWorld world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final Entity e) {
        super(world, x, y, z, vx, vy, vz);
        this.follow = e;
    }
    
    @Override
    public void func_189213_a() {
        super.func_189213_a();
        this.field_187123_c = this.field_187126_f;
        this.field_187124_d = this.field_187127_g;
        this.field_187125_e = this.field_187128_h;
        this.func_187109_b(this.follow.func_226277_ct_(), this.follow.func_226278_cu_(), this.follow.func_226281_cx_());
    }
    
    public static class Factory implements IParticleFactory<PinnedFireflyData>
    {
        private final IAnimatedSprite sprite;
        
        public Factory(final IAnimatedSprite sprite) {
            this.sprite = sprite;
        }
        
        @Nullable
        public Particle makeParticle(final PinnedFireflyData data, final ClientWorld world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
            final Entity e = world.func_73045_a(data.follow);
            if (e == null) {
                return null;
            }
            final PinnedFireflyParticle ret = new PinnedFireflyParticle(world, x, y, z, vx, vy, vz, e);
            ret.func_217568_a(this.sprite);
            return (Particle)ret;
        }
    }
}
