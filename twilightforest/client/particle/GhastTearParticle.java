// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.util.IItemProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.client.world.ClientWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.particle.SpriteTexturedParticle;

@OnlyIn(Dist.CLIENT)
public class GhastTearParticle extends SpriteTexturedParticle
{
    GhastTearParticle(final ClientWorld world, final double x, final double y, final double z, final Item item) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.field_217569_E = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_199934_a((IItemProvider)item);
        final float field_70552_h = 1.0f;
        this.field_70551_j = field_70552_h;
        this.field_70553_i = field_70552_h;
        this.field_70552_h = field_70552_h;
        this.field_70544_f = 2.0f;
        this.field_70545_g = 0.6f;
        this.field_70547_e = 20 + this.field_187136_p.nextInt(40);
        this.field_190017_n = true;
    }
    
    public IParticleRenderType func_217558_b() {
        return IParticleRenderType.field_217601_a;
    }
    
    public void func_189213_a() {
        if (this.field_187132_l && this.field_187136_p.nextBoolean()) {
            this.field_187122_b.func_184148_a((PlayerEntity)null, this.field_187126_f, this.field_187127_g + 1.0, this.field_187128_h, TFSounds.TEAR_BREAK, SoundCategory.HOSTILE, 0.5f, 1.0f);
            final ItemStack itemID = new ItemStack((IItemProvider)Items.field_151073_bk);
            for (int i = 0; i < 20; ++i) {
                final double gaussX = this.field_187136_p.nextGaussian() * 0.1;
                final double gaussY = this.field_187136_p.nextGaussian() * 0.2;
                final double gaussZ = this.field_187136_p.nextGaussian() * 0.1;
                this.field_187122_b.func_195594_a((IParticleData)new ItemParticleData(ParticleTypes.field_197591_B, itemID), this.field_187126_f + this.field_187136_p.nextFloat() - this.field_187136_p.nextFloat(), this.field_187127_g + 0.5, this.field_187128_h + this.field_187136_p.nextFloat(), gaussX, gaussY, gaussZ);
                this.field_187122_b.func_195594_a((IParticleData)ParticleTypes.field_197627_t, this.field_187126_f, this.field_187127_g, this.field_187128_h, 0.0, 0.0, 0.0);
            }
            this.func_187112_i();
        }
        super.func_189213_a();
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        public Particle makeParticle(final BasicParticleType typeIn, final ClientWorld worldIn, final double x, final double y, final double z, final double xSpeed, final double ySpeed, final double zSpeed) {
            return (Particle)new GhastTearParticle(worldIn, x, y, z, Items.field_151073_bk);
        }
    }
}
