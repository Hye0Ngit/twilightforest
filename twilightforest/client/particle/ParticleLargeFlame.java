// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.particle.Particle;

@SideOnly(Side.CLIENT)
public class ParticleLargeFlame extends Particle
{
    private float flameScale;
    
    public ParticleLargeFlame(final World world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        super(world, x, y, z, vx, vy, vz);
        this.field_187129_i = this.field_187129_i * 0.009999999776482582 + vx;
        this.field_187130_j = this.field_187130_j * 0.009999999776482582 + vy;
        this.field_187131_k = this.field_187131_k * 0.009999999776482582 + vz;
        this.field_70544_f *= 5.0;
        this.flameScale = this.field_70544_f;
        final float field_70552_h = 1.0f;
        this.field_70551_j = field_70552_h;
        this.field_70553_i = field_70552_h;
        this.field_70552_h = field_70552_h;
        this.field_70547_e = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.func_70536_a(48);
    }
    
    public void func_180434_a(final BufferBuilder buffer, final Entity entity, final float partialTicks, final float rotationX, final float rotationZ, final float rotationYZ, final float rotationXY, final float rotationXZ) {
        final float var8 = (this.field_70546_d + partialTicks) / this.field_70547_e;
        this.field_70544_f = this.flameScale * (1.0f - var8 * var8 * 0.5f);
        super.func_180434_a(buffer, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
    
    public int func_189214_a(final float partialTicks) {
        float var2 = (this.field_70546_d + partialTicks) / this.field_70547_e;
        if (var2 < 0.0f) {
            var2 = 0.0f;
        }
        if (var2 > 1.0f) {
            var2 = 1.0f;
        }
        final int var3 = super.func_189214_a(partialTicks);
        int var4 = var3 & 0xFF;
        final int var5 = var3 >> 16 & 0xFF;
        var4 += (int)(var2 * 15.0f * 16.0f);
        if (var4 > 240) {
            var4 = 240;
        }
        return var4 | var5 << 16;
    }
    
    public void func_189213_a() {
        this.field_187123_c = this.field_187126_f;
        this.field_187124_d = this.field_187127_g;
        this.field_187125_e = this.field_187128_h;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_187112_i();
        }
        this.field_187130_j += 0.004;
        this.func_187110_a(this.field_187129_i, this.field_187130_j, this.field_187131_k);
        this.field_187129_i *= 0.9599999785423279;
        this.field_187130_j *= 0.9599999785423279;
        this.field_187131_k *= 0.9599999785423279;
        if (this.field_187132_l) {
            this.field_187129_i *= 0.699999988079071;
            this.field_187131_k *= 0.699999988079071;
        }
    }
}
