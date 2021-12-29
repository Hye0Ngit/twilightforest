// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityTFLargeFlameFX extends aze
{
    private float flameScale;
    
    public EntityTFLargeFlameFX(final xv par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12) {
        super(par1World, par2, par4, par6, par8, par10, par12);
        this.w = this.w * 0.009999999776482582 + par8;
        this.x = this.x * 0.009999999776482582 + par10;
        this.y = this.y * 0.009999999776482582 + par12;
        double var10000 = par2 + (this.aa.nextFloat() - this.aa.nextFloat()) * 0.05f;
        var10000 = par4 + (this.aa.nextFloat() - this.aa.nextFloat()) * 0.05f;
        var10000 = par6 + (this.aa.nextFloat() - this.aa.nextFloat()) * 0.05f;
        this.f *= 5.0;
        this.flameScale = this.f;
        final float h = 1.0f;
        this.j = h;
        this.i = h;
        this.h = h;
        this.e = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.a(48);
    }
    
    public void a(final bao par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        final float var8 = (this.d + par2) / this.e;
        this.f = this.flameScale * (1.0f - var8 * var8 * 0.5f);
        super.a(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }
    
    public int b(final float par1) {
        float var2 = (this.d + par1) / this.e;
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
        float var2 = (this.d + par1) / this.e;
        if (var2 < 0.0f) {
            var2 = 0.0f;
        }
        if (var2 > 1.0f) {
            var2 = 1.0f;
        }
        final float var3 = super.c(par1);
        return var3 * var2 + (1.0f - var2);
    }
    
    public void j_() {
        this.q = this.t;
        this.r = this.u;
        this.s = this.v;
        if (this.d++ >= this.e) {
            this.x();
        }
        this.x += 0.004;
        this.d(this.w, this.x, this.y);
        this.w *= 0.9599999785423279;
        this.x *= 0.9599999785423279;
        this.y *= 0.9599999785423279;
        if (this.E) {
            this.w *= 0.699999988079071;
            this.y *= 0.699999988079071;
        }
    }
}
