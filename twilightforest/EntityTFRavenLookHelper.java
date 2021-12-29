// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFRavenLookHelper extends vz
{
    private acq entity;
    private float field_46149_b;
    private float field_46150_c;
    private boolean field_46147_d;
    private double posX;
    private double posY;
    private double posZ;
    
    public EntityTFRavenLookHelper(final acq par1EntityLiving) {
        super(par1EntityLiving);
        this.field_46147_d = false;
        this.entity = par1EntityLiving;
    }
    
    public void a(final nn par1Entity, final float par2, final float par3) {
        this.posX = par1Entity.o;
        if (par1Entity instanceof acq) {
            this.posY = par1Entity.p + ((acq)par1Entity).I();
        }
        else {
            this.posY = (par1Entity.y.b + par1Entity.y.e) / 2.0;
        }
        this.posZ = par1Entity.q;
        this.field_46149_b = par2;
        this.field_46150_c = par3;
        this.field_46147_d = true;
    }
    
    public void a(final double par1, final double par3, final double par5, final float par7, final float par8) {
        this.posX = par1;
        this.posY = par3;
        this.posZ = par5;
        this.field_46149_b = par7;
        this.field_46150_c = par8;
        this.field_46147_d = true;
    }
    
    public void a() {
        this.entity.v = 0.0f;
        if (this.field_46147_d) {
            this.field_46147_d = false;
            final double var1 = this.posX - this.entity.o;
            final double var2 = this.posY - (this.entity.p + this.entity.I());
            final double var3 = this.posZ - this.entity.q;
            final double var4 = gk.a(var1 * var1 + var3 * var3);
            final float var5 = (float)(Math.atan2(var3, var1) * 180.0 / 3.141592653589793) - 30.0f;
            final float var6 = (float)(-(Math.atan2(var2, var4) * 180.0 / 3.141592653589793));
            this.entity.v = this.updateRotation(this.entity.v, var6, this.field_46150_c);
            this.entity.bf = this.updateRotation(this.entity.bf, var5, this.field_46149_b);
        }
        else {
            this.entity.bf = this.updateRotation(this.entity.bf, this.entity.bd, 10.0f);
        }
        float var7;
        for (var7 = this.entity.bf - this.entity.bd; var7 < -180.0f; var7 += 360.0f) {}
        while (var7 >= 180.0f) {
            var7 -= 360.0f;
        }
        if (!this.entity.aM().e()) {
            if (var7 < -75.0f) {
                this.entity.bf = this.entity.bd - 75.0f;
            }
            if (var7 > 75.0f) {
                this.entity.bf = this.entity.bd + 75.0f;
            }
        }
    }
    
    private float updateRotation(final float par1, final float par2, final float par3) {
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
