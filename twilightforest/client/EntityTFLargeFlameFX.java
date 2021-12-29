// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityTFLargeFlameFX extends ben
{
    private float flameScale;
    
    public EntityTFLargeFlameFX(final zv par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12) {
        super(par1World, par2, par4, par6, par8, par10, par12);
        this.x = this.x * 0.009999999776482582 + par8;
        this.y = this.y * 0.009999999776482582 + par10;
        this.z = this.z * 0.009999999776482582 + par12;
        double var10000 = par2 + (this.ab.nextFloat() - this.ab.nextFloat()) * 0.05f;
        var10000 = par4 + (this.ab.nextFloat() - this.ab.nextFloat()) * 0.05f;
        var10000 = par6 + (this.ab.nextFloat() - this.ab.nextFloat()) * 0.05f;
        this.h *= 5.0;
        this.flameScale = this.h;
        final float j = 1.0f;
        this.av = j;
        this.au = j;
        this.j = j;
        this.g = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.i(48);
    }
    
    public void a(final bfx par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        final float var8 = (this.f + par2) / this.g;
        this.h = this.flameScale * (1.0f - var8 * var8 * 0.5f);
        super.a(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }
    
    public int b(final float par1) {
        float var2 = (this.f + par1) / this.g;
        if (var2 < 0.0f) {
            var2 = 0.0f;
        }
        if (var2 > 1.0f) {
            var2 = 1.0f;
        }
        final int var3 = super.b(par1);
        int var4 = var3 & 0xFF;
        final int var5 = var3 >> 16 & 0xFF;
        var4 += (int)(var2 * 15.0f * 16.0f);
        if (var4 > 240) {
            var4 = 240;
        }
        return var4 | var5 << 16;
    }
    
    public float c(final float par1) {
        float var2 = (this.f + par1) / this.g;
        if (var2 < 0.0f) {
            var2 = 0.0f;
        }
        if (var2 > 1.0f) {
            var2 = 1.0f;
        }
        final float var3 = super.c(par1);
        return var3 * var2 + (1.0f - var2);
    }
    
    public void l_() {
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        if (this.f++ >= this.g) {
            this.w();
        }
        this.y += 0.004;
        this.d(this.x, this.y, this.z);
        this.x *= 0.9599999785423279;
        this.y *= 0.9599999785423279;
        this.z *= 0.9599999785423279;
        if (this.F) {
            this.x *= 0.699999988079071;
            this.z *= 0.699999988079071;
        }
    }
}
