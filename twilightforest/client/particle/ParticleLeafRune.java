// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.world.World;
import net.minecraft.client.particle.ParticleEnchantmentTable;

public class ParticleLeafRune extends ParticleEnchantmentTable
{
    public ParticleLeafRune(final World world, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        super(world, x, y, z, velX, velY, velZ);
        this.field_70544_f = this.field_187136_p.nextFloat() + 1.0f;
        this.field_70547_e += 10;
        this.field_70545_g = 0.003f + this.field_187136_p.nextFloat() * 0.006f;
        this.field_190017_n = true;
    }
    
    public void func_189213_a() {
        this.field_187123_c = this.field_187126_f;
        this.field_187124_d = this.field_187127_g;
        this.field_187125_e = this.field_187128_h;
        this.func_187110_a(this.field_187129_i, this.field_187130_j, this.field_187131_k);
        this.field_187130_j -= this.field_70545_g;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_187112_i();
        }
    }
}
