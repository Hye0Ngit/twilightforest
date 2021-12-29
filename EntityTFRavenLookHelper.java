// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFRavenLookHelper extends eo
{
    private ne entity;
    private float field_46149_b;
    private float field_46150_c;
    private boolean field_46147_d;
    private double posX;
    private double posY;
    private double posZ;
    
    public EntityTFRavenLookHelper(final ne par1EntityLiving) {
        super(par1EntityLiving);
        this.field_46147_d = false;
        this.entity = par1EntityLiving;
    }
    
    public void a(final tv par1Entity, final float par2, final float par3) {
        this.posX = par1Entity.bm;
        if (par1Entity instanceof ne) {
            this.posY = par1Entity.bn + ((ne)par1Entity).B();
        }
        else {
            this.posY = (par1Entity.bw.b + par1Entity.bw.e) / 2.0;
        }
        this.posZ = par1Entity.bo;
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
        this.entity.bt = 0.0f;
        if (this.field_46147_d) {
            this.field_46147_d = false;
            final double var1 = this.posX - this.entity.bm;
            final double var2 = this.posY - (this.entity.bn + this.entity.B());
            final double var3 = this.posZ - this.entity.bo;
            final double var4 = kb.a(var1 * var1 + var3 * var3);
            final float var5 = (float)(Math.atan2(var3, var1) * 180.0 / 3.141592653589793) - 30.0f;
            final float var6 = (float)(-(Math.atan2(var2, var4) * 180.0 / 3.141592653589793));
            this.entity.bt = this.updateRotation(this.entity.bt, var6, this.field_46150_c);
            this.entity.X = this.updateRotation(this.entity.X, var5, this.field_46149_b);
        }
        else {
            this.entity.X = this.updateRotation(this.entity.X, this.entity.V, 10.0f);
        }
        float var7;
        for (var7 = this.entity.X - this.entity.V; var7 < -180.0f; var7 += 360.0f) {}
        while (var7 >= 180.0f) {
            var7 -= 360.0f;
        }
        if (!this.entity.al().e()) {
            if (var7 < -75.0f) {
                this.entity.X = this.entity.V - 75.0f;
            }
            if (var7 > 75.0f) {
                this.entity.X = this.entity.V + 75.0f;
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
