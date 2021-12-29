// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityTFGhastTrapFX extends ben
{
    float reddustParticleScale;
    private double originX;
    private double originY;
    private double originZ;
    
    public EntityTFGhastTrapFX(final zv par1World, final double par2, final double par4, final double par6, final double par8, final double par9, final double par10) {
        this(par1World, par2, par4, par6, 3.0f, par8, par9, par10);
    }
    
    public EntityTFGhastTrapFX(final zv par1World, final double x, final double y, final double z, final float scale, final double mx, final double my, final double mz) {
        super(par1World, x + mx, y + my, z + mz, mx, my, mz);
        this.x = mx;
        this.y = my;
        this.z = mz;
        this.originX = x;
        this.originY = y;
        this.originZ = z;
        final float f4 = (float)Math.random() * 0.4f;
        this.au = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * f4;
        this.av = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * f4;
        this.j = 1.0f;
        this.h *= 0.75f;
        this.h *= scale;
        this.reddustParticleScale = this.h;
        this.g = (int)(10.0 / (Math.random() * 0.8 + 0.2));
        this.Z = false;
    }
    
    public void a(final bfx par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        float f6 = (this.f + par2) / this.g * 32.0f;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.h = this.reddustParticleScale * f6;
        super.a(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }
    
    public void l_() {
        this.i(7 - this.f * 8 / this.g);
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        float proportion = this.f / (float)this.g;
        proportion = 1.0f - proportion;
        this.u = this.originX + this.x * proportion;
        this.v = this.originY + this.y * proportion;
        this.w = this.originZ + this.z * proportion;
        if (this.f++ >= this.g) {
            this.w();
        }
    }
}
