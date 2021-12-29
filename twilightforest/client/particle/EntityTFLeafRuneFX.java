// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.world.World;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;

public class EntityTFLeafRuneFX extends EntityEnchantmentTableParticleFX
{
    public EntityTFLeafRuneFX(final World world, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        super(world, x, y, z, velX, velY, velZ);
        this.field_70544_f = this.field_70146_Z.nextFloat() + 1.0f;
        this.field_70547_e += 10;
        this.field_70545_g = 0.003f + this.field_70146_Z.nextFloat() * 0.006f;
        this.field_70145_X = false;
    }
    
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70181_x -= this.field_70545_g;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
    }
}
