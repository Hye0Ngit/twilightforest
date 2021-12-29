// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.particles.IParticleData;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.IAnimatedSprite;
import twilightforest.client.particle.data.LeafParticleData;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.ActiveRenderInfo;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.SpriteTexturedParticle;

@OnlyIn(Dist.CLIENT)
public class LeafParticle extends SpriteTexturedParticle
{
    private final Vector3d target;
    private float rot;
    
    LeafParticle(final ClientWorld world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        this(world, x, y, z, vx, vy, vz, 1.0f);
    }
    
    LeafParticle(final ClientWorld world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final float scale) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.target = new Vector3d(x, y, z);
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
        this.field_82339_as = 0.0f;
        this.field_70544_f *= 0.75f * (this.field_187136_p.nextBoolean() ? -1.0f : 1.0f);
        this.field_70544_f *= scale;
        this.field_70547_e = 160 + (int)(this.field_187136_p.nextFloat() * 30.0f);
        this.field_70547_e *= (int)scale;
        this.field_190017_n = true;
        final float n = this.field_187136_p.nextFloat() * 2.0f - 1.0f;
        this.field_190014_F = n;
        this.field_190015_G = n;
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
        this.field_187130_j *= 0.699999988079071;
        this.field_187130_j -= 0.019999999552965164;
        if (this.field_187132_l) {
            this.field_187129_i *= 0.699999988079071;
            this.field_187131_k *= 0.699999988079071;
        }
        else {
            this.rot += 5.0f;
            if (this.field_187129_i == 0.0) {
                this.field_187129_i += (this.field_187136_p.nextBoolean() ? 1 : -1) * 0.001f;
            }
            if (this.field_187131_k == 0.0) {
                this.field_187131_k += (this.field_187136_p.nextBoolean() ? 1 : -1) * 0.001f;
            }
            if (this.field_187136_p.nextInt(5) == 0) {
                this.field_187129_i += Math.signum(this.target.field_72450_a - this.field_187126_f) * this.field_187136_p.nextFloat() * 0.004999999888241291;
            }
            if (this.field_187136_p.nextInt(5) == 0) {
                this.field_187131_k += Math.signum(this.target.field_72449_c - this.field_187128_h) * this.field_187136_p.nextFloat() * 0.004999999888241291;
            }
        }
    }
    
    public void func_225606_a_(final IVertexBuilder buffer, final ActiveRenderInfo entity, final float partialTicks) {
        this.field_82339_as = Math.min(MathHelper.func_76125_a(this.field_70546_d, 0, 20) / 20.0f, MathHelper.func_76125_a(this.field_70547_e - this.field_70546_d, 0, 20) / 20.0f);
        final Vector3d lvt_4_1_ = entity.func_216785_c();
        final float lvt_5_1_ = (float)(MathHelper.func_219803_d((double)partialTicks, this.field_187123_c, this.field_187126_f) - lvt_4_1_.func_82615_a());
        final float lvt_6_1_ = (float)(MathHelper.func_219803_d((double)partialTicks, this.field_187124_d, this.field_187127_g) - lvt_4_1_.func_82617_b());
        final float lvt_7_1_ = (float)(MathHelper.func_219803_d((double)partialTicks, this.field_187125_e, this.field_187128_h) - lvt_4_1_.func_82616_c());
        final Quaternion lvt_8_2_ = new Quaternion(entity.func_227995_f_());
        if (this.field_190014_F != 0.0f) {
            final float lvt_9_1_ = MathHelper.func_219799_g(partialTicks, this.field_190015_G, this.field_190014_F);
            lvt_8_2_.func_195890_a(Vector3f.field_229183_f_.func_229193_c_(lvt_9_1_));
        }
        lvt_8_2_.func_195890_a(Vector3f.field_229181_d_.func_229193_c_(MathHelper.func_76134_b((float)Math.toRadians(this.rot % 360.0f))));
        final Vector3f lvt_9_2_ = new Vector3f(-1.0f, -1.0f, 0.0f);
        lvt_9_2_.func_214905_a(lvt_8_2_);
        final Vector3f[] lvt_10_1_ = { new Vector3f(-1.0f, -1.0f, 0.0f), new Vector3f(-1.0f, 1.0f, 0.0f), new Vector3f(1.0f, 1.0f, 0.0f), new Vector3f(1.0f, -1.0f, 0.0f) };
        final float lvt_11_1_ = this.func_217561_b(partialTicks);
        for (int lvt_12_1_ = 0; lvt_12_1_ < 4; ++lvt_12_1_) {
            final Vector3f lvt_13_1_ = lvt_10_1_[lvt_12_1_];
            lvt_13_1_.func_214905_a(lvt_8_2_);
            lvt_13_1_.func_195898_a(lvt_11_1_);
            lvt_13_1_.func_195904_b(lvt_5_1_, lvt_6_1_, lvt_7_1_);
        }
        final float lvt_12_2_ = this.func_217563_c();
        final float lvt_13_2_ = this.func_217564_d();
        final float lvt_14_1_ = this.func_217562_e();
        final float lvt_15_1_ = this.func_217560_f();
        final int lvt_16_1_ = this.func_189214_a(partialTicks);
        buffer.func_225582_a_((double)lvt_10_1_[0].func_195899_a(), (double)lvt_10_1_[0].func_195900_b(), (double)lvt_10_1_[0].func_195902_c()).func_225583_a_(lvt_13_2_, lvt_15_1_).func_227885_a_(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as).func_227886_a_(lvt_16_1_).func_181675_d();
        buffer.func_225582_a_((double)lvt_10_1_[1].func_195899_a(), (double)lvt_10_1_[1].func_195900_b(), (double)lvt_10_1_[1].func_195902_c()).func_225583_a_(lvt_13_2_, lvt_14_1_).func_227885_a_(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as).func_227886_a_(lvt_16_1_).func_181675_d();
        buffer.func_225582_a_((double)lvt_10_1_[2].func_195899_a(), (double)lvt_10_1_[2].func_195900_b(), (double)lvt_10_1_[2].func_195902_c()).func_225583_a_(lvt_12_2_, lvt_14_1_).func_227885_a_(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as).func_227886_a_(lvt_16_1_).func_181675_d();
        buffer.func_225582_a_((double)lvt_10_1_[3].func_195899_a(), (double)lvt_10_1_[3].func_195900_b(), (double)lvt_10_1_[3].func_195902_c()).func_225583_a_(lvt_12_2_, lvt_15_1_).func_227885_a_(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as).func_227886_a_(lvt_16_1_).func_181675_d();
    }
    
    public int func_189214_a(final float partialTicks) {
        return 15728880;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<LeafParticleData>
    {
        private final IAnimatedSprite spriteSet;
        
        public Factory(final IAnimatedSprite sprite) {
            this.spriteSet = sprite;
        }
        
        public Particle makeParticle(final LeafParticleData data, final ClientWorld world, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            final LeafParticle particle = new LeafParticle(world, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.func_70538_b(data.r / 255.0f, data.g / 255.0f, data.b / 255.0f);
            particle.func_217568_a(this.spriteSet);
            return (Particle)particle;
        }
    }
}
