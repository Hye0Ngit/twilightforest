// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;

@SideOnly(Side.CLIENT)
public class EntityTFGhastTrapFX extends EntityFX
{
    float reddustParticleScale;
    private double originX;
    private double originY;
    private double originZ;
    
    public EntityTFGhastTrapFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par9, final double par10) {
        this(par1World, par2, par4, par6, 3.0f, par8, par9, par10);
    }
    
    public EntityTFGhastTrapFX(final World par1World, final double x, final double y, final double z, final float scale, final double mx, final double my, final double mz) {
        super(par1World, x + mx, y + my, z + mz, mx, my, mz);
        this.field_70159_w = mx;
        this.field_70181_x = my;
        this.field_70179_y = mz;
        this.originX = x;
        this.originY = y;
        this.originZ = z;
        final float f4 = (float)Math.random() * 0.4f;
        this.field_70553_i = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * f4;
        this.field_70551_j = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * f4;
        this.field_70552_h = 1.0f;
        this.field_70544_f *= 0.75f;
        this.field_70544_f *= scale;
        this.reddustParticleScale = this.field_70544_f;
        this.field_70547_e = (int)(10.0 / (Math.random() * 0.8 + 0.2));
        this.field_70145_X = false;
    }
    
    public void func_70539_a(final Tessellator par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        float f6 = (this.field_70546_d + par2) / this.field_70547_e * 32.0f;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.field_70544_f = this.reddustParticleScale * f6;
        super.func_70539_a(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }
    
    public void func_70071_h_() {
        this.func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        float proportion = this.field_70546_d / (float)this.field_70547_e;
        proportion = 1.0f - proportion;
        this.field_70165_t = this.originX + this.field_70159_w * proportion;
        this.field_70163_u = this.originY + this.field_70181_x * proportion;
        this.field_70161_v = this.originZ + this.field_70179_y * proportion;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
    }
}
