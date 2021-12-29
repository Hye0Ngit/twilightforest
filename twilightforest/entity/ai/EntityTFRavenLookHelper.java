// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

public class EntityTFRavenLookHelper extends pd
{
    private of a;
    private float field_46149_b;
    private float field_46150_c;
    private boolean field_46147_d;
    private double e;
    private double f;
    private double g;
    
    public EntityTFRavenLookHelper(final of par1EntityLiving) {
        super(par1EntityLiving);
        this.field_46147_d = false;
        this.a = par1EntityLiving;
    }
    
    public void a(final nm par1Entity, final float par2, final float par3) {
        this.e = par1Entity.u;
        if (par1Entity instanceof of) {
            this.f = par1Entity.v + ((of)par1Entity).f();
        }
        else {
            this.f = (par1Entity.E.b + par1Entity.E.e) / 2.0;
        }
        this.g = par1Entity.w;
        this.field_46149_b = par2;
        this.field_46150_c = par3;
        this.field_46147_d = true;
    }
    
    public void a(final double par1, final double par3, final double par5, final float par7, final float par8) {
        this.e = par1;
        this.f = par3;
        this.g = par5;
        this.field_46149_b = par7;
        this.field_46150_c = par8;
        this.field_46147_d = true;
    }
    
    public void a() {
        this.a.B = 0.0f;
        if (this.field_46147_d) {
            this.field_46147_d = false;
            final double var1 = this.e - this.a.u;
            final double var2 = this.f - (this.a.v + this.a.f());
            final double var3 = this.g - this.a.w;
            final double var4 = lr.a(var1 * var1 + var3 * var3);
            final float var5 = (float)(Math.atan2(var3, var1) * 180.0 / 3.141592653589793) - 30.0f;
            final float var6 = (float)(-(Math.atan2(var2, var4) * 180.0 / 3.141592653589793));
            this.a.B = this.a(this.a.B, var6, this.field_46150_c);
            this.a.aP = this.a(this.a.aP, var5, this.field_46149_b);
        }
        else {
            this.a.aP = this.a(this.a.aP, this.a.aN, 10.0f);
        }
        float var7;
        for (var7 = this.a.aP - this.a.aN; var7 < -180.0f; var7 += 360.0f) {}
        while (var7 >= 180.0f) {
            var7 -= 360.0f;
        }
        if (!this.a.k().g()) {
            if (var7 < -75.0f) {
                this.a.aP = this.a.aN - 75.0f;
            }
            if (var7 > 75.0f) {
                this.a.aP = this.a.aN + 75.0f;
            }
        }
    }
    
    private float a(final float par1, final float par2, final float par3) {
        float var4;
        for (var4 = par2 - par1; var4 < -180.0f; var4 += 360.0f) {}
        while (var4 >= 180.0f) {
            var4 -= 360.0f;
        }
        if (var4 > par3) {
            var4 = par3;
        }
        if (var4 < -par3) {
            var4 = -par3;
        }
        return par1 + var4;
    }
}
