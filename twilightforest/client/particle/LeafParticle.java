// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteSet;
import twilightforest.client.particle.data.LeafParticleData;
import net.minecraft.client.particle.ParticleProvider;
import com.mojang.math.Vector3f;
import com.mojang.math.Quaternion;
import net.minecraft.util.Mth;
import net.minecraft.client.Camera;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.TextureSheetParticle;

@OnlyIn(Dist.CLIENT)
public class LeafParticle extends TextureSheetParticle
{
    private final Vec3 target;
    private float rot;
    
    LeafParticle(final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        this(world, x, y, z, vx, vy, vz, 1.0f);
    }
    
    LeafParticle(final ClientLevel world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final float scale) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.target = new Vec3(x, y, z);
        this.f_107215_ *= 0.10000000149011612;
        this.f_107216_ *= 0.10000000149011612;
        this.f_107217_ *= 0.10000000149011612;
        this.f_107215_ += vx * 0.4;
        this.f_107216_ += vy * 0.4;
        this.f_107217_ += vz * 0.4;
        final float f_107227_ = 1.0f;
        this.f_107229_ = f_107227_;
        this.f_107228_ = f_107227_;
        this.f_107227_ = f_107227_;
        this.f_107230_ = 0.0f;
        this.f_107663_ *= 0.75f * (this.f_107223_.nextBoolean() ? -1.0f : 1.0f);
        this.f_107663_ *= scale;
        this.f_107225_ = 160 + (int)(this.f_107223_.nextFloat() * 30.0f);
        this.f_107225_ *= (int)scale;
        this.f_107219_ = true;
        final float n = this.f_107223_.nextFloat() * 2.0f - 1.0f;
        this.f_107231_ = n;
        this.f_107204_ = n;
    }
    
    public ParticleRenderType m_7556_() {
        return ParticleRenderType.f_107430_;
    }
    
    public void m_5989_() {
        this.f_107209_ = this.f_107212_;
        this.f_107210_ = this.f_107213_;
        this.f_107211_ = this.f_107214_;
        if (this.f_107224_++ >= this.f_107225_) {
            this.m_107274_();
        }
        this.m_6257_(this.f_107215_, this.f_107216_, this.f_107217_);
        this.f_107216_ *= 0.699999988079071;
        this.f_107216_ -= 0.019999999552965164;
        if (this.f_107218_) {
            this.f_107215_ *= 0.699999988079071;
            this.f_107217_ *= 0.699999988079071;
        }
        else {
            this.rot += 5.0f;
            if (this.f_107215_ == 0.0) {
                this.f_107215_ += (this.f_107223_.nextBoolean() ? 1 : -1) * 0.001f;
            }
            if (this.f_107217_ == 0.0) {
                this.f_107217_ += (this.f_107223_.nextBoolean() ? 1 : -1) * 0.001f;
            }
            if (this.f_107223_.nextInt(5) == 0) {
                this.f_107215_ += Math.signum(this.target.f_82479_ - this.f_107212_) * this.f_107223_.nextFloat() * 0.004999999888241291;
            }
            if (this.f_107223_.nextInt(5) == 0) {
                this.f_107217_ += Math.signum(this.target.f_82481_ - this.f_107214_) * this.f_107223_.nextFloat() * 0.004999999888241291;
            }
        }
    }
    
    public void m_5744_(final VertexConsumer buffer, final Camera entity, final float partialTicks) {
        this.f_107230_ = Math.min(Mth.m_14045_(this.f_107224_, 0, 20) / 20.0f, Mth.m_14045_(this.f_107225_ - this.f_107224_, 0, 20) / 20.0f);
        final Vec3 lvt_4_1_ = entity.m_90583_();
        final float lvt_5_1_ = (float)(Mth.m_14139_((double)partialTicks, this.f_107209_, this.f_107212_) - lvt_4_1_.m_7096_());
        final float lvt_6_1_ = (float)(Mth.m_14139_((double)partialTicks, this.f_107210_, this.f_107213_) - lvt_4_1_.m_7098_());
        final float lvt_7_1_ = (float)(Mth.m_14139_((double)partialTicks, this.f_107211_, this.f_107214_) - lvt_4_1_.m_7094_());
        final Quaternion lvt_8_2_ = new Quaternion(entity.m_90591_());
        if (this.f_107231_ != 0.0f) {
            final float lvt_9_1_ = Mth.m_14179_(partialTicks, this.f_107204_, this.f_107231_);
            lvt_8_2_.m_80148_(Vector3f.f_122227_.m_122270_(lvt_9_1_));
        }
        lvt_8_2_.m_80148_(Vector3f.f_122225_.m_122270_(Mth.m_14089_((float)Math.toRadians(this.rot % 360.0f))));
        final Vector3f lvt_9_2_ = new Vector3f(-1.0f, -1.0f, 0.0f);
        lvt_9_2_.m_122251_(lvt_8_2_);
        final Vector3f[] lvt_10_1_ = { new Vector3f(-1.0f, -1.0f, 0.0f), new Vector3f(-1.0f, 1.0f, 0.0f), new Vector3f(1.0f, 1.0f, 0.0f), new Vector3f(1.0f, -1.0f, 0.0f) };
        final float lvt_11_1_ = this.m_5902_(partialTicks);
        for (int lvt_12_1_ = 0; lvt_12_1_ < 4; ++lvt_12_1_) {
            final Vector3f lvt_13_1_ = lvt_10_1_[lvt_12_1_];
            lvt_13_1_.m_122251_(lvt_8_2_);
            lvt_13_1_.m_122261_(lvt_11_1_);
            lvt_13_1_.m_122272_(lvt_5_1_, lvt_6_1_, lvt_7_1_);
        }
        final float lvt_12_2_ = this.m_5970_();
        final float lvt_13_2_ = this.m_5952_();
        final float lvt_14_1_ = this.m_5951_();
        final float lvt_15_1_ = this.m_5950_();
        final int lvt_16_1_ = this.m_6355_(partialTicks);
        buffer.m_5483_((double)lvt_10_1_[0].m_122239_(), (double)lvt_10_1_[0].m_122260_(), (double)lvt_10_1_[0].m_122269_()).m_7421_(lvt_13_2_, lvt_15_1_).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(lvt_16_1_).m_5752_();
        buffer.m_5483_((double)lvt_10_1_[1].m_122239_(), (double)lvt_10_1_[1].m_122260_(), (double)lvt_10_1_[1].m_122269_()).m_7421_(lvt_13_2_, lvt_14_1_).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(lvt_16_1_).m_5752_();
        buffer.m_5483_((double)lvt_10_1_[2].m_122239_(), (double)lvt_10_1_[2].m_122260_(), (double)lvt_10_1_[2].m_122269_()).m_7421_(lvt_12_2_, lvt_14_1_).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(lvt_16_1_).m_5752_();
        buffer.m_5483_((double)lvt_10_1_[3].m_122239_(), (double)lvt_10_1_[3].m_122260_(), (double)lvt_10_1_[3].m_122269_()).m_7421_(lvt_12_2_, lvt_15_1_).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(lvt_16_1_).m_5752_();
    }
    
    public int m_6355_(final float partialTicks) {
        return 15728880;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<LeafParticleData>
    {
        private final SpriteSet spriteSet;
        
        public Factory(final SpriteSet sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle createParticle(final LeafParticleData data, final ClientLevel world, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final LeafParticle particle = new LeafParticle(world, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.m_107253_(data.r / 255.0f, data.g / 255.0f, data.b / 255.0f);
            particle.m_108335_(this.spriteSet);
            return (Particle)particle;
        }
    }
}
