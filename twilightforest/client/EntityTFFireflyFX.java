// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;

public class EntityTFFireflyFX extends ben
{
    float fireflyParticleScale;
    int fireflyHalfLife;
    
    public EntityTFFireflyFX(final zv world, final double d, final double d1, final double d2, final float f, final float f1, final float f2) {
        this(world, d, d1, d2, 1.0f, f, f1, f2);
    }
    
    public EntityTFFireflyFX(final zv world, final double d, final double d1, final double d2, final float f, float f1, final float f2, final float f3) {
        super(world, d, d1, d2, 0.0, 0.0, 0.0);
        this.x *= 2.100000001490116;
        this.y *= 2.100000001490116;
        this.z *= 2.100000001490116;
        if (f1 == 0.0f) {
            f1 = 1.0f;
        }
        final float n = 1.0f * f;
        this.au = n;
        this.j = n;
        this.j *= 0.9f;
        this.av = 0.0f;
        this.h *= 1.0f;
        this.h *= f;
        this.fireflyParticleScale = this.h;
        this.g = (int)(32.0 / (Math.random() * 0.8 + 0.2));
        this.g *= (int)f;
        this.fireflyHalfLife = this.g / 2;
        this.Z = false;
    }
    
    public void a(final bfx par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        float f6 = this.b / 16.0f;
        float f7 = f6 + 0.0624375f;
        float f8 = this.c / 16.0f;
        float f9 = f8 + 0.0624375f;
        final float f10 = 0.1f * this.h;
        this.h = this.fireflyParticleScale;
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glColorMask(true, true, true, true);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
        if (this.ax != null) {
            f6 = this.ax.e();
            f7 = this.ax.f();
            f8 = this.ax.g();
            f9 = this.ax.h();
        }
        final float f11 = (float)(this.r + (this.u - this.r) * par2 - EntityTFFireflyFX.ay);
        final float f12 = (float)(this.s + (this.v - this.s) * par2 - EntityTFFireflyFX.az);
        final float f13 = (float)(this.t + (this.w - this.t) * par2 - EntityTFFireflyFX.aA);
        final float f14 = 1.0f;
        par1Tessellator.a(this.j * f14, this.au * f14, this.av * f14, this.aw);
        par1Tessellator.a((double)(f11 - par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 - par5 * f10 - par7 * f10), (double)f7, (double)f9);
        par1Tessellator.a((double)(f11 - par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 - par5 * f10 + par7 * f10), (double)f7, (double)f8);
        par1Tessellator.a((double)(f11 + par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 + par5 * f10 + par7 * f10), (double)f6, (double)f8);
        par1Tessellator.a((double)(f11 + par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 + par5 * f10 - par7 * f10), (double)f6, (double)f9);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
    }
    
    public void l_() {
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        if (this.f++ >= this.g) {
            this.w();
        }
        if (this.f < this.fireflyHalfLife) {
            this.i(this.f * 8 / this.fireflyHalfLife);
        }
        else {
            this.i(7 - (this.f - this.fireflyHalfLife) * 8 / this.g);
        }
        this.d(this.x, this.y, this.z);
        if (this.v == this.s) {
            this.x *= 1.1;
            this.z *= 1.1;
        }
        this.x *= 0.9599999785423279;
        this.y *= 0.9599999785423279;
        this.z *= 0.9599999785423279;
        if (this.F) {
            this.x *= 0.699999988079071;
            this.z *= 0.699999988079071;
        }
    }
}
