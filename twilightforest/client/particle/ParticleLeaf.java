// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.particle.Particle;

@SideOnly(Side.CLIENT)
public class ParticleLeaf extends Particle
{
    private final Vec3d target;
    private float rot;
    
    public ParticleLeaf(final World world, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
        this(world, x, y, z, vx, vy, vz, 1.0f);
    }
    
    public ParticleLeaf(final World world, final double x, final double y, final double z, final double vx, final double vy, final double vz, final float scale) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.target = new Vec3d(x, y, z);
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
        this.func_187117_a(Minecraft.func_71410_x().func_147117_R().func_110572_b("twilightforest:particles/fallen_leaf"));
        this.func_189213_a();
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
    
    public void func_180434_a(final BufferBuilder buffer, final Entity entityIn, final float partialTicks, final float rotationX, final float rotationZ, final float rotationYZ, final float rotationXY, final float rotationXZ) {
        this.field_82339_as = Math.min(MathHelper.func_76125_a(this.field_70546_d, 0, 20) / 20.0f, MathHelper.func_76125_a(this.field_70547_e - this.field_70546_d, 0, 20) / 20.0f);
        super.func_180434_a(buffer, entityIn, partialTicks, rotationX, rotationZ + MathHelper.func_76134_b((float)Math.toRadians((this.rot + partialTicks) % 360.0f)), rotationYZ, rotationXY, rotationXZ);
    }
    
    public int func_189214_a(final float partialTicks) {
        return 15728880;
    }
    
    public int func_70537_b() {
        return 1;
    }
}
