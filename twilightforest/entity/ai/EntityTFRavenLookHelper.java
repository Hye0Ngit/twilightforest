// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityLookHelper;

public class EntityTFRavenLookHelper extends EntityLookHelper
{
    private EntityLiving field_75659_a;
    private float field_46149_b;
    private float field_46150_c;
    private boolean field_46147_d;
    private double field_75656_e;
    private double field_75653_f;
    private double field_75654_g;
    
    public EntityTFRavenLookHelper(final EntityLiving par1EntityLiving) {
        super(par1EntityLiving);
        this.field_46147_d = false;
        this.field_75659_a = par1EntityLiving;
    }
    
    public void func_75651_a(final Entity par1Entity, final float par2, final float par3) {
        this.field_75656_e = par1Entity.field_70165_t;
        if (par1Entity instanceof EntityLiving) {
            this.field_75653_f = par1Entity.field_70163_u + ((EntityLiving)par1Entity).func_70047_e();
        }
        else {
            this.field_75653_f = (par1Entity.field_70121_D.field_72338_b + par1Entity.field_70121_D.field_72337_e) / 2.0;
        }
        this.field_75654_g = par1Entity.field_70161_v;
        this.field_46149_b = par2;
        this.field_46150_c = par3;
        this.field_46147_d = true;
    }
    
    public void func_75650_a(final double par1, final double par3, final double par5, final float par7, final float par8) {
        this.field_75656_e = par1;
        this.field_75653_f = par3;
        this.field_75654_g = par5;
        this.field_46149_b = par7;
        this.field_46150_c = par8;
        this.field_46147_d = true;
    }
    
    public void func_75649_a() {
        this.field_75659_a.field_70125_A = 0.0f;
        if (this.field_46147_d) {
            this.field_46147_d = false;
            final double var1 = this.field_75656_e - this.field_75659_a.field_70165_t;
            final double var2 = this.field_75653_f - (this.field_75659_a.field_70163_u + this.field_75659_a.func_70047_e());
            final double var3 = this.field_75654_g - this.field_75659_a.field_70161_v;
            final double var4 = MathHelper.func_76133_a(var1 * var1 + var3 * var3);
            final float var5 = (float)(Math.atan2(var3, var1) * 180.0 / 3.141592653589793) - 30.0f;
            final float var6 = (float)(-(Math.atan2(var2, var4) * 180.0 / 3.141592653589793));
            this.field_75659_a.field_70125_A = this.func_75652_a(this.field_75659_a.field_70125_A, var6, this.field_46150_c);
            this.field_75659_a.field_70759_as = this.func_75652_a(this.field_75659_a.field_70759_as, var5, this.field_46149_b);
        }
        else {
            this.field_75659_a.field_70759_as = this.func_75652_a(this.field_75659_a.field_70759_as, this.field_75659_a.field_70761_aq, 10.0f);
        }
        float var7;
        for (var7 = this.field_75659_a.field_70759_as - this.field_75659_a.field_70761_aq; var7 < -180.0f; var7 += 360.0f) {}
        while (var7 >= 180.0f) {
            var7 -= 360.0f;
        }
        if (!this.field_75659_a.func_70661_as().func_75500_f()) {
            if (var7 < -75.0f) {
                this.field_75659_a.field_70759_as = this.field_75659_a.field_70761_aq - 75.0f;
            }
            if (var7 > 75.0f) {
                this.field_75659_a.field_70759_as = this.field_75659_a.field_70761_aq + 75.0f;
            }
        }
    }
    
    private float func_75652_a(final float par1, final float par2, final float par3) {
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
