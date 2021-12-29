// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import org.lwjgl.opengl.GL11;

public class EntityTFFireflyFX extends rt
{
    float fireflyParticleScale;
    int fireflyHalfLife;
    
    public EntityTFFireflyFX(final xd world, final double d, final double d1, final double d2, final float f, final float f1, final float f2) {
        this(world, d, d1, d2, 1.0f, f, f1, f2);
    }
    
    public EntityTFFireflyFX(final xd world, final double d, final double d1, final double d2, final float f, float f1, final float f2, final float f3) {
        super(world, d, d1, d2, 0.0, 0.0, 0.0);
        this.r *= 2.100000001490116;
        this.s *= 2.100000001490116;
        this.t *= 2.100000001490116;
        if (f1 == 0.0f) {
            f1 = 1.0f;
        }
        final float n = 1.0f * f;
        this.ap = n;
        this.ao = n;
        this.ao *= 0.9f;
        this.aq = 0.0f;
        this.am *= 1.0f;
        this.am *= f;
        this.fireflyParticleScale = this.am;
        this.e = (int)(32.0 / (Math.random() * 0.8 + 0.2));
        this.e *= (int)f;
        this.fireflyHalfLife = this.e / 2;
        this.S = false;
    }
    
    public void a(final adz tessellator, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        float agescale = (this.d + f) / this.e * 32.0f;
        if (agescale < 0.0f) {
            agescale = 0.0f;
        }
        if (agescale > 1.0f) {
            agescale = 1.0f;
        }
        this.am = this.fireflyParticleScale * agescale;
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glColorMask(true, true, true, true);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
        final float f6 = this.s() % 16 / 16.0f;
        final float f7 = f6 + 0.0624375f;
        final float f8 = this.s() / 16 / 16.0f;
        final float f9 = f8 + 0.0624375f;
        final float f10 = 0.1f * this.am;
        final float f11 = (float)(this.l + (this.o - this.l) * f - EntityTFFireflyFX.ar);
        final float f12 = (float)(this.m + (this.p - this.m) * f - EntityTFFireflyFX.as);
        final float f13 = (float)(this.n + (this.q - this.n) * f - EntityTFFireflyFX.at);
        final float f14 = this.a(f);
        tessellator.a(this.ao * f14, this.ap * f14, this.aq * f14, 0.2f);
        tessellator.a((double)(f11 - f1 * f10 - f4 * f10), (double)(f12 - f2 * f10), (double)(f13 - f3 * f10 - f5 * f10), (double)f7, (double)f9);
        tessellator.a((double)(f11 - f1 * f10 + f4 * f10), (double)(f12 + f2 * f10), (double)(f13 - f3 * f10 + f5 * f10), (double)f7, (double)f8);
        tessellator.a((double)(f11 + f1 * f10 + f4 * f10), (double)(f12 + f2 * f10), (double)(f13 + f3 * f10 + f5 * f10), (double)f6, (double)f8);
        tessellator.a((double)(f11 + f1 * f10 - f4 * f10), (double)(f12 - f2 * f10), (double)(f13 + f3 * f10 - f5 * f10), (double)f6, (double)f9);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
    }
    
    public void J_() {
        this.l = this.o;
        this.m = this.p;
        this.n = this.q;
        if (this.d++ >= this.e) {
            this.A();
        }
        if (this.d < this.fireflyHalfLife) {
            this.c(this.d * 8 / this.fireflyHalfLife);
        }
        else {
            this.c(7 - (this.d - this.fireflyHalfLife) * 8 / this.e);
        }
        this.b(this.r, this.s, this.t);
        if (this.p == this.m) {
            this.r *= 1.1;
            this.t *= 1.1;
        }
        this.r *= 0.9599999785423279;
        this.s *= 0.9599999785423279;
        this.t *= 0.9599999785423279;
        if (this.z) {
            this.r *= 0.699999988079071;
            this.t *= 0.699999988079071;
        }
    }
}
