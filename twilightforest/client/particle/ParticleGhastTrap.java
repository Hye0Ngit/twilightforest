// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.particle.Particle;

@SideOnly(Side.CLIENT)
public class ParticleGhastTrap extends Particle
{
    float reddustParticleScale;
    private double originX;
    private double originY;
    private double originZ;
    
    public ParticleGhastTrap(final World world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        this(world, x, y, z, 3.0f, vx, vy, vz);
    }
    
    public ParticleGhastTrap(final World world, final double x, final double y, final double z, final float scale, final double mx, final double my, final double mz) {
        super(world, x + mx, y + my, z + mz, mx, my, mz);
        this.field_187129_i = mx;
        this.field_187130_j = my;
        this.field_187131_k = mz;
        this.originX = x;
        this.originY = y;
        this.originZ = z;
        final float brightness = (float)Math.random() * 0.4f;
        this.field_70553_i = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * brightness;
        this.field_70551_j = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * brightness;
        this.field_70552_h = 1.0f;
        this.field_70544_f *= 0.75f;
        this.field_70544_f *= scale;
        this.reddustParticleScale = this.field_70544_f;
        this.field_70547_e = (int)(10.0 / (Math.random() * 0.8 + 0.2));
        this.field_190017_n = true;
    }
    
    public void func_180434_a(final BufferBuilder buffer, final Entity entity, final float partialTicks, final float rotationX, final float rotationZ, final float rotationYZ, final float rotationXY, final float rotationXZ) {
        float f6 = (this.field_70546_d + partialTicks) / this.field_70547_e * 32.0f;
        f6 = MathHelper.func_76131_a(f6, 0.0f, 1.0f);
        this.field_70544_f = this.reddustParticleScale * f6;
        super.func_180434_a(buffer, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
    
    public void func_189213_a() {
        this.func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
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
}
