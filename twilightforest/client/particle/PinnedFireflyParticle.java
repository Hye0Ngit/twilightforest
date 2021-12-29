// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.core.particles.ParticleOptions;
import javax.annotation.Nullable;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteSet;
import twilightforest.client.particle.data.PinnedFireflyData;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;

public class PinnedFireflyParticle extends FireflyParticle
{
    private final Entity follow;
    
    public PinnedFireflyParticle(final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final Entity e) {
        super(world, x, y, z, vx, vy, vz);
        this.follow = e;
    }
    
    @Override
    public void m_5989_() {
        super.m_5989_();
        this.f_107209_ = this.f_107212_;
        this.f_107210_ = this.f_107213_;
        this.f_107211_ = this.f_107214_;
        this.m_107264_(this.follow.m_20185_(), this.follow.m_20186_(), this.follow.m_20189_());
    }
    
    public static class Factory implements ParticleProvider<PinnedFireflyData>
    {
        private final SpriteSet sprite;
        
        public Factory(final SpriteSet sprite) {
            this.sprite = sprite;
        }
        
        @Nullable
        public Particle createParticle(final PinnedFireflyData data, final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
            final Entity e = world.m_6815_(data.follow);
            if (e == null) {
                return null;
            }
            final PinnedFireflyParticle ret = new PinnedFireflyParticle(world, x, y, z, vx, vy, vz, e);
            ret.m_108335_(this.sprite);
            return (Particle)ret;
        }
    }
}
