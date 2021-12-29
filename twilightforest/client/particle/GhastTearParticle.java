// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.TextureSheetParticle;

@OnlyIn(Dist.CLIENT)
public class GhastTearParticle extends TextureSheetParticle
{
    GhastTearParticle(final ClientLevel world, final double x, final double y, final double z, final Item item) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.f_108321_ = Minecraft.m_91087_().m_91291_().m_115103_().m_109401_((ItemLike)item);
        final float f_107227_ = 1.0f;
        this.f_107229_ = f_107227_;
        this.f_107228_ = f_107227_;
        this.f_107227_ = f_107227_;
        this.f_107663_ = 2.0f;
        this.f_107226_ = 0.6f;
        this.f_107225_ = 20 + this.f_107223_.nextInt(40);
        this.f_107219_ = true;
    }
    
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107429_;
    }
    
    public void m_5989_() {
        if (this.f_107218_ && this.f_107223_.nextBoolean()) {
            this.f_107208_.m_6263_((Player)null, this.f_107212_, this.f_107213_ + 1.0, this.f_107214_, TFSounds.TEAR_BREAK, SoundSource.HOSTILE, 0.5f, 1.0f);
            final ItemStack itemID = new ItemStack((ItemLike)Items.f_42586_);
            for (int i = 0; i < 20; ++i) {
                final double gaussX = this.f_107223_.nextGaussian() * 0.1;
                final double gaussY = this.f_107223_.nextGaussian() * 0.2;
                final double gaussZ = this.f_107223_.nextGaussian() * 0.1;
                this.f_107208_.m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, itemID), this.f_107212_ + this.f_107223_.nextFloat() - this.f_107223_.nextFloat(), this.f_107213_ + 0.5, this.f_107214_ + this.f_107223_.nextFloat(), gaussX, gaussY, gaussZ);
                this.f_107208_.m_7106_((ParticleOptions)ParticleTypes.f_123813_, this.f_107212_, this.f_107213_, this.f_107214_, 0.0, 0.0, 0.0);
            }
            this.m_107274_();
        }
        super.m_5989_();
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType>
    {
        public Particle createParticle(final SimpleParticleType typeIn, final ClientLevel worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            return (Particle)new GhastTearParticle(worldIn, x, y, z, Items.f_42586_);
        }
    }
}
