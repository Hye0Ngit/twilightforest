// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.client.particle.Particle;

public class ParticleFirefly extends Particle
{
    private int lifeTime;
    private int halfLife;
    
    public ParticleFirefly(final World world, final double x, final double y, final double z, final double f, final double f1, final double f2) {
        this(world, x, y, z, 1.0f, f, f1, f2);
    }
    
    public ParticleFirefly(final World world, final double x, final double y, final double z, final float f, final double f1, final double f2, final double f3) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.field_187129_i *= 2.100000001490116;
        this.field_187130_j *= 2.100000001490116;
        this.field_187131_k *= 2.100000001490116;
        final float n = 1.0f * f;
        this.field_70553_i = n;
        this.field_70552_h = n;
        this.field_70552_h *= 0.9f;
        this.field_70551_j = 0.0f;
        this.field_70544_f = 1.0f + this.field_187136_p.nextFloat() * 0.6f;
        this.field_70544_f *= f;
        final int n2 = 10 + this.field_187136_p.nextInt(21);
        this.field_70547_e = n2;
        this.lifeTime = n2;
        this.field_70547_e *= (int)f;
        this.halfLife = this.lifeTime / 2;
        this.field_190017_n = true;
        this.func_187117_a(Minecraft.func_71410_x().func_147117_R().func_110572_b("twilightforest:particles/firefly"));
    }
    
    public void func_180434_a(final BufferBuilder buffer, final Entity entity, final float partialTicks, final float rotationX, final float rotationZ, final float rotationYZ, final float rotationXY, final float rotationXZ) {
        this.field_82339_as = this.getGlowBrightness();
        super.func_180434_a(buffer, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
    
    public void func_189213_a() {
        if (this.lifeTime <= 1) {
            this.func_187112_i();
        }
        else {
            --this.lifeTime;
        }
    }
    
    public float getGlowBrightness() {
        if (this.lifeTime <= this.halfLife) {
            return this.lifeTime / (float)this.halfLife;
        }
        return Math.max(1.0f - (this.lifeTime - (float)this.halfLife) / this.halfLife, 0.0f);
    }
    
    public int func_189214_a(final float partialTicks) {
        return 15728880;
    }
    
    public int func_70537_b() {
        return 1;
    }
}
