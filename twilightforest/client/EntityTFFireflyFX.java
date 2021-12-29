// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;

public class EntityTFFireflyFX extends azq
{
    float fireflyParticleScale;
    int fireflyHalfLife;
    
    public EntityTFFireflyFX(final yc world, final double d, final double d1, final double d2, final float f, final float f1, final float f2) {
        this(world, d, d1, d2, 1.0f, f, f1, f2);
    }
    
    public EntityTFFireflyFX(final yc world, final double d, final double d1, final double d2, final float f, float f1, final float f2, final float f3) {
        super(world, d, d1, d2, 0.0, 0.0, 0.0);
        this.w *= 2.100000001490116;
        this.x *= 2.100000001490116;
        this.y *= 2.100000001490116;
        if (f1 == 0.0f) {
            f1 = 1.0f;
        }
        final float n = 1.0f * f;
        this.i = n;
        this.h = n;
        this.h *= 0.9f;
        this.j = 0.0f;
        this.f *= 1.0f;
        this.f *= f;
        this.fireflyParticleScale = this.f;
        this.e = (int)(32.0 / (Math.random() * 0.8 + 0.2));
        this.e *= (int)f;
        this.fireflyHalfLife = this.e / 2;
        this.Y = false;
    }
    
    public void a(final baz tessellator, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        float agescale = (this.d + f) / this.e * 32.0f;
        if (agescale < 0.0f) {
            agescale = 0.0f;
        }
        if (agescale > 1.0f) {
            agescale = 1.0f;
        }
        this.f = this.fireflyParticleScale * agescale;
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glColorMask(true, true, true, true);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
        final float f6 = this.h() % 16 / 16.0f;
        final float f7 = f6 + 0.0624375f;
        final float f8 = this.h() / 16 / 16.0f;
        final float f9 = f8 + 0.0624375f;
        final float f10 = 0.1f * this.f;
        final float f11 = (float)(this.q + (this.t - this.q) * f - EntityTFFireflyFX.au);
        final float f12 = (float)(this.r + (this.u - this.r) * f - EntityTFFireflyFX.av);
        final float f13 = (float)(this.s + (this.v - this.s) * f - EntityTFFireflyFX.aw);
        final float f14 = this.c(f);
        tessellator.a(this.h * f14, this.i * f14, this.j * f14, 0.2f);
        tessellator.a((double)(f11 - f1 * f10 - f4 * f10), (double)(f12 - f2 * f10), (double)(f13 - f3 * f10 - f5 * f10), (double)f7, (double)f9);
        tessellator.a((double)(f11 - f1 * f10 + f4 * f10), (double)(f12 + f2 * f10), (double)(f13 - f3 * f10 + f5 * f10), (double)f7, (double)f8);
        tessellator.a((double)(f11 + f1 * f10 + f4 * f10), (double)(f12 + f2 * f10), (double)(f13 + f3 * f10 + f5 * f10), (double)f6, (double)f8);
        tessellator.a((double)(f11 + f1 * f10 - f4 * f10), (double)(f12 - f2 * f10), (double)(f13 + f3 * f10 - f5 * f10), (double)f6, (double)f9);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
    }
    
    public void j_() {
        this.q = this.t;
        this.r = this.u;
        this.s = this.v;
        if (this.d++ >= this.e) {
            this.x();
        }
        if (this.d < this.fireflyHalfLife) {
            this.i(this.d * 8 / this.fireflyHalfLife);
        }
        else {
            this.i(7 - (this.d - this.fireflyHalfLife) * 8 / this.e);
        }
        this.d(this.w, this.x, this.y);
        if (this.u == this.r) {
            this.w *= 1.1;
            this.y *= 1.1;
        }
        this.w *= 0.9599999785423279;
        this.x *= 0.9599999785423279;
        this.y *= 0.9599999785423279;
        if (this.E) {
            this.w *= 0.699999988079071;
            this.y *= 0.699999988079071;
        }
    }
}
